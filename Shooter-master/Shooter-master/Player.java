    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
    import java.util.*;
    /**
     * Write a description of class Player1 here.
     * 
     * @author (your name) 
     * @version (a version number or a date)
     */
    public class Player extends Actor
    {
        //Fields
        public static final int UP = 270;
        public static final int UP_LEFT = 225;
        public static final int UP_RIGHT = 315;
        public static final int DOWN = 90;
        public static final int LEFT = 180;
        public static final int RIGHT = 0; 
        public static final int DOWN_RIGHT = 45;
        public static final int DOWN_LEFT = 135;
        public static final List<String> WEAPON_TYPES = new ArrayList<>(
                List.of("gun","rocket launcher","machine gun")
        );
        
        public long timeOfPrevBullet = 0;
        public int health = 100;
        public Weapon weapon;
        //public List<Weapon> weaponList;
        
        public Player(String imgFile) {
            weapon = new Weapon("gun"); 
            GreenfootImage image = new GreenfootImage(imgFile);
            image.scale(30, 30);
            setImage(image);
        }
        
        
        /**
         * Act - do whatever the Player1 wants to do. This method is called whenever
         * the 'Act' or 'Run' button gets pressed in the environment.
         */
        public void act(){
            //check for collision with box
            if(isTouching(Box.class)){
                onPickupBox();
            }
        }

        
    /*                if (direction == UP) {
                        //if wall's y is smaller, then return false;
                        if(wall.getY() < getY()){
                            return false;
                        }
                    }
                    else if (direction == DOWN) {
                        if(wall.getY() > getY()){
                            return false;
                        }
                    }
                    else if (direction == LEFT) {
                        if(wall.getX() < getX()){
                            return false;
                        }
                    }
                    else if (direction == RIGHT) {
                        if(wall.getX() > getX()){
                            return false;
                        }
                    }
      */      
    
    
    
    public boolean isTouchingWall(){
        return isTouching(Wall.class);
    }
    public void movePlayer(int direction) //UPLEFT
    {
        setRotation(direction);
        move(1);
        if (isTouching(Wall.class)) {
            move(-1);
        }
    }
    
    public void shoot()
    {
        //TODO: play sound based on weapon type
        
        if (getCurrentTime() - timeOfPrevBullet > weapon.rateOfFire) {
            int direction = getRotation();
            //create a projectile
            Projectile projectile = getNewProjectile(direction);

            //add projectile to projectileList
            Game gameWorld = (Game)getWorld();
            gameWorld.projectileList.add(projectile);
            
            //add projectile to the world
            if(direction == RIGHT){
                gameWorld.addObject(projectile, (getX()+25), (getY()+12));
            } else if (direction == LEFT){
                gameWorld.addObject(projectile, (getX()-25), (getY()-12));
            } else if (direction == UP){
                gameWorld.addObject(projectile, (getX()+12), (getY()-25));
            } else if (direction == DOWN) {
                gameWorld.addObject(projectile, (getX()-12), (getY()+25));
            } else if (direction == UP_LEFT) {
                gameWorld.addObject(projectile, (getX()-12), (getY()-25));
            } else if (direction == UP_RIGHT){
                gameWorld.addObject(projectile, (getX()+26), (getY()-22));
            } else if (direction == DOWN_LEFT){
                gameWorld.addObject(projectile, (getX()-30), (getY()+12));
            } else if (direction == DOWN_RIGHT){
                gameWorld.addObject(projectile, (getX()+12), (getY()+25));
            } 
           
            //set the time of the last bullet fired (seconds)
            timeOfPrevBullet = getCurrentTime();
            weapon.playSound();
            
            //remove 1 bullet from clip
            weapon.currentClipSize -= 1;
            
            //reload if clip is empty
            if(weapon.currentClipSize == 0){
                //play reload sound
                
                
                //reload the clip
                weapon.currentClipSize = weapon.clipSize;
                
                //set timeOfPrevBullet so that there is a big delay
                
                timeOfPrevBullet = getCurrentTime() + weapon.reloadTime;
                
            }
            
        }
    }
    public Projectile getNewProjectile(int direction){
        if (weapon.name.equals("gun")){
            return new PistolBullet(direction);
        }
        else if (weapon.name.equals("machine gun")){
            return new MachineGunBullet(direction);
        }
        else { //if (weapon.name.equals("rocket launcher")) {
            return new Rocket(direction);
        }
    }
    public long getCurrentTime() {
        return System.currentTimeMillis();
    }
    public void onPickupBox() {
        Game world = (Game)getWorld();
        world.removeObject(world.box);
        world.box = null;
        world.frameOfBoxPickUp = world.currentFrame;
        int weaponIndex = Greenfoot.getRandomNumber(WEAPON_TYPES.size()-1) + 1;
        String newWeapon = WEAPON_TYPES.get(weaponIndex);
        weapon = new Weapon(newWeapon);
    }
}
