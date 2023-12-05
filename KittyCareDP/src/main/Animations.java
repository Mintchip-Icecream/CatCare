package main;
import javax.imageio.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class Animations {
    public BufferedImage idle1, idle2;
    gamePlay gp;
    Graphics2D g2;

    public Animations(gamePlay gp) {
        this.gp = gp;
    }

    public void draw(Graphics2D g2){
        this.g2 =g2;
        BufferedImage image = null;
        switch(gp.choice.as){
            case as1:
                break;
            case as2:
                break;
            case as3:
                break;
            case as4:
                break;
        }
        idleAnimation();
        if (gp.animationTimer <= 15){image = idle1;}
        else if (gp.animationTimer <=30) {image = idle2;}
        else{gp.animationTimer = 0;}
        g2.drawImage(image, (gp.screenWidth/2)-96, (gp.screenHeight/2)-96, gp.tileSize*4, gp.tileSize*4, null);
    }


    public void idleAnimation(){
        try{
            idle1 = ImageIO.read(new File("src/res/idleCat/idleCat1.png"));
            idle2 = ImageIO.read(new File("src/res/idleCat/idleCat2.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
