
package UI_Texto;


import Jogo.*;
import Cartas.*;
import Estados.*;
import Planetas.*;
import UI.UI;
import java.util.Scanner;


public class ITexto extends UI{
    Jogo jogo;
    int [] pos = new int[2];
    Carta [][] mapData;
    int [][] matrizcartas = new int [10][10];
    
    public ITexto(){
        jogo = new Jogo();
        jogo.setMapaFixo();
        mapData = jogo.getMapa();
        
    }
    
    public void printMapa(){
        int i, j;
        int dimX = 7;
        int dimY = 7;
        char letra = ' ';
        char [][] charMap = new char [7][7];
        
        // Cria array de caracteres 10x10 do mapa
        for(i = 0; i < dimX; i++){
            for(j = 0; j < dimY; j++){
                    if((j == jogo.getJogador1().getToken().getPosX()) && (i == jogo.getJogador1().getToken().getPosY()))
                    {
                        
                            charMap[i][j] = '1';
                            pos[0] = i;
                            pos[1] = j;
                    }
                    else
                    {
                        if(mapData[i][j] == null){
                                letra = ' ';    // Espaço fora do mapa
                            }
                            else if(!mapData[i][j].getVisible()){
                               letra = '?';     // Carta ainda nao descoberta
                            }
                            else if(mapData[i][j] instanceof EmptySpace){
                                letra = 'E';    // EmptySpace
                            }
                            else if(mapData[i][j] instanceof WormHole){
                                letra = 'W';    // WormHole
                            }
                            else if(mapData[i][j] instanceof Planeta){
                                letra = 'P';    // Planeta
                            }
                            else if(mapData[i][j] instanceof PlanetaPirata){
                                letra = 'K';    // Planeta Pirata
                            }
                            charMap[i][j] = letra;
                    }
            }
        }
        // Imprime mapa
        for(int a = 0; a < dimX; a++){
            for(int b = 0; b < dimY; b++){
                
                // Adicionar mudanca de cor para a casa em que o jogador tem o token da nave?
                // O token da nave pode ser '1' e '2', para o jogador 1 e jogador 2, respetivamente ...
                
                System.out.print(charMap[a][b]);
            }
            
            System.out.print('\n');
        }
    }
    
    public void apresentaMenuInicial(){
        System.out.println("BEM VINDO");
        System.out.println();
        int x = 0;
        while(x != 1 && x != 2 && x !=3){        
            System.out.println("1. Começar Jogo");
            System.out.println("2. Terminar Jogo");
            System.out.println();
            System.out.println();
            Scanner sc = new Scanner(System.in);
            x = sc.nextInt();
            if(x!=1 && x!=2){
            System.out.println();
            System.out.println();
            System.out.println("Opção incorrecta");
            System.out.println();
            System.out.println();
            }
            
            if(x == 1){
                jogo.comecarJogo();
            }
            if(x==2){
                System.exit(0);
            }
            
        }
        
    }
    
    public void tabuleiroDeJogo(){
        int x = 88;
        while(true){
        System.out.println("---------------------------------------------------");
        System.out.println("MILKY WAY EXPRESS");
        System.out.println();
        System.out.println();
        System.out.println();
        
        printMapa();
            System.out.println();
            System.out.println();
            System.out.println("posicao: " + jogo.getJogadorActivo().getToken().getPosY() + jogo.getJogadorActivo().getToken().getPosX());
            System.out.println("0 - legendas");
            System.out.println("5 - Parar Nave");
            System.out.println("112 - info sobre posição actual");
            Scanner sc = new Scanner(System.in);
            x = sc.nextInt();
            if(x==0)
            {
                instrucoesMovimento();
            }else if(x==5){
                jogo.pararNave();
                return;
            }else if(x==112){
                System.out.println();
                System.out.println();
                System.out.println("Está actualmente em " + jogo.getCartaActual());
                
            }else{
                jogo.moverNave(x,pos[0],pos[1]);
            }         
        }
        
        
    }
    
    public void faseDeTrade(){
        int x = 0;
        while(x!=5){
        System.out.println("-------------------------------------------");
        System.out.println();
        System.out.println();
        System.out.println("TRADE");
        System.out.println("1 - Upgrade Força");
        System.out.println("2 - Upgrade Carga");
        System.out.println("3 - Vender Carga");
        System.out.println("4 - Comprar Carga");
        System.out.println("5 - Retomar Movimento");
        Scanner sc = new Scanner(System.in);
            x = sc.nextInt();
            
            if(x==1){
                if(jogo.getJogadorActivo().getFundos() > jogo.getJogadorActivo().getNave().upgradeForcaPreco()){
                    jogo.getJogadorActivo().fazCompra(jogo.getJogadorActivo().getNave().upgradeForca());
                }
                else
                {
                    System.out.println("Fundos insuficientes");
                    System.out.println();
                    System.out.println();
                }
                System.out.println("A sua forca é agora " + jogo.getJogadorActivo().getNave().getForca());
                System.out.println();
                System.out.println();
            }else if(x==2){
                if(jogo.getJogadorActivo().getFundos() > jogo.getJogadorActivo().getNave().upgradeCargaPreco())
                {
                    jogo.getJogadorActivo().fazCompra(jogo.getJogadorActivo().getNave().upgradeCarga());
                }
                else
                {
                    System.out.println("Fundos insuficientes");
                    System.out.println();
                    System.out.println();
                }
                
                System.out.println("A sua capacidade é agora " + jogo.getJogadorActivo().getNave().getCarga());
                System.out.println();
                System.out.println();
            }else if(x==3){
                
            }else if(x==4){
                
            }
        }
        jogo.retomarMovimento();
    }
    
    public void instrucoesMovimento(){
        while(true){
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("W - buraco negro");
        System.out.println("? - inexplorado");
        System.out.println("0 - voltar ao mapa");
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
                if(x==0){
                    return;
                }
        }     
        
    }
    
    public void naveParada(){
        System.out.println();
        System.out.println();
        System.out.println("Nave Parada");
        System.out.println("5 - Retomar Movimento");
        Scanner sc = new Scanner(System.in);
        int var;
        do{
           var = sc.nextInt();
           jogo.retomarMovimento();
        }while(var != 5);
    }
    
    public void exe(){
        Estado estado = new E00_Menu(jogo);
        
        while(true){
            estado = jogo.getEstado();
            if(estado instanceof E00_Menu){
                apresentaMenuInicial();
            }else if(estado instanceof E01_Movimento){
                tabuleiroDeJogo();
            }else if(estado instanceof E02_Trade){
                faseDeTrade();
            }
            else if(estado instanceof E03_Parado){
                naveParada();
            }
        }
    }
}
    

