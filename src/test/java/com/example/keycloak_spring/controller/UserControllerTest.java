package com.example.keycloak_spring.controller;

import net.minidev.json.JSONObject;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Order(1)
    void registerUser() throws Exception {
        JSONObject userJson = getUserJson();
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/user/registerUser")
                .contentType(MediaType.APPLICATION_JSON)
                .content(userJson.toJSONString());
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    private JSONObject getUserJson() {
        JSONObject userJson = new JSONObject();
        userJson.put("firstname", "farzad");
        userJson.put("lastname", "afshar");
        userJson.put("username", "farzadafi");
        userJson.put("email", "farzadafi40@gmail.com");
        userJson.put("password", "aA1!aaaaa");
        userJson.put("meliCode", "1234567890");
        return userJson;
    }

    @Test
    @Order(2)
    void removeUser() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/user/removeUser?username=farzadafi")
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }
}