package org.uva.sea.ql.webUI;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expression.*;
import org.uva.sea.ql.ast.expression.value.Bool;
import org.uva.sea.ql.ast.expression.value.Int;
import org.uva.sea.ql.ast.expression.value.Str;
import org.uva.sea.ql.ast.type.TypeVisitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class KnockoutJSViewModelBuilderVisitor implements
        StatementVisitor<Void, KnockoutJSViewModelBuilderVisitor.Context>,
        ExpressionVisitor<Void, KnockoutJSViewModelBuilderVisitor.Context>,
        TypeVisitor<String, Void> {

    public static class Context {
        private final List<String> identifiers;
        private final StringBuilder objectHierarchy;

        public Context() {
            this.identifiers = new ArrayList<String>();
            this.objectHierarchy = new StringBuilder();
        }

        public List<String> getIdentifiers() { return identifiers; }
        public StringBuilder getObjectHierarchy() { return objectHierarchy; }
    }

    private static final String VIEWMODEL_TEMPLATE = "new (function(){var _self=this;_self.identifiers=%s;_self.root=%s;})()";

    /**
     * Private constructor to indicate that no instance should be made of this class.
     */
    private KnockoutJSViewModelBuilderVisitor() { }

    public static String createViewModel(Form form) {
        KnockoutJSViewModelBuilderVisitor visitor = new KnockoutJSViewModelBuilderVisitor();
        Context context = new Context();
        form.accept(visitor, context);

        return String.format(VIEWMODEL_TEMPLATE,
                createIdentifierObject(context.identifiers),
                context.getObjectHierarchy().toString());
    }

    private static String createIdentifierObject(Iterable<String> identifiers) {
        StringBuilder stringBuilder = new StringBuilder("{");
        for(Iterator<String> iterator = identifiers.iterator(); iterator.hasNext(); ) {
            stringBuilder.append(iterator.next());

            if(iterator.hasNext())
                stringBuilder.append(",");
        }
        stringBuilder.append("}");

        return stringBuilder.toString();
    }

    @Override
    public Void visit(Add astNode, Context param) {
        visitBinaryExpression(astNode, param, "+");
        return null;
    }

    @Override
    public Void visit(And astNode, Context param) {
        visitBinaryExpression(astNode, param, "&&");
        return null;
    }

    @Override
    public Void visit(Bool astNode, Context param) {
        param.getObjectHierarchy().append(astNode.getValue());
        return null;
    }

    @Override
    public Void visit(Computed astNode, Context param) {
        param.getObjectHierarchy()
                .append("new Computed(\"")
                .append(astNode.getLabel())
                .append("\",function(){return ");
        astNode.getExpression().accept(this, param);
        param.getObjectHierarchy()
                .append(";})");

        return null;
    }

    @Override
    public Void visit(CompositeStatement astNode, Context param) {
        for(Iterator<Statement> iterator = astNode.getStatements().iterator(); iterator.hasNext(); ) {
            iterator.next().accept(this, param);
            if(iterator.hasNext())
                param.getObjectHierarchy().append(",");
        }

        return null;
    }

    @Override
    public Void visit(Divide astNode, Context param) {
        visitBinaryExpression(astNode, param, "/");
        return null;
    }

    @Override
    public Void visit(EqualTo astNode, Context param) {
        visitBinaryExpression(astNode, param, "==");
        return null;
    }

    @Override
    public Void visit(Form astNode, Context param) {
        param.getObjectHierarchy().append("new Block(function(){return true;},[");
        astNode.getBody().accept(this, param);
        param.getObjectHierarchy().append("])");
        return null;
    }

    @Override
    public Void visit(GreaterThanOrEqualTo astNode, Context param) {
        visitBinaryExpression(astNode, param, ">=");
        return null;
    }

    @Override
    public Void visit(GreaterThan astNode, Context param) {
        visitBinaryExpression(astNode, param, ">");
        return null;
    }

    @Override
    public Void visit(Identifier astNode, Context param) {
        param.getObjectHierarchy()
                .append("_self.identifiers.")
                .append(astNode.getName())
                .append("()");
        return null;
    }

    @Override
    public Void visit(If astNode, Context param) {
        createBlock(astNode.getCondition(), astNode.getIfBody(), param);
        return null;
    }

    @Override
    public Void visit(IfElse astNode, Context param) {
        createBlock(astNode.getCondition(), astNode.getIfBody(), param);
        param.getObjectHierarchy().append(",");
        createBlock(new Not(astNode.getCondition()), astNode.getIfBody(), param);
        return null;
    }

    private void createBlock(Expression condition, Statement body, Context context) {
        context.getObjectHierarchy().append("new Block(function(){return ");
        condition.accept(this, context);
        context.getObjectHierarchy().append(";},[");
        body.accept(this, context);
        context.getObjectHierarchy().append("])");
    }

    @Override
    public Void visit(Int astNode, Context param) {
        param.getObjectHierarchy().append(astNode.getValue());
        return null;
    }

    @Override
    public Void visit(LesserThanOrEqualTo astNode, Context param) {
        visitBinaryExpression(astNode, param, "<=");
        return null;
    }

    @Override
    public Void visit(LesserThan astNode, Context param) {
        visitBinaryExpression(astNode, param, "<");
        return null;
    }

    @Override
    public Void visit(Multiply astNode, Context param) {
        visitBinaryExpression(astNode, param, "*");
        return null;
    }

    @Override
    public Void visit(Negative astNode, Context param) {
        visitUnaryExpression(astNode, param, "-");
        return null;
    }

    @Override
    public Void visit(NotEqualTo astNode, Context param) {
        visitBinaryExpression(astNode, param, "!=");
        return null;
    }

    @Override
    public Void visit(Not astNode, Context param) {
        visitUnaryExpression(astNode, param, "!");
        return null;
    }

    @Override
    public Void visit(Or astNode, Context param) {
        visitBinaryExpression(astNode, param, "||");
        return null;
    }

    @Override
    public Void visit(Positive astNode, Context param) {
        visitUnaryExpression(astNode, param, "+");
        return null;
    }

    @Override
    public Void visit(Question astNode, Context param) {
        param.getIdentifiers().add(
                String.format(
                        "%s:ko.observable()",
                        astNode.getIdentifier().getName()
                )
        );

        param.getObjectHierarchy()
                .append("new Question(\"")
                .append(astNode.getQuestion())
                .append("\",\"")
                .append(astNode.getIdentifier().getName())
                .append("\",_self.identifiers.")
                .append(astNode.getIdentifier().getName())
                .append(",")
                .append(astNode.getType().accept(this, null))
                .append(")");
        return null;
    }

    @Override
    public Void visit(StoredExpression astNode, Context param) {
        Context newContext = new Context();
        astNode.getExpression().accept(this, newContext);
        param.getIdentifiers().add(
                String.format(
                        "%s:ko.computed(function(){return %s;})",
                        astNode.getIdentifier().getName(),
                        newContext.getObjectHierarchy().toString()
                )
        );

        return null;
    }

    @Override
    public Void visit(Str astNode, Context param) {
        param.getObjectHierarchy().append(String.format("\"%s\"", astNode.getValue()));
        return null;
    }

    @Override
    public Void visit(Subtract astNode, Context param) {
        visitBinaryExpression(astNode, param, "-");
        return null;
    }

    private void visitUnaryExpression(UnaryExpression unaryExpression, Context param, String operator) {
        param.getObjectHierarchy().append("(").append(operator);
        unaryExpression.getExpression().accept(this, param);
        param.getObjectHierarchy().append(")");
    }

    private void visitBinaryExpression(BinaryExpression binaryExpression, Context param, String operator) {
        param.getObjectHierarchy().append("(");
        binaryExpression.getLeftExpression().accept(this, param);
        param.getObjectHierarchy().append(operator);
        binaryExpression.getRightExpression().accept(this, param);
        param.getObjectHierarchy().append(")");
    }


    @Override
    public String visit(org.uva.sea.ql.ast.type.Bool type, Void param) {
        return "DataType.BOOLEAN";
    }

    @Override
    public String visit(org.uva.sea.ql.ast.type.Int type, Void param) {
        return "DataType.INTEGER";
    }

    @Override
    public String visit(org.uva.sea.ql.ast.type.Str type, Void param) {
        return "DataType.STRING";
    }

    @Override
    public String visit(org.uva.sea.ql.ast.type.Unknown type, Void param) {
        throw new RuntimeException("Visit called on unknown type, no type should be unknown at this point!");
    }

    @Override
    public String visit(org.uva.sea.ql.ast.type.Void type, Void param) {
        throw new RuntimeException("Visit called on void type. There should be no need to access the type of an Void expression.");
    }
}
