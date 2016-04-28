package Objects;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Country implements PropertiesExtractor {
    private String code, name, continent, region, localName, governmentForm, headOfState, code2;
    private double surfaceArea, lifeExpectancy, gnp, gnpOld;
    private int indepYear, capital, population;

    public Country(){}

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public String getGovernmentForm() {
        return governmentForm;
    }

    public void setGovernmentForm(String governmentForm) {
        this.governmentForm = governmentForm;
    }

    public String getHeadOfState() {
        return headOfState;
    }

    public void setHeadOfState(String headOfState) {
        this.headOfState = headOfState;
    }

    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public double getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(double lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public double getGnp() {
        return gnp;
    }

    public void setGnp(double gnp) {
        this.gnp = gnp;
    }

    public double getGnpOld() {
        return gnpOld;
    }

    public void setGnpOld(double gnpOld) {
        this.gnpOld = gnpOld;
    }

    public int getIndepYear() {
        return indepYear;
    }

    public void setIndepYear(int indepYear) {
        this.indepYear = indepYear;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public Country extract(ResultSet rs, ResultSetMetaData rsmd) {
        try {
            Country country = new Country();
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                String prop = rsmd.getColumnLabel(i);

                switch(prop) {
                    case "Code":
                        country.code = rs.getString(i);
                        break;
                    case "Name":
                        country.name = rs.getString(i);
                        break;
                    case "Continent":
                        country.continent = rs.getString(i);
                        break;
                    case "Region":
                        country.region = rs.getString(i);
                        break;
                    case "SurfaceArea":
                        country.surfaceArea = rs.getDouble(i);
                        break;
                    case "IndepYear":
                        country.indepYear = rs.getInt(i);
                        break;
                    case "Population":
                        country.population = rs.getInt(i);
                        break;
                    case "LifeExpectancy":
                        country.lifeExpectancy = rs.getDouble(i);
                        break;
                    case "GNP":
                        country.gnp = rs.getDouble(i);
                        break;
                    case "GNPOld":
                        country.gnpOld = rs.getDouble(i);
                        break;
                    case "LocalName":
                        country.localName = rs.getString(i);
                        break;
                    case "GovernmentForm":
                        country.governmentForm = rs.getString(i);
                        break;
                    case "HeadOfState":
                        country.headOfState = rs.getString(i);
                        break;
                    case "Capital":
                        country.capital = rs.getInt(i);
                        break;
                    case "Code2":
                        country.code2 = rs.getString(i);
                        break;

                    default:
                        throw new IllegalArgumentException("Not found");
                }
            }
            return country;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static class CountryFactory implements Factory<Country>{
        public Country create() {
            return new Country();
        }
    }

}
