package eu.karuza.ql.symbol;


import eu.karuza.ql.ast.AnswerableQuestion;
import eu.karuza.ql.ast.ComputedQuestion;
import eu.karuza.ql.ast.ConditionalStatement;
import eu.karuza.ql.ast.Form;
import eu.karuza.ql.ast.Question;
import eu.karuza.ql.ast.Statement;
import eu.karuza.ql.ast.expr.type.Type;
import eu.karuza.ql.error.QLError;
import eu.karuza.ql.parser.ParserContext;
import eu.karuza.ql.visitor.StatementVisitor;

public class DefinitionCollector implements StatementVisitor<Void> {
	
	private ParserContext context;

	public DefinitionCollector(ParserContext context) {
		this.context = context;
	}

	@Override
	public Void visit(Form node) {
		for (Statement statement : node.getStatements()) {
			statement.accept(this);
		}
		return null;
	}

	@Override
	public Void visit(ConditionalStatement node) {
		for (Statement statement : node.getStatements()) {
			statement.accept(this);
		}
		return null;
	}

	@Override
	public Void visit(AnswerableQuestion node) {
		declareVariable(node, node.getType());
		return null;
	}

	@Override
	public Void visit(ComputedQuestion node) {
		declareVariable(node, node.getExpr().typeOf(context.getTable()));
		return null;
	}

	private void declareVariable(Question node, Type type) {
		if (context.hasSymbol(node.getName())) {
			context.addError(new QLError("Duplicate entry with name: " + node.getName() + " at line: " + node.getLineNumber()));
		} else {
			context.putSymbol(node.getName(), new Symbol(node, node.getExpr()));
		}
	}

}
