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
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.interfaces.Evaluatable;
import org.uva.sea.ql.ast.interfaces.ReturnTypes;
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
import org.uva.sea.ql.common.ReturnFinder;
import org.uva.sea.ql.common.QLException;
import org.uva.sea.ql.common.interfaces.EvaluationVisitor;
import org.uva.sea.ql.interpretation.exception.EmptyInputException;
import org.uva.sea.ql.interpretation.exception.EvaluationException;

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
        final QuestionPanel q = this.registry.getQuestionPanelByIdent(i);
        ReturnFinder f = new ReturnFinder(this.registry.getQuestionsAst());
        q.getQuestion().getType().accept(f);
        ReturnTypes r = f.getResult();
        if (r.equals(ReturnTypes.MATH)) {
            final String val = q.getStringValue();
            if (val.trim().equals("")) {
                if (replaceEmtyWithZero) {
                    ret = 0;
                } else {
                    throw new EmptyInputException();
                }
            }
            try {
                ret = Float.parseFloat(q.getStringValue().replace(',', '.'));
            } catch (NumberFormatException ex) {
                throw new EvaluationException("invalid user input");
            }
        }
    }

    public void visit(IntLiteral i) {
        ret = i.getValue();
    }

    @Override
    public void visit(BooleanType booleanType) {
        throw new NotImplementedException();
    }

    @Override
    public void visit(IntType intType) {
        throw new NotImplementedException();
    }

    @Override
    public void visit(Money money) {
        throw new NotImplementedException();
    }

    @Override
    public void visit(StrType strType) {
        throw new NotImplementedException();
    }
}
