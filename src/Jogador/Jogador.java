/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jogador;

import Spaceship.Ship_Token;

/**
 *
 * @author inose_000
 */
public class Jogador {
    Ship_Token tokenship;
    
    public Jogador(){
        tokenship = new Ship_Token(this);
    }
}
