package ie.tudublin;

public class Player 
{
    YASC yasc;
    float x, y;
    float w; 
    float halfW;
    float rotation;
    float fx, fy;

    public Player(float x, float y, float w, YASC yasc)
    {
        this.x = x;
        this.y = y;
        this.w = w;
        halfW = w/2.0f;
        this.yasc = yasc;
        this.rotation = 0;
        // know its constructor because the constructor is the same name as the class
    }
    
    void render()
    {   
        yasc.pushMatrix();
        yasc.translate(x,y);
        yasc.rotate(rotation);
        float halfW = w/2;
        yasc.stroke(255);
        yasc.line(-halfW, halfW, 0, - halfW);
        yasc.line(0,  - halfW, halfW, halfW);
        yasc.line(halfW, halfW, 0, 0); 
        yasc.line(0, 0,  - halfW, halfW);        
        yasc.popMatrix();
    }   
    
    public void update()
    {
        if (yasc.keyPressed)
        {
            if (yasc.key == 'w')
            {
                x += fx;
                y += fy;
            }
            if (yasc.key == 's')
            {
                x -= fx;
                y -= fy;
            }
            if (yasc.key == 'a')
            {
                rotation -= 0.01f;
            }
            if (yasc.key == 'd')
            {
                rotation += 0.01f;
            }
        }
        fx = YASC.sin(rotation);
        fy = - YASC.cos(rotation);
    }
}
