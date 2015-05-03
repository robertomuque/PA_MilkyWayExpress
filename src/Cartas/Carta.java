/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cartas;

/**
 *
 * @author inose_000
 */
public class Carta{
    protected int posx;
    protected int posy;
    public void setPos(int xx,int yy){
        posx = xx;
        posy = yy;
    }
    public int getX(){
        return posx;
    }
    public int getY(){
        return posy;
    }
}
