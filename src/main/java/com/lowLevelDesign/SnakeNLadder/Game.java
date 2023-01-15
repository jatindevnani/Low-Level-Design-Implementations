package com.lowLevelDesign.SnakeNLadder;

import com.lowLevelDesign.SnakeNLadder.Exceptions.InvalidMoveException;
import lombok.Builder;
import lombok.Data;

import java.util.*;

@Builder
@Data
public class Game {
    private Board board;
    private Player[] players;
    private List<Turn> turns;
    private GameStatus status;
    private Player currentPlayer;

    public static void main(String[] args) {
        Player player1 = new Player(new Piece("1"));
        Player player2 = new Player(new Piece("2"));
        Game game = Game.startGame(100, GameDifficulty.HARD, player1, player2);
    }

    public static Game startGame(int boardSize, GameDifficulty difficulty, Player... players) {
        Game newGame = Game.builder()
                .board(Board.createNewBoard(boardSize, difficulty))
                .players(players)
                .turns(new ArrayList<>())
                .status(GameStatus.INITIATED)
                .currentPlayer(players[0])
                .build();

        List<Piece> pieces = Arrays.stream(players)
                .map(Player :: getPiece)
                .toList();

        newGame.getBoard().getStart().setPieces(pieces);

        return newGame;
    }

    public List<Move> makeMove(List<Move> moves, Piece piece, Square currentSquare) {
        Face face = Die.rollDice();
        Square nextSquare = null;

        try {
            nextSquare = board.findSquareBySquareNumber(currentSquare.getNumber() + face.getFaceValue());
        } catch (InvalidMoveException e) {
            System.out.println("Invalid move");
            return moves;
        }

        while (nextSquare.getTeleporter() != null) {
            Teleporter teleporter = currentSquare.getTeleporter();
            nextSquare = board.findSquareBySquareNumber(teleporter.getEndingSquare());
        }

        currentSquare.removePiecesFromSquare(Arrays.asList(piece));
        nextSquare.placePiecesOnSquare(Arrays.asList(piece));

        Move move = new Move.MoveBuilder()
                .dieRoll(face)
                .prevSquare(currentSquare)
                .nextSquare(nextSquare)
                .teleporter(nextSquare.getTeleporter())
                .build();

        moves.add(move);

        if (nextSquare.getTeleporter() != null) {
            return makeMove(moves, piece, nextSquare);
        }

        return moves;
    }
}
