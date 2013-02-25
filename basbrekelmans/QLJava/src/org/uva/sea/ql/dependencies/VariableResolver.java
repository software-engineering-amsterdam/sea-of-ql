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
import org.uva.sea.ql.parser.QLError;
import org.uva.sea.ql.runtime.ComputedRuntimeValue;
import org.uva.sea.ql.runtime.ExpressionEvaluator;
import org.uva.sea.ql.runtime.IExpressionEvaluator;
import org.uva.sea.ql.runtime.RuntimeValue;
import org.uva.sea.ql.runtime.RuntimeValues;
import org.uva.sea.ql.runtime.UserInputRuntimeValue;
import org.uva.sea.ql.visitor.IStatementVisitor;

public class VariableResolver implements IVariableResolver, IStatementVisitor {

	private final IdentifierFinder identifierFinder = new IdentifierFinder();
	private RuntimeValues variables;
	private final List<QLError> errors = new ArrayList<QLError>();

	private IExpressionEvaluator eval;

	private void addVariableForIfStatement(final If element) {
		final Expression condition = element.getCondition();
		final RuntimeValue variable = new ComputedRuntimeValue(this.eval,
				condition);
		this.resolveDependencies(condition, variable);
		this.variables.add(element, variable);
	}

	private void addVariableFromExpression(final Statement element,
			final Expression expr, final Identifier identifier) {
		this.checkDuplicateVariableError(element, identifier);
		final RuntimeValue variable = new ComputedRuntimeValue(this.eval, expr);
		this.resolveDependencies(expr, variable, identifier);
		this.variables.add(element, variable, identifier);
	}

	private void checkDuplicateVariableError(
			final ICodeLocationInformation location, final Identifier identifier) {
		if (this.variables.containsIdentifier(identifier)) {
			this.errors.add(new QLError(location, String.format(
					"Duplicate variable definition for '%s'",
					identifier.getName())));
		}
	}

	@Override
	public Iterable<QLError> getErrors() {
		return this.errors;
	}

	@Override
	public RuntimeValues getRuntimeValues(final Form root) {
		this.variables = new RuntimeValues();
		this.eval = new ExpressionEvaluator(this.variables);
		root.getBody().accept(this);
		return this.variables;
	}

	@Override
	public boolean hasErrors() {
		return this.errors.size() > 0;
	}

	private void resolveDependencies(final Expression expr,
			final RuntimeValue variable) {
		this.resolveDependencies(expr, variable, null);
	}

	private void resolveDependencies(final Expression expr,
			final RuntimeValue variable, final Identifier identifier) {
		for (final Identifier dependency : this.identifierFinder
				.findDependencies(expr)) {
			final RuntimeValue dependantVariable = this.variables
					.get(dependency);
			if (dependantVariable == null) {
				String name;
				if (identifier == null) {
					name = "If statement";
				} else {
					name = "Variable '" + identifier.getName() + "'";
				}
				this.errors.add(new QLError(expr, String.format(
						"%s depends on undeclared variable '%s'", name,
						dependency.getName())));
			} else if (variable.isComputed()) {
				dependantVariable.addObserver((ComputedRuntimeValue) variable);
			}
		}
	}

	@Override
	public void visit(final ComputedQuestion element) {
		this.addVariableFromExpression(element, element.getComputation(),
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
		final RuntimeValue variable = new UserInputRuntimeValue();
		this.variables.add(element, variable, identifier);
	}

	@Override
	public void visit(final Statements element) {
		for (final Statement statement : element) {
			statement.accept(this);
		}
	}
}
