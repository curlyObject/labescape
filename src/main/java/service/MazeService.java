package service;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class MazeService {

    public char[][] solveMaze(String maze, int startX, int startY){
        char[][] charMaze = Arrays.stream(maze.split("\\r?\\n")).map(String::toCharArray).toArray(char[][]::new);
        return charMaze;
    }

}
