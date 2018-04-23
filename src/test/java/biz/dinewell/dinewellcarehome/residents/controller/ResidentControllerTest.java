package biz.dinewell.dinewellcarehome.residents.controller;

import biz.dinewell.dinewellcarehome.db.entity.Title;
import biz.dinewell.dinewellcarehome.residents.presentation.ResidentDTO;
import biz.dinewell.dinewellcarehome.residents.presentation.TitleDTO;
import biz.dinewell.dinewellcarehome.residents.service.ResidentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ResidentController.class, secure = false)
public class ResidentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ResidentService residentService;

    private JacksonTester< ResidentDTO > jsonTester;

    @Mock
    private ResidentDTO residentDTO;

    @Mock
    private TitleDTO titleDTO;

    @Before
    public void setUp() {
        JacksonTester.initFields(this, objectMapper);
        titleDTO = new TitleDTO("Mr", "Mr");
        residentDTO = new ResidentDTO("3ba114a6-b88e-4a16-9b39-e7e691e290f0", "Name", "", "Surname", "/resident", titleDTO, null);
    }

    @Test
    public void getListOfResidents() throws Exception {

        Set<ResidentDTO> allResidents = new HashSet<>();
        allResidents.add(residentDTO);

        assertEquals(allResidents.size(), 1);

        when(residentService.getAllResidents()).thenReturn(allResidents);

        mockMvc.perform(get("/api/residents").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id")
                        .value(residentDTO.getId()));
    }

    @Test
    public void createNewResidentIfValid() throws  Exception {
        when(residentService.createNewResident(residentDTO)).thenReturn( ResponseEntity.status(HttpStatus.CREATED).build());

        final String residentDTOToJson = jsonTester.write(residentDTO).getJson();

        mockMvc.perform(post("/api/residents/create").content(residentDTOToJson).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void createNewResidentNotValid() throws  Exception {
        when(residentService.createNewResident(residentDTO)).thenReturn( ResponseEntity.status(HttpStatus.NO_CONTENT).build());

        final String residentDTOToJson = jsonTester.write(residentDTO).getJson();

        mockMvc.perform(post("/api/residents/create").content(residentDTOToJson).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
}