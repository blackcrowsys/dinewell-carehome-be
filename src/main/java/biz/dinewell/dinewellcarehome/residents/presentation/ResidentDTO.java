package biz.dinewell.dinewellcarehome.residents.presentation;

import biz.dinewell.dinewellcarehome.db.entity.Title;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
