package gr.aueb.cf.schoolapp.dao;

import gr.aueb.cf.schoolapp.model.City;
import gr.aueb.cf.schoolapp.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityDAOImpl implements ICityDAO {

    @Override
    public List<City> getAll() throws SQLException {
        String sql = "SELECT * FROM cities";
        List<City> cities = new ArrayList<>();
        ResultSet rs;


        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                City city = new City(id, name);
                cities.add(city);
            }
           return cities;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
