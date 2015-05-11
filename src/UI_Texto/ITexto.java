
package UI_Texto;


import Jogo.*;
import Cartas.*;
import Jogador.Jogador;
import Planetas.*;
import java.util.Scanner;


public class ITexto {
    Jogo jogo;
    Carta [][] mapData;
    int [][] matrizcartas = new int [10][10];
    
    public ITexto(){
        jogo = new Jogo();
        jogo.setMapa();
        mapData = jogo.getMapa();
    }
    
    
    public void printMapa(){
        int i, j;
        int dimX = 10;
        int dimY = 10;
        char letra = ' ';
        char [][] charMap = new char [10][10];
        
        // Cria array de caracteres 10x10 do mapa
        for(i = 0; i < dimX; i++){
            for(j = 0; j < dimY; j++){
                if(mapData[i][j] == null){
                    letra = ' ';    // Espaço fora do mapa
                }
                else if(false == mapData[i][j].getVisible()){
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
        
        // Imprime mapa
        for(i = 0; i < dimX; i++){
            for(j = 0; j < dimY; j++){
                
                // Adicionar mudanca de cor para a casa em que o jogador tem o token da nave?
                // O token da nave pode ser '1' e '2', para o jogador 1 e jogador 2, respetivamente ...
                
                System.out.print(charMap[i][j]);
            }
            System.out.print('\n');
        }
    }
    
    public void ApresentaMenuInicial(){
        System.out.println("BEM VINDO");
        System.out.println();
        int x = 0;
        while(x != 1 && x != 2 && x !=3){        
            System.out.println("1. Adicionar Jogador 2");
            System.out.println("2. Começar Jogo");
            System.out.println("3. Terminar Jogo");
            System.out.println();
            System.out.println();
            Scanner sc = new Scanner(System.in);
            x = sc.nextInt();
            if(x!=1 && x!=2 && x !=3){
            System.out.println();
            System.out.println();
            System.out.println("Opção incorrecta");
            System.out.println();
            System.out.println();
            }
            
            if(x == 1){
                jogo.addJogador(new Jogador());
            }
            if(x==2){
                jogo.comecarJogo();
            }
            
        }
        
    }
    
    public void tabuleiroDeJogo(){
        int x = 88;
        while(x!=1 && x!=2){
        System.out.println("---------------------------------------------------");
        System.out.println("MILKY WAY EXPRESS");
        System.out.println();
        System.out.println();
        System.out.println();
        
        printMapa();
            System.out.println();
            System.out.println();
            System.out.println("0 - Instruções");
            Scanner sc = new Scanner(System.in);
            x = sc.nextInt();
            if(x==0)
            {
                instrucoesMovimento();
            }
        }
        
        
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
    
}
