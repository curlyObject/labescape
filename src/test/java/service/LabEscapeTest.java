package service;

import exceptions.IllegalStartPositionException;
import exceptions.NoEscapeException;
import org.assertj.core.data.Index;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LabEscapeTest {

    @Test
    public void testEscape_OneWayOut_Simple() throws Exception{
        char[][] maze = {   new char[]{'O', ' ', 'O', 'O'},
                            new char[]{'O', ' ', ' ', 'O'},
                            new char[]{'O', 'O', ' ', 'O'},
                            new char[]{'O', 'O', 'O', 'O'}};
        int startX = 2, startY = 2;
        char[][] mazeWithEscape = LabEscape.drawPathForEscape(maze, startX, startY);

        assertThat(mazeWithEscape)
                .hasSize(4)
                .contains(new char[]{'O', '•', 'O', 'O'}, Index.atIndex(0))
                .contains(new char[]{'O', '•', '•', 'O'}, Index.atIndex(1))
                .contains(new char[]{'O', 'O', '•', 'O'}, Index.atIndex(2))
                .contains(new char[]{'O', 'O', 'O', 'O'}, Index.atIndex(3));

    }

    @Test
    public void testEscape_OneWayOut_OnTheEdge() throws Exception{
        char[][] maze = {   new char[]{'O', ' ', 'O', 'O'},
                            new char[]{'O', ' ', ' ', 'O'},
                            new char[]{'O', 'O', ' ', 'O'},
                            new char[]{'O', 'O', 'O', 'O'}};
        int startX = 1, startY = 0;
        char[][] mazeWithEscape = LabEscape.drawPathForEscape(maze, startX, startY);

        assertThat(mazeWithEscape)
                .hasSize(4)
                .contains(new char[]{'O', '•', 'O', 'O'}, Index.atIndex(0))
                .contains(new char[]{'O', ' ', ' ', 'O'}, Index.atIndex(1))
                .contains(new char[]{'O', 'O', ' ', 'O'}, Index.atIndex(2))
                .contains(new char[]{'O', 'O', 'O', 'O'}, Index.atIndex(3));

    }

    @Test
    public void testEscape_TwoWaysOut_BothShortest() throws Exception{
        char[][] maze = {   new char[]{'O', ' ', 'O', 'O'},
                            new char[]{'O', ' ', ' ', 'O'},
                            new char[]{'O', 'O', ' ', ' '},
                            new char[]{'O', 'O', 'O', 'O'}};
        int startX = 2, startY = 1;
        char[][] mazeWithEscape = LabEscape.drawPathForEscape(maze, startX, startY);

        assertThat(mazeWithEscape)
                .hasSize(4)
                .contains(new char[]{'O', ' ', 'O', 'O'}, Index.atIndex(0))
                .contains(new char[]{'O', ' ', '•', 'O'}, Index.atIndex(1))
                .contains(new char[]{'O', 'O', '•', '•'}, Index.atIndex(2))
                .contains(new char[]{'O', 'O', 'O', 'O'}, Index.atIndex(3));

    }

    @Test
    public void testEscape_TwoWaysOut_OneShortest() throws Exception{
        char[][] maze = {   new char[]{'O', ' ', 'O', 'O'},
                            new char[]{'O', ' ', ' ', 'O'},
                            new char[]{'O', 'O', ' ', ' '},
                            new char[]{'O', 'O', 'O', 'O'}};
        int startX = 1, startY = 1;
        char[][] mazeWithEscape = LabEscape.drawPathForEscape(maze, startX, startY);

        assertThat(mazeWithEscape)
                .hasSize(4)
                .contains(new char[]{'O', '•', 'O', 'O'}, Index.atIndex(0))
                .contains(new char[]{'O', '•', ' ', 'O'}, Index.atIndex(1))
                .contains(new char[]{'O', 'O', ' ', ' '}, Index.atIndex(2))
                .contains(new char[]{'O', 'O', 'O', 'O'}, Index.atIndex(3));

    }



    @Test
    public void testEscape_OneWayOut_Complex() throws Exception{
        char[][] maze = {   new char[]{'O', 'O', 'O', 'O', 'O', 'O'},
                            new char[]{'O', ' ', ' ', 'O', ' ', ' '},
                            new char[]{'O', 'O', ' ', ' ', ' ', 'O'},
                            new char[]{'O', 'O', ' ', 'O', 'O', 'O'},
                            new char[]{'O', ' ', ' ', 'O', ' ', 'O'},
                            new char[]{'O', 'O', 'O', 'O', ' ', ' '}};
        int startX = 1, startY = 4;
        char[][] mazeWithEscape = LabEscape.drawPathForEscape(maze, startX, startY);

        assertThat(mazeWithEscape)
                .hasSize(6)
                .contains(new char[]{'O', 'O', 'O', 'O', 'O', 'O'}, Index.atIndex(0))
                .contains(new char[]{'O', ' ', ' ', 'O', '•', '•'}, Index.atIndex(1))
                .contains(new char[]{'O', 'O', '•', '•', '•', 'O'}, Index.atIndex(2))
                .contains(new char[]{'O', 'O', '•', 'O', 'O', 'O'}, Index.atIndex(3))
                .contains(new char[]{'O', '•', '•', 'O', ' ', 'O'}, Index.atIndex(4))
                .contains(new char[]{'O', 'O', 'O', 'O', ' ', ' '}, Index.atIndex(5));
    }

    @Test
    public void testEscape_OneWayOut_Complex_Rectangle() throws Exception{
        char[][] maze = {   new char[]{'O', 'O', 'O', 'O', 'O', 'O'},
                            new char[]{'O', ' ', ' ', 'O', ' ', ' '},
                            new char[]{'O', 'O', ' ', ' ', ' ', 'O'},
                            new char[]{'O', 'O', ' ', 'O', 'O', 'O'},
                            new char[]{'O', ' ', ' ', 'O', ' ', 'O'},
                            new char[]{'O', ' ', ' ', 'O', ' ', 'O'},
                            new char[]{'O', ' ', ' ', 'O', ' ', 'O'},
                            new char[]{'O', 'O', 'O', 'O', ' ', ' '}};
        int startX = 1, startY = 6;
        char[][] mazeWithEscape = LabEscape.drawPathForEscape(maze, startX, startY);

        assertThat(mazeWithEscape)
                .hasSize(4)
                .contains(new char[]{'O', 'O', 'O', 'O', 'O', 'O'}, Index.atIndex(0))
                .contains(new char[]{'O', ' ', ' ', 'O', '•', '•'}, Index.atIndex(1))
                .contains(new char[]{'O', 'O', '•', '•', '•', 'O'}, Index.atIndex(2))
                .contains(new char[]{'O', 'O', '•', 'O', 'O', 'O'}, Index.atIndex(3))
                .contains(new char[]{'O', '•', '•', 'O', ' ', 'O'}, Index.atIndex(4))
                .contains(new char[]{'O', 'O', 'O', 'O', ' ', ' '}, Index.atIndex(5));
    }

    @Test
    public void testEscape_OneWayOut_Complex_Rectangle_OneShorterThanTheOtherEscape() throws Exception{
        char[][] maze = {   new char[]{'O', 'O', 'O', 'O', 'O', 'O'},
                            new char[]{'O', ' ', ' ', 'O', ' ', '0'},
                            new char[]{'O', 'O', ' ', ' ', ' ', 'O'},
                            new char[]{'O', 'O', ' ', 'O', ' ', 'O'},
                            new char[]{'O', ' ', ' ', 'O', ' ', 'O'},
                            new char[]{'O', ' ', '0', 'O', ' ', 'O'},
                            new char[]{'O', ' ', ' ', ' ', ' ', 'O'},
                            new char[]{'O', 'O', 'O', 'O', ' ', ' '}};
        int startX = 1, startY = 6;
        char[][] mazeWithEscape = LabEscape.drawPathForEscape(maze, startX, startY);

        assertThat(mazeWithEscape)
                .hasSize(8)
                .contains(new char[]{'O', 'O', 'O', 'O', 'O', 'O'}, Index.atIndex(0))
                .contains(new char[]{'O', ' ', ' ', 'O', '•', '•'}, Index.atIndex(1))
                .contains(new char[]{'O', 'O', '•', '•', '•', 'O'}, Index.atIndex(2))
                .contains(new char[]{'O', 'O', '•', 'O', 'O', 'O'}, Index.atIndex(3))
                .contains(new char[]{'O', '•', '•', 'O', ' ', 'O'}, Index.atIndex(4))
                .contains(new char[]{'O', 'O', 'O', 'O', ' ', ' '}, Index.atIndex(5));
    }

    @Test
    public void testEscape_OneWayOut_Complex_Rectangle_MulitpleEscapeROutes_OneShorterThanTheOthers() throws Exception{
        char[][] maze = {   new char[]{'O', 'O', 'O', 'O', 'O', 'O'},
                            new char[]{'O', ' ', ' ', 'O', ' ', ' '},
                            new char[]{'O', 'O', ' ', ' ', ' ', 'O'},
                            new char[]{'O', 'O', ' ', 'O', ' ', 'O'},
                            new char[]{'O', ' ', ' ', 'O', ' ', 'O'},
                            new char[]{'O', ' ', '0', 'O', ' ', 'O'},
                            new char[]{'O', ' ', ' ', ' ', ' ', 'O'},
                            new char[]{'O', 'O', 'O', 'O', ' ', ' '}};
        int startX = 1, startY = 6;
        char[][] mazeWithEscape = LabEscape.drawPathForEscape(maze, startX, startY);

        assertThat(mazeWithEscape)
                .hasSize(8)
                .contains(new char[]{'O', 'O', 'O', 'O', 'O', 'O'}, Index.atIndex(0))
                .contains(new char[]{'O', ' ', ' ', 'O', '•', '•'}, Index.atIndex(1))
                .contains(new char[]{'O', 'O', '•', '•', '•', 'O'}, Index.atIndex(2))
                .contains(new char[]{'O', 'O', '•', 'O', 'O', 'O'}, Index.atIndex(3))
                .contains(new char[]{'O', '•', '•', 'O', ' ', 'O'}, Index.atIndex(4))
                .contains(new char[]{'O', 'O', 'O', 'O', ' ', ' '}, Index.atIndex(5));
    }

    @Test(expected = IllegalStartPositionException.class)
    public void testEscape_IllegalX() throws Exception{
        char[][] maze = {   new char[]{'O', 'O', 'O', 'O'},
                            new char[]{'O', ' ', ' ', 'O'},
                            new char[]{'O', 'O', ' ', 'O'},
                            new char[]{'O', 'O', 'O', 'O'}};
        int startX = 0, startY = 2;
        LabEscape.drawPathForEscape(maze, startX, startY);
    }

    @Test(expected = IllegalStartPositionException.class)
    public void testEscape_IllegalY() throws Exception{
        char[][] maze = {   new char[]{'O', 'O', 'O', 'O'},
                            new char[]{'O', ' ', ' ', 'O'},
                            new char[]{'O', 'O', ' ', 'O'},
                            new char[]{'O', 'O', 'O', 'O'}};
        int startX = 2, startY = 0;
        LabEscape.drawPathForEscape(maze, startX, startY);
    }

    @Test(expected = IllegalStartPositionException.class)
    public void testEscape_IllegalY_Outside() throws Exception{
        char[][] maze = {   new char[]{'O', 'O', 'O', 'O'},
                            new char[]{'O', ' ', ' ', 'O'},
                            new char[]{'O', 'O', ' ', 'O'},
                            new char[]{'O', 'O', 'O', 'O'}};
        int startX = 7, startY = 0;
        LabEscape.drawPathForEscape(maze, startX, startY);
    }

    @Test(expected = IllegalStartPositionException.class)
    public void testEscape_IllegalX_Outside() throws Exception{
        char[][] maze = {   new char[]{'O', 'O', 'O', 'O'},
                            new char[]{'O', ' ', ' ', 'O'},
                            new char[]{'O', 'O', ' ', 'O'},
                            new char[]{'O', 'O', 'O', 'O'}};
        int startX = 2, startY = 9;
        LabEscape.drawPathForEscape(maze, startX, startY);
    }

    @Test(expected = NoEscapeException.class)
    public void testEscape_NoWayOut_Simple() throws Exception{
        char[][] maze = {   new char[]{'O', 'O', 'O', 'O'},
                            new char[]{'O', ' ', ' ', 'O'},
                            new char[]{'O', 'O', ' ', 'O'},
                            new char[]{'O', 'O', 'O', 'O'}};
        int startX = 2, startY = 2;
        LabEscape.drawPathForEscape(maze, startX, startY);

    }

    @Test(expected = NoEscapeException.class)
    public void testEscape_NoWayOut_Complex() throws Exception{
        char[][] maze = {   new char[]{'O', 'O', 'O', 'O', 'O', 'O'},
                            new char[]{'O', ' ', ' ', 'O', ' ', ' '},
                            new char[]{'O', 'O', ' ', ' ', 'O', 'O'},
                            new char[]{'O', ' ', ' ', 'O', 'O', 'O'},
                            new char[]{'O', ' ', ' ', 'O', ' ', 'O'},
                            new char[]{'O', 'O', 'O', 'O', ' ', ' '}};
        int startX = 3, startY = 2;
        LabEscape.drawPathForEscape(maze, startX, startY);
    }

}
