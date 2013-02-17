package org.uva.sea.ql.gui;

import static julius.validation.Assertions.checked;
import static julius.validation.Assertions.state;
import static org.uva.sea.ql.gui.TranslationUtil.createExpression;
import static org.uva.sea.ql.gui.TranslationUtil.isValidUserInput;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import julius.validation.ValidationException;

import org.jpatterns.gof.VisitorPattern.Visitor;
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

/**
 * This creator class functions as a visitor to create visual objects for the form.
 * 
 */
@Visitor
public class VisibleFormNodeCreator implements StatementVisitor<Node> {

	private static final String QUESTION_STYLE = "question";

	Model model;

	ExpressionEvaluator expressionEvaluator;

	/**
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
		Group holder = new Group();

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
		holder.getChildren().add(text);

		return holder;
	}

	@Override
	public Node visit(final IfStatement ifStatement) {
		final Node drawable = ifStatement.getIfCompound().accept(this);
		final Group holder = new Group();
		final Expression<?> exp = ifStatement.getExpression();

		model.addListener(exp, new ModelChangeListener() {

			@Override
			public void changed(final Expression<?> expression) {
				handleVisibility(holder, drawable, isTrueInModel(exp));
			}
		});

		handleVisibility(holder, drawable, isTrueInModel(exp));
		return holder;
	}

	private void handleVisibility(final Group holder, final Node drawable,
			final boolean isVisible) {

		if (isVisible) {
			holder.getChildren().add(drawable);
		} else {
			holder.getChildren().remove(drawable);
		}
	}

	private boolean isTrueInModel(final Expression<?> expression) {
		Computed comp = model.getComputed(expression);
		if (comp != null
				&& ((BooleanValue) comp.getExpression().accept(
						expressionEvaluator)).getValue()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Node visit(final IfElseStatement ifElse) {
		final Group holder = new Group();
		final Node ifNode = ifElse.getIfCompound().accept(this);
		final Node elseNode = ifElse.getElseCompound().accept(this);

		final Expression<?> exp = ifElse.getExpression();

		model.addListener(exp, new ModelChangeListener() {

			@Override
			public void changed(final Expression<?> expression) {
				handleIfElseVisibility(exp, holder, ifNode, elseNode);
			}

		});

		handleIfElseVisibility(exp, holder, ifNode, elseNode);
		return holder;
	}

	private void handleIfElseVisibility(final Expression<?> exp,
			final Group holder, final Node ifNode, final Node elseNode) {
		if (isTrueInModel(exp)) {
			handleVisibility(holder, ifNode, true);
			handleVisibility(holder, elseNode, false);
		} else {
			handleVisibility(holder, ifNode, false);
			handleVisibility(holder, elseNode, true);
		}
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

	private Node createOpenQuestion(final Question question) {
		final TextField input = new TextField();
		input.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(final ObservableValue<? extends String> arg0,
					final String oldVal, final String newVal) {

				handleUserInput(question, input, oldVal, newVal);
			}
		});
		return createHorizontalHolder(createText(question.getText()), input);
	}

	private void handleUserInput(final Question question,
			final TextField input, final String oldInput, final String newInput) {
		Nature nature = question.getDataType().getNature();

		if (isValidUserInput(nature, newInput)) {
			Computed computed = new Computed(question.getDataType(),
					question.getIdentifier(),
					createExpression(nature, newInput));
			model.registerComputed(computed);

		} else if (!newInput.isEmpty()) {
			input.setText(oldInput);
		} else {
			input.clear();
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

	/**
	 * TODO: This could be moved to {@link TranslationUtil}
	 * 
	 * @param nature
	 * @param expression
	 * @return
	 * @throws ValidationException
	 */
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
