package org.uva.sea.ql.common.interfaces;

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
import org.uva.sea.ql.common.VisitorException;


public interface EvaluationVisitor {
    void visit(Add add) throws VisitorException;

    void visit(Mul mul) throws VisitorException;

    void visit(Div div) throws VisitorException;

    void visit(Sub sub) throws VisitorException;

    void visit(And and) throws VisitorException;

    void visit(Or or) throws VisitorException;

    void visit(Eq eq) throws VisitorException;

    void visit(NEq neq) throws VisitorException;

    void visit(GT gt) throws VisitorException;

    void visit(GEq geq) throws VisitorException;

    void visit(LT lt) throws VisitorException;

    void visit(LEq leq) throws VisitorException;

    void visit(Not not) throws VisitorException;

    void visit(Pos pos) throws VisitorException;

    void visit(Neg neg) throws VisitorException;

    void visit(Ident ident) throws VisitorException;
    
    void visit(IntLiteral i) throws VisitorException;

    void visit(BooleanType booleanType);

    void visit(IntType intType);

    void visit(Money money);

    void visit(StrType strType);

}
