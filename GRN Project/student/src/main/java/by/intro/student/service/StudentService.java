package by.intro.student.service;

import by.intro.student.dao.StudentRepository;
import by.intro.student.domain.Student;
import by.intro.student.domain.StudentDocument;
import by.intro.student.view.StudentRequest;
import by.intro.student.view.StudentResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    public static final Logger LOGGER = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    private StudentRepository studentRepository;

    @Transactional
    public List<StudentResponse> getStudentInfo(StudentRequest request) {

        List<Student> student = studentRepository.findStudent(request.getLastName(),
                request.getFirstName(),
                request.getMiddleName(),
                request.getDateOfBirth(),
                request.getPassportSeries(),
                request.getPassportNumber(),
                request.getPassportDate());

        if (student.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        List<StudentDocument> docs = student.get(0).getDocuments();
        List<StudentResponse> result = docs.stream().map(d -> getResponse(d)).collect(Collectors.toList());

        return result;
    }

    public StudentResponse getResponse(StudentDocument doc) {
        StudentResponse sr = new StudentResponse();
        sr.setDocumentNumber(doc.getDocumentNumber());
        sr.setDocumentDate(doc.getDocumentDate());
        sr.setExpiredDate(doc.getExpiredDate());
        sr.setFacultyName(doc.getFaculty().getFacultyName());
        sr.setUniversityName(doc.getFaculty().getUniversity().getUniversityName());
        sr.setStudentForm(doc.getStudentForm().toString());

        return sr;
    }
}
