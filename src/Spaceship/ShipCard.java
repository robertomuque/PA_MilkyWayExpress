/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Spaceship;

import Cartas.Carta;
import Cubos.*;
import Jogador.Jogador;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author inose_000
 */

public class ShipCard extends Carta{
    Jogador jogador;
    private List<Cubo> forca = new ArrayList<>();
    private List<Cubo> carga = new ArrayList<>();
    List<Cubo> comida = new ArrayList<>();
    List<Cubo> agua = new ArrayList<>();
    List<Cubo> medicamentos = new ArrayList<>();
    List<Cubo> ilegalgoods = new ArrayList<>();
    
    public ShipCard(Jogador jog){
        jogador = jog;
        forca.add(new CuboCinza());
        forca.add(new CuboCinza());
        forca.add(new CuboCinza());
        carga.add(new CuboCinza());
    }
    
    Jogador getJogador(){
        return jogador;
    }
    
    public int upgradeForca(){
        if(forca.size()<5){
            forca.add(new CuboCinza());
            return forca.size();
        }
        else
        {
            return 0;
        }
        
    }
    
    public int upgradeCarga(){
        if(carga.size()<3)
        {
            carga.add(new CuboCinza());
            return carga.size();
        }
        else
        {
           return 0; 
        }
    }
    
    public void adicionarCompra(Cubo material){
        if(material instanceof CuboAmarelo){
            
        }
        else if(material instanceof CuboAzul){
            
        }
        else if(material instanceof CuboVermelho){
            
        }
        else if(material instanceof CuboPreto){
            
        }
    }
    
}
