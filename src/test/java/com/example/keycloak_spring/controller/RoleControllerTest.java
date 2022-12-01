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

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RoleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void addRole() throws Exception {
        JSONObject roleJson = new JSONObject();
        roleJson.put("name", "admin");
        roleJson.put("description", "admin");
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/role/addRole")
                .contentType(MediaType.APPLICATION_JSON)
                .content(roleJson.toJSONString());
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Disabled
    @Test
    void getAllRole() {
    }

    @Disabled
    @Test
    void removeRole() {
    }
}