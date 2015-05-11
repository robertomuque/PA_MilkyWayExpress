/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI_Grafica;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author inose_000
 */
public class Menu extends JFrame{
    
    JPanel menu;
    
    public Menu(){
        setName("GALAXY EXPRESS");
        setVisible(true);
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        menu = new JPanel();
        menu.setBackground(Color.yellow);
        
    }
}
