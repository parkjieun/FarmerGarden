# file name : test.py
# pwd : /project_name/app/test/test.py
import asyncio
import websockets
from werkzeug.utils import secure_filename
import datetime
import os
import json,datetime
from flask import Flask, Blueprint, send_file, request, render_template, flash, redirect, url_for

from flask_cors import CORS
from module import dbModule

app = Flask(__name__)
app.config['JSON_AS_ASCII'] = False
CORS(app)




@app.route('/', methods=['GET'])
def index():
    return render_template('test.html')

@app.route('/test', methods=['GET'])
def test():
    return "testpage"

@app.route('/imgUpload', methods = ['GET', 'POST'])
def upload_file():
    if request.method == 'POST':
        print("이미지 업로드 시작해요")
        f = request.files['file']
        fname = secure_filename(f.filename)
        path = os.path.join(app.config['UPLOAD_DIR'], fname)
        f.save(path)
        return 'Img upload complete (%s)' % path

    return "img upload FAIL"

@app.route('/iot-actions', methods=['GET'])
def iotActions():
    action = request.args.get('action')  # 사용자 액션
    # led => on/off
    # waterpump
    # picture

    async def my_connect():
        async with websockets.connect("ws://115.143.115.9:443") as websocket:
            await websocket.send(action)
            data_rcv = await websocket.recv()
            print("data received from server : " + data_rcv)

    # connect to server
    asyncio.get_event_loop().run_until_complete(my_connect())

    return action


@app.route('/recent-imgs', methods = ['GET'])
def recentImgs():
    choice_id = request.args.get('choice_id')  # 작물선택 기본키
    # 가장 최근에 찍힌 사진 10개만 리턴

    db_class = dbModule.Database()

    sql = "select r.rb_img from raspberry as r \
            join plant_choice p \
            on " + choice_id + " = r.choice_id \
            where p.grow_flag = 1 \
            order by r.rb_create desc \
            limit 10"
    row = db_class.executeAll(sql)

    for data in row:
        print(data['rb_img'])

    print("/recent-imgs의 결과", row)

    path_dir = './static/data/img/'
    file_list = os.listdir(path_dir)  # path 에 존재하는 파일 목록 가져오기

    i = 0
    result = []

    for data in row:
        imgname = data['rb_img']
        for filename in file_list:
            if imgname in filename:
                data['rb_img'] = (path_dir[1:]+imgname)
            else:
                data['rb_img'] = (path_dir[1:]+"error.jpg")
                break

    return json.dumps(row)

@app.route('/supply-water-logs', methods = ['GET'])
def supplyWaterLogs():
    choice_id = request.args.get('choice_id') #작물선택 기본키

    # 가장 최근 급수 시간 출력

    db_class = dbModule.Database()

    sql = "select w.watering_time from watering_log as w \
            join plant_choice p \
            on " + choice_id + " = w.choice_id \
            where p.grow_flag = 1 \
            order by w.watering_time desc \
            limit 1"
    row = db_class.executeAll(sql)

    t = row[0]["watering_time"]
    row[0]["watering_time"] = t.strftime('%Y-%m-%d %H:%M:%S')

    print("/supply-water-logs의 결과", row)
    return row[0]

@app.route('/temp-and-hum', methods = ['GET'])
def tempAndHum():
    choice_id = request.args.get('choice_id') #작물선택 기본키

    # 온/습도/시간 반환

    db_class = dbModule.Database()

    sql = "select r.rb_temperature, r.rb_humidity, r.rb_create from raspberry as r \
            join plant_choice p \
            on " + choice_id + " = r.choice_id \
            where p.grow_flag = 1 \
            order by r.rb_create"
    row = db_class.executeAll(sql)


    for datas in row:
        t = datas["rb_create"]
        datas["rb_create"] = t.strftime('%Y-%m-%d %H:%M:%S')
    print("결과", row)
    result = json.dumps(row, indent=3)
    return result

@app.route('/recent-temp', methods = ['GET'])
def recentTemp():
    choice_id = request.args.get('choice_id') #작물선택 기본키

    # 가장 최근 기록된 온도 반환

    db_class = dbModule.Database()

    sql = "select r.rb_temperature from raspberry as r \
            join plant_choice p \
            on " + choice_id + " = r.choice_id \
            where p.grow_flag = 1 \
            order by r.rb_create limit 1"
    row = db_class.executeAll(sql)

    print("/recent-temp 결과", row)
    return row[0]

@app.route('/recent-hum', methods = ['GET'])
def recentHum():
    choice_id = request.args.get('choice_id') #작물선택 기본키

    # 가장 최근 기록된 습도 반환

    db_class = dbModule.Database()

    sql = "select r.rb_humidity from raspberry as r \
            join plant_choice p \
            on " + choice_id + " = r.choice_id \
            where p.grow_flag = 1 \
            order by r.rb_create limit 1"
    row = db_class.executeAll(sql)

    print("/recent-hum 결과", row)
    return row[0]

if __name__ == '__main__':
    app.run()