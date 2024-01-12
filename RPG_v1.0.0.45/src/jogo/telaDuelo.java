package jogo;

import java.awt.Color;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class telaDuelo extends javax.swing.JFrame {
    int contPlayer1 = 0, contPlayer2 = 0;
    int estaminaBarraPlayer1 = 100, estaminaBarraPlayer2 = 100;
    int estaminaBarraTotalPlayer1 = 100, estaminaBarraTotalPlayer2 = 100;
    int vidaBarraPlayer1 = 100, vidaBarraPlayer2 = 100;
    int vidaBarraTotalPlayer1 = 100, vidaBarraTotalPlayer2 = 100;
    int danoCausadoPlayer1, danoCriticoPlayer1, danoCausadoPlayer2, danoCriticoPlayer2, sorte;
    int contAumentarCriticoPlayer1, contAumentarCriticoPlayer2 , contAtordoamentoPlayer1 = 0 , contAtordoamentoPlayer2 = 0;
    int porcentagemVida11, porcentagemVida12;
    int porcentagemVida21, porcentagemVida22, contAtaque, vez;
    String Historia1, Historia2, Historia3, estaminaBarra;
    
    Thread carregamento = new Thread();
    Thread escreverHist1 = new Thread();
    Thread escreverHist2 = new Thread();
    Thread escreverHist3 = new Thread();
    
    telaInformacao telaInformacaoChamar;
    telaConfiguracao telaConfiguracaoChamar;
    
    Random geradorCriticoPlayer1 = new Random();
    Random geradorCriticoPlayer2 = new Random();
    Random geradorDanoPlayer1 = new Random();
    Random geradorDanoPlayer2 = new Random();
    Random geradorSorte = new Random();
    
    ImageIcon assassina_1 = new ImageIcon("src/imagens/assassina_1.png");
    ImageIcon arqueira_1 = new ImageIcon("src/imagens/arqueira_1.png");
    ImageIcon cavaleiro_1 = new ImageIcon("src/imagens/cavaleiro_1.png");
    ImageIcon berserk_1 = new ImageIcon("src/imagens/berserk_1.png");
    ImageIcon mago_1 = new ImageIcon("src/imagens/mago_1.png");
    
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
    
    private void imagemPlayer1(){
        if(contPlayer1 == 0){
            player1.setIcon(berserk_1);
            player1Classe.setText("Berserk");
        }
        if(contPlayer1 == 1){
            player1.setIcon(cavaleiro_1);
            player1Classe.setText("Cavaleiro");
        }
        if(contPlayer1 == 2){
            player1.setIcon(assassina_1);
            player1Classe.setText("Assassina");
        }
        if(contPlayer1 == 3){
            player1.setIcon(arqueira_1);
            player1Classe.setText("Arqueira");
        }
        if(contPlayer1 == 4){
            player1.setIcon(mago_1);
            player1Classe.setText("Mago");
        }
    }
    private void imagemPlayer2(){
        if(contPlayer2 == 0){
            player2.setIcon(berserk_1);
            player2Classe.setText("Berserk");
        }
        if(contPlayer2 == 1){
            player2.setIcon(cavaleiro_1);
            player2Classe.setText("Cavaleiro");
        }
        if(contPlayer2 == 2){
            player2.setIcon(assassina_1);
            player2Classe.setText("Assassina");
        }
        if(contPlayer2 == 3){
            player2.setIcon(arqueira_1);
            player2Classe.setText("Arqueira");
        }
        if(contPlayer2 == 4){
            player2.setIcon(mago_1);
            player2Classe.setText("Mago");
        }
    }
    
    private void carregarAtaque(){
        setInfo();
        
        ataque1Player1.setVisible(false);
        ataque2Player1.setVisible(false);
        ataque3Player1.setVisible(false);
        ataque4Player1.setVisible(false);
        ataque5Player1.setVisible(false);
        ataque6Player1.setVisible(false);
        ataque1Player2.setVisible(false);
        ataque2Player2.setVisible(false);
        ataque3Player2.setVisible(false);
        ataque4Player2.setVisible(false);
        ataque5Player2.setVisible(false);
        ataque6Player2.setVisible(false);
        aguarde1.setVisible(true);
        aguarde2.setVisible(true);
        
        if(vez == 1){
            if(contPlayer1 == 0){
                if(contAtaque == 1){
                    geradorDanoPlayer1();
                    danoCausadoPlayer1 = danoCausadoPlayer1 + 10 ;
                    if(danoCriticoPlayer1==0){
                        danoCausadoPlayer1=0;
                    }
                    escreverHistoria1();
                    estaminaBarraPlayer1 = estaminaBarraPlayer1 - 3;
                }else if(contAtaque == 2){
                    sorte = geradorSorte.nextInt(100);
                    
                    if(sorte == 42){
                        vidaBarraPlayer2 = 0;
                    }else{
                        Historia3 = "O inimigo não se sente intimidado";
                    }  
                    escreverHistoria3();
                }else if(contAtaque == 3){
                    geradorDanoPlayer1();
                    danoCausadoPlayer1 = danoCausadoPlayer1 + 20;
                    if(danoCriticoPlayer1==0){
                        danoCausadoPlayer1=0;
                    }
                    escreverHistoria1();
                    estaminaBarraPlayer1 = estaminaBarraPlayer1 - 20;
                }else if(contAtaque == 4){
                    geradorDanoPlayer1();
                    danoCausadoPlayer1 = danoCausadoPlayer1*3;
                    if(danoCriticoPlayer1==0){
                        danoCausadoPlayer1=0;
                    }
                    escreverHistoria1();
                    estaminaBarraPlayer1 = estaminaBarraPlayer1 - 50;
                }
                setInfo();
            }else if(contPlayer1 == 1){
                
            }else if(contPlayer1 == 2){
                
            }else if(contPlayer1 == 3){
                if(contAtaque==1){
                    geradorDanoPlayer1();
                    danoCausadoPlayer1 = danoCausadoPlayer1+10;
                    if(danoCriticoPlayer1==0){
                        danoCausadoPlayer1=0;
                    }
                    escreverHistoria1();
                    estaminaBarraPlayer1 = estaminaBarraPlayer1 - 3;
                }else if(contAtaque==2){
                    sorte = geradorSorte.nextInt(100);
                    
                    if(sorte>100){
                        Historia1="Você atordou o inimigo, agora pode atacar duas vezes";
                        escreverHistoria1();
                        contAtordoamentoPlayer1=contAtordoamentoPlayer1+1;
                        estaminaBarraPlayer1=estaminaBarraPlayer1-15;
                        if(contAtordoamentoPlayer1==1){
                            geradorDanoPlayer1();
                            danoCausadoPlayer1 = danoCausadoPlayer1 + 10;
                            if(danoCriticoPlayer1==0){
                                danoCausadoPlayer1=0;
                            }
                            escreverHistoria1();
                        }
                        if(contAtordoamentoPlayer1==2){
                            geradorDanoPlayer1();
                            danoCausadoPlayer1 = danoCausadoPlayer1 + 10;
                            if(danoCriticoPlayer1==0){
                                danoCausadoPlayer1=0;
                            }
                            escreverHistoria1();
                        }
                        
                    }else{
                        Historia1="Você infelizmente não atordou o inimigo";
                        escreverHistoria1();
                    }
                }else if(contAtaque==3){
                    geradorDanoPlayer1();
                    danoCausadoPlayer1=danoCausadoPlayer1+20;
                    if(danoCriticoPlayer1==0){
                            danoCausadoPlayer1=0;
                        }
                    escreverHistoria1();
                    estaminaBarraPlayer1 = estaminaBarraPlayer1 - 20; 
                }else if(contAtaque==4){
                    geradorDanoPlayer1();
                    
                    sorte = geradorSorte.nextInt(100);
                    
                    if(sorte<=90&&sorte>70){
                        danoCausadoPlayer1=danoCausadoPlayer1+35;
                        if(danoCriticoPlayer1==0){
                            danoCausadoPlayer1=0;
                        }
                        escreverHistoria1();
         
                        estaminaBarraPlayer1=estaminaBarraPlayer1-20;
                    }else if(sorte<=70&&sorte>50){
                        danoCausadoPlayer1=danoCausadoPlayer1+25;
                        if(danoCriticoPlayer1==0){
                            danoCausadoPlayer1=0;
                        }
                        escreverHistoria1();
                     
                        estaminaBarraPlayer1=estaminaBarraPlayer1-20;
                    }else if(sorte<=50&&sorte>30){
                        danoCausadoPlayer1=danoCausadoPlayer1+20;
                        if(danoCriticoPlayer1==0){
                            danoCausadoPlayer1=0;
                        }
                        escreverHistoria1();
                     
                        estaminaBarraPlayer1=estaminaBarraPlayer1-20;
                    }else if(sorte<=30&&sorte>20){
                        danoCausadoPlayer1=danoCausadoPlayer1+10;
                        if(danoCriticoPlayer1==0){
                            danoCausadoPlayer1=0;
                        }
                        escreverHistoria1();
                     
                        estaminaBarraPlayer1=estaminaBarraPlayer1-20;
                    }else if(sorte<=20){
                        danoCausadoPlayer1=danoCausadoPlayer1+5;
                        if(danoCriticoPlayer1==0){
                            danoCausadoPlayer1=0;
                        }
                        escreverHistoria1();
    
                        estaminaBarraPlayer1=estaminaBarraPlayer1-20;
                    }   
                }
                setInfo();
            }else if(contPlayer1 == 4){
                
            }
        }else if(vez == 2){
            if(contPlayer2 == 0){
                if(contAtaque == 1){
                    geradorDanoPlayer2();
                    danoCausadoPlayer2 = danoCausadoPlayer2 + 10 ;
                    if(danoCriticoPlayer2==0){
                            danoCausadoPlayer2=0;
                    }
                    escreverHistoria2();
                    estaminaBarraPlayer2 = estaminaBarraPlayer2 - 3;
                }else if(contAtaque == 2){
                    sorte = geradorSorte.nextInt(100);
                    if(sorte == 42){
                        vidaBarraPlayer1 = 0;
                    }else{
                        Historia3 = "O inimigo não se sente intimidado";
                    }
                    escreverHistoria3();
                }else if(contAtaque == 3){
                    geradorDanoPlayer2();
                    danoCausadoPlayer2 = danoCausadoPlayer2 + 20 ;
                    if(danoCriticoPlayer2==0){
                            danoCausadoPlayer2=0;
                    }
                    escreverHistoria2();
                    estaminaBarraPlayer2 = estaminaBarraPlayer2 - 20;
                }else if(contAtaque == 4){
                    geradorDanoPlayer2();
                    danoCausadoPlayer2 = danoCausadoPlayer2*3;
                    if(danoCriticoPlayer2==0){
                            danoCausadoPlayer2=0;
                    }
                    escreverHistoria2();
                    estaminaBarraPlayer2 = estaminaBarraPlayer2 - 50;
                }
                setInfo();
            }else if(contPlayer2 == 1){
                
            }else if(contPlayer2 == 2){
                
            }else if(contPlayer2 == 3){
                if(contAtaque==1){
                    geradorDanoPlayer2();
                    danoCausadoPlayer2 = danoCausadoPlayer2+10;
                    if(danoCriticoPlayer2==0){
                            danoCausadoPlayer2=0;
                    }
                    escreverHistoria2();
                    estaminaBarraPlayer2 = estaminaBarraPlayer2 - 3;
                }else if(contAtaque==2){
                    sorte = geradorSorte.nextInt(100);
                    
                    if(sorte>100){
                        Historia2="Você atordou o inimigo, agora pode atacar duas vezes";
                        escreverHistoria2();
                        estaminaBarraPlayer2=estaminaBarraPlayer2-15;
                        if(contAtordoamentoPlayer2==1){
                            geradorDanoPlayer2();
                            danoCausadoPlayer2 = danoCausadoPlayer2 + 13;
                            if(danoCriticoPlayer2==0){
                                danoCausadoPlayer2=0;
                            }
                            escreverHistoria2();
                        }
                        if(contAtordoamentoPlayer2==2){
                            geradorDanoPlayer2();
                            danoCausadoPlayer2 = danoCausadoPlayer2 + 12;
                            if(danoCriticoPlayer2==0){
                                danoCausadoPlayer2=0;
                            }
                            escreverHistoria2();
                        }
            
                    }else{
                        Historia2="Você infelizmente não atordou o inimigo";
                        escreverHistoria2();
                    }
                }else if(contAtaque==3){
                    geradorDanoPlayer2();
                    danoCausadoPlayer2=danoCausadoPlayer2+20;
                    if(danoCriticoPlayer2==0){
                            danoCausadoPlayer2=0;
                    }
                    escreverHistoria2();
                    estaminaBarraPlayer2 = estaminaBarraPlayer2 - 20; 
                }else if(contAtaque==4){
                    geradorDanoPlayer2();
                    
                    sorte = geradorSorte.nextInt(100);
                    
                    if(sorte<=90&&sorte>70){
                        danoCausadoPlayer2=danoCausadoPlayer2+35;
                        if(danoCriticoPlayer2==0){
                            danoCausadoPlayer2=0;
                        }
                        escreverHistoria2();
                        estaminaBarraPlayer2=estaminaBarraPlayer2-20;
                    }else if(sorte<=70&&sorte>50){
                        danoCausadoPlayer2=danoCausadoPlayer2+25;
                        if(danoCriticoPlayer2==0){
                            danoCausadoPlayer2=0;
                        }
                        escreverHistoria2();
                        estaminaBarraPlayer2=estaminaBarraPlayer2-20;
                    }else if(sorte<=50&&sorte>30){
                        danoCausadoPlayer2=danoCausadoPlayer2+20;
                        if(danoCriticoPlayer2==0){
                            danoCausadoPlayer2=0;
                        }
                        escreverHistoria2();
                        estaminaBarraPlayer2=estaminaBarraPlayer2-20;
                    }else if(sorte<=30&&sorte>20){
                        danoCausadoPlayer2=danoCausadoPlayer2+10;
                        if(danoCriticoPlayer2==0){
                            danoCausadoPlayer2=0;
                        }
                        escreverHistoria2();
                        estaminaBarraPlayer2=estaminaBarraPlayer2-20;
                    }else if(sorte<=20){
                        danoCausadoPlayer2=danoCausadoPlayer2+5;
                        if(danoCriticoPlayer2==0){
                            danoCausadoPlayer2=0;
                        }
                        escreverHistoria2();
                        estaminaBarraPlayer2=estaminaBarraPlayer2-20;
                    }   
                }
                setInfo();
                
            }else if(contPlayer2 == 4){
                
            }
        }
        
        if(contAtaque == 5){    
            if(vez == 1){
                estaminaBarraPlayer1 = estaminaBarraPlayer1 - 15;
                Historia3 = "Sua estamina já estava completa";
            }else if(vez == 2){
                estaminaBarraPlayer2 = estaminaBarraPlayer2 - 15;
            }
            escreverHistoria3();
        }else if(contAtaque == 6){
            if(vez == 1){
                if(estaminaBarraPlayer1 < estaminaBarraTotalPlayer1){
                    estaminaBarraPlayer1=estaminaBarraPlayer1+20;
                    Historia3 = "Sua estamina foi recuperada";
                }
                if(estaminaBarraPlayer1 >= estaminaBarraTotalPlayer1){
                    estaminaBarraPlayer1 = estaminaBarraTotalPlayer1;
                    Historia3 = "Sua estamina já estava completa";
                }
            }else if(vez == 2){
                if(estaminaBarraPlayer2 < estaminaBarraTotalPlayer2){
                    estaminaBarraPlayer2=estaminaBarraPlayer2+20;
                    Historia3 = "Sua estamina foi recuperada";
                }
                if(estaminaBarraPlayer2 >= estaminaBarraTotalPlayer2){
                    estaminaBarraPlayer2 = estaminaBarraTotalPlayer2;
                    Historia3 = "Sua estamina já estava completa";
                }
            }
            escreverHistoria3();
        }
        
        if(vez == 1){
            vez = 2;
        }else if(vez == 2){
            vez = 1;
        }
        
        setInfo();
    }
    
    private void escreverHistoria1(){
        textoHistoria2.setText("");
       
        escreverHist1 = new Thread(){
            public void run(){
        
                for(int cont = 0; cont<Historia1.length(); cont++){
                    try {
                        textoHistoria2.setText(textoHistoria2.getText() + Historia1.charAt(cont));
                        escreverHist1.sleep(50);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(telaCarregamento.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                ataque1Player1.setVisible(true);
                ataque2Player1.setVisible(true);
                ataque3Player1.setVisible(true);
                ataque4Player1.setVisible(true);
                ataque5Player1.setVisible(true);
                ataque6Player1.setVisible(true);
                ataque1Player2.setVisible(true);
                ataque2Player2.setVisible(true);
                ataque3Player2.setVisible(true);
                ataque4Player2.setVisible(true);
                ataque5Player2.setVisible(true);
                ataque6Player2.setVisible(true);
                aguarde1.setVisible(false);
                aguarde2.setVisible(false);
                escreverHist1.interrupt();
                if(contPlayer1==3&&contAtaque==2){
                    contAtordoamentoPlayer1=contAtordoamentoPlayer1+1;
                }
                if(contAtaque==1||contAtaque==3||contAtaque==4){
                    if(danoCriticoPlayer1==0){
                        danoCausadoPlayer1=0;
                    }
                    vidaBarraPlayer2 = vidaBarraPlayer2 - danoCausadoPlayer1;
                    setInfo();
                }
            }
        };
        escreverHist1.start();
    }
    private void escreverHistoria2(){
        textoHistoria2.setText("");
       
        escreverHist2 = new Thread(){
            
            public void run(){
        
                for(int cont = 0; cont<Historia2.length(); cont++){
                    try {
                        textoHistoria2.setText(textoHistoria2.getText() + Historia2.charAt(cont));
                        escreverHist2.sleep(50);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(telaCarregamento.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                ataque1Player1.setVisible(true);
                ataque2Player1.setVisible(true);
                ataque3Player1.setVisible(true);
                ataque4Player1.setVisible(true);
                ataque5Player1.setVisible(true);
                ataque6Player1.setVisible(true);
                ataque1Player2.setVisible(true);
                ataque2Player2.setVisible(true);
                ataque3Player2.setVisible(true);
                ataque4Player2.setVisible(true);
                ataque5Player2.setVisible(true);
                ataque6Player2.setVisible(true);
                aguarde1.setVisible(false);
                aguarde2.setVisible(false);
                escreverHist2.interrupt();
                if(contPlayer2==3&&contAtaque==2){
                    contAtordoamentoPlayer2=contAtordoamentoPlayer2+2;
                }
                if(danoCriticoPlayer1==0){
                        danoCausadoPlayer2=0;
                    }
                if(contAtaque==1||contAtaque==3||contAtaque==4){
                    vidaBarraPlayer1 = vidaBarraPlayer1 - danoCausadoPlayer2;
                    setInfo();
                }
            }
        };
        escreverHist2.start();
    }
    private void escreverHistoria3(){
        textoHistoria2.setText("");
        escreverHist3 = new Thread(){
            
            public void run(){
        
                for(int cont = 0; cont<Historia3.length(); cont++){
                    try {
                        textoHistoria2.setText(textoHistoria2.getText() + Historia3.charAt(cont));
                        escreverHist3.sleep(50);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(telaCarregamento.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                ataque1Player1.setVisible(true);
                ataque2Player1.setVisible(true);
                ataque3Player1.setVisible(true);
                ataque4Player1.setVisible(true);
                ataque5Player1.setVisible(true);
                ataque6Player1.setVisible(true);
                ataque1Player2.setVisible(true);
                ataque2Player2.setVisible(true);
                ataque3Player2.setVisible(true);
                ataque4Player2.setVisible(true);
                ataque5Player2.setVisible(true);
                ataque6Player2.setVisible(true);
                aguarde1.setVisible(false);
                aguarde2.setVisible(false);
                escreverHist3.interrupt();
            }
        };
        escreverHist3.start();
    }
    
    private void carregamento(){
        carregamento = new Thread(){
            
            public void run(){
        
                for(int cont = 0; cont<10; cont++){
                    try {
                        barraCarregamento.setValue(cont);
                        carregamento.sleep(50);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(telaCarregamento.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                painelCarregamento.setVisible(false);
                painelCarregamento.setEnabled(false);
                painelDuelo.setVisible(true);
                painelDuelo.setEnabled(true);
                setInfo();
                carregamento.interrupt();
            }
        };
        carregamento.start();
    }
    private void setInfo(){
        
        if(vez == 1){
            ataque1Player1.setEnabled(true);
            ataque2Player1.setEnabled(true);
            ataque3Player1.setEnabled(true);
            ataque4Player1.setEnabled(true);
            ataque5Player1.setEnabled(true);
            ataque6Player1.setEnabled(true);
            ataque1Player2.setEnabled(false);
            ataque2Player2.setEnabled(false);
            ataque3Player2.setEnabled(false);
            ataque4Player2.setEnabled(false);
            ataque5Player2.setEnabled(false);
            ataque6Player2.setEnabled(false);
            
        }else if(vez == 2){
            ataque1Player1.setEnabled(false);
            ataque2Player1.setEnabled(false);
            ataque3Player1.setEnabled(false);
            ataque4Player1.setEnabled(false);
            ataque5Player1.setEnabled(false);
            ataque6Player1.setEnabled(false);
            ataque1Player2.setEnabled(true);
            ataque2Player2.setEnabled(true);
            ataque3Player2.setEnabled(true);
            ataque4Player2.setEnabled(true);
            ataque5Player2.setEnabled(true);
            ataque6Player2.setEnabled(true);
            
        }
        
        // Player 1
        if(contPlayer1 == 0){
            porcentagemVida11 = (vidaBarraTotalPlayer1 / 100)* 30;
            porcentagemVida12 = (vidaBarraTotalPlayer1 / 100)* 60;
            
            if(vidaBarraPlayer1 <= porcentagemVida11){
                avatarPlayer1.setIcon(berserkHistoria_3);
            }
            if(vidaBarraPlayer1 <= porcentagemVida12 && vidaBarraPlayer1> porcentagemVida11){
                avatarPlayer1.setIcon(berserkHistoria_2);
            }
            if(vidaBarraPlayer1 > porcentagemVida12){
                avatarPlayer1.setIcon(berserkHistoria_1);
            }
            
            exibirClassePlayer1.setText("Berserk");
            
            ataque1Player1.setText("Ataque Normal");
            ataque2Player1.setText("Grito de Fúria");
            ataque3Player1.setText("Golpe Aniquilador");
            ataque4Player1.setText("Fúria Brutal");
            ataque5Player1.setText("Percepção");
            ataque6Player1.setText("Recuperar ST");
        }
        if(contPlayer1 == 1){
            porcentagemVida11 = (vidaBarraTotalPlayer1 / 100)* 30;
            porcentagemVida12 = (vidaBarraTotalPlayer1 / 100)* 60;
            
            if(vidaBarraPlayer1 <= porcentagemVida11){
                avatarPlayer1.setIcon(cavaleiroHistoria_3);
            }
            if(vidaBarraPlayer1 <= porcentagemVida12 && vidaBarraPlayer1> porcentagemVida11){
                avatarPlayer1.setIcon(cavaleiroHistoria_2);
            }
            if(vidaBarraPlayer1 > porcentagemVida12){
                avatarPlayer1.setIcon(cavaleiroHistoria_1);
            }
            exibirClassePlayer1.setText("Cavaleiro");
            
            ataque5Player1.setText("Percepção");
            ataque6Player1.setText("Recuperar ST");
        }
        if(contPlayer1 == 2){
            porcentagemVida11 = (vidaBarraTotalPlayer1 / 100)* 30;
            porcentagemVida12 = (vidaBarraTotalPlayer1 / 100)* 60;
            
            if(vidaBarraPlayer1 <= porcentagemVida11){
                avatarPlayer1.setIcon(assassinaHistoria_3);
            }
            if(vidaBarraPlayer1 <= porcentagemVida12 && vidaBarraPlayer1> porcentagemVida11){
                avatarPlayer1.setIcon(assassinaHistoria_2);
            }
            if(vidaBarraPlayer1 > porcentagemVida12){
                avatarPlayer1.setIcon(assassinaHistoria_1);
            }
            exibirClassePlayer1.setText("Assassina");
            
            ataque5Player1.setText("Percepção");
            ataque6Player1.setText("Recuperar ST");
        }
        if(contPlayer1 == 3){
            porcentagemVida11 = (vidaBarraTotalPlayer1 / 100)* 30;
            porcentagemVida12 = (vidaBarraTotalPlayer1 / 100)* 60;
            
            if(vidaBarraPlayer1 <= porcentagemVida11){
                avatarPlayer1.setIcon(arqueiraHistoria_3);
            }
            if(vidaBarraPlayer1 <= porcentagemVida12 && vidaBarraPlayer1> porcentagemVida11){
                avatarPlayer1.setIcon(arqueiraHistoria_2);
            }
            if(vidaBarraPlayer1 > porcentagemVida12){
                avatarPlayer1.setIcon(arqueiraHistoria_1);
            }
            exibirClassePlayer1.setText("Arqueira");
            
            ataque1Player1.setText("Tiro rápido");
            ataque2Player1.setText("Flecha de Gelo");
            ataque3Player1.setText("Chuva de Flechas");
            ataque4Player1.setText("Tiro furtivo");
            ataque5Player1.setText("Percepção");
            ataque6Player1.setText("Recuperar ST");
        }
        if(contPlayer1 == 4){
            porcentagemVida11 = (vidaBarraTotalPlayer1 / 100)* 30;
            porcentagemVida12 = (vidaBarraTotalPlayer1 / 100)* 60;
            
            if(vidaBarraPlayer1 <= porcentagemVida11){
                avatarPlayer1.setIcon(magoHistoria_3);
            }
            if(vidaBarraPlayer1 <= porcentagemVida12 && vidaBarraPlayer1> porcentagemVida11){
                avatarPlayer1.setIcon(magoHistoria_2);
            }
            if(vidaBarraPlayer1 > porcentagemVida12){
                avatarPlayer1.setIcon(magoHistoria_1);
            }
            exibirClassePlayer1.setText("Mago");
            
            ataque5Player1.setText("Percepção");
            ataque6Player1.setText("Recuperar ST");
        }
        
        exibirEstaminaPlayer1.setMaximum(estaminaBarraTotalPlayer1);
        exibirEstaminaPlayer1.setValue(estaminaBarraPlayer1);
        exibirEstaminaStatusPlayer1.setText(estaminaBarraPlayer1 + " / " + estaminaBarraTotalPlayer1);
        exibirVidaPlayer1.setMaximum(vidaBarraTotalPlayer1);
        exibirVidaPlayer1.setValue(vidaBarraPlayer1);
        exibirVidaStatusPlayer1.setText(vidaBarraPlayer1 + " / " + vidaBarraTotalPlayer1);
        
        
        // Player 2
        if(contPlayer2 == 0){
            porcentagemVida21 = (vidaBarraTotalPlayer1 / 100)* 30;
            porcentagemVida22 = (vidaBarraTotalPlayer1 / 100)* 60;
            
            if(vidaBarraPlayer1 <= porcentagemVida21){
                avatarPlayer2.setIcon(berserkHistoria_3);
            }
            if(vidaBarraPlayer1 <= porcentagemVida22 && vidaBarraPlayer1> porcentagemVida21){
                avatarPlayer2.setIcon(berserkHistoria_2);
            }
            if(vidaBarraPlayer1 > porcentagemVida22){
                avatarPlayer2.setIcon(berserkHistoria_1);
            }
            
            exibirClassePlayer2.setText("Berserk");
            
            ataque1Player2.setText("Ataque Normal");
            ataque2Player2.setText("Grito de Fúria");
            ataque3Player2.setText("Golpe Aniquilador");
            ataque4Player2.setText("Fúria Brutal");
            ataque5Player2.setText("Percepção");
            ataque6Player2.setText("Recuperar ST");
        }
        if(contPlayer2 == 1){
            porcentagemVida21 = (vidaBarraTotalPlayer1 / 100)* 30;
            porcentagemVida22 = (vidaBarraTotalPlayer1 / 100)* 60;
            
            if(vidaBarraPlayer1 <= porcentagemVida21){
                avatarPlayer2.setIcon(cavaleiroHistoria_3);
            }
            if(vidaBarraPlayer1 <= porcentagemVida22 && vidaBarraPlayer1> porcentagemVida21){
                avatarPlayer2.setIcon(cavaleiroHistoria_2);
            }
            if(vidaBarraPlayer1 > porcentagemVida22){
                avatarPlayer2.setIcon(cavaleiroHistoria_1);
            }
            
            exibirClassePlayer2.setText("Cavaleiro");
            
            ataque5Player2.setText("Percepção");
            ataque6Player2.setText("Recuperar ST");
        }
        if(contPlayer2 == 2){
            porcentagemVida21 = (vidaBarraTotalPlayer1 / 100)* 30;
            porcentagemVida22 = (vidaBarraTotalPlayer1 / 100)* 60;
            
            if(vidaBarraPlayer1 <= porcentagemVida21){
                avatarPlayer2.setIcon(assassinaHistoria_3);
            }
            if(vidaBarraPlayer1 <= porcentagemVida22 && vidaBarraPlayer1> porcentagemVida21){
                avatarPlayer2.setIcon(assassinaHistoria_2);
            }
            if(vidaBarraPlayer1 > porcentagemVida22){
                avatarPlayer2.setIcon(assassinaHistoria_1);
            }
            
            exibirClassePlayer2.setText("Assassina");
            
            ataque5Player2.setText("Percepção");
            ataque6Player2.setText("Recuperar ST");
        }
        if(contPlayer2 == 3){
            porcentagemVida21 = (vidaBarraTotalPlayer1 / 100)* 30;
            porcentagemVida22 = (vidaBarraTotalPlayer1 / 100)* 60;
            
            if(vidaBarraPlayer1 <= porcentagemVida21){
                avatarPlayer2.setIcon(arqueiraHistoria_3);
            }
            if(vidaBarraPlayer1 <= porcentagemVida22 && vidaBarraPlayer1> porcentagemVida21){
                avatarPlayer2.setIcon(arqueiraHistoria_2);
            }
            if(vidaBarraPlayer1 > porcentagemVida22){
                avatarPlayer2.setIcon(arqueiraHistoria_1);
            }
            
            exibirClassePlayer2.setText("Arqueira");
            
            ataque1Player2.setText("Tiro rápido");
            ataque2Player2.setText("Flecha de Gelo");
            ataque3Player2.setText("Chuva de Flechas");
            ataque4Player2.setText("Tiro furtivo");
            ataque5Player2.setText("Percepção");
            ataque6Player2.setText("Recuperar ST");
        }
        if(contPlayer2 == 4){
            porcentagemVida21 = (vidaBarraTotalPlayer1 / 100)* 30;
            porcentagemVida22 = (vidaBarraTotalPlayer1 / 100)* 60;
            
            if(vidaBarraPlayer1 <= porcentagemVida21){
                avatarPlayer2.setIcon(magoHistoria_3);
            }
            if(vidaBarraPlayer1 <= porcentagemVida22 && vidaBarraPlayer1> porcentagemVida21){
                avatarPlayer2.setIcon(magoHistoria_2);
            }
            if(vidaBarraPlayer1 > porcentagemVida22){
                avatarPlayer2.setIcon(magoHistoria_1);
            }
            
            exibirClassePlayer2.setText("Mago");
            
            ataque5Player2.setText("Percepção");
            ataque6Player2.setText("Recuperar ST");
        }
        
        exibirEstaminaPlayer2.setMaximum(estaminaBarraTotalPlayer2);
        exibirEstaminaPlayer2.setValue(estaminaBarraPlayer2);
        exibirEstaminaStatusPlayer2.setText(estaminaBarraPlayer2 + " / " + estaminaBarraTotalPlayer2);
        exibirVidaPlayer2.setMaximum(vidaBarraTotalPlayer2);
        exibirVidaPlayer2.setValue(vidaBarraPlayer2);
        exibirVidaStatusPlayer2.setText(vidaBarraPlayer2 + " / " + vidaBarraTotalPlayer2);
        
        if(vidaBarraPlayer1 <= 0 || estaminaBarraPlayer1 <= 0){
            vidaBarraPlayer1 = 0;
            painelVitoria.setVisible(true);
            painelVitoria.setEnabled(true);
            ataque1Player1.setEnabled(false);
            ataque2Player1.setEnabled(false);
            ataque3Player1.setEnabled(false);
            ataque4Player1.setEnabled(false);
            ataque5Player1.setEnabled(false);
            ataque6Player1.setEnabled(false);
            ataque1Player2.setEnabled(false);
            ataque2Player2.setEnabled(false);
            ataque3Player2.setEnabled(false);
            ataque4Player2.setEnabled(false);
            ataque5Player2.setEnabled(false);
            ataque6Player2.setEnabled(false);
            
            jogador.setText("Player 2");
        }
        if(vidaBarraPlayer2 <= 0 || estaminaBarraPlayer2 <= 0){
            vidaBarraPlayer2 = 0;
            painelVitoria.setVisible(true);
            painelVitoria.setEnabled(true);
            ataque1Player1.setEnabled(false);
            ataque2Player1.setEnabled(false);
            ataque3Player1.setEnabled(false);
            ataque4Player1.setEnabled(false);
            ataque5Player1.setEnabled(false);
            ataque6Player1.setEnabled(false);
            ataque1Player2.setEnabled(false);
            ataque2Player2.setEnabled(false);
            ataque3Player2.setEnabled(false);
            ataque4Player2.setEnabled(false);
            ataque5Player2.setEnabled(false);
            ataque6Player2.setEnabled(false);
            
            jogador.setText("Player 1");
        }
    }
    
    private void geradorDanoPlayer1(){
        danoCausadoPlayer1 = geradorDanoPlayer1.nextInt(10);
        danoCriticoPlayer1 = geradorCriticoPlayer1.nextInt(6);
        
        if(contAumentarCriticoPlayer1==50){
            danoCriticoPlayer1=3+danoCriticoPlayer1;
        }
        if(contAumentarCriticoPlayer1==100){
            danoCriticoPlayer1=6;
        }
        
        if(danoCriticoPlayer1 == 0){
            danoCausadoPlayer1 = 0;
            Historia1="Você infelizmente errou o ataque";
            
        }
        else{
            if(danoCriticoPlayer1 >= 1 && danoCriticoPlayer1 <= 3){
                Historia1="Você acerta o ataque";
                
            }
            else{
                if(danoCriticoPlayer1 >= 4 && danoCriticoPlayer1 <= 6){
                    danoCausadoPlayer1 = danoCausadoPlayer1*2;
                    Historia1="Você acertou um ataque crítico!";
                    
                }
            }
        }
    }
    private void geradorDanoPlayer2(){
        danoCausadoPlayer2 = geradorDanoPlayer2.nextInt(10);
        danoCriticoPlayer2 = geradorCriticoPlayer2.nextInt(6);
        
        if(contAumentarCriticoPlayer2==50){
            danoCriticoPlayer2=3+danoCriticoPlayer2;
        }
        if(contAumentarCriticoPlayer2==100){
            danoCriticoPlayer2=6;
        }
        
        if(danoCriticoPlayer2 == 0){
            danoCausadoPlayer2 = 0;
            Historia2="Você infelizmente errou o ataque";
            
        }
        else{
            if(danoCriticoPlayer2 >= 1 && danoCriticoPlayer2 <= 3){
                Historia2="Você acerta o ataque";
                
            }
            else{
                if(danoCriticoPlayer2 >= 4 && danoCriticoPlayer2 <= 6){
                    danoCausadoPlayer2 = danoCausadoPlayer2*2;
                    Historia2="Você acertou um ataque crítico!";
                    
                }
            }
        }
    }
    
    public telaDuelo() {
        
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
        
        imagemPlayer1();
        imagemPlayer2();
        
        telaInformacaoChamar = new telaInformacao();
        telaConfiguracaoChamar = new telaConfiguracao();
        telaInformacaoChamar.setVisible(false);
        telaConfiguracaoChamar.setVisible(false);
        
        painelEscolha.setVisible(true);
        painelEscolha.setEnabled(true);
        painelCarregamento.setVisible(false);
        painelCarregamento.setEnabled(false);
        painelDuelo.setVisible(false);
        painelDuelo.setEnabled(false);
        
        painelVitoria.setVisible(false);
        painelVitoria.setEnabled(false);
        aguarde1.setVisible(false);
        aguarde2.setVisible(false);
        
        labelNomeAtaque.setText("");
        labelAtaqueDescricao1.setText("");
        labelAtaqueDescricao2.setText("");
        labelAtaqueDescricao3.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelDuelo = new javax.swing.JPanel();
        painelVitoria = new javax.swing.JPanel();
        jogador2 = new javax.swing.JLabel();
        jogador1 = new javax.swing.JLabel();
        jogador = new javax.swing.JLabel();
        voltar1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        textoHistoria1 = new javax.swing.JLabel();
        textoHistoria2 = new javax.swing.JLabel();
        textoHistoria3 = new javax.swing.JLabel();
        painelPlayer1 = new javax.swing.JPanel();
        avatarPlayer1 = new javax.swing.JLabel();
        bordaPlayer1 = new javax.swing.JLabel();
        exibirPlayer1 = new javax.swing.JLabel();
        exibirClassePlayer1 = new javax.swing.JLabel();
        exibirEstaminaStatusPlayer1 = new javax.swing.JLabel();
        exibirVidaStatusPlayer1 = new javax.swing.JLabel();
        textoST = new javax.swing.JLabel();
        exibirEstaminaPlayer1 = new javax.swing.JProgressBar();
        textoVida = new javax.swing.JLabel();
        exibirVidaPlayer1 = new javax.swing.JProgressBar();
        painelPlayer2 = new javax.swing.JPanel();
        avatarPlayer2 = new javax.swing.JLabel();
        bordaPlayer2 = new javax.swing.JLabel();
        exibirPlayer2 = new javax.swing.JLabel();
        exibirClassePlayer2 = new javax.swing.JLabel();
        exibirEstaminaStatusPlayer2 = new javax.swing.JLabel();
        exibirVidaStatusPlayer2 = new javax.swing.JLabel();
        textoST1 = new javax.swing.JLabel();
        exibirEstaminaPlayer2 = new javax.swing.JProgressBar();
        textoVida1 = new javax.swing.JLabel();
        exibirVidaPlayer2 = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        abrirConfiguracoes1 = new javax.swing.JButton();
        voltar = new javax.swing.JButton();
        painelAtaquePlayer1 = new javax.swing.JPanel();
        aguarde1 = new javax.swing.JLabel();
        ataque1Player1 = new javax.swing.JButton();
        ataque2Player1 = new javax.swing.JButton();
        ataque3Player1 = new javax.swing.JButton();
        ataque4Player1 = new javax.swing.JButton();
        ataque5Player1 = new javax.swing.JButton();
        ataque6Player1 = new javax.swing.JButton();
        painelAtaquePlayer2 = new javax.swing.JPanel();
        aguarde2 = new javax.swing.JLabel();
        ataque1Player2 = new javax.swing.JButton();
        ataque2Player2 = new javax.swing.JButton();
        ataque3Player2 = new javax.swing.JButton();
        ataque4Player2 = new javax.swing.JButton();
        ataque5Player2 = new javax.swing.JButton();
        ataque6Player2 = new javax.swing.JButton();
        painelHabilidadesPlayer1 = new javax.swing.JPanel();
        labelNomeAtaque = new javax.swing.JLabel();
        labelAtaqueDescricao1 = new javax.swing.JLabel();
        labelAtaqueDescricao2 = new javax.swing.JLabel();
        labelAtaqueDescricao3 = new javax.swing.JLabel();
        fundoBatalha = new javax.swing.JLabel();
        painelCarregamento = new javax.swing.JPanel();
        barraCarregamento = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        fundoCarregamento = new javax.swing.JLabel();
        painelEscolha = new javax.swing.JPanel();
        player1 = new javax.swing.JLabel();
        player1Classe = new javax.swing.JLabel();
        player2 = new javax.swing.JLabel();
        player2Classe = new javax.swing.JLabel();
        Vs = new javax.swing.JLabel();
        proximoPlayer1 = new javax.swing.JButton();
        anteriorPlayer1 = new javax.swing.JButton();
        anteriorPlayer2 = new javax.swing.JButton();
        proximoPlayer2 = new javax.swing.JButton();
        iniciarDuelo = new javax.swing.JButton();
        sair = new javax.swing.JButton();
        fundoEscolha = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setUndecorated(true);
        setSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        painelDuelo.setMaximumSize(new java.awt.Dimension(1280, 720));
        painelDuelo.setMinimumSize(new java.awt.Dimension(1280, 720));
        painelDuelo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        painelVitoria.setBackground(new java.awt.Color(152, 152, 152));
        painelVitoria.setForeground(new java.awt.Color(152, 152, 152));
        painelVitoria.setMaximumSize(new java.awt.Dimension(840, 460));
        painelVitoria.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jogador2.setFont(new java.awt.Font("Ink Free", 0, 48)); // NOI18N
        jogador2.setForeground(new java.awt.Color(60, 60, 60));
        jogador2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jogador2.setText("Por vencer o duelo");
        painelVitoria.add(jogador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 450, 63));

        jogador1.setFont(new java.awt.Font("Ink Free", 0, 34)); // NOI18N
        jogador1.setForeground(new java.awt.Color(60, 60, 60));
        jogador1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jogador1.setText("Parabéns ao");
        painelVitoria.add(jogador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 290, 63));

        jogador.setFont(new java.awt.Font("Ink Free", 1, 40)); // NOI18N
        jogador.setForeground(new java.awt.Color(60, 60, 60));
        jogador.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jogador.setText("Player 1");
        painelVitoria.add(jogador, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, 240, 63));

        voltar1.setBackground(new java.awt.Color(172, 172, 172));
        voltar1.setFont(new java.awt.Font("Ink Free", 0, 30)); // NOI18N
        voltar1.setForeground(new java.awt.Color(60, 60, 60));
        voltar1.setText("Voltar");
        voltar1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        voltar1.setBorderPainted(false);
        voltar1.setContentAreaFilled(false);
        voltar1.setFocusable(false);
        voltar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                voltar1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                voltar1MouseExited(evt);
            }
        });
        voltar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltar1ActionPerformed(evt);
            }
        });
        painelVitoria.add(voltar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 390, 270, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/telaVitoria.png"))); // NOI18N
        painelVitoria.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 460));

        painelDuelo.add(painelVitoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 840, 460));

        textoHistoria1.setFont(new java.awt.Font("Dubai Medium", 0, 24)); // NOI18N
        textoHistoria1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        painelDuelo.add(textoHistoria1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 1260, 30));

        textoHistoria2.setFont(new java.awt.Font("Dubai Medium", 0, 24)); // NOI18N
        textoHistoria2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        painelDuelo.add(textoHistoria2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 1260, 30));

        textoHistoria3.setFont(new java.awt.Font("Dubai Medium", 0, 24)); // NOI18N
        textoHistoria3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        painelDuelo.add(textoHistoria3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 1260, 30));

        painelPlayer1.setOpaque(false);
        painelPlayer1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        painelPlayer1.add(avatarPlayer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 100));

        bordaPlayer1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/bordaHistoria.png"))); // NOI18N
        painelPlayer1.add(bordaPlayer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 8, 110, 110));

        exibirPlayer1.setFont(new java.awt.Font("Freshman", 0, 20)); // NOI18N
        exibirPlayer1.setText("Player 1");
        painelPlayer1.add(exibirPlayer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 320, 30));

        exibirClassePlayer1.setFont(new java.awt.Font("MV Boli", 0, 16)); // NOI18N
        exibirClassePlayer1.setText("Classe");
        painelPlayer1.add(exibirClassePlayer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 80, -1));

        exibirEstaminaStatusPlayer1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exibirEstaminaStatusPlayer1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        exibirEstaminaStatusPlayer1.setMaximumSize(new java.awt.Dimension(170, 17));
        exibirEstaminaStatusPlayer1.setMinimumSize(new java.awt.Dimension(170, 17));
        exibirEstaminaStatusPlayer1.setPreferredSize(new java.awt.Dimension(170, 17));
        painelPlayer1.add(exibirEstaminaStatusPlayer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 170, 17));

        exibirVidaStatusPlayer1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exibirVidaStatusPlayer1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        exibirVidaStatusPlayer1.setMaximumSize(new java.awt.Dimension(170, 17));
        exibirVidaStatusPlayer1.setMinimumSize(new java.awt.Dimension(170, 17));
        exibirVidaStatusPlayer1.setPreferredSize(new java.awt.Dimension(170, 17));
        painelPlayer1.add(exibirVidaStatusPlayer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 170, 17));

        textoST.setText("ST");
        painelPlayer1.add(textoST, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, -1, -1));

        exibirEstaminaPlayer1.setBackground(new java.awt.Color(156, 156, 156));
        exibirEstaminaPlayer1.setForeground(new java.awt.Color(181, 196, 0));
        exibirEstaminaPlayer1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        exibirEstaminaPlayer1.setMaximumSize(new java.awt.Dimension(170, 15));
        exibirEstaminaPlayer1.setMinimumSize(new java.awt.Dimension(170, 15));
        exibirEstaminaPlayer1.setPreferredSize(new java.awt.Dimension(170, 15));
        painelPlayer1.add(exibirEstaminaPlayer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, -1, -1));

        textoVida.setText(" HP");
        painelPlayer1.add(textoVida, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, -1, -1));

        exibirVidaPlayer1.setBackground(new java.awt.Color(156, 156, 156));
        exibirVidaPlayer1.setForeground(new java.awt.Color(175, 30, 30));
        exibirVidaPlayer1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        exibirVidaPlayer1.setMaximumSize(new java.awt.Dimension(170, 17));
        exibirVidaPlayer1.setMinimumSize(new java.awt.Dimension(170, 17));
        exibirVidaPlayer1.setPreferredSize(new java.awt.Dimension(170, 17));
        painelPlayer1.add(exibirVidaPlayer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, -1, -1));

        painelDuelo.add(painelPlayer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 120));

        painelPlayer2.setOpaque(false);
        painelPlayer2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        painelPlayer2.add(avatarPlayer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 100, 100));

        bordaPlayer2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/bordaHistoria.png"))); // NOI18N
        painelPlayer2.add(bordaPlayer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 110, 110));

        exibirPlayer2.setFont(new java.awt.Font("Freshman", 0, 20)); // NOI18N
        exibirPlayer2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        exibirPlayer2.setText("Player 2");
        painelPlayer2.add(exibirPlayer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 320, 30));

        exibirClassePlayer2.setFont(new java.awt.Font("MV Boli", 0, 16)); // NOI18N
        exibirClassePlayer2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        exibirClassePlayer2.setText("Classe");
        painelPlayer2.add(exibirClassePlayer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 100, -1));

        exibirEstaminaStatusPlayer2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exibirEstaminaStatusPlayer2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        exibirEstaminaStatusPlayer2.setMaximumSize(new java.awt.Dimension(170, 17));
        exibirEstaminaStatusPlayer2.setMinimumSize(new java.awt.Dimension(170, 17));
        exibirEstaminaStatusPlayer2.setPreferredSize(new java.awt.Dimension(170, 17));
        painelPlayer2.add(exibirEstaminaStatusPlayer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 170, 17));

        exibirVidaStatusPlayer2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exibirVidaStatusPlayer2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        exibirVidaStatusPlayer2.setMaximumSize(new java.awt.Dimension(170, 17));
        exibirVidaStatusPlayer2.setMinimumSize(new java.awt.Dimension(170, 17));
        exibirVidaStatusPlayer2.setPreferredSize(new java.awt.Dimension(170, 17));
        painelPlayer2.add(exibirVidaStatusPlayer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 170, 17));

        textoST1.setText("ST");
        painelPlayer2.add(textoST1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, -1, -1));

        exibirEstaminaPlayer2.setBackground(new java.awt.Color(156, 156, 156));
        exibirEstaminaPlayer2.setForeground(new java.awt.Color(181, 196, 0));
        exibirEstaminaPlayer2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        exibirEstaminaPlayer2.setMaximumSize(new java.awt.Dimension(170, 15));
        exibirEstaminaPlayer2.setMinimumSize(new java.awt.Dimension(170, 15));
        exibirEstaminaPlayer2.setPreferredSize(new java.awt.Dimension(170, 15));
        painelPlayer2.add(exibirEstaminaPlayer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, -1, -1));

        textoVida1.setText(" HP");
        painelPlayer2.add(textoVida1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, -1, -1));

        exibirVidaPlayer2.setBackground(new java.awt.Color(156, 156, 156));
        exibirVidaPlayer2.setForeground(new java.awt.Color(175, 30, 30));
        exibirVidaPlayer2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        exibirVidaPlayer2.setMaximumSize(new java.awt.Dimension(170, 17));
        exibirVidaPlayer2.setMinimumSize(new java.awt.Dimension(170, 17));
        exibirVidaPlayer2.setPreferredSize(new java.awt.Dimension(170, 17));
        painelPlayer2.add(exibirVidaPlayer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, -1, -1));

        painelDuelo.add(painelPlayer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 490, 120));

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        abrirConfiguracoes1.setBackground(new java.awt.Color(172, 172, 172));
        abrirConfiguracoes1.setFont(new java.awt.Font("Impact", 0, 20)); // NOI18N
        abrirConfiguracoes1.setForeground(new java.awt.Color(60, 60, 60));
        abrirConfiguracoes1.setText("Configurações");
        abrirConfiguracoes1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        abrirConfiguracoes1.setBorderPainted(false);
        abrirConfiguracoes1.setContentAreaFilled(false);
        abrirConfiguracoes1.setFocusable(false);
        abrirConfiguracoes1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                abrirConfiguracoes1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                abrirConfiguracoes1MouseExited(evt);
            }
        });
        abrirConfiguracoes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirConfiguracoes1ActionPerformed(evt);
            }
        });
        jPanel1.add(abrirConfiguracoes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 60, 280, -1));

        voltar.setBackground(new java.awt.Color(172, 172, 172));
        voltar.setFont(new java.awt.Font("Ink Free", 0, 20)); // NOI18N
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
        jPanel1.add(voltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 30, 270, -1));

        painelDuelo.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 630, 280, 90));

        painelAtaquePlayer1.setOpaque(false);
        painelAtaquePlayer1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        aguarde1.setFont(new java.awt.Font("meatloaf sketched", 0, 48)); // NOI18N
        aguarde1.setForeground(new java.awt.Color(60, 60, 60));
        aguarde1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        aguarde1.setText("Aguarde");
        aguarde1.setFocusable(false);
        painelAtaquePlayer1.add(aguarde1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 150, 70));

        ataque1Player1.setFont(new java.awt.Font("meatloaf sketched", 0, 36)); // NOI18N
        ataque1Player1.setForeground(new java.awt.Color(60, 60, 60));
        ataque1Player1.setText("jButton1");
        ataque1Player1.setBorder(null);
        ataque1Player1.setBorderPainted(false);
        ataque1Player1.setContentAreaFilled(false);
        ataque1Player1.setFocusable(false);
        ataque1Player1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ataque1Player1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ataque1Player1MouseExited(evt);
            }
        });
        ataque1Player1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ataque1Player1ActionPerformed(evt);
            }
        });
        painelAtaquePlayer1.add(ataque1Player1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 220, 50));

        ataque2Player1.setFont(new java.awt.Font("meatloaf sketched", 0, 36)); // NOI18N
        ataque2Player1.setForeground(new java.awt.Color(60, 60, 60));
        ataque2Player1.setText("jButton2");
        ataque2Player1.setBorder(null);
        ataque2Player1.setBorderPainted(false);
        ataque2Player1.setContentAreaFilled(false);
        ataque2Player1.setFocusable(false);
        ataque2Player1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ataque2Player1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ataque2Player1MouseExited(evt);
            }
        });
        ataque2Player1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ataque2Player1ActionPerformed(evt);
            }
        });
        painelAtaquePlayer1.add(ataque2Player1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 290, 220, 50));

        ataque3Player1.setFont(new java.awt.Font("meatloaf sketched", 0, 36)); // NOI18N
        ataque3Player1.setForeground(new java.awt.Color(60, 60, 60));
        ataque3Player1.setText("jButton3");
        ataque3Player1.setBorder(null);
        ataque3Player1.setBorderPainted(false);
        ataque3Player1.setContentAreaFilled(false);
        ataque3Player1.setFocusable(false);
        ataque3Player1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ataque3Player1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ataque3Player1MouseExited(evt);
            }
        });
        ataque3Player1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ataque3Player1ActionPerformed(evt);
            }
        });
        painelAtaquePlayer1.add(ataque3Player1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 220, 50));

        ataque4Player1.setFont(new java.awt.Font("meatloaf sketched", 0, 36)); // NOI18N
        ataque4Player1.setForeground(new java.awt.Color(60, 60, 60));
        ataque4Player1.setText("jButton4");
        ataque4Player1.setBorder(null);
        ataque4Player1.setBorderPainted(false);
        ataque4Player1.setContentAreaFilled(false);
        ataque4Player1.setFocusable(false);
        ataque4Player1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ataque4Player1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ataque4Player1MouseExited(evt);
            }
        });
        ataque4Player1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ataque4Player1ActionPerformed(evt);
            }
        });
        painelAtaquePlayer1.add(ataque4Player1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 360, 220, 50));

        ataque5Player1.setFont(new java.awt.Font("meatloaf sketched", 0, 36)); // NOI18N
        ataque5Player1.setForeground(new java.awt.Color(60, 60, 60));
        ataque5Player1.setText("jButton5");
        ataque5Player1.setBorder(null);
        ataque5Player1.setBorderPainted(false);
        ataque5Player1.setContentAreaFilled(false);
        ataque5Player1.setFocusable(false);
        ataque5Player1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ataque5Player1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ataque5Player1MouseExited(evt);
            }
        });
        ataque5Player1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ataque5Player1ActionPerformed(evt);
            }
        });
        painelAtaquePlayer1.add(ataque5Player1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 220, 50));

        ataque6Player1.setFont(new java.awt.Font("meatloaf sketched", 0, 36)); // NOI18N
        ataque6Player1.setForeground(new java.awt.Color(60, 60, 60));
        ataque6Player1.setText("jButton6");
        ataque6Player1.setBorder(null);
        ataque6Player1.setBorderPainted(false);
        ataque6Player1.setContentAreaFilled(false);
        ataque6Player1.setFocusable(false);
        ataque6Player1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ataque6Player1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ataque6Player1MouseExited(evt);
            }
        });
        ataque6Player1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ataque6Player1ActionPerformed(evt);
            }
        });
        painelAtaquePlayer1.add(ataque6Player1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 430, 220, 50));

        painelDuelo.add(painelAtaquePlayer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 480, 510));

        painelAtaquePlayer2.setOpaque(false);
        painelAtaquePlayer2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        aguarde2.setFont(new java.awt.Font("meatloaf sketched", 0, 48)); // NOI18N
        aguarde2.setForeground(new java.awt.Color(60, 60, 60));
        aguarde2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        aguarde2.setText("Aguarde");
        aguarde2.setFocusable(false);
        painelAtaquePlayer2.add(aguarde2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, 150, 70));

        ataque1Player2.setFont(new java.awt.Font("meatloaf sketched", 0, 36)); // NOI18N
        ataque1Player2.setForeground(new java.awt.Color(60, 60, 60));
        ataque1Player2.setText("jButton1");
        ataque1Player2.setBorder(null);
        ataque1Player2.setBorderPainted(false);
        ataque1Player2.setContentAreaFilled(false);
        ataque1Player2.setFocusable(false);
        ataque1Player2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ataque1Player2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ataque1Player2MouseExited(evt);
            }
        });
        ataque1Player2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ataque1Player2ActionPerformed(evt);
            }
        });
        painelAtaquePlayer2.add(ataque1Player2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 220, 50));

        ataque2Player2.setFont(new java.awt.Font("meatloaf sketched", 0, 36)); // NOI18N
        ataque2Player2.setForeground(new java.awt.Color(60, 60, 60));
        ataque2Player2.setText("jButton2");
        ataque2Player2.setBorder(null);
        ataque2Player2.setBorderPainted(false);
        ataque2Player2.setContentAreaFilled(false);
        ataque2Player2.setFocusable(false);
        ataque2Player2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ataque2Player2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ataque2Player2MouseExited(evt);
            }
        });
        ataque2Player2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ataque2Player2ActionPerformed(evt);
            }
        });
        painelAtaquePlayer2.add(ataque2Player2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, 220, 50));

        ataque3Player2.setFont(new java.awt.Font("meatloaf sketched", 0, 36)); // NOI18N
        ataque3Player2.setForeground(new java.awt.Color(60, 60, 60));
        ataque3Player2.setText("jButton3");
        ataque3Player2.setBorder(null);
        ataque3Player2.setBorderPainted(false);
        ataque3Player2.setContentAreaFilled(false);
        ataque3Player2.setFocusable(false);
        ataque3Player2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ataque3Player2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ataque3Player2MouseExited(evt);
            }
        });
        ataque3Player2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ataque3Player2ActionPerformed(evt);
            }
        });
        painelAtaquePlayer2.add(ataque3Player2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 220, 50));

        ataque4Player2.setFont(new java.awt.Font("meatloaf sketched", 0, 36)); // NOI18N
        ataque4Player2.setForeground(new java.awt.Color(60, 60, 60));
        ataque4Player2.setText("jButton4");
        ataque4Player2.setBorder(null);
        ataque4Player2.setBorderPainted(false);
        ataque4Player2.setContentAreaFilled(false);
        ataque4Player2.setFocusable(false);
        ataque4Player2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ataque4Player2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ataque4Player2MouseExited(evt);
            }
        });
        ataque4Player2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ataque4Player2ActionPerformed(evt);
            }
        });
        painelAtaquePlayer2.add(ataque4Player2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 370, 220, 50));

        ataque5Player2.setFont(new java.awt.Font("meatloaf sketched", 0, 36)); // NOI18N
        ataque5Player2.setForeground(new java.awt.Color(60, 60, 60));
        ataque5Player2.setText("jButton5");
        ataque5Player2.setBorder(null);
        ataque5Player2.setBorderPainted(false);
        ataque5Player2.setContentAreaFilled(false);
        ataque5Player2.setFocusable(false);
        ataque5Player2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ataque5Player2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ataque5Player2MouseExited(evt);
            }
        });
        ataque5Player2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ataque5Player2ActionPerformed(evt);
            }
        });
        painelAtaquePlayer2.add(ataque5Player2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 220, 50));

        ataque6Player2.setFont(new java.awt.Font("meatloaf sketched", 0, 36)); // NOI18N
        ataque6Player2.setForeground(new java.awt.Color(60, 60, 60));
        ataque6Player2.setText("jButton6");
        ataque6Player2.setBorder(null);
        ataque6Player2.setBorderPainted(false);
        ataque6Player2.setContentAreaFilled(false);
        ataque6Player2.setFocusable(false);
        ataque6Player2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ataque6Player2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ataque6Player2MouseExited(evt);
            }
        });
        ataque6Player2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ataque6Player2ActionPerformed(evt);
            }
        });
        painelAtaquePlayer2.add(ataque6Player2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 440, 220, 50));

        painelDuelo.add(painelAtaquePlayer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 200, 490, 520));

        painelHabilidadesPlayer1.setOpaque(false);

        labelNomeAtaque.setFont(new java.awt.Font("Javanese Text", 1, 18)); // NOI18N
        labelNomeAtaque.setForeground(new java.awt.Color(60, 60, 60));
        labelNomeAtaque.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNomeAtaque.setText("Ataque");
        labelNomeAtaque.setFocusable(false);

        labelAtaqueDescricao1.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        labelAtaqueDescricao1.setForeground(new java.awt.Color(60, 60, 60));
        labelAtaqueDescricao1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAtaqueDescricao1.setText("Descricao");
        labelAtaqueDescricao1.setFocusable(false);

        labelAtaqueDescricao2.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        labelAtaqueDescricao2.setForeground(new java.awt.Color(60, 60, 60));
        labelAtaqueDescricao2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAtaqueDescricao2.setText("Descricao");
        labelAtaqueDescricao2.setFocusable(false);

        labelAtaqueDescricao3.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        labelAtaqueDescricao3.setForeground(new java.awt.Color(60, 60, 60));
        labelAtaqueDescricao3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAtaqueDescricao3.setText("Descricao");
        labelAtaqueDescricao3.setFocusable(false);

        javax.swing.GroupLayout painelHabilidadesPlayer1Layout = new javax.swing.GroupLayout(painelHabilidadesPlayer1);
        painelHabilidadesPlayer1.setLayout(painelHabilidadesPlayer1Layout);
        painelHabilidadesPlayer1Layout.setHorizontalGroup(
            painelHabilidadesPlayer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelNomeAtaque, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(painelHabilidadesPlayer1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelHabilidadesPlayer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelAtaqueDescricao1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painelHabilidadesPlayer1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(labelAtaqueDescricao3, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 18, Short.MAX_VALUE))
                    .addComponent(labelAtaqueDescricao2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        painelHabilidadesPlayer1Layout.setVerticalGroup(
            painelHabilidadesPlayer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelHabilidadesPlayer1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelNomeAtaque, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelAtaqueDescricao1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelAtaqueDescricao2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelAtaqueDescricao3)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        painelDuelo.add(painelHabilidadesPlayer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 440, -1, -1));

        fundoBatalha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/DueloBatalhaRPG.png"))); // NOI18N
        painelDuelo.add(fundoBatalha, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        getContentPane().add(painelDuelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        painelCarregamento.setMaximumSize(new java.awt.Dimension(1280, 720));
        painelCarregamento.setMinimumSize(new java.awt.Dimension(1280, 720));
        painelCarregamento.setPreferredSize(new java.awt.Dimension(1280, 720));
        painelCarregamento.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        barraCarregamento.setBackground(new java.awt.Color(204, 204, 204));
        barraCarregamento.setForeground(new java.awt.Color(135, 135, 135));
        barraCarregamento.setMaximum(10);
        barraCarregamento.setBorderPainted(false);
        barraCarregamento.setFocusable(false);
        barraCarregamento.setRequestFocusEnabled(false);
        barraCarregamento.setVerifyInputWhenFocusTarget(false);
        painelCarregamento.add(barraCarregamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 670, 1190, 20));

        jLabel1.setFont(new java.awt.Font("Dubai Medium", 2, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(60, 60, 60));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Carregando...");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        painelCarregamento.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 610, 1190, -1));

        fundoCarregamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundoCarregamento.png"))); // NOI18N
        fundoCarregamento.setText("]");
        painelCarregamento.add(fundoCarregamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        getContentPane().add(painelCarregamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        painelEscolha.setMaximumSize(new java.awt.Dimension(1280, 720));
        painelEscolha.setMinimumSize(new java.awt.Dimension(1280, 720));
        painelEscolha.setPreferredSize(new java.awt.Dimension(1280, 720));
        painelEscolha.setRequestFocusEnabled(false);
        painelEscolha.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        player1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/berserk_1.png"))); // NOI18N
        player1.setFocusable(false);
        painelEscolha.add(player1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, -1, -1));

        player1Classe.setFont(new java.awt.Font("Ink Free", 0, 36)); // NOI18N
        player1Classe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        player1Classe.setText("Player 1");
        painelEscolha.add(player1Classe, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 520, 300, 70));

        player2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/berserk_1.png"))); // NOI18N
        player2.setFocusable(false);
        painelEscolha.add(player2, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 130, -1, -1));

        player2Classe.setFont(new java.awt.Font("Ink Free", 0, 36)); // NOI18N
        player2Classe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        player2Classe.setText("Player 2");
        painelEscolha.add(player2Classe, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 520, 300, 70));

        Vs.setFont(new java.awt.Font("Ink Free", 0, 36)); // NOI18N
        Vs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Vs.setText("Vs");
        painelEscolha.add(Vs, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 520, 300, 70));

        proximoPlayer1.setFont(new java.awt.Font("Impact", 0, 22)); // NOI18N
        proximoPlayer1.setText("Próximo");
        proximoPlayer1.setBorderPainted(false);
        proximoPlayer1.setContentAreaFilled(false);
        proximoPlayer1.setFocusable(false);
        proximoPlayer1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                proximoPlayer1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                proximoPlayer1MouseExited(evt);
            }
        });
        proximoPlayer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proximoPlayer1ActionPerformed(evt);
            }
        });
        painelEscolha.add(proximoPlayer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 460, 130, -1));

        anteriorPlayer1.setFont(new java.awt.Font("Impact", 0, 22)); // NOI18N
        anteriorPlayer1.setText("Anterior");
        anteriorPlayer1.setBorderPainted(false);
        anteriorPlayer1.setContentAreaFilled(false);
        anteriorPlayer1.setFocusable(false);
        anteriorPlayer1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                anteriorPlayer1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                anteriorPlayer1MouseExited(evt);
            }
        });
        anteriorPlayer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteriorPlayer1ActionPerformed(evt);
            }
        });
        painelEscolha.add(anteriorPlayer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 460, 130, -1));

        anteriorPlayer2.setFont(new java.awt.Font("Impact", 0, 22)); // NOI18N
        anteriorPlayer2.setText("Anterior");
        anteriorPlayer2.setBorderPainted(false);
        anteriorPlayer2.setContentAreaFilled(false);
        anteriorPlayer2.setFocusable(false);
        anteriorPlayer2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                anteriorPlayer2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                anteriorPlayer2MouseExited(evt);
            }
        });
        anteriorPlayer2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteriorPlayer2ActionPerformed(evt);
            }
        });
        painelEscolha.add(anteriorPlayer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 460, 130, -1));

        proximoPlayer2.setFont(new java.awt.Font("Impact", 0, 22)); // NOI18N
        proximoPlayer2.setText("Próximo");
        proximoPlayer2.setBorderPainted(false);
        proximoPlayer2.setContentAreaFilled(false);
        proximoPlayer2.setFocusable(false);
        proximoPlayer2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                proximoPlayer2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                proximoPlayer2MouseExited(evt);
            }
        });
        proximoPlayer2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proximoPlayer2ActionPerformed(evt);
            }
        });
        painelEscolha.add(proximoPlayer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 460, 130, -1));

        iniciarDuelo.setFont(new java.awt.Font("Impact", 1, 40)); // NOI18N
        iniciarDuelo.setText("Iníciar");
        iniciarDuelo.setBorderPainted(false);
        iniciarDuelo.setContentAreaFilled(false);
        iniciarDuelo.setFocusable(false);
        iniciarDuelo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                iniciarDueloMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                iniciarDueloMouseExited(evt);
            }
        });
        iniciarDuelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarDueloActionPerformed(evt);
            }
        });
        painelEscolha.add(iniciarDuelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 615, 250, 60));

        sair.setBackground(new java.awt.Color(172, 172, 172));
        sair.setFont(new java.awt.Font("Ink Free", 1, 20)); // NOI18N
        sair.setText("Voltar");
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
        painelEscolha.add(sair, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 680, 150, 40));

        fundoEscolha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/DueloEscolhaRPG.png"))); // NOI18N
        painelEscolha.add(fundoEscolha, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        getContentPane().add(painelEscolha, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void anteriorPlayer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorPlayer1ActionPerformed
        if(contPlayer1 == 0){ 
            contPlayer1 = 3;
        }else{
            contPlayer1 = 0;
        }
        
        imagemPlayer1();
    }//GEN-LAST:event_anteriorPlayer1ActionPerformed

    private void proximoPlayer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proximoPlayer1ActionPerformed
        if(contPlayer1 == 3){ 
            contPlayer1 = 0;
        }else{
            contPlayer1 = 3;
        }
        
        imagemPlayer1();
    }//GEN-LAST:event_proximoPlayer1ActionPerformed

    private void anteriorPlayer2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorPlayer2ActionPerformed
        if(contPlayer2 == 0){ 
            contPlayer2 = 3;
        }else{
            contPlayer2 = 0;
        }
        
        imagemPlayer2();
    }//GEN-LAST:event_anteriorPlayer2ActionPerformed

    private void proximoPlayer2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proximoPlayer2ActionPerformed
        if(contPlayer2 == 3){ 
            contPlayer2 = 0;
        }else{
            contPlayer2 = 3;
        }
        
        imagemPlayer2();
    }//GEN-LAST:event_proximoPlayer2ActionPerformed

    private void sairMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sairMouseEntered
        sair.setForeground(new Color(172,172,172));
    }//GEN-LAST:event_sairMouseEntered

    private void sairMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sairMouseExited
        sair.setForeground(new Color(60,60,60));
    }//GEN-LAST:event_sairMouseExited

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed

        new telaInicio().setVisible(true);
        this.dispose();

    }//GEN-LAST:event_sairActionPerformed

    private void iniciarDueloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarDueloActionPerformed
        painelEscolha.setVisible(false);
        painelEscolha.setEnabled(false);
        anteriorPlayer1.setEnabled(false);
        proximoPlayer1.setEnabled(false);
        anteriorPlayer2.setEnabled(false);
        proximoPlayer2.setEnabled(false);
        
        sair.setEnabled(false);
        
        vidaBarraPlayer1 = vidaBarraTotalPlayer1;
        vidaBarraPlayer2 = vidaBarraTotalPlayer2;
        estaminaBarraPlayer1 = estaminaBarraTotalPlayer1;
        estaminaBarraPlayer2 = estaminaBarraTotalPlayer2;
        textoHistoria2.setText("");
        
        painelCarregamento.setVisible(true);
        sorte = geradorSorte.nextInt(2) + 1;
        vez = sorte;
        carregamento();
    }//GEN-LAST:event_iniciarDueloActionPerformed

    private void abrirConfiguracoes1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abrirConfiguracoes1MouseEntered
        abrirConfiguracoes1.setForeground(new Color(0,0,0));
    }//GEN-LAST:event_abrirConfiguracoes1MouseEntered

    private void abrirConfiguracoes1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abrirConfiguracoes1MouseExited
        abrirConfiguracoes1.setForeground(new Color(60,60,60));
    }//GEN-LAST:event_abrirConfiguracoes1MouseExited

    private void abrirConfiguracoes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirConfiguracoes1ActionPerformed
        telaConfiguracaoChamar.setVisible(true);
    }//GEN-LAST:event_abrirConfiguracoes1ActionPerformed

    private void voltarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_voltarMouseEntered
        voltar.setForeground(new Color(0,0,0));
    }//GEN-LAST:event_voltarMouseEntered

    private void voltarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_voltarMouseExited
        voltar.setForeground(new Color(60,60,60));
    }//GEN-LAST:event_voltarMouseExited

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
        painelDuelo.setVisible(false);
        painelDuelo.setEnabled(false);
        painelCarregamento.setVisible(false);
        painelCarregamento.setEnabled(false);
        painelEscolha.setVisible(true);
        painelEscolha.setEnabled(true);
        anteriorPlayer1.setEnabled(true);
        anteriorPlayer2.setEnabled(true);
        proximoPlayer1.setEnabled(true);
        proximoPlayer2.setEnabled(true);
        sair.setEnabled(true);
        
    }//GEN-LAST:event_voltarActionPerformed

    private void ataque1Player1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ataque1Player1ActionPerformed
        vez = 1;
        
        contAtaque = 1;
        carregarAtaque();
        setInfo();
       
    }//GEN-LAST:event_ataque1Player1ActionPerformed

    private void ataque2Player1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ataque2Player1ActionPerformed
        vez = 1;
        
        contAtaque = 2;
        carregarAtaque();
        setInfo();
    }//GEN-LAST:event_ataque2Player1ActionPerformed

    private void ataque3Player1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ataque3Player1ActionPerformed
        vez = 1;
        
        contAtaque = 3;
        carregarAtaque();
        setInfo();
    }//GEN-LAST:event_ataque3Player1ActionPerformed

    private void ataque4Player1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ataque4Player1ActionPerformed
        vez = 1;
        
        contAtaque = 4;
        carregarAtaque();
        setInfo();
    }//GEN-LAST:event_ataque4Player1ActionPerformed

    private void ataque5Player1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ataque5Player1ActionPerformed
        vez = 1;
        
        contAtaque = 5;
        carregarAtaque();
        setInfo();
    }//GEN-LAST:event_ataque5Player1ActionPerformed

    private void ataque6Player1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ataque6Player1ActionPerformed
        vez = 1;
        
        contAtaque = 6;
        carregarAtaque();
        setInfo();
    }//GEN-LAST:event_ataque6Player1ActionPerformed

    private void ataque1Player2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ataque1Player2ActionPerformed
        vez = 2;
        
        contAtaque = 1;
        carregarAtaque();
        setInfo();
    }//GEN-LAST:event_ataque1Player2ActionPerformed

    private void ataque2Player2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ataque2Player2ActionPerformed
        vez = 2;
        
        contAtaque = 2;
        carregarAtaque();
        setInfo();
    }//GEN-LAST:event_ataque2Player2ActionPerformed

    private void ataque3Player2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ataque3Player2ActionPerformed
        vez = 2;
        
        contAtaque = 3;
        carregarAtaque();
        setInfo();
    }//GEN-LAST:event_ataque3Player2ActionPerformed

    private void ataque4Player2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ataque4Player2ActionPerformed
        vez = 2;
        
        contAtaque = 4;
        carregarAtaque();
        setInfo();
    }//GEN-LAST:event_ataque4Player2ActionPerformed

    private void ataque5Player2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ataque5Player2ActionPerformed
        vez = 2;
        
        contAtaque = 5;
        carregarAtaque();
        setInfo();
    }//GEN-LAST:event_ataque5Player2ActionPerformed

    private void ataque6Player2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ataque6Player2ActionPerformed
        vez = 2;
        
        contAtaque = 6;
        carregarAtaque();
        setInfo();
    }//GEN-LAST:event_ataque6Player2ActionPerformed

    private void anteriorPlayer1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_anteriorPlayer1MouseEntered
        anteriorPlayer1.setForeground(new Color(172,172,172));
    }//GEN-LAST:event_anteriorPlayer1MouseEntered

    private void anteriorPlayer1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_anteriorPlayer1MouseExited
        anteriorPlayer1.setForeground(new Color(60,60,60));
    }//GEN-LAST:event_anteriorPlayer1MouseExited

    private void proximoPlayer1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_proximoPlayer1MouseEntered
        proximoPlayer1.setForeground(new Color(172,172,172));
    }//GEN-LAST:event_proximoPlayer1MouseEntered

    private void proximoPlayer1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_proximoPlayer1MouseExited
        proximoPlayer1.setForeground(new Color(60,60,60));
    }//GEN-LAST:event_proximoPlayer1MouseExited

    private void anteriorPlayer2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_anteriorPlayer2MouseExited
        anteriorPlayer2.setForeground(new Color(60,60,60));
    }//GEN-LAST:event_anteriorPlayer2MouseExited

    private void anteriorPlayer2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_anteriorPlayer2MouseEntered
        anteriorPlayer2.setForeground(new Color(172,172,172));
    }//GEN-LAST:event_anteriorPlayer2MouseEntered

    private void proximoPlayer2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_proximoPlayer2MouseExited
        proximoPlayer2.setForeground(new Color(60,60,60));
    }//GEN-LAST:event_proximoPlayer2MouseExited

    private void proximoPlayer2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_proximoPlayer2MouseEntered
        proximoPlayer2.setForeground(new Color(172,172,172));
    }//GEN-LAST:event_proximoPlayer2MouseEntered

    private void iniciarDueloMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iniciarDueloMouseExited
        iniciarDuelo.setForeground(new Color(60,60,60));
    }//GEN-LAST:event_iniciarDueloMouseExited

    private void iniciarDueloMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iniciarDueloMouseEntered
        iniciarDuelo.setForeground(new Color(172,172,172));
    }//GEN-LAST:event_iniciarDueloMouseEntered

    private void ataque1Player1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ataque1Player1MouseEntered
        ataque1Player1.setForeground(new Color(0,0,0));
        if(contPlayer1 == 0){
            labelNomeAtaque.setText("Ataque Normal");
            labelAtaqueDescricao1.setText("");
            labelAtaqueDescricao2.setText("");
            labelAtaqueDescricao3.setText("");
        }
    }//GEN-LAST:event_ataque1Player1MouseEntered

    private void ataque1Player1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ataque1Player1MouseExited
        ataque1Player1.setForeground(new Color(60,60,60));
        
        labelNomeAtaque.setText("");
        labelAtaqueDescricao1.setText("");
        labelAtaqueDescricao2.setText("");
        labelAtaqueDescricao3.setText("");
    }//GEN-LAST:event_ataque1Player1MouseExited

    private void ataque2Player1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ataque2Player1MouseEntered
        ataque2Player1.setForeground(new Color(0,0,0));
        if(contPlayer1 == 0){
            labelNomeAtaque.setText("Grito de Fúria");
            labelAtaqueDescricao1.setText("");
            labelAtaqueDescricao2.setText("");
            labelAtaqueDescricao3.setText("");
        }
    }//GEN-LAST:event_ataque2Player1MouseEntered

    private void ataque2Player1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ataque2Player1MouseExited
        ataque2Player1.setForeground(new Color(60,60,60));
        
        labelNomeAtaque.setText("");
        labelAtaqueDescricao1.setText("");
        labelAtaqueDescricao2.setText("");
        labelAtaqueDescricao3.setText("");
    }//GEN-LAST:event_ataque2Player1MouseExited

    private void ataque3Player1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ataque3Player1MouseEntered
        ataque3Player1.setForeground(new Color(0,0,0));
        if(contPlayer1 == 0){
            labelNomeAtaque.setText("Golpe Aniquilador");
            labelAtaqueDescricao1.setText("");
            labelAtaqueDescricao2.setText("");
            labelAtaqueDescricao3.setText("");
        }
    }//GEN-LAST:event_ataque3Player1MouseEntered

    private void ataque3Player1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ataque3Player1MouseExited
        ataque3Player1.setForeground(new Color(60,60,60));
        
        labelNomeAtaque.setText("");
        labelAtaqueDescricao1.setText("");
        labelAtaqueDescricao2.setText("");
        labelAtaqueDescricao3.setText("");
    }//GEN-LAST:event_ataque3Player1MouseExited

    private void ataque4Player1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ataque4Player1MouseEntered
        ataque4Player1.setForeground(new Color(0,0,0));
        if(contPlayer1 == 0){
            labelNomeAtaque.setText("Fúria Brutal");
            labelAtaqueDescricao1.setText("");
            labelAtaqueDescricao2.setText("");
            labelAtaqueDescricao3.setText("");
        }
    }//GEN-LAST:event_ataque4Player1MouseEntered

    private void ataque4Player1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ataque4Player1MouseExited
        ataque4Player1.setForeground(new Color(60,60,60));
        
        labelNomeAtaque.setText("");
        labelAtaqueDescricao1.setText("");
        labelAtaqueDescricao2.setText("");
        labelAtaqueDescricao3.setText("");
    }//GEN-LAST:event_ataque4Player1MouseExited

    private void ataque5Player1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ataque5Player1MouseEntered
        ataque5Player1.setForeground(new Color(0,0,0));
        labelNomeAtaque.setText("Percepção");
        labelAtaqueDescricao1.setText("");
        labelAtaqueDescricao2.setText("");
        labelAtaqueDescricao3.setText("");
    }//GEN-LAST:event_ataque5Player1MouseEntered

    private void ataque5Player1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ataque5Player1MouseExited
        ataque5Player1.setForeground(new Color(60,60,60));
        
        labelNomeAtaque.setText("");
        labelAtaqueDescricao1.setText("");
        labelAtaqueDescricao2.setText("");
        labelAtaqueDescricao3.setText("");
    }//GEN-LAST:event_ataque5Player1MouseExited

    private void ataque6Player1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ataque6Player1MouseEntered
        ataque6Player1.setForeground(new Color(0,0,0));
        
        labelNomeAtaque.setText("Carisma");
        labelAtaqueDescricao1.setText("");
        labelAtaqueDescricao2.setText("");
        labelAtaqueDescricao3.setText("");
    }//GEN-LAST:event_ataque6Player1MouseEntered

    private void ataque6Player1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ataque6Player1MouseExited
        ataque6Player1.setForeground(new Color(60,60,60));
        
        labelNomeAtaque.setText("");
        labelAtaqueDescricao1.setText("");
        labelAtaqueDescricao2.setText("");
        labelAtaqueDescricao3.setText("");
    }//GEN-LAST:event_ataque6Player1MouseExited

    private void ataque1Player2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ataque1Player2MouseEntered
        ataque1Player2.setForeground(new Color(0,0,0));
        
        if(contPlayer2 == 0){
            labelNomeAtaque.setText("Ataque Normal");
            labelAtaqueDescricao1.setText("");
            labelAtaqueDescricao2.setText("");
            labelAtaqueDescricao3.setText("");
        }
    }//GEN-LAST:event_ataque1Player2MouseEntered

    private void ataque1Player2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ataque1Player2MouseExited
        ataque1Player2.setForeground(new Color(60,60,60));
        
        labelNomeAtaque.setText("");
        labelAtaqueDescricao1.setText("");
        labelAtaqueDescricao2.setText("");
        labelAtaqueDescricao3.setText("");
    }//GEN-LAST:event_ataque1Player2MouseExited

    private void ataque2Player2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ataque2Player2MouseEntered
        ataque2Player2.setForeground(new Color(0,0,0));
        
        if(contPlayer2 == 0){
            labelNomeAtaque.setText("Grito de Fúria");
            labelAtaqueDescricao1.setText("");
            labelAtaqueDescricao2.setText("");
            labelAtaqueDescricao3.setText("");
        }
    }//GEN-LAST:event_ataque2Player2MouseEntered

    private void ataque2Player2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ataque2Player2MouseExited
        ataque2Player2.setForeground(new Color(60,60,60));
        
        labelNomeAtaque.setText("");
        labelAtaqueDescricao1.setText("");
        labelAtaqueDescricao2.setText("");
        labelAtaqueDescricao3.setText("");
    }//GEN-LAST:event_ataque2Player2MouseExited

    private void ataque3Player2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ataque3Player2MouseEntered
        ataque3Player2.setForeground(new Color(0,0,0));
        
        if(contPlayer2 == 0){
            labelNomeAtaque.setText("Golpe Aniquilador");
            labelAtaqueDescricao1.setText("");
            labelAtaqueDescricao2.setText("");
            labelAtaqueDescricao3.setText("");
        }
    }//GEN-LAST:event_ataque3Player2MouseEntered

    private void ataque3Player2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ataque3Player2MouseExited
        ataque3Player2.setForeground(new Color(60,60,60));
        
        labelNomeAtaque.setText("");
        labelAtaqueDescricao1.setText("");
        labelAtaqueDescricao2.setText("");
        labelAtaqueDescricao3.setText("");
    }//GEN-LAST:event_ataque3Player2MouseExited

    private void ataque4Player2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ataque4Player2MouseEntered
        ataque4Player2.setForeground(new Color(0,0,0));
        
        if(contPlayer2 == 0){
            labelNomeAtaque.setText("Golpe Aniquilador");
            labelAtaqueDescricao1.setText("");
            labelAtaqueDescricao2.setText("");
            labelAtaqueDescricao3.setText("");
        }
    }//GEN-LAST:event_ataque4Player2MouseEntered

    private void ataque4Player2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ataque4Player2MouseExited
        ataque4Player2.setForeground(new Color(60,60,60));
        
        labelNomeAtaque.setText("");
        labelAtaqueDescricao1.setText("");
        labelAtaqueDescricao2.setText("");
        labelAtaqueDescricao3.setText("");
    }//GEN-LAST:event_ataque4Player2MouseExited

    private void ataque5Player2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ataque5Player2MouseEntered
        ataque5Player2.setForeground(new Color(0,0,0));
        
        labelNomeAtaque.setText("Percepção");
        labelAtaqueDescricao1.setText("");
        labelAtaqueDescricao2.setText("");
        labelAtaqueDescricao3.setText("");
    }//GEN-LAST:event_ataque5Player2MouseEntered

    private void ataque5Player2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ataque5Player2MouseExited
        ataque5Player2.setForeground(new Color(60,60,60));
        
        labelNomeAtaque.setText("");
        labelAtaqueDescricao1.setText("");
        labelAtaqueDescricao2.setText("");
        labelAtaqueDescricao3.setText("");
    }//GEN-LAST:event_ataque5Player2MouseExited

    private void ataque6Player2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ataque6Player2MouseEntered
        ataque6Player2.setForeground(new Color(0,0,0));
        
        labelNomeAtaque.setText("Carisma");
        labelAtaqueDescricao1.setText("");
        labelAtaqueDescricao2.setText("");
        labelAtaqueDescricao3.setText("");
    }//GEN-LAST:event_ataque6Player2MouseEntered

    private void ataque6Player2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ataque6Player2MouseExited
        ataque6Player2.setForeground(new Color(60,60,60));
        
        labelNomeAtaque.setText("");
        labelAtaqueDescricao1.setText("");
        labelAtaqueDescricao2.setText("");
        labelAtaqueDescricao3.setText("");
    }//GEN-LAST:event_ataque6Player2MouseExited

    private void voltar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_voltar1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_voltar1MouseEntered

    private void voltar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_voltar1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_voltar1MouseExited

    private void voltar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltar1ActionPerformed
        painelDuelo.setVisible(false);
        painelDuelo.setEnabled(false);
        painelCarregamento.setVisible(false);
        painelCarregamento.setEnabled(false);
        painelEscolha.setVisible(true);
        painelEscolha.setEnabled(true);
        anteriorPlayer1.setEnabled(true);
        anteriorPlayer2.setEnabled(true);
        proximoPlayer1.setEnabled(true);
        proximoPlayer2.setEnabled(true);
        painelVitoria.setVisible(false);
        painelVitoria.setEnabled(false);
        

        ataque1Player1.setEnabled(true);
        ataque2Player1.setEnabled(true);
        ataque3Player1.setEnabled(true);
        ataque4Player1.setEnabled(true);
        ataque5Player1.setEnabled(true);
        ataque6Player1.setEnabled(true);
        ataque1Player2.setEnabled(true);
        ataque2Player2.setEnabled(true);
        ataque3Player2.setEnabled(true);
        ataque4Player2.setEnabled(true);
        ataque5Player2.setEnabled(true);
        ataque6Player2.setEnabled(true);
        
            ataque6Player2.setEnabled(false);
        sair.setEnabled(true);
    }//GEN-LAST:event_voltar1ActionPerformed

    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(telaDuelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaDuelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaDuelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaDuelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaDuelo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Vs;
    private javax.swing.JButton abrirConfiguracoes1;
    private javax.swing.JLabel aguarde1;
    private javax.swing.JLabel aguarde2;
    private javax.swing.JButton anteriorPlayer1;
    private javax.swing.JButton anteriorPlayer2;
    private javax.swing.JButton ataque1Player1;
    private javax.swing.JButton ataque1Player2;
    private javax.swing.JButton ataque2Player1;
    private javax.swing.JButton ataque2Player2;
    private javax.swing.JButton ataque3Player1;
    private javax.swing.JButton ataque3Player2;
    private javax.swing.JButton ataque4Player1;
    private javax.swing.JButton ataque4Player2;
    private javax.swing.JButton ataque5Player1;
    private javax.swing.JButton ataque5Player2;
    private javax.swing.JButton ataque6Player1;
    private javax.swing.JButton ataque6Player2;
    private javax.swing.JLabel avatarPlayer1;
    private javax.swing.JLabel avatarPlayer2;
    private javax.swing.JProgressBar barraCarregamento;
    private javax.swing.JLabel bordaPlayer1;
    private javax.swing.JLabel bordaPlayer2;
    private javax.swing.JLabel exibirClassePlayer1;
    private javax.swing.JLabel exibirClassePlayer2;
    private javax.swing.JProgressBar exibirEstaminaPlayer1;
    private javax.swing.JProgressBar exibirEstaminaPlayer2;
    private javax.swing.JLabel exibirEstaminaStatusPlayer1;
    private javax.swing.JLabel exibirEstaminaStatusPlayer2;
    private javax.swing.JLabel exibirPlayer1;
    private javax.swing.JLabel exibirPlayer2;
    private javax.swing.JProgressBar exibirVidaPlayer1;
    private javax.swing.JProgressBar exibirVidaPlayer2;
    private javax.swing.JLabel exibirVidaStatusPlayer1;
    private javax.swing.JLabel exibirVidaStatusPlayer2;
    private javax.swing.JLabel fundoBatalha;
    private javax.swing.JLabel fundoCarregamento;
    private javax.swing.JLabel fundoEscolha;
    private javax.swing.JButton iniciarDuelo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jogador;
    private javax.swing.JLabel jogador1;
    private javax.swing.JLabel jogador2;
    private javax.swing.JLabel labelAtaqueDescricao1;
    private javax.swing.JLabel labelAtaqueDescricao2;
    private javax.swing.JLabel labelAtaqueDescricao3;
    private javax.swing.JLabel labelNomeAtaque;
    private javax.swing.JPanel painelAtaquePlayer1;
    private javax.swing.JPanel painelAtaquePlayer2;
    private javax.swing.JPanel painelCarregamento;
    private javax.swing.JPanel painelDuelo;
    private javax.swing.JPanel painelEscolha;
    private javax.swing.JPanel painelHabilidadesPlayer1;
    private javax.swing.JPanel painelPlayer1;
    private javax.swing.JPanel painelPlayer2;
    private javax.swing.JPanel painelVitoria;
    private javax.swing.JLabel player1;
    private javax.swing.JLabel player1Classe;
    private javax.swing.JLabel player2;
    private javax.swing.JLabel player2Classe;
    private javax.swing.JButton proximoPlayer1;
    private javax.swing.JButton proximoPlayer2;
    private javax.swing.JButton sair;
    private javax.swing.JLabel textoHistoria1;
    private javax.swing.JLabel textoHistoria2;
    private javax.swing.JLabel textoHistoria3;
    private javax.swing.JLabel textoST;
    private javax.swing.JLabel textoST1;
    private javax.swing.JLabel textoVida;
    private javax.swing.JLabel textoVida1;
    private javax.swing.JButton voltar;
    private javax.swing.JButton voltar1;
    // End of variables declaration//GEN-END:variables
}
