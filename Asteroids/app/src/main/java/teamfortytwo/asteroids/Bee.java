package teamfortytwo.asteroids;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/**
 * Created by BrandonWebster on 4/13/15.
 */
public class Bee{

    Drawable image;

    public Bee(Resources res){
        image = res.getDrawable(R.drawable.B);
        image.setBounds(32, 64, 64, 32);
    }

    public void draw(Canvas canvas){
        image.draw(canvas);
    }
}
