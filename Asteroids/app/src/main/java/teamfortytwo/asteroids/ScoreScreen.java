package teamfortytwo.asteroids;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class ScoreScreen extends Activity implements OnClickListener{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_screen);
    }

    @Override
    public void onClick(View v) {

    }
}
