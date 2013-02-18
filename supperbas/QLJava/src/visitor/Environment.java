package visitor;

import java.rmi.UnexpectedException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import visitor.evaluator.Bindable;

import ast.Type;
import ast.expression.Ident;
import ast.expression.Value;
import ast.statement.QuestionComputed;
import ast.statement.QuestionVar;
import ast.statement.Var;
import ast.type.Message;

public class Environment {
	private Map<Ident, QuestionComputed> mapComputed = new HashMap<Ident, QuestionComputed>();
	private Map<Ident, QuestionVar> mapVar = new HashMap<Ident, QuestionVar>();
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
	
	public boolean hasIdent(Ident ident){
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

}
