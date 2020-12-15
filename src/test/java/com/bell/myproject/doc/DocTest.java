package com.bell.myproject.doc;

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
public class DocTest implements Doc{
    @Autowired
    private MockMvc mockMvc;
    
    @Override
    @Test
    public void GetDocs_ValidRequest_Success() throws Exception {
        this.mockMvc.perform(post("/api/docs"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.data[13]").doesNotExist())
            .andExpect(jsonPath("$.data[0].code").value(3))
            .andExpect(jsonPath("$.data[0].name").value("Свидетельство о рождении"))
            .andExpect(jsonPath("$.data[1].code").value(7))
            .andExpect(jsonPath("$.data[1].name").value("Военный билет "))
            .andExpect(jsonPath("$.data[2].code").value(8))
            .andExpect(jsonPath("$.data[2].name").value("Временное удостоверение, выданное взамен военного билета"))
            .andExpect(jsonPath("$.data[3].code").value(10))
            .andExpect(jsonPath("$.data[3].name").value("Паспорт иностранного гражданина"))
            .andExpect(jsonPath("$.data[4].code").value(11))
            .andExpect(jsonPath("$.data[4].name").value("Свидетельство о рассмотрении ходатайства о признании лица беженцем на территории Российской Федерации по существу"))
            .andExpect(jsonPath("$.data[5].code").value(12))
            .andExpect(jsonPath("$.data[5].name").value("Вид на жительство в Российской Федерации"))
            .andExpect(jsonPath("$.data[6].code").value(13))
            .andExpect(jsonPath("$.data[6].name").value("Удостоверение беженца"))
            .andExpect(jsonPath("$.data[7].code").value(15))
            .andExpect(jsonPath("$.data[7].name").value("Разрешение на временное проживание в Российской Федерации"))
            .andExpect(jsonPath("$.data[8].code").value(18))
            .andExpect(jsonPath("$.data[8].name").value("Свидетельство о предоставлении временного убежища на территории Российской Федерации"))
            .andExpect(jsonPath("$.data[9].code").value(21))
            .andExpect(jsonPath("$.data[9].name").value("Паспорт гражданина Российской Федерации"))
            .andExpect(jsonPath("$.data[10].code").value(23))
            .andExpect(jsonPath("$.data[10].name").value("Свидетельство о рождении, выданное уполномоченным органом иностранного государства"))
            .andExpect(jsonPath("$.data[11].code").value(24))
            .andExpect(jsonPath("$.data[11].name").value("Удостоверение личности военнослужащего Российской Федерации"))
            .andExpect(jsonPath("$.data[12].code").value(91))
            .andExpect(jsonPath("$.data[12].name").value("Иные документы"));
    }
}
