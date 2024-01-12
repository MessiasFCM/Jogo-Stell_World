/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo;

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

public class telaBatalha extends javax.swing.JFrame {

    private telaMenu menu;
    private String name;
    private String nome, nomeInimigo;
    
    String classeEscolhida, local, classeInimigo;
    String Historia1="",Historia2="",Historia3="";
    
    int[] pontos = new int[8];
    int[] pontosBackup = new int[8];
    int pontos_adiconais, pontosAdicionaisBackup;
    int estaminaBarraBatalha = 100, vidaBarraPersonagem, vidaBarraInimigo = 100, levelBarra, estaminaBarra = 100;
    int estaminaBarraTotal = 100, vidaBarraTotalPersonagem, vidaBarraTotalInimigo = 100, levelBarraTotal;
    int dano, levelPersonagem, levelInimigo, levelUp;
    int porcentagemVida1,porcentagemVida2, modoADM;
    int porcentagemVidaInimigo1, porcentagemVidaInimigo2;
    int telaFundo , gameOver = 0, travamento = 0, travamentoPersonagem = 0;
    int danoCausadoPersonagem, danoCriticoPersonagem, danoCausadoInimigo, danoCriticoInimigo,sorte;
    int contGeral, contTravamento,contGeralAtaque = 0, contPercepcao = 2 , contAumentarCritico, contAtordoamento=5;
    long contHistoria;
    
    
    Thread delayAtaquePersonagemBerserk = new Thread();
    Thread delayAtaquePersonagemArqueira = new Thread();
    Thread delayAtaqueInimigo = new Thread();
    
    telaInformacao telaInformacaoChamar;
    telaConfiguracao telaConfiguracaoChamar;
    
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

    ImageIcon grupoDeLadroesHistoria_1 = new ImageIcon("src/imagens/grupoDeLadroesHistoria_1.png");
    ImageIcon grupoDeLadroesHistoria_2 = new ImageIcon("src/imagens/grupoDeLadroesHistoria_2.png");
    ImageIcon grupoDeLadroesHistoria_3 = new ImageIcon("src/imagens/grupoDeLadroesHistoria_3.png");
    ImageIcon ciclopeHistoria_1 = new ImageIcon("src/imagens/ciclopeHistoria_1.png");
    ImageIcon ciclopeHistoria_2 = new ImageIcon("src/imagens/ciclopeHistoria_2.png");
    ImageIcon ciclopeHistoria_3 = new ImageIcon("src/imagens/ciclopeHistoria_3.png");
    ImageIcon loboHistoria_1 = new ImageIcon("src/imagens/loboHistoria_1.png");
    ImageIcon loboHistoria_2 = new ImageIcon("src/imagens/loboHistoria_2.png");
    ImageIcon loboHistoria_3 = new ImageIcon("src/imagens/loboHistoria_3.png");
    ImageIcon slimeHistoria_1 = new ImageIcon("src/imagens/slimeHistoria_1.png");
    ImageIcon slimeHistoria_2 = new ImageIcon("src/imagens/slimeHistoria_2.png");
    ImageIcon slimeHistoria_3 = new ImageIcon("src/imagens/slimeHistoria_3.png");
    ImageIcon eduHistoria_1 = new ImageIcon("src/imagens/eduHistoria_1.png");
    ImageIcon eduHistoria_2 = new ImageIcon("src/imagens/eduHistoria_2.png");
    ImageIcon eduHistoria_3 = new ImageIcon("src/imagens/eduHistoria_3.png");
    ImageIcon goblinsHistoria_1 = new ImageIcon("src/imagens/goblinsHistoria_1.png");
    ImageIcon goblinsHistoria_2 = new ImageIcon("src/imagens/goblinsHistoria_2.png");
    ImageIcon goblinsHistoria_3 = new ImageIcon("src/imagens/goblinsHistoria_3.png");
    ImageIcon kaduHistoria_1 = new ImageIcon("src/imagens/kaduHistoria_1.png");
    ImageIcon kaduHistoria_2 = new ImageIcon("src/imagens/kaduHistoria_2.png");
    ImageIcon kaduHistoria_3 = new ImageIcon("src/imagens/kaduHistoria_3.png");
    
    Random geradorCriticoPersonagem = new Random();
    Random geradorCriticoInimigo = new Random();
    Random geradorDanoPersonagem = new Random();
    Random geradorDanoInimigo = new Random();
    Random geradorSorte = new Random();
    
    
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
                    
                    System.out.println("telaBatalhaLer" + "\nNome: " + nome + "\r\nClasse: " + classeEscolhida  + "\r\nForca: "  + pontos[0]  + "\r\nConstituicao: "  + pontos[1] +  "\r\nDestreza: " + pontos[2] + "\r\nAgilidade: " + pontos[3] + "\r\nInteligencia: " + pontos[4] + "\r\nForcaDeVontade: " + pontos[5] + "\r\nPercepcao: " + pontos[6] + "\r\nCarisma: " + pontos[7] + "\r\nBackupForca: " + pontosBackup[0] + "\r\nBackupConstituicao: " + pontosBackup[1] + "\r\nBackupDestreza: " + pontosBackup[2] + "\r\nBackupAgilidade: " + pontosBackup[3] + "\r\nBackupInteligencia: " + pontosBackup[4] + "\r\nBackupForcaDeVontade: " + pontosBackup[5] + "\r\nBackupPercepcao: " + pontosBackup[6] + "\r\nBackupCarisma: " + pontosBackup[7] + "\nPontosAdicionais: " + pontos_adiconais + "\nLevelBarra: " + levelBarra + "\nLevelBarraTotal: " + levelBarraTotal+ "\nVidaBarra: " + vidaBarraPersonagem + "\nVidaBarraTotal: " + vidaBarraTotalPersonagem + "\nLevel: " + levelPersonagem + "\nLevelUP: " + levelUp + "\nTelaFundo: " + telaFundo + "\nContHistoria: " + contHistoria + "\nLocalidade: " + local + "\ncontTravamento" + contTravamento +  "\nPontosAdicionaisBackup: " + pontosAdicionaisBackup +  "\nBarra Estamina: " + estaminaBarra + "\n  -=%=-  \n");
                    escreverTela();
                }
            }while(linha != null);
            arquivo.close();
        }catch(Exception e){
            System.err.printf("|telaBatalhaLer| Erro na abertura do arquivo: %s.\n",
            e.getMessage());
        }
            
    }
    private void escritorSalvamento() {
        
        try{

        FileOutputStream arquivo = new FileOutputStream("backup\\Salvamento.txt");
        PrintWriter print = new PrintWriter(arquivo);

        print.println("Nome" + " ; " + nome + " ; " + "Classe" + " ; " + classeEscolhida + " ; " + "Forca" + " ; " + pontos[0] + " ; " + "Constituicao" + " ; " + pontos[1] + " ; " + "Destreza" + " ; " + pontos[2] + " ; " + "Agilidade" + " ; " + pontos[3] + " ; " + "Inteligencia" + " ; " + pontos[4] + " ; " + "ForcaDeVontade" + " ; " + pontos[5] + " ; " + "Percepcao" + " ; " + pontos[6] + " ; " + "Carisma" + " ; " + pontos[7] + " ; " + "BackupForca" + " ; " + pontosBackup[0] + " ; " + "BackupConstituicao" + " ; " + pontosBackup[1] + " ; " + "BackupDestreza" + " ; " + pontosBackup[2] + " ; " + "BackupAgilidade" + " ; " + pontosBackup[3] + " ; " + "BackupInteligencia" + " ; " + pontosBackup[4] + " ; " + "BackupForcaDeVontade" + " ; " + pontosBackup[5] + " ; " + "BackupPercepcao" + " ; " + pontosBackup[6] + " ; " + "BackupCarisma" + " ; " + pontosBackup[7] + " ; " + "PontosAdicionais:" + " ; " + pontos_adiconais + " ; " + "LevelBarra" + " ; " + levelBarra + " ; " + "LevelBarraTotal" + " ; " + levelBarraTotal+ " ; "  + "VidaBarra" + " ; " + vidaBarraPersonagem + " ; "  + "VidaBarraTotal" + " ; " + vidaBarraTotalPersonagem + " ; " + "Level" + " ; " + levelPersonagem + " ; " + "LevelUP" + " ; " + levelUp + " ; " + "telaFundo" + " ; " + telaFundo + " ; " + "contHistoria" + " ; " + contHistoria + " ; " + "localidade" + " ; " + local + " ; " + "contTravamento" + " ; " + contTravamento + " ; " + "pontosAdicionaisBackup" + " ; " + pontosAdicionaisBackup + " ; " + modoADM + " ; " + "estaminaBarra" + " ; " + estaminaBarra + " ; ");
        System.out.println("telaBatalhaEscrever" + "\nNome: " + nome + "\r\nClasse: " + classeEscolhida  + "\r\nForca: "  + pontos[0]  + "\r\nConstituicao: "  + pontos[1] +  "\r\nDestreza: " + pontos[2] + "\r\nAgilidade: " + pontos[3] + "\r\nInteligencia: " + pontos[4] + "\r\nForcaDeVontade: " + pontos[5] + "\r\nPercepcao: " + pontos[6] + "\r\nCarisma: " + pontos[7] + "\r\nBackupForca: " + pontosBackup[0] + "\r\nBackupConstituicao: " + pontosBackup[1] + "\r\nBackupDestreza: " + pontosBackup[2] + "\r\nBackupAgilidade: " + pontosBackup[3] + "\r\nBackupInteligencia: " + pontosBackup[4] + "\r\nBackupForcaDeVontade: " + pontosBackup[5] + "\r\nBackupPercepcao: " + pontosBackup[6] + "\r\nBackupCarisma: " + pontosBackup[7] + "\nPontosAdicionais: " + pontos_adiconais + "\nLevelBarra: " + levelBarra + "\nLevelBarraTotal: " + levelBarraTotal+ "\nVidaBarra: " + vidaBarraPersonagem + "\nVidaBarraTotal: " + vidaBarraTotalPersonagem + "\nLevel: " + levelPersonagem + "\nLevelUP: " + levelUp + "\nTelaFundo: " + telaFundo + "\nContHistoria: " + contHistoria + "\nLocalidade: " + local + "\ncontTravamento: " + contTravamento + "\nPontosAdicionaisBackup: " + pontosAdicionaisBackup +  "\nBarra Estamina: " + estaminaBarra + "\n  -=%=-  \n");
        print.close();
        arquivo.close();
        
        }catch(Exception e){
            System.err.printf("|telaBatalhaEscrever| Erro na abertura do arquivo: %s.\n",
            e.getMessage());
        }
            
    }   
    private void salvarDados(){
        escritorSalvamento();
        escreverTela();
        
        if(gameOver == 0){
            if(vidaBarraPersonagem <= 0){
                gameOver = 1;
                this.dispose();
                new telaGameOver().setVisible(true);
            }
            if(estaminaBarraBatalha <= 0){
                gameOver = 1;
                this.dispose();
                new telaGameOver().setVisible(true);
            }
        }
         if(vidaBarraInimigo<0){
             vidaBarraInimigo = 0;
         }
    }
    private void escreverTela(){
        if(contHistoria<2){
            porcentagemVidaInimigo1 = (vidaBarraTotalInimigo / 100)* 30;
            porcentagemVidaInimigo2 = (vidaBarraTotalInimigo / 100)* 60;
            
            if(vidaBarraInimigo <= porcentagemVidaInimigo1){
                avatarInimigo.setIcon(grupoDeLadroesHistoria_3);
            }
            if(vidaBarraInimigo <= porcentagemVidaInimigo2 && vidaBarraInimigo> porcentagemVidaInimigo1){
                avatarInimigo.setIcon(grupoDeLadroesHistoria_2);
            }
            if(vidaBarraInimigo > porcentagemVidaInimigo2){
                avatarInimigo.setIcon(grupoDeLadroesHistoria_1);
            }
            
            nomeInimigo = "Pato Maloqueiro";
            classeInimigo = "Pato";
            levelInimigo = 666;
            exibirNomeInimigo.setText(nomeInimigo);
            exibirClasseInimigo.setText(classeInimigo);
            textoLevelInimigo.setText("Level: " + levelInimigo);

            if(travamento == 0){
                vidaBarraTotalInimigo = 666;
                vidaBarraInimigo = 666;
                estaminaBarraBatalha = 1000;
                estaminaBarraTotal = 1000;
                vidaBarraPersonagem = 240;
                vidaBarraTotalPersonagem = 240;
                travamento = 1;
            }
            nome = "Kudelebre";
            classeEscolhida = "Designer";
            levelPersonagem = 24;
            exibirVidaInimigo.setMaximum(vidaBarraTotalInimigo);
            exibirVidaInimigo.setValue(vidaBarraInimigo);
            exibirVidaStatusInimigo.setText(vidaBarraInimigo + " / " + vidaBarraTotalInimigo);
            exibirVidaInimigo.setForeground(new Color(175,30,30));
        }
        
        
        exibirNome.setText(nome);
        exibirClasse.setText(classeEscolhida);
        textoLevelPersonagem.setText("Level: " + levelPersonagem);
        if(travamentoPersonagem == 0){
            estaminaBarraBatalha = estaminaBarra;
            estaminaBarraTotal = estaminaBarra;
            travamentoPersonagem = 1;
        }
        exibirEstamina.setValue(estaminaBarraBatalha);
        exibirEstamina.setMaximum(estaminaBarraTotal);
        exibirEstaminaStatus.setText(estaminaBarraBatalha + " / " + estaminaBarraTotal);
        exibirEstamina.setForeground(new Color(181,196,0));
        
        exibirVida.setMaximum(vidaBarraTotalPersonagem);
        exibirVida.setValue(vidaBarraPersonagem);
        exibirVidaStatus.setText(vidaBarraPersonagem + " / " + vidaBarraTotalPersonagem);
        exibirVida.setForeground(new Color(175,30,30));
        
        if(contHistoria==40015){
            porcentagemVidaInimigo1 = (vidaBarraTotalInimigo / 100)* 30;
            porcentagemVidaInimigo2 = (vidaBarraTotalInimigo / 100)* 60;
            
            if(vidaBarraInimigo <= porcentagemVidaInimigo1){
                avatarInimigo.setIcon(grupoDeLadroesHistoria_3);
            }
            if(vidaBarraInimigo <= porcentagemVidaInimigo2 && vidaBarraInimigo> porcentagemVidaInimigo1){
                avatarInimigo.setIcon(grupoDeLadroesHistoria_2);
            }
            if(vidaBarraInimigo > porcentagemVidaInimigo2){
                avatarInimigo.setIcon(grupoDeLadroesHistoria_1);
            }
            
            nomeInimigo = "Grupo de ladroes";
            classeInimigo = "Ladrões";
            levelInimigo = 3;
            exibirNomeInimigo.setText(nomeInimigo);
            exibirClasseInimigo.setText(classeInimigo);
            textoLevelInimigo.setText("Level: " + levelInimigo);

            if(travamento == 0){
                vidaBarraTotalInimigo = 100;
                vidaBarraInimigo = 100;
                travamento = 1;
            }
            exibirVidaInimigo.setMaximum(vidaBarraTotalInimigo);
            exibirVidaInimigo.setValue(vidaBarraInimigo);
            exibirVidaStatusInimigo.setText(vidaBarraInimigo + " / " + vidaBarraTotalInimigo);
            exibirVidaInimigo.setForeground(new Color(175,30,30));
        }
        if(contHistoria==50015){
            porcentagemVidaInimigo1 = (vidaBarraTotalInimigo / 100)* 30;
            porcentagemVidaInimigo2 = (vidaBarraTotalInimigo / 100)* 60;
            
            if(vidaBarraInimigo <= porcentagemVidaInimigo1){
                avatarInimigo.setIcon(goblinsHistoria_3);
            }
            if(vidaBarraInimigo <= porcentagemVidaInimigo2 && vidaBarraInimigo> porcentagemVidaInimigo1){
                avatarInimigo.setIcon(goblinsHistoria_2);
            }
            if(vidaBarraInimigo > porcentagemVidaInimigo2){
                avatarInimigo.setIcon(goblinsHistoria_1);
            }
            
            nomeInimigo = "Gangue de Goblins";
            classeInimigo = "Goblins";
            levelInimigo = 5;
            exibirNomeInimigo.setText(nomeInimigo);
            exibirClasseInimigo.setText(classeInimigo);
            textoLevelInimigo.setText("Level: " + levelInimigo);

            if(travamento == 0){
                vidaBarraTotalInimigo = 120;
                vidaBarraInimigo = 120;
                travamento = 1;
            }
            exibirVidaInimigo.setMaximum(vidaBarraTotalInimigo);
            exibirVidaInimigo.setValue(vidaBarraInimigo);
            exibirVidaStatusInimigo.setText(vidaBarraInimigo + " / " + vidaBarraTotalInimigo);
            exibirVidaInimigo.setForeground(new Color(175,30,30));
        }
        if(contHistoria==80015){
            porcentagemVidaInimigo1 = (vidaBarraTotalInimigo / 100)* 30;
            porcentagemVidaInimigo2 = (vidaBarraTotalInimigo / 100)* 60;
            
            if(vidaBarraInimigo <= porcentagemVidaInimigo1){
                avatarInimigo.setIcon(ciclopeHistoria_3);
            }
            if(vidaBarraInimigo <= porcentagemVidaInimigo2 && vidaBarraInimigo> porcentagemVidaInimigo1){
                avatarInimigo.setIcon(ciclopeHistoria_2);
            }
            if(vidaBarraInimigo > porcentagemVidaInimigo2){
                avatarInimigo.setIcon(ciclopeHistoria_1);
            }
            
            nomeInimigo = "3 Ciclopes";
            classeInimigo = "Ciclopes";
            levelInimigo = 8;
            exibirNomeInimigo.setText(nomeInimigo);
            exibirClasseInimigo.setText(classeInimigo);
            textoLevelInimigo.setText("Level: " + levelInimigo);

            if(travamento == 0){
                vidaBarraTotalInimigo = 150;
                vidaBarraInimigo = 150;
                travamento = 1;
            }
            exibirVidaInimigo.setMaximum(vidaBarraTotalInimigo);
            exibirVidaInimigo.setValue(vidaBarraInimigo);
            exibirVidaStatusInimigo.setText(vidaBarraInimigo + " / " + vidaBarraTotalInimigo);
            exibirVidaInimigo.setForeground(new Color(175,30,30));
        }
        if(contHistoria==800152){
            porcentagemVidaInimigo1 = (vidaBarraTotalInimigo / 100)* 30;
            porcentagemVidaInimigo2 = (vidaBarraTotalInimigo / 100)* 60;
            
            if(vidaBarraInimigo <= porcentagemVidaInimigo1){
                avatarInimigo.setIcon(ciclopeHistoria_3);
            }
            if(vidaBarraInimigo <= porcentagemVidaInimigo2 && vidaBarraInimigo> porcentagemVidaInimigo1){
                avatarInimigo.setIcon(ciclopeHistoria_2);
            }
            if(vidaBarraInimigo > porcentagemVidaInimigo2){
                avatarInimigo.setIcon(ciclopeHistoria_1);
            }
            
            nomeInimigo = "3 Ciclopes";
            classeInimigo = "Ciclopes";
            levelInimigo = 8;
            exibirNomeInimigo.setText(nomeInimigo);
            exibirClasseInimigo.setText(classeInimigo);
            textoLevelInimigo.setText("Level: " + levelInimigo);

            if(travamento == 0){
                vidaBarraTotalInimigo = 150;
                vidaBarraInimigo = 150;
                travamento = 1;
            }
            exibirVidaInimigo.setMaximum(vidaBarraTotalInimigo);
            exibirVidaInimigo.setValue(vidaBarraInimigo);
            exibirVidaStatusInimigo.setText(vidaBarraInimigo + " / " + vidaBarraTotalInimigo);
            exibirVidaInimigo.setForeground(new Color(175,30,30));
        }
        if(contHistoria==800153){
            porcentagemVidaInimigo1 = (vidaBarraTotalInimigo / 100)* 30;
            porcentagemVidaInimigo2 = (vidaBarraTotalInimigo / 100)* 60;
            
            if(vidaBarraInimigo <= porcentagemVidaInimigo1){
                avatarInimigo.setIcon(ciclopeHistoria_3);
            }
            if(vidaBarraInimigo <= porcentagemVidaInimigo2 && vidaBarraInimigo> porcentagemVidaInimigo1){
                avatarInimigo.setIcon(ciclopeHistoria_2);
            }
            if(vidaBarraInimigo > porcentagemVidaInimigo2){
                avatarInimigo.setIcon(ciclopeHistoria_1);
            }
            
            nomeInimigo = "3 Ciclopes";
            classeInimigo = "Ciclopes";
            levelInimigo = 8;
            exibirNomeInimigo.setText(nomeInimigo);
            exibirClasseInimigo.setText(classeInimigo);
            textoLevelInimigo.setText("Level: " + levelInimigo);

            if(travamento == 0){
                vidaBarraTotalInimigo = 150;
                vidaBarraInimigo = 150;
                travamento = 1;
            }
            exibirVidaInimigo.setMaximum(vidaBarraTotalInimigo);
            exibirVidaInimigo.setValue(vidaBarraInimigo);
            exibirVidaStatusInimigo.setText(vidaBarraInimigo + " / " + vidaBarraTotalInimigo);
            exibirVidaInimigo.setForeground(new Color(175,30,30));
        }
        if(contHistoria==800154){
            porcentagemVidaInimigo1 = (vidaBarraTotalInimigo / 100)* 30;
            porcentagemVidaInimigo2 = (vidaBarraTotalInimigo / 100)* 60;
            
            if(vidaBarraInimigo <= porcentagemVidaInimigo1){
                avatarInimigo.setIcon(ciclopeHistoria_3);
            }
            if(vidaBarraInimigo <= porcentagemVidaInimigo2 && vidaBarraInimigo> porcentagemVidaInimigo1){
                avatarInimigo.setIcon(ciclopeHistoria_2);
            }
            if(vidaBarraInimigo > porcentagemVidaInimigo2){
                avatarInimigo.setIcon(ciclopeHistoria_1);
            }
            
             nomeInimigo = "3 Ciclopes";
            classeInimigo = "Ciclopes";
            levelInimigo = 8;
            exibirNomeInimigo.setText(nomeInimigo);
            exibirClasseInimigo.setText(classeInimigo);
            textoLevelInimigo.setText("Level: " + levelInimigo);

            if(travamento == 0){
                vidaBarraTotalInimigo = 150;
                vidaBarraInimigo = 150;
                travamento = 1;
            }
            exibirVidaInimigo.setMaximum(vidaBarraTotalInimigo);
            exibirVidaInimigo.setValue(vidaBarraInimigo);
            exibirVidaStatusInimigo.setText(vidaBarraInimigo + " / " + vidaBarraTotalInimigo);
            exibirVidaInimigo.setForeground(new Color(175,30,30));
        }
        if(contHistoria==800155){
            porcentagemVidaInimigo1 = (vidaBarraTotalInimigo / 100)* 30;
            porcentagemVidaInimigo2 = (vidaBarraTotalInimigo / 100)* 60;
            
            if(vidaBarraInimigo <= porcentagemVidaInimigo1){
                avatarInimigo.setIcon(loboHistoria_3);
            }
            if(vidaBarraInimigo <= porcentagemVidaInimigo2 && vidaBarraInimigo> porcentagemVidaInimigo1){
                avatarInimigo.setIcon(loboHistoria_2);
            }
            if(vidaBarraInimigo > porcentagemVidaInimigo2){
                avatarInimigo.setIcon(loboHistoria_1);
            }
            
            nomeInimigo = "Lobo Cinzento";
            classeInimigo = "Lobo";
            levelInimigo = 10;
            exibirNomeInimigo.setText(nomeInimigo);
            exibirClasseInimigo.setText(classeInimigo);
            textoLevelInimigo.setText("Level: " + levelInimigo);

            if(travamento == 0){
                vidaBarraTotalInimigo = 180;
                vidaBarraInimigo = 180;
                travamento = 1;
            }
            exibirVidaInimigo.setMaximum(vidaBarraTotalInimigo);
            exibirVidaInimigo.setValue(vidaBarraInimigo);
            exibirVidaStatusInimigo.setText(vidaBarraInimigo + " / " + vidaBarraTotalInimigo);
            exibirVidaInimigo.setForeground(new Color(175,30,30));
        }
        if(contHistoria==8001555){
            porcentagemVidaInimigo1 = (vidaBarraTotalInimigo / 100)* 30;
            porcentagemVidaInimigo2 = (vidaBarraTotalInimigo / 100)* 60;
            
            if(vidaBarraInimigo <= porcentagemVidaInimigo1){
                avatarInimigo.setIcon(slimeHistoria_3);
            }
            if(vidaBarraInimigo <= porcentagemVidaInimigo2 && vidaBarraInimigo> porcentagemVidaInimigo1){
                avatarInimigo.setIcon(slimeHistoria_2);
            }
            if(vidaBarraInimigo > porcentagemVidaInimigo2){
                avatarInimigo.setIcon(slimeHistoria_1);
            }
            
            nomeInimigo = "Slime";
            classeInimigo = "Slime";
            levelInimigo = 8;
            exibirNomeInimigo.setText(nomeInimigo);
            exibirClasseInimigo.setText(classeInimigo);
            textoLevelInimigo.setText("Level: " + levelInimigo);

            if(travamento == 0){
                vidaBarraTotalInimigo = 150;
                vidaBarraInimigo = 150;
                travamento = 1;
            }
            exibirVidaInimigo.setMaximum(vidaBarraTotalInimigo);
            exibirVidaInimigo.setValue(vidaBarraInimigo);
            exibirVidaStatusInimigo.setText(vidaBarraInimigo + " / " + vidaBarraTotalInimigo);
            exibirVidaInimigo.setForeground(new Color(175,30,30));
            
        }
        if(contHistoria==1300015){
            porcentagemVidaInimigo1 = (vidaBarraTotalInimigo / 100)* 30;
            porcentagemVidaInimigo2 = (vidaBarraTotalInimigo / 100)* 60;
            
            if(vidaBarraInimigo <= porcentagemVidaInimigo1){
                avatarInimigo.setIcon(eduHistoria_3);
            }
            if(vidaBarraInimigo <= porcentagemVidaInimigo2 && vidaBarraInimigo> porcentagemVidaInimigo1){
                avatarInimigo.setIcon(eduHistoria_2);
            }
            if(vidaBarraInimigo > porcentagemVidaInimigo2){
                avatarInimigo.setIcon(eduHistoria_1);
            }
            
            nomeInimigo = "Gangue do Dudu";
            classeInimigo = "Demonios";
            levelInimigo = 10;
            exibirNomeInimigo.setText(nomeInimigo);
            exibirClasseInimigo.setText(classeInimigo);
            textoLevelInimigo.setText("Level: " + levelInimigo);

            if(travamento == 0){
                vidaBarraTotalInimigo = 170;
                vidaBarraInimigo = 170;
                travamento = 1;
            }
            exibirVidaInimigo.setMaximum(vidaBarraTotalInimigo);
            exibirVidaInimigo.setValue(vidaBarraInimigo);
            exibirVidaStatusInimigo.setText(vidaBarraInimigo + " / " + vidaBarraTotalInimigo);
            exibirVidaInimigo.setForeground(new Color(175,30,30));
        }
        if(contHistoria==13000155){
            porcentagemVidaInimigo1 = (vidaBarraTotalInimigo / 100)* 30;
            porcentagemVidaInimigo2 = (vidaBarraTotalInimigo / 100)* 60;
            
            if(vidaBarraInimigo <= porcentagemVidaInimigo1){
                avatarInimigo.setIcon(kaduHistoria_3);
            }
            if(vidaBarraInimigo <= porcentagemVidaInimigo2 && vidaBarraInimigo> porcentagemVidaInimigo1){
                avatarInimigo.setIcon(kaduHistoria_2);
            }
            if(vidaBarraInimigo > porcentagemVidaInimigo2){
                avatarInimigo.setIcon(kaduHistoria_1);
            }
            
            nomeInimigo = "Kdu";
            classeInimigo = "Rei Demonio";
            levelInimigo = 24;
            exibirNomeInimigo.setText(nomeInimigo);
            exibirClasseInimigo.setText(classeInimigo);
            textoLevelInimigo.setText("Level: " + levelInimigo);

            if(travamento == 0){
                vidaBarraTotalInimigo = 750;
                vidaBarraInimigo = 750;
                travamento = 1;
            }
            exibirVidaInimigo.setMaximum(vidaBarraTotalInimigo);
            exibirVidaInimigo.setValue(vidaBarraInimigo);
            exibirVidaStatusInimigo.setText(vidaBarraInimigo + " / " + vidaBarraTotalInimigo);
            exibirVidaInimigo.setForeground(new Color(175,30,30));
        }
        
        if("Assassina".equals(classeEscolhida)){
            porcentagemVida1 = (vidaBarraTotalPersonagem / 100)* 30;
            porcentagemVida2 = (vidaBarraTotalPersonagem / 100)* 60;
            
            if(vidaBarraPersonagem <= porcentagemVida1){
                avatarPersonagem.setIcon(assassinaHistoria_3);
            }
            if(vidaBarraPersonagem <= porcentagemVida2 && vidaBarraPersonagem> porcentagemVida1){
                avatarPersonagem.setIcon(assassinaHistoria_2);
            }
            if(vidaBarraPersonagem > porcentagemVida2){
                avatarPersonagem.setIcon(assassinaHistoria_1);
            }
            
            botaoAtaque1.setText("Ataque Normal");

            botaoAtaque2.setText("Grito de Furia");

            botaoAtaque3.setText("Golpe Aniquilador");

            botaoAtaque4.setText("Fúria Brutal");

            botaoAtaque5.setText("Percepção");

            botaoAtaque6.setText("Recuperar ST");
        }
        
        if("Cavaleiro".equals(classeEscolhida)){
            porcentagemVida1 = (vidaBarraTotalPersonagem / 100)* 30;
            porcentagemVida2 = (vidaBarraTotalPersonagem / 100)* 60;
            
            if(vidaBarraPersonagem <= porcentagemVida1){
                avatarPersonagem.setIcon(cavaleiroHistoria_3);
            }
            if(vidaBarraPersonagem <= porcentagemVida2 && vidaBarraPersonagem> porcentagemVida1){
                avatarPersonagem.setIcon(cavaleiroHistoria_2);
            }
            if(vidaBarraPersonagem > porcentagemVida2){
                avatarPersonagem.setIcon(cavaleiroHistoria_1);
            }
            
            botaoAtaque1.setText("Ataque Normal");

            botaoAtaque2.setText("Grito de Furia");

            botaoAtaque3.setText("Golpe Aniquilador");

            botaoAtaque4.setText("Fúria Brutal");

            botaoAtaque5.setText("Percepção");

            botaoAtaque6.setText("Recuperar ST");
        }
        
        if("Berserk".equals(classeEscolhida)){
            porcentagemVida1 = (vidaBarraTotalPersonagem / 100)* 30;
            porcentagemVida2 = (vidaBarraTotalPersonagem / 100)* 60;
            
            if(vidaBarraPersonagem <= porcentagemVida1){
                avatarPersonagem.setIcon(berserkHistoria_3);
            }
            if(vidaBarraPersonagem <= porcentagemVida2 && vidaBarraPersonagem> porcentagemVida1){
                avatarPersonagem.setIcon(berserkHistoria_2);
            }
            if(vidaBarraPersonagem > porcentagemVida2){
                avatarPersonagem.setIcon(berserkHistoria_1);
            }
            
            botaoAtaque1.setText("Ataque Normal");

            botaoAtaque2.setText("Grito de Furia");

            botaoAtaque3.setText("Golpe Aniquilador");

            botaoAtaque4.setText("Fúria Brutal");

            botaoAtaque5.setText("Percepção");

            botaoAtaque6.setText("Recuperar ST");
        }
        
        if("Arqueira".equals(classeEscolhida)){
            porcentagemVida1 = (vidaBarraTotalPersonagem / 100)* 30;
            porcentagemVida2 = (vidaBarraTotalPersonagem / 100)* 60;
            
            if(vidaBarraPersonagem <= porcentagemVida1){
                avatarPersonagem.setIcon(arqueiraHistoria_3);
            }
            if(vidaBarraPersonagem <= porcentagemVida2 && vidaBarraPersonagem> porcentagemVida1){
                avatarPersonagem.setIcon(arqueiraHistoria_2);
            }
            if(vidaBarraPersonagem > porcentagemVida2){
                avatarPersonagem.setIcon(arqueiraHistoria_1);
            }
            
            botaoAtaque1.setText("Tiro rápido");

            botaoAtaque2.setText("Flecha de Gelo");

            botaoAtaque3.setText("Chuva de Flechas");

            botaoAtaque4.setText("Tiro Furtivo");

            botaoAtaque5.setText("Percepção");

            botaoAtaque6.setText("Recuperar ST");
        }
        
        if("Mago".equals(classeEscolhida)){
            porcentagemVida1 = (vidaBarraTotalPersonagem / 100)* 30;
            porcentagemVida2 = (vidaBarraTotalPersonagem / 100)* 60;
            
            if(vidaBarraPersonagem <= porcentagemVida1){
                avatarPersonagem.setIcon(magoHistoria_3);
            }
            if(vidaBarraPersonagem <= porcentagemVida2 && vidaBarraPersonagem> porcentagemVida1){
                avatarPersonagem.setIcon(magoHistoria_2);
            }
            if(vidaBarraPersonagem > porcentagemVida2){
                avatarPersonagem.setIcon(magoHistoria_1);
            }
            
            botaoAtaque1.setText("Ataque Normal");

            botaoAtaque2.setText("Grito de Furia");

            botaoAtaque3.setText("Golpe Aniquilador");

            botaoAtaque4.setText("Fúria Brutal");

            botaoAtaque5.setText("Percepção");

            botaoAtaque6.setText("Recuperar ST");
        }
        
        if("Designer".equals(classeEscolhida)){
            porcentagemVida1 = (vidaBarraTotalPersonagem / 100)* 30;
            porcentagemVida2 = (vidaBarraTotalPersonagem / 100)* 60;
            
            if(vidaBarraPersonagem <= porcentagemVida1){
                avatarPersonagem.setIcon(berserkHistoria_3);
            }
            if(vidaBarraPersonagem <= porcentagemVida2 && vidaBarraPersonagem> porcentagemVida1){
                avatarPersonagem.setIcon(berserkHistoria_2);
            }
            if(vidaBarraPersonagem > porcentagemVida2){
                avatarPersonagem.setIcon(berserkHistoria_1);
            }
            
            botaoAtaque1.setText("Ataque Normal");

            botaoAtaque2.setText("Enloquecedor");

            botaoAtaque3.setText("Golpe da Caneta");

            botaoAtaque4.setText("Café");

            botaoAtaque5.setText("Percepção");

            botaoAtaque6.setText("Recuperar ST");
        }
    }
    private void adm(){
        if(modoADM == 1){
            admMatar.setVisible(true);
            admMatar.setEnabled(true);
            admVida.setVisible(true);
            admVida.setEnabled(true);
        }else{
            admMatar.setVisible(false);
            admMatar.setEnabled(false);
            admVida.setVisible(false);
            admVida.setEnabled(false);
        }
    }
    
    private void vitoria(){
        if(vidaBarraInimigo<=0){
            delayAtaqueInimigo.stop();
            
            painelVitoria.setVisible(true);
            continuar.setEnabled(true);
            botaoAtaque1.setEnabled(false);
            botaoAtaque2.setEnabled(false);
            botaoAtaque3.setEnabled(false);
            botaoAtaque4.setEnabled(false);
            botaoAtaque5.setEnabled(false);
            botaoAtaque6.setEnabled(false);
            sair.setEnabled(false);
            abrirConfiguracoes.setEnabled(false);
            
            if(contHistoria<2){
                msgVitoria2.setText("o Pato Maloqueiro");
                msgVitoria4.setText("o respeito do lendario");
                msgVitoria5.setText("mestre Kalleby");
                msgVitoria6.setText("Tu és foda Manitio !!");
                
                salvarDados();
            }
            if(contHistoria==40015){
                msgVitoria2.setText("o Grupo de ladroes");
                msgVitoria4.setText("+50 de xp");
                msgVitoria5.setText("+10 pontos adicionais");
                msgVitoria6.setText("+2 pontos de inteligencia");
                
                levelBarra = levelBarra + 50;
                pontos_adiconais = pontos_adiconais + 10;
                pontosAdicionaisBackup = pontosAdicionaisBackup + 10;
                pontos[4] = pontos [4] + 2;
                
                contHistoria = 5;
                salvarDados();
            }
            if(contHistoria==50015){
                msgVitoria2.setText("a Gangue de Goblins");
                msgVitoria4.setText("+60 de xp");
                msgVitoria5.setText("+10 pontos adicionais");
                msgVitoria6.setText("+2 pontos de agilidade");
                
                levelBarra = levelBarra + 60;
                pontos_adiconais = pontos_adiconais + 10;
                pontosAdicionaisBackup = pontosAdicionaisBackup + 10;
                pontos[3] = pontos [3] + 2;
                
                contHistoria = 500111;
                salvarDados();
            }
            if(contHistoria==80015){
                msgVitoria2.setText("os 3 Ciclopes");
                msgVitoria4.setText("+70 de xp");
                msgVitoria5.setText("+10 pontos adicionais");
                msgVitoria6.setText("+2 pontos de inteligencia");
                
                levelBarra = levelBarra + 70;
                pontos_adiconais = pontos_adiconais + 10;
                pontosAdicionaisBackup = pontosAdicionaisBackup + 10;
                pontos[4] = pontos [4] + 2;
                
                contHistoria = 80011;
                salvarDados();
            }
            if(contHistoria==800152){
                msgVitoria2.setText("os 3 Ciclopes");
                msgVitoria4.setText("+70 de xp");
                msgVitoria5.setText("+10 pontos adicionais");
                msgVitoria6.setText("+2 pontos de carisma");
                
                levelBarra = levelBarra + 70;
                pontos_adiconais = pontos_adiconais + 10;
                pontosAdicionaisBackup = pontosAdicionaisBackup + 10;
                pontos[6] = pontos [6] + 2;
                
                contHistoria = 8001111;
                salvarDados();
            }
            if(contHistoria==800153){
                msgVitoria2.setText("os 3 Ciclopes");
                msgVitoria4.setText("+70 de xp");
                msgVitoria5.setText("+10 pontos adicionais");
                msgVitoria6.setText("+2 pontos de carisma");
                
                levelBarra = levelBarra + 70;
                pontos_adiconais = pontos_adiconais + 10;
                pontosAdicionaisBackup = pontosAdicionaisBackup + 10;
                pontos[6] = pontos [6] + 2;
                
                contHistoria = 800111120;
                salvarDados();
            }
            if(contHistoria==800154){
                msgVitoria2.setText("os 3 Ciclopes");
                msgVitoria4.setText("+70 de xp");
                msgVitoria5.setText("+10 pontos adicionais");
                msgVitoria6.setText("+2 pontos de carisma");
                
                levelBarra = levelBarra + 70;
                pontos_adiconais = pontos_adiconais + 10;
                pontosAdicionaisBackup = pontosAdicionaisBackup + 10;
                pontos[6] = pontos [6] + 2;
                
                contHistoria = 80011111200L;
                salvarDados();
            }
            if(contHistoria==800155){
                msgVitoria2.setText(" o Lobo Cinzento");
                msgVitoria4.setText("+80 de xp");
                msgVitoria5.setText("+15 pontos adicionais");
                msgVitoria6.setText("+3 pontos de forca");
                
                levelBarra = levelBarra + 80;
                pontos_adiconais = pontos_adiconais + 15;
                pontosAdicionaisBackup = pontosAdicionaisBackup + 15;
                pontos[0] = pontos [0] + 3;
                
                contHistoria = 9;
                salvarDados();
            }
            if(contHistoria==8001555){
                msgVitoria2.setText("o Slime");
                msgVitoria4.setText("+70 de xp");
                msgVitoria5.setText("+10 pontos adicionais");
                msgVitoria6.setText("+2 pontos de constituição");
                
                levelBarra = levelBarra + 70;
                pontos_adiconais = pontos_adiconais + 10;
                pontosAdicionaisBackup = pontosAdicionaisBackup + 10;
                pontos[1] = pontos [1] + 2;
                
                contHistoria = 9;
                salvarDados();
            }
            if(contHistoria==1300015){
                msgVitoria2.setText("a Gangue do Dudu");
                msgVitoria4.setText("+100 de xp");
                msgVitoria5.setText("+5 pontos adicionais");
                msgVitoria6.setText("+2 pontos de constituição");
                
                levelBarra = levelBarra + 100;
                pontos_adiconais = pontos_adiconais + 5;
                pontosAdicionaisBackup = pontosAdicionaisBackup + 10;
                pontos[1] = pontos [1] + 2;
                
                contHistoria = 130000;
                salvarDados();
            }
            if(contHistoria==13000155){
                msgVitoria2.setText("o Rei Kdú");
                msgVitoria4.setText("+1000 de xp");
                msgVitoria5.setText("+50 pontos adicionais");
                msgVitoria6.setText("");
                
                levelBarra = levelBarra + 1000;
                pontos_adiconais = pontos_adiconais + 50;
                pontosAdicionaisBackup = pontosAdicionaisBackup + 10;
                
                contHistoria = 1300002;
                salvarDados();
            }
        }
    }
    private void delayAtaquePersonagemBerserk(){
        textoHistoria1.setText("");
        textoHistoria2.setText("");
        textoHistoria3.setText("");
        textoHistoria2.setVisible(true);
        contGeral = 1;
        delayAtaqueInimigo.interrupt();
        delayAtaquePersonagemBerserk = new Thread(){
            
            public void run(){
        
                botaoAtaque1.setEnabled(false);
                botaoAtaque2.setEnabled(false);
                botaoAtaque3.setEnabled(false);
                botaoAtaque4.setEnabled(false);
                botaoAtaque5.setEnabled(false);
                botaoAtaque6.setEnabled(false);
                if(contGeralAtaque==1||contGeralAtaque==3||contGeralAtaque==4){
                    geradorDanoPersonagem();
                }
                if(contGeralAtaque==5||contGeralAtaque==6){
                    Historia1="";
                }
                if(contGeralAtaque==6){
                    if(estaminaBarraBatalha==estaminaBarraTotal){
                        Historia1="Sua estamina está cheia, por tanto você desperdiçou uma rodada";
                        }
                    else{
                        Historia1="Você recuperou 20 de ST";
                    }
                    recuperarstamina();
                    salvarDados();
                }
               for(int cont = 0; cont<Historia1.length(); cont++){
                   try {
                        textoHistoria2.setText(textoHistoria2.getText() + Historia1.charAt(cont));
                        delayAtaquePersonagemBerserk.sleep(50);
                   } catch (InterruptedException ex) {
                        Logger.getLogger(telaCarregamento.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               
               if(classeEscolhida.equals("Berserk") || classeEscolhida.equals("Designer")){ 
                   if(contGeralAtaque==1){
                      ataqueNormal();
                      if(danoCriticoPersonagem==0){
                        danoCausadoPersonagem=0;
                      }
                      vidaBarraInimigo = vidaBarraInimigo - danoCausadoPersonagem;
                      estaminaBarraBatalha = estaminaBarraBatalha - 3;
                      if(vidaBarraInimigo<0){
                            vidaBarraInimigo=0;
                            salvarDados();
                       }
                      salvarDados();
                   }
                   if(contGeralAtaque==2){
                      if(danoCriticoPersonagem==0){
                        danoCausadoPersonagem=0;
                      }
                      gritoFuria();  
                      salvarDados();
                   }
                   if(contGeralAtaque==3){
                      golpeAniquilador();
                      if(danoCriticoPersonagem==0){
                        danoCausadoPersonagem=0;
                      }
                      vidaBarraInimigo = vidaBarraInimigo - danoCausadoPersonagem;
                      estaminaBarraBatalha = estaminaBarraBatalha - 20;
                      if(vidaBarraInimigo<0){
                            vidaBarraInimigo=0;
                            salvarDados();
                       }
                      salvarDados();
                   }
                   if(contGeralAtaque==4){
                      furiaBrutal();
                      if(danoCriticoPersonagem==0){
                        danoCausadoPersonagem=0;
                      }
                      vidaBarraInimigo = vidaBarraInimigo - danoCausadoPersonagem;
                      estaminaBarraBatalha = estaminaBarraBatalha - 50;
                      if(vidaBarraInimigo<0){
                            vidaBarraInimigo=0;
                            salvarDados();
                       }
                      salvarDados();
                   }
                   if(contGeralAtaque==5){
                        percepcao();
                        if(danoCriticoPersonagem==0){
                          danoCausadoPersonagem=0;
                        }
                        salvarDados();
                   }
                   if(contGeralAtaque==6){
                       recuperarstamina();
                       if(danoCriticoPersonagem==0){
                          danoCausadoPersonagem=0;
                        }
                       salvarDados();
                    }
               }
               
               if(contGeralAtaque==5){
                for(int cont = 0; cont<Historia2.length(); cont++){
                try {
                     textoHistoria2.setText(textoHistoria2.getText() + Historia2.charAt(cont));
                     delayAtaquePersonagemBerserk.sleep(50);
                 }catch (InterruptedException ex) {
                     Logger.getLogger(telaCarregamento.class.getName()).log(Level.SEVERE, null, ex);
                  }
                }
                try {
                delayAtaquePersonagemBerserk.sleep(1000);
                } catch (InterruptedException ex) {
                     Logger.getLogger(telaBatalha.class.getName()).log(Level.SEVERE, null, ex);
                }
                textoHistoria1.setText("");
                textoHistoria2.setText("");
                textoHistoria3.setText("");
                if(Historia3.equals("")) {
                    vitoria();
                    delayAtaqueInimigo(); 
                    }
                else{
                    for(int cont = 0; cont<Historia3.length(); cont++){
                        try {
                            textoHistoria2.setText(textoHistoria2.getText() + Historia3.charAt(cont));
                            delayAtaquePersonagemBerserk.sleep(50);
                        }catch (InterruptedException ex) {
                            Logger.getLogger(telaCarregamento.class.getName()).log(Level.SEVERE, null, ex);
                            }   
                        }   
                         try {
                             delayAtaquePersonagemBerserk.sleep(1000); 
                         }catch (InterruptedException ex) {
                             Logger.getLogger(telaBatalha.class.getName()).log(Level.SEVERE, null, ex);
                         }
                         vitoria();
                         delayAtaqueInimigo(); 
                    }
                 }
                 else{
                     try {
                         delayAtaquePersonagemBerserk.sleep(1000);
                     } catch (InterruptedException ex) {
                         Logger.getLogger(telaBatalha.class.getName()).log(Level.SEVERE, null, ex);
                     }
                     vitoria();
                     if(vidaBarraInimigo>0){
                          delayAtaqueInimigo(); 
                     }
                }
               
            }
        };
        delayAtaquePersonagemBerserk.start();
    }
    private void delayAtaquePersonagemArqueira(){
        textoHistoria1.setText("");
        textoHistoria2.setText("");
        textoHistoria3.setText("");
        textoHistoria2.setVisible(true);
        contGeral = 1;
        delayAtaqueInimigo.interrupt();
        delayAtaquePersonagemArqueira = new Thread(){
            
            public void run(){
                botaoAtaque1.setEnabled(false);
                botaoAtaque2.setEnabled(false);
                botaoAtaque3.setEnabled(false);
                botaoAtaque4.setEnabled(false);
                botaoAtaque5.setEnabled(false);
                botaoAtaque6.setEnabled(false);
                textoHistoria1.setText("");
                textoHistoria2.setText("");
                textoHistoria3.setText("");
                if(contGeralAtaque==2){
                    flechaDeGelo();
                }
                if(contAtordoamento==0){
                    for(int cont = 0; cont<Historia1.length(); cont++){
                        try {
                             textoHistoria2.setText(textoHistoria2.getText() + Historia1.charAt(cont));
                             delayAtaquePersonagemArqueira.sleep(50);
                        } catch (InterruptedException ex) {
                             Logger.getLogger(telaCarregamento.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    estaminaBarraBatalha=estaminaBarraBatalha-15;
                    salvarDados();
                    try {
                         delayAtaquePersonagemArqueira.sleep(1000);
                        } catch (InterruptedException ex) {
                             Logger.getLogger(telaBatalha.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    delayAtaqueInimigo();
                    }
                    if(contAtordoamento==1){
                            for(int cont = 0; cont<Historia1.length(); cont++){
                                try {
                                    textoHistoria2.setText(textoHistoria2.getText() + Historia1.charAt(cont));
                                    delayAtaquePersonagemArqueira.sleep(50);
                                } catch (InterruptedException ex) {
                                     Logger.getLogger(telaCarregamento.class.getName()).log(Level.SEVERE, null, ex);
                                }
                             }
                            try {
                                delayAtaquePersonagemArqueira.sleep(1000);
                            } catch (InterruptedException ex) {
                                 Logger.getLogger(telaBatalha.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            contGeralAtaque=0;
                            contAtordoamento=5;
                            textoHistoria2.setText("");
                            Historia1="";
                            geradorDanoPersonagem();
                             for(int cont = 0; cont<Historia1.length(); cont++){
                                try {
                                textoHistoria2.setText(textoHistoria2.getText() + Historia1.charAt(cont));
                                    delayAtaquePersonagemArqueira.sleep(50);
                                } catch (InterruptedException ex) {
                                        Logger.getLogger(telaCarregamento.class.getName()).log(Level.SEVERE, null, ex);
                                }
                             }
                            danoCausadoPersonagem=danoCausadoPersonagem+5+pontos[2];
                            if(danoCriticoPersonagem==0){
                                danoCausadoPersonagem=0;
                            }
                            vidaBarraInimigo=vidaBarraInimigo-danoCausadoPersonagem;
                            estaminaBarraBatalha=estaminaBarraBatalha-10;
                            salvarDados();
                            try {
                                    delayAtaquePersonagemArqueira.sleep(1000);
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(telaCarregamento.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            delayAtaquePersonagemArqueira();
                            delayAtaquePersonagemArqueira.stop();
                        }
                    if(contAtordoamento==5){
                        textoHistoria1.setText("");
                        textoHistoria2.setText("");
                        textoHistoria3.setText("");
                        if(contGeralAtaque==1||contGeralAtaque==2||contGeralAtaque==3||contGeralAtaque==4||contGeralAtaque==0){
                            geradorDanoPersonagem();
                        }
                        if(contGeralAtaque==5||contGeralAtaque==6){
                            Historia1="";
                        }
                        if(contGeralAtaque==6){
                            if(estaminaBarraBatalha==estaminaBarraTotal){
                                Historia1="Sua estamina está cheia, por tanto você desperdiçou uma rodada";
                            }
                            else{
                                Historia1="Você recuperou 20 de ST";
                            }
                            recuperarstamina();
                            salvarDados();
                        }
                        for(int cont = 0; cont<Historia1.length(); cont++){
                            try {
                                 textoHistoria2.setText(textoHistoria2.getText() + Historia1.charAt(cont));
                                 delayAtaquePersonagemArqueira.sleep(50);
                            } catch (InterruptedException ex) {
                                 Logger.getLogger(telaCarregamento.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        if(contGeralAtaque==1){
                            tiroRapido();
                            estaminaBarraBatalha=estaminaBarraBatalha-5;
                            salvarDados();
                        }
                        if(contGeralAtaque==2||contGeralAtaque==0){
                            danoCausadoPersonagem=danoCausadoPersonagem+10+pontos[2];
                        }
                        if(contGeralAtaque==3){
                            chuvaDeFlechas();
                            estaminaBarraBatalha=estaminaBarraBatalha-20;
                            salvarDados();
                        }
                        if(contGeralAtaque==4){
                            tiroFurtivo();
                            estaminaBarraBatalha=estaminaBarraBatalha-10;
                            salvarDados();
                        }
                        if(contGeralAtaque==5){       
                        for(int cont = 0; cont<Historia2.length(); cont++){
                            try {
                                 textoHistoria2.setText(textoHistoria2.getText() + Historia2.charAt(cont));
                                 delayAtaquePersonagemArqueira.sleep(50);
                             }catch (InterruptedException ex) {
                                 Logger.getLogger(telaCarregamento.class.getName()).log(Level.SEVERE, null, ex);
                               }
                            }
                            try {
                                delayAtaquePersonagemArqueira.sleep(1000);
                            }catch (InterruptedException ex) {
                                 Logger.getLogger(telaBatalha.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            textoHistoria1.setText("");
                            textoHistoria2.setText("");
                            textoHistoria3.setText("");
                            if(Historia3.equals("")) {
                                vitoria();
                                delayAtaqueInimigo(); 
                            }
                            else{
                                for(int cont = 0; cont<Historia3.length(); cont++){
                                    try {
                                        textoHistoria2.setText(textoHistoria2.getText() + Historia3.charAt(cont));
                                        delayAtaquePersonagemArqueira.sleep(50);
                                    }catch (InterruptedException ex) {
                                        Logger.getLogger(telaCarregamento.class.getName()).log(Level.SEVERE, null, ex);
                                        }   
                                    }   
                                     try {
                                         delayAtaquePersonagemArqueira.sleep(1000); 
                                     }catch (InterruptedException ex) {
                                         Logger.getLogger(telaBatalha.class.getName()).log(Level.SEVERE, null, ex);
                                     }
                                     vitoria();
                                }
                        }
                        if(danoCriticoPersonagem==0||contGeralAtaque==5||contGeralAtaque==6){
                                danoCausadoPersonagem=0;
                        }
                        vidaBarraInimigo=vidaBarraInimigo-danoCausadoPersonagem;
                        salvarDados();
                        try {
                                delayAtaquePersonagemArqueira.sleep(1000);
                            } catch (InterruptedException ex) {
                                 Logger.getLogger(telaCarregamento.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        vitoria();
                        delayAtaqueInimigo(); 
                        salvarDados();
               }
               if(contGeralAtaque==2){
                    if(vidaBarraInimigo<0){
                        vidaBarraInimigo=0;
                    salvarDados();
                    }
                    contAtordoamento=5;
                    contGeralAtaque=0;
                    salvarDados();
               }
       
            }
        };
        delayAtaquePersonagemArqueira.start();
        }
    private void delayAtaqueInimigo(){
        textoHistoria2.setVisible(true);
        contGeral = 1;
        delayAtaquePersonagemBerserk.interrupt();
        delayAtaquePersonagemArqueira.interrupt();
        delayAtaqueInimigo = new Thread(){
            
            public void run(){
                textoHistoria1.setText("");
                textoHistoria2.setText("");
                textoHistoria3.setText("");
                if(vidaBarraInimigo>0){
                    geradorDanoInimigo();
                }
                for(int cont = 0; cont<Historia2.length(); cont++){
                    try {
                        textoHistoria2.setText(textoHistoria2.getText() + Historia2.charAt(cont));
                        delayAtaqueInimigo.sleep(50);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(telaCarregamento.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                vidaBarraPersonagem = vidaBarraPersonagem - danoCausadoInimigo;
                salvarDados();
                try {
                    delayAtaqueInimigo.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(telaBatalha.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(contGeralAtaque==5||contGeralAtaque==6){
                    contGeralAtaque=0;
                    delayAtaqueInimigo();
                    botaoAtaque1.setEnabled(false);
                    botaoAtaque2.setEnabled(false);
                    botaoAtaque3.setEnabled(false);
                    botaoAtaque4.setEnabled(false);
                    botaoAtaque5.setEnabled(false);
                    botaoAtaque6.setEnabled(false);
                    sair.setEnabled(false);
                    abrirConfiguracoes.setEnabled(false);
                    textoHistoria1.setText("");
                    textoHistoria2.setText("");
                    textoHistoria3.setText("");
                }
                else{
                    botaoAtaque1.setEnabled(true);
                    botaoAtaque2.setEnabled(true);
                    botaoAtaque3.setEnabled(true);
                    botaoAtaque4.setEnabled(true);
                    if(contPercepcao==1){
                        botaoAtaque5.setEnabled(false);
                    }
                    else{
                        botaoAtaque5.setEnabled(true);
                    }
                    botaoAtaque6.setEnabled(true);
                    sair.setEnabled(true);
                    abrirConfiguracoes.setEnabled(true);
                    textoHistoria1.setText("");
                    textoHistoria2.setText("");
                    textoHistoria3.setText("");
                }
                delayAtaquePersonagemBerserk.stop();
            }
        };
        delayAtaqueInimigo.start();
        
    }
    
    private void geradorDanoPersonagem(){
        danoCausadoPersonagem = geradorDanoPersonagem.nextInt(10);
        danoCriticoPersonagem = geradorCriticoPersonagem.nextInt(6);
        
        if(contAumentarCritico==50){
            danoCriticoPersonagem=3+danoCriticoPersonagem;
        }
        if(contAumentarCritico==100){
            danoCriticoPersonagem=6;
        }
        
        if(danoCriticoPersonagem == 0){
            danoCausadoPersonagem = 0;
            Historia1="Você infelizmente errou o ataque";
            salvarDados();
        }
        else{
            if(danoCriticoPersonagem >= 1 && danoCriticoPersonagem <= 3){
                Historia1="Você acerta o ataque";
                salvarDados();
            }
            else{
                if(danoCriticoPersonagem >= 4 && danoCriticoPersonagem <= 6){
                    danoCausadoPersonagem = danoCausadoPersonagem*2;
                    Historia1="Você acertou um ataque crítico!";
                    salvarDados();
                }
            }
        }
    }
    private void geradorDanoInimigo(){  
        danoCausadoInimigo = geradorDanoInimigo.nextInt(5);
        danoCriticoInimigo = geradorCriticoInimigo.nextInt(6);
        if(danoCriticoInimigo == 0){
            danoCausadoInimigo = 0;
            Historia2="O inimigo tenta te atacar, mas erra";
            salvarDados();
        }
        if(danoCriticoInimigo>=1 && danoCriticoInimigo<=3){
            danoCausadoInimigo=5;
            Historia2="O inimigo te atacou";
            salvarDados();
        }
        if(danoCriticoInimigo >= 4 && danoCriticoInimigo <= 6){
            danoCausadoInimigo = 5*2;
            Historia2="O inimigo te acerta um ataque em um ponto crítico";
            salvarDados();
        }
        textoHistoria2.setVisible(true);
    }
    
    private void ataqueNormal(){
        danoCausadoPersonagem = danoCausadoPersonagem + 10 + pontos[0];
        salvarDados();
    }
    private void gritoFuria(){
       salvarDados();
    }
    private void golpeAniquilador(){
       danoCausadoPersonagem = danoCausadoPersonagem + 20 + pontos[0];
       salvarDados();
    }
    private void furiaBrutal(){
       danoCausadoPersonagem = danoCausadoPersonagem + (pontos[0]*2);
       salvarDados();
    }
    
    private void tiroRapido(){
        danoCausadoPersonagem = danoCausadoPersonagem + 10 + pontos[2];
        salvarDados();
    }
    private void flechaDeGelo(){
        sorte = geradorSorte.nextInt(100);
        if(sorte>90){
          Historia1="Você atordoa o inimigo e agora pode atacar mais uma vez";
          contAtordoamento=1;
        }
        else{
          Historia1="Você infelizmente não atordoou o inimigo";
          contAtordoamento=0;
        }
        salvarDados();
    }
    private void chuvaDeFlechas(){
        danoCausadoPersonagem = danoCausadoPersonagem + 20 + pontos[2];
        salvarDados();
    }
    private void tiroFurtivo(){
        if(pontos[2]>=25){
            danoCausadoPersonagem = danoCausadoPersonagem + 30;
        }
        if(pontos[2]>=20 && pontos[2]<25){
            danoCausadoPersonagem = danoCausadoPersonagem + 25;
        }
        if(pontos[2]>=15 && pontos[2]<20){
            danoCausadoPersonagem = danoCausadoPersonagem + 20;
        }
        if(pontos[2]>=10 && pontos[2]<15){
            danoCausadoPersonagem = danoCausadoPersonagem + 15;
        }
        if(pontos[2]>=5 && pontos[2]<10){
            danoCausadoPersonagem = danoCausadoPersonagem + 10;
        }
        if(pontos[2]>=0 && pontos[2]<5){
            danoCausadoPersonagem = danoCausadoPersonagem + 5;
        }
    }    
    
    private void percepcao(){
        estaminaBarraBatalha = estaminaBarraBatalha - 15;
        salvarDados();

    }
    private void recuperarstamina(){
        if(estaminaBarraBatalha < estaminaBarraTotal){
            estaminaBarraBatalha=estaminaBarraBatalha+20;
            if(estaminaBarraBatalha > estaminaBarraTotal){
                estaminaBarraBatalha = estaminaBarraTotal;
            }
        }
        salvarDados();

    }
            
    public telaBatalha() {
        
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
        lerSalvamento();
        salvarDados();
        adm();
        
        telaInformacaoChamar = new telaInformacao();
        telaConfiguracaoChamar = new telaConfiguracao();
        telaInformacaoChamar.setVisible(false);
        telaConfiguracaoChamar.setVisible(false);
        
        textoHistoria1.setVisible(false);
        textoHistoria2.setVisible(false);
        textoHistoria3.setVisible(false);
        
        painelAtaqueDetalhe.setVisible(false);
        
        painelVitoria.setVisible(false);
        continuar.setEnabled(false);
        botaoAtaque1.setEnabled(true);
        botaoAtaque2.setEnabled(true);
        botaoAtaque3.setEnabled(true);
        botaoAtaque4.setEnabled(true);
        botaoAtaque5.setEnabled(true);
        botaoAtaque6.setEnabled(true);
        sair.setEnabled(true);
        abrirConfiguracoes.setEnabled(true);
        
        msgVitoria2.setText(""); 
        msgVitoria4.setText("");
        msgVitoria5.setText("");
        msgVitoria6.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelVitoria = new javax.swing.JPanel();
        continuar = new javax.swing.JButton();
        msgVitoria6 = new javax.swing.JLabel();
        msgVitoria5 = new javax.swing.JLabel();
        msgVitoria4 = new javax.swing.JLabel();
        msgVitoria3 = new javax.swing.JLabel();
        msgVitoria2 = new javax.swing.JLabel();
        msgVitoria1 = new javax.swing.JLabel();
        msgVitoria = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        painelADM = new javax.swing.JPanel();
        admMatar = new javax.swing.JButton();
        admVida = new javax.swing.JButton();
        painelAtaqueDetalhe = new javax.swing.JPanel();
        labelNomeAtaque = new javax.swing.JLabel();
        labelAtaqueDescricao1 = new javax.swing.JLabel();
        labelAtaqueDescricao2 = new javax.swing.JLabel();
        labelAtaqueDescricao3 = new javax.swing.JLabel();
        painelMenu = new javax.swing.JPanel();
        abrirConfiguracoes = new javax.swing.JButton();
        sair = new javax.swing.JButton();
        painelMensagem = new javax.swing.JPanel();
        textoHistoria1 = new javax.swing.JLabel();
        textoHistoria2 = new javax.swing.JLabel();
        textoHistoria3 = new javax.swing.JLabel();
        painelBotoes = new javax.swing.JPanel();
        botaoAtaque1 = new javax.swing.JButton();
        botaoAtaque3 = new javax.swing.JButton();
        botaoAtaque5 = new javax.swing.JButton();
        botaoAtaque2 = new javax.swing.JButton();
        botaoAtaque4 = new javax.swing.JButton();
        botaoAtaque6 = new javax.swing.JButton();
        labelAtaque1 = new javax.swing.JLabel();
        labelAtaque2 = new javax.swing.JLabel();
        labelAtaque3 = new javax.swing.JLabel();
        labelAtaque4 = new javax.swing.JLabel();
        labelAtaque5 = new javax.swing.JLabel();
        labelAtaque6 = new javax.swing.JLabel();
        painelPersonagem = new javax.swing.JPanel();
        avatarPersonagem = new javax.swing.JLabel();
        bordaPersonagem = new javax.swing.JLabel();
        exibirNome = new javax.swing.JLabel();
        exibirClasse = new javax.swing.JLabel();
        textoLevelPersonagem = new javax.swing.JLabel();
        exibirEstaminaStatus = new javax.swing.JLabel();
        exibirVidaStatus = new javax.swing.JLabel();
        textoST = new javax.swing.JLabel();
        exibirEstamina = new javax.swing.JProgressBar();
        textoVida = new javax.swing.JLabel();
        exibirVida = new javax.swing.JProgressBar();
        painelInimigo = new javax.swing.JPanel();
        avatarInimigo = new javax.swing.JLabel();
        bordaInimigo = new javax.swing.JLabel();
        textoLevelInimigo = new javax.swing.JLabel();
        exibirNomeInimigo = new javax.swing.JLabel();
        exibirClasseInimigo = new javax.swing.JLabel();
        exibirVidaStatusInimigo = new javax.swing.JLabel();
        textoVida2 = new javax.swing.JLabel();
        exibirVidaInimigo = new javax.swing.JProgressBar();
        fundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setUndecorated(true);
        setSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        painelVitoria.setBackground(new java.awt.Color(222, 222, 222));
        painelVitoria.setFocusable(false);
        painelVitoria.setOpaque(false);
        painelVitoria.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        continuar.setFont(new java.awt.Font("Dubai Medium", 1, 36)); // NOI18N
        continuar.setForeground(new java.awt.Color(60, 60, 60));
        continuar.setText("Continuar");
        continuar.setBorder(null);
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
        painelVitoria.add(continuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 390, 260, 40));

        msgVitoria6.setFont(new java.awt.Font("Imprint MT Shadow", 1, 20)); // NOI18N
        msgVitoria6.setForeground(new java.awt.Color(60, 60, 60));
        msgVitoria6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        painelVitoria.add(msgVitoria6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, 530, 30));

        msgVitoria5.setFont(new java.awt.Font("Imprint MT Shadow", 1, 20)); // NOI18N
        msgVitoria5.setForeground(new java.awt.Color(60, 60, 60));
        msgVitoria5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        painelVitoria.add(msgVitoria5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 580, 30));

        msgVitoria4.setFont(new java.awt.Font("Imprint MT Shadow", 1, 20)); // NOI18N
        msgVitoria4.setForeground(new java.awt.Color(60, 60, 60));
        msgVitoria4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        painelVitoria.add(msgVitoria4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 560, 30));

        msgVitoria3.setFont(new java.awt.Font("Ink Free", 0, 18)); // NOI18N
        msgVitoria3.setForeground(new java.awt.Color(60, 60, 60));
        msgVitoria3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        msgVitoria3.setText("e ganhou...");
        painelVitoria.add(msgVitoria3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 510, 40));

        msgVitoria2.setFont(new java.awt.Font("AngryBirds", 1, 18)); // NOI18N
        msgVitoria2.setForeground(new java.awt.Color(60, 60, 60));
        msgVitoria2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        painelVitoria.add(msgVitoria2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 170, 260, 30));

        msgVitoria1.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        msgVitoria1.setForeground(new java.awt.Color(60, 60, 60));
        msgVitoria1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        msgVitoria1.setText("Você derrotou ");
        painelVitoria.add(msgVitoria1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 250, 30));

        msgVitoria.setFont(new java.awt.Font("HACKED", 1, 68)); // NOI18N
        msgVitoria.setForeground(new java.awt.Color(60, 60, 60));
        msgVitoria.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        msgVitoria.setText("Vitoria");
        painelVitoria.add(msgVitoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 650, 100));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/telaVitoria.png"))); // NOI18N
        painelVitoria.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 460));

        getContentPane().add(painelVitoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 840, 460));

        painelADM.setDoubleBuffered(false);
        painelADM.setFocusable(false);
        painelADM.setOpaque(false);
        painelADM.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        admMatar.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        admMatar.setForeground(new java.awt.Color(60, 60, 60));
        admMatar.setText("Matar Inimigo");
        admMatar.setBorder(null);
        admMatar.setBorderPainted(false);
        admMatar.setContentAreaFilled(false);
        admMatar.setFocusable(false);
        admMatar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admMatarActionPerformed(evt);
            }
        });
        painelADM.add(admMatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 100, -1));

        admVida.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        admVida.setForeground(new java.awt.Color(60, 60, 60));
        admVida.setText("Recuperar Vida");
        admVida.setBorder(null);
        admVida.setBorderPainted(false);
        admVida.setContentAreaFilled(false);
        admVida.setFocusable(false);
        admVida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admVidaActionPerformed(evt);
            }
        });
        painelADM.add(admVida, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 100, -1));

        getContentPane().add(painelADM, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, 200, 60));

        painelAtaqueDetalhe.setFocusable(false);
        painelAtaqueDetalhe.setOpaque(false);
        painelAtaqueDetalhe.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelNomeAtaque.setFont(new java.awt.Font("Javanese Text", 1, 18)); // NOI18N
        labelNomeAtaque.setForeground(new java.awt.Color(60, 60, 60));
        labelNomeAtaque.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNomeAtaque.setText("Ataque");
        painelAtaqueDetalhe.add(labelNomeAtaque, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 260, 30));

        labelAtaqueDescricao1.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        labelAtaqueDescricao1.setForeground(new java.awt.Color(60, 60, 60));
        labelAtaqueDescricao1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAtaqueDescricao1.setText("Descricao");
        painelAtaqueDetalhe.add(labelAtaqueDescricao1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 260, 30));

        labelAtaqueDescricao2.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        labelAtaqueDescricao2.setForeground(new java.awt.Color(60, 60, 60));
        labelAtaqueDescricao2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAtaqueDescricao2.setText("Descricao");
        painelAtaqueDetalhe.add(labelAtaqueDescricao2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 260, 30));

        labelAtaqueDescricao3.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        labelAtaqueDescricao3.setForeground(new java.awt.Color(60, 60, 60));
        labelAtaqueDescricao3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAtaqueDescricao3.setText("Descricao");
        painelAtaqueDetalhe.add(labelAtaqueDescricao3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 260, 30));

        getContentPane().add(painelAtaqueDetalhe, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 480, 320, 150));

        painelMenu.setOpaque(false);
        painelMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        abrirConfiguracoes.setBackground(new java.awt.Color(172, 172, 172));
        abrirConfiguracoes.setFont(new java.awt.Font("Impact", 0, 30)); // NOI18N
        abrirConfiguracoes.setForeground(new java.awt.Color(60, 60, 60));
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
        painelMenu.add(abrirConfiguracoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 210, -1));

        sair.setBackground(new java.awt.Color(172, 172, 172));
        sair.setFont(new java.awt.Font("Ink Free", 0, 36)); // NOI18N
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
        painelMenu.add(sair, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 100, -1));

        getContentPane().add(painelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 590, 280, 130));

        painelMensagem.setBackground(new java.awt.Color(0, 0, 0));
        painelMensagem.setOpaque(false);
        painelMensagem.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textoHistoria1.setFont(new java.awt.Font("Dubai Medium", 0, 24)); // NOI18N
        textoHistoria1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        painelMensagem.add(textoHistoria1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 1260, 30));

        textoHistoria2.setFont(new java.awt.Font("Dubai Medium", 0, 36)); // NOI18N
        textoHistoria2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        painelMensagem.add(textoHistoria2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 1260, 60));

        textoHistoria3.setFont(new java.awt.Font("Dubai Medium", 0, 24)); // NOI18N
        textoHistoria3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        painelMensagem.add(textoHistoria3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 1260, 30));

        getContentPane().add(painelMensagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 1280, 200));

        painelBotoes.setOpaque(false);
        painelBotoes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botaoAtaque1.setFont(new java.awt.Font("Dubai Medium", 0, 24)); // NOI18N
        botaoAtaque1.setBorderPainted(false);
        botaoAtaque1.setContentAreaFilled(false);
        botaoAtaque1.setFocusable(false);
        botaoAtaque1.setPreferredSize(new java.awt.Dimension(150, 40));
        botaoAtaque1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botaoAtaque1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botaoAtaque1MouseExited(evt);
            }
        });
        botaoAtaque1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAtaque1ActionPerformed(evt);
            }
        });
        painelBotoes.add(botaoAtaque1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 240, -1));

        botaoAtaque3.setFont(new java.awt.Font("Dubai Medium", 0, 24)); // NOI18N
        botaoAtaque3.setBorderPainted(false);
        botaoAtaque3.setContentAreaFilled(false);
        botaoAtaque3.setFocusable(false);
        botaoAtaque3.setPreferredSize(new java.awt.Dimension(150, 40));
        botaoAtaque3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botaoAtaque3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botaoAtaque3MouseExited(evt);
            }
        });
        botaoAtaque3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAtaque3ActionPerformed(evt);
            }
        });
        painelBotoes.add(botaoAtaque3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 240, -1));

        botaoAtaque5.setFont(new java.awt.Font("Dubai Medium", 0, 24)); // NOI18N
        botaoAtaque5.setBorderPainted(false);
        botaoAtaque5.setContentAreaFilled(false);
        botaoAtaque5.setFocusable(false);
        botaoAtaque5.setPreferredSize(new java.awt.Dimension(150, 40));
        botaoAtaque5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botaoAtaque5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botaoAtaque5MouseExited(evt);
            }
        });
        botaoAtaque5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAtaque5ActionPerformed(evt);
            }
        });
        painelBotoes.add(botaoAtaque5, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 40, 230, -1));

        botaoAtaque2.setFont(new java.awt.Font("Dubai Medium", 0, 24)); // NOI18N
        botaoAtaque2.setBorderPainted(false);
        botaoAtaque2.setContentAreaFilled(false);
        botaoAtaque2.setFocusable(false);
        botaoAtaque2.setPreferredSize(new java.awt.Dimension(150, 40));
        botaoAtaque2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botaoAtaque2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botaoAtaque2MouseExited(evt);
            }
        });
        botaoAtaque2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAtaque2ActionPerformed(evt);
            }
        });
        painelBotoes.add(botaoAtaque2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 240, -1));

        botaoAtaque4.setFont(new java.awt.Font("Dubai Medium", 0, 24)); // NOI18N
        botaoAtaque4.setBorderPainted(false);
        botaoAtaque4.setContentAreaFilled(false);
        botaoAtaque4.setFocusable(false);
        botaoAtaque4.setPreferredSize(new java.awt.Dimension(150, 40));
        botaoAtaque4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botaoAtaque4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botaoAtaque4MouseExited(evt);
            }
        });
        botaoAtaque4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAtaque4ActionPerformed(evt);
            }
        });
        painelBotoes.add(botaoAtaque4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, 240, -1));

        botaoAtaque6.setFont(new java.awt.Font("Dubai Medium", 0, 24)); // NOI18N
        botaoAtaque6.setBorderPainted(false);
        botaoAtaque6.setContentAreaFilled(false);
        botaoAtaque6.setFocusable(false);
        botaoAtaque6.setPreferredSize(new java.awt.Dimension(150, 40));
        botaoAtaque6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botaoAtaque6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botaoAtaque6MouseExited(evt);
            }
        });
        botaoAtaque6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAtaque6ActionPerformed(evt);
            }
        });
        painelBotoes.add(botaoAtaque6, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 160, 230, -1));

        labelAtaque1.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        labelAtaque1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAtaque1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelAtaque1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelAtaque1MouseExited(evt);
            }
        });
        painelBotoes.add(labelAtaque1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 230, 40));

        labelAtaque2.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        labelAtaque2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAtaque2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelAtaque2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelAtaque2MouseExited(evt);
            }
        });
        painelBotoes.add(labelAtaque2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, 230, 40));

        labelAtaque3.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        labelAtaque3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAtaque3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelAtaque3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelAtaque3MouseExited(evt);
            }
        });
        painelBotoes.add(labelAtaque3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 90, 210, 40));

        labelAtaque4.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        labelAtaque4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAtaque4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelAtaque4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelAtaque4MouseExited(evt);
            }
        });
        painelBotoes.add(labelAtaque4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 230, 30));

        labelAtaque5.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        labelAtaque5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAtaque5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelAtaque5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelAtaque5MouseExited(evt);
            }
        });
        painelBotoes.add(labelAtaque5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, 250, 40));

        labelAtaque6.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        labelAtaque6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAtaque6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelAtaque6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelAtaque6MouseExited(evt);
            }
        });
        painelBotoes.add(labelAtaque6, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 200, 240, 40));

        getContentPane().add(painelBotoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 460, 840, 250));

        painelPersonagem.setOpaque(false);
        painelPersonagem.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        painelPersonagem.add(avatarPersonagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 100));

        bordaPersonagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/bordaHistoria.png"))); // NOI18N
        painelPersonagem.add(bordaPersonagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 8, 110, 110));

        exibirNome.setFont(new java.awt.Font("Freshman", 0, 20)); // NOI18N
        exibirNome.setText("Nome");
        painelPersonagem.add(exibirNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 320, 30));

        exibirClasse.setFont(new java.awt.Font("MV Boli", 0, 16)); // NOI18N
        exibirClasse.setText("Classe");
        painelPersonagem.add(exibirClasse, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 80, -1));

        textoLevelPersonagem.setFont(new java.awt.Font("MV Boli", 0, 16)); // NOI18N
        textoLevelPersonagem.setText("Level: ");
        painelPersonagem.add(textoLevelPersonagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 211, -1));

        exibirEstaminaStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exibirEstaminaStatus.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        exibirEstaminaStatus.setMaximumSize(new java.awt.Dimension(170, 17));
        exibirEstaminaStatus.setMinimumSize(new java.awt.Dimension(170, 17));
        exibirEstaminaStatus.setPreferredSize(new java.awt.Dimension(170, 17));
        painelPersonagem.add(exibirEstaminaStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 170, 17));

        exibirVidaStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exibirVidaStatus.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        exibirVidaStatus.setMaximumSize(new java.awt.Dimension(170, 17));
        exibirVidaStatus.setMinimumSize(new java.awt.Dimension(170, 17));
        exibirVidaStatus.setPreferredSize(new java.awt.Dimension(170, 17));
        painelPersonagem.add(exibirVidaStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 170, 17));

        textoST.setText("ST");
        painelPersonagem.add(textoST, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, -1, -1));

        exibirEstamina.setBackground(new java.awt.Color(156, 156, 156));
        exibirEstamina.setForeground(new java.awt.Color(181, 196, 0));
        exibirEstamina.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        exibirEstamina.setMaximumSize(new java.awt.Dimension(170, 15));
        exibirEstamina.setMinimumSize(new java.awt.Dimension(170, 15));
        exibirEstamina.setPreferredSize(new java.awt.Dimension(170, 15));
        painelPersonagem.add(exibirEstamina, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, -1, -1));

        textoVida.setText(" HP");
        painelPersonagem.add(textoVida, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, -1, -1));

        exibirVida.setBackground(new java.awt.Color(156, 156, 156));
        exibirVida.setForeground(new java.awt.Color(175, 30, 30));
        exibirVida.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        exibirVida.setMaximumSize(new java.awt.Dimension(170, 17));
        exibirVida.setMinimumSize(new java.awt.Dimension(170, 17));
        exibirVida.setPreferredSize(new java.awt.Dimension(170, 17));
        painelPersonagem.add(exibirVida, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, -1, -1));

        getContentPane().add(painelPersonagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 120));

        painelInimigo.setOpaque(false);
        painelInimigo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        painelInimigo.add(avatarInimigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 100, 100));

        bordaInimigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/bordaHistoria.png"))); // NOI18N
        painelInimigo.add(bordaInimigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 8, -1, -1));

        textoLevelInimigo.setFont(new java.awt.Font("MV Boli", 0, 16)); // NOI18N
        textoLevelInimigo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        textoLevelInimigo.setText("Level: ");
        painelInimigo.add(textoLevelInimigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 211, -1));

        exibirNomeInimigo.setFont(new java.awt.Font("Freshman", 0, 20)); // NOI18N
        exibirNomeInimigo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        exibirNomeInimigo.setText("Nome");
        painelInimigo.add(exibirNomeInimigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 320, 30));

        exibirClasseInimigo.setFont(new java.awt.Font("MV Boli", 0, 16)); // NOI18N
        exibirClasseInimigo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        exibirClasseInimigo.setText("Classe");
        painelInimigo.add(exibirClasseInimigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 100, -1));

        exibirVidaStatusInimigo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exibirVidaStatusInimigo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        exibirVidaStatusInimigo.setMaximumSize(new java.awt.Dimension(170, 17));
        exibirVidaStatusInimigo.setMinimumSize(new java.awt.Dimension(170, 17));
        exibirVidaStatusInimigo.setPreferredSize(new java.awt.Dimension(170, 17));
        painelInimigo.add(exibirVidaStatusInimigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 170, 17));

        textoVida2.setText(" HP");
        painelInimigo.add(textoVida2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, -1, -1));

        exibirVidaInimigo.setBackground(new java.awt.Color(156, 156, 156));
        exibirVidaInimigo.setForeground(new java.awt.Color(175, 30, 30));
        exibirVidaInimigo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        exibirVidaInimigo.setMaximumSize(new java.awt.Dimension(170, 17));
        exibirVidaInimigo.setMinimumSize(new java.awt.Dimension(170, 17));
        exibirVidaInimigo.setPreferredSize(new java.awt.Dimension(170, 17));
        painelInimigo.add(exibirVidaInimigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, -1, -1));

        getContentPane().add(painelInimigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 0, 490, 120));

        fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/telaBatalha.png"))); // NOI18N
        getContentPane().add(fundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sairMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sairMouseEntered
        sair.setForeground(new Color(172,172,172));
    }//GEN-LAST:event_sairMouseEntered

    private void sairMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sairMouseExited
        sair.setForeground(new Color(60,60,60));
    }//GEN-LAST:event_sairMouseExited

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        salvarDados();
        System.exit(0);
    }//GEN-LAST:event_sairActionPerformed

    private void abrirConfiguracoesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abrirConfiguracoesMouseEntered
        abrirConfiguracoes.setForeground(new Color(172,172,172));
    }//GEN-LAST:event_abrirConfiguracoesMouseEntered

    private void abrirConfiguracoesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abrirConfiguracoesMouseExited
        abrirConfiguracoes.setForeground(new Color(60,60,60));
    }//GEN-LAST:event_abrirConfiguracoesMouseExited

    private void abrirConfiguracoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirConfiguracoesActionPerformed
        telaConfiguracaoChamar.setVisible(true);
        salvarDados();
    }//GEN-LAST:event_abrirConfiguracoesActionPerformed

    private void botaoAtaque1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAtaque1ActionPerformed
        contGeralAtaque=1;
        delayAtaquePersonagemBerserk.stop();
        delayAtaqueInimigo.stop();
        if(classeEscolhida.equals("Berserk")){
            delayAtaquePersonagemBerserk();
        }
        if(classeEscolhida.equals("Arqueira")){
            delayAtaquePersonagemArqueira();
        }
    }//GEN-LAST:event_botaoAtaque1ActionPerformed

    private void botaoAtaque3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAtaque3ActionPerformed
        contGeralAtaque=3;
        delayAtaquePersonagemBerserk.stop();
        delayAtaqueInimigo.stop();
        if(classeEscolhida.equals("Berserk")){
            delayAtaquePersonagemBerserk();
        }
        if(classeEscolhida.equals("Arqueira")){
            delayAtaquePersonagemArqueira();
        }
    }//GEN-LAST:event_botaoAtaque3ActionPerformed

    private void botaoAtaque2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAtaque2ActionPerformed
        contGeralAtaque=2;
        delayAtaquePersonagemBerserk.stop();
        delayAtaqueInimigo.stop();
        if(classeEscolhida.equals("Berserk")){
            sorte = geradorSorte.nextInt(10);
            if(sorte>9){

               Historia1="O inimigo correu de você";
               vidaBarraInimigo=0;
               estaminaBarraBatalha = estaminaBarraBatalha - 20;
            }
            else{
               Historia1="O inimigo não se sente intimidado";
               estaminaBarraBatalha = estaminaBarraBatalha - 20;
            }
        delayAtaquePersonagemBerserk();
        }
        if(classeEscolhida.equals("Arqueira")){
            delayAtaquePersonagemArqueira();
        }
    }//GEN-LAST:event_botaoAtaque2ActionPerformed

    private void botaoAtaque4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAtaque4ActionPerformed
        contGeralAtaque=4;
        delayAtaquePersonagemBerserk.stop();
        delayAtaqueInimigo.stop();
        if(classeEscolhida.equals("Berserk")){
            delayAtaquePersonagemBerserk();
        }
        if(classeEscolhida.equals("Arqueira")){
            delayAtaquePersonagemArqueira();
        }
    }//GEN-LAST:event_botaoAtaque4ActionPerformed

    private void botaoAtaque5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAtaque5ActionPerformed
        contGeralAtaque=5;
        delayAtaquePersonagemBerserk.stop();
        delayAtaquePersonagemArqueira.stop();
        delayAtaqueInimigo.stop();
        sorte = geradorSorte.nextInt(100);
        if(sorte>=0 && sorte<50){
            Historia2="Você não percebe nada no campo que possa te ajudar"; 
            contAumentarCritico=0;
        }
        if(sorte>=50 && sorte<80){
            Historia2="Você percebe que o local onde o inimigo está é ruim para andar";
            Historia3="Sua chance de crítico agora é de 50%";
            contAumentarCritico=50;
        }
        if(sorte>=80 && sorte<=100){
            Historia2="Você percebe o calcanhar de aquiles do inimigo e sabe onde atacar";
            Historia3="Sua chance de crítico está em 100% agora";
            contAumentarCritico=100;
        }
        contPercepcao=1;
        if(classeEscolhida.equals("Berserk")){
            delayAtaquePersonagemBerserk();
        }
        if(classeEscolhida.equals("Arqueira")){
            delayAtaquePersonagemArqueira();
        }
    }//GEN-LAST:event_botaoAtaque5ActionPerformed

    private void botaoAtaque6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAtaque6ActionPerformed
        contGeralAtaque=6;
        delayAtaquePersonagemBerserk.stop();
        delayAtaquePersonagemArqueira.stop();
        delayAtaqueInimigo.stop();
        Historia1="Você recuperou 20 de ST";
        if(classeEscolhida.equals("Berserk")){
            delayAtaquePersonagemBerserk();
        }
        if(classeEscolhida.equals("Arqueira")){
            delayAtaquePersonagemArqueira();
        }
    }//GEN-LAST:event_botaoAtaque6ActionPerformed

    private void botaoAtaque1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoAtaque1MouseExited
        botaoAtaque1.setForeground(new Color(60,60,60));
    }//GEN-LAST:event_botaoAtaque1MouseExited

    private void botaoAtaque1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoAtaque1MouseEntered
        botaoAtaque1.setForeground(new Color(172,172,172));
    }//GEN-LAST:event_botaoAtaque1MouseEntered

    private void botaoAtaque3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoAtaque3MouseExited
        botaoAtaque3.setForeground(new Color(60,60,60));
    }//GEN-LAST:event_botaoAtaque3MouseExited

    private void botaoAtaque3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoAtaque3MouseEntered
        botaoAtaque3.setForeground(new Color(172,172,172));
    }//GEN-LAST:event_botaoAtaque3MouseEntered

    private void botaoAtaque5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoAtaque5MouseExited
        botaoAtaque5.setForeground(new Color(60,60,60));
    }//GEN-LAST:event_botaoAtaque5MouseExited

    private void botaoAtaque5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoAtaque5MouseEntered
        botaoAtaque5.setForeground(new Color(172,172,172));
    }//GEN-LAST:event_botaoAtaque5MouseEntered

    private void botaoAtaque2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoAtaque2MouseExited
        botaoAtaque2.setForeground(new Color(60,60,60));
    }//GEN-LAST:event_botaoAtaque2MouseExited

    private void botaoAtaque2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoAtaque2MouseEntered
        botaoAtaque2.setForeground(new Color(172,172,172));
    }//GEN-LAST:event_botaoAtaque2MouseEntered

    private void botaoAtaque4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoAtaque4MouseExited
        botaoAtaque4.setForeground(new Color(60,60,60));
    }//GEN-LAST:event_botaoAtaque4MouseExited

    private void botaoAtaque4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoAtaque4MouseEntered
        botaoAtaque4.setForeground(new Color(172,172,172));
    }//GEN-LAST:event_botaoAtaque4MouseEntered

    private void botaoAtaque6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoAtaque6MouseExited
        botaoAtaque6.setForeground(new Color(60,60,60));
    }//GEN-LAST:event_botaoAtaque6MouseExited

    private void botaoAtaque6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoAtaque6MouseEntered
        botaoAtaque6.setForeground(new Color(172,172,172));
    }//GEN-LAST:event_botaoAtaque6MouseEntered

    private void continuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continuarActionPerformed
        if(contHistoria<2){
            this.setVisible(false);
        }else{
            this.setVisible(false);
            this.setMenu(new telaMenu(this,true,name));
            this.getMenu().setVisible(true);
        }
    }//GEN-LAST:event_continuarActionPerformed

    private void labelAtaque1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAtaque1MouseEntered
        painelAtaqueDetalhe.setVisible(true);
        
        if("Arqueira".equals(classeEscolhida)){
        }
        if("Berserk".equals(classeEscolhida)){
            labelNomeAtaque.setText("Ataque Normal");
            labelAtaqueDescricao1.setText("Efetua um...");
            labelAtaqueDescricao2.setText("");
            labelAtaqueDescricao3.setText(""); 
        }
        if("Mago".equals(classeEscolhida)){
        }
        if("Assassina".equals(classeEscolhida)){
        }
        if("Cavaleiro".equals(classeEscolhida)){
        } 
    }//GEN-LAST:event_labelAtaque1MouseEntered

    private void labelAtaque1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAtaque1MouseExited
        painelAtaqueDetalhe.setVisible(false);
        labelNomeAtaque.setText("");
        labelAtaqueDescricao1.setText("");
        labelAtaqueDescricao2.setText("");
        labelAtaqueDescricao3.setText("");     
    }//GEN-LAST:event_labelAtaque1MouseExited

    private void labelAtaque2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAtaque2MouseEntered
        painelAtaqueDetalhe.setVisible(true);
        
        if("Arqueira".equals(classeEscolhida)){
        }
        if("Berserk".equals(classeEscolhida)){
            labelNomeAtaque.setText("Golpe Aniquilador");
            labelAtaqueDescricao1.setText("Efetua um...");
            labelAtaqueDescricao2.setText("");
            labelAtaqueDescricao3.setText(""); 
        }
        if("Mago".equals(classeEscolhida)){
        }
        if("Assassina".equals(classeEscolhida)){
        }
        if("Cavaleiro".equals(classeEscolhida)){
        } 
    }//GEN-LAST:event_labelAtaque2MouseEntered

    private void labelAtaque2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAtaque2MouseExited
        painelAtaqueDetalhe.setVisible(false);
        labelNomeAtaque.setText("");
        labelAtaqueDescricao1.setText("");
        labelAtaqueDescricao2.setText("");
        labelAtaqueDescricao3.setText("");
    }//GEN-LAST:event_labelAtaque2MouseExited

    private void labelAtaque3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAtaque3MouseEntered
        painelAtaqueDetalhe.setVisible(true);
        
        if("Arqueira".equals(classeEscolhida)){
        }
        if("Berserk".equals(classeEscolhida)){
            labelNomeAtaque.setText("Percepção");
            labelAtaqueDescricao1.setText("Efetua um...");
            labelAtaqueDescricao2.setText("");
            labelAtaqueDescricao3.setText(""); 
        }
        if("Mago".equals(classeEscolhida)){
        }
        if("Assassina".equals(classeEscolhida)){
        }
        if("Cavaleiro".equals(classeEscolhida)){
        } 
    }//GEN-LAST:event_labelAtaque3MouseEntered

    private void labelAtaque3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAtaque3MouseExited
        painelAtaqueDetalhe.setVisible(false);
        labelNomeAtaque.setText("");
        labelAtaqueDescricao1.setText("");
        labelAtaqueDescricao2.setText("");
        labelAtaqueDescricao3.setText("");
    }//GEN-LAST:event_labelAtaque3MouseExited

    private void labelAtaque4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAtaque4MouseEntered
        painelAtaqueDetalhe.setVisible(true);
        
        if("Arqueira".equals(classeEscolhida)){
        }
        if("Berserk".equals(classeEscolhida)){
            labelNomeAtaque.setText("Grito de Furia");
            labelAtaqueDescricao1.setText("Efetua um...");
            labelAtaqueDescricao2.setText("");
            labelAtaqueDescricao3.setText(""); 
        }
        if("Mago".equals(classeEscolhida)){
        }
        if("Assassina".equals(classeEscolhida)){
        }
        if("Cavaleiro".equals(classeEscolhida)){
        } 
    }//GEN-LAST:event_labelAtaque4MouseEntered

    private void labelAtaque4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAtaque4MouseExited
        painelAtaqueDetalhe.setVisible(false);
        labelNomeAtaque.setText("");
        labelAtaqueDescricao1.setText("");
        labelAtaqueDescricao2.setText("");
        labelAtaqueDescricao3.setText("");
    }//GEN-LAST:event_labelAtaque4MouseExited

    private void labelAtaque5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAtaque5MouseEntered
        painelAtaqueDetalhe.setVisible(true);
        
        if("Arqueira".equals(classeEscolhida)){
        }
        if("Berserk".equals(classeEscolhida)){
            labelNomeAtaque.setText("Fúria Brutal");
            labelAtaqueDescricao1.setText("Efetua um...");
            labelAtaqueDescricao2.setText("");
            labelAtaqueDescricao3.setText(""); 
        }
        if("Mago".equals(classeEscolhida)){
        }
        if("Assassina".equals(classeEscolhida)){
        }
        if("Cavaleiro".equals(classeEscolhida)){
        } 
    }//GEN-LAST:event_labelAtaque5MouseEntered

    private void labelAtaque5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAtaque5MouseExited
        painelAtaqueDetalhe.setVisible(false);
        labelNomeAtaque.setText("");
        labelAtaqueDescricao1.setText("");
        labelAtaqueDescricao2.setText("");
        labelAtaqueDescricao3.setText("");
    }//GEN-LAST:event_labelAtaque5MouseExited

    private void labelAtaque6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAtaque6MouseEntered
        painelAtaqueDetalhe.setVisible(true);
        
        if("Arqueira".equals(classeEscolhida)){
        }
        if("Berserk".equals(classeEscolhida)){
            labelNomeAtaque.setText("Recuperar ST");
            labelAtaqueDescricao1.setText("Efetua um...");
            labelAtaqueDescricao2.setText("");
            labelAtaqueDescricao3.setText(""); 
        }
        if("Mago".equals(classeEscolhida)){
        }
        if("Assassina".equals(classeEscolhida)){
        }
        if("Cavaleiro".equals(classeEscolhida)){
        } 
    }//GEN-LAST:event_labelAtaque6MouseEntered

    private void labelAtaque6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAtaque6MouseExited
        painelAtaqueDetalhe.setVisible(false);
        labelNomeAtaque.setText("");
        labelAtaqueDescricao1.setText("");
        labelAtaqueDescricao2.setText("");
        labelAtaqueDescricao3.setText("");
    }//GEN-LAST:event_labelAtaque6MouseExited

    private void admVidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admVidaActionPerformed
        vidaBarraPersonagem = vidaBarraTotalPersonagem;
        salvarDados();
    }//GEN-LAST:event_admVidaActionPerformed

    private void admMatarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admMatarActionPerformed
        vidaBarraInimigo = 0;
        salvarDados();
    }//GEN-LAST:event_admMatarActionPerformed

    private void continuarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_continuarMouseEntered
        continuar.setForeground(new Color(172,172,172));
    }//GEN-LAST:event_continuarMouseEntered

    private void continuarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_continuarMouseExited
        continuar.setForeground(new Color(60,60,60));
    }//GEN-LAST:event_continuarMouseExited

    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(telaBatalha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaBatalha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaBatalha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaBatalha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaBatalha().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abrirConfiguracoes;
    private javax.swing.JButton admMatar;
    private javax.swing.JButton admVida;
    private javax.swing.JLabel avatarInimigo;
    private javax.swing.JLabel avatarPersonagem;
    private javax.swing.JLabel bordaInimigo;
    private javax.swing.JLabel bordaPersonagem;
    private javax.swing.JButton botaoAtaque1;
    private javax.swing.JButton botaoAtaque2;
    private javax.swing.JButton botaoAtaque3;
    private javax.swing.JButton botaoAtaque4;
    private javax.swing.JButton botaoAtaque5;
    private javax.swing.JButton botaoAtaque6;
    private javax.swing.JButton continuar;
    private javax.swing.JLabel exibirClasse;
    private javax.swing.JLabel exibirClasseInimigo;
    private javax.swing.JProgressBar exibirEstamina;
    private javax.swing.JLabel exibirEstaminaStatus;
    private javax.swing.JLabel exibirNome;
    private javax.swing.JLabel exibirNomeInimigo;
    private javax.swing.JProgressBar exibirVida;
    private javax.swing.JProgressBar exibirVidaInimigo;
    private javax.swing.JLabel exibirVidaStatus;
    private javax.swing.JLabel exibirVidaStatusInimigo;
    private javax.swing.JLabel fundo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelAtaque1;
    private javax.swing.JLabel labelAtaque2;
    private javax.swing.JLabel labelAtaque3;
    private javax.swing.JLabel labelAtaque4;
    private javax.swing.JLabel labelAtaque5;
    private javax.swing.JLabel labelAtaque6;
    private javax.swing.JLabel labelAtaqueDescricao1;
    private javax.swing.JLabel labelAtaqueDescricao2;
    private javax.swing.JLabel labelAtaqueDescricao3;
    private javax.swing.JLabel labelNomeAtaque;
    private javax.swing.JLabel msgVitoria;
    private javax.swing.JLabel msgVitoria1;
    private javax.swing.JLabel msgVitoria2;
    private javax.swing.JLabel msgVitoria3;
    private javax.swing.JLabel msgVitoria4;
    private javax.swing.JLabel msgVitoria5;
    private javax.swing.JLabel msgVitoria6;
    private javax.swing.JPanel painelADM;
    private javax.swing.JPanel painelAtaqueDetalhe;
    private javax.swing.JPanel painelBotoes;
    private javax.swing.JPanel painelInimigo;
    private javax.swing.JPanel painelMensagem;
    private javax.swing.JPanel painelMenu;
    private javax.swing.JPanel painelPersonagem;
    private javax.swing.JPanel painelVitoria;
    private javax.swing.JButton sair;
    private javax.swing.JLabel textoHistoria1;
    private javax.swing.JLabel textoHistoria2;
    private javax.swing.JLabel textoHistoria3;
    private javax.swing.JLabel textoLevelInimigo;
    private javax.swing.JLabel textoLevelPersonagem;
    private javax.swing.JLabel textoST;
    private javax.swing.JLabel textoVida;
    private javax.swing.JLabel textoVida2;
    // End of variables declaration//GEN-END:variables

    public telaMenu getMenu() {
        return menu;
    }

    public void setMenu(telaMenu menu) {
        this.menu = menu;
    }
}
