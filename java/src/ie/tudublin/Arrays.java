package ie.tudublin;
import processing.core.PApplet;
public class Arrays extends PApplet{
    float[] rainfall = {45,37,55,27,38,50,79,48,104,31,100,58};
    String [] months = {"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP", "OCT","NOV","DEC"};

    public void settings() {
        size(500,500);
           
    }

    public void setup() {

        for(int i = 0; i < rainfall.length;i++)
        {
            println(rainfall[i]+"\t"+months[i]);
        }

        for(float r:rainfall)
        {
            println(r);
        }

        for(int i = rainfall.length - 1; i>=0;i--)
        {
            println(rainfall[i] + "\t" + months[i]);
        }

        int j = 0;
        float min=rainfall[j];
        String minmon = months[j];
        String maxmon = months[j];
        float max = rainfall[j];
        float total = 0;
        float avg = 0;
        for(j = 0; j < rainfall.length;j++)
        {
            
            total += rainfall[j];
            avg = total / 12;
           
            if(rainfall[j] < min)
            {
                min = rainfall[j];
                minmon = months[j];
            }
            if(rainfall[j] > max)
            {
               max = rainfall[j];
               maxmon = months[j];
            }
            
        }
        println("Max rainfall in  " + maxmon + " is " + max);
        println("Min rainfall in " + minmon + " is " + min);
        println("The total rainfall is " + total); 
        println("The average rainfall is " + avg);
    }

    public void draw() {
        background(0);
        colorMode(HSB);

        float w = width / (float) rainfall.length;
        for (int i =0; i<rainfall.length;i++)
        {
            float x = map(i,0,rainfall.length,0, width);
            int c = (int)map(i,0,rainfall.length,0,255);
            fill(c,255,255);
            rect(x , height , w , -rainfall[i]);
        }

    }
}
