package eu.karuza.ql.loader;

import android.content.AsyncTaskLoader;
import android.content.Context;

public abstract class AbstractLoader<D> extends AsyncTaskLoader<LoaderResult> {
	
	protected LoaderResult result;
	
	public AbstractLoader(Context context) {
		super(context);
	}
	
	@Override
	public void deliverResult(LoaderResult result) {
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
	public LoaderResult loadInBackground() {
		return load();
	}
	
	protected abstract LoaderResult load();
}
