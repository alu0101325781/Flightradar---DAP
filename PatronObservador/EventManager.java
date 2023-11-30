package PatronObservador;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;
import java.nio.file.Paths;


public class EventManager {
    private List<EventListener> observers = new ArrayList<>();
    private Editor flightInfo;
    private String filePath;
    private String currentFlightInfo;

    public EvenManager(String filePath) {
        this.filePath = filePath;
        scheduleJsonFileCheck();
    }

    // Método para agregar observadores
    public void addObserver(EventListener observer) {
        observers.add(observer);
    }

    // Método para quitar observadores
    public void removeObserver(EventListener observer) {
        observers.remove(observer);
    }

    // Método para notificar a los observadores
    public void notifyObservers() {
        String newFlightInfo = readJsonFile();

        if (!newFlightInfo.equals(currentFlightInfo)) {
            currentFlightInfo = newFlightInfo;
            for (EventListener observer : observers) {
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
        scheduler.scheduleAtFixedRate(() -> {
            try {
                notifyObserversIfFileChanged();  // Llamada al método de comprobación de cambios
            } catch (IOException e) {
                e.printStackTrace();
            }
        }, 0, 10, TimeUnit.SECONDS);
    }


    private void notifyObserversIfFileChanged() throws IOException {
        Path directory = Paths.get(filePath).getParent();  // Obtén el directorio del archivo
        WatchService watchService = FileSystems.getDefault().newWatchService();
        directory.register(watchService, ENTRY_MODIFY);

        new Thread(() -> {
            while (true) {
                WatchKey key;
                try {
                    key = watchService.take();
                } catch (InterruptedException e) {
                    return;
                }

                for (WatchEvent<?> event : key.pollEvents()) {
                    if (event.kind() == ENTRY_MODIFY) {
                        Path changedPath = (Path) event.context();
                        if (changedPath.endsWith("Airport_fields.json")) {
                            notifyObservers();
                        }
                    }
                }

                boolean valid = key.reset();
                if (!valid) {
                    break;
                }
            }
        }).start();
    }

}
