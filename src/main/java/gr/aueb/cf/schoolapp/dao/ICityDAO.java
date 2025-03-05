package gr.aueb.cf.schoolapp.dao;

import gr.aueb.cf.schoolapp.model.City;

import java.sql.SQLException;
import java.util.List;

public interface ICityDAO {

    // All CRUD methods need to be defined.

    List<City> getAll() throws SQLException;
}
