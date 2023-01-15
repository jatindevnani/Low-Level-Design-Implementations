package com.lowLevelDesign.SnakeNLadder;

import java.util.Random;

public class Die {

    public static Face rollDice() {
        int pick = new Random().nextInt(Face.values().length);
        return Face.values()[pick];
    }

}
