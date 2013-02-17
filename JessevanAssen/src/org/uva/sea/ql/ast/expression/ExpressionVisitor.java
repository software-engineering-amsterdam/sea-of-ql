package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.ast.expression.value.Bool;
import org.uva.sea.ql.ast.expression.value.Int;
import org.uva.sea.ql.ast.expression.value.Str;

public interface ExpressionVisitor<ReturnType, ParameterType> {
    public ReturnType visit(Add      astNode, ParameterType param);
    public ReturnType visit(And      astNode, ParameterType param);
    public ReturnType visit(Bool     astNode, ParameterType param);
    public ReturnType visit(Divide astNode, ParameterType param);
    public ReturnType visit(EqualTo astNode, ParameterType param);
    public ReturnType visit(GreaterThanOrEqualTo astNode, ParameterType param);
    public ReturnType visit(GreaterThan astNode, ParameterType param);
    public ReturnType visit(Identifier astNode, ParameterType param);
    public ReturnType visit(Int      astNode, ParameterType param);
    public ReturnType visit(LesserThanOrEqualTo astNode, ParameterType param);
    public ReturnType visit(LesserThan astNode, ParameterType param);
    public ReturnType visit(Multiply astNode, ParameterType param);
    public ReturnType visit(Negative astNode, ParameterType param);
    public ReturnType visit(NotEqualTo astNode, ParameterType param);
    public ReturnType visit(Not      astNode, ParameterType param);
    public ReturnType visit(Or       astNode, ParameterType param);
    public ReturnType visit(Positive astNode, ParameterType param);
    public ReturnType visit(Str      astNode, ParameterType param);
    public ReturnType visit(Subtract astNode, ParameterType param);

}
