function evalConditions() {
  /* each conditional */
  $("[data-conditional='true']").each(function() {
        var method = new Function("return " + $(this).data('condition'));
        if (method() == true) {
            console.log('yes');
          $(this).children('.success-elements').show();
          $(this).children('.else-elements').hide();
        }
        else {
            console.log('no ' + $(this).data('condition'));
          $(this).children('.success-elements').hide();
          $(this).children('.else-elements').show();
        }
    });
}
 
function evalExpressions() {
  $('[data-expression]').filter(
      function() {
          return ($(this).attr('data-expression').length > 0);
      }).each(function() {
        var expression = new Function("return " + $(this).data('expression'));
        $(this).val(expression());
    });
}

function getValue(field) {
    if ($(field).is(':checkbox')) return $(field).prop('checked');
    else return $(field).val();
}

function onChange() {
    $('input').change(function() { evalConditions(); evalExpressions(); });
}

$(document).ready(function() { evalConditions(); evalExpressions(); onChange(); });