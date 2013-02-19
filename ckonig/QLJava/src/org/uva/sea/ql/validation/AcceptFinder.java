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
import org.uva.sea.ql.common.ReturnTypes;

 class AcceptFinder implements EvaluationVisitor {
    private ReturnTypes result;

    public AcceptFinder() {
    }

    public final ReturnTypes getResult() {
        return this.result;
    }

    @Override
    public final void visit(Add add) throws QLException {
        this.result = ReturnTypes.BOOLEAN;
    }

    @Override
    public final void visit(Mul mul) throws QLException {
        this.result = ReturnTypes.MATH;
    }

    @Override
    public final void visit(Div div) throws QLException {
        this.result = ReturnTypes.MATH;
    }

    @Override
    public final void visit(Sub sub) throws QLException {
        this.result = ReturnTypes.MATH;
    }

    @Override
    public final void visit(And and) throws QLException {
        this.result = ReturnTypes.BOOLEAN;
    }

    @Override
    public final void visit(Or or) throws QLException {
        this.result = ReturnTypes.BOOLEAN;
    }

    @Override
    public final void visit(Eq eq) throws QLException {
        this.result = ReturnTypes.BOTH;
    }

    @Override
    public final void visit(NEq neq) throws QLException {
        this.result = ReturnTypes.BOTH;
    }

    @Override
    public final void visit(GT gt) throws QLException {
        this.result = ReturnTypes.MATH;
    }

    @Override
    public final void visit(GEq geq) throws QLException {
        this.result = ReturnTypes.MATH;
    }

    @Override
    public final void visit(LT lt) throws QLException {
        this.result = ReturnTypes.MATH;
    }

    @Override
    public final void visit(LEq leq) throws QLException {
        this.result = ReturnTypes.MATH;
    }

    @Override
    public final void visit(Not not) throws QLException {
        this.result = ReturnTypes.BOOLEAN;
    }

    @Override
    public final void visit(Pos pos) throws QLException {
        this.result = ReturnTypes.MATH;
    }

    @Override
    public final void visit(Neg neg) throws QLException {
        this.result = ReturnTypes.MATH;
    }

    @Override
    public final void visit(Ident ident) throws QLException {
        this.result = ReturnTypes.NONE;
    }

    @Override
    public final void visit(IntLiteral i) throws QLException {
        this.result = ReturnTypes.NONE;
    }

    @Override
    public final void visit(BooleanType booleanType) {
        this.result = ReturnTypes.NONE;
    }

    @Override
    public final void visit(IntType intType) {
        this.result = ReturnTypes.NONE;
    }

    @Override
    public final void visit(Money money) {
        this.result = ReturnTypes.NONE;
    }

    @Override
    public final void visit(StrType strType) {
        this.result = ReturnTypes.NONE;
    }

}
