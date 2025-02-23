package my_project.model;

import KAGO_framework.model.GraphicalObject;

public abstract class Fruit extends GraphicalObject {
    private Player[] playersToCollideWith = new Player[2];
    protected double speed;
    protected double speedModifier = 1;

    public void update(double dt) {
        //TODO 01 Ein Apfel soll von oben herab fallen. Sobald er unten den Bildschirmrand berührt wird die Methode jumpBack() aufgerufen (siehe TODO 02).
        y = y + speed * dt;
        if (y >= 1000) {
            jumpBack();
        }
        handlePlayerCollisions();
    }

    public abstract void jumpBack();
    public void hitPlayer(Player player) {
        player.moodifySpeed(speedModifier);
        jumpBack();
    }
    public void addPlayerToCollisionDetection(Player player) {
        for (int i = 0; i < playersToCollideWith.length; i++) {
            if (playersToCollideWith[i] == null) {
                playersToCollideWith[i] = player;
            }
        }
    }
    private void handlePlayerCollisions(){
        for (int i = 0; i < playersToCollideWith.length; i++) {
            if (playersToCollideWith[i] != null) {
                if (playersToCollideWith[i].collidesWith(this)){
                    hitPlayer(playersToCollideWith[i]);
                }
            }
        }
    }
}
