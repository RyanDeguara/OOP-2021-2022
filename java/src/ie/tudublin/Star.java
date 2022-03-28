package ie.tudublin;

import processing.core.PApplet;
import processing.data.TableRow;

public class Star {
    private boolean hab;
    private String dispayName;
    private float distance;
    private float xG,yG,zG;
    private float absMag;

    

    @Override // method overrides a method from the superclass - flag
    public String toString() {
        return "Star [absMag=" + absMag + ", dispayName=" + dispayName + ", distance=" + distance + ", hab=" + hab
                + ", xG=" + xG + ", yG=" + yG + ", zG=" + zG + "]";
    }

    public Star(TableRow tr)
    {
        this(
            tr.getInt("Hab?") == 1, 
            tr.getString("Display Name"), 
            tr.getFloat("Distance"), 
            tr.getFloat("Xg"),
            tr.getFloat("Yg"), 
            tr.getFloat("Zg"),
            tr.getFloat("AbsMag")
        );
    }

    public Star(boolean hab, String dispayName, float distance, float xG, float yG, float zG, float absMag) {
        this.hab = hab;
        this.dispayName = dispayName;
        this.distance = distance;
        this.xG = xG;
        this.yG = yG;
        this.zG = zG;
        this.absMag = absMag;
    }

    public boolean isHab() {
        return hab;
    }
    public void setHab(boolean hab) {
        this.hab = hab;
    }
    public String getDispayName() {
        return dispayName;
    }
    public void setDispayName(String dispayName) {
        this.dispayName = dispayName;
    }
    public float getDistance() {
        return distance;
    }
    public void setDistance(float distance) {
        this.distance = distance;
    }
    public float getxG() {
        return xG;
    }
    public void setxG(float xG) {
        this.xG = xG;
    }
    public float getyG() {
        return yG;
    }
    public void setyG(float yG) {
        this.yG = yG;
    }
    public float getzG() {
        return zG;
    }
    public void setzG(float zG) {
        this.zG = zG;
    }
    public float getAbsMag() {
        return absMag;
    }
    public void setAbsMag(float absMag) {
        this.absMag = absMag;
    }
    
    public void render(StarMap pa)
    {
        float x = PApplet.map(xG, -5, 5, pa.border, pa.width - pa.border);
        float y = PApplet.map(yG, -5, 5, pa.border, pa.height - pa.border);
        pa.stroke(255, 255, 0);
        pa.line(x, y - 5, x, y + 5);
        pa.line(x-5, y, x + 5, y);
        pa.stroke(255, 0, 0);
        pa.noFill();
        pa.circle(x, y, absMag);
        pa.fill(255);
        pa.textAlign(PApplet.LEFT,PApplet.CENTER);
        pa.text(dispayName, x+20, y);
    }
}
