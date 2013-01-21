package org.uva.sea.ql.visitor;

/**
 * Combined visitor interface for AST nodes.
 */
public interface INodeVisitor<T> extends IExpressionVisitor<T>, IStatementVisitor<T>, ITypeVisitor<T> {
}
