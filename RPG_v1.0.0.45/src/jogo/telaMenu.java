package jogo;

// Essa tela foi criada para executar o telaMenu do Jogo de RPG
// Onde mostrara os Status, Skills, o Personagem, Habilidades, Etc
// Feita por Messias Feres e Joao Victor Barbosa

import classes.chamar;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import jdk.nashorn.internal.runtime.JSType;


public final class telaMenu extends javax.swing.JFrame {
    
    private String nome;
    private Point point = new Point();
    
    String[] habilidades = new String[1];
    String classeEscolhida, local;
    
    Thread delay = new Thread();
    
    int[] pontos = new int[8];
    int[] pontosBackup = new int[8];
    int pontos_adiconais, pontosAdicionaisBackup;
    int levelBarra = 0, vidaBarraPersonagem = 100, correcaoVida;
    int levelBarraTotal = 100, vidaBarraTotalPersonagem = 100;
    int dano, levelPersonagem = 1, levelUp = 0;
    int porcentagemVida1,porcentagemVida2, modoADM, estaminaBarra;
    int telaFundo, contTravamento, gameOver = 0, contADM = 0;
    long contHistoria;
    
    telaInformacao telaInformacaoChamar;
    telaConfiguracao telaConfiguracaoChamar;
    
    ImageIcon assassina_1 = new ImageIcon("src/imagens/assassina_1.png");
    ImageIcon assassina_2 = new ImageIcon("src/imagens/assassina_2.png");
    ImageIcon assassina_3 = new ImageIcon("src/imagens/assassina_3.png");
    ImageIcon arqueira_1 = new ImageIcon("src/imagens/arqueira_1.png");
    ImageIcon arqueira_2 = new ImageIcon("src/imagens/arqueira_2.png");
    ImageIcon arqueira_3 = new ImageIcon("src/imagens/arqueira_3.png");
    ImageIcon cavaleiro_1 = new ImageIcon("src/imagens/cavaleiro_1.png");
    ImageIcon cavaleiro_2 = new ImageIcon("src/imagens/cavaleiro_2.png");
    ImageIcon cavaleiro_3 = new ImageIcon("src/imagens/cavaleiro_3.png");
    ImageIcon berserk_1 = new ImageIcon("src/imagens/berserk_1.png");
    ImageIcon berserk_2 = new ImageIcon("src/imagens/berserk_2.png");
    ImageIcon berserk_3 = new ImageIcon("src/imagens/berserk_3.png");
    ImageIcon mago_1 = new ImageIcon("src/imagens/mago_1.png");
    ImageIcon mago_2 = new ImageIcon("src/imagens/mago_2.png");
    ImageIcon mago_3 = new ImageIcon("src/imagens/mago_3.png");

    telaMenu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
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
                        
                        nome = palavras[1];
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
                        vidaBarraPersonagem = JSType.toInteger(palavras[43]);
                        vidaBarraTotalPersonagem = JSType.toInteger(palavras[45]); 
                        
                        levelPersonagem = JSType.toInteger(palavras[47]); 
                        levelUp = JSType.toInteger(palavras[49]); 
                        telaFundo = JSType.toInteger(palavras[51]); 
                        contHistoria = JSType.toLong(palavras[53]); 
                        local = palavras[55]; 
                        contTravamento = JSType.toInteger(palavras[57]);
                        pontosAdicionaisBackup = JSType.toInteger(palavras[59]);
                        modoADM = JSType.toInteger(palavras[60]);
                        estaminaBarra = JSType.toInteger(palavras[62]);
                        
                    }
                    
                    System.out.println("telaMenuLer" + "\nNome: " + nome + "\r\nClasse: " + classeEscolhida  + "\r\nForca: "  + pontos[0]  + "\r\nConstituicao: "  + pontos[1] +  "\r\nDestreza: " + pontos[2] + "\r\nAgilidade: " + pontos[3] + "\r\nInteligencia: " + pontos[4] + "\r\nForcaDeVontade: " + pontos[5] + "\r\nPercepcao: " + pontos[6] + "\r\nCarisma: " + pontos[7] + "\r\nBackupForca: " + pontosBackup[0] + "\r\nBackupConstituicao: " + pontosBackup[1] + "\r\nBackupDestreza: " + pontosBackup[2] + "\r\nBackupAgilidade: " + pontosBackup[3] + "\r\nBackupInteligencia: " + pontosBackup[4] + "\r\nBackupForcaDeVontade: " + pontosBackup[5] + "\r\nBackupPercepcao: " + pontosBackup[6] + "\r\nBackupCarisma: " + pontosBackup[7] + "\nPontosAdicionais: " + pontos_adiconais + "\nLevelBarra: " + levelBarra + "\nLevelBarraTotal: " + levelBarraTotal+ "\nVidaBarra: " + vidaBarraPersonagem + "\nVidaBarraTotal: " + vidaBarraTotalPersonagem + "\nLevel: " + levelPersonagem + "\nLevelUP: " + levelUp + "\nTelaFundo: " + telaFundo + "\nContHistoria: " + contHistoria + "\nLocalidade: " + local + "\nContTravamento: " + contTravamento +  "\nPontosAdicionaisBackup: " + pontosAdicionaisBackup +  "\nBarra Estamina: " + estaminaBarra + "\n  -=%=-  \n");
                    escreverTela();
                }
            }while(linha != null);
            arquivo.close();
        }catch(Exception e){
            System.err.printf("|lerMenu| Erro na abertura do arquivo: %s.\n",
            e.getMessage());
        }
            
    }
    private void escritorSalvamento() {
        
        try{

        FileOutputStream arquivo = new FileOutputStream("backup\\Salvamento.txt");
        PrintWriter print = new PrintWriter(arquivo);

        print.println("Nome" + " ; " + nome + " ; " + "Classe" + " ; " + classeEscolhida + " ; " + "Forca" + " ; " + pontos[0] + " ; " + "Constituicao" + " ; " + pontos[1] + " ; " + "Destreza" + " ; " + pontos[2] + " ; " + "Agilidade" + " ; " + pontos[3] + " ; " + "Inteligencia" + " ; " + pontos[4] + " ; " + "ForcaDeVontade" + " ; " + pontos[5] + " ; " + "Percepcao" + " ; " + pontos[6] + " ; " + "Carisma" + " ; " + pontos[7] + " ; " + "BackupForca" + " ; " + pontosBackup[0] + " ; " + "BackupConstituicao" + " ; " + pontosBackup[1] + " ; " + "BackupDestreza" + " ; " + pontosBackup[2] + " ; " + "BackupAgilidade" + " ; " + pontosBackup[3] + " ; " + "BackupInteligencia" + " ; " + pontosBackup[4] + " ; " + "BackupForcaDeVontade" + " ; " + pontosBackup[5] + " ; " + "BackupPercepcao" + " ; " + pontosBackup[6] + " ; " + "BackupCarisma" + " ; " + pontosBackup[7] + " ; "   + "PontosAdicionais:" + " ; " + pontos_adiconais + " ; " + "LevelBarra" + " ; " + levelBarra+ " ; "  + "LevelBarraTotal" + " ; " + levelBarraTotal+ " ; "  + "VidaBarra" + " ; " + vidaBarraPersonagem + " ; "  + "VidaBarraTotal" + " ; " + vidaBarraTotalPersonagem + " ; " + "Level" + " ; " + levelPersonagem + " ; " + "LevelUP" + " ; " + levelUp + " ; " + "telaFundo" + " ; " + telaFundo + " ; " + "contHistoria" + " ; " + contHistoria + " ; " + "localidade" + " ; " + local + " ; " + "contTravamento" + " ; " + contTravamento + " ; " + "pontosAdicionaisBackup" + " ; " + pontosAdicionaisBackup + " ; " + modoADM + " ; " + "estaminaBarra" + " ; " + estaminaBarra + " ; ");
        System.out.println("telaMenuEscrever" + "\nNome: " + nome + "\r\nClasse: " + classeEscolhida  + "\r\nForca: "  + pontos[0]  + "\r\nConstituicao: "  + pontos[1] +  "\r\nDestreza: " + pontos[2] + "\r\nAgilidade: " + pontos[3] + "\r\nInteligencia: " + pontos[4] + "\r\nForcaDeVontade: " + pontos[5] + "\r\nPercepcao: " + pontos[6] + "\r\nCarisma: " + pontos[7] + "\r\nBackupForca: " + pontosBackup[0] + "\r\nBackupConstituicao: " + pontosBackup[1] + "\r\nBackupDestreza: " + pontosBackup[2] + "\r\nBackupAgilidade: " + pontosBackup[3] + "\r\nBackupInteligencia: " + pontosBackup[4] + "\r\nBackupForcaDeVontade: " + pontosBackup[5] + "\r\nBackupPercepcao: " + pontosBackup[6] + "\r\nBackupCarisma: " + pontosBackup[7] + "\nPontosAdicionais: " + pontos_adiconais + "\nLevelBarra: " + levelBarra + "\nLevelBarraTotal: " + levelBarraTotal+ "\nVidaBarra: " + vidaBarraPersonagem + "\nVidaBarraTotal: " + vidaBarraTotalPersonagem + "\nLevel: " + levelPersonagem + "\nLevelUP: " + levelUp + "\nTelaFundo: " + telaFundo + "\nContHistoria: " + contHistoria + "\nLocalidade: " + local + "\nContTravamento: " + contTravamento + "\nPontosAdicionaisBackup: " + pontosAdicionaisBackup + "\nBarra Estamina: " + estaminaBarra + "\n  -=%=-  \n");
        print.close();
        arquivo.close();
        
        }catch(Exception e){
            System.err.printf("|Menu|*eS1* Erro na abertura do arquivo: %s.\n",
            e.getMessage());
        }
            
    }
    private void adm(){
        if(modoADM == 1){
            admDano.setVisible(true);
            admDano.setEnabled(true);
            admOP.setVisible(true);
            admOP.setEnabled(true);
            batalha.setVisible(true);
            batalha.setEnabled(true);
            admUparLevel.setVisible(true);
            admUparLevel.setEnabled(true);
        }else{
            admDano.setVisible(false);
            admDano.setEnabled(false);
            admOP.setVisible(false);
            admOP.setEnabled(false);
            batalha.setVisible(false);
            batalha.setEnabled(false);
            admUparLevel.setVisible(false);
            admUparLevel.setEnabled(false);
        }
    }
    
    // ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
    private void salvarDados(){
        escritorSalvamento();
        escreverTela();
        adm();
        
        if(gameOver == 0){
            if(vidaBarraPersonagem <= 0){
                gameOver = 1;
                this.dispose();
                new telaGameOver().setVisible(true);
            }
        }
    }
    private void escreverTela(){
        
        textoNome.setText(nome);
        textoClasse.setText("Classe: " + classeEscolhida);
        pontosDistribuicao.setText("Pontos para distribuir: " + pontos_adiconais);
        valorForca.setText("" + pontos[0]);
        valorConstituicao.setText("" + pontos[1]);
        valorDestreza.setText("" + pontos[2]);
        valorAgilidade.setText("" + pontos[3]);
        valorInteligencia.setText("" + pontos[4]);
        valorForcaDeVontade.setText("" + pontos[5]);
        valorPercepcao.setText("" + pontos[6]);
        valorCarisma.setText("" + pontos[7]);
        
        
        levelBarraTotal = 100 + levelUp;
        
        if (levelBarra >= levelBarraTotal) {
            if(levelBarra == levelBarraTotal){
                levelPersonagem = levelPersonagem + 1;
                levelUp = levelUp + 100;
                levelBarra = 0;
                levelBarraTotal = 100 + levelUp;
                if(levelPersonagem == 2){
                    pontos_adiconais = pontos_adiconais + 4;
                    pontosAdicionaisBackup = pontosAdicionaisBackup + 4;
                    vidaBarraTotalPersonagem = 100 + (levelPersonagem * pontos[1]);
                }
                if(levelPersonagem == 3){
                    pontos_adiconais = pontos_adiconais + 6;
                    pontosAdicionaisBackup = pontosAdicionaisBackup + 6;
                    vidaBarraTotalPersonagem = 100 + (levelPersonagem * pontos[1]);
                }
                if(levelPersonagem == 4){
                    pontos_adiconais = pontos_adiconais + 8;
                    pontosAdicionaisBackup = pontosAdicionaisBackup + 8;
                    vidaBarraTotalPersonagem = 100 + (levelPersonagem * pontos[1]);
                }
                if(levelPersonagem == 5){
                    pontos_adiconais = pontos_adiconais + 10;
                    pontosAdicionaisBackup = pontosAdicionaisBackup + 10;
                    vidaBarraTotalPersonagem = 100 + (levelPersonagem * pontos[1]);
                }
                if(levelPersonagem == 6){
                    pontos_adiconais = pontos_adiconais + 12;
                    pontosAdicionaisBackup = pontosAdicionaisBackup + 12;
                    vidaBarraTotalPersonagem = 100 + (levelPersonagem * pontos[1]);
                }
                if(levelPersonagem == 7){
                    pontos_adiconais = pontos_adiconais + 14;
                    pontosAdicionaisBackup = pontosAdicionaisBackup + 14;
                    vidaBarraTotalPersonagem = 100 + (levelPersonagem * pontos[1]);
                }
                if(levelPersonagem == 8){
                    pontos_adiconais = pontos_adiconais + 16;
                    pontosAdicionaisBackup = pontosAdicionaisBackup + 16;
                    vidaBarraTotalPersonagem = 100 + (levelPersonagem * pontos[1]);
                }
                if(levelPersonagem == 9){
                    pontos_adiconais = pontos_adiconais + 18;
                    pontosAdicionaisBackup = pontosAdicionaisBackup + 18;
                    vidaBarraTotalPersonagem = 100 + (levelPersonagem * pontos[1]);
                }
                if(levelPersonagem == 10){
                    pontos_adiconais = pontos_adiconais + 20;
                    pontosAdicionaisBackup = pontosAdicionaisBackup + 20;
                    vidaBarraTotalPersonagem = 100 + (levelPersonagem * pontos[1]);
                }
            }
            if(levelBarra > levelBarraTotal){
                do{
                    levelPersonagem = levelPersonagem + 1;
                    levelUp = levelUp + 100;
                    levelBarra = levelBarra - levelBarraTotal;
                    levelBarraTotal = 100 + levelUp;
                    if(levelPersonagem == 2){
                    pontos_adiconais = pontos_adiconais + 4;
                    pontosAdicionaisBackup = pontosAdicionaisBackup + 4;
                    vidaBarraTotalPersonagem = 100 + (levelPersonagem * pontos[1]);
                    }
                    if(levelPersonagem == 3){
                        pontos_adiconais = pontos_adiconais + 6;
                        pontosAdicionaisBackup = pontosAdicionaisBackup + 6;
                        vidaBarraTotalPersonagem = 100 + (levelPersonagem * pontos[1]);
                    }
                    if(levelPersonagem == 4){
                        pontos_adiconais = pontos_adiconais + 8;
                        pontosAdicionaisBackup = pontosAdicionaisBackup + 8;
                        vidaBarraTotalPersonagem = 100 + (levelPersonagem * pontos[1]);
                    }
                    if(levelPersonagem == 5){
                        pontos_adiconais = pontos_adiconais + 10;
                        pontosAdicionaisBackup = pontosAdicionaisBackup + 10;
                        vidaBarraTotalPersonagem = 100 + (levelPersonagem * pontos[1]);
                    }
                    if(levelPersonagem == 6){
                        pontos_adiconais = pontos_adiconais + 12;
                        pontosAdicionaisBackup = pontosAdicionaisBackup + 12;
                        vidaBarraTotalPersonagem = 100 + (levelPersonagem * pontos[1]);
                    }
                    if(levelPersonagem == 7){
                        pontos_adiconais = pontos_adiconais + 14;
                        pontosAdicionaisBackup = pontosAdicionaisBackup + 14;
                        vidaBarraTotalPersonagem = 100 + (levelPersonagem * pontos[1]);
                    }
                    if(levelPersonagem == 8){
                        pontos_adiconais = pontos_adiconais + 16;
                        pontosAdicionaisBackup = pontosAdicionaisBackup + 16;
                        vidaBarraTotalPersonagem = 100 + (levelPersonagem * pontos[1]);
                    }
                    if(levelPersonagem == 9){
                        pontos_adiconais = pontos_adiconais + 18;
                        pontosAdicionaisBackup = pontosAdicionaisBackup + 18;
                        vidaBarraTotalPersonagem = 100 + (levelPersonagem * pontos[1]);
                    }
                    if(levelPersonagem == 10){
                        pontos_adiconais = pontos_adiconais + 20;
                        pontosAdicionaisBackup = pontosAdicionaisBackup + 20;
                        vidaBarraTotalPersonagem = 100 + (levelPersonagem * pontos[1]);
                    }
                }while(levelBarra > levelBarraTotal);
            }
            
        }
        
        textoLevel.setText("Level: " + levelPersonagem);
        exibirLevel.setMaximum(levelBarraTotal);
        exibirLevel.setValue(levelBarra);
        exibirLevelStatus.setText(levelBarra + " / " + levelBarraTotal);
        
        
        exibirVida.setMaximum(vidaBarraTotalPersonagem);
        exibirVida.setValue(vidaBarraPersonagem);
        exibirVidaStatus.setText(vidaBarraPersonagem + " / " + vidaBarraTotalPersonagem);
        
        if("Assassina".equals(classeEscolhida)){
            porcentagemVida1 = (vidaBarraTotalPersonagem / 100)* 30;
            porcentagemVida2 = (vidaBarraTotalPersonagem / 100)* 60;
            
            if(vidaBarraPersonagem <= porcentagemVida1){
                avatar.setIcon(assassina_3);
            }
            if(vidaBarraPersonagem <= porcentagemVida2 && vidaBarraPersonagem> porcentagemVida1){
                avatar.setIcon(assassina_2);
            }
            if(vidaBarraPersonagem > porcentagemVida2){
                avatar.setIcon(assassina_1);
            }
        }
        
        if("Cavaleiro".equals(classeEscolhida)){
            porcentagemVida1 = (vidaBarraTotalPersonagem / 100)* 30;
            porcentagemVida2 = (vidaBarraTotalPersonagem / 100)* 60;
            
            if(vidaBarraPersonagem <= porcentagemVida1){
                avatar.setIcon(cavaleiro_3);
            }
            if(vidaBarraPersonagem <= porcentagemVida2 && vidaBarraPersonagem> porcentagemVida1){
                avatar.setIcon(cavaleiro_2);
            }
            if(vidaBarraPersonagem > porcentagemVida2){
                avatar.setIcon(cavaleiro_1);
            }
        }
        
        if("Berserk".equals(classeEscolhida)){
            porcentagemVida1 = (vidaBarraTotalPersonagem / 100)* 30;
            porcentagemVida2 = (vidaBarraTotalPersonagem / 100)* 60;
            
            if(vidaBarraPersonagem <= porcentagemVida1){
                avatar.setIcon(berserk_3);
            }
            if(vidaBarraPersonagem <= porcentagemVida2 && vidaBarraPersonagem> porcentagemVida1){
                avatar.setIcon(berserk_2);
            }
            if(vidaBarraPersonagem > porcentagemVida2){
                avatar.setIcon(berserk_1);
            }
            
            textoHabilidades1.setText("Ataque Normal");
            textoHabilidades2.setText("Grito de Furia");
            textoHabilidades3.setText("Golpe Aniquilador");
            textoHabilidades4.setText("Fúria Brutal");
        }
        
        if("Arqueira".equals(classeEscolhida)){
            porcentagemVida1 = (vidaBarraTotalPersonagem / 100)* 30;
            porcentagemVida2 = (vidaBarraTotalPersonagem / 100)* 60;
            
            if(vidaBarraPersonagem <= porcentagemVida1){
                avatar.setIcon(arqueira_3);
            }
            if(vidaBarraPersonagem <= porcentagemVida2 && vidaBarraPersonagem> porcentagemVida1){
                avatar.setIcon(arqueira_2);
            }
            if(vidaBarraPersonagem > porcentagemVida2){
                avatar.setIcon(arqueira_1);
            }
            
            textoHabilidades1.setText("Tiro rápido");
            textoHabilidades2.setText("Flecha de Gelo");
            textoHabilidades3.setText("Chuva de Flechas");
            textoHabilidades4.setText("Tiro Furtivo");
        }
        
        if("Mago".equals(classeEscolhida)){
            porcentagemVida1 = (vidaBarraTotalPersonagem / 100)* 30;
            porcentagemVida2 = (vidaBarraTotalPersonagem / 100)* 60;
            
            if(vidaBarraPersonagem <= porcentagemVida1){
                avatar.setIcon(mago_3);
            }
            if(vidaBarraPersonagem <= porcentagemVida2 && vidaBarraPersonagem> porcentagemVida1){
                avatar.setIcon(mago_2);
            }
            if(vidaBarraPersonagem > porcentagemVida2){
                avatar.setIcon(mago_1);
            }
        }
        
    }
    
    // ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
    private telaMenu(Frame parent, boolean modal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    telaMenu(telaHistoria aThis, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public telaMenu(java.awt.Frame parent, boolean modal, String nome) {
        
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
        setResizable(false);
        setLocationRelativeTo(null);
        // setExtendedState(MAXIMIZED_BOTH);
        
        
        chamar chamador = new chamar();
        chamador.fundoTransparencia(this);
        
        telaInformacaoChamar = new telaInformacao();
        telaConfiguracaoChamar = new telaConfiguracao();
        telaInformacaoChamar.setVisible(false);
        telaConfiguracaoChamar.setVisible(false);
        
        telaADM.setVisible(false);
        telaADM.setEnabled(false);
        senha.setVisible(false);
        senha.setEnabled(false);
        
        this.nome = nome;
        
        pontos_adiconais = 10;
        lerSalvamento();
        escreverTela();
        
        adm();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelGeral = new javax.swing.JPanel();
        admBotao = new javax.swing.JButton();
        telaADM = new javax.swing.JPanel();
        textoSenha = new javax.swing.JLabel();
        senha = new javax.swing.JPasswordField();
        admOP = new javax.swing.JButton();
        admUparLevel = new javax.swing.JButton();
        batalha = new javax.swing.JButton();
        admDano = new javax.swing.JButton();
        continuar = new javax.swing.JButton();
        painelPontosDistribuicao = new javax.swing.JPanel();
        painelStatus = new javax.swing.JPanel();
        textoForca = new javax.swing.JLabel();
        textoConstituicao = new javax.swing.JLabel();
        textoDestreza = new javax.swing.JLabel();
        textoInteligencia = new javax.swing.JLabel();
        textoForcaDeVontade = new javax.swing.JLabel();
        textoPercepcao = new javax.swing.JLabel();
        textoCarisma = new javax.swing.JLabel();
        textoAgilidade = new javax.swing.JLabel();
        painelPontos = new javax.swing.JPanel();
        valorForca = new javax.swing.JLabel();
        valorConstituicao = new javax.swing.JLabel();
        valorDestreza = new javax.swing.JLabel();
        valorAgilidade = new javax.swing.JLabel();
        valorInteligencia = new javax.swing.JLabel();
        valorForcaDeVontade = new javax.swing.JLabel();
        valorPercepcao = new javax.swing.JLabel();
        valorCarisma = new javax.swing.JLabel();
        forca1 = new javax.swing.JButton();
        constituicao1 = new javax.swing.JButton();
        destreza1 = new javax.swing.JButton();
        agilidade1 = new javax.swing.JButton();
        inteligencia1 = new javax.swing.JButton();
        ForcaDeVontade1 = new javax.swing.JButton();
        percepcao1 = new javax.swing.JButton();
        carisma1 = new javax.swing.JButton();
        pontosDistribuicao = new javax.swing.JLabel();
        resetPontos = new javax.swing.JButton();
        textoHabilidades = new javax.swing.JLabel();
        textoHabilidades1 = new javax.swing.JLabel();
        textoHabilidades2 = new javax.swing.JLabel();
        textoHabilidades3 = new javax.swing.JLabel();
        textoHabilidades4 = new javax.swing.JLabel();
        textoHabilidades5 = new javax.swing.JLabel();
        textoHabilidades6 = new javax.swing.JLabel();
        textoXP = new javax.swing.JLabel();
        textoVida = new javax.swing.JLabel();
        exibirLevelStatus = new javax.swing.JLabel();
        exibirLevel = new javax.swing.JProgressBar();
        exibirVidaStatus = new javax.swing.JLabel();
        exibirVida = new javax.swing.JProgressBar();
        textoLevel = new javax.swing.JLabel();
        textoNome = new javax.swing.JLabel();
        textoClasse = new javax.swing.JLabel();
        painelBotoes = new javax.swing.JPanel();
        abrirInformacoes = new javax.swing.JButton();
        abrirConfiguracoes = new javax.swing.JButton();
        Home = new javax.swing.JButton();
        avatar = new javax.swing.JLabel();
        fundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);
        setMaximumSize(null);
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setName("jMenu"); // NOI18N
        setUndecorated(true);
        setSize(new java.awt.Dimension(1280, 720));
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

        painelGeral.setBackground(new java.awt.Color(255, 255, 255));
        painelGeral.setToolTipText("");
        painelGeral.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        painelGeral.setMinimumSize(new java.awt.Dimension(1280, 720));
        painelGeral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        admBotao.setFont(new java.awt.Font("Dialog", 0, 3)); // NOI18N
        admBotao.setBorder(null);
        admBotao.setBorderPainted(false);
        admBotao.setContentAreaFilled(false);
        admBotao.setDefaultCapable(false);
        admBotao.setFocusPainted(false);
        admBotao.setFocusable(false);
        admBotao.setVerifyInputWhenFocusTarget(false);
        admBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admBotaoActionPerformed(evt);
            }
        });
        painelGeral.add(admBotao, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 20, 20));

        telaADM.setFocusable(false);
        telaADM.setOpaque(false);
        telaADM.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textoSenha.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        textoSenha.setForeground(new java.awt.Color(60, 60, 60));
        textoSenha.setText("Digite a senha:");
        textoSenha.setFocusable(false);
        telaADM.add(textoSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 119, -1));

        senha.setBackground(new java.awt.Color(60, 60, 60));
        senha.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        senha.setForeground(new java.awt.Color(153, 153, 153));
        senha.setAutoscrolls(false);
        senha.setBorder(null);
        senha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                senhaActionPerformed(evt);
            }
        });
        telaADM.add(senha, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 200, 25));

        painelGeral.add(telaADM, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 640, 240, 70));

        admOP.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        admOP.setForeground(new java.awt.Color(153, 153, 153));
        admOP.setText("Modo OP");
        admOP.setBorderPainted(false);
        admOP.setContentAreaFilled(false);
        admOP.setFocusable(false);
        admOP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admOPActionPerformed(evt);
            }
        });
        painelGeral.add(admOP, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 100, 20));

        admUparLevel.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        admUparLevel.setForeground(new java.awt.Color(153, 153, 153));
        admUparLevel.setText("Upar Level");
        admUparLevel.setBorderPainted(false);
        admUparLevel.setContentAreaFilled(false);
        admUparLevel.setFocusable(false);
        admUparLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admUparLevelActionPerformed(evt);
            }
        });
        painelGeral.add(admUparLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, -1, 20));

        batalha.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        batalha.setForeground(new java.awt.Color(153, 153, 153));
        batalha.setText("Tela Batalha");
        batalha.setBorderPainted(false);
        batalha.setContentAreaFilled(false);
        batalha.setFocusable(false);
        batalha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalhaActionPerformed(evt);
            }
        });
        painelGeral.add(batalha, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, -1, 20));

        admDano.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        admDano.setForeground(new java.awt.Color(153, 153, 153));
        admDano.setText("20 de Dano");
        admDano.setBorderPainted(false);
        admDano.setContentAreaFilled(false);
        admDano.setFocusable(false);
        admDano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admDanoActionPerformed(evt);
            }
        });
        painelGeral.add(admDano, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, -1, 20));

        continuar.setBackground(new java.awt.Color(172, 172, 172));
        continuar.setFont(new java.awt.Font("Dubai Medium", 0, 40)); // NOI18N
        continuar.setForeground(new java.awt.Color(60, 60, 60));
        continuar.setText("Continuar");
        continuar.setToolTipText("");
        continuar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        continuar.setBorderPainted(false);
        continuar.setContentAreaFilled(false);
        continuar.setFocusable(false);
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
        painelGeral.add(continuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 650, 230, 40));

        painelPontosDistribuicao.setBackground(new java.awt.Color(255, 255, 255));
        painelPontosDistribuicao.setForeground(new java.awt.Color(255, 255, 255));
        painelPontosDistribuicao.setToolTipText("");
        painelPontosDistribuicao.setOpaque(false);

        painelStatus.setBackground(new java.awt.Color(255, 255, 255));
        painelStatus.setForeground(new java.awt.Color(255, 255, 255));
        painelStatus.setOpaque(false);
        painelStatus.setPreferredSize(new java.awt.Dimension(10, 25));

        textoForca.setBackground(new java.awt.Color(255, 255, 255));
        textoForca.setFont(new java.awt.Font("DialogInput", 2, 12)); // NOI18N
        textoForca.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoForca.setText("Força");
        textoForca.setMaximumSize(new java.awt.Dimension(120, 25));
        textoForca.setMinimumSize(new java.awt.Dimension(120, 25));
        textoForca.setPreferredSize(new java.awt.Dimension(120, 25));

        textoConstituicao.setBackground(new java.awt.Color(255, 255, 255));
        textoConstituicao.setFont(new java.awt.Font("DialogInput", 2, 12)); // NOI18N
        textoConstituicao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoConstituicao.setText("Constituição");
        textoConstituicao.setMaximumSize(new java.awt.Dimension(120, 25));
        textoConstituicao.setMinimumSize(new java.awt.Dimension(120, 25));
        textoConstituicao.setPreferredSize(new java.awt.Dimension(120, 25));

        textoDestreza.setBackground(new java.awt.Color(255, 255, 255));
        textoDestreza.setFont(new java.awt.Font("DialogInput", 2, 12)); // NOI18N
        textoDestreza.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoDestreza.setText("Destreza");
        textoDestreza.setMaximumSize(new java.awt.Dimension(120, 25));
        textoDestreza.setMinimumSize(new java.awt.Dimension(120, 25));
        textoDestreza.setPreferredSize(new java.awt.Dimension(120, 25));

        textoInteligencia.setFont(new java.awt.Font("DialogInput", 2, 12)); // NOI18N
        textoInteligencia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoInteligencia.setText("Inteligência");
        textoInteligencia.setMaximumSize(new java.awt.Dimension(120, 25));
        textoInteligencia.setMinimumSize(new java.awt.Dimension(120, 25));
        textoInteligencia.setPreferredSize(new java.awt.Dimension(120, 25));

        textoForcaDeVontade.setFont(new java.awt.Font("DialogInput", 2, 12)); // NOI18N
        textoForcaDeVontade.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoForcaDeVontade.setText("Força de Vontade");
        textoForcaDeVontade.setMaximumSize(new java.awt.Dimension(120, 25));
        textoForcaDeVontade.setMinimumSize(new java.awt.Dimension(120, 25));
        textoForcaDeVontade.setPreferredSize(new java.awt.Dimension(120, 25));

        textoPercepcao.setFont(new java.awt.Font("DialogInput", 2, 12)); // NOI18N
        textoPercepcao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoPercepcao.setText("Percepção");
        textoPercepcao.setMaximumSize(new java.awt.Dimension(120, 25));
        textoPercepcao.setMinimumSize(new java.awt.Dimension(120, 25));
        textoPercepcao.setPreferredSize(new java.awt.Dimension(120, 25));

        textoCarisma.setFont(new java.awt.Font("DialogInput", 2, 12)); // NOI18N
        textoCarisma.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoCarisma.setText("Carisma");
        textoCarisma.setMaximumSize(new java.awt.Dimension(120, 25));
        textoCarisma.setMinimumSize(new java.awt.Dimension(120, 25));
        textoCarisma.setPreferredSize(new java.awt.Dimension(120, 25));

        textoAgilidade.setFont(new java.awt.Font("DialogInput", 2, 12)); // NOI18N
        textoAgilidade.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoAgilidade.setText("Agilidade");
        textoAgilidade.setMaximumSize(new java.awt.Dimension(120, 25));
        textoAgilidade.setMinimumSize(new java.awt.Dimension(120, 25));
        textoAgilidade.setPreferredSize(new java.awt.Dimension(120, 25));

        javax.swing.GroupLayout painelStatusLayout = new javax.swing.GroupLayout(painelStatus);
        painelStatus.setLayout(painelStatusLayout);
        painelStatusLayout.setHorizontalGroup(
            painelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelStatusLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelStatusLayout.createSequentialGroup()
                        .addGroup(painelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textoForca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textoConstituicao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textoDestreza, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textoInteligencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textoForcaDeVontade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(13, 13, 13))
                    .addGroup(painelStatusLayout.createSequentialGroup()
                        .addComponent(textoPercepcao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(textoCarisma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelStatusLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(textoAgilidade, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        painelStatusLayout.setVerticalGroup(
            painelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelStatusLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textoForca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(textoConstituicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(textoDestreza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoAgilidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(textoInteligencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoForcaDeVontade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoPercepcao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoCarisma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        painelPontos.setBackground(new java.awt.Color(255, 255, 255));
        painelPontos.setForeground(new java.awt.Color(255, 255, 255));
        painelPontos.setOpaque(false);

        valorForca.setForeground(new java.awt.Color(0, 0, 0));
        valorForca.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        valorForca.setText("0");
        valorForca.setMaximumSize(new java.awt.Dimension(10, 25));
        valorForca.setMinimumSize(new java.awt.Dimension(10, 25));
        valorForca.setPreferredSize(new java.awt.Dimension(10, 25));

        valorConstituicao.setForeground(new java.awt.Color(0, 0, 0));
        valorConstituicao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        valorConstituicao.setText("0");
        valorConstituicao.setMaximumSize(new java.awt.Dimension(10, 25));
        valorConstituicao.setMinimumSize(new java.awt.Dimension(10, 25));
        valorConstituicao.setPreferredSize(new java.awt.Dimension(10, 25));

        valorDestreza.setForeground(new java.awt.Color(0, 0, 0));
        valorDestreza.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        valorDestreza.setText("0");
        valorDestreza.setMaximumSize(new java.awt.Dimension(10, 25));
        valorDestreza.setMinimumSize(new java.awt.Dimension(10, 25));
        valorDestreza.setPreferredSize(new java.awt.Dimension(10, 25));

        valorAgilidade.setForeground(new java.awt.Color(0, 0, 0));
        valorAgilidade.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        valorAgilidade.setText("0");
        valorAgilidade.setMaximumSize(new java.awt.Dimension(10, 25));
        valorAgilidade.setMinimumSize(new java.awt.Dimension(10, 25));
        valorAgilidade.setPreferredSize(new java.awt.Dimension(10, 25));

        valorInteligencia.setForeground(new java.awt.Color(0, 0, 0));
        valorInteligencia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        valorInteligencia.setText("0");
        valorInteligencia.setMaximumSize(new java.awt.Dimension(10, 25));
        valorInteligencia.setMinimumSize(new java.awt.Dimension(10, 25));
        valorInteligencia.setPreferredSize(new java.awt.Dimension(10, 25));

        valorForcaDeVontade.setForeground(new java.awt.Color(0, 0, 0));
        valorForcaDeVontade.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        valorForcaDeVontade.setText("0");
        valorForcaDeVontade.setMaximumSize(new java.awt.Dimension(10, 25));
        valorForcaDeVontade.setMinimumSize(new java.awt.Dimension(10, 25));
        valorForcaDeVontade.setPreferredSize(new java.awt.Dimension(10, 25));

        valorPercepcao.setForeground(new java.awt.Color(0, 0, 0));
        valorPercepcao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        valorPercepcao.setText("0");
        valorPercepcao.setMaximumSize(new java.awt.Dimension(10, 25));
        valorPercepcao.setMinimumSize(new java.awt.Dimension(10, 25));
        valorPercepcao.setPreferredSize(new java.awt.Dimension(10, 25));

        valorCarisma.setForeground(new java.awt.Color(0, 0, 0));
        valorCarisma.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        valorCarisma.setText("0");
        valorCarisma.setMaximumSize(new java.awt.Dimension(10, 25));
        valorCarisma.setMinimumSize(new java.awt.Dimension(10, 25));
        valorCarisma.setPreferredSize(new java.awt.Dimension(10, 25));

        forca1.setBackground(new java.awt.Color(172, 172, 172));
        forca1.setText("+1");
        forca1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        forca1.setFocusable(false);
        forca1.setMaximumSize(new java.awt.Dimension(50, 25));
        forca1.setMinimumSize(new java.awt.Dimension(50, 25));
        forca1.setPreferredSize(new java.awt.Dimension(50, 25));
        forca1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                forca1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                forca1MouseExited(evt);
            }
        });
        forca1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forca1ActionPerformed(evt);
            }
        });

        constituicao1.setBackground(new java.awt.Color(172, 172, 172));
        constituicao1.setText("+1");
        constituicao1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        constituicao1.setFocusable(false);
        constituicao1.setMaximumSize(new java.awt.Dimension(50, 25));
        constituicao1.setMinimumSize(new java.awt.Dimension(50, 25));
        constituicao1.setPreferredSize(new java.awt.Dimension(50, 25));
        constituicao1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                constituicao1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                constituicao1MouseExited(evt);
            }
        });
        constituicao1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                constituicao1ActionPerformed(evt);
            }
        });

        destreza1.setBackground(new java.awt.Color(172, 172, 172));
        destreza1.setText("+1");
        destreza1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        destreza1.setFocusable(false);
        destreza1.setMaximumSize(new java.awt.Dimension(50, 25));
        destreza1.setMinimumSize(new java.awt.Dimension(50, 25));
        destreza1.setPreferredSize(new java.awt.Dimension(50, 25));
        destreza1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                destreza1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                destreza1MouseExited(evt);
            }
        });
        destreza1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                destreza1ActionPerformed(evt);
            }
        });

        agilidade1.setBackground(new java.awt.Color(172, 172, 172));
        agilidade1.setText("+1");
        agilidade1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        agilidade1.setFocusable(false);
        agilidade1.setMaximumSize(new java.awt.Dimension(50, 25));
        agilidade1.setMinimumSize(new java.awt.Dimension(50, 25));
        agilidade1.setPreferredSize(new java.awt.Dimension(50, 25));
        agilidade1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                agilidade1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                agilidade1MouseExited(evt);
            }
        });
        agilidade1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agilidade1ActionPerformed(evt);
            }
        });

        inteligencia1.setBackground(new java.awt.Color(172, 172, 172));
        inteligencia1.setText("+1");
        inteligencia1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        inteligencia1.setFocusable(false);
        inteligencia1.setMaximumSize(new java.awt.Dimension(50, 25));
        inteligencia1.setMinimumSize(new java.awt.Dimension(50, 25));
        inteligencia1.setPreferredSize(new java.awt.Dimension(50, 25));
        inteligencia1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inteligencia1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                inteligencia1MouseExited(evt);
            }
        });
        inteligencia1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inteligencia1ActionPerformed(evt);
            }
        });

        ForcaDeVontade1.setBackground(new java.awt.Color(172, 172, 172));
        ForcaDeVontade1.setText("+1");
        ForcaDeVontade1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        ForcaDeVontade1.setFocusable(false);
        ForcaDeVontade1.setMaximumSize(new java.awt.Dimension(50, 25));
        ForcaDeVontade1.setMinimumSize(new java.awt.Dimension(50, 25));
        ForcaDeVontade1.setPreferredSize(new java.awt.Dimension(50, 25));
        ForcaDeVontade1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ForcaDeVontade1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ForcaDeVontade1MouseExited(evt);
            }
        });
        ForcaDeVontade1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ForcaDeVontade1ActionPerformed(evt);
            }
        });

        percepcao1.setBackground(new java.awt.Color(172, 172, 172));
        percepcao1.setText("+1");
        percepcao1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        percepcao1.setFocusable(false);
        percepcao1.setMaximumSize(new java.awt.Dimension(50, 25));
        percepcao1.setMinimumSize(new java.awt.Dimension(50, 25));
        percepcao1.setPreferredSize(new java.awt.Dimension(50, 25));
        percepcao1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                percepcao1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                percepcao1MouseExited(evt);
            }
        });
        percepcao1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                percepcao1ActionPerformed(evt);
            }
        });

        carisma1.setBackground(new java.awt.Color(172, 172, 172));
        carisma1.setText("+1");
        carisma1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        carisma1.setFocusable(false);
        carisma1.setMaximumSize(new java.awt.Dimension(50, 25));
        carisma1.setMinimumSize(new java.awt.Dimension(50, 25));
        carisma1.setPreferredSize(new java.awt.Dimension(50, 25));
        carisma1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                carisma1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                carisma1MouseExited(evt);
            }
        });
        carisma1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carisma1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelPontosLayout = new javax.swing.GroupLayout(painelPontos);
        painelPontos.setLayout(painelPontosLayout);
        painelPontosLayout.setHorizontalGroup(
            painelPontosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPontosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelPontosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPontosLayout.createSequentialGroup()
                        .addGroup(painelPontosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelPontosLayout.createSequentialGroup()
                                .addComponent(valorCarisma, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPontosLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(valorPercepcao, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(valorForcaDeVontade, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelPontosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(carisma1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(percepcao1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ForcaDeVontade1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(59, 59, 59))
                    .addGroup(painelPontosLayout.createSequentialGroup()
                        .addGroup(painelPontosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(valorForca, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(valorConstituicao, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(valorDestreza, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(valorAgilidade, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(valorInteligencia, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelPontosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelPontosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(inteligencia1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(destreza1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(agilidade1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(forca1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(constituicao1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53))))
        );
        painelPontosLayout.setVerticalGroup(
            painelPontosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPontosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelPontosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(valorForca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(forca1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(painelPontosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelPontosLayout.createSequentialGroup()
                        .addGroup(painelPontosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(valorConstituicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(painelPontosLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(constituicao1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelPontosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(destreza1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(valorDestreza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(agilidade1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelPontosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inteligencia1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(valorInteligencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(painelPontosLayout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(valorAgilidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelPontosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ForcaDeVontade1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valorForcaDeVontade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelPontosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(percepcao1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valorPercepcao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(painelPontosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(carisma1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valorCarisma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        pontosDistribuicao.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        pontosDistribuicao.setText("Pontos para distribuir ");

        resetPontos.setBackground(new java.awt.Color(172, 172, 172));
        resetPontos.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        resetPontos.setText("Voce deseja resetar seus pontos?");
        resetPontos.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        resetPontos.setBorderPainted(false);
        resetPontos.setContentAreaFilled(false);
        resetPontos.setFocusable(false);
        resetPontos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                resetPontosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                resetPontosMouseExited(evt);
            }
        });
        resetPontos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetPontosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelPontosDistribuicaoLayout = new javax.swing.GroupLayout(painelPontosDistribuicao);
        painelPontosDistribuicao.setLayout(painelPontosDistribuicaoLayout);
        painelPontosDistribuicaoLayout.setHorizontalGroup(
            painelPontosDistribuicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPontosDistribuicaoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelPontosDistribuicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelPontosDistribuicaoLayout.createSequentialGroup()
                        .addComponent(painelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(painelPontos, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pontosDistribuicao, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(painelPontosDistribuicaoLayout.createSequentialGroup()
                .addComponent(resetPontos, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        painelPontosDistribuicaoLayout.setVerticalGroup(
            painelPontosDistribuicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPontosDistribuicaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pontosDistribuicao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelPontosDistribuicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelPontos, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(painelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resetPontos, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
        );

        painelGeral.add(painelPontosDistribuicao, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 280, 330));

        textoHabilidades.setFont(new java.awt.Font("Dubai Medium", 1, 36)); // NOI18N
        textoHabilidades.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoHabilidades.setText("Habilidades");
        painelGeral.add(textoHabilidades, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 200, 308, 60));

        textoHabilidades1.setFont(new java.awt.Font("Dubai Medium", 0, 20)); // NOI18N
        textoHabilidades1.setForeground(new java.awt.Color(60, 60, 60));
        textoHabilidades1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoHabilidades1.setText("1");
        painelGeral.add(textoHabilidades1, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 280, 308, 40));

        textoHabilidades2.setFont(new java.awt.Font("Dubai Medium", 0, 20)); // NOI18N
        textoHabilidades2.setForeground(new java.awt.Color(60, 60, 60));
        textoHabilidades2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoHabilidades2.setText("2");
        painelGeral.add(textoHabilidades2, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 320, 308, 40));

        textoHabilidades3.setFont(new java.awt.Font("Dubai Medium", 0, 20)); // NOI18N
        textoHabilidades3.setForeground(new java.awt.Color(60, 60, 60));
        textoHabilidades3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoHabilidades3.setText("3");
        painelGeral.add(textoHabilidades3, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 360, 308, 40));

        textoHabilidades4.setFont(new java.awt.Font("Dubai Medium", 0, 20)); // NOI18N
        textoHabilidades4.setForeground(new java.awt.Color(60, 60, 60));
        textoHabilidades4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoHabilidades4.setText("4");
        painelGeral.add(textoHabilidades4, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 400, 308, 40));

        textoHabilidades5.setFont(new java.awt.Font("Dubai Medium", 0, 20)); // NOI18N
        textoHabilidades5.setForeground(new java.awt.Color(60, 60, 60));
        textoHabilidades5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoHabilidades5.setText("Percepção");
        painelGeral.add(textoHabilidades5, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 440, 308, 40));

        textoHabilidades6.setFont(new java.awt.Font("Dubai Medium", 0, 20)); // NOI18N
        textoHabilidades6.setForeground(new java.awt.Color(60, 60, 60));
        textoHabilidades6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoHabilidades6.setText("Recuperar ST");
        painelGeral.add(textoHabilidades6, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 480, 308, 40));

        textoXP.setText(" XP");
        painelGeral.add(textoXP, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, -1, -1));

        textoVida.setText(" HP");
        painelGeral.add(textoVida, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, -1, -1));

        exibirLevelStatus.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        exibirLevelStatus.setForeground(new java.awt.Color(0, 0, 0));
        exibirLevelStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exibirLevelStatus.setText("0 / 100");
        exibirLevelStatus.setMaximumSize(new java.awt.Dimension(170, 17));
        exibirLevelStatus.setMinimumSize(new java.awt.Dimension(170, 17));
        exibirLevelStatus.setPreferredSize(new java.awt.Dimension(170, 17));
        painelGeral.add(exibirLevelStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, -1, -1));

        exibirLevel.setBackground(new java.awt.Color(156, 156, 156));
        exibirLevel.setForeground(new java.awt.Color(67, 52, 212));
        exibirLevel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        exibirLevel.setBorderPainted(false);
        exibirLevel.setMaximumSize(new java.awt.Dimension(170, 17));
        exibirLevel.setMinimumSize(new java.awt.Dimension(170, 17));
        exibirLevel.setPreferredSize(new java.awt.Dimension(170, 17));
        exibirLevel.setString("");
        exibirLevel.setStringPainted(true);
        painelGeral.add(exibirLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, -1, -1));

        exibirVidaStatus.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        exibirVidaStatus.setForeground(new java.awt.Color(0, 0, 0));
        exibirVidaStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exibirVidaStatus.setText("0 / 100");
        exibirVidaStatus.setMaximumSize(new java.awt.Dimension(170, 17));
        exibirVidaStatus.setMinimumSize(new java.awt.Dimension(170, 17));
        exibirVidaStatus.setPreferredSize(new java.awt.Dimension(170, 17));
        painelGeral.add(exibirVidaStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, -1));

        exibirVida.setBackground(new java.awt.Color(156, 156, 156));
        exibirVida.setForeground(new java.awt.Color(175, 30, 30));
        exibirVida.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        exibirVida.setBorderPainted(false);
        exibirVida.setMaximumSize(new java.awt.Dimension(170, 17));
        exibirVida.setMinimumSize(new java.awt.Dimension(170, 17));
        exibirVida.setPreferredSize(new java.awt.Dimension(170, 17));
        exibirVida.setString("");
        exibirVida.setStringPainted(true);
        painelGeral.add(exibirVida, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, -1));

        textoLevel.setFont(new java.awt.Font("MV Boli", 0, 16)); // NOI18N
        textoLevel.setText("Level: ");
        painelGeral.add(textoLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 211, -1));

        textoNome.setFont(new java.awt.Font("Freshman", 0, 36)); // NOI18N
        textoNome.setForeground(new java.awt.Color(0, 0, 0));
        textoNome.setText("Nome ");
        painelGeral.add(textoNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 250, -1));

        textoClasse.setFont(new java.awt.Font("MV Boli", 0, 16)); // NOI18N
        textoClasse.setText("Classe: ");
        painelGeral.add(textoClasse, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 200, -1));

        painelBotoes.setForeground(new java.awt.Color(204, 0, 51));
        painelBotoes.setOpaque(false);
        painelBotoes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        abrirInformacoes.setBackground(new java.awt.Color(172, 172, 172));
        abrirInformacoes.setFont(new java.awt.Font("Imprint MT Shadow", 0, 22)); // NOI18N
        abrirInformacoes.setText("Informações");
        abrirInformacoes.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        abrirInformacoes.setBorderPainted(false);
        abrirInformacoes.setContentAreaFilled(false);
        abrirInformacoes.setFocusable(false);
        abrirInformacoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                abrirInformacoesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                abrirInformacoesMouseExited(evt);
            }
        });
        abrirInformacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirInformacoesActionPerformed(evt);
            }
        });
        painelBotoes.add(abrirInformacoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 140, -1));

        abrirConfiguracoes.setBackground(new java.awt.Color(172, 172, 172));
        abrirConfiguracoes.setFont(new java.awt.Font("Imprint MT Shadow", 0, 22)); // NOI18N
        abrirConfiguracoes.setText("Configurações");
        abrirConfiguracoes.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        abrirConfiguracoes.setBorderPainted(false);
        abrirConfiguracoes.setContentAreaFilled(false);
        abrirConfiguracoes.setFocusable(false);
        abrirConfiguracoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                abrirConfiguracoesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                abrirConfiguracoesMouseExited(evt);
            }
        });
        abrirConfiguracoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirConfiguracoesActionPerformed(evt);
            }
        });
        painelBotoes.add(abrirConfiguracoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 160, -1));

        Home.setBackground(new java.awt.Color(172, 172, 172));
        Home.setFont(new java.awt.Font("Imprint MT Shadow", 0, 24)); // NOI18N
        Home.setText("Home");
        Home.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Home.setBorderPainted(false);
        Home.setContentAreaFilled(false);
        Home.setFocusable(false);
        Home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                HomeMouseExited(evt);
            }
        });
        Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeActionPerformed(evt);
            }
        });
        painelBotoes.add(Home, new org.netbeans.lib.awtextra.AbsoluteConstraints(331, 10, 80, -1));

        painelGeral.add(painelBotoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 0, 430, 60));

        avatar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        painelGeral.add(avatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 210, 300, 300));

        fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundoMenu.png"))); // NOI18N
        fundo.setText("Funnddooo");
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

        getAccessibleContext().setAccessibleName("jMenu");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void abrirConfiguracoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirConfiguracoesActionPerformed

        telaConfiguracaoChamar.setVisible(true);
        salvarDados();
        
    }//GEN-LAST:event_abrirConfiguracoesActionPerformed

    private void forca1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forca1ActionPerformed

        if(pontos_adiconais > 0)
        {
            pontos_adiconais = pontos_adiconais - 1;
            pontos[0] = pontos[0] + 1;
            valorForca.setText("" + pontos[0]);
            pontosDistribuicao.setText("Pontos para distribuir: " + pontos_adiconais);
            
            salvarDados();
        }
    }//GEN-LAST:event_forca1ActionPerformed

    private void constituicao1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_constituicao1ActionPerformed

        if(pontos_adiconais > 0)
        {
            pontos_adiconais = pontos_adiconais - 1;
            pontos[1] = pontos[1] + 1;
            valorConstituicao.setText("" + pontos[1]);
            pontosDistribuicao.setText("Pontos para distribuir: " + pontos_adiconais);
            
            escreverTela();
            salvarDados();
        }

    }//GEN-LAST:event_constituicao1ActionPerformed

    private void destreza1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_destreza1ActionPerformed

        if(pontos_adiconais > 0)
        {
            pontos_adiconais = pontos_adiconais - 1;
            pontos[2] = pontos[2] + 1;
            valorDestreza.setText("" + pontos[2]);
            pontosDistribuicao.setText("Pontos para distribuir: " + pontos_adiconais);
            
            salvarDados();
        }

    }//GEN-LAST:event_destreza1ActionPerformed

    private void agilidade1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agilidade1ActionPerformed

        if(pontos_adiconais > 0)
        {
            pontos_adiconais = pontos_adiconais - 1;
            pontos[3] = pontos[3] + 1;
            valorAgilidade.setText("" + pontos[3]);
            pontosDistribuicao.setText("Pontos para distribuir: " + pontos_adiconais);
            
            salvarDados();
        }

    }//GEN-LAST:event_agilidade1ActionPerformed

    private void inteligencia1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inteligencia1ActionPerformed

        if(pontos_adiconais > 0)
        {
            pontos_adiconais = pontos_adiconais - 1;
            pontos[4] = pontos[4] + 1;
            valorInteligencia.setText("" + pontos[4]);
            pontosDistribuicao.setText("Pontos para distribuir: " + pontos_adiconais);
            
            salvarDados();
        }

    }//GEN-LAST:event_inteligencia1ActionPerformed

    private void ForcaDeVontade1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ForcaDeVontade1ActionPerformed

        if(pontos_adiconais > 0)
        {
            pontos_adiconais = pontos_adiconais - 1;
            pontos[5] = pontos[5] + 1;
            valorForcaDeVontade.setText("" + pontos[5]);
            pontosDistribuicao.setText("Pontos para distribuir: " + pontos_adiconais);
            
            salvarDados();
        }

    }//GEN-LAST:event_ForcaDeVontade1ActionPerformed

    private void percepcao1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_percepcao1ActionPerformed

        if(pontos_adiconais > 0)
        {
            pontos_adiconais = pontos_adiconais - 1;
            pontos[6] = pontos[6] + 1;
            valorPercepcao.setText("" + pontos[6]);
            pontosDistribuicao.setText("Pontos para distribuir: " + pontos_adiconais);
            
            salvarDados();
        }

    }//GEN-LAST:event_percepcao1ActionPerformed

    private void carisma1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carisma1ActionPerformed

        if(pontos_adiconais > 0)
        {
            pontos_adiconais = pontos_adiconais - 1;
            pontos[7] = pontos[7] + 1;
            valorCarisma.setText("" + pontos[7]);
            pontosDistribuicao.setText("Pontos para distribuir: " + pontos_adiconais);
            
            salvarDados();
        }

    }//GEN-LAST:event_carisma1ActionPerformed

    private void continuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continuarActionPerformed
        
        new telaHistoria().setVisible(true);
        salvarDados();
        this.dispose();
        
        
    }//GEN-LAST:event_continuarActionPerformed

    private void resetPontosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetPontosActionPerformed
        
        for(int Cont = 0; Cont <8; Cont++)
        {
            pontos[Cont] = pontosBackup[Cont];
        } 
        
        escreverTela();
        
        pontos_adiconais = pontosAdicionaisBackup;
        pontosDistribuicao.setText("Pontos para distribuir: " + pontos_adiconais);
        valorForca.setText("" + pontosBackup[0]);
        valorConstituicao.setText("" + pontosBackup[1]);
        valorDestreza.setText("" + pontosBackup[2]);
        valorAgilidade.setText("" + pontosBackup[3]);
        valorInteligencia.setText("" + pontosBackup[4]);
        valorForcaDeVontade.setText("" + pontosBackup[5]);
        valorPercepcao.setText("" + pontosBackup[6]);
        valorCarisma.setText("" + pontosBackup[7]);
        
        vidaBarraTotalPersonagem = 100 + pontos[1];
        exibirVida.setMaximum(vidaBarraTotalPersonagem);
        exibirVida.setValue(vidaBarraPersonagem);
        exibirVidaStatus.setText(vidaBarraPersonagem + " / " + vidaBarraTotalPersonagem);
        if(vidaBarraPersonagem> vidaBarraTotalPersonagem){
            correcaoVida = vidaBarraPersonagem - vidaBarraTotalPersonagem;
            vidaBarraPersonagem = vidaBarraPersonagem -(correcaoVida);
        }
        
        salvarDados();
        
        
    }//GEN-LAST:event_resetPontosActionPerformed

    private void HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeActionPerformed
        
        salvarDados();
        new telaInicio().setVisible(true);
        this.dispose();
        
        
    }//GEN-LAST:event_HomeActionPerformed

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        point.x = evt.getX();
        point.y = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        Point point = this.getLocation();
        this.setLocation(point.x + evt.getX() - point.x, point.y + evt.getY() - point.y);
    }//GEN-LAST:event_formMouseDragged

    private void continuarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_continuarMouseEntered
        continuar.setForeground(new Color(172,172,172));
    }//GEN-LAST:event_continuarMouseEntered

    private void continuarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_continuarMouseExited
        continuar.setForeground(new Color(60,60,60));
    }//GEN-LAST:event_continuarMouseExited

    private void forca1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forca1MouseEntered
        forca1.setBackground(new Color(60,60,60));
        forca1.setForeground(new Color(172,172,172));
    }//GEN-LAST:event_forca1MouseEntered

    private void forca1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forca1MouseExited
        forca1.setBackground(new Color(172,172,172));
        forca1.setForeground(new Color(60,60,60));
    }//GEN-LAST:event_forca1MouseExited

    private void constituicao1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_constituicao1MouseEntered
        constituicao1.setBackground(new Color(60,60,60));
        constituicao1.setForeground(new Color(172,172,172));
    }//GEN-LAST:event_constituicao1MouseEntered

    private void constituicao1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_constituicao1MouseExited
        constituicao1.setBackground(new Color(172,172,172));
        constituicao1.setForeground(new Color(60,60,60));
    }//GEN-LAST:event_constituicao1MouseExited

    private void destreza1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_destreza1MouseEntered
        destreza1.setBackground(new Color(60,60,60));
        destreza1.setForeground(new Color(172,172,172));
    }//GEN-LAST:event_destreza1MouseEntered

    private void destreza1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_destreza1MouseExited
        destreza1.setBackground(new Color(172,172,172));
        destreza1.setForeground(new Color(60,60,60));
    }//GEN-LAST:event_destreza1MouseExited

    private void agilidade1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agilidade1MouseEntered
        agilidade1.setBackground(new Color(60,60,60));
        agilidade1.setForeground(new Color(172,172,172));
    }//GEN-LAST:event_agilidade1MouseEntered

    private void agilidade1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agilidade1MouseExited
        agilidade1.setBackground(new Color(172,172,172));
        agilidade1.setForeground(new Color(60,60,60));
    }//GEN-LAST:event_agilidade1MouseExited

    private void inteligencia1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inteligencia1MouseEntered
        inteligencia1.setBackground(new Color(60,60,60));
        inteligencia1.setForeground(new Color(172,172,172));
    }//GEN-LAST:event_inteligencia1MouseEntered

    private void inteligencia1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inteligencia1MouseExited
        inteligencia1.setBackground(new Color(172,172,172));
        inteligencia1.setForeground(new Color(60,60,60));
    }//GEN-LAST:event_inteligencia1MouseExited

    private void ForcaDeVontade1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ForcaDeVontade1MouseEntered
       ForcaDeVontade1.setBackground(new Color(60,60,60));
       ForcaDeVontade1.setForeground(new Color(172,172,172));
    }//GEN-LAST:event_ForcaDeVontade1MouseEntered

    private void ForcaDeVontade1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ForcaDeVontade1MouseExited
        ForcaDeVontade1.setBackground(new Color(172,172,172));
        ForcaDeVontade1.setForeground(new Color(60,60,60));
    }//GEN-LAST:event_ForcaDeVontade1MouseExited

    private void percepcao1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_percepcao1MouseEntered
        percepcao1.setBackground(new Color(60,60,60));
        percepcao1.setForeground(new Color(172,172,172));
    }//GEN-LAST:event_percepcao1MouseEntered

    private void percepcao1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_percepcao1MouseExited
        percepcao1.setBackground(new Color(172,172,172));
        percepcao1.setForeground(new Color(60,60,60));
    }//GEN-LAST:event_percepcao1MouseExited

    private void carisma1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carisma1MouseEntered
        carisma1.setBackground(new Color(60,60,60));
        carisma1.setForeground(new Color(172,172,172));
    }//GEN-LAST:event_carisma1MouseEntered

    private void carisma1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carisma1MouseExited
        carisma1.setBackground(new Color(172,172,172));
        carisma1.setForeground(new Color(60,60,60));
    }//GEN-LAST:event_carisma1MouseExited

    private void resetPontosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetPontosMouseEntered
        resetPontos.setForeground(new Color(172,172,172));
    }//GEN-LAST:event_resetPontosMouseEntered

    private void resetPontosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetPontosMouseExited
        resetPontos.setForeground(new Color(60,60,60));
    }//GEN-LAST:event_resetPontosMouseExited

    private void abrirConfiguracoesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abrirConfiguracoesMouseEntered
        abrirConfiguracoes.setForeground(new Color(172,172,172));
    }//GEN-LAST:event_abrirConfiguracoesMouseEntered

    private void abrirConfiguracoesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abrirConfiguracoesMouseExited
        abrirConfiguracoes.setForeground(new Color(60,60,60));
    }//GEN-LAST:event_abrirConfiguracoesMouseExited

    private void HomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeMouseEntered
        Home.setForeground(new Color(172,172,172));
    }//GEN-LAST:event_HomeMouseEntered

    private void HomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeMouseExited
        Home.setForeground(new Color(60,60,60));
    }//GEN-LAST:event_HomeMouseExited

    private void admDanoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admDanoActionPerformed
        vidaBarraPersonagem = vidaBarraPersonagem - 20;
        salvarDados();
    }//GEN-LAST:event_admDanoActionPerformed

    private void batalhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalhaActionPerformed
        this.dispose();
        new telaBatalha().setVisible(true);
    }//GEN-LAST:event_batalhaActionPerformed

    private void admOPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admOPActionPerformed
        for (int i = 0; i < 8; i++) {
            pontos[i] = 10000;
        }
        vidaBarraPersonagem = 10000;
        vidaBarraTotalPersonagem = 10000;
        levelBarra = 1000000;
        pontos_adiconais = 10000;
        salvarDados();
    }//GEN-LAST:event_admOPActionPerformed

    private void abrirInformacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirInformacoesActionPerformed

        telaInformacaoChamar.setVisible(true);
        salvarDados();

    }//GEN-LAST:event_abrirInformacoesActionPerformed

    private void abrirInformacoesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abrirInformacoesMouseExited
        abrirInformacoes.setForeground(new Color(60,60,60));
    }//GEN-LAST:event_abrirInformacoesMouseExited

    private void abrirInformacoesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abrirInformacoesMouseEntered
        abrirInformacoes.setForeground(new Color(172,172,172));
    }//GEN-LAST:event_abrirInformacoesMouseEntered

    private void admBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admBotaoActionPerformed
        if(contADM == 0){
            telaADM.setVisible(true);
            telaADM.setEnabled(true);
            senha.setVisible(true);
            senha.setEnabled(true);
            contADM = 1;
        }else{
            if(contADM == 1){
                telaADM.setVisible(false);
                telaADM.setEnabled(false);
                senha.setVisible(false);
                senha.setEnabled(false);
                contADM = 0;
            }
        }
        salvarDados();
    }//GEN-LAST:event_admBotaoActionPerformed

    private void senhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_senhaActionPerformed
        
        if("Bugatti123".equals(senha.getText())){
            if(modoADM == 1){
                modoADM = 0;
                salvarDados();
            }else{
                if(modoADM == 0){
                    modoADM = 1;
                    salvarDados();
                }
            }
        }

    }//GEN-LAST:event_senhaActionPerformed

    private void admUparLevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admUparLevelActionPerformed
        levelBarra = levelBarra + 20;
        salvarDados();
    }//GEN-LAST:event_admUparLevelActionPerformed

   
    public static void main(String args[]) throws IOException {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(telaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaMenu().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ForcaDeVontade1;
    private javax.swing.JButton Home;
    private javax.swing.JButton abrirConfiguracoes;
    private javax.swing.JButton abrirInformacoes;
    private javax.swing.JButton admBotao;
    private javax.swing.JButton admDano;
    private javax.swing.JButton admOP;
    private javax.swing.JButton admUparLevel;
    private javax.swing.JButton agilidade1;
    private javax.swing.JLabel avatar;
    private javax.swing.JButton batalha;
    private javax.swing.JButton carisma1;
    private javax.swing.JButton constituicao1;
    private javax.swing.JButton continuar;
    private javax.swing.JButton destreza1;
    private javax.swing.JProgressBar exibirLevel;
    private javax.swing.JLabel exibirLevelStatus;
    private javax.swing.JProgressBar exibirVida;
    private javax.swing.JLabel exibirVidaStatus;
    private javax.swing.JButton forca1;
    private javax.swing.JLabel fundo;
    private javax.swing.JButton inteligencia1;
    private javax.swing.JPanel painelBotoes;
    private javax.swing.JPanel painelGeral;
    private javax.swing.JPanel painelPontos;
    private javax.swing.JPanel painelPontosDistribuicao;
    private javax.swing.JPanel painelStatus;
    private javax.swing.JButton percepcao1;
    private javax.swing.JLabel pontosDistribuicao;
    private javax.swing.JButton resetPontos;
    private javax.swing.JPasswordField senha;
    private javax.swing.JPanel telaADM;
    private javax.swing.JLabel textoAgilidade;
    private javax.swing.JLabel textoCarisma;
    private javax.swing.JLabel textoClasse;
    private javax.swing.JLabel textoConstituicao;
    private javax.swing.JLabel textoDestreza;
    private javax.swing.JLabel textoForca;
    private javax.swing.JLabel textoForcaDeVontade;
    private javax.swing.JLabel textoHabilidades;
    private javax.swing.JLabel textoHabilidades1;
    private javax.swing.JLabel textoHabilidades2;
    private javax.swing.JLabel textoHabilidades3;
    private javax.swing.JLabel textoHabilidades4;
    private javax.swing.JLabel textoHabilidades5;
    private javax.swing.JLabel textoHabilidades6;
    private javax.swing.JLabel textoInteligencia;
    private javax.swing.JLabel textoLevel;
    private javax.swing.JLabel textoNome;
    private javax.swing.JLabel textoPercepcao;
    private javax.swing.JLabel textoSenha;
    private javax.swing.JLabel textoVida;
    private javax.swing.JLabel textoXP;
    private javax.swing.JLabel valorAgilidade;
    private javax.swing.JLabel valorCarisma;
    private javax.swing.JLabel valorConstituicao;
    private javax.swing.JLabel valorDestreza;
    private javax.swing.JLabel valorForca;
    private javax.swing.JLabel valorForcaDeVontade;
    private javax.swing.JLabel valorInteligencia;
    private javax.swing.JLabel valorPercepcao;
    // End of variables declaration//GEN-END:variables

}
