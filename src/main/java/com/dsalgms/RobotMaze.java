package com.dsalgms;

import java.util.ArrayList;
import java.util.HashMap;

public class RobotMaze {

    public class Point {
        int row, col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "row=" + row +
                    ", col=" + col +
                    '}';
        }
    }

    /**
     * Given a R x C grid
     * And a robot standing on left top corner,
     *
     * while the robot can move only to right or down at each step,
     * while some cells(i,j) are inaccessible
     *
     * Find "a" path from Left top corner to Right bottom corner.
     *
     * @param maze
     * @return
     */
    public ArrayList<Point> getPath(boolean[][] maze) {
        //Check for Invalid mazes.
        if(maze == null || maze.length == 0 || maze[0].length == 0) return null;

        HashMap<Point, Boolean> visitedCells = new HashMap<Point, Boolean>();
        ArrayList<Point> path = new ArrayList<>();

        int row = maze.length-1;
        int col = maze[0].length -1;

        if(getPath(maze, row, col, visitedCells, path)) {
            return path;
        }
        return null;
    }

    private boolean getPath(boolean[][] maze, int row, int col, HashMap<Point, Boolean> visitedCells, ArrayList<Point> path) {
        if(row < 0 || col < 0 || !maze[row][col]) return false;

        Point p = new Point(row, col);
        if(visitedCells.containsKey(p)) return visitedCells.get(p);

        boolean isOrigin = (row == 0) && (col == 0);
        if(isOrigin || getPath(maze, row-1, col, visitedCells, path) || getPath(maze, row, col-1, visitedCells, path)) {
            path.add(p);
            visitedCells.put(p, true);
            return true;
        } else {
            visitedCells.put(p, false);
            return false;
        }
    }
}
