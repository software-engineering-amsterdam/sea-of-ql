package org.uva.sea.ql.interfaces;

public interface IVisitable {

	<T> T accept(IVisitor<T> visitor) throws Exception;
}
