package org.uva.sea.ql.typechecking;

import org.uva.sea.ql.ast.IStatementVisitor;
import org.uva.sea.ql.ast.statements.ComputedQuestion;
import org.uva.sea.ql.ast.statements.Form;
import org.uva.sea.ql.ast.statements.If;
import org.uva.sea.ql.ast.statements.InputQuestion;
import org.uva.sea.ql.ast.statements.Statement;
import org.uva.sea.ql.ast.statements.Statements;
import org.uva.sea.ql.ast.types.Type;

/* internal */ class TypeChecker implements IStatementVisitor, ITypeChecker {

	private TypeContext context;
	private ITypeResolver resolver;

	public TypeChecker(TypeContext context, ITypeResolver resolver) {
		this.context = context;
		this.resolver = resolver;
	}
	
	@Override
	public void visit(Form element) {
		element.getBody().accept(this);
	}

	@Override
	public void visit(If element) {		
		element.getIfStatement().accept(this);
		Statement elseStatement = element.getElseStatement();
		if (elseStatement != null) {
			elseStatement.accept(this);
		}
		if (!resolver.getType(element.getExpression()).isBoolean()) {
			context.getErrors().put(element, "Expression in if statement is not a boolean");
		}
	}
	
	
	@Override
	public void visit(Statements element) {
		for (Statement s : element.getChildren()) {
			s.accept(this);
		}
	}

	@Override
	public void visit(InputQuestion element) {
		context.getSymbolTable().put(element.getIdentifier(), element.getType());		
	}

	@Override
	public void visit(ComputedQuestion element) {
		Type expressionType = resolver.getType(element.getValue());
		if (expressionType == Type.UNKNOWN) {
			context.getErrors().put(element, "Unable to determine type of computed value");
		} else {
			context.getSymbolTable().put(element.getIdentifier(), expressionType);
		}
	}

	@Override
	public TypeContext getContext() {
		return context;
	}

	@Override
	public void checkTypes(Statement root) {
		root.accept(this);		
	}
}
