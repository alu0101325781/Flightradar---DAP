package es.ull.patrones.practica7.Events;

import es.ull.patrones.practica7.Usuario;

import java.util.List;

class FlightListener implements EventListeners {
    private String name;

    private List<Usuario> usuarios;

    public FlightListener(String name, List<Usuario> usuarios) {
        this.name = name;
        this.usuarios = usuarios;
    }

    public FlightListener(String name) {
        this.name = name;
    }

    public void addUsuario(Usuario usario){
        this.usuarios.add(usario);
    }

    @Override
    public void update(String flightInfo) {
        for (Usuario user : this.usuarios) {
            user.recibirAviso(flightInfo);
        }
    }
}
