package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public class Apple extends Fruit {

    //Attribute

    public Apple(double x, double y){
        this.x = x;
        this.y = y;
        speed = 150;
        radius = 30;
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(255,0,0,255);
        drawTool.drawFilledCircle(x,y,radius);
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawCircle(x,y,radius);
    }

    //TODO 02 Lege eine Methode jumpBack() an, die bei Aufruf das Apple-Objekt oben am oberen Bildschirmrand an einer zufälligen x-Position positioniert.
    @Override
    public void jumpBack() {
        y = 0 - radius;
        x = Math.random() * (1000 - 2 * radius) + radius;
    }
}
