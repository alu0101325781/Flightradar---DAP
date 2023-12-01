package es.ull.patrones.practica7;

public class Editor {
    private String flightNumber;
    private String status;

    // Constructor, getters y setters

    // Método para actualizar el estado del vuelo
    public void updateStatus(String newStatus) {
        this.status = newStatus;
    }
}
