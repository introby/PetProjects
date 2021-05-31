package by.intro.city.web;

import by.intro.city.dao.PersonCheckDao;
import by.intro.city.dao.PoolConnectionBuilder;
import by.intro.city.domain.PersonRequest;
import by.intro.city.domain.PersonResponse;
import by.intro.city.exception.PersonCheckException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/check")
@Singleton
public class CheckPersonService {

    private static final Logger logger = LoggerFactory.getLogger(CheckPersonService.class);

    private PersonCheckDao dao;

    @PostConstruct
    public void init() {
        logger.info("START");
        dao = new PersonCheckDao();
        dao.setConnectionBuilder(new PoolConnectionBuilder());
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PersonResponse checkPerson(PersonRequest personRequest) throws PersonCheckException {

        logger.info(personRequest.toString());
        return dao.checkPerson(personRequest);
    }

}
