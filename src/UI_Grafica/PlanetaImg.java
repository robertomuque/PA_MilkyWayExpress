/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI_Grafica;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author inose_000
 */
public class PlanetaImg extends JPanel{
    Image img;
    public PlanetaImg(){
        try{
           ImageIcon imgem = new ImageIcon(ImageIO.read(new File("C:\\Users\\inose_000\\Pictures\\PA\\jar\\planetas\\gethen.jpg")));
           img = imgem.getImage();
            
        }catch(IOException e){
            
        }
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(img, 0, 0, this);
    }
}
