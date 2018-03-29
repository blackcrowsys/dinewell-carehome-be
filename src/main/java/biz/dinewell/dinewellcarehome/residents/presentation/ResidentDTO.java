package biz.dinewell.dinewellcarehome.residents.presentation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResidentDTO {

    private String id;

    private String firstName;

    private String middleName;

    private String lastName;

    private String url;

    private TitleDTO title;

    private List<ResidentAllergenDTO> residentAllergenDTOList;
}
