package eu.karuza.ql.visitor.impl;

import java.util.List;
import java.util.Map.Entry;
import java.util.Stack;

import eu.karuza.ql.ast.Expr;
import eu.karuza.ql.ast.Form;
import eu.karuza.ql.ast.Statement;
import eu.karuza.ql.ast.statement.AnswerableQuestion;
import eu.karuza.ql.ast.statement.ComputedQuestion;
import eu.karuza.ql.ast.statement.IfConditionalStatement;
import eu.karuza.ql.ast.statement.IfElseConditionalStatement;
import eu.karuza.ql.error.QLError;
import eu.karuza.ql.parser.ParserContext;
import eu.karuza.ql.symbol.DefinitionCollector;
import eu.karuza.ql.symbol.Symbol;
import eu.karuza.ql.visitor.StatementVisitor;

public class StatementSemanticChecker implements StatementVisitor<Void> {

	private ParserContext context;
	private ExpressionSemanticChecker expressionChecker;
	private StatementVisitor<?> generator;
	private Stack<List<Symbol>> dependentOnStack = new Stack<List<Symbol>>();

	public StatementSemanticChecker(ParserContext context, StatementVisitor<?> generator, ExpressionSemanticChecker expressionChecker) {
		this.context = context;
		this.expressionChecker = expressionChecker;
		this.generator = generator;
	}

	public StatementSemanticChecker(ParserContext context) {
		this.context = context;
		this.expressionChecker = new ExpressionSemanticChecker(context);
		this.generator = new DefinitionCollector(context);
	}

	/**
	 * Checks for cyclic dependencies and runs the symbol definition collector
	 */
	@Override
	public Void visit(Form node) {
		node.accept(generator);
		acceptChildren(node.getStatements());
		for (Entry<String, Symbol> symbol : context.getSymbols().entrySet()) { 
			for (Symbol currentSymbol : symbol.getValue().getDependantOn()) {
				for (Symbol dependentSymbol : currentSymbol.getDependantOn()) {
					if (dependentSymbol == symbol.getValue()) {
						context.addError(new QLError("Cyclic dependency between node: " + dependentSymbol.getDeclarationPoint().getName() + " and node: "
								+ currentSymbol.getDeclarationPoint().getName()));
					}
				}
			}
		}
		return null;
	}

	@Override
	public Void visit(IfConditionalStatement node) {
		checkConditionalExpression(node.getExpr(), node.getLineNumber());
		checkExpressionDependencies(node.getExpr());
		acceptChildren(node.getStatements());
		dependentOnStack.pop();
		return null;
	}

	@Override
	public Void visit(IfElseConditionalStatement node) {
		checkConditionalExpression(node.getExpr(), node.getLineNumber());
		checkExpressionDependencies(node.getExpr());
		acceptChildren(node.getAllStatements());
		dependentOnStack.pop();
		return null;
	}

	@Override
	public Void visit(AnswerableQuestion node) {
		Symbol symbol = context.getSymbol(node.getName());
		for (List<Symbol> symbols : dependentOnStack) {
			symbol.addDependantOn(symbols);
		}
		node.getExpr().accept(expressionChecker);
		return null;
	}

	@Override
	public Void visit(ComputedQuestion node) {
		node.getExpr().accept(expressionChecker);
		return null;
	}
	
	private void acceptChildren(List<Statement> statements) {
		for(Statement statement: statements) {
			statement.accept(this);
		}
	}

	private void checkConditionalExpression(Expr expr, int lineNumber) {
		if (!expr.typeOf(context.getTable()).isCompatibleToBool()) {
			context.addError(new QLError("invalid non-boolean expression in statement at: " + lineNumber));
		}
	}

	private void checkExpressionDependencies(Expr expr) {
		expr.accept(expressionChecker);
		dependentOnStack.push(expressionChecker.getSymbols());
		expressionChecker.clearSymbols();
	}
}
