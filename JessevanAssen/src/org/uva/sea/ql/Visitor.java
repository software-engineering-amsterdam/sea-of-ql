package org.uva.sea.ql;

import org.uva.sea.ql.ast.*;

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
