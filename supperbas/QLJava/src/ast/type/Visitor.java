package ast.type;

public interface Visitor<T> {

	T visit(Bool ast);
	T visit(Str ast);
	T visit(Ident ast);
	T visit(Int ast);
	T visit(Message ast);
	T visit(Undefined ast);
}
