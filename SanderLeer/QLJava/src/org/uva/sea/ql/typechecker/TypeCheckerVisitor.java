package org.uva.sea.ql.typechecker;

import java.util.ArrayList;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.datatype.*;
import org.uva.sea.ql.ast.expression.*;
import org.uva.sea.ql.ast.expression.binary.*;
import org.uva.sea.ql.ast.expression.literal.*;
import org.uva.sea.ql.ast.expression.unary.*;
import org.uva.sea.ql.ast.statement.*;

class TypeCheckerVisitor implements Visitor {
	private final SymbolTable symbols;
	private final ArrayList<String> errors;

	public TypeCheckerVisitor(SymbolTable symboltable, ArrayList<String> errors) {
		this.symbols = symboltable;
		this.errors = errors;
	}

	protected void addError(String s) {
		errors.add(s);
	}

	@Override
	public void visit(Pos node) {
		node.getOperand().accept(this);
	}

	@Override
	public void visit(Neg node) {
		node.getOperand().accept(this);
	}

	@Override
	public void visit(Not node) {
		node.getOperand().accept(this);
	}

	@Override
	public void visit(Mul node) {
		node.getLhs().accept(this);
		node.getRhs().accept(this);
	}

	@Override
	public void visit(Div node) {
		node.getLhs().accept(this);
		node.getRhs().accept(this);
	}

	@Override
	public void visit(Add node) {
		node.getLhs().accept(this);
		node.getRhs().accept(this);
	}

	@Override
	public void visit(Sub node) {
		node.getLhs().accept(this);
		node.getRhs().accept(this);
	}

	@Override
	public void visit(Eq node) {
		node.getLhs().accept(this);
		node.getRhs().accept(this);
	}

	@Override
	public void visit(NEq node) {
		node.getLhs().accept(this);
		node.getRhs().accept(this);
	}

	@Override
	public void visit(GT node) {
		node.getLhs().accept(this);
		node.getRhs().accept(this);
	}

	@Override
	public void visit(LT node) {
		node.getLhs().accept(this);
		node.getRhs().accept(this);
	}

	@Override
	public void visit(GEq node) {
		node.getLhs().accept(this);
		node.getRhs().accept(this);
	}

	@Override
	public void visit(LEq node) {
		node.getLhs().accept(this);
		node.getRhs().accept(this);
	}

	@Override
	public void visit(And node) {
		node.getLhs().accept(this);
		node.getRhs().accept(this);
	}

	@Override
	public void visit(Or node) {
		node.getLhs().accept(this);
		node.getRhs().accept(this);
	}

	@Override
	public void visit(Identifier node) {
		if (!symbols.contains(node.getName())) {
			addError("Variable '" + node.getName() + "' not defined");
		}
	}

	@Override
	public void visit(IntegerLiteral node) {
	}

	@Override
	public void visit(BooleanLiteral node) {
	}

	@Override
	public void visit(StringLiteral node) {
	}

	@Override
	public void visit(IntegerType node) {
	}

	@Override
	public void visit(StringType node) {
	}

	@Override
	public void visit(BooleanType node) {
	}

	@Override
	public void visit(Form node) {
		node.getStatements().accept(this);
	}

	@Override
	public void visit(StatementList node) {
		for (Statement e : node.getList()) {
			e.accept(this);
		}
	}

	private void addQuestionSymbol(Identifier identifier, Datatype datatype) {
		if (symbols.contains(identifier.getName())) {
			addError("Question identifier '" + identifier.getName() + "' already defined");
		} else {
			symbols.put(identifier.getName(), datatype);
		}
	}
	
	@Override
	public void visit(Question node) {
		addQuestionSymbol(node.getIdentifier(), node.getDatatype());
	}

	@Override
	public void visit(ComputedQuestion node) {
		addQuestionSymbol(node.getIdentifier(), node.getDatatype());
		node.getExpression().accept(this);
	}

	@Override
	public void visit(IfStatement node) {
		node.getExpression().accept(this);
		node.getStatements().accept(this);
	}
}
