package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;
import ddf.minim.analysis.WindowFunction;
import processing.core.PApplet;

public class PitchSpeller extends PApplet {

    Minim minim;
    AudioPlayer ap;
    AudioInput ai;
    AudioBuffer ab;

    int mode = 0;

    float[] lerpedBuffer;
    float y = 0;
    float smoothedY = 0;
    float smoothedAmplitude = 0;

    // FAST FOURIER TRANSPORT
    FFT fft;

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
        size(1024, 1000, P3D);
        //fullScreen(P3D, SPAN);
    }

    public void setup()
    {
        background(0);
        stroke(255);
        textSize(20);
        fill(255);
        PitchSpeller ps = new PitchSpeller();
        System.out.println(ps.spell(330));
        text("Freq: " + ps.spell(330), 100, 200);
    }

    float off = 0;

    public void draw()
    {
        background(0);
        stroke(255);
        textSize(20);
        fill(255);
        PitchSpeller ps = new PitchSpeller();
        System.out.println(ps.spell(330));
        text("Freq: " + ps.spell(330), 100, 200);


    }        
    
    float[] frequencies = {
        293.66f, 329.63f, 369.99f, 392.00f, 
        440.00f, 493.88f, 554.37f, 587.33f, 
        659.25f, 739.99f, 783.99f, 880.00f, 
        987.77f, 1108.73f, 1174.66f
    };

    String[] spellings = {
        "D,", "E,", "F,", "G,", 
        "A,", "B,", "C", "D", 
        "E", "F", "G", "A", 
        "B","c", "d", "e", 
        "f", "g", "a", "b", 
        "c'", "d'", "e'", "f'", 
        "g'", "a'", "b'", "c''", 
        "d''"
    };

    public String spell(float frequency)
    {
        float temp = 1000;
        float sum = 0;
        float sum2 = 0;
        String letter = " ";
        for (int i =0; i < frequencies.length; i++)
        {
            sum = frequency - frequencies[i];
            sum2 = frequencies[i] - frequency;
            if (sum > 0.0 && sum < temp)
            {
                temp = frequency - frequencies[i];
                letter = spellings[i];
            }

            if (sum2 > 0.0 && sum2 < temp)
            {
                temp = frequency - frequencies[i];
                letter = spellings[i];
            }
        }

        return letter;
    }

    public static void main(String[] args) {
        PitchSpeller ps = new PitchSpeller();
        System.out.println(ps.spell(330));
        System.out.println(ps.spell(420));
        System.out.println(ps.spell(1980));
    }

}
