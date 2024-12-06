import java.util.Scanner;

public class Main {
    private static Jugador[] jugadores = new Jugador[10];
    private static int cantidadJugadores = 0;
    private static Jugador jugadorActual;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tablero tablero = new Tablero();
        boolean salir = false;

        while (!salir) {
            System.out.println("Menú de Inicio:");
            System.out.println("1. Login");
            System.out.println("2. Crear Player");
            System.out.println("3. Salir");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    login(scanner);
                    break;
                case 2:
                    crearJugador(scanner);
                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

            if (jugadorActual != null) {
                menuPrincipal(scanner, tablero);
            }
        }
    }

    private static void login(Scanner scanner) {
        System.out.print("Ingrese su username: ");
        String username = scanner.next();
        System.out.print("Ingrese su password: ");
        String password = scanner.next();

        for (int i = 0; i < cantidadJugadores; i++) {
            if (jugadores[i].getUsername().equals(username) && jugadores[i].verificarPassword(password)) {
                jugadorActual = jugadores[i];
                System.out.println("Login exitoso.");
                return;
            }
        }

        System.out.println("Usuario o contraseña incorrectos.");
    }

    private static void crearJugador(Scanner scanner) {
        if (cantidadJugadores >= 10) {
            System.out.println("No se pueden crear más jugadores.");
            return;
        }

        System.out.print("Ingrese un username: ");
        String username = scanner.next();
        for (int i = 0; i < cantidadJugadores; i++) {
            if (jugadores[i].getUsername().equals(username)) {
                System.out.println("El username ya está en uso.");
                return;
            }
        }

        System.out.print("Ingrese un password (mínimo 8 caracteres): ");
        String password = scanner.next();
        if (password.length() < 8) {
            System.out.println("El password debe tener al menos 8 caracteres.");
            return;
        }

        jugadores[cantidadJugadores++] = new Jugador(username, password);
        System.out.println("Jugador creado exitosamente.");
    }

    private static void menuPrincipal(Scanner scanner, Tablero tablero) {
        boolean salir = false;

        while (!salir) {
            System.out.println("Menú Principal:");
            System.out.println("1. Jugar Ghosts");
            System.out.println("2. Configuración");
            System.out.println("3. Reportes");
            System.out.println("4. Mi Perfil");
            System.out.println("5. Salir");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    jugarGhosts(scanner, tablero);
                    break;
                case 5:
                    jugadorActual = null;
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void jugarGhosts(Scanner scanner, Tablero tablero) {
        // Implementar lógica del juego.
        System.out.println("Iniciando el juego...");
    }
}
