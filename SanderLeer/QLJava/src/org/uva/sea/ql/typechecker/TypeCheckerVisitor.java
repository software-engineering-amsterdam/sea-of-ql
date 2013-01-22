package org.uva.sea.ql.typechecker;

import java.util.ArrayList;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.datatype.*;
import org.uva.sea.ql.ast.expression.*;
import org.uva.sea.ql.ast.expression.binary.*;
import org.uva.sea.ql.ast.expression.literal.*;
import org.uva.sea.ql.ast.expression.unary.*;
import org.uva.sea.ql.ast.statement.*;

class TypeCheckerVisitor implements Visitor<Boolean> {
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
	public Boolean visit(Pos node) {
		node.getOperand().accept(this);
		return true;
	}

	@Override
	public Boolean visit(Neg node) {
		node.getOperand().accept(this);
		return true;
	}

	@Override
	public Boolean visit(Not node) {
		node.getOperand().accept(this);
		return true;
	}

	@Override
	public Boolean visit(Mul node) {
		node.getLhs().accept(this);
		node.getRhs().accept(this);
		return true;
	}

	@Override
	public Boolean visit(Div node) {
		node.getLhs().accept(this);
		node.getRhs().accept(this);
		return true;
	}

	@Override
	public Boolean visit(Add node) {
		node.getLhs().accept(this);
		node.getRhs().accept(this);
		return true;
	}

	@Override
	public Boolean visit(Sub node) {
		node.getLhs().accept(this);
		node.getRhs().accept(this);
		return true;
	}

	@Override
	public Boolean visit(Eq node) {
		node.getLhs().accept(this);
		node.getRhs().accept(this);
		return true;
	}

	@Override
	public Boolean visit(NEq node) {
		node.getLhs().accept(this);
		node.getRhs().accept(this);
		return true;
	}

	@Override
	public Boolean visit(GT node) {
		node.getLhs().accept(this);
		node.getRhs().accept(this);
		return true;
	}

	@Override
	public Boolean visit(LT node) {
		node.getLhs().accept(this);
		node.getRhs().accept(this);
		return true;
	}

	@Override
	public Boolean visit(GEq node) {
		node.getLhs().accept(this);
		node.getRhs().accept(this);
		return true;
	}

	@Override
	public Boolean visit(LEq node) {
		node.getLhs().accept(this);
		node.getRhs().accept(this);
		return true;
	}

	@Override
	public Boolean visit(And node) {
		node.getLhs().accept(this);
		node.getRhs().accept(this);
		return true;
	}

	@Override
	public Boolean visit(Or node) {
		node.getLhs().accept(this);
		node.getRhs().accept(this);
		return true;
	}

	@Override
	public Boolean visit(Identifier node) {
		if (!symbols.contains(node.getName())) {
			addError("Variable '" + node.getName() + "' not defined");
		}
		return true;
	}

	@Override
	public Boolean visit(IntegerLiteral node) {
		return true;
	}

	@Override
	public Boolean visit(BooleanLiteral node) {
		return true;
	}

	@Override
	public Boolean visit(StringLiteral node) {
		return true;
	}

	@Override
	public Boolean visit(IntegerType node) {
		return true;
	}

	@Override
	public Boolean visit(StringType node) {
		return true;
	}

	@Override
	public Boolean visit(BooleanType node) {
		return true;
	}

	@Override
	public Boolean visit(Form node) {
		node.getStatements().accept(this);
		return true;
	}

	@Override
	public Boolean visit(StatementList node) {
		for (Statement e : node.getList()) {
			e.accept(this);
		}
		return true;
	}

	private void addQuestionSymbol(Identifier identifier, Datatype datatype) {
		if (symbols.contains(identifier.getName())) {
			addError("Question identifier '" + identifier.getName() + "' already defined");
		} else {
			symbols.put(identifier.getName(), datatype);
		}
	}
	
	@Override
	public Boolean visit(Question node) {
		addQuestionSymbol(node.getIdentifier(), node.getDatatype());
		return true;
	}

	@Override
	public Boolean visit(ComputedQuestion node) {
		addQuestionSymbol(node.getIdentifier(), node.getDatatype());
		node.getExpression().accept(this);
		return true;
	}

	@Override
	public Boolean visit(IfStatement node) {
		node.getExpression().accept(this);
		node.getStatements().accept(this);
		return true;
	}
}
