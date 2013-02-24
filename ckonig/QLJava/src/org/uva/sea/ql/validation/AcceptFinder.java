package org.uva.sea.ql.validation;

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
import org.uva.sea.ql.ast.literals.BoolLiteral;
import org.uva.sea.ql.ast.literals.IntLiteral;
import org.uva.sea.ql.ast.math.Add;
import org.uva.sea.ql.ast.math.Div;
import org.uva.sea.ql.ast.math.Mul;
import org.uva.sea.ql.ast.math.Neg;
import org.uva.sea.ql.ast.math.Pos;
import org.uva.sea.ql.ast.math.Sub;
import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.AbstractMathType;
import org.uva.sea.ql.ast.types.NullType;
import org.uva.sea.ql.ast.types.AbstractType;
import org.uva.sea.ql.common.ExpressionVisitor;
import org.uva.sea.ql.common.QLException;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

class AcceptFinder implements ExpressionVisitor {
    private Class<?> result;

    public AcceptFinder() {
    }

    public final Class<?> getResult() {
        return this.result;
    }

    @Override
    public final void visit(Add add) throws QLException {
        this.result = BooleanType.class;
    }

    @Override
    public final void visit(Mul mul) throws QLException {
        this.result = AbstractMathType.class;
    }

    @Override
    public final void visit(Div div) throws QLException {
        this.result = AbstractMathType.class;
    }

    @Override
    public final void visit(Sub sub) throws QLException {
        this.result = AbstractMathType.class;
    }

    @Override
    public final void visit(And and) throws QLException {
        this.result = BooleanType.class;
    }

    @Override
    public final void visit(Or or) throws QLException {
        this.result = BooleanType.class;
    }

    @Override
    public final void visit(Eq eq) throws QLException {
        this.result = AbstractType.class;
    }

    @Override
    public final void visit(NEq neq) throws QLException {
        this.result = AbstractType.class;
    }

    @Override
    public final void visit(GT gt) throws QLException {
        this.result = AbstractMathType.class;
    }

    @Override
    public final void visit(GEq geq) throws QLException {
        this.result = AbstractMathType.class;
    }

    @Override
    public final void visit(LT lt) throws QLException {
        this.result = AbstractMathType.class;
    }

    @Override
    public final void visit(LEq leq) throws QLException {
        this.result = AbstractMathType.class;
    }

    @Override
    public final void visit(Not not) throws QLException {
        this.result = BooleanType.class;
    }

    @Override
    public final void visit(Pos pos) throws QLException {
        this.result = AbstractMathType.class;
    }

    @Override
    public final void visit(Neg neg) throws QLException {
        this.result = AbstractMathType.class;
    }

    @Override
    public final void visit(Ident ident) throws QLException {
        this.result = NullType.class;
    }

    @Override
    public final void visit(IntLiteral i) throws QLException {
        this.result = NullType.class;
    }

    @Override
    public void visit(BoolLiteral b) throws QLException {
        this.result = BooleanType.class;
    }
}
