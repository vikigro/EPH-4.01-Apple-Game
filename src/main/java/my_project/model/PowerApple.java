package my_project.model;

import KAGO_framework.view.DrawTool;

public class PowerApple extends Apple {


    public PowerApple(double x, double y) {
        super(x, y);

        speedModifier = 1 + 1*Math.random();
    }
    @Override
    public void draw(DrawTool tool) {
        super.draw(tool);
        tool.setCurrentColor(100,90,10,255);
        tool.drawFilledRectangle(x - 2, y - radius - 10, 4, 10);
    }
}
