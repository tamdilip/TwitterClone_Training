package tweet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class DeleteTweet
 */
@WebServlet("/DeleteTweet")
public class DeleteTweet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out=response.getWriter();
		  String sn=request.getParameter("user");
		  int tid =Integer.parseInt(sn);
		  System.out.println(tid);
		  System.out.println("sn");
		  try
		  {
  Class.forName("com.mysql.jdbc.Driver");
 Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/tweet","dsomasun","csc");
 String sql="delete from tweet where tweet_id='"+tid+"'";
 PreparedStatement st=con.prepareStatement(sql);
 st.executeUpdate();  // this is for name

 st.close();
 con.close();
		  }
		  catch(Exception e)
		  {

out.println(e);
	}

	}

}
