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

import org.uva.sea.ql.ast.Natural;
import org.uva.sea.ql.ast.exp.Expression;
import org.uva.sea.ql.ast.exp.Expression.Nature;
import org.uva.sea.ql.ast.exp.Identifier;
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

		// hBox.getChildren().add(drawableStatements);

		final Identifier exp = (Identifier) ifStatement.getExpression();
		if (exp != null) {
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

					}
				}
			});

		}

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
		final VBox vBox = new VBox();
		CheckBox testChecker = new CheckBox();

		final HBox hBox = createHBox();

		hBox.getStyleClass().add(QUESTION_STYLE);

		hBox.getChildren().add(createText(question.getText().getValue()));

		Node interactiveNode = createInteractiveNode(question.getDataType());

		// hBox.visibleProperty().bind(testChecker.selectedProperty());
		hBox.getChildren().add(interactiveNode);
		vBox.getChildren().add(hBox);

		if (interactiveNode instanceof CheckBox) {
			((CheckBox) interactiveNode).selectedProperty().addListener(
					new ChangeListener<Boolean>() {

						@Override
						public void changed(
								final ObservableValue<? extends Boolean> arg0,
								final Boolean old, final Boolean neww) {

							Computed computed = new Computed(question
									.getDataType(), question.getIdentifier(),
									new BooleanValue(neww.booleanValue()));
							model.registerComputed(computed);

						}

					});
		}
		return vBox;
		// }

		// hBox.visibleProperty().b

	}

	private HBox createHBox() {
		HBox hBox = new HBox();
		return hBox;
	}

	private Node createInteractiveNode(final Natural natural) {
		Nature nature = natural.getNature();
		switch (nature) {
		case BOOLEAN:
			return new CheckBox();
		case NUMERIC:
		case TEXTUAL:
			return new TextField();

		default:
			throw state.createException("Unsupported nature");
		}
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
