package main;
import javax.imageio.*;

import main.ChoiceHandler.gametype;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class Animations {
    public BufferedImage idle1, idle2, bowl;
    gamePlay gp;
    Graphics2D g2;
    BufferedImage image;

    public Animations(gamePlay gp) {
        this.gp = gp;
        this.image = null;
    }

    public void draw(Graphics2D g2){
        this.g2 =g2;
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
        if(gp.choice.gameStart != gametype.noGame)
        {
            gameAnimation();
        }else
        {
            idleAnimation();
            if (gp.animationTimer <= 15){image = idle1;}
            else if (gp.animationTimer <=30) {image = idle2;}
            else{gp.animationTimer = 0;}
            g2.drawImage(image, (gp.screenWidth/2)-96, (gp.screenHeight/2)-96, gp.tileSize*4, gp.tileSize*4, null);
        }
    }


    public void idleAnimation(){
        try{
            idle1 = ImageIO.read(new File("src/res/idleCat/idleCat1.png"));
            idle2 = ImageIO.read(new File("src/res/idleCat/idleCat2.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void happinessAnimation(){
    }

    
    public void gameAnimation(){
        if(gp.choice.gameStart == gametype.bowl )
        {
            try{
                image = ImageIO.read(new File("src/res/image/bowl1.png"));
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        if(gp.choice.gameStart == gametype.winGame )
        {

            gp.animationTimer = 0;
            gp.choice.gameStart = gametype.loadGame;
            try{
                image = ImageIO.read(new File("src/res/image/winCat.png"));
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        if(gp.choice.gameStart == gametype.loseGame )
        {
            gp.animationTimer = 0;
            gp.choice.gameStart = gametype.loadGame;
            try{
                image = ImageIO.read(new File("src/res/image/loseCat.png"));
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        if(gp.choice.gameStart == gametype.loadGame )
        {
            if (gp.animationTimer > 30)
            {
                gp.choice.gameStart = gametype.noGame;
            }
        }
        g2.drawImage(image, (gp.screenWidth/2)-96, (gp.screenHeight/2)-96, gp.tileSize*4, gp.tileSize*4, null);
    }
}
