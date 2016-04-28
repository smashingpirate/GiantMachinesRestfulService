package Objects;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class City implements PropertiesExtractor {
    private String name;
    private String countryCode;
    private String district;
    private int population;

    private City(){}

    public City(String name, String countryCode, String district, int population) {
        this.name = name;
        this.countryCode = countryCode;
        this.district = district;
        this.population = population;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City extract(ResultSet rs, ResultSetMetaData rsmd) {
        try {
            City city = new City();
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                String prop = rsmd.getColumnLabel(i);
                if (prop.equals("Name")) {
                    city.name = rs.getString(i);
                } else if (prop.equals("CountryCode")) {
                    city.countryCode = rs.getString(i);
                } else if (prop.equals("District")) {
                    city.district = rs.getString(i);
                } else if (prop.equals("Population")) {
                    city.population = rs.getInt(i);
                }
            }
            return city;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static class CityFactory implements Factory<City>{
        public City create() {
            return new City();
        }
    }
}
