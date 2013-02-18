package org.uva.sea.ql.evaluator;

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
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.evaluator.environment.ValueEnvironment;
import org.uva.sea.ql.ui.ControlEvent;
import org.uva.sea.ql.ui.ControlEventListener;
import org.uva.sea.ql.ui.ControlFactory;
import org.uva.sea.ql.ui.control.Control;
import org.uva.sea.ql.ui.control.PanelControl;
import org.uva.sea.ql.value.BooleanValue;
import org.uva.sea.ql.value.Value;
import org.uva.sea.ql.visitor.StatementVisitor;

public class Renderer implements StatementVisitor<Void> {
	private final ControlFactory factory;
	private final ValueEnvironment environment;
	private final PanelControl panel;
	private final ControlRenderer controlRenderer;

	public static PanelControl render( Statement statement, ControlFactory factory ) {
		Renderer renderer = new Renderer( new ValueEnvironment(), factory );
		statement.accept( renderer );
		return renderer.getPanel();
	}

	protected static PanelControl render( Statement statement, ValueEnvironment environment, ControlFactory factory ) {
		Renderer renderer = new Renderer( environment, factory );
		statement.accept( renderer );
		return renderer.getPanel();
	}

	private Renderer( ValueEnvironment environment, ControlFactory factory ) {
		this.environment = environment;
		this.factory = factory;
		this.controlRenderer = new ControlRenderer( factory );
		this.panel = this.controlRenderer.createPanel();
	}

	private Value initType( Type type ) {
		return TypeInitializer.initType( type );
	}

	private PanelControl getPanel() {
		return this.panel;
	}

	private void addComponent( Control component ) {
		this.panel.add( component );
	}

	private void addLabel( String label ) {
		this.addComponent( this.controlRenderer.createLabel( label ) );
	}

	private void registerHandler( final QuestionDeclaration question, final Control component ) {
		component.addChangeListener( new ControlEventListener() {
			@Override
			public void itemChanged( ControlEvent event ) {
				Control source = event.getSource();
				Value value = source.getValue();

				environment.assign( question.getIdentifier(), value );
				environment.notifyObservers( question.getIdentifier() );
			}
		} );
	}

	private void registerConditionObservers( Expression expression, PanelControl ifTrue, PanelControl ifFalse ) {
		Observer observer = new ConditionObserver( expression, this.environment, ifTrue, ifFalse );
		this.registerDependencies( observer, expression );
	}

	private void registerComputedObservers( final ComputedQuestion question, final Control component ) {
		Observer observer = new ComputedObserver( component, this.environment, question );
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
		boolean condition = ( (BooleanValue) Evaluator.evaluate( node.getCondition(), this.environment ) ).getValue();

		PanelControl truePanel = render( node.getBody(), this.environment, this.factory );
		PanelControl falsePanel = this.controlRenderer.createPanel();

		truePanel.setVisible( condition );
		falsePanel.setVisible( !condition );

		this.addComponent( truePanel );
		this.addComponent( falsePanel );

		this.registerConditionObservers( node.getCondition(), truePanel, falsePanel );

		return null;
	}

	@Override
	public Void visit( IfThenElse node ) {
		boolean condition = ( (BooleanValue) Evaluator.evaluate( node.getCondition(), this.environment ) ).getValue();

		PanelControl truePanel = render( node.getBody(), this.environment, this.factory );
		PanelControl falsePanel = render( node.getElse(), this.environment, this.factory );

		truePanel.setVisible( condition );
		falsePanel.setVisible( !condition );

		this.addComponent( truePanel );
		this.addComponent( falsePanel );

		this.registerConditionObservers( node.getCondition(), truePanel, falsePanel );

		return null;
	}

	@Override
	public Void visit( VariableDeclaration node ) {
		Value value = this.initType( node.getType() );
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
		this.addComponent( formPanel );

		this.panel.setName( node.getLabel() );

		return null;
	}

	@Override
	public Void visit( VariableQuestion node ) {
		node.getVarDeclaration().accept( this );

		Type type = node.getType();
		Value value = this.initType( type );

		String label = node.getLabel().getValue();
		Control component = this.controlRenderer.createEditableControlFromType( type, value );

		this.addLabel( label );
		this.addComponent( component );

		this.registerHandler( node, component );

		return null;
	}

	@Override
	public Void visit( ComputedQuestion node ) {
		node.getAssignment().accept( this );

		Value value = this.environment.lookup( node.getIdentifier() );
		Type type = value.getType();

		String label = node.getLabel().getValue();
		Control component = this.controlRenderer.createReadOnlyControlFromType( type, value );

		this.addLabel( label );
		this.addComponent( component );

		this.registerComputedObservers( node, component );
		this.registerHandler( node, component );

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
