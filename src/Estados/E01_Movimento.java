/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estados;

import Ataque.AtaquePirata;
import Cartas.*;
import Jogador.*;
import Jogo.*;
import Planetas.*;

/**
 *
 * @author inose_000
 */
public class E01_Movimento extends Estado{
    public E01_Movimento(Jogo jog){
        super(jog);
    }
    
    @Override
    public Estado moverNave(Jogador jogador, int x, int y){
        if(jogador.getFundos()<=0){
            
            return new E00_Menu(jog);
        }
        else
        {
            jog.getJogadorActivo().fazCompra(1);
            return this;
            //
        }
    }
    
    @Override
    public Estado pararNave(Carta posicao){
        if(posicao instanceof Planeta){
            return new E02_Trade(jog);
        }else if(posicao instanceof PlanetaPirata){
            
            AtaquePirata ataque1 = jog.getAtaque1();
            AtaquePirata ataque2 = jog.getAtaque2();
            jog.getJogadorActivo().fazCompra(ataque1.getResgate());
            jog.getJogadorActivo().fazCompra(ataque2.getResgate());
            return new E03_Parado(jog);
            
        }
        else{
            return this;
        }
    }
}
