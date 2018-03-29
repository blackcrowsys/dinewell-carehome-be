package biz.dinewell.dinewellcarehome.residents.factory;

import biz.dinewell.dinewellcarehome.common.WebAPI;
import biz.dinewell.dinewellcarehome.db.entity.Resident;
import biz.dinewell.dinewellcarehome.residents.presentation.ResidentDTO;
import biz.dinewell.dinewellcarehome.residents.presentation.TitleDTO;
import org.springframework.stereotype.Service;

@Service
public class ResidentDTOFactory {

    public static ResidentDTO generateDTO(Resident resident) {
        ResidentDTO dto = new ResidentDTO();
        dto.setId(resident.getId());
        dto.setFirstName(resident.getFirstName());
        dto.setMiddleName(resident.getMiddleName());
        dto.setLastName(resident.getLastName());
        dto.setTitle(new TitleDTO(resident.getTitle().getCode(),resident.getTitle().getName()));
        dto.setUrl(String.format("%s/%s", WebAPI.RESIDENT_API, resident.getId()));
        dto.setResidentAllergenDTOList((resident.getAllergens()));
        return dto;
    }
}