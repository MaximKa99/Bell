package com.bell.myproject.Organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.bell.myproject.view.organization.OrganizationFilterView;
import com.bell.myproject.view.organization.OrganizationSaveView;
import com.bell.myproject.view.organization.OrganizationUpdateView;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class OrganizationRestTest implements OrganizationRest {
    @LocalServerPort
    int serverPort = 8888;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;

    /* #region тесты для проверки получения организации по id */
    @Test
    public void GetOrganizationById_IdEqualsOne_Success() throws Exception {
        this.mockMvc.perform(get("/api/organization/1")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.data.id").value(1)).andExpect(jsonPath("$.data.fullName").value("ПАО СБЕРБАНК"))
                .andExpect(jsonPath("$.data.name").value("sberbank"))
                .andExpect(jsonPath("$.data.inn").value("780204893183"))
                .andExpect(jsonPath("$.data.kpp").value("771443001"))
                .andExpect(jsonPath("$.data.address").value("Moscow"))
                .andExpect(jsonPath("$.data.phone").value("8-916-292-45-87"))
                .andExpect(jsonPath("$.data.isActive").value(true));
    }

    @Test
    public void GetOrganizationById_IdEqualsOneHundred_NoSuchOrganizationExceptionThrown() throws Exception {
        this.mockMvc.perform(get("/api/organization/100")).andDo(print()).andExpect(status().isNotFound());
    }
    /* #endregion */

    /* #region тесты для проверки получения списка организаций с учетом фильтра */
    @Test
    public void GetListOfOrganization_FilterNameEqual_S_Success() throws Exception {
        OrganizationFilterView filter = new OrganizationFilterView("s", null, null);
        this.mockMvc
                .perform(post("/api/organization/list").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(filter)))
                .andExpect(status().isOk()).andExpect(jsonPath("$.data[0].id").value(1))
                .andExpect(jsonPath("$.data[2]").doesNotExist())
                .andExpect(jsonPath("$.data[0].name").value("sberbank"))
                .andExpect(jsonPath("$.data[0].isActive").value(true)).andExpect(jsonPath("$.data[1].id").value(3))
                .andExpect(jsonPath("$.data[1].name").value("rosneft"))
                .andExpect(jsonPath("$.data[1].isActive").value(true));
    }

    @Test
    public void GetListOfOrganization_LengthOfInnEqual13_BadRequest() throws Exception {
        OrganizationFilterView filter = new OrganizationFilterView("s", "1111111111111", null);
        this.mockMvc
                .perform(post("/api/organization/list").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(filter)))
                .andDo(print()).andExpect(status().isBadRequest());
    }
    /* #endregion */

    /* #region проверка update секции у организаций */
    @Test
    public void UpdateOrganization_WithSomeValues_Success() throws Exception {
        OrganizationUpdateView update = new OrganizationUpdateView();
        update.setId(4);
        update.setName("рога и копыта");
        update.setFullName("ООО Рога и Копыта");
        update.setInn("780204893181");
        update.setKpp("771443002");
        update.setAddress("Москва");

        this.mockMvc.perform(post("/api/organization/update").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(update))).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void UpdateOrganization_NoSuchOrgId_NoSuchExceptionThrown() throws Exception {
        OrganizationUpdateView update = new OrganizationUpdateView();
        update.setId(17);
        update.setName("рога и копыта");
        update.setFullName("ООО Рога и Копыта");
        update.setInn("780204893181");
        update.setKpp("771443002");
        update.setAddress("Москва");

        this.mockMvc
                .perform(post("/api/organization/update").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(update)))
                .andDo(print()).andExpect(status().isNotFound());
    }

    @Test
    public void UpdateOrganization_IncorrectLenghtOfInn_NoValidExceptionThrown() throws Exception {
        OrganizationUpdateView update = new OrganizationUpdateView();
        update.setId(1);
        update.setName("рога и копыта");
        update.setFullName("ООО Рога и Копыта");
        update.setInn("1");
        update.setKpp("771443002");
        update.setAddress("Москва");

        this.mockMvc
                .perform(post("/api/organization/update").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(update)))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void UpdateOrganization_IncorrectLenghtOfKpp_NoValidExceptionThrown() throws Exception {
        OrganizationUpdateView update = new OrganizationUpdateView();
        update.setId(4);
        update.setName("рога и копыта");
        update.setFullName("ООО Рога и Копыта");
        update.setInn("780204893181");
        update.setKpp("77144300211111111111");
        update.setAddress("Москва");

        this.mockMvc
                .perform(post("/api/organization/update").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(update)))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void UpdateOrganization_NoKpp_NoValidExceptionThrown() throws Exception {
        OrganizationUpdateView update = new OrganizationUpdateView();
        update.setId(4);
        update.setName("рога и копыта");
        update.setFullName("ООО Рога и Копыта");
        update.setInn("780204893181");
        update.setAddress("Москва");

        this.mockMvc
                .perform(post("/api/organization/update").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(update)))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void UpdateOrganization_EmptyName_NoValidExceptionThrown() throws Exception {
        OrganizationUpdateView update = new OrganizationUpdateView();
        update.setId(4);
        update.setName("");
        update.setFullName("ООО Рога и Копыта");
        update.setInn("780204893181");
        update.setKpp("771443002");
        update.setAddress("Москва");

        this.mockMvc
                .perform(post("/api/organization/update").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(update)))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void UpdateOrganization_NoInn_NoValidExceptionThrown() throws Exception {
        OrganizationUpdateView update = new OrganizationUpdateView();
        update.setId(4);
        update.setName("рога и копыта");
        update.setFullName("ООО Рога и Копыта");
        update.setKpp("771443002");
        update.setAddress("Москва");

        this.mockMvc
                .perform(post("/api/organization/update").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(update)))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void UpdateOrganization_NoName_NoValidExceptionThrown() throws Exception {
        OrganizationUpdateView update = new OrganizationUpdateView();
        update.setId(4);
        update.setFullName("ООО Рога и Копыта");
        update.setInn("780204893181");
        update.setKpp("771443002");
        update.setAddress("Москва");

        this.mockMvc
                .perform(post("/api/organization/update").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(update)))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void UpdateOrganization_NoAddress_NoValidExceptionThrown() throws Exception {
        OrganizationUpdateView update = new OrganizationUpdateView();
        update.setId(4);
        update.setName("рога и копыта");
        update.setFullName("ООО Рога и Копыта");
        update.setInn("780204893181");
        update.setKpp("771443002");

        this.mockMvc
                .perform(post("/api/organization/update").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(update)))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void UpdateOrganization_NoFullName_NoValidExceptionThrown() throws Exception {
        OrganizationUpdateView update = new OrganizationUpdateView();
        update.setId(4);
        update.setName("рога и копыта");
        update.setInn("780204893181");
        update.setKpp("771443002");
        update.setAddress("Москва");

        this.mockMvc
                .perform(post("/api/organization/update").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(update)))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void UpdateOrganization_NoId_NoValidExceptionThrown() throws Exception {
        OrganizationUpdateView update = new OrganizationUpdateView();
        update.setName("рога и копыта");
        update.setFullName("ООО Рога и Копыта");
        update.setInn("1");
        update.setKpp("771443002");
        update.setAddress("Москва");

        this.mockMvc
                .perform(post("/api/organization/update").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(update)))
                .andDo(print()).andExpect(status().isBadRequest());
    }
    /* #endregion */

    /* #region проверка save секции для организации*/
    @Test
    public void SaveOrganization_CorrectRequest_Success() throws Exception {
        OrganizationSaveView save = new OrganizationSaveView();
        save.setName("рога и копыта");
        save.setFullName("ООО Рога и Копыта");
        save.setInn("780204893181");
        save.setKpp("771443002");
        save.setAddress("Москва");

        this.mockMvc.perform(post("/api/organization/save").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(save))).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void SaveOrganization_NoName_NoValidExceptionThrown() throws Exception {
        OrganizationSaveView save = new OrganizationSaveView();
        save.setFullName("ООО Рога и Копыта");
        save.setInn("780204893181");
        save.setKpp("771443002");
        save.setAddress("Москва");

        this.mockMvc
                .perform(post("/api/organization/save").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(save)))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void SaveOrganization_NoFulName_NoValidExceptionThrown() throws Exception {
        OrganizationSaveView save = new OrganizationSaveView();
        save.setName("qwe");
        save.setInn("780204893181");
        save.setKpp("771443002");
        save.setAddress("Москва");

        this.mockMvc
                .perform(post("/api/organization/save").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(save)))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void SaveOrganization_NoAdress_NoValidExceptionThrown() throws Exception {
        OrganizationSaveView save = new OrganizationSaveView();
        save.setName("qwe");
        save.setFullName("ООО Рога и Копыта");
        save.setInn("780204893181");
        save.setKpp("771443002");

        this.mockMvc
                .perform(post("/api/organization/save").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(save)))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void SaveOrganization_EmptyName_NoValidExceptionThrown() throws Exception {
        OrganizationSaveView save = new OrganizationSaveView();
        save.setName("");
        save.setFullName("ООО Рога и Копыта");
        save.setInn("780204893181");
        save.setKpp("7714430021");
        save.setAddress("Москва");

        this.mockMvc
                .perform(post("/api/organization/save").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(save)))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void SaveOrganization_EmptyFullName_NoValidExceptionThrown() throws Exception {
        OrganizationSaveView save = new OrganizationSaveView();
        save.setName("рога и копыта");
        save.setFullName("");
        save.setInn("780204893181");
        save.setKpp("7714430021");
        save.setAddress("Москва");

        this.mockMvc
                .perform(post("/api/organization/save").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(save)))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void SaveOrganization_EmptyAddress_NoValidExceptionThrown() throws Exception {
        OrganizationSaveView save = new OrganizationSaveView();
        save.setName("рога и копыта");
        save.setFullName("ООО Рога и Копыта");
        save.setInn("780204893181");
        save.setKpp("7714430021");
        save.setAddress("");

        this.mockMvc
                .perform(post("/api/organization/save").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(save)))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void SaveOrganization_IncorrectLenghtOfKpp_NoValidExceptionThrown() throws Exception {
        OrganizationSaveView save = new OrganizationSaveView();
        save.setName("рога и копыта");
        save.setFullName("ООО Рога и Копыта");
        save.setInn("780204893181");
        save.setKpp("7714430021");
        save.setAddress("Москва");

        this.mockMvc
                .perform(post("/api/organization/save").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(save)))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void SaveOrganization_IncorrectLenghtOfInn_Success() throws Exception {
        OrganizationSaveView save = new OrganizationSaveView();
        save.setName("рога и копыта");
        save.setFullName("ООО Рога и Копыта");
        save.setInn("177");
        save.setKpp("771443002");
        save.setAddress("Москва");

        this.mockMvc
                .perform(post("/api/organization/save").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(save)))
                .andDo(print()).andExpect(status().isBadRequest());
    }
    /* #endregion */
}
