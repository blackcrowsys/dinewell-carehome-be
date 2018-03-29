package biz.dinewell.dinewellcarehome.residents.factory;

import biz.dinewell.dinewellcarehome.db.entity.Allergen;
import biz.dinewell.dinewellcarehome.residents.presentation.AllergenDTO;

public class AllergenDTOFactory {
    public static AllergenDTO generateDTO(Allergen allergen) {
        return new AllergenDTO(allergen.getCode(), allergen.getName());
    }
}
