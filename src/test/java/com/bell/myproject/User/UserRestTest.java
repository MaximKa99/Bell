package com.bell.myproject.User;

import com.bell.myproject.view.user.UserFilterView;
import com.bell.myproject.view.user.UserSaveView;
import com.bell.myproject.view.user.UserUpdateView;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
public class UserRestTest implements UserRest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @LocalServerPort
    int serverPort = 8888;

    @Test
    public void GetUserById_IdEqualThree_Success() throws Exception {
        this.mockMvc.perform(get("/api/user/3"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.data.id").value(3))
            .andExpect(jsonPath("$.data.firstName").value("Петр"))
            .andExpect(jsonPath("$.data.secondName").value("Иванович"))
            .andExpect(jsonPath("$.data.middleName").value("Понурый"))
            .andExpect(jsonPath("$.data.position").value("вахтер"))
            .andExpect(jsonPath("$.data.phone").value("8-916-292-74-22"))
            .andExpect(jsonPath("$.data.docName").doesNotExist())
            .andExpect(jsonPath("$.data.docNumber").value(322228))
            .andExpect(jsonPath("$.data.docDate").value("1980-07-09"))
            .andExpect(jsonPath("$.data.citizenshipName").value("Российская Федерация"))
            .andExpect(jsonPath("$.data.citizenshipCode").value(643))
            .andExpect(jsonPath("$.data.isIdentified").value(true));
    }

    @Test
    public void GetUserById_IdEqualTen_NoSuchUserExceptionThrown() throws Exception {
        this.mockMvc.perform(get("/api/user/10"))
            .andDo(print())
            .andExpect(status().isNotFound());
    }

    /*секция для проверки update */

    @Test
    public void UpdateUser_ValidRequest_Success() throws Exception {
        UserUpdateView update = new UserUpdateView();

        update.setId(3);
        update.setFirstName("Петя");
        update.setPosition("Кофенос");

        this.mockMvc.perform(post("/api/user/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(update)))
            .andDo(print())
            .andExpect(status().isOk());
    }

    @Test
    public void UpdateUser_NoValidRequestNoId_NoValidRequestException() throws Exception {
        UserUpdateView update = new UserUpdateView();

        update.setFirstName("Петя");
        update.setPosition("Кофенос");

        this.mockMvc.perform(post("/api/user/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(update)))
            .andDo(print())
            .andExpect(status().isBadRequest());
    }

    @Test
    public void UpdateUser_NoSuchOfficeId_NoSuchOfficeExceptionThrown() throws Exception {
        UserUpdateView update = new UserUpdateView();

        update.setId(1);
        update.setOfficeId(10);
        update.setFirstName("Петя");
        update.setPosition("Кофенос");

        this.mockMvc.perform(post("/api/user/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(update)))
            .andDo(print())
            .andExpect(status().isNotFound());
    }

    @Override
    @Test
    public void UpdateUser_EmptyFirstName_NoValidRequestException() throws Exception {
        UserUpdateView update = new UserUpdateView();

        update.setId(1);
        update.setFirstName("");
        update.setPosition("Кофенос");

        this.mockMvc.perform(post("/api/user/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(update)))
            .andDo(print())
            .andExpect(status().isBadRequest());
    }

    @Override
    @Test
    public void UpdateUser_EmptyPosition_NoValidRequestException() throws Exception {
        UserUpdateView update = new UserUpdateView();

        update.setId(1);
        update.setFirstName("Петя");
        update.setPosition("");

        this.mockMvc.perform(post("/api/user/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(update)))
            .andDo(print())
            .andExpect(status().isBadRequest());
        
    }

    @Override
    @Test
    public void UpdateUser_NoFirstName_NoValidRequestException() throws Exception {
        UserUpdateView update = new UserUpdateView();

        update.setId(1);
        update.setPosition("Кофенос");

        this.mockMvc.perform(post("/api/user/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(update)))
            .andDo(print())
            .andExpect(status().isBadRequest());
        
    }

    @Override
    @Test
    public void UpdateUser_NoPosition_NoValidRequestException() throws Exception {
        UserUpdateView update = new UserUpdateView();

        update.setId(1);
        update.setFirstName("Петя");

        this.mockMvc.perform(post("/api/user/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(update)))
            .andDo(print())
            .andExpect(status().isBadRequest());
    }

    /*секция для проверки save */

    @Test
    public void SaveUser_ValidRequest_Success() throws Exception {
        UserSaveView save = new UserSaveView();

        save.setOfficeId(3);
        save.setFirstName("Петя");
        save.setPosition("Кофенос");

        this.mockMvc.perform(post("/api/user/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(save)))
            .andDo(print())
            .andExpect(status().isOk());
    }

    @Override
    @Test
    public void SaveUser_NoOfficeId_NoValidRequestException() throws Exception {
        UserSaveView save = new UserSaveView();

        save.setFirstName("Петя");
        save.setPosition("Кофенос");

        this.mockMvc.perform(post("/api/user/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(save)))
            .andDo(print())
            .andExpect(status().isBadRequest());
    }

    @Override
    @Test
    public void SaveUser_EmptyOfficeId_NoValidRequestException() throws Exception {
        UserSaveView save = new UserSaveView();

        save.setOfficeId(null);
        save.setFirstName("Петя");
        save.setPosition("Кофенос");

        this.mockMvc.perform(post("/api/user/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(save)))
            .andDo(print())
            .andExpect(status().isBadRequest());
    }

    @Override
    @Test
    public void SaveUser_NoFirstName_NoValidRequestException() throws Exception {
        UserSaveView save = new UserSaveView();

        save.setOfficeId(3);
        save.setPosition("Кофенос");

        this.mockMvc.perform(post("/api/user/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(save)))
            .andDo(print())
            .andExpect(status().isBadRequest());
        
    }

    @Override
    @Test
    public void SaveUser_EmptyFirstName_NoValidRequestException() throws Exception {
        UserSaveView save = new UserSaveView();

        save.setOfficeId(3);
        save.setFirstName("");
        save.setPosition("Кофенос");

        this.mockMvc.perform(post("/api/user/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(save)))
            .andDo(print())
            .andExpect(status().isBadRequest());
        
    }

    @Override
    @Test
    public void SaveUser_EmptyPostion_NoValidRequestException() throws Exception {
        UserSaveView save = new UserSaveView();

        save.setOfficeId(3);
        save.setFirstName("Петя");
        save.setPosition("");

        this.mockMvc.perform(post("/api/user/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(save)))
            .andDo(print())
            .andExpect(status().isBadRequest());
        
    }

    @Override
    @Test
    public void SaveUser_NoPostion_NoValidRequestException() throws Exception {
        UserSaveView save = new UserSaveView();

        save.setOfficeId(3);
        save.setFirstName("Петя");

        this.mockMvc.perform(post("/api/user/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(save)))
            .andDo(print())
            .andExpect(status().isBadRequest());
        
    }

    @Override
    @Test
    public void GetListOfUsers_EmptyOfficeId_NoValidRequestException() throws Exception {
        UserFilterView filter = new UserFilterView();
        filter.setOfficeId(null);

        this.mockMvc.perform(post("/api/user/list")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(filter)))
            .andDo(print())
            .andExpect(status().isBadRequest());
    }

    @Override
    @Test
    public void GetListOfUsers_NoOfficeId_NoValidRequestException() throws Exception {
        UserFilterView filter = new UserFilterView();

        this.mockMvc.perform(post("/api/user/list")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(filter)))
            .andDo(print())
            .andExpect(status().isBadRequest());
    }

    @Override
    @Test
    public void GetListOfUsers_OfficeIdEqualOne_Success() throws Exception {
        UserFilterView filter = new UserFilterView();
        filter.setOfficeId(1);

        this.mockMvc.perform(post("/api/user/list")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(filter)))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.data[0].id").value(1))
            .andExpect(jsonPath("$.data[0].firstName").value("Максим"))
            .andExpect(jsonPath("$.data[0].secondName").value("Валентинович"))
            .andExpect(jsonPath("$.data[0].middleName").value("Походин"))
            .andExpect(jsonPath("$.data[0].position").value("стажер"));
    }
}
