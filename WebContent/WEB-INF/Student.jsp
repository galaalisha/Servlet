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
<title>Student</title>
</head>
<body>
<jsp:useBean id="key2" class="swehw642.StudentBean" scope="session" />
<table border="1" style="margin: auto;" width="45%"> 

       <caption> <strong> <p><h1>Survey Form </h1></p></strong> </caption>
 <tr>
 <td>Sid<br>
 <%= key2.getStudentId() %></td>
 <td>First Name<br>
 <%= key2.getFname() %></td>
 <td>Last Name<br>
 <%= key2.getLname() %></td>
</tr>

<tr>
 <td>Street Address<br>
 <%= key2.getStreet() %></td>
 <td>City<br>
 <%= key2.getCity() %></td>
 <td>State<br>
 <%= key2.getState() %></td>
</tr>

<tr>
 <td>Zip<br>
 <%= key2.getZip() %></td>
 <td>Telephone Number<br>
 <%= key2.getTel() %></td>
 <td>Email<br>
 <%= key2.getEmail() %></td>
</tr>

<tr>
 <td>URL<br>
 <%= key2.getUrl() %></td>
 <td>Month of high-school graduation<br>
 <%= key2.getMonth() %></td>
 <td>Date of Survey<br>
 <%= key2.getDate() %></td>
 </tr>
 


  
<tr>
 <td>Year of high-school graduation<br>
 <%= key2.getYear() %></td>
 <td>What do you like most about the campus?<br>
 <%= key2.getCheck() %></td>
 <td>How did you find out about this university?<br>
 <%= key2.getRadio() %></td>
</tr>

<tr>
 <td>Feedback<br>
 <%= key2.getFeedback() %></td>
<td colspan="2">Additional Comments<br>
<%= key2.getComments() %>
</td>
</tr>
</table>



</body>
</html>