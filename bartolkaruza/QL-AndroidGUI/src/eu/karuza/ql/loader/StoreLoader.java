package eu.karuza.ql.loader;


import eu.karuza.ql.QLFrontEndException;
import eu.karuza.ql.parser.ParserContext;
import eu.karuza.ql.service.ParserService;

import android.content.Context;
import android.net.ConnectivityManager;

public class StoreLoader extends AbstractLoader<StoreResult> {

	private ParserContext context;
	
	public StoreLoader(Context context, ParserContext parserContext) {
		super(context);
		this.context = parserContext;
	}

	@Override
	protected StoreResult load() {
		result = new StoreResult();
		ParserService service = new ParserService();
		try {
			service.storeFormAnswers((ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE), context.getForm());
		} catch (QLFrontEndException e) {
			result.setException(e);
		}
		return (StoreResult)result;
	}

}
