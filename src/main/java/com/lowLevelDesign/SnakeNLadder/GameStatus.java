package com.lowLevelDesign.SnakeNLadder;

public enum GameStatus {
    FINISHED(null),
    ONGOING(FINISHED),
    INITIATED(ONGOING);

    private final GameStatus nextStatus;
    private GameStatus(GameStatus nextStatus) {
        this.nextStatus = nextStatus;
    }

    public GameStatus NextStatus() {
        return nextStatus;
    }
}
