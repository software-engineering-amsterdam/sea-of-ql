package org.uva.sea.ql.common;

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
import org.uva.sea.ql.ast.interfaces.ReturnTypes;
import org.uva.sea.ql.ast.literal.IntLiteral;
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

public class AcceptFinder implements EvaluationVisitor {
    private ReturnTypes result;

    public AcceptFinder() {
    }

    public final ReturnTypes getResult() {
        return this.result;
    }

    @Override
    public final void visit(Add add) throws VisitorException {
        this.result = ReturnTypes.BOOLEAN;
    }

    @Override
    public final void visit(Mul mul) throws VisitorException {
        this.result = ReturnTypes.MATH;
    }

    @Override
    public final void visit(Div div) throws VisitorException {
        this.result = ReturnTypes.MATH;
    }

    @Override
    public final void visit(Sub sub) throws VisitorException {
        this.result = ReturnTypes.MATH;
    }

    @Override
    public final void visit(And and) throws VisitorException {
        this.result = ReturnTypes.BOOLEAN;
    }

    @Override
    public final void visit(Or or) throws VisitorException {
        this.result = ReturnTypes.BOOLEAN;
    }

    @Override
    public final void visit(Eq eq) throws VisitorException {
        this.result = ReturnTypes.BOTH;
    }

    @Override
    public final void visit(NEq neq) throws VisitorException {
        this.result = ReturnTypes.BOTH;
    }

    @Override
    public final void visit(GT gt) throws VisitorException {
        this.result = ReturnTypes.MATH;
    }

    @Override
    public final void visit(GEq geq) throws VisitorException {
        this.result = ReturnTypes.MATH;
    }

    @Override
    public final void visit(LT lt) throws VisitorException {
        this.result = ReturnTypes.MATH;
    }

    @Override
    public final void visit(LEq leq) throws VisitorException {
        this.result = ReturnTypes.MATH;
    }

    @Override
    public final void visit(Not not) throws VisitorException {
        this.result = ReturnTypes.BOOLEAN;
    }

    @Override
    public final void visit(Pos pos) throws VisitorException {
        this.result = ReturnTypes.MATH;
    }

    @Override
    public final void visit(Neg neg) throws VisitorException {
        this.result = ReturnTypes.MATH;
    }

    @Override
    public final void visit(Ident ident) throws VisitorException {
        this.result = ReturnTypes.NONE;
    }

    @Override
    public final void visit(IntLiteral i) throws VisitorException {
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
