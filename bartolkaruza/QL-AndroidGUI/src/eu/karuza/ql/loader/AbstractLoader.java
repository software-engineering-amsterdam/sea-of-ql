package eu.karuza.ql.loader;

import eu.karuza.ql.loader.result.LoaderResult;
import android.content.AsyncTaskLoader;
import android.content.Context;

public abstract class AbstractLoader<D> extends AsyncTaskLoader<LoaderResult> {
	
	protected abstract LoaderResult getResult();
	protected abstract void setResult(LoaderResult result);
	
	public AbstractLoader(Context context) {
		super(context);
	}
	
	@Override
	public void deliverResult(LoaderResult result) {
		if (getResult() == null) {
			setResult(result);
		}
		if(isStarted()) {
			super.deliverResult(result);
		}
	}
	

	
	@Override
	protected void onStartLoading() {
		if(getResult() != null) {
			deliverResult(getResult());
		}
		
		if(takeContentChanged() || getResult() == null) {
			forceLoad();
		}	
	}
	
	@Override
	public LoaderResult loadInBackground() {
		return load();
	}
	
	protected abstract LoaderResult load();
}
