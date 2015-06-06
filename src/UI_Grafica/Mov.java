/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI_Grafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author inose_000
 */
public class Mov extends JPanel{
    JPanel left;
    JPanel center;
    JPanel right;
    JFrame trade;
    JFrame ship;
    JButton nave;
    JButton bmateriais;
    JButton bcomprar;
    JLabel jogador;
    JLabel fundos;
    JLabel planeta;
    int x=10;
    int y=10;
    
    public Mov(){
        setLayout(new BorderLayout());
        
        //---------------------- Left
        left = new JPanel();
        left.setPreferredSize(new Dimension(100,600));
        left.setLayout(new GridLayout(14,1));
        jogador = new JLabel(" Jogador ");
        jogador.setForeground(Color.cyan);
        left.add(new JLabel());
        left.add(jogador);
        left.add(new JLabel("Fundos"));
        fundos = new JLabel();
        left.add(fundos);
        left.add(nave = new JButton("Nave"));
        
        
        // ----------------------- Right
        right = new JPanel();
        right.setPreferredSize(new Dimension(100,600));
        right.setLayout(new GridLayout(14,1));
        jogador = new JLabel(" Posição ");
        jogador.setForeground(Color.cyan);
        right.add(new JLabel());
        right.add(jogador);
        right.add(new JLabel("Nome do planeta"));
        right.add(bmateriais = new JButton("Info"));
        right.add(bcomprar = new JButton("Trade"));
        
        //-------------------------Center
        center = new JPanel();
        center.setLayout(new GridLayout(y,x));
        for(int i=0;i<x*y;i++){
            center.add(new JButton(Integer.toString(i)));
        }
        left.setBackground(Color.blue);
        right.setBackground(Color.blue);
        registaListeners();
        add(right, BorderLayout.EAST);
        add(left, BorderLayout.WEST);
        add(center,BorderLayout.CENTER);
    }
    
    void registaListeners(){
        bcomprar.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            if(trade == null){
                trade = new JFrame("Trade");
                trade.setSize(380, 360);
                trade.add(new Trade());
                trade.setResizable(false);
                trade.setVisible(true);
            }
            
        }});
        
        nave.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            if(ship == null){
                ship = new JFrame("NAVE");
                ship.setSize(600, 450);
                ship.add(new Nave());
                ship.setResizable(false);
                ship.setVisible(true);
            }
            
        }});
    }
}
