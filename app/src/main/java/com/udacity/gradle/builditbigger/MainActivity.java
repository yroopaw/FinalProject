package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.util.Pair;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.os.AsyncTask;

import com.example.yusuf.myapplication.backend.myApi.MyApi;
//import com.google.android.gms.ads.AdListener;
//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.InterstitialAd;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.jokes.jokeProvider;


import java.io.IOException;

import gradle.udacity.com.displayjokelibrary.DisplayJokeActivity;

public class MainActivity extends ActionBarActivity {
    public static String mJoke;
   // InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      // yy new EndpointsAsyncTask().execute(new Pair<Context, String>(this, null));
        //Added for Insterstitial Ad

       /* mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(this.getString(R.string.banner_ad_unit_id));

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {

                requestNewInterstitial();


            }
        });*/
    }


 /*   private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mInterstitialAd.loadAd(adRequest);

    }*/


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view){
        new EndpointsAsyncTask().execute();
      //yy  new EndpointsAsyncTask().execute(new Pair<Context, String>(this, null));
       // jokeProvider1 myJoke = new jokeProvider1();
       // String newJoke = myJoke.getJoke();
       // Toast.makeText(this, newJoke, Toast.LENGTH_SHORT).show();
        Intent myIntent = new Intent(this, DisplayJokeActivity.class);
       // myIntent.putExtra(DisplayJokeActivity.JOKE_INTENT_KEY, newJoke);
        myIntent.putExtra(DisplayJokeActivity.JOKE_INTENT_KEY, mJoke);
        startActivity(myIntent);

    }

    public static class EndpointsAsyncTask extends AsyncTask<Context, Void, String> {
       //yy public static class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
        private  MyApi myApiService = null;
        private Context context;
        private EndpointsAsyncTaskListener mListener = null;

        @Override
        protected String doInBackground(Context... params) {
           //yy protected String doInBackground(Pair<Context, String>... params) {
            if(myApiService == null) {  // Only do this once
            /*    MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                        new AndroidJsonFactory(), null)
                        // options for running against local devappserver
                        // - 10.0.2.2 is localhost's IP address in Android emulator
                        // - turn off compression when running against local devappserver
                        .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                        .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                            @Override
                            public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                                abstractGoogleClientRequest.setDisableGZipContent(true);
                            }
                        });*/

                MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                        .setRootUrl("https://builditbigger-1470484649802.appspot.com/_ah/api/");
                // end options for devappserver

                myApiService = builder.build();
            }

          //  context = params[0].first;
        //    String name = params[0].second;


            try {
                return myApiService.randomJoke().execute().getData();
             //   return myApiService.sayHi(name).execute().getData();
            } catch (IOException e) {
                return e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String result) {
          //  Toast.makeText(context, result, Toast.LENGTH_LONG).show();
            mJoke = "";
            mJoke = result;
            Log.v("Joke Recieved", "Joke Received:"+mJoke);
        }

        //added for testing Async Task
        public EndpointsAsyncTask setListener(EndpointsAsyncTaskListener listener) {
            this.mListener = listener;
            return this;

        }

        public static interface EndpointsAsyncTaskListener {
            public void onComplete(String jokeString, Exception e);
        }
    }

}
