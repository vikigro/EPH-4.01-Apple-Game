package my_project.control;

import KAGO_framework.control.ViewController;
import my_project.Config;
import my_project.model.*;

import java.awt.event.KeyEvent;

/**
 * Ein Objekt der Klasse ProgramController dient dazu das Programm zu steuern. Die updateProgram - Methode wird
 * mit jeder Frame im laufenden Programm aufgerufen.
 */
public class ProgramController {

    //Attribute


    // Referenzen
    private ViewController viewController;  // diese Referenz soll auf ein Objekt der Klasse viewController zeigen. Über dieses Objekt wird das Fenster gesteuert.

    private Fruit[] fruits;
    private Player player01;
    private Player player02;
    private Background background;

    /**
     * Konstruktor
     * Dieser legt das Objekt der Klasse ProgramController an, das den Programmfluss steuert.
     * Damit der ProgramController auf das Fenster zugreifen kann, benötigt er eine Referenz auf das Objekt
     * der Klasse viewController. Diese wird als Parameter übergeben.
     * @param viewController das viewController-Objekt des Programms
     */
    public ProgramController(ViewController viewController){
        this.viewController = viewController;
    }

    /**
     * Diese Methode wird genau ein mal nach Programmstart aufgerufen.
     * Sie erstellt die leeren Datenstrukturen, zu Beginn nur eine Queue
     */
    public void startProgram() {
        background = new Background();
        viewController.draw(background);
        player01 = new Player(50, Config.WINDOW_HEIGHT-100, KeyEvent.VK_A, KeyEvent.VK_D);
        player02 = new Player(50, Config.WINDOW_HEIGHT-100, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT);
        viewController.draw(player01);
        viewController.draw(player02);
        viewController.register(player01);
        viewController.register(player02);
        System.out.println("finished creating players");

        int appleAmount = 4;
        int powerAppleAmount = 1;
        int badAppleAmount = 1;
        int pearAmount = 1;
        int traubeAmount = 1;

        fruits = new Fruit[appleAmount + powerAppleAmount + badAppleAmount + pearAmount + traubeAmount];
        for(int i = 0; i < fruits.length; i++){
            double xPos = Math.random()*(Config.WINDOW_WIDTH-50) + 50;
            double yPos = Math.random()*(Config.WINDOW_HEIGHT-50) + 50;
            if(i < appleAmount) {
                fruits[i] = new Apple(xPos, yPos);
            }else if(i < appleAmount + powerAppleAmount) {
                fruits[i] = new PowerApple(xPos, yPos);
            }else if(i < appleAmount + powerAppleAmount + badAppleAmount) {
                fruits[i] = new BadApple(xPos, yPos);
            }else if(i < appleAmount + powerAppleAmount + badAppleAmount + pearAmount) {
                fruits[i] = new Pear(xPos, yPos);
            }else if(i < appleAmount + powerAppleAmount + badAppleAmount + pearAmount + traubeAmount) {
                fruits[i] = new Traube(xPos, yPos);
            }
            viewController.draw(fruits[i]);
            fruits[i].addPlayerToCollisionDetection(player01);
            fruits[i].addPlayerToCollisionDetection(player02);
        }
        System.out.println("finished creating fruits");


    }

    /**
     * Aufruf mit jeder Frame
     * @param dt Zeit seit letzter Frame
     */
    public void updateProgram(double dt){
        //TODO 08 Nachdem Sie die TODOs 01-07 erledigt haben: Setzen Sie um, dass im Falle einer Kollision (siehe TODO 06 bzw. 07) zwischen dem Spieler und dem Apfel bzw. dem Spieler und der Birne, die jumpBack()-Methode von dem Apfel bzw. der Birne aufgerufen wird.
        //Weitere TODOs folgen und werden im Unterricht formuliert. Spätestens nach TODO 08 sollte der Aufbau des Projekts durchdacht werden.
        /*
        if(checkAndHandleCollision(apple01)){

            apple01.jumpBack();

        }
        public boolean checkAndHandleCollision(GraphicalObject g0){
        return g0.collidesWith(player01);
        //die funktion hier oben ist schon entweder true oder false, deshalb ist es irrelevant ein if statement daraus zu machen.
    }
        */
    }

    //TODO 06 Fügen Sie eine Methode checkAndHandleCollision(Apple a) hinzu. Diese gibt true zurück, falls das Apple-Objekt mit dem Player-Objekt kollidiert. Nutzen Sie hierzu die collidesWith-Methode der Klasse GraphicalObject.

    //TODO 07 Fügen Sie eine Methode checkAndHandleCollision(Pear p) hinzu. Diese gibt true zurück, falls das Pear-Objekt mit dem Player-Objekt kollidiert. Nutzen Sie hierzu die collidesWith-Methode der Klasse GraphicalObject.
}
