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
    public Estado moverNave(Jogador jogador, int tecla, int y, int x){
        int xx=x;
        int yy=y;
       
        if(jogador.getFundos()<=0){
            return new E00_Menu(jog);
        }
        else
        {
            if(tecla == 7){
                xx--;
                yy--;
            }
            else if(tecla == 4){
                xx--;
            }
            else if(tecla == 1){
                xx--;
                yy++;
            }else if(tecla == 2){
                yy++;
            }
            else if(tecla == 3){
                xx++;
                yy++;
            }
            else if(tecla == 6){
                xx++;
            }else if(tecla == 9){
                xx++;
                yy--;
            }else if(tecla == 8){
                yy--;                
            }
            
            if(xx<0 || xx > 9 || yy < 0 || yy >9){
                return this;
            }
            else
            {
               if((jog.getCarta(yy,xx) != null) && tecla!=0){
               jog.getJogadorActivo().getToken().setX(xx);
               jog.getJogadorActivo().getToken().setY(yy);
               jog.revelaMapa();
               jog.getJogadorActivo().fazCompra(1);
               jog.replenish();
               }
               
               return this;
            }
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
