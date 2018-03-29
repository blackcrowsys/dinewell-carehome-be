package biz.dinewell.dinewellcarehome.residents.factory;

import biz.dinewell.dinewellcarehome.db.entity.Allergen;
import biz.dinewell.dinewellcarehome.residents.presentation.AllergenDTO;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AllergenDTOFactoryTest {

    @Mock
    private AllergenDTO allergenDTO;

    @Mock
    private Allergen allergen;

    @MockBean
    private AllergenDTOFactory allergenDTOFactory;

    @Test
    public void generatingAllergenDTO() {
        allergen = new Allergen("Mr", "Mr");
        allergenDTO = allergenDTOFactory.generateDTO(allergen);

        assertEquals("Mr", allergenDTO.getCode());
        assertEquals("Mr", allergenDTO.getName());
    }

}