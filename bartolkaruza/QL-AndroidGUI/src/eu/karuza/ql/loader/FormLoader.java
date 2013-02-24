package eu.karuza.ql.loader;

import android.content.Context;
import android.net.ConnectivityManager;
import eu.karuza.ql.QLFrontEndException;
import eu.karuza.ql.loader.result.LoaderResult;
import eu.karuza.ql.loader.result.ParserResult;
import eu.karuza.ql.service.IParserService;
import eu.karuza.ql.service.ServiceFactory;

public class FormLoader extends AbstractLoader<ParserResult> {

	private IParserService service = ServiceFactory.getParserService();
	private ParserResult result;

	public FormLoader(Context context) {
		super(context);
	}

	@Override
	protected ParserResult load() {
		result = new ParserResult();
		try {
			result.setContext(service.fetchServerForm((ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE)));
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
		this.result = (ParserResult) result;
	}

}
