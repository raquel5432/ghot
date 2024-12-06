import java.util.Arrays;

public class Jugador {
    private String username;
    private String password;
    private int puntos;
    private String[] historialPartidas; // Historial de las últimas 10 partidas
    private int indiceHistorial;

    public Jugador(String username, String password) {
        this.username = username;
        this.password = password;
        this.puntos = 0;
        this.historialPartidas = new String[10];
        this.indiceHistorial = 0;
    }

    public String getUsername() {
        return username;
    }

    public boolean verificarPassword(String password) {
        return this.password.equals(password);
    }

    public void cambiarPassword(String nuevoPassword) {
        this.password = nuevoPassword;
    }

    public void agregarPuntos(int puntos) {
        this.puntos += puntos;
    }

    public int getPuntos() {
        return puntos;
    }

    public void agregarHistorial(String partida) {
        historialPartidas[indiceHistorial] = partida;
        indiceHistorial = (indiceHistorial + 1) % 10; // Índice circular
    }

    public void mostrarHistorial() {
        System.out.println("Historial de partidas:");
        Arrays.stream(historialPartidas)
                .filter(partida -> partida != null)
                .forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "Jugador: " + username + " | Puntos: " + puntos;
    }
}

