package org.uva.sea.ql.interpretation.swing.visitors;

import java.util.List;

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
import org.uva.sea.ql.ast.elements.Question;
import org.uva.sea.ql.ast.expressions.BinaryExpr;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.interfaces.Evaluatable;
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
import org.uva.sea.ql.common.ReturnFinder;
import org.uva.sea.ql.interpretation.swing.SwingRegistry;
import org.uva.sea.ql.interpretation.swing.components.QuestionPanel;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class BoolEvaluator {

    private SwingRegistry registry;
    private boolean ret;

    public BoolEvaluator(SwingRegistry reg) {
        this.registry = reg;
    }

    public final boolean eval(Expr e) throws QLException {
        ((Evaluatable) e).accept(new BoolEvaluationVisitor());
        return this.ret;
    }

    private class BoolEvaluationVisitor implements ExpressionVisitor {

        public BoolEvaluationVisitor() {
            this.math = new MathEvaluator(registry);
        }

        private MathEvaluator math;

        @Override
        public final void visit(Add add) throws QLException {
            throw new NotImplementedException();
        }

        @Override
        public final void visit(Mul mul) throws QLException {
            throw new NotImplementedException();
        }

        @Override
        public final void visit(Div div) throws QLException {
            throw new NotImplementedException();
        }

        @Override
        public final void visit(Sub sub) throws QLException {
            throw new NotImplementedException();
        }

        @Override
        public final void visit(And and) throws QLException {
            ret = eval(and.getLeft()) && eval(and.getRight());
        }

        @Override
        public final void visit(Or or) throws QLException {
            ret = eval(or.getLeft()) || eval(or.getRight());
        }

        @Override
        public final void visit(Eq eq) throws QLException {
            if (checkReturn(eq, registry.getQuestionsAst(), BooleanType.class)) {
                ret = eval(eq.getLeft()) == eval(eq.getRight());
            }
            if (checkReturn(eq, registry.getQuestionsAst(),
                    AbstractMathType.class)) {
                ret = this.math.eval(eq.getLeft()) == this.math.eval(eq
                        .getRight());
            }
        }

        @Override
        public final void visit(NEq neq) throws QLException {
            if (checkReturn(neq, registry.getQuestionsAst(), BooleanType.class)) {
                ret = eval(neq.getLeft()) != eval(neq.getRight());
            }
            if (checkReturn(neq, registry.getQuestionsAst(),
                    AbstractMathType.class)) {
                ret = this.math.eval(neq.getLeft()) != this.math.eval(neq
                        .getRight());
            }
        }

        @Override
        public final void visit(GT gt) throws QLException {
            ret = this.math.eval(gt.getLeft()) > this.math.eval(gt.getRight());
        }

        @Override
        public final void visit(GEq geq) throws QLException {
            ret = this.math.eval(geq.getLeft()) >= this.math.eval(geq
                    .getRight());
        }

        @Override
        public final void visit(LT lt) throws QLException {
            ret = this.math.eval(lt.getLeft()) < this.math.eval(lt.getRight());
        }

        @Override
        public final void visit(LEq leq) throws QLException {
            ret = this.math.eval(leq.getLeft()) <= this.math.eval(leq
                    .getRight());
        }

        @Override
        public final void visit(Not not) throws QLException {
            ret = !eval(not.getAdjacent());
        }

        @Override
        public final void visit(Pos pos) throws QLException {
            throw new NotImplementedException();
        }

        @Override
        public final void visit(Neg neg) throws QLException {
            throw new NotImplementedException();
        }

        @Override
        public final void visit(Ident ident) throws QLException {
            final QuestionPanel q = registry.getQuestionPanelByIdent(ident);
            final ReturnFinder f = new ReturnFinder(registry.getQuestionsAst());
            ident.accept(f);
            final Class<?> r = f.getResult();
            if (r.equals(BooleanType.class)) {
                ret = q.getBoolValue();
            }
        }

        @Override
        public final void visit(IntLiteral i) throws QLException {
            throw new NotImplementedException();
        }

    }

    private static boolean checkReturn(BinaryExpr ex, List<Question> questions,
            Class<?> type) throws QLException {
        return checkReturn(ex.getLeft(), questions, type)
                && checkReturn(ex.getRight(), questions, type);
    }

    private static boolean checkReturn(Expr ex, List<Question> questions,
            Class<?> type) throws QLException {
        final ReturnFinder r = new ReturnFinder(questions);
        ((Evaluatable) ex).accept(r);
        return r.getResult().equals(type);
    }

}
