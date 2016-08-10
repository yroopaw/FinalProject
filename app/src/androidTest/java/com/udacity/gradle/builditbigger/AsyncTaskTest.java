package com.udacity.gradle.builditbigger;

import android.content.Context;

import java.util.concurrent.TimeUnit;
import org.mockito.Mock;
import android.test.AndroidTestCase;


/**
 * Created by yusuf on 07/08/16.
 */
public class AsyncTaskTest extends AndroidTestCase{

    MainActivity.EndpointsAsyncTask myTask;
    String mJoke;
    @Mock
    Context mMockContext;

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        mJoke = null;
        myTask = new MainActivity.EndpointsAsyncTask() {
            @Override
            protected void onPostExecute(String result) {
                //mJoke = result;
            }
        };
    }

    public void testJokeReturnData() {
        try {
            myTask.execute(mMockContext);
            mJoke = myTask.get(10, TimeUnit.SECONDS);
            assertNotNull(mJoke);
        } catch (Exception e) {
            fail("Time out");
        }
    }
}
