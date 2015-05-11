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
    public Estado moverNave(Jogador jogador, int x){
        if(jogador.getFundos()<=0){
            return new E00_Menu(jog);
        }
        else
        {
            if(x==7 && jog.getJogadorActivo().getToken().getPosX()>0 && jog.getJogadorActivo().getToken().getPosY()>0) {
                jog.getJogadorActivo().getToken().setX(jog.getJogadorActivo().getToken().getPosX()-1);
                jog.getJogadorActivo().getToken().setY(jog.getJogadorActivo().getToken().getPosY()-1);
            }
            else if(x==1 && jog.getJogadorActivo().getToken().getPosX()>0 && jog.getJogadorActivo().getToken().getPosY()<9) {
                jog.getJogadorActivo().getToken().setX(jog.getJogadorActivo().getToken().getPosX()-1);
                jog.getJogadorActivo().getToken().setY(jog.getJogadorActivo().getToken().getPosY()+1);
            }
            else if(x==3 && jog.getJogadorActivo().getToken().getPosX()<9 && jog.getJogadorActivo().getToken().getPosY()<9) {
                jog.getJogadorActivo().getToken().setX(jog.getJogadorActivo().getToken().getPosX()+1);
                jog.getJogadorActivo().getToken().setY(jog.getJogadorActivo().getToken().getPosY()+1);
            }
            else if(x==9 && jog.getJogadorActivo().getToken().getPosX()<9 && jog.getJogadorActivo().getToken().getPosY()>0) {
                jog.getJogadorActivo().getToken().setX(jog.getJogadorActivo().getToken().getPosX()-1);
                jog.getJogadorActivo().getToken().setY(jog.getJogadorActivo().getToken().getPosY()+1);
            }
            else if(x==8 && jog.getJogadorActivo().getToken().getPosY()>0) {
                jog.getJogadorActivo().getToken().setY(jog.getJogadorActivo().getToken().getPosY()-1);
            }
            else if(x==2 && jog.getJogadorActivo().getToken().getPosY()<9) {
                jog.getJogadorActivo().getToken().setY(jog.getJogadorActivo().getToken().getPosY()+1);
            }
            else if(x==4 && jog.getJogadorActivo().getToken().getPosX()>0) {
                jog.getJogadorActivo().getToken().setX(jog.getJogadorActivo().getToken().getPosX()-1);
            }
            else if(x==6 && jog.getJogadorActivo().getToken().getPosX()<9) {
                jog.getJogadorActivo().getToken().setX(jog.getJogadorActivo().getToken().getPosX()+1);
            }
            else{
                return this;
            }
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
            return new E02_Trade(jog);
        }
        else{
            return new E03_Parado(jog);
        }
    }
}
