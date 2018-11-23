<%@ page import="javax.security.auth.login.Configuration" %>
<%@ page import="org.eclipse.persistence.sessions.factories.SessionFactory" %>
<%@ page import="javax.persistence.Query" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.github.djuloori.whiteboard.model.ClassesEO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.github.djuloori.whiteboard.dao.ClassesDao" %>
<%@ page import="javax.persistence.EntityManagerFactory" %>
<%@ page import="javax.persistence.Persistence" %>
<%@ page import="javax.persistence.EntityManager" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@ page import="org.springframework.context.annotation.AnnotationConfigApplicationContext" %>
<%@ page import="com.github.djuloori.whiteboard.framework.SecurableEntityManager" %>
<%@ page import="com.github.djuloori.whiteboard.framework.SecurableEntityManagerImpl" %>
<%@ page import="com.github.djuloori.whiteboard.framework.ApplicationContextProvider" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title><%= (String) session.getAttribute("username")%> /WhiteBoard </title>
    <!-- Bootstrap core CSS-->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom fonts for this template-->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <!-- Page level plugin CSS-->
    <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
    <!-- Custom styles for this template-->
    <link href="css/sb-admin.css" rel="stylesheet">
</head>
<body class="fixed-nav sticky-footer bg-dark" id="page-top" onload="noBack();"
      onpageshow="if (event.persisted) noBack();" onunload="">
<%
    response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
    if(session.getAttribute("username")==null) {
        response.sendRedirect("index.jsp");
    }
%>
<!-- Navigation-->

<SCRIPT type="text/javascript">
    window.history.forward();
    function noBack() { window.history.forward(); }
</SCRIPT>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
    <a class="navbar-brand" href="index1.jsp">WHITEBOARD</a>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
            <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Dashboard">
                <a class="nav-link" href="index1.jsp?username= <%=(String) session.getAttribute("username")%>">
                    <i class="fa fa-fw fa-dashboard"></i>
                    <span class="nav-link-text">HOME</span>
                </a>
            </li>
            <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Charts">
                <a class="nav-link" href="courses.jsp?username= <%=(String) session.getAttribute("username")%>">
                    <i class="fa fa-fw fa-area-chart"></i>
                    <span class="nav-link-text">Courses</span>
                </a>
            </li>
            <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Tables">
                <a class="nav-link" href="students.jsp?username= <%=(String) session.getAttribute("username")%>">
                    <i class="fa fa-fw fa-table"></i>
                    <span class="nav-link-text">Students</span>
                </a>
            </li>
            <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Tables">
                <a class="nav-link" href="assignments.jsp?username= <%=(String) session.getAttribute("username")%>">
                    <i class="fa fa-fw fa-table"></i>
                    <span class="nav-link-text">Assignments</span>
                </a>
            </li>
            <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Tables">
                <a class="nav-link" href="Ta.jsp?username= <%=(String) session.getAttribute("username")%>">
                    <i class="fa fa-fw fa-table"></i>
                    <span class="nav-link-text">TA</span>
                </a>
            </li>

            <%
                String user = (String) session.getAttribute("username");
            %>
            <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Tables">
                <a class="nav-link" href="schedule.jsp?username= <%=(String) session.getAttribute("username")%>">
                    <i class="fa fa-fw fa-table"></i>
                    <span class="nav-link-text">Schedule</span>
                </a>
            </li>
            <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Link">
                <a class="nav-link" href="Syllubus.jsp?username= <%=(String) session.getAttribute("username")%>">
                    <i class="fa fa-fw fa-link"></i>
                    <span class="nav-link-text">Syllabus</span>
                </a>
            </li>
        </ul>
        <ul class="navbar-nav sidenav-toggler">
            <li class="nav-item">
                <a class="nav-link text-center" id="sidenavToggler">
                    <i class="fa fa-fw fa-angle-left"></i>
                </a>
            </li>
        </ul>
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link" data-toggle="modal" data-target="#exampleModal">
                    <i class="fa fa-fw fa-sign-out"></i>Logout</a>
            </li>
        </ul>
    </div>
</nav>

<div class="content-wrapper">
    <div class="container-fluid">
        <!-- Breadcrumbs-->
        <ol class="breadcrumb">
            <li class="breadcrumb-item">
                <a href="CourseRegister.jsp?username= <%=(String) session.getAttribute("username")%>">Add Class</a>
            </li>
            <li class="breadcrumb-item active"><%= user %></li>
        </ol>
        <!-- Example DataTables Card-->
        <div class="card mb-3">
            <div class="card-header">
                <i class="fa fa-table"></i> List of Courses</div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <thead>
                        <tr>
                            <th>Class_id</th>
                            <th>Class_name</th>
                            <th>Edit</th>
                            <th>Delete</th>

                        </tr>
                        </thead>

                        <tbody>
                        <%
                            ClassesDao cd = (ClassesDao) ApplicationContextProvider.getApplicationContext().getBean("classesDao");
                            List<ClassesEO> cs = cd.getAllCourses();
                            for(int i=0;i<cs.size();i++){
                                String id = cs.get(i).getClassId();
                                String name = cs.get(i).getClassName();
                        %>

                        <tr>

                            <td><%= id %></td>
                            <td><%= name%></td>
                            <td><a href = "CourseRegister.jsp">edit</a></td>
                            <td><a href = "deletecourse.jsp">delete</a></td>

                        </tr>
                        <%
                            }
                        %>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
        </div>
    </div>
    <!-- /.container-fluid-->
    <!-- /.content-wrapper-->
    <footer class="sticky-footer">
        <div class="container">
            <div class="text-center">
                <small>Copyright © WhiteBoard</small>
            </div>
        </div>
    </footer>
    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fa fa-angle-up"></i>
    </a>
    <!-- Logout Modal-->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave <%= user %></h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="index.jsp">Logout</a>
                </div>
            </div>
        </div>
    </div>
    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
    <!-- Page level plugin JavaScript-->
    <script src="vendor/datatables/jquery.dataTables.js"></script>
    <script src="vendor/datatables/dataTables.bootstrap4.js"></script>
    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin.min.js"></script>
    <!-- Custom scripts for this page-->
    <script src="js/sb-admin-datatables.min.js"></script>
</div>
</body>
</html>