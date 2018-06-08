'Whiteboard' is an educational portal which allows Professors and Students to monitor their activities and progress in the university. It provides a platform where professors can upload assignments and students can submit them accordingly, And also Professor can assign a grader to his course and he gets a privilege to grade the assignments of students.

Tools and Technologies used:
1) Entire programming for the application is done in Java using Spring IOC and RESTful Web services. Used HTML5, CSS, and Javascript in the Front-end development following by AJAX calls to the server.
2) Used Oracle database for the application and implemented ORM using JPA with eclipselink.
3) Git is used as a VCS, Maven as a build tool and Glassfish as an app server.

Steps to Setup:
1) Install Maven, Tomcat/Glassfish, XAMP server, MySQLWorkBench and IntelliJ/Eclipse.
2) Run 'mvn install' from the root directory of the project to add all the dependencies to the classpath
3) To deploy the application run 'mvn package' and this generates war file which can be deployed in any J2EE container. 

Link of the application:
http://54.236.112.106:8080/whiteboard/

Default Credentials:
username: user
password: root
