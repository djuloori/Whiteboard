<%@ page import="java.sql.Blob" %>
<%@ page import="com.github.djuloori.whiteboard.model.AssignmentEO" %>
<%@ page import="com.github.djuloori.whiteboard.dao.AssignmentDao" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.OutputStream" %><%--
  Created by IntelliJ IDEA.
  User: Dhruva Juloori
  Date: 12/1/2017
  Time: 4:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View File</title>
</head>
<body>
<%
    //String id = request.getParameter("asgn_id");
    //Blob file = null;
    byte[] fileData1 = (byte[]) session.getAttribute("syllubus");
    response.setContentType("application/pdf");
    response.setHeader("Content-Disposition","inline");
    response.setContentLength(fileData1.length);
    OutputStream output = response.getOutputStream();
    output.write(fileData1);
    output.flush();

%>

</body>
</html>

