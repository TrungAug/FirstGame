/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package KeyEvent;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author ASUS
 */
public class KeyHandler implements KeyListener{
public boolean upPress,downPress, leftPress, rightPress;
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(code==KeyEvent.VK_W){
            upPress=true;
        }
        if(code==KeyEvent.VK_S){
            downPress=true;
        }
        if(code==KeyEvent.VK_A){
            leftPress=true;
        }
        if(code==KeyEvent.VK_D){
            rightPress=true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if(code==KeyEvent.VK_W){
            upPress=false;
        }
        if(code==KeyEvent.VK_S){
            downPress=false;
        }
        if(code==KeyEvent.VK_A){
            leftPress=false;
        }
        if(code==KeyEvent.VK_D){
            rightPress=false;
        }
    }
    
}
