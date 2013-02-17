package org.uva.sea.ql.widget;

import org.uva.sea.ql.R;
import org.uva.sea.ql.ast.AnswerableQuestion;
import org.uva.sea.ql.ast.Question;
import org.uva.sea.ql.ast.expr.value.Value;
import org.uva.sea.ql.ui.FormAdapter.Callbacks;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;

public class TextRow implements RowWrapper, OnKeyListener {

	private AnswerableQuestion node;
	private Callbacks callbacks;

	public TextRow(AnswerableQuestion node) {
		this.node = node;
	}

	@Override
	public Question getQuestion() {
		return node;
	}

	@Override
	public int getLayoutRes() {
		return R.layout.answerable_value_row;
	}

	@Override
	public void setListener(Callbacks callbacks) {
		this.callbacks = callbacks;
	}

	@Override
	public void setRowView(View convertView) {
		EditText editText = (EditText) convertView.findViewById(R.id.answerable_value);
		editText.setText(((Value)node.getExpr()).getRawValue().toString());
		editText.setOnKeyListener(this);
	}

	@Override
	public boolean onKey(View v, int keyCode, KeyEvent event) {
       if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
    	   node.setValue(((EditText)v).getText());
    	   callbacks.valueChanged();
    	   return true;
       }
       return false;
	}

}
