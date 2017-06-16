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
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		  String sn=request.getParameter("user");
		  try
		  {
    Class.forName("com.mysql.jdbc.Driver");
   Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/tweet","dsomasun","csc");
   Statement st=con.createStatement();
   ResultSet rs = st.executeQuery("select user_id from person where user_id like '"+sn+"%'");  // this is for name
  out.println("<select name='followid'>");
   while(rs.next())
  {
	  out.println("<option value="+rs.getString(1)+">"+rs.getString(1)+"</option>");	  
  }
   out.println("</select>");
   out.println("<input type='Submit' value='Search'>");
   /*if(rs.next())
   {    
       out.println("<font color=green>");
       out.println("UserName Already Exists");
       out.println("</font>");

   }else {

       out.println("<font color=green>");
       out.println("UserName Available.So make use of it");
       out.println("</font>");

   }*/
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
