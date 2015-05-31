/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI_Grafica;

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
    
    CardLayout cardLayout;
    JPanel geral;
    JPanel menu;
    JPanel mov;
    JPanel trade;
    JButton iniciar;
    Container cont;
    JButton addJogador;
    JButton fechar;
    
    public Menu(){
        super("MILKY WAY EXPRESS");
        setVisible(true);
        setSize(600,400);
        cardLayout = new CardLayout();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        geral = new JPanel();
        geral.setLayout(cardLayout);
        menu = new JPanel();
        mov = new Mov();
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
    }
    
    void registaListeners(){
        iniciar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("WHOOLAY");
                cardLayout.show(geral, "Mover");
                           }
        });
    }
    
    
    
    
}
