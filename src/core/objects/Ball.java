package core.objects;

import core.main.GameObject;
import core.main.Handler;
import core.main.Main;
import org.w3c.dom.css.Rect;

import java.awt.*;

public class Ball extends GameObject {

    private int radius;

    private Handler handler;
    private Main main;

    public Ball(float x, float y, Main main, Handler handler, int radius) {
        super(x, y);
        this.handler = handler;
        this.main = main;

        this.radius = radius;
    }

    public boolean colliding() {
        //find the closest ball
        //check of the distance is less than twice the radius
        //if it is then call avoid()
        ;
        GameObject tempBall = null;
        for(int i = 0; i < handler.getObjects().size(); i++) {
            GameObject tempObject = handler.getObjects().get(i);
            if (tempObject == this) {
                continue;
            }
            if(tempBall == null) {
                tempBall = tempObject;
            }
            float xToTempBall = tempBall.getX() - x,
                    yToTempBall = tempBall.getY() - y,
                    xToTempObj = tempObject.getX() - x,
                    yToTempObj = tempObject.getY() - y;

            float distToTempBall = (float) Math.sqrt((xToTempBall * xToTempBall) + (yToTempBall * yToTempBall));
            float distToTempObj = (float) Math.sqrt((xToTempObj * xToTempObj) + (yToTempObj * yToTempObj));

            if(distToTempObj < distToTempBall) {
                tempBall = tempObject;
            }
        }
        float delX = tempBall.getX() - x, delY = tempBall.getY() - y;

        return Math.sqrt((delX * delX) + (delY * delY)) < (2 * radius);
    }

    public void bounce() {
        //find impulse vector
        // add it to the velocity vector
        System.out.println("COLLIDING!");
        velX = 0;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        if(colliding()) {
            bounce();
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval((int) x - radius, (int) y - radius,  2 * radius, 2 * radius);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(radius, radius);
    }


}
