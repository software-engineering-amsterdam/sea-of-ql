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
import org.uva.sea.ql.ast.math.Add;
import org.uva.sea.ql.ast.math.Div;
import org.uva.sea.ql.ast.math.Mul;
import org.uva.sea.ql.ast.math.Neg;
import org.uva.sea.ql.ast.math.Pos;
import org.uva.sea.ql.ast.math.Sub;

public interface ExprVisitor {
    boolean visit(Add add) throws VisitorException;

    boolean visit(Mul mul) throws VisitorException;

    boolean visit(Div div) throws VisitorException;

    boolean visit(Sub sub) throws VisitorException;

    boolean visit(And and) throws VisitorException;

    boolean visit(Or or) throws VisitorException;

    boolean visit(Eq eq) throws VisitorException;

    boolean visit(NEq neq) throws VisitorException;

    boolean visit(GT gt) throws VisitorException;

    boolean visit(GEq geq) throws VisitorException;

    boolean visit(LT lt) throws VisitorException;

    boolean visit(LEq leq) throws VisitorException;

    boolean visit(Not not) throws VisitorException;

    boolean visit(Pos pos) throws VisitorException;

    boolean visit(Neg neg) throws VisitorException;

}
