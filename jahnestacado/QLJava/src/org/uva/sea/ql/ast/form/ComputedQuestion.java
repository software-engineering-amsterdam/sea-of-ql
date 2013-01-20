package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.values.Ident;
import org.uva.sea.ql.visitor.ASTNodeVisitor;

public class ComputedQuestion extends BodyElements {
	private final Ident id;
	private final String label;
	private final Type type;
	private final Expr expr;

	public ComputedQuestion(Ident id, String label, Type type, Expr expr) {
			this.id=id;
			this.label=label;
			this.type=type;
			this.expr=expr;
	}

	public Ident getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

	public Type getType() {
		return type;
	}

	public Expr getExpr() {
		return expr;
	}

	@Override
	public void accept(ASTNodeVisitor nodeVisitor) {
		// TODO Auto-generated method stub
		
	}

}
