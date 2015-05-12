//<SCRIPT type=text/javascript>
        function Fn_ValidateItems(form)
        {
        if (!Fn_ValidateItem(form,"ARRIVAL_DATE","Arrival Date","isdate"))	return false;
        if (!Fn_ValidateItem(form,"ARRIVAL_DATE","Arrival Date","isNull"))	return false;
        if (!Fn_ValidateItem(form,"ARRIVAL_COUNTRY","Arrival Country","isNull"))	return false;
        if(!Fn_ValidateItem(form, "ARRIVAL_COUNTRY", "Arrival Country", "isCombo")) return false;
        if (!Fn_ValidateItem(form,"ARRIVAL_CITY","City","isNull"))	return false;
        if (!Fn_ValidateItem(form,"RESIDENCE_PHONE","Phone","isNull"))	return false;
        if (!Fn_ValidateItem(form,"MOBILE","Mobile","isNull"))	return false;
        if (!Fn_ValidateItem(form,"RESIDENCE","RESIDENCE","isNull"))	return false;

   

        return true;
        }
//    </SCRIPT>
