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
 * Servlet implementation class Following
 */
@WebServlet("/Following")
public class Following extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		HttpSession session = request.getSession();
		 String user_id=(String)session.getAttribute("user_id");
		 
		  try
		  {
  Class.forName("com.mysql.jdbc.Driver");
 Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/tweet","dsomasun","csc");
 Statement ps=null;
 String sql = "select * FROM following WHERE user_id='"+user_id+"'";
 ps = con.createStatement();
 ResultSet i = ps.executeQuery(sql);
 out.println("<div align='center' class='w'>");
 out.println("<table ><tr><th>Following</th></tr>");
 while(i.next())
 { 
 		out.println("<tr><td>"+i.getString(2)+"</td></tr>");

 }
 out.println("</table>");
 out.println("</div>");
  i.close();
 ps.close();
 con.close();
		  }
		  catch(Exception e)
		  {

out.println(e);
	}

	}


}
