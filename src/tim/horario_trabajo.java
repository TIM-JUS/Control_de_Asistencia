package tim;

import Classes.Conexion;
import Classes.Empleado;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class horario_trabajo extends javax.swing.JInternalFrame {

    public DefaultTableModel modelohorario;
    DefaultComboBoxModel modeloEmpleado = new DefaultComboBoxModel();
    FondoPanel fondo = new FondoPanel();
    public horario_trabajo() {
        this.setContentPane(fondo);
        initComponents();
        this.getContentPane().setBackground(getBackground());
        int a = ventanaprincipal.Escritorio.getWidth() - this.getWidth();
        int b = ventanaprincipal.Escritorio.getHeight() - this.getHeight();
        setLocation(a / 2, b / 2);

        String[] columnaNombre = {"ID", "APELLIDO EMPLEADO", "ENTRADA", "SALIDA", "FECHA", "CODE"};
        String[][] dato = {};
        modelohorario = new DefaultTableModel(dato, columnaNombre);
        grdHorarioTrabajo.setModel(modelohorario);
        TableColumnModel columnModel = grdHorarioTrabajo.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(20);
        columnModel.getColumn(1).setPreferredWidth(200);
        columnModel.getColumn(2).setPreferredWidth(60);
        columnModel.getColumn(3).setPreferredWidth(50);
        columnModel.getColumn(4).setPreferredWidth(50);
        grdHorarioTrabajo.getColumn(grdHorarioTrabajo.getColumnName(5)).setWidth(0);
        grdHorarioTrabajo.getColumn(grdHorarioTrabajo.getColumnName(5)).setMinWidth(0);
        grdHorarioTrabajo.getColumn(grdHorarioTrabajo.getColumnName(5)).setMaxWidth(0);

        cmbApellidoEmpleado_id.setModel(modeloEmpleado);
        cargarHorario();
        cargarcomboEmpleado();

    }

    public void cargarHorario() {

        Conexion cn1 = new Conexion();
        Connection cn = cn1.conexion();

        try {

            Statement s = cn.createStatement();
            ResultSet r = s.executeQuery("SELECT horario_trabajo.id_horario,CONCAT(empleado.apellido_empleado,', ',empleado.nombre_empleado) empleado,horario_trabajo.entrada,horario_trabajo.salida,horario_trabajo.fecha,empleado.id_empleado\n"
                    + "FROM horario_trabajo,empleado\n"
                    + "WHERE horario_trabajo.id_empleado=empleado.id_empleado");

            while (r.next()) {
                Object bien[] = {r.getString("id_horario"), r.getString("empleado"), r.getString("entrada"), r.getString("salida"), r.getString("fecha"), r.getString("id_empleado")};
                modelohorario.addRow(bien);
            }

        } catch (Exception ex) {
            System.out.println("Error, no se ha podido cargar SQL Server JDBC Driver");
        }

    }

    public void cargarcomboEmpleado() {

        Conexion cn1 = new Conexion();
        Connection cn = cn1.conexion();

        try {

            Statement s = cn.createStatement();
            ResultSet r = s.executeQuery(" select id_empleado,CONCAT(empleado.apellido_empleado,', ',empleado.nombre_empleado) empleado from empleado order by apellido_empleado");

            while (r.next()) {
                Empleado P = new Empleado(r.getString("id_empleado"), r.getString("empleado"));
                modeloEmpleado.addElement(P);
            }

        } catch (Exception ex) {
            System.out.println("Error, no se ha podido cargar SQL Server JDBC Driver");
        }

    }

    public void buscarHorarioTrabajo(String texto) {

        String[] columnaNombre = {"ID", "APELLIDO EMPLEADO", "ENTRADA", "SALIDA", "FECHA", "CODE"};
        String[][] dato = {};
        modelohorario = new DefaultTableModel(dato, columnaNombre);
        grdHorarioTrabajo.setModel(modelohorario);

        Conexion cn1 = new Conexion();
        Connection cn = cn1.conexion();

        try {

            Statement s = cn.createStatement();
            String bandera = cmbFiltrarHorario.getSelectedItem().toString();
            String consulta = "";
            if (bandera == "ID") {
                consulta = "SELECT horario_trabajo.id_horario,CONCAT(empleado.apellido_empleado,', ',empleado.nombre_empleado) empleado,horario_trabajo.entrada,horario_trabajo.salida,horario_trabajo.fecha,empleado.id_empleado\n"
                        + "FROM horario_trabajo,empleado\n"
                        + "WHERE horario_trabajo.id_empleado=empleado.id_empleado AND id_horario LIKE '" + texto + "%'";
            } else if (bandera == "APELLIDO") {
                consulta = "SELECT horario_trabajo.id_horario,CONCAT(empleado.apellido_empleado,', ',empleado.nombre_empleado) empleado,horario_trabajo.entrada,horario_trabajo.salida,horario_trabajo.fecha,empleado.id_empleado\n"
                        + "FROM horario_trabajo,empleado\n"
                        + "WHERE horario_trabajo.id_empleado=empleado.id_empleado AND apellido_empleado LIKE '" + texto + "%'";
            } else {
                JOptionPane.showMessageDialog(null, "Selecione un ítem para filtrar");
            }
            ResultSet r = s.executeQuery(consulta);

            while (r.next()) {
                Object bien[] = {r.getString("id_horario"), r.getString("empleado"), r.getString("entrada"), r.getString("salida"), r.getString("fecha"), r.getString("id_empleado")};
                modelohorario.addRow(bien);
            }

        } catch (Exception ex) {
            System.out.println("Error, no se ha podido cargar SQL Server JDBC Driver");
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtEntrada = new javax.swing.JTextField();
        txtSalida = new javax.swing.JTextField();
        btnRegistrarHorario = new javax.swing.JButton();
        btnEliminarHorario = new javax.swing.JButton();
        btnModificarHorario = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        grdHorarioTrabajo = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        cmbApellidoEmpleado_id = new javax.swing.JComboBox<>();
        jdcFechaHorario = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        cmbFiltrarHorario = new javax.swing.JComboBox<>();
        txtFiltroHorarioTrabajo = new javax.swing.JTextField();

        setBackground(new java.awt.Color(102, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Horario de trabajo");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("ENTRADA");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("SALIDA");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("FECHA");

        txtEntrada.setText("08:00:00");
        txtEntrada.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                txtEntradaMouseMoved(evt);
            }
        });
        txtEntrada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtEntradaMouseExited(evt);
            }
        });
        txtEntrada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEntradaKeyPressed(evt);
            }
        });

        txtSalida.setText("20:00:00");
        txtSalida.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                txtSalidaMouseMoved(evt);
            }
        });
        txtSalida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtSalidaMouseExited(evt);
            }
        });
        txtSalida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSalidaKeyPressed(evt);
            }
        });

        btnRegistrarHorario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRegistrarHorario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agregarcliente.png"))); // NOI18N
        btnRegistrarHorario.setText("Registrar");
        btnRegistrarHorario.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnRegistrarHorarioMouseMoved(evt);
            }
        });
        btnRegistrarHorario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegistrarHorarioMouseExited(evt);
            }
        });
        btnRegistrarHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarHorarioActionPerformed(evt);
            }
        });

        btnEliminarHorario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEliminarHorario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminarcliente.png"))); // NOI18N
        btnEliminarHorario.setText("Eliminar");
        btnEliminarHorario.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnEliminarHorarioMouseMoved(evt);
            }
        });
        btnEliminarHorario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminarHorarioMouseExited(evt);
            }
        });
        btnEliminarHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarHorarioActionPerformed(evt);
            }
        });

        btnModificarHorario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnModificarHorario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/modificar.png"))); // NOI18N
        btnModificarHorario.setText("Modificar");
        btnModificarHorario.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnModificarHorarioMouseMoved(evt);
            }
        });
        btnModificarHorario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnModificarHorarioMouseExited(evt);
            }
        });
        btnModificarHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarHorarioActionPerformed(evt);
            }
        });

        grdHorarioTrabajo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID_HORARIO", "APELLIDO_EMPLEADO", "ENTRADA", "SALIDA", "FECHA"
            }
        ));
        grdHorarioTrabajo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grdHorarioTrabajoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(grdHorarioTrabajo);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("APELLIDO_EMPLEADO");

        jdcFechaHorario.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jdcFechaHorarioMouseMoved(evt);
            }
        });
        jdcFechaHorario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jdcFechaHorarioMouseExited(evt);
            }
        });
        jdcFechaHorario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jdcFechaHorarioKeyPressed(evt);
            }
        });

        jLabel1.setText("Filtrar por:");

        cmbFiltrarHorario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Seleccionar>", "ID", "APELLIDO" }));

        txtFiltroHorarioTrabajo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                txtFiltroHorarioTrabajoMouseMoved(evt);
            }
        });
        txtFiltroHorarioTrabajo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtFiltroHorarioTrabajoMouseExited(evt);
            }
        });
        txtFiltroHorarioTrabajo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFiltroHorarioTrabajoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltroHorarioTrabajoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbFiltrarHorario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtSalida, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtEntrada)
                                            .addComponent(cmbApellidoEmpleado_id, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jdcFechaHorario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtFiltroHorarioTrabajo))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(btnRegistrarHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(131, 131, 131)
                                .addComponent(btnModificarHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEliminarHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(23, 23, 23))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbFiltrarHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFiltroHorarioTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbApellidoEmpleado_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jdcFechaHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnRegistrarHorario)
                        .addComponent(btnEliminarHorario))
                    .addComponent(btnModificarHorario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFiltroHorarioTrabajoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroHorarioTrabajoKeyReleased
        // TODO add your handling code here:
        String buscar = txtFiltroHorarioTrabajo.getText();
        buscarHorarioTrabajo(buscar);
    }//GEN-LAST:event_txtFiltroHorarioTrabajoKeyReleased

    private void btnRegistrarHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarHorarioActionPerformed
        // TODO add your handling code here:
        String fecha;
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        fecha = f.format(jdcFechaHorario.getDate());

        Empleado C = new Empleado("", "");
        C = (Empleado) modeloEmpleado.getSelectedItem();

        Conexion cn1 = new Conexion();
        Connection cn = cn1.conexion();

        try {

            Statement s = cn.createStatement();

            ResultSet r = s.executeQuery("select max(id_horario)+1 as codigo from horario_trabajo");
            r.next();
            String c = r.getString("codigo");

            String cadSQL = "insert into horario_trabajo(id_horario,id_empleado,entrada,salida,fecha) values(" + c + "," + C.getCodigo() + ",'" + txtEntrada.getText() + "','" + txtSalida.getText() + "','" + fecha + "')";
            s.execute(cadSQL);
            // System.out.println(cadSQL);
            JOptionPane.showMessageDialog(null, "Registro Guardado");
        } catch (Exception ex) {
            System.out.println("Error, no se ha podido cargar SQL Server JDBC Driver");
        }
        this.dispose();
    }//GEN-LAST:event_btnRegistrarHorarioActionPerformed

    private void btnModificarHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarHorarioActionPerformed
        // TODO add your handling code here:
        String fecha;
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        fecha = f.format(jdcFechaHorario.getDate());

        Empleado C = new Empleado("", "");
        C = (Empleado) modeloEmpleado.getSelectedItem();

        int fila = grdHorarioTrabajo.getSelectedRow();

        if (fila >= 0) {
            String cod = "";
            cod = grdHorarioTrabajo.getValueAt(fila, 0).toString();

            Conexion cn1 = new Conexion();
            Connection cn = cn1.conexion();
            try {

                Statement s = cn.createStatement();

                String cadSQL = "UPDATE horario_trabajo SET id_empleado=" + C.getCodigo() + ",entrada='" + txtEntrada.getText() + "',salida='" + txtSalida.getText() + "',fecha= '" + fecha + "' WHERE id_horario=" + cod + "";
                System.out.println(cod);

                s.execute(cadSQL);
                JOptionPane.showMessageDialog(null, "Registro Actualizado");

            } catch (Exception ex) {
                System.out.println("Error, no se ha podido cargar SQL Server JDBC Driver");
                JOptionPane.showMessageDialog(null, "Error, no se ha podido cargar SQL Server JDBC Driver");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }
        this.dispose();
    }//GEN-LAST:event_btnModificarHorarioActionPerformed

    private void grdHorarioTrabajoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grdHorarioTrabajoMouseClicked
        // TODO add your handling code here:

        DefaultTableModel model = (DefaultTableModel) grdHorarioTrabajo.getModel();

        int fila = grdHorarioTrabajo.getSelectedRow();
        if (fila >= 0) {
            Conexion cn1 = new Conexion();
            Connection cn = cn1.conexion();
            try {
                Statement s = cn.createStatement();
                ResultSet r = s.executeQuery(" select *,CONCAT(empleado.apellido_empleado,', ',empleado.nombre_empleado) empleado from empleado order by apellido_empleado ");
                int cont = 0;
                int indx = 0;
                //remover
                cmbApellidoEmpleado_id.removeAllItems();
                int i = Integer.parseInt(grdHorarioTrabajo.getValueAt(fila, 5).toString());

                while (r.next()) {
                    Empleado E = new Empleado(r.getString("id_empleado"), r.getString("empleado"));
                    modeloEmpleado.addElement(E);
                    if (r.getInt("id_empleado") == i) {
                        indx = cont;
                    }
                    cont++;

                }
                cmbApellidoEmpleado_id.setSelectedIndex(indx);
            } catch (Exception ex) {
                System.out.println("Error, no se ha podido cargar SQL Server JDBC Driver33");
            }
            Date date;
            try {
                date = new SimpleDateFormat("yyyy-MM-dd").parse((String) model.getValueAt(fila, 4).toString());
                jdcFechaHorario.setDate(date);
            } catch (ParseException ex) {
                Logger.getLogger(horario_trabajo.class.getName()).log(Level.SEVERE, null, ex);
            }

            txtEntrada.setText(grdHorarioTrabajo.getValueAt(fila, 2).toString());
            txtSalida.setText(grdHorarioTrabajo.getValueAt(fila, 3).toString());

        } else {
            JOptionPane.showMessageDialog(null, "NO SELECCIONO NINGUNA FILA, SELECCIONE UNO!!");
        }

    }//GEN-LAST:event_grdHorarioTrabajoMouseClicked

    private void btnEliminarHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarHorarioActionPerformed
        // TODO add your handling code here:
        int fila = grdHorarioTrabajo.getSelectedRow();
        if (fila >= 0) {
            int valor = JOptionPane.showConfirmDialog(null, "Está seguro de eliminar el registro?", "Advertencia", JOptionPane.YES_NO_OPTION);
            if (valor == JOptionPane.YES_OPTION) {
                String cod = "";
                cod = grdHorarioTrabajo.getValueAt(fila, 0).toString();
                Conexion cn1 = new Conexion();
                Connection cn = cn1.conexion();

                try {

                    Statement s = cn.createStatement();

                    String cadSQL = "DELETE FROM horario_trabajo WHERE id_horario=" + cod + "";
                    s.execute(cadSQL);
                    JOptionPane.showMessageDialog(null, "Se borró el registro");
                } catch (Exception ex) {
                    System.out.println("Error, no se ha podido cargar SQL Server JDBC Driver");
                    JOptionPane.showMessageDialog(null, "Error, no se encontró el servidor");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se borró el registro");
            }

        } else {
            JOptionPane.showMessageDialog(null, "NO SELECCIONO NINGUNA FILA, SELECCIONE UNO!!");
        }
    }//GEN-LAST:event_btnEliminarHorarioActionPerformed

    private void btnRegistrarHorarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarHorarioMouseExited
       btnRegistrarHorario.setBackground(Color.GRAY);
    }//GEN-LAST:event_btnRegistrarHorarioMouseExited

    private void btnRegistrarHorarioMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarHorarioMouseMoved
       btnRegistrarHorario.setBackground(Color.CYAN);
    }//GEN-LAST:event_btnRegistrarHorarioMouseMoved

    private void btnModificarHorarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarHorarioMouseExited
        btnModificarHorario.setBackground(Color.GRAY);
    }//GEN-LAST:event_btnModificarHorarioMouseExited

    private void btnModificarHorarioMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarHorarioMouseMoved
       btnModificarHorario.setBackground(Color.CYAN);
    }//GEN-LAST:event_btnModificarHorarioMouseMoved

    private void btnEliminarHorarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarHorarioMouseExited
       btnEliminarHorario.setBackground(Color.GRAY);
    }//GEN-LAST:event_btnEliminarHorarioMouseExited

    private void btnEliminarHorarioMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarHorarioMouseMoved
        btnEliminarHorario.setBackground(Color.CYAN);
    }//GEN-LAST:event_btnEliminarHorarioMouseMoved

    private void txtFiltroHorarioTrabajoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroHorarioTrabajoKeyPressed
        txtFiltroHorarioTrabajo.setBackground(Color.CYAN);
    }//GEN-LAST:event_txtFiltroHorarioTrabajoKeyPressed

    private void txtFiltroHorarioTrabajoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFiltroHorarioTrabajoMouseMoved
        txtFiltroHorarioTrabajo.setBackground(Color.CYAN);
    }//GEN-LAST:event_txtFiltroHorarioTrabajoMouseMoved

    private void txtFiltroHorarioTrabajoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFiltroHorarioTrabajoMouseExited
       txtFiltroHorarioTrabajo.setBackground(Color.WHITE);
    }//GEN-LAST:event_txtFiltroHorarioTrabajoMouseExited

    private void txtEntradaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEntradaKeyPressed
        txtEntrada.setBackground(Color.CYAN);
    }//GEN-LAST:event_txtEntradaKeyPressed

    private void txtEntradaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEntradaMouseMoved
       txtEntrada.setBackground(Color.CYAN);
    }//GEN-LAST:event_txtEntradaMouseMoved

    private void txtEntradaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEntradaMouseExited
        txtEntrada.setBackground(Color.WHITE);
    }//GEN-LAST:event_txtEntradaMouseExited

    private void txtSalidaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSalidaKeyPressed
        txtSalida.setBackground(Color.CYAN);
    }//GEN-LAST:event_txtSalidaKeyPressed

    private void txtSalidaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSalidaMouseMoved
       txtSalida.setBackground(Color.CYAN);
    }//GEN-LAST:event_txtSalidaMouseMoved

    private void txtSalidaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSalidaMouseExited
       txtSalida.setBackground(Color.WHITE);
    }//GEN-LAST:event_txtSalidaMouseExited

    private void jdcFechaHorarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jdcFechaHorarioKeyPressed
        jdcFechaHorario.setBackground(Color.CYAN);
    }//GEN-LAST:event_jdcFechaHorarioKeyPressed

    private void jdcFechaHorarioMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jdcFechaHorarioMouseMoved
       jdcFechaHorario.setBackground(Color.CYAN);
    }//GEN-LAST:event_jdcFechaHorarioMouseMoved

    private void jdcFechaHorarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jdcFechaHorarioMouseExited
        jdcFechaHorario.setBackground(Color.WHITE);
    }//GEN-LAST:event_jdcFechaHorarioMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminarHorario;
    private javax.swing.JButton btnModificarHorario;
    private javax.swing.JButton btnRegistrarHorario;
    private javax.swing.JComboBox<String> cmbApellidoEmpleado_id;
    private javax.swing.JComboBox<String> cmbFiltrarHorario;
    private javax.swing.JTable grdHorarioTrabajo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdcFechaHorario;
    private javax.swing.JTextField txtEntrada;
    private javax.swing.JTextField txtFiltroHorarioTrabajo;
    private javax.swing.JTextField txtSalida;
    // End of variables declaration//GEN-END:variables

    class FondoPanel extends JPanel {

        private Image imagen;

        @Override
        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("/imagenes/fondo.jpg")).getImage();

            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);

            setOpaque(false);

            super.paint(g);
        }
    }

}
