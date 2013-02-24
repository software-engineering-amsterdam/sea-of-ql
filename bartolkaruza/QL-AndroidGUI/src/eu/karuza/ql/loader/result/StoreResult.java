package eu.karuza.ql.loader.result;

import eu.karuza.ql.ServerResult;

public class StoreResult extends LoaderResult {

	private ServerResult result;

	public ServerResult getResult() {
		return result;
	}

	public void setResult(ServerResult result) {
		this.result = result;
	}
	
	public String getResponse() {
		return getResult().getResponse();
	}
}
