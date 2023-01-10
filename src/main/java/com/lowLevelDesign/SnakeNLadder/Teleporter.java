package com.lowLevelDesign.SnakeNLadder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Teleporter {

    private final Square startingSquare;
    private final Square endingSquare;
    private final TeleporterType type;

}
