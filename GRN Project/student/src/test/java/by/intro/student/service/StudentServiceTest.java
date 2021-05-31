package by.intro.student.service;

import by.intro.student.rest.Controller;
import by.intro.student.view.StudentRequest;
import by.intro.student.view.StudentResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:springContext.xml"})
public class StudentServiceTest {

    public static final Logger LOGGER = LoggerFactory.getLogger("StudentServiceTest.class");


    @Autowired
    private Controller controller;

    @Test
    public void studentInfo() {

        StudentRequest request = new StudentRequest();
        request.setFirstName("First");
        request.setLastName("Last");
        request.setMiddleName("Middle");
        request.setDateOfBirth(LocalDate.of(1995, 10,24));
        request.setPassportSeries("series");
        request.setPassportNumber("number");
        request.setPassportDate(LocalDate.of(1996, 12, 10));

        List<StudentResponse> info = controller.getStudentInfo(request);

        Assert.assertTrue(info.size() > 0);
    }

}