function show(e) {
  if(e.tagName !== undefined) {
    e = $(e);
  }
  e.show();
  $("fieldset").trigger("check");
}

function hide(e) {
  if(e.tagName !== undefined) {
    e = $(e);
  }
  e.hide();
  $("fieldset").trigger("check");
}

function checkSection(s) {
  var visibleChildren = false;
  $.each($(s).children("div,fieldset"), function(i, e) {
    if($(e).css("display") != "none") {
      visibleChildren = true;
    }
  });
  
  if(visibleChildren) {
    $(s).show();
  } else {
    $(s).hide();
  }
}

// Todo: Refactor switching
function getFormValue(id) {
	// Select has a tagname...
	tagname = $(id)[0].tagName;
	if(tagname == "SELECT") {
		if($("#sellingPrice").val() === "true") {
			return true;
		} else {
			return false;
		}
	}
	// Other elements have a type:
	type = $(id).attr("type");
	switch(type) {
		case "checkbox": return $(id).is(":checked"); 
		default: return $(id).val();
	}
}

// Todo: refactor as well
function setFormValue(id, val) {
	tagname = $(id)[0].tagName;
	if(tagname == "SELECT") {
		if(val) {
			$(id).val("true");
		} else if(!val) {
			$(id).val("false");
		} else {
			$(id).val("undefined");
		}
		return ;
	}
	// Other elements have a type:
	type = $(id).attr("type");
	switch(type) {
		case "checkbox": $(id).prop("checked", val);
		default: $(id).val(val);
	}
	$(id).change();
}

$(document).on("check", "fieldset", function(e) {
  checkSection(e.target);
});
