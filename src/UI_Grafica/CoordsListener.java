/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI_Grafica;

import Control.Control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author inose_000
 */
public class CoordsListener implements ActionListener{
    
    Control controller;
    
    CoordsListener(Control cc){
        controller = cc;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        int y = Integer.parseInt(btn.getClientProperty("y").toString());
        int x = Integer.parseInt(btn.getClientProperty("x").toString());
        System.out.println(y +","+ x);
        controller.moverNave(controller.getDirecao(y, x), y, x);
        System.out.println(""+controller.getPosY()+ " " + controller.getPosX());
    }
   
}
