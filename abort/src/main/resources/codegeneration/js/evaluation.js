function initFunctionMap() {
	getExpressionEntities().each(function() {
		initExpressionAsFunction(this);
	});

	getConditionEntities().each(function() {
		initConditionalExpressionAsFunction(this);
	});
}

function evaluateExpression(entity) {
	var id = $(entity).attr('id');
	var value = functionMap[id]();
	
	variableMap[id] = value;
	$(entity).val(value == NaN ? "Invalid or incomplete computation" : value);
}

function evaluateConditional(entity) {
	var id = $(entity).attr('id');
	var value = functionMap[id]();
	
	if (value == true) {
		$(entity).children('.success-elements').show();
		$(entity).children('.else-elements').hide();
	}
	else if (value == false) {
		$(entity).children('.success-elements').hide();
		$(entity).children('.else-elements').show();
	}
	else {
		console.log("invalid contents to evaluate, probably empty variables or user abuse... hiding both until we have clarity");

		$(entity).children('.success-elements').hide();
		$(entity).children('.else-elements').hide();
	}
}

function initExpressionAsFunction(entity) {
	var id = $(entity).attr('id');
	
	functionMap[id] = getExpressionAsFunction($(entity).data('expression'));
}

function initConditionalExpressionAsFunction(entity) {
	var id = $(entity).attr('id');

	functionMap[id] = getExpressionAsFunction($(entity).data('condition'));
}

// function has to return the evaluated expression
function getExpressionAsFunction(expression) {
	return new Function('return ' + expression);
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

function getValue(field) {
    if ($(field).is(':checkbox')) return $(field).prop('checked');
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
	console.log("update for: " + updatedId);
    variableMap[updatedId] = getValue(updatedEntity);
	dispatchToDependencies(updatedId);
}
