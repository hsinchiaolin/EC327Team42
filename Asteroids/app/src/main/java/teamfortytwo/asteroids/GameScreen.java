package teamfortytwo.asteroids;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;

/**
 * Created by BrandonWebster on 4/8/15.
 */
public class GameScreen extends Activity{

    Canvas canvas;
    Bee player;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_screen);

        Bitmap b = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(b);

        Resources res = this.getResources();
        player = new Bee(res);

    }

    protected void onDraw(){
        player.draw(canvas);
    }




}
