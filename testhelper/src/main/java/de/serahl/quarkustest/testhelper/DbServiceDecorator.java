package de.serahl.quarkustest.testhelper;

import de.serahl.quarkustest.dbservice.DbService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Priority;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Priority(10)
@Decorator
@Dependent
public class DbServiceDecorator implements DbService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Inject
    @Any
    @Delegate
    DbService delegate;

    @Override
    public boolean executeStatement(String statement) {
        logger.info("Executing statement in test: " + statement);
        return delegate.executeStatement(statement);
    }
}
