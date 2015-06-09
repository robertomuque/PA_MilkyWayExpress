/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI_Grafica;

import Ataque.AtaquePirata;
import Control.Control;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author inose_000
 */
public class CoordsListener implements ActionListener{
    
    Control controller;
    List<AtaquePirata> ataques = new ArrayList<>();
    
    CoordsListener(Control cc){
        controller = cc;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        int y = Integer.parseInt(btn.getClientProperty("y").toString());
        int x = Integer.parseInt(btn.getClientProperty("x").toString());
        int direcao = controller.getDirecao(y, x);
        if(direcao != 0){
            controller.moverNave(controller.getDirecao(y, x));
            ataques = controller.getAtaques();
            if(!ataques.isEmpty()){
                JFrame frame = new JFrame("ATAQUE");
                JPanel painel = new JPanel();
                painel.setLayout(new BoxLayout(painel,BoxLayout.Y_AXIS));
                for(int i=0;i<ataques.size();i++){
                    if(ataques.get(i).getResgate()!=0){
                        int num = i+1;
                        painel.add(new JLabel("Ataque " + num));
                        painel.add(new JLabel("Resgate: " + ataques.get(i).getResgate() + " Coins"));
                        painel.add(new JLabel());
                    }
                    else{
                        int num = i+1;
                        painel.add(new JLabel("Ataque " + num));
                        painel.add(new JLabel("Batalha vencida!"));
                        painel.add(new JLabel());
                    }
                }
                frame.add(painel);
                frame.setSize(new Dimension(200,100));
                frame.setVisible(true);
            }
        }
        
    }
   
}
