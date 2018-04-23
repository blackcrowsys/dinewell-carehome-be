package biz.dinewell.dinewellcarehome.residents.service;

import biz.dinewell.dinewellcarehome.residents.presentation.ResidentDTO;

import java.util.Set;

public interface ResidentService {

    Set<ResidentDTO> getAllResidents();
}
