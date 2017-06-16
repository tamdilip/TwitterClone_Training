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
 * Servlet implementation class TweetCount
 */
@WebServlet("/TweetCount")
public class TweetCount extends HttpServlet {
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
 ResultSet rs = st.executeQuery("SELECT  * FROM tweet where user_id='"+user+"'");  // this is for name

int i=0;
 while(rs.next())
 {   
	 i++;
 }
 out.println(i+"-<a href='mprofile.jsp'>Tweets</a> ");
 out.println("<br>");
 ResultSet rs1 = st.executeQuery("SELECT  * FROM following where user_id='"+user+"'");  // this is for name

 int j=0;
  while(rs1.next())
  {   
 	 j++;
  }
  out.println(j+"-<a href='following.jsp' >Following</a> "); 
  out.println("<br>");
  
  ResultSet rs2 = st.executeQuery("SELECT  * FROM following where following_id='"+user+"'");  // this is for name

  int k=0;
   while(rs2.next())
   {   
  	 k++;
   }
   out.println(k+"-<a href='followers.jsp' >Followers</a> "); 
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
