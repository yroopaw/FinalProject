package com.example.yusuf.myapplication.backend;

import java.util.Random;
//import com.udacity.gradle.jokes.jokeProvider;



/** The object model for the data we are sending through endpoints */
public class MyBean {

    private String myData;

    public String getData() {
        return myData;
    }

    public void setData(String data) {
        myData = data;
    }

}