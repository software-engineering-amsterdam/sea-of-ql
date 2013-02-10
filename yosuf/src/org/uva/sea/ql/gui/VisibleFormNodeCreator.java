package org.uva.sea.ql.gui;

import static julius.validation.Assertions.state;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import org.uva.sea.ql.ast.Natural;
import org.uva.sea.ql.ast.exp.Expression.Nature;
import org.uva.sea.ql.ast.stm.CompoundStatement;
import org.uva.sea.ql.ast.stm.Computed;
import org.uva.sea.ql.ast.stm.Form;
import org.uva.sea.ql.ast.stm.IfElseStatement;
import org.uva.sea.ql.ast.stm.IfStatement;
import org.uva.sea.ql.ast.stm.Question;
import org.uva.sea.ql.ast.stm.Statement;
import org.uva.sea.ql.visitor.StatementVisitor;

public class VisibleFormNodeCreator implements StatementVisitor<Node> {

	// Model model;
	// ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator(model);

	@Override
	public Node visit(final Form form) {
		return form.getBody().accept(this);
	}

	@Override
	public Node visit(final CompoundStatement compoundStatement) {
		VBox vBox = new VBox();

		for (Statement statement : compoundStatement.getStatements()) {
			vBox.getChildren().add(statement.accept(this));
		}
		return vBox;
	}

	@Override
	public Node visit(final Computed computed) {
		HBox hBox = createHBox();
		hBox.getChildren().add(createInteractiveNode(computed.getDataType()));

		return hBox;
	}

	@Override
	public Node visit(final IfStatement ifStatement) {
		// TODO bind the expression
		ifStatement.getExpression();

		Node node = ifStatement.getIfCompound().accept(this);

		return node;
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
		HBox hBox = createHBox();

		hBox.getChildren().add(
				createText(question.getQuestionText().getValue()));
		hBox.getChildren().add(createInteractiveNode(question.getDataType()));

		return hBox;
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

}
