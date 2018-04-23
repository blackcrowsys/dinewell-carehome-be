package biz.dinewell.dinewellcarehome.db.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AllergenTest {

    Allergen allergen;

    @Before
    public void setUp() {
        allergen = new Allergen();
    }

    @Test
    public void testGettingAllergen() {
        allergen.setCode("MLK");
        allergen.setName("Milk");
        assertEquals("MLK", allergen.getCode());
        assertEquals("Milk", allergen.getName());
    }

}