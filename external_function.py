from FlightRadar24 import FlightRadar24API
from FlightRadar24 import Flight
def _compare_registration(flight: Flight, reg: str):
    return reg == flight.registration

def _compare_number(flight: Flight, number: str):
    return number == flight.number

def _compare_id(flight: Flight, id: str):
    return id == flight.id

def find_flight(opcion: int, str: str) -> Flight:

    choosen_function = None
    if opcion == 1:
        choosen_function = _compare_registration
    elif opcion == 2:
        choosen_function = _compare_number
    else: 
        choosen_function = _compare_id
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