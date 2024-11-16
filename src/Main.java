import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static SistemaReservas sistema = new SistemaReservas();
    private static Estudiante estudiante = new Estudiante();
    
//    Primero registra un estudiante
//    Luego puedes hacer reservas usando la cédula del estudiante
//    Puedes ver las reservas existentes buscando por cédula
//    Puedes ver las aulas disponibles en cualquier momento.

    public static void main(String[] args) {
        while (true) {

            System.out.println("\n=== Sistema de Reserva de Aulas ===");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Realizar reserva");
            System.out.println("3. Ver reservas por cédula");
            System.out.println("4. Ver aulas disponibles");
            System.out.println("5. Entrega de aula");
            System.out.println("6. Salir");

            System.out.print("Seleccione una opción: ");
             int opcion = scanner.nextInt();


            switch (opcion) {
                case 1:
                    registrarEstudiante();
                    break;
                case 2:
                    realizarReserva();
                    break;
                case 3:
                    verReservas();
                    break;
                case 4:
                    sistema.mostrarAulasDisponibles();
                    break;

                case 5:
//                  falta entrega del aula
                    break;

                case 6:
                    System.out.println("¡Hasta luego!");
                    return;


                default:
                    System.out.println("Opción no válida");
            }
        }
    }


    private static void registrarEstudiante() {
        System.out.println("\n=== Registro de Estudiante ===");
        System.out.print("Nombre: ");
        String nombre = scanner.next();
        System.out.print("Apellido: ");
        String apellido = scanner.next();
        System.out.print("Cédula: ");
        int cedula = scanner.nextInt();
        System.out.print("Correo: ");
        String correo = scanner.next();
        System.out.print("Carnet: ");
        int carnet = scanner.nextInt();

        Estudiante estudiante = new Estudiante(nombre, apellido, cedula, correo, carnet);
        estudiante.registrar();
    }

    private static void realizarReserva() {
        System.out.println("\n=== Realizar Reserva ===");
        System.out.print("Cédula del estudiante: ");
        int cedula = scanner.nextInt();
        System.out.print("Torre (A/B): ");
        String torre = scanner.next();
        System.out.print("Número de salón: ");
        int salon = scanner.nextInt();

        sistema.realizarReserva(cedula, torre, salon);
    }

    private static void verReservas() {
        System.out.print("\nIngrese la cédula del estudiante: ");
        int cedula = scanner.nextInt();
        sistema.verReservasEstudiante(cedula);

    }


}