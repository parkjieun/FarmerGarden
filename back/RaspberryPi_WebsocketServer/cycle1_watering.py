import datetime
import time
import RPi.GPIO as GPIO
import sys
import pymysql
import Adafruit_DHT as dht


import subprocess


class Database():
    def __init__(self):
        self.db = pymysql.connect(host='3.35.131.33',
                                  user='root',
                                  password='ssafy',
                                  db='ssafy_iot',
                                  charset='utf8')
        self.cursor = self.db.cursor(pymysql.cursors.DictCursor)

    def execute(self, query, args={}):
        self.cursor.execute(query, args)

    def executeOne(self, query, args={}):
        self.cursor.execute(query, args)
        row = self.cursor.fetchone()
        return row

    def executeAll(self, query, args={}):
        self.cursor.execute(query, args)
        row = self.cursor.fetchall()
        return row

    def commit(self):
        self.db.commit()


print("Water Moter will be started")
choice_id = str(sys.argv[1])
print("Received choice_id", choice_id)

# Take user, plant ID
db_class = Database()
sql = "select pc.user_id as u, pc.plant_id p \
                from plant_choice as pc \
                where pc.choice_id =" + choice_id
row = db_class.executeAll(sql)
user_id = str(row[0]['u'])
plant_id = str(row[0]['p'])

# Take Later Time
now = datetime.datetime.now()
sql = "select plant_steep_hour + plant_gemmation_hour as h from plant \
        where plant_id = " + plant_id
row = db_class.executeAll(sql)


laterTime = now + datetime.timedelta(hours=row[0]['h'])
print("result is", laterTime)

breakFlag = False
ledOnFlag = False
# Watering Function
def watering(t):
    print("Water Pump On")

    GPIO.setmode(GPIO.BCM)
    GPIO.setup(23, GPIO.OUT)

    time.sleep(10)

    print("ON")
    GPIO.output(23, True)

    time.sleep(t)
    print("OFF")
    GPIO.output(23, False)

    GPIO.cleanup()

    sql = "insert into watering_log (choice_id,  user_id, plant_id) \
           values (%s, \'%s\', %s)" % (choice_id, user_id, plant_id)
    db_class.execute(sql)
    db_class.commit()

while True:
    now = datetime.datetime.now()

    if breakFlag == True:
        break
    elif now > laterTime:
        # Cycle2 Start
        if ledOnFlag == False:
            ledOnFlag = True
            GPIO.setmode(GPIO.BCM)
            GPIO.setup(14, GPIO.OUT)
            print("LED ON")
            GPIO.output(14, True)
        while True:
            sql = "select calendar_stop_day as c from calendar \
                where choice_id = " + choice_id
            row = db_class.executeAll(sql)
            print("******STOP day is", row[0]['c'])
            if row[0]['c'] is None:
                print("Still growing in Cycle2")

                # Watering
                watering(t=30)
                # Cycle2 time 6 Hours

                for i in range(1, 7):
                    # Take Picture
                    img = subprocess.check_output('sh ./cycle2_imageTransfer.sh', shell=True)
                    img = str(img)
                    imgName = img.split("/")[4].split(".")
                    print("imgNmae is")
                    print(imgName[0])

                    # DB input
                    hum, temp = dht.read_retry(dht.DHT11, 4)

                    sql = "INSERT INTO raspberry(rb_temperature, rb_humidity, choice_id, user_id, plant_id, rb_img ) \
                                           VALUES(%s, %s, %s, \'%s\', %s, \'%s\')" % (
                    temp, hum, choice_id, user_id, plant_id, str(imgName[0]))
                    db_class.execute(sql)
                    db_class.commit()

                    sql = "select calendar_stop_day as c from calendar \
                                    where choice_id = " + choice_id
                    row = db_class.executeAll(sql)
                    print("******STOP day is", row[0]['c'])

                    if row[0]['c'] is None:
                        time.sleep(3600)
                    else:
                        breakFlag = True
                        break



            else:
                # STOP
                breakFlag = True
                break


    else:
        # Cycle1 Start
        print("Still growing in Cycle1")
        watering(t=10)

        # Take Picture
        img = subprocess.check_output('sh ./cycle1_imageTransfer.sh', shell=True)
        img = str(img)
        imgName = img.split("/")[4].split(".")
        print("imgNmae is")
        print(imgName[0])

        # DB input
        hum, temp = dht.read_retry(dht.DHT11, 4)

        sql = "INSERT INTO raspberry(rb_temperature, rb_humidity, choice_id, user_id, plant_id, rb_img ) \
                        VALUES(%s, %s, %s, \'%s\', %s, \'%s\')" % (temp, hum, choice_id, user_id, plant_id, str(imgName[0]))
        db_class.execute(sql)
        db_class.commit()

        # Cycle time 30Min
        time.sleep(1800)



