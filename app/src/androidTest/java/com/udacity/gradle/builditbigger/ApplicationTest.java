package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.text.TextUtils;

import java.util.concurrent.CountDownLatch;
import com.udacity.gradle.builditbigger.MainActivity.EndpointsAsyncTask;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {

   /* CountDownLatch trigger;
    String mJokeString = null;
    Exception mError = null;*/

    public ApplicationTest() {
        super(Application.class);
    }

   /* @Override protected void setUp() throws Exception {
        trigger = new CountDownLatch(1);
    }

    @Override protected void tearDown() throws Exception {
        trigger.countDown();
    }

    public void testJokeApiTask() throws InterruptedException {

        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask();
        endpointsAsyncTask.setListener(new EndpointsAsyncTask.EndpointsAsyncTaskListener() {
            @Override
            public void onComplete(String jokeString, Exception e) {
                mJokeString = jokeString;
                mError = e;
                trigger.countDown();
            }
        }).execute("https://builditbigger-1470484649802.appspot.com/_ah/api/");
        //.execute("https://builditbigger-1470484649802.appspot.com/_ah/api/");
        trigger.await();

        assertNull(mError);
        assertFalse(TextUtils.isEmpty(mJokeString));
        assertTrue(!TextUtils.isEmpty(mJokeString));

    }*/
}