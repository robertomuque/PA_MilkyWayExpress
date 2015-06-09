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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author inose_000
 */
public class Mov extends JPanel implements Observer{
    Control controller;
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
    List<JButton> botoes_lista = new ArrayList<>();
    int x;
    int y;
    
    public Mov(Control cc){
        setLayout(new BorderLayout());
        controller = cc;
        controller.addObserver(this);
        x=controller.getTamMatrizX();
        y=controller.getTamMatrizY();
        //---------------------- Left
        left = new JPanel();
        left.setPreferredSize(new Dimension(100,600));
        left.setLayout(new GridLayout(14,1));
        jogador = new JLabel(" Jogador ");
        jogador.setForeground(Color.cyan);
        left.add(new JLabel());
        left.add(jogador);
        left.add(new JLabel("Fundos"));
        fundos = new JLabel(""+controller.getFundos());
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
        for(int i=0;i<y;i++){
            for(int j =0;j<x;j++){
                botoes_lista.add(new JButton());
                botoes_lista.get(botoes_lista.size()-1).setBackground(Color.red);
                botoes_lista.get(botoes_lista.size()-1).putClientProperty("y", i);
                botoes_lista.get(botoes_lista.size()-1).putClientProperty("x", j);
                botoes_lista.get(botoes_lista.size()-1).addActionListener(new CoordsListener(controller));
                        
                if(cc.getJogador().getToken().getPosY()==i && cc.getJogador().getToken().getPosX()==j){
                    center.add(new JButton("*"));
                }
                else if(cc.getTipoCarta(i, j)==1){
                    botoes_lista.get(botoes_lista.size()-1).setBackground(Color.GRAY);
                    center.add(botoes_lista.get(botoes_lista.size()-1));
                }else if(cc.getTipoCarta(i, j)==2){
                    botoes_lista.get(botoes_lista.size()-1).setBackground(Color.MAGENTA);
                    center.add(botoes_lista.get(botoes_lista.size()-1));
                }else{
                    center.add(botoes_lista.get(botoes_lista.size()-1));
                }
                
                
            }
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
                trade.setSize(450, 360);
                trade.add(new Trade(controller));
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
                ship.add(new Nave(controller));
                ship.setResizable(false);
                ship.setVisible(true);
            }
            
        }});
    }

    @Override
    public void update(Observable o, Object arg) {
        fundos.setText(""+controller.getFundos());
        center.removeAll();
        botoes_lista.clear();
        setBotoes();
        revalidate();
        repaint();
    }
    
    
    void setBotoes(){
        for(int i=0;i<y;i++){
            for(int j =0;j<x;j++){
                botoes_lista.add(new JButton());
                botoes_lista.get(botoes_lista.size()-1).setBackground(Color.red);
                botoes_lista.get(botoes_lista.size()-1).putClientProperty("y", i);
                botoes_lista.get(botoes_lista.size()-1).putClientProperty("x", j);
                botoes_lista.get(botoes_lista.size()-1).addActionListener(new CoordsListener(controller));
                        
                if(controller.getJogador().getToken().getPosY()==i && controller.getJogador().getToken().getPosX()==j){
                    center.add(new JButton("*"));
                }
                else if(controller.getTipoCarta(i, j)==1){
                    botoes_lista.get(botoes_lista.size()-1).setBackground(Color.GRAY);
                    center.add(botoes_lista.get(botoes_lista.size()-1));
                }else if(controller.getTipoCarta(i, j)==2){
                    botoes_lista.get(botoes_lista.size()-1).setBackground(Color.MAGENTA);
                    center.add(botoes_lista.get(botoes_lista.size()-1));
                }else{
                    center.add(botoes_lista.get(botoes_lista.size()-1));
                }
                
                
            }
        }
    }
}