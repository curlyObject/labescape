package main.controller;

import main.exceptions.IllegalMazeShapeException;
import main.exceptions.IllegalStartPositionException;
import main.exceptions.NoEscapeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import main.service.MazeService;

/**
 * Controller to submit a maze to be solved
 */
@RestController
@RequestMapping("/api/maze")
public class MazeController {

    private final MazeService mazeService;

    @Autowired
    public MazeController(MazeService mazeService) {
        this.mazeService = mazeService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(path = "/solve", method = RequestMethod.GET, produces={MediaType.APPLICATION_JSON_UTF8_VALUE})
    public @ResponseBody String solveMaze(@RequestParam("maze") String maze,
                                          @RequestParam("mazeWidth") int mazeWidth,
                                          @RequestParam("startX") int startX,
                                          @RequestParam("startY") int startY) throws NoEscapeException, IllegalStartPositionException, IllegalMazeShapeException {
        return mazeService.solveMaze(maze, mazeWidth, startX, startY);
    }

}
