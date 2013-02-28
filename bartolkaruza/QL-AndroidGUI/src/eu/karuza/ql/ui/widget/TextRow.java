package eu.karuza.ql.ui.widget;

import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import eu.karuza.ql.R;
import eu.karuza.ql.ast.Question;
import eu.karuza.ql.ast.statement.AnswerableQuestion;
import eu.karuza.ql.ast.value.Value;
import eu.karuza.ql.ui.FormAdapter.Callbacks;

public class TextRow implements RowWrapper, OnKeyListener, TextWatcher {

	private AnswerableQuestion node;
	private Callbacks callbacks;
	private boolean numeric;
	private boolean decimal;

	public TextRow(AnswerableQuestion node, boolean numeric, boolean decimal) {
		this.node = node;
		this.numeric = numeric;
		this.decimal = decimal;
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
		editText.setText(((Value) node.getExpr()).getRawValue().toString());
		editText.setOnKeyListener(this);
		setInputType(editText);
		editText.addTextChangedListener(this);
	}

	private void setInputType(EditText editText) {
		int flags;
		if (numeric && decimal) {
			flags = InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL;
		} else if (numeric) {
			flags = InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_NORMAL;
		} else {
			flags = InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_SHORT_MESSAGE | InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS;
		}
		editText.setInputType(flags);
	}

	@Override
	public boolean onKey(View v, int keyCode, KeyEvent event) {
		if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
			setValue(((EditText) v).getText().toString());
			callbacks.valueChanged();
			return true;
		}
		return false;
	}

	private void setValue(String value) {
		node.setValue(value);	
	}

	@Override
	public void afterTextChanged(Editable s) {
		setValue(s.toString());
	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count, int after) {

	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {

	}
}
