package jogo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import jdk.nashorn.internal.runtime.JSType;

public class telaGameOver extends javax.swing.JFrame {
    int salvamento = 0;
    long contHistoria;
    
    private void lerSalvamento() {
        try{ 
            FileInputStream arquivo = new FileInputStream("backup\\Salvamento.txt");
            InputStreamReader leitor = new InputStreamReader(arquivo);
            BufferedReader buffer = new BufferedReader(leitor);
            
            String linha;
            
            do{
                linha = buffer.readLine();
                
                if(linha != null){
                    
                    String[] palavras = linha.split(" ; ");
                    for(int i = 0; i < palavras.length; i++){
                         
                        contHistoria = JSType.toLong(palavras[53]); 
                    }
                    
                    
                }
            }while(linha != null);
            arquivo.close();
        }catch(Exception e){
            System.err.printf("|lerHistoria| Erro na abertura do arquivo: %s.\n",
            e.getMessage());
        }
            
    }
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
     
    public telaGameOver() {
        initComponents();
        setLocationRelativeTo(null);
        lerSalvamento();
        if(contHistoria == 50011111){
            info.setText("Infelizmente o Rei Goblin lhe matou ! :( ");
        }
        
        escritorSalvamentoGlobal();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        botaoSair = new javax.swing.JButton();
        botaoRecomecar = new javax.swing.JButton();
        info = new javax.swing.JLabel();
        gameOver = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(720, 360));
        setUndecorated(true);

        jPanel1.setMaximumSize(new java.awt.Dimension(720, 360));
        jPanel1.setMinimumSize(new java.awt.Dimension(720, 360));
        jPanel1.setPreferredSize(new java.awt.Dimension(720, 360));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botaoSair.setFont(new java.awt.Font("Dubai Medium", 0, 20)); // NOI18N
        botaoSair.setText("Sair");
        botaoSair.setBorderPainted(false);
        botaoSair.setContentAreaFilled(false);
        botaoSair.setFocusable(false);
        botaoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSairActionPerformed(evt);
            }
        });
        jPanel1.add(botaoSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 280, 117, -1));

        botaoRecomecar.setFont(new java.awt.Font("Dubai Medium", 0, 20)); // NOI18N
        botaoRecomecar.setText("Recomeçar");
        botaoRecomecar.setBorderPainted(false);
        botaoRecomecar.setContentAreaFilled(false);
        botaoRecomecar.setFocusable(false);
        botaoRecomecar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRecomecarActionPerformed(evt);
            }
        });
        jPanel1.add(botaoRecomecar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 160, -1));

        info.setFont(new java.awt.Font("Ink Free", 0, 18)); // NOI18N
        info.setForeground(new java.awt.Color(60, 60, 60));
        info.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(info, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 670, 30));

        gameOver.setFont(new java.awt.Font("Freshman", 1, 70)); // NOI18N
        gameOver.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gameOver.setText("Game Over");
        jPanel1.add(gameOver, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 500, 130));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSairActionPerformed
         System.exit(0);
    }//GEN-LAST:event_botaoSairActionPerformed

    private void botaoRecomecarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRecomecarActionPerformed
        this.dispose();
        new telaInicio().setVisible(true);
    }//GEN-LAST:event_botaoRecomecarActionPerformed

    
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(telaGameOver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaGameOver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaGameOver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaGameOver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaGameOver().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoRecomecar;
    private javax.swing.JButton botaoSair;
    private javax.swing.JLabel gameOver;
    private javax.swing.JLabel info;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
