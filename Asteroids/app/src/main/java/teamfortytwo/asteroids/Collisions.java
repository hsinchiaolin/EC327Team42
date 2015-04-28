package teamfortytwo.asteroids;

/**
 * Created by BrandonWebster on 4/27/15.
 */
public class Collisions {

    static final int off_x = 1, off_y = 2;
    int screenWidth, screenHeight;

    public Collisions(){
        screenHeight = GameScreen.screenHeight;
        screenWidth = GameScreen.screenWidth;
    }

    public int check(Entity entity){

        int x = entity.getPos().getX(), y = entity.getPos().getY();
        if(x < 0 || x > screenWidth - entity.getSize()){
            return off_x;
        }
        if(y < -entity.getSize() || y > screenHeight + entity.getSize()){
            return off_y;
        }

        return 0;
    }

}
