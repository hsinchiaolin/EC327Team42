package teamfortytwo.asteroids;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

/**
 * Created by BrandonWebster on 4/13/15.
 */
public class Bee{

    Drawable image; //This is the image drawn to the screen
    Vector<Integer> pos; //The position of the Bee on the screen
    int size = 32; //this will be added to position in setBounds

    public Bee(Resources res, Vector<Integer> pos){
        image = res.getDrawable(R.drawable.b_small); //Set the image to be the file b_small.png
        this.pos = pos; //sets the position vector
        image.setBounds(pos.getX(), pos.getY(), pos.getX() + size, pos.getY() + size); //initializes the image onto the screen, android has 0, 0 as the top left corner

    }

    public void draw(Canvas canvas){
        pos.setX(pos.getX()); //currently redundant, but this is used to change the x position, will be more helpful when i know how to change based on the gyroscope
        image.setBounds(pos.getX(), pos.getY(), pos.getX() + size, pos.getY() + size); //updates the position of the image on the screen
        image.draw(canvas); //Draws the image
    }
}
