package org.uva.sea.ql.widget;

import org.uva.sea.ql.ast.Question;
import org.uva.sea.ql.ui.FormAdapter.Callbacks;

import android.view.View;

public interface RowWrapper {
	
	public Question getQuestion();
	
	public int getLayoutRes();

	public void setListener(Callbacks callbacks);

	public void setRowView(View convertView);
	
}
