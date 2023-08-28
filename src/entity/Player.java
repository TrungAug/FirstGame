/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import KeyEvent.KeyHandler;
import component.GamePanel;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public final class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;

    public Player() {
    }

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_2.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if (keyH.upPress == true) {
            direction = "up";
            y -= speed;
            //  System.out.println("W");
        } else if (keyH.downPress == true) {
            direction = "down";
            y += speed;
            // System.out.println("S");
        } else if (keyH.leftPress == true) {
            direction = "left";
            x -= speed;
            // System.out.println("A");
        } else if (keyH.rightPress == true) {
            direction = "right";
            x += speed;
            // System.out.println("D");
        }
    }

    public void draw(Graphics2D g2) {
//        g2.setColor(Color.GREEN);
//        g2.fillRect(x, y, gp.titleSize, gp.titleSize);
        BufferedImage image = null;
        switch (direction) {
            case "up":
                image = up1;
                break;
            case "down":
                image = down1;
                break;
            case "left":
                image = left1;
                break;
            case "right":
                image = right1;
                break;
            default:
               image = null;
        }
        
        g2.drawImage(image,x, y, gp.titleSize, gp.titleSize,null);
    }
}
