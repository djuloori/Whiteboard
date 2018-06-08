**Description**
'Whiteboard' is an educational portal which allows Professors and Students to monitor their activities and progress in the university. It provides a platform where professors can upload assignments and students can submit them accordingly, And also Professor can assign a grader to his course and he gets a privilege to grade the assignments of students.

**Tools and Technologies used:**
1) Entire programming for the application is done in Java using Spring Framework and RESTful Web services. Used HTML5, CSS, and Javascript in the Front-end development following by AJAX calls to the server.
2) Used Oracle database for the application and implemented ORM using JPA with eclipselink.
3) Git is used as a VCS, Maven as a build tool and Glassfish as an app server.

**Setting up for Development:**
1) Download/Install standard versions of either IntelliJ/Eclipse.
2) Download/install Maven, version 3.5.3 or newer.
3) Fork this git repo and clone it. GitHub for Windows or GitHub for Mac are good clients if you don't already have one.
4) If you are using IntelliJ, File>Open Projects and then find the folder where this repo is cloned. Ignore any compile errors (for now).
5) If you are using Eclipse, File>Import and then choose "Existing projects into workspace", and find the folder where this repo is cloned. Ignore any compile errors (for now). Run 'mvn eclipse:eclipse' from the root directory of this project.
6) Run 'mvn install' from the root directory of the project to add all the dependencies to the classpath.
7) To deploy the application run 'mvn package', this will create a target folder in the project directory and generates a WAR file, which can be deployed in any J2EE container. (Make sure your DB is running before you deploy) 

**DB Setup:**
1) Download/Install standard version of XAMP server
2) Open the XAMP server and start Apache and MySQL
2) Make sure to run MYSQL on port 3306.
 
**Link of the application:**
http://54.236.112.106:8080/whiteboard/

**Default Credentials:**
username: user
password: root
