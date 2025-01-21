package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public class Traube extends Fruit {

    //Attribute

    public Traube(double x, double y){
        this.x = x;
        this.y = y;
        speed = 150;
        radius = 10;
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(160,0,255,255);
        drawTool.drawFilledCircle(x,y,radius);
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawCircle(x,y,radius);
    }

    @Override
    public void jumpBack() {
        y = 0 - radius;
        x = Math.random() * (1000 - 2 * radius) + radius;
    }
}
