package org.uva.sea.ql.typechecking;

import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.expressions.Identifier;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.statements.ComputedQuestion;
import org.uva.sea.ql.ast.statements.If;
import org.uva.sea.ql.ast.statements.IfElse;
import org.uva.sea.ql.ast.statements.InputQuestion;
import org.uva.sea.ql.ast.statements.Statement;
import org.uva.sea.ql.ast.statements.Statements;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.parser.QLError;
import org.uva.sea.ql.visitor.IStatementVisitor;

public class TypeChecker implements IStatementVisitor, ITypeChecker {

	private final TypeContext context;
	private final ITypeResolver resolver;

	public TypeChecker() {
		this.context = new TypeContext();
		this.resolver = new TypeResolver(this.context);
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
	public List<QLError> getErrors() {
		return this.context.getErrors();
	}

	@Override
	public Map<Identifier, Type> getSymbolTable() {
		return this.context.getSymbolTable();
	}

	@Override
	public boolean hasErrors() {
		return this.context.hasErrors();
	}

	@Override
	public void visit(final ComputedQuestion element) {
		final Type expressionType = this.resolver.getType(element
				.getComputation());
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
		this.visitIfStatement(element);
	}

	@Override
	public void visit(final IfElse element) {
		this.visitIfStatement(element);
		element.getElseBody().accept(this);
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

	private void visitIfStatement(final If element) {
		element.getIfBody().accept(this);
		if (!this.resolver.getType(element.getCondition()).isBoolean()) {
			this.context.addError(element,
					"Expression in if statement is not a boolean");
		}
	}
}
