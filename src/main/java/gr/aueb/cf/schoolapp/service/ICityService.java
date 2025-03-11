package gr.aueb.cf.schoolapp.service;

import gr.aueb.cf.schoolapp.model.City;

import java.sql.SQLException;
import java.util.List;

public interface ICityService {

    List<City> getAllCities() throws SQLException;
}
