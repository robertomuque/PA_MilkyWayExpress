package Jogo;


import Ataque.AtaquePirata;
import Cartas.*;
import Cubos.*;
import Estados.*;
import Estados.Estado;
import Jogador.Jogador;
import Planetas.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Jogo {
    
    Jogador jogador1;
    Jogador jogador2;
    Jogador jogadoractivo;
    Estado state;
    List<Carta> baralho = new ArrayList<>();
    List<Cubo> banco = new ArrayList<>();
    Carta [][] mapa = new Carta[10][10];
    List<AtaquePirata> ataque = new ArrayList<>();
    Random aleatorio = new Random();
    int [] wh0 = new int[2]; // X=wh0[0], Y=wh0[1]
    
    public Jogo(){
        jogador1 = new Jogador();
        jogadoractivo = jogador1;
        state = new E00_Menu(this);
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
        if(jogador2 == null){
            jogador2 = new Jogador();
        }
        state = state.addJogador(jogador2);
    }
    
    public void comecarJogo(){
        state = state.iniciarJogo();
    }
    
    public void moverNave(int x){
        state = state.moverNave(jogadoractivo, x);
        if(mapa[jogadoractivo.getToken().getPosX()][jogadoractivo.getToken().getPosX()] != null){
            mapa[jogadoractivo.getToken().getPosX()][jogadoractivo.getToken().getPosX()].setVisible();
        }
    }
    
    public void upgradeForca(){
        state = state.upgradeForca();
    }
    
    public void upgradeCarga(){
        state = state.upgradeCarga();
    }
    
    public void pararNave(){
        state = state.pararNave(mapa[jogadoractivo.getToken().getPosX()][jogadoractivo.getToken().getPosY()]);
    }
    
    public void retomarMovimento(){
        state = state.retomarMovimento();
    }
    
    public void removeJogador(){
        if(jogador2!=null){
            jogador2 = null;
        }
        
        state = new E00_Menu(this);
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
        int addX = 0;
        int addY = 0;
        int canto1, canto2, ligacaoX, ligacaoY, difX, difY, sorte, conta;
        
        // Escolhe cantos dos WormHoles
        canto1 = aleatorio.nextInt(4);
        do{
            canto2 = aleatorio.nextInt(4);
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
            // Guarda coordenadas do primeiro WormHole
            jogador1.getToken().setX(pX[0]);
            jogador1.getToken().setY(pY[0]);
        }
         
        // Ligacao entre WormHoles (1 -> 2)
        ligacaoX = pX[0];
        ligacaoY = pY[0];
        // Sentido X
        if(ligacaoX < pX[1]){
            addX = -1;
        }
        else if(ligacaoX > pX[1]){
            addX = 1;
        }
        else if(ligacaoX == pX[1]){
            addX = 0;
        }
        // Sentido Y
        if(ligacaoY < pY[1]){
            addY = -1;
        }
        else if(ligacaoY > pY[1]){
            addY = 1;
        }
        else if(ligacaoY == pY[1]){
            addY = 0;
        }
        // Ciclo principal
        while((ligacaoX != pX[1] && ligacaoY != pY[1]) && (baralho.size() > 0)){
            difX = pX[1] - ligacaoX;
            difY = pY[1] - ligacaoY;
            if(difX == 0 && Math.abs(difY) > 0){        // Caso 1
                nextX = ligacaoX;
                nextY = ligacaoY + addY;
            }
            else if(difY == 0 && Math.abs(difX) > 0){       // Caso 2
                nextX = ligacaoX + addX;
                nextY = ligacaoY;
            }
            else if(Math.abs(difX) > Math.abs(difY) && difX != 0 && difY != 0){     // Caso 3
                nextX = ligacaoX + addX;
                nextY = ligacaoY;
            }
            else if(Math.abs(difX) < Math.abs(difY) && difX != 0 && difY != 0){     // Caso 4
                nextX = ligacaoX;
                nextY = ligacaoY + addY;
            }
            else if(Math.abs(difX) == Math.abs(difY)){      // Caso 5
                int desempata = aleatorio.nextInt(2);
                if(desempata == 0){
                    nextX = ligacaoX + addX;
                    nextY = ligacaoY;
                }
                else{
                    nextX = ligacaoX;                    
                    nextY = ligacaoY + addY;
                }
            }
            if(((nextX >= 0 && nextX <= 9) && (nextY >= 0 && nextY <= 9)) && (nextX != pX[1] && nextY != pY[1]) && (ligacaoX != pX[1] && ligacaoY != pY[1]) && mapa[nextX][nextY] == null){
                sorte = aleatorio.nextInt(baralho.size());  // Escolhe carta aleatoria do baralho
                mapa[nextX][nextY] = baralho.get(sorte);    // Coloca essa carta no mapa
                baralho.remove(sorte);                      // Apaga essa carta do baralho
                ligacaoX = nextX;
                ligacaoY = nextY;
            }
        }
        
        // Colocacao das restantes cartas do baralho
        while(baralho.size() > 0){
            conta = 0;
            int sorteX = 1 + aleatorio.nextInt(8);  // Sorteia posicao em X (1-8)
            int sorteY = 1 + aleatorio.nextInt(8);  // Sorteia posicao em Y (1-8)
            if(mapa[sorteX][sorteY] == null){   // Garante que a celula esta vazia
                for(int varX = -1; varX <= 1; varX++){
                    for(int varY = -1; varY <= 1; varY++){
                        if((varX != 0 && varY != 0) && mapa[sorteX + varX][sorteY + varY] != null){   // Conta celulas circundanes nao vazias (com carta)
                            conta++;    // Conta numero de cartas adjacentes a posicao atual nao vazias (com carta)
                        }
                    }
                }
            }
            if(conta > 0){                                     // Se qualquer celula circundante tiver carta
                sorte = aleatorio.nextInt(baralho.size());     // Assim so coloca cartas adjacentes a outras cartas antes colocadas
                mapa[sorteX][sorteY] = baralho.get(sorte);
                baralho.remove(sorte);
            }
        }
    }
    
    int preencheMat(Carta cart){
        return 0;
    }
    
    public int getPosX(){
        return jogadoractivo.getToken().getPosX();
    }
    
    public int getPosY(){
        return jogadoractivo.getToken().getPosY();
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
    
    public void setEstado(Estado estado){
        state = estado;
    }
    
    public Carta[][] getMapa(){
        return mapa;
    }
    
    public int[] getWormHoleCoord(){
        // Retorna coordenadas do primeiro WormHole
        // X = wh0[0]
        // Y = wh0[1]
        return wh0;
    }
    
    public Jogador getJogador1(){
        return jogador1;
    }
    
    public Jogador getJogador2(){
        return jogador2;
    }
    
    public Estado getEstado(){
        return state;
    }
    
    public String getCartaActual(){
        if(mapa[jogadoractivo.getToken().getPosX()][jogadoractivo.getToken().getPosX()] != null){
            return mapa[jogadoractivo.getToken().getPosX()][jogadoractivo.getToken().getPosX()].getClass().getSimpleName(); 
        }
        else
        {
            return "Informação desconhecida";
        }
           
        
    }
}
