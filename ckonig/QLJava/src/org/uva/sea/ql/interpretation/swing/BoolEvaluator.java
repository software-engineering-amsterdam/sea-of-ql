package org.uva.sea.ql.interpretation.swing;


import org.uva.sea.ql.ast.bool.And;
import org.uva.sea.ql.ast.bool.Eq;
import org.uva.sea.ql.ast.bool.GEq;
import org.uva.sea.ql.ast.bool.GT;
import org.uva.sea.ql.ast.bool.LEq;
import org.uva.sea.ql.ast.bool.LT;
import org.uva.sea.ql.ast.bool.NEq;
import org.uva.sea.ql.ast.bool.Not;
import org.uva.sea.ql.ast.bool.Or;
import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.ast.expressions.BinaryExpr;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.expressions.UnaryExpr;
import org.uva.sea.ql.ast.interfaces.ReturnTypes;
import org.uva.sea.ql.ast.interfaces.Returns;
import org.uva.sea.ql.ast.interfaces.ReturnsMathOperands;
import org.uva.sea.ql.interpretation.exception.EvaluationException;

public class BoolEvaluator {

    SwingRegistry registry;

    public BoolEvaluator(SwingRegistry reg) {
        this.registry = reg;
    }

    public boolean eval(Expr e) throws EvaluationException {
        MathEvaluator math = new MathEvaluator(registry);
        if (e instanceof UnaryExpr) {
            UnaryExpr u = (UnaryExpr) e;
            if (u instanceof Not) {
                return !eval(u.getAdjacent());
            }
        }
        if (e instanceof BinaryExpr) {
            BinaryExpr b = (BinaryExpr) e;
            if (b instanceof And) {
                return eval(b.getLeft()) && eval(b.getRight());
            }
            if (b instanceof Or) {
                return eval(b.getLeft()) || eval(b.getRight());
            }
            if (b instanceof Eq) {
                Returns l = (Returns) b.getLeft();
                Returns r = (Returns) b.getRight();
                if (l.getReturnType(registry.getQuestionsAst()).equals(ReturnTypes.BOOLEAN)
                        && r.getReturnType(registry.getQuestionsAst()).equals(
                                ReturnTypes.BOOLEAN)) {
                    return eval(b.getLeft()) == eval(b.getRight());
                }
                if (b.getLeft() instanceof ReturnsMathOperands
                        && b.getRight() instanceof ReturnsMathOperands) {
                    return math.eval(b.getLeft()) == math.eval(b.getRight());
                }
            }
            if (b instanceof NEq) {
                Returns l = (Returns) b.getLeft();
                Returns r = (Returns) b.getRight();
                if (l.getReturnType(registry.getQuestionsAst()).equals(ReturnTypes.BOOLEAN)
                        && r.getReturnType(registry.getQuestionsAst()).equals(
                                ReturnTypes.BOOLEAN)) {
                    return eval(b.getLeft()) != eval(b.getRight());
                }
                if (b.getLeft() instanceof ReturnsMathOperands
                        && b.getRight() instanceof ReturnsMathOperands) {
                    return math.eval(b.getLeft()) != math.eval(b.getRight());
                }
            }
            if (b instanceof LEq) {
                return math.eval(b.getLeft()) <= math.eval(b.getRight());
            }
            if (b instanceof LT) {
                return math.eval(b.getLeft()) < math.eval(b.getRight());
            }
            if (b instanceof GEq) {
                return math.eval(b.getLeft()) >= math.eval(b.getRight());
            }
            if (b instanceof GT) {
                return math.eval(b.getLeft()) > math.eval(b.getRight());
            }
        }
        if (e instanceof Ident) {
            final Ident i = (Ident) e;
            final QuestionPanel q = this.registry.getQuestionPanelByIdent(i);
            Returns r = (Returns) q.getQuestion().getType();
            if (r.getReturnType(registry.getQuestionsAst()).equals(ReturnTypes.BOOLEAN)) {
                return q.getBoolValue();
            }
        }
        throw new EvaluationException("bool evaluation failed");
    }

}
