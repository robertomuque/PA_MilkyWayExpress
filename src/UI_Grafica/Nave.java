/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI_Grafica;

import Control.Control;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author inose_000
 */
public class Nave extends JPanel{
    Control controller;
    
    //forca
    JPanel forca;
    JLabel forca_label;
    List<JButton> forcaLista = new ArrayList<>();
    
    //carga
    JPanel carga;
    JLabel carga_label;
    List<JButton> cargaLista = new ArrayList<>();
    
    //materiais
    JPanel materiais;
    JLabel materiais_label;
    JPanel materia;
    List<JButton> materiasv = new ArrayList<>();
    
    //imagens
    Image img;
    
    // construtor
    public Nave(Control cc){
        try{
           ImageIcon imgem = new ImageIcon(ImageIO.read(new File("C:\\Users\\inose_000\\Pictures\\PA\\jar\\0,,14316948,00.jpg")));
           img = imgem.getImage();
            
        }catch(IOException e){
            
        }
        controller = cc;
        forca = new JPanel();
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        forca.add(forca_label = new JLabel("Força: "));
        forca_label.setForeground(Color.white);
        
        for(int i=0;i<cc.getLengForca();i++){
            if(i<cc.getForca()){
                forcaLista.add(new JButton());
                forcaLista.get(i).setBackground(Color.red);
                forca.add(forcaLista.get(i));
            }
            else{
                forcaLista.add(new JButton());
                forca.add(forcaLista.get(i));
            }
        }
        carga = new JPanel();
        carga.add(carga_label = new JLabel("Carga: "));
        carga_label.setForeground(Color.white);
        
        for(int i=0;i<cc.getLengCarga();i++){
            if(i<cc.getCarga()){
                cargaLista.add(new JButton());
                cargaLista.get(i).setBackground(Color.red);
                carga.add(cargaLista.get(i));
            }
            else{
                cargaLista.add(new JButton());
                carga.add(cargaLista.get(i));
            }
        }
        
        materiais = new JPanel();
        materiais.add(materiais_label = new JLabel("Materiais"));
        materia = new JPanel();
        
        for(int i=0;i<cc.getLengCarga();i++){
            String material = cc.getMaterialAt(i);
            if(material != null){
                //adiciona butao com o nome do material
                materiasv.add(new JButton(material));
            }
        }
        
        for(int i = 0;i<materiasv.size(); i++){
            materia.add(materiasv.get(i));
        }
        
        forca.setOpaque(false);
        carga.setOpaque(false);
        //materiais.setOpaque(false);
        this.setAlignmentX(LEFT_ALIGNMENT);
        add(forca);
        add(carga);
        add(materiais);
        add(materia);
        
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, this);
    }
    
    
}
