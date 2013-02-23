function show(e) {
  if(e.tagName !== undefined) {
    e = $(e);
  }
  e.show();
  e.find("*[touched=touched]").change();
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

function getFormValue(id) {
	// Select has a tagname...
	tagname = $(id)[0].tagName;
	if(tagname == "SELECT") {
		return $(id).val() === "true";
	}
	// Other elements have a type:
	type = $(id).attr("type");
	switch(type) {
		case "checkbox": 
		case "radio":
			return $(id).is(":checked");
		default: 
			return $(id).val();
	}
}

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

function addPage(ident, name, parentIdent) {
  $("<div />")
    .attr({
      id: ident,
      class: "page"
    })
    .append(
      $("<h1 />").text(name)
    )
    .appendTo($("#" + parentIdent));
}

function addSection(ident, name, parentIdent) {
  $("<fieldset />")
    .attr({
      id: ident,
      class: "section"
    })
    .append(
      $("<legend />").text(name)
    )
    .appendTo($("#" + parentIdent));
}

function addQuestion(ident, parentIdent) {
  $("#" + ident)
    .appendTo($("#" + parentIdent));
}

function addText(ident) {
  $("#" + ident)
    .replaceWith(
      $("<input />")
        .attr({
          id: ident,
          name: ident,
          type: "text",
          disabled: $("#" + ident).is(":disabled")
        })
    );
}

function addNumber(ident, min, max, step) {
  $("#" + ident)
    .replaceWith(
      $("<input />")
        .attr({
          id: ident,
          name: ident,
          type: "number",
          min: function() {
            if(min < 0) {
              return undefined;
            } else {
              return min;
            }
          },
          max: function() {
            if(max < 0) {
              return undefined;
            } else {
              return max;
            }
          },
          step: function() {
            if(step < 0) {
              if($("#" + ident).attr("type") === "money") {
                return 0.01;
              } else {
                return 1;
              }
            } else {
              return step;
            }
          },
          disabled: $("#" + ident).is(":disabled")
        })
    );
}

function addSlider(ident, min, max, step) {
  $("#" + ident)
    .replaceWith(
      $("<span />")
        .append(
          $("<input />")
            .attr({
              id: ident,
              name: ident,
              type: "range",
              value: "0",
              min: min,
              max: max,
              step: function() {
                if(step < 0) {
                  if($("#" + ident).attr("type") === "money") {
                    return 0.01;
                  } else {
                    return 1;
                  }
                } else {
                  return step;
                }
              },
              disabled: $("#" + ident).is(":disabled")
            })
            .change(function() {
              $("#" + ident + "Display").text($(this).val());
            })
        )
        .append(
          $("<span />")
            .attr({
              id: ident + "Display"
            })
            .text(0)
        )
    );
}

function addRadio(ident) {
  $("#" + ident)
    .replaceWith(
      $("<span />")
        .append(
          $("<input />")
            .attr({
              id: ident,
              name: ident,
              value: "true",
              type: "radio",
              disabled: $("#" + ident).is(":disabled")
            })
        )
        .append(
          $("<label />")
            .attr({
              for: ident
            })
            .text("Yes")
        )
        .append(
          $("<input />")
            .attr({
              id: ident + "False",
              name: ident,
              value: "false",
              type: "radio",
              disabled: $("#" + ident).is(":disabled")
            })
        )
        .append(
          $("<label />")
            .attr({
              for: ident + "False"
            })
            .text("No")
        )
    );
}

function addCheckbox(ident) {
  $("#" + ident)
    .replaceWith(
      $("<span />")
        .append(
          $("<input />")
            .attr({
              id: ident,
              name: ident,
              value: "true",
              type: "checkbox",
              disabled: $("#" + ident).is(":disabled")
            })
        )
        .append(
          $("<label />")
            .attr({
              for: ident
            })
            .text("Yes")
        )
    );
  
  $("#" + ident)
    .rules("remove");
}


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
            if($(page).find("input:visible, select:visible").valid()) {
              for(var j = i + 1; j < pages.length; j++) {
                showPage(pages[j]);
                if($(pages[j]).find(
                      "input[type!=submit]:visible, select:visible"
                    ).length > 0) {
                  // There is content on this page
                  break;
                } else if(j == pages.length - 1) {
                  // Reached the end, still no content found, submit the form
                  $("#submit").click();
                }
              }
            }
          })
          .appendTo(page);
      }
    });
    
    showPage(pages.first());
  }
  
  $("#submit").appendTo(pages.last());
}

