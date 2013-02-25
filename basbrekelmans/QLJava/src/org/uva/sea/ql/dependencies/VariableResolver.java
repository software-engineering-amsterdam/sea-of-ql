package org.uva.sea.ql.dependencies;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ICodeLocationInformation;
import org.uva.sea.ql.ast.expressions.Expression;
import org.uva.sea.ql.ast.expressions.Identifier;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.statements.ComputedQuestion;
import org.uva.sea.ql.ast.statements.If;
import org.uva.sea.ql.ast.statements.IfElse;
import org.uva.sea.ql.ast.statements.InputQuestion;
import org.uva.sea.ql.ast.statements.Statement;
import org.uva.sea.ql.ast.statements.Statements;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.runtime.ComputedVariable;
import org.uva.sea.ql.runtime.Variable;
import org.uva.sea.ql.runtime.Variables;
import org.uva.sea.ql.visitor.IStatementVisitor;

public class VariableResolver implements IVariableResolver, IStatementVisitor {

	private final IdentifierFinder identifierFinder = new IdentifierFinder();
	private Variables variables;
	private final List<ParseError> errors = new ArrayList<ParseError>();

	private void addVariableForIfStatement(final If element) {
		final Variable variable = new ComputedVariable();
		this.resolveDependencies(element.getExpression(), variable);
		this.variables.add(element, variable);
	}

	private void addVariableFromExpression(final Statement element,
			final Expression expr, final Identifier identifier) {
		this.checkDuplicateVariableError(element, identifier);
		final Variable variable = new ComputedVariable();
		this.resolveDependencies(expr, variable, identifier);
		this.variables.add(element, variable, identifier);
	}

	private void checkDuplicateVariableError(
			final ICodeLocationInformation location, final Identifier identifier) {
		if (this.variables.containsIdentifier(identifier)) {
			this.errors.add(new ParseError(location, String.format(
					"Duplicate variable definition for '%s'",
					identifier.getName())));
		}
	}

	@Override
	public Iterable<ParseError> getErrors() {
		return this.errors;
	}

	@Override
	public Variables getVariables(final Form root) {
		this.variables = new Variables();
		root.getBody().accept(this);
		return this.variables;
	}

	@Override
	public boolean hasErrors() {
		return this.errors.size() > 0;
	}

	private void resolveDependencies(final Expression expr,
			final Variable variable) {
		this.resolveDependencies(expr, variable, null);
	}

	private void resolveDependencies(final Expression expr,
			final Variable variable, final Identifier identifier) {
		for (final Identifier dependency : this.identifierFinder
				.getDependency(expr)) {
			final Variable dependantVariable = this.variables.get(dependency);
			if (dependantVariable == null) {
				String name;
				if (identifier == null) {
					name = "If statement";
				} else {
					name = "Variable '" + identifier.getName() + "'";
				}
				this.errors.add(new ParseError(expr, String.format(
						"%s depends on undeclared variable '%s'", name,
						dependency.getName())));
			} else {
				dependantVariable.addObserver(variable);
			}
		}
	}

	@Override
	public void visit(final ComputedQuestion element) {
		this.addVariableFromExpression(element, element.getExpression(),
				element.getIdentifier());
	}

	@Override
	public void visit(final If element) {
		this.addVariableForIfStatement(element);
		element.getIfBody().accept(this);
	}

	@Override
	public void visit(final IfElse element) {
		this.addVariableForIfStatement(element);
		element.getIfBody().accept(this);
		element.getElseBody().accept(this);
	}

	@Override
	public void visit(final InputQuestion element) {
		final Identifier identifier = element.getIdentifier();
		this.checkDuplicateVariableError(element, identifier);
		final Variable variable = new Variable();
		this.variables.add(element, variable, identifier);
	}

	@Override
	public void visit(final Statements element) {
		for (final Statement statement : element) {
			statement.accept(this);
		}
	}
}
