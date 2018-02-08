package biz.dinewell.dinewellcarehome.residents.presentation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResidentListDTO {

    Set<ResidentDTO> residents;
}
