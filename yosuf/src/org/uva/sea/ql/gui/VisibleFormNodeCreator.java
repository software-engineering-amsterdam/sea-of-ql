package org.uva.sea.ql.gui;

import static julius.validation.Assertions.checked;
import static julius.validation.Assertions.state;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import julius.validation.ValidationException;

import org.uva.sea.ql.ast.exp.Expression;
import org.uva.sea.ql.ast.exp.Expression.Nature;
import org.uva.sea.ql.ast.stm.Block;
import org.uva.sea.ql.ast.stm.CompoundStatement;
import org.uva.sea.ql.ast.stm.Computed;
import org.uva.sea.ql.ast.stm.Form;
import org.uva.sea.ql.ast.stm.IfElseStatement;
import org.uva.sea.ql.ast.stm.IfStatement;
import org.uva.sea.ql.ast.stm.Question;
import org.uva.sea.ql.ast.value.BooleanValue;
import org.uva.sea.ql.ast.value.IntegerValue;
import org.uva.sea.ql.ast.value.StringValue;
import org.uva.sea.ql.lead.Model;
import org.uva.sea.ql.lead.ModelChangeListener;
import org.uva.sea.ql.visitor.ExpressionEvaluator;
import org.uva.sea.ql.visitor.StatementVisitor;

public class VisibleFormNodeCreator implements StatementVisitor<Node> {

	private static final String QUESTION_STYLE = "question";

	Model model;

	ExpressionEvaluator expressionEvaluator;

	/**
	 * 
	 * @param model
	 *            (not null)
	 */
	public VisibleFormNodeCreator(final Model model) {
		this.model = model;
		state.assertNotNull(this.model, "model");

		expressionEvaluator = new ExpressionEvaluator(model);
	}

	@Override
	public Node visit(final Form form) {
		return form.getBody().accept(this);
	}

	@Override
	public Node visit(final CompoundStatement compoundStatement) {
		VBox vBox = new VBox();

		for (Block statement : compoundStatement.getStatements()) {
			vBox.getChildren().add(statement.accept(this));
		}
		return vBox;
	}

	@Override
	public Node visit(final Computed computed) {
		HBox hBox = createHBox();
		hBox.getStyleClass().add(QUESTION_STYLE);
		String eval = "";

		if (model.getComputed(computed.getIdentifier()) != null) {
			System.out.println("model value: "
					+ model.getComputed(computed.getIdentifier()));
		}
		try {
			eval = getValue(computed.getExpression().getNature(),
					computed.getExpression());

		} catch (Exception e) {
			System.out.println(e);
		}
		Node text = createText(computed.getIdentifier().getName() + " : "
				+ eval);
		hBox.getChildren().add(text);

		return hBox;
	}

	@Override
	public Node visit(final IfStatement ifStatement) {
		final HBox hBox = new HBox();

		final Node drawableStatements = ifStatement.getIfCompound()
				.accept(this);

		final Expression<?> exp = ifStatement.getExpression();

		model.addListener(exp, new ModelChangeListener() {

			@Override
			public void changed(final Expression<?> expression) {
				Computed comp = model.getComputed(exp);
				if (comp.getExpression() != null) {
					BooleanValue val = (BooleanValue) comp.getExpression()
							.accept(expressionEvaluator);
					if (val.getValue()) {
						hBox.getChildren().add(drawableStatements);
					} else {
						hBox.getChildren().remove(drawableStatements);
					}
				} else {
					hBox.getChildren().remove(drawableStatements);
				}
			}
		});

		return hBox;
	}

	@Override
	public Node visit(final IfElseStatement ifElseStatement) {
		// TODO bind the expression
		ifElseStatement.getExpression();

		Node ifNode = ifElseStatement.getIfCompound().accept(this);

		Node elseNode = ifElseStatement.getElseCompound().accept(this);

		return elseNode;
	}

	@Override
	public Node visit(final Question question) {
		state.assertNotNull(question, "question");
		switch (question.getDataType().getNature()) {
		case BOOLEAN:
			return createYesNoQuestion(question);
		case NUMERIC:
		case TEXTUAL:
			return createOpenQuestion(question);
		default:
			throw state.createException("Unsupported nature:"
					+ question.getDataType().getNature());
		}
	}

	private HBox createHBox() {
		HBox hBox = new HBox();
		return hBox;
	}

	private Node createOpenQuestion(final Question question) {
		final TextField input = new TextField();
		input.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(final ObservableValue<? extends String> arg0,
					final String oldVal, final String newVal) {

				handleInput(question, input, oldVal, newVal);
			}
		});
		return createHorizontalHolder(createText(question.getText()), input);
	}

	private void handleInput(final Question question, final TextField input,
			final String oldInput, final String newInput) {
		Nature nature = question.getDataType().getNature();

		if (isValid(nature, newInput)) {

			Computed computed = new Computed(question.getDataType(),
					question.getIdentifier(),
					createExpression(nature, newInput));
			model.registerComputed(computed);

		} else if (isValid(nature, oldInput) && !newInput.isEmpty()) {
			input.setText(oldInput);
		} else {
			input.clear();
		}
	}

	private Expression<?> createExpression(final Nature nature,
			final String value) {
		switch (nature) {
		case NUMERIC:
			return new IntegerValue(Integer.valueOf(value));
		case TEXTUAL:
			return new StringValue(value);
		default:
			throw state
					.createException("Creating other than numeric or textual input should have never been called");
		}
	}

	private boolean isValid(final Nature nature, final String value) {
		switch (nature) {
		case NUMERIC:
			try {
				// the following throws a number format exception if the value is not convertable
				Integer.valueOf(value);
			} catch (NumberFormatException e) {
				return false;
			}
		case TEXTUAL:
			return value != null;
		default:
			return false;
		}
	}

	private Node createYesNoQuestion(final Question question) {
		CheckBox checkBox = new CheckBox();
		checkBox.selectedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(final ObservableValue<? extends Boolean> arg0,
					final Boolean oldVal, final Boolean newVal) {

				Computed computed = new Computed(question.getDataType(),
						question.getIdentifier(), new BooleanValue(newVal));
				model.registerComputed(computed);
			}
		});

		return createHorizontalHolder(createText(question.getText()), checkBox);
	}

	private HBox createHorizontalHolder(final Node... nodes) {
		HBox hBox = new HBox();
		hBox.getStyleClass().add(QUESTION_STYLE);
		hBox.getChildren().addAll(nodes);

		return hBox;
	}

	private Node createText(final String text) {
		return new Label(text);
	}

	private String getValue(final Nature nature, final Expression<?> expression)
			throws ValidationException {
		Expression<?> value = (Expression<?>) expression
				.accept(expressionEvaluator);

		checked.assertNotNull(value, "Expression does not exist yet.");

		switch (nature) {
		case BOOLEAN:
			return String.valueOf(((BooleanValue) value).getValue());
		case NUMERIC:
			return String.valueOf(((IntegerValue) value).getValue());
		case TEXTUAL:
			return ((StringValue) value).getValue();
		default:
			throw state.createException("Error getting value: " + nature + " "
					+ expression);
		}
	}
}
