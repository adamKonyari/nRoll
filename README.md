# About

Simple human resource management webapp designed for university students.

#### by Adam Konyari
#### 2019

## `DataSource`

Before deploying to a webserver create a `Resource` like in your webserver's config (e.g. for Apache Tomcat in `conf/context.xml`).

```
<Resource name="jdbc/nRoll"
          type="javax.sql.DataSource"
          username="postgres"
          password="admin"
          driverClassName="org.postgresql.Driver"
          url="jdbc:postgresql://localhost:5432/nRoll"
          closeMethod="close"/>
```

*Note*: the `closeMethod="close"` attribute is important. [As per Tomcat's documentation][1] this ensures that connections retrieved from the datasource are closed properly when a webapp context is reloaded/restarted/redeployed/etc.

