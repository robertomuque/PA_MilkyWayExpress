/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estados;

import Jogador.Jogador;
import Jogo.*;

/**
 *
 * @author inose_000
 */
public class E00_Menu extends Estado{
    
    public E00_Menu(Jogo jog){
        super(jog);
    }
    
    @Override
    public Estado iniciarJogo(){
        return new E01_Movimento(jog);
    }
}
