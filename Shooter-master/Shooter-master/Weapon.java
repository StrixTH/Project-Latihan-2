import greenfoot.*;
/**
 * Write a description of class Weapon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Weapon  
{
    //FIELDS
    public String name; //"gun" "rocket launcher"
    public int rateOfFire; //smaller = faster
    public int clipSize;
    public int currentClipSize;
    public int reloadTime;
    
    //CONSTRUCTOR
    public Weapon(String weaponType) {
        name = weaponType;
        if (weaponType.equals("gun")) {
            rateOfFire = 200;
            clipSize = 6;
            currentClipSize = 6;
            reloadTime = 1500;
        }
        else if (weaponType.equals("rocket launcher")) {
            rateOfFire = 350;
            clipSize = 3;
            currentClipSize = 3;
            reloadTime=3000;
        }
        else if (weaponType.equals("machine gun")) {
            rateOfFire = 100;
            clipSize = 50;
            currentClipSize = 50;
            reloadTime = 2500;
        }
        
    }
    
    //METHODS
    
    public void playSound(){
        if(name.equals("gun")) {
           GreenfootSound gunshotSound = new GreenfootSound("gunshot.wav");
           gunshotSound.play();
        }
        else if (name.equals("rocket launcher")) {
           //play rocket launcher sound
           GreenfootSound rocketSound = new GreenfootSound("rocket.wav");
           rocketSound.play();
        }
    }
    
    
    
}
