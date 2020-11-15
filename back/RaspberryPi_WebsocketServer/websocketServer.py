######server######
import asyncio
import websockets
import RPi.GPIO as GPIO
import time
import subprocess
import pymysql
import Adafruit_DHT as dht


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

    # call back for websockets.serve(accept,


async def accept(websocket, path):
    while True:

        # plant led setup
        GPIO.setmode(GPIO.BCM)
        GPIO.setup(14, GPIO.OUT)

        data_rcv = await websocket.recv()  # receiving the data from client.
        action = data_rcv.split(",")[0]
        choice_id = data_rcv.split(",")[1]
        print("received data = " + data_rcv)
        if action == "ledon":
            print("LED ON")
            GPIO.output(14, True)
        elif action == "ledoff":
            print("LED OFF")
            GPIO.output(14, False)
            GPIO.cleanup()
        elif action == "water":
            print("Water Pump On")
            GPIO.setmode(GPIO.BCM)
            GPIO.setup(23, GPIO.OUT)

            time.sleep(10)

            print("ON")
            GPIO.output(23, True)

            time.sleep(10)
            print("OFF")
            GPIO.output(23, False)

            GPIO.cleanup()
        elif action == "camera":
            img = subprocess.check_output('sh ./cycle2_imageTransfer.sh', shell=True)
            img = str(img)
            imgName = img.split("/")[4].split(".")
            print("imgNmae is")
            print(imgName[0])

            # DB input
            db_class = Database()
            sql = "select pc.user_id as u, pc.plant_id p \
                                from plant_choice as pc \
                                where pc.choice_id =" + choice_id
            row = db_class.executeAll(sql)
            user_id = str(row[0]['u'])
            plant_id = str(row[0]['p'])

            hum, temp = dht.read_retry(dht.DHT11, 4)

            sql = "INSERT INTO raspberry(rb_temperature, rb_humidity, choice_id, user_id, plant_id, rb_img ) \
                                                           VALUES(%s, %s, %s, \'%s\', %s, \'%s\')" % (
                temp, hum, choice_id, user_id, plant_id, str(imgName[0]))
            db_class.execute(sql)
            db_class.commit()



        elif action == "start":
            print("Growing START")
            print("choice_id", choice_id)

            subprocess.call('python3 cycle1_watering.py ' + choice_id + "&", shell=True)



        elif action == "stop":
            print("All Cycle will be stopped")
            # pupm setup
            GPIO.setmode(GPIO.BCM)
            GPIO.setup(23, GPIO.OUT)

            GPIO.output(14, False)  # led off
            GPIO.output(23, False)  # pump off
            GPIO.cleanup()

            subprocess.call('sudo pkill -9 -f cycle1_watering.py', shell=True)
            subprocess.call('python3 rp_led_green.py &', shell=True)
            print("choice_id", choice_id)
        await websocket.send("server data~ = " + data_rcv)  # send received data


# websocket server creation
websoc_svr = websockets.serve(accept, "192.168.219.110", 3000)

# waiting
asyncio.get_event_loop().run_until_complete(websoc_svr)
asyncio.get_event_loop().run_forever()




