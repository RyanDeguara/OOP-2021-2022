package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Audio1 extends PApplet
{
    Minim minim;
    AudioPlayer ap;
    AudioInput ai;
    AudioBuffer ab;

    int mode = 0;

    float[] lerpedBuffer;
    float y = 0;
    float smoothedY = 0;
    float smoothedAmplitude = 0;

    public void keyPressed() {
		if (key >= '0' && key <= '9') {
			mode = key - '0';
		}
		if (keyCode == ' ') {
            if (ap.isPlaying()) {
                ap.pause();
            } else {
                ap.rewind();
                ap.play();
            }
        }
	}

    public void settings()
    {
        size(500, 500);
    }

    public void setup()
    {
        minim = new Minim(this);
        // Uncomment this to use the microphone
        // ai = minim.getLineIn(Minim.MONO, width, 44100, 16);
        // ab = ai.mix; 
        ap = minim.loadFile("heroplanet.mp3", 500);
        ap.play();
        ab = ap.mix;
        colorMode(HSB);

        y = height / 2;
        smoothedY = y;

        lerpedBuffer = new float[width];
    }

    public void draw()
    {
        background(0);
        float halfH = height / 2;
        float average = 0;
        float sum = 0;

        // Calculate sum and average of the samples
        // Also lerp each element of buffer;
        for(int i = 0 ; i < ab.size() ; i ++)
        {
            sum += abs(ab.get(i));
            lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.1f);
        }
        average= sum / (float) ab.size();

        smoothedAmplitude = lerp(smoothedAmplitude, average, 0.1f);
        float cx = width/2;
        float cy = height/2;
        switch (mode) {
			case 0:
            {
                background(0);
                for(int i = 0 ; i < ab.size() ; i ++)
                {
                    //float c = map(ab.get(i), -1, 1, 0, 255);
                    float c = map(i, 0, ab.size(), 0, 255);
                    stroke(c, 255, 255);
                    float f = lerpedBuffer[i] * halfH * 4.0f;
                    line(i, halfH + f, halfH - f, i);                    
                }
                break;
            }
            case 1:
                {
                    background(0);
                    for (int i = 0; i < ab.size(); i++)
                    {
                        float c = map(i, 0, ab.size(), 0, 255);
                        stroke(c, 255, 255);
                        float f = lerpedBuffer[i] * ab.get(i) * 4.0f;
                        line(i, halfH - f * halfH * 4, i, halfH + f * halfH * 4);
                    }
                    break;
                }
            case 2:
                {
                    background(0);
                    for (int i = 0; i < ab.size(); i++)
                    {
                        float c = map(i, 0, ab.size(), 0, 255);
                        stroke(c, 255, 255);
                        float f = lerpedBuffer[i] * ab.get(i) * 4.0f;
                        line(0, i, halfH * f* 4, i);
                        line(width, i, width - (halfH * f* 4), i);
                        line(i, 0, i, (halfH * f* 4));
                        line(i, height, i, height - (halfH * f* 4));
                    }
                    break;
                }
            
            case 3:
            {
                background(0);
                strokeWeight(2);
                noFill();
                float r = map(smoothedAmplitude, 0, 0.5f, 100, 2000);
                float c = map(smoothedAmplitude, 0, 0.5f, 0, 255);
                stroke(c, 255, 255);
                circle(cx, cy, r);
            }
        }

        
        // Other examples we made in the class
        /*
        stroke(255);
        fill(100, 255, 255);        
        
        circle(width / 2, halfH, lerpedA * 100);

        circle(100, y, 50);
        y += random(-10, 10);
        smoothedY = lerp(smoothedY, y, 0.1f);        
        circle(200, smoothedY, 50);
        */

    }        
}
