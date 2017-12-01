package com.leet.leet.utils.database;

/**
 * Created by snail on 11/22/2017.
 */

public class FDAHelper {

    public int getMaleCalories(int age)
    {
        if(age <= 2) { return 1000; }
        if(age <= 5) { return 1400; }
        if(age <= 8) { return 1600; }
        if(age <= 10) { return 1800; }
        if(age <= 11) { return 2000; }
        if(age <= 13) { return 2200; }
        if(age <= 14) { return 2400; }
        if(age <= 15) { return 2600; }
        if(age <= 25) { return 2800; }
        if(age <= 45) { return 2600; }
        if(age <= 65) { return 2400; }

        return 2200;
    }

    public int getFemaleCalories(int age)
    {
        if(age <= 2) { return 1000; }
        if(age <= 3) { return 1200; }
        if(age <= 4) { return 1400; }
        if(age <= 9) { return 1600; }
        if(age <= 11) { return 1800; }
        if(age <= 18) { return 2000; }
        if(age <= 25) { return 2200; }
        if(age <= 50) { return 2000; }

        return 1800;
    }

    public int getMaleMacros(int age)
    {
        return 0;
    }

    public int getFemaleMacros(int age)
    {
        return 0;
    }
}
