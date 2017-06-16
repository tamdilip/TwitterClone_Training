<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>Welcome</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
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
var urls="AllTweet";
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
        document.getElementById("alltweets").innerHTML=xmlhttp.responseText;
 
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
function clear()
{
	document.getElementById("msg").value="";
	}
	
$(document).ready(function() {
    var text_max = 140;
    $('#textarea_feedback').html(text_max + ' characters remaining');

    $('#msg').keyup(function() {
        var text_length = $('#msg').val().length;
        var text_remaining = text_max - text_length;

        $('#textarea_feedback').html(text_remaining + ' characters remaining');
    });
});
</script>
<style type="text/css">
div.up {
    position: absolute;
    top: 400px;
    right: 200px;
    width: 600px;
    
    background-color: #ecc701;
    box-shadow: inset 0px 0px 5px 5px #302d30; 
}
div.up1 {

    position: absolute;
    top: 180px;
    right: 200px;
    width: 600px;
    height: 100px;
    background-color: #ecc701;
    box-shadow: inset 0px 0px 5px 5px #302d30; 
}
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

div.up1,div.up2 {
    padding-top: 25px;
    padding-right: 50px;
    padding-bottom: 25px;
    padding-left: 50px;
}
.label{
    color: black;
    font: bold;
    font-size: 20px;
}

div.details1 {
    position: absolute;
    top: 400px;
    right:230px;
    width: 600px;
    height: 100px;
    border: 0px solid #1F1F19;
    
}

TD,TH{font-family: metro; font-size: 15pt;}

</style>
</head>
<body style="font-size:25px;" onload="loadXMLDoc1();loadXMLDoc2();clear();">
<jsp:include page="indexheader.jsp" />  
<div class="up1">
<s:form action ="UpdateMessage" >
<s:textarea rows="4" cols="30" id="msg" name="message" label="What are you doing?"></s:textarea>
<s:submit type="image" src="images/tweet.png" value="" ></s:submit>

</s:form><div id="textarea_feedback">.</div>
</div>
<div class="up2">
<s:textfield id="searchfield" label="Search" onkeyup="loadXMLDoc(this.value)"/>
<form id="out" action="CheckProfile.action"></form>
<div id="tweetCount"></div>
</div>

<div class="up">
<div  align="center" id="alltweets"></div>
</div>

</body>
</html>