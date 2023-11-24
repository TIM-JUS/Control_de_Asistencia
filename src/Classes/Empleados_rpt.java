package Classes;

public class Empleados_rpt {

   String id_empledo;
    String apellido;
    String nombre;
    String dni;
    String genero;
    String edad;
    String celular;
    String email;

    public Empleados_rpt(String id_empledo, String apellido,String nombre,String dni, String genero,String edad,String celular,String email) {
        this.id_empledo= id_empledo;
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni= dni;
        this.genero = genero;
        this.edad = edad;
        this.celular = celular;
        this.email = email;
    }

    public String getId_empleado() {
        return id_empledo;
    }
     public String getApellido() {
        return apellido;
    }
    public String getNombre() {
        return nombre;
    } public String getDni() {
        return dni;
    }
     public String getGenero() {
        return genero;
    }
    public String getEdad() {
        return edad;
    } 
    public String getCelular() {
        return celular;
    }
    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return nombre;
    }

}
