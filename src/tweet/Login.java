package tweet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.DateRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.DoubleRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

public class Login extends ActionSupport {

	String username;
	String password;
	@RequiredStringValidator(message="Supply Username!!!")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@RequiredStringValidator(message="Supply Password!!!") 
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String execute() throws Exception
	{
		String url = "jdbc:mysql://localhost:3306/tweet";
		  
		  String driverName = "com.mysql.jdbc.Driver";
		  String userName = "dsomasun";
		  String password = "csc";
		  Connection con=null;
		  Statement stmt=null;
		  PreparedStatement pst=null;
		  try{
		  Class.forName(driverName);
		  con=DriverManager.getConnection(url, userName, password);
		  stmt=con.createStatement();
		  }
		  catch(Exception e){
		  System.out.println(e.getMessage());
		  }
		  String uname=getUsername();
		  String pws=getPassword();
		  Map session = ActionContext.getContext().getSession();
		  session.put("user_id",uname);
		  String user=(String)session.get("user_id");
		  System.out.println(user);
		  stmt = con.createStatement();
		  ResultSet rs=stmt.executeQuery("select  * from person where user_id= '"+uname+"' and password='"+pws+"'" );
		  if(rs.next())
		  {
			  String sql = "update person set active=? where user_id=?";
			  pst = con.prepareStatement(sql);
			  pst.setInt(1, 1);
			  pst.setString(2, user);
			  int i = pst.executeUpdate();
			  return SUCCESS;
		 }
		
		  else{
			  addActionError("Invalid Inputs!");
		  return INPUT;
		  }
		
	  }
	}

	

