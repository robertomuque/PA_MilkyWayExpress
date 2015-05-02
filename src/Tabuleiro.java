
import Cartas.*;
import Jogador.Jogador;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author inose_000
 */
public class Tabuleiro {
    Jogador jogador1;
    Jogador jogador2;
    List<Carta> baralho = new ArrayList<>();
    Tabuleiro(){
        
    }
    
    public void setJogadores(Jogador j1, Jogador j2){
        jogador1 = j1;
        jogador2 = j2;
    }
}
