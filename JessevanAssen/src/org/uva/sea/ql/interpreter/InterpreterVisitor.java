package org.uva.sea.ql.interpreter;

import org.uva.sea.ql.Message;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expr.*;
import org.uva.sea.ql.ast.expr.value.Bool;
import org.uva.sea.ql.ast.expr.value.Int;
import org.uva.sea.ql.ast.expr.value.Str;
import org.uva.sea.ql.ast.expr.value.Value;
import org.uva.sea.ql.ast.type.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InterpreterVisitor implements ASTNodeVisitor<Value, InterpreterVisitor.Context> {

    public static class Context {
        private final List<Message> errors;
        private final Map<Ident, Value> identifiers;
        private final Map<String, String> values;

        private Context(Map<String, String> values) {
            this.errors = new ArrayList<Message>();
            this.identifiers = new HashMap<Ident, Value>();
            this.values = values;
        }

        public List<Message> getErrors() { return errors; }
        public Map<Ident, Value> getIdentifiers() { return identifiers; }
        public Map<String, String> getValues() { return values; }
    }

    public static class Result {
        private final Map<String, String> values;
        private final List<Message> errors;

        private Result(Map<String, String> values, List<Message> errors) {
            this.values = values;
            this.errors = errors;
        }

        public Map<String, String> getValues() { return values; }
        public List<Message> getErrors() { return errors; }
    }

    public static Result interpret(Form form, Map<String, String> values) {
        Context context = new Context(values);
        InterpreterVisitor visitor = new InterpreterVisitor();
        form.accept(visitor, context);
        return new Result(context.getValues(), context.getErrors());
    }


    @Override
    public Value visit(Add astNode, Context param) {
        final Int left = (Int)astNode.getLeftExpression().accept(this, param),
                  right = (Int)astNode.getRightExpression().accept(this, param);
        return left.add(right);
    }

    @Override
    public Value visit(And astNode, Context param) {
        final Bool left = (Bool)astNode.getLeftExpression().accept(this, param),
                   right = (Bool)astNode.getRightExpression().accept(this, param);
        return left.and(right);
    }

    @Override
    public Value visit(Bool astNode, Context param) {
        return astNode;
    }

    @Override
    public Value visit(Computed astNode, Context param) {
        return null;
    }

    @Override
    public Value visit(CompositeFormElement astNode, Context param) {
        for(FormElement formElement : astNode.getFormElements())
            formElement.accept(this, param);
        return null;
    }

    @Override
    public Value visit(Div astNode, Context param) {
        final Int left = (Int)astNode.getLeftExpression().accept(this, param),
                  right = (Int)astNode.getRightExpression().accept(this, param);
        return left.divideBy(right);
    }

    @Override
    public Value visit(Eq astNode, Context param) {
        final Value left = astNode.getLeftExpression().accept(this, param),
                    right = astNode.getRightExpression().accept(this, param);

        if(left instanceof Bool && right instanceof Bool)
            return ((Bool)left).isEqualTo((Bool)right);
        else if(left instanceof Int && right instanceof Int)
            return ((Int)left).isEqualTo((Int)right);
        else if(left instanceof Str && right instanceof Str)
            return ((Str)left).isEqualTo((Str)right);
        else
            return new Bool(false);
    }

    @Override
    public Value visit(Form astNode, Context param) {
        astNode.getBody().accept(this, param);
        return null;
    }

    @Override
    public Value visit(GEq astNode, Context param) {
        final Int left = (Int)astNode.getLeftExpression().accept(this, param),
                  right = (Int)astNode.getRightExpression().accept(this, param);
        return left.isGreaterThanOrEqualTo(right);
    }

    @Override
    public Value visit(GT astNode, Context param) {
        final Int left = (Int)astNode.getLeftExpression().accept(this, param),
                  right = (Int)astNode.getRightExpression().accept(this, param);
        return left.isGreaterThan(right);
    }

    @Override
    public Value visit(Ident astNode, Context param) {
        return param.getIdentifiers().get(astNode);
    }

    @Override
    public Value visit(If astNode, Context param) {
        if(astNode.getCondition().accept(this, param).equals(new Bool(true)))
            astNode.getIfBody().accept(this, param);
        return null;
    }

    @Override
    public Value visit(IfElse astNode, Context param) {
        if(astNode.getCondition().accept(this, param).equals(new Bool(true)))
            astNode.getIfBody().accept(this, param);
        else
            astNode.getElseBody().accept(this, param);
        return null;
    }

    @Override
    public Value visit(Int astNode, Context param) {
        return astNode;
    }

    @Override
    public Value visit(LEq astNode, Context param) {
        final Int left = (Int)astNode.getLeftExpression().accept(this, param),
                  right = (Int)astNode.getRightExpression().accept(this, param);
        return left.isLesserThanOrEqualTo(right);
    }

    @Override
    public Value visit(LT astNode, Context param) {
        final Int left = (Int)astNode.getLeftExpression().accept(this, param),
                  right = (Int)astNode.getRightExpression().accept(this, param);
        return left.isLesserThan(right);
    }

    @Override
    public Value visit(Mul astNode, Context param) {
        final Int left = (Int)astNode.getLeftExpression().accept(this, param),
                  right = (Int)astNode.getRightExpression().accept(this, param);
        return left.multiply(right);
    }

    @Override
    public Value visit(Neg astNode, Context param) {
        final Int expression = (Int)astNode.getExpression().accept(this, param);
        return expression.negative();
    }

    @Override
    public Value visit(NEq astNode, Context param) {
        // Piggyback on the Eq to avoid having to do the glorious instanceof twice
        final Eq equals = new Eq(astNode.getLeftExpression(), astNode.getRightExpression());
        final Bool equalsResult = (Bool) equals.accept(this, param);
        return equalsResult.not();
    }

    @Override
    public Value visit(Not astNode, Context param) {
        final Bool expression = (Bool)astNode.getExpression().accept(this, param);
        return expression.not();
    }

    @Override
    public Value visit(Or astNode, Context param) {
        final Bool left = (Bool)astNode.getLeftExpression().accept(this, param),
                   right = (Bool)astNode.getRightExpression().accept(this, param);
        return left.or(right);
    }

    @Override
    public Value visit(Pos astNode, Context param) {
        final Int expression = (Int)astNode.getExpression().accept(this, param);
        return expression.positive();
    }

    @Override
    public Value visit(Question astNode, Context param) {
        return null;
    }

    @Override
    public Value visit(StoredExpression astNode, Context param) {
        param.getIdentifiers().put(
                astNode.getIdentifier(),
                astNode.getExpression().accept(this, param));
        return null;
    }

    @Override
    public Value visit(Str astNode, Context param) {
        return astNode;
    }

    @Override
    public Value visit(Sub astNode, Context param) {
        final Int left = (Int)astNode.getLeftExpression().accept(this, param),
                  right = (Int)astNode.getRightExpression().accept(this, param);
        return left.subtractWith(right);
    }

}
