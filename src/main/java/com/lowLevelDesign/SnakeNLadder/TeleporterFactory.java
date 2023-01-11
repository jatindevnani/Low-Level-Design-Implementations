package com.lowLevelDesign.SnakeNLadder;

import java.util.Random;

public class TeleporterFactory {

    public static Teleporter getTeleporter(TeleporterType teleporterType, Board board, int square) {
        if(teleporterType == null) {
            return null;
        }
        switch (teleporterType) {
            case SNAKE -> {
                int randomSq = getRandomSquareNumber(0, square);
                if(randomSq == 0) {
                    return null;
                }
                return Teleporter.builder()
                        .type(TeleporterType.SNAKE)
                        .startingSquare(square)
                        .endingSquare(randomSq)
                        .build();
            }
            case LADDER -> {
                int randomSq = getRandomSquareNumber(square, 0);
                if(randomSq == 0) {
                    return null;
                }
                return Teleporter.builder()
                        .type(TeleporterType.LADDER)
                        .startingSquare(square)
                        .endingSquare(randomSq)
                        .build();
            }
        }
        return null;
    }

    @SuppressWarnings("All")
    public static int getRandomSquareNumber(int min, int max) {
        //Logic to calculate the random place for a snake tail or ladder head
        if(min == 0) {

            if(max <= 10 || max >= 100) {
                return 0;
            }

            Random random = new Random();
            min = random.ints(1, max-1)
                    .findFirst()
                    .getAsInt();

            if(min > max || (max - max % 10) == (min - min % 10)) {
               return 0;
            }

            return min;

        } else {
            if(min > 90 || min == 1) {
                return 0;
            }

            Random random = new Random();
            max = random.ints(min, 100)
                    .findFirst()
                    .getAsInt();

            if(max < min || (max - max % 10) == (min - min % 10)) {
                return 0;
            }

            return max;
        }
    }
}
