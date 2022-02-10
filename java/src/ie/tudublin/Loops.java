
package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet {

    public void settings() {
        size(500, 500);
        cx = width / 2;
        cy = height / 2;        
    }

    int mode = 0;

    float cx;
    float cy;

    public void keyPressed() {
        // the value of mode will be the number of the 
        // number key pressed
        if (keyCode >= '0' && keyCode <= '9')
            mode = keyCode - '0';
    }

    public void setup() {
        colorMode(HSB);
    }

    float offset = 0;

    /*float magicMap(float a, float b, float c, float d, float e) magicMap (150, 100, 200, 2000, 4000) // 150 -> inbetween 100, 200 is equivalent to 3,000 for 2000,4000
    {
        float r1 = c - b;
        float r2 = e - d;
        float howFar = a - b;

        return d + ((howFar / r1) * r2);
    } already in processing */

    public void draw() {
        background(0);
        noStroke();
        switch (mode)
        {
			case 0:
			{
                float h = 700;                   
				if (mouseX < cx)
                {
                    rect(0, 0, cx, h);
                }
                else if (mouseX > cx)
                {
                    rect(cx, 0, cx, h);
                }
                break;
				
			}
			case 1:
			{
				fill(50, 255, 255);                                    
                if (mouseX < cx && mouseY < cy)
                {
                    rect(0, 0, cx, cy);
                }
                else if (mouseX > cx && mouseY < cy)
                {
                    rect(cx, 0, cx, cy);
                }
                else if (mouseX < cx && mouseY > cy)
                {
                    rect(0, cy, cx, cy);
                }
                else
                {
                    rect(cx, cy, cx, cy);
                }
                break;
			}
            case 2:
            {
                float w = 200;
                float h = 50;
                rectMode(CENTER);                    
                if (mouseX > cx -  (w /2) && mouseX < cx + (w/2) && mouseY > cy - (h/2) && mouseY < cy + (h/2)) // if x co-ordinate is greater than x co-ordinate of rectangle - 1/2 of its width (left half of the rectangle on its x axis) AND if x co-ordinate is less than x co-ordinate of rectangle + 1/2 of its width (right half of rectangle on x axis) AND if y co-ordinate is greater than y co-ordinate of the rectangle - 1/2 of its height (bottom half of rectangle on y axis) AND if y co-ordinate is less than y co-ordinate of rectangle + 1/2 of its height (top half of rectangle on y axis)
                {
                    fill(50, 255, 255);                
                }
                else
                {
                    fill(200, 255, 255);
                }
                rect(cx, cy, w, h);
                break;
            }      
			case 3:
			{
                /* without map
                int numRects = (int)(mouseX / 10); // amount of rectangle bars on the screen
                float w = width / (float) numRects;
                float cgap = 255 / (float) numRects; // colour gap in the 255 space
                for(int i = 0 ; i < numRects ; i ++)
                {
                    fill(mai * cgap, 255, 255); // filling the rectangles with colours 
                    rect(i * w, 0, w, height);
                }

                */
                // with map
                int numRects = (int)(mouseX / 10); // amount of rectangle bars on the screen
                float w = width / (float) numRects;
                for(int i = 0 ; i < numRects ; i ++)
                {
                    fill(map(i, 0, numRects, 0, 255), 255, 255); // filling the rectangles with colours 
                    rect(map(i, 0, numRects, 0, 500), 0, w, height);
                }
                
                break;
                
            }
			case 4:
            {
                rectMode(CORNER);
                int numRects = (int) mouseX / 10;
                float w = width / (float) numRects;
                float cgap = 255 / (float) numRects;
                for(int i = 0 ; i < numRects ; i ++)
                {
                    fill(cgap * i, 255, 255);
                    rect(i * w, i * w, w, w);
                }
                break;
            }
			case 5:
            {
                rectMode(CORNER);
                int numRects = (int) mouseX / 10;
                float w = width / (float) numRects;
                float cgap = 255 / (float) numRects;
                for(int i = 0 ; i < numRects ; i ++)
                {
                    fill(cgap * i, 255, 255);
                    rect(i * w, i * w, w, w);
                    rect(width - ((i + 1) * w), i * w, w, w);
                }
                break;
            }
			case 6:
            {
                int numCircles = (int) mouseX / 10;
                float cgap = 255 / (float) numCircles;
                float gap = width / (float) numCircles;
                float w = width;
                for(int i = numCircles ; i >= 1 ; i --)
                {
                    fill(i * cgap, 255, 255);
                    w = i * gap;
                    ellipse(cx, cy, w, w);
                    
                }     
				break;           
            }
			case 7:
            {
                offset += (mouseX / 100);
                int numCircles = 20;
                float w = width / (float)numCircles;
                float cgap = 255 / (numCircles + numCircles);
                for(int i = 0 ; i < numCircles ; i ++)
                {
                    for(int j = 0 ; j < numCircles ; j ++)
                    {
                        float c = ((cgap * (i + j)) + offset) % 255; 
                        fill(c, 255, 255);
                        ellipse((w / 2) + w * j, (w / 2) + w * i, w, w);
                    }
                }
                break;
            }
			case 8:
            {
                offset += (mouseX / 100);
                int numCircles = 20;
                float w = width / (float)numCircles;
                float cgap = 255 / (numCircles);
                for(int i = 0 ; i < numCircles ; i ++)
                {
					float c = ((cgap * (i)) + offset) % 255; 
					fill(c, 255, 255);
					ellipse((w / 2) + w * i, (w / 2) + w, w, w);
                }
                break;
            }
			case 9:
            {
                int sides = (mouseX / 50);
                float theta = TWO_PI / (float) sides;
                float radius = 200;
                stroke(255);
                for(int i = 1 ; i <= sides ; i ++)
                {
                    float x1 = sin(theta * (i - 1)) * radius;
                    float y1 = cos(theta * (i - 1)) * radius;
                    float x2 = sin(theta * i) * radius;
                    float y2 = cos(theta * i) * radius;
                    line(cx + x1, cy + y1, cx + x2, cy + y2);
                }
            }
		}
		
    }
}