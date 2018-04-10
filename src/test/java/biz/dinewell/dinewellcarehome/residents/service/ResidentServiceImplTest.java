package biz.dinewell.dinewellcarehome.residents.service;

import biz.dinewell.dinewellcarehome.db.entity.Resident;
import biz.dinewell.dinewellcarehome.db.entity.Title;
import biz.dinewell.dinewellcarehome.db.repositories.ResidentRepository;
import biz.dinewell.dinewellcarehome.residents.factory.ResidentDTOFactory;
import biz.dinewell.dinewellcarehome.residents.presentation.ResidentDTO;
import biz.dinewell.dinewellcarehome.residents.presentation.TitleDTO;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ResidentServiceImplTest {

    @InjectMocks
    private ResidentServiceImpl residentService;

    @Mock
    private ResidentRepository residentRepository;

    @Mock
    private ResidentDTOFactory residentDTOFactory;

    @Mock
    private Resident resident;

    @Mock
    private ResidentDTO residentDTO;

    @Mock
    private Title title;

    @Mock
    private TitleDTO titleDTO;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        residentService = new ResidentServiceImpl(residentRepository, residentDTOFactory);
        resident = new Resident();
        title = new Title();
        title.setName("Mr");
        title.setCode("Mr");
        resident.setTitle(title);
        resident.setFirstName("John");
        resident.setMiddleName("Michael");
        resident.setLastName("Smith");
    }

    @Test
    public void getAllResidents() throws Exception {
        Set<ResidentDTO> residentData = new HashSet<>();
        residentData.add(residentDTOFactory.generateDTO(resident));
        when(residentService.getAllResidents()).thenReturn(residentData);
        Set<ResidentDTO> residents = residentService.getAllResidents();

        assertEquals(residents.size(), 1);

        verify(residentRepository, times(1)).findAll();
    }

    @Test
    public void createNewResidentWhenResidentIsValid() throws Exception {
        residentDTO = new ResidentDTO();
        residentDTO.setFirstName("John");
        titleDTO = new TitleDTO();
        titleDTO.setCode("Mr");
        titleDTO.setName("Mr");
        residentDTO.setTitle(titleDTO);

        assertEquals("John", residentDTO.getFirstName());
        assertEquals("Mr", residentDTO.getTitle().getCode());
        assertEquals(ResponseEntity.status(HttpStatus.CREATED).build(), residentService.createNewResident(residentDTO));
    }

    @Test
    public void createNewResidentWhenFirstNameIsEmpty() throws  Exception {
        residentDTO.setTitle(titleDTO);
        residentDTO.setFirstName("");
        assertEquals(ResponseEntity.status(HttpStatus.NO_CONTENT).build(), residentService.createNewResident(residentDTO));
        resident = new Resident("", "John",  "Smith", new Title("Mr", "Mr"), null);

        verify(residentRepository, times(0)).save(resident);
    }

    @Test
    public void createNewResidentWhenFirstNameIsNull() throws  Exception {
        residentDTO.setTitle(titleDTO);
        assertEquals(ResponseEntity.status(HttpStatus.NO_CONTENT).build(), residentService.createNewResident(residentDTO));
        resident = new Resident(null, "John", "Smith", new Title("Mr", "Mr"), null);
        verify(residentRepository, times(0)).save(resident);
    }

    @Test
    public void createNewResidentWhenTitleIsNull() throws  Exception {
        residentDTO.setFirstName("John");
        assertEquals(ResponseEntity.status(HttpStatus.NO_CONTENT).build(), residentService.createNewResident(residentDTO));
        resident = new Resident( "John", "Jack", "Smith", null, null);
        verify(residentRepository, times(0)).save(resident);
    }

}