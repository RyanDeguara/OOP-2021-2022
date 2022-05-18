package ie.tudublin;

import java.util.ArrayList;

import javax.swing.plaf.SliderUI;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class StarMap extends PApplet {

    // create array list of stars
    ArrayList<Star> stars = new ArrayList<Star>();
    
    public float border;

    //draw the boxes with numbers
    void drawGrid()
    {
        stroke(255, 0, 255);
        textAlign(CENTER, CENTER);
        textSize(20);
        for(int i = -5; i <=5; i ++)
        {
            float x = map(i, -5, 5, border, width - border);
            line(x, border, x, height - border);
            line(border, x, width - border, x);
            fill(255);
            text(i, x, border * 0.5f);
            text(i, border * 0.5f, x);
        }
    }

    // prints contents of stars array list
    void printStars()
    {
        for(Star s:stars)
        {
            System.out.println(s);
        }
    }

    // load contents from the csv file into array list using Star class
    void loadStars()
    {
        Table table = loadTable("HabHYG15ly.csv", "header");
        for(TableRow r:table.rows())
        {
            Star s = new Star(r);
            stars.add(s);
        }
    }

    // size of screen
    public void settings() {
        size(800, 800);
    }

    // code to assign first or second variable clicked for use in the draw method
    Star first = null;
    Star second = null;
    public void mouseClicked()
    {

        for(Star s:stars)
        {
            float x = map(s.getxG(), -5, 5, border, width - border);
            float y = map(s.getyG(), -5, 5, border, height - border);

            if (dist(mouseX, mouseY, x, y) < 20)
            {
                if (first == null)
                {
                    first = s;
                    break;
                }
                else if (second == null)
                {
                    second = s;
                    break;
                } 
                else
                {
                    first = s;
                    second = null;
                    break;
                }
            }
        }
        
    }

    // set colour mode, call functions and set border width
    public void setup() {
        colorMode(RGB);
        loadStars();
        printStars();

        border = width * 0.1f;
    }

    // render the stars from the star class
    public void drawStars()
    {
        for(Star s:stars)
        {
            s.render(this);
        }
    }

    // draw the grid, stars and if statements to draw line from one star to the other by using the variables assigned from the mouseClicked() class
    public void draw() 
    {
        background(0);
        drawGrid();
        drawStars();
        
        if (first != null)
        {
            float x = map(first.getxG(), -5, 5, border, width - border);
            float y = map(first.getyG(), -5, 5, border, height - border);

            if (second != null)
            {
                float x2 = map(second.getxG(), -5, 5, border, width - border);
                float y2 = map(second.getyG(), -5, 5, border, height - border);
                stroke(255, 255, 0);
                line(x, y, x2, y2);

                float dist = dist(first.getxG(), first.getyG(), first.getzG(), second.getxG(), second.getyG(), second.getzG());
                fill(255);
                textAlign(CENTER, CENTER);
                text("Distance between: " + first.getDisplayName() + " and " + second.getDisplayName() + " is " + dist + " parasecs", width/2, height - (border * 0.5f));

            }
            else
            {
                stroke(255, 255, 0);
                line(x, y, mouseX, mouseY);
            }
        }
    }
}