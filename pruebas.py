from FlightRadar24 import FlightRadar24API
import json
from FlightRadar24 import Airport
from FlightRadar24 import Flight
import time
import cairosvg
from io import BytesIO
from PIL import Image
from flask import Flask, jsonify


# app = Flask(__name__)

# # Datos iniciales
# datos_json = {'clave': 'valor', 'otra_clave': 'otro_valor'}

# @app.route('/obtener_json', methods=['GET'])
# def obtener_json():
#     return jsonify(datos_json)

# def actualizar_datos_json():
#     global datos_json
#     # Aquí puedes realizar cualquier lógica para actualizar los datos_json
#     # Por ejemplo, puedes obtener datos de una API externa, base de datos, etc.

# # Bucle infinito con temporizador para actualizar los datos_json cada 60 segundos
# if __name__ == '__main__':
#     while True:
#         actualizar_datos_json()
#         time.sleep(3)  # Espera 60 segundos antes de la próxima actualización
#         app.run(debug=True, port=5000, use_reloader=False)

#from FlightRadar24 import Airport

# Obtener los bytes de la bandera del país
# flag_bytes = FlightRadar24API().get_country_flag("spain")[0]

# # Convertir los bytes SVG a PNG usando cairosvg
# png_bytes = cairosvg.svg2png(flag_bytes)

# # Crear un objeto BytesIO desde los bytes PNG
# png_io = BytesIO(png_bytes)

# # Utilizar png_io con las funciones de visualización o manipulación según tus necesidades
# png_image = Image.open(png_io)
# png_image.show()
# exit
while True:
    fr_api = FlightRadar24API()
    #print(fr_api.get_airport("TFN").country)

    count = 0
    key_flights = fr_api.get_flights(
        #airline = "CAI",
        registration = "EI-DHA"
    )
    #print(len(key_flights))
    fr_api.get_country_flag("spain")

    #print(key_flights[0])
    arch_j_son = json.dumps(fr_api.get_flight_details(key_flights[0]).get("time"))
for i in key_flights:
    #if "XR" in i.number:
    print(i.id,i.callsign,i.number,
            fr_api.get_airport(i.origin_airport_iata).city,
            fr_api.get_airport(i.destination_airport_iata).city)
for key in fr_api.get_zones():

    zone = fr_api.get_zones()[key]
    bounds = fr_api.get_bounds(zone)

    key_flights = fr_api.get_flights(
        airline = "IBB",
    )
    #print(len(key_flights))
    # print(len(europe_flights))
    for i in key_flights:
        #if "XR" in i.number:
        print(i.id,i.callsign,i.number,
                fr_api.get_airport(i.origin_airport_iata).city,
                fr_api.get_airport(i.destination_airport_iata).city)
            #print(fr_api.get_flight_details(i.id))

#myFlight = Flight("32f8323d",europe_flights)