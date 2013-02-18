ql = {};
ql.variableMap = {};

ql.messageBus = Base.extend({
    initialize : function() {
        this.variableListeners = {};
    },

    subscribeToVariable : function(variable, listener) {
        if (!this.variableListeners[variable]) {
            this.variableListeners[variable] = [];
        }
        this.variableListeners[variable].push(listener);
    },

    signalVariableChanged : function(variable) {
        if (this.variableListeners[variable]) {
            jQuery.each(this.variableListeners[variable], function(index, value) {
                value.dependenciesChanged();
            });
        }
    }
}).new();

ql.QuestionController = Base.extend({
    initialize : function(questionName) {
        this.questionName = questionName;
        this.view = $("#" + this.questionName);
    },

    bind : function() {
        var that = this;
        this.view.on("change", function() {
            that.validateInput(function() {
                var value = that.parseValue(that.view);
                ql.variableMap[that.questionName] = value;
                ql.messageBus.signalVariableChanged(that.questionName);
            }, function(errorMessage){
                alert(errorMessage);
            });
        });
    },

    validateInput : function(successCallback, failureCallback) {
        var that = this, data = {identifierName : that.questionName, value : that.view.val()};
        $.ajax({
            type: "POST",
            url: $(location).attr('href') + "validate/" + that.getValidationSuffix() + "/",
            data: JSON.stringify(data),
            success: successCallback,
            error : function(jqXHR) {
                failureCallback(jqXHR.responseText);
            },
            contentType: 'application/json'
        });
    }
});

ql.IntegerTypeQuestionController = ql.QuestionController.extend({
    parseValue : function(element) {
        return parseInt(element.val());
    },

    getValidationSuffix : function() {
        return "integer";
    }
});

ql.BooleanTypeQuestionController = ql.QuestionController.extend({
    parseValue : function(element) {
        return element.is(":checked");
    },

    getValidationSuffix : function() {
        return "boolean";
    }
});

ql.StringTypeQuestionController = ql.QuestionController.extend({
    parseValue : function(element) {
        return element.val();
    },

    getValidationSuffix : function() {
        return "string";
    }
});

ql.ComputationController = Base.extend({
    initialize: function(computationName) {
        this.computationName = computationName;
        this.view = $("#" + this.computationName);
    },

    dependenciesChanged : function() {
        var expressionOutcome = this.evaluateExpression();
        this.view.val(expressionOutcome);
        if (expressionOutcome !== "") {
            ql.variableMap[this.computationName] = expressionOutcome;
            ql.messageBus.signalVariableChanged(this.computationName);
        }
    }
});

ql.ConditionalController = Base.extend({
    initialize : function(conditionalName) {
        this.conditionalName = conditionalName;
        this.view = $("#" + this.conditionalName);
    },

    dependenciesChanged : function() {
        var booleanOutcome = this.evaluateExpression();
        this.toggle(booleanOutcome);
    },

    toggle : function(booleanValue) {
        if (booleanValue) {
            this.onConditionalTrue();
        } else {
            this.onConditionalFalse();
        }
    }
});

ql.IfStatementController = ql.ConditionalController.extend({
    initialize : function(conditionalName) {
        ql.ConditionalController.initialize.call(this, conditionalName);
    },

    onConditionalTrue : function() {
        this.view.find(".successBody").removeClass("hidden");
    },

    onConditionalFalse : function() {
        this.view.find(".successBody").addClass("hidden");
    }
});

ql.IfElseStatementController = ql.ConditionalController.extend({
    initialize : function(conditionalName) {
        ql.ConditionalController.initialize.call(this, conditionalName);
    },

    onConditionalTrue : function() {
        this.view.find(".successBody").removeClass("hidden");
        this.view.find(".failureBody").addClass("hidden");
    },

    onConditionalFalse : function() {
        this.view.find(".successBody").addClass("hidden");
        this.view.find(".failureBody").removeClass("hidden");
    }
});