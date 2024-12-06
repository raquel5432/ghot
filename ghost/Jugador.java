public class Jugador {
    private String username;
    private String password;
    private int puntos;
    private String[] historialPartidas = new String[10];
    private int contadorHistorial = 0;

    public Jugador(String username, String password) {
        this.username = username;
        this.password = password;
        this.puntos = 0;
    }

    public String getUsername() {
        return username;
    }

    public boolean verificarPassword(String password) {
        return this.password.equals(password);
    }

    public void cambiarPassword(String nuevaPassword) {
        this.password = nuevaPassword;
    }

    public int getPuntos() {
        return puntos;
    }

    public void agregarPuntos(int puntos) {
        this.puntos += puntos;
    }

    public void agregarPartidaHistorial(String descripcion) {
        if (contadorHistorial < 10) {
            historialPartidas[contadorHistorial] = descripcion;
            contadorHistorial++;
        } else {
            for (int i = 0; i < 9; i++) {
                historialPartidas[i] = historialPartidas[i + 1];
            }
            historialPartidas[9] = descripcion;
        }
    }

    public void mostrarHistorial() {
        System.out.println("Historial de Partidas de " + username + ":");
        for (int i = 0; i < contadorHistorial; i++) {
            System.out.println((i + 1) + ". " + historialPartidas[i]);
        }
    }

    public String mostrarDatos() {
        return "Usuario: " + username + ", Puntos: " + puntos;
    }
}
