package com.lowLevelDesign.SnakeNLadder;

import lombok.Data;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Data
public class Board {
    private Square[] squares;
    private Square start;
    private Square end;
    private int size;

    public static Board createNewBoard(int size, GameDifficulty difficulty) {
        Board board = new Board();
        board.size = size;
        board.setSquares(new Square[size]);
        AtomicInteger squareNumber = new AtomicInteger(1);

        //Getting the number of teleporters as per the difficulty
        Map<TeleporterType, Integer> teleportersMap = new HashMap<>();


        String[] teleporters = difficulty.getTeleportersBreakdown().split(" ");
        for(String teleporterMapping : teleporters) {
            String[] map = teleporterMapping.split("-");
            teleportersMap.put(TeleporterType.findByValue(map[0]),Integer.parseInt(map[1]));
        }

        List<String> boardMap = new ArrayList<>();

        for(int i = 0; i < 100; i++) {
            boardMap.add("NO_TELEPORTER");
        }

        //Creating a random board to represent location of teleporters
        boardMap = boardMap.stream().map(e -> {
            for(Map.Entry<TeleporterType, Integer> entry : teleportersMap.entrySet()) {
                if(entry.getValue() == 0) {
                    continue;
                }
                teleportersMap.put(entry.getKey(), entry.getValue() - 1);
                return entry.getKey().name();
            }
            return "NO_TELEPORTER";
        }).toList();

        List<String> finalBoard = new ArrayList<>(boardMap);

        //Shuffling the board
        Collections.shuffle(finalBoard, new Random(4));

        for(int i = 0; i < board.getSquares().length; i++) {
            board.getSquares()[i] = Square
                    .builder()
                    .teleporter(TeleporterFactory.getTeleporter(TeleporterType.findByValue(finalBoard
                            .get(i)), board, i ))
                    .number(squareNumber.getAndIncrement())
                    .build();
        }

        board.setStart(board.getSquares()[0]);
        board.setEnd(board.getSquares()[size-1]);
        return board;
    }

    public Square findSquareBySquareNumber(int squareNumber) {
        if(squareNumber > this.size || squareNumber < 1) {
            return null;
        }

        return this.squares[squareNumber - 1];
    }
}
