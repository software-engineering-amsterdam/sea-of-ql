package org.uva.sea.ql.common.returnfinder;

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
import org.uva.sea.ql.ast.types.StrType;
import org.uva.sea.ql.common.ExpressionVisitor;
import org.uva.sea.ql.common.QLException;

class ReturnFinderExpressionVisitor implements ExpressionVisitor {
    protected AbstractType ret;
    protected List<Question> questions;

    public ReturnFinderExpressionVisitor(List<Question> q) {
        this.questions = q;
    }

    final AbstractType getResult() {
        return this.ret;
    }

    @Override
    public final void visit(Add add) throws QLException {
        returnAbstractMath();
    }

    @Override
    public final void visit(Mul mul) throws QLException {
        returnAbstractMath();
    }

    @Override
    public final void visit(Div div) throws QLException {
        returnAbstractMath();
    }

    @Override
    public final void visit(Sub sub) throws QLException {
        returnAbstractMath();
    }

    @Override
    public final void visit(And and) throws QLException {
        returnBoolean();
    }

    @Override
    public final void visit(Or or) throws QLException {
        returnBoolean();
    }

    @Override
    public final void visit(Eq eq) throws QLException {
        returnBoolean();
    }

    @Override
    public final void visit(NEq neq) throws QLException {
        returnBoolean();
    }

    @Override
    public final void visit(GT gt) throws QLException {
        returnBoolean();
    }

    @Override
    public final void visit(GEq geq) throws QLException {
        returnBoolean();
    }

    @Override
    public final void visit(LT lt) throws QLException {
        returnBoolean();
    }

    @Override
    public final void visit(LEq leq) throws QLException {
        returnBoolean();
    }

    @Override
    public final void visit(Not not) throws QLException {
        returnBoolean();
    }

    @Override
    public final void visit(Pos pos) throws QLException {
        returnAbstractMath();
    }

    @Override
    public final void visit(Neg neg) throws QLException {
        returnAbstractMath();
    }

    @Override
    public final void visit(Ident ident) throws QLException {
        boolean found = false;
        for (Question question : this.questions) {
            if (question.getIdentName().equals(ident.getName())) {
                this.ret = question.getType();
                found = true;
            }
        }
        if (!found) {
            throw new RuntimeException("Question not found: " + ident.getName());
        }
    }

    @Override
    public final void visit(IntLiteral i) throws QLException {
        returnAbstractMath();
    }

    @Override
    public void visit(BoolLiteral b) throws QLException {
        returnBoolean();
    }

    @Override
    public void visit(StringLiteral s) throws QLException {
        this.ret = new StrType();
    }

    private void returnAbstractMath() {
        this.ret = new IntType();
    }

    private void returnBoolean() {
        this.ret = new BooleanType();
    }
}
