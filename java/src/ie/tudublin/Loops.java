package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet {

    int mode = 0;

    public void settings() {
        size(500, 500);
    }

    public void setup() {
        colorMode(HSB);

    }

    public void keyPressed() {
        if (key >= '0' && key <= '9') {
            mode = key - '0';
        }
        println(mode);
    }

    float magicMap(float a, float b, float c, float d, float e) {
        float output;
        a -= b;
        c -= b;
        e -= d;

        output = ((a / c) * e) + d;

        return output;
    }

    float magicMap1(float a, float b, float c, float d, float e) {
        float r1 = c - b;
        float r2 = e - d;
        float howFar = a - b;

        return d + ((howFar / r1) * r2);
    }

    float offset = 0;

    public void draw() {

        switch (mode) {
            case 0: {
                background(0);
                int bars = (int) (mouseX / 20.0f);
                float w = width / (float) bars;
                for (int i = 0; i < bars; i++) {
                    noStroke();
                    fill(map(i, 0, bars, 0, 255), 255, 255);
                    rect(map(i, 0, bars, 0, 500), 0, w, height);
                }
                break;
            }
            case 1: {
                background(0);
                // map(a,b,c,d,e);
                // a = inputvalue
                // b - c - start and end of the first range
                // d, e 0 - start and and of the end range

                // map(-2, 10, 90, 200, 233);
                int squares = (int) (mouseX / 20.0f); // amount of rectangle bars on the screen
                float h = width / (float) squares;
                for (int i = 0; i < squares; i++) {
                    noStroke();
                    fill(map(i, 0, squares, 0, 255), 255, 255); // filling the rectangles with colours
                    float x = map(i, 0, squares, 0, width);
                    rect(x, x, h, h);
                    rect((width - h) - x, x, h, h);
                }
                break;
            }
            case 2: {
                background(0);
                /*int circles = (int) (mouseX / 20.0f);
                float w = width / (float) circles;
                for (int i = 0; i < circles; i++) {
                    for (int j = 0; j < circles; j++) {
                            
                        fill(map(i, 0, circles, 0, 255), 255, 255);
                        circle(map(i,0,circles - 1, w /2.0f, width - (w/2.0f)), height/2, w);
                    }
                }   
                */

                background(0);
                int circles = (int) (mouseX / 20.0f);
                offset += mouseY/100.0f;

                float w = width / (float) circles;
                for (int i = 0; i < circles; i++) {
                    for (int j = 0; j < circles; j++) {
                        
                        noStroke();
                        float c = map((i+j+offset), 0, circles * 2, 0, 255) % offset;
                        fill(c, 255, 255);
                        float x = map(i, 0, circles - 1, w/2.0f, width - (w/2.0f));
                        float y = map(j, 0, circles - 1, w/2.0f, width - (w/2.0f));
                        circle(x, y ,w);
                    }
                }   

                break;
            }
            case 3:
            {
                background(0);
                /* //MY SOLUTION:
                
                rectMode(CENTER);
                int numSquares = 11;
                float w = (width / (float) numSquares);
                for(int i = 1 ; i < numSquares ; i ++)
                {
                    fill(100, 255 ,100);
                    text(i-6, 5, (w*i)-13);
                    for(int j = 1 ; j < numSquares ; j ++)
                    {
                        fill(0);
                        stroke(100, 255 ,100);
                        square(w*i, w*j, w);
                    }
                    fill(100, 255 ,100);
                    text(i-6, (w*i)-25, 15);   
                }
                */

                //Bryan solution:
                colorMode(RGB);
                float border = width * 0.1f;
                for (int i = -5; i<= 5; i++)
                {
                    float x = map(i, -5, 5, border, width - border);
                    stroke(0, 255, 0);
                    line(x, border, x, height - border);
                    line(border, x, width - border, x);
                    fill(255);
                    text(i, x, border * 0.5f);
                    text(i, border * 0.5f, x);
                }
                

                break; 
            }
            case 4:
            {
                background(0);
                colorMode(RGB);
                int sides = (int) map(mouseX, 1, width, 2, 20); // minimum of 2
                float cx = width/2; // place in center of the screen
                float cy = height/2;// basically putting the origin in the dead center of the screen
                float radius = 200;
                stroke(255);

                for(int i = 1 ; i <= sides ; i ++)
                {
                    float theta1 = map(i-1, 0, sides, 0, TWO_PI); // Q
                    float x1 = cx + sin(theta1) * radius;
                    float y1 = cy + cos(theta1) * radius;

                    float theta2 = map(i, 0, sides, 0, TWO_PI); // Q
                    float x2 = cx + sin(theta2) * radius;
                    float y2 = cy + cos(theta2) * radius;

                    line(x1, y1, x2, y2);
                }
                

                break;
            }
        }
    }
}
