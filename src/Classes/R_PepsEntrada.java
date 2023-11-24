
package Classes;


public class R_PepsEntrada {
   String fecha_entrada;
    String descripcion_entrada;
    String cantidad;
    String total;
   
    
    public R_PepsEntrada(String fecha_entrada, String descripcion_entrada,String cantidad,String total) {
        this.fecha_entrada=fecha_entrada;
        this.descripcion_entrada = descripcion_entrada;
        this.cantidad = cantidad;
        this.total = total;
      
    }

    public String getFecha_entrada() {
        return fecha_entrada;
    }
     public String getDescripcion_entrada() {
        return descripcion_entrada;
    }
    public String getCantidad() {
        return cantidad;
    }
    public String getTotal() {
        return total;
    }  
    
     
    @Override
    public String toString() {
        return descripcion_entrada;
    }  
}
