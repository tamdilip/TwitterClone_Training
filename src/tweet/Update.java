package tweet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Update extends ActionSupport {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	public String execute() throws Exception
	{
		String url = "jdbc:mysql://localhost:3306/tweet";
		  
		  String driverName = "com.mysql.jdbc.Driver";
		  String userName = "dsomasun";
		  String password = "csc";
		  Connection con=null;
		  try{
		  Class.forName(driverName);
		  con=DriverManager.getConnection(url, userName, password);
		  }
		  catch(Exception e){
		  System.out.println(e.getMessage());
		  }
		  Map session = ActionContext.getContext().getSession();
		  String msg=getMessage();
		  String user=(String)session.get("user_id");
		  System.out.println("In update");
		  System.out.println(msg);
		  if(msg.equals("")==false){
		  String sql = "insert into tweet(user_id,message) values(?,?)";
			 PreparedStatement ps = con.prepareStatement(sql);
			 ps.setString(1, user);
			 ps.setString(2, msg);
			int i= ps.executeUpdate();
			if(i>0)
				System.out.println("Insertion Successful");
			}
			 return SUCCESS;
	}

}
