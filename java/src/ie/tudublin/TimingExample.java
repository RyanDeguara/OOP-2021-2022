package ie.tudublin;

import processing.core.PApplet;


public class TimingExample extends PApplet{

    int mode = 0;

    Drawable d = new CircleDrawable(this);

    public void setup()
    {
        
    }

    public void settings()
    {
        size(500,500);
    }

    public void draw()
    {

        background(0);
        int m = millis();
        println(m);
        /*if (frameCount == 120) // wait 1 second to switch mode
        {
            mode = 1;
        }
        if (frameCount == 240) //wait 2 seconds to switch mode - frame based not timing based
        {
            mode = 0;
        }*/

        /*if (m >= 4000)
        {
            mode = 0;
        }
        else if (m >= 2000)
        {
            mode = 1;
        }*/

       

       

        if (m > 4000)
        {
            if (d instanceof RectDrawable)
            {
                d = new CircleDrawable(this);
            }
        }
        else if (m > 2000)
        {
            d = new RectDrawable(this);
        }

        d.render();

        /*
        switch (mode)
        {
            case 0:
            {
                circle(width/2, height/2, 100);

                break;
            }
            case 1:
            {
                rectMode(CENTER);
                rect(width/2, height/2, 100, 100);
                
                break;
            }
            default:
            {
                break;
            }
        }*/
    }
    
}
