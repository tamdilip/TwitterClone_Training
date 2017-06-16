package tweet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport {
	public String execute()
	{
		  Map session = ActionContext.getContext().getSession();
		  		 
		  String url = "jdbc:mysql://localhost:3306/tweet";		  
		  String driverName = "com.mysql.jdbc.Driver";
		  String userName = "dsomasun";
		  String password = "csc";
		  Connection con=null;
		  PreparedStatement pst=null;
		  try{
		  Class.forName(driverName);
		  con=DriverManager.getConnection(url, userName, password);
		  }
		  catch(Exception e){
		  System.out.println(e.getMessage());
		  }
		 
		  		String user = (String)session.get("user_id");
			  String sql = "update person set active=? where user_id=?";
			 try{ pst = con.prepareStatement(sql);
			  pst.setInt(1, 0);
			  pst.setString(2, user);
			  int i = pst.executeUpdate();}
			 catch(Exception e)
			 {
				 e.printStackTrace();
			 }
			  session.clear();
		
		  
		return SUCCESS;
	}

}
