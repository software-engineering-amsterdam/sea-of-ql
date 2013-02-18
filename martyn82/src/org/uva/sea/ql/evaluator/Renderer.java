package org.uva.sea.ql.evaluator;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashSet;
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
import org.uva.sea.ql.evaluator.environment.ValueEnvironment;
import org.uva.sea.ql.ui.ControlEvent;
import org.uva.sea.ql.ui.ControlEventListener;
import org.uva.sea.ql.ui.ControlFactory;
import org.uva.sea.ql.ui.control.ButtonControl;
import org.uva.sea.ql.ui.control.Control;
import org.uva.sea.ql.ui.control.PanelControl;
import org.uva.sea.ql.value.BooleanValue;
import org.uva.sea.ql.value.Value;
import org.uva.sea.ql.visitor.StatementVisitor;
import org.uva.sea.ql.visitor.TypeVisitor;

public class Renderer implements StatementVisitor<Void>, TypeVisitor<Control> {
	private final static String SUBMIT_TEXT = "Save";

	private final ControlFactory factory;
	private final PanelControl panel;
	private final ValueEnvironment environment;

	public static PanelControl render( Statement statement, ControlFactory factory ) {
		return render( statement, new ValueEnvironment(), factory );
	}

	protected static PanelControl render( Statement statement, ValueEnvironment environment, ControlFactory factory ) {
		Renderer renderer = new Renderer( environment, factory );
		statement.accept( renderer );
		return renderer.getPanel();
	}

	private Renderer( ValueEnvironment environment, ControlFactory factory ) {
		this.environment = environment;
		this.factory = factory;
		this.panel = this.factory.createPanel();
	}

	private PanelControl getPanel() {
		return this.panel;
	}

	private void addControl( Control control ) {
		this.panel.add( control );
	}

	private void addLabel( String label ) {
		this.addControl( this.factory.createLabel( label ) );
	}

	private void addSubmitButton() {
		ButtonControl button = this.factory.createButton( SUBMIT_TEXT );

		button.addChangeListener(
			new ControlEventListener() {
				@Override
				public void itemChanged( ControlEvent event ) {
					String dateString = DateFormat.getDateTimeInstance().format( new Date() ).replace( ':', '_' );

					Exporter exporter = new XmlExporter( panel.getName(), environment.getBindings() );
					exporter.export( System.getProperty( "user.dir" ) + "/formdata/" + dateString + ".xml" );
				}
			}
		);
		this.addControl( button );
	}

	private Control createEditableControlFromType( Type type, Value value ) {
		return this.createControlFromType( type, value, true );
	}

	private Control createReadOnlyControlFromType( Type type, Value value ) {
		return this.createControlFromType( type, value, false );
	}

	private Control createControlFromType( Type type, Value value, boolean editable ) {
		Control control = type.accept( this );
		control.setEnabled( editable );
		control.setValue( value );
		return control;
	}

	private void registerControlHandler( final QuestionDeclaration question, final Control control ) {
		control.addChangeListener(
			new ControlEventListener() {
				@Override
				public void itemChanged( ControlEvent event ) {
					environment.assign( question.getIdentifier(), control.getValue() );
					environment.notifyObservers( question.getIdentifier() );
				}
			}
		);
	}

	private void registerConditionObservers( Expression expression, PanelControl ifTrue, PanelControl ifFalse ) {
		Observer observer = new ConditionObserver( expression, this.environment, ifTrue, ifFalse );
		this.registerDependencies( observer, expression );
	}

	private void registerComputedObservers( final ComputedQuestion question, final Control control ) {
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
	public Void visit( IfThen node ) {
		Value conditionValue = Evaluator.evaluate( node.getCondition(), this.environment );
		boolean condition = conditionValue.isDefined() ? ( (BooleanValue) conditionValue ).getValue() : false;

		PanelControl truePanel = render( node.getBody(), this.environment, this.factory );
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
		Value conditionValue = Evaluator.evaluate( node.getCondition(), this.environment );
		boolean condition = conditionValue.isDefined() ? ( (BooleanValue) conditionValue ).getValue() : false;

		PanelControl truePanel = render( node.getBody(), this.environment, this.factory );
		PanelControl falsePanel = render( node.getElse(), this.environment, this.factory );

		truePanel.setVisible( condition );
		falsePanel.setVisible( !condition );

		this.addControl( truePanel );
		this.addControl( falsePanel );

		this.registerConditionObservers( node.getCondition(), truePanel, falsePanel );

		return null;
	}

	@Override
	public Void visit( VariableDeclaration node ) {
		Value value = TypeInitializer.initType( node.getType() );
		this.environment.assign( node.getIdentifier(), value );

		return null;
	}

	@Override
	public Void visit( Assignment node ) {
		Value value = Evaluator.evaluate( node.getExpression(), this.environment );
		this.environment.assign( node.getIdentifier(), value );

		return null;
	}

	@Override
	public Void visit( FormDeclaration node ) {
		PanelControl formPanel = render( node.getBody(), this.environment, this.factory );
		this.addControl( formPanel );

		this.panel.setName( node.getLabel() );
		this.addSubmitButton();

		return null;
	}

	@Override
	public Void visit( VariableQuestion node ) {
		node.getVarDeclaration().accept( this );

		Type type = node.getType();
		Value value = TypeInitializer.initType( type );

		String label = node.getLabel().getValue();
		Control control = this.createEditableControlFromType( type, value );

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
		Control control = this.createReadOnlyControlFromType( type, value );

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

	@Override
	public Control visit( BooleanType node ) {
		return this.factory.createCheckBox();
	}

	@Override
	public Control visit( IntegerType node ) {
		return this.factory.createNumberBox();
	}

	@Override
	public Control visit( StringType node ) {
		return this.factory.createTextBox();
	}

	@Override
	public Control visit( MoneyType node ) {
		return this.factory.createMoneyBox();
	}
}
