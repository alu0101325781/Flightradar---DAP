import javax.swing.JOptionPane;

public class FlightInfoSubscriber implements IObserver {
    private String name;
    private FlightTracker flightTracker;

    public FlightInfoSubscriber(String name, FlightTracker flightTracker) {
        this.name = name;
        this.flightTracker = flightTracker;
    }

    @Override
    public void update(String flightInfo) {
        // Actualizar el área de texto con la nueva información del vuelo
        System.out.println(name + ": Se detectó un cambio en la información del vuelo.");
        
        // Cambiar el estado según ciertas condiciones
        if (/* Condición para cambiar a DelayedStatus */) {
            flightTracker.setFlightStatus(new OnAir());
        } else {
            flightTracker.setFlightStatus(new OnLand());
        }
    }
}
