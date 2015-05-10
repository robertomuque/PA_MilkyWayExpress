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
public class Reverie extends Planeta{
    public Reverie(){
        nome = "Reverie";
        precario.put(new Agua(), 1);
        precario.put(new Comida(), 2);
        precario.put(new Medicamento(), 3);
        precario.put(new Ilegal(), 3);
    }
}
