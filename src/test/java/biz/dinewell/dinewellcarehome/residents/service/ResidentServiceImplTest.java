package biz.dinewell.dinewellcarehome.residents.service;

import biz.dinewell.dinewellcarehome.db.entity.Resident;
import biz.dinewell.dinewellcarehome.db.repositories.ResidentRepository;
import biz.dinewell.dinewellcarehome.residents.factory.ResidentFactory;
import biz.dinewell.dinewellcarehome.residents.presentation.ResidentDTO;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ResidentServiceImplTest {

    ResidentServiceImpl residentService;

    @Mock
    ResidentRepository residentRepository;

    @Mock
    ResidentFactory residentFactory;

    @Mock
    Resident resident;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        residentService = new ResidentServiceImpl(residentRepository, residentFactory);
    }

    @Test
    public void getAllResidents() throws Exception {

        resident = new Resident();
        Set<ResidentDTO> residentData = new HashSet<>();
        residentData.add(residentFactory.generateDTO(resident));

        when(residentService.getAllResidents()).thenReturn(residentData);

        Set<ResidentDTO> residents = residentService.getAllResidents();

        assertEquals(residents.size(), 1);

        verify(residentRepository, times(1)).findAll();
    }

}