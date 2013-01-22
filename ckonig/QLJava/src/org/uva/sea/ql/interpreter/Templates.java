package org.uva.sea.ql.interpreter;

import java.io.IOException;

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
	
	private String question;
	private String input;
	private String getter_bool;
	private String getter_money;
	private String getter_string;
	private String evaluator;
	private String listener;
	private String document;
	private String startHiddenContainer;
	private String endHiddenContainer;
	
	private String path;
	
	public Templates(String path) throws InterpreterException {
		this.path = path;
		try {
			loadTemplates();
		} catch (IOException ex) {
			throw new InterpreterException(ex.getMessage());
		}
	}

	private void loadTemplates() throws IOException {
		this.document = IOHelper.read(path+"document.html");
		this.input = IOHelper.read(path+"input.html");
		this.question = IOHelper.read(path+"question.html");
		this.getter_bool = IOHelper.read(path+"getter_bool.html");
		this.getter_money = IOHelper.read(path+"getter_money.html");
		this.getter_string = IOHelper.read(path+"getter_string.html");
		this.evaluator = IOHelper.read(path+"evaluator.html");
		this.listener = IOHelper.read(path+"listener.html");
		this.startHiddenContainer = IOHelper.read(path + "start_hidden.html");
		this.endHiddenContainer = IOHelper.read(path + "end_hidden.html");
	}

	public String question(String content, String input) {
		return question.replace(CONTENT, content).replace(INPUT, input);
	}

	public String input(String name, String type) {
		return input.replace(NAME, name).replace(TYPE, type);
	}

	public String getterBool(String name) {
		return getter_bool.replace(NAME, name);
	}

	public String getterMoney(String name) {
		return getter_money.replace(NAME, name);
	}

	public String getterString(String name) {
		return getter_string.replace(NAME, name);
	}

	public String document(String heading, String body, String script) {
		return document.replace(BODY, body).replace(SCRIPT, script)
				.replace(HEADING, heading);
	}

	public String listener(String name, String id) {
		return listener.replace(NAME, name).replace(ID, id);
	}

	public String evaluator(String id, String condition) {
		return evaluator.replace(ID, id).replace(CONDITION, condition);
	}
	public String hiddenStart(String id) {
		return startHiddenContainer.replace(ID, id);
	}

	public String hiddenEnd() {
		return endHiddenContainer;
	}
}
