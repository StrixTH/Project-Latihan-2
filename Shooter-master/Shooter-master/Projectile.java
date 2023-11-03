import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projectile extends Actor
{
    //Fields
    int speed;
    double damage; //bullet = 10, rocket = 30

    public static final int UP = 270;
    public static final int UP_LEFT = 225;
    public static final int UP_RIGHT = 315;
    public static final int DOWN = 90;
    public static final int LEFT = 180;
    public static final int RIGHT = 0;
    public static final int DOWN_RIGHT = 45;
    public static final int DOWN_LEFT = 135;
    
    public Projectile(int speed, int direction, double damage) {
        this.damage = damage;
        this.speed = speed;
        setRotation(direction);
    }
    
    
    
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // move the bullet
        move(speed);
        
        //wall collision
        if(isTouching(Wall.class)) {
            remove();
            
        }
        
        //player collision
        else if(isTouching(Player.class)) {
            //remove health
            //get the player object of the player who was hit
            GreenfootSound hitSound = new GreenfootSound("playerHit.wav");
            hitSound.play();
            Game gameWorld = (Game)getWorld();
            if (intersects(gameWorld.p1)) {
                gameWorld.p1.health -= damage;
                
                if(gameWorld.p1.health < 1){
                    Greenfoot.setWorld(new Game());
                }
            }
            else if (intersects(gameWorld.p2)) {
                gameWorld.p2.health -= damage;
                
                if(gameWorld.p2.health < 1){
                    Greenfoot.setWorld(new Game());
                }
            }
            remove();
        }
        
        //edge of screen
        else if(this.isAtEdge()){
            remove();
        }
    }
    
    public void remove() {
        //remove the object from the game board
        Game world = (Game)getWorld();
        world.removeObject(this);
        
        //remove the bullet from the bulletList
        world.projectileList.remove(this);
    }
}
