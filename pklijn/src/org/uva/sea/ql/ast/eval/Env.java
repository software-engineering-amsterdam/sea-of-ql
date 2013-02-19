package org.uva.sea.ql.ast.eval;

import java.util.HashMap;
import java.util.Map;

import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.types.NotDefinedType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.values.Value;
import org.uva.sea.ql.form.ScopedFormItem;

public class Env {
	
	private final Env parent;
	private final Map<Ident, Type> types;
	private final Map<Ident, Value> values;
	private final Map<ScopedFormItem, Env> childEnvironments;
	
	public Env() {
		this(null);
	}
	
	public Env(Env parent) {
		this.parent = parent;
		types = new HashMap<Ident, Type>();
		values = new HashMap<Ident, Value>();
		childEnvironments = new HashMap<ScopedFormItem, Env>();
	}
	
	public Env getParent() {
		return parent;
	}
	
	public Env getChildScope(ScopedFormItem formItem) {
		if (!childEnvironments.containsKey(formItem)) {
			childEnvironments.put(formItem, new Env(this));
		}
		return childEnvironments.get(formItem);
	}
	
	public Type typeOf(Ident ident) {
		if (types.containsKey(ident))
			return types.get(ident);
		else if (parent != null)
			return parent.typeOf(ident);
		else 
			return new NotDefinedType();
	}
	
	public boolean hasIdent(Ident ident) {
		if (types.containsKey(ident))
			return true;
		else if (parent != null)
			return parent.hasIdent(ident);
		return false;
	}
	
	public void addIdent(Ident ident, Type type) {
		types.put(ident, type);
	}
	
	public void addValue(Ident ident, Value value) {
		if (hasValue(ident)) {
			if (types.containsKey(ident))
				values.put(ident, value);
			else if (parent != null)
				parent.addValue(ident, value);
		}
		else {
			values.put(ident, value);
		}
	}
	
	public boolean hasValue(Ident ident) {
		if (values.containsKey(ident))
			return true;
		else if (parent != null)
			return parent.hasValue(ident);
		return false;
	}
	
	public Value getValue(Ident ident) {
		assert hasValue(ident);
		if (hasValue(ident)) {
			if (values.containsKey(ident))
				return values.get(ident);
			else if (parent != null)
				return parent.getValue(ident);
			throw new IllegalArgumentException("The ident " + ident.getName() + " does not exist in the values of this environment");
		} else {
			throw new IllegalArgumentException("The ident " + ident.getName() + " does not exist in the values of this environment");
		}
	}
}
