package com.lowLevelDesign.SnakeNLadder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Teleporter {

    private final int startingSquare;
    private final int endingSquare;
    private final TeleporterType type;

}
