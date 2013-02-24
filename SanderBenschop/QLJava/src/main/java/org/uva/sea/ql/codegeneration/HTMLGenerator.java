package org.uva.sea.ql.codegeneration;

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
import org.uva.sea.ql.ast.statement.*;
import org.uva.sea.ql.ast.type.BooleanType;
import org.uva.sea.ql.ast.type.IntegerType;
import org.uva.sea.ql.ast.type.StringType;
import org.uva.sea.ql.ast.type.Type;

import java.util.List;

public class HTMLGenerator implements NodeVisitor<String> {

    private static final String UNSUPPORTED_NODE_VISIT_MESSAGE = "AST type '%s' does not generate HTML code.";

    private final STGroupFile htmlTemplateGroup;

    protected HTMLGenerator() {
        this.htmlTemplateGroup = new STGroupFile("src/main/resources/templates/qlhtmlcode.stg", '$', '$');
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
        ST computationTemplate = htmlTemplateGroup.getInstanceOf("computation");
        computationTemplate.add("id", computation.getIdentifier().getName());
        computationTemplate.add("labelText", computation.getLabel().getValue());
        return computationTemplate.render();
    }

    @Override
    public String visitIfStatement(IfStatement ifStatement) {
        ST ifStatementTemplate = htmlTemplateGroup.getInstanceOf("ifStatement");
        ifStatementTemplate.add("identifier", ConditionalIdentifierGenerator.generateIdentifier(ifStatement));
        ifStatementTemplate.add("successBodyContent", generateHTMLCodeForStatementList(ifStatement.getSuccessBlock()));
        return ifStatementTemplate.render();
    }

    @Override
    public String visitIfElseStatement(IfElseStatement ifElseStatement) {
        ST ifStatementTemplate = htmlTemplateGroup.getInstanceOf("ifElseStatement");
        ifStatementTemplate.add("identifier", ConditionalIdentifierGenerator.generateIdentifier(ifElseStatement));
        ifStatementTemplate.add("successBodyContent", generateHTMLCodeForStatementList(ifElseStatement.getSuccessBlock()));
        ifStatementTemplate.add("failureBodyContent", generateHTMLCodeForStatementList(ifElseStatement.getFailureBlock()));
        return ifStatementTemplate.render();
    }

    private String generateHTMLCodeForStatementList(List<Statement> statementList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Statement successStatement : statementList) {
            stringBuilder.append(successStatement.accept(this));
        }
        return stringBuilder.toString();
    }

    @Override
    public String visitQuestion(Question question) {
        ST questionHtmlTemplate = getQuestionHtmlTemplate(question.getDatatype());
        questionHtmlTemplate.add("id", question.getIdentifier().getName());
        questionHtmlTemplate.add("labelText", question.getLabel().getValue());
        return questionHtmlTemplate.render();
    }

    private ST getQuestionHtmlTemplate(Type type) {
        if (type instanceof IntegerType || type instanceof StringType) {
            return htmlTemplateGroup.getInstanceOf("openQuestion");
        } else if (type instanceof BooleanType) {
            return htmlTemplateGroup.getInstanceOf("closedQuestion");
        } else {
            throw new UnsupportedOperationException("Unsupported type.");
        }
    }

    @Override
    public String visitPositive(Positive positive) {
        String className = positive.getClass().getSimpleName();
        throw new UnsupportedOperationException(String.format(UNSUPPORTED_NODE_VISIT_MESSAGE, className));
    }

    @Override
    public String visitNegative(Negative negative) {
        String className = negative.getClass().getSimpleName();
        throw new UnsupportedOperationException(String.format(UNSUPPORTED_NODE_VISIT_MESSAGE, className));
    }

    @Override
    public String visitNot(Not not) {
        String className = not.getClass().getSimpleName();
        throw new UnsupportedOperationException(String.format(UNSUPPORTED_NODE_VISIT_MESSAGE, className));
    }

    @Override
    public String visitMultiply(Multiply multiply) {
        String className = multiply.getClass().getSimpleName();
        throw new UnsupportedOperationException(String.format(UNSUPPORTED_NODE_VISIT_MESSAGE, className));
    }

    @Override
    public String visitDivide(Divide divide) {
        String className = divide.getClass().getSimpleName();
        throw new UnsupportedOperationException(String.format(UNSUPPORTED_NODE_VISIT_MESSAGE, className));
    }

    @Override
    public String visitSubtract(Subtract subtract) {
        String className = subtract.getClass().getSimpleName();
        throw new UnsupportedOperationException(String.format(UNSUPPORTED_NODE_VISIT_MESSAGE, className));
    }

    @Override
    public String visitAdd(Add add) {
        String className = add.getClass().getSimpleName();
        throw new UnsupportedOperationException(String.format(UNSUPPORTED_NODE_VISIT_MESSAGE, className));
    }

    @Override
    public String visitAnd(And and) {
        String className = and.getClass().getSimpleName();
        throw new UnsupportedOperationException(String.format(UNSUPPORTED_NODE_VISIT_MESSAGE, className));
    }

    @Override
    public String visitOr(Or or) {
        String className = or.getClass().getSimpleName();
        throw new UnsupportedOperationException(String.format(UNSUPPORTED_NODE_VISIT_MESSAGE, className));
    }

    @Override
    public String visitEqualTo(EqualTo equalTo) {
        String className = equalTo.getClass().getSimpleName();
        throw new UnsupportedOperationException(String.format(UNSUPPORTED_NODE_VISIT_MESSAGE, className));
    }

    @Override
    public String visitNotEqualTo(NotEqualTo notEqualTo) {
        String className = notEqualTo.getClass().getSimpleName();
        throw new UnsupportedOperationException(String.format(UNSUPPORTED_NODE_VISIT_MESSAGE, className));
    }

    @Override
    public String visitGreaterThan(GreaterThan greaterThan) {
        String className = greaterThan.getClass().getSimpleName();
        throw new UnsupportedOperationException(String.format(UNSUPPORTED_NODE_VISIT_MESSAGE, className));
    }

    @Override
    public String visitGreaterThanOrEqualTo(GreaterThanOrEqualTo greaterThanOrEqualTo) {
        String className = greaterThanOrEqualTo.getClass().getSimpleName();
        throw new UnsupportedOperationException(String.format(UNSUPPORTED_NODE_VISIT_MESSAGE, className));
    }

    @Override
    public String visitLessThan(LessThan lessThan) {
        String className = lessThan.getClass().getSimpleName();
        throw new UnsupportedOperationException(String.format(UNSUPPORTED_NODE_VISIT_MESSAGE, className));
    }

    @Override
    public String visitLessThanOrEqualTo(LessThanOrEqualTo lessThanOrEqualTo) {
        String className = lessThanOrEqualTo.getClass().getSimpleName();
        throw new UnsupportedOperationException(String.format(UNSUPPORTED_NODE_VISIT_MESSAGE, className));
    }

    @Override
    public String visitIdent(Ident ident) {
        String className = ident.getClass().getSimpleName();
        throw new UnsupportedOperationException(String.format(UNSUPPORTED_NODE_VISIT_MESSAGE, className));
    }

    @Override
    public String visitBool(Bool boolLiteral) {
        String className = boolLiteral.getClass().getSimpleName();
        throw new UnsupportedOperationException(String.format(UNSUPPORTED_NODE_VISIT_MESSAGE, className));
    }

    @Override
    public String visitInt(Int intLiteral) {
        String className = intLiteral.getClass().getSimpleName();
        throw new UnsupportedOperationException(String.format(UNSUPPORTED_NODE_VISIT_MESSAGE, className));
    }

    @Override
    public String visitStr(Str strLiteral) {
        String className = strLiteral.getClass().getSimpleName();
        throw new UnsupportedOperationException(String.format(UNSUPPORTED_NODE_VISIT_MESSAGE, className));
    }
}
