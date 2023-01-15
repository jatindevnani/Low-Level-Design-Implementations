package com.lowLevelDesign.SnakeNLadder.controller;

import com.lowLevelDesign.SnakeNLadder.*;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameController {

    public static void main(String[] args) {
        Game game = Game.startGame(100,
                GameDifficulty.HARD,
                new Player(new Piece("1")),
                new Player(new Piece("2")));

        while(game.getStatus() != GameStatus.FINISHED) {
            Player currentPlayer = game.getCurrentPlayer();
            Piece currentPiece = currentPlayer.getPiece();
            Square currentSquare = game.getBoard().findSquareByPiece(currentPiece);

            Scanner scanner = new Scanner(System.in);
            int roll = scanner.nextInt();                                                           //Roll dice

            List<Move> moves = game.makeMove(new ArrayList<>(), currentPiece, currentSquare);
        }
    }
}
