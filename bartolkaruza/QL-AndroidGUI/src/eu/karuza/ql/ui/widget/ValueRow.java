package eu.karuza.ql.ui.widget;



import android.view.View;
import android.widget.TextView;
import eu.karuza.ql.R;
import eu.karuza.ql.ast.Question;
import eu.karuza.ql.ast.statement.ComputedQuestion;
import eu.karuza.ql.ui.FormAdapter.Callbacks;

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
