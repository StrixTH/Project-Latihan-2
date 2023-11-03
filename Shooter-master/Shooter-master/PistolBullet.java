import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PistolBullet extends Projectile
{
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public PistolBullet(int direction) {
        super(4, direction, 10);
        
        GreenfootImage BulletImage = new GreenfootImage(5, 5);
        BulletImage.setColor(Color.RED);
        BulletImage.fill();
        setImage(BulletImage);
    }
   
}
