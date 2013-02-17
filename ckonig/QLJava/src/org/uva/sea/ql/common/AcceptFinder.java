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
    private ReturnTypes r;

    public ReturnTypes getResult() {
        return r;
    }

    public AcceptFinder() {
    }

    @Override
    public void visit(Add add) throws VisitorException {
        r = (ReturnTypes.BOOLEAN);
    }

    @Override
    public void visit(Mul mul) throws VisitorException {
        r = (ReturnTypes.MATH);
    }

    @Override
    public void visit(Div div) throws VisitorException {
        r = (ReturnTypes.MATH);
    }

    @Override
    public void visit(Sub sub) throws VisitorException {
        r = (ReturnTypes.MATH);
    }

    @Override
    public void visit(And and) throws VisitorException {
        r = (ReturnTypes.BOOLEAN);
    }

    @Override
    public void visit(Or or) throws VisitorException {
        r = (ReturnTypes.BOOLEAN);
    }

    @Override
    public void visit(Eq eq) throws VisitorException {
        r = (ReturnTypes.BOTH);
    }

    @Override
    public void visit(NEq neq) throws VisitorException {
        r = (ReturnTypes.BOTH);
    }

    @Override
    public void visit(GT gt) throws VisitorException {
        r = (ReturnTypes.MATH);
    }

    @Override
    public void visit(GEq geq) throws VisitorException {
        r = (ReturnTypes.MATH);
    }

    @Override
    public void visit(LT lt) throws VisitorException {
        r = (ReturnTypes.MATH);
    }

    @Override
    public void visit(LEq leq) throws VisitorException {
        r = (ReturnTypes.MATH);
    }

    @Override
    public void visit(Not not) throws VisitorException {
        r = (ReturnTypes.BOOLEAN);
    }

    @Override
    public void visit(Pos pos) throws VisitorException {
        r = (ReturnTypes.MATH);
    }

    @Override
    public void visit(Neg neg) throws VisitorException {
        r = (ReturnTypes.MATH);
    }

    @Override
    public void visit(Ident ident) throws VisitorException {
        r = (ReturnTypes.NONE);
    }

    @Override
    public void visit(IntLiteral i) throws VisitorException {
        r = (ReturnTypes.NONE);
    }

    @Override
    public void visit(BooleanType booleanType) {
        r = (ReturnTypes.NONE);
    }

    @Override
    public void visit(IntType intType) {
        r = (ReturnTypes.NONE);
    }

    @Override
    public void visit(Money money) {
        r = (ReturnTypes.NONE);
    }

    @Override
    public void visit(StrType strType) {
        r = (ReturnTypes.NONE);
    }

}
