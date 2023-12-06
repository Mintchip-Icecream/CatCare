package main;

import java.awt.event.*;
import java.util.Random;


public class ChoiceHandler {
    gamePlay gp;
    KeyHandler keyH;
    boolean bowlGameStart = false;
    boolean [] bowls = new boolean [4];

    KeyHandler lastKeyH;
    boolean buttonPress = false;

    public enum actiontype {
        a1, a2, a3, a4
    }
    actiontype at;

    public enum actionsecondary {
        as1, as2, as3, as4, asnone
    }
    actionsecondary as;

    public ChoiceHandler(gamePlay gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
    }

    public void update() {
        as=actionsecondary.asnone;
        if (gp.ui.nonDefaultState == true && gp.internalTimer > 10){
            if (keyH.a1Pressed == true) {
                keyH.a1Pressed = false;
                as = actionsecondary.as1;
            } else if (keyH.a2Pressed == true) {
                keyH.a1Pressed = false;
                as = actionsecondary.as2;
            } else if (keyH.a3Pressed == true) {
                keyH.a1Pressed = false;
                as = actionsecondary.as3;
            } else if (keyH.a4Pressed == true){
                keyH.a1Pressed = false;
                as = actionsecondary.as4;
            }
            inputPerformed();

        } else if (gp.internalTimer > 10){
            if (keyH.a1Pressed == true) {
                at = actiontype.a1;
                keyH.a1Pressed = false;
                gp.internalTimer = 0;
                gp.ui.nonDefaultState = true;

            } else if (keyH.a2Pressed == true) {
                at = actiontype.a2;
                keyH.a2Pressed = false;
                gp.internalTimer = 0;
                gp.ui.nonDefaultState = true;

            } else if (keyH.a3Pressed == true) {
                at = actiontype.a3;
                keyH.a3Pressed = false;
                gp.internalTimer = 0;
                gp.ui.nonDefaultState = true;

            } else if (keyH.a4Pressed == true) {
                at = actiontype.a4;
                keyH.a4Pressed = false;
                gp.internalTimer = 0;
                gp.ui.nonDefaultState = true;

            }
        }
    }

    public void draw() {
    }

    public void winBowlGame()
    {
        gp.catCoinStat = gp.catCoinStat + 5;
        bowlGameStart = false;
        System.out.println("Gain 5 coins");
        System.out.println("Win Bowl game\n");
    }
    
    public void loseBowlGame()
    {
        bowlGameStart = false;
        System.out.println("Lose Bowl game\n");
    }
    
    public void inputPerformed() { //where all of the different key input scenarios go
        switch (at) {
                case a1:System.out.println("a1 has activated the switch case");
               switch (as){
                   case as1:
                       System.out.println("SECONDARY SWITCH ACTIVATED");
                       gp.internalTimer = 0;
                       gp.ui.nonDefaultState = false;
                       break;
               }
                break;
                case a2: System.out.println("a2 has activated the switch case");
                    break;
                case a3: System.out.println("a3 has activated the switch case");

                    break;
                case a4: 
                { 
                    if(bowlGameStart == false)
                    {
                        switch (as){
                            case as1:
                            {
                                bowlGameStart = true;
                                Random random = new Random();
                                bowls = new boolean [4]; 
                                bowls [random.nextInt(3)] = true;
                                System.out.println("Start Bowl game");

                                break;
                            }
                        }
                    }else
                    {
                        if(as != actionsecondary.asnone)
                        {
                            if(bowls[as.ordinal()] == true)
                            {
                                winBowlGame();
                            }else{
                                loseBowlGame();
                            }
                        }
                    }
                    
                    
                    
                    break;
                }
            }

    }
}
