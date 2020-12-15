package com.bell.myproject.Office;

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

import com.bell.myproject.view.office.OfficeFilterView;
import com.bell.myproject.view.office.OfficeSaveView;
import com.bell.myproject.view.office.OfficeUpdateView;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
public class OfficeRestTest implements OfficeRest {
    @LocalServerPort
    int serverPort = 8888;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;

    /* #region секция для проверки получения оффиса по id*/
    @Test
    public void getOfficeById_IdEqualOne_Success() throws Exception {
        this.mockMvc.perform(get("/api/office/1")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.data.id").value(1)).andExpect(jsonPath("$.data.name").value("Президент плаза"))
                .andExpect(jsonPath("$.data.address").value("Кутузовский проспект, 32"))
                .andExpect(jsonPath("$.data.phone").value("8 (495) 208-63-30"))
                .andExpect(jsonPath("$.data.isActive").value(true));
    }

    @Test
    public void getOfficeById_NoSuchOffice_NoSuchExceptionThrown() throws Exception {
        this.mockMvc.perform(get("/api/office/15")).andDo(print()).andExpect(status().isNotFound());
    }
    /* #endregion */

    /* #region секция для проверки update у оффиса */
    @Test
    public void updateOfficeById_IdEqualTwo_Success() throws Exception {
        OfficeUpdateView update = new OfficeUpdateView();

        update.setId(2);
        update.setAddress("Питер");
        update.setName("БЦ Тест");

        this.mockMvc.perform(post("/api/office/update").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(update))).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void updateOfficeById_WithIncorrectId_NoSuchOfficeExceptionThrown() throws Exception {
        OfficeUpdateView update = new OfficeUpdateView();

        update.setId(8);
        update.setAddress("Питер");
        update.setName("БЦ Тест");

        this.mockMvc
                .perform(post("/api/office/update").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(update)))
                .andDo(print()).andExpect(status().isNotFound());
    }

    @Test
    public void updateOfficeById_EmptyAddress_NoValidRequestExceptionThrown() throws Exception {
        OfficeUpdateView update = new OfficeUpdateView();

        update.setId(1);
        update.setAddress("");
        update.setName("БЦ Тест");

        this.mockMvc
                .perform(post("/api/office/update").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(update)))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void updateOfficeById_EmptyName_NoValidRequestExceptionThrown() throws Exception {
        OfficeUpdateView update = new OfficeUpdateView();

        update.setId(1);
        update.setAddress("Питер");
        update.setName("");

        this.mockMvc
                .perform(post("/api/office/update").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(update)))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void updateOfficeById_NoAddress_NoValidRequestExceptionThrown() throws Exception {
        OfficeUpdateView update = new OfficeUpdateView();

        update.setId(1);
        update.setName("БЦ Тест");

        this.mockMvc
                .perform(post("/api/office/update").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(update)))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void updateOfficeById_NoName_NoValidRequestExceptionThrown() throws Exception {
        OfficeUpdateView update = new OfficeUpdateView();

        update.setId(1);
        update.setAddress("Питер");

        this.mockMvc
                .perform(post("/api/office/update").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(update)))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void updateOfficeById_NoValidRequest_NoValidRequestExceptionThrown() throws Exception {
        OfficeUpdateView update = new OfficeUpdateView();

        this.mockMvc
                .perform(post("/api/office/update").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(update)))
                .andDo(print()).andExpect(status().isBadRequest());
    }
    /* #endregion */

    /* #region секция для проверки save у оффиса */
    @Test
    public void saveOfficeById_CorrectRequest_Success() throws Exception {
        OfficeSaveView save = new OfficeSaveView();

        save.setOrgId(3);

        this.mockMvc.perform(post("/api/office/save").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(save))).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void saveOfficeById_WithIncorrectId_NoSuchOrganizationExceptionThrown() throws Exception {
        OfficeSaveView save = new OfficeSaveView();

        save.setOrgId(8);

        this.mockMvc
                .perform(post("/api/office/save").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(save)))
                .andDo(print()).andExpect(status().isNotFound());
    }

    @Test
    public void saveOfficeById_NoValidRequest_NoValidRequestExceptionThrown() throws Exception {
        OfficeSaveView save = new OfficeSaveView();

        this.mockMvc
                .perform(post("/api/office/save").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(save)))
                .andDo(print()).andExpect(status().isBadRequest());
    }
    /* #endregion */

    /* #region секция для проверки получения списка по фильтру */
    @Test
    public void getListOfOffices_ValidRequestOrgIdEqualTwo_Success() throws Exception {
        OfficeFilterView filter = new OfficeFilterView();

        filter.setOrgId(2);

        this.mockMvc
                .perform(post("/api/office/list").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(filter)))
                .andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.data[1]").doesNotExist())
                .andExpect(jsonPath("$.data[0].id").value(2))
                .andExpect(jsonPath("$.data[0].name").value("Здание штаб-квартиры «Газпрома»"))
                .andExpect(jsonPath("$.data[0].isActive").value(true));
    }

    @Test
    public void getListOfOffices_ValidRequestOrgIdEqualTwoAndNameIsEmpty_Success() throws Exception {
        OfficeFilterView filter = new OfficeFilterView();

        filter.setOrgId(2);
        filter.setName("");

        this.mockMvc
                .perform(post("/api/office/list").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(filter)))
                .andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.data[1]").doesNotExist())
                .andExpect(jsonPath("$.data[0].id").value(2))
                .andExpect(jsonPath("$.data[0].name").value("Здание штаб-квартиры «Газпрома»"))
                .andExpect(jsonPath("$.data[0].isActive").value(true));
    }

    @Test
    public void getListOfOffices_ValidRequestOrgIdEqualTwoAndNameIsEmptyAndPhoneEqualSeven_Success() throws Exception {
        OfficeFilterView filter = new OfficeFilterView();

        filter.setPhone("7");
        filter.setOrgId(2);
        filter.setName("");

        this.mockMvc
                .perform(post("/api/office/list").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(filter)))
                .andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.data[1]").doesNotExist())
                .andExpect(jsonPath("$.data[0].id").value(2))
                .andExpect(jsonPath("$.data[0].name").value("Здание штаб-квартиры «Газпрома»"))
                .andExpect(jsonPath("$.data[0].isActive").value(true));
    }

    @Test
    public void getListOfOffices_ValidRequestNoSuchOrgId_Success() throws Exception {
        OfficeFilterView filter = new OfficeFilterView();

        filter.setOrgId(14);

        this.mockMvc
                .perform(post("/api/office/list").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(filter)))
                .andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.data").isEmpty());
    }
    /* #endregion */
}
