<%@ taglib prefix="s" uri="/struts-tags" %>


<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script>



$(document).ready(function(){
    
	$(".btn2").click(function(){
		
		
		 if ($("div").is(":visible")) {
		        $("div").slideUp(800);
		        }
		      else  { 
		    	  $("div").slideDown(1000);      }
        
    });
});
</script>
<style type="text/css">
.initiallyHidden { display: none; }
 .label { font-family: [z] Arista; font-weight:bold ;color:#ecc701;}

h1{color:#ecc701;}
</style>
</head>


<body bgcolor=#302d30 >
 <s:if test="hasActionErrors()">
    <h1 >  <s:actionerror/></h1>
</s:if>
<div class="initiallyHidden" align="center" >
<s:form action="login" method="POST" >
<s:textfield name="username"  label="User Name"  />
<s:password name="password" label="Password"/>
<s:submit type="image" src="images/login.png" value="" align="center"></s:submit>
</s:form>
<h3 style="color:#ecc701;">New User?</h3><a href="signup.action" ><img src="images/signup.png" alt="Submit" width="72" height="36" ></a>
</div>
<p align="center"><img src="images/bird.png" alt="Click to Login"  class="btn2"  > </p>
</body>