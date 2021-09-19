package com.dsalgms;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;


class RobotMazeTest {

    @Test
    public void testMaze() {
        RobotMaze robotMaze = new RobotMaze();
        boolean[][] maze = new boolean[][] {
                {true, true, true, true},
                {true, true, false, true},
                {true, false, true, true},
                {false, true, true, true},
                {true, true, true, true},
        };
        ArrayList<RobotMaze.Point> paths = robotMaze.getPath(maze);
        paths.forEach(p -> System.out.println(p));
    }

}
