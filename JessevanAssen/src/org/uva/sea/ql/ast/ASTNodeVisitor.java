package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expr.ExprVisitor;

public interface ASTNodeVisitor<ReturnType, ParameterType> extends ExprVisitor<ReturnType, ParameterType>, StatementVisitor<ReturnType, ParameterType> { }
