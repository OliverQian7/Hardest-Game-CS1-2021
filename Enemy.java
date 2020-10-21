package hardestgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
/**
 *
 * @author Oliver Qian
 */
public class Enemy {
    private int x, y, vx, vy;
    private final static int SPEED = 2;
    private final static int WIDTH = 30, HEIGHT = 30;
    private final static Color COLOR = Color.RED;
    
    public Enemy (int x, int y, int vx, int vy) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
    }
    
    public void draw(Graphics g) {
        g.setColor(Color.red);
        g.fillOval (x, y, WIDTH, HEIGHT);
        g.setColor(Color.black);
        g.drawOval (x,y, WIDTH, HEIGHT);
    }
    public void move() {
        x += vx * SPEED;
        y += vy * SPEED;
    }
   /**
    * Check if enemy hits border, then turns around
    * @param border -- the boundaries of the room
    */
    public void collideWorldBounds(Border border) {
        Rectangle enemyBounds = new Rectangle (x, y, WIDTH, HEIGHT);
        Rectangle borderBounds = new Rectangle (border.getX(), border.getY(), border.getWidth(), border.getHeight());
        if (!borderBounds.contains(enemyBounds)) {
            vy= -vy;
            vx= -vx;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getVx() {
        return vx;
    }

    public int getVy() {
        return vy;
    }

    public static int getSPEED() {
        return SPEED;
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public static Color getCOLOR() {
        return COLOR;
    }
    
}
