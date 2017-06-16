<%@taglib uri="/struts-tags" prefix="csc"%>
<head>
<script type="text/javascript">
//javascript user defined function
/*
 function functionname()
 {
 }
 }
 */
function loadXMLDoc()
{
var xmlhttp;//declare a variable. datatype is var.
var k=document.getElementById("id2").value;
var urls="Available?user="+k;
 
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
        document.getElementById("err").innerHTML=xmlhttp.responseText;
 
    }
  }
xmlhttp.open("POST",urls,true);//calling the Ajax1 servlet
xmlhttp.send();
}
</script>
 <style type="text/css">
 div.s {
	    position: absolute;
	    top: 250px;
	    right: 400px;
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

<body bgcolor=#302d30 text=black>
<div class=s>
<csc:form action="EditRegister">
<csc:textfield name="fullname" label="Full Name" />
<csc:textfield name="email" label="Email" />
<csc:submit type="image" src="images/update.png" value="" ></csc:submit>
</csc:form>
</div>
</body>
