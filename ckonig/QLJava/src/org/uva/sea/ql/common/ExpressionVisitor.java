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
import org.uva.sea.ql.ast.literals.IntLiteral;
import org.uva.sea.ql.ast.math.Add;
import org.uva.sea.ql.ast.math.Div;
import org.uva.sea.ql.ast.math.Mul;
import org.uva.sea.ql.ast.math.Neg;
import org.uva.sea.ql.ast.math.Pos;
import org.uva.sea.ql.ast.math.Sub;


public interface ExpressionVisitor {
    void visit(Add add) throws QLException;

    void visit(Mul mul) throws QLException;

    void visit(Div div) throws QLException;

    void visit(Sub sub) throws QLException;

    void visit(And and) throws QLException;

    void visit(Or or) throws QLException;

    void visit(Eq eq) throws QLException;

    void visit(NEq neq) throws QLException;

    void visit(GT gt) throws QLException;

    void visit(GEq geq) throws QLException;

    void visit(LT lt) throws QLException;

    void visit(LEq leq) throws QLException;

    void visit(Not not) throws QLException;

    void visit(Pos pos) throws QLException;

    void visit(Neg neg) throws QLException;

    void visit(Ident ident) throws QLException;
    
    void visit(IntLiteral i) throws QLException;
}
