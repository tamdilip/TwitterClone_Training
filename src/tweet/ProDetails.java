package tweet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProDetails
 */
@WebServlet("/ProDetails")
public class ProDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	// TODO Auto-generated method stub
	
		PrintWriter out=response.getWriter();
		HttpSession session = request.getSession();
		 String user=(String)session.getAttribute("user_id");
		 System.out.println("alltweet");
		  try
		  {
  Class.forName("com.mysql.jdbc.Driver");
 Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/tweet","dsomasun","csc");
 Statement st=con.createStatement();
 ResultSet rs = st.executeQuery(" select * from person where user_id='"+user+ "'" );  // this is for name
 


 while(rs.next())
 { 
	 out.println("<h1>"+rs.getString(3)+"</h1><h4>"+rs.getString(4)+"</h4>");
	 

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
