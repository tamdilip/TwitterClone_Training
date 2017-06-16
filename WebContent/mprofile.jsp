<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>Welcome</title>
<script type="text/javascript">

function loadXMLDoc(str)
{
var xmlhttp;//declare a variable. datatype is var.
var urls="Search?user="+str;
 //window and document  is a javascript predefined object
if (window.XMLHttpRequest)
  {
  xmlhttp=new XMLHttpRequest();//Ajax Class
  }
else
  {
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4)
    {
        document.getElementById("out").innerHTML=xmlhttp.responseText;
 
    }
  }
xmlhttp.open("POST",urls,true);//calling the Ajax1 servlet
xmlhttp.send();
}
function loadXMLDoc1()
{
var xmlhttp;//declare a variable. datatype is var.
var urls="MyTweet";
 //window and document  is a javascript predefined object
if (window.XMLHttpRequest)
  {
  xmlhttp=new XMLHttpRequest();//Ajax Class
  }
else
  {
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4)
    {
        document.getElementById("MyTweet").innerHTML=xmlhttp.responseText;
 
    }
  }
xmlhttp.open("POST",urls,true);//calling the Ajax1 servlet
xmlhttp.send();
}
function loadXMLDoc2()
{
var xmlhttp;//declare a variable. datatype is var.
var urls="TweetCount";
 //window and document  is a javascript predefined object
if (window.XMLHttpRequest)
  {
  xmlhttp=new XMLHttpRequest();//Ajax Class
  }
else
  {
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4)
    {
        document.getElementById("TweetCount").innerHTML=xmlhttp.responseText;
 
    }
  }
xmlhttp.open("POST",urls,true);//calling the Ajax1 servlet
xmlhttp.send();
}
function loadXMLDoc3()
{
var xmlhttp;//declare a variable. datatype is var.
var urls="ProDetails";
 //window and document  is a javascript predefined object
if (window.XMLHttpRequest)
  {
  xmlhttp=new XMLHttpRequest();//Ajax Class
  }
else
  {
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4)
    {
        document.getElementById("ProDetails").innerHTML=xmlhttp.responseText;
 
    }
  }
xmlhttp.open("POST",urls,true);//calling the Ajax1 servlet
xmlhttp.send();
}
function loadXMLDoc4(str)
{
var xmlhttp;


if (confirm("Press Ok Delete!") == true) {
	var urls="DeleteTweet?user="+str;
	 //window and document  is a javascript predefined object
	if (window.XMLHttpRequest)
	  {
	  xmlhttp=new XMLHttpRequest();//Ajax Class
	  }
	else
	  {
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }
	xmlhttp.onreadystatechange=function()
	  {
		
	  if (xmlhttp.readyState==4)
	    {
		  
		   }
	  }
	xmlhttp.open("POST",urls,true);//calling the Ajax1 servlet
	xmlhttp.send();

}
}
function loadXMLDoc5(tid)
{
var xmlhttp;

var msg = prompt("Edit Tweet");


	var urls="EditTweet?tid="+tid+"&message="+msg;
	 //window and document  is a javascript predefined object
	if (window.XMLHttpRequest)
	  {
	  xmlhttp=new XMLHttpRequest();//Ajax Class
	  }
	else
	  {
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }
	xmlhttp.onreadystatechange=function()
	  {
		
	  if (xmlhttp.readyState==4)
	    {
		  
		   }
	  }
	xmlhttp.open("POST",urls,true);//calling the Ajax1 servlet
	xmlhttp.send();


}

function myFunction() {
	
    location.reload();
}
</script>
<style type="text/css">
div.up2 {
    position: absolute;
    top: 180px;
    left:55px;
    width: 250px;
    height: 100px;
    border: 0px solid #1F1F19;
    background-color: #ecc701;
    box-shadow: inset 0px 0px 5px 5px #302d30;
    
}
div.up2 {
    padding-top: 25px;
    padding-right: 50px;
    padding-bottom: 25px;
    padding-left: 50px;
}
div.up {
    
    padding-right: 50px;
    padding-bottom: 25px;
    padding-left: 50px;
}

div.up {
    position: absolute;
    top: 180px;
    right: 85px;
    width: 700px;
    background-color: #ecc701;
    box-shadow: inset 0px 0px 5px 5px #302d30; 
}
TD{font-family: metro; font-size: 15pt;}

</style>
</head>
<body onload="loadXMLDoc1();loadXMLDoc2();loadXMLDoc3();">
<jsp:include page="indexheader.jsp" />  




<div class="up2">
<img alt="dp" src="images/dp.png" width="100" height="100" align="middle">
<div id="ProDetails"></div>
<a href="EditProfile.action">Edit Profile</a>
<br>
<a href="DeleteConfirm.action">Delete Account</a>
<br></br>
<br>
<s:textfield id="searchfield" label="Search" onkeyup="loadXMLDoc(this.value)"/>
<form id="out" action="CheckProfile.action"></form>
<div id="tweetCount"></div>
</div>
<div class="up">
<div   id="MyTweet"></div>
</div>
</body>
</html>