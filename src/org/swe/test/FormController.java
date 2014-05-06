package org.swe.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;




import swehw642.DataBean;
import swehw642.DataProcessor;
import swehw642.StudentDAO;
//import swehw642.connect;
import swehw642.StudentBean;


/**
 * Servlet implementation class FormController
 */
@WebServlet("/FormController")
public class FormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		System.out.println("Olaaa");
		String sid = request.getParameter("stuid");
	    StudentDAO sd = new StudentDAO();
	    StudentBean bean = sd.getStudentInfo(sid);
	    HttpSession session2 = request.getSession();
        session2.setAttribute("key2", bean);
        if(bean.getStudentId() != null)
        {
        	System.out.println("Name:" + bean.getFname());
        	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Student.jsp");
        	rd.forward(request, response);
        }
        else
        {
        	System.out.println("noStudent");
        	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/NoSuchStudent.jsp");
        	rd.forward(request, response);
        }
	   
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	System.out.println("Hello");
		try
		{	  
			String sid = request.getParameter("sid");  
            String fname = request.getParameter("fname");  
            String lname = request.getParameter("lname");  
            String street = request.getParameter("street");  
            String city = request.getParameter("city");  
            String state = request.getParameter("state");  
            String zip = request.getParameter("zip");  
            String tel = request.getParameter("tel");  
            String email = request.getParameter("email");
            String url = request.getParameter("url");  
            String date = request.getParameter("date");
            String month = request.getParameter("monthgrad");  
            String year = request.getParameter("yeargrad");
           // String campus = request.getParameter("thingsliked");  
            String infouni = request.getParameter("howtosite");  
            String feedback = request.getParameter("feedback");
            String comments = request.getParameter("comments");
           // StudentBean declira = new StudentBean(sid,name,state,zip,street);  

            String temp[] = request.getParameterValues("thingsliked");
            String campus =" ";
            for (int i = 0; i < temp.length; i++) 
            {
            	 if(i==0)
            		 campus=temp[i];
            	 else
            	     campus = campus + "," + temp[i];
            }

            StudentBean declira = new StudentBean();
            declira.setStudentId(sid);
            declira.setFname(fname);
            declira.setLname(lname);
            declira.setStreet(street);
            declira.setCity(city);
            declira.setState(state);
            declira.setZip(zip);
            declira.setTel(tel);
            declira.setEmail(email);
            declira.setUrl(url);
            declira.setDate(date);
            declira.setMonth(month);
            declira.setYear(year);
            declira.setCheck(campus);
            declira.setRadio(infouni);
            declira.setFeedback(feedback);
            declira.setComments(comments);
            
            System.out.println(declira.getCheck() );
          //  StudentDAO.save();
            StudentDAO.save(declira);
            
            HttpSession session1 = request.getSession();
            session1.setAttribute("key1", declira);
            
            StudentDAO.info();
            StudentDAO m1 = new StudentDAO();
            ArrayList myList = m1.info();
            System.out.println(myList); 
            
            String data= request.getParameter("data");
	        String[] tokens = data.split(",");
	        DataProcessor dp = new DataProcessor();
            DataBean db= dp.calcMeanStd(tokens); 
            System.out.println("Mean:" + db.getMean());
            System.out.println("SD:" + db.getStd());
            
            HttpSession session = request.getSession();
            session.setAttribute("key", db);
            request.setAttribute("key1", myList);
            
            if(db.getMean()>=90)
            {
            	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/WinnerAcknowledgement.jsp");
            	rd.forward(request, response);
            }
            else
            {
            	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/SimpleAcknowledgement.jsp");
            	rd.forward(request, response);
            }
            
            

		}
				
		catch (Throwable theException) 	    
		{
		     System.out.println(theException); 
		}
		      

	}}


