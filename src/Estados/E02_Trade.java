/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estados;

import Cubos.Cubo;
import Jogo.Jogo;

/**
 *
 * @author inose_000
 */
public class E02_Trade extends Estado{
    public E02_Trade(Jogo jog){
        super(jog);
    }
        
    @Override
    public Estado upgradeForca(){
        return this;
    }
    
    @Override
    public Estado upgradeDefesa(){
        return this;
    }
    
    @Override
    public Estado comprar(Cubo material){
        return this;
    }
    
    @Override
    public Estado retomarMovimento(){
        jog.resetAtaques();
        return new E01_Movimento(jog);}
    
}
