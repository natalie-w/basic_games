package pongv2;

import java.awt.Color;
import java.awt.Graphics;

public class AIPaddle extends Paddle{
    double y, yVel;
    boolean upAccel, downAccel;
    final double GRAVITY = 0.94;
    int player, x;
    ball b1;
    
    public AIPaddle(int player, ball b) {
        upAccel = false; downAccel = false;
        y = 210; yVel = 0;
        b1=b;
        
        if(player == 1)
            x = 20;
        else
            x = 660;
    }
    
    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x,  (int)y, 20, 80);
    }
    
    public void move() {  
        y = b1.getY() - 40;
        
        if(y < 0) {
            y = 0;
        }
        if(y > 420) {
            y = 420;
        }
    }
    


    public void setUpAccel(boolean input) {
        upAccel = input;
    }
    
    public void setDownAccel(boolean input) {
        downAccel = input;
    }
    
    public int getY() {
        return (int)y;
    }
}
