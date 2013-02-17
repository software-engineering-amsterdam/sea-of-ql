package org.uva.sea.ql.ui;

import org.uva.sea.ql.service.ParserService;
import org.uva.sea.ql.service.QLFrontEndException;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.net.ConnectivityManager;

public class FormLoader extends AsyncTaskLoader<ParserResult> {

	private ParserResult result;
	
	public FormLoader(Context context) {
		super(context);
	}
	
	@Override
	public void deliverResult(ParserResult result) {
		if (this.result == null) {
			this.result = result;
		}
		if(isStarted()) {
			super.deliverResult(result);
		}
	}
	
	@Override
	protected void onStartLoading() {
		if(this.result != null) {
			deliverResult(this.result);
		}
		
		if(takeContentChanged() || this.result == null) {
			forceLoad();
		}	
	}

	@Override
	public ParserResult loadInBackground() {
		ParserResult result = new ParserResult();
		ParserService service = new ParserService();
		try {
			result.setContext(service.fetchServerForm((ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE)));
		} catch (QLFrontEndException e) {
			result.setException(e);
		}
		return result;
	}

}
