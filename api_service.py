from flask import Flask, jsonify
import threading
import time
import json
from FlightRadar24.api import FlightRadar24API  # Asegúrate de importar adecuadamente tu módulo FlightRadar24
import logging

app = Flask(__name__)

logging.basicConfig(filename='api_service.log', level=logging.DEBUG)

# Datos iniciales
datos_json = {}
lock = threading.Lock()

@app.route('/obtener_json', methods=['GET'])
def obtener_json():
    with lock:
        return jsonify(datos_json)

def actualizar_datos_json():
    global datos_json
    fr_api = FlightRadar24API()

    while True:
        # Lógica para obtener datos actualizados
        key_flights = fr_api.get_flights(
            registration="EC-MPI"
        )

        if key_flights:
            detalles_vuelo = fr_api.get_flight_details(key_flights[0])
            print(key_flights[0])
            with lock:
                datos_json = detalles_vuelo.get("time")
        
        time.sleep(3)

if __name__ == '__main__':
    hilo_flask = threading.Thread(target=app.run, kwargs={'debug': True, 'port': 5000, 'use_reloader': False})
    hilo_flask.start()

    hilo_datos = threading.Thread(target=actualizar_datos_json)
    hilo_datos.start()