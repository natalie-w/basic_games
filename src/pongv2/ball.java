package pongv2;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class ball {
    double xVel, yVel, x, y;
    boolean coll = false;
    Color c = Color.white;
    
    public ball() {
        x = 350;
        y = 250;
        xVel = getRandomSpeed() * getRandomDirection();
        yVel = getRandomSpeed() * getRandomDirection();
    }
    
    public double getRandomSpeed() {
        return (Math.random() * 3 + 2);
    }
    
    public int getRandomDirection() {
        int rand = (int)(Math.random() * 2);
        if(rand == 1) {
            return 1;
        }
        else
            return -1;
                
    }
    
    public void draw(Graphics g) {
        if (coll) {
            System.out.print("collision");
            Random r = new Random();
            c = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
            coll = false;
        }
        g.setColor(c);
        g.fillOval((int)x - 10, (int)y - 10, 20, 20);
    }
    
    public void checkPaddleCollision(Paddle p1, Paddle p2) {
        if(x <= 50) {
            if(y >= p1.getY() && y <= p1.getY() + 80) {
                xVel = -xVel;
                coll = true;
            }
        }
        else if(x >= 650) {
            if(y >= p2.getY() && y <= p2.getY() + 80) {
                xVel = -xVel;
                coll = true;
            }
        }
    }
    
    public void move() {
        x += xVel;
        y += yVel;
        
        if (y < 10) {
            yVel = -yVel;
        }
        if (y > 490) {
            yVel = -yVel;
        }
    }
    
    public int getX() {
        return (int)x;
    }
    public int getY() {
        return (int)y;
    }
}
