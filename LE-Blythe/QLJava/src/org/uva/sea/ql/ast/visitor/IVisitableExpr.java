package org.uva.sea.ql.ast.visitor;

public interface IVisitableExpr {

	<T> T accept(IVisitorExpr<T> visitor) throws Exception;
}
