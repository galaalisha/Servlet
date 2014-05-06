<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*, java.net.*"%>
<%@page import="swehw642.DataBean"%>
<%@page import="swehw642.StudentBean"%>
<%@page import="swehw642.StudentDAO"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Simple</title>
</head>
<body>
<h3> Thank you for submitting the form.</h3>

<jsp:useBean id="key" class="swehw642.DataBean" scope="session" />

Mean: <%= key.getMean() %><BR>
Standard Deviation: <%= key.getStd() %><BR>

SID: <% ArrayList stu = (ArrayList)request.getAttribute("key1");
out.println("<ul>");
      for(int i=0;i<stu.size();i++)
    	//  out.println("<li><a >"+ stu.get(i) + "</a></li>");
      out.println("<li> <a href=\"http://localhost:8080/assignment4/FormController?stuid="+stu.get(i)+"\">Click this link to retrieve Student ID "+stu.get(i)+"</a></li>");
out.println("</ul>");
%>



</body>





















</html>