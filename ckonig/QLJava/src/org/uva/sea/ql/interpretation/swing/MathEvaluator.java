package org.uva.sea.ql.interpretation.swing;

import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.ast.expressions.BinaryExpr;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.expressions.UnaryExpr;
import org.uva.sea.ql.ast.interfaces.ReturnsMathOperands;
import org.uva.sea.ql.ast.literal.IntLiteral;
import org.uva.sea.ql.ast.math.Add;
import org.uva.sea.ql.ast.math.Div;
import org.uva.sea.ql.ast.math.Mul;
import org.uva.sea.ql.ast.math.Neg;
import org.uva.sea.ql.ast.math.Pos;
import org.uva.sea.ql.ast.math.Sub;
import org.uva.sea.ql.interpretation.exception.EmptyInputException;
import org.uva.sea.ql.interpretation.exception.EvaluationException;

public class MathEvaluator {
    private boolean replaceEmtyWithZero;
    private SwingRegistry registry;

    public MathEvaluator(SwingRegistry reg) {
        this.registry = reg;
        this.replaceEmtyWithZero = false;
    }

    public MathEvaluator(SwingRegistry reg, boolean replaceEmptyInputWithZero) {
        this(reg);
        this.replaceEmtyWithZero = replaceEmptyInputWithZero;
    }

    public final float eval(Expr e) throws EvaluationException {
        if (e instanceof UnaryExpr) {
            final UnaryExpr u = (UnaryExpr) e;
            if (u instanceof Neg) {
                return this.eval(u.getAdjacent()) * (-1);
            }
            if (u instanceof Pos) {
                return this.eval(u.getAdjacent()) * (1);
            }
        }
        if (e instanceof BinaryExpr) {
            final BinaryExpr b = (BinaryExpr) e;
            if (b instanceof Add) {
                return this.eval(b.getLeft()) + this.eval(b.getRight());
            }
            if (b instanceof Sub) {
                return this.eval(b.getLeft()) - this.eval(b.getRight());
            }
            if (b instanceof Mul) {
                return this.eval(b.getLeft()) * this.eval(b.getRight());
            }
            if (b instanceof Div) {
                return this.eval(b.getLeft()) / this.eval(b.getRight());
            }
        }
        if (e instanceof IntLiteral) {
            return ((IntLiteral) e).getValue();
        }
        if (e instanceof Ident) {
            final Ident i = (Ident) e;
            final QuestionPanel q = this.registry.getQuestionPanelByIdent(i);

            if (q.getQuestion().getType() instanceof ReturnsMathOperands) {
                final String val = q.getStringValue();
                if (val.trim().equals("")) {
                    if (replaceEmtyWithZero) {
                        return 0;
                    } else {
                        throw new EmptyInputException();
                    }
                }
                try {
                    return Float.parseFloat(q.getStringValue()
                            .replace(',', '.'));
                } catch (NumberFormatException ex) {
                    throw new EvaluationException("invalid user input");
                }
            }

        }
        throw new EvaluationException("math evaluation failed");
    }
}
