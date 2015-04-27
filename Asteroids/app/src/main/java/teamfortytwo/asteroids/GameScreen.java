package teamfortytwo.asteroids;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by BrandonWebster on 4/8/15.
 */
public class GameScreen extends Activity implements SensorEventListener{

    Canvas canvas;


    private SensorManager sManager;
    private Sensor accelerometer, magnetometer;

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

        //Sensors
        sManager = (SensorManager) getSystemService(this.SENSOR_SERVICE);
        accelerometer = sManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        magnetometer = sManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        sManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_GAME);
        sManager.registerListener(this, magnetometer, SensorManager.SENSOR_DELAY_GAME);

        view = new GameView(this, screenWidth, screenHeight);
        setContentView(view);
    }

    @Override
    protected void onResume(){
        super.onResume();
        sManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_GAME);
        sManager.registerListener(this, magnetometer, SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    protected void onPause(){
        super.onPause();
        sManager.unregisterListener(this, accelerometer);
        sManager.unregisterListener(this, magnetometer);
    }


    @Override
    public void onSensorChanged(SensorEvent event) {
        float angle = event.values[2];
        Log.i("Sensor", "Sensor Event, angle: " + angle);

        view.updatePlayer(angle);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
