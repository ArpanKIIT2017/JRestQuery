/**
 * Client Side Validation logic for transactions
 */

function validateTransaction(p1,p2,p3,p4,p5,p7,qty,rate)
{
	document.getElementById("valErr").innerHTML="";
	isValidMsg(p1);isValidMsg(p2);isValidMsg(p3);isValidMsg(p4);isValidMsg(p5);isValidMsg(p6);isValidMsg(p7);isValidMsg(qty);isValidMsg(rate);
	
	
	if(isValid(p1)&&isValid(p2)&&isValid(p3)&&isValid(p4)&&isValid(p5)&&isValid(p6)&&isValid(p7)&&isValid(qty)&&isValid(rate))
	{
		if((!isNaN(qty.value))&&(!isNaN(rate.value)))
			{
			return true;
			}
			
		else
			
		{
			temp=document.getElementById("valErr").innerHTML;
			document.getElementById("valErr").innerHTML=temp+"Invalid rate or quantity values..";
			alert("Invalid Data!!");
				return false;
			}
			
	}
	else
	{
		alert("Invalid Data!!");
		return false;
	}
		
	
}

function isValid(param)
{
	val=param.value;
	
	temp=document.getElementById("valErr").innerHTML;
	
	if(val==null|| val=="" || val==" ")
	{
		//document.getElementById("valErr").innerHTML=temp+"Required Field "+param.name+" Value missing<br>";
		return false;
	}
	else
	{
		return true;
	}
	
}
function isValidMsg(param)
{
	val=param.value;
	
	temp=document.getElementById("valErr").innerHTML;
	
	if(val==null|| val=="" || val==" ")
	{
		document.getElementById("valErr").innerHTML=temp+"Required Field "+param.name+" Value missing<br>";
		return false;
	}
	else
	{
		return true;
	}
	
}

function checkJSLink()
{
	alert("js working fine");
}

function checkTransType()
{
	//alert("hello");
	val=document.getElementsByName("trans_type")[0].value;
	
	if(val==1)//Purchase
	{
		document.getElementsByName("item_id")[0].readOnly=false;
		document.getElementsByName("trans_date")[0].readOnly=false;
		document.getElementsByName("supplier_id")[0].readOnly=false;
		document.getElementsByName("dept_id")[0].readOnly=false;
		document.getElementsByName("doc_date")[0].readOnly=false;
		document.getElementsByName("doc_id")[0].readOnly=false;
		document.getElementsByName("qty")[0].readOnly=false;
		document.getElementsByName("rate")[0].readOnly=false;
		document.getElementsByName("naration")[0].readOnly=false;
		document.getElementsByName("remark")[0].readOnly=false;
		
		document.getElementsByName("supplier_id")[0].hidden=false;
		document.getElementsByName("rate")[0].hidden=false;
		
		document.getElementsByName("supplier_id")[0].required=true;
	}
	else if(val==2)//Issue
	{
		document.getElementsByName("item_id")[0].readOnly=false;
		document.getElementsByName("trans_date")[0].readOnly=false;
		document.getElementsByName("supplier_id")[0].readOnly=false;
		document.getElementsByName("dept_id")[0].readOnly=false;
		document.getElementsByName("doc_date")[0].readOnly=false;
		document.getElementsByName("doc_id")[0].readOnly=false;
		document.getElementsByName("qty")[0].readOnly=false;
		document.getElementsByName("rate")[0].readOnly=false;
		document.getElementsByName("naration")[0].readOnly=false;
		document.getElementsByName("remark")[0].readOnly=false;
		
		
		
		//document.getElementsByTagName("input").readOnly=false;
		//document.getElementsByTagName("select").readOnly=false;
		
		document.getElementById("sel").selected=true;
		document.getElementsByName("supplier_id")[0].hidden=true;
		
		document.getElementsByName("rate")[0].value="0";
		document.getElementsByName("rate")[0].hidden=true;
		
		
		document.getElementsByName("supplier_id")[0].required=false;
		
	}
	else
	{
		document.getElementsByName("item_id")[0].readOnly=true;
		document.getElementsByName("trans_date")[0].readOnly=true;
		document.getElementsByName("supplier_id")[0].readOnly=true;
		document.getElementsByName("dept_id")[0].readOnly=true;
		document.getElementsByName("doc_date")[0].readOnly=true;
		document.getElementsByName("doc_id")[0].readOnly=true;
		document.getElementsByName("qty")[0].readOnly=true;
		document.getElementsByName("rate")[0].readOnly=true;
		document.getElementsByName("naration")[0].readOnly=true;
		document.getElementsByName("remark")[0].readOnly=true;
		
		alert("Select a Transaction Type before you can proceed.");
	}
	
}

function restrictDate()
{
	var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth()+1; //January is 0!
	var yyyy = today.getFullYear();
	 if(dd<10){
	        dd='0'+dd
	    } 
	    if(mm<10){
	        mm='0'+mm
	    } 

	today = yyyy+'-'+mm+'-'+dd;
	 document.getElementsByName("trans_date")[0].setAttribute('max', today);
}

function whenLoaded()
{
	restrictDate();
	
}

	