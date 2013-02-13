package org.uva.sea.ql.interfaces;

public interface IVisitableExpr {

	<T> T accept(IVisitorExpr<T> visitor) throws Exception;
}
