
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Game here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Game extends World
{
    //FIELDS
    public int currentFrame;
    public int frameOfBoxPickUp;
    public Player p1;
    public Player p2;
    public List<Wall> wallList = new ArrayList<>();
    public Box box;
    public List<Projectile> projectileList = new ArrayList<>();
    
        public static final int UP = 270;
        public static final int UP_LEFT = 225;
        public static final int UP_RIGHT = 315;
        public static final int DOWN = 90;
        public static final int LEFT = 180;
        public static final int RIGHT = 0;
        public static final int DOWN_RIGHT = 45;
        public static final int DOWN_LEFT = 135;

    /**
     * Constructor for objects of class Game.
     * 
     */
    public Game()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        prepare();
       
        
    }
    
    /*public Game(String imageFile, String Left, String Right, String Down, String Up) {
    Up = p1("W"),p2("up");
    Down = p1("S"),p2("down");
    Left = p1("A"),p2("left");
    Right = p1("D"),p2("right");

    }*/
        public void prepare() {
        p1 = new Player("soldier1.gif");
        p2 = new Player("soldier2.gif");
        addObject(p1, 25,16);
        addObject(p2, 556, 363);
        createLevel1();
//           createLevel2();
       
        
    }
    
    public void createLevel1() {
        //set up all the wall for this game
        Wall currentWall = new Wall(10,200);
        wallList.add(currentWall);
        addObject(currentWall, 100, 193);
        
        currentWall = new Wall(10,200);
        wallList.add(currentWall);
        addObject(currentWall, 414,208);
        
        currentWall = new Wall(400, 10);
        wallList.add(currentWall);
        addObject(currentWall, 272,336);
    }

    public void playerMovement() {
        
        if (Greenfoot.isKeyDown("w")) {
            if (Greenfoot.isKeyDown("a")) { //up-left
                p1.movePlayer(UP_LEFT);
            } else if (Greenfoot.isKeyDown("d")) { //up-right
                p1.movePlayer(UP_RIGHT);
            } else { //up
                p1.movePlayer(UP);
            }
        }
        else if (Greenfoot.isKeyDown("s")) {
            if (Greenfoot.isKeyDown("a")) { 
                p1.movePlayer(DOWN_LEFT);
            } else if (Greenfoot.isKeyDown("d")) { 
                p1.movePlayer(DOWN_RIGHT);
            } else { 
                p1.movePlayer(DOWN);
            }
        }
        else if (Greenfoot.isKeyDown("a")) {
            p1.movePlayer(LEFT);
        }
        else if (Greenfoot.isKeyDown("d")) {
            p1.movePlayer(RIGHT);
        }
        
        if (Greenfoot.isKeyDown("up")) {
           if (Greenfoot.isKeyDown("left")) { 
                p2.movePlayer(UP_LEFT);
            } else if (Greenfoot.isKeyDown("right")) { 
                p2.movePlayer(UP_RIGHT);
            } else { 
                p2.movePlayer(UP);
            }
        }
        else if (Greenfoot.isKeyDown("down")) {
            if (Greenfoot.isKeyDown("left")) { 
                p2.movePlayer(DOWN_LEFT);
            } else if (Greenfoot.isKeyDown("right")) { 
                p2.movePlayer(DOWN_RIGHT);
            } else { 
                p2.movePlayer(DOWN);
            }
        }
        else if (Greenfoot.isKeyDown("left")) {
            p2.movePlayer(LEFT);
        }
        else if (Greenfoot.isKeyDown("right")) {
            p2.movePlayer(RIGHT);
        }
    }
    
    public void act() {
        currentFrame++;
                
        //movement
        playerMovement();
        
        //shooting
        playerShooting();
                
        //random weapon box
        createRandomWeaponBox();
        
        
    }
    
    public void playerShooting(){
        if(Greenfoot.isKeyDown("space")) {
            p1.shoot();
        }
        if(Greenfoot.isKeyDown(",")){
            p2.shoot();
        }
    }
    public void createRandomWeaponBox() {
        if (box == null) {
            if (doBuildBox()) {
                box = new Box();
                addBoxToWorld();
                //create a box actor that isn't touching a wall or player
                while (!box.isLocationValid()) {
                    addBoxToWorld();
                }
            }
        }
    }
    
    public boolean doBuildBox() {
        int waitingFrames = 1000;
        //currentFrame =5000
        //frameOfBoxPickUp=4000
        return frameOfBoxPickUp + waitingFrames < currentFrame;
    }
    
    public void addBoxToWorld(){
     addObject(box,getRandomXLocation(),getRandomYLocation());    
    }
    
    public int getRandomXLocation() {
        int range = getWidth() - 20;
        return Greenfoot.getRandomNumber(range) + 10; 
    }
    
    public int getRandomYLocation() {
        int range = getHeight() - 20;
        return Greenfoot.getRandomNumber(range) + 10; 
    }
    
}

