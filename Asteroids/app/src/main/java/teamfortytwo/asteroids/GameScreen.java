package teamfortytwo.asteroids;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by BrandonWebster on 4/8/15.
 */
public class GameScreen extends Activity{

    Canvas canvas;


    private SensorManager sManager;
    private Sensor gyro;

    GameView view; //This is needed for to draw drawables

    int screenWidth;
    int screenHeight;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_screen);

        //Used for determining screen size in pixels
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager wm = (WindowManager) getApplicationContext().getSystemService(this.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(displayMetrics);
        screenWidth = displayMetrics.widthPixels;
        screenHeight = displayMetrics.heightPixels;

        view = new GameView(this, screenWidth, screenHeight);

    }

}
