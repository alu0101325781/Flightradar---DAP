package es.ull.patrones.practica7;

import es.ull.patrones.practica7.Connection.APIConnection;
import es.ull.patrones.practica7.Connection.FreePortFinder;
import es.ull.patrones.practica7.Events.*;
import es.ull.patrones.practica7.FlightPck.Flight;

import java.util.Arrays;
import java.util.EventListener;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Usuario rodrigo = new Usuario("Rodrigo");
        Usuario enrique = new Usuario("Enrique");
        String puerto = String.valueOf(FreePortFinder.findFreePort(5000));
        System.out.println(puerto);
        Thread apiThread = new Thread(() -> APIConnection.loadConnection(puerto,"-n","BA248"));
        apiThread.start();
        Thread.sleep(10000);
        //System.out.println(APIConnection.getFlightId("2","CA737"));
        Flight mad_eze = new Flight(APIConnection.getFlightId("2","BA248"));
        System.out.println(mad_eze.getInitialMessage());
        //Thread.sleep(10000);
        //TrackerApp editor = new TrackerApp(mad_eze.getId());
        List<Usuario> userlist = Arrays.asList(rodrigo,enrique);
        myEventListener flight1Listener = new FlightListener(userlist);
        EventManager em = new EventManager(mad_eze,flight1Listener);
        TrackerApp ta = new TrackerApp(em);
        ta.start();
    }
}