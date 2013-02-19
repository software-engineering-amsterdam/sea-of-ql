package org.uva.sea.ql.ast.visitor;

public interface Visitor<T> extends ExpressionVisitor<T>, StatementVisitor<T> {

}
