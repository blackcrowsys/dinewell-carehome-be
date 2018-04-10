package biz.dinewell.dinewellcarehome.residents.factory;

import biz.dinewell.dinewellcarehome.db.entity.Allergen;
import biz.dinewell.dinewellcarehome.residents.presentation.AllergenDTO;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AllergenDTOFactoryTest {

    @Mock
    private AllergenDTO allergenDTO;

    @Mock
    private Allergen fish;

    @Mock
    private Allergen milk;

    @MockBean
    private AllergenDTOFactory allergenDTOFactory;

    @Before
    public void setUp() {
        fish = new Allergen("FSH", "FISH", null);
        milk = new Allergen("MLK", "Milk", null);
    }

    @Test
    public void testGeneratingAllergenDTO() {
        allergenDTO = allergenDTOFactory.generateDTO(fish);
        assertEquals("FSH", allergenDTO.getCode());
        assertEquals("FISH", allergenDTO.getName());
    }

    @Test
    public void testGettingListOfAllergenDTOs() {
        Set<Allergen> allergens = new HashSet<>(2);
        allergens.add(fish);
        allergens.add(milk);
        List<AllergenDTO> allergenDTOs = allergenDTOFactory.generateDTO(allergens);
        assertEquals(allergenDTOs.size(), 2);
    }

}