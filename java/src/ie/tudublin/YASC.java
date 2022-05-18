package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;

public class YASC extends PApplet {
    boolean[] keys = new boolean[1024];

    
    // Update your forks!
    // Create a branch for today monday9
    // Write drawPlayer
    // Write movePlayer

    Player p;
    ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();

    // Polymorphism!
    // The type is of the base class, but the instance is a subclass

    public void settings() {
        size(500, 500);
    }

    public void setup() {
        p = new Player(this, width / 2, height / 2);

        gameObjects.add(p);
        gameObjects.add(new Health(this));
        gameObjects.add(new Ammo(this));
        
    }

    public void draw() {

        fill(255);
        background(0);
        text("Game Objects: " + gameObjects.size(), 50, 50);
        text("FPS: " + frameRate, 50, 100);
        
        stroke(255);
        for(int i = gameObjects.size() - 1; i >= 0 ; i--)
        {
            GameObject go = gameObjects.get(i);
            go.update();
            go.render();

            //collision code
            // instanceof checks if something implements an interface - boolean operator that returns true if it implements interface
            if (go instanceof PowerUp)
            {
                // check to see if colliding with player
                // can call fields on gameObject
                if (dist(go.x, go.y, p.x, p.y) < go.halfW + p.halfW)
                {
                    // Apply powerup to the player
                    // type of go is gameobject, compiler doesnt know its a powerup, only knows its a gameobject, cant call powerup methods on a gameObject
                    // cast it to PowerUp knowing it will apply PowerUp to the GameObject

                    ((PowerUp) go).applyTo(p);
                    // remove gameObject because PowerUp has been consumed
                    gameObjects.remove(go);
                    // PowerUp is now applied to player whenever it runs into the box thing
                }
            }
        }
    }

    boolean checkKey(int k) {
        if (keys.length >= k) {
            return keys[k] || keys[Character.toUpperCase(k)];
        }
        return false;
    }

    public void mousePressed() {
    }

    public void keyPressed() {
        keys[keyCode] = true;
    }

    public void keyReleased() {
        keys[keyCode] = false;
    }
}