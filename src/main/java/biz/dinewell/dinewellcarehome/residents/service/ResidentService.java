package biz.dinewell.dinewellcarehome.residents.service;

import biz.dinewell.dinewellcarehome.residents.presentation.ResidentDTO;
import org.springframework.http.ResponseEntity;

import java.util.Set;

public interface ResidentService {

    Set<ResidentDTO> getAllResidents();

    ResponseEntity createNewResident(ResidentDTO residentDTO);
}
