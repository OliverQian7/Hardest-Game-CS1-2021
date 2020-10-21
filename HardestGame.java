package hardestgame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Oliver Qian
 */
public class HardestGame extends JPanel implements KeyListener, MouseListener {

    private Timer timer;
    private int frameCount = 0;
    private Player player;
    private Border topWall;
   // private Border leftWall;
    //private Border bottomWall;
    //private Border rightWall;
    private Goal finish;
    private Goal start;
    private Enemy enemy1;
    private Enemy enemy2;
    private Enemy enemy3;
    
    public HardestGame() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), 100, 1000/12);
        this.player = new Player(50,75);
        this.topWall = new Border(0,0,783,560);
       // this.leftWall = new Border(0,0,3,700);
        //this.bottomWall = new Border (0,558,800,3);
        //this.rightWall = new Border (781,0,3,700);
        this.finish = new Goal (650,450,200,150,true);
        this.start = new Goal (0,0,200,150,false);
        this.enemy1 = new Enemy (400,200,0,1);
        this.enemy2 = new Enemy (500,300,1,0);
        this.enemy3 = new Enemy (75,475,1,-1);
    }
    
     @Override
     public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        frameCount++;
        
        this.setBackground(Color.gray);		
       
        finish.draw(g);
        start.draw(g);
        player.draw(g);
        enemy1.draw(g);
        enemy2.draw(g);
        enemy3.draw(g);
        topWall.draw(g);
       // leftWall.draw(g);
        //bottomWall.draw(g);
        //rightWall.draw(g);
        
        enemy1.move ();
        enemy2.move();
        enemy3.move();
        enemy1.collideWorldBounds(topWall);
        enemy2.collideWorldBounds(topWall);
        enemy3.collideWorldBounds(topWall);
    }
     
    private class ScheduleTask extends TimerTask {

        @Override
        public void run() {
            repaint();
        }
    }
    
    public static void main(String[] args) {
        JFrame j = new JFrame("Blobby Game");
        Container c = new HardestGame();
        j.add(c);
        j.pack();
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setSize(800, 600);
        j.setVisible(true);
        j.setLocationRelativeTo(null);
        j.addKeyListener((KeyListener) c);
        j.addMouseListener((MouseListener) c);
    }
    
     @Override
    public void keyPressed(KeyEvent e) {
        System.out.printf("\nKeyCode: %d was pressed",e.getKeyCode());
       // player.move(0,1);
            if (e.getKeyCode()== 87) {
            player.move(0,-1);
        }
            if (e.getKeyCode()== 83) {
            player.move(0,1);
        }
            if (e.getKeyCode()== 68) {
            player.move(1,0);
        }
            if (e.getKeyCode()== 65) {
            player.move(-1,0);
        }
    }
    
     @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.printf("\nMouse Clicked at (%d,%d)",e.getX(), e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
