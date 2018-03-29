package biz.dinewell.dinewellcarehome.residents.service;

import biz.dinewell.dinewellcarehome.db.entity.Resident;
import biz.dinewell.dinewellcarehome.db.entity.Title;
import biz.dinewell.dinewellcarehome.db.repositories.ResidentRepository;
import biz.dinewell.dinewellcarehome.residents.factory.ResidentDTOFactory;
import biz.dinewell.dinewellcarehome.residents.presentation.ResidentDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
public class ResidentServiceImpl implements ResidentService {

    private final ResidentRepository residentRepository;

    private final ResidentDTOFactory residentDTOFactory;

    public ResidentServiceImpl(ResidentRepository residentRepository, ResidentDTOFactory residentDTOFactory) {
        this.residentRepository = residentRepository;
        this.residentDTOFactory = residentDTOFactory;
    }

    @Override
    public Set<ResidentDTO> getAllResidents() {
        log.debug("Getting list of all Residents");

        Set<ResidentDTO> residentDTOS = new HashSet<>();
        residentRepository.findAll().iterator().forEachRemaining(resident -> residentDTOS.add(residentDTOFactory.generateDTO(resident)));
        return residentDTOS;
    }

    @Override
    public ResponseEntity createNewResident(ResidentDTO residentDTO) {
        log.debug("Persisting a new Resident");

        if (residentDTO.getFirstName() == null || residentDTO.getFirstName().isEmpty() || residentDTO.getTitle() == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        Resident resident = new Resident();
        resident.setFirstName(residentDTO.getFirstName());
        resident.setMiddleName(residentDTO.getMiddleName());
        resident.setLastName(residentDTO.getLastName());
        resident.setTitle(new Title(residentDTO.getTitle().getCode(), residentDTO.getTitle().getName()));

        residentRepository.save(resident);
        return ResponseEntity.status((HttpStatus.CREATED)).build();
    }
}
