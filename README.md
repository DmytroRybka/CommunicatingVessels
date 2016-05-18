communicating-vessels
=====================

What is it?
-----------

It is a project for demonstrating communicating-vessels (represented as a list) algorithm implementation based on Java EE 6 on JBoss AS 7.1., primefaces 5.0. JSF 2.0, EJB 3.1, CDI 1.0
As a base was used maven archetype.  

In future existing implementation might be extended with statistic module that collects statistic history per user. 

Demo 
-----------------
Please see short demonstration video:
https://www.dropbox.com/s/z8ckdhe43xi6tos/communicating%20vessels%20demo.mp4?dl=0
Please view with an external player ( dropbox viewer quality is low). 
 
Binaries
-----------
Binaries are available here:
https://www.dropbox.com/sh/05l7p4r9ijnwfwh/AADqWawgoxY8PV_6-fQ1G8O4a?dl=0

 
Core service
--------------
Core service is available under: CommunicatingVessels\communicating-vessels-ejb\src\main\java\me\rybka\dmytro\service\CommunicatingVesselsServiceImpl.java

Algorithm Complexity
--------------------
O(n + n^2)


This project is setup to allow you to create a compliant Java EE 6 application using JSF 2.0, CDI 1.0, EJB 3.1, JPA 2.0 and Bean Validation 1.0. It includes a persistence unit and some sample persistence and transaction code to introduce you to database access in enterprise Java. 

System requirements
-------------------

All you need to build this project is Java 6.0 (Java SDK 1.6) or better, Maven 3.0 or better.

The application this project produces is designed to be run on JBoss Enterprise Application Platform 6 or JBoss AS 7.1. 

 
Start JBoss Enterprise Application Platform 6 or JBoss AS 7.1
-------------------------

1. Open a command line and navigate to the root of the JBoss server directory.
2. The following shows the command line to start the server with the web profile:

        For Linux:   JBOSS_HOME/bin/standalone.sh
        For Windows: JBOSS_HOME\bin\standalone.bat

 
Build and Deploy the Quickstart
-------------------------

_NOTE: The following build command assumes you have configured your Maven user settings. If you have not, you must include Maven setting arguments on the command line. See [Build and Deploy the Quickstarts](../README.html/#buildanddeploy) for complete instructions and additional options._

1. Make sure you have started the JBoss Server as described above.
2. Open a command line and navigate to the root directory of this quickstart.
3. Type this command to build and deploy the archive:

        mvn clean package jboss-as:deploy

4. This will deploy `target/communicating-vessels.ear` to the running instance of the server.


Access the application 
---------------------

The application will be running at the following URL <http://localhost:8080/communicating-vessels-web/>.

1. Refresh main page. 
2. After page refresh new version of array will be generated automatically and displayed as vertical bar chart.
3. Water volume capacity calculated automatically and displayed on the vertical bar chart. 
4. Refresh again to generate new array. 

Undeploy the Archive
--------------------

1. Make sure you have started the JBoss Server as described above.
2. Open a command line and navigate to the root directory of this quickstart.
3. When you are finished testing, type this command to undeploy the archive:

        mvn jboss-as:undeploy


Run the Arquillian Tests 
-------------------------

This quickstart provides Arquillian tests. By default, these tests are configured to be skipped as Arquillian tests require the use of a container. 

_NOTE: The following commands assume you have configured your Maven user settings. If you have not, you must include Maven setting arguments on the command line. See [Run the Arquillian Tests](../README.html/#arquilliantests) for complete instructions and additional options._

1. Make sure you have started the JBoss Server as described above.
2. Open a command line and navigate to the root directory of this quickstart.
3. Type the following command to run the test goal with the following profile activated:

        mvn clean test -Parq-jbossas-remote 


Test Coverage Summary
----------------------
http://screencast.com/t/wtyGnfF2

Investigate the Console Output
---------------------
You should see the following console output when you run the tests:

    Results :
    Tests run: 1, Failures: 0, Errors: 0, Skipped: 0


Investigate the Server Console Output
---------------------
You should see messages similar to the following:

    INFO  [org.jboss.as.server] (management-handler-thread - 9) JBAS018559: Deployed "test.war"
    INFO  [org.jboss.as.quickstarts.kitchensink_ear.controller.MemberRegistration] (http--127.0.0.1-8080-2) Registering Jane Doe
    INFO  [org.jboss.as.quickstarts.kitchensink_ear.test.MemberRegistrationTest] (http--127.0.0.1-8080-2) Jane Doe was persisted with id 1
    INFO  [org.jboss.weld.deployer] (MSC service thread 1-6) JBAS016009: Stopping weld service for deployment test.war
    INFO  [org.jboss.as.jpa] (MSC service thread 1-1) JBAS011403: Stopping Persistence Unit Service 'test.war#primary'
    INFO  [org.hibernate.tool.hbm2ddl.SchemaExport] (MSC service thread 1-1) HHH000227: Running hbm2ddl schema export
    INFO  [org.hibernate.tool.hbm2ddl.SchemaExport] (MSC service thread 1-1) HHH000230: Schema export complete
    INFO  [org.jboss.as.connector.subsystems.datasources] (MSC service thread 1-5) JBAS010409: Unbound data source [jboss/datasources/KitchensinkEarQuickstartTestDS]
    INFO  [org.jboss.as.server.deployment] (MSC service thread 1-6) JBAS015877: Stopped deployment test.war in 19ms
    INFO  [org.jboss.as.server] (management-handler-thread - 10) JBAS018558: Undeployed "test.war"
