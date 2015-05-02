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
public class Tiamat extends Planeta{
    String nome;
    Map<Cubo,Integer> precario = new HashMap<>();
    
    Tiamat(){
        nome = "Tiamat";
        precario.put(new CuboAzul(), 2);
        precario.put(new CuboAmarelo(), 3);
        precario.put(new CuboVermelho(), 1);
        precario.put(new CuboPreto(), 3);
    }
}
