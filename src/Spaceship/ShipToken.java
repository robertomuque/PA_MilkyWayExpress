/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Spaceship;

import Jogador.Jogador;

/**
 *
 * @author inose_000
 */
public class ShipToken {
    int x;
    int y;
    private Jogador jogador;
    public ShipToken(Jogador jog){
        jogador = jog;
    }
}