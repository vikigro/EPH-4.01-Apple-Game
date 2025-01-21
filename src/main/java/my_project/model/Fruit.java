package my_project.model;

import KAGO_framework.model.GraphicalObject;

public abstract class Fruit extends GraphicalObject {

    protected double speed;

    public void update(double dt) {
        //TODO 01 Ein Apfel soll von oben herab fallen. Sobald er unten den Bildschirmrand berührt wird die Methode jumpBack() aufgerufen (siehe TODO 02).
        y = y + speed * dt;
        if (y >= 1000) {
            jumpBack();
        }
    }

    public abstract void jumpBack();
}
