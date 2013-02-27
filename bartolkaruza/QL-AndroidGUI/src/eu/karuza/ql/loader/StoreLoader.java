package eu.karuza.ql.loader;

import android.content.Context;
import android.net.ConnectivityManager;
import eu.karuza.ql.QLFrontEndException;
import eu.karuza.ql.loader.result.LoaderResult;
import eu.karuza.ql.loader.result.StoreResult;
import eu.karuza.ql.parser.ParserContext;
import eu.karuza.ql.service.IParserService;
import eu.karuza.ql.service.ServiceFactory;

public class StoreLoader extends AbstractLoader<StoreResult> {

	private ParserContext context;
	private IParserService service = ServiceFactory.getParserService();
	private StoreResult result;

	public StoreLoader(Context context, ParserContext parserContext) {
		super(context);
		this.context = parserContext;
	}

	@Override
	protected StoreResult load() {
		result = new StoreResult();
		try {
			result.setResult(service.storeFormAnswers((ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE), context.getForm()));
		} catch (QLFrontEndException e) {
			result.setException(e);
		}
		return result;
	}

	@Override
	protected LoaderResult getResult() {
		return result;
	}

	@Override
	protected void setResult(LoaderResult result) {
		this.result = (StoreResult) result;
	}

}
