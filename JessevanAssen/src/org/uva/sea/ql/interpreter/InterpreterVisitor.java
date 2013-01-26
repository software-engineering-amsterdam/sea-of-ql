package org.uva.sea.ql.interpreter;

import org.uva.sea.ql.Message;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expr.*;
import org.uva.sea.ql.ast.expr.value.Bool;
import org.uva.sea.ql.ast.expr.value.Int;
import org.uva.sea.ql.ast.expr.value.Str;
import org.uva.sea.ql.ast.expr.value.Value;

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
        return null;
    }

    @Override
    public Value visit(And astNode, Context param) {
        return null;
    }

    @Override
    public Value visit(Bool astNode, Context param) {
        return null;
    }

    @Override
    public Value visit(Computed astNode, Context param) {
        return null;
    }

    @Override
    public Value visit(CompositeFormElement astNode, Context param) {
        return null;
    }

    @Override
    public Value visit(Div astNode, Context param) {
        return null;
    }

    @Override
    public Value visit(Eq astNode, Context param) {
        return null;
    }

    @Override
    public Value visit(Form astNode, Context param) {
        return null;
    }

    @Override
    public Value visit(GEq astNode, Context param) {
        return null;
    }

    @Override
    public Value visit(GT astNode, Context param) {
        return null;
    }

    @Override
    public Value visit(Ident astNode, Context param) {
        return null;
    }

    @Override
    public Value visit(If astNode, Context param) {
        return null;
    }

    @Override
    public Value visit(IfElse astNode, Context param) {
        return null;
    }

    @Override
    public Value visit(Int astNode, Context param) {
        return null;
    }

    @Override
    public Value visit(LEq astNode, Context param) {
        return null;
    }

    @Override
    public Value visit(LT astNode, Context param) {
        return null;
    }

    @Override
    public Value visit(Mul astNode, Context param) {
        return null;
    }

    @Override
    public Value visit(Neg astNode, Context param) {
        return null;
    }

    @Override
    public Value visit(NEq astNode, Context param) {
        return null;
    }

    @Override
    public Value visit(Not astNode, Context param) {
        return null;
    }

    @Override
    public Value visit(Or astNode, Context param) {
        return null;
    }

    @Override
    public Value visit(Pos astNode, Context param) {
        return null;
    }

    @Override
    public Value visit(Question astNode, Context param) {
        return null;
    }

    @Override
    public Value visit(StoredExpression astNode, Context param) {
        return null;
    }

    @Override
    public Value visit(Str astNode, Context param) {
        return null;
    }

    @Override
    public Value visit(Sub astNode, Context param) {
        return null;
    }

}
