<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Account</title>
 <style type="text/css">
 div.s {
	    position: absolute;
	    top: 300px;
	    right: 300px;
	    width: 400px;
	    heigth:200;
	    align=center;
	    background-color: #ecc701;
	    box-shadow: inset 0px 0px 5px 5px #302d30; 
	}
	div.s {
    padding-top: 25px;
    padding-right: 50px;
    padding-bottom: 25px;
    padding-left: 50px;
 </style>
</head>
<body bgcolor=#302d30 >
<div class=s>
<s:if test="hasActionErrors()">
    <h1>  <s:actionerror/></h1>
</s:if>

<s:form action="DeleteAccount" method="POST" >
<s:password name="password" label="Password"/>
<s:submit type="image" src="images/go.png" value="" ></s:submit>
</s:form>
</div>
</body>
</html>