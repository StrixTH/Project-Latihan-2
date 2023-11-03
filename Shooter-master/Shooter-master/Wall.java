import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wall extends Actor{
    //fields
    public int height;
    public int width;
    public static final int UP = -90;
    public static final int DOWN = 90;
    public static final int LEFT = 180;
    public static final int RIGHT = 0;  
    
    //constructor
    public Wall(int width, int height){
        this.height = height;
        this.width = width;
        //TODO: visual image
        
        
        
        //create an empty transparent image with same dimensions as this wall
        GreenfootImage wallImage = new GreenfootImage(width, height);
        
        //change the image background to black
        wallImage.setColor(Color.BLACK);
        wallImage.fill();
        
        //call setImage()
        setImage(wallImage);
        
    }
}





