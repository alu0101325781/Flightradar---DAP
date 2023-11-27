from FlightRadar24 import FlightRadar24API
import json
from FlightRadar24 import Airport
from FlightRadar24 import Flight
import time
import cairosvg
from io import BytesIO
from PIL import Image
from flask import Flask, jsonify

while True:
    fr_api = FlightRadar24API()
    #print(fr_api.get_airport("TFN").country)

    count = 0
    key_flights = fr_api.get_flights(
        #airline = "CAI",
        registration = "G-DRTB"
    )
    detalles_vuelo = fr_api.get_flight_details(key_flights[0])
    print(detalles_vuelo.get("time")["real"]["arrival"],end="\t")
    print(key_flights[0])
    time.sleep(10)
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