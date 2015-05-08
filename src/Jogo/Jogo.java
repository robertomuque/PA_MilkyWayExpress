package Jogo;


import Ataque.AtaquePirata;
import Cartas.*;
import Cubos.*;
import Jogador.Jogador;
import Planetas.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Jogo {
    
    Jogador jogador1;
    Jogador jogador2;
    Jogador jogadoractivo;
    List<Carta> baralho = new ArrayList<>();
    List<Cubo> banco = new ArrayList<>();
    Carta [][] mapa = new Carta[10][10];
    List<AtaquePirata> ataque = new ArrayList<>();
    Random aletaorio = new Random();
    
    public Jogo(){
        for(int i=0;i<2;i++)
        {
            baralho.add(new WormHole());
        }
        for(int i=0;i<12;i++)
        {
            baralho.add(new EmptySpace());
        }
        baralho.add(new Arrakis());
        baralho.add(new Asperta());
        baralho.add(new Gethen());
        baralho.add(new Kiber());
        baralho.add(new Lamarckia());
        baralho.add(new Reverie());
        baralho.add(new Striterax());
        baralho.add(new Tiamat());
        baralho.add(new Whirl());
    }
    
    public void addJogador(Jogador jog){
        if(jogador1 == null){
            jogador1 = new Jogador();
        }else if(jogador2 == null){
            jogador2 = new Jogador();
        }
    }
    
    public void removeJogador(){
        if(jogador2!=null){
            jogador2 = null;
        }
    }
    
    public void setMapa(){  // Criação aleatória do mapa
        // Dados
        int xx = 0;
        int yy = 0;
        int tamanho = baralho.size();
        int auxCanto=-1;
        int []pX = new int[2];
        int []pY = new int[2];
        int nextX=0, nextY=0;
        int canto1, canto2, difX, difY, sorte, conta;
        
        // Escolhe cantos dos WormHoles
        canto1 = aletaorio.nextInt(4);
        do{
            canto2 = aletaorio.nextInt(4);
        }while(canto2 == canto1);
        
        // Colocacao dos WormHoles
        for(int i = 0; i < 2; i++){
            if(i == 0){
                auxCanto = canto1;
            }
            if(i == 1){
                auxCanto = canto2;
            }
            switch(auxCanto){   // Adiciona o WormHole e guarda as suas coordenadas (xx,yy)
                case 0: // Canto superior esquerdo
                    mapa[0][0] = new WormHole();
                    pX[i] = 0;
                    pY[i] = 0;
                    break;
                case 1: // Canto superior direito
                    mapa[9][0] = new WormHole();
                    pX[i] = 9;
                    pY[i] = 0;
                    break;
                case 2: // Canto inferior esquerdo
                    mapa[0][9] = new WormHole();
                    pX[i] = 0;
                    pY[i] = 9;
                    break;
                case 3: // Canto inferior direito
                    mapa[9][9] = new WormHole();
                    pX[i] = 9;
                    pY[i] = 9;
                    break;
            }
        }
        
        // Ligacao entre WormHoles (1 -> 2)
        int ligacaoX = pX[0];
        int ligacaoY = pY[0];
        while((ligacaoX != pX[1] && ligacaoY != pX[1]) && baralho.size() > 0){
            difX = pX[1] - ligacaoX;
            difY = pY[1] - ligacaoY;
            if(Math.abs(difX) > Math.abs(difY) && difX != 0){
                nextX = ligacaoX + (1 * (ligacaoX / Math.abs(ligacaoX)));
                nextY = ligacaoY;
            }
            else if(Math.abs(difX) < Math.abs(difY) && difY != 0){
                nextX = ligacaoX;
                nextY = ligacaoY + (1 * (ligacaoY / Math.abs(ligacaoY)));
            }
            sorte = aletaorio.nextInt(baralho.size());
            mapa[nextX][nextY] = baralho.get(sorte);
            baralho.remove(sorte);
        }
        
        // Colocacao das restantes cartas do baralho
        while(baralho.size() > 0){
            conta = 0;
            int sorteX = 1 + aletaorio.nextInt(7);  // Sorteia posicao em X (1-6)
            int sorteY = 1 + aletaorio.nextInt(7);  // Sorteia posicao em Y (1-6)
            for(int varX = -1; varX <= 1; varX++){
                for(int varY = -1; varY <= 1; varY++){
                    if(varX != 0 && varY != 0 && mapa[sorteX + varX][sorteY + varY] == null){
                        conta++;    // Conta numero de cartas adjacentes a posicao atual
                    }
                }
            }
            if(conta > 0){                                     // Se qualquer celula circundante tiver carta
                sorte = aletaorio.nextInt(baralho.size());     // Assim so coloca cartas adjacentes a outras cartas antes colocadas
                mapa[sorteX][sorteY] = baralho.get(sorte);
                baralho.remove(sorte);
            }
        }
    }
    
    int preencheMat(Carta cart){
        return 0;
    }
    
    public void moverNave(int x, int y){  }
    
    public int getPosX(){
        return 0;
    }
    
    public int getPosY(){
        return 0;
    }
    
    public Jogador getJogadorActivo(){
        return jogadoractivo;
    }
    
    public void sofreAtaque(){
        ataque.add(new AtaquePirata());
        ataque.add(new AtaquePirata());
    }
    
    public AtaquePirata getAtaque1(){
        return ataque.get(0);
    }
    
    public AtaquePirata getAtaque2(){
        return ataque.get(1);
    }
    
    public void resetAtaques(){
        ataque.clear();
    }
    
    public void finalizarCompras(){
        
    }
}
