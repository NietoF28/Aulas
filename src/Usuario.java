abstract class Usuario {

    protected String nombre;
    protected String apellido;
    protected int cedula;
    protected String correo;

    public Usuario(String nombre, String apellido, int cedula, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.correo = correo;
    }

    public Usuario() {}


    public String getNombre() {
        return nombre; }

    public void setNombre(String nombre) {
        this.nombre = nombre; }

    public String getApellido() {
        return apellido; }

    public void setApellido(String apellido) {
        this.apellido = apellido; }

    public int getCedula() {
        return cedula; }

    public void setCedula(int cedula) {
        this.cedula = cedula; }

    public String getCorreo() {
        return correo; }

    public void setCorreo(String correo) {

        this.correo = correo; }
}

