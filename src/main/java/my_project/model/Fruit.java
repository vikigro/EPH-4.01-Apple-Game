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
        int i = 0;
        for (Player potentialPlayer : playersToCollideWith) { //geht die ganze liste durch (wie ipairs in lua)
            if (potentialPlayer == null) {
                playersToCollideWith[i] = player;
                System.out.println("found free slot: " + i);
                break; // stoppt den gesamten for-loop

            }
            i++;
        }
    }
    private void handlePlayerCollisions(){
        for (Player playerToCollideWith: playersToCollideWith) {
            if (playerToCollideWith != null) { // " != " ist "ungleich"
                System.out.println("found player");
                if (playerToCollideWith.collidesWith(this)){
                    System.out.println("found collision");
                    hitPlayer(playerToCollideWith);
                }
            }
        }
    }
}
