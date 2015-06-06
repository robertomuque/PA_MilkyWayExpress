/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI_Grafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author inose_000 
 */
public class Trade extends JPanel{
    Image img;
    JPanel center;
    JPanel east;
    JButton material1;
    JButton material2;
    List<JButton> venda = new ArrayList<>();
    
    public Trade(){
        setLayout(new BorderLayout());
        center = new PlanetaImg();
        center.setLayout(new BoxLayout(center,BoxLayout.Y_AXIS));
        east = new JPanel();
        east.setBackground(Color.red);
        east.add(new JLabel("Vender"));
        add(center, BorderLayout.CENTER);
        add(east, BorderLayout.EAST);
        
    }
}
