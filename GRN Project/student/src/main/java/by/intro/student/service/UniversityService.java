package by.intro.student.service;

import by.intro.student.dao.FacultyRepository;
import by.intro.student.dao.UniversityRepository;
import by.intro.student.domain.Faculty;
import by.intro.student.domain.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UniversityService {

    @Autowired
    private UniversityRepository universityRepository;

    @Autowired
    private FacultyRepository facultyRepository;

    @Transactional(readOnly = true)
    public List<University> findUniversities() {
        return universityRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Faculty> findFaculties() {
        return facultyRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Faculty getFaculty(Long facultyId) {
        Optional<Faculty> fop = facultyRepository.findById(facultyId);
        return fop.get();
    }
}
