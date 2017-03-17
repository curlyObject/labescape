package main.controller;

import io.restassured.RestAssured;
import main.Main;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {
        Main.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class E2ETest {

    @LocalServerPort
    private int port;

    @Before
    public void setUp(){
        RestAssured.port = port;
    }

    @Test
    public void sendMaze(){
        String maze = "O OOO  OOO OOOOO";
        String mazeSolved = "O•OO\nO••O\nOO•O\nOOOO";
        int startX = 2, startY = 2, mazeWidth = 4;
        when()
                .get("/api/maze/solve?maze="+maze+"&mazeWidth="+mazeWidth+"&startX="+startX+"&startY="+startY)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(is(mazeSolved));
    }

}
