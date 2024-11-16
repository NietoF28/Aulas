class Aula {
    private String torre;
    private int salon;
    private String tipo;
    private boolean disponible;

    public Aula(String torre, int salon, String tipo) {
        this.torre = torre;
        this.salon = salon;
        this.tipo = tipo;
        this.disponible = true;
    }


    public String getTorre() {
        return torre; }

    public int getSalon() {
        return salon; }

    public String getTipo() {
        return tipo; }

    public boolean isDisponible() {
        return disponible; }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible; }


    @Override
    public String toString() {
        return "Torre: " + torre + " - Salón: " + salon + " - Tipo: " + tipo +
                " - Disponible: " + (disponible ? "Sí" : "No");
    }
}