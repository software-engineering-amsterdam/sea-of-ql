package org.uva.sea.ql.semantic;

import java.util.List;
import java.util.Map.Entry;
import java.util.Stack;

import org.uva.sea.ql.ast.AnswerableQuestion;
import org.uva.sea.ql.ast.ComputedQuestion;
import org.uva.sea.ql.ast.ConditionalStatement;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.error.QLError;
import org.uva.sea.ql.parser.ParserContext;
import org.uva.sea.ql.symbol.DefinitionCollector;
import org.uva.sea.ql.symbol.Symbol;
import org.uva.sea.ql.visitor.StatementVisitor;

public class StatementSemanticChecker implements StatementVisitor {

	private ParserContext context;
	private ExpressionSemanticChecker expressionChecker;
	private DefinitionCollector generator;
	private Stack<List<Symbol>> dependentOnStack = new Stack<List<Symbol>>();

	public StatementSemanticChecker(ParserContext context, DefinitionCollector generator, ExpressionSemanticChecker expressionChecker) {
		this.context = context;
		this.expressionChecker = expressionChecker;
		this.generator = generator;
	}
	
	public StatementSemanticChecker(ParserContext context) {
		this.context = context;
		this.expressionChecker = new ExpressionSemanticChecker(context);
		this.generator = new DefinitionCollector(context);
	}

	@Override
	public void visit(Form node) {
		node.accept(generator); // Create the symbol table entries
		for (Statement statement : node.getStatements()) {
			statement.accept(this);
		}
		for (Entry<String, Symbol> symbol : context.getSymbols().entrySet()) { // Check for cyclic dependencies
			for (Symbol currentSymbol : symbol.getValue().getDependantOn()) {
				for (Symbol dependentSymbol : currentSymbol.getDependantOn()) {
					if (dependentSymbol == symbol.getValue()) { 
						context.addError(new QLError("Cyclic dependency between node: " + dependentSymbol.getDeclarationPoint().getName() + " and node: "
								+ currentSymbol.getDeclarationPoint().getName()));
					}
				}
			}
		}
	}

	@Override
	public void visit(ConditionalStatement node) {

		if (!node.getExpression().typeOf(context.getTable()).isCompatibleToBool()) {
			context.addError(new QLError("invalid non-boolean expression in statement at: " + node.getLineNumber()));
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
		Symbol symbol = context.getSymbol(node.getName());
		for (List<Symbol> symbols : dependentOnStack) {
			symbol.addDependantOn(symbols);
		}

	}

	@Override
	public void visit(ComputedQuestion node) {
		node.getExpr().accept(expressionChecker);
	}
}
