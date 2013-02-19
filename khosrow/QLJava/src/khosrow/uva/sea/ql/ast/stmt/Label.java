package khosrow.uva.sea.ql.ast.stmt;

import khosrow.uva.sea.ql.ast.expr.Expr;
import khosrow.uva.sea.ql.ast.expr.Ident;
import khosrow.uva.sea.ql.ast.expr.StringLiteral;
import khosrow.uva.sea.ql.ast.type.Type;
import khosrow.uva.sea.ql.visitor.IStmtVisitor;

public class Label extends Stmt {
	private static int count = 0;
	private final Ident ident;
	private final String text;
	private final Type type;
	private Expr expr;
	
	public Label(StringLiteral text, Expr expr){
		count++;
		this.text = text.getValue();
		this.setExpr(expr);
		this.ident = new Ident("L" + count);
		this.type = expr.typeOf();
	}

	public Ident getIdent() {
		return ident;
	}
	
	public Type getType() {
		return type;
	}
	
	public String getText() {
		return text;
	}

	public Expr getExpr() {
		return expr;
	}

	public void setExpr(Expr expr) {
		this.expr = expr;
	}	
	

	@Override
	public <T> T accept(IStmtVisitor<T> visitor) {		
		return visitor.visit(this);
	}	
}
