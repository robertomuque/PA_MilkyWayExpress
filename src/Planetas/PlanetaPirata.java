/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Planetas;

import Cartas.*;
import Cubos.*;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author inose_000
 */
public class PlanetaPirata extends Carta{
    String nome;
    Map<Cubo,Integer> precario = new HashMap<>();
    Cubo [] mercado = new Cubo[1];
    
    @Override 
    public int replenish(){
        if(mercado[0] == null){
            mercado[0] = new Ilegal();
        }
        return 0;
    }
}


