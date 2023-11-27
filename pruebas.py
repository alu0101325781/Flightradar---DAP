from FlightRadar24 import FlightRadar24API
import json
from FlightRadar24 import Airport
from FlightRadar24 import Flight
import time
import cairosvg
from io import BytesIO
from PIL import Image
from flask import Flask, jsonify
import sys

def mostrar_error(mensaje):
    print(f"Error: {mensaje}", file=sys.stderr)

def compare_registration(flight: Flight, reg: str):
    return reg == flight.registration

def compare_number(flight: Flight, number: str):
    return number == flight.number

def find_flight(opcion: int, str: str) -> Flight:

    choosen_function = None
    if opcion == 1:
        choosen_function = compare_registration
    else: 
        choosen_function = compare_number
    fr_api = FlightRadar24API()

    for key in fr_api.get_zones():

        zone = fr_api.get_zones()[key]
        zone_bounds = fr_api.get_bounds(zone)

        selected_flights = fr_api.get_flights(
            bounds = zone_bounds
        )

        for i in selected_flights:
            if choosen_function(i,str):
                print(i.id,i.callsign,i.number,i.registration,
                    fr_api.get_airport(i.origin_airport_iata).city,
                    fr_api.get_airport(i.destination_airport_iata).city)
                return i

opcion = 0
if (sys.argv[1] == "-r" or
    sys.argv[1] == "--registration"):
    opcion = 1
elif (sys.argv[1] == "-n" or
    sys.argv[1] == "--fligh_number"):
    opcion = 2
else:
    mostrar_error("Opción no válida")
    sys.exit(1)

selected_flight = find_flight(opcion,sys.argv[2]) 
if selected_flight == None:
    mostrar_error("No se ha encontrado el vuelo")
    sys.exit(2)
        

while True:
    fr_api = FlightRadar24API()
    #print(fr_api.get_airport("TFN").country)

    # count = 0
    # key_flights = fr_api.get_flights(
    #     #airline = "CAI",
    #     #registration = "G-DRTB"
    # )
    detalles_vuelo = fr_api.get_flight_details(selected_flight)
    print(detalles_vuelo.get("time")["real"]["arrival"],end="\t")
    print(selected_flight)
    time.sleep(10)

# for i in key_flights:
#     #if "XR" in i.number:
#     print(i.id,i.callsign,i.number,
#             fr_api.get_airport(i.origin_airport_iata).city,
#             fr_api.get_airport(i.destination_airport_iata).city)
# for key in fr_api.get_zones():

#     zone = fr_api.get_zones()[key]
#     bounds = fr_api.get_bounds(zone)

#     key_flights = fr_api.get_flights(
#         airline = "IBB",
#     )
#     #print(len(key_flights))
#     # print(len(europe_flights))
#     for i in key_flights:
#         #if "XR" in i.number:
#         print(i.id,i.callsign,i.number,
#                 fr_api.get_airport(i.origin_airport_iata).city,
#                 fr_api.get_airport(i.destination_airport_iata).city)
#             #print(fr_api.get_flight_details(i.id))

#myFlight = Flight("32f8323d",europe_flights)