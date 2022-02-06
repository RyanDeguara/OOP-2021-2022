package ie.tudublin;

import processing.core.PApplet;

public class HelloProcessing extends PApplet
{

	public void settings() //methods (functions in C)
	{
		size(500, 500); // size of the window, pApplet superclass sets the size of the drawing window
	}

	public void setup() { 

		//colorMode(HSB);
		colorMode(RGB);
		background(0);
		
	}
	
	public void draw() // called once per frame, framerate processign runs at 60 frames per second, draw method gets called 60 times a second
	{	
		//stroke(255);
		//background(200); // grey background, grey scale, 255 is white, 0 is black using colorMode(HSB);
		background(255, 255, 0); //using colorMode(RGB); red, green, blue, creates yellow 
		line(10, 10, 200, 200); // x1, y1, -> top left of the line x2, y2 -> bottom right of the line
		circle(200, 250, 50); // cx, cy, r
		ellipse(50, 200, 90, 200); // cx, cy, w, h

		stroke(0); //outline
		//fill(0, 0, 255); //RGB
		//noFill();
		noStroke();

		rectMode(CENTER); //makes first two parameters the center of the triangle 

		rect(300, 20, 100, 20); // rectangle - top left x, top left y, w, h

		rectMode(CORNER); // first two parameters means top left x, top left y and width and height
		rect(200, 20, 100, 20); // rectangle - top left x, top left y, w, h

		point(20, 300); //plot single pixel, x, y

		triangle(10, 400, 50, 450, 300, 200); //x1, y1, x2, y2, x3, y3 


		

	}
}
