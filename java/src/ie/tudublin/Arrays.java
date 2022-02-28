package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;

public class Arrays extends PApplet
{
    float[] rainfall = { 45, 37, 55, 27, 38, 50, 79, 48, 104, 31, 100, 58 };
    
    String[] months = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};
    int maxIndex = 0;
    int minIndex = 0;
    
    //float[] a1 = new float[100];
    //float[] a2;

    public void settings()
    {
        size (500, 500);
    }

    public void setup()
    {
        for (int i = 0; i < rainfall.length; i++)
        {
            println(rainfall[i] + "\t" + months[i]);
        }

        //enhanced for loop - every element from rainfall gets copied into r, r gets executed
        for (float r:rainfall)
        {
            println(r);
        } // this cant print index

        int j = 0;
        for (float r:rainfall)
        {
            println(r + "\t" + months[j]);
            j++;
        }

        for (int i = rainfall.length - 1; i >= 0; i--)
        {
            println(rainfall[i] + "\t" + months[i]);
        }

        //ArrayList al = new ArrayList<>();

        float total = 0;

        for (int i=0; i < rainfall.length; i++)
        {
            if (rainfall[i] < rainfall[minIndex])
            {
                minIndex = i;
            }
            if (rainfall[i] > rainfall[maxIndex])
            {
                maxIndex = i;
            }

            total = total + rainfall[i];


        }

        println("Max rainfall: " + rainfall[maxIndex] + " in month " + months[maxIndex]);
        println("Min rainfall: " + rainfall[minIndex] + " in month " + months[minIndex]);
        println("Total rainfall: " + total);
        println("Average rainfall: " + total/rainfall.length);
    }

    int mode = 0;

    public void keyPressed() {
        if (key >= '0' && key <= '9') {
            mode = key - '0';
        }
        println(mode);
    }

    public void draw()
    {

        colorMode(HSB);
    
        
        switch(mode) {
            case 0:
            {
                /*background(0);
                float border = width * 0.1f; // border 10% of the width of the screen
                float range = 120;
        
                stroke(255);
                line(border, border, border, height-border);
                line(border, height-border, width-border, height-border);
        
                // y axis
                for (float j = 0; j <= range; j = j + 10)
                {
        
                    float y = map(j, 0, 120, height - border, border);
                    line(border - 5, y, border, y);
                    fill(255);
                    textAlign(CENTER, CENTER);
                    text(j, border/2, y);
                }
                float w = (width - (border*2)) / (float) rainfall.length; //(float) rainfall.length to get rid of gap at the end
                for (int i = 0; i < rainfall.length; i++)
                {
                    float x = map(i, 0, rainfall.length, border, width-border); //i * w;
                    // put bars to the top of the screen
                    float h = map(rainfall[i], 0, range, 0, -height + (border*2)); // height + (border * 2) - two borders one at top and bottom
                    // Colour each bar different:
                    int c = (int) map(i, 0, rainfall.length, 0, 255);
                    fill (c, 255, 255);

                    rect(x, height - border, w, h);
                    
                    fill(255);
                    textAlign(CENTER, CENTER);
                    text(months[i], x + (w/2), height - (border/2));
                    //rect(x, height, w, -rainfall[i]); //-rainfall drawing upwards instead of downwards
                    
                }*/
                
            }
            case 1:
            {
                /*//PIE CHART
                
                background(0);
                float r = width * 0.3f; // radius - fill 60% of the screen
                float cx = width / 2;
                float cy = height / 2;
                stroke(255);
                noFill();
                circle(cx, cy, r * 2.0f); // diameter last value
                float total = 0;
                for (float f:rainfall)
                {
                    total += f;
                }
                float start = 0;
                for (int i = 0; i < rainfall.length; i++)
                {
                    float val = map(rainfall[i], 0, total, 0, TWO_PI);
                    float c = map(i, 0, rainfall.length, 0, 255);
                    noStroke();
                    fill(c, 255, 255);
                    arc(cx, cy, r * 2, r * 2, start, start + val, PIE);
                    
                    float theta = start + (val * 0.5f); // start + half val
                    float x = cx + cos(theta) * (r * 1.2f);
                    float y = cy + sin(theta) * (r * 1.2f); // multiple r by two to make text outside pie chart
                    fill(255);
                    text(months[i], x, y);

                    start = start + val;
                    
                     
                }
                */
                
            }
            case 2:
            {
                // line graph 
                
                background(0);
                float border = width * 0.1f; 
                float range = 120;
        
                stroke(255);
                line(border, border, border, height-border);
                line(border, height-border, width-border, height-border);
                int k = 0;
                // y axis
                for (float j = 0; j <= range; j = j + 10)
                {
        
                    float y = map(j, 0, 120, height - border, border);
                    line(border - 5, y, border, y);
                    fill(255);
                    textAlign(CENTER, CENTER);
                    text(j, border/2, y);
                }
                float w = (width - (border*2)) / (float) rainfall.length;
                for (int i = 1; i < rainfall.length; i++)
                {
                    
                    float x = map(k, 0, rainfall.length, border, width-border);
                    text(months[k], x + (w/2), height - (border/2));
                    k++;

                    float x1 = map(i-1, 0, rainfall.length-1, border + (w/2), width-border-(w/2));
                    float x2 = map(i, 0, rainfall.length-1, border + (w/2), width-border-(w/2));
                    float y1 = map(rainfall[i-1], 0, range, height - border, border);
                    float y2 = map(rainfall[i], 0, range, height - border, border);

                    line(x1, y1, x2, y2);

                    fill(255);

                    
                }
                k = 11;
                float x = map(k, 0, rainfall.length, border, width-border);
                text(months[k], x + (w/2), height - (border/2));

            }
        }
    }
}