package org.uva.sea.ql.gui;

import static julius.validation.Assertions.state;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import org.jpatterns.gof.VisitorPattern.Visitor;
import org.uva.sea.ql.ast.exp.Bools;
import org.uva.sea.ql.ast.exp.Expression;
import org.uva.sea.ql.ast.exp.Identifier;
import org.uva.sea.ql.ast.exp.Nature;
import org.uva.sea.ql.ast.stm.Block;
import org.uva.sea.ql.ast.stm.CompoundStatement;
import org.uva.sea.ql.ast.stm.Computed;
import org.uva.sea.ql.ast.stm.Form;
import org.uva.sea.ql.ast.stm.IfElseStatement;
import org.uva.sea.ql.ast.stm.IfStatement;
import org.uva.sea.ql.ast.stm.Question;
import org.uva.sea.ql.ast.value.BooleanValue;
import org.uva.sea.ql.ast.value.Value;
import org.uva.sea.ql.lead.LogPrinter;
import org.uva.sea.ql.lead.Model;
import org.uva.sea.ql.lead.ModelChangeListener;
import org.uva.sea.ql.visitor.ExpressionEvaluator;
import org.uva.sea.ql.visitor.ExpressionEvaluator.UnmodifiedException;
import org.uva.sea.ql.visitor.StatementVisitor;

/**
 * This creator class functions as a visitor to create visual objects for the form.
 * 
 */
@Visitor
public class QLNodeVisitor implements StatementVisitor<Node> {

	private static final String INPUT_STYLE = "input";
	private static final String QUESTION_STYLE = "question";

	private final Model model;
	private final ExpressionEvaluator expressionEvaluator;

	/**
	 * @param model
	 *            (not null)
	 */
	public QLNodeVisitor(final Model model) {
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
		final Identifier identifier = computed.getIdentifier();
		state.assertNotNull(model.getComputed(identifier), identifier
				+ " not registered at model.");

		final Label valueText = createText(computed.getIdentifier().getName());

		String value = "";
		if (isExpressionEvaluatable(computed)) {
			value = evaluateAndGetValue(computed.getExpression());
		}

		model.addListener(identifier, new ModelChangeListener() {

			@Override
			public void changed(final Expression expression) {
				if (isExpressionEvaluatable(computed)) {
					String newVal = evaluateAndGetValue(computed
							.getExpression());
					valueText.setText(newVal);
					LogPrinter.debugInfo("update recieved: " + expression);
				}
			}
		});

		valueText.setText(value);

		return createHorizontalHolder(createText(identifier.getName() + " :"),
				valueText);
	}

	protected boolean isExpressionEvaluatable(final Computed computed) {
		try {
			computed.getExpression().accept(expressionEvaluator);
		} catch (UnmodifiedException e) {
			LogPrinter.debugInfo(computed.getIdentifier()
					+ " cannot be evaluated yet.");
			return false;
		}

		return true;
	}

	@Override
	public Node visit(final IfStatement ifStatement) {
		final Node drawable = ifStatement.getIfCompound().accept(this);
		final Group holder = new Group();
		final Expression exp = ifStatement.getExpression();

		model.addListener(exp, new ModelChangeListener() {

			@Override
			public void changed(final Expression expression) {
				if (exp.equals(expression)) {
					handleVisibility(holder, drawable, isTrueInModel(exp));
				}
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

	private boolean isTrueInModel(final Expression expression) {
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

		final Expression exp = ifElse.getExpression();

		model.addListener(exp, new ModelChangeListener() {

			@Override
			public void changed(final Expression expression) {
				if (exp.equals(expression)) {
					handleIfElseVisibility(exp, holder, ifNode, elseNode);
				}
			}

		});

		handleIfElseVisibility(exp, holder, ifNode, elseNode);
		return holder;
	}

	private void handleIfElseVisibility(final Expression exp,
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
		Nature nature = question.getDataType().getNature();

		if (nature.equals(new Bools())) {
			return createYesNoQuestion(question);
		} else {
			return createOpenQuestion(question);
		}

	}

	private Node createOpenQuestion(final Question question) {
		final TextField input = new TextField();
		input.setPrefColumnCount(20);
		input.getStyleClass().add(INPUT_STYLE);

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

		if (nature.isValidInput(newInput)) {

			Computed computed = new Computed(question.getDataType(),
					question.getIdentifier(), nature.createValue(newInput));

			model.registerComputed(computed);

		} else if (newInput.isEmpty()) {
			input.clear();
		} else {
			input.setText(oldInput);
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

	private Node createHorizontalHolder(final Node header, final Node inputNode) {
		GridPane holder = new GridPane();

		holder.getColumnConstraints().add(new ColumnConstraints(300));
		holder.getStyleClass().add(QUESTION_STYLE);

		holder.add(header, 0, 0);
		holder.add(inputNode, 1, 0);

		return holder;
	}

	private Label createText(final String text) {
		return new Label(text);
	}

	/**
	 * 
	 * @param expression
	 * @return
	 */
	private String evaluateAndGetValue(final Expression expression) {
		Value value = expression.accept(expressionEvaluator);
		state.assertNotNull(value, "Value does not exist yet.");

		return value.getAsString();
	}
}
