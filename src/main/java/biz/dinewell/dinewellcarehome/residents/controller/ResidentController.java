package biz.dinewell.dinewellcarehome.residents.controller;

import biz.dinewell.dinewellcarehome.common.WebAPI;
import biz.dinewell.dinewellcarehome.residents.presentation.ResidentDTO;
import biz.dinewell.dinewellcarehome.residents.presentation.ResidentListDTO;
import biz.dinewell.dinewellcarehome.residents.service.ResidentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = WebAPI.RESIDENT_API)
public class ResidentController {

    private final ResidentService residentService;

    public ResidentController(ResidentService residentService) {
        this.residentService = residentService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Set<ResidentDTO> getResidentList() {
        return residentService.getAllResidents();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity newResident(@RequestBody ResidentDTO residentDTO) {
        return residentService.createNewResident(residentDTO);
    }
}