/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI_Grafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author inose_000
 */
public class Menu extends JFrame{
    
    JPanel menu;
    JButton iniciar;
    Container cont;
    JButton addJogador;
    JButton fechar;
    
    public Menu(){
        super("GALAXY EXPRESS");
        setVisible(true);
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        menu = new JPanel();
        menu.setBackground(Color.yellow);
        
        iniciar = new JButton("1 Jogador");
        fechar = new JButton("Abandonar");
        addJogador = new JButton("2 Jogadores");
        add(menu);
        menu.add(iniciar);
        menu.add(fechar);
        menu.add(addJogador);
    }
    
    
    
    
}
