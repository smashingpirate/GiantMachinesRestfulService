package Objects;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public interface PropertiesExtractor<T> {
    abstract T extract(ResultSet rs, ResultSetMetaData rsmd);
}
