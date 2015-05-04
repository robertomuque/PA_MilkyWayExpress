package Tabuleiro;


import Cartas.*;
import Cubos.*;
import Dice.*;
import Jogador.Jogador;
import Planetas.*;
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
    List<Carta> mesa = new ArrayList<>();
    Dice dadocor = new DadoColorido();
    Dice dadopreto = new DadoPreto();
    List<Cubo> banco = new ArrayList<>();
    
    Tabuleiro(){
        for(int i=0;i<2;i++)
        {
            baralho.add(new WormHole());
        }
        for(int i=0;i<12;i++)
        {
            baralho.add(new EmptySpace());
        }
        baralho.add(new Arrakis());
        baralho.add(new Asperta());
        baralho.add(new Gethen());
        baralho.add(new Kiber());
        baralho.add(new Lamarckia());
        baralho.add(new Reverie());
        baralho.add(new Striterax());
        baralho.add(new Tiamat());
        baralho.add(new Whirl());
    }
    
    public void setJogadores(Jogador j1, Jogador j2){
        jogador1 = j1;
        jogador2 = j2;
    }
    
    public void setTabuleiro(){
        int xx = 0;
        int yy = 0;
        int x = baralho.size();
        mesa.add(new WormHole());
        mesa.get(0).setPos(xx, yy);
        for(int i=0;i<x;i++)
        {
            int posicao = (int)Math.random()*(baralho.size()-1);
            Carta escolha = baralho.get(posicao);
            mesa.add(escolha);
            baralho.remove(escolha);
            
            int var = (int)Math.random()*2;
            if(var==0){
                xx++;
                mesa.get(mesa.indexOf(escolha)).setPos(xx, yy);
            }
            else
            {
                yy++;
                mesa.get(mesa.indexOf(escolha)).setPos(xx, yy);
            }
        }
        mesa.add(new WormHole());
        mesa.get(mesa.size()-1).setPos(xx++, yy);
    }
    
    
}
