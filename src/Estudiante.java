import java.util.HashMap;

class Estudiante extends Usuario implements UsuarioInterface {

    private int carnet;
    private static HashMap<Integer, Estudiante> registroEstudiantes = new HashMap<>();

    public Estudiante(String nombre, String apellido, int cedula, String correo, int carnet) {
        super(nombre, apellido, cedula, correo);
        this.carnet = carnet;
    }

    public Estudiante() {
        super();
    }

    public int getCarnet() {
        return carnet; }

    public void setCarnet(int carnet) {
        this.carnet = carnet; }

    @Override
    public void registrar() {
        registroEstudiantes.put(this.cedula, this);
        System.out.println("Estudiante registrado exitosamente.");
    }

    @Override
    public void verInformacion() {
        System.out.println("\nInformación del estudiante:");
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Cédula: " + cedula);
        System.out.println("Correo: " + correo);
        System.out.println("Carnet: " + carnet);
        System.out.println("______________________________");
    }

    public static Estudiante buscarPorCedula(int cedula) {
        return registroEstudiantes.get(cedula);
    }
}