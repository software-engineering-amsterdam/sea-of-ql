package org.uva.sea.ql.visitor.expression;

import org.uva.sea.ql.ast.expression.*;
import org.uva.sea.ql.ast.statement.ObservableStatement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExpressionDependencyAnalyzer implements ExpressionVisitor<Void> {
    private final Map<Ident, List<ObservableStatement>> observableMap;
    private final ObservableStatement statement;


    public ExpressionDependencyAnalyzer(final ObservableStatement statement, final Map<Ident, List<ObservableStatement>> observableMap) {
        this.observableMap = observableMap;
        this.statement = statement;
    }

    @Override
    public Void visit(Ident node) {
        List<ObservableStatement> observables = this.observableMap.get(node);
        if(observables == null)
        {
            observables = new ArrayList<ObservableStatement>();
        }
        observables.add(statement);
        this.observableMap.put(node, observables);

        return null;
    }

    @Override
    public Void visit(Add node) {
        Expr lhs = node.getLhs();
        Expr rhs = node.getRhs();
        lhs.accept(this);
        rhs.accept(this);

        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Void visit(And node) {
        Expr lhs = node.getLhs();
        Expr rhs = node.getRhs();
        lhs.accept(this);
        rhs.accept(this);

        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Void visit(Div node) {
        Expr lhs = node.getLhs();
        Expr rhs = node.getRhs();
        lhs.accept(this);
        rhs.accept(this);

        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Void visit(Eq node) {
        Expr lhs = node.getLhs();
        Expr rhs = node.getRhs();
        lhs.accept(this);
        rhs.accept(this);

        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Void visit(GEq node) {
        Expr lhs = node.getLhs();
        Expr rhs = node.getRhs();
        lhs.accept(this);
        rhs.accept(this);

        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Void visit(GT node) {
        Expr lhs = node.getLhs();
        Expr rhs = node.getRhs();
        lhs.accept(this);
        rhs.accept(this);

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
        Expr lhs = node.getLhs();
        Expr rhs = node.getRhs();
        lhs.accept(this);
        rhs.accept(this);

        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Void visit(LT node) {
        Expr lhs = node.getLhs();
        Expr rhs = node.getRhs();
        lhs.accept(this);
        rhs.accept(this);

        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Void visit(Mul node) {
        Expr lhs = node.getLhs();
        Expr rhs = node.getRhs();
        lhs.accept(this);
        rhs.accept(this);

        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Void visit(Neg node) {
        Expr exprNode = node.getExpr();
        exprNode.accept(this);

        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Void visit(NEq node) {
        Expr lhs = node.getLhs();
        Expr rhs = node.getRhs();
        lhs.accept(this);
        rhs.accept(this);

        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Void visit(Not node) {
        Expr exprNode = node.getExpr();
        exprNode.accept(this);

        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Void visit(Or node) {
        Expr lhs = node.getLhs();
        Expr rhs = node.getRhs();
        lhs.accept(this);
        rhs.accept(this);

        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Void visit(Pos node) {
        Expr exprNode = node.getExpr();
        exprNode.accept(this);

        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Void visit(Sub node) {
        Expr lhs = node.getLhs();
        Expr rhs = node.getRhs();
        lhs.accept(this);
        rhs.accept(this);

        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

}
