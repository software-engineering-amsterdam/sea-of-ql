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
import org.uva.sea.ql.common.ExpressionVisitor;
import org.uva.sea.ql.common.QLException;
import org.uva.sea.ql.common.returnfinder.ReturnFinder;
import org.uva.sea.ql.interpretation.SwingRegistry;
import org.uva.sea.ql.interpretation.components.content.QuestionPanel;
import org.uva.sea.ql.interpretation.exception.EmptyInputException;
import org.uva.sea.ql.interpretation.exception.EvaluationException;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class MathEvaluator {
 
    private MathEval evaluator;
    
    public MathEvaluator(SwingRegistry reg, boolean replaceEmptyInputWithZero) {
        this.evaluator = new MathEval(replaceEmptyInputWithZero, reg);
    }

    public final float eval(Expr e) throws QLException {
        System.out.println("math eval: " + e.toString());
        ((Expression) e).accept(evaluator);
        return this.evaluator.mathRet;
    }

    private class MathEval extends Evaluator implements ExpressionVisitor {
        private boolean replaceEmtyWithZero;
        private float mathRet;

        public MathEval(boolean replaceEmptyWithZero, SwingRegistry reg){
            super(reg, false);
        }
        @Override
        public void visit(Add add) throws QLException {
            mathRet = eval(add.getLeft()) + eval(add.getRight());
        }

        @Override
        public void visit(Mul mul) throws QLException {
            mathRet = eval(mul.getLeft()) * eval(mul.getRight());
        }

        @Override
        public void visit(Div div) throws QLException {
            mathRet = eval(div.getLeft()) / eval(div.getRight());
        }

        @Override
        public void visit(Sub sub) throws QLException {
            mathRet = eval(sub.getLeft()) - eval(sub.getRight());
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
            mathRet = eval(pos.getAdjacent()) * (1);
        }

        @Override
        public void visit(Neg neg) throws QLException {
            mathRet = eval(neg.getAdjacent()) * (-1);
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

        public final void visit(IntLiteral i) {
            mathRet = i.getValue();
        }

        @Override
        public void visit(BoolLiteral b) throws QLException {
            throw new NotImplementedException();
        }
        
        private void tryToReplaceEmptyInput() throws EmptyInputException {
            if (replaceEmtyWithZero) {
                mathRet = 0;
            } else {
                throw new EmptyInputException();
            }
        }

        private void tryToParseInput(QuestionPanel questionPanel)
                throws EvaluationException {
            try {
                questionPanel.setValid(true);
                mathRet = Float.parseFloat(questionPanel.getStringValue().replace(
                        ',', '.'));
            } catch (NumberFormatException ex) {
                questionPanel.setValid(false);
            }
        }

    }
}
