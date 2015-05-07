/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jogador;

import Cubos.*;
import Spaceship.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author inose_000
 */
public class Jogador {
    ShipToken tokenship;
    ShipCard nave;
    List<Cubo> fundos = new ArrayList<>();
    List<Cubo> comida = new ArrayList<>();
    List<Cubo> agua = new ArrayList<>();
    List<Cubo> medicamentos = new ArrayList<>();
    List<Cubo> ilegalgoods = new ArrayList<>();
    
    public Jogador(){
        tokenship = new ShipToken(this);
        nave = new ShipCard(this);
    }
    
    public void fazCompra(int x){
        for(int i=0;i<x;i++)
        {
            fundos.remove(fundos.size()-1);
        }
    }
    
    public int getFundos(){
        return fundos.size();
    }
    
}
