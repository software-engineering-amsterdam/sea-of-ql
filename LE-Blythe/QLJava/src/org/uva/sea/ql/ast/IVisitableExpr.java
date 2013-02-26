package org.uva.sea.ql.ast;

public interface IVisitableExpr {

	<T> T accept(IVisitorExpr<T> visitor) throws Exception;
}
