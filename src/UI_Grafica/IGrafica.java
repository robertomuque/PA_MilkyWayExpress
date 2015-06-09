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
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;

/**
 *
 * @author inose_000
 */
public class IGrafica extends UI implements Observer{
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

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
