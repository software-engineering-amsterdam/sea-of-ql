ql = {};
ql.variableMap = {};

ql.MessageBus = Base.extend({
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
});

ql.QuestionController = Base.extend({
    initialize : function(questionName) {
        this.questionName = questionName;
    },

    bind : function() {
        var that = this, questionElement = $("#" + this.questionName);
        questionElement.on("change", function() {
            var value = that.parseValue(questionElement);
            ql.variableMap[that.questionName] = value;
            ql.messageBus.signalVariableChanged(that.questionName);
        });
    }
});

ql.IntegerTypeQuestionController = ql.QuestionController.extend({
    parseValue : function(element) {
        return parseInt(element.val());
    }
});

ql.BooleanTypeQuestionController = ql.QuestionController.extend({
    parseValue : function(element) {
        return element.is(":checked");
    }
});

ql.StringTypeQuestionController = ql.StringQuestionController.extend({
    parseValue : function(element) {
        return element.val();
    }
});

ql.ComputationController = Base.extend({
    initialize: function(computationName) {
        this.computationName = computationName;
    },

    dependenciesChanged : function() {
        var expressionOutcome = this.evaluateExpression();
        $("#" + this.computationName).val(expressionOutcome);
        if (expressionOutcome !== "") {
            ql.variableMap[this.computationName] = expressionOutcome;
            ql.messageBus.signalVariableChanged(this.computationName);
        }
    }
});