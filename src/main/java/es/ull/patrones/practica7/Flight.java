package es.ull.patrones.practica7;

import com.fasterxml.jackson.databind.JsonNode;
import es.ull.patrones.practica7.Connection.ReadJsonFromUrl;

public class Flight {
    private String id;
    private String registration;
    private String fNumber;
    private String originAptIATA;
    private String destinationAptIATA;

    public Flight(String id){
        this.id = id;
        JsonNode jsonNode = ReadJsonFromUrl.read("http://127.0.0.1:5000/3308e49b/info");
        this.registration = jsonNode.get("registration").asText();
        this.fNumber = jsonNode.get("number").asText();
        this.originAptIATA = jsonNode.get("origin_airport_iata").asText();
        this.destinationAptIATA = jsonNode.get("origin_airport_iata").asText();
    }

}
