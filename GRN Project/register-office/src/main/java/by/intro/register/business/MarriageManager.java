package by.intro.register.business;

import by.intro.register.dao.MarriageDao;
import by.intro.register.dao.PersonDao;
import by.intro.register.domain.MarriageCertificate;
import by.intro.register.domain.Person;
import by.intro.register.domain.PersonFemale;
import by.intro.register.domain.PersonMale;
import by.intro.register.view.MarriageRequest;
import by.intro.register.view.MarriageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service(value = "marriageService")
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class MarriageManager {

    @Autowired
    private MarriageDao marriageDao;
    @Autowired
    private PersonDao personDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(MarriageManager.class);


    @Transactional
    public MarriageResponse findMarriageCertificate(MarriageRequest request) {

        LOGGER.info("findMarriageCertificate called");

        personDao.addPerson(getPerson(1));
        personDao.addPerson(getPerson(2));

        MarriageCertificate mc = getMarriageCertificate();
        marriageDao.saveAndFlush(mc);

//        marriageDao.findAll();

        List<MarriageCertificate> list = marriageDao.findByNumber("12345");
        list.forEach(m -> LOGGER.info("MC:{}", m.getMarriageCertificateId()));
        LOGGER.info("------------>>>>>>>>>>>>>");

        List<MarriageCertificate> list2 = marriageDao.findByNum("98765");
        list2.forEach(m -> LOGGER.info("MC:{}", m.getMarriageCertificateId()));
        LOGGER.info("------------>>>>>>>>>>>>>");

        List<MarriageCertificate> list3 = marriageDao.findSomething("01928");
        list3.forEach(m -> LOGGER.info("MC:{}", m.getMarriageCertificateId()));


        return new MarriageResponse();
    }

    private MarriageCertificate getMarriageCertificate() {
        MarriageCertificate mc = new MarriageCertificate();
        mc.setIssueDate(LocalDate.now());
        mc.setNumber("01928");
        mc.setActive(true);

        List<Person> persons = personDao.findPersons();
        for (Person person : persons) {
            if (person instanceof PersonMale) {
                mc.setHusband((PersonMale) person);
            } else {
                mc.setWife((PersonFemale) person);
            }
        }
        return mc;
    }

    private Person getPerson(int sex) {
        Person m = sex == 1 ? new PersonFemale() : new PersonMale();
        m.setFirstName("1_" + sex);
        m.setLastName("2_" + sex);
        m.setPatronymic("3_" + sex);
        m.setDateOfBirth(LocalDate.of(1991, 2, 4));
        return m;
    }

}
