package main.service;

import main.exceptions.IllegalMazeShapeException;
import main.exceptions.IllegalStartPositionException;
import main.exceptions.NoEscapeException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class MazeService {

    /**
     * Wrapper around solve method that translates from incoming data type String to the desired char[][]
     * @param maze Incoming string formatted maze
     * @param startX The X coordinate of the starting point
     * @param startY The Y coordinate of the starting point
     * @return The maze as before but with the path out drawn into it
     * @throws NoEscapeException Thrown if there is no way to escape the maze
     */
    public String solveMaze(String maze, int mazeWidth, int startX, int startY) throws NoEscapeException, IllegalStartPositionException, IllegalMazeShapeException {
        return translate2dCharArrayToString(LabEscape.drawPathForEscape(translateStringMapTo2dCharArray(maze, mazeWidth), startX, startY));
    }

    /**
     * Translate the maze from a string using line endings to define the end of a row. Should handle both windows and unix line endings.
     * @param maze The string representation of the maze
     * @param mazeWidth The number of blocks in a row in the maze
     * @return The maze represented in a 2d char array
     */
    public char[][] translateStringMapTo2dCharArray(String maze, int mazeWidth) throws IllegalMazeShapeException {
        int numOfRows = maze.length() / mazeWidth;
        char[][] charMaze = new char[numOfRows][];
        if (maze.length() % mazeWidth != 0) { throw new IllegalMazeShapeException("The maze can only be rectangular or square");}
        for (int index =0; index < numOfRows; index++){
            charMaze[index] = maze.substring(index*mazeWidth, (index+1)*mazeWidth).toCharArray();
        }
        return charMaze;
    }

    /**
     * Translates the maze into a String format to be returned to the controller
     * @param charMaze The maze with the path in it
     * @return The char maze as one continuous String
     */
    public String translate2dCharArrayToString(char[][] charMaze){
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(charMaze).forEach(chars -> stringBuilder.append(chars).append("\n"));
        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }

}
