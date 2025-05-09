package my_project.model;

import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.event.KeyEvent;

public class Player extends InteractiveGraphicalObject {


    //Attribute
    private double speed;
    private int points;

    //Tastennummern zur Steuerung
    private int keyToGoLeft;
    private int keyToGoRight;
    private int direction;

    public Player(double x, double y, int keyToGoLeft, int keyToGoRight) {
        this.x = x;
        this.y = y;
        speed = 150;
        width = 80;
        height = 40;

        this.keyToGoLeft    = keyToGoLeft;
        this.keyToGoRight   = keyToGoRight;
        this.direction      = -1; //-1 keine Bewegung, 0 nach rechts, 2 nach links
    }

    @Override
    public void draw(DrawTool drawTool) {
        if (keyToGoLeft == KeyEvent.VK_A) { drawTool.setCurrentColor(157,152,3,255); }
        drawTool.setCurrentColor(157,152,3,255);
        drawTool.drawFilledRectangle(x,y,width,height);
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawRectangle(x,y,width,height);
    }

    @Override
    public void update(double dt) {
        //TODO 05 Überarbeiten Sie die Update-Methode derart, dass ein Player-Objekt nicht den Bildschirm verlassen kann und immer zu sehen ist.
//        if(x > 1 && x < 1000 - width) {
            if (direction == 0 && x < 980 - width) {
                x += speed * dt;
            }
            if (direction == 2 && x > 5) {
                x -= speed * dt;
            }
//        }
    }

    @Override
    public void keyPressed(int key) {
        if(key == keyToGoLeft){
            direction = 2;
        }
        if(key == keyToGoRight){
            direction = 0;
        }
    }

    @Override
    public void keyReleased(int key) {
        if(key == keyToGoLeft){
            direction = -1;
        }
        if(key == keyToGoRight){
            direction = -1;
        }
    }

    public void setSpeed(double speed){
        this.speed = speed;
    }
    public void moodifySpeed(double speedFactor){
        this.speed *= speedFactor;
        if (speed <= 0.1) {
            speed = 0.1;
        }
    }
}
