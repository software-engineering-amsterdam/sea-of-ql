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
import org.uva.sea.ql.ast.types.AbstractMathType;
import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.common.ExpressionVisitor;
import org.uva.sea.ql.common.QLException;

public class ReturnFinderExpressionVisitor extends AbstractReturnFinderVisitor implements ExpressionVisitor {
    public ReturnFinderExpressionVisitor(List<Question> q) {
        super(q);
    }

    @Override
    public final void visit(Add add) throws QLException {
        this.ret = AbstractMathType.class;
    }

    @Override
    public final void visit(Mul mul) throws QLException {
        this.ret = AbstractMathType.class;
    }

    @Override
    public final void visit(Div div) throws QLException {
        this.ret = AbstractMathType.class;
    }

    @Override
    public final void visit(Sub sub) throws QLException {
        this.ret = AbstractMathType.class;
    }

    @Override
    public final void visit(And and) throws QLException {
        this.ret = BooleanType.class;
    }

    @Override
    public final void visit(Or or) throws QLException {
        this.ret = BooleanType.class;
    }

    @Override
    public final void visit(Eq eq) throws QLException {
        this.ret = BooleanType.class;
    }

    @Override
    public final void visit(NEq neq) throws QLException {
        this.ret = BooleanType.class;
    }

    @Override
    public final void visit(GT gt) throws QLException {
        this.ret = BooleanType.class;
    }

    @Override
    public final void visit(GEq geq) throws QLException {
        this.ret = BooleanType.class;
    }

    @Override
    public final void visit(LT lt) throws QLException {
        this.ret = BooleanType.class;
    }

    @Override
    public final void visit(LEq leq) throws QLException {
        this.ret = BooleanType.class;
    }

    @Override
    public final void visit(Not not) throws QLException {
        this.ret = BooleanType.class;
    }

    @Override
    public final void visit(Pos pos) throws QLException {
        this.ret = AbstractMathType.class;
    }

    @Override
    public final void visit(Neg neg) throws QLException {
        this.ret = AbstractMathType.class;
    }

    @Override
    public final void visit(Ident ident) throws QLException {
        boolean found = false;
        for (Question question : this.questions) {
            if (question.getIdentName().equals(ident.getName())) {
                final ReturnFinderTypeVisitor f = new ReturnFinderTypeVisitor(this.questions);
                question.getType().accept(f);
                this.ret = f.getResult();
                found = true;
            }
        }
        if (!found) {
            throw new RuntimeException("Question not found: "
                    + ident.getName());
        }
    }

    @Override
    public final void visit(IntLiteral i) throws QLException {
        this.ret = AbstractMathType.class;
    }

    @Override
    public void visit(BoolLiteral b) throws QLException {
        this.ret = BooleanType.class;
    }

    @Override
    public void visit(StringLiteral s) throws QLException {
        // TODO Auto-generated method stub
        
    }
}