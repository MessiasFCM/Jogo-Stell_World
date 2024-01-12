package jogo;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class telaCarregamento extends javax.swing.JFrame {
    
    Thread carregamento = new Thread();
    Thread msg = new Thread();
    String msg1= "Dica: use os pontos de status com sabedoria";
    
    private void fim(){
        this.dispose();
    }
    
    private void carregar(){
        carregamento = new Thread(){
            
            public void run(){
                for(int cont = 0; cont<101; cont++){
                    try {
                        barra.setValue(cont);
                        carregamento.sleep(50);
                        if(cont == 100){
                            new telaHistoria().setVisible(true); 
                            fim();
                        }
                    } catch (InterruptedException ex) {
                        Logger.getLogger(telaCarregamento.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        carregamento.start();
        exibirMsg();
    }
    
    private void exibirMsg(){
        msg = new Thread(){
            
            public void run(){
        
                for(int cont = 0; cont<msg1.length(); cont++){
                    try {
                        exibirMsg.setText(exibirMsg.getText() + msg1.charAt(cont));
                        msg.sleep(50);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(telaCarregamento.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        msg.start();
    }

    public telaCarregamento() {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(telaMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(telaMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(telaMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(telaMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        initComponents();
        setLocationRelativeTo(null);
        
        carregar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        barra = new javax.swing.JProgressBar();
        exibirMsg = new javax.swing.JLabel();
        fundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setUndecorated(true);
        setSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        barra.setBackground(new java.awt.Color(204, 204, 204));
        barra.setForeground(new java.awt.Color(135, 135, 135));
        barra.setBorder(null);
        barra.setBorderPainted(false);
        barra.setFocusable(false);
        barra.setRequestFocusEnabled(false);
        jPanel1.add(barra, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 670, 1190, 20));

        exibirMsg.setFont(new java.awt.Font("Dubai Medium", 0, 22)); // NOI18N
        exibirMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(exibirMsg, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 580, 1120, 30));

        fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundoCarregamento.png"))); // NOI18N
        jPanel1.add(fundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(telaCarregamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaCarregamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaCarregamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaCarregamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaCarregamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barra;
    private javax.swing.JLabel exibirMsg;
    private javax.swing.JLabel fundo;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private void isOpaque(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
