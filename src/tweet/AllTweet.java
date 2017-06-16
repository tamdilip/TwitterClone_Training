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
 * Servlet implementation class AllTweet
 */
@WebServlet("/AllTweet")
public class AllTweet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out=response.getWriter();
		HttpSession session = request.getSession();
		 String user=(String)session.getAttribute("user_id");
		 
		  try
		  {
  Class.forName("com.mysql.jdbc.Driver");
 Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/tweet","dsomasun","csc");
 Statement st=con.createStatement();
 ResultSet rs = st.executeQuery("select * from tweet where user_id in (select following_id from following where user_id='"+user +"') union select * from tweet where user_id='"+user+ "' order by created desc" );  // this is for name
 out.println("<table cellpadding='10' cellspacing='5'  border=0 color=green><tr><th><img src='images/user2.png' alt=''></img></th><th><img src='images/tweet1.png' alt=''></img></th><th><img src='images/time1.png' alt='' width='30' height='30'></img></th></tr>");
 

 while(rs.next())
 { 
	 out.println("<tr><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td></tr>");

 }
 out.println("</table>");
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
