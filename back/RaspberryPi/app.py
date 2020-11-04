# file name : test.py
# pwd : /project_name/app/test/test.py
import datetime
import os
from flask import Flask, Blueprint, send_file, request, render_template, flash, redirect, url_for

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

    print("/recent-imgs의 결과", row)

    path_dir = './static/data/img/'
    file_list = os.listdir(path_dir)  # path 에 존재하는 파일 목록 가져오기
    result = path_dir+file_list[0]
    return result[1:]

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

    print("/supply-water-logs의 결과", row)
    return row

@app.route('/temp-and-hum', methods = ['GET'])
def tempAndHum():
    choice_id = request.args.get('choice_id') #작물선택 기본키

    # 가장 최근 급수 시간 출력

    db_class = dbModule.Database()

    sql = "select r.rb_temperature, r.rb_humidity, r.rb_create from raspberry as r \
            join plant_choice p \
            on " + choice_id + " = r.choice_id \
            where p.grow_flag = 1 \
            order by r.rb_create"
    row = db_class.executeAll(sql)

    result = row.to_json(orient='result', force_ascii=False)

    print("/temp-and-hum의 결과", result)
    return result

if __name__ == '__main__':
    app.run()