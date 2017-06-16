package tweet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FollowAction extends ActionSupport {

	public String execute() throws Exception
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
		  }
		  catch(Exception e){
		  System.out.println(e.getMessage());
		  }
		  Map session = ActionContext.getContext().getSession();
		  String user=(String)session.get("user_id");
		  String follow=(String)session.get("check_id");
		  System.out.println(user);
		  System.out.println(follow);
		  String sql = "insert into following(user_id,following_id) values(?,?)";
		  stmt = con.prepareStatement(sql);
		  stmt.setString(1, user);
		  stmt.setString(2, follow);
		  int rs=stmt.executeUpdate();
		  if(rs>0)
			  return SUCCESS;
		return ERROR;		
	  }
}
