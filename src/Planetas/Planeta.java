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
    Cubo [] mercado = new Cubo[3];
    Cubo verificaCubos(){
        return null;
    }
}