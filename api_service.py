from flask import Flask, jsonify
import threading
import time
import json
from FlightRadar24.api import FlightRadar24API  # Asegúrate de importar adecuadamente tu módulo FlightRadar24
import logging
import sys
# url: http://127.0.0.1:<port_number>/<function_name>
#http://127.0.0.1:5000/obtener_json

app = Flask(__name__)

logging.basicConfig(filename='api_service.log', level=logging.DEBUG)

# Datos iniciales
datos_json = {}
lock = threading.Lock()

ruta_personalizada = None

if len(sys.argv) > 1:
    matricula = sys.argv[1]
    ruta_personalizada = "/tracking_airplane_" + matricula  # Toma el primer argumento de la línea de comandos
    print(ruta_personalizada)
else:
    print("ERROR: Debes proporcionar una matricula para el seguimiento del vuelo.")
    sys.exit(1)  # Salir con código de error 1

@app.route(ruta_personalizada, methods=['GET'])
def obtener_json():
    with lock:
        return jsonify(datos_json)

def actualizar_datos_json():
    global datos_json
    fr_api = FlightRadar24API()

    while True:
        # Lógica para obtener datos actualizados
        key_flights = fr_api.get_flights(
            registration = matricula
        )

        if key_flights:
            flight_selected = fr_api.get_flight_details(key_flights[0])
            #print(flight_selected.get("time")["real"]["arrival"],end="\t")
            print(key_flights[0])
            with lock:
                datos_json = flight_selected.get("time")
        
        time.sleep(10)

if __name__ == '__main__':
    hilo_flask = threading.Thread(target=app.run, kwargs={'debug': True, 'port': 5000, 'use_reloader': False})
    hilo_flask.start()

    hilo_datos = threading.Thread(target=actualizar_datos_json)
    hilo_datos.start()