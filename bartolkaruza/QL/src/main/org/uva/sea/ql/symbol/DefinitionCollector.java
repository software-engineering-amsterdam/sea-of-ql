package org.uva.sea.ql.symbol;

import org.uva.sea.ql.ast.AnswerableQuestion;
import org.uva.sea.ql.ast.ComputedQuestion;
import org.uva.sea.ql.ast.ConditionalStatement;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.Question;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.expr.type.Type;
import org.uva.sea.ql.error.ErrorHandler;
import org.uva.sea.ql.error.QLError;
import org.uva.sea.ql.visitor.StatementVisitor;

public class DefinitionCollector implements StatementVisitor {

	private SymbolTable table;
	private ErrorHandler handler;

	public DefinitionCollector(SymbolTable table, ErrorHandler handler) {
		this.table = table;
		this.handler = handler;
	}

	@Override
	public void visit(Form node) {
		for (Statement statement : node.getStatements()) {
			statement.accept(this);
		}
	}

	@Override
	public void visit(ConditionalStatement node) {
		for (Statement statement : node.getStatements()) {
			statement.accept(this);
		}
	}

	@Override
	public void visit(AnswerableQuestion node) {
		declareVariable(node, node.getType());

	}

	@Override
	public void visit(ComputedQuestion node) {
		declareVariable(node, node.getExpr().typeOf(table));
	}

	private void declareVariable(Question node, Type type) {
		if (table.hasSymbol(node.getName())) {
			handler.addError(new QLError("Duplicate entry with name: " + node.getName() + " at line: " + node.getLineNumber()));
		} else {
			table.putSymbol(node.getName(), new Symbol(node, type));
		}
	}

}
