/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventure;

import java.awt.Color;
import java.util.Random;
import javalib.colors.Black;
import javalib.colors.IColor;

public class MeteorRM implements Comparable<MeteorRM>, Collideable<MeteorRM>, Tickable<MeteorRM> {
    String color;
    int height = MAXH;
    int deltaHeight = -1;
    int width;
    int identity;
    int leavingHeight = 200;
    static int planeIntervals = 10;
    static int MAXH = 750;
    static int MAXW = 450;
    static int count = 0;
    
    // ========== CONSTRUCTORS ==========
// Starting off-screen width, but at the right height position
    MeteorRM() {
        this(MAXH, -500, count, "none");
        count++;
    }
    
    MeteorRM(int width, int height, int count, String color) {
         this.height = height;
        // Using Sentinal w = -500
        if (width == -500) {
            Random random = new Random();
            // This makes sure that they are in one of the plane intervals so that it can be hit
            this.width = planeIntervals * (Math.abs(random.nextInt()) + 1) % (400 / planeIntervals);
        } else 
            this.width = width;
        
        // Set the color
        if (color.equals("none")) {
            Random random = new Random();
            int colorChoice = Math.abs(random.nextInt()) % 2;
            if (colorChoice == 0) {
                this.color = "red";
            } else {
                this.color = "blue";
            }
        } else 
            this.color = color;
        
        this.identity = count;
    }
    
    public int getWidth() {
        return this.width;
    }
    
    public int getHeight() {
        return this.height;
    }
    
    
    // ========== REACT ==========
    public MeteorRM react(String se) {
        return this;
    }
    
    
    
    // ========== TICK ==========
    public MeteorRM onTick() {
        // Make it go up 1;
         return new MeteorRM( this.width, this.height - 1, this.identity, this.color);
    }
   
    
    
    // ========== EQUALITY ==========
    public boolean isEqualToDWHC(MeteorRM otherMeteor) {
        return (this.width == otherMeteor.width) && 
                (this.height == otherMeteor.height) && 
                (this.deltaHeight == otherMeteor.deltaHeight) &&
                (this.color.equals(otherMeteor.color));
    }
    
    public boolean isEqualToId(MeteorRM otherMeteor) {
        return this.identity == otherMeteor.identity;
    }
   
    
    
    // ========== COMPARETO ==========
    public int compareTo(MeteorRM otherMeteor) {
        if (this.isEqualToId(otherMeteor)) {
            return 0;
        } else if (this.identity < otherMeteor.identity) {
            return 1;
        } else {
            return -1;
        }
    }
    
    // ========== COLLISIONS ========== 
    public MeteorRM collidesWith(Collideable thing) {
        if (this.height == thing.getHeight()) {
            return this;
        } else {
            // I HATE NULL;
            return null;
        }     
    }
    


    
    
    
    
   
    
}
