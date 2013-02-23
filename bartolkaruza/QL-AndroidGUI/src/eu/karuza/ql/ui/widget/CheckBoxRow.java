package eu.karuza.ql.ui.widget;



import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import eu.karuza.ql.R;
import eu.karuza.ql.ast.Question;
import eu.karuza.ql.ast.statement.AnswerableQuestion;
import eu.karuza.ql.ast.value.Value;
import eu.karuza.ql.ui.FormAdapter.Callbacks;

public class CheckBoxRow implements RowWrapper, OnCheckedChangeListener {

	private AnswerableQuestion node;
	private Callbacks callbacks;

	public CheckBoxRow(AnswerableQuestion node) {
		this.node = node;
	}

	@Override
	public Question getQuestion() {
		return node;
	}

	@Override
	public int getLayoutRes() {
		return R.layout.answerable_checklist_row;
	}

	@Override
	public void setListener(Callbacks callbacks) {
		this.callbacks = callbacks;
	}

	@Override
	public void setRowView(View convertView) {
		CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.answerable_value);
		checkBox.setChecked(((Boolean) ((Value) node.getExpr()).getRawValue()));
		checkBox.setOnCheckedChangeListener(this);
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		setValue(isChecked);
	}

	private void setValue(boolean value) {
		node.setValue(value);
		callbacks.valueChanged();
	}

}
