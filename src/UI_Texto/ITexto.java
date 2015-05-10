
package UI_Texto;


import Jogo.*;
import Cartas.*;
import Planetas.*;


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
                else if(false == mapData[i][j].getVisible() && mapData[i][j] instanceof WormHole){
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
    
    
    void adicionaJogador(){
        
    }
    
}
