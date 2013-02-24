package eu.karuza.ql.ui.widget;


import eu.karuza.ql.ast.Question;
import eu.karuza.ql.ui.FormAdapter.Callbacks;

import android.view.View;

public interface RowWrapper {
	
	public Question getQuestion();
	
	public int getLayoutRes();

	public void setListener(Callbacks callbacks);

	public void setRowView(View convertView);
	
}
