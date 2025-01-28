package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public class Pear extends Fruit {

    //Attribute
    private boolean nachRechts;

    public Pear(double x, double y){
        this.x = x;
        this.y = y;
        speed = 150;
        width = 25;
        height = 35;
        nachRechts = false;
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(0,255,0,255);
        drawTool.drawFilledRectangle(x,y,width,height);
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawRectangle(x,y,width,height);
    }

    public void update(double dt) {
        super.update(dt);
        if(nachRechts){
            x = x + speed*dt;
            if(x >= 1000){
                nachRechts = false;
            }
        } else {
            x = x - speed * dt;
            if (x <= 0) {
                nachRechts = true;
            }
        }
    }

    //TODO 04 Lege eine Methode jumpBack() an, die bei Aufruf das Pear-Objekt oben am oberen Bildschirmrand an einer zufälligen x-Position positioniert.
    @Override
    public void jumpBack() {
            y = 0 - height;
            x = Math.random() * (1000 - width);
        }
}
