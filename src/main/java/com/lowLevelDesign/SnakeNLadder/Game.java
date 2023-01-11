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

    public static void main(String[] args) {
        Player player1 = new Player(new Piece("1"));
        Player player2 = new Player(new Piece("2"));
        Game game = Game.startGame(100, GameDifficulty.HARD, player1, player2);
    }

    public static Game startGame(int boardSize, GameDifficulty difficulty, Player... players) {
        Game newGame = Game.builder()
                .board(Board.createNewBoard(boardSize, difficulty))
                .die(new Dice())
                .players(players)
                .moveList(new ArrayList<>())
                .status(GameStatus.INITIATED)
                .build();

        List<Piece> pieces = Arrays.stream(players)
                .map(Player :: getPiece)
                .toList();

        newGame.getBoard().getStart().setPieces(pieces);

        for(Square sq : newGame.getBoard().getSquares()) {
            if(sq.getTeleporter() != null) {
                int startingSquare = sq.getTeleporter().getStartingSquare();
                int endingSquare = sq.getTeleporter().getEndingSquare();

                if(startingSquare == 1 || endingSquare == 100) {
                    System.out.println("WRRRRRRRONG");
                }
            }
        }

        return newGame;
    }
}
