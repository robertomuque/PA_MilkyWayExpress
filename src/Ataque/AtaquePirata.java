/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ataque;

import Jogo.Jogo;

/**
 *
 * @author inose_000
 */
public class AtaquePirata {
    int forca_atq;
    int forca_def;
    
    public AtaquePirata(int x){
        forca_atq = (int)(Math.random()*6)+1;
        forca_def = (int)(Math.random()*x)+1;
        
    }
    
    public int getForcaAtaque(){
        return forca_atq;
    }
    
    public int getForcaDefesa(){
        return forca_def;
    }
    
    public int getResgate(){
        return (forca_atq - forca_def);
    }
            
}
