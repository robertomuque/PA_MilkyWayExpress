/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Spaceship;

import Cartas.Carta;
import Cubos.*;
import Jogador.Jogador;

/**
 *
 * @author inose_000
 */

public class ShipCard extends Carta{
    Jogador jogador;
    Cubo [] forca = new Cubo[5];
    Cubo [] carga = new Cubo[3];
    
    public ShipCard(Jogador jog){
        jogador = jog;
        forca[0] = null;
        forca[1] = null;
        forca[2] = null;
        forca[3] = new CuboCinza();
        forca[4] = new CuboCinza();
        
        carga[0] = null;
        carga[1] = new CuboCinza();
        carga[2] = new CuboCinza();
    }
    
    Jogador getJogador(){
        return jogador;
    }
    
    public int upgradeForca(){
        for(int i=0;i<forca.length;i++){
            if(forca[i] instanceof CuboCinza){
                forca[i] = null;
                return i+1;
            }
        }
        return 0;
    }
    
    public int upgradeForcaPreco(){
        for(int i=0;i<forca.length;i++){
            if(forca[i] instanceof CuboCinza){
                return i+1;
            }
        }
        return 0;
    }
    
    public int upgradeCarga(){
        for(int i=0;i<carga.length;i++){
            if(carga[i] instanceof CuboCinza){
                carga[i] = null;
                return i+1;
            }
        }
        return 0;
    }
    public int upgradeCargaPreco(){
        for(int i=0;i<carga.length;i++){
            if(carga[i] instanceof CuboCinza){
                return i+1;
            }
        }
        return 0;
    }
    
    public void adicionarCompra(Cubo material){
        for(int i=0;i<carga.length;i++){
           if(carga[i] == null){
               carga[i] = material;
               break;
           } 
        } 
    }
    
    public int getForca(){
        int x=0;
        for(int i=0;i<forca.length;i++)
        {
            if(!(forca[i] instanceof CuboCinza)){
                 
                      x++;
            }
            
        }
        return x;
    }
    
    public int getCarga(){
        int x=0;
        for(int i=0;i<carga.length;i++)
        {
            if(!(carga[i] instanceof CuboCinza)){
                  x++;
            }
            
        }
        return x;
    }
    
    public int getLenghtForca(){
        return forca.length;
    }
    
    public int getLenghtCarga(){
        return carga.length;
    }
    
    public boolean checkCargaCheia(){
        int x=0;
        for(int i=0;i<carga.length;i++){
            if(carga[i] == null){
                return false;
            }
        }
        return true;
    }
    
    public Cubo getMaterialAt(int x){
        Cubo escolha = carga[x];
        if((escolha instanceof CuboCinza) || carga[x]==null)
        {
            System.out.print("1 ");
            return null;
        }
        return escolha;
    }
}
