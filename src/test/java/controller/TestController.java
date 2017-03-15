package controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Quick test to make sure the Spring boot serve is configured correctly
 */
public class TestController {

    private MockMvc mockMvc;

    @Before
    public void setup(){
        this.mockMvc = standaloneSetup(new FooBarController()).build();
    }

    @Test
    public void testFooBarController() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/foobar"))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("foobar")));
    }

}
