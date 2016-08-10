package com.example.yusuf.myapplication.backend;

import java.util.Random;

/** The object model for the data we are sending through endpoints */
public class MyBean {

    private String myData;

    public String getData() {
        return myData;
    }

    public void setData(String data) {
        myData = data;
    }
    public String provideRandomJoke() {
        //Returns a random joke
        String[] jokes = {
                "He said 'I'm going to chop off the bottom of one of your trouser legs and put it in a library. ' I thought 'That's a turn-up for the books.",
                "British scientists have demonstrated that cigarettes can harm your children. Fair enough, use an ashtray.",
                "My parents are from Glasgow which means they're incredibly hard, but I was never smacked as a child. Well, maybe one or two grams to get me to sleep at night.",
                "Standing in the park, I was wondering why a Frisbee gets larger the closer it gets. Then it hit me.",
                "My name is Fin, which means it's very hard for me to end emails without sounding pretentious.",
                "I was watching the London Marathon and saw one runner dressed as a chicken and another runner dressed as an egg. I thought: 'This could be interesting'.",
                "For my birthday I got myself glasses. So my observational comedy’s really improved.",
                "I got an odd-job man in. He was useless. Gave him a list of eight things to do and he only did numbers one, three, five and seven.",
                "I needed a password eight characters long so I picked Snow White and the Seven Dwarfs.",
                "I went to buy some camouflage trousers the other day but I couldn't find any.",
                "I heard a rumour that Cadbury is bringing out an oriental chocolate bar. Could be a Chinese Wispa.",
                "I had an argument with one of the seven dwarfs. He wasn’t happy.",
                "The early bird gets the worm but the late worm gets to live.",
                "If I discovered a new animal I’d call it a Quorn to mess with vegetarians.",
                "A lorry-load of tortoises crashed into a train-load of terrapins, I thought 'That's a turtle disaster'.",
                "I’ve decided to sell my Hoover… well, it was just collecting dust.",
                "Hedgehogs – why can’t they just share the hedge?",
                "You can’t lose a homing pigeon. If your homing pigeon doesn’t come back, then what you’ve lost is a pigeon.",
                "My dad said, always leave them wanting more. Ironically, that’s how he lost his job in disaster relief.",
                "So I rang up British Telecom, I said 'I want to report a nuisance caller', he said 'Not you again'.",
                "I saw a documentary on how ships are kept together. Riveting!",
                "The anti-ageing advert that I would like to see is a baby covered in cream saying, ‘AAAAH, I’ve used too much!!'"

        };

        int len = jokes.length;
        Random rand = new Random();
        int  n = rand.nextInt(len) + 1;
        return jokes[n];


    }
}