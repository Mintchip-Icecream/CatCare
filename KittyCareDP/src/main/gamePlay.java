package main;

import java.awt.*;

public class gamePlay implements Runnable{
    final int originalTitleSize = 16; // 16x16 tile
    final int scale = 3;
    final int tileSize = originalTitleSize * scale; // 48x48 tile
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenRow; //576 pixels wide
    final int screenHeight = tileSize * maxScreenCol;// 768 pixels tall
    public static final Color Pastel_Pink = new Color(255, 232, 247);//creates new color
    Thread gameThread;
    public UI ui = new UI(this);
    DrawingPanel panel = new DrawingPanel(screenWidth, screenHeight);
    Graphics2D g2;
    KeyHandler keyH = new KeyHandler();
    ChoiceHandler choice = new ChoiceHandler(this,keyH);
    Animations animate = new Animations(this);
    public int internalTimer = 0;
    public int animationTimer = 0;
    public int secondaryTimer = 0;

    public gamePlay() {
        g2 = panel.getGraphics();
        panel.setBackground(Pastel_Pink);
        panel.addKeyListener(keyH);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run() { // IMPORTANT: THIS IS THE GAMELOOP

        while(gameThread != null){
            // Step 1: UPDATE (updating information such character animations or progress)
            update();


            // Step 2: DRAW (making a new screen with updated information )
            rePaint();
            System.out.println("New Frame!");
            internalTimer++;
            animationTimer++;
        }

    }
    public void update() {
        choice.update();
    }
    public void rePaint(){

        // main.UI (should be the last draw method called);
        animate.draw(g2);
        ui.draw(g2);
        panel.sleep(41); //30fps
        panel.clear(); //DISPOSES EACH TIME SCREEN IS DRAWN TO DRAW A NEW SCREEN


    }
}

