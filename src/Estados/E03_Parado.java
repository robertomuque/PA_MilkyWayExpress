/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estados;

import Jogo.Jogo;

/**
 *
 * @author inose_000
 */
public class E03_Parado extends Estado{
    public E03_Parado(Jogo jog){
        super(jog);
    }
    
    @Override
    public Estado retomarMovimento(){
        return new E01_Movimento(jog);}
    
}
