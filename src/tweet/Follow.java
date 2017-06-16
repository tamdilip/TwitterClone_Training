package tweet;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Follow extends ActionSupport {
	public String execute()
	{
		Map session = ActionContext.getContext().getSession();
		HttpServletRequest request = ServletActionContext.getRequest();
		session.put("check_id", request.getParameter("followid"));
		System.out.println("Hello " +request.getParameter("followid"));
		return SUCCESS;
	}
}
