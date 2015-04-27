package teamfortytwo.asteroids;

import android.app.Activity;
import android.graphics.Canvas;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;

/**
 * Created by BrandonWebster on 4/8/15.
 */
public class GameScreen extends Activity implements OnClickListener, SensorEventListener{

    Canvas canvas;


    private SensorManager sManager;
    private Sensor accelerometer, magnetometer;
    boolean accSet, magSet;
    float[] lastAccelerometer = new float[3], lastMagnetometer = new float[3],
            mR = new float[9], mOrientation = new float[3];

    GameView view; //This is needed for to draw drawables

    static int screenWidth;
    static int screenHeight;

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
        accSet = false;
        magSet = false;

        view = new GameView(this);
        setContentView(view);
    }

    @Override
    protected void onResume(){
        super.onResume();
        accSet = false;
        magSet = false;
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

        if(event.sensor == accelerometer){
            System.arraycopy(event.values, 0, lastAccelerometer, 0, event.values.length);
            accSet = true;
        }else if(event.sensor == magnetometer){
            System.arraycopy(event.values, 0, lastMagnetometer, 0, event.values.length);
            magSet = true;
        }
        if(accSet && magSet){
            SensorManager.getRotationMatrix(mR, null, lastAccelerometer, lastMagnetometer);
            SensorManager.getOrientation(mR, mOrientation);
        }

        Log.i("Sensor", "Angle: " + mOrientation[2]);

        view.updatePlayer(mOrientation[2]);
        view.invalidate();
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onClick(View v) {

    }
}
