package eu.karuza.ql.ui.widget;

import java.util.List;

import eu.karuza.ql.ast.Form;
import eu.karuza.ql.ast.Statement;
import eu.karuza.ql.ast.statement.AnswerableQuestion;
import eu.karuza.ql.ast.statement.ComputedQuestion;
import eu.karuza.ql.ast.statement.IfConditionalStatement;
import eu.karuza.ql.ast.statement.IfElseConditionalStatement;
import eu.karuza.ql.visitor.StatementVisitor;

public class RowWrapperGenerator implements StatementVisitor<Void> {

	private List<RowWrapper> widgetList;
	
	public RowWrapperGenerator(List<RowWrapper> list) {
		this.widgetList = list;
	}
	
	public List<RowWrapper> getWidgetList() {
		return widgetList;
	}

	@Override
	public Void visit(Form node) {
		for(Statement statement : node.getStatements()) {
			statement.accept(this);
		}
		return null;
	}

	@Override
	public Void visit(IfConditionalStatement node) {
		if(node.isVisible()) {
			for(Statement statement : node.getStatements()) {
				statement.accept(this);
			}
		}
		return null;
	}

	@Override
	public Void visit(AnswerableQuestion node) {
		RowWrapper wrapper;
		if(node.getType().isCompatibleToBool()) {
			wrapper = new CheckBoxRow(node);
		} else {
			wrapper = new TextRow(node, node.getType().isCompatibleToInt(), node.getType().isCompatibleToMoney());
		}
		this.widgetList.add(wrapper);
		return null;
	}

	@Override
	public Void visit(ComputedQuestion node) {
		widgetList.add(new ValueRow(node));
		return null;
	}

	@Override
	public Void visit(IfElseConditionalStatement node) {
		List<Statement> statements;
		if(node.isVisible()) {
			statements = node.getIfStatements();
		} else {
			statements = node.getElseStatements();
		}
		for(Statement statement : statements) {
			statement.accept(this);
		}
		return null;
	}
}
