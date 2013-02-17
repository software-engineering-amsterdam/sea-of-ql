package org.uva.sea.ql.widget;

import org.uva.sea.ql.R;
import org.uva.sea.ql.ast.AnswerableQuestion;
import org.uva.sea.ql.ast.Question;
import org.uva.sea.ql.ast.expr.value.Value;
import org.uva.sea.ql.ui.FormAdapter.Callbacks;

import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

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
		checkBox.setChecked(((Boolean)((Value)node.getExpr()).getRawValue()));
		checkBox.setOnCheckedChangeListener(this);
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		node.setValue(isChecked);
		callbacks.valueChanged();
	}

}
