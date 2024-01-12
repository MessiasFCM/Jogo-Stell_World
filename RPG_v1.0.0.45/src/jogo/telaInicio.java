package jogo;

// Essa tela foi criada para executar o telaInicio do Jogo de RPG
// Pedindo Nome e Classe do Usuario
// Feita por Messias Feres e Joao Victor Barbosa

import classes.chamar;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import jdk.nashorn.internal.runtime.JSType;

public class telaInicio extends javax.swing.JFrame {
    private telaMenu menu;
    private String name, classeEscolhida, local;
    private int[] pontos = new int[8];
    private int[] pontosBackup = new int[8];
    int levelBarra = 0, vidaBarra = 100;
    int levelBarraTotal = 100, vidaBarraTotal = 100;
    int pontos_adiconais, pontosAdicionaisBackup;
    int level, levelUp;
    int classe, salvamento, delayInicio = 0;
    int telaFundo, contTravamento, modoADM, estaminaBarra;
    long contHistoria;
    
    telaInformacao telaInformacaoChamar;
    telaConfiguracao telaConfiguracaoChamar;
    telaDuelo telaDueloChamar;
    
    Thread delay = new Thread();
    
    ImageIcon assassinaHistoria_1 = new ImageIcon("src/imagens/assassinaTelaInicio.png");
    ImageIcon berserkHistoria_1 = new ImageIcon("src/imagens/berserkTelaInicio.png");
    ImageIcon arqueiraHistoria_1 = new ImageIcon("src/imagens/arqueiraTelaInicio.png");
    ImageIcon cavaleiroHistoria_1 = new ImageIcon("src/imagens/cavaleiroTelaInicio.png");
    ImageIcon magoHistoria_1 = new ImageIcon("src/imagens/magoTelaInicio.png");

    ImageIcon kaduHistoria_1 = new ImageIcon("src/imagens/kaduTelaInicio.png");
    
    private void delayAvatar(){
        
        delay = new Thread(){
            
            public void run(){
                do {                    
                    for(int cont = 0; cont<6; cont++){
                        try {
                            if(cont == 0){
                                exibirAvatar.setIcon(assassinaHistoria_1);
                            }else if(cont == 1){
                                exibirAvatar.setIcon(berserkHistoria_1);
                            }else if(cont == 2){
                                exibirAvatar.setIcon(arqueiraHistoria_1);
                            }else if(cont == 3){
                                exibirAvatar.setIcon(cavaleiroHistoria_1);
                            }else if(cont == 4){
                                exibirAvatar.setIcon(magoHistoria_1);
                            }else if(cont == 5){
                                exibirAvatar.setIcon(kaduHistoria_1);
                            }
                            delay.sleep(1800);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(telaCarregamento.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    try {
                        delay.sleep(700);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(telaInicio.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } while (delayInicio == 0);
            }
        };
        delay.start();
        
    }
    
    public telaInicio() {
       
        chamar chamador = new chamar();
        
        initComponents();
        setLocationRelativeTo(null);
        chamador.fundoTransparencia(this);
        
        telaInformacaoChamar = new telaInformacao();
        telaConfiguracaoChamar = new telaConfiguracao();
        telaDueloChamar = new telaDuelo();
        telaDueloChamar.setVisible(false);
        telaInformacaoChamar.setVisible(false);
        telaConfiguracaoChamar.setVisible(false);
        
        painelHistoria.setVisible(false);
        painelHistoria.setEnabled(false);
        
        delayAvatar();
        
        lerSalvamento();
        lerSalvamentoGlobal();
        
        if("Mago".equals(classeEscolhida)){
            classe = 0;
        }
        if("Berserk".equals(classeEscolhida)){
            classe = 1;
        }
        if("Arqueira".equals(classeEscolhida)){
            classe = 2;
        }
        if("Assassina".equals(classeEscolhida)){
            classe = 3;
        }
        if("Cavaleiro".equals(classeEscolhida)){
            classe = 4;
        }
    }
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelComandos = new javax.swing.JPanel();
        abrirHistoria = new javax.swing.JButton();
        abrirDuelo = new javax.swing.JButton();
        abrirConfig = new javax.swing.JButton();
        painelHistoria = new javax.swing.JPanel();
        newGame = new javax.swing.JButton();
        continuar = new javax.swing.JButton();
        voltar = new javax.swing.JButton();
        painelFundo = new javax.swing.JPanel();
        sair = new javax.swing.JButton();
        exibirAvatar = new javax.swing.JLabel();
        fundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("RPG");
        setBackground(new java.awt.Color(141, 141, 141));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImages(null);
        setMinimumSize(new java.awt.Dimension(450, 500));
        setUndecorated(true);
        setSize(new java.awt.Dimension(450, 500));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        painelComandos.setOpaque(false);
        painelComandos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        abrirHistoria.setBackground(new java.awt.Color(172, 172, 172));
        abrirHistoria.setFont(new java.awt.Font("Imprint MT Shadow", 0, 36)); // NOI18N
        abrirHistoria.setForeground(new java.awt.Color(60, 60, 60));
        abrirHistoria.setText("História");
        abrirHistoria.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        abrirHistoria.setBorderPainted(false);
        abrirHistoria.setContentAreaFilled(false);
        abrirHistoria.setFocusable(false);
        abrirHistoria.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        abrirHistoria.setMargin(null);
        abrirHistoria.setMaximumSize(new java.awt.Dimension(100, 20));
        abrirHistoria.setMinimumSize(new java.awt.Dimension(100, 20));
        abrirHistoria.setPreferredSize(new java.awt.Dimension(100, 20));
        abrirHistoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                abrirHistoriaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                abrirHistoriaMouseExited(evt);
            }
        });
        abrirHistoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirHistoriaActionPerformed(evt);
            }
        });
        painelComandos.add(abrirHistoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 180, 40));

        abrirDuelo.setBackground(new java.awt.Color(172, 172, 172));
        abrirDuelo.setFont(new java.awt.Font("Imprint MT Shadow", 0, 30)); // NOI18N
        abrirDuelo.setForeground(new java.awt.Color(60, 60, 60));
        abrirDuelo.setText("Duelo");
        abrirDuelo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        abrirDuelo.setBorderPainted(false);
        abrirDuelo.setContentAreaFilled(false);
        abrirDuelo.setFocusable(false);
        abrirDuelo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        abrirDuelo.setMargin(null);
        abrirDuelo.setMaximumSize(new java.awt.Dimension(100, 20));
        abrirDuelo.setMinimumSize(new java.awt.Dimension(100, 20));
        abrirDuelo.setPreferredSize(new java.awt.Dimension(100, 20));
        abrirDuelo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                abrirDueloMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                abrirDueloMouseExited(evt);
            }
        });
        abrirDuelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirDueloActionPerformed(evt);
            }
        });
        painelComandos.add(abrirDuelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 120, 28));

        abrirConfig.setBackground(new java.awt.Color(172, 172, 172));
        abrirConfig.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        abrirConfig.setForeground(new java.awt.Color(60, 60, 60));
        abrirConfig.setText("Configurações");
        abrirConfig.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        abrirConfig.setBorderPainted(false);
        abrirConfig.setContentAreaFilled(false);
        abrirConfig.setFocusable(false);
        abrirConfig.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        abrirConfig.setMargin(null);
        abrirConfig.setMaximumSize(new java.awt.Dimension(100, 20));
        abrirConfig.setMinimumSize(new java.awt.Dimension(100, 20));
        abrirConfig.setPreferredSize(new java.awt.Dimension(100, 20));
        abrirConfig.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                abrirConfigMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                abrirConfigMouseExited(evt);
            }
        });
        abrirConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirConfigActionPerformed(evt);
            }
        });
        painelComandos.add(abrirConfig, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 130, -1));

        getContentPane().add(painelComandos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 190, 250));

        painelHistoria.setOpaque(false);
        painelHistoria.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        newGame.setBackground(new java.awt.Color(172, 172, 172));
        newGame.setFont(new java.awt.Font("Engravers MT", 0, 17)); // NOI18N
        newGame.setForeground(new java.awt.Color(60, 60, 60));
        newGame.setText("New Game");
        newGame.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        newGame.setBorderPainted(false);
        newGame.setContentAreaFilled(false);
        newGame.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        newGame.setFocusable(false);
        newGame.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        newGame.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        newGame.setMargin(null);
        newGame.setMaximumSize(new java.awt.Dimension(100, 20));
        newGame.setMinimumSize(new java.awt.Dimension(100, 20));
        newGame.setPreferredSize(new java.awt.Dimension(100, 20));
        newGame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                newGameMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                newGameMouseExited(evt);
            }
        });
        newGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameActionPerformed(evt);
            }
        });
        painelHistoria.add(newGame, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 161, -1));

        continuar.setBackground(new java.awt.Color(172, 172, 172));
        continuar.setFont(new java.awt.Font("Imprint MT Shadow", 0, 35)); // NOI18N
        continuar.setForeground(new java.awt.Color(60, 60, 60));
        continuar.setText("Continuar");
        continuar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        continuar.setContentAreaFilled(false);
        continuar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        continuar.setFocusable(false);
        continuar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        continuar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        continuar.setMargin(null);
        continuar.setVerifyInputWhenFocusTarget(false);
        continuar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                continuarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                continuarMouseExited(evt);
            }
        });
        continuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continuarActionPerformed(evt);
            }
        });
        painelHistoria.add(continuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 169, 30));

        voltar.setBackground(new java.awt.Color(172, 172, 172));
        voltar.setFont(new java.awt.Font("Impact", 2, 25)); // NOI18N
        voltar.setForeground(new java.awt.Color(60, 60, 60));
        voltar.setText("Voltar");
        voltar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        voltar.setBorderPainted(false);
        voltar.setContentAreaFilled(false);
        voltar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        voltar.setFocusable(false);
        voltar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        voltar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        voltar.setMargin(null);
        voltar.setMaximumSize(new java.awt.Dimension(100, 20));
        voltar.setMinimumSize(new java.awt.Dimension(100, 20));
        voltar.setPreferredSize(new java.awt.Dimension(100, 20));
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
        painelHistoria.add(voltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 110, -1));

        getContentPane().add(painelHistoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 180, 180));

        painelFundo.setOpaque(false);
        painelFundo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sair.setBackground(new java.awt.Color(172, 172, 172));
        sair.setFont(new java.awt.Font("MV Boli", 1, 36)); // NOI18N
        sair.setForeground(new java.awt.Color(60, 60, 60));
        sair.setText("Sair");
        sair.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        sair.setBorderPainted(false);
        sair.setContentAreaFilled(false);
        sair.setFocusable(false);
        sair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sairMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sairMouseExited(evt);
            }
        });
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });
        painelFundo.add(sair, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 460, 120, 30));

        exibirAvatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/berserkTelaInicio.png"))); // NOI18N
        painelFundo.add(exibirAvatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, -1, -1));

        fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundoInicio.png"))); // NOI18N
        fundo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                fundoMouseDragged(evt);
            }
        });
        painelFundo.add(fundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(painelFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    private void lerSalvamentoGlobal() {
     
        try{ 
            FileInputStream arquivo = new FileInputStream("backup\\SalvamentoGlobal.txt");
            InputStreamReader leitor = new InputStreamReader(arquivo);
            BufferedReader buffer = new BufferedReader(leitor);
            
            String linha;
            
            do{
                linha = buffer.readLine();
                
                if(linha != null){
                    
                    String[] palavras = linha.split(" ");
                    for(int i = 0; i < palavras.length; i++){
                        
                        salvamento = JSType.toInteger(palavras[1]);
                    }
                }
            }while(linha != null);
            arquivo.close();
        }catch(Exception e){
            System.err.printf("|lerInicio| Erro na abertura do arquivo: %s.\n",
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
                        estaminaBarra = JSType.toInteger(palavras[62]);
                    }
                }
                System.out.println("telaInicioLer" + "\nNome: " + name + "\r\nClasse: " + classeEscolhida  + "\r\nForca: "  + pontos[0]  + "\r\nConstituicao: "  + pontos[1] +  "\r\nDestreza: " + pontos[2] + "\r\nAgilidade: " + pontos[3] + "\r\nInteligencia: " + pontos[4] + "\r\nForcaDeVontade: " + pontos[5] + "\r\nPercepcao: " + pontos[6] + "\r\nCarisma: " + pontos[7] + "\r\nBackupForca: " + pontosBackup[0] + "\r\nBackupConstituicao: " + pontosBackup[1] + "\r\nBackupDestreza: " + pontosBackup[2] + "\r\nBackupAgilidade: " + pontosBackup[3] + "\r\nBackupInteligencia: " + pontosBackup[4] + "\r\nBackupForcaDeVontade: " + pontosBackup[5] + "\r\nBackupPercepcao: " + pontosBackup[6] + "\r\nBackupCarisma: " + pontosBackup[7] + "\nPontosAdicionais: " + pontos_adiconais + "\nLevelBarra: " + levelBarra + "\nLevelBarraTotal: " + levelBarraTotal+ "\nVidaBarra: " + vidaBarra + "\nVidaBarraTotal: " + vidaBarraTotal + "\nLevel: " + level + "\nLevelUP: " + levelUp + "\nTelaFundo: " + telaFundo + "\nContHistoria: " + contHistoria + "\nLocalidade: " + local  + "\nContTravamento: " + contTravamento +  "\nPontosAdicionaisBackup: " + pontosAdicionaisBackup + "\nBarra Estamina: " + estaminaBarra + "\n  -=%=-  \n");
                        
                
            }while(linha != null);
            
        }catch(Exception e){
            System.err.printf("|lerInicio| Erro na abertura do arquivo: %s.\n",
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
            System.err.printf("|escreverInicio| Erro na abertura do arquivo: %s.\n",
            e.getMessage());
        }
            
    }
    
    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        delayInicio = 1;
        System.exit(0);
    }//GEN-LAST:event_sairActionPerformed

    private void continuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continuarActionPerformed
        delayInicio = 1;
        lerSalvamentoGlobal();
        
        if(salvamento == 1){
            new telaCarregamento().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_continuarActionPerformed

    private void newGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGameActionPerformed
        delayInicio = 1;
        salvamento = 0;
        escritorSalvamentoGlobal();
        
        new telaCriarPersonagem().setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_newGameActionPerformed

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        
    }//GEN-LAST:event_formMouseDragged

    private void abrirConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirConfigActionPerformed
        telaConfiguracaoChamar.setVisible(true);
    }//GEN-LAST:event_abrirConfigActionPerformed

    private void continuarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_continuarMouseEntered
        continuar.setForeground(new Color(172,172,172));
    }//GEN-LAST:event_continuarMouseEntered

    private void continuarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_continuarMouseExited
        continuar.setForeground(new Color(60,60,60));
    }//GEN-LAST:event_continuarMouseExited

    private void sairMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sairMouseEntered
        sair.setForeground(new Color(172,172,172));
    }//GEN-LAST:event_sairMouseEntered

    private void sairMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sairMouseExited
        sair.setForeground(new Color(60,60,60));
    }//GEN-LAST:event_sairMouseExited

    private void fundoMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fundoMouseDragged
        
    }//GEN-LAST:event_fundoMouseDragged

    private void newGameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newGameMouseExited
        newGame.setForeground(new Color(60,60,60));
    }//GEN-LAST:event_newGameMouseExited

    private void newGameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newGameMouseEntered
        newGame.setForeground(new Color(172,172,172));
    }//GEN-LAST:event_newGameMouseEntered

    private void abrirConfigMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abrirConfigMouseExited
        abrirConfig.setForeground(new Color(60,60,60));
    }//GEN-LAST:event_abrirConfigMouseExited

    private void abrirConfigMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abrirConfigMouseEntered
        abrirConfig.setForeground(new Color(172,172,172));
    }//GEN-LAST:event_abrirConfigMouseEntered

    private void abrirDueloMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abrirDueloMouseEntered
        abrirDuelo.setForeground(new Color(172,172,172));
    }//GEN-LAST:event_abrirDueloMouseEntered

    private void abrirDueloMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abrirDueloMouseExited
        abrirDuelo.setForeground(new Color(60,60,60));
    }//GEN-LAST:event_abrirDueloMouseExited

    private void abrirDueloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirDueloActionPerformed
        delayInicio = 1;
        telaDueloChamar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_abrirDueloActionPerformed

    private void abrirHistoriaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abrirHistoriaMouseEntered
        abrirHistoria.setForeground(new Color(172,172,172));
    }//GEN-LAST:event_abrirHistoriaMouseEntered

    private void abrirHistoriaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abrirHistoriaMouseExited
        abrirHistoria.setForeground(new Color(60,60,60));
    }//GEN-LAST:event_abrirHistoriaMouseExited

    private void abrirHistoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirHistoriaActionPerformed
        delayInicio = 1;
        painelHistoria.setVisible(true);
        painelHistoria.setEnabled(true);
        
        painelComandos.setVisible(false);
        painelComandos.setEnabled(false);
    }//GEN-LAST:event_abrirHistoriaActionPerformed

    private void voltarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_voltarMouseEntered
        voltar.setForeground(new Color(172,172,172));
    }//GEN-LAST:event_voltarMouseEntered

    private void voltarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_voltarMouseExited
        voltar.setForeground(new Color(60,60,60));
    }//GEN-LAST:event_voltarMouseExited

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
        painelHistoria.setVisible(false);
        painelHistoria.setEnabled(false);
        
        painelComandos.setVisible(true);
        painelComandos.setEnabled(true);
    }//GEN-LAST:event_voltarActionPerformed

  
    public static void main(String args[]) {
        
       try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(telaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaInicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abrirConfig;
    private javax.swing.JButton abrirDuelo;
    private javax.swing.JButton abrirHistoria;
    private javax.swing.JButton continuar;
    private javax.swing.JLabel exibirAvatar;
    private javax.swing.JLabel fundo;
    private javax.swing.JButton newGame;
    private javax.swing.JPanel painelComandos;
    private javax.swing.JPanel painelFundo;
    private javax.swing.JPanel painelHistoria;
    private javax.swing.JButton sair;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables


    public telaMenu getMenu() {
        return menu;
    }

    public void setMenu(telaMenu menu) {
        this.menu = menu;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

}
