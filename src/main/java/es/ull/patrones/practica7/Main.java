package es.ull.patrones.practica7;

import es.ull.patrones.practica7.Connection.APIConnection;
import es.ull.patrones.practica7.Connection.ReadJsonFromUrl;

public class Main {
    public static void main(String[] args) {
/*        Editor editor = new Editor();
        System.out.println(APIConnection.getFlightId("2","VY3000"));
        Ventana ventana = new Ventana("Rodrigo");*/
        System.out.println(ReadJsonFromUrl.read("http://127.0.0.1:5000/3308e49b/info").get("destination_airport_iata").asText());
    }
}