package teamfortytwo.asteroids;

import android.content.res.Resources;

/**
 * Created by BrandonWebster on 4/19/15.
 */
public class Caterpillar extends Entity{

    public Caterpillar(Resources res, Collisions collisions, Vector pos, int size) {
        super(collisions, pos, size);
        image = res.getDrawable(R.drawable.caterpillar_small); //Set the image to be the file b_small.png
        setBounds(pos.getX(), pos.getY(), pos.getX() + size, pos.getY() + size); //initializes the image onto the screen, android has 0, 0 as the top left corner

        speed = - GameScreen.screenHeight / 200;

        team = 1;
    }
}
