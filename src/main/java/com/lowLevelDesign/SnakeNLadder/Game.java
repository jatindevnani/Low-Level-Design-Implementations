package com.lowLevelDesign.SnakeNLadder;

import lombok.Builder;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

@Builder
@Data
public class Game {
    private Board board;
    private Dice die;
    private Player[] players;
    private List<Move> moveList;
    private GameStatus status;

    public static Game startGame(int boardSize, GameDifficulty difficulty, Player... players) {
        Game newGame = Game.builder()
                .board(Board.createNewBoard(boardSize, difficulty))
                .die(new Dice())
                .players(players)
                .moveList(new ArrayList<>())
                .status(GameStatus.INITIATED)
                .build();

        newGame.getBoard()
                .getStart()
                .placePiecesOnSquare(Arrays.stream(players)
                        .map(Player :: getPiece)
                        .collect(Collectors.toList()));

        return newGame;
    }
}
