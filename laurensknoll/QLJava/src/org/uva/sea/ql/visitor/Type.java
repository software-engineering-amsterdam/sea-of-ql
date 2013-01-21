package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.type.Bool;
import org.uva.sea.ql.ast.type.Int;
import org.uva.sea.ql.ast.type.Money;
import org.uva.sea.ql.ast.type.String;

public interface Type<T> {

	public T visit(Bool bool);

	public T visit(Int intType);

	public T visit(Money money);

	public T visit(String string);

}
