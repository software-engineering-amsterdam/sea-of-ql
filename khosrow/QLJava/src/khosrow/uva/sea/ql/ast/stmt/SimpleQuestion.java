package khosrow.uva.sea.ql.ast.stmt;

import khosrow.uva.sea.ql.ast.expr.Ident;
import khosrow.uva.sea.ql.ast.expr.StringLiteral;
import khosrow.uva.sea.ql.ast.type.Type;
import khosrow.uva.sea.ql.visitor.IStmtVisitor;

public class SimpleQuestion extends Question {
	public SimpleQuestion(Ident ident, StringLiteral text, Type type) {
		super(ident, text.getValue(), type);
	}

	@Override
	public <T> T accept(IStmtVisitor<T> visitor) {		
		return visitor.visit(this);
	}	
}
