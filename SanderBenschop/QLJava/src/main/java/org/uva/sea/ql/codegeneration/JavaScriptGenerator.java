package org.uva.sea.ql.codegeneration;

import org.apache.commons.lang.WordUtils;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroupFile;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.NodeVisitor;
import org.uva.sea.ql.ast.expression.binary.*;
import org.uva.sea.ql.ast.expression.primary.Bool;
import org.uva.sea.ql.ast.expression.primary.Ident;
import org.uva.sea.ql.ast.expression.primary.Int;
import org.uva.sea.ql.ast.expression.primary.Str;
import org.uva.sea.ql.ast.expression.unary.Negative;
import org.uva.sea.ql.ast.expression.unary.Not;
import org.uva.sea.ql.ast.expression.unary.Positive;
import org.uva.sea.ql.ast.expression.unary.UnaryOperation;
import org.uva.sea.ql.ast.statement.*;
import org.uva.sea.ql.ast.type.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaScriptGenerator implements NodeVisitor<String> {

    private final STGroupFile javaScriptTemplateGroup;

    protected JavaScriptGenerator() {
        this.javaScriptTemplateGroup = new STGroupFile("src/main/resources/templates/qljscode.stg", '$', '$');
    }

    @Override
    public String visitForm(Form form) {
        StringBuilder statementCodeBuilder = new StringBuilder();
        for (Statement statement : form.getStatements()) {
            statementCodeBuilder.append(statement.accept(this));
        }
        return statementCodeBuilder.toString();
    }

    @Override
    public String visitComputation(Computation computation) {
        ST computationTemplate = javaScriptTemplateGroup.getInstanceOf("computation");
        String expressionCode = computation.getExpression().accept(this);
        computationTemplate.add("name", computation.getIdentifier().getName());
        computationTemplate.add("initializationBlock", getExpressionInitializationBlock(expressionCode));
        computationTemplate.add("expression", expressionCode);
        return computationTemplate.render();
    }

    @Override
    public String visitIfStatement(IfStatement ifStatement) {
        StringBuilder ifStatementCodeBuilder = new StringBuilder();
        String expressionCode = ifStatement.getCondition().accept(this), identifier = ConditionalIdentifierGenerator.generateIdentifier(ifStatement);
        ifStatementCodeBuilder.append(renderConditionalJSTemplate(identifier, "ifStatementParentController", expressionCode));
        ifStatementCodeBuilder.append(generateJSCodeForStatementList(ifStatement.getSuccessBlock()));
        return ifStatementCodeBuilder.toString();
    }

    @Override
    public String visitIfElseStatement(IfElseStatement ifElseStatement) {
        StringBuilder ifStatementCodeBuilder = new StringBuilder();
        String expressionCode = ifElseStatement.getCondition().accept(this), identifier = ConditionalIdentifierGenerator.generateIdentifier(ifElseStatement);
        ;
        ifStatementCodeBuilder.append(renderConditionalJSTemplate(identifier, "ifElseStatementParentController", expressionCode));
        ifStatementCodeBuilder.append(generateJSCodeForStatementList(ifElseStatement.getSuccessBlock()));
        ifStatementCodeBuilder.append(generateJSCodeForStatementList(ifElseStatement.getFailureBlock()));
        return ifStatementCodeBuilder.toString();
    }

    private String generateJSCodeForStatementList(List<Statement> statementList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Statement successStatement : statementList) {
            stringBuilder.append(successStatement.accept(this));
        }
        return stringBuilder.toString();
    }

    private String renderConditionalJSTemplate(String identifier, String parentControllerTemplateName, String expressionJSCode) {
        ST conditionalJSTemplate = javaScriptTemplateGroup.getInstanceOf("conditional");
        conditionalJSTemplate.add("identifier", identifier);
        conditionalJSTemplate.add("parentController", javaScriptTemplateGroup.getInstanceOf(parentControllerTemplateName).render());
        conditionalJSTemplate.add("initializationBlock", getExpressionInitializationBlock(expressionJSCode));
        conditionalJSTemplate.add("expression", expressionJSCode);
        return conditionalJSTemplate.render();
    }

    private List<String> getExpressionInitializationBlock(String expression) {
        List<String> expressionInitializationLines = new ArrayList<String>();

        String preRegex = javaScriptTemplateGroup.getInstanceOf("variableMapStart").render(), postRegex = javaScriptTemplateGroup.getInstanceOf("variableMapEnd").render();
        Pattern pattern = Pattern.compile(preRegex.replace("[", "\\[") + "(.+?)" + postRegex.replace("]", "\\]"));
        Matcher matcher = pattern.matcher(expression);

        while (matcher.find()) {
            ST variableSubscriptionTemplate = javaScriptTemplateGroup.getInstanceOf("variableSubscription");
            variableSubscriptionTemplate.add("variableName", matcher.group(1).trim());
            expressionInitializationLines.add(variableSubscriptionTemplate.render());
        }

        if (expressionInitializationLines.isEmpty()) {
            ST fixedExpressionInitializationTemplate = javaScriptTemplateGroup.getInstanceOf("fixedExpressionInitialization");
            expressionInitializationLines.add(fixedExpressionInitializationTemplate.render());
        }

        return expressionInitializationLines;
    }

    @Override
    public String visitQuestion(Question question) {
        Type type = question.getDatatype();
        ST questionJS = javaScriptTemplateGroup.getInstanceOf("question");
        questionJS.add("id", question.getIdentifier().getName());
        questionJS.add("controllerType", type.getClass().getSimpleName() + "QuestionController");
        return questionJS.render();
    }

    @Override
    public String visitPositive(Positive positive) {
        return getUnaryOperationST(positive).render();
    }

    @Override
    public String visitNegative(Negative negative) {
        return getUnaryOperationST(negative).render();
    }

    @Override
    public String visitNot(Not not) {
        return getUnaryOperationST(not).render();
    }

    private ST getUnaryOperationST(UnaryOperation unaryOperation) {
        String templateName = WordUtils.uncapitalize(unaryOperation.getClass().getSimpleName());
        ST unaryOperationTemplate = javaScriptTemplateGroup.getInstanceOf(templateName);
        unaryOperationTemplate.add("expr", unaryOperation.getExpression().accept(this));
        return unaryOperationTemplate;
    }

    @Override
    public String visitMultiply(Multiply multiply) {
        return getBinaryOperationST(multiply).render();
    }

    @Override
    public String visitDivide(Divide divide) {
        return getBinaryOperationST(divide).render();
    }

    @Override
    public String visitSubtract(Subtract subtract) {
        return getBinaryOperationST(subtract).render();
    }

    @Override
    public String visitAdd(Add add) {
        return getBinaryOperationST(add).render();
    }

    @Override
    public String visitAnd(And and) {
        return getBinaryOperationST(and).render();
    }

    @Override
    public String visitOr(Or or) {
        return getBinaryOperationST(or).render();
    }

    @Override
    public String visitEqualTo(EqualTo equalTo) {
        return getBinaryOperationST(equalTo).render();
    }

    @Override
    public String visitNotEqualTo(NotEqualTo notEqualTo) {
        return getBinaryOperationST(notEqualTo).render();
    }

    @Override
    public String visitGreaterThan(GreaterThan greaterThan) {
        return getBinaryOperationST(greaterThan).render();
    }

    @Override
    public String visitGreaterThanOrEqualTo(GreaterThanOrEqualTo greaterThanOrEqualTo) {
        return getBinaryOperationST(greaterThanOrEqualTo).render();
    }

    @Override
    public String visitLessThan(LessThan lessThan) {
        return getBinaryOperationST(lessThan).render();
    }

    @Override
    public String visitLessThanOrEqualTo(LessThanOrEqualTo lessThanOrEqualTo) {
        return getBinaryOperationST(lessThanOrEqualTo).render();
    }

    private ST getBinaryOperationST(BinaryOperation binaryOperation) {
        String templateName = WordUtils.uncapitalize(binaryOperation.getClass().getSimpleName());
        ST binaryOperationTemplate = javaScriptTemplateGroup.getInstanceOf(templateName);
        binaryOperationTemplate.add("leftHandSideExpr", binaryOperation.getLeftHandSide().accept(this));
        binaryOperationTemplate.add("rightHandSideExpr", binaryOperation.getRightHandSide().accept(this));
        return binaryOperationTemplate;
    }

    @Override
    public String visitIdent(Ident ident) {
        ST identTemplate = javaScriptTemplateGroup.getInstanceOf("ident");
        identTemplate.add("name", ident.getName());
        return identTemplate.render();
    }

    @Override
    public String visitBool(Bool boolLiteral) {
        return boolLiteral.getValue().toString();
    }

    @Override
    public String visitInt(Int intLiteral) {
        return intLiteral.getValue().toString();
    }

    @Override
    public String visitStr(Str stringLiteral) {
        return stringLiteral.getValue();
    }
}
