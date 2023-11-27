import java.awt.*;

public class Main {
    final int originalTitleSize = 16; // 16x16 tile
    final int scale = 3;

    final int tileSize = originalTitleSize * scale; // 48x48 tile
    final int maxScreenRow = 16;
    final int maxScreenCol = 12;
    final int screenWidth = tileSize * maxScreenCol; //768 pixels tall
    final int screenHeight = tileSize * maxScreenRow;// 576 pixels wide
    public static final Color Pastel_Pink = new Color(255, 232, 247); //creates new color


    public Main(){
        DrawingPanel panel = new DrawingPanel(screenWidth, screenHeight);
        Graphics g2 = panel.getGraphics();
        panel.setBackground(Pastel_Pink);
        g2.drawRect(100, 100, 200, 200);


    }

    public static void main(String[] args) {
        new Main();
    }
}