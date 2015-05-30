/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Jogo.*;
import UI.*;

/**
 *
 * @author inose_000
 */
public class Control {
    Jogo jogo;
    UI view;
    
    public Control(UI vista, Jogo j){
        view = vista;
        jogo = j;
    }
}
