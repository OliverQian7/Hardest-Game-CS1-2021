package hardestgame;

import java.awt.Color;
import java.awt.Graphics;
/**
 *
 * @author Oiver Qian
 */
public class Goal {
    private int x, y;
    private final int width, height;
    private final boolean isFinish;
    private final static Color COLOR = Color.green;
    
    public Goal (int x,int y,int width,int height,boolean isFinish) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.isFinish = isFinish;
    }
    
    public void draw(Graphics g) {
        g.setColor (Color.green);
        g.fillRect (x,y,width,height);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isIsFinish() {
        return isFinish;
    }

    public static Color getCOLOR() {
        return COLOR;
    }
    
}
