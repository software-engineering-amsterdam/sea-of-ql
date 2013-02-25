package org.uva.sea.ql.runtime.ui.swing;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.statements.ComputedQuestion;
import org.uva.sea.ql.ast.statements.If;
import org.uva.sea.ql.ast.statements.IfElse;
import org.uva.sea.ql.ast.statements.InputQuestion;
import org.uva.sea.ql.ast.statements.Statement;
import org.uva.sea.ql.ast.statements.Statements;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.runtime.JsonOutputPrinter;
import org.uva.sea.ql.runtime.OutputPrinter;
import org.uva.sea.ql.runtime.Variable;
import org.uva.sea.ql.runtime.Variables;
import org.uva.sea.ql.runtime.ui.IUserInterfaceFactory;
import org.uva.sea.ql.runtime.ui.IWindow;
import org.uva.sea.ql.typechecking.ITypeResolver;
import org.uva.sea.ql.visitor.IParametrizedTypeVisitor;
import org.uva.sea.ql.visitor.IStatementVisitor;

public class SwingUserInterfaceFactory implements IUserInterfaceFactory,
		IStatementVisitor {

	private final IParametrizedTypeVisitor<Variable, JComponent> readOnlyComponentFactory = new ReadOnlyComponentFactory();
	private final IParametrizedTypeVisitor<Variable, JComponent> writeOnlyComponentFactory = new WriteOnlyComponentFactory();
	ITypeResolver typeResolver;
	private Container currentPane;
	private final Variables variables;

	public SwingUserInterfaceFactory(final ITypeResolver typeResolver,
			final Variables variables) {
		this.typeResolver = typeResolver;
		this.variables = variables;
	}

	@Override
	public IWindow create(final Form form) {
		final JFrame result = new JFrame();

		result.setTitle(form.getName());
		this.currentPane = result.getContentPane();
		this.currentPane.setLayout(new BorderLayout());
		this.createScrollPane();
		form.getBody().accept(this);
		final OutputPrinter printer = new JsonOutputPrinter(form,
				this.variables);
		result.getContentPane().add(
				new SaveButton(printer).getUnderlyingComponent(),
				BorderLayout.SOUTH);
		return new SwingWindow(result);
	}

	private Component createQuestionUserInterface(final String name,
			final JComponent field) {
		final JPanel container = new JPanel();
		container.setAlignmentX(Component.RIGHT_ALIGNMENT);
		container.setLayout(new BorderLayout(0, 0));
		// need html to have line breaks in labels
		final JLabel questionLabel = new JLabel(String.format(
				"<html>%s</html>", name));
		questionLabel.setHorizontalAlignment(SwingConstants.LEFT);
		questionLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		container.add(questionLabel, BorderLayout.CENTER);
		field.setPreferredSize(new Dimension(150, 0));
		container.add(field, BorderLayout.EAST);
		return container;
	}

	private void createScrollPane() {
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		final JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		this.currentPane.add(scrollPane, BorderLayout.CENTER);
		this.currentPane = panel;
	}

	@Override
	public void visit(final ComputedQuestion element) {
		final Type type = this.typeResolver.getType(element.getExpression());
		final Variable variable = this.variables.get(element);
		final JComponent display = type.accept(this.readOnlyComponentFactory,
				variable);
		this.currentPane.add(this.createQuestionUserInterface(
				element.getQuestion(), display));
	}

	@Override
	public void visit(final If element) {
		this.visitIfStatement(element);
	}

	@Override
	public void visit(final IfElse element) {
		this.visitIfStatement(element);
		final Variable variable = this.variables.get(element);
		final Container parentContainer = this.currentPane;
		final SwingPanel elsePanel = new SwingElsePanel(variable);
		parentContainer.add(elsePanel.getUnderlyingComponent());
		this.currentPane = elsePanel.getUnderlyingComponent();
		element.getElseBody().accept(this);
		this.currentPane = parentContainer;
	}

	@Override
	public void visit(final InputQuestion element) {
		final Type type = element.getType();
		final Variable variable = this.variables.get(element);
		final JComponent editor = type.accept(this.writeOnlyComponentFactory,
				variable);
		this.currentPane.add(this.createQuestionUserInterface(
				element.getQuestion(), editor));
	}

	@Override
	public void visit(final Statements element) {
		for (final Statement s : element) {
			s.accept(this);
		}

	}

	private void visitIfStatement(final If element) {
		final Variable variable = this.variables.get(element);
		final Container parentContainer = this.currentPane;
		final SwingPanel panel = new SwingIfPanel(variable);
		parentContainer.add(panel.getUnderlyingComponent());
		this.currentPane = panel.getUnderlyingComponent();
		element.getIfBody().accept(this);
		this.currentPane = parentContainer;
	}
}
