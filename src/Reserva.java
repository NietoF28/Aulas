import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Reserva {
    private Estudiante estudiante;
    private Aula aula;
    private LocalDateTime fechaReserva;
    private LocalDateTime fechaEntrega;
    private boolean activa;
    private static HashMap<Integer, List<Reserva>> reservasPorEstudiante = new HashMap<>();


    public Reserva(Estudiante estudiante, Aula aula) {
        this.estudiante = estudiante;
        this.aula = aula;
        this.fechaReserva = LocalDateTime.now();
        this.activa = true;

        // Agregar la reserva al HashMap
        reservasPorEstudiante.computeIfAbsent(estudiante.getCedula(), k -> new ArrayList<>()).add(this);
    }

    public Reserva() {

    }

    public void finalizarReserva() {
        this.activa = false;
        this.fechaEntrega = LocalDateTime.now();
        this.aula.setDisponible(true);
    }

    public static List<Reserva> buscarReservasPorCedula(int cedula) {
        return reservasPorEstudiante.getOrDefault(cedula, new ArrayList<>());
    }

    // Getters
    public Estudiante getEstudiante() {
        return estudiante; }

    public Aula getAula() {
        return aula; }

    public LocalDateTime getFechaReserva() {
        return fechaReserva; }

    public LocalDateTime getFechaEntrega() {
        return fechaEntrega; }

    public boolean isActiva() {
        return activa; }

}