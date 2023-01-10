package com.lowLevelDesign.SnakeNLadder;

import lombok.Data;

import java.util.Objects;

@Data
public class Piece {
    private String id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return Objects.equals(id, piece.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
