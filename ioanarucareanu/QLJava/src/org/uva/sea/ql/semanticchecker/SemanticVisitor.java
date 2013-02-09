package org.uva.sea.ql.semanticchecker;

import java.util.List;

import org.uva.sea.ql.ast.expr.Add;
import org.uva.sea.ql.ast.expr.Div;
import org.uva.sea.ql.ast.expr.Mul;
import org.uva.sea.ql.ast.expr.Sub;
import org.uva.sea.ql.ast.ql.ComputedQuestion;
import org.uva.sea.ql.ast.ql.ConditionalElseQuestion;
import org.uva.sea.ql.ast.ql.QLForm;
import org.uva.sea.ql.ast.ql.QLItem;
import org.uva.sea.ql.ast.ql.Question;
import org.uva.sea.ql.ast.ql.SimpleConditionalQuestion;

import smth.ErrorMessage;

public class SemanticVisitor implements QLItemSemanticVisitor, ExpressionSemanticVisitor {

	public List<ErrorMessage> start(QLForm form) {

		form.accept(form, this);
		return null;
	}

	public void visit(QLForm form) {

		List<QLItem> itemsToVisit = form.getBlockOfItems().getBlockElements();
		for (QLItem item : itemsToVisit) {
			item.accept(item, this);
		}
	}

	@Override
	public void visit(Question question) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(ComputedQuestion question) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(SimpleConditionalQuestion question) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(ConditionalElseQuestion question) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(Add node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Sub node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Mul node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Div node) {
		// TODO Auto-generated method stub
		
	}

}
