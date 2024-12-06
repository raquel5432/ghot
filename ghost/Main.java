import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Jugador> jugadores = new ArrayList<>();
    private static Jugador usuarioActual;
    private static Tablero tablero = new Tablero();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("=== MENÚ DE INICIO ===");
            System.out.println("1. Login");
            System.out.println("2. Crear Player");
            System.out.println("3. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea

            switch (opcion) {
                case 1:
                    login(scanner);
                    break;
                case 2:
                    crearJugador(scanner);
                    break;
                case 3:
                    System.out.println("Gracias por jugar. ¡Adiós!");
                    return;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }
        }
    }

    private static void login(Scanner scanner) {
        System.out.print("Ingresa tu username: ");
        String username = scanner.nextLine();
        System.out.print("Ingresa tu password: ");
        String password = scanner.nextLine();

        for (Jugador jugador : jugadores) {
            if (jugador.getUsername().equals(username) && jugador.verificarPassword(password)) {
                usuarioActual = jugador;
                System.out.println("Login exitoso. ¡Bienvenido, " + username + "!");
                menuPrincipal(scanner);
                return;
            }
        }
        System.out.println("Usuario o contraseña incorrectos.");
    }

    private static void crearJugador(Scanner scanner) {
        System.out.print("Ingresa un username: ");
        String username = scanner.nextLine();
        for (Jugador jugador : jugadores) {
            if (jugador.getUsername().equals(username)) {
                System.out.println("El username ya está en uso. Intenta con otro.");
                return;
            }
        }

        System.out.print("Ingresa un password (8 caracteres): ");
        String password = scanner.nextLine();
        if (password.length() != 8) {
            System.out.println("El password debe tener exactamente 8 caracteres.");
            return;
        }

        Jugador nuevoJugador = new Jugador(username, password);
        jugadores.add(nuevoJugador);
        System.out.println("Jugador creado exitosamente. ¡Bienvenido, " + username + "!");
        usuarioActual = nuevoJugador;
        menuPrincipal(scanner);
    }

    private static void menuPrincipal(Scanner scanner) {
        while (true) {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Jugar Ghosts");
            System.out.println("2. Configuración");
            System.out.println("3. Mi Perfil");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea

            switch (opcion) {
                case 1:
                    jugarGhosts(scanner);
                    break;
                case 2:
                    configuracion(scanner);
                    break;
                case 3:
                    mostrarPerfil(scanner);
                    break;
                case 4:
                    usuarioActual = null;
                    System.out.println("Sesión cerrada.");
                    return;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }
        }
    }

    private static void jugarGhosts(Scanner scanner) {
        tablero.mostrarTablero();
        System.out.println("Funcionalidad en desarrollo...");
    }

    private static void configuracion(Scanner scanner) {
        System.out.println("Funcionalidad de configuración en desarrollo...");
    }

    private static void mostrarPerfil(Scanner scanner) {
        System.out.println(usuarioActual);
        usuarioActual.mostrarHistorial();
    }
}
