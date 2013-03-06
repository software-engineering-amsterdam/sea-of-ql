package org.uva.sea.ql.ast.visitor;

import org.uva.sea.ql.ast.expr.Add;
import org.uva.sea.ql.ast.expr.And;
import org.uva.sea.ql.ast.expr.Div;
import org.uva.sea.ql.ast.expr.Eq;
import org.uva.sea.ql.ast.expr.GEq;
import org.uva.sea.ql.ast.expr.GT;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.LEq;
import org.uva.sea.ql.ast.expr.LT;
import org.uva.sea.ql.ast.expr.Mul;
import org.uva.sea.ql.ast.expr.NEq;
import org.uva.sea.ql.ast.expr.Neg;
import org.uva.sea.ql.ast.expr.Not;
import org.uva.sea.ql.ast.expr.Or;
import org.uva.sea.ql.ast.expr.Pos;
import org.uva.sea.ql.ast.expr.Sub;
import org.uva.sea.ql.ast.nodes.values.Bool;
import org.uva.sea.ql.ast.nodes.values.Doub;
import org.uva.sea.ql.ast.nodes.values.Int;
import org.uva.sea.ql.ast.nodes.values.Money;
import org.uva.sea.ql.ast.nodes.values.Str;

public interface Visitor<T> {

	T visit(Ident ast);

	T visit(Bool bool);

	T visit(Str bool);

	T visit(Money bool);

	T visit(Int ast);

	T visit(Doub doub);

	T visit(Add ast);

	T visit(And ast);

	T visit(Div ast);

	T visit(Eq ast);

	T visit(GEq ast);

	T visit(GT ast);

	T visit(LEq ast);

	T visit(LT ast);

	T visit(Mul ast);

	T visit(Neg ast);

	T visit(NEq ast);

	T visit(Not ast);

	T visit(Or ast);

	T visit(Pos ast);

	T visit(Sub ast);

}
