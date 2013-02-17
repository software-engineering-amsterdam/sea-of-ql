package org.uva.sea.ql.ui;

import java.util.List;

import org.uva.sea.ql.parser.ParserContext;
import org.uva.sea.ql.service.ParserService;
import org.uva.sea.ql.widget.RowWrapper;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class QuestionListFragment extends ListFragment implements FormAdapter.Callbacks {

	private ParserContext context;

	public QuestionListFragment() {

	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return super.onCreateView(inflater, container, savedInstanceState); // TODO
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
		FormAdapter adapter = new FormAdapter(data, this);
		setListAdapter(adapter);
	}

	@Override
	public void valueChanged() {
		ParserService service = new ParserService();
		setupAdapter(service.getDisplayableData(context));
	}
}
