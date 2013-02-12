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

public class WebAppGeneratingVisitor implements ASTNodeVisitor<Void> {

    private final STGroupFile pageTemplateGroup;
    private final STGroupFile formTemplateGroup;

    private final ST pageTemplate;

    public WebAppGeneratingVisitor() {
        this.pageTemplateGroup =  new STGroupFile("src/main/resources/webapp/qlpage.stg", '$', '$');
        this.formTemplateGroup =  new STGroupFile("src/main/resources/webapp/qlform.stg", '$', '$');
        this.pageTemplate = pageTemplateGroup.getInstanceOf("page");
    }

    public String generateQLCodeForForm(Form form) {
        form.accept(this);
        return pageTemplate.render();
    }

    private void addToFormContent(ST template) {
        pageTemplate.add("formContent", template);
    }

    private void addToJSDocumentReadyContent(ST template) {
        pageTemplate.add("documentReadyContent", template);
    }

    @Override
    public Void visitForm(Form form) {
        pageTemplate.add("formName", form.getName());
        for (QLStatement statement : form.getStatements()) {
            statement.accept(this);
        }

        return null;
    }

    @Override
    public Void visitComputation(Computation computation) {
        ST computationTemplate = formTemplateGroup.getInstanceOf("computation");
        computationTemplate.add("id", computation.getIdentifier().getName());
        computationTemplate.add("labelText", computation.getLabel().getValue());

        addToFormContent(computationTemplate);
        return null;
    }

    @Override
    public Void visitIfStatement(IfStatement ifStatement) {
        return null;
    }

    @Override
    public Void visitIfElseStatement(IfElseStatement ifElseStatement) {
        return null;
    }

    @Override
    public Void visitQuestion(Question question) {
        Type type = question.getDatatype();
        ST questionHtmlTemplate = getQuestionHtmlTemplate(type), questionJSTemplate = formTemplateGroup.getInstanceOf("questionJS");

        questionHtmlTemplate.add("id", question.getIdentifier().getName());
        questionHtmlTemplate.add("labelText", question.getLabel().getValue());
        questionJSTemplate.add("id", question.getIdentifier().getName());
        questionJSTemplate.add("controllerType", type.getClass().getSimpleName() + "QuestionController");

        addToFormContent(questionHtmlTemplate);
        addToJSDocumentReadyContent(questionJSTemplate);
        return null;
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
    public Void visitPositive(Positive positive) {
        ST template = getUnaryOperationST(positive, "positive");
        addToFormContent(template);
        return null;
    }

    @Override
    public Void visitNegative(Negative negative) {
        ST template = getUnaryOperationST(negative, "negative");
        addToFormContent(template);
        return null;
    }

    @Override
    public Void visitNot(Not not) {
        ST template = getUnaryOperationST(not, "not");
        addToFormContent(template);
        return null;
    }

    private ST getUnaryOperationST(UnaryOperation unaryOperation, String templateName) {
        ST unaryOperationTemplate = formTemplateGroup.getInstanceOf(templateName);
        unaryOperationTemplate.add("expr", unaryOperation.getExpression().accept(this));
        return unaryOperationTemplate;
    }

    @Override
    public Void visitMultiply(Multiply multiply) {
        ST template = getBinaryOperationST(multiply, "multiply");
        addToFormContent(template);
        return null;
    }

    @Override
    public Void visitDivide(Divide divide) {
        ST template = getBinaryOperationST(divide, "divide");
        addToFormContent(template);
        return null;
    }

    @Override
    public Void visitSubtract(Subtract subtract) {
        ST template = getBinaryOperationST(subtract, "subtract");
        addToFormContent(template);
        return null;
    }

    @Override
    public Void visitAdd(Add add) {
        ST template = getBinaryOperationST(add, "add");
        addToFormContent(template);
        return null;
    }

    @Override
    public Void visitAnd(And and) {
        ST template = getBinaryOperationST(and, "and");
        addToFormContent(template);
        return null;
    }

    @Override
    public Void visitOr(Or or) {
        ST template = getBinaryOperationST(or, "or");
        addToFormContent(template);
        return null;
    }

    @Override
    public Void visitEqualTo(EqualTo equalTo) {
        ST template = getBinaryOperationST(equalTo, "equalTo");
        addToFormContent(template);
        return null;
    }

    @Override
    public Void visitNotEqualTo(NotEqualTo notEqualTo) {
        ST template = getBinaryOperationST(notEqualTo, "notEqualTo");
        addToFormContent(template);
        return null;
    }

    @Override
    public Void visitGreaterThan(GreaterThan greaterThan) {
        ST template = getBinaryOperationST(greaterThan, "greaterThan");
        addToFormContent(template);
        return null;
    }

    @Override
    public Void visitGreaterThanOrEqualTo(GreaterThanOrEqualTo greaterThanOrEqualTo) {
        ST template = getBinaryOperationST(greaterThanOrEqualTo, "greaterThanOrEqualTo");
        addToFormContent(template);
        return null;
    }

    @Override
    public Void visitLessThan(LessThan lessThan) {
        ST template = getBinaryOperationST(lessThan, "lessThan");
        addToFormContent(template);
        return null;
    }

    @Override
    public Void visitLessThanOrEqualTo(LessThanOrEqualTo lessThanOrEqualTo) {
        ST template = getBinaryOperationST(lessThanOrEqualTo, "lessThanOrEqualTo");
        addToFormContent(template);
        return null;
    }

    private ST getBinaryOperationST(BinaryOperation binaryOperation, String templateName) {
        ST binaryOperationTemplate = formTemplateGroup.getInstanceOf(templateName);
        binaryOperationTemplate.add("leftHandSideExpr", binaryOperation.getLeftHandSide());
        binaryOperationTemplate.add("rightHandSideExpr", binaryOperation.getRightHandSide());
        return binaryOperationTemplate;
    }

    @Override
    public Void visitIdent(Ident ident) {
        return null;
    }

    @Override
    public Void visitBool(Bool boolLiteral) {
        return null;
    }

    @Override
    public Void visitInt(Int intLiteral) {
        return null;
    }

    @Override
    public Void visitStr(Str str) {
        return null;
    }
}
