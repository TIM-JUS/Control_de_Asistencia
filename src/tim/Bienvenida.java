package tim;

import Classes.Conexion;
import java.awt.Graphics;
import java.awt.Image;
import static java.lang.Thread.sleep;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Bienvenida extends javax.swing.JFrame {

    FondoPanel fondo = new FondoPanel();
    public Bienvenida() {
        this.setContentPane(fondo);
        initComponents();
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(getBackground());
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/ControlInventario.png")).getImage());

        barra();
        Usuario();

    }

    public void barra() {

        Thread hilo = new Thread() {
            @Override
            public void run() {
                for (int i = 1; i <= 100; i++) {
                    try {
                        sleep(40);
                        jpbarra.setValue(i);
                        if (i == 100) {
                            dispose();
                            ventanaprincipal v = new ventanaprincipal();
                            v.setVisible(true);
                        }
                    } catch (Exception e) {
                    }
                }
            }

        };
        hilo.start();
    }

    ///=========================================
    public void Usuario() {
        int resultado = 0;
        String password = String.valueOf(login.txtPasswordLogin.getPassword());
        String user = login.txtUserLogin.getText();

        Conexion cn1 = new Conexion();
        Connection cn = cn1.conexion();

        try {

            Statement s = cn.createStatement();
            ResultSet r = s.executeQuery("SELECT usuarios.full_name FROM usuarios where user='" + user + "' and password='" + password + "'");
            if (r.next()) {
                resultado = 1;
                String bien = r.getString("full_name");

                txtMostrarUsuario.setText(bien);

            } else {
                JOptionPane.showMessageDialog(null, "Usuario no encontrado, por favor regístrece");
            }
        } catch (Exception ex) {
            System.out.println("Error, no se ha podido cargar SQL Server JDBC Driver");
            JOptionPane.showMessageDialog(null, "Error, Servidor no encontrado");
        }

    }
    ///=========================================

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jpbarra = new javax.swing.JProgressBar();
        txtMostrarUsuario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 153));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("¡BIENVENIDO AL PROGRAMA...!");

        jpbarra.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jpbarra.setForeground(new java.awt.Color(0, 51, 204));
        jpbarra.setStringPainted(true);

        txtMostrarUsuario.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        txtMostrarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        txtMostrarUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)
                    .addComponent(jpbarra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtMostrarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtMostrarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jpbarra, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(149, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Bienvenida.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bienvenida.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bienvenida.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bienvenida.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bienvenida().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JProgressBar jpbarra;
    private javax.swing.JLabel txtMostrarUsuario;
    // End of variables declaration//GEN-END:variables

    class FondoPanel extends JPanel {

        private Image imagen;

        @Override
        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("/imagenes/Bienvenida.gif")).getImage();

            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);

            setOpaque(false);

            super.paint(g);
        }
    }

}
