/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dice;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author inose_000
 */
public class DadoColorido extends Dice{
    Map<Integer,String> cor = new HashMap<>();
    public DadoColorido(){
        cor.put(0,"Vermelho");
        cor.put(1,"Azul");
        cor.put(2,"Amarelo");
        cor.put(3,"Preto");
        cor.put(4,"Branco");
        cor.put(5,"Branco");
    }
    
    public String lancarDado(){
        return cor.get((int)Math.random()*(6));
    }
    
}
