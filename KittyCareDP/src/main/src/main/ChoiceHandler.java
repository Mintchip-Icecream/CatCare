package main;

import java.awt.event.*;


public class ChoiceHandler {
    gamePlay gp;
    KeyHandler keyH;

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
                as = actionsecondary.as1;
            } else if (keyH.a2Pressed == true) {
                as = actionsecondary.as2;
            } else if (keyH.a3Pressed == true) {
                as = actionsecondary.as3;
            } else if (keyH.a4Pressed == true){
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
                case a4: System.out.println("a4 has activated the switch case");
                    break;
            }

    }
}
