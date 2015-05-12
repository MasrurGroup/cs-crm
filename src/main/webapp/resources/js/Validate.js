/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



function Fn_ValidateItem(form, fieldName, fieldTitle, validationType)
{
	var Source = (document.getElementsByName(fieldName))[0];
	var Error = false;
	switch (validationType.toString().toLowerCase())
	{
		case 'isnull':
			if (Source.value == '')
			{
				alert( fieldTitle + " - This Field is required" );
				Error = !Error;
			}
			break;

		case 'isnumber':
			if ( isNaN(Source.value) )
			{
				alert( fieldTitle + " - Value must be a Number" );
				Error = !Error;
			}
			break;

		case 'iscombo':
			if (Source.value == '%null%' || Source.value == '')
			{
				alert( fieldTitle + " - Could not be left blank, as well as select from the list" );
				Error = !Error;
			}
			break;
			
		case 'isemail':
			if (! Fn_EmailCheck(Source.value))
			{
				alert( fieldTitle + " - Not in the right email format" );
				Error = !Error;
			}
			break;

		case 'isdate':
			var Result = Fn_isDate(Source);
			if (Result != ' ')
			{
				alert(fieldTitle + Result);
				Error = !Error;
			}
			break;
		
		case 'isaftertoday':
			if (! Fn_AfterToday(Source.value) )
			{
				alert( fieldTitle + " - Can not be less than today's date" );
				Error = !Error;
			}
			break;

		case 'isbeforetoday':
			if (! Fn_BeforeToday(Source.value))
			{
				alert( fieldTitle + " - Can not be greater than today's date" );
				Error = !Error;
			}
			break;

		case 'ismoney':
			var Result = Fn_isMoney(Source);
			if (Result != ' ')
			{
				alert(fieldTitle + Result);
				Error = !Error;
			}
			break;

		case 'istime':
			var Result = Fn_isTime(Source);
			if (Result != ' ')
			{
				alert(fieldTitle + Result);
				Error = !Error;
			}
			break;
                 case 'isssn':
			if (Source.value.length != 14)
			{
				alert(fieldTitle + "- Must be 14 number" );
				Error = !Error;
			}
			break;
		
		case 'isfile':
			var extArray = new Array(".doc", ".txt", ".pdf", ".xls", ".bmp", ".gif", ".jpg", ".png");
			var allowSubmit = false;
			if (Source.value == '')
				return true;
			var temp = Source.value;
			while (temp.indexOf("\\") != -1)
				temp = temp.slice(temp.indexOf("\\") + 1);
			ext = temp.slice(temp.indexOf(".")).toLowerCase();
			for (var i=0; i<extArray.length; i++)
				if (extArray[i] == ext)
				{
					allowSubmit = true;
					break;
				}
			if (!allowSubmit)
			{
				alert( fieldTitle + " - Incorrect Extension " + "\n" + (extArray.join(" ")) + " Allowed Extension" );
				Error = !Error;
			}
			break;

		default:
			alert( "Error" );
			return false;
			break;
	}

	if (Error)
	{
		Fn_Blink(fieldName);
		Source.focus();
		if (validationType.toString().toLowerCase() != 'isnull' && validationType.toString().toLowerCase() != 'iscombo')
			Source.select();
		return false;
	}
	return true;
}

function Fn_Blink(target)
{
	color1 = "#feff6f";	// blinking color
	color2 = "#ffffff"; // background color
	swap   = false;
	for (var i=0 ; i<=2250 ; i=i+250)
	{
		if (swap = !swap)	setTimeout('Fn_Blink_Exec("' + target + '", "' + color1 + '")', i);
		else				setTimeout('Fn_Blink_Exec("' + target + '", "' + color2 + '")', i);
	}
}
function Fn_Blink_Exec(target, color)
{	(document.getElementsByName(target))[0].style.backgroundColor = color;	}

// Administration Buttons flipping [Add OR Update\Delete]
function Fn_FlipButtons(form, fieldName)
{
	fieldName = Fn_GetFullFieldName(form, fieldName);
	var field = document.getElementsByName(fieldName);
	if (field[0].value == '')
	{
		document.getElementById('divInsert').style.display = 'block';
		document.getElementById('divUpdateDelete').style.display = 'none';
	}
	else
	{
		document.getElementById('divInsert').style.display = 'none';
		document.getElementById('divUpdateDelete').style.display = 'block';
	}
}
// Helper Function to get the Field's Full name
function Fn_GetFullFieldName(form, fieldName)
{
	var slices;
	for(var i=0; i<form.length; i++)
	{
		slices = form.elements[i].name.split(".");
		if (slices[1] == 'DEFAULT' && slices[3] == '01')
			return (slices[0] + '.' + slices[1] + '.' + fieldName.toString().toUpperCase() + '.01');
	}
	return null;
}

function Fn_Confirm_Password(form, fieldName1, fieldName2)
{
	var fieldName1 = Fn_GetFullFieldName(form, fieldName1);
	var fieldName2 = Fn_GetFullFieldName(form, fieldName2);
	var Pass1 = (document.getElementsByName(fieldName1))[0];
	var Pass2 = (document.getElementsByName(fieldName2))[0];
	if (Pass1.value.length < 6)
	{
		alert ('The Password - Must be (6-30) digits and contain at least one number');
		Fn_Blink(Pass1);
		Pass1.focus();
		Pass1.select();
		return false;
	}
	var ContainsNumber = false;
	for (var i=0 ; i<Pass1.value.length ; i++)
	{
		if (!isNaN ( Pass1.value.charAt(i) ) )
		{
			ContainsNumber = true;
			break;
		}
	}
	if (!ContainsNumber)
	{
		alert ('The password must contain at least one number');
		Fn_Blink(Pass1);
		Pass1.focus();
		Pass1.select();
		return false;
	}
	if (Pass1.value != Pass2.value)
	{
		alert ('The retyped password no the ');
		Fn_Blink(Pass1);
		Pass1.focus();
		Pass1.select();
		return false;
	}
	return true;
}

function Fn_AfterToday(dt)
{	
	// If Empty
	if (dt.length == 0 ) return true;

	var today = new Date();
	var Date1 = Date.parse(today.getDate()+'-'+(today.getMonth()+1)+'-'+today.getFullYear());
	var Date2 = Date.parse(dt);
	return Date1 <= Date2;
}

function Fn_BeforeToday(dt)
{
	// If Empty
	if (dt.length == 0) return true;
	
	var today = new Date();
	var Date1 = Date.parse(today.getDate()+'-'+(today.getMonth()+1)+'-'+today.getFullYear());
	var Date2 = Date.parse(dt);
	return Date1 >= Date2;
}

//	Compares two Dates - Returns true if Date1 is smaller or equal to Date2
function Fn_CompareDates(form, fieldName1, fieldTitle1, fieldName2, fieldTitle2)
{
	var fieldName1 = Fn_GetFullFieldName(form, fieldName1);
	var fieldName2 = Fn_GetFullFieldName(form, fieldName2);

	var Source1 = (document.getElementsByName(fieldName1))[0];
	var Source2 = (document.getElementsByName(fieldName2))[0];
	if (Source1.value == '' || Source2.value == '')	return true;

	var Date1 = Date.parse(Source1.value);
	var Date2 = Date.parse(Source2.value);

	if (Date1 >= Date2)
	{
		alert(fieldTitle1 + "Must be less than " + fieldTitle2);
		Fn_Blink(fieldName1);
		Source1.focus();
		Source1.select();
		return false;
	}
	else
		return true;
}

function Fn_GetParameter(parameter)
{
	var Temp = window.location.toString();
	var Temp = Temp.split('?');
	while (Temp[1].indexOf('%') != -1)
		Temp[1] = Temp[1].replace('%26', '&');
	var Params = Temp[1].split('&');
	var Param;
	for (var i=0 ; i<Params.length ; i++)
	{
		Param = Params[i].split('=');
		if (Param[0].toString().toLowerCase() == parameter.toString().toLowerCase())
			return Param[1];
	}
}

function Fn_Insert()	{	document.getElementById("btnInsert").click();	}	// Clicks on the button "Insert" [Server Side]
function Fn_Query()		{	document.getElementById("btnQuery").click();	}	// Clicks on the button "Query"  [Server Side]
function Fn_Update()	{	document.getElementById("btnUpdate").click();	}	// Clicks on the button "Update" [Server Side]
function Fn_Delete()	{	document.getElementById("btnDelete").click();	}	// Clicks on the button "Delete" [Server Side]
function Fn_Flip()		{	document.getElementById("btnFlip").click();		}	// Clicks on the button "Flip"   [Server Side]
function Fn_Find()		{	document.getElementById("btnFind").click();		}	// Clicks on the button "Find"   [Server Side]
function Fn_Reset()		{	document.getElementById("btnReset").click();	}	// Clicks on the button "Reset"  [Server Side]

function Fn_Continue()		{	document.getElementById("btnContinue").click();	}	// Clicks on the button "Continue"  [Server Side]
function Fn_DeleteConfirmation()	{	return confirm('are you sure you want to delete?');	}	// Confirms before Deleting  [Client Side]

function Fn_EmailCheck(emailStr)
{
	if (emailStr == '')
		return true;
	var checkTLD=1;
	var knownDomsPat=/^(com|net|org|edu|int|mil|gov|arpa|biz|aero|name|coop|info|pro|museum)$/;
	var emailPat=/^(.+)@(.+)$/;
	var specialChars="\\(\\)><@,;:\\\\\\\"\\.\\[\\]";
	var validChars="\[^\\s" + specialChars + "\]";
	var quotedUser="(\"[^\"]*\")";
	var ipDomainPat=/^\[(\d{1,3})\.(\d{1,3})\.(\d{1,3})\.(\d{1,3})\]$/;
	var atom=validChars + '+';
	var word="(" + atom + "|" + quotedUser + ")";
	var userPat=new RegExp("^" + word + "(\\." + word + ")*$");
	var domainPat=new RegExp("^" + atom + "(\\." + atom +")*$");
	var matchArray=emailStr.match(emailPat);
	
	if (matchArray==null)
		return false;
	var user=matchArray[1];
	var domain=matchArray[2];
	for (i=0; i<user.length; i++)
		if (user.charCodeAt(i)>127)
			return false;
	for (i=0; i<domain.length; i++)
		if (domain.charCodeAt(i)>127)
			return false;
	if (user.match(userPat)==null)
		return false;
	var IPArray=domain.match(ipDomainPat);
	if (IPArray!=null)
	{
		for (var i=1;i<=4;i++)
			if (IPArray[i]>255)
				return false;
		return true;
	}
	var atomPat=new RegExp("^" + atom + "$");
	var domArr=domain.split(".");
	var len=domArr.length;
	for (i=0;i<len;i++)
		if (domArr[i].search(atomPat)==-1)
			return false;
	if (checkTLD && domArr[domArr.length-1].length!=2 && domArr[domArr.length-1].search(knownDomsPat)==-1)
		return false;
	if (len<2)
		return false;
	return true;
}

function Fn_isDate(fieldName)
{
	// If Empty
	if (fieldName.value.length == 0 ) return ' ';

	var d_MonthDays = '31,28,31,30,31,30,31,31,30,31,30,31'.split(',');
	var d_Year=0, d_Month=0, d_Day=0, DateParts;
	DateParts = fieldName.value.split('-');
	if (DateParts.length < 3)
		return "- Must be in the format 15-05-2007";

	d_Day   = DateParts[0];
	d_Month = DateParts[1];
	d_Year  = DateParts[2];

	// Check for Year
	if (d_Year.length != 4)
		return " - Wrong year";

	// Add zero to Day and Month
	if ( d_Day   < 10 && d_Day.length   == 1 )	d_Day   = '0' + d_Day;
	if ( d_Month < 10 && d_Month.length == 1 )	d_Month = '0' + d_Month;
	fieldName.value = d_Day + '-' + d_Month + '-' + d_Year;
	
	// Not formatted well
	var filter=/^[0-9]{2}-[0-9]{2}-[0-9]{4}$/;
	if (! filter.test(fieldName.value))
		return "- Must be in the format 15-05-2007";

	// Check for Month
	if ( d_Month < 1 || d_Month > 12 )
		return " - الشهر غير صحيح";

	// Check For Leap Year
	var N = Number(d_Year);
	if ( ( N%4 == 0 && N%100 != 0 ) || ( N%400 == 0 ) )
		d_MonthDays[1] = 29;

	// Check for Day
	if ( d_Day < 1 || d_Day > d_MonthDays[d_Month-1] )
		return " - Wrong day";
	return ' ';
}

function Fn_isTime(fieldName)
{
	// If Empty
	if (fieldName.value.length == 0 ) return ' ';
	
	var tParts = fieldName.value.split(':');
	if (tParts.length < 2) return " - Must be in the format 15:30";
	
	// Add zero to Day and Month
	if ( tParts[0] < 10 && tParts[0].length == 1 )	tParts[0] = '0' + tParts[0];
	if ( tParts[1] < 10 && tParts[1].length == 1 )	tParts[1] = '0' + tParts[1];
	fieldName.value = tParts[0] + ':' + tParts[1];

	// Not formatted well
	var filter=/^[0-9]{2}:[0-9]{2}$/;
	if (! filter.test(fieldName.value))
		return  " - Must be in the format 15:30";
	
	if ( tParts[0] > 23 ) return " - Wrong hour";
	if ( tParts[1] > 59 ) return " - Wrong minutes";
	return ' ';
}

function Fn_isMoney(fieldName)
{
	// If Empty
	if (fieldName.value.length == 0 ) return ' ';
	
	var mParts = fieldName.value.split('.');
	if (mParts.length == 2)
		if (mParts[1].length > 2)
			return " - Piaster Can not exceed two digits";
	
	if ((fieldName.value.length > 7 && fieldName.value.indexOf('.') == -1) ||
		(fieldName.value.length > 10 && fieldName.value.indexOf('.') != -1))
		return " - Money Can not exceed 7 digits";
	else if (fieldName.value.indexOf('.') == -1)
		fieldName.value = fieldName.value + '.00';
	
	return ' ';
}

// FrontPage functions for the Interactive buttons
function FP_preloadImgs()
{
	var d=document,a=arguments; if(!d.FP_imgs) d.FP_imgs=new Array();
	for(var i=0; i<a.length; i++) { d.FP_imgs[i]=new Image; d.FP_imgs[i].src=a[i]; }
}
function FP_swapImg()
{
	var doc=document,args=arguments,elm,n; doc.$imgSwaps=new Array(); for(n=2; n<args.length;
	n+=2) { elm=FP_getObjectByID(args[n]); if(elm) { doc.$imgSwaps[doc.$imgSwaps.length]=elm;
	elm.$src=elm.src; elm.src=args[n+1]; } }
}
function FP_getObjectByID(id,o)
{
	var c,el,els,f,m,n; if(!o)o=document; if(o.getElementById) el=o.getElementById(id);
	else if(o.layers) c=o.layers; else if(o.all) el=o.all[id]; if(el) return el;
	if(o.id==id || o.name==id) return o; if(o.childNodes) c=o.childNodes; if(c)
	for(n=0; n<c.length; n++) { el=FP_getObjectByID(id,c[n]); if(el) return el; }
	f=o.forms; if(f) for(n=0; n<f.length; n++) { els=f[n].elements;
	for(m=0; m<els.length; m++){ el=FP_getObjectByID(id,els[n]); if(el) return el; } }
	return null;
}
function Fn_CheckEnter(e)
{
	var characterCode;
	if(e && e.which)
	{
		e = e;
		characterCode = e.which;
	}
	else
	{
		e = event;
		characterCode = e.keyCode;
	}

	if(characterCode == 13)
		return false ;
	else
		return true;
}
function Fn_ReportPrintPreview()
{
	var vCode = Fn_GetParameter('Code');
	var vIndex = location.toString().indexOf('_') + 1;
	var vType = location.toString().charAt(vIndex);
	var vURL = '/portal/pls/portal/MOHE.RM_DEPUTATION_'+vType+'.show?p_arg_names=Code&p_arg_values='+vCode;
	window.open(vURL, '_self');
}
function Fn_LimitTextArea(fieldName)
{
	var Source = (document.getElementsByName(fieldName))[0];
	if (Source.value.length > 2000)
	{
		alert('Can not exceed 2000 digit');
		Fn_Blink(fieldName);
		Source.focus();
		Source.select();
		return false;
	}
	return true;
}
function Fn_LimitTextArea_Key(fieldName)
{
        var Source = (document.getElementsByName(fieldName))[0];        
	if (Source.value.length >= 2000)
		return false;
	return true;
}
