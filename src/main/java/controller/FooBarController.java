package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Endpoint to poke
 */
@RestController
@RequestMapping("/api/foobar")
public class FooBarController {

    @RequestMapping(method = RequestMethod.GET)
    public String get() {
        return "foobar";
    }

}
