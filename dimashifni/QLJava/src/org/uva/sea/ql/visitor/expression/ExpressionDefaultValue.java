package org.uva.sea.ql.visitor.expression;

import org.uva.sea.ql.ast.expression.*;
import org.uva.sea.ql.value.Value;
import org.uva.sea.ql.visitor.type.DefaultValue;

import java.util.Map;

public class ExpressionDefaultValue implements ExpressionVisitor<Void> {

    private final Map<Ident, Value> variables;

    public ExpressionDefaultValue(Map<Ident, Value> variables) {
        this.variables = variables;
    }

    @Override
    public Void visit(Ident node) {
        // assign default value
        this.variables.put(node, node.getType().accept(new DefaultValue()));
        return null;
    }

    @Override
    public Void visit(Add node) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Void visit(And node) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Void visit(Div node) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Void visit(Eq node) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Void visit(GEq node) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Void visit(GT node) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Void visit(Int node) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Void visit(Bool node) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Void visit(StringLiteral node) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Void visit(Money node) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Void visit(LEq node) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Void visit(LT node) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Void visit(Mul node) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Void visit(Neg node) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Void visit(NEq node) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Void visit(Not node) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Void visit(Or node) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Void visit(Pos node) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Void visit(Sub node) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
