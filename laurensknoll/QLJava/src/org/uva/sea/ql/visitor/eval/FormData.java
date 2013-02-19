package org.uva.sea.ql.visitor.eval;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.expr.atom.Ident;
import org.uva.sea.ql.visitor.eval.value.AbstractValue;

public class FormData {

	private final FormData parent;
	private final List<FormData> children;
	private final Map<Ident, AbstractValue> values;

	public FormData(Map<Ident, AbstractValue> values) {
		this(null, values);
	}

	private FormData(FormData parent, Map<Ident, AbstractValue> values) {
		this.parent = parent;

		this.values = values;
		this.children = new ArrayList<FormData>();
	}

	public FormData getChildFormData(Map<Ident, AbstractValue> values) {
		FormData child = new FormData(this, values);
		this.children.add(child);
		return child;
	}

	public FormData getParent() {
		return this.parent;
	}

	public List<FormData> getChildren() {
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
