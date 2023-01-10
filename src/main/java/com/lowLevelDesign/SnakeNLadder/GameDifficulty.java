package com.lowLevelDesign.SnakeNLadder;

public enum GameDifficulty {
    EASY("SNAKE-2,LADDER-2"),
    NORMAL("SNAKE-6,LADDER-6"),
    HARD("SNAKE-10,LADDER-10");

    private String teleportersBreakdown;

    private GameDifficulty(String teleportersBreakdown) {
        this.teleportersBreakdown = teleportersBreakdown;
    }

    public String getTeleportersBreakdown() {
        return teleportersBreakdown;
    }
}
