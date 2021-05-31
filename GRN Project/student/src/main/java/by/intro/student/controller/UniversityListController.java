package by.intro.student.controller;

import by.intro.student.domain.University;
import by.intro.student.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping(path = "/universityList")
public class UniversityListController {

    @Autowired
    private UniversityService service;

//    @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public String findUniversities(Model model) {
        List<University> list = service.findUniversities();
        model.addAttribute("today", LocalDate.now().format(DateTimeFormatter.ISO_DATE));
        model.addAttribute("universities", list);
        return "universityList";
    }
}
