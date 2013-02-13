package org.uva.sea.ql.interfaces;

public interface IVisitableStatement {

	<T> T accept(IVisitorStatement<T> visitor) throws Exception;
}
