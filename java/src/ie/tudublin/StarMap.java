package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class StarMap extends PApplet {

    ArrayList<Star> stars = new ArrayList<Star>(); // angle brackets - passing a type as a parameter - generic, this array list is for holding stars (star type)
    public float border;
    
    void drawGrid()
    {
        
        stroke(255, 0, 255);
        textAlign(CENTER, CENTER);
        textSize(20);
        for (int i = -5; i<=5; i++)
        {
            float x = map(i, -5, 5, border, width - border);
            line(x, border, x, height - border);
            line(border, x, width-border, x);
            fill(255);
            text(i, x, border*0.5f);
            text(i, border * 0.5f, x);
        }

    }

    void printStars()
    {
        for(Star s:stars)
        {
            s.render(this);
        }
        
    }

    void loadStars()
    {
        Table table = loadTable("HabHYG15ly.csv", "header"); 
        for(TableRow r:table.rows()) // enhanced for loop (foreach) way of iterating over collections
        {
            Star s = new Star(r);
            stars.add(s);
        }
    }

    public void settings() {
        size(800, 800);
    }


    public void mouseClicked()
    {
        
    }

    public void setup() {
        colorMode(RGB);
        loadStars();
        printStars();
        
        border = width * 0.1f;
    }

    public void drawStars()
    {
        for (Star s:stars)
        {
            stroke(0);
            circle(s.getxG(), s.getyG(), 5);
        }
    }

    public void draw() 
    {
        drawGrid();
        drawStars();
    }
}