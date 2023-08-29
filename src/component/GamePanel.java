/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package component;

import KeyEvent.KeyHandler;
import entity.Player;
import entity.TileManager;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

public final class GamePanel extends JPanel implements Runnable {

    final int originalTitleSize = 16;
    final int scale = 3;
    public final int titleSize = originalTitleSize * scale;
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = titleSize * maxScreenCol;
    public final int screenHight = titleSize * maxScreenRow;

    //set player position
//    int playerX = 100;
//    int playerY = 100;
//    int playerSpeed = 4;
    //Frame Per Second
    int FPS = 60;

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    Player player = new Player(this, keyH);
    TileManager tileM = new TileManager(this);

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        this.startGameThread();
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;
        while (gameThread != null) {
            //update
            update();
            //draw
            repaint();

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime / 1000000;
                if (remainingTime < 0) {
                    remainingTime = 0;
                }
                Thread.sleep((long) remainingTime);
                nextDrawTime += drawInterval;
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void update() {
        player.update();
    }

//    public void update() {
//        if (keyH.upPress == true) {
//            playerY -= playerSpeed;
//            //  System.out.println("W");
//        } else if (keyH.downPress == true) {
//            playerY += playerSpeed;
//            // System.out.println("S");
//        } else if (keyH.leftPress == true) {
//            playerX -= playerSpeed;
//            // System.out.println("A");
//        } else if (keyH.rightPress == true) {
//            playerX += playerSpeed;
//            // System.out.println("D");
//        }
//    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        tileM.draw(g2);
        player.draw(g2);
//        g2.setColor(Color.GREEN);
//        g2.fillRect(playerX, playerY, titleSize, titleSize);
        g2.dispose();

    }

}
