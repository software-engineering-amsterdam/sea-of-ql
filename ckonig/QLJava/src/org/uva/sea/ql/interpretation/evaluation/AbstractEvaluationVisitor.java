package org.uva.sea.ql.interpretation.evaluation;

import org.uva.sea.ql.ast.bool.And;
import org.uva.sea.ql.ast.bool.Eq;
import org.uva.sea.ql.ast.bool.GEq;
import org.uva.sea.ql.ast.bool.GT;
import org.uva.sea.ql.ast.bool.LEq;
import org.uva.sea.ql.ast.bool.LT;
import org.uva.sea.ql.ast.bool.NEq;
import org.uva.sea.ql.ast.bool.Not;
import org.uva.sea.ql.ast.bool.Or;
import org.uva.sea.ql.ast.expressions.BinaryExpr;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.literals.BoolLiteral;
import org.uva.sea.ql.ast.literals.IntLiteral;
import org.uva.sea.ql.ast.literals.StringLiteral;
import org.uva.sea.ql.ast.math.Add;
import org.uva.sea.ql.ast.math.Div;
import org.uva.sea.ql.ast.math.Mul;
import org.uva.sea.ql.ast.math.Neg;
import org.uva.sea.ql.ast.math.Pos;
import org.uva.sea.ql.ast.math.Sub;
import org.uva.sea.ql.ast.types.AbstractType;
import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.common.ExpressionVisitor;
import org.uva.sea.ql.common.QLException;
import org.uva.sea.ql.interpretation.SwingRegistry;

abstract class AbstractEvaluationVisitor implements ExpressionVisitor {
    protected SwingRegistry registry;
    protected boolean boolRet;
    protected float mathRet;
    protected Evaluator evaluator;

    public AbstractEvaluationVisitor(SwingRegistry reg, Evaluator eval) {
        this.registry = reg;
        this.evaluator = eval;
    }

    @Override
    public final void visit(Add add) throws QLException {
        this.mathRet = evalFloat(add.getLeft()) + evalFloat(add.getRight());
    }

    @Override
    public final void visit(Mul mul) throws QLException {
        this.mathRet = evalFloat(mul.getLeft()) * evalFloat(mul.getRight());
    }

    @Override
    public final void visit(Div div) throws QLException {
        this.mathRet = evalFloat(div.getLeft()) / evalFloat(div.getRight());
    }

    @Override
    public final void visit(Sub sub) throws QLException {
        this.mathRet = evalFloat(sub.getLeft()) - evalFloat(sub.getRight());
    }

    @Override
    public final void visit(Pos pos) throws QLException {
        this.mathRet = evalFloat(pos.getAdjacent()) * (1);
    }

    @Override
    public final void visit(Neg neg) throws QLException {
        this.mathRet = evalFloat(neg.getAdjacent()) * (-1);
    }

    @Override
    public final void visit(And and) throws QLException {
        this.boolRet = evalBool(and.getLeft()) && evalBool(and.getRight());
    }

    @Override
    public final void visit(Or or) throws QLException {
        this.boolRet = evalBool(or.getLeft()) || evalBool(or.getRight());
    }

    @Override
    public final void visit(Eq eq) throws QLException {
        if (checkReturn(eq, new BooleanType())) {
            this.boolRet = evalBool(eq.getLeft()) == evalBool(eq.getRight());
        }
        if (checkReturn(eq, new IntType())) {
            this.boolRet = evalFloat(eq.getLeft()) == evalFloat(eq.getRight());
        }
    }

    @Override
    public final void visit(NEq neq) throws QLException {
        if (checkReturn(neq, new BooleanType())) {
            this.boolRet = evalBool(neq.getLeft()) != evalBool(neq.getRight());
        }
        if (checkReturn(neq, new IntType())) {
            this.boolRet = evalFloat(neq.getLeft()) != evalFloat(neq.getRight());
        }
    }

    @Override
    public final void visit(GT gt) throws QLException {
        this.boolRet = evalFloat(gt.getLeft()) > evalFloat(gt.getRight());
    }

    @Override
    public final void visit(GEq geq) throws QLException {
        this.boolRet = evalFloat(geq.getLeft()) >= evalFloat(geq.getRight());
    }

    @Override
    public final void visit(LT lt) throws QLException {
        this.boolRet = evalFloat(lt.getLeft()) < evalFloat(lt.getRight());
    }

    @Override
    public final void visit(LEq leq) throws QLException {
        this.boolRet = evalFloat(leq.getLeft()) <= evalFloat(leq.getRight());
    }

    @Override
    public final void visit(Not not) throws QLException {
        this.boolRet = !evalBool(not.getAdjacent());
    }

    @Override
    public final void visit(IntLiteral i) throws QLException {
        this.mathRet = i.getValue();
    }

    @Override
    public void visit(BoolLiteral b) throws QLException {
        this.boolRet = b.getValue();
    }

    @Override
    public void visit(StringLiteral s) throws QLException {
    }

    private float evalFloat(Expr ex) throws QLException {
        return this.evaluator.evalFloat(ex);
    }

    private boolean evalBool(Expr ex) throws QLException {
        return this.evaluator.evalBool(ex);
    }

    private boolean checkReturn(BinaryExpr ex, AbstractType type)
            throws QLException {
        return checkReturn(ex.getLeft(), type)
                && checkReturn(ex.getRight(), type);
    }

    private boolean checkReturn(Expr ex, AbstractType type) throws QLException {
        return registry.lookupReturnType(ex).equals(type);
    }

}
