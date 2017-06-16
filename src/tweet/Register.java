/**
 * 
 */
package tweet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;;

/**
 * @author trg
 *
 */
public class Register extends ActionSupport {

	private String username,password,fullname,email;

	@RequiredStringValidator(message="Supply Username!!!")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	@RequiredStringValidator(message="Supply Password!!!")
	@StringLengthFieldValidator(minLength="4",maxLength="8", message = "Enter password between 4 to 8 Integers")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
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
		  Connection con=null;
		  Statement stmt=null;
		  try{
		  Class.forName(driverName);
		  con=DriverManager.getConnection(url, userName, password);
		  stmt=con.createStatement();
		  String sql = "insert into person(user_id,password,fullname,email,active) values(?,?,?,?,?)";
			 PreparedStatement ps = con.prepareStatement(sql);
			 ps.setString(1, getUsername());
			 ps.setString(2, getPassword());
			 ps.setString(3, getFullname());
			 ps.setString(4, getEmail());
			 ps.setInt(5, 0);		 
			int i= ps.executeUpdate();
			if(i>0)
				System.out.println("Insertion Successful");
			 return SUCCESS;
		  }
		  catch(Exception e){
			  addActionError("User Already Exists!");
		  System.out.println(e.getMessage());
		  }
		  
		  return INPUT;
		
	  }
	
}
