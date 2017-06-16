package tweet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;

public class EditRegister extends ActionSupport {
	private String fullname,email;

	
	@RequiredStringValidator(message="Supply Full Name!!!")
	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	@RequiredStringValidator(message="Supply Email!!")
	@EmailValidator(message = "Please enter a valid e-mail address.")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String execute() throws Exception
	{
		String url = "jdbc:mysql://localhost:3306/tweet";
		  
		  String driverName = "com.mysql.jdbc.Driver";
		  String userName = "dsomasun";
		  String password = "csc";
		  Map session = ActionContext.getContext().getSession();
		  String user=(String)session.get("user_id");
		 
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
		  String sql = "update person set fullName='"+getFullname()+"' , email='"+getEmail()+"' where user_id='"+user+"'";
		 PreparedStatement ps = con.prepareStatement(sql);
			 
		int i= ps.executeUpdate();
		
		 return SUCCESS;
	  }
	
		 
	
}
