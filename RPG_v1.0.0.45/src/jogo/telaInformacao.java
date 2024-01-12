package jogo;

// Essa tela foi criada para executar as apagarrr do Jogo de RPG

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import javax.swing.ImageIcon;
import jdk.nashorn.internal.runtime.JSType;

// Onde voce encontra a ajuda para Jogar o RPG
// Feita por Messias Feres e Joao Victor Barbosa


public class telaInformacao extends javax.swing.JFrame {
    int contAvatar = 0, salvamento;
    
    ImageIcon assassina_1 = new ImageIcon("src/imagens/assassina_1.png");
    ImageIcon arqueira_1 = new ImageIcon("src/imagens/arqueira_1.png");
    ImageIcon cavaleiro_1 = new ImageIcon("src/imagens/cavaleiro_1.png");
    ImageIcon berserk_1 = new ImageIcon("src/imagens/berserk_1.png");
    ImageIcon mago_1 = new ImageIcon("src/imagens/mago_1.png");
    ImageIcon grupoDeLadroes_1 = new ImageIcon("src/imagens/grupoDeLadroes_1.png");
    ImageIcon ciclope_1 = new ImageIcon("src/imagens/ciclope_1.png");
    ImageIcon slime_1 = new ImageIcon("src/imagens/slime_1.png");
    ImageIcon lobo_1 = new ImageIcon("src/imagens/lobo_1.png");
    ImageIcon kadu_1 = new ImageIcon("src/imagens/kadu_1.png");
    ImageIcon edu_1 = new ImageIcon("src/imagens/edu_1.png");
    ImageIcon goblins_1 = new ImageIcon("src/imagens/goblins_1.png");
    
    
    private void fecharPaineis(){
        painelInfo1.setVisible(false);
        painelInfo2.setVisible(false);
        painelInfo3.setVisible(false);
        painelInfo4.setVisible(false);
        painelInfo5.setVisible(false);
        painelInfo6.setVisible(false);
        painelInfo7.setVisible(false);
        painelInfo8.setVisible(false);
        painelInfo9.setVisible(false);
        painelInfo10.setVisible(false);
        
        info1.setForeground(new Color(60,60,60));
        info2.setForeground(new Color(60,60,60));
        info3.setForeground(new Color(60,60,60));
        info3.setForeground(new Color(60,60,60));
        info4.setForeground(new Color(60,60,60));
        info5.setForeground(new Color(60,60,60));
        info6.setForeground(new Color(60,60,60));
        info7.setForeground(new Color(60,60,60));
        info8.setForeground(new Color(60,60,60));
        info9.setForeground(new Color(60,60,60));
        info10.setForeground(new Color(60,60,60));
        
    }
    private void setarAvatar(){
        if(contAvatar == 0){
            avatar.setIcon(berserk_1);
            info145.setText("Berserk");
        }
        if(contAvatar == 1){
            avatar.setIcon(arqueira_1);
            info145.setText("Arqueira");
        }
        if(contAvatar == 2){
            avatar.setIcon(cavaleiro_1);
            info145.setText("Cavaleiro");
        }
        if(contAvatar == 3){
            avatar.setIcon(assassina_1);
            info145.setText("Assassina");
        }
        if(contAvatar == 4){
            avatar.setIcon(mago_1);
            info145.setText("Mago");
        }
        if(contAvatar == 5){
            avatar.setIcon(grupoDeLadroes_1);
            info145.setText("Grupo de Ladrões");
        }
        if(contAvatar == 6){
            avatar.setIcon(ciclope_1);
            info145.setText("Ciclope");
        }
        if(contAvatar == 7){
            avatar.setIcon(slime_1);
            info145.setText("Slime");
        }
        if(contAvatar == 8){
            avatar.setIcon(lobo_1);
            info145.setText("Lobo Cinzento");
        }
        if(contAvatar == 9){
            avatar.setIcon(goblins_1);
            info145.setText("Gangue de Goblins");
        }
        if(contAvatar == 10){
            avatar.setIcon(edu_1);
            info145.setText("Gangue do Dudu");
        }
        if(contAvatar == 11){
            avatar.setIcon(kadu_1);
            info145.setText("Kdú");
        }
    }
    
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
            System.err.printf("|lerInicio| Erro na abertura do arquivo: %s.\n",
            e.getMessage());
        }
            
    }
    
    public telaInformacao() {
        initComponents();
        setLocationRelativeTo(null);
        fecharPaineis();
        lerSalvamentoGlobal();
        
        info1.setVisible(false);
        info2.setVisible(false);
        info3.setVisible(false);
        info4.setVisible(false);
        info5.setVisible(false);
        info6.setVisible(false);
        
        avatar.setIcon(berserk_1);
        contAvatar = 0;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        painelGeral = new javax.swing.JPanel();
        info1 = new javax.swing.JButton();
        info2 = new javax.swing.JButton();
        info3 = new javax.swing.JButton();
        info4 = new javax.swing.JButton();
        info5 = new javax.swing.JButton();
        info6 = new javax.swing.JButton();
        info7 = new javax.swing.JButton();
        info8 = new javax.swing.JButton();
        info9 = new javax.swing.JButton();
        info10 = new javax.swing.JButton();
        painelInfo1 = new javax.swing.JPanel();
        textoInfo1 = new javax.swing.JLabel();
        painelInfo2 = new javax.swing.JPanel();
        textoInfo2 = new javax.swing.JLabel();
        painelInfo3 = new javax.swing.JPanel();
        textoInfo3 = new javax.swing.JLabel();
        painelInfo4 = new javax.swing.JPanel();
        textoInfo4 = new javax.swing.JLabel();
        painelInfo5 = new javax.swing.JPanel();
        textoInfo5 = new javax.swing.JLabel();
        painelInfo6 = new javax.swing.JPanel();
        textoInfo6 = new javax.swing.JLabel();
        painelInfo7 = new javax.swing.JPanel();
        info143 = new javax.swing.JLabel();
        info145 = new javax.swing.JLabel();
        avatar = new javax.swing.JLabel();
        anterior = new javax.swing.JButton();
        proximo = new javax.swing.JButton();
        avatarBorda = new javax.swing.JLabel();
        painelInfo8 = new javax.swing.JPanel();
        info141 = new javax.swing.JLabel();
        info142 = new javax.swing.JLabel();
        info139 = new javax.swing.JLabel();
        info140 = new javax.swing.JLabel();
        info135 = new javax.swing.JLabel();
        info136 = new javax.swing.JLabel();
        info133 = new javax.swing.JLabel();
        info134 = new javax.swing.JLabel();
        info131 = new javax.swing.JLabel();
        info132 = new javax.swing.JLabel();
        info129 = new javax.swing.JLabel();
        info130 = new javax.swing.JLabel();
        info128 = new javax.swing.JLabel();
        info127 = new javax.swing.JLabel();
        info124 = new javax.swing.JLabel();
        info125 = new javax.swing.JLabel();
        info126 = new javax.swing.JLabel();
        info137 = new javax.swing.JLabel();
        info138 = new javax.swing.JLabel();
        painelInfo9 = new javax.swing.JPanel();
        info123 = new javax.swing.JLabel();
        info122 = new javax.swing.JLabel();
        info119 = new javax.swing.JLabel();
        info120 = new javax.swing.JLabel();
        info121 = new javax.swing.JLabel();
        painelInfo10 = new javax.swing.JPanel();
        info118 = new javax.swing.JLabel();
        info117 = new javax.swing.JLabel();
        info115 = new javax.swing.JLabel();
        info116 = new javax.swing.JLabel();
        info113 = new javax.swing.JLabel();
        info114 = new javax.swing.JLabel();
        info112 = new javax.swing.JLabel();
        info111 = new javax.swing.JLabel();
        info110 = new javax.swing.JLabel();
        info109 = new javax.swing.JLabel();
        info108 = new javax.swing.JLabel();
        info107 = new javax.swing.JLabel();
        info106 = new javax.swing.JLabel();
        info105 = new javax.swing.JLabel();
        info104 = new javax.swing.JLabel();
        info103 = new javax.swing.JLabel();
        info102 = new javax.swing.JLabel();
        info101 = new javax.swing.JLabel();
        voltar = new javax.swing.JButton();
        fundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setUndecorated(true);
        setSize(new java.awt.Dimension(800, 600));

        jPanel1.setMaximumSize(new java.awt.Dimension(800, 600));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        painelGeral.setOpaque(false);
        painelGeral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        info1.setBackground(new java.awt.Color(172, 172, 172));
        info1.setForeground(new java.awt.Color(60, 60, 60));
        info1.setText("Info 1");
        info1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        info1.setBorderPainted(false);
        info1.setContentAreaFilled(false);
        info1.setEnabled(false);
        info1.setFocusable(false);
        info1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton14MouseExited(evt);
            }
        });
        info1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                info1ActionPerformed(evt);
            }
        });
        painelGeral.add(info1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 80, 20));

        info2.setBackground(new java.awt.Color(172, 172, 172));
        info2.setForeground(new java.awt.Color(60, 60, 60));
        info2.setText("Info 2");
        info2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        info2.setBorderPainted(false);
        info2.setContentAreaFilled(false);
        info2.setEnabled(false);
        info2.setFocusable(false);
        info2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                info2jButton14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                info2jButton14MouseExited(evt);
            }
        });
        info2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                info2ActionPerformed(evt);
            }
        });
        painelGeral.add(info2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, 20));

        info3.setBackground(new java.awt.Color(172, 172, 172));
        info3.setForeground(new java.awt.Color(60, 60, 60));
        info3.setText("Info 3");
        info3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        info3.setBorderPainted(false);
        info3.setContentAreaFilled(false);
        info3.setEnabled(false);
        info3.setFocusable(false);
        info3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                info3jButton14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                info3jButton14MouseExited(evt);
            }
        });
        info3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                info3ActionPerformed(evt);
            }
        });
        painelGeral.add(info3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 80, 20));

        info4.setBackground(new java.awt.Color(172, 172, 172));
        info4.setForeground(new java.awt.Color(60, 60, 60));
        info4.setText("Info 4");
        info4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        info4.setBorderPainted(false);
        info4.setContentAreaFilled(false);
        info4.setEnabled(false);
        info4.setFocusable(false);
        info4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                info4jButton14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                info4jButton14MouseExited(evt);
            }
        });
        info4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                info4ActionPerformed(evt);
            }
        });
        painelGeral.add(info4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 80, 20));

        info5.setBackground(new java.awt.Color(172, 172, 172));
        info5.setForeground(new java.awt.Color(60, 60, 60));
        info5.setText("Info 5");
        info5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        info5.setBorderPainted(false);
        info5.setContentAreaFilled(false);
        info5.setEnabled(false);
        info5.setFocusable(false);
        info5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                info5jButton14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                info5jButton14MouseExited(evt);
            }
        });
        info5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                info5ActionPerformed(evt);
            }
        });
        painelGeral.add(info5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 80, 20));

        info6.setBackground(new java.awt.Color(172, 172, 172));
        info6.setForeground(new java.awt.Color(60, 60, 60));
        info6.setText("Info 6");
        info6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        info6.setBorderPainted(false);
        info6.setContentAreaFilled(false);
        info6.setEnabled(false);
        info6.setFocusable(false);
        info6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                info6jButton14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                info6jButton14MouseExited(evt);
            }
        });
        info6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                info6ActionPerformed(evt);
            }
        });
        painelGeral.add(info6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 80, 20));

        info7.setBackground(new java.awt.Color(172, 172, 172));
        info7.setFont(new java.awt.Font("Dubai Medium", 0, 16)); // NOI18N
        info7.setForeground(new java.awt.Color(60, 60, 60));
        info7.setText("Personagens");
        info7.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        info7.setBorderPainted(false);
        info7.setContentAreaFilled(false);
        info7.setFocusable(false);
        info7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                info7jButton14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                info7jButton14MouseExited(evt);
            }
        });
        info7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                info7ActionPerformed(evt);
            }
        });
        painelGeral.add(info7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 100, 20));

        info8.setBackground(new java.awt.Color(172, 172, 172));
        info8.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        info8.setForeground(new java.awt.Color(60, 60, 60));
        info8.setText("Status");
        info8.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        info8.setBorderPainted(false);
        info8.setContentAreaFilled(false);
        info8.setFocusable(false);
        info8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                info8jButton14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                info8jButton14MouseExited(evt);
            }
        });
        info8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                info8ActionPerformed(evt);
            }
        });
        painelGeral.add(info8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 100, 20));

        info9.setBackground(new java.awt.Color(172, 172, 172));
        info9.setFont(new java.awt.Font("Dubai Medium", 0, 16)); // NOI18N
        info9.setForeground(new java.awt.Color(60, 60, 60));
        info9.setText("Atualizações");
        info9.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        info9.setBorderPainted(false);
        info9.setContentAreaFilled(false);
        info9.setFocusable(false);
        info9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                info9jButton14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                info9jButton14MouseExited(evt);
            }
        });
        info9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                info9ActionPerformed(evt);
            }
        });
        painelGeral.add(info9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 100, 20));

        info10.setBackground(new java.awt.Color(172, 172, 172));
        info10.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        info10.setForeground(new java.awt.Color(60, 60, 60));
        info10.setText("Sobre");
        info10.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        info10.setBorderPainted(false);
        info10.setContentAreaFilled(false);
        info10.setFocusable(false);
        info10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                info10jButton14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                info10jButton14MouseExited(evt);
            }
        });
        info10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                info10ActionPerformed(evt);
            }
        });
        painelGeral.add(info10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 100, 20));

        jPanel1.add(painelGeral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 110, 320));

        painelInfo1.setMinimumSize(new java.awt.Dimension(620, 542));
        painelInfo1.setOpaque(false);
        painelInfo1.setPreferredSize(new java.awt.Dimension(620, 542));
        painelInfo1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textoInfo1.setText("Texto 1");
        painelInfo1.add(textoInfo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 124, 203, 262));

        jPanel1.add(painelInfo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 640, 560));

        painelInfo2.setMinimumSize(new java.awt.Dimension(620, 542));
        painelInfo2.setOpaque(false);
        painelInfo2.setPreferredSize(new java.awt.Dimension(620, 542));
        painelInfo2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textoInfo2.setText("Texto 2");
        painelInfo2.add(textoInfo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 124, 203, 262));

        jPanel1.add(painelInfo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 640, 560));

        painelInfo3.setMinimumSize(new java.awt.Dimension(620, 542));
        painelInfo3.setOpaque(false);
        painelInfo3.setPreferredSize(new java.awt.Dimension(620, 542));
        painelInfo3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textoInfo3.setText("Texto 3");
        painelInfo3.add(textoInfo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 124, 203, 262));

        jPanel1.add(painelInfo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 640, 560));

        painelInfo4.setMinimumSize(new java.awt.Dimension(620, 542));
        painelInfo4.setOpaque(false);
        painelInfo4.setPreferredSize(new java.awt.Dimension(620, 542));
        painelInfo4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textoInfo4.setText("Texto 4");
        painelInfo4.add(textoInfo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 124, 203, 262));

        jPanel1.add(painelInfo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 640, 560));

        painelInfo5.setMinimumSize(new java.awt.Dimension(620, 542));
        painelInfo5.setOpaque(false);
        painelInfo5.setPreferredSize(new java.awt.Dimension(620, 542));
        painelInfo5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textoInfo5.setText("Texto 5");
        painelInfo5.add(textoInfo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 124, 203, 262));

        jPanel1.add(painelInfo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 640, 560));

        painelInfo6.setMinimumSize(new java.awt.Dimension(620, 542));
        painelInfo6.setOpaque(false);
        painelInfo6.setPreferredSize(new java.awt.Dimension(620, 542));
        painelInfo6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textoInfo6.setText("Texto 6");
        painelInfo6.add(textoInfo6, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 124, 203, 262));

        jPanel1.add(painelInfo6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 640, 560));

        painelInfo7.setMinimumSize(new java.awt.Dimension(620, 542));
        painelInfo7.setOpaque(false);
        painelInfo7.setPreferredSize(new java.awt.Dimension(620, 542));
        painelInfo7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        info143.setFont(new java.awt.Font("Ink Free", 1, 36)); // NOI18N
        info143.setForeground(new java.awt.Color(0, 0, 0));
        info143.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info143.setText("Personagens");
        painelInfo7.add(info143, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 570, -1));

        info145.setFont(new java.awt.Font("Ink Free", 0, 36)); // NOI18N
        info145.setForeground(new java.awt.Color(41, 40, 40));
        info145.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info145.setText("Berserk");
        painelInfo7.add(info145, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 570, 40));

        avatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/berserk_1.png"))); // NOI18N
        painelInfo7.add(avatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 300, 300));

        anterior.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        anterior.setForeground(new java.awt.Color(60, 60, 60));
        anterior.setText("Anterior");
        anterior.setBorder(null);
        anterior.setBorderPainted(false);
        anterior.setContentAreaFilled(false);
        anterior.setFocusable(false);
        anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteriorActionPerformed(evt);
            }
        });
        painelInfo7.add(anterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 90, 30));

        proximo.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        proximo.setForeground(new java.awt.Color(60, 60, 60));
        proximo.setText("Próximo");
        proximo.setBorder(null);
        proximo.setBorderPainted(false);
        proximo.setContentAreaFilled(false);
        proximo.setFocusable(false);
        proximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proximoActionPerformed(evt);
            }
        });
        painelInfo7.add(proximo, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 250, 90, 30));

        avatarBorda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/bordaAvatar.png"))); // NOI18N
        painelInfo7.add(avatarBorda, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 470, 531));

        jPanel1.add(painelInfo7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 640, 560));

        painelInfo8.setMinimumSize(new java.awt.Dimension(620, 542));
        painelInfo8.setOpaque(false);
        painelInfo8.setPreferredSize(new java.awt.Dimension(620, 542));
        painelInfo8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        info141.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        info141.setForeground(new java.awt.Color(41, 40, 40));
        info141.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info141.setText("Carisma:");
        painelInfo8.add(info141, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 400, 110, -1));

        info142.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        info142.setForeground(new java.awt.Color(60, 60, 60));
        info142.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info142.setText(" ajuda no decorrer da história.");
        painelInfo8.add(info142, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 340, -1));

        info139.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        info139.setForeground(new java.awt.Color(60, 60, 60));
        info139.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info139.setText("ajuda na história e na batalha.");
        painelInfo8.add(info139, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 370, 350, -1));

        info140.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        info140.setForeground(new java.awt.Color(41, 40, 40));
        info140.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info140.setText("Percepção:");
        painelInfo8.add(info140, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, 110, -1));

        info135.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        info135.setForeground(new java.awt.Color(60, 60, 60));
        info135.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info135.setText(" ajuda no decorrer da história.");
        painelInfo8.add(info135, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, 250, -1));

        info136.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        info136.setForeground(new java.awt.Color(41, 40, 40));
        info136.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info136.setText("Força de Vontade:");
        painelInfo8.add(info136, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, 150, -1));

        info133.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        info133.setForeground(new java.awt.Color(41, 40, 40));
        info133.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info133.setText("Agilidade:");
        painelInfo8.add(info133, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 110, -1));

        info134.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        info134.setForeground(new java.awt.Color(60, 60, 60));
        info134.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info134.setText("ajuda na história e melhora suas chances em uma batalha.");
        painelInfo8.add(info134, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 500, -1));

        info131.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        info131.setForeground(new java.awt.Color(41, 40, 40));
        info131.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info131.setText("Destreza:");
        painelInfo8.add(info131, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 110, -1));

        info132.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        info132.setForeground(new java.awt.Color(60, 60, 60));
        info132.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info132.setText("melhora algumas de suas habilidades.");
        painelInfo8.add(info132, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 360, -1));

        info129.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        info129.setForeground(new java.awt.Color(41, 40, 40));
        info129.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info129.setText("Constituição:");
        painelInfo8.add(info129, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 110, -1));

        info130.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        info130.setForeground(new java.awt.Color(60, 60, 60));
        info130.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info130.setText("aumenta a vida do personagem ao passar de level.");
        painelInfo8.add(info130, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 390, -1));

        info128.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        info128.setForeground(new java.awt.Color(60, 60, 60));
        info128.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info128.setText("deixa seu personagem com um ataque maior, e ajuda na história.");
        painelInfo8.add(info128, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 500, -1));

        info127.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        info127.setForeground(new java.awt.Color(60, 60, 60));
        info127.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info127.setText("o beneficiando durante a histório do RPG...");
        painelInfo8.add(info127, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 600, -1));

        info124.setFont(new java.awt.Font("Ink Free", 1, 36)); // NOI18N
        info124.setForeground(new java.awt.Color(0, 0, 0));
        info124.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info124.setText("Status");
        painelInfo8.add(info124, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 570, -1));

        info125.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        info125.setForeground(new java.awt.Color(60, 60, 60));
        info125.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info125.setText("Cada status possui uma certa vantagem no jogo,");
        painelInfo8.add(info125, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 600, -1));

        info126.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        info126.setForeground(new java.awt.Color(41, 40, 40));
        info126.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info126.setText("Força:");
        painelInfo8.add(info126, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 90, -1));

        info137.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        info137.setForeground(new java.awt.Color(41, 40, 40));
        info137.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info137.setText("Inteligência:");
        painelInfo8.add(info137, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, 110, -1));

        info138.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        info138.setForeground(new java.awt.Color(60, 60, 60));
        info138.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info138.setText("ajuda na história e na batalha.");
        painelInfo8.add(info138, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, 370, -1));

        jPanel1.add(painelInfo8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 640, 560));

        painelInfo9.setMinimumSize(new java.awt.Dimension(620, 542));
        painelInfo9.setOpaque(false);
        painelInfo9.setPreferredSize(new java.awt.Dimension(620, 542));
        painelInfo9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        info123.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        info123.setForeground(new java.awt.Color(60, 60, 60));
        info123.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info123.setText("e aumento da história, para melhor entrete-los.");
        painelInfo9.add(info123, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 600, -1));

        info122.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        info122.setForeground(new java.awt.Color(60, 60, 60));
        info122.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info122.setText("como correção de Bugs, melhorias no designer, adição de novos personagens,");
        painelInfo9.add(info122, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 600, -1));

        info119.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        info119.setForeground(new java.awt.Color(60, 60, 60));
        info119.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info119.setText("Na versão 1.0.0.45 aconteceram grandes mudanças");
        painelInfo9.add(info119, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 600, -1));

        info120.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        info120.setForeground(new java.awt.Color(41, 40, 40));
        info120.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info120.setText("Versão atual v1.0.0.45");
        painelInfo9.add(info120, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 500, 310, -1));

        info121.setFont(new java.awt.Font("Ink Free", 1, 36)); // NOI18N
        info121.setForeground(new java.awt.Color(0, 0, 0));
        info121.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info121.setText("Atualizações");
        painelInfo9.add(info121, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 570, -1));

        jPanel1.add(painelInfo9, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 640, 560));

        painelInfo10.setOpaque(false);
        painelInfo10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        info118.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        info118.setForeground(new java.awt.Color(41, 40, 40));
        info118.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info118.setText("Messiasferes127@gmail.com");
        painelInfo10.add(info118, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 510, 240, 30));

        info117.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        info117.setForeground(new java.awt.Color(60, 60, 60));
        info117.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info117.setText("Contato:");
        painelInfo10.add(info117, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 510, 140, -1));

        info115.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        info115.setForeground(new java.awt.Color(41, 40, 40));
        info115.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info115.setText("Samuel Cristian");
        painelInfo10.add(info115, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 460, 210, -1));

        info116.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        info116.setForeground(new java.awt.Color(60, 60, 60));
        info116.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info116.setText("ajudou com os mini-mapas.");
        painelInfo10.add(info116, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 460, 230, -1));

        info113.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        info113.setForeground(new java.awt.Color(60, 60, 60));
        info113.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info113.setText("ajudou com alguns mini-mapas.");
        painelInfo10.add(info113, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 430, 260, -1));

        info114.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        info114.setForeground(new java.awt.Color(41, 40, 40));
        info114.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info114.setText("João Pedro Leocardio");
        painelInfo10.add(info114, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 430, 210, -1));

        info112.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        info112.setForeground(new java.awt.Color(60, 60, 60));
        info112.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info112.setText("ajudou com os desenhos dos personagens.");
        painelInfo10.add(info112, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 400, 380, -1));

        info111.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        info111.setForeground(new java.awt.Color(41, 40, 40));
        info111.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info111.setText("Kalleby Lucchere");
        info111.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                info111MouseClicked(evt);
            }
        });
        painelInfo10.add(info111, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 400, 210, -1));

        info110.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        info110.setForeground(new java.awt.Color(60, 60, 60));
        info110.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info110.setText("Além dos criadores, possue alguns colaboradores:");
        painelInfo10.add(info110, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 600, -1));

        info109.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        info109.setForeground(new java.awt.Color(60, 60, 60));
        info109.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info109.setText("para um projeto de programação do Instituto Federal de MG.");
        painelInfo10.add(info109, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 600, -1));

        info108.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        info108.setForeground(new java.awt.Color(41, 40, 40));
        info108.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info108.setText("Messias Feres e João Victor Barbosa");
        painelInfo10.add(info108, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, 310, -1));

        info107.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        info107.setForeground(new java.awt.Color(60, 60, 60));
        info107.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info107.setText("Esse RPG foi criado por");
        painelInfo10.add(info107, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 220, -1));

        info106.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        info106.setForeground(new java.awt.Color(60, 60, 60));
        info106.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info106.setText("seu amigo, em que os dois batalham até a derrota de um.");
        painelInfo10.add(info106, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 600, -1));

        info105.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        info105.setForeground(new java.awt.Color(60, 60, 60));
        info105.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info105.setText("formas de entreterimento, como o modo duelo, em que você pode desafiar");
        painelInfo10.add(info105, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 600, -1));

        info104.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        info104.setForeground(new java.awt.Color(60, 60, 60));
        info104.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info104.setText("empolgante. Além do modo de escolhas(modo história), o RPG possui outras");
        painelInfo10.add(info104, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 600, -1));

        info103.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        info103.setForeground(new java.awt.Color(60, 60, 60));
        info103.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info103.setText("e se divertir, possui batalhas com diversos inimigos, o que se torna bem mais");
        painelInfo10.add(info103, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 600, -1));

        info102.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        info102.setForeground(new java.awt.Color(60, 60, 60));
        info102.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info102.setText("O jogo StellWorld é um RPG de escolhas, com diversos caminhos para seguir");
        painelInfo10.add(info102, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 600, -1));

        info101.setFont(new java.awt.Font("Ink Free", 1, 36)); // NOI18N
        info101.setForeground(new java.awt.Color(0, 0, 0));
        info101.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info101.setText("Sobre");
        painelInfo10.add(info101, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 570, -1));

        jPanel1.add(painelInfo10, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 640, 560));

        voltar.setFont(new java.awt.Font("Dubai Medium", 0, 24)); // NOI18N
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
        jPanel1.add(voltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 565, 110, 30));

        fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundoInformacoes.png"))); // NOI18N
        fundo.setOpaque(true);
        jPanel1.add(fundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void info1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_info1ActionPerformed
        fecharPaineis();
        painelInfo1.setVisible(true);
    }//GEN-LAST:event_info1ActionPerformed

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_voltarActionPerformed

    private void jButton14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton14MouseEntered
        info1.setBackground(new Color(60,60,60));
        info1.setForeground(new Color(172,172,172));
    }//GEN-LAST:event_jButton14MouseEntered

    private void jButton14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton14MouseExited
        info1.setBackground(new Color(172,172,172));
        info1.setForeground(new Color(60,60,60));
    }//GEN-LAST:event_jButton14MouseExited

    private void info2jButton14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_info2jButton14MouseEntered
        info2.setBackground(new Color(60,60,60));
        info2.setForeground(new Color(172,172,172));
    }//GEN-LAST:event_info2jButton14MouseEntered

    private void info2jButton14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_info2jButton14MouseExited
        info2.setBackground(new Color(172,172,172));
        info2.setForeground(new Color(60,60,60));
    }//GEN-LAST:event_info2jButton14MouseExited

    private void info2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_info2ActionPerformed
        fecharPaineis();
        painelInfo2.setVisible(true);
    }//GEN-LAST:event_info2ActionPerformed

    private void info3jButton14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_info3jButton14MouseEntered
        info3.setBackground(new Color(60,60,60));
        info3.setForeground(new Color(172,172,172));
    }//GEN-LAST:event_info3jButton14MouseEntered

    private void info3jButton14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_info3jButton14MouseExited
        info3.setBackground(new Color(172,172,172));
        info3.setForeground(new Color(60,60,60));
    }//GEN-LAST:event_info3jButton14MouseExited

    private void info3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_info3ActionPerformed
        fecharPaineis();
        painelInfo3.setVisible(true);
    }//GEN-LAST:event_info3ActionPerformed

    private void info4jButton14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_info4jButton14MouseEntered
        info4.setBackground(new Color(60,60,60));
        info4.setForeground(new Color(172,172,172));
    }//GEN-LAST:event_info4jButton14MouseEntered

    private void info4jButton14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_info4jButton14MouseExited
        info4.setBackground(new Color(172,172,172));
        info4.setForeground(new Color(60,60,60));
    }//GEN-LAST:event_info4jButton14MouseExited

    private void info4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_info4ActionPerformed
        fecharPaineis();
        painelInfo4.setVisible(true);
    }//GEN-LAST:event_info4ActionPerformed

    private void info5jButton14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_info5jButton14MouseEntered
        info5.setBackground(new Color(60,60,60));
        info5.setForeground(new Color(172,172,172));
    }//GEN-LAST:event_info5jButton14MouseEntered

    private void info5jButton14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_info5jButton14MouseExited
        info5.setBackground(new Color(172,172,172));
        info5.setForeground(new Color(60,60,60));
    }//GEN-LAST:event_info5jButton14MouseExited

    private void info5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_info5ActionPerformed
        fecharPaineis();
        painelInfo5.setVisible(true);
    }//GEN-LAST:event_info5ActionPerformed

    private void info6jButton14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_info6jButton14MouseEntered
        info6.setBackground(new Color(60,60,60));
        info6.setForeground(new Color(172,172,172));
    }//GEN-LAST:event_info6jButton14MouseEntered

    private void info6jButton14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_info6jButton14MouseExited
        info6.setBackground(new Color(172,172,172));
        info6.setForeground(new Color(60,60,60));
    }//GEN-LAST:event_info6jButton14MouseExited

    private void info6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_info6ActionPerformed
        fecharPaineis();
        painelInfo6.setVisible(true);
    }//GEN-LAST:event_info6ActionPerformed

    private void info7jButton14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_info7jButton14MouseEntered
        info7.setBackground(new Color(60,60,60));
        info7.setForeground(new Color(172,172,172));
    }//GEN-LAST:event_info7jButton14MouseEntered

    private void info7jButton14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_info7jButton14MouseExited
        info7.setBackground(new Color(172,172,172));
        info7.setForeground(new Color(60,60,60));
    }//GEN-LAST:event_info7jButton14MouseExited

    private void info7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_info7ActionPerformed
        fecharPaineis();
        painelInfo7.setVisible(true);
    }//GEN-LAST:event_info7ActionPerformed

    private void info8jButton14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_info8jButton14MouseEntered
        info8.setBackground(new Color(60,60,60));
        info8.setForeground(new Color(172,172,172));
    }//GEN-LAST:event_info8jButton14MouseEntered

    private void info8jButton14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_info8jButton14MouseExited
        info8.setBackground(new Color(172,172,172));
        info8.setForeground(new Color(60,60,60));
    }//GEN-LAST:event_info8jButton14MouseExited

    private void info8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_info8ActionPerformed
        fecharPaineis();
        painelInfo8.setVisible(true);
    }//GEN-LAST:event_info8ActionPerformed

    private void info9jButton14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_info9jButton14MouseEntered
        info9.setBackground(new Color(60,60,60));
        info9.setForeground(new Color(172,172,172));
    }//GEN-LAST:event_info9jButton14MouseEntered

    private void info9jButton14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_info9jButton14MouseExited
        info9.setBackground(new Color(172,172,172));
        info9.setForeground(new Color(60,60,60));
    }//GEN-LAST:event_info9jButton14MouseExited

    private void info9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_info9ActionPerformed
        fecharPaineis();
        painelInfo9.setVisible(true);
    }//GEN-LAST:event_info9ActionPerformed

    private void info10jButton14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_info10jButton14MouseEntered
        info10.setBackground(new Color(60,60,60));
        info10.setForeground(new Color(172,172,172));
    }//GEN-LAST:event_info10jButton14MouseEntered

    private void info10jButton14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_info10jButton14MouseExited
        info10.setBackground(new Color(172,172,172));
        info10.setForeground(new Color(60,60,60));
    }//GEN-LAST:event_info10jButton14MouseExited

    private void info10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_info10ActionPerformed
        fecharPaineis();
        painelInfo10.setVisible(true);
    }//GEN-LAST:event_info10ActionPerformed

    private void voltarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_voltarMouseExited
        voltar.setBackground(new Color(172,172,172));
        voltar.setForeground(new Color(60,60,60));
    }//GEN-LAST:event_voltarMouseExited

    private void voltarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_voltarMouseEntered
        voltar.setBackground(new Color(60,60,60));
        voltar.setForeground(new Color(172,172,172));
    }//GEN-LAST:event_voltarMouseEntered

    private void proximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proximoActionPerformed
        if(contAvatar == 11){ 
            contAvatar = 0;
        }else{
            contAvatar = contAvatar + 1;
        }
        setarAvatar();
    }//GEN-LAST:event_proximoActionPerformed

    private void anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorActionPerformed
        if(contAvatar == 0){ 
            contAvatar = 9;
        }else{
            contAvatar = contAvatar - 1;
        }
        setarAvatar();
    }//GEN-LAST:event_anteriorActionPerformed

    private void info111MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_info111MouseClicked
        lerSalvamentoGlobal();
        
        if(salvamento == 0){
            new telaBatalha().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_info111MouseClicked

    
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(telaInformacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaInformacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaInformacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaInformacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaInformacao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anterior;
    private javax.swing.JLabel avatar;
    private javax.swing.JLabel avatarBorda;
    private javax.swing.JLabel fundo;
    private javax.swing.JButton info1;
    private javax.swing.JButton info10;
    private javax.swing.JLabel info101;
    private javax.swing.JLabel info102;
    private javax.swing.JLabel info103;
    private javax.swing.JLabel info104;
    private javax.swing.JLabel info105;
    private javax.swing.JLabel info106;
    private javax.swing.JLabel info107;
    private javax.swing.JLabel info108;
    private javax.swing.JLabel info109;
    private javax.swing.JLabel info110;
    private javax.swing.JLabel info111;
    private javax.swing.JLabel info112;
    private javax.swing.JLabel info113;
    private javax.swing.JLabel info114;
    private javax.swing.JLabel info115;
    private javax.swing.JLabel info116;
    private javax.swing.JLabel info117;
    private javax.swing.JLabel info118;
    private javax.swing.JLabel info119;
    private javax.swing.JLabel info120;
    private javax.swing.JLabel info121;
    private javax.swing.JLabel info122;
    private javax.swing.JLabel info123;
    private javax.swing.JLabel info124;
    private javax.swing.JLabel info125;
    private javax.swing.JLabel info126;
    private javax.swing.JLabel info127;
    private javax.swing.JLabel info128;
    private javax.swing.JLabel info129;
    private javax.swing.JLabel info130;
    private javax.swing.JLabel info131;
    private javax.swing.JLabel info132;
    private javax.swing.JLabel info133;
    private javax.swing.JLabel info134;
    private javax.swing.JLabel info135;
    private javax.swing.JLabel info136;
    private javax.swing.JLabel info137;
    private javax.swing.JLabel info138;
    private javax.swing.JLabel info139;
    private javax.swing.JLabel info140;
    private javax.swing.JLabel info141;
    private javax.swing.JLabel info142;
    private javax.swing.JLabel info143;
    private javax.swing.JLabel info145;
    private javax.swing.JButton info2;
    private javax.swing.JButton info3;
    private javax.swing.JButton info4;
    private javax.swing.JButton info5;
    private javax.swing.JButton info6;
    private javax.swing.JButton info7;
    private javax.swing.JButton info8;
    private javax.swing.JButton info9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel painelGeral;
    private javax.swing.JPanel painelInfo1;
    private javax.swing.JPanel painelInfo10;
    private javax.swing.JPanel painelInfo2;
    private javax.swing.JPanel painelInfo3;
    private javax.swing.JPanel painelInfo4;
    private javax.swing.JPanel painelInfo5;
    private javax.swing.JPanel painelInfo6;
    private javax.swing.JPanel painelInfo7;
    private javax.swing.JPanel painelInfo8;
    private javax.swing.JPanel painelInfo9;
    private javax.swing.JButton proximo;
    private javax.swing.JLabel textoInfo1;
    private javax.swing.JLabel textoInfo2;
    private javax.swing.JLabel textoInfo3;
    private javax.swing.JLabel textoInfo4;
    private javax.swing.JLabel textoInfo5;
    private javax.swing.JLabel textoInfo6;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables
}
