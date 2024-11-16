import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

class SistemaReservas {
    private List<Aula> aulas;
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public SistemaReservas() {
        this.aulas = new ArrayList<>();
        inicializarAulas();
    }

    private void inicializarAulas() {
        aulas.add(new Aula("A", 201, "Multimedia"));
        aulas.add(new Aula("A", 202, "Sistemas"));
        aulas.add(new Aula("B", 301, "Laboratorio"));
        aulas.add(new Aula("B", 302, "Radio"));
    }

    public Aula buscarAula(String torre, int salon) {
        return aulas.stream()
                .filter(a -> a.getTorre().equalsIgnoreCase(torre) && a.getSalon() == salon)
                .findFirst()
                .orElse(null);
    }

    public void mostrarAulasDisponibles() {
        System.out.println("\nAulas disponibles:");
        aulas.stream()
                .filter(Aula::isDisponible)
                .forEach(System.out::println);
    }

    public boolean realizarReserva(int cedula, String torre, int salon) {
        Estudiante estudiante = Estudiante.buscarPorCedula(cedula);
        if (estudiante == null) {
            System.out.println("Estudiante no encontrado.");
            return false;
        }

        Aula aula = buscarAula(torre, salon);
        if (aula == null) {
            System.out.println("Aula no encontrada.");
            return false;
        }

        if (!aula.isDisponible()) {
            System.out.println("El aula no está disponible.");
            return false;
        }

        aula.setDisponible(false);
        new Reserva(estudiante, aula);
        System.out.println("Reserva realizada exitosamente.");
        return true;
    }

    public void verReservasEstudiante(int cedula) {
        List<Reserva> reservas = Reserva.buscarReservasPorCedula(cedula);
        if (reservas.isEmpty()) {
            System.out.println("No se encontraron reservas para esta cédula.");
            return;
        }

        System.out.println("\nReservas encontradas:");
        for (Reserva reserva : reservas) {
            System.out.println("\nEstudiante: " + reserva.getEstudiante().getNombre() +
                    " " + reserva.getEstudiante().getApellido());
            System.out.println("Aula: Torre " + reserva.getAula().getTorre() +
                    " - Salón " + reserva.getAula().getSalon());
            System.out.println("Fecha de reserva: " + reserva.getFechaReserva().format(formatter));
            System.out.println("Estado: " + (reserva.isActiva() ? "Activa" : "Finalizada"));
            if (!reserva.isActiva()) {
                System.out.println("Fecha de entrega: " +
                        reserva.getFechaEntrega().format(formatter));
            }
        }
    }
}