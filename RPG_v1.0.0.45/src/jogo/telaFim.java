package jogo;

import java.awt.Color;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class telaFim extends javax.swing.JFrame {

    int salvamento;
    
    private void escritorSalvamentoGlobal() {
        try{

        FileOutputStream arq = new FileOutputStream("backup\\SalvamentoGlobal.txt");
        PrintWriter print = new PrintWriter(arq);
        
        print.println(1 + " ; " + salvamento + " ; ");
        print.close();
        arq.close();
        
        }catch(Exception e){
            System.err.printf("|escreverGameOver Erro na abertura do arquivo: %s.\n",
            e.getMessage());
        }
            
    }
    
    public telaFim() {
        
        initComponents();
        setLocationRelativeTo(null);
        
        salvamento = 0;
        escritorSalvamentoGlobal();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelGeral = new javax.swing.JPanel();
        botaoHome = new javax.swing.JButton();
        botaoSair = new javax.swing.JButton();
        fundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setUndecorated(true);
        setSize(new java.awt.Dimension(1280, 720));

        painelGeral.setMaximumSize(new java.awt.Dimension(1280, 720));
        painelGeral.setMinimumSize(new java.awt.Dimension(1280, 720));
        painelGeral.setName(""); // NOI18N
        painelGeral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botaoHome.setFont(new java.awt.Font("Ink Free", 1, 48)); // NOI18N
        botaoHome.setForeground(new java.awt.Color(60, 60, 60));
        botaoHome.setText("Home");
        botaoHome.setBorder(null);
        botaoHome.setBorderPainted(false);
        botaoHome.setContentAreaFilled(false);
        botaoHome.setFocusable(false);
        botaoHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botaoHomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botaoHomeMouseExited(evt);
            }
        });
        botaoHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoHomeActionPerformed(evt);
            }
        });
        painelGeral.add(botaoHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 620, 300, -1));

        botaoSair.setFont(new java.awt.Font("Ink Free", 1, 48)); // NOI18N
        botaoSair.setForeground(new java.awt.Color(60, 60, 60));
        botaoSair.setText("Sair");
        botaoSair.setBorder(null);
        botaoSair.setBorderPainted(false);
        botaoSair.setContentAreaFilled(false);
        botaoSair.setFocusable(false);
        botaoSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botaoSairMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botaoSairMouseExited(evt);
            }
        });
        botaoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSairActionPerformed(evt);
            }
        });
        painelGeral.add(botaoSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(653, 620, 340, -1));

        fundo.setFont(new java.awt.Font("Imprint MT Shadow", 1, 48)); // NOI18N
        fundo.setForeground(new java.awt.Color(150, 150, 150));
        fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundoFinal.png"))); // NOI18N
        fundo.setMaximumSize(new java.awt.Dimension(1280, 720));
        fundo.setMinimumSize(new java.awt.Dimension(1280, 720));
        fundo.setPreferredSize(new java.awt.Dimension(1280, 720));
        painelGeral.add(fundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelGeral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelGeral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_botaoSairActionPerformed

    private void botaoHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoHomeActionPerformed
        new telaInicio().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botaoHomeActionPerformed

    private void botaoHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoHomeMouseEntered
        botaoHome.setForeground(new Color(172,172,172));
    }//GEN-LAST:event_botaoHomeMouseEntered

    private void botaoHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoHomeMouseExited
        botaoHome.setForeground(new Color(60,60,60));
    }//GEN-LAST:event_botaoHomeMouseExited

    private void botaoSairMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoSairMouseEntered
        botaoSair.setForeground(new Color(172,172,172));
    }//GEN-LAST:event_botaoSairMouseEntered

    private void botaoSairMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoSairMouseExited
        botaoSair.setForeground(new Color(60,60,60));
    }//GEN-LAST:event_botaoSairMouseExited

    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(telaFim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaFim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaFim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaFim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaFim().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoHome;
    private javax.swing.JButton botaoSair;
    private javax.swing.JLabel fundo;
    private javax.swing.JPanel painelGeral;
    // End of variables declaration//GEN-END:variables
}
