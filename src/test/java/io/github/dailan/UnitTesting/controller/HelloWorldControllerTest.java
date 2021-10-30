package io.github.dailan.UnitTesting.controller;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(SpringExtension.class)
@WebMvcTest(HelloWorldController.class)
public class HelloWorldControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void should_be_return_hello_world() throws Exception {
        // PREPAR TO CALL API
        RequestBuilder request = MockMvcRequestBuilders
                .get("/hello-world")
                .accept(MediaType.APPLICATION_JSON);
        // EXECUTE
        MvcResult mvcResult = mockMvc.perform(request).andReturn();

        // VALIDATE RESULT
        assertEquals("Hello World", mvcResult.getResponse().getContentAsString());
    }
}
