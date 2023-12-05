package main;

import main.*;

import java.awt.*;
import java.io.*;

public class UI {
    gamePlay gp;
    Graphics2D g2;
    Font normalFont;
    public static final Color Pastel_Pink = new Color(255, 232, 247); //creates new color
    public boolean nonDefaultState = false;
    String[] action = {"Action 1", "Action 2", "Action 3", "Action 4"};
    String[] keyLegend = {"D", "F", "J", "K"};

    ChoiceHandler choice;

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
            g2.fillRect(gp.screenWidth/2, 650, gp.tileSize*3, gp.tileSize*3);
        }

        for (int i = 0; i<4; i++) {
            g2.setColor(Color.black);
            g2.drawRect(((gp.screenWidth/4)*i)-1,649, gp.tileSize*3+1, gp.tileSize*3+1);
            g2.setColor(Pastel_Pink);
            g2.fillRect((gp.screenWidth/4)*i, 650, (gp.tileSize*3)-1, (gp.tileSize*3)-1);
            g2.setColor(Color.BLACK);
            g2.drawString(keyLegend[i], ((gp.screenWidth/4)*i)+55, 750);
        }

        if (nonDefaultState == true){ // container for all of the different choices
            System.out.println("nonDefault State");
            reassignButtons();
            for (int i = 0; i<4; i++) {
                g2.setColor(Color.BLACK);
                g2.drawString(action[i],((gp.screenWidth/4)*i)+35, 700);
            }
        } else { // where the default options on the screen are displayed
            action[0] = "Play";
            action[1] = "Feed";
            action[2] = "Rest";
            action[3] = "Games";
            for (int i = 0; i<4; i++) {
                g2.setColor(Color.BLACK);
                g2.drawString(action[i],((gp.screenWidth/4)*i)+35, 700);
            }
        }


    }
    public void reassignButtons(){ //Reassignment for buttons
        switch(gp.choice.at){
            case a1: action[0] = "Pet";action[1] = "Brush";action[2] = "Feather";action[3] = "";break;
            case a2: action[0] = "Salmon";action[1] = "Beef";action[2] = "Chicken";action[3] = "Milk";break;
            case a3: action[0] = "1 HR";action[1] = "2 HR";action[2] = "3 HR";action[3] = "";break;
            case a4: action[0] = "Bowls";action[1] = "";action[2] = "";action[3] = "";break;

        }
    }

}
