/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package guicontroller;

import java.awt.Component;
import java.util.Map;
import screens.*;

/**
 *
 * @author lynch
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form LoaderFrame
     */
    public MainFrame(String loginStatus) {
        initComponents();
        loadTabs("Driver");
        
//        JPanel tstpan = (JPanel) Screens.Login();
//        swapPanel(Screens.Login());
    }

    public final void loadTabs(String userType){
        if(userType.equals("Driver")){
            DriverScreen driverScreen = new screens.DriverScreen();
            for(Map.Entry<String, Component> entry : driverScreen.getAllPanels().entrySet()){
                panelHolder.add(entry.getKey(), entry.getValue());
            }
            
        }else if(userType.equals("Admin")){
            AdminScreen adminScreen = new screens.AdminScreen();
            
            
        }   
        pack();
        setLocationRelativeTo(null);
    }
    
//    public void (){
//        
//    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelHolder = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Black Hard Sweet Company");
        getContentPane().setLayout(new java.awt.FlowLayout());
        getContentPane().add(panelHolder);

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame("Login").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane panelHolder;
    // End of variables declaration//GEN-END:variables
}