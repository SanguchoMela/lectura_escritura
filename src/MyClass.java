import java.io.Serializable;

public class MyClass implements Serializable {

    private static final long serialVersionUID =1L;    //long: tipo de datos especial
    private String nombre;
    private String cedula;
    private String edad;
    

    public MyClass(String nombre, String cedula, String edad) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    @Override
    public String toString(){
        return "\nNombre: "+nombre+"\nCedula: "+cedula+"\nEdad: "+edad;
    }
}
