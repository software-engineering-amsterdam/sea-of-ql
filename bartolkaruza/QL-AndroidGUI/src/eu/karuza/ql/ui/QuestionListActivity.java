package eu.karuza.ql.ui;

import android.app.Activity;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import eu.karuza.ql.R;
import eu.karuza.ql.loader.FormLoader;
import eu.karuza.ql.loader.LoaderResult;
import eu.karuza.ql.loader.ParserResult;
import eu.karuza.ql.loader.StoreLoader;
import eu.karuza.ql.loader.StoreResult;
import eu.karuza.ql.parser.ParserContext;

public class QuestionListActivity extends Activity implements LoaderCallbacks<LoaderResult> {

	private int retryAttempt = 0;

	private final static int GET_SURVEY_LOADER = 0;
	private final static int STORE_SURVEY_LOADER = 1;

	private ParserContext context = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_question);
		getLoaderManager().initLoader(0, null, this);
		findViewById(R.id.loading_spinner).setVisibility(View.VISIBLE);
	}

	@Override
	public Loader<LoaderResult> onCreateLoader(int id, Bundle args) {
		switch (id) {
		case GET_SURVEY_LOADER:
			return new FormLoader(getApplicationContext());
		case STORE_SURVEY_LOADER:
			return new StoreLoader(getApplicationContext(), context);
		default:
			return null;
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.reload:
			getLoaderManager().restartLoader(GET_SURVEY_LOADER, null, this);
			return true;
		case R.id.store:
			startOrInitializeStoreLoader();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private void startOrInitializeStoreLoader() {
		if (getLoaderManager().getLoader(STORE_SURVEY_LOADER) != null) {
			getLoaderManager().restartLoader(STORE_SURVEY_LOADER, null, this);
		} else {
			getLoaderManager().initLoader(STORE_SURVEY_LOADER, null, this);
		}
	}

	@Override
	public void onLoadFinished(Loader<LoaderResult> loader, LoaderResult result) {
		switch (loader.getId()) {
		case GET_SURVEY_LOADER:
			handleGetFormResult((ParserResult) result);
			break;
		case STORE_SURVEY_LOADER:
			handleStoreFormResult((StoreResult) result);
			break;
		}

	}

	private void handleStoreFormResult(StoreResult result) {
		if (result.getException() != null) {
			Toast.makeText(this, "Something went wrong while trying to store the form", Toast.LENGTH_LONG).show();
		} else {
			Toast.makeText(getApplicationContext(), "Result of storing: " + result.getResponse(), Toast.LENGTH_LONG).show();
		}
	}

	private void handleGetFormResult(ParserResult result) {
		this.context = result.getContext();
		findViewById(R.id.loading_spinner).setVisibility(View.GONE);
		if (result.getException() == null && !result.hasErrors()) {
			updateFragment(result.getContext());
		} else if (retryAttempt < 2) {
			Toast.makeText(this, "Something went wrong while trying to load the form, retrying", Toast.LENGTH_LONG).show();
			retryAttempt++;
			getLoaderManager().restartLoader(0, null, this);
		} else {
			Toast.makeText(this, "Something went wrong while trying to load the form", Toast.LENGTH_LONG).show();
		}
	}

	@Override
	public void onLoaderReset(Loader<LoaderResult> arg0) {

	}

	private void updateFragment(ParserContext context) {
		QuestionListFragment fragment = (QuestionListFragment) getFragmentManager().findFragmentById(R.id.question_list);
		fragment.updateContext(context);
	}
}
