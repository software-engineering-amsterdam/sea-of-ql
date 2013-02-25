package org.uva.sea.ql.evaluate.render;

import java.util.HashSet;
import java.util.Observer;
import java.util.Set;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.IdentifierExpression;
import org.uva.sea.ql.ast.statement.ComputedQuestion;
import org.uva.sea.ql.ast.statement.QuestionDeclaration;
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
import org.uva.sea.ql.value.Value;
import org.uva.sea.ql.visitor.TypeVisitor;

class FormBuilder implements TypeVisitor<InputControl> {
	private final ControlFactory factory;
	private final PanelControl panel;
	private final BindingEnvironment environment;

	public FormBuilder( ControlFactory factory, BindingEnvironment environment ) {
		this.environment = environment;
		this.factory = factory;
		this.panel = this.factory.createPanel();
	}

	public ControlFactory getFactory() {
		return this.factory;
	}

	public PanelControl getResult() {
		return this.panel;
	}

	protected void addControl( Control control ) {
		this.panel.addControl( control );
	}

	public void addLabel( String label ) {
		this.addControl( this.factory.createLabel( label ) );
	}

	public InputControl createEditableControlFromType( Type type, Value value ) {
		return this.createControlFromType( type, value, true );
	}

	public InputControl createReadOnlyControlFromType( Type type, Value value ) {
		return this.createControlFromType( type, value, false );
	}

	private InputControl createControlFromType( Type type, Value value, boolean editable ) {
		InputControl control = type.accept( this );
		control.setEnabled( editable );
		control.setValue( value );
		return control;
	}

	public void registerControlHandler( final QuestionDeclaration question, final InputControl control ) {
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

	public void registerConditionObservers( Expression expression, PanelControl truePanel ) {
		this.registerConditionObservers( expression, truePanel, this.factory.createPanel() );
	}

	public void registerConditionObservers( Expression expression, PanelControl truePanel, PanelControl falsePanel ) {
		Observer observer = new ConditionObserver( expression, this.environment, truePanel, falsePanel );
		this.registerDependencies( observer, expression );
	}

	public void registerComputedObservers( ComputedQuestion question, InputControl control ) {
		Observer observer = new ComputedObserver( control, this.environment, question );
		this.registerDependencies( observer, question.getExpression() );
	}

	public void registerDependencies( Observer observer, Expression expression ) {
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
}
