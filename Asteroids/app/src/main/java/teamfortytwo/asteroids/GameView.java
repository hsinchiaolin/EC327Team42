package teamfortytwo.asteroids;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by BrandonWebster on 4/22/15.
 */

public class GameView extends View {
    /* This class is where drawables actually get updated and drawn. */
    Bee player;
    ArrayList<Entity> entities = new ArrayList<Entity>();
    Collisions collisions;
    Resources res;

    Random random;

    int screenWidth, screenHeight;


    public GameView(Context context) {
        super(context);

        this.screenHeight = GameScreen.screenHeight;
        this.screenWidth = GameScreen.screenWidth;

        random = new Random(System.currentTimeMillis());

        res = this.getResources();
        Drawable background = res.getDrawable(R.drawable.ingame);
        setBackground(background);

        collisions = new Collisions();
        player = new Bee(res, collisions, new Vector(screenWidth / 2, screenHeight / 10), screenWidth / 12);

        Timer timer = new Timer();

        Log.i("Time", ""+ System.currentTimeMillis());

        timer.scheduleAtFixedRate(new CreateEnemies(), 5000, 500);
        timer.scheduleAtFixedRate(new MoveEntities(), 3000, 30);
    }

    public void updatePlayer(float angle){
        float move = angle * (screenWidth / 80);
        player.move(move);

    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        for(int i = 0; i < entities.size(); i++){
            entities.get(i).draw(canvas);

        }
        player.draw(canvas);
    }


    private class CreateEnemies extends TimerTask{

        @Override
        public void run() {
            entities.add(new Caterpillar(res, collisions, new Vector(random.nextInt() % screenWidth, screenHeight), screenWidth / 12));
        }

    }
    private class MoveEntities extends TimerTask{


        @Override
        public void run() {
            for(int i = 0; i < entities.size(); i++){
             entities.get(i).moveAtSpeed();
            }
        }
    }
}
