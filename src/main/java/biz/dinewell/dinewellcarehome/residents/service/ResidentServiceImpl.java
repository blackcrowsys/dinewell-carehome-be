package biz.dinewell.dinewellcarehome.residents.service;

import biz.dinewell.dinewellcarehome.db.repositories.ResidentRepository;
import biz.dinewell.dinewellcarehome.residents.factory.ResidentFactory;
import biz.dinewell.dinewellcarehome.residents.presentation.ResidentDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
public class ResidentServiceImpl implements ResidentService {

    private final ResidentRepository residentRepository;

    private final ResidentFactory residentFactory;

    public ResidentServiceImpl(ResidentRepository residentRepository, ResidentFactory residentFactory) {
        this.residentRepository = residentRepository;
        this.residentFactory = residentFactory;
    }

    @Override
    public Set<ResidentDTO> getAllResidents() {
        log.debug("Getting list of all Residents");

        Set<ResidentDTO> residentDTOS = new HashSet<>();
        residentRepository.findAll().iterator().forEachRemaining(resident -> residentDTOS.add(residentFactory.generateDTO(resident)));
        return residentDTOS;
    }
}
