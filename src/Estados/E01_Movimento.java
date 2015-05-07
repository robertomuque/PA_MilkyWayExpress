/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estados;

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
        if(posicao instanceof Planeta || posicao instanceof PlanetaPirata){
            return new E02_Trade(jog);
        }else{
            return new E03_Parado(jog);
        }
    }
}
