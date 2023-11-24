# FlightRadar
## Acerca de 
Este programa muestra la información de los aviones actualmente volando
Se mostrará origen, destino y demás estadísticas
## Como funciona
Para conseguir nuestro objetivo usamos la API proporcionada por la aplicación Flightradar24.
Se ha elegido esta y no otra ya que las alternativas no disponen de tanta calidad ni fácilidades de uso.

Dicha API funciona en Python por lo que hemos tenido que crear un script que nos permite descargar la información que necesitamos
en un archivo .json que se actualiza de forma automática y se sube a una carpeta drive de forma recurrente.

Posteriromente se ha hecho en Java una interfaz siguiendo el patrón observador en la que al subscriptor se le informa de los vuelos y sus estadísticas. 
