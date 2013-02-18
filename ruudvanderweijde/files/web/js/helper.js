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
  data = $(':input:visible', 'form').serialize();
  $.post(window.location, data, success, 'json')
  	.fail(function() { alert("Invalid data returned."); });
  // prevent normal submit method
  return false;
}

function success (data) {
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
}