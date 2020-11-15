######server######
import asyncio
import websockets
import RPi.GPIO as GPIO
import time
import subprocess


    # call back for websockets.serve(accept,
async def accept(websocket, path):
        while True:

            #plant led setup
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
                subprocess.call('sh ../imageTransfer.sh', shell=True)

            elif action == "start":
                print("Growing START")
                print("choice_id", choice_id)

                subprocess.call('python3 cycle1_watering.py ' + choice_id + "&" , shell=True)


            elif action == "stop":
                print("All Cycle will be stopped")
                #pupm setup
                GPIO.setmode(GPIO.BCM)
                GPIO.setup(23, GPIO.OUT)

                GPIO.output(14, False) # led off
                GPIO.output(23, False) # pump off
                GPIO.cleanup()

                subprocess.call('sudo pkill -9 -f cycle1_watering.py', shell=True)
                print("choice_id", choice_id)
            await websocket.send("server data~ = " + data_rcv)  # send received data

    # websocket server creation
websoc_svr = websockets.serve(accept, "192.168.219.110", 3000)

    # waiting
asyncio.get_event_loop().run_until_complete(websoc_svr)
asyncio.get_event_loop().run_forever()

