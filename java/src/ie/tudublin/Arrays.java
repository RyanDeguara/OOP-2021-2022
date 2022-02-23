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
            if (rainfall[i] < rainfall[maxIndex])
            {
                minIndex = i;
            }

            total = total + rainfall[i];


        }

        println("Max rainfall: " + rainfall[maxIndex] + " in month " + months[maxIndex]);
        println("Min rainfall: " + rainfall[minIndex] + " in month " + months[minIndex]);
        println("Total rainfall: " + total);
        println("Average rainfall: " + total/rainfall.length);
    }

    public void draw()
    {
        background(0);
        colorMode(HSB);
        float w = width / (float) rainfall.length; //(float) rainfall.length to get rid of gap at the end
        noStroke();
        for (int i = 0; i < rainfall.length; i++)
        {
            float x = map(i, 0, rainfall.length, 0, width); //i * w;
            
            // Colour each bar different:
            int c = (int) map(i, 0, rainfall.length, 0, 255);
            fill (c, 255, 255);

            // put bars to the top of the screen
            float h = map(rainfall[i], 0, rainfall[maxIndex], 0, -height);
            rect(x,height,w,h);
            fill(255);
            textAlign(CENTER, CENTER);
            text(months[i], x + (w/2), height - 50);
            //rect(x, height, w, -rainfall[i]); //-rainfall drawing upwards instead of downwards
        }
    }
}