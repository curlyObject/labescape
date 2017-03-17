package main.service;

import main.exceptions.IllegalMazeShapeException;
import org.assertj.core.data.Index;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MazeServiceTest {

    //TODO Get this to be autowired with a subset of the spring configuration
    private MazeService mazeService = new MazeService();

    @Test
    public void testTranslateMaze() throws Exception{
        String maze = "O OOO  OOO OOOOO";
        int mazeWidth = 4;
        char[][] charMaze = mazeService.translateStringMapTo2dCharArray(maze, mazeWidth);
        assertThat(charMaze)
                .hasSize(4)
                .contains(new char[]{'O', ' ', 'O', 'O'}, Index.atIndex(0))
                .contains(new char[]{'O', ' ', ' ', 'O'}, Index.atIndex(1))
                .contains(new char[]{'O', 'O', ' ', 'O'}, Index.atIndex(2))
                .contains(new char[]{'O', 'O', 'O', 'O'}, Index.atIndex(3));
    }

    @Test(expected = IllegalMazeShapeException.class)
    public void testTranslateMaze_BadWidth() throws Exception{
        String maze = "O OOO  OOO OOOOO";
        int mazeWidth = 5;
        mazeService.translateStringMapTo2dCharArray(maze, mazeWidth);
    }

    @Test
    public void testTranslateCharMazeToString(){
        char[][] maze = {   new char[]{'O', '•', 'O', 'O'},
                            new char[]{'O', '•', '•', 'O'},
                            new char[]{'O', 'O', '•', 'O'},
                            new char[]{'O', 'O', 'O', 'O'}};
        String stringMaze = mazeService.translate2dCharArrayToString(maze);
        assertThat(stringMaze).isEqualTo("O•OO\nO••O\nOO•O\nOOOO");
    }

}
