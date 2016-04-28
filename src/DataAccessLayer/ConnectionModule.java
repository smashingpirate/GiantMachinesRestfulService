package DataAccessLayer;


import com.google.inject.AbstractModule;

public class ConnectionModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(DBConnector.class).to(MySqlConnectionProvider.class);
    }
}
