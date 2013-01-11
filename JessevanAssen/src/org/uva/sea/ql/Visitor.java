package org.uva.sea.ql;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expr.Add;
import org.uva.sea.ql.ast.expr.And;
import org.uva.sea.ql.ast.expr.Bool;
import org.uva.sea.ql.ast.expr.Div;
import org.uva.sea.ql.ast.expr.Eq;
import org.uva.sea.ql.ast.expr.GEq;
import org.uva.sea.ql.ast.expr.GT;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.If;
import org.uva.sea.ql.ast.expr.Int;
import org.uva.sea.ql.ast.expr.LEq;
import org.uva.sea.ql.ast.expr.LT;
import org.uva.sea.ql.ast.expr.Mul;
import org.uva.sea.ql.ast.expr.NEq;
import org.uva.sea.ql.ast.expr.Neg;
import org.uva.sea.ql.ast.expr.Not;
import org.uva.sea.ql.ast.expr.Or;
import org.uva.sea.ql.ast.expr.Pos;
import org.uva.sea.ql.ast.expr.Str;
import org.uva.sea.ql.ast.expr.Sub;

public interface Visitor<ReturnType, ParameterType> {
	public ReturnType visit(Add      visitee, ParameterType param);
	public ReturnType visit(And      visitee, ParameterType param);
	public ReturnType visit(Bool     visitee, ParameterType param);
	public ReturnType visit(Computed visitee, ParameterType param);
	public ReturnType visit(Div      visitee, ParameterType param);
	public ReturnType visit(Eq       visitee, ParameterType param);
	public ReturnType visit(Form     visitee, ParameterType param);
	public ReturnType visit(GEq      visitee, ParameterType param);
	public ReturnType visit(GT       visitee, ParameterType param);
	public ReturnType visit(Ident    visitee, ParameterType param);
	public ReturnType visit(If       visitee, ParameterType param);
	public ReturnType visit(Int      visitee, ParameterType param);
	public ReturnType visit(LEq      visitee, ParameterType param);
	public ReturnType visit(LT       visitee, ParameterType param);
	public ReturnType visit(Mul      visitee, ParameterType param);
	public ReturnType visit(Neg      visitee, ParameterType param);
	public ReturnType visit(NEq      visitee, ParameterType param);
	public ReturnType visit(Not      visitee, ParameterType param);
	public ReturnType visit(Or       visitee, ParameterType param);
	public ReturnType visit(Pos      visitee, ParameterType param);
	public ReturnType visit(Question visitee, ParameterType param);
	public ReturnType visit(Str      visitee, ParameterType param);
	public ReturnType visit(Sub      visitee, ParameterType param);
}
