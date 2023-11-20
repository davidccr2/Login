/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package front;



import loginsql.conexion;
import java.sql.*;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;
import java.util.Date;
/**
 *
 * @author DAVID
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    conexion conec=new conexion();
    Connection con=(Connection) conec.conectar(); 
    private int intentosFallidos = 0;
    private static final int MAX_INTENTOS = 3;
    
    public Login() {
        initComponents();
        this.setTitle("INGRESAR");
          this.setLocation(400, 200);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        usuriol = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        pwl = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("USUARIO");

        jLabel3.setText("CONTRASEÑA");

        jButton1.setText("INGRESAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("CANCELAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(28, 28, 28)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(45, 45, 45)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(usuriol, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pwl, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(usuriol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(pwl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
           Front form=new Front();
        form.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        validausr();
  
    }//GEN-LAST:event_jButton1ActionPerformed

    public void validausr(){
        
        int resultado;

         

         String cadena3,cadena4;
        
       
        cadena3 = usuriol.getText();
        cadena4 = pwl.getText().toString();
        String SQL = "select * from usuariobd where usuario='"+cadena3+"' and contraseña='"+cadena4+"' or correo='"+cadena3+"' and contraseña='"+cadena4+"' ";
        
         try{

                Statement st = con.createStatement(); 
                ResultSet rs = st.executeQuery(SQL);
                 
            
                if (rs.next()){
                    resultado=1;
                    if (resultado==1) {
                        Sistema form=new Sistema();
                        form.setVisible(true);
                        this.dispose();
                    }
                }else{
                     JOptionPane.showMessageDialog(null, "Error usuario o contraseña incorrecta");
                     intentosFallidos++;
                System.out.println("Intentos fallidos: " + intentosFallidos);

                if (intentosFallidos >= MAX_INTENTOS) {
                    JOptionPane.showMessageDialog(null, "Demasiados intentos fallidos. Bloqueando el acceso." + new Date());
                    JOptionPane.showMessageDialog(null, "Se desbloquea en 15s." + new Date());
                    jButton1.setEnabled(false);
                    bloqueo();
                }
                
                } 
                 
                 
        }catch (Exception e){
            JOptionPane.showInputDialog("Error de login" + e.getMessage());
            
            
             System.out.println("Error de login" + e.getMessage());
        }
        

}
    
    public void bloqueo(){ 
        
        Timer timer = new Timer();
        TimerTask tarea = new TimerTask(){
            @Override
            public void run() {
                System.out.println("se desbloqueo el usuario en " + new Date());
                JOptionPane.showMessageDialog(null, "se desbloqueo el usuario en " + new Date());
                jButton1.setEnabled(true);
            }
            
            
        };
        timer.schedule(tarea, 15000);
    }
    
    
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    
     


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField pwl;
    private javax.swing.JTextField usuriol;
    // End of variables declaration//GEN-END:variables
}
