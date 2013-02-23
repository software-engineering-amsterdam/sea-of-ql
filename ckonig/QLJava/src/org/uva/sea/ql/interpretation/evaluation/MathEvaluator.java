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
import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.interfaces.Evaluatable;
import org.uva.sea.ql.ast.literals.BoolLiteral;
import org.uva.sea.ql.ast.literals.IntLiteral;
import org.uva.sea.ql.ast.math.Add;
import org.uva.sea.ql.ast.math.Div;
import org.uva.sea.ql.ast.math.Mul;
import org.uva.sea.ql.ast.math.Neg;
import org.uva.sea.ql.ast.math.Pos;
import org.uva.sea.ql.ast.math.Sub;
import org.uva.sea.ql.ast.types.AbstractMathType;
import org.uva.sea.ql.common.ExpressionVisitor;
import org.uva.sea.ql.common.QLException;
import org.uva.sea.ql.common.returnfinder.ReturnFinder;
import org.uva.sea.ql.interpretation.SwingRegistry;
import org.uva.sea.ql.interpretation.components.content.QuestionPanel;
import org.uva.sea.ql.interpretation.exception.EmptyInputException;
import org.uva.sea.ql.interpretation.exception.EvaluationException;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class MathEvaluator {
    private boolean replaceEmtyWithZero;
    private SwingRegistry registry;
    private float ret;

    public MathEvaluator(SwingRegistry reg) {
        registry = reg;
        this.replaceEmtyWithZero = false;
    }

    public MathEvaluator(SwingRegistry reg, boolean replaceEmptyInputWithZero) {
        this(reg);
        this.replaceEmtyWithZero = replaceEmptyInputWithZero;
    }

    public final float eval(Expr e) throws QLException {
        System.out.println("math eval: " + e.toString());
        ((Evaluatable) e).accept(new MathEval());
        return this.ret;
    }

    private class MathEval implements ExpressionVisitor {

        @Override
        public void visit(Add add) throws QLException {
            ret = eval(add.getLeft()) + eval(add.getRight());
        }

        @Override
        public void visit(Mul mul) throws QLException {
            ret = eval(mul.getLeft()) * eval(mul.getRight());
        }

        @Override
        public void visit(Div div) throws QLException {
            ret = eval(div.getLeft()) / eval(div.getRight());
        }

        @Override
        public void visit(Sub sub) throws QLException {
            ret = eval(sub.getLeft()) - eval(sub.getRight());
        }

        @Override
        public void visit(And and) throws QLException {
            throw new NotImplementedException();
        }

        @Override
        public void visit(Or or) throws QLException {
            throw new NotImplementedException();
        }

        @Override
        public void visit(Eq eq) throws QLException {
            throw new NotImplementedException();
        }

        @Override
        public void visit(NEq neq) throws QLException {
            throw new NotImplementedException();
        }

        @Override
        public void visit(GT gt) throws QLException {
            throw new NotImplementedException();
        }

        @Override
        public void visit(GEq geq) throws QLException {
            throw new NotImplementedException();
        }

        @Override
        public void visit(LT lt) throws QLException {
            throw new NotImplementedException();
        }

        @Override
        public void visit(LEq leq) throws QLException {
            throw new NotImplementedException();
        }

        @Override
        public void visit(Not not) throws QLException {
            throw new NotImplementedException();
        }

        @Override
        public void visit(Pos pos) throws QLException {
            ret = eval(pos.getAdjacent()) * (1);
        }

        @Override
        public void visit(Neg neg) throws QLException {
            ret = eval(neg.getAdjacent()) * (-1);
        }

        @Override
        public void visit(Ident i) throws QLException {
            final QuestionPanel questionPanel = registry
                    .getQuestionPanelByIdent(i);
            final ReturnFinder finder = new ReturnFinder(
                    registry.getQuestionsAst(), questionPanel.getQuestion().getType());
            final Class<?> result = finder.getResult();
            if (result.equals(AbstractMathType.class)) {
                final String val = questionPanel.getStringValue();
                if (val.trim().equals("")) {
                    this.tryToReplaceEmptyInput();
                } else {
                    this.tryToParseInput(questionPanel);
                }
            }
        }

        private void tryToReplaceEmptyInput() throws EmptyInputException {
            if (replaceEmtyWithZero) {
                ret = 0;
            } else {
                throw new EmptyInputException();
            }
        }

        private void tryToParseInput(QuestionPanel questionPanel)
                throws EvaluationException {
            try {
                questionPanel.setValid(true);
                ret = Float.parseFloat(questionPanel.getStringValue().replace(
                        ',', '.'));
            } catch (NumberFormatException ex) {
                questionPanel.setValid(false);
            }
        }

        public final void visit(IntLiteral i) {
            ret = i.getValue();
        }

        @Override
        public void visit(BoolLiteral b) throws QLException {
            throw new NotImplementedException();
        }
    }
}
