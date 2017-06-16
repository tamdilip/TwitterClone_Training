package tweet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

public class ConfirmPass extends ActionSupport {

	private String password;
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
		  try{
		  Class.forName(driverName);
		  con=DriverManager.getConnection(url, userName, password);
		  stmt=con.createStatement();
		  }
		  catch(Exception e){
		  System.out.println(e.getMessage());
		  }
		  String pws=getPassword();
		  Map session = ActionContext.getContext().getSession();
		  String user=(String)session.get("user_id");
		  stmt = con.createStatement();
		  ResultSet rs=stmt.executeQuery("select  * from person where  password='"+pws+"'" );
		  if(rs.next())
		  {
			  return SUCCESS;
		  }
		  else{
			  addActionError("Invalid Password !");
		  return INPUT;
		  }
		
	  }

	}
