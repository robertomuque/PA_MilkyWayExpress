
package UI_Texto;

import Jogo.*;
import Cartas.*;
import Planetas.*;








public class ITexto {
    Jogo jogo = new Jogo();
    Carta [][] mapData;
    int [][] matrizcartas = new int [10][10];
    
    public ITexto(){
        mapData = jogo.getMapa();
    }
    
    public void printMapa(){
        int i, j;
        int dimX = 10;
        int dimY = 10;
        char letra;
        
        for(i = 0; i < dimX; i++){
            for(j = 0; j < dimY; j++){
                if(mapData[i][j] == null){
                    letra = ' ';
                }
                else if(mapData[i][j] instanceof EmptySpace){
                    letra = 'E';
                }
                else if(mapData[i][j] instanceof WormHole){
                    letra = 'W';
                }
                else if(mapData[i][j] instanceof Planeta){
                    letra = 'P';
                }
                else if(mapData[i][j] instanceof PlanetaPirata){
                    letra = 'K';
                }
                
            }
        }
        
        
        
    }
    
    
    
    void adicionaJogador(){
        
    }
    
}
