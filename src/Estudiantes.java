public class Estudiantes {
    String cedula;
    String nombre;
    float b1;
    float b2;

    public Estudiantes() {
    }

    public Estudiantes(String cedula, String nombre, float b1, float b2) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.b1 = b1;
        this.b2 = b2;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getB1() {
        return b1;
    }

    public void setB1(Float b1) {
        this.b1 = b1;
    }

    public Float getB2() {
        return b2;
    }

    public void setB2(Float b2) {
        this.b2 = b2;
    }
}
