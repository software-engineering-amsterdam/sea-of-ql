package org.uva.sea.ql.evaluate.render;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Observer;
import java.util.Set;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.IdentifierExpression;
import org.uva.sea.ql.ast.statement.Assignment;
import org.uva.sea.ql.ast.statement.ComputedQuestion;
import org.uva.sea.ql.ast.statement.FormDeclaration;
import org.uva.sea.ql.ast.statement.IfThen;
import org.uva.sea.ql.ast.statement.IfThenElse;
import org.uva.sea.ql.ast.statement.QuestionDeclaration;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.ast.statement.Statements;
import org.uva.sea.ql.ast.statement.VariableDeclaration;
import org.uva.sea.ql.ast.statement.VariableQuestion;
import org.uva.sea.ql.ast.type.BooleanType;
import org.uva.sea.ql.ast.type.IntegerType;
import org.uva.sea.ql.ast.type.MoneyType;
import org.uva.sea.ql.ast.type.StringType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ui.ControlEvent;
import org.uva.sea.ql.ui.ControlFactory;
import org.uva.sea.ql.ui.InputControlEventListener;
import org.uva.sea.ql.ui.control.Control;
import org.uva.sea.ql.ui.control.InputControl;
import org.uva.sea.ql.ui.control.PanelControl;
import org.uva.sea.ql.value.BooleanValue;
import org.uva.sea.ql.value.Value;
import org.uva.sea.ql.visitor.StatementVisitor;
import org.uva.sea.ql.visitor.TypeVisitor;

class Renderer implements StatementVisitor<Void>, TypeVisitor<InputControl> {
	private final BindingEnvironment environment;
	private final ControlFactory factory;
	private final PanelControl panel;

	public Renderer( ControlFactory factory, BindingEnvironment environment ) {
		this.factory = factory;
		this.environment = environment;
		this.panel = this.factory.createPanel();
	}

	protected static PanelControl createPart(
		Statement statement, BindingEnvironment environment, ControlFactory factory
	) {
		Renderer renderer = new Renderer( factory, environment );
		statement.accept( renderer );
		return renderer.panel;
	}

	public Map<String, Binding> getBoundValues() {
		Map<IdentifierExpression, Binding> bindings = this.environment.getBindings();
		Map<String, Binding> result = new HashMap<String, Binding>();

		for ( Map.Entry<IdentifierExpression, Binding> each : bindings.entrySet() ) {
			result.put( each.getKey().getName(), each.getValue() );
		}

		return result;
	}

	public PanelControl getPanel() {
		return this.panel;
	}

	public void addControl( Control control ) {
		this.panel.add( control );
	}

	private void addLabel( String label ) {
		this.addControl( this.factory.createLabel( label ) );
	}

	private InputControl createEditableControlFromType( Type type, Value value ) {
		return this.createControlFromType( type, value, true );
	}

	private InputControl createReadOnlyControlFromType( Type type, Value value ) {
		return this.createControlFromType( type, value, false );
	}

	private InputControl createControlFromType( Type type, Value value, boolean editable ) {
		InputControl control = type.accept( this );
		control.setEnabled( editable );
		control.setValue( value );
		return control;
	}

	private void registerControlHandler( final QuestionDeclaration question, final InputControl control ) {
		control.addChangeListener(
			new InputControlEventListener() {
				@Override
				public void valueChanged( ControlEvent event ) {
					environment.declare( question.getIdentifier(), control.getValue() );
					environment.notifyObservers( question.getIdentifier() );
				}
			}
		);
	}

	private void registerConditionObservers( Expression expression, PanelControl ifTrue, PanelControl ifFalse ) {
		Observer observer = new ConditionObserver( expression, this.environment, ifTrue, ifFalse );
		this.registerDependencies( observer, expression );
	}

	private void registerComputedObservers( ComputedQuestion question, InputControl control ) {
		Observer observer = new ComputedObserver( control, this.environment, question );
		this.registerDependencies( observer, question.getExpression() );
	}

	private void registerDependencies( Observer observer, Expression expression ) {
		Set<IdentifierExpression> dependencies = new HashSet<IdentifierExpression>();
		DependencyFinder.findDependencies( expression, dependencies );

		for ( IdentifierExpression identifier : dependencies ) {
			this.environment.registerObserver( identifier, observer );
		}
	}

	@Override
	public InputControl visit( BooleanType node ) {
		return this.factory.createCheckBox();
	}

	@Override
	public InputControl visit( IntegerType node ) {
		return this.factory.createNumberBox();
	}

	@Override
	public InputControl visit( StringType node ) {
		return this.factory.createTextBox();
	}

	@Override
	public InputControl visit( MoneyType node ) {
		return this.factory.createMoneyBox();
	}

	@Override
	public Void visit( IfThen node ) {
		Value conditionValue = ExpressionEvaluator.evaluate( node.getCondition(), this.environment );
		boolean condition = conditionValue.isDefined() ? ( (BooleanValue) conditionValue ).getValue() : false;

		PanelControl truePanel = createPart( node.getBody(), this.environment, this.factory );
		PanelControl falsePanel = this.factory.createPanel();

		truePanel.setVisible( condition );
		falsePanel.setVisible( !condition );

		this.addControl( truePanel );
		this.addControl( falsePanel );

		this.registerConditionObservers( node.getCondition(), truePanel, falsePanel );

		return null;
	}

	@Override
	public Void visit( IfThenElse node ) {
		Value conditionValue = ExpressionEvaluator.evaluate( node.getCondition(), this.environment );
		boolean condition = conditionValue.isDefined() ? ( (BooleanValue) conditionValue ).getValue() : false;

		PanelControl truePanel = createPart( node.getBody(), this.environment, this.factory );
		PanelControl falsePanel = createPart( node.getElse(), this.environment, this.factory );

		truePanel.setVisible( condition );
		falsePanel.setVisible( !condition );

		this.addControl( truePanel );
		this.addControl( falsePanel );

		this.registerConditionObservers( node.getCondition(), truePanel, falsePanel );

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
		PanelControl formPanel = createPart( node.getBody(), this.environment, this.factory );

		this.addControl( formPanel );
		this.panel.setName( node.getLabel() );

		return null;
	}

	@Override
	public Void visit( VariableQuestion node ) {
		node.getVariableDeclaration().accept( this );

		Type type = node.getType();
		Value value = TypeEvaluator.initType( type );

		String label = node.getLabel().getValue();
		InputControl control = this.createEditableControlFromType( type, value );

		this.addLabel( label );
		this.addControl( control );

		this.registerControlHandler( node, control );

		return null;
	}

	@Override
	public Void visit( ComputedQuestion node ) {
		node.getAssignment().accept( this );

		Value value = this.environment.lookup( node.getIdentifier() );
		Type type = value.getType();

		String label = node.getLabel().getValue();
		InputControl control = this.createReadOnlyControlFromType( type, value );

		this.addLabel( label );
		this.addControl( control );

		this.registerComputedObservers( node, control );
		this.registerControlHandler( node, control );

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
