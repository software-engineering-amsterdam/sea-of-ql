package org.uva.sea.ql.visitor;

/**
 * Visitor for printing AST.
 */
public interface INodeVisitor extends IExpressionVisitor, IStatementVisitor, ITypeVisitor {
}
