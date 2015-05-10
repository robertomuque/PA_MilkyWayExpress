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
public class Gethen extends Planeta{    
    
        public Gethen(){
        nome = "Gethen";
        precario.put(new Agua(), 1);
        precario.put(new Comida(), 3);
        precario.put(new Medicamento(), 2);
        precario.put(new Ilegal(), 3);
    }
        
    @Override
    Cubo verificaCubos(){
        return null;
    }
}
