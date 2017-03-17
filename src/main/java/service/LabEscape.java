package service;

import exceptions.IllegalStartPositionException;
import exceptions.NoEscapeException;
import util.Coordinate;
import util.Path;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Please implement your solution here
 */
public class LabEscape {

    private static final char WALL = 'O';
    private static final char FREE = ' ';
    private static final char PATH = '•';

    /**
     * @param labyrinth A labyrinth drawn on a matrix of characters. It's at least 4x4, can be a rectangle or a square.
     *                  Walkable areas are represented with a space character, walls are represented with a big O character.
     *                  The escape point is always on the border (see README)
     * @param startX    Starting row number for the escape. 0 based.
     * @param startY    Starting column number for the escape. 0 based.
     * @return          A char matrix with the same labyrinth and a path drawn from the starting point to the escape
     * @throws NoEscapeException when no path exists to the outside, from the selected starting point
     */
    public static char[][] drawPathForEscape(char[][] labyrinth, int startX, int startY) throws NoEscapeException, IllegalStartPositionException {

        if (startY > labyrinth.length){
            throw new IllegalStartPositionException("The starting Y coordinate is outside of the maze");
        }
        if (startX > labyrinth[0].length){
            throw new IllegalStartPositionException("The starting X coordinate is outside of the maze");
        }
        if (labyrinth[startY][startX] != FREE){
            throw new IllegalStartPositionException("The starting X and Y coordinates will put you in a wall!");
        }
        solve(labyrinth, new Coordinate(startX, startY), new Path(), new HashSet<>());
        return new char[][]{};
    }

    private static Path solve(char[][] labyrinth, Coordinate currentPosition, Path currentPath, Set<Path> allPaths){
        // Check if I'm backtracking
        if (!currentPath.addCoordinate(currentPosition)) {
            return currentPath;
        }
        if (allPaths.stream().anyMatch(path -> path.containsCoordinate(currentPosition)))
        if (isTopOpen(labyrinth, currentPosition)) {
            allPaths.add(solve(labyrinth, currentPosition.moveUp(), currentPath, allPaths));
        }
        return new Path();
    }

    /**
     * Checks if you have reached the deg of the labyrinth and escaped.
     * Especially verbose styling for debugging
     * @param labyrinth The maze to espcape
     * @param currentPosition The current position in the search
     * @return true if on any edge of the maze.
     */
    private static boolean isEscaped(char[][] labyrinth, Coordinate currentPosition){
        //On left or top edge
        if (currentPosition.getX() == 0 || currentPosition.getY() == 0){
            return true;
        }
        //On right edge
        if (currentPosition.getX() == labyrinth[0].length-1){
            return true;
        }
        //On right edge
        if (currentPosition.getY() == labyrinth.length-1){
            return true;
        }
        return false;
    }

    private static boolean isTopOpen(char[][] labyrinth, Coordinate currentPosition) {
        return labyrinth[currentPosition.getY() - 1][currentPosition.getX()] == FREE;
    }

    private static boolean isRightOpen(char[][] labyrinth, Coordinate currentPosition) {
        return labyrinth[currentPosition.getY() - 1][currentPosition.getX()] == FREE;
    }

    private static boolean isBottomOpen(char[][] labyrinth, Coordinate currentPosition) {
        return labyrinth[currentPosition.getY() - 1][currentPosition.getX()] == FREE;
    }

    private static boolean isLeftOpen(char[][] labyrinth, Coordinate currentPosition) {
        return labyrinth[currentPosition.getY() - 1][currentPosition.getX()] == FREE;
    }
}
