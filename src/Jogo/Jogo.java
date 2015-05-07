package Jogo;


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

public class Jogo {
    Jogador jogador1;
    Jogador jogador2;
    Jogador jogadoractivo;
    Carta [][] matrizcartas = new Carta[25][25];
    int [][] matrizinterface = new int[25][25];
    List<Carta> baralho = new ArrayList<>();
    List<Carta> mesa = new ArrayList<>();
    Dice dadocor = new DadoColorido();
    Dice dadopreto = new DadoPreto();
    List<Cubo> banco = new ArrayList<>();
    
    public Jogo(){
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
    
    public void addJogador(Jogador jog){
        if(jogador1 == null){
            jogador1 = new Jogador();
        }else if(jogador2 == null){
            jogador2 = new Jogador();
        }
    }
    
    public void removeJogador(){
        if(jogador2!=null){
            jogador2 = null;
        }
    }
    
    public void setTabuleiro(){
        int xx = 0;
        int yy = 0;
        int x = baralho.size();
        
        mesa.add(new WormHole());
        
        matrizinterface[xx][yy] = 0;
        
        for(int i=0;i<x;i++)
        {
            
        }
        mesa.add(new WormHole());
        matrizinterface[xx][yy] = 0;
    }
    
    int preencheMat(Carta cart){
        return 0;
    }
    
    public void moverNave(int x, int y){  }
    
    public int getPosX(){
        return 0;
    }
    
    public int getPosY(){
        return 0;
    }
    
    public Jogador getJogadorActivo(){
        return jogadoractivo;
    }
}
