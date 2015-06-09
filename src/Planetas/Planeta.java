/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Planetas;

import Cubos.*;
import Cartas.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author inose_000
 */
public class Planeta extends Carta{
    String nome;
    Map<Cubo,Integer> precario = new HashMap<>();
    Cubo [] mercado = new Cubo[2];
    
    Cubo verificaCubos(){
        return null;
    }
    
    @Override
    public int replenish(){
        int ataques=0;
        for(int i=0;i<mercado.length;i++){
            if(mercado[i] instanceof CuboBranco){
                mercado[i] = null;
            }
        }
        
        for(int i=0;i<mercado.length;i++){
          while(mercado[i] == null){
            if(mercado[i] instanceof CuboBranco || mercado[i] == null){
                int x = (int)(Math.random()*6)+1;
                        if(x==1 || x==2){
                         //branco
                         mercado[i] = new CuboBranco();
                     }else
                     if(x==3){
                         //azull
                         mercado[i] = new Agua();
                     }else
                     if(x==4){
                         //Vermelho
                         mercado[i] = new Medicamento();
                     }else
                     if(x==5){
                         //amarelo
                         mercado[i] = new Comida();
                     }else
                     if(x==6){
                           ataques++;
                     } 
                }
                
            }
        }
        
        return ataques;
        
    }
    
    
}