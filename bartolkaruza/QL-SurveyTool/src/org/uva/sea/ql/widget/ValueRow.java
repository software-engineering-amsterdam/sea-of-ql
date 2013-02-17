package org.uva.sea.ql.widget;

import org.uva.sea.ql.R;
import org.uva.sea.ql.ast.ComputedQuestion;
import org.uva.sea.ql.ast.Question;
import org.uva.sea.ql.ui.FormAdapter.Callbacks;

import android.view.View;
import android.widget.TextView;

public class ValueRow implements RowWrapper {

	private ComputedQuestion node;

	public ValueRow(ComputedQuestion node) {
		this.node = node;
	}

	@Override
	public Question getQuestion() {
		return node;
	}

	@Override
	public int getLayoutRes() {
		return R.layout.computed_row;
	}

	@Override
	public void setListener(Callbacks callbacks) {
		// No callbacks necessary from a non-changing widget
	}

	@Override
	public void setRowView(View convertView) {
		TextView view = (TextView)convertView.findViewById(R.id.computed_value);
		view.setText(node.getExpr().evaluate().getRawValue().toString());
	}

}
