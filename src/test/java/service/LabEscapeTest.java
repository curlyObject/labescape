package service;

import exceptions.NoEscapeException;
import org.assertj.core.data.Index;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LabEscapeTest {

    @Test
    public void testEscape_OneWayOut_Simple() throws NoEscapeException{
        char[][] maze = {   new char[]{'O', ' ', 'O', 'O'},
                            new char[]{'O', ' ', ' ', 'O'},
                            new char[]{'O', 'O', ' ', 'O'},
                            new char[]{'O', 'O', 'O', 'O'}};
        int startX = 2, startY = 2;
        char[][] mazeWithEscape = LabEscape.drawPathForEscape(maze, startX, startY);

        assertThat(mazeWithEscape)
                .hasSize(4)
                .contains(new char[]{'O', '.', 'O', 'O'}, Index.atIndex(0))
                .contains(new char[]{'O', '.', '.', 'O'}, Index.atIndex(1))
                .contains(new char[]{'O', 'O', '.', 'O'}, Index.atIndex(2))
                .contains(new char[]{'O', 'O', 'O', 'O'}, Index.atIndex(3));

    }

    @Test
    public void testEscape_OneWayOut_OnTheEdge() throws NoEscapeException{
        char[][] maze = {   new char[]{'O', ' ', 'O', 'O'},
                            new char[]{'O', ' ', ' ', 'O'},
                            new char[]{'O', 'O', ' ', 'O'},
                            new char[]{'O', 'O', 'O', 'O'}};
        int startX = 1, startY = 0;
        char[][] mazeWithEscape = LabEscape.drawPathForEscape(maze, startX, startY);

        assertThat(mazeWithEscape)
                .hasSize(4)
                .contains(new char[]{'O', '.', 'O', 'O'}, Index.atIndex(0))
                .contains(new char[]{'O', ' ', ' ', 'O'}, Index.atIndex(1))
                .contains(new char[]{'O', 'O', ' ', 'O'}, Index.atIndex(2))
                .contains(new char[]{'O', 'O', 'O', 'O'}, Index.atIndex(3));

    }

    @Test
    public void testEscape_TwoWaysOut_BothShortest() throws NoEscapeException{
        char[][] maze = {   new char[]{'O', ' ', 'O', 'O'},
                            new char[]{'O', ' ', ' ', 'O'},
                            new char[]{'O', 'O', ' ', ' '},
                            new char[]{'O', 'O', 'O', 'O'}};
        int startX = 2, startY = 1;
        char[][] mazeWithEscape = LabEscape.drawPathForEscape(maze, startX, startY);

        assertThat(mazeWithEscape)
                .hasSize(4)
                .contains(new char[]{'O', ' ', 'O', 'O'}, Index.atIndex(0))
                .contains(new char[]{'O', ' ', '.', 'O'}, Index.atIndex(1))
                .contains(new char[]{'O', 'O', '.', '.'}, Index.atIndex(2))
                .contains(new char[]{'O', 'O', 'O', 'O'}, Index.atIndex(3));

    }

    @Test
    public void testEscape_TwoWaysOut_OneShortest() throws NoEscapeException{
        char[][] maze = {   new char[]{'O', ' ', 'O', 'O'},
                            new char[]{'O', ' ', ' ', 'O'},
                            new char[]{'O', 'O', ' ', ' '},
                            new char[]{'O', 'O', 'O', 'O'}};
        int startX = 1, startY = 1;
        char[][] mazeWithEscape = LabEscape.drawPathForEscape(maze, startX, startY);

        assertThat(mazeWithEscape)
                .hasSize(4)
                .contains(new char[]{'O', '.', 'O', 'O'}, Index.atIndex(0))
                .contains(new char[]{'O', '.', ' ', 'O'}, Index.atIndex(1))
                .contains(new char[]{'O', 'O', ' ', ' '}, Index.atIndex(2))
                .contains(new char[]{'O', 'O', 'O', 'O'}, Index.atIndex(3));

    }



    @Test
    public void testEscape_OneWayOut_Complex() throws NoEscapeException{
        char[][] maze = {   new char[]{'O', 'O', 'O', 'O', 'O', 'O'},
                            new char[]{'O', ' ', ' ', 'O', ' ', ' '},
                            new char[]{'O', 'O', ' ', ' ', ' ', 'O'},
                            new char[]{'O', 'O', ' ', 'O', 'O', 'O'},
                            new char[]{'O', ' ', ' ', 'O', ' ', 'O'},
                            new char[]{'O', 'O', 'O', 'O', ' ', ' '}};
        int startX = 1, startY = 4;
        char[][] mazeWithEscape = LabEscape.drawPathForEscape(maze, startX, startY);

        assertThat(mazeWithEscape)
                .hasSize(4)
                .contains(new char[]{'O', 'O', 'O', 'O', 'O', 'O'}, Index.atIndex(0))
                .contains(new char[]{'O', ' ', ' ', 'O', '.', '.'}, Index.atIndex(1))
                .contains(new char[]{'O', 'O', '.', '.', '.', 'O'}, Index.atIndex(2))
                .contains(new char[]{'O', 'O', '.', 'O', 'O', 'O'}, Index.atIndex(3))
                .contains(new char[]{'O', '.', '.', 'O', ' ', 'O'}, Index.atIndex(4))
                .contains(new char[]{'O', 'O', 'O', 'O', ' ', ' '}, Index.atIndex(5));
    }

    @Test(expected = NoEscapeException.class)
    public void testEscape_NoWayOut_Simple() throws NoEscapeException{
        char[][] maze = {   new char[]{'O', 'O', 'O', 'O'},
                            new char[]{'O', ' ', ' ', 'O'},
                            new char[]{'O', 'O', ' ', 'O'},
                            new char[]{'O', 'O', 'O', 'O'}};
        int startX = 2, startY = 2;
        LabEscape.drawPathForEscape(maze, startX, startY);

    }

    @Test(expected = NoEscapeException.class)
    public void testEscape_NoWayOut_Complex() throws NoEscapeException{
        char[][] maze = {   new char[]{'O', 'O', 'O', 'O', 'O', 'O'},
                            new char[]{'O', ' ', ' ', 'O', ' ', ' '},
                            new char[]{'O', 'O', ' ', ' ', 'O', 'O'},
                            new char[]{'O', 'O', ' ', 'O', 'O', 'O'},
                            new char[]{'O', ' ', ' ', 'O', ' ', 'O'},
                            new char[]{'O', 'O', 'O', 'O', ' ', ' '}};
        int startX = 3, startY = 2;
        LabEscape.drawPathForEscape(maze, startX, startY);
    }

}
