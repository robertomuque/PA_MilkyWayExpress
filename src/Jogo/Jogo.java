package Jogo;


import Ataque.AtaquePirata;
import Cartas.*;
import Estados.*;
import Estados.Estado;
import Jogador.Jogador;
import Planetas.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;


public class Jogo extends Observable{
    
   Jogador jogador1;
    Jogador jogador2;
    Jogador jogadoractivo;
    Estado state;
    List<Carta> baralho = new ArrayList<>();
    Carta [][] mapa = new Carta[7][7];
    List<AtaquePirata> ataque = new ArrayList<>();
    Random aleatorio = new Random();
    int matrizX = 7;
    int matrizY = 7;
    List<Observer> observers = new ArrayList<>();
    
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
    
    public int getTamMatrizX(){
        return matrizX;
    }
    
    public int getTamMatrizY(){
        return matrizY;
    }
    
    
    public void comecarJogo(){
        state = state.iniciarJogo();
        this.notifyObservers();
    }
    
    public void revelaMapa(){
        try{
            if(mapa[jogadoractivo.getToken().getPosY()][jogadoractivo.getToken().getPosX()] != null){
             mapa[jogadoractivo.getToken().getPosY()][jogadoractivo.getToken().getPosX()].setVisible();

         }}
        catch(IndexOutOfBoundsException e){

        }
        
        try{
            if(mapa[jogadoractivo.getToken().getPosY()-1][jogadoractivo.getToken().getPosX()-1] != null){
            mapa[jogadoractivo.getToken().getPosY()-1][jogadoractivo.getToken().getPosX()-1].setVisible();
           
        }
        }catch(IndexOutOfBoundsException e){
            
        }
        try{
           if(mapa[jogadoractivo.getToken().getPosY()-1][jogadoractivo.getToken().getPosX()] != null){
            mapa[jogadoractivo.getToken().getPosY()-1][jogadoractivo.getToken().getPosX()].setVisible();
           
        } 
        }catch(IndexOutOfBoundsException e){
            
        }
        
        try{
          if(mapa[jogadoractivo.getToken().getPosY()-1][jogadoractivo.getToken().getPosX()+1] != null){
            mapa[jogadoractivo.getToken().getPosY()-1][jogadoractivo.getToken().getPosX()+1].setVisible();
           
        }  
        }catch(IndexOutOfBoundsException e){
            
        }
        
        try{
           if(mapa[jogadoractivo.getToken().getPosY()][jogadoractivo.getToken().getPosX()-1] != null){
            mapa[jogadoractivo.getToken().getPosY()][jogadoractivo.getToken().getPosX()-1].setVisible();
           
        } 
        }catch(IndexOutOfBoundsException e){
            
        }
        
        try{
            if(mapa[jogadoractivo.getToken().getPosY()-1][jogadoractivo.getToken().getPosX()] != null){
            mapa[jogadoractivo.getToken().getPosY()-1][jogadoractivo.getToken().getPosX()].setVisible();
           
        }
        }
        catch(IndexOutOfBoundsException e){
                
                
        }
        
        try{
          if(mapa[jogadoractivo.getToken().getPosY()][jogadoractivo.getToken().getPosX()+1] != null){
            mapa[jogadoractivo.getToken().getPosY()][jogadoractivo.getToken().getPosX()+1].setVisible();
           
        }  
        }catch(IndexOutOfBoundsException e){
            
        }
        try{
         if(mapa[jogadoractivo.getToken().getPosY()+1][jogadoractivo.getToken().getPosX()-1] != null){
            mapa[jogadoractivo.getToken().getPosY()+1][jogadoractivo.getToken().getPosX()-1].setVisible();
           
        }   
        }catch(IndexOutOfBoundsException e){
            
        }
        
        try{
          if(mapa[jogadoractivo.getToken().getPosY()+1][jogadoractivo.getToken().getPosX()] != null){
            mapa[jogadoractivo.getToken().getPosY()+1][jogadoractivo.getToken().getPosX()].setVisible();
           
        }  
        }catch(IndexOutOfBoundsException e){
            
        }
        
        try{
         if(mapa[jogadoractivo.getToken().getPosY()+1][jogadoractivo.getToken().getPosX()+1] != null){
            mapa[jogadoractivo.getToken().getPosY()+1][jogadoractivo.getToken().getPosX()+1].setVisible();
           
        }   
        }catch(IndexOutOfBoundsException e){
            
        }
    }
    
    public void moverNave(int tecla, int y, int x){
        int xx = x;
        int yy = y;
         state = state.moverNave(jogadoractivo,tecla,yy, xx);
         this.notifyObservers();
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
        System.out.print("a" +ligacaoX + "b" +ligacaoY);
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
    
    public void setMapaFixo(){
    // falta inicializar algumas variáveis

    // marca posição com carta (losango)
    mapa[0][0] = null;
    mapa[0][1] = null;
    mapa[0][2] = null;
    mapa[0][3] = new Carta();
    mapa[0][4] = null;
    mapa[0][5] = null;
    mapa[0][6] = null;
    mapa[1][0] = null;
    mapa[1][1] = null;
    mapa[1][2] = new Carta();
    mapa[1][3] = new Carta();
    mapa[1][4] = new Carta();
    mapa[1][5] = null;
    mapa[1][6] = null;
    mapa[2][0] = null;
    mapa[2][1] = new Carta();
    mapa[2][2] = new Carta();
    mapa[2][3] = new Carta();
    mapa[2][4] = new Carta();
    mapa[2][5] = new Carta();
    mapa[2][6] = null;
    mapa[3][0] = new Carta();
    mapa[3][1] = new Carta();
    mapa[3][2] = new Carta();
    mapa[3][3] = new Carta();
    mapa[3][4] = new Carta();
    mapa[3][5] = new Carta();
    mapa[3][6] = new Carta();
    mapa[4][0] = null;
    mapa[4][1] = new Carta();
    mapa[4][2] = new Carta();
    mapa[4][3] = new Carta();
    mapa[4][4] = new Carta();
    mapa[4][5] = new Carta();
    mapa[4][6] = null;
    mapa[5][0] = null;
    mapa[5][1] = null;
    mapa[5][2] = new Carta();
    mapa[5][3] = new Carta();
    mapa[5][4] = new Carta();
    mapa[5][5] = null;
    mapa[5][6] = null;
    mapa[6][0] = null;
    mapa[6][1] = null;
    mapa[6][2] = null;
    mapa[6][3] = new Carta();
    mapa[6][4] = null;
    mapa[6][5] = null;
    mapa[6][6] = null;

    // coloca cartas (aleatoriamente)
    int sorte;
    for(int i=0; i < 7; i++){
        for(int j=0; j<7; j++){
            if(i == 3 && j == 0){
                mapa[i][j] = new WormHole(); // WH inicial
            }
            else if(i == 3 && j == 6){
                mapa[i][j] = new WormHole(); // WH final
            }
            else if(mapa[i][j] != null){
                sorte = aleatorio.nextInt(baralho.size());  // Escolhe carta aleatoria do baralho
                mapa[i][j] = baralho.get(sorte);    // Coloca essa carta no mapa
                baralho.remove(sorte);    // e retira do baralho
            }
        }
        
    }
    jogador1.getToken().setX(0);
    jogador1.getToken().setY(3);


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
        ataque.add(new AtaquePirata(jogadoractivo.getNave().getForca()));
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
    
    public Jogador getJogador1(){
        return jogador1;
    }
    
    public Jogador getJogador2(){
        return jogador2;
    }
    
    public Estado getEstado(){
        return state;
    }
    
    public Carta getCarta(int y, int x){
        return mapa[y][x];
    }
    
    public boolean checkIfPlaneta(){
        if(mapa[jogadoractivo.getToken().getPosY()][jogadoractivo.getToken().getPosX()] instanceof Planeta){
          return true;  
        }
        else if(mapa[jogadoractivo.getToken().getPosY()][jogadoractivo.getToken().getPosX()] instanceof PlanetaPirata){
            return true;
        }else{
            return false;
        }
        
    }
    
    public String getCartaActual(){
        if(mapa[jogadoractivo.getToken().getPosY()][jogadoractivo.getToken().getPosX()] != null){
            return mapa[jogadoractivo.getToken().getPosY()][jogadoractivo.getToken().getPosX()].getClass().getSimpleName(); 
        }
        else
        {
            return "Informação desconhecida";
        }  
    }
    
    public void setWormHoles(){
        for(int i=0;i<baralho.size();i++){
            
        }
    }
    
    public void descobreMapa(int yy, int xx){
        
    }
    
    @Override
    public void addObserver(Observer O){
        observers.add(O);
    }
    
    @Override
    public void deleteObserver(Observer O){
        observers.remove(O);
    }
    
    @Override
    public void notifyObservers(){
        for(int i=0;i<observers.size();i++){
            observers.get(i).update(this, observers.get(i));
        }
    }
    
    public void replenish(){
        ataque.clear();
        int ataques = 0;
        for(int i=0;i<matrizY;i++){
            for(int j=0;j<matrizX;j++){
                if(mapa[i][j] != null){
                   ataques = ataques + mapa[i][j].replenish(); 
                }
                
            }
        }
        if(!(state instanceof E00_Menu)){
            sofreAtaques(ataques);
        }
    }
    
    public List getAtaques(){
        return ataque;
    }
    
    public void sofreAtaques(int ataques){
        for(int i=0;i<ataques;i++){
            this.ataque.add(new AtaquePirata(getJogadorActivo().getNave().getForca()));
            this.jogadoractivo.fazCompra(ataque.get(i).getResgate());
        }
    }

}
