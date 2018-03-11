import processing.core.PApplet;
import processing.core.PImage;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainApp extends PApplet{

    public static void main(String[] args){
        PApplet.main("MainApp", args);
    }

    public void settings(){
        size(500, 500);
    }

    //Subclasses definitions
    Menu Menu;
    HistoryStage HistoryStage;
    Game Game;

    //Stage mode variables
    public int stage = 0;
    private final int MAIN_MENU = 0;
    private final int HISTORY_MENU = 1;
    private final int PLAY_GAME = 2;
    private final int PAUSE = 3;

    public void setup() {
        frameRate(60);
        stroke(255);
        fill(255);
        PImage img;
        img = loadImage("images/stars.png");
        background(img);

    //Subclass instances
        Menu = new Menu(this);
        HistoryStage = new HistoryStage(this);
        Game = new Game(this);
    }

    public void draw()
    {
    //Stage Mode controller
        switch(stage) {
            case MAIN_MENU:
                Menu.draw();
                break;
            case HISTORY_MENU:
                HistoryStage.scoreHistory = Game.scoreHistory;
                HistoryStage.draw();
                break;
            case PLAY_GAME:
                Game.draw();
                break;
//            case PAUSE:
//                //Pause Stuff
//                break;
        }
    }

    public void mousePressed() {
        if (mouseButton == LEFT) {
            Game.gameMousePressed();
            if (Menu.rect2Over== true){
                System.out.println("history button");
                stage = HISTORY_MENU;
            } else if (Menu.rectOver== true){
                stage = PLAY_GAME;
            }
        } else if (mouseButton == RIGHT) {
            stage = MAIN_MENU;
        }
    }

    //Get & Set Methods
    public int getStage(){
        return stage;
    }

    public void setStage(int stage){
        this.stage = stage;
    }

}


