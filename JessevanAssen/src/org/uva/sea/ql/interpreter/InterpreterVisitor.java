package org.uva.sea.ql.interpreter;

import org.uva.sea.ql.Error;
import org.uva.sea.ql.Message;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expression.*;
import org.uva.sea.ql.ast.expression.value.Bool;
import org.uva.sea.ql.ast.expression.value.Int;
import org.uva.sea.ql.ast.expression.value.Str;
import org.uva.sea.ql.ast.expression.value.Value;
import org.uva.sea.ql.interpreter.valueParser.ValueParser;
import org.uva.sea.ql.interpreter.valueParser.ValueParserException;
import org.uva.sea.ql.interpreter.valueParser.ValueParserFactory;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class InterpreterVisitor implements
        StatementVisitor<Value, InterpreterVisitor.Context>,
        ExpressionVisitor<Value, InterpreterVisitor.Context> {

    public static class Context {
        private final List<Message> errors;
        private final Map<Identifier, Value> identifiers;
        private final Map<String, String> values;

        private Context(Map<String, String> values) {
            // A LinkedHashMap is used here instead of a regular HashMap, because a LinkedHashMap retains
            // the order in which the values are inserted. This gives the values a better context, because
            // they can be retrieved in the same order as they were in the form.
            this.identifiers = new LinkedHashMap<Identifier, Value>();
            this.errors = new ArrayList<Message>();
            this.values = values;
        }

        public Map<Identifier, Value> getIdentifiers() { return identifiers; }
        public List<Message> getErrors() { return errors; }
        public Map<String, String> getValues() { return values; }
    }

    public static class Result {
        private final Map<Identifier, Value> identifiers;
        private final List<Message> errors;

        private Result(Map<Identifier, Value> identifiers, List<Message> errors) {
            this.identifiers = identifiers;
            this.errors = errors;
        }

        public Map<Identifier, Value> getIdentifiers() { return identifiers; }
        public List<Message> getErrors() { return errors; }
    }

    public static Result interpret(Form form, Map<String, String> values) {
        Context context = new Context(values);
        InterpreterVisitor visitor = new InterpreterVisitor();
        form.accept(visitor, context);
        return new Result(context.getIdentifiers(), context.getErrors());
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
    public Value visit(CompositeStatement astNode, Context param) {
        for(Statement statement : astNode.getStatements())
            statement.accept(this, param);
        return null;
    }

    @Override
    public Value visit(Divide astNode, Context param) {
        final Int left = (Int)astNode.getLeftExpression().accept(this, param),
                  right = (Int)astNode.getRightExpression().accept(this, param);
        return left.divideBy(right);
    }

    @Override
    public Value visit(EqualTo astNode, Context param) {
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
    public Value visit(GreaterThanOrEqualTo astNode, Context param) {
        final Int left = (Int)astNode.getLeftExpression().accept(this, param),
                  right = (Int)astNode.getRightExpression().accept(this, param);
        return left.isGreaterThanOrEqualTo(right);
    }

    @Override
    public Value visit(GreaterThan astNode, Context param) {
        final Int left = (Int)astNode.getLeftExpression().accept(this, param),
                  right = (Int)astNode.getRightExpression().accept(this, param);
        return left.isGreaterThan(right);
    }

    @Override
    public Value visit(Identifier astNode, Context param) {
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
    public Value visit(LesserThanOrEqualTo astNode, Context param) {
        final Int left = (Int)astNode.getLeftExpression().accept(this, param),
                  right = (Int)astNode.getRightExpression().accept(this, param);
        return left.isLesserThanOrEqualTo(right);
    }

    @Override
    public Value visit(LesserThan astNode, Context param) {
        final Int left = (Int)astNode.getLeftExpression().accept(this, param),
                  right = (Int)astNode.getRightExpression().accept(this, param);
        return left.isLesserThan(right);
    }

    @Override
    public Value visit(Multiply astNode, Context param) {
        final Int left = (Int)astNode.getLeftExpression().accept(this, param),
                  right = (Int)astNode.getRightExpression().accept(this, param);
        return left.multiply(right);
    }

    @Override
    public Value visit(Negative astNode, Context param) {
        final Int expression = (Int)astNode.getExpression().accept(this, param);
        return expression.negative();
    }

    @Override
    public Value visit(NotEqualTo astNode, Context param) {
        // Piggyback on the EqualTo to avoid having to do the glorious instanceof twice
        final EqualTo equalTo = new EqualTo(astNode.getLeftExpression(), astNode.getRightExpression());
        final Bool equalsResult = (Bool) equalTo.accept(this, param);
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
    public Value visit(Positive astNode, Context param) {
        final Int expression = (Int)astNode.getExpression().accept(this, param);
        return expression.positive();
    }

    @Override
    public Value visit(Question astNode, Context param) {
        final Identifier identifier = astNode.getIdentifier();
        final ValueParser valueParser = ValueParserFactory.createValueParser(astNode.getType());

        if(!param.getValues().containsKey(identifier.getName())) {
            final Value defaultValue = valueParser.getDefault();
            param.errors.add(new Error(
                    String.format(
                            "No value for identifier '%s' in the values map! Using the default value '%s'.",
                            identifier.getName(),
                            defaultValue
                    )
            ));
            param.getIdentifiers().put(astNode.getIdentifier(), defaultValue);
        } else {
            final String value = param.values.get(identifier.getName());
            try {
                final Value parsedValue = valueParser.parseValue(value);
                param.getIdentifiers().put(astNode.getIdentifier(), parsedValue);
            } catch(ValueParserException ex) {
                final Value defaultValue = valueParser.getDefault();
                param.errors.add(new Error(
                        String.format(
                                "The value of identifier '%s' ('%s') can't be parsed as type '%s'! Using the default value '%s'.",
                                identifier.getName(),
                                value,
                                astNode.getType(),
                                defaultValue
                        )
                ));
                param.getIdentifiers().put(astNode.getIdentifier(), defaultValue);
            }
        }

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
    public Value visit(Subtract astNode, Context param) {
        final Int left = (Int)astNode.getLeftExpression().accept(this, param),
                  right = (Int)astNode.getRightExpression().accept(this, param);
        return left.subtractWith(right);
    }

}
