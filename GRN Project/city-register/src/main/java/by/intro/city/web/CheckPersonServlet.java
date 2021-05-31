package by.intro.city.web;

import by.intro.city.dao.PersonCheckDao;
import by.intro.city.dao.PoolConnectionBuilder;
import by.intro.city.domain.PersonRequest;
import by.intro.city.domain.PersonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "CheckPersonServlet", urlPatterns = {"/checkPerson"})
public class CheckPersonServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(CheckPersonServlet.class);

    private PersonCheckDao dao;

    @Override
    public void init() throws ServletException {
        logger.info("Servlet is created");
        dao = new PersonCheckDao();
        dao.setConnectionBuilder(new PoolConnectionBuilder());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

//        String surname = req.getParameter("surname");
        PersonRequest pr = new PersonRequest();
        pr.setSurname(req.getParameter("surname"));
        pr.setGivenname(req.getParameter("givenname"));
        pr.setPatronymic(req.getParameter("patronymic"));
        LocalDate dateOfBirth = LocalDate.parse(req.getParameter("dateOfBirth"), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        pr.setDateOfBirth(dateOfBirth);
        pr.setStreetCode(Integer.parseInt(req.getParameter("streetCode")));
        pr.setBuilding(req.getParameter("building"));
        pr.setExtension(req.getParameter("extension"));
        pr.setApartment(req.getParameter("apartment"));

        try {
            PersonResponse ps = dao.checkPerson(pr);
            if (ps.isRegistered()) {
                resp.getWriter().write("Registered");
            } else {
                resp.getWriter().write("Not registered");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
