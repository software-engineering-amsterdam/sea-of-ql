package org.uva.sea.ql.evaluator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observer;
import java.util.Map.Entry;

import org.uva.sea.ql.ast.Type;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.Value;
import org.uva.sea.ql.ast.statement.QuestionComputed;
import org.uva.sea.ql.ast.statement.QuestionVar;
import org.uva.sea.ql.ast.statement.Var;
import org.uva.sea.ql.ast.type.Message;
import org.uva.sea.ql.evaluator.Bindable;


public class Environment {
	private final Map<Ident, QuestionComputed> mapComputed = new HashMap<Ident, QuestionComputed>();
	private final Map<Ident, QuestionVar> mapVar = new HashMap<Ident, QuestionVar>();
	private final Map<Ident, Bindable> valEnv = new HashMap<Ident, Bindable>();
	private final List<Message> messages = new ArrayList<Message>();
	private Map<Ident, Type> typeEnv = new HashMap<Ident, Type>();
	
	public Environment(Map<Ident, Type> typeEnv) {
		this.typeEnv = typeEnv;
	}

	public void setComputed(Ident ident, QuestionComputed stat) {
		if (mapComputed.containsKey(ident))
			addError("ERROR: " + ident.getValue() + " already exists!");
		else
			mapComputed.put(ident, stat);
	}

	public QuestionComputed getValue(Ident ident) {
		return mapComputed.get(ident);
	}

	public void setVar(Ident ident, QuestionVar stat) {
		if (mapComputed.containsKey(ident))
			addError("ERROR: " + ident.getValue() + " already exists!");
		else
			mapVar.put(ident, stat);
	}

	public QuestionVar getVar(QuestionVar stat) {
		return mapVar.get(stat);
	}

	public List<Message> getMessages() {
		return messages;
	}

	public Bindable getIdent(Ident ident) {
		return valEnv.get(ident);
	}

	public boolean hasIdent(Ident ident) {
		return valEnv.containsKey(ident);
	}

	public void setVar(Var var) {
		valEnv.put(var.getIdent(), new Bindable(var.getType()));
	}

	public void setVal(Ident ident, Value val) {
		Bindable bind = valEnv.get(ident);
		bind.setValue(val);
	}

	public Map<Ident, Bindable> getValEnv() {
		return valEnv;
	}

	public void addError(String err) {
		this.messages.add(new Message(err));
	}

	public void addObserver(Ident ident, Observer observer) {
		this.valEnv.get(ident).addObserver(observer);
	}

	public void notifyObservers(Ident ident) {
		this.valEnv.get(ident).notifyObservers();
	}

	public void printErrors() {
		System.out.println("There was an error during parsing:");
		for (Message i : this.getMessages())
			System.out.println("-" + i.getMessage());
	}

	public void printVariablesJSON(){
		Iterator<Entry<Ident, Bindable>> it = this.getValEnv().entrySet().iterator();
		System.out.println("{");
		boolean first = true;
		while(it.hasNext())
		{
			if(first)
				first=false;
			else
				System.out.println(",");
			Entry<Ident, Bindable> tmp = it.next();
			String ident = tmp.getKey().toString();
			Bindable bindable = (Bindable) tmp.getValue();
			String type = bindable.getType().toString();
			String value = bindable.getValue().toString();
			System.out.println("\t\""+ident.replaceAll("\"", "\\\"")+"\":{"); // print ident and escape double quotes
			System.out.print("\t\t\"type\": \""+type+"\"");
			System.out.println(",");
			System.out.println("\t\t\"value\": \""+value.replaceAll("\"", "\\\"")+"\"");
			System.out.print("\t}");
		}
		System.out.println();
		System.out.println("}");
	}

	public Map<Ident, Type> getTypeEnv() {
		return typeEnv;
	}
}
