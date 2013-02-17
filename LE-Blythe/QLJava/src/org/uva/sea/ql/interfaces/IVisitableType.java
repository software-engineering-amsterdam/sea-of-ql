package org.uva.sea.ql.interfaces;

public interface IVisitableType {

	<T> T accept(IVisitorType<T> visitor) throws Exception;
}
