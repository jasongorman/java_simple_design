package com.codemanship.marsrover;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Rover {
    private int[] position;
    private String facing;

    public Rover(String facing, int x, int y) {
        this.facing = facing;
        this.position = new int[]{x, y};
    }

    public String getFacing() {
        return facing;
    }

    public int[] getPosition() {
        return position;
    }

    public void go(String instructions) {
        instructions.chars().forEach((instruction) -> {
            if(instruction == 'R'){
                String[] compass = {"N", "E", "S", "W"};
                int i = Arrays.asList(compass).indexOf(facing);
                facing = compass[(i + 1) % 4];
            }

            if(instruction == 'L') {
                String[] compass = {"N", "W", "S", "E"};
                int i = Arrays.asList(compass).indexOf(facing);
                facing = compass[(i + 1) % 4];
            }

            if(instruction == 'F'){
                Map<String, int[]> vectors = new HashMap<String, int[]>(){{
                    put("N", new int[]{0, 1});
                    put("E", new int[]{1, 0});
                    put("S", new int[]{0, -1});
                    put("W", new int[]{-1, 0});
                }};

                int[] vector = vectors.get(facing);
                position[0] = position[0] + vector[0];
                position[1] = position[1] + vector[1];
            }

            if(instruction == 'B'){
                Map<String, int[]> vectors = new HashMap<String, int[]>(){{
                    put("N", new int[]{0, 1});
                    put("E", new int[]{1, 0});
                    put("S", new int[]{0, -1});
                    put("W", new int[]{-1, 0});
                }};

                int[] vector = vectors.get(facing);
                position[0] = position[0] - vector[0];
                position[1] = position[1] - vector[1];
            }
        });
    }
}