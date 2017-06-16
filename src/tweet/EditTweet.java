package tweet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditTweet
 */
@WebServlet("/EditTweet")
public class EditTweet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		  String sn=request.getParameter("tid");
		  int tid =Integer.parseInt(sn);
		  String message=request.getParameter("message");
		  System.out.println("inside edit");
		  System.out.println(message);
		  try
		  {
Class.forName("com.mysql.jdbc.Driver");
Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/tweet","dsomasun","csc");
String sql="update  tweet set message='"+message+"'where tweet_id='"+tid+"'";
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
