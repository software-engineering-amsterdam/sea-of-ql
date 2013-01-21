package org.uva.sea.ql.symbol;

import org.uva.sea.ql.ast.AnswerableQuestion;
import org.uva.sea.ql.ast.ComputedQuestion;
import org.uva.sea.ql.ast.ConditionalStatement;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.error.ErrorHandler;
import org.uva.sea.ql.error.QLError;
import org.uva.sea.ql.visitor.StatementVisitor;

public class SymbolGenerator implements StatementVisitor {
	
	private SymbolTable table;
	private ErrorHandler handler;

	public SymbolGenerator(SymbolTable table, ErrorHandler handler) {
		this.table = table;
		this.handler = handler;
	}
	
	@Override
	public void visit(Form node) {
		for(Statement statement : node.getStatements()) {
			statement.accept(this);
		}
	}
	
	@Override
	public void visit(ConditionalStatement node) {
		for(Statement statement : node.getStatements()) {
			statement.accept(this);
		}
	}
	
	@Override
	public void visit(AnswerableQuestion node) {
		if (table.hasSymbol(node.getName())) {
			handler.addError(new QLError("Duplicate entry with name: " + node.getName() + " at line: " + node.getLineNumber()));
		} else {
			table.putSymbol(node.getName(), new Symbol(node, node.getType()));
		}
		
	}
	
	@Override
	public void visit(ComputedQuestion node) {
		if (table.hasSymbol(node.getName())) {
			handler.addError(new QLError("Duplicate entry with name: " + node.getName() + " at line: " + node.getLineNumber()));
		} else {
			table.putSymbol(node.getName(), new Symbol(node, node.getExpr(), table));
		}
	}

}
