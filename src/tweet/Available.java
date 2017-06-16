package tweet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


/**
 * Servlet implementation class Available
 */
@WebServlet("/Available")
public class Available extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		  String sn=request.getParameter("user");
		  try
		  {
      Class.forName("com.mysql.jdbc.Driver");
     Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/tweet","dsomasun","csc");
     Statement st=con.createStatement();
     ResultSet rs = st.executeQuery("select * from person where user_id='"+sn+"'");  // this is for name
     if(rs.next())
     {    
         out.println("<font color=green>");
         out.println("UserName Already Exists");
         out.println("</font>");

     }else {

         out.println("<font color=green>");
         out.println("UserName Available.So make use of it");
         out.println("</font>");

     }
     rs.close();
     st.close();
     con.close();
		  }
		  catch(Exception e)
		  {

out.println(e);
	}

	}

}
