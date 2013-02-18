package org.uva.sea.ql.ast.visitor;

public interface IVisitableType {

	<T> T accept(IVisitorType<T> visitor) throws Exception;
}
