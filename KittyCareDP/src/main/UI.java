package main;

import main.*;

import java.awt.*;
import java.io.*;

public class UI {
    final int originalTitleSize = 16; // 16x16 tile
    final int scale = 3;
    final int tileSize = originalTitleSize * scale; // 48x48 tile
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenRow; //576 pixels wide
    final int screenHeight = tileSize * maxScreenCol;// 768 pixels tall
    gamePlay gp;
    Graphics2D g2;
    Font normalFont;
    public static final Color Pastel_Pink = new Color(255, 232, 247); //creates new color

    public UI(gamePlay gp){
        this.gp=gp;
        {
            try {
                normalFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/res/font/x12y16pxMaruMonica.ttf")).deriveFont(36f);
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/res/font/x12y16pxMaruMonica.ttf")));
            } catch (FontFormatException | IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void draw(Graphics2D g2){
        this.g2 =g2;
        g2.setFont(normalFont);
        g2.setColor(Color.black);
        for (int i = 0; i<4; i++) {
            g2.fillRect(screenWidth/2, 576, tileSize*3, tileSize*3);
        }

        for (int i = 0; i<4; i++) {
            g2.setColor(Color.black);
            g2.drawRect(((screenWidth/4)*i)-1,575, tileSize*3+1, tileSize*3);
            g2.setColor(Pastel_Pink);
            g2.fillRect((screenWidth/4)*i, 576, (tileSize*3)-1, (tileSize*3)-1);
            g2.setColor(Color.BLACK);
            g2.drawString("Action " + (i+1),((screenWidth/4)*i)+23, 690);
        }
    }

}
