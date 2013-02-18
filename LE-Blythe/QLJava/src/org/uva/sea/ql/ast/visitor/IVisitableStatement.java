package org.uva.sea.ql.ast.visitor;

public interface IVisitableStatement {

	<T> T accept(IVisitorStatement<T> visitor) throws Exception;
}
