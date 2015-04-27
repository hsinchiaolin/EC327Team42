package teamfortytwo.asteroids;

/**
 * Created by BrandonWebster on 4/18/15.
 */
public class Vector {

    //simple vector class, mostly to be used for positioning entities on the screen

    private int x, y, z;

    public Vector(int x, int y){
        this.x = x;
        this.y = y;
        z =  0;
    }
    public Vector(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public void setZ(int z) { this.z = z; }
    public void set(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void set(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getZ() { return z; }







}
