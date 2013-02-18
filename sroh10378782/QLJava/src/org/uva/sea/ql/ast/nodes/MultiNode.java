package org.uva.sea.ql.ast.nodes;

import java.util.ArrayList;

public interface MultiNode<T> extends NodeType {
	public void addValue(T value);
	public int getValuesCount();
	public ArrayList<T> getValues();
	public T getValue(int index);
}
