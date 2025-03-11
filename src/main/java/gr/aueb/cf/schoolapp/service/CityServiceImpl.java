package gr.aueb.cf.schoolapp.service;

import gr.aueb.cf.schoolapp.dao.ICityDAO;
import gr.aueb.cf.schoolapp.model.City;

import java.sql.SQLException;
import java.util.List;

public class CityServiceImpl implements ICityService {

    private final ICityDAO cityDAO;

    public CityServiceImpl(ICityDAO cityDAO) {
        this.cityDAO = cityDAO;
    }


    @Override
    public List<City> getAllCities() throws SQLException {
        try {
            return cityDAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
