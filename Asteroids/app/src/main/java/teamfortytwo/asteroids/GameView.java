package teamfortytwo.asteroids;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by BrandonWebster on 4/22/15.
 */

public class GameView extends View implements ValueAnimator.AnimatorUpdateListener{
    /* This class is where drawables actually get updated and drawn. */
    private Bee player;
    private ArrayList<Entity> entities = new ArrayList<Entity>();
    private Collisions collisions;
    private Resources res;

    private int score = 0;

    public int frame = 0;

    private Random random;

    private MainScreen mainScreen;
    private int screenWidth, screenHeight;

    public GameView(Context context, MainScreen mainScreen) {
        super(context);

        this.mainScreen = mainScreen;
        this.screenHeight = GameScreen.screenHeight;
        this.screenWidth = GameScreen.screenWidth;

        random = new Random(System.currentTimeMillis());

        res = this.getResources();
        Drawable background = res.getDrawable(R.drawable.ingame);
        setBackground(background);

        collisions = new Collisions(this);
        player = new Bee(res, collisions, this, new Vector(screenWidth / 2, screenHeight / 10), screenWidth / 12);



//        Timer timer = new Timer();
//
//        timer.scheduleAtFixedRate(new CreateEnemies(this), 5000, 500);
//        timer.scheduleAtFixedRate(new MoveEntities(), 3000, 30);
    }

    public void setFrame(int frame){
        this.frame = frame;
    }
    public int getFrame(){ return frame; }

    public void updatePlayer(float angle){
        float move = angle * (screenWidth / 80);
        player.move(move);

    }
    public void shoot(){
        entities.add(new Bullet(res, collisions, this, 0, player.getPos().copy(), screenWidth / 24));
    }


    public void destroyEntity(Entity entity){
        if(entity.equals(player)){
            player = null;
            mainScreen.startScore();
        }
        Log.i("destroyEntity", "" + entities.size());
        entities.remove(entity);
        Log.i("destroyEntity", "" + entities.size());
    }

    public ArrayList<Entity> getEntities(){
        return entities;
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        for(int i = 0; i < entities.size(); i++){
            entities.get(i).draw(canvas);

        }
        player.draw(canvas);
    }

    @Override
    public void onAnimationUpdate(ValueAnimator animation) {

        if(animation.getAnimatedValue() == 0){
            entities.add(new Caterpillar(res, collisions, this, new Vector(random.nextInt() % screenWidth, screenHeight), screenWidth / 12));
            score += 1;
        }
        for(int i = 0; i < entities.size(); i++){
            try {
                entities.get(i).moveAtSpeed();
            }catch(NullPointerException e){
                Log.i("GameView", "NullPointerException with entity at index " + i);
            }
        }
    }

//    private class CreateEnemies extends TimerTask{
//
//        GameView view;
//        public CreateEnemies(GameView view){
//            this.view = view;
//        }
//
//        @Override
//        public void run() {
//            entities.add(new Caterpillar(res, collisions, view, new Vector(random.nextInt() % screenWidth, screenHeight), screenWidth / 12));
//        }
//
//    }
//    private class MoveEntities extends TimerTask{
//
//
//        @Override
//        public void run() {
//
//        }
//    }
}
