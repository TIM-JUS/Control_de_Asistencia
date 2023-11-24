package tim;

import Classes.Conexion;
import Classes.R_PepsEntrada;
import Classes.R_PepsSalida;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;


public class peps extends javax.swing.JInternalFrame {

    public DefaultTableModel modelokardexEntrada;
    public DefaultTableModel modelokardexSalida;
    int codigo_producto;
    FondoPanel fondo = new FondoPanel();
    public peps(int cod) {
        this.setContentPane(fondo); 
        initComponents();
        this.getContentPane().setBackground(getBackground());
        codigo_producto = cod;
        System.out.println(cod);
        int a = ventanaprincipal.Escritorio.getWidth() - this.getWidth();
        int b = ventanaprincipal.Escritorio.getHeight() - this.getHeight();
        setLocation(a / 2, b / 2);

        String[] columnaNombre = {"FECHA ENTRADA", "DESCRIPCION", "CANTIDAD RECIBIDA"};
        String[][] dato = {};
        modelokardexEntrada = new DefaultTableModel(dato, columnaNombre);
        grdEntradas.setModel(modelokardexEntrada);
//        kardexEntradas();

//        txtMostrarEntradas.setText(Integer.toString(totalEntrada()));
        String[] columnaNombre1 = {"FECHA SALIDA", "DESCRIPCION", "CANTIDAD VENDIDA"};
        String[][] dato1 = {};
        modelokardexSalida = new DefaultTableModel(dato1, columnaNombre1);
        grdSalidas.setModel(modelokardexSalida);
//        kardexSalidas();
//        txtMostrarSalidas.setText(Integer.toString(totalSalida()));
//        int num1, num2, resta;
//        num1 = Integer.parseInt(this.txtMostrarEntradas.getText());
//        num2 = Integer.parseInt(this.txtMostrarSalidas.getText());
//        resta = num1 - num2;
//        txtSaldo.setText(String.valueOf(resta));
    }

    public void kardexEntradas() {

        Conexion cn1 = new Conexion();
        Connection cn = cn1.conexion();

        try {

            Statement s = cn.createStatement();
            ResultSet r = s.executeQuery("SELECT pedido.fecha_entrega,producto.descripcion_producto,pedido.cantidad_entregada \n"
                    + "FROM pedido,producto \n"
                    + "WHERE pedido.id_producto=producto.id_producto\n"
                    + "AND pedido.fecha_entrega BETWEEN '2021-01-03' AND '2021-01-31'\n"
                    + "AND producto.id_producto = 11");

            while (r.next()) {
                Object bien[] = {r.getString("fecha_entrega"), r.getString("descripcion_producto"), r.getString("cantidad_entregada")};
                modelokardexEntrada.addRow(bien);
            }

        } catch (Exception ex) {
            System.out.println("Error, no se ha podido cargar SQL Server JDBC Driverentrada");
        }
    }

    public void kardexSalidas() {
        Conexion cn1 = new Conexion();
        Connection cn = cn1.conexion();

        try {

            Statement s = cn.createStatement();
            ResultSet r = s.executeQuery("SELECT venta.fecha_venta,producto.descripcion_producto,detalle_venta.unidades_vendidas\n"
                    + "FROM venta,producto,detalle_venta\n"
                    + "WHERE detalle_venta.id_producto=producto.id_producto\n"
                    + "AND detalle_venta.id_venta=venta.id_venta\n"
                    + "AND venta.fecha_venta BETWEEN '2021-01-03' AND '2021-01-09'\n"
                    + "AND producto.id_producto = 35");

            while (r.next()) {
                Object bien[] = {r.getString("fecha_venta"), r.getString("descripcion_producto"), r.getString("unidades_vendidas")};
                modelokardexSalida.addRow(bien);
            }

        } catch (Exception ex) {
            System.out.println("Error, no se ha podido cargar SQL Server JDBC Driversalida");
        }
    }

    public int totalEntrada() {
        int contar = grdEntradas.getRowCount();
        int suma = 0;
        for (int i = 0; i < contar; i++) {
            suma = suma + Integer.parseInt(grdEntradas.getValueAt(i, 2).toString());
        }
        return suma;
    }

    public int totalSalida() {
        int contar = grdSalidas.getRowCount();
        int suma = 0;
        for (int i = 0; i < contar; i++) {
            suma = suma + Integer.parseInt(grdSalidas.getValueAt(i, 2).toString());
        }
        return suma;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        grdEntradas = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        grdSalidas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtMostrarEntradas = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMostrarSalidas = new javax.swing.JTextField();
        txtSaldo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnConsultar = new javax.swing.JButton();
        txtInferior = new com.toedter.calendar.JDateChooser();
        txtSuperior = new com.toedter.calendar.JDateChooser();
        PRINT_ENTRADA = new javax.swing.JButton();
        PRINT_SALIDA = new javax.swing.JButton();

        setBackground(new java.awt.Color(51, 255, 204));
        setClosable(true);

        grdEntradas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(grdEntradas);

        grdSalidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(grdSalidas);

        jLabel1.setText("Entra");

        txtMostrarEntradas.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel2.setText("Desde");

        jLabel3.setText("Hasta");

        jLabel4.setText("Sale");

        txtMostrarSalidas.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtSaldo.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel5.setText("Saldo");

        btnConsultar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/bus.png"))); // NOI18N
        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        PRINT_ENTRADA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Print.png"))); // NOI18N
        PRINT_ENTRADA.setText("PRINT");
        PRINT_ENTRADA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PRINT_ENTRADAActionPerformed(evt);
            }
        });

        PRINT_SALIDA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Print.png"))); // NOI18N
        PRINT_SALIDA.setText("PRINT");
        PRINT_SALIDA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PRINT_SALIDAActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel1)
                            .addComponent(txtMostrarEntradas, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txtMostrarSalidas, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PRINT_ENTRADA)
                            .addComponent(PRINT_SALIDA)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtInferior, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                            .addComponent(txtSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(79, 79, 79)
                        .addComponent(btnConsultar)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(txtInferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(12, 12, 12)
                                        .addComponent(jLabel3))
                                    .addComponent(btnConsultar, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(PRINT_ENTRADA)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMostrarEntradas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PRINT_SALIDA)
                        .addGap(33, 33, 33)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMostrarSalidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        // TODO add your handling code here:

        String fecha1, fecha2;
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        fecha1 = f.format(txtInferior.getDate());
        fecha2 = f.format(txtSuperior.getDate());

        Conexion cn1 = new Conexion();
        Connection cn = cn1.conexion();

        try {

            Statement s = cn.createStatement();
            ResultSet r = s.executeQuery("SELECT pedido.fecha_entrega,producto.descripcion_producto,pedido.cantidad_entregada \n"
                    + "FROM pedido,producto \n"
                    + "WHERE pedido.id_producto=producto.id_producto\n"
                    + "AND pedido.fecha_entrega BETWEEN '" + fecha1 + "' AND '" + fecha2 + "'\n"
                    + "AND producto.id_producto = " + codigo_producto + "");

            while (r.next()) {
                Object bien[] = {r.getString("fecha_entrega"), r.getString("descripcion_producto"), r.getString("cantidad_entregada")};
                modelokardexEntrada.addRow(bien);
            }

            txtMostrarEntradas.setText(Integer.toString(totalEntrada()));

        } catch (Exception ex) {
            System.out.println("Error, no se ha podido cargar SQL Server JDBC Driverentrada");
        }

        try {

            Statement s = cn.createStatement();
            ResultSet r = s.executeQuery("SELECT venta.fecha_venta,producto.descripcion_producto,detalle_venta.unidades_vendidas\n"
                    + "FROM venta,producto,detalle_venta\n"
                    + "WHERE detalle_venta.id_producto=producto.id_producto\n"
                    + "AND detalle_venta.id_venta=venta.id_venta\n"
                    + "AND venta.fecha_venta BETWEEN '" + fecha1 + "' AND '" + fecha2 + "'\n"
                    + "AND producto.id_producto = " + codigo_producto + "");

            while (r.next()) {
                Object bien[] = {r.getString("fecha_venta"), r.getString("descripcion_producto"), r.getString("unidades_vendidas")};
                modelokardexSalida.addRow(bien);
            }
            txtMostrarSalidas.setText(Integer.toString(totalSalida()));
        } catch (Exception ex) {
            System.out.println("Error, no se ha podido cargar SQL Server JDBC Driversalida");
        }
        int num1, num2, resta;
        num1 = Integer.parseInt(this.txtMostrarEntradas.getText());
        num2 = Integer.parseInt(this.txtMostrarSalidas.getText());
        resta = num1 - num2;
        txtSaldo.setText(String.valueOf(resta));

    }//GEN-LAST:event_btnConsultarActionPerformed

    private void PRINT_ENTRADAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRINT_ENTRADAActionPerformed
        
        String fecha_entrada;
        String descripcion_entrada;
        String cantidad;
        String total;
        
     
      List lista = new ArrayList();
        
        for (int i = 0; i < grdEntradas.getRowCount(); i++) {
            fecha_entrada= (String) modelokardexEntrada.getValueAt(i, 0);
            descripcion_entrada = (String) modelokardexEntrada.getValueAt(i, 1);
            cantidad = (String) modelokardexEntrada.getValueAt(i, 2);
            
          total= txtMostrarEntradas.getText();
            R_PepsEntrada a =new R_PepsEntrada(fecha_entrada,descripcion_entrada,cantidad,total);
          
            lista.add(a);
        }
      

        try {

            String dirRep = "C:\\Users\\Juan\\Desktop\\PROYECTO\\WILI\\src\\Reportes\\R_PepsEntrada.jasper";
            JasperReport jr = null;

            jr = (JasperReport) JRLoader.loadObjectFromFile((dirRep));
            String nombre_provincia1="";
            //pasamos parametros a nuestro reporte
            Map parametros = new HashMap<String, Object>();
            parametros.put("nombre_provincia", nombre_provincia1);
            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, new JRBeanCollectionDataSource(lista));

            JasperViewer jv = new JasperViewer(jp);
             jv.setTitle("REPORTE ENTRADA DE UN PRODUCTO");
             jv.setSize(700, 800);
             jv.setLocation(0, 0);
            jv.show();

        } catch (JRException ex) {
            ex.printStackTrace();
        }
        
        
        
    }//GEN-LAST:event_PRINT_ENTRADAActionPerformed

    private void PRINT_SALIDAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRINT_SALIDAActionPerformed
        
        String fecha_salida;
        String descripcion_salida;
        String cantidad_salida;
        String total_s;
        String existencia;
     
      List lista = new ArrayList();
        
       
       for(int e=0;e<grdSalidas.getRowCount();e++){
             fecha_salida  = (String) modelokardexSalida.getValueAt(e, 0);
            descripcion_salida = (String) modelokardexSalida.getValueAt(e, 1);
            cantidad_salida = (String) modelokardexSalida.getValueAt(e, 2);
            total_s= txtMostrarSalidas.getText();
            existencia=txtSaldo.getText();
            R_PepsSalida a=new R_PepsSalida (fecha_salida,descripcion_salida,cantidad_salida,total_s,existencia);
            lista.add(a);
             }

        try {

            String dirRep = "C:\\Users\\Juan\\Desktop\\PROYECTO\\WILI\\src\\Reportes\\R_PepsSalida.jasper";
            JasperReport jr = null;

            jr = (JasperReport) JRLoader.loadObjectFromFile((dirRep));
            String nombre_provincia1="";
            //pasamos parametros a nuestro reporte
            Map parametros = new HashMap<String, Object>();
            parametros.put("nombre_provincia", nombre_provincia1);
            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, new JRBeanCollectionDataSource(lista));

            JasperViewer jv = new JasperViewer(jp);
            jv.setTitle("REPORTE SALIDA DE UN PRODUCTO");
            jv.setSize(700, 800);
            jv.setLocation(680,1/2);
            jv.show();

        } catch (JRException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_PRINT_SALIDAActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton PRINT_ENTRADA;
    private javax.swing.JButton PRINT_SALIDA;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JTable grdEntradas;
    private javax.swing.JTable grdSalidas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JDateChooser txtInferior;
    private javax.swing.JTextField txtMostrarEntradas;
    private javax.swing.JTextField txtMostrarSalidas;
    private javax.swing.JTextField txtSaldo;
    private com.toedter.calendar.JDateChooser txtSuperior;
    // End of variables declaration//GEN-END:variables

    class FondoPanel extends JPanel {

        private Image imagen;

        @Override
        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("/imagenes/fondoconsulta.jpg")).getImage();

            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);

            setOpaque(false);

            super.paint(g);
        }
    }

}
