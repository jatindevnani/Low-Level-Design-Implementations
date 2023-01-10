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

        Map<TeleporterType, Integer> teleportersMap = Arrays.stream(difficulty.getTeleportersBreakdown()
                        .split(""))
                .map(e -> e.split("-"))
                .collect(Collectors.toMap(a -> TeleporterType.valueOf(a[0]), b -> Integer.parseInt(b[0])));

        List<String> boardMap = new ArrayList<>(size);

        boardMap = boardMap.stream().map(e -> {
            for(Map.Entry<TeleporterType, Integer> entry : teleportersMap.entrySet()) {
                if(entry.getValue() == 0) {
                    continue;
                }
                teleportersMap.put(entry.getKey(), entry.getValue() - 1);
                return entry.getKey().name();
            }
            return null;
        }).toList();

        Collections.shuffle(boardMap);

        List<String> finalBoardMap = boardMap;
        Arrays.stream(board.getSquares()).forEach(e -> {
                e = Square
                        .builder()
                        .teleporter(TeleporterFactory.getTeleporter(TeleporterType.findByValue(finalBoardMap.get(squareNumber.get() - 1)), squareNumber.get() - 1))
                        .number(squareNumber.getAndIncrement())
                        .build();
            }
        );
        board.setStart(board.getSquares()[0]);
        board.setEnd(board.getSquares()[size-1]);
        return board;
    }
}
