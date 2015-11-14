package com.hexad.controller;

import com.hexad.configurations.RootConfig;
import com.hexad.configurations.WebConfig;
import com.hexad.configurations.WebInitializer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;


/**
 * Created by sureshshamanna on 14/11/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={WebInitializer.class,RootConfig.class,WebConfig.class})
@WebAppConfiguration
public class WelcomeControllerTest {

private MockMvc mockMvc;

   @Autowired
   WebApplicationContext webApplicationContext;


    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

    }


    @Test
    public void welcomeTest() throws Exception
    {

        Map<String, Object> model = new HashMap<>();
        model.put("name","shyamala");
        mockMvc.perform(MockMvcRequestBuilders.get("/welcome"))
                .andExpect(status().isOk())
                .andExpect(view().name("welcome"))
                .andExpect(forwardedUrl("/WEB-INF/views/jsp/welcome.jsp"))
                .andExpect(model().attribute("name", "shyamala"));


   }


}