<%@ page import="org.uva.sea.ql.webUI.KnockoutJSViewModelBuilderVisitor" %>
<%@ page import="org.uva.sea.ql.Message" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="org.uva.sea.ql.typechecker.TypecheckerVisitor" %>
<%@ page import="java.util.List" %>
<%@ page import="org.uva.sea.ql.ast.Form" %>
<%@ page import="org.uva.sea.ql.parser.Parser" %>
<%@ page import="org.uva.sea.ql.parser.antlr.ANTLRParser" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <link href="style.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="jquery-1.9.0.min.js"></script>
    <script type="text/javascript" src="knockout-2.2.1.js"></script>
    <script type="text/javascript" src="ko.bindingHandlers/booleanValue.js"></script>
    <script type="text/javascript" src="ko.bindingHandlers/integerValue.js"></script>
    <script type="text/javascript">
        var DataType = {
            BOOLEAN : 0,
            INTEGER : 1,
            STRING  : 2
        };
        var Type = {
            QUESTION : 0,
            BLOCK : 1,
            COMPUTED : 2
        };

        function integerValidator(input) {
            return input == undefined ||
                    (typeof input) == 'number';
        }

        function stringValidator(input) {
            return input == undefined ||
                    input.length > 0;
        }

        function booleanValidator(input) {
            return input == true || input == false;
        }

        function Block(condition, elements) {
            var self = this;
            this.condition = ko.computed(condition);
            this.elements = elements.map(function(element) { element.parent = self; return element; });
            this.type = Type.BLOCK;

            this.required = function() { return (self.parent != undefined ? self.parent.required() : true) && self.condition(); };
            this.valid = function() {
                return elements.every(function(element) { return element.type == Type.COMPUTED || element.valid(); });
            }
            this.collectValues = function() {
                var values = {};
                self.elements.map(function(element) {
                    if((element.type == Type.QUESTION || element.type == Type.BLOCK) && element.required())
                        $.extend(values, element.collectValues());
                });
                return values;
            };
        }

        function Computed(label, expression) {
            this.label = label;
            this.expression = ko.computed(function() {
                var expressionValue = expression();
                if(expressionValue != undefined && !isNaN(expressionValue))
                    return expressionValue;
                else
                    return undefined;
            });
            this.type = Type.COMPUTED;
        }

        function Question(label, name, valueObservable, dataType) {
            var self = this;
            this.label = label;
            this.name = name;
            this.value = valueObservable;
            this.dataType = dataType;
            this.type = Type.QUESTION;

            switch(dataType) {
                case DataType.BOOLEAN:
                    this.validator = booleanValidator;
                    break;
                case DataType.INTEGER:
                    this.validator = integerValidator;
                    break;
                case DataType.STRING:
                    this.validator = stringValidator;
                    break;
            }

            this.required = function() { return self.parent.required(); };
            this.valid = function() { return !self.required() || self.value() != undefined && self.validator(self.value()); };

            this.collectValues = function() {
                var o = {};
                o[self.name] = self.value();
                return o;
            };
        }
    </script>

    <script type="text/html" id="formelement-template">
        <!-- ko if: $data.type == Type.BLOCK && $data.condition() -->
        <!-- ko template: { name: "formelement-template", foreach: $data.elements } --><!-- /ko -->
        <!-- /ko -->
        <!-- ko if: $data.type == Type.QUESTION -->
            <!-- ko template: { name: "question-template", data: $data } --><!-- /ko -->
        <!-- /ko -->
        <!-- ko if: $data.type == Type.COMPUTED -->
            <!-- ko template: { name: "computed-template", data: $data } --><!-- /ko -->
        <!-- /ko -->

    </script>

    <script type="text/html" id="question-template">
        <tr>
            <td data-bind="text: label"></td>
            <td data-bind="css: { invalid : !valid() }">
                <!-- ko if: $data.dataType == DataType.BOOLEAN -->
                    <!-- ko template: { name: "boolean-input-template" } --><!-- /ko -->
                <!-- /ko -->
                <!-- ko if: $data.dataType == DataType.INTEGER -->
                    <!-- ko template: { name: "integer-input-template" } --><!-- /ko -->
                <!-- /ko -->
                <!-- ko if: $data.dataType == $data.dataType == DataType.STRING -->
                    <!-- ko template: { name: "string-input-template" } --><!-- /ko -->
                <!-- /ko -->
            </td>
        </tr>
    </script>

    <script type="text/html" id="computed-template">
        <tr>
            <td data-bind="text: label"></td>
            <td data-bind="text: expression"></td>
        </tr>
    </script>

    <script type="text/html" id="boolean-input-template">
        <label><input type="radio" value="true" data-bind="name: name, booleanValue: value" /> Yes</label>
        <label><input type="radio" value="false" data-bind="name: name, booleanValue: value" /> No</label>
    </script>
    <script type="text/html" id="integer-input-template">
        <input type="text" data-bind="integerValue: value, valueUpdate: 'afterKeyDown'" />
    </script>
    <script type="text/html" id="string-input-template">
        <input type="text" data-bind="value: value, valueUpdate: 'afterKeyDown'" />
    </script>
</head>
<body>

    <table>
        <!-- ko template: { name : "formelement-template", foreach: $root.root.elements } --><!-- /ko -->
    </table>
    <input type="button" value="Send form" data-bind="enable: $root.root.valid(), click: function() {console.log($root.root.collectValues());}"/>

    <script type="text/javascript">
        <%
            final String SAMPLE_FORM =
                    "form Box1HouseOwning {" +
                    "    \"Did you sell a house in 2010?\" hasSoldHouse: boolean" +
                    "    \"Did you by a house in 2010?\" hasBoughtHouse: boolean" +
                    "    \"Did you enter a loan for maintenance/reconstruction?\" hasMaintLoan: boolean" +
                    "    if (hasSoldHouse) {" +
                    "        \"Private debts for the sold house:\" privateDebt: integer" +
                    "        \"Price the house was sold for:\" sellingPrice: integer" +
                    "        \"Value residue:\" sellingPrice - privateDebt" +
                    "    }" +
                    "}";
            Parser parser = new ANTLRParser();
            Form parsedForm = (Form) parser.parse(SAMPLE_FORM);
            List<Message> errors = TypecheckerVisitor.typecheck(parsedForm);
            if(errors.isEmpty()) {
                String viewModel = KnockoutJSViewModelBuilderVisitor.createViewModel(parsedForm);
                out.println(viewModel);
            } else
                out.println("<!-- Errors in script. -->");
        %>
        ko.applyBindings(_viewModel);
    </script>
</body>
</html>