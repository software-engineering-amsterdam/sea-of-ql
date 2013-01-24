package org.uva.sea.ql.visitor;

/**
 * Combined visitor interface for AST nodes.
 */
abstract public class NodeVisitor<T> implements IExpressionVisitor<T>, IStatementVisitor<T>, ITypeVisitor<T> {

}
