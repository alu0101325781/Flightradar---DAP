# FlightRadar

## Acerca de 
Este programa muestra la información del avión seleccionado por el usuario. 
Se podrá ver si está en vuelo o en tierra y notificará si cambia alguno de estos estados.
## Como funciona
Para lograr nuestro objetivo, utilizamos la API proporcionada por la aplicación Flightradar24. Se ha elegido esta y no 
otra, ya que las alternativas no disponen de tanta calidad ni facilidades de uso.

Dicha API funciona en Python, por lo que hemos tenido que crear un script que nos permite descargar la información que 
necesitamos en un archivo .json que se actualiza automáticamente.

Posteriormente, se ha desarrollado en Java una interfaz siguiendo el patrón observador en la que al suscriptor se le 
informa de los vuelos y sus estadísticas. Para su correcto funcionamiento, también se ha utilizado el patrón estado para la posibilidad de que este despegando, en el aire o aterrizando.
