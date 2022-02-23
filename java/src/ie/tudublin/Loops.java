package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet {

<<<<<<< HEAD
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

    public void draw() {
        background(0);
        noStroke();
        switch (mode)
        {
            case 0:
            {
                float w = 200;
                float h = 50;
                rectMode(CENTER);                    
                if (mouseX > cx -  (w /2) && mouseX < cx + (w/2) && mouseY > cy - (h/2) && mouseY < cy + (h/2))
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
            case 1:
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
            case 2:
            {
                int numRects = (int)(mouseX / 10.0f);
                float w = width / (float) numRects;
                float cgap = 255 / (float) numRects;
                for(int i = 0 ; i < numRects ; i ++)
                {
                    fill(i * cgap, 255, 255);
                    rect(i * w, 0, w, height);
                }
                break;
            }
            case 3:
            {
                int numCircles = (int)(mouseX / 10.0f);
                float w = width / (float) numCircles;
                float cgap = 255 / (float) numCircles;
                for(int i = 0 ; i < numCircles ; i ++)
                {
                    fill(cgap * i, 255, 255);
                    ellipse(w / 2 + (i * w), cy, w, w);
                }
                break;
            }
            case 4:
            {
                int numLines = 5;
                float theta = TWO_PI / (float) numLines;
                float radius = 100;
                for(int i = 0 ; i < numLines ; i ++)
                {
                    float angle = theta * i;
                    float x = sin(angle) * radius;
                    float y = cos(angle) * radius;
                    line(cx, cy, cx + x, cy + y);                    
                }
            }
            break;
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
            break;
            case 9:
            {
                background(0);
                colorMode(RGB);
                float border = width * 0.1f;
                stroke(255);
                for(int i = -5 ; i <= 5 ; i ++)
                {
                    float x = map(i, -5,5 , border, width - border);
                    stroke(0,255,0);
                    line(x,border,x,height-border);
                    line(border,x,width-border,x);
                    fill(255);
                    text(i,x,border*0.5f);
                    text(i,border*0.5f,x);
                }
            }
            break;
        }
    }
}
=======
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
			case 0:
				background(0);
				int bars = (int) (mouseX / 20.0f);
				float w = width / (float) bars;
				for (int i = 0; i < bars; i++) {
					noStroke();
					fill(map(i, 0, bars, 0, 255), 255, 255);
					rect(map(i, 0, bars, 0, 500), 0, w, height);
				}
				break;
			case 1: {
				background(0);
				int squares = (int) (mouseX / 20.0f);
				float h = width / (float) squares;
				for (int i = 0; i < squares; i++) {
					noStroke();
					fill(map(i, 0, squares, 0, 255), 255, 255);
					float x = map(i, 0, squares, 0, width);
					rect(x, x, h, h);
					rect((width - h) - x, x, h, h);
				}
			}
				break;
			case 2:
				background(255);
				int circles = (int) (mouseX / 20.0f);
				offset += (mouseY / 100.0f);
				float d = width / (float) circles;
				for (int j = 0; j < circles; j++) {
					for (int i = 0; i < circles; i++) {
						noStroke();
						float c = map((i + j + offset), 0, circles * 2, 0, 255) % 256;
						fill(c, 255, 255);
						float x = map(i, 0, circles - 1, d / 2.0f, width - (d / 2.0f)); 
						float y = map(j, 0, circles - 1, d / 2.0f, width - (d / 2.0f)); 
						circle(x, y, d);
					}
				}
				break;
			case 3:
				background(0);
				colorMode(RGB);
				float border = width * 0.1f;
				for(int i = -5; i <= 5; i ++)
				{
					float x = map(i, -5, 5, border, width - border);
					stroke(0, 255, 0);
					line(x, border, x, height - border);
					line(border, x, width - border, x);
					fill(255);
					text(i, x, border * 0.5f);
					text(i, border * 0.5f, x);
				}
			case 4:
				background(0);
				colorMode(RGB);
				stroke(255);	
				float cx = width / 2;
				float cy = height / 2;	
				float radius = 200;		
				int sides = (int)map(mouseX, 1, width, 2, 10);
				for(int i = 1 ; i <= sides ; i ++)
				{
					float theta1 = map(i - 1, 0, sides, 0, TWO_PI);
					float x1 = cx + sin(theta1) * radius;
					float y1 = cy + cos(theta1) * radius;

					float theta2 = map(i, 0, sides, 0, TWO_PI);
					float x2 = cx + sin(theta2) * radius;
					float y2 = cy + cos(theta2) * radius;
					line(x1, y1, x2, y2);

					//circle(x, y, 20);
				}

				// map(a,b,c,d,e);
				// a = inputvalue
				// b - c - start and end of the first range
				// d, e 0 - start and and of the end range

				// map(-2, 10, 90, 200, 233);

		}
	}
}
>>>>>>> d53e2a8317afe6b546d09b3afd70667e49058ef2
