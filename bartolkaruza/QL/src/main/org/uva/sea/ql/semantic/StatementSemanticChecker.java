package org.uva.sea.ql.semantic;

import java.util.List;
import java.util.Map.Entry;
import java.util.Stack;

import org.uva.sea.ql.ast.AnswerableQuestion;
import org.uva.sea.ql.ast.ComputedQuestion;
import org.uva.sea.ql.ast.ConditionalStatement;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.error.ErrorHandler;
import org.uva.sea.ql.error.QLError;
import org.uva.sea.ql.symbol.Symbol;
import org.uva.sea.ql.symbol.SymbolGenerator;
import org.uva.sea.ql.symbol.SymbolTable;
import org.uva.sea.ql.visitor.StatementVisitor;

public class StatementSemanticChecker implements StatementVisitor {

	private SymbolTable table;
	private ErrorHandler handler;
	private ExpressionSemanticChecker expressionChecker;
	private SymbolGenerator generator;
	private Stack<List<Symbol>> dependentOnStack = new Stack<List<Symbol>>();

	public StatementSemanticChecker(SymbolTable table, ErrorHandler handler, SymbolGenerator generator, ExpressionSemanticChecker expressionChecker) {
		this.table = table;
		this.handler = handler;
		this.expressionChecker = expressionChecker;
		this.generator = generator;
	}

	@Override
	public void visit(Form node) {
		node.accept(generator); // Create the symbol table entries
		for (Statement statement : node.getStatements()) {
			statement.accept(this);
		}
		for (Entry<String, Symbol> symbol : table.getSymbols().entrySet()) { // Check for cyclic dependencies
			for (Symbol currentSymbol : symbol.getValue().getDependantOn()) {
				for (Symbol dependentSymbol : currentSymbol.getDependantOn()) {
					if (dependentSymbol == symbol.getValue()) { 
						handler.addError(new QLError("Cyclic dependency between node: " + dependentSymbol.getDeclarationPoint().getName() + " and node: "
								+ currentSymbol.getDeclarationPoint().getName()));
					}
				}
			}
		}
	}

	@Override
	public void visit(ConditionalStatement node) {

		if (!node.getExpression().typeOf(table).isCompatibleToBool()) {
			handler.addError(new QLError("invalid non-boolean expression in statement at: " + node.getLineNumber()));
		}
		node.getExpression().accept(expressionChecker);
		dependentOnStack.push(expressionChecker.getSymbols());
		expressionChecker.clearSymbols();
		for (Statement statement : node.getStatements()) {
			statement.accept(this);
		}
		dependentOnStack.pop();
	}

	@Override
	public void visit(AnswerableQuestion node) {
		Symbol symbol = table.getSymbol(node.getName());
		for (List<Symbol> symbols : dependentOnStack) {
			symbol.addDependantOn(symbols);
		}

	}

	@Override
	public void visit(ComputedQuestion node) {
		node.getExpr().accept(expressionChecker);
	}
}
