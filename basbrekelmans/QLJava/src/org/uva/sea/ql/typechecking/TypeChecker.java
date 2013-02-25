package org.uva.sea.ql.typechecking;

import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.statements.ComputedQuestion;
import org.uva.sea.ql.ast.statements.If;
import org.uva.sea.ql.ast.statements.IfElse;
import org.uva.sea.ql.ast.statements.InputQuestion;
import org.uva.sea.ql.ast.statements.Statement;
import org.uva.sea.ql.ast.statements.Statements;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.IStatementVisitor;

/* internal */class TypeChecker implements IStatementVisitor, ITypeChecker {

	private final TypeContext context;
	private final ITypeResolver resolver;

	public TypeChecker(final TypeContext context, final ITypeResolver resolver) {
		this.context = context;
		this.resolver = resolver;
	}

	@Override
	public void checkTypes(final Form root) {
		root.getBody().accept(this);
	}

	@Override
	public void checkTypes(final Statement statement) {
		statement.accept(this);
	}

	@Override
	public TypeContext getContext() {
		return this.context;
	}

	@Override
	public ITypeResolver getResolver() {
		return this.resolver;
	}

	@Override
	public void visit(final ComputedQuestion element) {
		final Type expressionType = this.resolver.getType(element.getExpression());
		if (expressionType == Type.UNKNOWN) {
			this.context.addError(element,
					"Unable to determine type of computed value");
		} else {
			this.context.getSymbolTable().put(element.getIdentifier(),
					expressionType);
		}
	}

	@Override
	public void visit(final If element) {
		element.getIfBody().accept(this);
		if (!this.resolver.getType(element.getExpression()).isBoolean()) {
			this.context.addError(element,
					"Expression in if statement is not a boolean");
		}
	}

	@Override
	public void visit(final IfElse element) {
		element.getIfBody().accept(this);
		element.getElseBody().accept(this);
		if (!this.resolver.getType(element.getExpression()).isBoolean()) {
			this.context.addError(element,
					"Expression in if statement is not a boolean");
		}
	}

	@Override
	public void visit(final InputQuestion element) {
		this.context.getSymbolTable().put(element.getIdentifier(),
				element.getType());
	}

	@Override
	public void visit(final Statements element) {
		for (final Statement s : element) {
			s.accept(this);
		}
	}
}
