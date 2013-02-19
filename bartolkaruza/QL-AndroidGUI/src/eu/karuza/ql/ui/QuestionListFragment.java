package eu.karuza.ql.ui;

import java.util.List;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import eu.karuza.ql.R;
import eu.karuza.ql.parser.ParserContext;
import eu.karuza.ql.service.ParserService;
import eu.karuza.ql.widget.RowWrapper;

public class QuestionListFragment extends ListFragment implements FormAdapter.Callbacks {

	private ParserContext context;
	private FormAdapter adapter = null;

	public QuestionListFragment() {

	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_question, null);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

	public void updateContext(ParserContext context) {
		this.context = context;
		List<RowWrapper> data = new ParserService().getDisplayableData(context);
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
		ParserService service = new ParserService();
		setupAdapter(service.getDisplayableData(context));
	}
}
