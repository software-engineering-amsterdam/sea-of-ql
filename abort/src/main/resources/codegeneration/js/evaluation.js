
function initAjaxValidation() {
	getQuestionEntities().each(function() {
		$(this).bind('change', function() {
			var entity = this;
			$.ajax({
		     	type: "POST",
		        url: createValidationURL(this),
		        data: '{ "value": "' + getValidationValue(entity) + '" }',
		        contentType: "application/json; charset=utf-8",
		        dataType: "json",
		        success: function(data) {
		        	evaluateValidationData(entity, data);
		        },
		        failure: function(errMsg) {
		            alert('Failed to validate');
		     	}
			});
		});
	});
}

function validateAndPersistForm(form) {
	formEntitiesJSON = JSON.stringify(form.serializeArray());
	var formJSON = {};
	formJSON["name"] = $(form).attr('name');
	formJSON["form"] = $(form).serializeFormJSON();
	
	$.ajax({
     	type: "POST",
        url: getWebServiceURL() + 'persist/',
        data: JSON.stringify(formJSON),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function(data) {
        	if (data == null || !data) {
        		showFailedPersist();
        	}
        	else {
    			showSuccessfulPersist();
        	}
        },
        failure: function(errMsg) {
            alert('Failed to post');
     	}
	});
}

function showFailedPersist() {
	clearPersistMessage();
	$(contents).append('<p class="fail">Failed to persist form: could be related to the lack of input, a failing server, or you being a script kiddy :)</p>');
}

function showSuccessfulPersist() {
	clearPersistMessage();
	$(contents).append('<p class="success">Successfully persisted form</p>');
}

function clearPersistMessage() {
	$(contents).children('p[class="fail"]').remove();
	$(contents).children('p[class="success"]').remove();
}

function evaluateValidationData(entity, data) {
	if (data == null || !data) {
		showInvalidInput(entity);
	}
	else {
		hideInvalidInput(entity);
	}
}

function createValidationURL(entity) {
	return getWebServiceURL() + 'validate' + capitalize($(entity).data('type') + '/');
}

function getWebServiceURL() {
	return serverBaseURL + 'ws/bootstrap/';
}

function showInvalidInput(entity) {
	$(getLabelForEntity(entity)).addClass("input-error");
}

function hideInvalidInput(entity) {
	$(getLabelForEntity(entity)).removeClass("input-error");
}

function getLabelForEntity(entity) {
	return $("label[for='" + $(entity).attr('id') + "']");
}


function evaluateExpression(entity) {
	var id = $(entity).attr('id');
	var value = functionMap[id]();
	
	variableMap[id] = value;
	$(entity).val(isNaN(value) ? "" : value);

	if (isNaN(value)) { showInvalidInput(entity); }
	else { hideInvalidInput(entity); }
}

function evaluateConditional(entity) {
	var id = $(entity).attr('id');
	var value = functionMap[id]();
	
	if (value == true) {
		showConditionalSuccessClause(entity);
	}
	else if (value == false) {
		showConditionalElseClause(entity);
	}
	else {
		console.log("invalid contents to evaluate, probably empty variables or user abuse... hiding success clause only");

		showConditionalElseClause(entity);
	}
}

function showConditionalSuccessClause(entity) {
	$(entity).children('.success-elements').show();
	$(entity).children('.else-elements').hide();
	$(entity).children('.else-elements').find('input').val("");
}

function showConditionalElseClause(entity) {
	$(entity).children('.success-elements').hide();
	$(entity).children('.else-elements').show();
	$(entity).children('.success-elements').find('input').val("");
}

function getQuestionEntities() {
	return $('input:not([readonly])');
}

function getExpressionEntities() {
	var entities = $('[data-expression]').filter(function(){
        return ($(this).attr('data-expression').length > 0);
    });
    
    return (entities.length == 0 ? null : entities);
}

function getConditionEntities() {
	return $("[data-conditional='true']");
}

function getValidationValue(field) {
    if ($(field).is(':checkbox')) return $(field).prop('checked');
    return $(field).val();
}

function getValue(field) {
    if ($(field).is(':checkbox')) return $(field).prop('checked');
    if ($(field).data('type') == "money") return new BigDecimal($(field).val());
    if ($(field).data('type') == "int") return parseInt($(field).val());
    else return $(field).val();
}

function dispatchToDependencies(id) {
	var matchPattern = new RegExp("\\s*variableMap\\['" + id + "'\\]\\s*");
	getExpressionEntities().each(function() {
		var entity = this;
		if (matchPattern.test($(this).data('expression'))) {
	  		evaluateExpression(entity);
		}
	});

	getConditionEntities().each(function() {
		var entity = this;
		if (matchPattern.test($(this).data('condition'))) {
			evaluateConditional(entity);
		}	
	});
}

function doesArrayContainIdReference(expressions, id) {
	var referenceName = "variableMap['" + id + "']";

	$(expressions).each(function(index) {
		if (expressions[index] == referenceName) {
	 		return true;
		}
	});
	return false;
}

function initConditionalGUI() {
	getConditionEntities().each(function() {
		evaluateConditional(this); 
	});
}

function updateGUI(updatedEntity, updatedId) {
    variableMap[updatedId] = getValue(updatedEntity);
	dispatchToDependencies(updatedId);
}

function capitalize(string) {
	if (string == null) return null;
	if (string.length == 0) return "";
	if (string.length == 1) return string[0].toUpperCase();

    return string[0].toUpperCase() + string.slice(1);
}

(function($) {
$.fn.serializeFormJSON = function() {

   var o = {};
   var a = this.serializeArray();
   $.each(a, function() {
       	/* do not serialize hidden fields */
   	   if ($("input[name=" + this.name + "]").is(':hidden')) return true;

       if (o[this.name]) {
           if (!o[this.name].push) {
               o[this.name] = [o[this.name]];
           }
           o[this.name].push(this.value || '');
       } else {
           o[this.name] = this.value || '';
       }
   });
   return o;
};
})(jQuery);