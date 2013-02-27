package eu.karuza.ql.ui;

import java.util.List;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import eu.karuza.ql.R;
import eu.karuza.ql.parser.ParserContext;
import eu.karuza.ql.service.IParserService;
import eu.karuza.ql.service.ServiceFactory;
import eu.karuza.ql.ui.widget.RowWrapper;

public class QuestionListFragment extends ListFragment implements FormAdapter.Callbacks {

	private ParserContext context;
	private FormAdapter adapter = null;
	private IParserService service = ServiceFactory.getParserService();

	public QuestionListFragment() {

	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_question, null);
	}

	public void updateContext(ParserContext context) {
		this.context = context;
		List<RowWrapper> data = service.getDisplayableData(context);
		setupAdapter(data);
	}

	private void setupAdapter(List<RowWrapper> data) {
		if(adapter == null) {
			adapter = new FormAdapter(data, this);
			setListAdapter(adapter);
		} else {
			adapter.setList(data);
		}
	}

	@Override
	public void valueChanged() {
		setupAdapter(service.getDisplayableData(context));
	}
}
