# file name : test.py
# pwd : /project_name/app/test/test.py
import datetime
from flask import Flask, Blueprint, request, render_template, flash, redirect, url_for

from flask_cors import CORS
from module import dbModule

app = Flask(__name__)
app.config['JSON_AS_ASCII'] = False
CORS(app)




@app.route('/', methods=['GET'])
def index():
    return render_template('test.html',
                           result=None,
                           resultData=None,
                           resultUPDATE=None)


# INSERT 함수 예제
@app.route('/insert', methods=['GET'])
def insert():
    db_class = dbModule.Database()

    #today time
    now = datetime.datetime.now()
    nowDate = now.strftime('%Y-%m-%d')
    nowDatetime = now.strftime('%Y-%m-%d %H:%M:%S')

    # INSERT INTO raspberry(rb_id, rb_temperature, rb_humidity, rb_shoot_day, user_id, plant_id, rb_img, rb_create )
    # VALUES(1, 23, 50,"2020-10-20", 1, 1, "임시 이미지", "2020-10-20");
    sql = "INSERT INTO raspberry(rb_temperature, rb_humidity, rb_shoot_day, user_id, plant_id, rb_img, rb_create ) \
                VALUES(23, 50, '%s', 1, 1, '임시 이미지', '%s')" % (nowDate, nowDatetime)
    db_class.execute(sql)
    db_class.commit()

    return render_template('test.html',
                           result='insert is done!',
                           resultData=None,
                           resultUPDATE=None)


# SELECT 함수 예제
@app.route('/select', methods=['GET'])
def select():
    db_class = dbModule.Database()

    sql = "SELECT * \
                FROM raspberry"
    row = db_class.executeAll(sql)

    print(row)
    print(row[0])
    return render_template('test.html',
                           result=None,
                           resultData=row[0],
                           resultUPDATE=None)


# UPDATE 함수 예제
@app.route('/update', methods=['GET'])
def update():
    db_class = dbModule.Database()

    sql = "UPDATE raspberry \
                SET rb_img='%s' \
                WHERE rb_id=1" % ('임시이미지_변경')
    db_class.execute(sql)
    db_class.commit()

    sql = "SELECT * \
                    FROM raspberry"
    row = db_class.executeAll(sql)

    return render_template('test.html',
                           result=None,
                           resultData=None,
                           resultUPDATE=row[0])

if __name__ == '__main__':
    app.run()