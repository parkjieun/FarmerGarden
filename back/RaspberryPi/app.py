# file name : websocketServer.py
# pwd : /project_name/app/test/websocketServer.py
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
    return "This is IOT REST-Api Server Default Page"

@app.route('/test', methods=['GET'])
def test():
    return "testpage"

@app.route('/iot-actions', methods=['GET'])
def iotActions():
    action = request.args.get('action')  # 사용자 액션
    choice_id = request.args.get('choice_id')  # 작물선택 기본키

    sendSTR = action +","+choice_id
    print("iot ~~~")
    async def my_connect():
        print("websocket connect")
        async with websockets.connect("ws://192.168.219.110:3000") as websocket:
        #async with websockets.connect("ws://115.143.115.9:3000") as websocket:
            print("before send")
            await websocket.send(sendSTR)
            data_rcv = await websocket.recv()
            print("data received from server : " + data_rcv)

    # connect to server
    loop = asyncio.new_event_loop()
    loop.run_until_complete(my_connect())
    loop.close()
    
    return action

@app.route('/day-imgs', methods = ['GET'])
def dayImgs():
    choice_id = request.args.get('choice_id')  # 작물선택 기본키
    day =  request.args.get('day')
    # 가장 최근에 찍힌 사진 10개만 리턴
    print("날짜", day)
    db_class = dbModule.Database()

    sql = '''select r.rb_img from raspberry as r \
            join plant_choice p \
            on ''' + choice_id + ''' = r.choice_id \
            where p.grow_flag = 1 \
            and r.rb_img LIKE '%%%%%s%%%%' \
            order by r.rb_create desc''' % (day)

    print(sql)
    row = db_class.executeAll(sql)

    for data in row:
        data['rb_img'] = "/static/data/img/" + data['rb_img'] + ".jpg"
        print(data['rb_img'])

    print("/day-imgs의 결과", row)
    return json.dumps(row)

@app.route('/recent-imgs', methods = ['GET'])
def recentImgs():
    choice_id = request.args.get('choice_id')  # 작물선택 기본키
    # 가장 최근에 찍힌 사진 10개만 리턴

    db_class = dbModule.Database()

    sql = "select r.rb_img from raspberry as r \
            join plant_choice p \
            on   p.choice_id   = r.choice_id \
            where p.grow_flag = 1 and r.choice_id =" + choice_id + "\
            order by r.rb_create desc \
            limit 10"
    row = db_class.executeAll(sql)
    print("결과", row)

    for data in row:
        print("바꾸기 전", data['rb_img'])
        data['rb_img'] = "/static/data/img/" + data['rb_img'] + ".jpg"
        print(data['rb_img'])

    print("/recent-imgs의 결과", row)



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

@app.route('/pictured-img', methods = ['GET'])
def picturedImg():
    choice_id = request.args.get('choice_id') #작물선택 기본키

    # 방금 사진찍혔을때 이미지

    db_class = dbModule.Database()

    sql = "select r.rb_img from raspberry as r \
            join plant_choice p \
            on p.choice_id = r.choice_id  \
            where p.choice_id = " + choice_id + " \
            order by r.rb_create desc\
            limit 1"
    row = db_class.executeAll(sql)

    print("/pictured-img 결과", row)
    row[0]['rb_img'] = "/static/data/img/" + row[0]['rb_img'] + ".jpg"
    return row[0]

if __name__ == '__main__':
    app.run()