
package Classes;


public class R_PepsSalida {
     String fecha_salida ;
    String descripcion_salida;
    String cantidad_salida;
    String total_s;
    String existencia;
    public R_PepsSalida (String fecha_salida ,String descripcion_salida,String cantidad_salida,String total_s,String existencia) {
       
        this.fecha_salida = fecha_salida ;
        this.descripcion_salida = descripcion_salida;
        this.cantidad_salida = cantidad_salida;
        this.total_s = total_s;
        this.existencia=existencia;
    }

     public String getFecha_salida() {
        return fecha_salida ;
    }
     public String getDescripcion_salida() {
        return descripcion_salida;
    }
    public String getCantidad_salida() {
        return cantidad_salida;
    } public String getTotal_s() {
        return total_s;
    } public String getExistencia() {
        return existencia;
    }  
     

    @Override
    public String toString() {
        return descripcion_salida;
    }
}
