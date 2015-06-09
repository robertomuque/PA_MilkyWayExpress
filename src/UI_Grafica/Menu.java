/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI_Grafica;

import Estados.*;
import Control.Control;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author inose_000
 */
public class Menu extends JFrame{
    Control controller;
    CardLayout cardLayout;
    JPanel geral;
    JPanel menu;
    JPanel mov;
    JPanel trade;
    JButton iniciar;
    Container cont;
    JButton addJogador;
    JButton fechar;
    JButton bparar;
    
    public Menu(Control cc){
        super("MILKY WAY EXPRESS");
        controller = cc;
        
        setVisible(true);
        setSize(800,600);
        cardLayout = new CardLayout();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        mov = new Mov(controller);
        geral = new JPanel();
        
        geral.setLayout(cardLayout);
        menu = new JPanel();
        
        menu.setLayout(new BorderLayout());
        menu.setBackground(Color.yellow);
        
        iniciar = new JButton("Iniciar");
        fechar = new JButton("Abandonar");
        menu.add(iniciar, BorderLayout.NORTH);
        menu.add(fechar, BorderLayout.SOUTH);
        registaListeners();
        geral.add(menu, "Menu");
        geral.add(mov, "Mover");
        cardLayout.show(geral, "Menu");
        add(geral);
        setVisible(true);
    }
    
    void registaListeners(){
        iniciar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                if(controller.getEstado() instanceof E00_Menu){
                    controller.comercaJogo();
                    cardLayout.show(geral, "Mover");
                }
             }
        });
        
        fechar.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }});
    }
    
    
    
    
}
