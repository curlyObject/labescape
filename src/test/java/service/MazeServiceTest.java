package service;

import org.assertj.core.data.Index;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MazeServiceTest {

    private MazeService mazeService = new MazeService();

    @Test
    public void testSolveMaze(){
        String maze = "0 00\n0  0\n00 0\n0000";
        int startX = 1, startY = 2;
        char[][] charMaze = mazeService.solveMaze(maze, startX, startY);
        assertThat(charMaze)
                .hasSize(4)
                .contains(new char[]{'0', ' ', '0', '0'}, Index.atIndex(0))
                .contains(new char[]{'0', ' ', ' ', '0'}, Index.atIndex(1))
                .contains(new char[]{'0', '0', ' ', '0'}, Index.atIndex(2))
                .contains(new char[]{'0', '0', '0', '0'}, Index.atIndex(3));
    }

}
