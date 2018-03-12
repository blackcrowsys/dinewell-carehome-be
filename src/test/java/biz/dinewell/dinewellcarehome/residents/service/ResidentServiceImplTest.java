package biz.dinewell.dinewellcarehome.residents.service;

import biz.dinewell.dinewellcarehome.db.entity.Resident;
import biz.dinewell.dinewellcarehome.db.entity.Title;
import biz.dinewell.dinewellcarehome.db.repositories.ResidentRepository;
import biz.dinewell.dinewellcarehome.residents.factory.ResidentFactory;
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
    private ResidentFactory residentFactory;

    @Mock
    private Resident resident;

    @Mock
    private ResidentDTO residentDTO;

    @Mock
    private
    Title title;

    @Mock
    private TitleDTO titleDTO;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        residentService = new ResidentServiceImpl(residentRepository, residentFactory);
    }

    @Test
    public void getAllResidents() throws Exception {
        Set<ResidentDTO> residentData = new HashSet<>();
        residentData.add(residentFactory.generateDTO(resident));
        when(residentService.getAllResidents()).thenReturn(residentData);
        Set<ResidentDTO> residents = residentService.getAllResidents();

        assertEquals(residents.size(), 1);

        verify(residentRepository, times(1)).findAll();
    }

    @Test
    public void createNewResidentWhenResidentIsValid() throws Exception {
        residentDTO = new ResidentDTO();
        residentDTO.setFirstName("Bob");

        titleDTO = new TitleDTO();
        titleDTO.setCode("Mr");
        titleDTO.setName("Mr");

        residentDTO.setTitle(titleDTO);

        assertEquals("Bob", residentDTO.getFirstName());
        assertEquals("Mr", residentDTO.getTitle().getCode());
        assertEquals(ResponseEntity.status(HttpStatus.CREATED).build(), residentService.createNewResident(residentDTO));
    }

    @Test
    public void createNewResidentWhenFirstNameIsNull() throws  Exception {
        resident.setTitle(title);
        residentDTO.setTitle(titleDTO);
        assertEquals(residentService.createNewResident(residentDTO), ResponseEntity.status(HttpStatus.NO_CONTENT).build());

        verify(residentRepository, times(0)).save(resident);
    }

    @Test
    public void createNewResidentWhenTitleIsNull() throws  Exception {
        residentDTO.setFirstName("Bob");
        resident.setFirstName("Bob");
        assertEquals(residentService.createNewResident(residentDTO), ResponseEntity.status(HttpStatus.NO_CONTENT).build());

        verify(residentRepository, times(0)).save(resident);
    }

}