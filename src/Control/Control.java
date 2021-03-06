/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Ataque.AtaquePirata;
import Cartas.Carta;
import Cartas.EmptySpace;
import Cartas.WormHole;
import Cubos.Cubo;
import Estados.Estado;
import Jogador.Jogador;
import Jogo.*;
import Planetas.Planeta;
import Planetas.PlanetaPirata;
import UI.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author inose_000
 */
public class Control implements Observer{
    Jogo jogo;
    UI view;
    Estado estado;
    List<AtaquePirata> ataques = new ArrayList<>();
    
    public Control(UI vista, Jogo j){
        view = vista;
        jogo = j;
        j.addObserver(this);
        jogo.setMapaFixo();
        estado = getEstado();
    }
    
    public void addObserver(Observer O){
        jogo.addObserver(O);
    }
    
    public Estado getEstado(){
        return jogo.getEstado();
    }
    
    public Jogador getJogador(){
        return jogo.getJogadorActivo();
    }
    
    public int getPosX(){
        return jogo.getJogadorActivo().getToken().getPosX();
    }
    
    public int getPosY(){
        return jogo.getJogadorActivo().getToken().getPosY();
    }
    
    public String getCartaString(){
        return jogo.getCartaActual();
    }
    
    public Carta getCartaActual(int y, int x){
        return jogo.getCarta(y, x);
    }
    
    public int getFundos(){
        return jogo.getJogadorActivo().getFundos();
    }
    
    public int getTamMatrizX(){
        return jogo.getTamMatrizX();
    }
    
    public int getTamMatrizY(){
        return jogo.getTamMatrizY();
    }
    
    public int getForca(){
        return jogo.getJogadorActivo().getNave().getForca();
    }
    
    public int getCarga(){
        return jogo.getJogadorActivo().getNave().getCarga();
    }
    
    public int getLengForca(){
        return jogo.getJogadorActivo().getNave().getLenghtForca();
    }
    
    public int getLengCarga(){
        return jogo.getJogadorActivo().getNave().getLenghtCarga();
    }
    
    public boolean checkCargaCheia(){
        return jogo.getJogadorActivo().getNave().checkCargaCheia();
    }
    
    public void getMateriais(){
        
    }
    
    public void setForca(int x){
        
    }
    
    public void setCarga(int x){
        
    }
    
    public boolean checkIfPlaneta(){
       return jogo.checkIfPlaneta();
    }
    
    public String getMaterialAt(int x){
        Cubo material = jogo.getJogadorActivo().getNave().getMaterialAt(x);
        if(material == null){
            return null;
        }
        return material.getClass().getSimpleName();
    }
    
    int intCarta(Carta planeta){
        if(planeta instanceof Planeta){
            return 1;
        }
        else if(planeta instanceof PlanetaPirata){
            return 2;
        }
        else if(planeta instanceof WormHole){
            return 3;
        }else if(planeta instanceof EmptySpace){
            return 4;
        }
        return 0;
    }
    
    
    
    public int getTipoCarta(int y, int x){
        return intCarta(jogo.getCarta(y, x));
    }
    
    public int getDirecao(int y, int x){
        int yy = jogo.getJogadorActivo().getToken().getPosY();
        int xx = jogo.getJogadorActivo().getToken().getPosX();
        if((y == yy+1) && (x == xx+1)){
            return 3;
        }
        else if((y == yy+1) && (x == xx)){
            return 2;
        }
        else if((y == yy+1) && (x == xx-1)){
            return 1;
        }
        else if((y == yy) && (x == xx-1)){
            return 4;
        }
        else if((y == yy) && (x == xx+1)){
            return 6;
        }
        else if((y == yy-1) && (x == xx-1)){
            return 7;
        }
        else if((y == yy-1) && (x == xx)){
            return 8;
        }
        else if((y == yy-1) && (x == xx+1)){
            return 9;
        }
        return 0;
    }
    
    
    public void moverNave(int direcao){
        jogo.moverNave(direcao, jogo.getJogadorActivo().getToken().getPosY(), jogo.getJogadorActivo().getToken().getPosX());
    }

    @Override
    public void update(Observable o, Object arg) {
           estado = getEstado();
           updateAtaques();
    }
    
    public void comercaJogo(){
        jogo.comecarJogo();
    }
    
    public void updateAtaques(){
        ataques = jogo.getAtaques();
    }
    
    public List getAtaques(){
        return ataques;
    }
    
}
