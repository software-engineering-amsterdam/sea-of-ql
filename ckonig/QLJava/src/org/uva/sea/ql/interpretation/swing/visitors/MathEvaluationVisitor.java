package org.uva.sea.ql.interpretation.swing.visitors;

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
import org.uva.sea.ql.ast.literals.IntLiteral;
import org.uva.sea.ql.ast.math.Add;
import org.uva.sea.ql.ast.math.Div;
import org.uva.sea.ql.ast.math.Mul;
import org.uva.sea.ql.ast.math.Neg;
import org.uva.sea.ql.ast.math.Pos;
import org.uva.sea.ql.ast.math.Sub;
import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.Money;
import org.uva.sea.ql.ast.types.StrType;
import org.uva.sea.ql.common.EvaluationVisitor;
import org.uva.sea.ql.common.QLException;
import org.uva.sea.ql.common.ReturnFinder;
import org.uva.sea.ql.common.ReturnTypes;
import org.uva.sea.ql.interpretation.exception.EmptyInputException;
import org.uva.sea.ql.interpretation.exception.EvaluationException;
import org.uva.sea.ql.interpretation.swing.SwingRegistry;
import org.uva.sea.ql.interpretation.swing.components.QuestionPanel;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class MathEvaluationVisitor implements EvaluationVisitor {
    private boolean replaceEmtyWithZero;
    private SwingRegistry registry;
    private float ret;

    public MathEvaluationVisitor(SwingRegistry reg) {
        this.registry = reg;
        this.replaceEmtyWithZero = false;
    }

    public MathEvaluationVisitor(SwingRegistry reg,
            boolean replaceEmptyInputWithZero) {
        this(reg);
        this.replaceEmtyWithZero = replaceEmptyInputWithZero;
    }

    public final float eval(Expr e) throws QLException {
        ((Evaluatable) e).accept(this);

        return this.ret;
    }

    @Override
    public void visit(Add add) throws QLException {
        this.ret = this.eval(add.getLeft()) + this.eval(add.getRight());
    }

    @Override
    public void visit(Mul mul) throws QLException {
        this.ret = this.eval(mul.getLeft()) * this.eval(mul.getRight());
    }

    @Override
    public void visit(Div div) throws QLException {
        this.ret = this.eval(div.getLeft()) / this.eval(div.getRight());
    }

    @Override
    public void visit(Sub sub) throws QLException {
        this.ret = this.eval(sub.getLeft()) - this.eval(sub.getRight());
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
        this.ret = this.eval(pos.getAdjacent()) * (1);
    }

    @Override
    public void visit(Neg neg) throws QLException {
        this.ret = this.eval(neg.getAdjacent()) * (-1);
    }

    @Override
    public void visit(Ident i) throws QLException {
        final QuestionPanel questionPanel = this.registry
                .getQuestionPanelByIdent(i);
        final ReturnFinder finder = new ReturnFinder(
                this.registry.getQuestionsAst());
        questionPanel.getQuestion().getType().accept(finder);
        final ReturnTypes result = finder.getResult();
        if (result.equals(ReturnTypes.MATH)) {
            final String val = questionPanel.getStringValue();
            if (val.trim().equals("")) {
                this.tryToReplaceEmptyInput();
            } else {
                this.tryToParseInput(questionPanel);
            }
        }
    }

    private void tryToReplaceEmptyInput() throws EmptyInputException {
        if (this.replaceEmtyWithZero) {
            this.ret = 0;
        } else {
            throw new EmptyInputException();
        }
    }

    private void tryToParseInput(QuestionPanel questionPanel)
            throws EvaluationException {
        try {
            questionPanel.setValid(true);
            this.ret = Float.parseFloat(questionPanel.getStringValue().replace(
                    ',', '.'));
        } catch (NumberFormatException ex) {
            questionPanel.setValid(false);
        }
    }

    public final void visit(IntLiteral i) {
        this.ret = i.getValue();
    }

    @Override
    public final void visit(BooleanType booleanType) {
        throw new NotImplementedException();
    }

    @Override
    public final void visit(IntType intType) {
        throw new NotImplementedException();
    }

    @Override
    public final void visit(Money money) {
        throw new NotImplementedException();
    }

    @Override
    public final void visit(StrType strType) {
        throw new NotImplementedException();
    }
}
