/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Planetas;

import Cubos.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author inose_000
 */
public class Asperta extends PlanetaPirata{
    String nome;
    Map<Cubo,Integer> precario = new HashMap<>();
    List<Cubo> cubos = new ArrayList<>();
    
    
        Asperta(){
        nome = "Asperta";
        precario.put(new CuboAzul(), 3);
    }
}
