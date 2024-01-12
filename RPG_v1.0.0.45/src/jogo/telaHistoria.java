
package jogo;
// Essa tela foi criada para executar a telaHistoria do Jogo de RPG
// Onde a Aventura vai Comecar!!

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import jdk.nashorn.internal.runtime.JSType;

// Feita por Messias Feres e Joao Victor Barbosa

public class telaHistoria extends javax.swing.JFrame {
    
    private telaMenu menu;
    private String nome, name;
    String Historia1= "", Historia2= "", Historia3= "";
    String classeEscolhida, local;
    
    telaInformacao telaInformacaoChamar;
    telaConfiguracao telaConfiguracaoChamar;
    
    Thread exibicaoHistoria = new Thread();
    Thread exibicaoHistoria2 = new Thread();
    Thread barraSorte = new Thread();
    Thread barraSorteTime = new Thread();
    Thread efeitoEnvenenamento = new Thread();
    Thread delayBatatas = new Thread();
    Thread delay = new Thread();

    int[] pontos = new int[8];
    int[] pontosBackup = new int[8];
    int pontos_adiconais, pontosAdicionaisBackup;
    int levelBarra = 100, vidaBarraPersonagem = 100;
    int levelBarraTotal = 100, vidaBarraTotalPersonagem = 100;
    int dano, levelPersonagem, levelUp;
    int porcentagemVida1,porcentagemVida2;
    int telaFundo = 0, contTravamento = 0, gameOver = 0;
    int contTruco = 0, contTruco1 = 0, contTruco2 = 0, contTruco3 = 0, pontosTruco = 0,  pontosTrucoInimigo = 0, carta;
    int contADM = 0 , modoADM;
    int contBatatas = 0, batatas = 0, estaminaBarra;
    long contHistoria;

    Random gerador = new Random();
    int sorte= gerador.nextInt(6);
    int contGeral = 1;
    int pocaoEnvenenamento = 0, pocaoCura = 0;
   
    ImageIcon fundoHistoriaUm = new ImageIcon("src/imagens/fundoHistoriaUm.png");
    ImageIcon fundoHistoriaDois = new ImageIcon("src/imagens/fundoHistoriaDois.png");
    ImageIcon fundoHistoriaTres = new ImageIcon("src/imagens/fundoHistoriaTres.png");
    ImageIcon fundoHistoriaQuatro = new ImageIcon("src/imagens/fundoHistoriaQuatro.png");
    ImageIcon bordaMiniMapa= new ImageIcon("src/imagens/bordaPixelArts.png");
   
    ImageIcon assassinaHistoria_1 = new ImageIcon("src/imagens/assassinaHistoria_1.png");
    ImageIcon assassinaHistoria_2 = new ImageIcon("src/imagens/assassinaHistoria_2.png");
    ImageIcon assassinaHistoria_3 = new ImageIcon("src/imagens/assassinaHistoria_3.png");
    ImageIcon berserkHistoria_1 = new ImageIcon("src/imagens/berserkHistoria_1.png");
    ImageIcon berserkHistoria_2 = new ImageIcon("src/imagens/berserkHistoria_2.png");
    ImageIcon berserkHistoria_3 = new ImageIcon("src/imagens/berserkHistoria_3.png");
    ImageIcon arqueiraHistoria_1 = new ImageIcon("src/imagens/arqueiraHistoria_1.png");
    ImageIcon arqueiraHistoria_2 = new ImageIcon("src/imagens/arqueiraHistoria_2.png");
    ImageIcon arqueiraHistoria_3 = new ImageIcon("src/imagens/arqueiraHistoria_3.png");
    ImageIcon cavaleiroHistoria_1 = new ImageIcon("src/imagens/cavaleiroHistoria_1.png");
    ImageIcon cavaleiroHistoria_2 = new ImageIcon("src/imagens/cavaleiroHistoria_2.png");
    ImageIcon cavaleiroHistoria_3 = new ImageIcon("src/imagens/cavaleiroHistoria_3.png");
    ImageIcon magoHistoria_1 = new ImageIcon("src/imagens/magoHistoria_1.png");
    ImageIcon magoHistoria_2 = new ImageIcon("src/imagens/magoHistoria_2.png");
    ImageIcon magoHistoria_3 = new ImageIcon("src/imagens/magoHistoria_3.png");
    
    ImageIcon trucoCartaA = new ImageIcon("src/imagens/trucoCartaA.png");
    ImageIcon trucoCarta2 = new ImageIcon("src/imagens/trucoCarta2.png");
    ImageIcon trucoCarta3 = new ImageIcon("src/imagens/trucoCarta3.png");
    ImageIcon trucoCartaK = new ImageIcon("src/imagens/trucoCartaK.png");
    ImageIcon trucoCartaJ = new ImageIcon("src/imagens/trucoCartaJ.png");
    ImageIcon trucoCartaQ = new ImageIcon("src/imagens/trucoCartaQ.png");
    ImageIcon trucoCarta4 = new ImageIcon("src/imagens/trucoCarta4.png");
    ImageIcon trucoCarta7s2 = new ImageIcon("src/imagens/trucoCarta7s2.png");
    ImageIcon trucoCarta7a = new ImageIcon("src/imagens/trucoCarta7a.png");
    
    ImageIcon avatarPotatoTime = new ImageIcon("src/imagens/avatarPotatoTime.png");
    ImageIcon avatarPotatoTime2 = new ImageIcon("src/imagens/avatarPotatoTime2.png");
    
    
    ImageIcon imagemContHistoria1 = new ImageIcon("src/imagens/monte.png");
    ImageIcon imagemContHistoria2 = new ImageIcon("src/imagens/2caminhos.png");
    ImageIcon imagemContHistoria2001 = new ImageIcon("src/imagens/caminhoAlbatatrux.png");
    ImageIcon imagemContHistoria3002 = new ImageIcon("src/imagens/loja.gif");
    
    ImageIcon imagemContHistoria4 = new ImageIcon("src/imagens/ponte.gif");
    
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
                    
                    System.out.println("telaHistoriaLer" + "\nNome: " + nome + "\r\nClasse: " + classeEscolhida  + "\r\nForca: "  + pontos[0]  + "\r\nConstituicao: "  + pontos[1] +  "\r\nDestreza: " + pontos[2] + "\r\nAgilidade: " + pontos[3] + "\r\nInteligencia: " + pontos[4] + "\r\nForcaDeVontade: " + pontos[5] + "\r\nPercepcao: " + pontos[6] + "\r\nCarisma: " + pontos[7] + "\r\nBackupForca: " + pontosBackup[0] + "\r\nBackupConstituicao: " + pontosBackup[1] + "\r\nBackupDestreza: " + pontosBackup[2] + "\r\nBackupAgilidade: " + pontosBackup[3] + "\r\nBackupInteligencia: " + pontosBackup[4] + "\r\nBackupForcaDeVontade: " + pontosBackup[5] + "\r\nBackupPercepcao: " + pontosBackup[6] + "\r\nBackupCarisma: " + pontosBackup[7] + "\nPontosAdicionais: " + pontos_adiconais + "\nLevelBarra: " + levelBarra + "\nLevelBarraTotal: " + levelBarraTotal+ "\nVidaBarra: " + vidaBarraPersonagem + "\nVidaBarraTotal: " + vidaBarraTotalPersonagem + "\nLevel: " + levelPersonagem + "\nLevelUP: " + levelUp + "\nTelaFundo: " + telaFundo + "\nContHistoria: " + contHistoria + "\nLocalidade: " + local + "\nContTravamento: " + contTravamento +  "\nPontosAdicionaisBackup: " + pontosAdicionaisBackup + "\nBarra Estamina: " + estaminaBarra + "\n  -=%=-  \n");
                    escreverTela();
                }
            }while(linha != null);
            arquivo.close();
        }catch(Exception e){
            System.err.printf("|lerHistoria| Erro na abertura do arquivo: %s.\n",
            e.getMessage());
        }
            
    }
    private void escritorSalvamento() {
        
        try{

        FileOutputStream arquivo = new FileOutputStream("backup\\Salvamento.txt");
        PrintWriter print = new PrintWriter(arquivo);

        print.println("Nome" + " ; " + nome + " ; " + "Classe" + " ; " + classeEscolhida + " ; " + "Forca" + " ; " + pontos[0] + " ; " + "Constituicao" + " ; " + pontos[1] + " ; " + "Destreza" + " ; " + pontos[2] + " ; " + "Agilidade" + " ; " + pontos[3] + " ; " + "Inteligencia" + " ; " + pontos[4] + " ; " + "ForcaDeVontade" + " ; " + pontos[5] + " ; " + "Percepcao" + " ; " + pontos[6] + " ; " + "Carisma" + " ; " + pontos[7] + " ; " + "BackupForca" + " ; " + pontosBackup[0] + " ; " + "BackupConstituicao" + " ; " + pontosBackup[1] + " ; " + "BackupDestreza" + " ; " + pontosBackup[2] + " ; " + "BackupAgilidade" + " ; " + pontosBackup[3] + " ; " + "BackupInteligencia" + " ; " + pontosBackup[4] + " ; " + "BackupForcaDeVontade" + " ; " + pontosBackup[5] + " ; " + "BackupPercepcao" + " ; " + pontosBackup[6] + " ; " + "BackupCarisma" + " ; " + pontosBackup[7] + " ; "   + "PontosAdicionais:" + " ; " + pontos_adiconais + " ; " + "LevelBarra" + " ; " + levelBarra+ " ; "  + "LevelBarraTotal" + " ; " + levelBarraTotal+ " ; "  + "VidaBarra" + " ; " + vidaBarraPersonagem + " ; "  + "VidaBarraTotal" + " ; " + vidaBarraTotalPersonagem + " ; " + "Level" + " ; " + levelPersonagem + " ; " + "LevelUP" + " ; " + levelUp + " ; " + "telaFundo" + " ; " + telaFundo + " ; " + "contHistoria" + " ; " + contHistoria + " ; " + "localidade" + " ; " + local + " ; " + "contTravamento" + " ; " + contTravamento + " ; " + "pontosAdicionaisBackup" + " ; " + pontosAdicionaisBackup + " ; " + modoADM + " ; " + "estaminaBarra" + " ; " + estaminaBarra + " ; ");
        System.out.println("telaHistoriaEscrever" + "\nNome: " + nome + "\r\nClasse: " + classeEscolhida  + "\r\nForca: "  + pontos[0]  + "\r\nConstituicao: "  + pontos[1] +  "\r\nDestreza: " + pontos[2] + "\r\nAgilidade: " + pontos[3] + "\r\nInteligencia: " + pontos[4] + "\r\nForcaDeVontade: " + pontos[5] + "\r\nPercepcao: " + pontos[6] + "\r\nCarisma: " + pontos[7] + "\r\nBackupForca: " + pontosBackup[0] + "\r\nBackupConstituicao: " + pontosBackup[1] + "\r\nBackupDestreza: " + pontosBackup[2] + "\r\nBackupAgilidade: " + pontosBackup[3] + "\r\nBackupInteligencia: " + pontosBackup[4] + "\r\nBackupForcaDeVontade: " + pontosBackup[5] + "\r\nBackupPercepcao: " + pontosBackup[6] + "\r\nBackupCarisma: " + pontosBackup[7] + "\nPontosAdicionais: " + pontos_adiconais + "\nLevelBarra: " + levelBarra + "\nLevelBarraTotal: " + levelBarraTotal+ "\nVidaBarra: " + vidaBarraPersonagem + "\nVidaBarraTotal: " + vidaBarraTotalPersonagem + "\nLevel: " + levelPersonagem + "\nLevelUP: " + levelUp + "\nTelaFundo: " + telaFundo + "\nContHistoria: " + contHistoria + "\nLocalidade: " + local  + "\nContTravamento: " + contTravamento +  "\nPontosAdicionaisBackup: " + pontosAdicionaisBackup + "\nBarra Estamina: " + estaminaBarra + "\n  -=%=-  \n");
        print.close();
        arquivo.close();
        
        }catch(Exception e){
            System.err.printf("|Historia|*eS1* Erro na abertura do arquivo: %s.\n",
            e.getMessage());
        }
            
    }
    private void adm(){
        if(modoADM == 1){
            comandosADM.setVisible(true);
            comandosADM.setEnabled(true);
        }else{
            comandosADM.setVisible(false);
            comandosADM.setEnabled(false);
        }
    }
    
    private void salvarDados(){
        dano = vidaBarraTotalPersonagem - vidaBarraPersonagem;
        if(vidaBarraTotalPersonagem < vidaBarraPersonagem){
            vidaBarraPersonagem = vidaBarraTotalPersonagem;
            dano = 0;
        }
        
        escritorSalvamento();
        escreverTela();
        
        if(gameOver == 0){
            if(vidaBarraPersonagem <= 0){
                gameOver = 1;
                this.dispose();
                new telaGameOver().setVisible(true);
            }
        }
    }
    private void escreverTela(){
        
        exibirNome.setText(nome);
        exibirClasse.setText(classeEscolhida);
        
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
        exibirVida.setForeground(new Color(175,30,30));
        
        if("Assassina".equals(classeEscolhida)){
            porcentagemVida1 = (vidaBarraTotalPersonagem / 100)* 30;
            porcentagemVida2 = (vidaBarraTotalPersonagem / 100)* 60;
            
            if(vidaBarraPersonagem <= porcentagemVida1){
                avatar.setIcon(assassinaHistoria_3);
            }
            if(vidaBarraPersonagem <= porcentagemVida2 && vidaBarraPersonagem> porcentagemVida1){
                avatar.setIcon(assassinaHistoria_2);
            }
            if(vidaBarraPersonagem > porcentagemVida2){
                avatar.setIcon(assassinaHistoria_1);
            }
        }
        
        if("Cavaleiro".equals(classeEscolhida)){
            porcentagemVida1 = (vidaBarraTotalPersonagem / 100)* 30;
            porcentagemVida2 = (vidaBarraTotalPersonagem / 100)* 60;
            
            if(vidaBarraPersonagem <= porcentagemVida1){
                avatar.setIcon(cavaleiroHistoria_3);
            }
            if(vidaBarraPersonagem <= porcentagemVida2 && vidaBarraPersonagem> porcentagemVida1){
                avatar.setIcon(cavaleiroHistoria_2);
            }
            if(vidaBarraPersonagem > porcentagemVida2){
                avatar.setIcon(cavaleiroHistoria_1);
            }
        }
        
        if("Berserk".equals(classeEscolhida)){
            porcentagemVida1 = (vidaBarraTotalPersonagem / 100)* 30;
            porcentagemVida2 = (vidaBarraTotalPersonagem / 100)* 60;
            
            if(vidaBarraPersonagem <= porcentagemVida1){
                avatar.setIcon(berserkHistoria_3);
            }
            if(vidaBarraPersonagem <= porcentagemVida2 && vidaBarraPersonagem> porcentagemVida1){
                avatar.setIcon(berserkHistoria_2);
            }
            if(vidaBarraPersonagem > porcentagemVida2){
                avatar.setIcon(berserkHistoria_1);
            }
        }
        
        if("Arqueira".equals(classeEscolhida)){
            porcentagemVida1 = (vidaBarraTotalPersonagem / 100)* 30;
            porcentagemVida2 = (vidaBarraTotalPersonagem / 100)* 60;
            
            if(vidaBarraPersonagem <= porcentagemVida1){
                avatar.setIcon(arqueiraHistoria_3);
            }
            if(vidaBarraPersonagem <= porcentagemVida2 && vidaBarraPersonagem> porcentagemVida1){
                avatar.setIcon(arqueiraHistoria_2);
            }
            if(vidaBarraPersonagem > porcentagemVida2){
                avatar.setIcon(arqueiraHistoria_1);
            }
        }
        
        if("Mago".equals(classeEscolhida)){
            porcentagemVida1 = (vidaBarraTotalPersonagem / 100)* 30;
            porcentagemVida2 = (vidaBarraTotalPersonagem / 100)* 60;
            
            if(vidaBarraPersonagem <= porcentagemVida1){
                avatar.setIcon(magoHistoria_3);
            }
            if(vidaBarraPersonagem <= porcentagemVida2 && vidaBarraPersonagem> porcentagemVida1){
                avatar.setIcon(magoHistoria_2);
            }
            if(vidaBarraPersonagem > porcentagemVida2){
                avatar.setIcon(magoHistoria_1);
            }
        }
        
        if(telaFundo == 0){
            fundo.setIcon(fundoHistoriaDois);
            botaoEsquerda.setVisible(false);
            botaoEsquerda.setEnabled(false);
            botaoDireita.setVisible(false);
            botaoDireita.setEnabled(false);
            botaoMeio.setVisible(true);
            botaoMeio.setEnabled(true);
            botaoTruco1.setEnabled(false);
            botaoTruco1.setVisible(false);
            botaoTruco2.setEnabled(false);
            botaoTruco2.setVisible(false);
            botaoTruco3.setEnabled(false);
            botaoTruco3.setVisible(false);
        }else{
            if(telaFundo == 1){
                fundo.setIcon(fundoHistoriaUm);
                botaoEsquerda.setVisible(true);
                botaoEsquerda.setEnabled(true);
                botaoDireita.setVisible(true);
                botaoDireita.setEnabled(true);
                botaoMeio.setVisible(false);
                botaoMeio.setEnabled(false);
                botaoTruco1.setEnabled(false);
                botaoTruco1.setVisible(false);
                botaoTruco2.setEnabled(false);
                botaoTruco2.setVisible(false);
                botaoTruco3.setEnabled(false);
                botaoTruco3.setVisible(false);
            }else{
                if(telaFundo == 2){
                    fundo.setIcon(fundoHistoriaTres);
                    botaoTruco1.setEnabled(true);
                    botaoTruco1.setVisible(true);
                    botaoTruco2.setEnabled(true);
                    botaoTruco2.setVisible(true);
                    botaoTruco3.setEnabled(true);
                    botaoTruco3.setVisible(true);
                    botaoEsquerda.setEnabled(false);
                    botaoEsquerda.setVisible(false);
                    botaoDireita.setEnabled(false);
                    botaoDireita.setVisible(false);
                    botaoMeio.setVisible(false);
                    botaoMeio.setEnabled(false);
                }else {
                    if(telaFundo == 3){
                        fundo.setIcon(fundoHistoriaQuatro);
                        botaoTruco1.setEnabled(false);
                        botaoTruco1.setVisible(false);
                        botaoTruco2.setEnabled(false);
                        botaoTruco2.setVisible(false);
                        botaoTruco3.setEnabled(false);
                        botaoTruco3.setVisible(false);
                        botaoEsquerda.setEnabled(false);
                        botaoEsquerda.setVisible(false);
                        botaoDireita.setEnabled(false);
                        botaoDireita.setVisible(false);
                        botaoMeio.setVisible(false);
                        botaoMeio.setEnabled(false);
                    }
                }
            }
        }
        lerContHistoria.setText("" + contHistoria);
    }
    private void escreverHistoria(){
        textoHistoria1.setText("");
        textoHistoria2.setText("");
        textoHistoria3.setText("");
        contGeral = 1;
        
        exibicaoHistoria = new Thread(){
            
            public void run(){
        
                for(int cont = 0; cont<Historia1.length(); cont++){
                    try {
                        textoHistoria1.setText(textoHistoria1.getText() + Historia1.charAt(cont));
                        exibicaoHistoria.sleep(50);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(telaCarregamento.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                for(int cont = 0; cont<Historia2.length(); cont++){
                    try {
                        textoHistoria2.setText(textoHistoria2.getText() + Historia2.charAt(cont));
                        exibicaoHistoria.sleep(50);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(telaCarregamento.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                for(int cont = 0; cont<Historia3.length(); cont++){
                    try {
                        textoHistoria3.setText(textoHistoria3.getText() + Historia3.charAt(cont));
                        exibicaoHistoria.sleep(50);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(telaCarregamento.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                contGeral = 0;
                cliqueParaPassar.setVisible(false);
                cliqueParaPassar.setEnabled(false);
                exibicaoHistoria.stop();
            }
            
        };
        exibicaoHistoria.start();
        
    }
    private void escreverHistoria2(){
        textoHistoria1.setText("");
        textoHistoria2.setText("");
        textoHistoria3.setText("");
        contGeral = 1;
        
        exibicaoHistoria2 = new Thread(){
            
            public void run(){
        
                for(int cont = 0; cont<Historia1.length(); cont++){
                    try {
                        textoHistoria1.setText(textoHistoria1.getText() + Historia1.charAt(cont));
                        exibicaoHistoria2.sleep(50);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(telaCarregamento.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                for(int cont = 0; cont<Historia2.length(); cont++){
                    try {
                        textoHistoria2.setText(textoHistoria2.getText() + Historia2.charAt(cont));
                        exibicaoHistoria2.sleep(50);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(telaCarregamento.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                for(int cont = 0; cont<Historia3.length(); cont++){
                    try {
                        textoHistoria3.setText(textoHistoria3.getText() + Historia3.charAt(cont));
                        exibicaoHistoria2.sleep(50);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(telaCarregamento.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                contGeral = 0;
                cliqueParaPassar.setVisible(false);
                cliqueParaPassar.setEnabled(false);
                
                exibicaoHistoria2.stop();
            }
        };
        exibicaoHistoria2.start();
        
    }
    
    private void truco(){
        // 1 - q
        // 2 - j
        // 3 - k
        // 4 - 1
        // 5 - 2
        // 6 - 3
        // 7 - 7Menor
        // 8 - Espadilha
        // 9 - 7Maior
        // 10 - Zap
        telaFundo = 2;
        if(contTruco == 0){
            exibicaoHistoria.isInterrupted();
            exibicaoHistoria2.isInterrupted();
            int sorte = gerador.nextInt(2);
            int truco1 = gerador.nextInt(3);
            int truco2 = gerador.nextInt(3);
            int truco3 = gerador.nextInt(4);

            miniMapaBorda.setIcon(null);
            miniMapa.setIcon(null);

            if(sorte == 0){
                Historia1 = "Seu parceiro está fazendo com um 2";
                Historia2 = "agora é sua vez...";
                Historia3 = "";
                carta = 0;
                escreverHistoria2();
            }else{
                if(sorte == 1){
                    Historia1 = "O inimigo está fazendo com um 3";
                    Historia2 = "agora é sua vez...";
                    Historia3 = "";
                    carta = 6;
                    escreverHistoria2();
                }
            }

            if(truco1 == 0){
                botaoTruco1.setIcon(trucoCartaA);
                contTruco1 = 0;
                // as
            }
            if(truco1 == 1){
                botaoTruco1.setIcon(trucoCarta2);
                contTruco1 = 1;
                // dois
            }
            if(truco1 == 2){
                botaoTruco1.setIcon(trucoCarta3);
                contTruco1 = 2;
                // tres
            }

            if(truco2 == 0){
                botaoTruco2.setIcon(trucoCartaK);
                contTruco2 = 0;
                // K
            }
            if(truco2 == 1){
                botaoTruco2.setIcon(trucoCartaJ);
                contTruco2 = 1;
                // J
            }
            if(truco2 == 2){
                botaoTruco2.setIcon(trucoCartaQ);
                contTruco2 = 2;
                // Q
            }

            if(truco3 == 0){
                botaoTruco3.setIcon(trucoCarta4);
                contTruco3 = 0;
                // zap
            }
            if(truco3 == 1){
                botaoTruco3.setIcon(trucoCarta7s2);
                contTruco3 = 1;
                // 7
            }
            if(truco3 == 2){
                botaoTruco3.setIcon(trucoCarta7a);
                contTruco3 = 2;
                // 7
            }
            if(truco3 == 3){
                botaoTruco3.setIcon(trucoCarta7a);
                contTruco3 = 3;
                // 7
            }
        }else{
            delay = new Thread(){

                public void run(){

                    try {
                        delay.sleep(1000);
                        if(contTruco == 1){
                            delay.sleep(1000);
                            exibicaoHistoria.stop();
                            exibicaoHistoria2.stop();
                            textoHistoria1.setText(Historia1);
                            textoHistoria2.setText(Historia2);
                            textoHistoria3.setText(Historia3);

                            int sorte = gerador.nextInt(2);

                            if(sorte == 0){
                                Historia1 = "Seu parceiro está fazendo com um 2";
                                Historia2 = "agora é sua vez...";
                                Historia3 = "";
                                carta = 0;
                                escreverHistoria2();
                            }else{
                                if(sorte == 1){
                                    Historia1 = "O inimigo está fazendo com o Espadilha";
                                    Historia2 = "agora é sua vez...";
                                    Historia3 = "";
                                    carta = 8;
                                    escreverHistoria2();
                                }
                            }
                        }else{
                            if(contTruco == 2){
                                delay.sleep(1000);
                                exibicaoHistoria.stop();
                                exibicaoHistoria2.stop();
                                textoHistoria1.setText(Historia1);
                                textoHistoria2.setText(Historia2);
                                textoHistoria3.setText(Historia3);
                                
                                int sorte = gerador.nextInt(2);

                                if(pontosTruco == 2){
                                    telaFundo = 0;
                                    escreverTela();
                                    Historia1 = "Parabéns,";
                                    Historia2 = "você e Messias venceram";
                                    Historia3 = "a partida !";
                                    botaoMeio.setText("Continuar");
                                    escreverHistoria2();
                                    delay.stop();
                                }else{
                                    if(pontosTrucoInimigo == 2){
                                        telaFundo = 0;
                                        escreverTela();
                                        Historia1 = "Infelizmente,";
                                        Historia2 = "o Kalleby e o Gandra";
                                        Historia3 = "venceram a partida !";
                                        botaoMeio.setText("Continuar");
                                        escreverHistoria2();
                                        delay.stop();
                                    }else{
                                        if(sorte == 0){
                                            Historia1 = "O inimigo está fazendo com um As";
                                            Historia2 = "agora é sua vez...";
                                            Historia3 = "";
                                            carta = 4;
                                            escreverHistoria2();
                                        }else{
                                            if(sorte == 1){
                                                Historia1 = "O inimigo está fazendo com um 3";
                                                Historia2 = "agora é sua vez...";
                                                Historia3 = "";
                                                carta = 6;
                                                escreverHistoria2();
                                            }
                                        }
                                    }
                                }
                            }else{
                                if(contTruco == 3){
                                    delay.sleep(1000);
                                    exibicaoHistoria.stop();
                                    exibicaoHistoria2.stop();
                                    textoHistoria1.setText(Historia1);
                                    textoHistoria2.setText(Historia2);
                                    textoHistoria3.setText(Historia3);


                                    if(pontosTruco == 2){
                                        telaFundo = 0;
                                        escreverTela();
                                        Historia1 = "Parabéns,";
                                        Historia2 = "você e Messias venceram";
                                        Historia3 = "a partida !";
                                        botaoMeio.setText("Continuar");
                                        escreverHistoria2();
                                        delay.stop();
                                    }else{
                                        if(pontosTrucoInimigo == 2){
                                            telaFundo = 0;
                                            escreverTela();
                                            Historia1 = "Infelizmente,";
                                            Historia2 = "o Kalleby e o Gandra";
                                            Historia3 = "venceram a partida !";
                                            botaoMeio.setText("Continuar");
                                            escreverHistoria2();
                                            delay.stop();
                                        }
                                    }
                                }
                            }
                        }
                    } catch (InterruptedException ex) {
                        Logger.getLogger(telaCarregamento.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            };
            delay.start();
        }
    }
    
    private void historia(){
        
        if(contHistoria == 0){
            contHistoria0();
            salvarDados();
        }else if(contHistoria == 1){
            contHistoria1();
            salvarDados();
        }else if(contHistoria == 2){
            contHistoria2();
            salvarDados();
        }else if(contHistoria == 2001){
            contHistoria2001();
            salvarDados();
        }else if(contHistoria == 2002){
            contHistoria2002();
            salvarDados();
        }else if(contHistoria == 3){
            contHistoria3();
            salvarDados();
        }else if(contHistoria == 3001){
            contHistoria3001();
            salvarDados();
        }else if(contHistoria == 30011){
            contHistoria30011();
            salvarDados();
        }else if(contHistoria == 30012){
            contHistoria30012();
            salvarDados();
        }else if(contHistoria == 3002){
            contHistoria3002();
            salvarDados();
        }else if(contHistoria == 30021){
            contHistoria30021();
            salvarDados();
        }else if(contHistoria == 30022){
            contHistoria30022();
            salvarDados();
        }else if(contHistoria == 4){
            contHistoria4();
            salvarDados();
        }else if(contHistoria == 4001){
            contHistoria4001();
            salvarDados();
        }else if(contHistoria == 4002){
            contHistoria4002();
            salvarDados();
        }else if(contHistoria == 40011){
            contHistoria40011();
            salvarDados();  
        }else if(contHistoria == 40012){
            contHistoria40012();
            salvarDados();
        }else if(contHistoria == 5){
            contHistoria5();
            salvarDados();
        }else if(contHistoria == 5001){
            contHistoria5001();
            salvarDados();
        }else if(contHistoria == 5002){
            contHistoria5002();
            salvarDados();
        }else if(contHistoria == 6){
            contHistoria6();
            salvarDados();
        }else if(contHistoria == 50011){
            contHistoria50011();
            salvarDados();
        }else if(contHistoria == 50012){
            contHistoria50012();
            salvarDados();
        }else if(contHistoria == 500111){
            contHistoria500111();
            salvarDados();
        }else if(contHistoria == 5001111){
            contHistoria5001111();
            salvarDados();
        }else if(contHistoria == 5001112){
            contHistoria5001112();
            salvarDados();
        }else if(contHistoria == 50011111){
            contHistoria50011111();
            salvarDados();
        }else if(contHistoria == 600){
            contHistoria600();
            salvarDados();
        }else if(contHistoria == 7){
            contHistoria7();
            salvarDados();
        }else if(contHistoria == 7001){
            contHistoria7001();
            salvarDados();
        }else if(contHistoria == 7002){
            contHistoria7002();
            salvarDados();
        }else if(contHistoria == 70011){
            contHistoria70011();
            salvarDados();
        }else if(contHistoria == 70022){
            contHistoria70022();
            salvarDados();
        }else if(contHistoria == 700221){
            contHistoria700221();
            salvarDados();
        }else if(contHistoria == 700222){
            contHistoria700222();
            salvarDados();
        }else if(contHistoria == 8){
            contHistoria8();
            salvarDados();
        }else if(contHistoria == 8001){
            contHistoria8001();
            salvarDados();
        }else if(contHistoria == 8002){
            contHistoria8002();
            salvarDados();
        }else if(contHistoria == 80021){
            contHistoria80021();
            salvarDados();
        }else if(contHistoria == 80011){
            contHistoria80011();
            salvarDados();
        }else if(contHistoria == 800111){
            contHistoria800111();
            salvarDados();
        }else if(contHistoria == 8001111){
            contHistoria8001111();
            salvarDados();
        }else if(contHistoria == 80011111){
            contHistoria80011111();
            salvarDados();
        }else if(contHistoria == 80011112){
            contHistoria80011112();
            salvarDados();
        }else if(contHistoria == 800111111){
            contHistoria800111111();
            salvarDados();
        }else if(contHistoria == 800111112){
            contHistoria800111112();
            salvarDados();
        }else if(contHistoria == 8000111111L){
            contHistoria8000111111();
            salvarDados();
        }else if(contHistoria == 80001111111L){
            contHistoria80001111111();
            salvarDados();
        }else if(contHistoria == 301){
            contHistoria301();
            salvarDados();
        }else if(contHistoria == 3011){
            contHistoria3011();
            salvarDados();
        }else if(contHistoria == 3015){
            contHistoria3015();
            salvarDados();
        }else if(contHistoria == 30151){
            contHistoria30151();
            salvarDados();
        }else if(contHistoria == 30152){
            contHistoria30152();
            salvarDados();
        }else if(contHistoria == 6000){
            contHistoria6000();
            salvarDados();
        }else if(contHistoria == 700220){
            contHistoria700220();
            salvarDados();
        }else if(contHistoria == 70021){
            contHistoria70021();
            salvarDados();
        }else if(contHistoria == 800111120){
            contHistoria800111120();
            salvarDados();
        }else if(contHistoria == 9){
            contHistoria9();
            salvarDados();
        }else if(contHistoria == 8001111120L){
            contHistoria8001111120();
            salvarDados();
        }else if(contHistoria == 80011111200L){
            contHistoria80011111200();
            salvarDados();
        }else if(contHistoria == 8001111110L){
            contHistoria8001111110();
            salvarDados();
        }else if(contHistoria == 800011111111L){
            contHistoria800011111111();
            salvarDados();
        }else if(contHistoria == 9001){
            contHistoria9001();
            salvarDados();
        }else if(contHistoria == 90011){
            contHistoria90011();
            salvarDados();
        }else if(contHistoria == 90012){
            contHistoria90012();
            salvarDados();
        }else if(contHistoria == 900111){
            contHistoria900111();
            salvarDados();
        }else if(contHistoria == 900112){
            contHistoria900112();
            salvarDados();
        }else if(contHistoria == 900120){
            contHistoria900120();
            salvarDados();
        }else if(contHistoria == 9001200){
            contHistoria9001200();
            salvarDados();
        }else if(contHistoria == 90012000){
            contHistoria90012000();
            salvarDados();
        }else if(contHistoria == 900120000){
            contHistoria900120000();
            salvarDados();
        }else if(contHistoria == 10){
            contHistoria10();
            salvarDados();
        }else if(contHistoria == 304){
            contHistoria304();
            salvarDados();
        }else if(contHistoria == 3040){
            contHistoria3040();
            salvarDados();
        }else if(contHistoria == 30400){
            contHistoria30400();
            salvarDados();
        }else if(contHistoria == 708){
            contHistoria708();
            salvarDados();
        }else if(contHistoria == 7080){
            contHistoria7080();
            salvarDados();
        }else if(contHistoria == 70800){
            contHistoria70800();
            salvarDados();
        }else if(contHistoria == 9001200000L){
            contHistoria9001200000();
            salvarDados();
        }else if(contHistoria == 10000){
            contHistoria10000();
            salvarDados();
        }else if(contHistoria == 100001){
            contHistoria100001();
            salvarDados();
        }else if(contHistoria == 100002){
            contHistoria100002();
            salvarDados();
        }else if(contHistoria == 11){
            contHistoria11();
            salvarDados();
        }else if(contHistoria == 11000){
            contHistoria11000();
            salvarDados();
        }else if(contHistoria == 110001){
            contHistoria110001();
            salvarDados();
        }else if(contHistoria == 110002){
            contHistoria110002();
            salvarDados();
        }else if(contHistoria == 1100010){
            contHistoria1100010();
            salvarDados();
        }else if(contHistoria == 11000100){
            contHistoria11000100();
            salvarDados();
        }else if(contHistoria == 12){
            contHistoria12();
            salvarDados();
        }else if(contHistoria == 1100021){
            contHistoria1100021();
            salvarDados();
        }else if(contHistoria == 1100022){
            contHistoria1100022();
            salvarDados();
        }else if(contHistoria == 1100020){
            contHistoria1100020();
            salvarDados();
        }else if(contHistoria == 12000){
            contHistoria12000();
            salvarDados();
        }else if(contHistoria == 120001){
            contHistoria120001();
            salvarDados();
        }else if(contHistoria == 120002){
            contHistoria120002();
            salvarDados();
        }else if(contHistoria == 13){
            contHistoria13();
            salvarDados();
        }else if(contHistoria == 13000){
            contHistoria13000();
            salvarDados();
        }else if(contHistoria == 130000){
            contHistoria130000();
            salvarDados();
        }else if(contHistoria == 1300001){
            contHistoria1300001();
            salvarDados();
        }else if(contHistoria == 1300002){
            contHistoria1300002();
            salvarDados();
        }else if(contHistoria == 13000020){
            contHistoria13000020();
            salvarDados();
        }else if(contHistoria == 130000201){
            contHistoria130000201();
            salvarDados();
        }else if(contHistoria == 130000202){
            contHistoria130000202();
            salvarDados();
        }else if(contHistoria == 14){
            salvarDados();
            new telaFim().setVisible(true);
            this.dispose();
        }else if(contHistoria == 1200010){
            contHistoria1200010();
            salvarDados();
        }else if(contHistoria == 12000101){
            contHistoria12000101();
            salvarDados();
        }else if(contHistoria == 12000102){
            contHistoria12000102();
            salvarDados();
        }else if(contHistoria == 120003){
            contHistoria120003();
            salvarDados();
        }else if(contHistoria == 1200030){
            contHistoria1200030();
            salvarDados();
        }else if(contHistoria == 120004){
            contHistoria120004();
            salvarDados();
        }else if(contHistoria == 120005){
            contHistoria120005();
            salvarDados();
        }else if(contHistoria == 1200041){
            contHistoria1200041();
            salvarDados();
        }else if(contHistoria == 1200050){
            contHistoria1200050();
            salvarDados();
        }else if(contHistoria == 12000500){
            contHistoria12000500();
            salvarDados();
        }else if(contHistoria == 1200021){
            contHistoria1200021();
            salvarDados();
        }else if(contHistoria == 1200022){
            contHistoria1200022();
            salvarDados();
        }else if(contHistoria == 1200023){
            contHistoria1200023();
            salvarDados();
        }
    }
     
    private void contHistoria0(){
        exibirMenu.setEnabled(false);
        Historia1 = "";
        Historia2 = "Olá " + nome + ", esse é um jogo do tipo RPG e depende constantemente da sua sorte e suas escolhas. Boa sorte !";
        Historia3 = "";
        escreverHistoria();
        if(contTravamento == 0){
            levelBarra = levelBarra + 16;
        }
        
        botaoMeio.setText("Continuar");    
    }
    
    private void contHistoria1(){
        miniMapaBorda.setIcon(bordaMiniMapa);
        miniMapa.setIcon(imagemContHistoria1);
        telaFundo = 0;
        salvarDados();
        
        if("Mago".equals(classeEscolhida)){
            Historia1 = "Você é um mago e nasceu nas redondezas da montanha de Freljorje, um lugar quente e tranquilo para se viver.";
            Historia2 = "Sua família e você viviam uma vida tranquila até que um dia monstros da floresta de Elber escaparam e";
            Historia3 = "aniquilaram sua família inteira assim como sua vila.";
        }
        if("Berserk".equals(classeEscolhida)){
            Historia1 = "Você é um berserk e nasceu nas redondezas da montanha de Freljorje, um lugar quente e tranquilo para se viver.";
            Historia2 = "Sua família e você viviam uma vida tranquila até que um dia monstros da floresta de Elber escaparam e";
            Historia3 = "aniquilaram sua família inteira assim como sua vila.";
        }
        if("Arqueira".equals(classeEscolhida)){
            Historia1 = "Você é uma arqueira e nasceu perto na cidade de Frostill, um lugar muito frio. Lá é uma cidade de arqueiros. ";
            Historia2 = "Mas durante um inverno você e sua família, tiveram de morar na rua, ficando assim pobres";
            Historia3 = "Sua família morreu de fome e você jurou se tornar a pessoa mais rica do mundo.";
        }
        if("Assassina".equals(classeEscolhida)){
            Historia1 = "";
            Historia2 = "";
            Historia3 = "";
        }
        if("Cavaleiro".equals(classeEscolhida)){
            Historia1 = "";
            Historia2 = "";
            Historia3 = "";
        }
        escreverHistoria();
        botaoMeio.setText("Continuar");
        if(contTravamento == 0){
            sorte = gerador.nextInt(18) + 1;
            levelBarra = levelBarra + sorte;
        }
    }
    
    private void contHistoria2(){
        miniMapaBorda.setIcon(bordaMiniMapa);
        miniMapa.setIcon(imagemContHistoria2);
        telaFundo = 1;
        salvarDados();
        
        if("Mago".equals(classeEscolhida)){
            Historia1 = "Alguns anos depois, agora você possui 46 anos e está pronto para buscar vingança por sua família";
            Historia2 = "Você se encontra entre dois caminhos um que leva a cidade de Albalatrux e outro que";
            Historia3 = "leva a cidade de Vapylon, por qual você deseja seguir?";
            
        }
        if("Berserk".equals(classeEscolhida)){
            Historia1 = "Alguns anos depois, agora você possui 18 anos e está pronto para buscar vingança por sua família.";
            Historia2 = "Agora você se encontra entre dois caminhos um que leva a cidade de Albalatrux e outro que";
            Historia3 = "leva a cidade de Vapylon, por qual você deseja seguir?";
        }
        if("Arqueira".equals(classeEscolhida)){
            Historia1 = "Por ter pressa para conseguir sua riqueza, você comeca sua jornada cedo com 12 anos.";
            Historia2 = "Agora você se encontra entre dois caminhos um que leva a cidade de Albalatrux e outro que";
            Historia3 = "leva a cidade de Vapylon, por qual você deseja seguir?";
        }
        if("Assassina".equals(classeEscolhida)){
            Historia1 = "";
            Historia2 = "";
            Historia3 = "";
        }
        if("Cavaleiro".equals(classeEscolhida)){
            Historia1 = "";
            Historia2 = "";
            Historia3 = "";
        }
        
        escreverHistoria();
        botaoEsquerda.setText("Albalatrux");
        botaoDireita.setText("Vapylon");
        if(contTravamento == 0){
            sorte = gerador.nextInt(18) + 1;
            levelBarra = levelBarra + sorte;
        }
        
    }
    private void contHistoria2001(){
        miniMapaBorda.setIcon(bordaMiniMapa);
        miniMapa.setIcon(imagemContHistoria2001);
        telaFundo = 0;
        salvarDados();
        
        int sorte= gerador.nextInt(5);
        
        if(sorte >= 2){
            Historia1 = "";
            Historia2 = "Você consegue passar o caminho tranquilamente e chega a cidade de Albalatrux.";
            Historia3 = "";
            escreverHistoria();
            botaoMeio.setText("Continuar");
        }
        if(sorte < 2){
            Historia1 = "";
            Historia2 = "No meio do caminho havia uma pedra, você tropeça e perde 15 de vida.";
            Historia3 = "";
            escreverHistoria();
            botaoMeio.setText("Continuar");
            if(contTravamento == 0){
                vidaBarraPersonagem = vidaBarraPersonagem - 15;
            }
            salvarDados();
        }
        
        local = "Albalatrux";
        salvarDados();
    }
    private void contHistoria2002(){
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        telaFundo = 0;
        int sorte= gerador.nextInt(6);
        salvarDados();
        
        if(sorte >= 3){
            Historia1 = "";
            Historia2 = "Vapylon é um caminho cheio de perigos, mas você consegue passar tranquilamente e chega a cidade de Vapylon.";
            Historia3 = "";
            escreverHistoria();
            botaoMeio.setText("Continuar");
        }
        if(sorte < 3){
            Historia1 = "Infelizmente Vapylon é um caminho cheio de perigos, você cai em um buraco e é picado por uma aranha,";
            Historia2 = "e agora você perde 25 de vida e está sobre efeito venenoso que faz com que você perca 5 de vida a cada minuto que passa.";
            Historia3 = "DICA: Procure a loja de poções lá deve ter o que você precisa.";
            escreverHistoria();
            botaoMeio.setText("Continuar");
            if(contTravamento == 0){
                pocaoEnvenenamento = 1;
                efeitoEnvenenamento = new Thread(){
                    public void run(){
                        try {
                            for(int cont = 0; cont < vidaBarraPersonagem; cont++){
                                vidaBarraPersonagem = vidaBarraPersonagem - 5;
                                escreverTela();
                                salvarDados();
                                efeitoEnvenenamento.sleep(60000);
                            }
                        } catch (InterruptedException ex) {
                            Logger.getLogger(telaCarregamento.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                };
                efeitoEnvenenamento.start();
                vidaBarraPersonagem = vidaBarraPersonagem - 25;
            }
            salvarDados();
        }
        
        local = "Vapylon";
        salvarDados();
    }
    
    private void contHistoria3(){
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        telaFundo = 1;
        salvarDados();
        if(contTravamento == 0){
            if(levelPersonagem == 1){
                sorte = gerador.nextInt(18) + 1;
                levelBarra = levelBarra + (levelBarraTotal - levelBarra) + sorte;
            }
        }
        if("Mago".equals(classeEscolhida)){
            Historia1 = "";
            Historia2 = "";
            Historia3 = "";
        }
        if("Berserk".equals(classeEscolhida)){
            Historia1 = "Você se encontra agora na cidade de " + local + ". Você está com pressa para conseguir sua vingança e quer ir";
            Historia2 = "logo para ponte que liga para a próxima cidade, então você pode ir a dois lugares a taverna para ganhar informação";
            Historia3 = "ou a loja de poções ou elixires para comprar items. Qual lugar deseja se dirigir?";
        }
        if("Arqueira".equals(classeEscolhida)){
            Historia1 = "Você se encontra agora na cidade de " + local + ". Você está com pressa para conseguir sua riqueza e quer ir";
            Historia2 = "logo para ponte que liga para a próxima cidade, então você pode ir a dois lugares a taverna para ganhar informação";
            Historia3 = "ou a loja de poções ou elixires para comprar items. Qual lugar deseja se dirigir?";
        }
        if("Assassina".equals(classeEscolhida)){
            Historia1 = "";
            Historia2 = "";
            Historia3 = "";
        }
        if("Cavaleiro".equals(classeEscolhida)){
            Historia1 = "";
            Historia2 = "";
            Historia3 = "";
        }
        escreverHistoria();
        botaoEsquerda.setText("Taverna");
        botaoDireita.setText("Loja");
        
       
    }
    private void contHistoria301(){
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        telaFundo = 0;
        salvarDados();
        
        Historia1 = "Entrando no local você se depara na primeira mesa com 3 homens totalmente bebados e jogando truco.";
        Historia2 = "O nome deles era Gandra, que bebia porque sua mulher o deixara, Messias, bebia apenas porque gostava,";
        Historia3 = "e por último e não menos importante Kalleby, que bebia porque queria jogar truco também.";
        escreverHistoria();
        botaoMeio.setText("Continuar");
        
        local = "Taverna";
        salvarDados();
    }
    private void contHistoria3011(){
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        telaFundo = 1;
        salvarDados();
        
        Historia1 = "Os três bebados ao te ver, convidam você";
        Historia2 = "para uma partida de truco valendo recompensas.";
        Historia3 = "Você deseja participar?";
        escreverHistoria();
        botaoEsquerda.setText("Sim");
        botaoDireita.setText("Não");
        
       
    }
    private void contHistoria3015(){
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        truco();
        salvarDados();
    }
    private void contHistoria30151(){
        exibicaoHistoria.stop();
        exibicaoHistoria2.stop();
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        telaFundo = 0;
        salvarDados();
        
        Historia1 = "Por ter ganho a partida,";
        Historia2 = "Kalleby e Gandra te dão uma poção de 20 de vida";
        Historia3 = "e 50 de xp";
        escreverHistoria2();
        if(contTravamento == 0){
            vidaBarraPersonagem = vidaBarraPersonagem + 20;
            levelBarra = levelBarra + 50;
        }
        botaoMeio.setText("Continuar");
        
        salvarDados();
    }
    private void contHistoria30152(){
        exibicaoHistoria.stop();
        exibicaoHistoria2.stop();
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        telaFundo = 0;
        salvarDados();
        
        Historia1 = "Por ter perdido a partida,";
        Historia2 = "você não recebe nada";
        Historia3 = "";
        escreverHistoria2();
        botaoMeio.setText("Continuar");
        
        salvarDados();
    }
    private void contHistoria3001(){
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        telaFundo = 1;
        salvarDados();
        
        Historia1 = "Tirando os bebados possuiam 2 pessoas na taverna um homem grande e";
        Historia2 = "cheio de músculos e a mulher que cuida do balcão com as bebidas.";
        Historia3 = "Qual deles deseja pedir informação?";
        escreverHistoria();
        botaoEsquerda.setText("Homem");
        botaoDireita.setText("Mulher");
        
        local = "Taverna";
        salvarDados();
    }
    private void contHistoria30011(){
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        telaFundo = 0;
        salvarDados();
        
        if(pontos[7] >= 2){
            Historia1 = "Incrívelmente o homem era muito legal, seu nome é Jorjão e lhe deu a informação de que após a ponte";
            Historia2 = "há vários monstros e o melhor caminho a seguir é para a direita à cidade de Pelber,";
            Historia3 = "que apesar de ser mais lonje de Elber é um lugar tranquilo e sem perigos.";
            escreverHistoria();
                botaoMeio.setText("Continuar");
            }
        if(pontos[7] < 2){
            if("Mago".equals(classeEscolhida)){
                Historia1 = "";
                Historia2 = "";
                Historia3 = "";
            }
            if("Berserk".equals(classeEscolhida)){
                Historia1 = "Apesar de Jorjão ser uma pessoa muito legal,";
                Historia2 = "você foi grosseiro ao pedir informação";
                Historia3 = "e ele apenas o ignorou.";
            }
            if("Arqueira".equals(classeEscolhida)){
                Historia1 = "Apesar de Jorjão ser uma pessoa muito legal,";
                Historia2 = "você foi grosseira ao pedir informação";
                Historia3 = "e ele apenas a ignorou.";
            }
            if("Assassina".equals(classeEscolhida)){
                Historia1 = "";
                Historia2 = "";
                Historia3 = "";
            }
            if("Cavaleiro".equals(classeEscolhida)){
                Historia1 = "";
                Historia2 = "";
                Historia3 = "";
            }
            escreverHistoria();
            botaoMeio.setText("Continuar");

            salvarDados();
        }
    }
    private void contHistoria30012(){
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        telaFundo = 0;
        salvarDados();
      
        if(pontos[7] >= 4 && pontos[6] <= 2 ){
            Historia1 = "A mulher do balcão se chamava Luisa e estava bêbada e com muito custo lhe";
            Historia2 = "deu a informação de que após a ponte o melhor caminho é a esquerda para";
            Historia3 = "a cidade de Bellatriz.";
            escreverHistoria();
            botaoMeio.setText("Continuar");
        }else{
            if(pontos[7] >= 4 && pontos[6] > 2 ){
                Historia1 = "A mulher do balcão se chamava Luisa e estava bêbada. Ela lhe deu a informação de que o";
                Historia2 = "melhor caminho é a esquerda para a cidade de Bellatriz mais você percebe que ";
                Historia3 = "era mentira e o melhor caminho é a direita.";
                escreverHistoria();
                botaoMeio.setText("Continuar");
            }else{
                if(pontos[7] < 4){
                    Historia1 = "Luisa, a mulher do balcão, estava bebada assim,";
                    Historia2 = "te expulsa da taverna e lhe dá um tapa.";
                    Historia3 = "Você perde 5 de vida.";
                    escreverHistoria();
                    botaoMeio.setText("Continuar");

                    if(contTravamento == 0){
                        vidaBarraPersonagem = vidaBarraPersonagem - 5;
                    }
                    salvarDados();
                }
            }
        }
        
        salvarDados();
    }
    private void contHistoria3002(){
        miniMapaBorda.setIcon(bordaMiniMapa);
        miniMapa.setIcon(imagemContHistoria3002);
        telaFundo = 1;
        salvarDados();
        
        Historia1 = "Possui um homem no balcão da loja. Você vai até ele e ele lhe oferece 2 tipos de poções,";
        Historia2 = "uma que retira efeito de venenos e outra que cura 20 de vida.";
        Historia3 = "Qual você escolhe?";
        escreverHistoria();
        botaoEsquerda.setText("Antídoto");
        botaoDireita.setText("Cura");
        
        local = "Loja";
        salvarDados();
    }
    private void contHistoria30021(){
        miniMapaBorda.setIcon(bordaMiniMapa);
        miniMapa.setIcon(imagemContHistoria3002);
        telaFundo = 0;
        salvarDados();
        
        if(pontos[7] >= 4){
            Historia1 = "Por achar você um bom rapaz, Alberto,";
            Historia2 = "o dono da loja, lhe dá uma poção extra de cura.";
            Historia3 = "";
            if(contTravamento == 0){
                pocaoEnvenenamento = 0;
                efeitoEnvenenamento.stop();
                vidaBarraPersonagem = vidaBarraPersonagem + 20;
            }
            escreverHistoria();
            botaoMeio.setText("Continuar");
        }
        if(pontos[7] < 4){
            Historia1 = "";
            Historia2 = "O efeito de envenenamento foi removido";
            Historia3 = "";
            if(contTravamento == 0){
                pocaoEnvenenamento = 0;
                efeitoEnvenenamento.stop();
            }
            escreverHistoria();
            botaoMeio.setText("Continuar");

            salvarDados();
        }
        
        salvarDados();  
    }
    private void contHistoria30022(){
        miniMapaBorda.setIcon(bordaMiniMapa);
        miniMapa.setIcon(imagemContHistoria3002);
        int sorte= gerador.nextInt(6);
        telaFundo = 0;
        salvarDados();
        
        if(sorte > 4){
            Historia1 = "Por achar você um bom rapaz, Alberto,";
            Historia2 = "o dono da loja, lhe dá uma poção extra de cura.";
            Historia3 = "Curando assim 30 de vida.";
            if(contTravamento == 0){
                vidaBarraPersonagem = vidaBarraPersonagem + 30;
            }
            escreverHistoria();
            botaoMeio.setText("Continuar");
            salvarDados();
        }
        if(sorte < 5){
            Historia1 = "";
            Historia2 = "Você curou 20 de vida.";
            Historia3 = "";
            if(contTravamento == 0){
                vidaBarraPersonagem = vidaBarraPersonagem + 20;
            }
            escreverHistoria();
            botaoMeio.setText("Continuar");

            salvarDados();
        }
    }
    
    private void contHistoria304(){
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        telaFundo = 0;
        salvarDados();
        if("Arqueira".equals(classeEscolhida) || "Assassina".equals(classeEscolhida)){
            Historia1 = "Ao sair do estabelecimento, você encontra um lindo homem e fica apaixonada...";
            Historia2 = "Com coragem, logo foi puxar assunto com ele.";
            Historia3 = "";
        }else{
            Historia1 = "Ao sair do estabelecimento, você encontra uma linda donzela e fica apaixonado...";
            Historia2 = "Com coragem, logo foi puxar assunto com ela.";
            Historia3 = "";
        }
        escreverHistoria();
        botaoMeio.setText("Continuar");
        
        salvarDados();
    }
    private void contHistoria3040(){
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        telaFundo = 0;
        salvarDados();
        if("Arqueira".equals(classeEscolhida) || "Assassina".equals(classeEscolhida)){
            Historia1 = "Durante a conversa você descobre que o nome dele é Matheus e se encanta cada vez mais.";
            Historia2 = "Até que em um momento, ele pede para você fechar os olhos.";
            Historia3 = "";
        }else{
            Historia1 = "Durante a conversa você descobre que o nome dela é Duda e se encanta cada vez mais.";
            Historia2 = "Até que em um momento, ela pede para você fechar os olhos.";
            Historia3 = "";
        }
        escreverHistoria();
        botaoMeio.setText("Continuar");
        
        salvarDados();
    }
    private void contHistoria30400(){
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        telaFundo = 0;
        salvarDados();
        if("Arqueira".equals(classeEscolhida) || "Assassina".equals(classeEscolhida)){
            if(pontos[6] >= 5){
                Historia1 = "Matheus estava pronto para esfaquea-la e roubar seus pertences, mas graças a sua percepção,";
                Historia2 = "você não fecha os olhos e consegue se defender. Assim, capturando e entregando ele para os cavaleiros da cidade,";
                Historia3 = "ganhando assim 47 de xp por capturar uma Ladrão.";
                if(contTravamento == 0){
                    levelBarra = levelBarra + 47;
                }
            }
            if(pontos[6] < 5){
                Historia1 = "Você infelizmente foi enganada por Matheus e ele rouba alguns pertences";
                Historia2 = "seu e te esfaqueia...";
                Historia3 = "Perdendo 10 de vida.";
                if(contTravamento == 0){
                    vidaBarraPersonagem = vidaBarraPersonagem - 10;
                }
                salvarDados();
            }
        }else{
            if(pontos[6] >= 5){
                Historia1 = "Duda estava pronta para esfaquea-ló e roubar seus pertences, mas graças a sua percepção,";
                Historia2 = "você não fecha os olhos e consegue se defender. Assim, capturando e entregando ela para os cavaleiros da cidade,";
                Historia3 = "ganhando assim 47 de xp por capturar uma Ladrã.";
                if(contTravamento == 0){
                    levelBarra = levelBarra + 47;
                }
            }
            if(pontos[6] < 5){
                Historia1 = "Você infelizmente foi enganado por Duda e ela rouba alguns pertences";
                Historia2 = "seu e te esfaqueia...";
                Historia3 = "Perdendo 10 de vida.";
                if(contTravamento == 0){
                    vidaBarraPersonagem = vidaBarraPersonagem - 10;
                }

                salvarDados();
            }
        }
        escreverHistoria();
        botaoMeio.setText("Continuar");
        
        salvarDados();
    }
    
    private void contHistoria4(){
        miniMapaBorda.setIcon(bordaMiniMapa);
        miniMapa.setIcon(imagemContHistoria4);
        telaFundo = 1;
        salvarDados();
        
        Historia1 = "Por ter pressa logo você sai da cidade e se encaminha para a ponte.";
        Historia2 = "Nela se encontra dois homens muito suspeitos.";
        Historia3 = "Você deseja conversar com eles ou seguir reto?";
        escreverHistoria();
        botaoEsquerda.setText("Conversar");
        botaoDireita.setText("Seguir");
        
        local = "Ponte";
        salvarDados();
    }
    private void contHistoria4001(){
        miniMapaBorda.setIcon(bordaMiniMapa);
        miniMapa.setIcon(imagemContHistoria4);
        telaFundo = 0;
        int sorte= gerador.nextInt(6);
        salvarDados();
        
        if(pontos[6] >= 4 && sorte > 3){
            Historia1 = "Você percebe que são bandidos antes de conversar";
            Historia2 = "e por sorte sai sem eles te notarem.";
            Historia3 = "";
            escreverHistoria();
            botaoMeio.setText("Continuar");
        }
        if(pontos[6] >= 4 && sorte < 4){
            Historia1 = "Você percebe que são bandidos antes de conversar,";
            Historia2 = "mas mesmo assim te notam. Você se encontra em situação";
            Historia3 = "de perigo, deseja correr ou lutar?";
            telaFundo = 1;
            salvarDados();
            escreverHistoria();
            botaoEsquerda.setText("Correr");
            botaoDireita.setText("Lutar");

            salvarDados();
        }
        if(pontos[6]< 4){
            Historia1 = "Você tenta conversar com eles, mas eles";
            Historia2 = "eram bandidos e agora você se encontra em";
            Historia3 = "uma situação que deve lutar.";
            escreverHistoria();
            botaoMeio.setText("Batalhar");
            contHistoria = 40015;
            
            salvarDados();
        }
        
        
        salvarDados();
    }
    private void contHistoria40011(){
        miniMapaBorda.setIcon(bordaMiniMapa);
        miniMapa.setIcon(imagemContHistoria4);
       
        if(pontos[3] >= 4){
            Historia1 = "Você corre muito rápido e os bandidos";
            Historia2 = "não conseguem te alcançar.";
            Historia3 = "";
            escreverHistoria();
            botaoMeio.setText("Continuar");
        }
        if(pontos[3] < 4){
            Historia1 = "Os bandidos te alcançam e te batem";
            Historia2 = "causando 20 de dano a você.";
            Historia3 = "";
            if(contTravamento == 0){
                vidaBarraPersonagem = vidaBarraPersonagem - 20;
            }
            escreverHistoria();
            botaoMeio.setText("Continuar");
        }
    }
    private void contHistoria40012(){
        miniMapaBorda.setIcon(bordaMiniMapa);
        miniMapa.setIcon(imagemContHistoria4);
        telaFundo = 0;
        salvarDados();
        
        Historia1 = "Você tenta conversar com eles, mas eles";
        Historia2 = "eram bandidos e agora você se encontra em";
        Historia3 = "uma situação que deve lutar.";
        escreverHistoria();
        botaoMeio.setText("Batalhar");
        contHistoria = 40015;
        exibirMenu.setEnabled(false);

        salvarDados();

    }
    private void contHistoria4002(){
        miniMapaBorda.setIcon(bordaMiniMapa);
        miniMapa.setIcon(imagemContHistoria4);
        int sorte= gerador.nextInt(6);
        telaFundo = 0;
        salvarDados();
        
        if(sorte >= 3){
            Historia1 = "";
            Historia2 = "Você segue reto e os homens nem te percebem.";
            Historia3 = "";
            escreverHistoria();
            botaoMeio.setText("Continuar");
        }
        if(sorte < 3){
            Historia1 = "Você segue reto e os homens infelizmente te percebem";
            Historia2 = "e te encurralam se revelando bandidos.";
            Historia3 = "Agora você deve lutar contra eles.";
            escreverHistoria();
            botaoMeio.setText("Batalhar");
            contHistoria = 40015;
            exibirMenu.setEnabled(false);

            salvarDados();
        }
        
        salvarDados();
    }
    
    private void contHistoria5(){
        miniMapaBorda.setIcon(bordaMiniMapa);
        miniMapa.setIcon(imagemContHistoria4);
        telaFundo = 1;
        salvarDados();
        
        Historia1 = "Após a ponte você se encontra entre dois caminhos um para a esquerda";
        Historia2 = "que leva a cidade Bellatriz e outro a direita que leva";
        Historia3 = "a cidade de Pelber. Qual caminho deseja seguir?";
        escreverHistoria();
        botaoEsquerda.setText("Bellatriz");
        botaoDireita.setText("Pelber");
        
        local = "Caminhos2";
        salvarDados();
    }
    private void contHistoria5001(){
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        telaFundo = 1;
        salvarDados();
        
        Historia1 = "Parece que não foi a melhor escolha, logo depois de seguir";
        Historia2 = "esse caminho se encontra cercado por uma gangue de goblins.";
        Historia3 = "Você tenta correr ou luta?";
        escreverHistoria();
        botaoEsquerda.setText("Correr");
        botaoDireita.setText("Lutar");
        
        salvarDados();
    }
    private void contHistoria50011(){
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        telaFundo = 0;
        salvarDados();
        
        if(pontos[3] > 5){
            Historia1 = "Você consegue voltar todo o caminho e";
            Historia2 = "dessa vez vai direto para Pelber.";
            Historia3 = "";
            escreverHistoria();
            botaoMeio.setText("Continuar");
        }
        if(pontos[3]< 6){
            Historia1 = "Você tenta correr, mas não consegue,";
            Historia2 = "agora está em uma situação que deve lutar.";
            Historia3 = "";
            escreverHistoria();
            botaoMeio.setText("Batalhar");
            contHistoria = 50015;
            exibirMenu.setEnabled(false);
            
            salvarDados();
        }
        
        salvarDados();
    }
    private void contHistoria500111(){
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        telaFundo = 1;
        salvarDados();
        
        Historia1 = "Depois da batalha você pode fazer duas coisa continuar";
        Historia2 = "continuar esse caminho ou voltar";
        Historia3 = "e seguir para Pelber.";
        escreverHistoria();
        botaoEsquerda.setText("Continuar");
        botaoDireita.setText("Voltar");
        
        salvarDados();
    }
    private void contHistoria5001111(){
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        telaFundo = 0;
        salvarDados();
        
        Historia1 = "Você continua um pouco e encontra um Rei Goblin.";
        Historia2 = "Ele é gigante e parece extremamente perigoso.";
        Historia3 = "Você não consegue nem mesmo se mexer.";
        
        escreverHistoria();
        botaoMeio.setText("Continuar");
       
        salvarDados();
    }
    private void contHistoria50011111(){
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        int sorte= gerador.nextInt(6);
        telaFundo = 0;
        salvarDados();
        
        sorte = 0 ;
        
        if(sorte > 3){
            Historia1 = "Você felizmente, com medo,";
            Historia2 = "dessa vez vai direto para Pelber.";
            Historia3 = "";
            escreverHistoria();
            botaoMeio.setText("Continuar");
            salvarDados();
        }
        if(sorte < 4){
            Historia1 = "";
            Historia2 = "Você MORREU.";
            Historia3 = "";
            botaoTruco1.setEnabled(false);
            botaoTruco1.setVisible(false);
            botaoTruco2.setEnabled(false);
            botaoTruco2.setVisible(false);
            botaoTruco3.setEnabled(false);
            botaoTruco3.setVisible(false);
            botaoEsquerda.setEnabled(false);
            botaoEsquerda.setVisible(false);
            botaoDireita.setEnabled(false);
            botaoDireita.setVisible(false);
            botaoMeio.setVisible(false);
            botaoMeio.setEnabled(false);
            
            vidaBarraPersonagem = 0;
            escreverHistoria();
            salvarDados();
        }
    }
    private void contHistoria5001112(){
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        telaFundo = 0;
        salvarDados();
        
        Historia1 = "";
        Historia2 = "Você segue para Pelber tranquilamente.";
        Historia3 = "";
        escreverHistoria();
        botaoMeio.setText("Continuar");
        salvarDados();
    }
    private void contHistoria50012(){
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        telaFundo = 0;
        salvarDados();
        
        Historia1 = "Agora voce terá que enfrentar";
        Historia2 = "a gangue de goblins";
        Historia3 = "";
        escreverHistoria();
        botaoMeio.setText("Batalhar");
        contHistoria = 50015;
        exibirMenu.setEnabled(false);

        salvarDados();

    }
    private void contHistoria5002(){
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        telaFundo = 0;
        salvarDados();
        
        Historia1 = "";
        Historia2 = "Você segue para Pelber tranquilamente.";
        Historia3 = "";
        escreverHistoria();
        botaoMeio.setText("Continuar");
        salvarDados();
    }
    
    private void contHistoria6(){
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        telaFundo = 0;
        salvarDados();
        
        Historia1 = "Você chega em Pelber e está muito cansado";
        Historia2 = "e vai para uma pousada descansar. Chegando lá, você";
        Historia3 = "encontra um recepcionista e conversa com ele.";
        escreverHistoria();
        botaoMeio.setText("Continuar");
        if(contTravamento == 0){
            levelBarra = levelBarra + 150;
        }
        local = "Pousada";
        salvarDados();
    }
    private void contHistoria600(){
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        telaFundo = 0;
        salvarDados();
        int sorte= gerador.nextInt(6);
        
        if(sorte > 4){
            Historia1 = "Você consegue se estabelecer na pousada";
            Historia2 = "e dorme lá esta noite.";
            Historia3 = "";
            escreverHistoria();
            botaoMeio.setText("Continuar");
            salvarDados();
        }
        if(sorte < 5){
            Historia1 = "Você foi grosso e intimidador com o dono da";
            Historia2 = "pousada e acaba dormindo na rua,";
            Historia3 = "perdendo 15 pontos de vida.";
            if(contTravamento == 0){
                vidaBarraPersonagem = vidaBarraPersonagem - 15;
            }
            escreverHistoria();
            botaoMeio.setText("Continuar");
            salvarDados();
        }
        
        local = "Pousada";
        salvarDados();
    }
    private void contHistoria6000(){
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        telaFundo = 0;
        salvarDados();
        
        Historia1 = "Na rua você dorme ao lado de um mendigo, Gigão cornão do GH.";
        Historia2 = "Você descobre que ele foi traído por sua mulher, e se entregou";
        Historia3 = "as Glades e agora vive na rua apenas BAFORANDO Glade...";
        escreverHistoria();
        botaoMeio.setText("Continuar");
        salvarDados();
        
        
        local = "Pousada";
        salvarDados();
    }
    
    private void contHistoria7(){
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        telaFundo = 1;
        salvarDados();
        
        Historia1 = "Agora você pode ir para dois lugares.";
        Historia2 = "O campo de treinamento ou a taverna para";
        Historia3 = "conseguir mais informações.";
        escreverHistoria();
        botaoEsquerda.setText("Treinamento");
        botaoDireita.setText("Taverna");
        
        local = "Pousada";
        salvarDados();
    }
    private void contHistoria7001(){
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        telaFundo = 0;
        salvarDados();
        
        Historia1 = "Chegando no campo de treino você encontra um homem";
        Historia2 = "e você conversa com ele. Ele se diz o treinador do local";
        Historia3 = "e que vai treinar você.";
        escreverHistoria();
        botaoMeio.setText("Continuar");
        
        local = "Treinamento";
        salvarDados();
    }
    private void contHistoria70011(){
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        telaFundo = 0;
        salvarDados();
        
         if(pontos[5] > 4){
            Historia1 = "Você se esforça muito no treinamento";
            Historia2 = "conseguindo assim, ganhar 250 de xp e";
            Historia3 = "5 pontos de atributos";
            if(contTravamento == 0){
                levelBarra = levelBarra + 250;
                pontos_adiconais = pontos_adiconais + 5;
            }
            escreverHistoria();
            botaoMeio.setText("Continuar");
            salvarDados();
        }
        if(pontos[5] < 5){
            Historia1 = "Você não se foca muito no treinamento";
            Historia2 = "conseguindo assim, ganhar 75 de xp e";
            Historia3 = "2 pontos de atributos";
            if(contTravamento == 0){
                levelBarra = levelBarra + 75;
                pontos_adiconais = pontos_adiconais + 2;
            }
            escreverHistoria();
            botaoMeio.setText("Continuar");
            salvarDados();
        }
        
        local = "Treinamento";
        salvarDados();
    }
    private void contHistoria7002(){
        telaFundo = 1;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados();
        
        Historia1 = "Você chega na taverna e não encontra ninguém lá, apenas umas folhas.";
        Historia2 = "Deseja apenas sair ou olhar o que está escrito nessas folhas?";
        Historia3 = "";
        escreverHistoria();
        botaoEsquerda.setText("Sair");
        botaoDireita.setText("Olhar");
        
        local = "Taverna";
        salvarDados();
    }
    private void contHistoria70021(){
        telaFundo = 0;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados();
        
        Historia1 = "Você apenas sai da taverna";
        Historia2 = "e segue para o seu destino.";
        Historia3 = "";
        escreverHistoria();
        botaoMeio.setText("Continuar");
        
        local = "Taverna";
        salvarDados();
    }
    private void contHistoria70022(){
        telaFundo = 0;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados();
        
        Historia1 = "Você olha as folhas que continham informações cruciais para o próximo caminho. ";
        Historia2 = "Nelas diz que ciclopes dominaram a floresta de Lobsville e";
        Historia3 = "que se tornou um local com passagem perigosa.";
        escreverHistoria();
        botaoMeio.setText("Continuar");
        
        local = "Taverna";
        salvarDados();
    }
    private void contHistoria700220(){
        telaFundo = 1;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados();
        
        Historia1 = "Mas enquanto olhava o dono da taverna viu você mexendo em suas folhas e lhe perguntou";
        Historia2 = "o que você estava fazendo. Você diz que queria apenas algumas informações";
        Historia3 = "ou diz que estava pegando as folhas que estavam no chão.";
        escreverHistoria();
        botaoEsquerda.setText("Informações");
        botaoDireita.setText("Pegando");
        
        local = "Taverna";
        salvarDados();
    }
    private void contHistoria700221(){
        telaFundo = 0;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados();
        
        Historia1 = "Você devolve as folhas e ele lhe deseja sorte";
        Historia2 = "para ir para a próxima cidade. E por achar você legal,";
        Historia3 = "te da um frasco de 100 de Xp.";
        escreverHistoria();
        botaoMeio.setText("Continuar");
        if(contTravamento == 0){
            levelBarra = levelBarra + 100;
        }
        
        local = "Taverna";
        salvarDados();
    }
    private void contHistoria700222(){
        telaFundo = 0;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados();
        
        Historia1 = "Ele já te observava antes e percebeu sua mentira.";
        Historia2 = "Ele diz que não gosta de mentirosos e te bate e expulsa.";
        Historia3 = "Você perde 15 pontos de vida.";
        if(contTravamento == 0){
            vidaBarraPersonagem = vidaBarraPersonagem - 15;
        }
        escreverHistoria();
        botaoMeio.setText("Continuar");
        
        local = "Taverna";
        salvarDados();
    }
    
    private void contHistoria708(){
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        telaFundo = 1;
        salvarDados();
        
        Historia1 = "Andando pela cidade, você encontra um local de apostas,";
        Historia2 = "onde possui dois tipos de jogos, um chamado Potato Time e o outro  Barra da Sorte.";
        Historia3 = "Qual você deseja escolher?";
        escreverHistoria();
        botaoEsquerda.setText("Potato Time");
        botaoDireita.setText("Barra");
        
        local = "Pousada";
    }
    private void contHistoria7080(){
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        telaFundo = 3;
        salvarDados();
        
        batata.setIcon(avatarPotatoTime);
        
        textoHistoria1.setText(null);
        textoHistoria2.setText(null);
        textoHistoria3.setText(null);
        
        painelPotatoTime.setVisible(true);
        painelPotatoTime.setEnabled(true);
        
        batata.setEnabled(true);
    }
    private void contHistoria70800(){
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        telaFundo = 3;
        salvarDados();
        
        textoHistoria1.setText(null);
        textoHistoria2.setText(null);
        textoHistoria3.setText(null);
        
        painelBarraSorte.setVisible(true);
        painelBarraSorte.setEnabled(true);
        cliqueAqui.setEnabled(true);
        
    }
    
    private void contHistoria8(){
        telaFundo = 1;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados();
        
        Historia1 = "Você agora segue para a cidade de Elber e";
        Historia2 = "possui dois jeitos de chegar lá. Pela floresta de";
        Historia3 = "Lobsville ou pelo caminho do LoboCinzento.";
        escreverHistoria();
        botaoEsquerda.setText("Lobsville");
        botaoDireita.setText("LoboCinzento");
        
        local = "Caminho3";
        salvarDados();
    }
    private void contHistoria8001(){
        telaFundo = 0;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados(); 
        
        Historia1 = "Entrando na floresta você se encontra";
        Historia2 = "com 3 ciclopes bem grandes e não vê outra escolha";
        Historia3 = "a não ser a luta.";
        escreverHistoria();
        botaoMeio.setText("Batalhar");
        contHistoria = 80015;
        exibirMenu.setEnabled(false);
       
        salvarDados();
    }
    private void contHistoria80011(){
        telaFundo = 0;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados(); 
        
        Historia1 = "Depois de acabar a luta";
        Historia2 = "você continua a estrada";
        Historia3 = "até o final da floresta.";
        escreverHistoria();
        botaoMeio.setText("Continuar");
        salvarDados();
       
    }
    private void contHistoria800111(){
        telaFundo = 0;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        int sorte= gerador.nextInt(6);
        salvarDados();
        
        if(sorte > 3){
            Historia1 = "";
            Historia2 = "Nada acontece durante o caminho.";
            Historia3 = "";
            escreverHistoria();
            botaoMeio.setText("Continuar");
            salvarDados();
        }
        if(sorte < 4){
            Historia1 = "Você se perde e se encontra";
            Historia2 = "com mais um grupo";
            Historia3 = "de 3 ciclopes.";
            escreverHistoria();
            botaoMeio.setText("Batalhar");
            contHistoria = 800152;
            exibirMenu.setEnabled(false);
            
            salvarDados();
        }
    }
    private void contHistoria8001111(){
        telaFundo = 1;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados(); 
        
        Historia1 = "Após a batalha você se encontra perdido no meio da floresta.";
        Historia2 = "Está ficando tarde e você está com medo de enfrentar mais ciclopes.";
        Historia3 = "Você prefere tentar arranjar um abrigo ou tentar sair da floresta?";
        escreverHistoria();
        botaoEsquerda.setText("Abrigo");
        botaoDireita.setText("Sair");
        salvarDados();
    }
    private void contHistoria80011111(){
        telaFundo = 1;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados(); 
        
        Historia1 = "Você acha uma caverna.";
        Historia2 = "Você quer se abrigar nela ou";
        Historia3 = "continuar procurando outro abrigo?";
        escreverHistoria();
        botaoEsquerda.setText("Abrigar");
        botaoDireita.setText("Procurar");
        salvarDados();
    }
    private void contHistoria8001111110(){
        telaFundo = 0;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados(); 
        
        Historia1 = "";
        Historia2 = "Felizmente no início da caverna não havia monstros.";
        Historia3 = "";
        escreverHistoria();
        botaoMeio.setText("Continuar");

        salvarDados();
        
    }
    private void contHistoria800111111(){
        telaFundo = 0;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        int sorte= gerador.nextInt(6);
        salvarDados(); 
        
       if(sorte > 4){
            Historia1 = "Você sai da caverna sem problemas";
            Historia2 = "e chega no fim da floresta.";
            Historia3 = "";
            escreverHistoria();
            botaoMeio.setText("Continuar");
            
            salvarDados();
        }
        if(sorte < 5){
            salvarDados();
            Historia1 = "Quando você estavá saindo da caverna, ouve um desabamento de pedras bem";
            Historia2 = "na saída. Agora o único jeito é empurrar as pedras.";
            Historia3 = "";
            escreverHistoria();
            contHistoria = 80001111;
            botaoMeio.setText("Continuar");
            
            salvarDados();
        }
    }
    private void contHistoria8000111111(){
        telaFundo = 0;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados();
        
        if(pontos[0] > 6){
            Historia1 = "";
            Historia2 = "Você empurra com facilidade as pedras..";
            Historia3 = "";
            escreverHistoria();
            botaoMeio.setText("Continuar");
            salvarDados();
        }
        if(pontos[0] < 7){
            Historia1 = "Você empurra com muita força, mas logo cai em seguida e perde 20 de vida.";
            Historia2 = "Agora você está preso na caverna e não há mais esperança de vida aparente.";
            Historia3 = "A única coisa que você pode fazer é gritar socorro.";
            escreverHistoria();
            if(contTravamento == 0){
                vidaBarraPersonagem = vidaBarraPersonagem - 20;
            }
            botaoMeio.setText("Socoroo");
            contHistoria = 80001111111L;
            
            salvarDados();
        }
    }
    private void contHistoria80001111111(){
        telaFundo = 0;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        int sorte= gerador.nextInt(6);
        salvarDados();
        
        
        if(sorte > 1){
            Historia1 = "Você tem muita sorte mesmo hein, outros heróis que passavam para libertar Lobsville dos monstros";
            Historia2 = "ouviram você gritando e te resgatam. Por ter passado 10 dias ali, você perdeu 30 de vida por fome.";
            Historia3 = "";
            escreverHistoria();
            contHistoria = 800001;
            if(contTravamento == 0){
                vidaBarraPersonagem = vidaBarraPersonagem - 30;
            }
            botaoMeio.setText("Continuar");
            salvarDados();
        }
        if(sorte < 2){
            Historia1 = "Você após 16 dias sem comer,";
            Historia2 = "morre de fome gritando socorro.";
            Historia3 = "";
            vidaBarraPersonagem = 0;
            contHistoria = 9999;
            escreverHistoria();
            salvarDados();
        }
    }
    private void contHistoria800011111111(){
        telaFundo = 0;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados();
        
         if("Mago".equals(classeEscolhida)){
            Historia1 = "";
            Historia2 = "";
            Historia3 = "";
        }
        if("Berserk".equals(classeEscolhida)){
            Historia1 = "VOCÊ FOI RESGATADO POR LOS GADOS HERMANOS!!!";
            Historia2 = "Dentro desse tão amado grupo de heróis se encontravam Carlos e Lucão, conhecidos como los gados hermanos.";
            Historia3 = "Agora você agradece os los gados e segue para a próxima cidade.";
        }
        if("Arqueira".equals(classeEscolhida)){
            Historia1 = "VOCÊ FOI RESGATADA POR LOS GADOS HERMANOS!!!";
            Historia2 = "Dentro desse tão amado grupo de heróis se encontravam Carlos e Lucão, conhecidos como los gados hermanos.";
            Historia3 = "Agora você agradece os los gados e segue para a próxima cidade.";
        }
        if("Assassina".equals(classeEscolhida)){
            Historia1 = "";
            Historia2 = "";
            Historia3 = "";
        }
        if("Cavaleiro".equals(classeEscolhida)){
            Historia1 = "";
            Historia2 = "";
            Historia3 = "";
        }
        escreverHistoria();
        contHistoria = 8000011;
        botaoMeio.setText("Continuar");
        salvarDados();
    }
    private void contHistoria800111112(){
        telaFundo = 0;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        int sorte= gerador.nextInt(6);
        salvarDados(); 
        
       if(sorte > 4){
            Historia1 = "Você encontra uma casa abandonada";
            Historia2 = "e passa a noite lá.";
            Historia3 = "";
            escreverHistoria();
            botaoMeio.setText("Continuar");
            
            salvarDados();
        }
        if(sorte < 5){
            telaFundo = 0;
            salvarDados();
            Historia1 = "Você infelizmente não encontra nada";
            Historia2 = "e se encontra cercado por três ciclopes novamente.";
            Historia3 = "";
            escreverHistoria();
            botaoMeio.setText("Batalhar");
            contHistoria = 800154;
            exibirMenu.setEnabled(false);
            salvarDados();
        }
    }
    private void contHistoria8001111120(){
       telaFundo = 0;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados(); 
        Historia1 = "Agora o dia já está claro e";
        Historia2 = "você encontra com facilidade a";
        Historia3 = "saída para o final da floresta.";
        escreverHistoria();
        botaoMeio.setText("Continuar");
        
        salvarDados();
    }
    private void contHistoria80011111200(){
        telaFundo = 0;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados(); 
        Historia1 = "Agora o dia já está claro e";
        Historia2 = "você encontra a saída para o final da floresta.";
        Historia3 = "";
        escreverHistoria();
        botaoMeio.setText("Continuar");
        
        salvarDados();
    }
    private void contHistoria80011112(){
        telaFundo = 0;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        int sorte= gerador.nextInt(6);
        salvarDados(); 
        
       if(sorte > 4){
            Historia1 = "Você, com sorte, consegue encontrar o caminho";
            Historia2 = "para fora da floresta sem encontrar monstros ou adversidade.";
            Historia3 = "O dia já está claro e você segue em direção para a próxima cidade.";
            escreverHistoria();
            botaoMeio.setText("Continuar");
            
            salvarDados();
        }
        if(sorte < 5){
            telaFundo = 0;
            salvarDados();
            Historia1 = "Você infelizmente não encontra o caminho para fora da floresta";
            Historia2 = "e se encontra cercado por três ciclopes novamente.";
            Historia3 = "";
            escreverHistoria();
            botaoMeio.setText("Batalhar");
            contHistoria = 800153;
            exibirMenu.setEnabled(false);
            salvarDados();
        }
    }
    private void contHistoria800111120(){
        telaFundo = 0;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados(); 
        Historia1 = "Agora o dia já está claro e";
        Historia2 = "você encontra a saída para o final da floresta.";
        Historia3 = "";
        escreverHistoria();
        botaoMeio.setText("Continuar");
        
        salvarDados();
    }
    private void contHistoria8002(){
        telaFundo = 1;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados(); 
        
        Historia1 = "Chegando no centro do caminho do LoboCinzento você encontra uma placa";
        Historia2 = "indicando que a partir dali poderia encontrar o temível Lobo Cinzento.";
        Historia3 = "Você continua ou volta e vai pela floresta de Lobsville?";
        escreverHistoria();
        botaoEsquerda.setText("Continuar");
        botaoDireita.setText("Voltar");
        
        local = "Caminho3";
        salvarDados();
    }
    private void contHistoria80021(){
        telaFundo = 0;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        int sorte= gerador.nextInt(6);
        salvarDados(); 
        
        if(sorte > 3){
            Historia1 = "Você encontra uma slime no final do";
            Historia2 = "caminho e deve lutar contra ela para";
            Historia3 = "chegar na cidade de Elber.";
            escreverHistoria();
            botaoMeio.setText("Batalhar");
            contHistoria = 8001555;
            exibirMenu.setEnabled(false);
            
            salvarDados();
        }
        if(sorte < 4){
            Historia1 = "Você infelizmente encontra";
            Historia2 = "o LoboCinzento e ";
            Historia3 = "terá que enfrentá-lo.";
            escreverHistoria();
            botaoMeio.setText("Batalhar");
            contHistoria = 800155;
            exibirMenu.setEnabled(false);
            
            salvarDados();
        }
        
        salvarDados();
        
    }
    
    private void contHistoria9(){
        telaFundo = 0;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados(); 
        Historia1 = "A cidade mais próxima depois de se passar a floresta de Lobsville é bem misteriosa,e você não a conhecia.";
        Historia2 = "Chegando nela você encontra um velho muito sábio chamado Denys, ele lhe diz para tomar cuidado com as pessoas";
        Historia3 = "daquela cidade sem nome pois até isso roubaram nela. Você se distrai apenas por um segundo e o velho some.";
        escreverHistoria();
        botaoMeio.setText("Continuar");
        if(contTravamento == 0){
            if(levelPersonagem == 2){
                levelBarra = levelBarra + (levelBarraTotal - levelBarra) + 13;
            }else{
                levelBarra = levelBarra + 183;
            }
            
        }
        
        salvarDados();
        
    }
    private void contHistoria9001(){
        telaFundo = 1;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados(); 
        Historia1 = "Agora você possui duas ações para realizar,";
        Historia2 = "ir a uma loja de poções de cura e antídotos";
        Historia3 = "ou ir para a taverna daquela cidade.";
        escreverHistoria();
        botaoEsquerda.setText("Loja");
        botaoDireita.setText("Taverna");
        
        salvarDados();
        
    }
    private void contHistoria90011(){
        telaFundo = 1;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados(); 
        Historia1 = "Você entra na loja e se encontra com um senhor de idade.";
        Historia2 = "Ele te oferece duas escolhas, uma poção de cura 150 hp ou";
        Historia3 = "um antídoto raro que cura qualquer efeito de grupo.";
        escreverHistoria();
        botaoEsquerda.setText("Cura");
        botaoDireita.setText("Antídoto");
        
        salvarDados();
        
    }
    private void contHistoria900111(){
        telaFundo = 0;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados(); 
        Historia1 = "";
        Historia2 = "Você pega a poção de 150 hp";
        Historia3 = "";
        escreverHistoria();
        if(contTravamento == 0){
            vidaBarraPersonagem = vidaBarraPersonagem + 150;
        }
        botaoMeio.setText("Continuar");
        
        salvarDados();
        
    }
    private void contHistoria900112(){
        telaFundo = 0;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados(); 
        Historia1 = "";
        Historia2 = "Você pega o antídoto raro.";
        Historia3 = "";
        escreverHistoria();
        if(contTravamento == 0){
            pocaoEnvenenamento = 0;
            efeitoEnvenenamento.stop();
        }
        botaoMeio.setText("Continuar");
        
        salvarDados();
        
    }
    private void contHistoria90012(){
        telaFundo = 0;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados(); 
        Historia1 = "Essa taverna estava com um clima estranho, haviam 3 pessoas nela e o barmen e um homem dormindo.";
        Historia2 = "O barmen te olhava fixamente desde que você entrou.";
        Historia3 = "Ele se apresentou como Xoto enquanto limpava um copo de vidro que já estava limpo...";
        escreverHistoria();
        botaoMeio.setText("Continuar");
        
        salvarDados();
        
    }
    private void contHistoria900120(){
        telaFundo = 0;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados(); 
        Historia1 = "Xoto disse que o homem dormindo ali se chamava Paulo e que por uma maldição do rei demonio Kdú, tem de";
        Historia2 = "dormir 23h por dia... Infelizmente Xoto não tinha muitas informações para te dar sobre a próxima cidade,";
        Historia3 = "a única informação interessante que ele lhe disse foi que o nome da cidade em que você estava era Yucatán.";
        escreverHistoria();
        botaoMeio.setText("Continuar");
        
        
        int sorte= gerador.nextInt(6);
        
        if(sorte > 3){
            contHistoria = 9001200;
            
            salvarDados();
        }
        if(sorte < 4){
            contHistoria = 90012000;
            
            salvarDados();
        }
        
        salvarDados();
        
    }
    private void contHistoria9001200(){
        telaFundo = 0;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados(); 
        Historia1 = "Paulo o Dorminhoco acorda e";
        Historia2 = "após observar durante 5 segundos o arredor,";
        Historia3 = "ele volta a dormir.";
        escreverHistoria();
        botaoMeio.setText("Continuar");
        
        salvarDados();
        
    }
    private void contHistoria90012000(){
        telaFundo = 0;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados(); 
        Historia1 = "Agora o último homem estava mais distante, chegando perto dele, ele se apresenta como";
        Historia2 = "o mago mais forte chamado Leocardio, conhecido por mago do leite.";
        Historia3 = "Você conta para ele sua história e pergunta se ele sabe onde está Kdu.";
        escreverHistoria();
        botaoMeio.setText("Continuar");
        
        salvarDados();
        
    }
    private void contHistoria900120000(){
        telaFundo = 0;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados(); 
        
        if(pontos[7] > 4){
            Historia1 = "Ao conversar com ele você descobre que é na próxima cidade que Kdú(o rei demônio) se encontra,";
            Historia2 = "você já está bem forte e a vingança está perto de se realizar.";
            Historia3 = "Vá para SUA VINGANÇA HERÓI!";
            escreverHistoria();
            botaoMeio.setText("Continuar");
            
            salvarDados();
        }
        if(pontos[7] < 5){
            Historia1 = "O mago do leite não gostou da sua";
            Historia2 = "forma incisiva de perguntar e";
            Historia3 = "te joga leite e some dali.";
            escreverHistoria();
            botaoMeio.setText("Continuar");
            
            salvarDados();
        }
    }
    private void contHistoria9001200000(){
        telaFundo = 0;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados(); 
        
        Historia1 = "Quando você sai da loja,";
        Historia2 = "Xoto continuava limpando aquele copo já limpo.";
        Historia3 = "";
        escreverHistoria();
        botaoMeio.setText("Continuar");

        salvarDados();
        
    }
    
    private void contHistoria10(){
        telaFundo = 0;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados(); 
        
        Historia1 = "Seguindo a cidade até a fonte de água onde geralmente se joga dinheiro, não havia uma moeda sequer...";
        Historia2 = "Você entendeu a dica do velho Denys. Agora sabendo a verdade do local, você quer sair dali o mais rápido possível,";
        Historia3 = "porém a saída da cidade está bloqueada durante a noite por causa dos monstros de Lobsville.";
        escreverHistoria();
        botaoMeio.setText("Continuar");
        
        salvarDados();
        
    }
    private void contHistoria10000(){
        telaFundo = 1;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados(); 
        
        Historia1 = "Você deve passar a noite em alguma pousada da cidade. Chegando na recepção da pousada";
        Historia2 = "se encontrava um homem aparentemente cego. Você pergunta para ele se tem algum quarto disponível.";
        Historia3 = "O homem não te responde nada e lhe dá uma chave com o número 666. Você deseja dormir mesmo nesse lugar ou fora?";
        escreverHistoria();
        botaoEsquerda.setText("Dormir");
        botaoDireita.setText("Fora");
        
        salvarDados();
        
    }
    private void contHistoria100001(){
        telaFundo = 0;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados(); 
        
        Historia1 = "Você entra no seu quarto e não vê nada anormal, apenas uma boa quantidade de cupim, então você dorme.";
        Historia2 = "No outro dia após acordar e você percebe que suas roupas sumiram e agora você se encontra pelado.";
        Historia3 = "Mesmo procurando o dono da pousada na recepção ele não aparece em nenhum lugar.";
        escreverHistoria();
        botaoMeio.setText("Continuar");
        
        salvarDados();
        
    }
    private void contHistoria100002(){
        telaFundo = 0;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados(); 
        
        Historia1 = "Você dorme no banco da praça, bem desconfortável.";
        Historia2 = "No outro dia após acordar e você percebe que suas roupas sumiram e agora você se encontra pelado.";
        Historia3 = "Por conta do frio você perdeu 15 pontos de vida";
        escreverHistoria();
        botaoMeio.setText("Continuar");
        if(contTravamento == 0){
            vidaBarraPersonagem = vidaBarraPersonagem - 15;
        }
        
        salvarDados();
        
    }
    
    private void contHistoria11(){
        telaFundo = 0;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados(); 
        
        Historia1 = "Sem o que fazer você segue para a saída da cidade mesmo parecendo um pervertido. Bom...";
        Historia2 = "pra sua sorte aquela cidade não tinha ninguém, parecia abandonada, todos sumiram.";
        Historia3 = "Na saída você vê um espantalho com suas roupas e pega elas de volta.";
        escreverHistoria();
        botaoMeio.setText("Continuar");
        
        salvarDados();
        
    }
    private void contHistoria11000(){
        telaFundo = 1;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados(); 
        
        Historia1 = "Continuando um pouco a frente o caminho você encontra um mercador de carroça e";
        Historia2 = "ele te oferece para dar uma carona até a capital do país, Muhren.";
        Historia3 = "Você aceita a carona ou prefere ir andando?";
        escreverHistoria();
        botaoEsquerda.setText("Aceitar");
        botaoDireita.setText("Andar");
        
        salvarDados();
        
    }
    private void contHistoria110001(){
        telaFundo = 0;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados(); 
        
        Historia1 = "O mercador se chamava Samuel ele meio estranho e evasivo sobre o que transportava. Ao longo da";
        Historia2 = "viagem vocês foram conversando e ele te pergunta o por quê de você estar no meio do nada. Porém ao lhe falar da";
        Historia3 = "cidade que estava, ele ficou bastante tempo pensando e falou que não existia nenhuma cidade por aquelas bandas...";
        escreverHistoria();
        botaoMeio.setText("Continuar");
        
        salvarDados();
        
    }
    private void contHistoria1100010(){
        telaFundo = 0;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados(); 
        
        Historia1 = "Pouco tempo depois e já perto de Muhren, Samuel deu um drift de carroça... Absurdo.";
        Historia2 = "Samuel não tinha noção das coisas, vocês cairam da carroça e ela quebrou...";
        Historia3 = "Você perde 10 pontos de vida.";
        escreverHistoria();
        botaoMeio.setText("Continuar");
        if(contTravamento == 0){
            vidaBarraPersonagem = vidaBarraPersonagem - 10;
        }
        
        salvarDados();
        
    }
    private void contHistoria11000100(){
        telaFundo = 0;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados(); 
        
        Historia1 = "A mercadoria foi revelada. ERAM MENTOS! A droga ilícita que ele levava para Muhren.";
        Historia2 = "Essa droga era proibida no país Hurensohn governado pelo Rei Gabi.";
        Historia3 = "Samuel após aquilo envergonhado...diz : \"A carroça deveria estar mais rebaixada\".";
        escreverHistoria();
        botaoMeio.setText("Continuar");
        
        salvarDados();
        
    }
    private void contHistoria110002(){
        telaFundo = 1;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados(); 
        
        Historia1 = "Você encontra no meio do caminho um cavaleiro fortemente armado";
        Historia2 = "chamado Dom Quixote, ele te desafia para um duelo,";
        Historia3 = "você aceita?";
        escreverHistoria();
        botaoEsquerda.setText("Sim");
        botaoDireita.setText("Não");
        
        salvarDados();
        
    }
    private void contHistoria1100021(){
        telaFundo = 0;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados(); 
        
        Historia1 = "Você ganha dele facilmente, sem nem se esforçar, apesar de parecer fortemente armado ele era muito fraco.";
        Historia2 = "Ele te dá a espada aparentemente muito forte e você decide guardá-la para usa-la contra Kdú.";
        Historia3 = "Mas logo percebe que a espada era de plástico e joga ela fora.";
        escreverHistoria();
        botaoMeio.setText("Continuar");
        
        salvarDados();
        
    }
    private void contHistoria1100022(){
        telaFundo = 0;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados(); 
        
        Historia1 = "Ele te chama de fraco e segue para o lado oposto.";
        Historia2 = "Você perde 1 pontos de força de vontade";
        Historia3 = "";
        escreverHistoria();
        botaoMeio.setText("Continuar");
        if(contTravamento == 0){
            pontos[5] = pontos[5] - 1;
        }
        
        salvarDados();
        
    }
    private void contHistoria1100020(){
        telaFundo = 0;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados(); 
        
        Historia1 = "A cidade era muito longe,";
        Historia2 = "parece que era melhor ter pego carona,";
        Historia3 = "você perde 20 pontos de vida por extremo cansaço.";
        escreverHistoria();
        botaoMeio.setText("Continuar");
        if(contTravamento == 0){
            vidaBarraPersonagem = vidaBarraPersonagem - 20;
        }
        
        salvarDados();
        
    }
    
    private void contHistoria12(){
        telaFundo = 0;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados(); 
        
        Historia1 = "Chegando em Muhren a capital do reino, o calor e o ar impuro foram percebidos instantaneamente.";
        Historia2 = "Entrando nela, logo de cara você vê uma cidade alegre, bem trabalhadora e cheio de estatuas do Deus Iago,";
        Historia3 = "porém chegando a noite, ela era dominada por pessoas viciadas em mentos.";
        escreverHistoria();
        botaoMeio.setText("Continuar");
        
        salvarDados();
        
    }
    private void contHistoria12000(){
        telaFundo = 1;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados(); 
        
        Historia1 = "Você quer fazer justiça pelo Rei Gabi e";
        Historia2 = "enfrentar os drogados de mentos ou";
        Historia3 = "deseja ir a loja de poções e elixires?";
        escreverHistoria();
        botaoEsquerda.setText("Enfrentar");
        botaoDireita.setText("Loja");
        
        salvarDados();
        
    }
    private void contHistoria120001(){
        telaFundo = 0;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados(); 
        
        Historia1 = "Você derrota facilmente os viciados, porém após derrotar os drogados, duas meninas aparecem se alto";
        Historia2 = "declarando gangue da cenoura. Essas duas se chamavam Amanda e Mariana e dizem ganhar muito distribuindo os";
        Historia3 = "mentos pela cidade e já que você está atrapalhando o comercio delas... Elas irão te matar.";
        escreverHistoria();
        botaoMeio.setText("Continuar");
        
        salvarDados();
        
    }
    private void contHistoria1200010(){
        telaFundo = 1;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados(); 
        
        Historia1 = "Elas te desafiam a experimentar a droga chamada Mentos, e se você resistisse a ela, a gangue";
        Historia2 = "da cenoura irá sair de Muhren, mas se você não resistir pode se tornar seu Fim...";
        Historia3 = "Você possui duas opções, fugir delas ou experimentar?";
        escreverHistoria();
        botaoEsquerda.setText("Fugir");
        botaoDireita.setText("Experimentar");
        
        salvarDados();
        
    }
    private void contHistoria12000101(){
        telaFundo = 0;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados(); 
        
        if(pontos[3] > 6){
            Historia1 = "Por sua agilidade estar alta,";
            Historia2 = "você consegue escapar sem nenhum dano";
            Historia3 = "";
            escreverHistoria();
            botaoMeio.setText("Continuar");
            salvarDados();
        }
        if(pontos[3] < 7){
            Historia1 = "Por sua agilidade não ser muito alta,";
            Historia2 = "você consegue escapar delas, mas leva";
            Historia3 = " 15 de dano";
            escreverHistoria();
            botaoMeio.setText("Continuar");
            if(contTravamento == 0){
                vidaBarraPersonagem = vidaBarraPersonagem - 15;
            }
            
            salvarDados();
        }
        
    }
    private void contHistoria12000102(){
        telaFundo = 0;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados(); 
        
        if(pontos[5] > 9){
            Historia1 = "Você consegue resistir a droga,";
            Historia2 = "sendo assim, a gangue da cenoura sai de Muhren";
            Historia3 = " e você recebe 50 de Xp";
            escreverHistoria();
            botaoMeio.setText("Continuar");
            if(contTravamento == 0){
                levelBarra = levelBarra + 50;
            }
            salvarDados();
        }
        if(pontos[5] < 10){
            Historia1 = "Você infelizmente";
            Historia2 = "não resiste a droga Mentos, e fica viciado.";
            Historia3 = "Tornando seu fim...";
            vidaBarraPersonagem = 0;
            contHistoria = 999912;
            escreverHistoria();
            salvarDados();
        }
        
    }
    private void contHistoria120002(){
        telaFundo = 1;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados(); 
        
        Historia1 = "Na loja você encontra o senhor Aldair que vende duas poções, uma que cura 150 de hp";
        Historia2 = "e outra que tem o efeito de aumentar sua estamina em 50 pontos.";
        Historia3 = "";
        escreverHistoria();
        
        botaoEsquerda.setText("Cura");
        botaoDireita.setText("Estamina");
        
        salvarDados();
        
    }
    private void contHistoria1200021(){
        telaFundo = 0;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados(); 
        
        Historia1 = "";
        Historia2 = "Você curou 150 de vida";
        Historia3 = "";
        escreverHistoria();
        botaoMeio.setText("Continuar");
        if(contTravamento == 0){
            vidaBarraPersonagem = vidaBarraPersonagem + 150;
        }
            
        
        salvarDados();
        
    }
    private void contHistoria1200022(){
        telaFundo = 0;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados(); 
        
        Historia1 = "";
        Historia2 = "Você aumentou a estamina em 50";
        Historia3 = "";
        escreverHistoria();
        botaoMeio.setText("Continuar");
        if(contTravamento == 0){
            estaminaBarra = estaminaBarra + 50;
        }
            
        
        salvarDados();
        
    }
    private void contHistoria1200023(){
        telaFundo = 0;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados(); 
        
        if(pontos[7] > 6){
            Historia1 = "Aldair não gostou de você,";
            Historia2 = "assim, ele não te deu nada";
            Historia3 = "de brinde.";
            escreverHistoria();
            botaoMeio.setText("Continuar");
            salvarDados();
        }
        if(pontos[7] < 7){
            Historia1 = "Por gostar de você,";
            Historia2 = "Aldair também lhe dá uma poção extra";
            Historia3 = "de estamina que dá 25 pontos.";
            escreverHistoria();
            botaoMeio.setText("Continuar");
            if(contTravamento == 0){
                estaminaBarra = estaminaBarra + 25;
            }
            
            salvarDados();
        }
        
    }
    private void contHistoria120003(){
        telaFundo = 0;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados(); 
        
        Historia1 = "Antes de você partir para a próxima cidade,";
        Historia2 = "decide que irá descansar em uma pousada, para";
        Historia3 = "depois continuar sua jornada";
        escreverHistoria();
        botaoMeio.setText("Continuar");
        
        salvarDados();
        
    }
    private void contHistoria1200030(){
        telaFundo = 0;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        int sorte= gerador.nextInt(6);
        salvarDados();
        
        if(sorte > 2){
            Historia1 = "Você dorme bem e por isso";
            Historia2 = "recupera 10 pontos de vida.";
            Historia3 = "";
            escreverHistoria();
            botaoMeio.setText("Continuar");
            if(contTravamento == 0){
                vidaBarraPersonagem = vidaBarraPersonagem + 10;
            }
            salvarDados();
        }
        if(sorte < 3){
            Historia1 = "No seu quarto da pousada";
            Historia2 = "havia uma farpa no chão,";
            Historia3 = "você pisa e perde 10 de vida.";
            escreverHistoria();
            botaoMeio.setText("Continuar");
            if(contTravamento == 0){
                vidaBarraPersonagem = vidaBarraPersonagem - 10;
            }
            
            salvarDados();
        }
    }
    private void contHistoria120004(){
        telaFundo = 1;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados(); 
        
        Historia1 = "Agora você vai até a maior estatua do Deus Iago e olha para ela.";
        Historia2 = "Você deseja rezar para o Deus Iago ou apenas sair?";
        Historia3 = "";
        escreverHistoria();
        botaoEsquerda.setText("Rezar");
        botaoDireita.setText("Sair");
        
        salvarDados();
        
    }
    private void contHistoria1200041(){
        telaFundo = 0;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados(); 
        
        Historia1 = "Você reza para Deus Iago";
        Historia2 = "e ganha 10 pontos adicionais.";
        Historia3 = "";
        escreverHistoria();
        botaoMeio.setText("Continuar");
            if(contTravamento == 0){
                pontos_adiconais = pontos_adiconais + 10;
                pontosAdicionaisBackup = pontosAdicionaisBackup + 10;
            }
        
        salvarDados();
        
    }
    private void contHistoria120005(){
        telaFundo = 0;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados(); 
        
        Historia1 = "Agora você segue para a próxima cidade.";
        Historia2 = "O caminho para a próxima cidade está bem macabro, com muitos nevoeiros do nada.";
        Historia3 = "Você ouvia apenas um som vindo do além.";
        escreverHistoria();
        botaoMeio.setText("Continuar");
        
        salvarDados();
        
    }
    private void contHistoria1200050(){
        telaFundo = 0;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados(); 
        
        Historia1 = "Chegando cada vez mais perto do som, você encontra um piriquito mágico que falava a língua humana";
        Historia2 = "e só repetia: \"Iago\". Olhando com mais atenção você percebe que ele é Piri, ave mágica do Deus Iago,";
        Historia3 = "que é muito retratada em livros por indicar má sorte.";
        escreverHistoria();
        botaoMeio.setText("Continuar");
        
        salvarDados();
        
    }
    private void contHistoria12000500(){
        telaFundo = 0;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados(); 
        
        Historia1 = "Logo depois de repetir mais 5 vezes Iago,";
        Historia2 = "ele sai voando e desaparece no nevoeiro.";
        Historia3 = "";
        escreverHistoria();
        botaoMeio.setText("Continuar");
        
        salvarDados();
        
    }
    
    private void contHistoria13(){
        telaFundo = 0;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados(); 
        
        Historia1 = "Agora você vê a cidade de Elber parecia uma cidade abandonada. Entrando nela você logo percebe a presença";
        Historia2 = "dos DEMÔNIOS que mataram sua família. E agora para conquistar sua vingança";
        Historia3 = "deve enfrentá-los e derrotar o rei dos demônios, Kdú.";
        escreverHistoria();
        botaoMeio.setText("Continuar");
        
        salvarDados();
        
    }
    private void contHistoria13000(){
        telaFundo = 0;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados(); 
        
        Historia1 = "Sem nem pensar você seguiu em direção aos 5 demônios subordinados do rei Demônio Kdú.";
        Historia2 = "A chamada Gangue do Dudu, Filho do rei demônio.";
        Historia3 = "";
        escreverHistoria();
        botaoMeio.setText("Batalhar");
        contHistoria = 1300015;
        exibirMenu.setEnabled(false);

        salvarDados();
        
    }
    private void contHistoria130000(){
        telaFundo = 1;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados(); 
        
        if("Mago".equals(classeEscolhida)){
            Historia1 = "";
            Historia2 = "";
            Historia3 = "";
        }
        if("Berserk".equals(classeEscolhida)){
            Historia1 = "Depois de enfrentar os demônios você está sozinho contra Kdú, aquele que matou sua família está na sua frente.";
            Historia2 = "Você deseja sair e seguir em frente a vida largando sua vingança ou";
            Historia3 = "deseja lutar e alcançar sua vingança tão desejada?";
        }
        if("Arqueira".equals(classeEscolhida)){
            Historia1 = "Depois de enfrentar os demônios você está sozinha contra Kdú, o passe direto para a riqueza.";
            Historia2 = "Você deseja sair e seguir em frente a vida largando sua cobiça por riqueza ou ";
            Historia3 = "deseja lutar e alcançar sua riqueza tão desejada?";
        }
        if("Assassina".equals(classeEscolhida)){
            Historia1 = "";
            Historia2 = "";
            Historia3 = "";
        }
        if("Cavaleiro".equals(classeEscolhida)){
            Historia1 = "";
            Historia2 = "";
            Historia3 = "";
        }
        escreverHistoria();
        botaoEsquerda.setText("Largar");
        botaoDireita.setText("Lutar");
        
        salvarDados();
        
    }
    private void contHistoria1300001(){
        telaFundo = 0;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados(); 
        
        Historia1 = "Você simplesmente sai e vive agora nas montanhas";
        Historia2 = "de Lauguer com sua nova família e feliz.";
        Historia3 = "";
        escreverHistoria();
        botaoMeio.setText("Fim");
        
        salvarDados();
        
    } // Fim
    private void contHistoria1300002(){ 
        telaFundo = 0;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados(); 
        
        if("Mago".equals(classeEscolhida)){
            Historia1 = "";
            Historia2 = "";
            Historia3 = "";
        }
        if("Berserk".equals(classeEscolhida)){
            Historia1 = "Após a batalha árdua você finalmente alcança a vingança.";
            Historia2 = "Derrotar o rei demônio que causou grande discordia no mundo por anos é um grande feito, e Rei Gabi";
            Historia3 = "te chama para o palácio para lhe dar uma recompensa.";
        }
        if("Arqueira".equals(classeEscolhida)){
            Historia1 = "Derrotar o rei demônio que causou grande discordia no mundo por anos é um grande feito,";
            Historia2 = "e Rei Gabi te chama para o palácio para lhe dar uma recompensa, assim como você queria.";
            Historia3 = "";
        }
        if("Assassina".equals(classeEscolhida)){
            Historia1 = "";
            Historia2 = "";
            Historia3 = "";
        }
        if("Cavaleiro".equals(classeEscolhida)){
            Historia1 = "";
            Historia2 = "";
            Historia3 = "";
        }
        escreverHistoria();
        botaoMeio.setText("Continuar");
        
        salvarDados();
        
    } 
    private void contHistoria13000020(){
        telaFundo = 1;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados(); 
       
        if("Mago".equals(classeEscolhida)){
            Historia1 = "";
            Historia2 = "";
            Historia3 = "";
        }
        if("Berserk".equals(classeEscolhida)){
            Historia1 = "Chegando no castelo do Rei ele te agradece por derrotar Kdú e lhe oferece um grande prêmio em dinheiro,";
            Historia2 = "assim como a mão de sua filha Gabriella.";
            Historia3 = "Você aceita o prêmio ou quer continuar viajando pelo mundo a fora?";
        }
        if("Arqueira".equals(classeEscolhida)){
            Historia1 = "Chegando no castelo do Rei ele te agradece por derrotar Kdú e lhe oferece um grande prêmio em dinheiro,";
            Historia2 = "assim como a mão de seu filho Willian.";
            Historia3 = "Você aceita o prêmio ou quer continuar viajando pelo mundo a fora?";
        }
        if("Assassina".equals(classeEscolhida)){
            Historia1 = "";
            Historia2 = "";
            Historia3 = "";
        }
        if("Cavaleiro".equals(classeEscolhida)){
            Historia1 = "";
            Historia2 = "";
            Historia3 = "";
        }
        escreverHistoria();
        botaoEsquerda.setText("Aceitar");
        botaoDireita.setText("Viajar");
        
        salvarDados();
        
    }
    private void contHistoria130000201(){
        telaFundo = 0;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados(); 
        
        if("Mago".equals(classeEscolhida)){
            Historia1 = "";
            Historia2 = "";
            Historia3 = "";
        }
        if("Berserk".equals(classeEscolhida)){
            Historia1 = "Você vive feliz para sempre com uma grande quantia";
            Historia2 = "em dinheiro e a princesa Gabriela.";
            Historia3 = "";
        }
        if("Arqueira".equals(classeEscolhida)){
            Historia1 = "Você vive feliz para sempre com uma grande quantia";
            Historia2 = "em dinheiro e o principe Willian.";
            Historia3 = "";
        }
        if("Assassina".equals(classeEscolhida)){
            Historia1 = "";
            Historia2 = "";
            Historia3 = "";
        }
        if("Cavaleiro".equals(classeEscolhida)){
            Historia1 = "";
            Historia2 = "";
            Historia3 = "";
        }
        escreverHistoria();
        botaoMeio.setText("Fim");
        
        salvarDados();
        
    } // Fim
    private void contHistoria130000202(){
        telaFundo = 0;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados(); 
        
        
        if("Mago".equals(classeEscolhida)){
            Historia1 = "";
            Historia2 = "";
            Historia3 = "";
        }
        if("Berserk".equals(classeEscolhida)){
            Historia1 = "Sua jornada continua, o que mais podemos esperar?";
            Historia2 = "Boa sorte Herói!!!";
            Historia3 = "";
        }
        if("Arqueira".equals(classeEscolhida)){
            Historia1 = "Sua jornada continua, o que mais podemos esperar?";
            Historia2 = "Boa sorte Heroína!!!";
            Historia3 = "";
        }
        if("Assassina".equals(classeEscolhida)){
            Historia1 = "";
            Historia2 = "";
            Historia3 = "";
        }
        if("Cavaleiro".equals(classeEscolhida)){
            Historia1 = "";
            Historia2 = "";
            Historia3 = "";
        }
        escreverHistoria();
        botaoMeio.setText("Fim");
        
        salvarDados();
        
    } // Fim
    
    private void contHistoria000(){
        telaFundo = 0;
        miniMapaBorda.setIcon(null);
        miniMapa.setIcon(null);
        salvarDados(); 
        
        if("Mago".equals(classeEscolhida)){
            Historia1 = "";
            Historia2 = "";
            Historia3 = "";
        }
        if("Berserk".equals(classeEscolhida)){
            Historia1 = "";
            Historia2 = "";
            Historia3 = "";
        }
        if("Arqueira".equals(classeEscolhida)){
            Historia1 = "";
            Historia2 = "";
            Historia3 = "";
        }
        if("Assassina".equals(classeEscolhida)){
            Historia1 = "";
            Historia2 = "";
            Historia3 = "";
        }
        if("Cavaleiro".equals(classeEscolhida)){
            Historia1 = "";
            Historia2 = "";
            Historia3 = "";
        }
        escreverHistoria();
        botaoMeio.setText("Continuar");
        
        salvarDados();
        
    } // Copy
    
    public telaHistoria() {
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
        
        
        telaInformacaoChamar = new telaInformacao();
        telaConfiguracaoChamar = new telaConfiguracao();
        telaInformacaoChamar.setVisible(false);
        telaConfiguracaoChamar.setVisible(false);
        
        botaoTruco1.setEnabled(false);
        botaoTruco1.setVisible(false);
        botaoTruco2.setEnabled(false);
        botaoTruco2.setVisible(false);
        botaoTruco3.setEnabled(false);
        botaoTruco3.setVisible(false);
        
        painelBarraSorte.setVisible(false);
        painelBarraSorte.setEnabled(false);
        cliqueAqui.setEnabled(false);
        
        painelPotatoTime.setVisible(false);
        painelPotatoTime.setEnabled(false);
        batata.setEnabled(false);
        
        lerContHistoria.setEnabled(false);
        lerContHistoria.setVisible(false);
        
        lerSalvamento();
        historia();
        
        if(pocaoEnvenenamento == 1){
            efeitoEnvenenamento.start();
        }
        
        adm();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelGeral = new javax.swing.JPanel();
        painelPotatoTime = new javax.swing.JPanel();
        batata = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        numeroDeBatatas = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        timerBatata = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        painelBarraSorte = new javax.swing.JPanel();
        barraDaSorte = new javax.swing.JProgressBar();
        cliqueAqui = new javax.swing.JButton();
        textoInfoBarra13 = new javax.swing.JLabel();
        textoInfoBarra12 = new javax.swing.JLabel();
        textoInfoBarra11 = new javax.swing.JLabel();
        textoInfoBarra10 = new javax.swing.JLabel();
        textoInfoBarra9 = new javax.swing.JLabel();
        textoInfoBarra8 = new javax.swing.JLabel();
        textoInfoBarra7 = new javax.swing.JLabel();
        textoInfoBarra6 = new javax.swing.JLabel();
        textoInfoBarra5 = new javax.swing.JLabel();
        textoInfoBarra4 = new javax.swing.JLabel();
        textoInfoBarra3 = new javax.swing.JLabel();
        textoInfoBarra2 = new javax.swing.JLabel();
        textoInfoBarra1 = new javax.swing.JLabel();
        textoInfoBarra = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        painelADM = new javax.swing.JPanel();
        lerContHistoria = new javax.swing.JTextField();
        botaoTruco1 = new javax.swing.JButton();
        botaoTruco2 = new javax.swing.JButton();
        botaoTruco3 = new javax.swing.JButton();
        comandosADM = new javax.swing.JButton();
        cliqueParaPassar = new javax.swing.JButton();
        exibirMenu = new javax.swing.JButton();
        personagem = new javax.swing.JPanel();
        avatar = new javax.swing.JLabel();
        bordaHistoria = new javax.swing.JLabel();
        exibirNome = new javax.swing.JLabel();
        exibirClasse = new javax.swing.JLabel();
        textoLevel = new javax.swing.JLabel();
        exibirLevelStatus = new javax.swing.JLabel();
        exibirVidaStatus = new javax.swing.JLabel();
        textoXP = new javax.swing.JLabel();
        exibirLevel = new javax.swing.JProgressBar();
        textoVida = new javax.swing.JLabel();
        exibirVida = new javax.swing.JProgressBar();
        botaoEsquerda = new javax.swing.JButton();
        botaoDireita = new javax.swing.JButton();
        botaoMeio = new javax.swing.JButton();
        exibirConfiguracao = new javax.swing.JButton();
        textoHistoria1 = new javax.swing.JLabel();
        textoHistoria2 = new javax.swing.JLabel();
        textoHistoria3 = new javax.swing.JLabel();
        miniMapa = new javax.swing.JLabel();
        miniMapaBorda = new javax.swing.JLabel();
        fundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setUndecorated(true);
        setSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        painelGeral.setMaximumSize(new java.awt.Dimension(1280, 720));
        painelGeral.setMinimumSize(new java.awt.Dimension(1280, 720));
        painelGeral.setPreferredSize(new java.awt.Dimension(1280, 720));
        painelGeral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        painelPotatoTime.setEnabled(false);
        painelPotatoTime.setFocusable(false);
        painelPotatoTime.setOpaque(false);
        painelPotatoTime.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        batata.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/avatarPotatoTime.png"))); // NOI18N
        batata.setBorder(null);
        batata.setBorderPainted(false);
        batata.setContentAreaFilled(false);
        batata.setFocusPainted(false);
        batata.setFocusable(false);
        batata.setOpaque(false);
        batata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batataActionPerformed(evt);
            }
        });
        painelPotatoTime.add(batata, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 110, 300, 300));

        jLabel8.setFont(new java.awt.Font("Imprint MT Shadow", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(60, 60, 60));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("der definirá o Xp ganho.");
        painelPotatoTime.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 260, 360, -1));

        jLabel7.setFont(new java.awt.Font("Imprint MT Shadow", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(60, 60, 60));
        jLabel7.setText("A quantidade de clicks que você");
        painelPotatoTime.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 230, -1, -1));

        numeroDeBatatas.setFont(new java.awt.Font("Impact", 0, 30)); // NOI18N
        numeroDeBatatas.setForeground(new java.awt.Color(151, 151, 151));
        numeroDeBatatas.setText("000");
        painelPotatoTime.add(numeroDeBatatas, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 260, -1, -1));

        jLabel5.setFont(new java.awt.Font("Impact", 0, 30)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(60, 60, 60));
        jLabel5.setText("Batatas: ");
        painelPotatoTime.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/logoPotatoTime.png"))); // NOI18N
        jLabel1.setFocusable(false);
        painelPotatoTime.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 200, 120));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/bordaPotatoTime.png"))); // NOI18N
        painelPotatoTime.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 370, 300, 100));

        timerBatata.setFont(new java.awt.Font("Impact", 0, 30)); // NOI18N
        timerBatata.setForeground(new java.awt.Color(60, 60, 60));
        timerBatata.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timerBatata.setText("00:00");
        painelPotatoTime.add(timerBatata, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 720, -1));

        jLabel3.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(60, 60, 60));
        jLabel3.setText("Clique na Batata !!");
        painelPotatoTime.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 170, -1, -1));

        painelGeral.add(painelPotatoTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 1280, 540));

        painelBarraSorte.setOpaque(false);
        painelBarraSorte.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        barraDaSorte.setBackground(new java.awt.Color(151, 151, 151));
        barraDaSorte.setForeground(new java.awt.Color(60, 60, 60));
        barraDaSorte.setMaximum(26);
        barraDaSorte.setMinimum(1);
        barraDaSorte.setBorder(null);
        barraDaSorte.setBorderPainted(false);
        painelBarraSorte.add(barraDaSorte, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 1000, 25));

        cliqueAqui.setFont(new java.awt.Font("Impact", 1, 36)); // NOI18N
        cliqueAqui.setForeground(new java.awt.Color(60, 60, 60));
        cliqueAqui.setText("Clique aqui !");
        cliqueAqui.setBorder(null);
        cliqueAqui.setBorderPainted(false);
        cliqueAqui.setContentAreaFilled(false);
        cliqueAqui.setDefaultCapable(false);
        cliqueAqui.setFocusPainted(false);
        cliqueAqui.setFocusable(false);
        cliqueAqui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cliqueAquiActionPerformed(evt);
            }
        });
        painelBarraSorte.add(cliqueAqui, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 340, -1, -1));

        textoInfoBarra13.setFont(new java.awt.Font("Ink Free", 2, 36)); // NOI18N
        textoInfoBarra13.setForeground(new java.awt.Color(60, 60, 60));
        textoInfoBarra13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        painelBarraSorte.add(textoInfoBarra13, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 1000, 70));

        textoInfoBarra12.setFont(new java.awt.Font("Ink Free", 0, 18)); // NOI18N
        textoInfoBarra12.setForeground(new java.awt.Color(60, 60, 60));
        textoInfoBarra12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoInfoBarra12.setText("100 xp");
        painelBarraSorte.add(textoInfoBarra12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 170, 90, 20));

        textoInfoBarra11.setFont(new java.awt.Font("Ink Free", 0, 18)); // NOI18N
        textoInfoBarra11.setForeground(new java.awt.Color(60, 60, 60));
        textoInfoBarra11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoInfoBarra11.setText("50 xp");
        painelBarraSorte.add(textoInfoBarra11, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 230, 90, 20));

        textoInfoBarra10.setFont(new java.awt.Font("Ink Free", 0, 18)); // NOI18N
        textoInfoBarra10.setForeground(new java.awt.Color(60, 60, 60));
        textoInfoBarra10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoInfoBarra10.setText("35 xp");
        painelBarraSorte.add(textoInfoBarra10, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 170, 90, 20));

        textoInfoBarra9.setFont(new java.awt.Font("Ink Free", 0, 18)); // NOI18N
        textoInfoBarra9.setForeground(new java.awt.Color(60, 60, 60));
        textoInfoBarra9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoInfoBarra9.setText("20 xp");
        painelBarraSorte.add(textoInfoBarra9, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 230, 90, 20));

        textoInfoBarra8.setFont(new java.awt.Font("Ink Free", 0, 18)); // NOI18N
        textoInfoBarra8.setForeground(new java.awt.Color(60, 60, 60));
        textoInfoBarra8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoInfoBarra8.setText("100 xp");
        painelBarraSorte.add(textoInfoBarra8, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 170, 90, 20));

        textoInfoBarra7.setFont(new java.awt.Font("Ink Free", 0, 18)); // NOI18N
        textoInfoBarra7.setForeground(new java.awt.Color(60, 60, 60));
        textoInfoBarra7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoInfoBarra7.setText("35 xp");
        painelBarraSorte.add(textoInfoBarra7, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 230, 90, 20));

        textoInfoBarra6.setFont(new java.awt.Font("Ink Free", 0, 18)); // NOI18N
        textoInfoBarra6.setForeground(new java.awt.Color(60, 60, 60));
        textoInfoBarra6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoInfoBarra6.setText("250 xp");
        painelBarraSorte.add(textoInfoBarra6, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 170, 90, 20));

        textoInfoBarra5.setFont(new java.awt.Font("Ink Free", 0, 18)); // NOI18N
        textoInfoBarra5.setForeground(new java.awt.Color(60, 60, 60));
        textoInfoBarra5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoInfoBarra5.setText("20 xp");
        painelBarraSorte.add(textoInfoBarra5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 230, 90, 20));

        textoInfoBarra4.setFont(new java.awt.Font("Ink Free", 0, 18)); // NOI18N
        textoInfoBarra4.setForeground(new java.awt.Color(60, 60, 60));
        textoInfoBarra4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoInfoBarra4.setText("50 xp");
        painelBarraSorte.add(textoInfoBarra4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, 90, 20));

        textoInfoBarra3.setFont(new java.awt.Font("Ink Free", 0, 18)); // NOI18N
        textoInfoBarra3.setForeground(new java.awt.Color(60, 60, 60));
        textoInfoBarra3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoInfoBarra3.setText("200 xp");
        painelBarraSorte.add(textoInfoBarra3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, 90, 20));

        textoInfoBarra2.setFont(new java.awt.Font("Ink Free", 0, 18)); // NOI18N
        textoInfoBarra2.setForeground(new java.awt.Color(60, 60, 60));
        textoInfoBarra2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoInfoBarra2.setText("100 xp");
        painelBarraSorte.add(textoInfoBarra2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 90, 20));

        textoInfoBarra1.setFont(new java.awt.Font("Ink Free", 0, 18)); // NOI18N
        textoInfoBarra1.setForeground(new java.awt.Color(60, 60, 60));
        textoInfoBarra1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoInfoBarra1.setText("35 xp");
        painelBarraSorte.add(textoInfoBarra1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 90, 20));

        textoInfoBarra.setFont(new java.awt.Font("Ink Free", 0, 18)); // NOI18N
        textoInfoBarra.setForeground(new java.awt.Color(60, 60, 60));
        textoInfoBarra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoInfoBarra.setText("20 xp");
        painelBarraSorte.add(textoInfoBarra, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 90, 20));

        jLabel9.setFont(new java.awt.Font("Impact", 0, 30)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(60, 60, 60));
        jLabel9.setText("Clique no Botão e teste sua sorte");
        painelBarraSorte.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, -1, -1));

        jLabel6.setFont(new java.awt.Font("Imprint MT Shadow", 1, 30)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(60, 60, 60));
        jLabel6.setText("Barra da Sorte ");
        painelBarraSorte.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, -1, -1));

        painelGeral.add(painelBarraSorte, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 1280, 540));

        painelADM.setEnabled(false);
        painelADM.setOpaque(false);
        painelADM.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lerContHistoria.setBackground(new java.awt.Color(255, 255, 255));
        lerContHistoria.setForeground(new java.awt.Color(60, 60, 60));
        lerContHistoria.setBorder(null);
        lerContHistoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lerContHistoriaActionPerformed(evt);
            }
        });
        painelADM.add(lerContHistoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 150, 20));

        painelGeral.add(painelADM, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 300, 80));

        botaoTruco1.setBorderPainted(false);
        botaoTruco1.setContentAreaFilled(false);
        botaoTruco1.setEnabled(false);
        botaoTruco1.setFocusPainted(false);
        botaoTruco1.setFocusable(false);
        botaoTruco1.setRequestFocusEnabled(false);
        botaoTruco1.setVerifyInputWhenFocusTarget(false);
        botaoTruco1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoTruco1ActionPerformed(evt);
            }
        });
        painelGeral.add(botaoTruco1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 570, 100, 130));

        botaoTruco2.setBorderPainted(false);
        botaoTruco2.setContentAreaFilled(false);
        botaoTruco2.setEnabled(false);
        botaoTruco2.setFocusPainted(false);
        botaoTruco2.setFocusable(false);
        botaoTruco2.setRequestFocusEnabled(false);
        botaoTruco2.setVerifyInputWhenFocusTarget(false);
        botaoTruco2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoTruco2ActionPerformed(evt);
            }
        });
        painelGeral.add(botaoTruco2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 570, 100, 130));

        botaoTruco3.setBorderPainted(false);
        botaoTruco3.setContentAreaFilled(false);
        botaoTruco3.setEnabled(false);
        botaoTruco3.setFocusPainted(false);
        botaoTruco3.setFocusable(false);
        botaoTruco3.setRequestFocusEnabled(false);
        botaoTruco3.setVerifyInputWhenFocusTarget(false);
        botaoTruco3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoTruco3ActionPerformed(evt);
            }
        });
        painelGeral.add(botaoTruco3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 570, 100, 130));

        comandosADM.setText("ADM");
        comandosADM.setBorderPainted(false);
        comandosADM.setContentAreaFilled(false);
        comandosADM.setFocusable(false);
        comandosADM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comandosADMActionPerformed(evt);
            }
        });
        painelGeral.add(comandosADM, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 140, 20));

        cliqueParaPassar.setToolTipText("");
        cliqueParaPassar.setBorderPainted(false);
        cliqueParaPassar.setContentAreaFilled(false);
        cliqueParaPassar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cliqueParaPassarActionPerformed(evt);
            }
        });
        painelGeral.add(cliqueParaPassar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 1280, 560));

        exibirMenu.setBackground(new java.awt.Color(172, 172, 172));
        exibirMenu.setFont(new java.awt.Font("Imprint MT Shadow", 0, 24)); // NOI18N
        exibirMenu.setForeground(new java.awt.Color(60, 60, 60));
        exibirMenu.setText("Menu");
        exibirMenu.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        exibirMenu.setBorderPainted(false);
        exibirMenu.setContentAreaFilled(false);
        exibirMenu.setFocusable(false);
        exibirMenu.setMaximumSize(new java.awt.Dimension(50, 25));
        exibirMenu.setMinimumSize(new java.awt.Dimension(50, 25));
        exibirMenu.setPreferredSize(new java.awt.Dimension(50, 25));
        exibirMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exibirMenuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exibirMenuMouseExited(evt);
            }
        });
        exibirMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exibirMenuActionPerformed(evt);
            }
        });
        painelGeral.add(exibirMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 10, 90, -1));

        personagem.setOpaque(false);
        personagem.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        personagem.add(avatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 100));

        bordaHistoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/bordaHistoria.png"))); // NOI18N
        personagem.add(bordaHistoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 8, 110, 110));

        exibirNome.setFont(new java.awt.Font("Freshman", 0, 20)); // NOI18N
        exibirNome.setText("Nome");
        personagem.add(exibirNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 320, 30));

        exibirClasse.setFont(new java.awt.Font("MV Boli", 0, 16)); // NOI18N
        exibirClasse.setText("Classe");
        personagem.add(exibirClasse, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 80, -1));

        textoLevel.setFont(new java.awt.Font("MV Boli", 0, 16)); // NOI18N
        textoLevel.setText("Level: ");
        personagem.add(textoLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 211, -1));

        exibirLevelStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exibirLevelStatus.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        exibirLevelStatus.setMaximumSize(new java.awt.Dimension(170, 17));
        exibirLevelStatus.setMinimumSize(new java.awt.Dimension(170, 17));
        exibirLevelStatus.setPreferredSize(new java.awt.Dimension(170, 17));
        personagem.add(exibirLevelStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 170, 17));

        exibirVidaStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exibirVidaStatus.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        exibirVidaStatus.setMaximumSize(new java.awt.Dimension(170, 17));
        exibirVidaStatus.setMinimumSize(new java.awt.Dimension(170, 17));
        exibirVidaStatus.setPreferredSize(new java.awt.Dimension(170, 17));
        personagem.add(exibirVidaStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 170, 17));

        textoXP.setText(" XP");
        personagem.add(textoXP, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, -1, -1));

        exibirLevel.setBackground(new java.awt.Color(156, 156, 156));
        exibirLevel.setForeground(new java.awt.Color(67, 52, 212));
        exibirLevel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        exibirLevel.setMaximumSize(new java.awt.Dimension(170, 15));
        exibirLevel.setMinimumSize(new java.awt.Dimension(170, 15));
        exibirLevel.setPreferredSize(new java.awt.Dimension(170, 15));
        personagem.add(exibirLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, -1, -1));

        textoVida.setText(" HP");
        personagem.add(textoVida, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, -1, -1));

        exibirVida.setBackground(new java.awt.Color(156, 156, 156));
        exibirVida.setForeground(new java.awt.Color(175, 30, 30));
        exibirVida.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        exibirVida.setMaximumSize(new java.awt.Dimension(170, 17));
        exibirVida.setMinimumSize(new java.awt.Dimension(170, 17));
        exibirVida.setPreferredSize(new java.awt.Dimension(170, 17));
        personagem.add(exibirVida, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, -1, -1));

        painelGeral.add(personagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 120));

        botaoEsquerda.setBackground(new java.awt.Color(172, 172, 172));
        botaoEsquerda.setFont(new java.awt.Font("Dubai Medium", 0, 36)); // NOI18N
        botaoEsquerda.setForeground(new java.awt.Color(60, 60, 60));
        botaoEsquerda.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        botaoEsquerda.setBorderPainted(false);
        botaoEsquerda.setContentAreaFilled(false);
        botaoEsquerda.setFocusable(false);
        botaoEsquerda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botaoEsquerdaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botaoEsquerdaMouseExited(evt);
            }
        });
        botaoEsquerda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEsquerdaActionPerformed(evt);
            }
        });
        painelGeral.add(botaoEsquerda, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 640, 250, 40));

        botaoDireita.setBackground(new java.awt.Color(172, 172, 172));
        botaoDireita.setFont(new java.awt.Font("Dubai Medium", 0, 36)); // NOI18N
        botaoDireita.setForeground(new java.awt.Color(60, 60, 60));
        botaoDireita.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        botaoDireita.setBorderPainted(false);
        botaoDireita.setContentAreaFilled(false);
        botaoDireita.setFocusable(false);
        botaoDireita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botaoDireitaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botaoDireitaMouseExited(evt);
            }
        });
        botaoDireita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoDireitaActionPerformed(evt);
            }
        });
        painelGeral.add(botaoDireita, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 640, 270, 40));

        botaoMeio.setBackground(new java.awt.Color(172, 172, 172));
        botaoMeio.setFont(new java.awt.Font("Dubai Medium", 0, 36)); // NOI18N
        botaoMeio.setForeground(new java.awt.Color(60, 60, 60));
        botaoMeio.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        botaoMeio.setBorderPainted(false);
        botaoMeio.setContentAreaFilled(false);
        botaoMeio.setFocusable(false);
        botaoMeio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botaoMeioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botaoMeioMouseExited(evt);
            }
        });
        botaoMeio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoMeioActionPerformed(evt);
            }
        });
        painelGeral.add(botaoMeio, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 640, 220, 40));

        exibirConfiguracao.setBackground(new java.awt.Color(172, 172, 172));
        exibirConfiguracao.setFont(new java.awt.Font("Imprint MT Shadow", 0, 22)); // NOI18N
        exibirConfiguracao.setForeground(new java.awt.Color(60, 60, 60));
        exibirConfiguracao.setText("Configuração");
        exibirConfiguracao.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        exibirConfiguracao.setBorderPainted(false);
        exibirConfiguracao.setContentAreaFilled(false);
        exibirConfiguracao.setFocusable(false);
        exibirConfiguracao.setMaximumSize(new java.awt.Dimension(80, 25));
        exibirConfiguracao.setMinimumSize(new java.awt.Dimension(80, 25));
        exibirConfiguracao.setPreferredSize(new java.awt.Dimension(80, 25));
        exibirConfiguracao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exibirConfiguracaoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exibirConfiguracaoMouseExited(evt);
            }
        });
        exibirConfiguracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exibirConfiguracaoActionPerformed(evt);
            }
        });
        painelGeral.add(exibirConfiguracao, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 10, 180, -1));

        textoHistoria1.setFont(new java.awt.Font("Dubai Medium", 0, 24)); // NOI18N
        textoHistoria1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        painelGeral.add(textoHistoria1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 1260, 30));

        textoHistoria2.setFont(new java.awt.Font("Dubai Medium", 0, 24)); // NOI18N
        textoHistoria2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        painelGeral.add(textoHistoria2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 1260, 30));

        textoHistoria3.setFont(new java.awt.Font("Dubai Medium", 0, 24)); // NOI18N
        textoHistoria3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        painelGeral.add(textoHistoria3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 1260, 30));
        painelGeral.add(miniMapa, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, 280, 200));
        painelGeral.add(miniMapaBorda, new org.netbeans.lib.awtextra.AbsoluteConstraints(605, 15, 290, 210));

        fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundoHistoriaUm.png"))); // NOI18N
        painelGeral.add(fundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(painelGeral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exibirMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exibirMenuActionPerformed
        contTravamento = 1;
        efeitoEnvenenamento.stop();
        this.setMenu(new telaMenu(this,true,name));
        this.getMenu().setVisible(true);
        salvarDados();
        this.dispose();
    }//GEN-LAST:event_exibirMenuActionPerformed

    private void exibirConfiguracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exibirConfiguracaoActionPerformed
        telaConfiguracaoChamar.setVisible(true);
        salvarDados();
    }//GEN-LAST:event_exibirConfiguracaoActionPerformed

    private void exibirConfiguracaoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exibirConfiguracaoMouseEntered
        exibirConfiguracao.setBackground(new Color(60,60,60));
        exibirConfiguracao.setForeground(new Color(172,172,172));
    }//GEN-LAST:event_exibirConfiguracaoMouseEntered

    private void exibirConfiguracaoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exibirConfiguracaoMouseExited
        exibirConfiguracao.setBackground(new Color(172,172,172));
        exibirConfiguracao.setForeground(new Color(60,60,60));
    }//GEN-LAST:event_exibirConfiguracaoMouseExited

    private void exibirMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exibirMenuMouseEntered
        exibirMenu.setBackground(new Color(60,60,60));
        exibirMenu.setForeground(new Color(172,172,172));
    }//GEN-LAST:event_exibirMenuMouseEntered

    private void exibirMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exibirMenuMouseExited
        exibirMenu.setBackground(new Color(172,172,172));
        exibirMenu.setForeground(new Color(60,60,60));
    }//GEN-LAST:event_exibirMenuMouseExited

    private void botaoMeioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoMeioMouseEntered
        botaoMeio.setBackground(new Color(60,60,60));
        botaoMeio.setForeground(new Color(172,172,172));
    }//GEN-LAST:event_botaoMeioMouseEntered

    private void botaoMeioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoMeioMouseExited
        botaoMeio.setBackground(new Color(172,172,172));
        botaoMeio.setForeground(new Color(60,60,60));
    }//GEN-LAST:event_botaoMeioMouseExited

    private void botaoDireitaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoDireitaMouseEntered
        botaoDireita.setBackground(new Color(60,60,60));
        botaoDireita.setForeground(new Color(172,172,172));
    }//GEN-LAST:event_botaoDireitaMouseEntered

    private void botaoDireitaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoDireitaMouseExited
        botaoDireita.setBackground(new Color(172,172,172));
        botaoDireita.setForeground(new Color(60,60,60));
    }//GEN-LAST:event_botaoDireitaMouseExited

    private void botaoEsquerdaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoEsquerdaMouseExited
        botaoEsquerda.setBackground(new Color(172,172,172));
        botaoEsquerda.setForeground(new Color(60,60,60));
    }//GEN-LAST:event_botaoEsquerdaMouseExited

    private void botaoEsquerdaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoEsquerdaMouseEntered
        botaoEsquerda.setBackground(new Color(60,60,60));
        botaoEsquerda.setForeground(new Color(172,172,172));
    }//GEN-LAST:event_botaoEsquerdaMouseEntered

    private void botaoMeioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoMeioActionPerformed
        
        if(contGeral == 0){
            if(contHistoria == 0){
                contHistoria = 1;
                salvarDados();

                this.dispose();
                this.setMenu(new telaMenu(this,true,name));
                this.getMenu().setVisible(true);

                exibirMenu.setEnabled(true);
                exibirConfiguracao.setEnabled(true);
                exibirMenu.setVisible(true);
                exibirConfiguracao.setVisible(true);
                salvarDados();
            }else{
                if(contHistoria == 1){
                    contHistoria = 2;
                    salvarDados();

                    historia();
                }else{
                    if(contHistoria == 2001){
                        contHistoria = 3;
                        salvarDados();

                        historia();
                    }else{
                        if(contHistoria == 2002){
                            contHistoria = 3;
                            salvarDados();

                            historia();
                        }else{
                            if(contHistoria == 30011 || contHistoria == 30012 || contHistoria == 30021 || contHistoria == 30022){
                                contHistoria = 304;
                                salvarDados();

                                historia();
                            }else{
                                if(contHistoria == 40015){
                                        salvarDados();
                                        
                                        new telaBatalha().setVisible(true);
                                        this.dispose();
                                }else{
                                    if(contHistoria == 4001 || contHistoria == 4002 || contHistoria == 40011 || contHistoria == 40012){
                                        contHistoria = 5;
                                        salvarDados();
                                        
                                        historia();
                                    }else{
                                        if(contHistoria == 5002 || contHistoria == 5001112){
                                            contHistoria = 6;
                                            salvarDados();

                                            historia();
                                        }else{
                                            if(contHistoria == 50015){
                                                salvarDados();

                                                new telaBatalha().setVisible(true);
                                                this.dispose();
                                            }else{
                                                if(contHistoria == 5001111){
                                                    contHistoria = 50011111;
                                                    salvarDados();

                                                    historia();
                                                }else{
                                                    if(contHistoria == 50011111){
                                                        contHistoria = 6;
                                                        salvarDados();

                                                        historia();
                                                    }else{
                                                        if(contHistoria == 6){
                                                            contHistoria = 600;
                                                            salvarDados();

                                                            historia();
                                                        }else{
                                                            if(contHistoria == 600){
                                                                contHistoria = 6000;
                                                                salvarDados();

                                                                historia();
                                                            }else{
                                                                if(contHistoria == 7001){
                                                                    contHistoria = 70011;
                                                                    salvarDados();

                                                                    historia();
                                                                }else{
                                                                    if(contHistoria == 70021){
                                                                        contHistoria = 708;
                                                                        salvarDados();

                                                                        historia();
                                                                    }else{
                                                                        if(contHistoria == 700222 || contHistoria == 700221 || contHistoria == 70011){
                                                                            contHistoria = 708;
                                                                            salvarDados();

                                                                            historia();
                                                                        }else{
                                                                            if(contHistoria == 80015 || contHistoria == 800155 || contHistoria == 8001555 || contHistoria == 800152 || contHistoria == 800153 || contHistoria == 800154){
                                                                                salvarDados();

                                                                                new telaBatalha().setVisible(true);
                                                                                this.dispose();
                                                                            }else{
                                                                                if(contHistoria == 80011){
                                                                                    contHistoria = 800111;
                                                                                    salvarDados();

                                                                                    historia();
                                                                                }else{
                                                                                    if(contHistoria == 800111){
                                                                                        contHistoria = 8001111;
                                                                                        salvarDados();

                                                                                        historia();
                                                                                    }else{
                                                                                        if(contHistoria == 80011111101L || contHistoria == 80011111102L || contHistoria == 800011111111L || contHistoria == 8000111111L){
                                                                                            contHistoria = 9;
                                                                                            salvarDados();

                                                                                            historia();
                                                                                        }else{
                                                                                            if(contHistoria == 301){
                                                                                                contHistoria = 3011;
                                                                                                salvarDados();

                                                                                                historia();
                                                                                            }else{
                                                                                                if(contHistoria == 3015){
                                                                                                    if(pontosTruco == 2){
                                                                                                        contHistoria = 30151;
                                                                                                        salvarDados();
                                                                                                        
                                                                                                        historia();
                                                                                                    }else{
                                                                                                        if(pontosTrucoInimigo == 2){
                                                                                                            contHistoria = 30152;
                                                                                                            salvarDados();
                                                                                                            
                                                                                                            historia();
                                                                                                        }
                                                                                                    }
                                                                                                }else{
                                                                                                    if(contHistoria == 30151 || contHistoria == 30152){
                                                                                                        contHistoria = 3001;
                                                                                                        salvarDados();

                                                                                                        historia();
                                                                                                    }else{
                                                                                                        if(contHistoria == 50011){
                                                                                                            contHistoria = 5002;
                                                                                                            salvarDados();

                                                                                                            historia();
                                                                                                        }else{
                                                                                                            if(contHistoria == 6000){
                                                                                                                contHistoria = 7;
                                                                                                                salvarDados();

                                                                                                                historia();
                                                                                                            }else{
                                                                                                                if(contHistoria == 70022){
                                                                                                                    contHistoria = 700220;
                                                                                                                    salvarDados();

                                                                                                                    historia();
                                                                                                                }else{
                                                                                                                    if(contHistoria == 800111120){
                                                                                                                        contHistoria = 9;
                                                                                                                        salvarDados();

                                                                                                                        historia();
                                                                                                                    }else{
                                                                                                                        if(contHistoria == 80011112 || contHistoria == 8001111120L || contHistoria == 80011111200L || contHistoria == 800111111){
                                                                                                                            contHistoria = 9;
                                                                                                                            salvarDados();

                                                                                                                            historia();
                                                                                                                        }else{
                                                                                                                            if(contHistoria == 800111112){
                                                                                                                                contHistoria = 8001111120L;
                                                                                                                                salvarDados();

                                                                                                                                historia();
                                                                                                                            }else{
                                                                                                                                if(contHistoria == 8001111110L){
                                                                                                                                    contHistoria = 800111111;
                                                                                                                                    salvarDados();

                                                                                                                                    historia();
                                                                                                                                }else{
                                                                                                                                    if(contHistoria == 8000111111L){
                                                                                                                                        contHistoria = 8000111111L;
                                                                                                                                        salvarDados();

                                                                                                                                        historia();
                                                                                                                                    }else{
                                                                                                                                        if(contHistoria == 800001){
                                                                                                                                            contHistoria = 800011111111L;
                                                                                                                                            salvarDados();

                                                                                                                                            historia();
                                                                                                                                        }else{
                                                                                                                                            if(contHistoria == 80001111111L){
                                                                                                                                                contHistoria = 80001111111L;
                                                                                                                                                salvarDados();

                                                                                                                                                historia();
                                                                                                                                            }else{
                                                                                                                                                if(contHistoria == 8000011){
                                                                                                                                                    contHistoria = 9;
                                                                                                                                                    salvarDados();

                                                                                                                                                    historia();
                                                                                                                                                }else{
                                                                                                                                                    if(contHistoria == 80001111){
                                                                                                                                                        contHistoria = 8000111111L;
                                                                                                                                                        salvarDados();

                                                                                                                                                        historia();
                                                                                                                                                    }else{
                                                                                                                                                        if(contHistoria == 9){
                                                                                                                                                            contHistoria = 9001;
                                                                                                                                                            salvarDados();

                                                                                                                                                            historia();
                                                                                                                                                        }else{
                                                                                                                                                            if(contHistoria == 900111 || contHistoria == 900112){
                                                                                                                                                                contHistoria = 10;
                                                                                                                                                                salvarDados();
                                                                                                                                                                
                                                                                                                                                                historia();
                                                                                                                                                            }else{
                                                                                                                                                                if(contHistoria == 90012){
                                                                                                                                                                    contHistoria = 900120;
                                                                                                                                                                    salvarDados();
                                                                                                                                                                    
                                                                                                                                                                    historia();
                                                                                                                                                                }else{
                                                                                                                                                                    if(contHistoria == 900120){
                                                                                                                                                                        salvarDados();
                                                                                                                                                                        
                                                                                                                                                                        historia();
                                                                                                                                                                    }else{
                                                                                                                                                                        if(contHistoria == 9001200){
                                                                                                                                                                            contHistoria = 90012000;
                                                                                                                                                                            salvarDados();
                                                                                                                                                                            
                                                                                                                                                                            historia();
                                                                                                                                                                        }else{
                                                                                                                                                                            if(contHistoria == 90012000){
                                                                                                                                                                                contHistoria = 900120000;
                                                                                                                                                                                salvarDados();

                                                                                                                                                                                historia();
                                                                                                                                                                            }else{
                                                                                                                                                                               if(contHistoria == 900120000){
                                                                                                                                                                                    contHistoria = 9001200000L;
                                                                                                                                                                                    salvarDados();

                                                                                                                                                                                    historia();
                                                                                                                                                                               }else if(contHistoria == 304){
                                                                                                                                                                                    contHistoria = 3040;
                                                                                                                                                                                    salvarDados();

                                                                                                                                                                                    historia();
                                                                                                                                                                               }else if(contHistoria == 3040){
                                                                                                                                                                                    contHistoria = 30400;
                                                                                                                                                                                    salvarDados();

                                                                                                                                                                                    historia();
                                                                                                                                                                               }else if(contHistoria == 30400){
                                                                                                                                                                                    contHistoria = 4;
                                                                                                                                                                                    salvarDados();

                                                                                                                                                                                    historia();
                                                                                                                                                                               }else if(contHistoria == 9001200000L){
                                                                                                                                                                                    contHistoria = 10;
                                                                                                                                                                                    salvarDados();

                                                                                                                                                                                    historia();
                                                                                                                                                                               }else if(contHistoria == 10){
                                                                                                                                                                                    contHistoria = 10000;
                                                                                                                                                                                    salvarDados();

                                                                                                                                                                                    historia();
                                                                                                                                                                               }else if(contHistoria == 100001 || contHistoria == 100002){
                                                                                                                                                                                    contHistoria = 11;
                                                                                                                                                                                    salvarDados();

                                                                                                                                                                                    historia();
                                                                                                                                                                               }else if(contHistoria == 11){
                                                                                                                                                                                    contHistoria = 11000;
                                                                                                                                                                                    salvarDados();

                                                                                                                                                                                    historia();
                                                                                                                                                                               }else if(contHistoria == 110001){
                                                                                                                                                                                    contHistoria = 1100010;
                                                                                                                                                                                    salvarDados();

                                                                                                                                                                                    historia();
                                                                                                                                                                               }else if(contHistoria == 1100010){
                                                                                                                                                                                    contHistoria = 11000100;
                                                                                                                                                                                    salvarDados();

                                                                                                                                                                                    historia();
                                                                                                                                                                               }else if(contHistoria == 11000100){
                                                                                                                                                                                    contHistoria = 12;
                                                                                                                                                                                    salvarDados();

                                                                                                                                                                                    historia();
                                                                                                                                                                               }else if(contHistoria == 1100021 || contHistoria == 1100022){
                                                                                                                                                                                    contHistoria = 1100020;
                                                                                                                                                                                    salvarDados();

                                                                                                                                                                                    historia();
                                                                                                                                                                               }else if(contHistoria == 1100020){
                                                                                                                                                                                    contHistoria = 12;
                                                                                                                                                                                    salvarDados();

                                                                                                                                                                                    historia();
                                                                                                                                                                               }else if(contHistoria == 12){
                                                                                                                                                                                    contHistoria = 12000;
                                                                                                                                                                                    salvarDados();

                                                                                                                                                                                    historia();
                                                                                                                                                                               }else if(contHistoria == 13){
                                                                                                                                                                                    contHistoria = 13000;
                                                                                                                                                                                    salvarDados();

                                                                                                                                                                                    historia();
                                                                                                                                                                               }else if(contHistoria == 1300002){
                                                                                                                                                                                    contHistoria = 13000020;
                                                                                                                                                                                    salvarDados();

                                                                                                                                                                                    historia();
                                                                                                                                                                               }else if(contHistoria == 1300001 || contHistoria == 130000201 || contHistoria == 130000202 ){
                                                                                                                                                                                    contHistoria = 14;
                                                                                                                                                                                    salvarDados();

                                                                                                                                                                                    historia();
                                                                                                                                                                               }else if(contHistoria == 120001){
                                                                                                                                                                                    contHistoria = 1200010;
                                                                                                                                                                                    salvarDados();

                                                                                                                                                                                    historia();
                                                                                                                                                                               }else if(contHistoria == 12000101 || contHistoria == 12000102){
                                                                                                                                                                                    contHistoria = 120003;
                                                                                                                                                                                    salvarDados();

                                                                                                                                                                                    historia();
                                                                                                                                                                               }else if(contHistoria == 120003){
                                                                                                                                                                                    contHistoria = 1200030;
                                                                                                                                                                                    salvarDados();

                                                                                                                                                                                    historia();
                                                                                                                                                                               }else if(contHistoria == 1200030){
                                                                                                                                                                                    contHistoria = 120004;
                                                                                                                                                                                    salvarDados();

                                                                                                                                                                                    historia();
                                                                                                                                                                               }else if(contHistoria == 1200041){
                                                                                                                                                                                    contHistoria = 120005;
                                                                                                                                                                                    salvarDados();

                                                                                                                                                                                    historia();
                                                                                                                                                                               }else if(contHistoria == 120005){
                                                                                                                                                                                    contHistoria = 1200050;
                                                                                                                                                                                    salvarDados();

                                                                                                                                                                                    historia();
                                                                                                                                                                               }else if(contHistoria == 1200050){
                                                                                                                                                                                    contHistoria = 12000500;
                                                                                                                                                                                    salvarDados();

                                                                                                                                                                                    historia();
                                                                                                                                                                               }else if(contHistoria == 12000500){
                                                                                                                                                                                    contHistoria = 13;
                                                                                                                                                                                    salvarDados();

                                                                                                                                                                                    historia();
                                                                                                                                                                               }else  if(contHistoria == 1200021 || contHistoria == 1200022){
                                                                                                                                                                                    contHistoria = 1200023;
                                                                                                                                                                                    salvarDados();

                                                                                                                                                                                    historia();
                                                                                                                                                                                }else if(contHistoria == 1200023){
                                                                                                                                                                                    contHistoria = 120003;
                                                                                                                                                                                    salvarDados();

                                                                                                                                                                                    historia();
                                                                                                                                                                               }else if(contHistoria == 1300015){
                                                                                                                                                                                    salvarDados();
                                                                                                                                                                                    new telaBatalha().setVisible(true);
                                                                                                                                                                                    this.dispose();
                                                                                                                                                                                    
                                                                                                                                                                                    salvarDados();

                                                                                                                                                                               }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }    
                    }
                }
            }
        }
        contTravamento = 0;
        cliqueParaPassar.setEnabled(true);
        cliqueParaPassar.setVisible(true);
        salvarDados();
        
    }//GEN-LAST:event_botaoMeioActionPerformed

    private void botaoEsquerdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEsquerdaActionPerformed
        
        if(contGeral == 0){
            if(contHistoria == 2){
               contHistoria = 2001;
               salvarDados();

               historia();
           }else{
                if(contHistoria == 3){
                   contHistoria = 301;
                   salvarDados();

                   historia();
               }else{
                   if(contHistoria == 3001){
                       contHistoria = 30011;
                       salvarDados();

                       historia();
                   }else{
                       if(contHistoria == 3002){
                       contHistoria = 30021;
                       salvarDados();

                       historia();
                       }else{
                           if(contHistoria == 4){
                                contHistoria = 4001;
                                salvarDados();

                                historia();
                           }else{
                               if(contHistoria == 4001){
                                    contHistoria = 5;
                                    salvarDados();

                                    historia();
                               }else{
                                    if(contHistoria == 5){
                                        contHistoria = 5001;
                                        salvarDados();

                                        historia();
                                    }else{
                                         if(contHistoria == 5001){
                                            contHistoria = 50011;
                                            salvarDados();

                                            historia();
                                        }else{
                                            if(contHistoria == 500111){
                                                contHistoria = 5001111;
                                                salvarDados();

                                                historia();
                                            }else{
                                                if(contHistoria == 7){
                                                    contHistoria = 7001;
                                                    salvarDados();

                                                    historia();
                                                }else{
                                                    if(contHistoria == 700220){
                                                        contHistoria = 700221;
                                                        salvarDados();

                                                        historia();
                                                    }else{
                                                        if(contHistoria == 8){
                                                            contHistoria = 8001;
                                                            salvarDados();

                                                            historia();
                                                        }else{
                                                            if(contHistoria == 8002){
                                                                contHistoria = 80021;
                                                                salvarDados();

                                                                historia();
                                                            }else{
                                                                if(contHistoria == 8001111){
                                                                    contHistoria = 80011111;
                                                                    salvarDados();

                                                                    historia();
                                                                }else{
                                                                    if(contHistoria == 80011111){
                                                                        contHistoria = 8001111110L;
                                                                        salvarDados();

                                                                        historia();
                                                                    }else{
                                                                        if(contHistoria == 800111111){
                                                                            salvarDados();
                                                                        }else{
                                                                            if(contHistoria == 3011){
                                                                                contHistoria = 3015;
                                                                                salvarDados();

                                                                                historia();
                                                                            }else{
                                                                                if(contHistoria == 7002){
                                                                                    contHistoria = 70021;
                                                                                    salvarDados();

                                                                                    historia();
                                                                                }else{
                                                                                    if(contHistoria == 9001){
                                                                                        contHistoria = 90011;
                                                                                        salvarDados();

                                                                                        historia();
                                                                                    }else{
                                                                                        if(contHistoria == 90011){
                                                                                            contHistoria = 900111;
                                                                                            salvarDados();

                                                                                            historia();
                                                                                        }else  if(contHistoria == 708){
                                                                                            contHistoria = 7080;
                                                                                            salvarDados();

                                                                                            historia();
                                                                                        }else  if(contHistoria == 10000){
                                                                                            contHistoria = 100001;
                                                                                            salvarDados();

                                                                                            historia();
                                                                                        }else  if(contHistoria == 11000){
                                                                                            contHistoria = 110001;
                                                                                            salvarDados();

                                                                                            historia();
                                                                                        }else  if(contHistoria == 110002){
                                                                                            contHistoria = 1100021;
                                                                                            salvarDados();

                                                                                            historia();
                                                                                        }else  if(contHistoria == 12000){
                                                                                            contHistoria = 120001;
                                                                                            salvarDados();

                                                                                            historia();
                                                                                        }else  if(contHistoria == 130000){
                                                                                            contHistoria = 1300001;
                                                                                            salvarDados();

                                                                                            historia();
                                                                                        }else  if(contHistoria == 13000020){
                                                                                            contHistoria = 130000201;
                                                                                            salvarDados();

                                                                                            historia();
                                                                                        }else  if(contHistoria == 1200010){
                                                                                            contHistoria = 12000101;
                                                                                            salvarDados();

                                                                                            historia();
                                                                                        }else  if(contHistoria == 120004){
                                                                                            contHistoria = 1200041;
                                                                                            salvarDados();

                                                                                            historia();
                                                                                        }else  if(contHistoria == 120002){
                                                                                            contHistoria = 1200021;
                                                                                            salvarDados();

                                                                                            historia();
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                         }
                                    }
                               }
                           }
                       }
                   }
               }
           }  
        } 
        contTravamento = 0;
        cliqueParaPassar.setEnabled(true);
        cliqueParaPassar.setVisible(true);
        salvarDados();
    }//GEN-LAST:event_botaoEsquerdaActionPerformed

    private void botaoDireitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDireitaActionPerformed
        
        if(contGeral == 0){
            if(contHistoria == 2){
                contHistoria = 2002;
                salvarDados();

                historia();
            }else{
                 if(contHistoria == 3){
                    contHistoria = 3002;
                    salvarDados();

                    historia();
                }else{
                    if(contHistoria == 3001){
                        contHistoria = 30012;
                        salvarDados();

                        historia();
                    }else{
                        if(contHistoria == 3002){
                            contHistoria = 30022;
                            salvarDados();

                            historia();
                        }else{
                            if(contHistoria == 4){
                                contHistoria = 4002;
                                salvarDados();

                                historia();
                           }else{
                                if(contHistoria == 4002){
                                    contHistoria = 5;
                                    salvarDados();

                                    historia();
                               }else{
                                    if(contHistoria == 4001){
                                        contHistoria = 40012;
                                        salvarDados();

                                        historia();
                                    }else{
                                        if(contHistoria == 5){
                                            contHistoria = 5002;
                                            salvarDados();

                                            historia();
                                        }else{
                                            if(contHistoria == 5001){
                                                contHistoria = 50012;
                                                salvarDados();

                                                historia();
                                            }else{
                                                if(contHistoria == 500111){
                                                    contHistoria = 5001112;
                                                    salvarDados();

                                                    historia();
                                                }else{
                                                    if(contHistoria == 7){
                                                        contHistoria = 7002;
                                                        salvarDados();

                                                        historia();
                                                    }else{
                                                        if(contHistoria == 700220){
                                                            contHistoria = 700222;
                                                            salvarDados();

                                                            historia();
                                                        }else{
                                                            if(contHistoria == 8){
                                                                contHistoria = 8002;
                                                                salvarDados();

                                                                historia();
                                                            }else{
                                                                if(contHistoria == 8002){
                                                                    contHistoria = 8001;
                                                                    salvarDados();

                                                                    historia();
                                                                }else{
                                                                    if(contHistoria == 8001111){
                                                                        contHistoria = 80011112;
                                                                        salvarDados();

                                                                        historia();
                                                                    }else{
                                                                        if(contHistoria == 80011111){
                                                                            contHistoria = 800111112;
                                                                            salvarDados();

                                                                            historia();
                                                                        }else{
                                                                            if(contHistoria == 800111111){
                                                                                salvarDados();
                                                                            }else{
                                                                                if(contHistoria == 3011){
                                                                                    contHistoria = 3001;
                                                                                    salvarDados();

                                                                                    historia();
                                                                                }else{
                                                                                    if(contHistoria == 7002){
                                                                                        contHistoria = 70022;
                                                                                        salvarDados();

                                                                                        historia();
                                                                                    }else{
                                                                                        if(contHistoria == 9001){
                                                                                            contHistoria = 90012;
                                                                                            salvarDados();

                                                                                            historia();
                                                                                        }else{
                                                                                            if(contHistoria == 90011){
                                                                                                contHistoria = 900112;
                                                                                                salvarDados();

                                                                                                historia();
                                                                                            }else if(contHistoria == 708){
                                                                                                contHistoria = 70800;
                                                                                                salvarDados();

                                                                                                historia();
                                                                                            }else  if(contHistoria == 10000){
                                                                                                contHistoria = 100002;
                                                                                                salvarDados();

                                                                                                historia();
                                                                                            }else  if(contHistoria == 11000){
                                                                                                contHistoria = 110002;
                                                                                                salvarDados();

                                                                                                historia();
                                                                                            }else  if(contHistoria == 110002){
                                                                                                contHistoria = 1100022;
                                                                                                salvarDados();

                                                                                                historia();
                                                                                            }else  if(contHistoria == 12000){
                                                                                                contHistoria = 120002;
                                                                                                salvarDados();

                                                                                                historia();
                                                                                            }else  if(contHistoria == 130000){
                                                                                                contHistoria = 13000155;
                                                                                                salvarDados();
                                                                                                new telaBatalha().setVisible(true);
                                                                                                this.dispose();
                                                                                            }else  if(contHistoria == 13000020){
                                                                                                contHistoria = 130000202;
                                                                                                salvarDados();

                                                                                                historia();
                                                                                            }else  if(contHistoria == 1200010){
                                                                                            contHistoria = 12000102;
                                                                                            salvarDados();

                                                                                            historia();
                                                                                            }else  if(contHistoria == 120004){
                                                                                                contHistoria = 120005;
                                                                                                salvarDados();

                                                                                                historia();
                                                                                            }else  if(contHistoria == 120002){
                                                                                                contHistoria = 1200022;
                                                                                                salvarDados();

                                                                                                historia();
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }  
        }  
        contTravamento = 0;
        cliqueParaPassar.setEnabled(true);
        cliqueParaPassar.setVisible(true);
        salvarDados();
    }//GEN-LAST:event_botaoDireitaActionPerformed

    private void cliqueParaPassarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cliqueParaPassarActionPerformed
        if(contGeral == 1){
                exibicaoHistoria.stop();
                exibicaoHistoria2.stop();
                
                textoHistoria1.setText("");
                textoHistoria2.setText("");
                textoHistoria3.setText("");
                textoHistoria1.setText(Historia1);
                textoHistoria2.setText(Historia2);
                textoHistoria3.setText(Historia3);
                
                contGeral = 0;
                cliqueParaPassar.setVisible(false);
                cliqueParaPassar.setEnabled(false);
            }
    }//GEN-LAST:event_cliqueParaPassarActionPerformed

    private void comandosADMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comandosADMActionPerformed
         if(contADM == 0){
            lerContHistoria.setEnabled(true);
            lerContHistoria.setVisible(true);
            painelADM.setEnabled(true);
            painelADM.setVisible(true);
            contADM =1;
            
        }else{
            if(contADM == 1){
                lerContHistoria.setEnabled(false);
                lerContHistoria.setVisible(false);
                painelADM.setEnabled(false);
                painelADM.setVisible(false);
                contADM =0;
            }
        }
        salvarDados();
    }//GEN-LAST:event_comandosADMActionPerformed

    private void botaoTruco1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoTruco1ActionPerformed
        if(contTruco == 0){
            if(contTruco1 == 0){
                if(carta < 4){
                    Historia1 = "Você e seu parceiro";
                    Historia2 = "fizeram a rodada";
                    Historia3 = "";
                    escreverHistoria();
                    pontosTruco = 1;
                }else{
                    Historia1 = "";
                    Historia2 = "O inimigo fez a rodada";
                    Historia3 = "";
                    escreverHistoria();
                    pontosTrucoInimigo = 1;
                }
            }
            if(contTruco1 == 1){
                if(carta < 5){
                    Historia1 = "Você e seu parceiro";
                    Historia2 = "fizeram a rodada";
                    Historia3 = "";
                    escreverHistoria();
                    pontosTruco = 1;
                }else{
                    Historia1 = "";
                    Historia2 = "O inimigo fez a rodada";
                    Historia3 = "";
                    escreverHistoria();
                    pontosTrucoInimigo = 1;
                }
            }
            if(contTruco1 == 2){
                if(carta < 6){
                    Historia1 = "Você e seu parceiro";
                    Historia2 = "fizeram a rodada";
                    Historia3 = "";
                    escreverHistoria();
                    pontosTruco = 1;
                }else{
                    Historia1 = "";
                    Historia2 = "O inimigo fez a rodada";
                    Historia3 = "";
                    escreverHistoria();
                    pontosTrucoInimigo = 1;
                }
            }   
            
            botaoTruco1.setEnabled(false);
            botaoTruco1.setVisible(false);
            contTruco = 1;
            truco();
        }else{
            if(contTruco == 1){
                if(contTruco2 == 0){
                    if(carta < 4){
                        Historia1 = "Você e seu parceiro";
                        Historia2 = "fizeram a rodada";
                        Historia3 = "";
                        escreverHistoria();
                        pontosTruco = pontosTruco + 1;
                    }else{
                        Historia1 = "";
                        Historia2 = "O inimigo fez a rodada";
                        Historia3 = "";
                        escreverHistoria();
                        pontosTrucoInimigo = pontosTrucoInimigo + 1;
                    }
                }
                if(contTruco2 == 1){
                    if(carta < 5){
                        Historia1 = "Você e seu parceiro";
                        Historia2 = "fizeram a rodada";
                        Historia3 = "";
                        escreverHistoria();
                        pontosTruco = pontosTruco + 1;
                    }else{
                        Historia1 = "";
                        Historia2 = "O inimigo fez a rodada";
                        Historia3 = "";
                        escreverHistoria();
                         pontosTrucoInimigo = pontosTrucoInimigo + 1;
                    }
                }
                if(contTruco2 == 2){
                    if(carta < 6){
                        Historia1 = "Você e seu parceiro";
                        Historia2 = "fizeram a rodada";
                        Historia3 = "";
                        escreverHistoria();
                        pontosTruco = pontosTruco + 1;
                    }else{
                        Historia1 = "";
                        Historia2 = "O inimigo fez a rodada";
                        Historia3 = "";
                        escreverHistoria();
                         pontosTrucoInimigo = pontosTrucoInimigo + 1;
                    }
                }
                botaoTruco1.setEnabled(false);
                botaoTruco1.setVisible(false);
                contTruco = 2;
                truco();
            }else{
                if(contTruco == 2){
                    if(contTruco2 == 0){
                        if(carta < 4){
                            Historia1 = "Você e seu parceiro";
                            Historia2 = "fizeram a rodada";
                            Historia3 = "";
                            escreverHistoria();
                            pontosTruco = pontosTruco + 1;
                        }else{
                            Historia1 = "";
                            Historia2 = "O inimigo fez a rodada";
                            Historia3 = "";
                            escreverHistoria();
                            pontosTrucoInimigo = pontosTrucoInimigo + 1;
                    }
                }
                if(contTruco2 == 1){
                    if(carta < 5){
                        Historia1 = "Você e seu parceiro";
                        Historia2 = "fizeram a rodada";
                        Historia3 = "";
                        escreverHistoria();
                        pontosTruco = pontosTruco + 1;
                    }else{
                        Historia1 = "";
                        Historia2 = "O inimigo fez a rodada";
                        Historia3 = "";
                        escreverHistoria();
                         pontosTrucoInimigo = pontosTrucoInimigo + 1;
                    }
                }
                if(contTruco2 == 2){
                    if(carta < 6){
                        Historia1 = "Você e seu parceiro";
                        Historia2 = "fizeram a rodada";
                        Historia3 = "";
                        escreverHistoria();
                        pontosTruco = pontosTruco + 1;
                    }else{
                        Historia1 = "";
                        Historia2 = "O inimigo fez a rodada";
                        Historia3 = "";
                        escreverHistoria();
                         pontosTrucoInimigo = pontosTrucoInimigo + 1;
                    }
                }
                    botaoTruco1.setEnabled(false);
                    botaoTruco1.setVisible(false);
                    contTruco = 3;
                    truco();
                }
            }
        }
            
    }//GEN-LAST:event_botaoTruco1ActionPerformed

    private void botaoTruco2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoTruco2ActionPerformed
        if(contTruco == 0){
            if(contTruco2 == 0){
                if(carta < 3){
                    Historia1 = "Você e seu parceiro";
                    Historia2 = "fizeram a rodada";
                    Historia3 = "";
                    escreverHistoria();
                    pontosTruco = 1;
                }else{
                    Historia1 = "";
                    Historia2 = "O inimigo fez a rodada";
                    Historia3 = "";
                    escreverHistoria();
                    pontosTrucoInimigo = 1;
                }
            }
            if(contTruco2 == 1){
                if(carta < 2){
                    Historia1 = "Você e seu parceiro";
                    Historia2 = "fizeram a rodada";
                    Historia3 = "";
                    escreverHistoria();
                    pontosTruco = 1;
                }else{
                    Historia1 = "";
                    Historia2 = "O inimigo fez a rodada";
                    Historia3 = "";
                    escreverHistoria();
                    pontosTrucoInimigo = 1;
                }
            }
            if(contTruco2 == 2){
                if(carta < 1){
                    Historia1 = "Você e seu parceiro";
                    Historia2 = "fizeram a rodada";
                    Historia3 = "";
                    escreverHistoria();
                    pontosTruco = 1;
                }else{
                    Historia1 = "";
                    Historia2 = "O inimigo fez a rodada";
                    Historia3 = "";
                    escreverHistoria();
                    pontosTrucoInimigo = 1;
                }
            }
            botaoTruco2.setEnabled(false);
            botaoTruco2.setVisible(false);
            contTruco = 1;
            truco();
        }else{
            if(contTruco == 1){
                if(contTruco2 == 0){
                    if(carta < 3){
                        Historia1 = "Você e seu parceiro";
                        Historia2 = "fizeram a rodada";
                        Historia3 = "";
                        escreverHistoria();
                        pontosTruco = pontosTruco + 1;
                    }else{
                        Historia1 = "";
                        Historia2 = "O inimigo fez a rodada";
                        Historia3 = "";
                        escreverHistoria();
                        pontosTrucoInimigo = pontosTrucoInimigo + 1;
                    }
                }
                if(contTruco2 == 1){
                    if(carta < 2){
                        Historia1 = "Você e seu parceiro";
                        Historia2 = "fizeram a rodada";
                        Historia3 = "";
                        escreverHistoria();
                        pontosTruco = pontosTruco + 1;
                    }else{
                        Historia1 = "";
                        Historia2 = "O inimigo fez a rodada";
                        Historia3 = "";
                        escreverHistoria();
                         pontosTrucoInimigo = pontosTrucoInimigo + 1;
                    }
                }
                if(contTruco2 == 2){
                    if(carta < 1){
                        Historia1 = "Você e seu parceiro";
                        Historia2 = "fizeram a rodada";
                        Historia3 = "";
                        escreverHistoria();
                        pontosTruco = pontosTruco + 1;
                    }else{
                        Historia1 = "";
                        Historia2 = "O inimigo fez a rodada";
                        Historia3 = "";
                        escreverHistoria();
                         pontosTrucoInimigo = pontosTrucoInimigo + 1;
                    }
                }
                botaoTruco2.setEnabled(false);
                botaoTruco2.setVisible(false);
                contTruco = 2;
                truco();
            }else{
                if(contTruco == 2){
                    if(contTruco2 == 0){
                        if(carta < 3){
                            Historia1 = "Você e seu parceiro";
                            Historia2 = "fizeram a rodada";
                            Historia3 = "";
                            escreverHistoria();
                            pontosTruco = pontosTruco + 1;
                        }else{
                            Historia1 = "";
                            Historia2 = "O inimigo fez a rodada";
                            Historia3 = "";
                            escreverHistoria();
                            pontosTrucoInimigo = pontosTrucoInimigo + 1;
                        }
                    }
                    if(contTruco2 == 1){
                        if(carta < 2){
                            Historia1 = "Você e seu parceiro";
                            Historia2 = "fizeram a rodada";
                            Historia3 = "";
                            escreverHistoria();
                            pontosTruco = pontosTruco + 1;
                        }else{
                            Historia1 = "";
                            Historia2 = "O inimigo fez a rodada";
                            Historia3 = "";
                            escreverHistoria();
                             pontosTrucoInimigo = pontosTrucoInimigo + 1;
                        }
                    }
                    if(contTruco2 == 2){
                        if(carta < 1){
                            Historia1 = "Você e seu parceiro";
                            Historia2 = "fizeram a rodada";
                            Historia3 = "";
                            escreverHistoria();
                            pontosTruco = pontosTruco + 1;
                        }else{
                            Historia1 = "";
                            Historia2 = "O inimigo fez a rodada";
                            Historia3 = "";
                            escreverHistoria();
                             pontosTrucoInimigo = pontosTrucoInimigo + 1;
                        }
                    }
                    botaoTruco2.setEnabled(false);
                    botaoTruco2.setVisible(false);
                    contTruco = 3;
                    truco();
                }
            }
            
        }
       
    }//GEN-LAST:event_botaoTruco2ActionPerformed

    private void botaoTruco3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoTruco3ActionPerformed
        if(contTruco == 0){
            if(contTruco3 == 0){
                if(carta < 10){
                    Historia1 = "Você e seu parceiro";
                    Historia2 = "fizeram a rodada";
                    Historia3 = "";
                    escreverHistoria();
                    pontosTruco = 1;
                }else{
                    Historia1 = "";
                    Historia2 = "O inimigo fez a rodada";
                    Historia3 = "";
                    escreverHistoria();
                    pontosTrucoInimigo = 1;
                }
            }
            if(contTruco3 == 1){
                if(carta < 9){
                    Historia1 = "Você e seu parceiro";
                    Historia2 = "fizeram a rodada";
                    Historia3 = "";
                    escreverHistoria();
                    pontosTruco = 1;
                }else{
                    Historia1 = "";
                    Historia2 = "O inimigo fez a rodada";
                    Historia3 = "";
                    escreverHistoria();
                    pontosTrucoInimigo = 1;
                }
            }
            if(contTruco3 == 2){
                if(carta < 7){
                    Historia1 = "Você e seu parceiro";
                    Historia2 = "fizeram a rodada";
                    Historia3 = "";
                    escreverHistoria();
                    pontosTruco = 1;
                }else{
                    Historia1 = "";
                    Historia2 = "O inimigo fez a rodada";
                    Historia3 = "";
                    escreverHistoria();
                    pontosTrucoInimigo = 1;
                }
            }
            if(contTruco3 == 3){
                if(carta < 7){
                    Historia1 = "Você e seu parceiro";
                    Historia2 = "fizeram a rodada";
                    Historia3 = "";
                    escreverHistoria();
                    pontosTruco = 1;
                }else{
                    Historia1 = "";
                    Historia2 = "O inimigo fez a rodada";
                    Historia3 = "";
                    escreverHistoria();
                    pontosTrucoInimigo = 1;
                }
            }
            botaoTruco3.setEnabled(false);
            botaoTruco3.setVisible(false);
            contTruco = 1;
            truco();
        }else{
            if(contTruco == 1){
                if(contTruco2 == 0){
                    if(carta < 10){
                        Historia1 = "Você e seu parceiro";
                        Historia2 = "fizeram a rodada";
                        Historia3 = "";
                        escreverHistoria();
                        pontosTruco = pontosTruco + 1;
                    }else{
                        Historia1 = "";
                        Historia2 = "O inimigo fez a rodada";
                        Historia3 = "";
                        escreverHistoria();
                        pontosTrucoInimigo = pontosTrucoInimigo + 1;
                    }
                }
                if(contTruco2 == 1){
                    if(carta < 9){
                        Historia1 = "Você e seu parceiro";
                        Historia2 = "fizeram a rodada";
                        Historia3 = "";
                        escreverHistoria();
                        pontosTruco = pontosTruco + 1;
                    }else{
                        Historia1 = "";
                        Historia2 = "O inimigo fez a rodada";
                        Historia3 = "";
                        escreverHistoria();
                         pontosTrucoInimigo = pontosTrucoInimigo + 1;
                    }
                }
                if(contTruco2 == 2){
                    if(carta < 7){
                        Historia1 = "Você e seu parceiro";
                        Historia2 = "fizeram a rodada";
                        Historia3 = "";
                        escreverHistoria();
                        pontosTruco = pontosTruco + 1;
                    }else{
                        Historia1 = "";
                        Historia2 = "O inimigo fez a rodada";
                        Historia3 = "";
                        escreverHistoria();
                         pontosTrucoInimigo = pontosTrucoInimigo + 1;
                    }
                }
                if(contTruco3 == 3){
                    if(carta < 7){
                        Historia1 = "Você e seu parceiro";
                        Historia2 = "fizeram a rodada";
                        Historia3 = "";
                        escreverHistoria();
                        pontosTruco = pontosTruco + 1;
                    }else{
                        Historia1 = "";
                        Historia2 = "O inimigo fez a rodada";
                        Historia3 = "";
                        escreverHistoria();
                         pontosTrucoInimigo = pontosTrucoInimigo + 1;
                    }
                }

                botaoTruco3.setEnabled(false);
                botaoTruco3.setVisible(false);
                contTruco = 2;
                truco();
            }else{
                if(contTruco == 2){
                    if(contTruco2 == 0){
                        if(carta < 10){
                            Historia1 = "Você e seu parceiro";
                            Historia2 = "fizeram a rodada";
                            Historia3 = "";
                            escreverHistoria();
                            pontosTruco = pontosTruco + 1;
                        }else{
                            Historia1 = "";
                            Historia2 = "O inimigo fez a rodada";
                            Historia3 = "";
                            escreverHistoria();
                            pontosTrucoInimigo = pontosTrucoInimigo + 1;
                        }
                    }
                    if(contTruco2 == 1){
                        if(carta < 9){
                            Historia1 = "Você e seu parceiro";
                            Historia2 = "fizeram a rodada";
                            Historia3 = "";
                            escreverHistoria();
                            pontosTruco = pontosTruco + 1;
                        }else{
                            Historia1 = "";
                            Historia2 = "O inimigo fez a rodada";
                            Historia3 = "";
                            escreverHistoria();
                             pontosTrucoInimigo = pontosTrucoInimigo + 1;
                        }
                    }
                    if(contTruco2 == 2){
                        if(carta < 7){
                            Historia1 = "Você e seu parceiro";
                            Historia2 = "fizeram a rodada";
                            Historia3 = "";
                            escreverHistoria();
                            pontosTruco = pontosTruco + 1;
                        }else{
                            Historia1 = "";
                            Historia2 = "O inimigo fez a rodada";
                            Historia3 = "";
                            escreverHistoria();
                             pontosTrucoInimigo = pontosTrucoInimigo + 1;
                        }
                    }
                    if(contTruco3 == 3){
                        if(carta < 7){
                            Historia1 = "Você e seu parceiro";
                            Historia2 = "fizeram a rodada";
                            Historia3 = "";
                            escreverHistoria();
                            pontosTruco = pontosTruco + 1;
                        }else{
                            Historia1 = "";
                            Historia2 = "O inimigo fez a rodada";
                            Historia3 = "";
                            escreverHistoria();
                            pontosTrucoInimigo = pontosTrucoInimigo + 1;
                        }
                    }

                    botaoTruco3.setEnabled(false);
                    botaoTruco3.setVisible(false);
                    contTruco = 3;
                    truco();
                }
            }
        
        }
            
    }//GEN-LAST:event_botaoTruco3ActionPerformed

    private void lerContHistoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lerContHistoriaActionPerformed
        contHistoria = JSType.toInteger(lerContHistoria.getText());
        exibicaoHistoria.stop();
        exibicaoHistoria2.stop();

        textoHistoria1.setText("");
        textoHistoria2.setText("");
        textoHistoria3.setText("");
        textoHistoria1.setText(Historia1);
        textoHistoria2.setText(Historia2);
        textoHistoria3.setText(Historia3);
        
        contGeral = 1;
        cliqueParaPassar.setVisible(true);
        cliqueParaPassar.setEnabled(true);
        salvarDados();
        historia();
    }//GEN-LAST:event_lerContHistoriaActionPerformed

    private void cliqueAquiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cliqueAquiActionPerformed
        cliqueAqui.setEnabled(false);
        sorte = gerador.nextInt(26) + 1;
        textoInfoBarra13.setText("");
        
        barraSorte = new Thread(){
            
            public void run(){
        
                for(int cont = 1; cont<sorte; cont++){
                    try {
                        barraDaSorte.setValue(cont);
                        barraSorte.sleep(55);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(telaCarregamento.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    int ganhou = 0;
                    if(sorte == 1 | sorte == 2){
                        barraDaSorte.setValue(2);
                        levelBarra = levelBarra + 20;
                        ganhou = 20;
                    }else if(sorte == 3 | sorte == 4){
                        barraDaSorte.setValue(4);
                        levelBarra = levelBarra + 35;
                        ganhou = 35;
                    }else if(sorte == 5 | sorte == 6){
                        barraDaSorte.setValue(6);
                        levelBarra = levelBarra + 100;
                        ganhou = 100;
                    }else if(sorte == 7 | sorte == 8){
                        barraDaSorte.setValue(8);
                        levelBarra = levelBarra + 200;
                        ganhou = 200;
                    }else if(sorte == 9 | sorte == 10){
                        barraDaSorte.setValue(10);
                        levelBarra = levelBarra + 50;
                        ganhou = 50;
                    }else if(sorte == 11 | sorte == 12){
                        barraDaSorte.setValue(12);
                        levelBarra = levelBarra + 20;
                        ganhou = 20;
                    }else if(sorte == 13 | sorte == 14){
                        barraDaSorte.setValue(14);
                        levelBarra = levelBarra + 250;
                        ganhou = 250;
                    }else if(sorte == 15 | sorte == 16){
                        barraDaSorte.setValue(16);
                        levelBarra = levelBarra + 35;
                        ganhou = 35;
                    }else if(sorte == 17 | sorte == 18){
                        barraDaSorte.setValue(18);
                        levelBarra = levelBarra + 100;
                        ganhou = 100;
                    }else if(sorte == 19 | sorte == 20){
                        barraDaSorte.setValue(20);
                        levelBarra = levelBarra + 20;
                        ganhou = 20;
                    }else if(sorte == 21 | sorte == 22){
                        barraDaSorte.setValue(22);
                        levelBarra = levelBarra + 35;
                        ganhou = 35;
                    }else if(sorte == 23 | sorte == 24){
                        barraDaSorte.setValue(24);
                        levelBarra = levelBarra + 50;
                        ganhou = 50;
                    }else if(sorte == 25 | sorte == 26){
                        barraDaSorte.setValue(26);
                        levelBarra = levelBarra + 100;
                        ganhou = 100;
                    }
                    Historia2 = "Parabéns você ganhou " + ganhou + " de Xp";

                    barraSorteTime = new Thread(){

                        public void run(){

                            for(int cont = 0; cont<Historia2.length(); cont++){
                                try {
                                    textoInfoBarra13.setText(textoInfoBarra13.getText() + Historia2.charAt(cont));
                                    barraSorteTime.sleep(50);
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(telaCarregamento.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            try {
                                barraSorteTime.sleep(1000);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(telaHistoria.class.getName()).log(Level.SEVERE, null, ex);
                            }
                                contHistoria = 8;
                                painelBarraSorte.setVisible(false);
                                painelBarraSorte.setEnabled(false);
                                painelGeral.setVisible(true);
                                painelGeral.setEnabled(true);
                                historia();
                                barraSorteTime.stop();
                            }
                    };
                    barraSorteTime.start();
                    barraSorte.stop();
                }
        };
        barraSorte.start();
        salvarDados();
    }//GEN-LAST:event_cliqueAquiActionPerformed

    private void batataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batataActionPerformed
        contBatatas = contBatatas + 1;
        numeroDeBatatas.setText("" + contBatatas);
        if(batatas == 0){
            batatas = 1;
            
            delayBatatas = new Thread(){
            
            public void run(){
        
                for(int cont = 60; cont>-1; cont--){
                    try {
                        if(cont<10){
                            timerBatata.setText("00:0" + cont);
                        }else{
                            timerBatata.setText("00:" + cont);
                        }
                        delayBatatas.sleep(150);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(telaCarregamento.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                batata.setIcon(avatarPotatoTime2);
                batata.setEnabled(false);
                
                int xpBatata = 0;
                if(contBatatas< 11){
                    xpBatata = 5;
                }else if(contBatatas>10 && contBatatas<16){
                    xpBatata = 10;
                }else if(contBatatas>15 && contBatatas<31){
                    xpBatata = 25;
                }else if(contBatatas>30 && contBatatas<46){
                    xpBatata = 40;
                }else if(contBatatas>45 && contBatatas<56){
                    xpBatata = 53;
                }else if(contBatatas>55 && contBatatas<66){
                    xpBatata = 64;
                }else if(contBatatas>65 && contBatatas<71){
                    xpBatata =  69;
                }else if(contBatatas>70 && contBatatas<81){
                    xpBatata = 80;
                }else if(contBatatas>80 && contBatatas<91){
                    xpBatata = 90;
                }else if(contBatatas>90 && contBatatas<101){
                    xpBatata = 100;
                }else if(contBatatas>101 && contBatatas<151){
                    xpBatata = 125;
                }else if(contBatatas>150 && contBatatas<201){
                    xpBatata = 200;
                }else if(contBatatas>200){
                    xpBatata = 300;
                }
                
                Historia2 = ("Parabéns você ganhou " + xpBatata + " de Xp");
                timerBatata.setText("");
                for(int cont = 0; cont<Historia2.length(); cont++){
                    try {
                        timerBatata.setText(timerBatata.getText() + Historia2.charAt(cont));
                        barraSorteTime.sleep(50);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(telaCarregamento.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                try {
                    barraSorteTime.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(telaCarregamento.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                levelBarra = levelBarra + xpBatata;
                contHistoria = 8;

                painelPotatoTime.setVisible(false);
                painelPotatoTime.setEnabled(false);
                painelGeral.setVisible(true);
                painelGeral.setEnabled(true);
                historia();
                delayBatatas.stop();
            }
        };
        delayBatatas.start();
        }
    }//GEN-LAST:event_batataActionPerformed

    
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(telaHistoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaHistoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaHistoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaHistoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaHistoria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel avatar;
    private javax.swing.JProgressBar barraDaSorte;
    private javax.swing.JButton batata;
    private javax.swing.JLabel bordaHistoria;
    private javax.swing.JButton botaoDireita;
    private javax.swing.JButton botaoEsquerda;
    private javax.swing.JButton botaoMeio;
    private javax.swing.JButton botaoTruco1;
    private javax.swing.JButton botaoTruco2;
    private javax.swing.JButton botaoTruco3;
    private javax.swing.JButton cliqueAqui;
    private javax.swing.JButton cliqueParaPassar;
    private javax.swing.JButton comandosADM;
    private javax.swing.JLabel exibirClasse;
    private javax.swing.JButton exibirConfiguracao;
    private javax.swing.JProgressBar exibirLevel;
    private javax.swing.JLabel exibirLevelStatus;
    private javax.swing.JButton exibirMenu;
    private javax.swing.JLabel exibirNome;
    private javax.swing.JProgressBar exibirVida;
    private javax.swing.JLabel exibirVidaStatus;
    private javax.swing.JLabel fundo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField lerContHistoria;
    private javax.swing.JLabel miniMapa;
    private javax.swing.JLabel miniMapaBorda;
    private javax.swing.JLabel numeroDeBatatas;
    private javax.swing.JPanel painelADM;
    private javax.swing.JPanel painelBarraSorte;
    private javax.swing.JPanel painelGeral;
    private javax.swing.JPanel painelPotatoTime;
    private javax.swing.JPanel personagem;
    private javax.swing.JLabel textoHistoria1;
    private javax.swing.JLabel textoHistoria2;
    private javax.swing.JLabel textoHistoria3;
    private javax.swing.JLabel textoInfoBarra;
    private javax.swing.JLabel textoInfoBarra1;
    private javax.swing.JLabel textoInfoBarra10;
    private javax.swing.JLabel textoInfoBarra11;
    private javax.swing.JLabel textoInfoBarra12;
    private javax.swing.JLabel textoInfoBarra13;
    private javax.swing.JLabel textoInfoBarra2;
    private javax.swing.JLabel textoInfoBarra3;
    private javax.swing.JLabel textoInfoBarra4;
    private javax.swing.JLabel textoInfoBarra5;
    private javax.swing.JLabel textoInfoBarra6;
    private javax.swing.JLabel textoInfoBarra7;
    private javax.swing.JLabel textoInfoBarra8;
    private javax.swing.JLabel textoInfoBarra9;
    private javax.swing.JLabel textoLevel;
    private javax.swing.JLabel textoVida;
    private javax.swing.JLabel textoXP;
    private javax.swing.JLabel timerBatata;
    // End of variables declaration//GEN-END:variables

    public telaMenu getMenu() {
        return menu;
    }

    public void setMenu(telaMenu menu) {
        this.menu = menu;
    }
}
