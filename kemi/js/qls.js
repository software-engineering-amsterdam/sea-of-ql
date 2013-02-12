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
		if($(id).val() === "true") {
			return true;
		} else {
			return false;
		}
	}
	// Other elements have a type:
	type = $(id).attr("type");
	switch(type) {
		case "checkbox": 
			return $(id).is(":checked"); 
		default: 
			return $(id).val();
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
		return;
	}
	// Other elements have a type:
	type = $(id).attr("type");
	switch(type) {
		case "checkbox": 
			$(id).prop("checked", val);
			break;
		case "money": 
			$(id).val(roundMoney(val));
			break;
		default: $(id).val(val);
	}
	$(id).change();
}

$(document).on("check", "fieldset", function(e) {
  checkSection(e.target);
});

function roundMoney(amount) {
	return (new Number(amount)).toFixed(2);
}

function numDecimals(value) {
  var valueStr = value.toString();
  var sepPos = valueStr.indexOf(".");
  if(sepPos > -1) {
    return valueStr.length - sepPos - 1;
  } else {
    return 0;
  }
}

// Each money field can only contain up to two decimals. 
jQuery.validator.addMethod("moneyValidator", function(value, element, params) {
	return this.optional(element) || numDecimals(value) <= 2; 
	}, jQuery.format("The money field can only contain up to 2 decimals.")
);


function button(text) {
  return $("<button />")
    .text(text || id);
}

function prevButton() {
  return button("Previous");
}

function nextButton() {
  return button("Next");
}

function showPage(page) {
  $(".page").hide();
  $(page).show();
}

function paginate() {
  var pages = $(".page");
  if(pages.length == 0) {
    return;
  }
  
  if(pages.length > 1) {
    $.each(pages, function(i, page) {
      if(i > 0) {
        prevButton()
          .click(function(e) {
            e.preventDefault();
            showPage(pages[i - 1]);
          })
          .appendTo(page);
      }
      if(i < pages.length - 1) {
        nextButton()
          .click(function(e) {
            e.preventDefault();
            if($(page).find("input, select").valid()) {
              showPage(pages[i + 1]);
            }
          })
          .appendTo(page);
      }
    });
    
    showPage(pages.first());
  }
  
  $("#submit").appendTo(pages.last());
}

