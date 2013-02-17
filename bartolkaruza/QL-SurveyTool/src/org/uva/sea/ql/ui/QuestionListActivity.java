package org.uva.sea.ql.ui;

import org.uva.sea.ql.R;
import org.uva.sea.ql.parser.ParserContext;

import android.app.Activity;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class QuestionListActivity extends Activity implements LoaderCallbacks<ParserResult> {

	private int retryAttempt = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_question);
		getLoaderManager().initLoader(0, null, this);
		findViewById(R.id.loading_spinner).setVisibility(View.VISIBLE);
	}

	@Override
	public Loader<ParserResult> onCreateLoader(int id, Bundle args) {
		return new FormLoader(getApplicationContext());
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
		case R.id.reload: getLoaderManager().restartLoader(0, null, this); return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public void onLoadFinished(Loader<ParserResult> loader, ParserResult result) {
		findViewById(R.id.loading_spinner).setVisibility(View.GONE);
		if (result.getException() == null && !result.hasErrors()) {
			updateFragment(result.getContext());
		} else if(retryAttempt < 2) {
			Toast.makeText(this, "Something went wrong while trying to load the form, retrying", Toast.LENGTH_LONG).show();
			retryAttempt++;
			getLoaderManager().restartLoader(0, null, this);
		} else {
			Toast.makeText(this, "Something went wrong while trying to load the form", Toast.LENGTH_LONG).show();
		}
	}

	@Override
	public void onLoaderReset(Loader<ParserResult> arg0) {

	}

	private void updateFragment(ParserContext context) {
		QuestionListFragment fragment = (QuestionListFragment)getFragmentManager().findFragmentById(R.id.question_list);
		fragment.updateContext(context);
	}
}
