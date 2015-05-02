/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dice;

/**
 *
 * @author inose_000
 */
public class DadoPreto extends Dice{
    public int lancarDado(){
        return (int)Math.random()*(6)+1;
    }
}
