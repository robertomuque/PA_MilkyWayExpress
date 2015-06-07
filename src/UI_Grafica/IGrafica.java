/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI_Grafica;

import Control.Control;
import Cubos.Cubo;
import Jogo.Jogo;
import UI.UI;
import javax.swing.JFrame;

/**
 *
 * @author inose_000
 */
public class IGrafica extends UI{
    Jogo jogo;
    Control controller;
    JFrame igrafica;
    
    
    
    public IGrafica(){
    }
    
    public void test(){
        jogo = new Jogo();
        controller = new Control(this,jogo);
        igrafica = new Menu(controller);
    }
    
    public void moverPosicao(int y, int x){
        controller.getJogador().getToken().setX(x);
        controller.getJogador().getToken().setY(y);
    }
    
    public void upgradeForca(int x){
        
    }
    
    public void upgradeCarga(int x){
        
    }
    
    public void venderMaterial(Cubo material){
        
    }
    
}
