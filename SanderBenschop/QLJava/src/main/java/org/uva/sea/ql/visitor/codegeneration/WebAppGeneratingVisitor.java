package org.uva.sea.ql.visitor.codegeneration;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroupFile;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.QLStatement;
import org.uva.sea.ql.ast.binary.*;
import org.uva.sea.ql.ast.primary.Bool;
import org.uva.sea.ql.ast.primary.Ident;
import org.uva.sea.ql.ast.primary.Int;
import org.uva.sea.ql.ast.primary.Str;
import org.uva.sea.ql.ast.primary.typeClasses.BooleanType;
import org.uva.sea.ql.ast.primary.typeClasses.IntegerType;
import org.uva.sea.ql.ast.primary.typeClasses.StringType;
import org.uva.sea.ql.ast.primary.typeClasses.Type;
import org.uva.sea.ql.ast.statement.Computation;
import org.uva.sea.ql.ast.statement.IfElseStatement;
import org.uva.sea.ql.ast.statement.IfStatement;
import org.uva.sea.ql.ast.statement.Question;
import org.uva.sea.ql.ast.unary.Negative;
import org.uva.sea.ql.ast.unary.Not;
import org.uva.sea.ql.ast.unary.Positive;
import org.uva.sea.ql.ast.unary.UnaryOperation;
import org.uva.sea.ql.visitor.ASTNodeVisitor;
import org.uva.sea.ql.visitor.codegeneration.codewrapper.CompositeStatementWebappCodeWrapper;
import org.uva.sea.ql.visitor.codegeneration.codewrapper.SimpleExpressionWebappCodeWrapper;
import org.uva.sea.ql.visitor.codegeneration.codewrapper.SimpleStatementWebappCodeWrapper;
import org.uva.sea.ql.visitor.codegeneration.codewrapper.WebappCodeWrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebAppGeneratingVisitor implements ASTNodeVisitor<WebappCodeWrapper> {

    private final STGroupFile pageTemplateGroup;
    private final STGroupFile formTemplateGroup;

    public WebAppGeneratingVisitor() {
        this.pageTemplateGroup =  new STGroupFile("src/main/resources/webapp/qlpage.stg", '$', '$');
        this.formTemplateGroup =  new STGroupFile("src/main/resources/webapp/qlform.stg", '$', '$');
    }

    public String generateQLCodeForForm(Form form) {
        WebappCodeWrapper webappCodeWrapper = form.accept(this);

        ST pageTemplate = pageTemplateGroup.getInstanceOf("page");
        pageTemplate.add("formName", form.getName());
        pageTemplate.add("documentReadyContent", webappCodeWrapper.getJavascriptCode());
        pageTemplate.add("formContent", webappCodeWrapper.getHTMLCode());

        return pageTemplate.render();
    }

    @Override
    public WebappCodeWrapper visitForm(Form form) {
        CompositeStatementWebappCodeWrapper compositeWrapper = new CompositeStatementWebappCodeWrapper();
        for (QLStatement statement : form.getStatements()) {
            WebappCodeWrapper statementWrapper = statement.accept(this);
            compositeWrapper.addStatementWebappCodeWrapper(statementWrapper);
        }
        return compositeWrapper;
    }

    @Override
    public WebappCodeWrapper visitComputation(Computation computation) {
        ST computationHtmlTemplate = formTemplateGroup.getInstanceOf("computationHtml"), computationJSTemplate = formTemplateGroup.getInstanceOf("computationJS");
        WebappCodeWrapper expressionJSCodeWrapper = computation.getExpression().accept(this);

        computationHtmlTemplate.add("id", computation.getIdentifier().getName());
        computationHtmlTemplate.add("labelText", computation.getLabel().getValue());

        computationJSTemplate.add("name", computation.getIdentifier().getName());
        computationJSTemplate.add("variableSubscriptions", getSubscriptions(expressionJSCodeWrapper.getJavascriptCode()));
        computationJSTemplate.add("expression", expressionJSCodeWrapper.getJavascriptCode());

        return new SimpleStatementWebappCodeWrapper(computationJSTemplate.render(), computationHtmlTemplate.render());
    }

    private List<String> getSubscriptions(String expression) {
        List<String> variableSubscriptions = new ArrayList<String>();

        String preRegex = formTemplateGroup.getInstanceOf("variableMapStart").render(), postRegex = formTemplateGroup.getInstanceOf("variableMapEnd").render();
        Pattern pattern = Pattern.compile(preRegex.replace("[", "\\[") + "(.+?)" + postRegex.replace("]", "\\]"));
        Matcher matcher = pattern.matcher(expression);
        while(matcher.find()) {
            ST variableSubscriptionTemplate = formTemplateGroup.getInstanceOf("variableSubscription");
            variableSubscriptionTemplate.add("variableName", matcher.group(1).trim());
            variableSubscriptions.add(variableSubscriptionTemplate.render());
        }

        return variableSubscriptions;
    }

    @Override
    public WebappCodeWrapper visitIfStatement(IfStatement ifStatement) {
        return null;
    }

    @Override
    public WebappCodeWrapper visitIfElseStatement(IfElseStatement ifElseStatement) {
        return null;
    }

    @Override
    public WebappCodeWrapper visitQuestion(Question question) {
        Type type = question.getDatatype();
        ST questionHtmlTemplate = getQuestionHtmlTemplate(type), questionJSTemplate = formTemplateGroup.getInstanceOf("questionJS");

        questionJSTemplate.add("id", question.getIdentifier().getName());
        questionJSTemplate.add("controllerType", type.getClass().getSimpleName() + "QuestionController");

        questionHtmlTemplate.add("id", question.getIdentifier().getName());
        questionHtmlTemplate.add("labelText", question.getLabel().getValue());

        return new SimpleStatementWebappCodeWrapper(questionJSTemplate.render(), questionHtmlTemplate.render());
    }

    private ST getQuestionHtmlTemplate(Type type) {
        ST questiontemplate;
        if (type instanceof IntegerType || type instanceof StringType) {
            questiontemplate = formTemplateGroup.getInstanceOf("openQuestionHtml");
        } else if (type instanceof BooleanType) {
            questiontemplate = formTemplateGroup.getInstanceOf("closedQuestionHtml");
        } else {
            throw new UnsupportedOperationException("Unsupported type.");
        }
        return questiontemplate;
    }

    @Override
    public WebappCodeWrapper visitPositive(Positive positive) {
        String javascriptCode = getUnaryOperationST(positive, "positive").render();
        return new SimpleExpressionWebappCodeWrapper(javascriptCode);
    }

    @Override
    public WebappCodeWrapper visitNegative(Negative negative) {
        String javascriptCode = getUnaryOperationST(negative, "negative").render();
        return new SimpleExpressionWebappCodeWrapper(javascriptCode);
    }

    @Override
    public WebappCodeWrapper visitNot(Not not) {
        String javascriptCode = getUnaryOperationST(not, "not").render();
        return new SimpleExpressionWebappCodeWrapper(javascriptCode);
    }

    private ST getUnaryOperationST(UnaryOperation unaryOperation, String templateName) {
        ST unaryOperationTemplate = formTemplateGroup.getInstanceOf(templateName);
        unaryOperationTemplate.add("expr", unaryOperation.getExpression().accept(this));
        return unaryOperationTemplate;
    }

    @Override
    public WebappCodeWrapper visitMultiply(Multiply multiply) {
        String javascriptCode = getBinaryOperationST(multiply, "multiply").render();
        return new SimpleExpressionWebappCodeWrapper(javascriptCode);
    }

    @Override
    public WebappCodeWrapper visitDivide(Divide divide) {
        String javascriptCode = getBinaryOperationST(divide, "divide").render();
        return new SimpleExpressionWebappCodeWrapper(javascriptCode);
    }

    @Override
    public WebappCodeWrapper visitSubtract(Subtract subtract) {
        String javascriptCode = getBinaryOperationST(subtract, "subtract").render();
        return new SimpleExpressionWebappCodeWrapper(javascriptCode);
    }

    @Override
    public WebappCodeWrapper visitAdd(Add add) {
        String javascriptCode = getBinaryOperationST(add, "add").render();
        return new SimpleExpressionWebappCodeWrapper(javascriptCode);
    }

    @Override
    public WebappCodeWrapper visitAnd(And and) {
        String javascriptCode = getBinaryOperationST(and, "and").render();
        return new SimpleExpressionWebappCodeWrapper(javascriptCode);
    }

    @Override
    public WebappCodeWrapper visitOr(Or or) {
        String javascriptCode = getBinaryOperationST(or, "or").render();
        return new SimpleExpressionWebappCodeWrapper(javascriptCode);
    }

    @Override
    public WebappCodeWrapper visitEqualTo(EqualTo equalTo) {
        String javascriptCode = getBinaryOperationST(equalTo, "equalTo").render();
        return new SimpleExpressionWebappCodeWrapper(javascriptCode);
    }

    @Override
    public WebappCodeWrapper visitNotEqualTo(NotEqualTo notEqualTo) {
        String javascriptCode = getBinaryOperationST(notEqualTo, "notEqualTo").render();
        return new SimpleExpressionWebappCodeWrapper(javascriptCode);
    }

    @Override
    public WebappCodeWrapper visitGreaterThan(GreaterThan greaterThan) {
        String javascriptCode = getBinaryOperationST(greaterThan, "greaterThan").render();
        return new SimpleExpressionWebappCodeWrapper(javascriptCode);
    }

    @Override
    public WebappCodeWrapper visitGreaterThanOrEqualTo(GreaterThanOrEqualTo greaterThanOrEqualTo) {
        String javascriptCode = getBinaryOperationST(greaterThanOrEqualTo, "greaterThanOrEqualTo").render();
        return new SimpleExpressionWebappCodeWrapper(javascriptCode);
    }

    @Override
    public WebappCodeWrapper visitLessThan(LessThan lessThan) {
        String javascriptCode = getBinaryOperationST(lessThan, "lessThan").render();
        return new SimpleExpressionWebappCodeWrapper(javascriptCode);
    }

    @Override
    public WebappCodeWrapper visitLessThanOrEqualTo(LessThanOrEqualTo lessThanOrEqualTo) {
        String javascriptCode = getBinaryOperationST(lessThanOrEqualTo, "lessThanOrEqualTo").render();
        return new SimpleExpressionWebappCodeWrapper(javascriptCode);
    }

    private ST getBinaryOperationST(BinaryOperation binaryOperation, String templateName) {
        ST binaryOperationTemplate = formTemplateGroup.getInstanceOf(templateName);
        WebappCodeWrapper leftHandSideWrapper = binaryOperation.getLeftHandSide().accept(this), rightHandSideWrapper = binaryOperation.getRightHandSide().accept(this);
        binaryOperationTemplate.add("leftHandSideExpr", leftHandSideWrapper.getJavascriptCode());
        binaryOperationTemplate.add("rightHandSideExpr", rightHandSideWrapper.getJavascriptCode());
        return binaryOperationTemplate;
    }

    @Override
    public WebappCodeWrapper visitIdent(Ident ident) {
        ST identTemplate = formTemplateGroup.getInstanceOf("ident");
        identTemplate.add("name", ident.getName());
        return new SimpleExpressionWebappCodeWrapper(identTemplate.render());
    }

    @Override
    public WebappCodeWrapper visitBool(Bool boolLiteral) {
        Boolean value = boolLiteral.getValue();
        return new SimpleExpressionWebappCodeWrapper(value.toString());
    }

    @Override
    public WebappCodeWrapper visitInt(Int intLiteral) {
        Integer value = intLiteral.getValue();
        return new SimpleExpressionWebappCodeWrapper(value.toString());
    }

    @Override
    public WebappCodeWrapper visitStr(Str str) {
        String value = str.getValue();
        return new SimpleExpressionWebappCodeWrapper(value);
    }
}
