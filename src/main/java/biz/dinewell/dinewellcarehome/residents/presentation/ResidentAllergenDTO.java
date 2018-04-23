package biz.dinewell.dinewellcarehome.residents.presentation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResidentAllergenDTO {

    private String id;

    private String allergenCode;

    private String allergenName;
}
