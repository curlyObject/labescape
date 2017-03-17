package service;

import exceptions.IllegalStartPositionException;
import exceptions.NoEscapeException;
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
    public char[][] solveMaze(String maze, int startX, int startY) throws NoEscapeException, IllegalStartPositionException {
        return LabEscape.drawPathForEscape(translateStringMapTo2dCharArray(maze), startX, startY);
    }

    /**
     * Translate the maze from a string using line endings to define the end of a row. Should handle both windows and unix line endings.
     * @param maze The string representation of the maze
     * @return The maze represented in a 2d char array
     */
    public char[][] translateStringMapTo2dCharArray(String maze){
        return Arrays.stream(maze.split("\\r?\\n")).map(String::toCharArray).toArray(char[][]::new);
    }

}
