package org.uva.sea.ql.ast;

public interface IVisitableStatement {

	<T> T accept(IVisitorStatement<T> visitor);
}
