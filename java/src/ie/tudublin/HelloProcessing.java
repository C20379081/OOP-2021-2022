package ie.tudublin;

import processing.core.PApplet;

public class HelloProcessing extends PApplet
{

	public void settings()
	{
		// If you want to use the width and 
		// height variables, they have to be after settings 
		// is called
		size(500, 500);
	}

	
	public void setup() {
		
	}
	
	public void draw()
	{	
		background(255,0,0);         
		circle(255,300,400);
		fill(0, 255, 255); 
		triangle(50, 450, 255, 10, 450, 450);
		fill(230);
		ellipse(255,255,200,100);
		fill(0);
		circle(255,255,50);
		fill(255,255,0);
		stroke(255);

	}
}