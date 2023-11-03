    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
    
    /**
     * Write a description of class Box here.
     * 
     * @author (your name) 
     * @version (a version number or a date)
     */
    public class Box extends Actor
    {
        
    public Box() {
        GreenfootImage image = new GreenfootImage("Crate.png");
        image.scale(25, 25);
        setImage(image);
    }
    
    public boolean isLocationValid() {
        return !isTouching(Wall.class) && !isTouching(Player.class);
    }
    
    public void act() 
    {

    }    
}
