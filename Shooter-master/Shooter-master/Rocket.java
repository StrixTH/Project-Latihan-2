import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rocket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rocket extends Projectile
{
    /**
     * Act - do whatever the Rocket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Rocket(int direction) {
        super(3, direction, 30);

        GreenfootImage BulletImage = new GreenfootImage(10, 10);
        BulletImage.setColor(Color.BLUE);
        BulletImage.fill();
        setImage(BulletImage);
        
    }
 
}
