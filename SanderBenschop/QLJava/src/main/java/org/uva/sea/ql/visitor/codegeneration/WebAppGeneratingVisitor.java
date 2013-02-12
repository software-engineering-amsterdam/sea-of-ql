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

public class WebAppGeneratingVisitor implements ASTNodeVisitor<ST> {

    private final STGroupFile pageTemplateGroup;
    private final STGroupFile formTemplateGroup;

    public WebAppGeneratingVisitor() {
        this.pageTemplateGroup =  new STGroupFile("src/main/resources/webappTemplates/qlpage.stg", '$', '$');
        this.formTemplateGroup =  new STGroupFile("src/main/resources/webappTemplates/qlform.stg", '$', '$');
    }

    public String generateQLCodeForForm(Form form) {
        ST pageTemplate = pageTemplateGroup.getInstanceOf("page");
        pageTemplate.add("formName", form.getName());
        pageTemplate.add("formContent", form.accept(this));
        return pageTemplate.render();
    }

    @Override
    public ST visitForm(Form form) {
        ST formTemplate = formTemplateGroup.getInstanceOf("form");
        for (QLStatement statement : form.getStatements()) {
            ST template = statement.accept(this);
            formTemplate.add("statements", template);
        }
        return formTemplate;
    }

    @Override
    public ST visitComputation(Computation computation) {
        ST computationTemplate = formTemplateGroup.getInstanceOf("computation");
        computationTemplate.add("id", computation.getIdentifier().getName());
        computationTemplate.add("labelText", computation.getLabel().getValue());
        return computationTemplate;
    }

    @Override
    public ST visitIfStatement(IfStatement ifStatement) {
        return null;
    }

    @Override
    public ST visitIfElseStatement(IfElseStatement ifElseStatement) {
        return null;
    }

    @Override
    public ST visitQuestion(Question question) {
        ST questiontemplate = getQuestionTemplate(question.getDatatype());
        questiontemplate.add("id", question.getIdentifier().getName());
        questiontemplate.add("labelText", question.getLabel().getValue());
        return questiontemplate;
    }

    private ST getQuestionTemplate(Type type) {
        ST questiontemplate;
        if (type instanceof IntegerType || type instanceof StringType) {
            questiontemplate = formTemplateGroup.getInstanceOf("openQuestion");
        } else if (type instanceof BooleanType) {
            questiontemplate = formTemplateGroup.getInstanceOf("closedQuestion");
        } else {
            throw new UnsupportedOperationException("Unsupported type.");
        }
        return questiontemplate;
    }

    @Override
    public ST visitPositive(Positive positive) {
        return getUnaryOperationST(positive, "positive");
    }

    @Override
    public ST visitNegative(Negative negative) {
        return getUnaryOperationST(negative, "negative");
    }

    @Override
    public ST visitNot(Not not) {
        return getUnaryOperationST(not, "not");
    }

    public ST getUnaryOperationST(UnaryOperation unaryOperation, String templateName) {
        ST unaryOperationTemplate = formTemplateGroup.getInstanceOf(templateName);
        unaryOperationTemplate.add("expr", unaryOperation.getExpression().accept(this));
        return unaryOperationTemplate;
    }

    @Override
    public ST visitMultiply(Multiply multiply) {
        return getBinaryOperationST(multiply, "multiply");
    }

    @Override
    public ST visitDivide(Divide divide) {
        return getBinaryOperationST(divide, "divide");
    }

    @Override
    public ST visitSubtract(Subtract subtract) {
        return getBinaryOperationST(subtract, "subtract");
    }

    @Override
    public ST visitAdd(Add add) {
        return getBinaryOperationST(add, "add");
    }

    @Override
    public ST visitAnd(And and) {
        return getBinaryOperationST(and, "and");
    }

    @Override
    public ST visitOr(Or or) {
        return getBinaryOperationST(or, "or");
    }

    @Override
    public ST visitEqualTo(EqualTo equalTo) {
        return getBinaryOperationST(equalTo, "equalTo");
    }

    @Override
    public ST visitNotEqualTo(NotEqualTo notEqualTo) {
        return getBinaryOperationST(notEqualTo, "notEqualTo");
    }

    @Override
    public ST visitGreaterThan(GreaterThan greaterThan) {
        return getBinaryOperationST(greaterThan, "greaterThan");
    }

    @Override
    public ST visitGreaterThanOrEqualTo(GreaterThanOrEqualTo greaterThanOrEqualTo) {
        return getBinaryOperationST(greaterThanOrEqualTo, "greaterThanOrEqualTo");
    }

    @Override
    public ST visitLessThan(LessThan lessThan) {
        return getBinaryOperationST(lessThan, "lessThan");
    }

    @Override
    public ST visitLessThanOrEqualTo(LessThanOrEqualTo lessThanOrEqualTo) {
        return getBinaryOperationST(lessThanOrEqualTo, "lessThanOrEqualTo");
    }

    private ST getBinaryOperationST(BinaryOperation binaryOperation, String templateName) {
        ST binaryOperationTemplate = formTemplateGroup.getInstanceOf(templateName);
        binaryOperationTemplate.add("leftHandSideExpr", binaryOperation.getLeftHandSide());
        binaryOperationTemplate.add("rightHandSideExpr", binaryOperation.getRightHandSide());
        return binaryOperationTemplate;
    }

    @Override
    public ST visitIdent(Ident ident) {
        return null;
    }

    @Override
    public ST visitBool(Bool boolLiteral) {
        return null;
    }

    @Override
    public ST visitInt(Int intLiteral) {
        return null;
    }

    @Override
    public ST visitStr(Str str) {
        return null;
    }
}
