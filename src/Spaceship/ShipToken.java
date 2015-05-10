/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Spaceship;

import Jogador.Jogador;

/**
 *
 * @author inose_000
 */
public class ShipToken {
    int posX;
    int posY;
    private Jogador jogador;
    public ShipToken(Jogador jog){
        jogador = jog;
    }
    
    public void setX(int x){
        posX = x;
    }
    
    public void setY(int y){
        posY = y;
    }
    
    public int getPosX(){
        return posX;
    }
    
    public int getPosY(){
        return posY;
    }
}
