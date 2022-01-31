# quarkus-cont-testing-arc-error-example Project

Uses Quarkus 2.6.3.Final.

## Recreate error/problem:

* `mvn clean package` or `mvn clean test` works fine.
* Starting devmode for a single module via `mvn clean package -am -pl restservice -P devmode-restservice` works fine to.
* BUT, when starting using Continuous Testing in devmode, the test fails because Arc cannot properly wire the "testhelper"-Module, which is just for testing.
* Same with the standalone quarkus:test mode `mvn clean package -am -pl restservice -P testmode-restservice`