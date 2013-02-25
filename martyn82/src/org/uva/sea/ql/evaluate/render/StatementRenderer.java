package org.uva.sea.ql.evaluate.render;

import org.uva.sea.ql.ast.statement.Assignment;
import org.uva.sea.ql.ast.statement.ComputedQuestion;
import org.uva.sea.ql.ast.statement.FormDeclaration;
import org.uva.sea.ql.ast.statement.IfThen;
import org.uva.sea.ql.ast.statement.IfThenElse;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.ast.statement.Statements;
import org.uva.sea.ql.ast.statement.VariableDeclaration;
import org.uva.sea.ql.ast.statement.VariableQuestion;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ui.ControlFactory;
import org.uva.sea.ql.ui.control.InputControl;
import org.uva.sea.ql.ui.control.PanelControl;
import org.uva.sea.ql.value.BooleanValue;
import org.uva.sea.ql.value.Value;
import org.uva.sea.ql.visitor.StatementVisitor;

class StatementRenderer implements StatementVisitor<Void> {
	private final BindingEnvironment environment;
	private final FormBuilder builder;

	public StatementRenderer( ControlFactory factory, BindingEnvironment environment ) {
		this.builder = new FormBuilder( factory, environment );
		this.environment = environment;
	}

	protected static PanelControl renderPart( Statement statement, FormBuilder builder, BindingEnvironment environment ) {
		StatementRenderer renderer = new StatementRenderer( builder.getFactory(), environment );
		statement.accept( renderer );
		return renderer.builder.getResult();
	}

	protected ValueMap getValues() {
		return this.environment.getValueMap();
	}

	public PanelControl getPanel() {
		return this.builder.getResult();
	}

	@Override
	public Void visit( IfThen node ) {
		Value conditionValue = ExpressionEvaluator.evaluate( node.getCondition(), this.environment );
		boolean condition = conditionValue.isDefined() ? ( (BooleanValue) conditionValue ).getValue() : false;

		PanelControl truePanel = renderPart( node.getBody(), this.builder, this.environment );
		truePanel.setVisible( condition );

		this.builder.addControl( truePanel );
		this.builder.registerConditionObservers( node.getCondition(), truePanel );

		return null;
	}

	@Override
	public Void visit( IfThenElse node ) {
		Value conditionValue = ExpressionEvaluator.evaluate( node.getCondition(), this.environment );
		boolean condition = conditionValue.isDefined() ? ( (BooleanValue) conditionValue ).getValue() : false;

		PanelControl truePanel = renderPart( node.getBody(), this.builder, this.environment );
		PanelControl falsePanel = renderPart( node.getElse(), this.builder, this.environment );

		truePanel.setVisible( condition );
		falsePanel.setVisible( !condition );

		this.builder.addControl( truePanel );
		this.builder.addControl( falsePanel );

		this.builder.registerConditionObservers( node.getCondition(), truePanel, falsePanel );

		return null;
	}

	@Override
	public Void visit( VariableDeclaration node ) {
		Value value = TypeEvaluator.initType( node.getType() );
		this.environment.declare( node.getIdentifier(), value );

		return null;
	}

	@Override
	public Void visit( Assignment node ) {
		Value value = ExpressionEvaluator.evaluate( node.getExpression(), this.environment );
		this.environment.declare( node.getIdentifier(), value );

		return null;
	}

	@Override
	public Void visit( FormDeclaration node ) {
		PanelControl formPanel = renderPart( node.getBody(), this.builder, this.environment );
		formPanel.setName( node.getLabel() );

		this.builder.addControl( formPanel );
		return null;
	}

	@Override
	public Void visit( VariableQuestion node ) {
		node.getVariableDeclaration().accept( this );

		Type type = node.getType();
		Value value = TypeEvaluator.initType( type );

		String label = node.getLabel().getValue();
		InputControl control = this.builder.createEditableControlFromType( type, value );

		this.builder.addLabel( label );
		this.builder.addControl( control );

		this.builder.registerControlHandler( node, control );

		return null;
	}

	@Override
	public Void visit( ComputedQuestion node ) {
		node.getAssignment().accept( this );

		Value value = this.environment.lookup( node.getIdentifier() );
		Type type = value.getType();

		String label = node.getLabel().getValue();
		InputControl control = this.builder.createReadOnlyControlFromType( type, value );

		this.builder.addLabel( label );
		this.builder.addControl( control );

		this.builder.registerComputedObservers( node, control );
		this.builder.registerControlHandler( node, control );

		return null;
	}

	@Override
	public Void visit( Statements node ) {
		for ( Statement statement : node ) {
			statement.accept( this );
		}

		return null;
	}
}
