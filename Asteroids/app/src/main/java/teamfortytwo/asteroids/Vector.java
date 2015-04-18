package teamfortytwo.asteroids;

/**
 * Created by BrandonWebster on 4/18/15.
 */
public class Vector<T> {

    //simple vector class, mostly to be used for positioning entities on the screen

    private T x, y;

    public Vector(T x, T y){
        this.x = x;
        this.y = y;
    }
    public void setX(T x){
        this.x = x;
    }
    public void setY(T y){
        this.y = y;
    }
    public void set(T x, T y){
        this.x = x;
        this.y = y;
    }
    public T getX(){
        return x;
    }
    public T getY(){
        return y;
    }






}
