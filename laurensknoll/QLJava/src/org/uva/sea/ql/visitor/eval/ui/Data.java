package org.uva.sea.ql.visitor.eval.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.expr.atom.Ident;
import org.uva.sea.ql.visitor.eval.value.AbstractValue;

public class Data {

	private final Data parent;
	private final List<Data> children;
	private final Map<Ident, AbstractValue> values;

	public Data(Map<Ident, AbstractValue> values) {
		this(null, values);
	}

	private Data(Data parent, Map<Ident, AbstractValue> values) {
		this.parent = parent;

		this.values = values;
		this.children = new ArrayList<Data>();
	}

	public Data createChild(Map<Ident, AbstractValue> values) {
		Data child = new Data(this, values);
		this.children.add(child);
		return child;
	}

	public Data getParent() {
		return this.parent;
	}

	public List<Data> getChildren() {
		return this.children;
	}

	public Map<Ident, AbstractValue> getValues() {
		return this.values;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<Ident, AbstractValue> entry : this.values.entrySet()) {
			sb.append(entry.getKey().toString());
			sb.append(" : ");
			sb.append(entry.getValue().toString());
			sb.append(System.getProperty("line.separator"));
		}

		return sb.toString();
	}

}
