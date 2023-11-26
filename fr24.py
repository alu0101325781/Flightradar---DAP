from FlightRadar24 import FlightRadar24API
fr_api = FlightRadar24API()

import json

# Crea una instancia de la API de FlightRadar24
fr_api = FlightRadar24API()

# Obtén detalles del aeropuerto (reemplaza 'GCXO' con el código del aeropuerto real)
airport_details = fr_api.get_airport_details("GCXO")

# Convierte los detalles del aeropuerto a una cadena JSON bien estructurada
json_str = json.dumps(airport_details, indent=2)

# Imprime la cadena JSON
# print(json_str)

# Opcional: Guardar la cadena JSON en un archivo
with open('aux2.json', 'w') as json_file:
    json.dump(airport_details, json_file, indent=2)
