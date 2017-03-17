package controller;

import exceptions.IllegalStartPositionException;
import exceptions.NoEscapeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.MazeService;

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

    @RequestMapping(path = "/solve", method = RequestMethod.GET)
    public @ResponseBody String solveMaze(@RequestParam("maze") String maze,
                                          @RequestParam("startX") int startX,
                                          @RequestParam("startY") int startY) throws NoEscapeException, IllegalStartPositionException {
        mazeService.solveMaze(maze, startX, startY);
        return maze;
    }

}
