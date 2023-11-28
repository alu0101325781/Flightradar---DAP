import javax.swing.JOptionPane;

public class FlightInfoSubscriber implements IObserver {
    private String name;

    public FlightInfoSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String flightInfo) {
        JOptionPane.showMessageDialog(null, "Se detectó un cambio en la información del vuelo.", "Cambio Detectado", JOptionPane.INFORMATION_MESSAGE);
    }
}