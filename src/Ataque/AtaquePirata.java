/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ataque;

/**
 *
 * @author inose_000
 */
public class AtaquePirata {
    int forca_atq;
    int forca_def;
    
    public AtaquePirata(){
        forca_atq = (int)(Math.random()*10)+1;
        forca_def = (int)(Math.random()*10)+1;
        
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
