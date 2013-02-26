package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.StatementVisitor;
import org.uva.sea.ql.ast.types.declarations.TypeDeclaration;
import org.uva.sea.ql.ast.types.primitive.StringLiteral;

public class ComputedValue extends Statement {

	private Identifier identifier;
	private StringLiteral text;
	private Expression expression;
	private TypeDeclaration type;

	public ComputedValue(Identifier identifier, StringLiteral text,
			Expression expression, TypeDeclaration type) {
		this.identifier = identifier;
		this.text = text;
		this.expression = expression;
		this.type = type;
	}

	@Override
	public void accept(StatementVisitor visitor) {
		visitor.visit(this);
	}

	public TypeDeclaration getType() {
		return type;
	}

	public Expression getExpression() {
		return expression;
	}

	public StringLiteral getText() {
		return text;
	}

	public Identifier getIdentifier() {
		return identifier;
	}
}
