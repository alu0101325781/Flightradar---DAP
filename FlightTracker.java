import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class FlightTracker implements IPublisher {
    private List<IObserver> observers = new ArrayList<>();
    private String filePath;
    private String currentFlightInfo;
    private FlightStatus flightStatus;

    public FlightTracker(String filePath) {
        this.filePath = filePath;
        this.currentFlightInfo = readJsonFile();
        this.flightStatus = new OnLand(); // Inicializar con un estado predeterminado
        scheduleJsonFileCheck();
    }

    public void setFlightStatus(FlightStatus flightStatus) {
        this.flightStatus = flightStatus;
    }

    @Override
    public void registerObserver(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        String newFlightInfo = readJsonFile();
        flightStatus.checkStatus(newFlightInfo);

        if (!newFlightInfo.equals(currentFlightInfo)) {
            currentFlightInfo = newFlightInfo;
            for (IObserver observer : observers) {
                observer.update(currentFlightInfo);
            }
        }
    }

    private String readJsonFile() {
        // Implementación de lectura del archivo JSON
        // ...
        return ""; // Placeholder, reemplázalo con la implementación real
    }

    private void scheduleJsonFileCheck() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(this::notifyObservers, 0, 10, TimeUnit.SECONDS);
    }
}

