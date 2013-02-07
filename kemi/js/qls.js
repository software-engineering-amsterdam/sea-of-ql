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

$(document).on("check", "fieldset", function(e) {
  checkSection(e.target);
});
