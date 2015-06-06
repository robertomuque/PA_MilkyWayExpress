/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI_Grafica;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
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
    JPanel forca;
    JPanel carga;
    JPanel materiais;
    Image img;
    public Nave(){
        try{
           ImageIcon imgem = new ImageIcon(ImageIO.read(new File("C:\\Users\\inose_000\\Pictures\\PA\\jar\\0,,14316948,00.jpg")));
           img = imgem.getImage();
            
        }catch(IOException e){
            
        }
        
        forca = new JPanel();
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        forca.add(new JLabel("Força: "));
        forca.add(new JButton());
        forca.add(new JButton());
        forca.add(new JButton());
        carga = new JPanel();
        carga.add(new JLabel("Carga: "));
        carga.add(new JButton());
        carga.add(new JButton());
        carga.add(new JButton());
        materiais = new JPanel();
        materiais.add(new JLabel("Materiais"));
        forca.setOpaque(false);
        //forca.setBackground(new Color(0,0,0,0));
        carga.setOpaque(false);
        //carga.setBackground(new Color(0,0,0,0));
        materiais.setOpaque(false);
        add(forca);
        add(carga);
        add(materiais);
        
        
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, this);
    }
    
    
}
