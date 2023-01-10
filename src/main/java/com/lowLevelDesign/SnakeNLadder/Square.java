package com.lowLevelDesign.SnakeNLadder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class Square {

    private int number;
    private List<Piece> pieces = new ArrayList<>();
    private Teleporter teleporter;

    public void placePiecesOnSquare(List<Piece> pieces) {
        pieces.addAll(pieces);
    }

    public void removePiecesFromSquare(List<Piece> pieces) {
        pieces.removeAll(pieces);
    }

}
