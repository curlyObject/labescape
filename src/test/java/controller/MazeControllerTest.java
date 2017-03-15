package controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import service.MazeService;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class MazeControllerTest {

    private MockMvc mockMvc;

    private MazeService mazeServiceMock = Mockito.mock(MazeService.class);

    @Before
    public void setup(){
        this.mockMvc = standaloneSetup(new MazeController(mazeServiceMock)).build();
    }

    @Test
    public void testMazeController_Solve() throws Exception {
        String maze = "0 000\n0  0\n00 0\n0000";
        int startX = 1, startY = 2;
        when(mazeServiceMock.solveMaze(maze, startX, startY)).thenReturn(new char[][]{});

        mockMvc.perform(MockMvcRequestBuilders.get("/api/maze/solve?maze="+maze+"&startX="+startX+"&startY="+startY))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("0 000\n0  0\n00 0\n0000")));
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
