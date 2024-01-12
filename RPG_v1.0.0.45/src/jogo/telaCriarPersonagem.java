package jogo;

// Essa tela foi criada para executar o jInicio do Jogo de RPG
// Pedindo Nome e Classe do Usuario
// Feita por Messias Feres e Joao Victor Barbosa

import java.awt.Color;
import java.awt.Point;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Random;

public class telaCriarPersonagem extends javax.swing.JFrame {
    
    private telaMenu menu;
    private Point point = new Point();
    int escolha;
    String[] classes = new String[5];
    String classe = "", local = "Inicio";
    int[] pontos = new int[8];
    int[] pontosBackup = new int[8];
    int levelBarra = 0, vidaBarra = 100;
    int levelBarraTotal = 100, vidaBarraTotal = 100;
    int telaFundo = 0, pontosAdicionaisBackup = 10;
    int level = 1, levelUp ;
    int pontos_adiconais, contTravamento,estaminaBarra = 100,modoADM;
    long contHistoria = 0;
    
    int salvamento;
    
    Random gerador = new Random();
    
    // ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
    private void escritorSalvamentoGlobal() {
        try{

        FileOutputStream arq = new FileOutputStream("backup\\SalvamentoGlobal.txt");
        PrintWriter print = new PrintWriter(arq);
        
        print.println(1 + " ; " + salvamento + " ; ");
        print.close();
        arq.close();
        
        }catch(Exception e){
            System.err.printf("|escreverCriarPersonagem| Erro na abertura do arquivo: %s.\n",
            e.getMessage());
        }
            
    }
    private void escritorSalvamento() {
        
        try{

        FileOutputStream arq = new FileOutputStream("backup\\Salvamento.txt");
        PrintWriter print = new PrintWriter(arq);
        

        print.println("Nome" + " ; " + name.getText() + " ; " + "Classe" + " ; " + classe + " ; " + "Forca" + " ; " + pontos[0] + " ; " + "Constituicao" + " ; " + pontos[1] + " ; " + "Destreza" + " ; " + pontos[2] + " ; " + "Agilidade" + " ; " + pontos[3] + " ; " + "Inteligencia" + " ; " + pontos[4] + " ; " + "ForcaDeVontade" + " ; " + pontos[5] + " ; " + "Percepcao" + " ; " + pontos[6] + " ; " + "Carisma" + " ; " + pontos[7] + " ; " + "BackupForca" + " ; " + pontosBackup[0] + " ; " + "BackupConstituicao" + " ; " + pontosBackup[1] + " ; " + "BackupDestreza" + " ; " + pontosBackup[2] + " ; " + "BackupAgilidade" + " ; " + pontosBackup[3] + " ; " + "BackupInteligencia" + " ; " + pontosBackup[4] + " ; " + "BackupForcaDeVontade" + " ; " + pontosBackup[5] + " ; " + "BackupPercepcao" + " ; " + pontosBackup[6] + " ; " + "BackupCarisma" + " ; " + pontosBackup[7] + " ; "   + "PontosAdicionais:" + " ; " + pontos_adiconais + " ; " + "LevelBarra" + " ; " + levelBarra+ " ; "  + "LevelBarraTotal" + " ; " + levelBarraTotal+ " ; "  + "VidaBarra" + " ; " + vidaBarra + " ; "  + "VidaBarraTotal" + " ; " + vidaBarraTotal + " ; " + "Level" + " ; " + level + " ; " + "LevelUP" + " ; " + levelUp + " ; " + "telaFundo" + " ; " + telaFundo + " ; " + "contHistoria" + " ; " + contHistoria + " ; " + "localidade" + " ; " + local + " ; " + "contTravamento" + " ; " + contTravamento + " ; " + "pontosAdicionaisBackup" + " ; " + pontosAdicionaisBackup + " ; " + modoADM + " ; " + "estaminaBarra" + " ; " + estaminaBarra + " ; ");
        System.out.println("telaCriarPersonagemEscrever" + "\nNome: " + name.getText() + "\r\nClasse: " + classe  + "\r\nForca: "  + pontos[0]  + "\r\nConstituicao: "  + pontos[1] +  "\r\nDestreza: " + pontos[2] + "\r\nAgilidade: " + pontos[3] + "\r\nInteligencia: " + pontos[4] + "\r\nForcaDeVontade: " + pontos[5] + "\r\nPercepcao: " + pontos[6] + "\r\nCarisma: " + pontos[7] + "\r\nBackupForca: " + pontosBackup[0] + "\r\nBackupConstituicao: " + pontosBackup[1] + "\r\nBackupDestreza: " + pontosBackup[2] + "\r\nBackupAgilidade: " + pontosBackup[3] + "\r\nBackupInteligencia: " + pontosBackup[4] + "\r\nBackupForcaDeVontade: " + pontosBackup[5] + "\r\nBackupPercepcao: " + pontosBackup[6] + "\r\nBackupCarisma: " + pontosBackup[7] + "\nPontosAdicionais: " + pontos_adiconais + "\nLevelBarra: " + levelBarra + "\nLevelBarraTotal: " + levelBarraTotal+ "\nVidaBarra: " + vidaBarra + "\nVidaBarraTotal: " + vidaBarraTotal + "\nLevel: " + level + "\nLevelUP: " + levelUp + "\nTelaFundo: " + telaFundo + "\nContHistoria: " + contHistoria + "\nLocalidade: " + local + "\nContTravamento: " + contTravamento +  "\nPontosAdicionaisBackup: " + pontosAdicionaisBackup +  "\n  -=%=-  \n");
        print.close();
        arq.close();
        
        }catch(Exception e){
            System.err.printf("|escreverCriarPersonagem| Erro na abertura do arquivo: %s.\n",
            e.getMessage());
        }
            
    }
    private void escritorSalvamentoCriar() {
        
        try{

        FileOutputStream arq = new FileOutputStream("backup\\Salvamento.txt");
        PrintWriter print = new PrintWriter(arq);

        print.printf("");
        print.close();
        arq.close();
        
        }catch(Exception e){
            System.err.printf("|escreverCriarPersonagem| Erro na abertura do arquivo: %s.\n",
            e.getMessage());
        }
            
    }
   
    private void gerarPontos(){
        
            if("Mago".equals(classe)) // Pontos Mago
            {

                pontos[0] = gerador.nextInt(2);
                pontos[1] = gerador.nextInt(2) + 1;
                pontos[2] = 0;
                pontos[3] = gerador.nextInt(2);
                pontos[4] = gerador.nextInt(2) + 4;
                pontos[5] = gerador.nextInt(6);
                pontos[6] = gerador.nextInt(6);
                pontos[7] = gerador.nextInt(6);

            }

            if("Berserk".equals(classe)) // Pontos Berserk
            {

                pontos[0] = gerador.nextInt(2) + 4;
                pontos[1] = gerador.nextInt(2) + 1;
                pontos[2] = 0;
                pontos[3] = gerador.nextInt(2);
                pontos[4] = gerador.nextInt(2);
                pontos[5] = gerador.nextInt(6);
                pontos[6] = gerador.nextInt(6);
                pontos[7] = gerador.nextInt(6);

            }

            if("Arqueira".equals(classe)) // Pontos Arqueira
            {

                pontos[0] = gerador.nextInt(2);
                pontos[1] = gerador.nextInt(2) + 1;
                pontos[2] = 3;
                pontos[3] = gerador.nextInt(2) + 4;
                pontos[4] = gerador.nextInt(2) + 1;
                pontos[5] = gerador.nextInt(6);
                pontos[6] = gerador.nextInt(6);
                pontos[7] = gerador.nextInt(6);

            }

            if("Assassina".equals(classe))  // Pontos Assassina
            {

                pontos[0] = gerador.nextInt(3);
                pontos[1] = gerador.nextInt(2) + 1;
                pontos[2] = gerador.nextInt(2) + 4;
                pontos[3] = gerador.nextInt(3);
                pontos[4] = gerador.nextInt(2) + 1;
                pontos[5] = gerador.nextInt(6);
                pontos[6] = gerador.nextInt(6);
                pontos[7] = gerador.nextInt(6);

            }

            if("Cavaleiro".equals(classe)) // Pontos Cavaleiro
            {

                pontos[0] = gerador.nextInt(4) + 2;
                pontos[1] = gerador.nextInt(2) + 4;
                pontos[2] = 0;
                pontos[3] = gerador.nextInt(2);
                pontos[4] = gerador.nextInt(2);
                pontos[5] = gerador.nextInt(6);
                pontos[6] = gerador.nextInt(6);
                pontos[7] = gerador.nextInt(6);

            }

        for(int Cont = 0; Cont <8; Cont++)
        {
            pontosBackup[Cont] = pontos[Cont];
        }
        
        pontos_adiconais = 10;
        escritorSalvamento();
        
}
    
    // ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
       
    public telaCriarPersonagem() {
        
        initComponents();
        setLocationRelativeTo(null);
        
        escritorSalvamentoCriar();
        
        classes[0] = "Mago";
        classes[1] = "Berserk";
        classes[2] = "Arqueira";
        classes[3] = "Assassina";
        classes[4] = "Cavaleiro";
        
        painelConfirmacao.setEnabled(false);
        painelConfirmacao.setVisible(false);
        travarTela.setEnabled(false);
        travarTela.setVisible(false);
        
        confirmar_1.setEnabled(true);
        sair.setEnabled(true);
        name.setEnabled(true);
        mago.setEnabled(false);
        arqueira.setEnabled(true);
        cavaleiro.setEnabled(false);
        berserk.setEnabled(true);
        assassina.setEnabled(false);
        msgErro.setVisible(false);
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escolherClasse = new javax.swing.ButtonGroup();
        fundoConfirmacaoTravamento = new javax.swing.JLabel();
        painelConfirmacao = new javax.swing.JPanel();
        confirmar = new javax.swing.JButton();
        voltar = new javax.swing.JButton();
        textoConfirmacao1 = new javax.swing.JLabel();
        textoConfirmacao = new javax.swing.JLabel();
        fundoConfirmacao = new javax.swing.JLabel();
        travarTela = new javax.swing.JPanel();
        fundoTravamento = new javax.swing.JLabel();
        msgErro = new javax.swing.JLabel();
        texto_insira_nick = new javax.swing.JLabel();
        mago = new javax.swing.JRadioButton();
        berserk = new javax.swing.JRadioButton();
        arqueira = new javax.swing.JRadioButton();
        assassina = new javax.swing.JRadioButton();
        cavaleiro = new javax.swing.JRadioButton();
        confirmar_1 = new javax.swing.JButton();
        sair = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        welcome = new javax.swing.JLabel();
        welcome2 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        escolha_sua_classe = new javax.swing.JLabel();
        fundo = new javax.swing.JLabel();

        fundoConfirmacaoTravamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundoConfirmacaoTravamento.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(450, 500));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(450, 500));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        painelConfirmacao.setEnabled(false);
        painelConfirmacao.setMaximumSize(new java.awt.Dimension(430, 150));
        painelConfirmacao.setMinimumSize(new java.awt.Dimension(430, 150));
        painelConfirmacao.setOpaque(false);
        painelConfirmacao.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        confirmar.setBackground(java.awt.Color.gray);
        confirmar.setFont(new java.awt.Font("Impact", 1, 24)); // NOI18N
        confirmar.setForeground(new java.awt.Color(60, 60, 60));
        confirmar.setText("Confirmar");
        confirmar.setBorderPainted(false);
        confirmar.setContentAreaFilled(false);
        confirmar.setFocusable(false);
        confirmar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                confirmarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                confirmarMouseExited(evt);
            }
        });
        confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarActionPerformed(evt);
            }
        });
        painelConfirmacao.add(confirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, -1, -1));

        voltar.setBackground(java.awt.Color.gray);
        voltar.setFont(new java.awt.Font("Impact", 1, 24)); // NOI18N
        voltar.setForeground(new java.awt.Color(60, 60, 60));
        voltar.setText("Voltar");
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
        painelConfirmacao.add(voltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, -1, -1));

        textoConfirmacao1.setFont(new java.awt.Font("Dubai Medium", 2, 18)); // NOI18N
        textoConfirmacao1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoConfirmacao1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textoConfirmacao1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        textoConfirmacao1.setInheritsPopupMenu(false);
        painelConfirmacao.add(textoConfirmacao1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 390, 30));

        textoConfirmacao.setFont(new java.awt.Font("Dubai Medium", 2, 18)); // NOI18N
        textoConfirmacao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoConfirmacao.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textoConfirmacao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        textoConfirmacao.setInheritsPopupMenu(false);
        painelConfirmacao.add(textoConfirmacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 27, 390, 30));

        fundoConfirmacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundoConfirmacao.png"))); // NOI18N
        painelConfirmacao.add(fundoConfirmacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 150));

        getContentPane().add(painelConfirmacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 430, 150));

        travarTela.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        travarTela.setEnabled(false);
        travarTela.setMaximumSize(new java.awt.Dimension(450, 500));
        travarTela.setMinimumSize(new java.awt.Dimension(450, 500));
        travarTela.setOpaque(false);
        travarTela.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fundoTravamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundoConfirmacaoTravamento.png"))); // NOI18N
        travarTela.add(fundoTravamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(travarTela, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 500));

        msgErro.setFont(new java.awt.Font("MV Boli", 0, 16)); // NOI18N
        msgErro.setForeground(new java.awt.Color(116, 0, 0));
        msgErro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        msgErro.setText("Insira um nome e uma classe válida");
        msgErro.setToolTipText("");
        getContentPane().add(msgErro, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, 290, 30));

        texto_insira_nick.setFont(new java.awt.Font("MV Boli", 0, 36)); // NOI18N
        texto_insira_nick.setForeground(new java.awt.Color(60, 60, 60));
        texto_insira_nick.setText("Insira o seu Nome");
        texto_insira_nick.setToolTipText("");
        getContentPane().add(texto_insira_nick, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 100, -1, 50));

        escolherClasse.add(mago);
        mago.setFont(new java.awt.Font("Imprint MT Shadow", 2, 14)); // NOI18N
        mago.setForeground(new java.awt.Color(60, 60, 60));
        mago.setText("Mago ");
        mago.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mago.setFocusable(false);
        mago.setOpaque(false);
        mago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                magoActionPerformed(evt);
            }
        });
        getContentPane().add(mago, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, 84, -1));

        escolherClasse.add(berserk);
        berserk.setFont(new java.awt.Font("Imprint MT Shadow", 2, 14)); // NOI18N
        berserk.setForeground(new java.awt.Color(60, 60, 60));
        berserk.setText("Berserk");
        berserk.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        berserk.setFocusable(false);
        berserk.setOpaque(false);
        getContentPane().add(berserk, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 84, -1));

        escolherClasse.add(arqueira);
        arqueira.setFont(new java.awt.Font("Imprint MT Shadow", 2, 14)); // NOI18N
        arqueira.setForeground(new java.awt.Color(60, 60, 60));
        arqueira.setText("Arqueira");
        arqueira.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        arqueira.setFocusable(false);
        arqueira.setOpaque(false);
        getContentPane().add(arqueira, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 91, -1));

        escolherClasse.add(assassina);
        assassina.setFont(new java.awt.Font("Imprint MT Shadow", 2, 14)); // NOI18N
        assassina.setForeground(new java.awt.Color(60, 60, 60));
        assassina.setText("Assassina");
        assassina.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        assassina.setFocusable(false);
        assassina.setOpaque(false);
        getContentPane().add(assassina, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, 89, -1));

        escolherClasse.add(cavaleiro);
        cavaleiro.setFont(new java.awt.Font("Imprint MT Shadow", 2, 14)); // NOI18N
        cavaleiro.setForeground(new java.awt.Color(60, 60, 60));
        cavaleiro.setText("Cavaleiro");
        cavaleiro.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cavaleiro.setFocusable(false);
        cavaleiro.setOpaque(false);
        getContentPane().add(cavaleiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 103, -1));

        confirmar_1.setBackground(java.awt.Color.gray);
        confirmar_1.setFont(new java.awt.Font("Imprint MT Shadow", 1, 40)); // NOI18N
        confirmar_1.setForeground(new java.awt.Color(60, 60, 60));
        confirmar_1.setText("Confirmar");
        confirmar_1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        confirmar_1.setBorderPainted(false);
        confirmar_1.setContentAreaFilled(false);
        confirmar_1.setFocusable(false);
        confirmar_1.setName(""); // NOI18N
        confirmar_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                confirmar_1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                confirmar_1MouseExited(evt);
            }
        });
        confirmar_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmar_1ActionPerformed(evt);
            }
        });
        getContentPane().add(confirmar_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 396, 300, 44));

        sair.setBackground(java.awt.Color.gray);
        sair.setFont(new java.awt.Font("Impact", 2, 24)); // NOI18N
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
        getContentPane().add(sair, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 465, 100, 27));

        jPanel1.setBackground(new java.awt.Color(122, 122, 122));
        jPanel1.setOpaque(false);

        welcome.setBackground(new java.awt.Color(255, 255, 255));
        welcome.setFont(new java.awt.Font("HACKED", 1, 19)); // NOI18N
        welcome.setForeground(new java.awt.Color(255, 255, 255));
        welcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcome.setText("Seja bem vindo ao mundo de Stell,");
        welcome.setToolTipText("");

        welcome2.setBackground(new java.awt.Color(0, 0, 0));
        welcome2.setFont(new java.awt.Font("HACKED", 1, 18)); // NOI18N
        welcome2.setForeground(new java.awt.Color(255, 255, 255));
        welcome2.setText(" onde tudo se torna possivel");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(welcome, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(welcome2)
                .addGap(33, 33, 33))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(welcome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(welcome2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 80));

        name.setFont(new java.awt.Font("Dubai", 2, 25)); // NOI18N
        name.setToolTipText("");
        name.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 155, 200, 40));

        escolha_sua_classe.setFont(new java.awt.Font("Dubai Light", 0, 24)); // NOI18N
        escolha_sua_classe.setForeground(new java.awt.Color(60, 60, 60));
        escolha_sua_classe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        escolha_sua_classe.setText("Escolha sua classe");
        getContentPane().add(escolha_sua_classe, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 207, 222, -1));

        fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundoCriarPersonagem.png"))); // NOI18N
        fundo.setText("jLabel1");
        fundo.setMaximumSize(new java.awt.Dimension(450, 500));
        fundo.setMinimumSize(new java.awt.Dimension(450, 500));
        fundo.setPreferredSize(new java.awt.Dimension(450, 500));
        getContentPane().add(fundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_sairActionPerformed

    private void confirmar_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmar_1ActionPerformed

        if(mago.isSelected())
        {
            classe = classes[0];
        }
        if(berserk.isSelected())
        {
            classe = classes[1];
        }
        if(arqueira.isSelected())
        {
            classe = classes[2];
        }
        if(assassina.isSelected())
        {
            classe = classes[3];
        }
        if(cavaleiro.isSelected())
        {
            classe = classes[4];
        }
        
        if("".equals(name.getText()) || "".equals(classe))
        {
            msgErro.setVisible(true);
        }else{
            msgErro.setVisible(false);
            gerarPontos();
            textoConfirmacao.setText("Voce confirma que seu nome é " + name.getText());
            textoConfirmacao1.setText("e sua classe é " + classe);
            painelConfirmacao.setEnabled(true);
            painelConfirmacao.setVisible(true);
            travarTela.setEnabled(true);
            travarTela.setVisible(true);
            confirmar_1.setEnabled(false);
            sair.setEnabled(false);
            name.setEnabled(false);
            mago.setEnabled(false);
            arqueira.setEnabled(false);
            cavaleiro.setEnabled(false);
            berserk.setEnabled(false);
            assassina.setEnabled(false);
            
        }

    }//GEN-LAST:event_confirmar_1ActionPerformed

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
       
    }//GEN-LAST:event_formMouseDragged

    private void confirmar_1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmar_1MouseEntered
        confirmar_1.setForeground(new Color(172,172,172));
    }//GEN-LAST:event_confirmar_1MouseEntered

    private void confirmar_1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmar_1MouseExited
        confirmar_1.setForeground(new Color(60,60,60));
    }//GEN-LAST:event_confirmar_1MouseExited

    private void sairMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sairMouseEntered
        sair.setForeground(new Color(172,172,172));
    }//GEN-LAST:event_sairMouseEntered

    private void sairMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sairMouseExited
        sair.setForeground(new Color(60,60,60));
    }//GEN-LAST:event_sairMouseExited

    private void confirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarActionPerformed
        salvamento = 1;
        escritorSalvamentoGlobal();
        
        new telaCarregamento().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_confirmarActionPerformed

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
        painelConfirmacao.setEnabled(false);
        painelConfirmacao.setVisible(false);
        travarTela.setEnabled(false);
        travarTela.setVisible(false);
        confirmar_1.setEnabled(true);
        sair.setEnabled(true);
        name.setEnabled(true);
        arqueira.setEnabled(true);
        berserk.setEnabled(true);
    }//GEN-LAST:event_voltarActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        
    }//GEN-LAST:event_formKeyPressed

    private void confirmarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmarMouseEntered
        confirmar.setForeground(new Color(172,172,172));
    }//GEN-LAST:event_confirmarMouseEntered

    private void confirmarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmarMouseExited
        confirmar.setForeground(new Color(60,60,60));
    }//GEN-LAST:event_confirmarMouseExited

    private void voltarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_voltarMouseExited
        voltar.setForeground(new Color(60,60,60));
    }//GEN-LAST:event_voltarMouseExited

    private void voltarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_voltarMouseEntered
        voltar.setForeground(new Color(172,172,172));
    }//GEN-LAST:event_voltarMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        
    }//GEN-LAST:event_formMouseExited

    private void magoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_magoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_magoActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(telaCriarPersonagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaCriarPersonagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaCriarPersonagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaCriarPersonagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaCriarPersonagem().setVisible(true);
            }
            
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton arqueira;
    private javax.swing.JRadioButton assassina;
    private javax.swing.JRadioButton berserk;
    private javax.swing.JRadioButton cavaleiro;
    private javax.swing.JButton confirmar;
    private javax.swing.JButton confirmar_1;
    private javax.swing.JLabel escolha_sua_classe;
    private javax.swing.ButtonGroup escolherClasse;
    private javax.swing.JLabel fundo;
    private javax.swing.JLabel fundoConfirmacao;
    private javax.swing.JLabel fundoConfirmacaoTravamento;
    private javax.swing.JLabel fundoTravamento;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton mago;
    private javax.swing.JLabel msgErro;
    private javax.swing.JTextField name;
    private javax.swing.JPanel painelConfirmacao;
    private javax.swing.JButton sair;
    private javax.swing.JLabel textoConfirmacao;
    private javax.swing.JLabel textoConfirmacao1;
    private javax.swing.JLabel texto_insira_nick;
    private javax.swing.JPanel travarTela;
    private javax.swing.JButton voltar;
    private javax.swing.JLabel welcome;
    private javax.swing.JLabel welcome2;
    // End of variables declaration//GEN-END:variables

    public telaMenu getStatus() {
        return menu;
    }

    public void setStatus(telaMenu status) {
        this.menu = status;
    }

    public int getClasse() {
        return escolha;
    }

    public void setClasse(int escolha) {
        this.escolha = escolha;
    }
   
}
