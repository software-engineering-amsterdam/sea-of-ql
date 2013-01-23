package org.uva.sea.ql.interpreter.html;

import java.io.IOException;
import java.util.Map;

import org.uva.sea.ql.interpreter.IOHelper;
import org.uva.sea.ql.interpreter.InterpreterException;

public class Templates {

	private final String NAME = "<?NAME?>";
	private final String CONTENT = "<?CONTENT?>";
	private final String ID = "<?ID?>";
	private final String CONDITION = "<?CONDITION?>";
	private final String BODY = "<?BODY?>";
	private final String INPUT = "<?INPUT?>";
	private final String TYPE = "<?TYPE?>";
	private final String SCRIPT = "<?SCRIPT?>";
	private final String HEADING = "<?HEADING?>";
	private final String CLASS = "<?CLASS?>";

	private Map<String, String> values;

	public Templates(String path) throws InterpreterException {
		try {
			this.values = IOHelper.readFolder(path);
		} catch (IOException ex) {
			throw new InterpreterException(ex.getMessage());
		}
	}

	public String question(String content, String input) {
		return values.get("question").replace(CONTENT, content)
				.replace(INPUT, input);
	}

	public String input(String name, InputTypes type) {
		return values.get("input").replace(NAME, name)
				.replace(TYPE, getInputType(type)).replace(CLASS, getInputClass(type));
	}

	public String getterBool(String name) {
		return values.get("getter_bool").replace(NAME, name);
	}

	public String getterMoney(String name) {
		return values.get("getter_money").replace(NAME, name);
	}

	public String getterString(String name) {
		return values.get("getter_string").replace(NAME, name);
	}

	public String document(String heading, String body, String script) {
		return values.get("document").replace(BODY, body)
				.replace(SCRIPT, script).replace(HEADING, heading);
	}

	public String listener(String name, String id) {
		return values.get("listener").replace(NAME, name).replace(ID, id);
	}

	public String evaluator(String id, String condition) {
		return values.get("evaluator").replace(ID, id)
				.replace(CONDITION, condition);
	}

	public String hiddenStart(String id) {
		return values.get("hidden_start").replace(ID, id);
	}

	public String hiddenEnd() {
		return values.get("hidden_end");
	}

	private static String getInputType(InputTypes t) {
		if (t == InputTypes.BOOLEAN)
			return "checkbox";
		if (t == InputTypes.STRING)
			return "text";
		if (t == InputTypes.MONEY)
			return "text";
		return null;
	}
	private static String getInputClass(InputTypes t){
		if (t == InputTypes.BOOLEAN)
			return "input_boolean";
		if (t == InputTypes.STRING)
			return "required";
		if (t == InputTypes.MONEY)
			return "number required";
		return null;
	}
}
