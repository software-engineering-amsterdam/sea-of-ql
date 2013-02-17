package org.uva.sea.ql.ui;

import java.util.List;

import org.uva.sea.ql.R;
import org.uva.sea.ql.widget.RowWrapper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class FormAdapter extends BaseAdapter {
	
	public interface Callbacks{
		void valueChanged();		
	}

	private List<RowWrapper> data;
	private Callbacks callbacks;

	public FormAdapter(List<RowWrapper> data, Callbacks callbacks) {
		this.data = data;
		this.callbacks = callbacks;
	}

	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public RowWrapper getItem(int position) {
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		return data.get(position).hashCode();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		RowWrapper holder = data.get(position);
		holder.setListener(callbacks);
		LayoutInflater inflater = LayoutInflater.from(parent.getContext());
		convertView = inflater.inflate(holder.getLayoutRes(), null);
		TextView label = (TextView) convertView.findViewById(R.id.row_label);
		label.setText(holder.getQuestion().getLabel());
		holder.setRowView(convertView);
		return convertView;
	}

}
