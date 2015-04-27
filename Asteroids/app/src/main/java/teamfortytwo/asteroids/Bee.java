package teamfortytwo.asteroids;

import android.content.res.Resources;


/**
 * Created by BrandonWebster on 4/13/15.
 */
public class Bee extends Entity{


    public Bee(Resources res, Vector pos, int size){
        super(res, pos, size);
        image = res.getDrawable(R.drawable.b_small); //Set the image to be the file b_small.png
        setBounds(pos.getX(), pos.getY(), pos.getX() + size, pos.getY() + size); //initializes the image onto the screen, android has 0, 0 as the top left corner

        team = 0;
    }

    public void move(int x){
        setPos(pos.getX() + x, pos.getY());
    }


}
