/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import component.GamePanel;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;

/**
 *
 * @author ASUS
 */
public final class TileManager {

    GamePanel gp;
    Tile[] tile;

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[10];
        getTileImage();
    }

    public void getTileImage() {
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water.png"));

//            tile[3]= new Tile();
//            tile[3].image=ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));
//            
//            tile[4]= new Tile();
//            tile[4].image=ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
//        g2.drawImage(tile[0].image,0,0,gp.titleSize,gp.titleSize,null);
//        g2.drawImage(tile[1].image,48,0,gp.titleSize,gp.titleSize,null);
//        g2.drawImage(tile[2].image,96,48,gp.titleSize,gp.titleSize,null);
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;
        while (col < gp.maxScreenCol && row < gp.maxScreenRow) {
            g2.drawImage(tile[0].image, x, y, gp.titleSize, gp.titleSize, null);
            col++;
            x+=gp.titleSize;
            if(col==gp.maxScreenCol){
                col=0;
                x=0;
                row++;
                y+=gp.titleSize;
            }
        }
    }
}
