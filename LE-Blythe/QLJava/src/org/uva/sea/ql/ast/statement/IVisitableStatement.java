package org.uva.sea.ql.ast.statement;

public interface IVisitableStatement {

	<T> T accept(IVisitorStatement<T> visitor) throws Exception;
}
