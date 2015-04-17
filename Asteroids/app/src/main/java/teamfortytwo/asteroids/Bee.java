package teamfortytwo.asteroids;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

/**
 * Created by BrandonWebster on 4/13/15.
 */
public class Bee{

    Drawable image;

    public Bee(Resources res){
        image = res.getDrawable(R.drawable.bee);
        image.setBounds(32, 64, 64, 32);
    }

    public void draw(Canvas canvas){
        image.draw(canvas);
    }
}
