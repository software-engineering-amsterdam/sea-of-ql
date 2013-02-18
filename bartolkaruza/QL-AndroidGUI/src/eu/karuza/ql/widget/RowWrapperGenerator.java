package eu.karuza.ql.widget;

import java.util.List;


import eu.karuza.ql.ast.AnswerableQuestion;
import eu.karuza.ql.ast.ComputedQuestion;
import eu.karuza.ql.ast.ConditionalStatement;
import eu.karuza.ql.ast.Form;
import eu.karuza.ql.ast.Statement;
import eu.karuza.ql.ast.expr.type.BoolType;
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
	public Void visit(ConditionalStatement node) {
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
		if(node.getType() instanceof BoolType) {
			wrapper = new CheckBoxRow(node);
		} else {
			wrapper = new TextRow(node);
		}
		this.widgetList.add(wrapper);
		return null;
	}

	@Override
	public Void visit(ComputedQuestion node) {
		widgetList.add(new ValueRow(node));
		return null;
	}
}
