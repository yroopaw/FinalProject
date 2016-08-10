package gradle.udacity.com.displayjokelibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DisplayJokeActivity extends AppCompatActivity {
    public static String JOKE_INTENT_KEY = "jokeText";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent myIntent = getIntent();
        String joke = myIntent.getStringExtra(JOKE_INTENT_KEY);
        setContentView(R.layout.activity_display_joke);


        TextView jokeTextView = (TextView) findViewById(R.id.jokeTextView);
        if (joke != null && joke.length() != 0) {
            jokeTextView.setText(joke);
        }


    }
}
