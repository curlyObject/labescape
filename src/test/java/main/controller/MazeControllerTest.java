package main.controller;

import main.exceptions.IllegalMazeShapeException;
import main.exceptions.IllegalStartPositionException;
import main.exceptions.NoEscapeException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import main.service.MazeService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.*;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class MazeControllerTest {

    private MockMvc mockMvc;

    private MazeService mazeServiceMock = Mockito.mock(MazeService.class);

    @Captor
    private ArgumentCaptor<String> mazeCaptor;

    @Captor
    private ArgumentCaptor<Integer> mazeWidthCaptor;

    @Captor
    private ArgumentCaptor<Integer> xCaptor;

    @Captor
    private ArgumentCaptor<Integer> yCaptor;

    @Before
    public void setup(){
        this.mockMvc = standaloneSetup(new MazeController(mazeServiceMock)).build();
        reset(mazeServiceMock);

        mazeCaptor = ArgumentCaptor.forClass(String.class);
        mazeWidthCaptor = ArgumentCaptor.forClass(Integer.class);
        xCaptor = ArgumentCaptor.forClass(Integer.class);
        yCaptor = ArgumentCaptor.forClass(Integer.class);
    }

    @Test
    public void testMazeController_Solve() throws Exception {
        String maze = "O OOO  OOO OOOOO";
        int startX = 1, startY = 2, mazeWidth = 4;
        when(mazeServiceMock.solveMaze(maze, mazeWidth, startX, startY)).thenReturn("O•OO\nO••O\nOO•O\nOOOO");

        mockMvc.perform(MockMvcRequestBuilders.get("/api/maze/solve?maze="+maze+"&mazeWidth="+mazeWidth+"&startX="+startX+"&startY="+startY))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("O•OO\nO••O\nOO•O\nOOOO")));

        verify(mazeServiceMock, times(1)).solveMaze(mazeCaptor.capture(), mazeWidthCaptor.capture(), xCaptor.capture(), yCaptor.capture());
        verifyNoMoreInteractions(mazeServiceMock);

        assertThat(mazeCaptor.getValue())
                .isNotEmpty()
                .isEqualTo(maze);
        assertThat(mazeWidthCaptor.getValue()).isEqualTo(mazeWidth);
        assertThat(xCaptor.getValue()).isEqualTo(startX);
        assertThat(yCaptor.getValue()).isEqualTo(startY);
    }

    @Test
    public void testMazeController_Solve_NoEscape() throws Exception {
        String maze = "O OOO  OOO OOOOO";
        int startX = 1, startY = 2, mazeWidth = 4;
        when(mazeServiceMock.solveMaze(maze, mazeWidth, startX, startY)).thenThrow(NoEscapeException.class);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/maze/solve?maze="+maze+"&mazeWidth="+mazeWidth+"&startX="+startX+"&startY="+startY))
                .andExpect(status().is(UNPROCESSABLE_ENTITY.value()));

    }

    @Test
    public void testMazeController_Solve_IllegalStart() throws Exception {
        String maze = "O OOO  OOO OOOOO";
        int startX = 1, startY = 2, mazeWidth = 4;
        when(mazeServiceMock.solveMaze(maze, mazeWidth, startX, startY)).thenThrow(IllegalStartPositionException.class);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/maze/solve?maze="+maze+"&mazeWidth="+mazeWidth+"&startX="+startX+"&startY="+startY))
                .andExpect(status().is(BAD_REQUEST.value()));

    }

    @Test
    public void testMazeController_Solve_IllegalMaze() throws Exception {
        String maze = "O OOO  OOO OOOOO";
        int startX = 1, startY = 2, mazeWidth = 4;
        when(mazeServiceMock.solveMaze(maze, mazeWidth, startX, startY)).thenThrow(IllegalMazeShapeException.class);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/maze/solve?maze="+maze+"&mazeWidth="+mazeWidth+"&startX="+startX+"&startY="+startY))
                .andExpect(status().is(BAD_REQUEST.value()));

    }

    @Test
    public void testMazeController_Solve_NoMaze() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/maze/solve?mazeWidth=4&startX=1&startY=2"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testMazeController_Solve_NoMazeWidth() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/maze/solve?maze=O OOO  OOO OOOOO&startX=1&startY=2"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testMazeController_Solve_NoStartX() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/maze/solve?maze=O OOO  OOO OOOOO&mazeWidth=4&startY=2"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testMazeController_Solve_NoStartY() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/maze/solve?maze=O OOO  OOO OOOOO&mazeWidth=4&startX=1"))
                .andExpect(status().isBadRequest());
    }

}
