package eu.karuza.ql.loader;


import eu.karuza.ql.QLFrontEndException;
import eu.karuza.ql.service.ParserService;

import android.content.Context;
import android.net.ConnectivityManager;

public class FormLoader extends AbstractLoader<ParserResult> {

	public FormLoader(Context context) {
		super(context);
	}

	@Override
	protected ParserResult load() {
		result = new ParserResult();
		ParserService service = new ParserService();
		try {
			((ParserResult)result).setContext(service.fetchServerForm((ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE)));
		} catch (QLFrontEndException e) {
			result.setException(e);
		}
		return (ParserResult) result;
	}

}
