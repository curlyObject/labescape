package service;

import org.assertj.core.data.Index;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MazeServiceTest {

    //TODO Get this to be autowired with a subset of the spring configuration
    private MazeService mazeService = new MazeService();

    @Test
    public void testSolveMaze() throws Exception{
        String maze = "O OO\nO  O\nOO O\nOOOO";
        char[][] charMaze = mazeService.translateStringMapTo2dCharArray(maze);
        assertThat(charMaze)
                .hasSize(4)
                .contains(new char[]{'O', ' ', 'O', 'O'}, Index.atIndex(0))
                .contains(new char[]{'O', ' ', ' ', 'O'}, Index.atIndex(1))
                .contains(new char[]{'O', 'O', ' ', 'O'}, Index.atIndex(2))
                .contains(new char[]{'O', 'O', 'O', 'O'}, Index.atIndex(3));
    }

}
