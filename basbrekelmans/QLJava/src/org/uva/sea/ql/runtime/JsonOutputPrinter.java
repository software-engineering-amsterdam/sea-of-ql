package org.uva.sea.ql.runtime;

import java.io.IOException;
import java.io.Writer;

import org.uva.sea.ql.ast.expressions.Identifier;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.IntegerType;
import org.uva.sea.ql.ast.types.MoneyType;
import org.uva.sea.ql.ast.types.StringType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.types.UnknownType;
import org.uva.sea.ql.runtime.values.Value;
import org.uva.sea.ql.visitor.IParametrizedTypeVisitor;

public class JsonOutputPrinter extends OutputPrinter implements
		IParametrizedTypeVisitor<Value, String> {

	private int indent;
	private Writer outputBuilder;

	public JsonOutputPrinter(final Form form, final Variables variables) {
		super(form, variables);
		this.indent = 0;
	}

	private void bracket() throws IOException {
		this.outputBuilder.write('{');
		this.indent++;
		this.newLine();
	}

	private void closeBracket() throws IOException {
		this.indent--;
		this.newLine();
		this.outputBuilder.write('}');
	}

	private void commaNewLine() throws IOException {
		this.outputBuilder.write(',');
		this.newLine();
	}

	private String getStringLiteral(final String value) {
		return String.format("\"%s\"", value);
	}

	private void newLine() throws IOException {
		this.outputBuilder.write('\n');
		for (int i = 0; i < this.indent; i++) {
			this.outputBuilder.write('\t');
		}
	}

	@Override
	public void printCurrentState(final Writer writer) throws IOException {
		this.outputBuilder = writer;
		this.bracket();
		this.stringLiteral("form");
		this.outputBuilder.write(": ");
		this.bracket();
		this.variableWithValue("title",
				this.getStringLiteral(this.getFormName()));
		this.commaNewLine();
		this.stringLiteral("results");
		this.outputBuilder.write(": ");
		this.bracket();
		final Variables variables = this.getVariables();
		boolean first = true;
		for (final Identifier identifier : variables.getIdentifiers()) {
			if (first) {
				first = false;
			} else {
				this.commaNewLine();
			}

			final Variable variable = variables.get(identifier);
			final Value value = variable.getValue();
			final Type type = value.getType();
			this.variableWithValue(identifier.getName(),
					type.accept(this, value));

		}
		this.closeBracket();
		this.closeBracket();
		this.closeBracket();
	}

	private void stringLiteral(final String string) throws IOException {
		this.outputBuilder.write('"');
		this.outputBuilder.write(string);
		this.outputBuilder.write('"');
	}

	private void variableWithValue(final String key, final String value)
			throws IOException {
		this.stringLiteral(key);
		this.outputBuilder.write(": ");
		this.outputBuilder.write(value);

	}

	@Override
	public String visit(final BooleanType element, final Value arg) {
		return arg.getValue().toString();
	}

	@Override
	public String visit(final IntegerType element, final Value arg) {
		return String.format("\"%s\"", arg.getValue().toString());
	}

	@Override
	public String visit(final MoneyType element, final Value arg) {
		return arg.getValue().toString();
	}

	@Override
	public String visit(final StringType element, final Value arg) {
		return arg.getValue().toString();
	}

	@Override
	public String visit(final UnknownType element, final Value arg) {
		return "undefined";
	}

}
