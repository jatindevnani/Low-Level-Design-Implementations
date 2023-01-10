package com.lowLevelDesign.SnakeNLadder;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Move {
    private Square prevSquare;
    private Square nextSquare;
    private Piece piece;
    private Teleporter teleporter;
}
