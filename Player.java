
package hardestgame;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author 800061
 */
public class Player {
    private int x, y; 
    // final means can't change
    private static final int width = 30, height = 30;
    private static final Color color = Color.ORANGE;
    
    public Player (int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x,y,width,height);
    }
    
    public void move() {
        
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }
    
    
}
