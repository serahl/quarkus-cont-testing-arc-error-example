package de.serahl.quarkustest.dbservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.sql.DataSource;

public abstract class AbstractDbServiceImpl implements DbService {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Inject
    DataSource dataSource;

    @Override
    public boolean executeStatement(String statement) {
        try {
            return dataSource.getConnection().createStatement().execute(statement);
        } catch (Exception e) {
            logger.error("Error executing statement " + statement, e);
            return false;
        }
    }

    protected DataSource getDataSource() {
        return dataSource;
    }


}
