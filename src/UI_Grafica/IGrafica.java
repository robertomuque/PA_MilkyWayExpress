/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI_Grafica;

import Jogo.Jogo;
import UI.UI;
import javax.swing.JFrame;

/**
 *
 * @author inose_000
 */
public class IGrafica extends UI{
    Jogo jogo = new Jogo();
    JFrame igrafica;
    public IGrafica(){
    }
    
    public void test(){
        igrafica = new Menu();
    }
}
