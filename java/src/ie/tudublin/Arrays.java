package ie.tudublin;

import processing.core.PApplet;

public class Arrays extends PApplet {


    float[] rainfall = { 45, 37, 55, 27, 38, 50, 79, 48, 104, 31, 100, 58 };

    String[] months = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};

    float[] a1 = new float[100];
    float[] a2;

    int minIndex = 0;
    int maxIndex  = 0;

    int mode = 0;

    public void keyPressed() {
		if (key >= '0' && key <= '9') {
			mode = key - '0';
		}
		println(mode);
	}
        

    public void settings()
    {
        size(500, 500);
    }

    public void setup()
    {
        for(int i = 0 ; i < rainfall.length ; i ++)
        {
            println(rainfall[i] + "\t" + months[i]);
        }
        for(float r:rainfall)
        {
            println(r);
        }
        
        int j = 0;
        for(float r:rainfall)
        {
            println(r + "\t" + months[j]);
            j ++;
        }

        for(int i = rainfall.length - 1; i >= 0 ; i -- )
        {
            println(rainfall[i] + "\t" + months[i]);
        }

        for(int i = 1 ; i < rainfall.length ; i ++)
        {
            if (rainfall[i] < rainfall[minIndex])
            {
                minIndex = i;
            }
            else if (rainfall[i] > rainfall[maxIndex])
            {
                maxIndex = i;
            } 
        }

        println("Max rainfall: " + rainfall[maxIndex] + " in month " + months[maxIndex]);
        println("Min rainfall: " + rainfall[minIndex] + " in month " + months[minIndex]);

    }

    public void draw()
    {
        switch (mode) {
			case 0:{
                background(0);
                int j = 120;
                colorMode(HSB);
                float border = width * 0.1f;
                float w = width / (float)rainfall.length;
                noStroke();
                for(int i = 0 ; i < rainfall.length ; i ++)
                {
                    float x = map(i, 0, rainfall.length, border+1, width - border);
                    float h = map(rainfall[i], 0, j, 0, height - (border * 2)); 
                    int c = (int)map(i, 0, rainfall.length, 0, 255);
                    fill(c, 255, 255);
                    rect(x,height-border-1, w,-h);
                    fill(255);
                    stroke(255);
                    line(border,border,border,height-border);
                    line(border,height-border,width-border,height-border);
                    textAlign(CENTER, CENTER);
                    text(months[i], x + (w / 2), height - 30);
                    text(j,rainfall[i]*0.5f,x);
                    j -= 10;
                    text("Rainfall Chart", width / 2, border / 2);
                }
            }

                break;
            case 1:
            {
                float border = width * 0.1f;
                int j= 120;
                float w = (width - (border * 2)) / rainfall.length;
                for(int i = 1 ; i < rainfall.length; i ++)
                {                    
                    float x1 = map(i-1, 0, rainfall.length-1, border + (w/2), width - border - (w/2));
                    float y1 = map(rainfall[i-1], 0, j, height - border, border);
                    float x2 = map(i, 0, rainfall.length-1, border + (w/2), width - border - (w/2));
                    float y2 = map(rainfall[i], 0, j, height - border, border);
                    line(x1, y1, x2, y2);
                }
                fill(255);
        
                break;
            }
            case 2:
                //
                break;
            }        
    }    
}
