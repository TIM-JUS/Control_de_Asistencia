package Classes;

public class Empleado {

    String codigo_empleado;
    String nombre;

    public Empleado(String codigo_empleado, String nombre) {
        this.codigo_empleado = codigo_empleado;
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo_empleado;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
