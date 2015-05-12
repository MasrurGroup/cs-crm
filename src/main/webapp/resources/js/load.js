	
	var afterHashParameters = location.hash.toString();
	var accessTokenStartIndex = afterHashParameters.indexOf("=") + 1;
    var accessTokenEndIndex = afterHashParameters.indexOf("&");
    
    var accessToken = afterHashParameters.substring(accessTokenStartIndex,accessTokenEndIndex);
    
    var accessTokenHiddenInput = document.getElementById("accessToken");
    accessTokenHiddenInput.value = accessToken;
