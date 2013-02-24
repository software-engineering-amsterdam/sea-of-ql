package eu.karuza.ql.ui.widget;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import eu.karuza.ql.R;
import eu.karuza.ql.ast.Question;
import eu.karuza.ql.ast.statement.AnswerableQuestion;
import eu.karuza.ql.ast.value.Value;
import eu.karuza.ql.ui.FormAdapter.Callbacks;

public class TextRow implements RowWrapper, OnKeyListener, OnFocusChangeListener {

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
		convertView.setOnFocusChangeListener(this);
	}

	@Override
	public boolean onKey(View v, int keyCode, KeyEvent event) {
       if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
    	   setValue(((EditText)v).getText().toString());
    	   return true;
       }
       return false;
	}
	
	private void setValue(String value) {
		node.setValue(value);
		callbacks.valueChanged();
	}

	@Override
	public void onFocusChange(View v, boolean hasFocus) {
		if(!hasFocus) {
			setValue(((EditText) v.findViewById(R.id.answerable_value)).getText().toString());
		}
	}

}
