package my_project.model;
import KAGO_framework.view.DrawTool;

public class BadApple extends Apple {

    public BadApple(double x, double y) {
        super(x, y);

        speedModifier = 1 - 1*Math.random();
    }

    @Override
    public void draw(DrawTool drawTool){
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawFilledCircle(x,y,radius);
        drawTool.drawFilledRectangle(x - 2, y-radius -10, 4, 10);
    }
}
