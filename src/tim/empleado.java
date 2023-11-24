package tim;

import Classes.Conexion;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class empleado extends javax.swing.JInternalFrame {

    public DefaultTableModel modeloempleado;
    FondoPanel fondo = new FondoPanel();
    public empleado() {
        this.setContentPane(fondo);
        initComponents();
        this.getContentPane().setBackground(getBackground());
        int a = ventanaprincipal.Escritorio.getWidth() - this.getWidth();
        int b = ventanaprincipal.Escritorio.getHeight() - this.getHeight();
        setLocation(a / 2, b / 2);

        String[] columnaNombre = {"ID", "APELLIDO", "NOMBRE", "DNI", "GENERO", "EDAD", "CELULAR", "EMAIL"};
        String[][] dato = {};
        modeloempleado = new DefaultTableModel(dato, columnaNombre);
        grdEmpleados.setModel(modeloempleado);
        TableColumnModel columnModel = grdEmpleados.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(20);
        columnModel.getColumn(1).setPreferredWidth(100);
        columnModel.getColumn(2).setPreferredWidth(60);
        columnModel.getColumn(3).setPreferredWidth(50);
        columnModel.getColumn(4).setPreferredWidth(50);
        columnModel.getColumn(5).setPreferredWidth(10);
        columnModel.getColumn(6).setPreferredWidth(50);
        columnModel.getColumn(7).setPreferredWidth(200);

        cargarEmpleados();

    }

    public void cargarEmpleados() {
        Conexion cn1 = new Conexion();
        Connection cn = cn1.conexion();

        try {

            Statement s = cn.createStatement();
            ResultSet r = s.executeQuery("SELECT * FROM empleado");

            while (r.next()) {
                Object bien[] = {r.getString("id_empleado"), r.getString("apellido_empleado"), r.getString("nombre_empleado"), r.getString("dni_empleado"), r.getString("genero_empleado"), r.getString("edad_empleado"), r.getString("celular_empleado"), r.getString("email_empleado")};
                modeloempleado.addRow(bien);
            }

        } catch (Exception ex) {
            System.out.println("Error, no se ha podido cargar SQL Server JDBC Driver");
        }

    }

    public void buscarEmpleado(String texto) {

        String[] columnaNombre = {"ID", "APELLIDO", "NOMBRE", "DNI", "GENERO", "EDAD", "CELULAR", "EMAIL"};
        String[][] dato = {};
        modeloempleado = new DefaultTableModel(dato, columnaNombre);
        grdEmpleados.setModel(modeloempleado);

        Conexion cn1 = new Conexion();
        Connection cn = cn1.conexion();

        try {

            Statement s = cn.createStatement();
            String bandera = cmbFiltroEmpleado.getSelectedItem().toString();
            String consulta = "";
            if (bandera == "ID") {
                consulta = "select * from empleado where id_empleado LIKE '" + texto + "%'";
            } else if (bandera == "APELLIDO") {
                consulta = "select * from empleado where apellido_empleado LIKE '" + texto + "%'";
            } else if (bandera == "DNI") {
                consulta = "select * from empleado where dni_empleado LIKE '" + texto + "%'";
            } else {
                JOptionPane.showMessageDialog(null, "Selecione un ítem para filtrar");
            }
            ResultSet r = s.executeQuery(consulta);

            while (r.next()) {
                Object bien[] = {r.getString("id_empleado"), r.getString("apellido_empleado"), r.getString("nombre_empleado"), r.getString("dni_empleado"), r.getString("genero_empleado"), r.getString("edad_empleado"), r.getString("celular_empleado"), r.getString("email_empleado")};
                modeloempleado.addRow(bien);
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
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtApellidosEmpleado = new javax.swing.JTextField();
        txtNombreEmpleado = new javax.swing.JTextField();
        txtdniEmpleado = new javax.swing.JTextField();
        txtGeneroEmpleado = new javax.swing.JTextField();
        txtEdadEmpleado = new javax.swing.JTextField();
        txtCelularEmpleado = new javax.swing.JTextField();
        txtEmailEmpleado = new javax.swing.JTextField();
        btnModificarEmpleado = new javax.swing.JButton();
        btnEliminarEmpleado = new javax.swing.JButton();
        btnRegistrarEmpleado = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        grdEmpleados = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cmbFiltroEmpleado = new javax.swing.JComboBox<>();
        txtFiltroEmpleado = new javax.swing.JTextField();

        setBackground(new java.awt.Color(0, 153, 255));
        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Empleados");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("APELLIDOS");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("NOMBRE");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("DNI");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("GENERO");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("EDAD");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("CELULAR");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("EMAIL");

        txtApellidosEmpleado.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                txtApellidosEmpleadoMouseMoved(evt);
            }
        });
        txtApellidosEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtApellidosEmpleadoMouseExited(evt);
            }
        });
        txtApellidosEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtApellidosEmpleadoKeyPressed(evt);
            }
        });

        txtNombreEmpleado.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                txtNombreEmpleadoMouseMoved(evt);
            }
        });
        txtNombreEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtNombreEmpleadoMouseExited(evt);
            }
        });
        txtNombreEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreEmpleadoKeyPressed(evt);
            }
        });

        txtdniEmpleado.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                txtdniEmpleadoMouseMoved(evt);
            }
        });
        txtdniEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtdniEmpleadoMouseExited(evt);
            }
        });
        txtdniEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtdniEmpleadoKeyPressed(evt);
            }
        });

        txtGeneroEmpleado.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                txtGeneroEmpleadoMouseMoved(evt);
            }
        });
        txtGeneroEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtGeneroEmpleadoMouseExited(evt);
            }
        });
        txtGeneroEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtGeneroEmpleadoKeyPressed(evt);
            }
        });

        txtEdadEmpleado.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                txtEdadEmpleadoMouseMoved(evt);
            }
        });
        txtEdadEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtEdadEmpleadoMouseExited(evt);
            }
        });
        txtEdadEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEdadEmpleadoKeyPressed(evt);
            }
        });

        txtCelularEmpleado.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                txtCelularEmpleadoMouseMoved(evt);
            }
        });
        txtCelularEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtCelularEmpleadoMouseExited(evt);
            }
        });
        txtCelularEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCelularEmpleadoKeyPressed(evt);
            }
        });

        txtEmailEmpleado.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                txtEmailEmpleadoMouseMoved(evt);
            }
        });
        txtEmailEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtEmailEmpleadoMouseExited(evt);
            }
        });
        txtEmailEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmailEmpleadoKeyPressed(evt);
            }
        });

        btnModificarEmpleado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnModificarEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/modificar.png"))); // NOI18N
        btnModificarEmpleado.setText("Modificar");
        btnModificarEmpleado.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnModificarEmpleadoMouseMoved(evt);
            }
        });
        btnModificarEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnModificarEmpleadoMouseExited(evt);
            }
        });
        btnModificarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarEmpleadoActionPerformed(evt);
            }
        });

        btnEliminarEmpleado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEliminarEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminarcliente.png"))); // NOI18N
        btnEliminarEmpleado.setText("Eliminar");
        btnEliminarEmpleado.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnEliminarEmpleadoMouseMoved(evt);
            }
        });
        btnEliminarEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminarEmpleadoMouseExited(evt);
            }
        });
        btnEliminarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarEmpleadoActionPerformed(evt);
            }
        });

        btnRegistrarEmpleado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRegistrarEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agregarcliente.png"))); // NOI18N
        btnRegistrarEmpleado.setText("Registrar");
        btnRegistrarEmpleado.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnRegistrarEmpleadoMouseMoved(evt);
            }
        });
        btnRegistrarEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegistrarEmpleadoMouseExited(evt);
            }
        });
        btnRegistrarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarEmpleadoActionPerformed(evt);
            }
        });

        grdEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "APELLIDO", "NOMBRE", "DNI", "GENERO", "EDAD", "CELULAR", "EMAIL"
            }
        ));
        grdEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grdEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(grdEmpleados);

        jLabel1.setText("Filtrar por:");

        cmbFiltroEmpleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Selecionar>", "ID", "APELLIDO", "DNI" }));

        txtFiltroEmpleado.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                txtFiltroEmpleadoMouseMoved(evt);
            }
        });
        txtFiltroEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtFiltroEmpleadoMouseExited(evt);
            }
        });
        txtFiltroEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFiltroEmpleadoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltroEmpleadoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(btnRegistrarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100, 100, 100)
                                .addComponent(btnModificarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                                .addComponent(btnEliminarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(cmbFiltroEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFiltroEmpleado))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCelularEmpleado, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtEdadEmpleado, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtGeneroEmpleado, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtdniEmpleado, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNombreEmpleado, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtApellidosEmpleado, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtEmailEmpleado))))
                .addGap(65, 65, 65))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbFiltroEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFiltroEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtApellidosEmpleado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombreEmpleado))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtdniEmpleado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtGeneroEmpleado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtEdadEmpleado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCelularEmpleado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtEmailEmpleado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificarEmpleado)
                    .addComponent(btnEliminarEmpleado)
                    .addComponent(btnRegistrarEmpleado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarEmpleadoActionPerformed
        // TODO add your handling code here:
        int fila = grdEmpleados.getSelectedRow();
        if (fila >= 0) {
            int valor = JOptionPane.showConfirmDialog(null, "Está seguro de eliminar el registro?", "Advertencia", JOptionPane.YES_NO_OPTION);
            if (valor == JOptionPane.YES_OPTION) {
                String cod = "";
                cod = grdEmpleados.getValueAt(fila, 0).toString();
                Conexion cn1 = new Conexion();
                Connection cn = cn1.conexion();

                try {

                    Statement s = cn.createStatement();

                    String cadSQL = "DELETE FROM empleado WHERE id_empleado=" + cod + "";
                    s.execute(cadSQL);

                } catch (Exception ex) {
                    System.out.println("Error, no se ha podido cargar SQL Server JDBC Driver");
                }
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "No se borró el registro");
            }

        } else {
            JOptionPane.showMessageDialog(null, "NO SELECCIONO NINGUNA FILA, SELECCIONE UNO!!");
        }
    }//GEN-LAST:event_btnEliminarEmpleadoActionPerformed

    private void txtFiltroEmpleadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroEmpleadoKeyReleased
        // TODO add your handling code here:
        String buscar = txtFiltroEmpleado.getText();
        buscarEmpleado(buscar);
    }//GEN-LAST:event_txtFiltroEmpleadoKeyReleased

    private void btnRegistrarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarEmpleadoActionPerformed
        // TODO add your handling code here:
        Conexion cn1 = new Conexion();
        Connection cn = cn1.conexion();
        try {
            Statement s = cn.createStatement();
            //se saca el siguiente codigo de empleado
            ResultSet r = s.executeQuery("select max(id_empleado)+1 as codigo from empleado");
            r.next();
            String c = r.getString("codigo");

            // se genera la cadena SQL para insertar un nuevo registro 
            // a la tabla provincia
            String cadSQL = "insert into empleado(id_empleado,apellido_empleado,nombre_empleado,dni_empleado,genero_empleado,edad_empleado,celular_empleado,email_empleado) values(" + c + ",'" + txtApellidosEmpleado.getText() + "','" + txtNombreEmpleado.getText() + "'," + txtdniEmpleado.getText() + ",'" + txtGeneroEmpleado.getText() + "'," + txtEdadEmpleado.getText() + "," + txtCelularEmpleado.getText() + ",'" + txtEmailEmpleado.getText() + "')";

            //se ejecuta la sentencia SQL 
            s.execute(cadSQL);
            JOptionPane.showMessageDialog(null, "Registro guardado");

        } catch (Exception ex) {
            System.out.println("Error, no se ha podido cargar SQL Server JDBC Driver");
            JOptionPane.showMessageDialog(null, "Error, no se ha podido cargar SQL Server JDBC Driver");
        }
    }//GEN-LAST:event_btnRegistrarEmpleadoActionPerformed

    private void btnModificarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarEmpleadoActionPerformed
        // TODO add your handling code here:
        int fila = grdEmpleados.getSelectedRow();
        if (fila >= 0) {
            String cod = "";
            cod = grdEmpleados.getValueAt(fila, 0).toString();

            Conexion cn1 = new Conexion();
            Connection cn = cn1.conexion();

            try {

                Statement s = cn.createStatement();

                // a la tabla provincia
                String cadSQL = "UPDATE empleado SET apellido_empleado='" + txtApellidosEmpleado.getText() + "',nombre_empleado='" + txtNombreEmpleado.getText() + "',dni_empleado=" + txtdniEmpleado.getText() + ",genero_empleado='" + txtGeneroEmpleado.getText() + "',edad_empleado=" + txtEdadEmpleado.getText() + ",celular_empleado=" + txtCelularEmpleado.getText() + ",email_empleado='" + txtEmailEmpleado.getText() + "' where id_empleado=" + cod + "";
                System.out.println(cod);
                //se ejecuta la sentencia SQL

                s.execute(cadSQL);
                JOptionPane.showMessageDialog(null, "Registro guardado");

            } catch (Exception ex) {
                System.out.println("Error, no se ha podido cargar SQL Server JDBC Driver");
                JOptionPane.showMessageDialog(null, "Error, no se ha podido cargar SQL Server JDBC Driver");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }
    }//GEN-LAST:event_btnModificarEmpleadoActionPerformed

    private void grdEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grdEmpleadosMouseClicked
        // TODO add your handling code here:
        int fila = grdEmpleados.getSelectedRow();
        if (fila >= 0) {

            txtApellidosEmpleado.setText(grdEmpleados.getValueAt(fila, 1).toString());
            txtNombreEmpleado.setText(grdEmpleados.getValueAt(fila, 2).toString());
            txtdniEmpleado.setText(grdEmpleados.getValueAt(fila, 3).toString());
            txtGeneroEmpleado.setText(grdEmpleados.getValueAt(fila, 4).toString());
            txtEdadEmpleado.setText(grdEmpleados.getValueAt(fila, 5).toString());
            txtCelularEmpleado.setText(grdEmpleados.getValueAt(fila, 6).toString());
            txtEmailEmpleado.setText(grdEmpleados.getValueAt(fila, 7).toString());

        } else {
            JOptionPane.showMessageDialog(null, "NO SELECCIONO NINGUNA FILA, SELECCIONE UNO!!");
        }
    }//GEN-LAST:event_grdEmpleadosMouseClicked

    private void btnRegistrarEmpleadoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarEmpleadoMouseExited
        
         btnRegistrarEmpleado.setBackground(Color.GRAY);
         
    }//GEN-LAST:event_btnRegistrarEmpleadoMouseExited

    private void btnRegistrarEmpleadoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarEmpleadoMouseMoved
        btnRegistrarEmpleado.setBackground(Color.CYAN);
    }//GEN-LAST:event_btnRegistrarEmpleadoMouseMoved

    private void btnModificarEmpleadoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarEmpleadoMouseExited
        btnModificarEmpleado.setBackground(Color.GRAY);
    }//GEN-LAST:event_btnModificarEmpleadoMouseExited

    private void btnModificarEmpleadoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarEmpleadoMouseMoved
        btnModificarEmpleado.setBackground(Color.CYAN);
    }//GEN-LAST:event_btnModificarEmpleadoMouseMoved

    private void btnEliminarEmpleadoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarEmpleadoMouseExited
      btnEliminarEmpleado.setBackground(Color.GRAY);
    }//GEN-LAST:event_btnEliminarEmpleadoMouseExited

    private void btnEliminarEmpleadoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarEmpleadoMouseMoved
       btnEliminarEmpleado.setBackground(Color.CYAN);
    }//GEN-LAST:event_btnEliminarEmpleadoMouseMoved

    private void txtFiltroEmpleadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroEmpleadoKeyPressed
          txtFiltroEmpleado.setBackground(Color.CYAN);
    }//GEN-LAST:event_txtFiltroEmpleadoKeyPressed

    private void txtFiltroEmpleadoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFiltroEmpleadoMouseMoved
          txtFiltroEmpleado.setBackground(Color.CYAN);
    }//GEN-LAST:event_txtFiltroEmpleadoMouseMoved

    private void txtFiltroEmpleadoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFiltroEmpleadoMouseExited
          txtFiltroEmpleado.setBackground(Color.WHITE);
    }//GEN-LAST:event_txtFiltroEmpleadoMouseExited

    private void txtApellidosEmpleadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosEmpleadoKeyPressed
       txtApellidosEmpleado.setBackground(Color.CYAN);
    }//GEN-LAST:event_txtApellidosEmpleadoKeyPressed

    private void txtApellidosEmpleadoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtApellidosEmpleadoMouseMoved
       txtApellidosEmpleado.setBackground(Color.CYAN);
    }//GEN-LAST:event_txtApellidosEmpleadoMouseMoved

    private void txtApellidosEmpleadoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtApellidosEmpleadoMouseExited
       txtApellidosEmpleado.setBackground(Color.WHITE);
    }//GEN-LAST:event_txtApellidosEmpleadoMouseExited

    private void txtNombreEmpleadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreEmpleadoKeyPressed
       txtNombreEmpleado.setBackground(Color.CYAN);
    }//GEN-LAST:event_txtNombreEmpleadoKeyPressed

    private void txtNombreEmpleadoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreEmpleadoMouseMoved
       txtNombreEmpleado.setBackground(Color.CYAN);
    }//GEN-LAST:event_txtNombreEmpleadoMouseMoved

    private void txtNombreEmpleadoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreEmpleadoMouseExited
       txtNombreEmpleado.setBackground(Color.WHITE);
    }//GEN-LAST:event_txtNombreEmpleadoMouseExited

    private void txtdniEmpleadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdniEmpleadoKeyPressed
      txtdniEmpleado.setBackground(Color.CYAN);
    }//GEN-LAST:event_txtdniEmpleadoKeyPressed

    private void txtdniEmpleadoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtdniEmpleadoMouseMoved
       txtdniEmpleado.setBackground(Color.CYAN);
    }//GEN-LAST:event_txtdniEmpleadoMouseMoved

    private void txtdniEmpleadoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtdniEmpleadoMouseExited
       txtdniEmpleado.setBackground(Color.WHITE);
    }//GEN-LAST:event_txtdniEmpleadoMouseExited

    private void txtGeneroEmpleadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGeneroEmpleadoKeyPressed
       txtGeneroEmpleado.setBackground(Color.CYAN);
    }//GEN-LAST:event_txtGeneroEmpleadoKeyPressed

    private void txtGeneroEmpleadoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtGeneroEmpleadoMouseMoved
        txtGeneroEmpleado.setBackground(Color.CYAN);
    }//GEN-LAST:event_txtGeneroEmpleadoMouseMoved

    private void txtGeneroEmpleadoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtGeneroEmpleadoMouseExited
        txtGeneroEmpleado.setBackground(Color.WHITE);
    }//GEN-LAST:event_txtGeneroEmpleadoMouseExited

    private void txtEdadEmpleadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEdadEmpleadoKeyPressed
        txtEdadEmpleado.setBackground(Color.CYAN);
    }//GEN-LAST:event_txtEdadEmpleadoKeyPressed

    private void txtEdadEmpleadoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEdadEmpleadoMouseMoved
        txtEdadEmpleado.setBackground(Color.CYAN);
    }//GEN-LAST:event_txtEdadEmpleadoMouseMoved

    private void txtEdadEmpleadoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEdadEmpleadoMouseExited
        txtEdadEmpleado.setBackground(Color.WHITE);
    }//GEN-LAST:event_txtEdadEmpleadoMouseExited

    private void txtCelularEmpleadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCelularEmpleadoKeyPressed
       txtCelularEmpleado.setBackground(Color.CYAN);
    }//GEN-LAST:event_txtCelularEmpleadoKeyPressed

    private void txtCelularEmpleadoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCelularEmpleadoMouseMoved
        txtCelularEmpleado.setBackground(Color.CYAN);
    }//GEN-LAST:event_txtCelularEmpleadoMouseMoved

    private void txtCelularEmpleadoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCelularEmpleadoMouseExited
       txtCelularEmpleado.setBackground(Color.WHITE);
    }//GEN-LAST:event_txtCelularEmpleadoMouseExited

    private void txtEmailEmpleadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailEmpleadoKeyPressed
       txtEmailEmpleado.setBackground(Color.CYAN);
    }//GEN-LAST:event_txtEmailEmpleadoKeyPressed

    private void txtEmailEmpleadoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEmailEmpleadoMouseMoved
       txtEmailEmpleado.setBackground(Color.CYAN);
    }//GEN-LAST:event_txtEmailEmpleadoMouseMoved

    private void txtEmailEmpleadoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEmailEmpleadoMouseExited
       txtEmailEmpleado.setBackground(Color.WHITE);
    }//GEN-LAST:event_txtEmailEmpleadoMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminarEmpleado;
    private javax.swing.JButton btnModificarEmpleado;
    private javax.swing.JButton btnRegistrarEmpleado;
    private javax.swing.JComboBox<String> cmbFiltroEmpleado;
    private javax.swing.JTable grdEmpleados;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtApellidosEmpleado;
    private javax.swing.JTextField txtCelularEmpleado;
    private javax.swing.JTextField txtEdadEmpleado;
    private javax.swing.JTextField txtEmailEmpleado;
    private javax.swing.JTextField txtFiltroEmpleado;
    private javax.swing.JTextField txtGeneroEmpleado;
    private javax.swing.JTextField txtNombreEmpleado;
    private javax.swing.JTextField txtdniEmpleado;
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
