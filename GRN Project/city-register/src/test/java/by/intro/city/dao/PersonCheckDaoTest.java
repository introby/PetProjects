package by.intro.city.dao;

import by.intro.city.domain.PersonRequest;
import by.intro.city.domain.PersonResponse;
import by.intro.city.exception.PersonCheckException;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class PersonCheckDaoTest {

    @Test
    public void checkPerson() throws PersonCheckException {
        PersonRequest pr = new PersonRequest();
        pr.setSurname("васильев");
        pr.setGivenname("Павел");
        pr.setPatronymic("Николаевич");
        pr.setDateOfBirth(LocalDate.of(1995, 3, 18));
        pr.setStreetCode(1);
        pr.setBuilding("10");
        pr.setExtension("2");
        pr.setApartment("121");

        PersonCheckDao dao = new PersonCheckDao();
        dao.setConnectionBuilder(new DirectConnectionBuilder());
        PersonResponse ps = dao.checkPerson(pr);
        Assert.assertTrue(ps.isRegistered());
        Assert.assertFalse(ps.isTemporal());
    }

    @Test
    public void checkPerson2() throws PersonCheckException {
        PersonRequest pr = new PersonRequest();
        pr.setSurname("Васильева");
        pr.setGivenname("Ирина");
        pr.setPatronymic("Петровна");
        pr.setDateOfBirth(LocalDate.of(1997, 8, 21));
        pr.setStreetCode(1);
        pr.setBuilding("10");
        pr.setExtension("2");
        pr.setApartment("121");

        PersonCheckDao dao = new PersonCheckDao();
        dao.setConnectionBuilder(new DirectConnectionBuilder());
        PersonResponse ps = dao.checkPerson(pr);
        Assert.assertTrue(ps.isRegistered());
        Assert.assertFalse(ps.isTemporal());
    }
}