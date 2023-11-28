
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class FlightTracker implements IPublisher {
    private List<IObserver> observers = new ArrayList<>();
    private String filePath;
    private String currentFlightInfo;

    public FlightTracker(String filePath) {
        this.filePath = filePath;
        this.currentFlightInfo = readJsonFile();
        scheduleJsonFileCheck();
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
        if (!newFlightInfo.equals(currentFlightInfo)) {
            currentFlightInfo = newFlightInfo;
            for (IObserver observer : observers) {
                observer.update(currentFlightInfo);
            }
        }
    }

    private String readJsonFile() {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    private void scheduleJsonFileCheck() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(this::notifyObservers, 0, 10, TimeUnit.SECONDS);
    }
}
