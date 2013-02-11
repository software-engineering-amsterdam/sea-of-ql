package org.uva.sea.ql.ui;

import org.uva.sea.ql.R;
import org.uva.sea.ql.parser.ParserContext;
import org.uva.sea.ql.service.ParserService;
import org.uva.sea.ql.service.ServiceFactory;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class EditorFormPaneActivity extends FragmentActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.editor_activity);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
		case R.id.interpret:
			EditorFragment fragment = (EditorFragment)getSupportFragmentManager().findFragmentById(R.id.editor_fragment); 
			String ql = fragment.getQL();
			parseAndCheckForm(ql);
		}
		return super.onOptionsItemSelected(item);
	}
	
	private void parseAndCheckForm(String ql) {
		ParserService service = ServiceFactory.getParserService();
		ParserContext context = service.parseNewForm(ql);
		if(context.getErrors().size() > 0) {
			Toast.makeText(this, "errors found", Toast.LENGTH_SHORT).show();
		}
	}

}
