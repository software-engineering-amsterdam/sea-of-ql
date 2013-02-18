window.onbeforeunload = confirmExit;
function confirmExit() {
  return "";
}

function getValueOf(id) {
    $elm = $('#'+id);
    if ($elm.is('input')) {
        if ($elm.is('input:checkbox')) {
            if ($elm.is(':checked')) {
                return true;
            } else {
                return false;
            }
        } else {
            return $elm.val();
        }
    } else {
        // unsupported type;
        return false;
    }
}

function customSubmit() {
  url = '/QLServer/Controller?form='+GetURLParameter("form");
  data = $(this).serialize();
   
  $.ajax(
    {
      type: "POST",
      url: url,
      data: data,
      success: function (data) {
        if (data.Errors && data.Errors.length) {
          var errorString = "Errors found. Please correct the following errors: \r\n\r\n";
          for(var error in data.Errors) {
            errorString += data.Errors[error] + "\r\n";
          }
          alert(errorString);
        } else {
          alert("Your form has been submitted. Thank you.");
          $('form')[0].reset();
        }
      },
      dataType: "json"
    }
  )
  .fail(function() { alert("Invalid data returned."); });
  // prevent normal submit method
  return false;
}

function GetURLParameter(sParam) {
	var sPageURL = window.location.search.substring(1);
	var sURLVariables = sPageURL.split('&');
	for ( var i = 0; i < sURLVariables.length; i++) {
		var sParameterName = sURLVariables[i].split('=');
		if (sParameterName[0] == sParam) {
			return sParameterName[1];
		}
	}
}