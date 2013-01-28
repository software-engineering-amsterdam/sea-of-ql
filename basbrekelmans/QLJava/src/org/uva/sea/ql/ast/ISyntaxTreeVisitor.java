package org.uva.sea.ql.ast;

public interface ISyntaxTreeVisitor<T> extends IStatementVisitor, IExpressionVisitor<T> {
	
}
