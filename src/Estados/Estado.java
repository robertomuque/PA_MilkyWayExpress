/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estados;

import Cartas.*;
import Cubos.*;
import Jogador.*;
import Jogo.*;

/**
 *
 * @author inose_000
 */
public class Estado {
    Jogo jog;
    boolean fim = false;
    public Estado(Jogo jogo){jog = jogo;}
    public Estado adicionarJogador(Jogador jog){
        return null;
    }
    
    public Estado addJogador(Jogador jogador){
        return this;
    }
    
    public Estado iniciarJogo(){return this;}
    
    public Estado moverNave(Jogador jogador, int x, int y){return this;}
    
    public Estado pararNave(Carta posicao){return this;}
    
    public Estado upgradeForca(){return this;}
    
    public Estado upgradeCarga(){return this;}
    
    public Estado comprar(Cubo material){return this;}
    
    public Estado vender(Cubo material){return this;}
            
    public Estado retomarMovimento(){return this;}
    
    public void fecharJogo(){fim = true;}
    
    public boolean getfim(){return fim;}
}
