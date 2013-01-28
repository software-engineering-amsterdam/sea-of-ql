package khosrow.uva.sea.ql.ast.stmt;

import khosrow.uva.sea.ql.ast.expr.Ident;
import khosrow.uva.sea.ql.ast.type.Type;

public abstract class Question extends Stmt{
	private final Ident ident;
	private final String text;
	private final Type type;
	
	public Question(Ident ident, String text, Type type){
		this.ident = ident;
		this.text = text;
		this.type = type;
	}

	public Ident getIdent() {
		return ident;
	}

	public String getText() {
		return text;
	}

	public Type getType() {
		return type;
	}

}
