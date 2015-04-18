package teamfortytwo.asteroids;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by BrandonWebster on 4/8/15.
 */
public class GameScreen extends Activity{

    Canvas canvas;
    Bee player;

    int screenWidth;
    int screenHeight;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_screen);

        Bitmap b = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(b);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager wm = (WindowManager) getApplicationContext().getSystemService(this.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(displayMetrics);
        screenWidth = displayMetrics.widthPixels;
        screenHeight = displayMetrics.heightPixels;

        Resources res = this.getResources();
        player = new Bee(res, new Vector<Integer>(screenWidth / 2, screenHeight - screenHeight / 5));

    }

    protected void onDraw(){
        player.draw(canvas);
    }


}
