package by.intro.city.dao;

import by.intro.city.domain.PersonRequest;
import by.intro.city.domain.PersonResponse;
import by.intro.city.exception.PersonCheckException;

import java.sql.*;

public class PersonCheckDao {

    private static final String SQL_REQUEST = "select temporal from cr_address_person ap " +
            "inner join cr_person p on p.person_id = ap.person_id " +
            "inner join cr_address addr on addr.address_id = ap.address_id " +
            "where " +
            "CURRENT_DATE >= ap.start_date and (CURRENT_DATE <= ap.end_date or ap.end_date is null) " +
            "and upper(p.surname) = upper(?)  " +
            "and upper(p.givenname) = upper(?) " +
            "and upper(p.patronymic) = upper(?) " +
            "and p.date_of_birth = ? " +
            "and addr.street_code = ? and upper(addr.building) = upper(?) ";

    private ConnectionBuilder connectionBuilder;

    public void setConnectionBuilder(ConnectionBuilder connectionBuilder) {
        this.connectionBuilder = connectionBuilder;
    }

    private Connection getConnection() throws SQLException {

        return connectionBuilder.getConnection();
    }

    public PersonResponse checkPerson(PersonRequest request) throws PersonCheckException {

        PersonResponse response = new PersonResponse();

        String sql = SQL_REQUEST;
        if (request.getExtension() != null) {
            sql += "and upper(addr.extension) = upper(?) ";
        } else sql += "and addr.extension is null ";
        if (request.getApartment() != null) {
            sql += "and upper(addr.apartment) = upper(?) ";
        } else sql += "and addr.apartment is null ";

        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            int count = 1;
            stmt.setString(count++, request.getSurname());
            stmt.setString(count++, request.getGivenname());
            stmt.setString(count++, request.getPatronymic());
            stmt.setDate(count++, java.sql.Date.valueOf(request.getDateOfBirth()));
            stmt.setInt(count++, request.getStreetCode());
            stmt.setString(count++, request.getBuilding());
            if (request.getExtension() != null) {
                stmt.setString(count++, request.getExtension());
            }
            if (request.getApartment() != null) {
                stmt.setString(count++, request.getApartment());
            }


            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                response.setRegistered(true);
                response.setTemporal(rs.getBoolean("temporal"));
            }

        } catch (SQLException ex) {
            throw new PersonCheckException(ex);
        }

        return response;
    }

}
