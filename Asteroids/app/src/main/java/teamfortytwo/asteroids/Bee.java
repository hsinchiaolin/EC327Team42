package teamfortytwo.asteroids;

import android.content.res.Resources;


/**
 * Created by BrandonWebster on 4/13/15.
 */
public class Bee extends Entity{


    public Bee(Resources res, Vector<Integer> pos){
        super(res, pos);
        image = res.getDrawable(R.drawable.b_small); //Set the image to be the file b_small.png
        setBounds(pos.getX(), pos.getY(), pos.getX() + size, pos.getY() + size); //initializes the image onto the screen, android has 0, 0 as the top left corner
        size = 32;

        team = 0;
    }


}
