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
import org.uva.sea.ql.ast.interfaces.Expression;
import org.uva.sea.ql.ast.literals.BoolLiteral;
import org.uva.sea.ql.ast.literals.IntLiteral;
import org.uva.sea.ql.ast.math.Add;
import org.uva.sea.ql.ast.math.Div;
import org.uva.sea.ql.ast.math.Mul;
import org.uva.sea.ql.ast.math.Neg;
import org.uva.sea.ql.ast.math.Pos;
import org.uva.sea.ql.ast.math.Sub;
import org.uva.sea.ql.ast.types.AbstractMathType;
import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.common.ExpressionVisitor;
import org.uva.sea.ql.common.QLException;
import org.uva.sea.ql.common.returnfinder.ReturnFinder;
import org.uva.sea.ql.interpretation.SwingRegistry;

public abstract class EvaluationVisitor implements ExpressionVisitor {
    protected SwingRegistry registry;
    protected boolean boolRet;
    protected float mathRet;
    protected Evaluator evaluator;

    public EvaluationVisitor(SwingRegistry reg, Evaluator eval) {
        this.registry = reg;
        this.evaluator = eval;
    }

    @Override
    public final void visit(Add add) throws QLException {
        this.mathRet = this.evaluator.evalFloat(add.getLeft())
                + this.evaluator.evalFloat(add.getRight());
    }

    @Override
    public final void visit(Mul mul) throws QLException {
        this.mathRet = this.evaluator.evalFloat(mul.getLeft())
                * this.evaluator.evalFloat(mul.getRight());
    }

    @Override
    public final void visit(Div div) throws QLException {
        this.mathRet = this.evaluator.evalFloat(div.getLeft())
                / this.evaluator.evalFloat(div.getRight());
    }

    @Override
    public final void visit(Sub sub) throws QLException {
        this.mathRet = this.evaluator.evalFloat(sub.getLeft())
                - this.evaluator.evalFloat(sub.getRight());
    }

    @Override
    public final void visit(Pos pos) throws QLException {
        this.mathRet = this.evaluator.evalFloat(pos.getAdjacent()) * (1);
    }

    @Override
    public final void visit(Neg neg) throws QLException {
        this.mathRet = this.evaluator.evalFloat(neg.getAdjacent()) * (-1);
    }

    @Override
    public final void visit(And and) throws QLException {
        this.boolRet = this.evaluator.evalBool(and.getLeft())
                && this.evaluator.evalBool(and.getRight());
    }

    @Override
    public final void visit(Or or) throws QLException {
        this.boolRet = this.evaluator.evalBool(or.getLeft())
                || this.evaluator.evalBool(or.getRight());
    }

    @Override
    public final void visit(Eq eq) throws QLException {
        if (checkReturn(eq, BooleanType.class)) {
            this.boolRet = this.evaluator.evalBool(eq.getLeft()) == this.evaluator
                    .evalBool(eq.getRight());
        }
        if (checkReturn(eq, AbstractMathType.class)) {
            this.boolRet = this.evaluator.evalFloat(eq.getLeft()) == this.evaluator
                    .evalFloat(eq.getRight());
        }
    }

    @Override
    public final void visit(NEq neq) throws QLException {
        if (checkReturn(neq, BooleanType.class)) {
            this.boolRet = this.evaluator.evalBool(neq.getLeft()) != this.evaluator
                    .evalBool(neq.getRight());
        }
        if (checkReturn(neq, AbstractMathType.class)) {
            this.boolRet = this.evaluator.evalFloat(neq.getLeft()) != this.evaluator
                    .evalFloat(neq.getRight());
        }
    }

    @Override
    public final void visit(GT gt) throws QLException {
        this.boolRet = this.evaluator.evalFloat(gt.getLeft()) > this.evaluator
                .evalFloat(gt.getRight());
    }

    @Override
    public final void visit(GEq geq) throws QLException {
        this.boolRet = this.evaluator.evalFloat(geq.getLeft()) >= this.evaluator
                .evalFloat(geq.getRight());
    }

    @Override
    public final void visit(LT lt) throws QLException {
        this.boolRet = this.evaluator.evalFloat(lt.getLeft()) < this.evaluator
                .evalFloat(lt.getRight());
    }

    @Override
    public final void visit(LEq leq) throws QLException {
        this.boolRet = this.evaluator.evalFloat(leq.getLeft()) <= this.evaluator
                .evalFloat(leq.getRight());
    }

    @Override
    public final void visit(Not not) throws QLException {
        this.boolRet = !this.evaluator.evalBool(not.getAdjacent());
    }

    @Override
    public final void visit(IntLiteral i) throws QLException {
        this.mathRet = i.getValue();
    }

    @Override
    public void visit(BoolLiteral b) throws QLException {
        this.boolRet = b.getValue();
    }

    private boolean checkReturn(BinaryExpr ex, Class<?> type)
            throws QLException {
        return checkReturn(ex.getLeft(), type)
                && checkReturn(ex.getRight(), type);
    }

    private boolean checkReturn(Expr ex, Class<?> type) throws QLException {
        final ReturnFinder r = new ReturnFinder(
                this.registry.getQuestionsAst(), (Expression) ex);
        return r.getResult().equals(type);
    }

}
