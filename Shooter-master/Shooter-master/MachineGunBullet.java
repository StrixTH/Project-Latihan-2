import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rocket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MachineGunBullet extends Projectile
{
    /**
     * Act - do whatever the Rocket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public MachineGunBullet(int direction) {
        super(8, direction, 2);

        GreenfootImage BulletImage = new GreenfootImage(3, 3);
        BulletImage.setColor(Color.MAGENTA);
        BulletImage.fill();
        setImage(BulletImage);
        
    }
 
}
