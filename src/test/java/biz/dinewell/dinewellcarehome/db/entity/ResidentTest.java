package biz.dinewell.dinewellcarehome.db.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ResidentTest {

    Resident resident;
    Title title;

    @Before
    public void setUp() throws Exception {
        resident = new Resident();
        title = new Title();
    }

    @Test
    public void getTitle() throws Exception {
        title.setCode("Mr");
        title.setName("Mr");
        resident.setTitle(title);
        assertEquals(title, resident.getTitle());
    }

    @Test
    public void getFirstName() throws Exception {
        String firstName = "John";
        resident.setFirstName(firstName);
        assertEquals(firstName, resident.getFirstName());
    }

    @Test
    public void getMiddleName() throws Exception {
        String middleName = "Middleton";
        resident.setMiddleName(middleName);
        assertEquals(middleName, resident.getMiddleName());
    }

    @Test
    public void getLastName() throws Exception {
        String lastName = "Smith";
        resident.setLastName(lastName);
        assertEquals(lastName, resident.getLastName());
    }

}