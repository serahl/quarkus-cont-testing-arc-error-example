package de.serahl.quarkustest.dbservice;

public interface DbService {

    boolean executeStatement(String statement);
}
