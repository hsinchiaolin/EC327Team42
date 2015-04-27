package teamfortytwo.asteroids;

import android.content.res.Resources;

/**
 * Created by BrandonWebster on 4/19/15.
 */
public class Caterpillar extends Entity{

    public Caterpillar(Resources res, Vector pos, int size) {
        super(res, pos, size);
        size = 32;
        image = res.getDrawable(R.drawable.caterpillar_small); //Set the image to be the file b_small.png
        setBounds(pos.getX(), pos.getY(), pos.getX() + size, pos.getY() + size); //initializes the image onto the screen, android has 0, 0 as the top left corner

        team = 1;
    }
}
