package org.uva.sea.ql.widget;

import java.util.List;

import org.uva.sea.ql.ast.AnswerableQuestion;
import org.uva.sea.ql.ast.ComputedQuestion;
import org.uva.sea.ql.ast.ConditionalStatement;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.expr.type.BoolType;
import org.uva.sea.ql.visitor.StatementVisitor;

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
