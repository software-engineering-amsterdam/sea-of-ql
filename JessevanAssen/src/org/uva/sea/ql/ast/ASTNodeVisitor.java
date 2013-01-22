package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expr.*;
import org.uva.sea.ql.ast.expr.value.*;

public interface ASTNodeVisitor<ReturnType, ParameterType> {
	public ReturnType visit(Add                  astNode, ParameterType param);
	public ReturnType visit(And                  astNode, ParameterType param);
	public ReturnType visit(Bool                 astNode, ParameterType param);
	public ReturnType visit(Computed             astNode, ParameterType param);
    public ReturnType visit(CompositeFormElement astNode, ParameterType param);
	public ReturnType visit(Div                  astNode, ParameterType param);
	public ReturnType visit(Eq                   astNode, ParameterType param);
	public ReturnType visit(Form                 astNode, ParameterType param);
	public ReturnType visit(GEq                  astNode, ParameterType param);
	public ReturnType visit(GT                   astNode, ParameterType param);
	public ReturnType visit(Ident                astNode, ParameterType param);
    public ReturnType visit(If                   astNode, ParameterType param);
    public ReturnType visit(IfElse               astNode, ParameterType param);
	public ReturnType visit(Int                  astNode, ParameterType param);
	public ReturnType visit(LEq                  astNode, ParameterType param);
	public ReturnType visit(LT                   astNode, ParameterType param);
	public ReturnType visit(Mul                  astNode, ParameterType param);
	public ReturnType visit(Neg                  astNode, ParameterType param);
	public ReturnType visit(NEq                  astNode, ParameterType param);
	public ReturnType visit(Not                  astNode, ParameterType param);
	public ReturnType visit(Or                   astNode, ParameterType param);
	public ReturnType visit(Pos                  astNode, ParameterType param);
	public ReturnType visit(Question             astNode, ParameterType param);
	public ReturnType visit(Str                  astNode, ParameterType param);
	public ReturnType visit(Sub                  astNode, ParameterType param);
}
