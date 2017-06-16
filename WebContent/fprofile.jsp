<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="java.sql.*" %>
<html>
<head>
<style type="text/css">
div.up {
    position: absolute;
    top: 400px;
    right: 200px;
    width: 600px;
    background-color: #ecc701;
    box-shadow: inset 0px 0px 5px 5px #302d30; 
}
</style>
</head>
<body>
<%!String driverName = "com.mysql.jdbc.Driver";%>
<%!String url = "jdbc:mysql://localhost:3306/tweet";%>
<%!String user = "dsomasun";%>
<%!String psw = "csc";%>
<jsp:include page="indexheader.jsp" />  

<%
String check_id = (String)session.getAttribute("check_id");
String user_id= (String)session.getAttribute("user_id");
if(check_id != null)
{
Connection con = null;
Statement ps = null;
try
{
Class.forName(driverName);
con = DriverManager.getConnection(url,user,psw);
String sql = "select * FROM person WHERE user_id='"+check_id+"'";
ps = con.createStatement();
ResultSet i = ps.executeQuery(sql);
out.println("<div align='center'  class='up'>");
out.println("<table  ><tr><th><img src='images/user2.png' alt=''></img></th><th>FullName</th><th><img src='images/time1.png' alt='' width='20' height='20'></img>Status</th></tr>");
if(i.next())
{ 
	if(i.getInt(5)==1)
		out.println("<tr><td>"+i.getString(1)+"</td><td>"+i.getString(3)+"</td><td>Online</td></tr>");
	else
		out.println("<tr><td>"+i.getString(1)+"</td><td>"+i.getString(3)+"</td><td>Offline</td></tr>");


}
out.println("</table>");

}
catch(SQLException sqe)
{
out.println(sqe);
}
}
try
{
	Connection con = null;
	Statement ps = null;

Class.forName(driverName);
con = DriverManager.getConnection(url,user,psw);
String sql = "select * FROM following WHERE following_id='"+check_id+"' and user_id='"+user_id+"'";
ps = con.createStatement();
ResultSet i = ps.executeQuery(sql);
if(i.next())
{
%>

<s:form action="UnfollowAction">
<s:submit type="image" src="images/unfollow.png" value="" ></s:submit>
</s:form>

<%
}
else{
%>

<s:form action="FollowAction">
<s:submit type="image" src="images/follow1.png" value="" ></s:submit>
</s:form>

<%
}
}
catch(SQLException sqe)
{
out.println(sqe);
}

%>
</div>
</body>
</html>