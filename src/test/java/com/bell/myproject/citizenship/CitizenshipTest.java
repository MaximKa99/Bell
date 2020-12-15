package com.bell.myproject.citizenship;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CitizenshipTest implements Citizenship {
    @Autowired
    private MockMvc mockMvc;
    @Override
    @Test
    public void getCitizenship_ValidRequest_Success() throws Exception {
        this.mockMvc.perform(post("/api/countries"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.data[1]").doesNotExist())
            .andExpect(jsonPath("$.data[0].code").value(643))
            .andExpect(jsonPath("$.data[0].name").value("Российская Федерация"));
    }
}
