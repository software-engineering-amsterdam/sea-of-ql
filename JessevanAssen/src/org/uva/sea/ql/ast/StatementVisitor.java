package org.uva.sea.ql.ast;

public interface StatementVisitor<ReturnType, ParameterType> {
    public ReturnType visit(CompositeStatement   astNode, ParameterType param);
    public ReturnType visit(Form                 astNode, ParameterType param);
    public ReturnType visit(If                   astNode, ParameterType param);
    public ReturnType visit(IfElse               astNode, ParameterType param);
    public ReturnType visit(Question             astNode, ParameterType param);
    public ReturnType visit(StoredExpression     astNode, ParameterType param);
}
