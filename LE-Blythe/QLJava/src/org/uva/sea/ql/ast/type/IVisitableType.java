package org.uva.sea.ql.ast.type;

public interface IVisitableType {

	<T> T accept(IVisitorType<T> visitor) throws Exception;
}
