/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventure;

import javalib.colors.Blue;
import javalib.funworld.World;
import javalib.worldimages.OverlayImages;
import javalib.worldimages.Posn;
import javalib.worldimages.RectangleImage;
import javalib.worldimages.WorldImage;

/**
 *
 * @author kathrynhodge
 */
public class HyperMeteorShower extends World {
    Lives lives;
    PlaneHM plane;
    Meteor meteors;
    Boolean gameOver;
    Score score;

    
    public HyperMeteorShower() {
        super();
        this.plane = new PlaneHM();
        this.meteors = new Meteor();
        this.lives = new Lives();
        this.score = new Score();
        this.gameOver = false;
    }
    
    public HyperMeteorShower(PlaneHM plane, Meteor meteors, Lives lives, Score score, boolean gameOver){
        super();
        this.plane = new PlaneHM();
        this.meteors = new Meteor();
        this.lives = new Lives();
        this.score = new Score();
        this.gameOver = false;
    }
  
    
    // REQUIRED METHODS BY GAMEWORLDS
    
    // To run the world game:
    public boolean bigBang() {
        return this.bigBang(500, 500, 1);
    }
    
    
    // This method produces a new instance of the world as it should be after one tick of the clock has passed.
    public World onTick() {
        return this;
    }
    
    // This method produces the world in response to the user pressing a key on the keyboard. 
    public World onKeyEvent(String ke) {
        PlaneHM newPlane = plane.react(ke);
        return new HyperMeteorShower(newPlane, this.meteors, this.lives, this.score, this.gameOver);
    }
    
    // Draws the image on screen
     public WorldImage makeImage() {
//         WorldImage background = new OverlayImages(new RectangleImage(new Posn(0,0),this.width,this.height, new Blue()))
         return new OverlayImages(new RectangleImage(new Posn(0,0),2000,2000, new Blue()), this.plane.planeImage());
    }
    
    // This method responds to a mouse click anywhere on the game’s canvas. 
    public World onMouseClicked(Posn p) {
     return this;   
    }
    
    
    // This method produces an instance of a class WorldEnd that consists of a boolean value 
    // indicating whether the world is ending (false if the world goes on) and the WorldImage 
    // that represents the last image to be displayed - for example announcing the winner of the game, 
    // or the final score.
//    public WorldEnd worldEnds() {
//        
//    }

}
