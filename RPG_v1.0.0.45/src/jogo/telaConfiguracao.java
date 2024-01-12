

package jogo;

// Essa tela foi criada para executar as Configuracoes do Jogo de RPG

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.runtime.JSType;

// Podem aumentar o volume, alterar a tela, jogabilidade, entre outras funcoes
// Feita por Messias Feres e Joao Victor Barbosa

public class telaConfiguracao extends javax.swing.JFrame {
    
    private telaMenu menu;
    private String name;
    String[] habilidades = new String[1];
    String classeEscolhida, local, nome;
    
    int[] pontos = new int[8];
    int[] pontosBackup = new int[8];
    int pontos_adiconais;
    int levelBarra, vidaBarraPersonagem, correcaoVida;
    int levelBarraTotal, vidaBarraTotalPersonagem;
    int dano, levelPersonagem, levelUp;
    int porcentagemVida1,porcentagemVida2;
    int telaFundo, gameOver = 0;
    int vidaBarra, vidaBarraTotal, level, contTravamento;
    int pontosAdicionaisBackup;
    long contHistoria;
    int salvamento, contADM = 0, modoADM;
    
    telaInformacao telaInformacaoChamar;
    
    private void lerSalvamentoGlobal() {
     
        try{ 
            FileInputStream arquivo = new FileInputStream("backup\\SalvamentoGlobal.txt");
            InputStreamReader leitor = new InputStreamReader(arquivo);
            BufferedReader buffer = new BufferedReader(leitor);
            
            String linha;
            
            do{
                linha = buffer.readLine();
                
                if(linha != null){
                    
                    String[] palavras = linha.split(" ; ");
                    for(int i = 0; i < palavras.length; i++){
                        
                        salvamento = JSType.toInteger(palavras[1]);
                    }
                }
            }while(linha != null);
            arquivo.close();
        }catch(Exception e){
            System.err.printf("|lerConfig| Erro na abertura do arquivo: %s.\n",
            e.getMessage());
        }
            
    }
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
                        
                        name = palavras[1];
                        classeEscolhida = palavras[3];
                    
                        pontos[0] = JSType.toInteger(palavras[5]);
                        pontos[1] = JSType.toInteger(palavras[7]);
                        pontos[2] = JSType.toInteger(palavras[9]);
                        pontos[3] = JSType.toInteger(palavras[11]);
                        pontos[4] = JSType.toInteger(palavras[13]);
                        pontos[5] = JSType.toInteger(palavras[15]);
                        pontos[6] = JSType.toInteger(palavras[17]);
                        pontos[7] = JSType.toInteger(palavras[19]);
                        
                        pontosBackup[0] = JSType.toInteger(palavras[21]);
                        pontosBackup[1] = JSType.toInteger(palavras[23]);
                        pontosBackup[2] = JSType.toInteger(palavras[25]);
                        pontosBackup[3] = JSType.toInteger(palavras[27]);
                        pontosBackup[4] = JSType.toInteger(palavras[29]);
                        pontosBackup[5] = JSType.toInteger(palavras[31]);
                        pontosBackup[6] = JSType.toInteger(palavras[33]);
                        pontosBackup[7] = JSType.toInteger(palavras[35]);
                        
                        pontos_adiconais = JSType.toInteger(palavras[37]);
                        
                        levelBarra = JSType.toInteger(palavras[39]);
                        levelBarraTotal = JSType.toInteger(palavras[41]);  
                        vidaBarra = JSType.toInteger(palavras[43]);
                        vidaBarraTotal = JSType.toInteger(palavras[45]); 
                        
                        level = JSType.toInteger(palavras[47]); 
                        levelUp = JSType.toInteger(palavras[49]); 
                        telaFundo = JSType.toInteger(palavras[51]); 
                        contHistoria = JSType.toInteger(palavras[53]); 
                        local = palavras[55];
                        contTravamento = JSType.toInteger(palavras[57]); 
                        pontosAdicionaisBackup = JSType.toInteger(palavras[59]);
                        modoADM = JSType.toInteger(palavras[60]);
                    }
                }
                System.out.println("telaConfigLer" + "\nNome: " + name + "\r\nClasse: " + classeEscolhida  + "\r\nForca: "  + pontos[0]  + "\r\nConstituicao: "  + pontos[1] +  "\r\nDestreza: " + pontos[2] + "\r\nAgilidade: " + pontos[3] + "\r\nInteligencia: " + pontos[4] + "\r\nForcaDeVontade: " + pontos[5] + "\r\nPercepcao: " + pontos[6] + "\r\nCarisma: " + pontos[7] + "\r\nBackupForca: " + pontosBackup[0] + "\r\nBackupConstituicao: " + pontosBackup[1] + "\r\nBackupDestreza: " + pontosBackup[2] + "\r\nBackupAgilidade: " + pontosBackup[3] + "\r\nBackupInteligencia: " + pontosBackup[4] + "\r\nBackupForcaDeVontade: " + pontosBackup[5] + "\r\nBackupPercepcao: " + pontosBackup[6] + "\r\nBackupCarisma: " + pontosBackup[7] + "\nPontosAdicionais: " + pontos_adiconais + "\nLevelBarra: " + levelBarra + "\nLevelBarraTotal: " + levelBarraTotal+ "\nVidaBarra: " + vidaBarra + "\nVidaBarraTotal: " + vidaBarraTotal + "\nLevel: " + level + "\nLevelUP: " + levelUp + "\nTelaFundo: " + telaFundo + "\nContHistoria: " + contHistoria + "\nLocalidade: " + local  + "\nContTravamento: " + contTravamento +  "\nPontosAdicionaisBackup: " + pontosAdicionaisBackup +  "\n  -=%=-  \n");
                        
                
            }while(linha != null);
            
        }catch(Exception e){
            System.err.printf("|lerConfig| Erro na abertura do arquivo: %s.\n",
            e.getMessage());
        }
            
    }

    public telaConfiguracao() {
        initComponents();
        setLocationRelativeTo(null);
        
        lerSalvamento();
        lerSalvamentoGlobal();
        
        if(salvamento == 1){
            config2.setText(name);
            config4.setText(classeEscolhida);
        }
        
        telaInformacaoChamar = new telaInformacao();
        telaInformacaoChamar.setVisible(false);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        config4 = new javax.swing.JLabel();
        config3 = new javax.swing.JLabel();
        config2 = new javax.swing.JLabel();
        config1 = new javax.swing.JLabel();
        info9 = new javax.swing.JLabel();
        info8 = new javax.swing.JLabel();
        info7 = new javax.swing.JLabel();
        info6 = new javax.swing.JLabel();
        info5 = new javax.swing.JLabel();
        info4 = new javax.swing.JLabel();
        info3 = new javax.swing.JLabel();
        info2 = new javax.swing.JLabel();
        info1 = new javax.swing.JLabel();
        version = new javax.swing.JLabel();
        obs1 = new javax.swing.JLabel();
        obs = new javax.swing.JLabel();
        volumeMusica = new javax.swing.JLabel();
        som1 = new javax.swing.JSlider();
        som2 = new javax.swing.JSlider();
        volumeEfeitos = new javax.swing.JLabel();
        volumeGeral = new javax.swing.JLabel();
        som = new javax.swing.JSlider();
        informacoes = new javax.swing.JButton();
        voltar = new javax.swing.JButton();
        fundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setUndecorated(true);
        setSize(new java.awt.Dimension(800, 600));

        jPanel1.setMaximumSize(new java.awt.Dimension(800, 600));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 600));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        config4.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        config4.setForeground(new java.awt.Color(153, 153, 153));
        config4.setText("ainda não foi cadastrada");
        jPanel1.add(config4, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 150, 240, 30));

        config3.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        config3.setForeground(new java.awt.Color(60, 60, 60));
        config3.setText("Classe");
        jPanel1.add(config3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 110, 30));

        config2.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        config2.setForeground(new java.awt.Color(153, 153, 153));
        config2.setText("ainda não foi cadastrado");
        jPanel1.add(config2, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 120, 240, 30));

        config1.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        config1.setForeground(new java.awt.Color(60, 60, 60));
        config1.setText("Nome");
        jPanel1.add(config1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 110, 30));

        info9.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        info9.setForeground(new java.awt.Color(41, 40, 40));
        info9.setText("Messiasferes127@gmail.com");
        jPanel1.add(info9, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 340, -1, -1));

        info8.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        info8.setForeground(new java.awt.Color(60, 60, 60));
        info8.setText("Contato:");
        jPanel1.add(info8, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 340, -1, -1));

        info7.setFont(new java.awt.Font("Dubai Medium", 0, 16)); // NOI18N
        info7.setForeground(new java.awt.Color(60, 60, 60));
        info7.setText("Atualmente o Stell World está na ");
        jPanel1.add(info7, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 380, -1, -1));

        info6.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        info6.setForeground(new java.awt.Color(41, 40, 40));
        info6.setText("e Samuel Cristian.");
        jPanel1.add(info6, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 240, -1, -1));

        info5.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        info5.setForeground(new java.awt.Color(41, 40, 40));
        info5.setText("Kalleby Lucchere, João Pedro Leocardio,");
        jPanel1.add(info5, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 220, -1, -1));

        info4.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        info4.setForeground(new java.awt.Color(60, 60, 60));
        info4.setText("E possui os seguintes colaboradores:");
        jPanel1.add(info4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, -1, -1));

        info3.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        info3.setForeground(new java.awt.Color(41, 40, 40));
        info3.setText("e João Victor Barbosa.");
        jPanel1.add(info3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 160, -1, -1));

        info2.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        info2.setForeground(new java.awt.Color(41, 40, 40));
        info2.setText("Messias Feres");
        jPanel1.add(info2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 140, -1, -1));

        info1.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        info1.setForeground(new java.awt.Color(60, 60, 60));
        info1.setText("Esse RPG foi criado por");
        jPanel1.add(info1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 140, -1, -1));

        version.setFont(new java.awt.Font("Dubai Medium", 2, 18)); // NOI18N
        version.setForeground(new java.awt.Color(41, 40, 40));
        version.setText("Versão: 1.0.0.45");
        jPanel1.add(version, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 410, 180, 20));

        obs1.setBackground(new java.awt.Color(60, 60, 60));
        obs1.setFont(new java.awt.Font("Dubai Medium", 0, 20)); // NOI18N
        obs1.setForeground(new java.awt.Color(153, 153, 153));
        obs1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        obs1.setText("por motivos tecnicos.");
        jPanel1.add(obs1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 290, -1));

        obs.setBackground(new java.awt.Color(60, 60, 60));
        obs.setFont(new java.awt.Font("Dubai Medium", 0, 20)); // NOI18N
        obs.setForeground(new java.awt.Color(153, 153, 153));
        obs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        obs.setText("Obs.: o som está desativado");
        jPanel1.add(obs, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 290, -1));

        volumeMusica.setBackground(new java.awt.Color(60, 60, 60));
        volumeMusica.setFont(new java.awt.Font("Dubai Medium", 0, 20)); // NOI18N
        volumeMusica.setForeground(new java.awt.Color(60, 60, 60));
        volumeMusica.setText("Volume música:");
        jPanel1.add(volumeMusica, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 160, -1));

        som1.setBackground(new java.awt.Color(153, 153, 153));
        som1.setFont(new java.awt.Font("Dubai Medium", 0, 11)); // NOI18N
        som1.setForeground(new java.awt.Color(60, 60, 60));
        som1.setPaintLabels(true);
        som1.setToolTipText("");
        som1.setValue(0);
        som1.setEnabled(false);
        som1.setFocusable(false);
        som1.setOpaque(false);
        som1.setRequestFocusEnabled(false);
        som1.setVerifyInputWhenFocusTarget(false);
        jPanel1.add(som1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 190, -1));

        som2.setBackground(new java.awt.Color(153, 153, 153));
        som2.setFont(new java.awt.Font("Dubai Medium", 0, 11)); // NOI18N
        som2.setForeground(new java.awt.Color(60, 60, 60));
        som2.setPaintLabels(true);
        som2.setToolTipText("");
        som2.setValue(0);
        som2.setEnabled(false);
        som2.setFocusable(false);
        som2.setOpaque(false);
        som2.setRequestFocusEnabled(false);
        som2.setVerifyInputWhenFocusTarget(false);
        jPanel1.add(som2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 190, -1));

        volumeEfeitos.setBackground(new java.awt.Color(60, 60, 60));
        volumeEfeitos.setFont(new java.awt.Font("Dubai Medium", 0, 20)); // NOI18N
        volumeEfeitos.setForeground(new java.awt.Color(60, 60, 60));
        volumeEfeitos.setText("Volume efeitos:");
        jPanel1.add(volumeEfeitos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 160, -1));

        volumeGeral.setBackground(new java.awt.Color(60, 60, 60));
        volumeGeral.setFont(new java.awt.Font("Dubai Medium", 0, 23)); // NOI18N
        volumeGeral.setForeground(new java.awt.Color(60, 60, 60));
        volumeGeral.setText("Volume geral:");
        jPanel1.add(volumeGeral, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 160, -1));

        som.setBackground(new java.awt.Color(153, 153, 153));
        som.setFont(new java.awt.Font("Dubai Medium", 0, 11)); // NOI18N
        som.setForeground(new java.awt.Color(60, 60, 60));
        som.setPaintLabels(true);
        som.setToolTipText("");
        som.setValue(0);
        som.setEnabled(false);
        som.setFocusable(false);
        som.setOpaque(false);
        som.setRequestFocusEnabled(false);
        som.setVerifyInputWhenFocusTarget(false);
        jPanel1.add(som, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 190, -1));

        informacoes.setBackground(new java.awt.Color(60, 60, 60));
        informacoes.setFont(new java.awt.Font("Dubai Medium", 0, 20)); // NOI18N
        informacoes.setForeground(new java.awt.Color(41, 40, 40));
        informacoes.setText("Acessar mais informações");
        informacoes.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        informacoes.setBorderPainted(false);
        informacoes.setContentAreaFilled(false);
        informacoes.setFocusable(false);
        informacoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                informacoesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                informacoesMouseExited(evt);
            }
        });
        informacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                informacoesActionPerformed(evt);
            }
        });
        jPanel1.add(informacoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 305, 250, 30));

        voltar.setBackground(new java.awt.Color(60, 60, 60));
        voltar.setFont(new java.awt.Font("Dubai Medium", 0, 24)); // NOI18N
        voltar.setForeground(new java.awt.Color(60, 60, 60));
        voltar.setText("Voltar");
        voltar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        voltar.setBorderPainted(false);
        voltar.setContentAreaFilled(false);
        voltar.setFocusable(false);
        voltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                voltarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                voltarMouseExited(evt);
            }
        });
        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarActionPerformed(evt);
            }
        });
        jPanel1.add(voltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 560, 80, 40));

        fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundoConfiguracoes.png"))); // NOI18N
        fundo.setName(""); // NOI18N
        fundo.setOpaque(true);
        jPanel1.add(fundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_voltarActionPerformed

    private void voltarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_voltarMouseEntered
        voltar.setBackground(new Color(60,60,60));
        voltar.setForeground(new Color(172,172,172));
    }//GEN-LAST:event_voltarMouseEntered

    private void voltarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_voltarMouseExited
        voltar.setBackground(new Color(172,172,172));
        voltar.setForeground(new Color(60,60,60));
    }//GEN-LAST:event_voltarMouseExited

    private void informacoesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_informacoesMouseEntered
        informacoes.setForeground(new Color(172,172,172));
    }//GEN-LAST:event_informacoesMouseEntered

    private void informacoesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_informacoesMouseExited
        informacoes.setForeground(new Color(60,60,60));
    }//GEN-LAST:event_informacoesMouseExited

    private void informacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_informacoesActionPerformed
        telaInformacaoChamar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_informacoesActionPerformed

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
            java.util.logging.Logger.getLogger(telaConfiguracao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaConfiguracao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaConfiguracao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaConfiguracao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new telaConfiguracao().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel config1;
    private javax.swing.JLabel config2;
    private javax.swing.JLabel config3;
    private javax.swing.JLabel config4;
    private javax.swing.JLabel fundo;
    private javax.swing.JLabel info1;
    private javax.swing.JLabel info2;
    private javax.swing.JLabel info3;
    private javax.swing.JLabel info4;
    private javax.swing.JLabel info5;
    private javax.swing.JLabel info6;
    private javax.swing.JLabel info7;
    private javax.swing.JLabel info8;
    private javax.swing.JLabel info9;
    private javax.swing.JButton informacoes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel obs;
    private javax.swing.JLabel obs1;
    private javax.swing.JSlider som;
    private javax.swing.JSlider som1;
    private javax.swing.JSlider som2;
    private javax.swing.JLabel version;
    private javax.swing.JButton voltar;
    private javax.swing.JLabel volumeEfeitos;
    private javax.swing.JLabel volumeGeral;
    private javax.swing.JLabel volumeMusica;
    // End of variables declaration//GEN-END:variables
    public telaMenu getMenu() {
        return menu;
    }

    public void setMenu(telaMenu menu) {
        this.menu = menu;
    }

}
