package com.lowLevelDesign.SnakeNLadder;

public enum TeleporterType {
    SNAKE, LADDER;

    public static TeleporterType findByValue(String val) {
        try {
            return TeleporterType.valueOf(val);
        } catch (Exception e) {
            return null;
        }
    }
}
