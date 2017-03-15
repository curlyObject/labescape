package controller;

import exceptions.NoEscapeException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import service.MazeService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class MazeControllerTest {

    private MockMvc mockMvc;

    private MazeService mazeServiceMock = Mockito.mock(MazeService.class);

    private ArgumentCaptor<String> mazeCaptor;
    private ArgumentCaptor<Integer> xCaptor;
    private ArgumentCaptor<Integer> yCaptor;

    @Before
    public void setup(){
        this.mockMvc = standaloneSetup(new MazeController(mazeServiceMock)).build();
        reset(mazeServiceMock);

        mazeCaptor = ArgumentCaptor.forClass(String.class);
        xCaptor = ArgumentCaptor.forClass(Integer.class);
        yCaptor = ArgumentCaptor.forClass(Integer.class);
    }

    @Test
    public void testMazeController_Solve() throws Exception {
        String maze = "0 000\n0  0\n00 0\n0000";
        int startX = 1, startY = 2;
        when(mazeServiceMock.solveMaze(maze, startX, startY)).thenReturn(new char[][]{});

        mockMvc.perform(MockMvcRequestBuilders.get("/api/maze/solve?maze="+maze+"&startX="+startX+"&startY="+startY))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("0 000\n0  0\n00 0\n0000")));

        verify(mazeServiceMock, times(1)).solveMaze(mazeCaptor.capture(), xCaptor.capture(), yCaptor.capture());
        verifyNoMoreInteractions(mazeServiceMock);

        assertThat(mazeCaptor.getValue())
                .isNotEmpty()
                .isEqualTo(maze);
        assertThat(xCaptor.getValue()).isEqualTo(startX);
        assertThat(yCaptor.getValue()).isEqualTo(startY);
    }

    @Test
    public void testMazeController_Solve_NoEscape() throws Exception {
        String maze = "0 000\n0  0\n00 0\n0000";
        int startX = 1, startY = 2;
        when(mazeServiceMock.solveMaze(maze, startX, startY)).thenThrow(NoEscapeException.class);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/maze/solve?maze="+maze+"&startX="+startX+"&startY="+startY))
                .andExpect(status().is(UNPROCESSABLE_ENTITY.value()));

    }

    @Test
    public void testMazeController_Solve_NoMaze() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/maze/solve?startX=1&startY=2"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testMazeController_Solve_NoStartX() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/maze/solve?maze=0 000\n0  0\n00 0\n0000&startY=2"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testMazeController_Solve_NoStartY() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/maze/solve?maze=0 000\n0  0\n00 0\n0000&startX=1"))
                .andExpect(status().isBadRequest());
    }

}
