package biz.dinewell.dinewellcarehome.residents.factory;

import biz.dinewell.dinewellcarehome.db.entity.Allergen;
import biz.dinewell.dinewellcarehome.residents.presentation.AllergenDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class AllergenDTOFactory {
    public static AllergenDTO generateDTO(Allergen allergen) {
        return new AllergenDTO(allergen.getCode(), allergen.getName());
    }

    public static List<AllergenDTO> generateDTO(Set<Allergen> allergens) {
        List<AllergenDTO> allergenDTOS = new ArrayList<>();
        allergens.stream().forEach(allergen -> {
            allergenDTOS.add(generateDTO(allergen));
        });
        return allergenDTOS;
    }
}
