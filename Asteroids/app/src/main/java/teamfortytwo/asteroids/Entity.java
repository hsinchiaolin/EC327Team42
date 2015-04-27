package teamfortytwo.asteroids;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Log;

/**
 * Created by BrandonWebster on 4/19/15.
 */
public class Entity {

    protected Drawable image; //This is the image drawn to the screen
    protected Vector pos; //The position of the Bee on the screen
    protected int size; //this will be added to position in setBounds
    static int team;

    public Entity(Resources res, Vector pos, int size){
        this.size = size;
        this.pos = pos; //sets the position vector

    }

    //Get Functions
    public Vector getPos(){
        return pos;
    }
    public Drawable getImage(){
        return image;
    }

    //Set Functions
    public void setPos(float x, float y){
        /*
        Set the position of the entity
         */

        pos.setX((int) x);
        pos.setY((int) y);
    }

    protected void setBounds(int left, int top, int right, int bottom){
        //initializes the image onto the screen, android has 0, 0 as the top left corner
        image.setBounds(left, top, right, bottom);
    }


    public void draw(Canvas canvas){
        setBounds(pos.getX(), pos.getY(), pos.getX() + size, pos.getY() + size); //updates the position of the image on the screen
        image.draw(canvas); //Draws the image
    }


}
