from flask import Flask, jsonify
import time
import json
from FlightRadar24.api import FlightRadar24API  # Asegúrate de importar adecuadamente tu módulo FlightRadar24
import logging

app = Flask(__name__)

logging.basicConfig(filename='api_service.log', level=logging.DEBUG)

# Datos iniciales
datos_json = {}

@app.route('/obtener_json', methods=['GET'])
def obtener_json():
    return jsonify(datos_json)

def actualizar_datos_json():
    global datos_json
    fr_api = FlightRadar24API()
    
    # Lógica para obtener datos actualizados
    key_flights = fr_api.get_flights(
        registration="HA-LGD"
    )

    if key_flights:
        detalles_vuelo = fr_api.get_flight_details(key_flights[0])
        datos_json = detalles_vuelo.get("time")
        detalles_vuelo.get("time")["real"]["departure"]


if __name__ == '__main__':
    while True:
        actualizar_datos_json()
        time.sleep(3)
        app.run(debug=True, port=5000, use_reloader=False)
