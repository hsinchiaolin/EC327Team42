package teamfortytwo.asteroids;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by BrandonWebster on 4/22/15.
 */

public class GameView extends View {
    /* This class is where drawables actually get updated and drawn. */
    Bee player;

    public GameView(Context context, int screenWidth, int screenHeight) {
        super(context);

        setBackground(R.drawable.ingame);
        Resources res = this.getResources();

        player = new Bee(res, new Vector<Integer>(screenWidth / 2, screenHeight - screenHeight / 5));
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        player.draw(canvas);
    }
}
