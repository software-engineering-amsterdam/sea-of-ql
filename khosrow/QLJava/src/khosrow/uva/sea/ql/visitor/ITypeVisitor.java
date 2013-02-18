package khosrow.uva.sea.ql.visitor;

import khosrow.uva.sea.ql.ast.type.*;

public interface ITypeVisitor<T> {
	public T visit (Int type);
	public T visit (Money type);
	public T visit (Bool type);
	public T visit (Str type);

}
