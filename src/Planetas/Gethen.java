/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Planetas;

import Cubos.*;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author inose_000
 */
public class Gethen extends Planeta{
    String nome;
    Map<Cubo,Integer> precario = new HashMap<>();
    
    
        Gethen(){
        nome = "Gethen";
        precario.put(Cubo_Azul, 1);
        precario.put(Cubo_Amarelo, 3);
        precario.put(Cubo_Vermelho, 2);
        precario.put(Cubo_Preto, 3);
    }
        
    @Override
    Cubo getCubos(){
        return null;
    }
}
