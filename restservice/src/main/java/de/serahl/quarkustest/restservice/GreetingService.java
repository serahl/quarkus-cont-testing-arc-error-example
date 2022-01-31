package de.serahl.quarkustest.restservice;

import de.serahl.quarkustest.dbservice.AbstractDbServiceImpl;
import de.serahl.quarkustest.dbservice.DbService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import java.sql.SQLException;

@RequestScoped
public class GreetingService extends AbstractDbServiceImpl {

    @PostConstruct
    public void init() throws SQLException {
        // setup DB a bit.
        executeStatement("create table IF NOT EXISTS greetings (id  INT NOT NULL, greetingtext VARCHAR(100))");
        executeStatement("MERGE INTO greetings key(id) values (1, 'Hello there!')");

    }


    public String loadGreeting(int id) {
        try {
            var statement = getDataSource().getConnection().createStatement();
            statement.execute("select g.greetingtext from greetings g where g.id = " + id);
            statement.getResultSet().first();
            return statement.getResultSet().getString(1);
        } catch (Exception e) {
            logger.error("Could not get greeting ", e);
            return null;
        }
    }

}
