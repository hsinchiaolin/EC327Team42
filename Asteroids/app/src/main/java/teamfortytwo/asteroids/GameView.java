package teamfortytwo.asteroids;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by BrandonWebster on 4/22/15.
 */

public class GameView extends View {
    /* This class is where drawables actually get updated and drawn. */
    Bee player;
    int screenWidth, screenHeight;


    public GameView(Context context) {
        super(context);

        this.screenHeight = GameScreen.screenHeight;
        this.screenWidth = GameScreen.screenWidth;

        Resources res = this.getResources();
        Drawable background = res.getDrawable(R.drawable.ingame);
        setBackground(background);

        Collisions collisions = new Collisions();
        player = new Bee(res, collisions, new Vector(screenWidth / 2, screenHeight - screenHeight / 5), screenWidth / 12);


    }

    public void updatePlayer(float angle){
        float move = angle * (screenWidth / 150);
        player.move(move);

    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        player.draw(canvas);
    }
}
