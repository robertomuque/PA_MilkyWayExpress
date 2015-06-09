/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI_Grafica;

import Control.Control;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
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
    Control controller;
    Image img;
    JPanel center;
    JPanel east;
    JButton material1;
    JButton material2;
    List<JButton> venda = new ArrayList<>();
    
    
    public Trade(Control cc){
        controller = cc;
        setLayout(new BorderLayout());
        center = new PlanetaImg();
        center.setLayout(null);
        center.setMaximumSize(new Dimension(360,360));
        setBotoesTrade();
        //center.setPreferredSize(null);
        east = new JPanel();
        east.setLayout(new GridLayout(14,1));
        east.setBackground(Color.red);
        east.add(new JLabel("Vender"));
        add(center, BorderLayout.CENTER);
        add(east, BorderLayout.EAST);
        
        for(int i=0;i<cc.getLengCarga();i++){
            String material = cc.getMaterialAt(i);
            if(material != null){
                //adiciona butao com o nome do material
                venda.add(new JButton(material));
            }
        }
        
        for(int i = 0;i<venda.size(); i++){
            east.add(venda.get(i));
        }
        
    }
    
    
    public void setBotoesTrade(){
        if(controller.getTipoCarta(controller.getPosY(), controller.getPosX()) == 1){
          material1 = new JButton("M1");
        material1.setBounds(110, 270, 50, 50);
         material2 = new JButton("M2");
        material2.setBounds(170, 270, 50, 50);
        
        center.add(material1);
        center.add(material2);  
        }else if(controller.getTipoCarta(controller.getPosY(), controller.getPosX()) == 2){
            
        }
        
    }
}
