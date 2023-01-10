package com.lowLevelDesign.SnakeNLadder;

public enum Face {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6);

    private int value;

    private Face(int val) {
        this.value = val;
    }

    public int getFaceValue() {
        return value;
    }
}
