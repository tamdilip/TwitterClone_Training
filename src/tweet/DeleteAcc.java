package tweet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;

import java.sql.PreparedStatement;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteAcc extends ActionSupport {

	public String execute()
	{
		String url = "jdbc:mysql://localhost:3306/tweet";
		  
		  String driverName = "com.mysql.jdbc.Driver";
		  String userName = "dsomasun";
		  String password = "csc";
		  Connection con=null;
		  PreparedStatement stmt=null;
		  try{
		  Class.forName(driverName);
		  con=DriverManager.getConnection(url, userName, password);
		  Map session = ActionContext.getContext().getSession();
		  String user=(String)session.get("user_id");
		  String sql = "delete from person where user_id = '"+user+"'";
		  stmt=con.prepareStatement(sql);
		  int result = stmt.executeUpdate();
		  if(result!=0)
		  {
			  session.clear();
			  return SUCCESS;
		  }
		  }
		  catch(Exception e){
		  System.out.println(e.getMessage());
		  }		
		return ERROR;
	}
}
