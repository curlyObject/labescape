package controller;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * Controller to submit a maze to be solved
 */
@RestController
@RequestMapping("/api/maze")
public class MazeController {

    @RequestMapping(path = "/solve", method = RequestMethod.GET)
    public @ResponseBody String solveMaze(@RequestParam("maze") String maze,
                                          @RequestParam("startX") int startX,
                                          @RequestParam("startY") int startY){
        return maze;
    }

}
