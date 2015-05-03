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
    private List<Cubo> aquisicoes = new ArrayList<>();
    
    public ShipCard(Jogador jog){
        jogador = jog;
    }
    
    Jogador getJogador(){
        return jogador;
    }
    
}
