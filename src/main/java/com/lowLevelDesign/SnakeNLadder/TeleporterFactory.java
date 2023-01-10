package com.lowLevelDesign.SnakeNLadder;

public class TeleporterFactory {

    public static Teleporter getTeleporter(TeleporterType teleporterType, int square, int size) {
        switch (teleporterType) {
            case SNAKE -> {
                return createNewSnake(square, size);
            }
            case LADDER -> {
                return createNewLadder(square, size);
            }
        }
        return null;
    }

    private static Teleporter createNewSnake(int max, int size) {
        if(max <= 10 || max >= 100) {
            return null;
        }
    }

    private static Teleporter createNewLadder(int min, int size) {
        if(min > 90 || min == 1) {
            return null;
        }

        int random_int = (int)Math.floor(Math.random() * (99 - min + 10) + min);

        if(random_int <= min) {
            return null;
        }

        return Teleporter.builder()
                .type(TeleporterType.LADDER)
                .endingSquare(random_int).build();
    }

}
