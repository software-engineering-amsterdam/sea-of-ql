package visitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observer;
import java.util.Map.Entry;
import visitor.evaluator.Bindable;
import ast.Type;
import ast.expression.Ident;
import ast.expression.Value;
import ast.statement.QuestionComputed;
import ast.statement.QuestionVar;
import ast.statement.Var;
import ast.type.Message;

public class Environment {
	private final Map<Ident, QuestionComputed> mapComputed = new HashMap<Ident, QuestionComputed>();
	private final Map<Ident, QuestionVar> mapVar = new HashMap<Ident, QuestionVar>();
	private final Map<Ident, Type> typeEnv = new HashMap<Ident, Type>();
	private final Map<Ident, Bindable> valEnv = new HashMap<Ident, Bindable>();
	private final List<Message> messages = new ArrayList<Message>();

	public Environment() {
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

	public Map<Ident, Type> getTypeEnv() {
		return typeEnv;
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
		while(it.hasNext())
		{
			Entry<Ident, Bindable> tmp = it.next();
			String ident = tmp.getKey().toString();
			Bindable bindable = (Bindable) tmp.getValue();
			String type = bindable.getType().toString();
			String value = bindable.getValue().toString();
			System.out.println("\t\""+ident.replaceAll("\"", "\\\"")+"\":{"); // print ident and escape double quotes
			System.out.println("\t\t\"type\": \""+type+"\"");
			System.out.println("\t\t\"value\": \""+value.replaceAll("\"", "\\\"")+"\"");
			System.out.println("\t}");
		}
		System.out.println("}");
	}
}
