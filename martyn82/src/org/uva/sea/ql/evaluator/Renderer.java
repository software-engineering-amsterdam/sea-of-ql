package org.uva.sea.ql.evaluator;

import java.util.LinkedList;

import org.uva.sea.ql.Observable;
import org.uva.sea.ql.Observer;
import org.uva.sea.ql.ast.expression.BinaryExpression;
import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.UnaryExpression;
import org.uva.sea.ql.ast.statement.Assignment;
import org.uva.sea.ql.ast.statement.Else;
import org.uva.sea.ql.ast.statement.ElseIf;
import org.uva.sea.ql.ast.statement.ElseIfs;
import org.uva.sea.ql.ast.statement.FormDeclaration;
import org.uva.sea.ql.ast.statement.IfThenElse;
import org.uva.sea.ql.ast.statement.QuestionComputed;
import org.uva.sea.ql.ast.statement.QuestionDeclaration;
import org.uva.sea.ql.ast.statement.QuestionVar;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.ast.statement.Statements;
import org.uva.sea.ql.ast.statement.VarDeclaration;
import org.uva.sea.ql.ast.type.Bool;
import org.uva.sea.ql.ast.type.Int;
import org.uva.sea.ql.ast.type.Money;
import org.uva.sea.ql.ast.type.Number;
import org.uva.sea.ql.ast.type.Str;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.evaluator.value.Boolean;
import org.uva.sea.ql.evaluator.value.Integer;
import org.uva.sea.ql.evaluator.value.String;
import org.uva.sea.ql.evaluator.value.Undefined;
import org.uva.sea.ql.evaluator.value.Value;
import org.uva.sea.ql.ui.ControlEvent;
import org.uva.sea.ql.ui.ControlEventListener;
import org.uva.sea.ql.ui.ControlFactory;
import org.uva.sea.ql.ui.control.Control;
import org.uva.sea.ql.ui.control.PanelControl;
import org.uva.sea.ql.ui.swing.JPanelControl;
import org.uva.sea.ql.visitor.StatementVisitor;
import org.uva.sea.ql.visitor.TypeVisitor;

/**
 * Evaluator for statement nodes.
 */
public class Renderer implements StatementVisitor<Void>, TypeVisitor<Control> {
	/**
	 * Holds the environment.
	 */
	private final Environment environment;

	/**
	 * Holds the expression evaluator.
	 */
	private final Evaluator expressionEvaluator;

	/**
	 * Holds the type initializer.
	 */
	private final TypeInitializer typeInitializer;

	/**
	 * Holds the working panel.
	 */
	private final PanelControl panel;

	/**
	 * Holds the control factory used to construct control elements.
	 */
	private final ControlFactory factory;

	/**
	 * Renders the given statement.
	 *
	 * @param statement
	 * @param environment
	 * @param factory
	 *
	 * @return Panel resulting from statement.
	 */
	public static PanelControl render( Statement statement, Environment environment, ControlFactory factory ) {
		Renderer renderer = new Renderer( environment, factory );
		statement.accept( renderer );
		return renderer.getPanel();
	}

	/**
	 * Hidden constructor for renderer.
	 *
	 * @param environment
	 * @param factory
	 */
	private Renderer( Environment environment, ControlFactory factory ) {
		this.factory = factory;
		this.environment = environment;
		this.expressionEvaluator = new Evaluator( environment );
		this.typeInitializer = new TypeInitializer();

		this.panel = this.factory.createPanel();
	}

	/**
	 * Retrieves the rendered panel.
	 *
	 * @return The result.
	 */
	private PanelControl getPanel() {
		return this.panel;
	}

	/**
	 * Adds a component to the panel.
	 *
	 * @param component
	 */
	private void addComponent( Control component ) {
		this.panel.add( component );
	}

	/**
	 * Adds a label to the panel.
	 *
	 * @param label
	 */
	private void addLabel( java.lang.String label ) {
		this.addComponent( this.factory.createLabel( label ) );
	}

	/**
	 * Creates a control from given type.
	 *
	 * @param type     The type to determine the control type.
	 * @param value    The value of the control.
	 * @param editable Whether the control is editable by the user.
	 *
	 * @return The control.
	 */
	private Control createControlFromType( Type type, Value value, boolean editable ) {
		Control component = type.accept( this );
		component.setEnabled( editable );
		component.setValue( value.getValue() );
		return component;
	}

	private void registerHandler( final QuestionDeclaration question, final Control component ) {
		component.addChangeListener( new ControlEventListener() {
			@Override
			public void itemChanged( ControlEvent event ) {
				Control source = event.getSource();
				Type type = environment.lookupType( question.getIdent() );
				Value value = Undefined.UNDEFINED;

				// TODO get this out

				if ( type instanceof Bool ) {
					value = new Boolean( (java.lang.Boolean) source.getValue() );
				}

				if ( type instanceof Str ) {
					value = new String( (java.lang.String) source.getValue() );
				}

				if ( type instanceof Int ) {
					value = new Integer( java.lang.Integer.parseInt( source.getValue().toString() ) );
				}

				if ( type instanceof Money ) {
					value = new org.uva.sea.ql.evaluator.value.Money( java.lang.Double.parseDouble( source.getValue().toString() ) );
				}

				environment.assign( question.getIdent(), value );
				environment.notifyObservers( question.getIdent() );
			}
		} );
	}

	private void registerCondition( Expression expression, PanelControl ifTrue, PanelControl ifFalse ) {
		Observer observer = new ConditionObserver( expression, this.environment, ifTrue, ifFalse );
		LinkedList<Ident> list = new LinkedList<Ident>();
		this.findDependencies( list, expression );

		for ( Ident ident : list ) {
			this.environment.registerObserver( ident, observer );
		}
	}

	private void findDependencies( LinkedList<Ident> list, Expression expression ) {
		// TODO get this out

		if ( expression instanceof BinaryExpression ) {
			this.findDependencies( list, ( (BinaryExpression) expression ).getLhs() );
			this.findDependencies( list, ( (BinaryExpression) expression ).getRhs() );
		}
		else if ( expression instanceof UnaryExpression ) {
			this.findDependencies( list, ( (UnaryExpression) expression ).getExpression() );
		}
		else if ( expression instanceof Ident ) {
			list.add( (Ident) expression );
		}
	}

	private void registerDependencies( final QuestionComputed question, final Control component ) {
		Observer observer = new ComputedObserver( component, this.environment, question );
		LinkedList<Ident> list = new LinkedList<Ident>();
		this.findDependencies( list, question.getExpression() );

		for ( Ident ident : list ) {
			this.environment.registerObserver( ident, observer );
		}

		this.registerHandler( question, component );
	}

	@Override
	public Void visit( ElseIf node ) {
		Boolean value = (Boolean) node.getCondition().accept( this.expressionEvaluator );
		PanelControl tru = render( node.getBody(), this.environment, this.factory );

		tru.setVisible( value.getValue() );

		this.addComponent( tru );
		this.registerCondition( node.getCondition(), tru, new JPanelControl() );

		return null;
	}

	@Override
	public Void visit( ElseIfs node ) {
		for ( ElseIf elseIf : node ) {
			elseIf.accept( this );
		}

		return null;
	}

	@Override
	public Void visit( Else node ) {
		PanelControl panel = render( node.getBody(), this.environment, this.factory );

		this.addComponent( panel );

		return null;
	}

	@Override
	public Void visit( IfThenElse node ) {
		boolean condition = ( (Boolean) node.getCondition().accept( this.expressionEvaluator ) ).getValue();

		PanelControl tru = render( node.getIfBody(), this.environment, this.factory );
		PanelControl fls = render( node.getElse(), this.environment, this.factory );

		tru.setVisible( condition );
		fls.setVisible( !condition );

		this.addComponent( tru );
		this.addComponent( fls );

		this.registerCondition( node.getCondition(), tru, fls );

		return null;
	}

	@Override
	public Void visit( VarDeclaration node ) {
		Value value = node.getType().accept( this.typeInitializer );

		if ( !this.environment.isDeclared( node.getIdent() ) ) {
			this.environment.declare( node.getIdent(), value.getType() );
		}

		this.environment.assign( node.getIdent(), value );

		return null;
	}

	@Override
	public Void visit( Assignment node ) {
		Value value = node.getExpression().accept( this.expressionEvaluator );

		if ( !this.environment.isDeclared( node.getIdent() ) ) {
			this.environment.declare( node.getIdent(), value.getType() );
		}

		this.environment.assign( node.getIdent(), value );

		return null;
	}

	@Override
	public Void visit( FormDeclaration node ) {
		PanelControl formPanel = render( node.getStatements(), this.environment, this.factory );
		this.addComponent( formPanel );

		this.panel.setName( node.getIdent().getName() );

		return null;
	}

	@Override
	public Void visit( QuestionVar node ) {
		node.getVarDeclaration().accept( this );

		Type type = node.getType();
		Value value = type.accept( this.typeInitializer );

		java.lang.String label = node.getLabel().getValue();
		Control component = this.createControlFromType( type, value, true );

		this.addLabel( label );
		this.addComponent( component );

		this.environment.setObservable( node.getIdent(), new Observable() );
		this.registerHandler( node, component );

		return null;
	}

	@Override
	public Void visit( QuestionComputed node ) {
		node.getAssignment().accept( this );

		Value value = this.environment.lookup( node.getIdent() );
		Type type = value.getType();

		java.lang.String label = node.getLabel().getValue();
		Control component = this.createControlFromType( type, value, false );

		this.addLabel( label );
		this.addComponent( component );

		this.environment.setObservable( node.getIdent(), new Observable() );
		this.registerDependencies( node, component );

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
	public Control visit( Bool node ) {
		return this.factory.createCheckBox();
	}

	@Override
	public Control visit( Int node ) {
		return this.factory.createTextBox();
	}

	@Override
	public Control visit( Str node ) {
		return this.factory.createTextBox();
	}

	@Override
	public Control visit( Money node ) {
		return this.factory.createTextBox();
	}

	@Override
	public Control visit( Number node ) {
		return this.factory.createTextBox();
	}
}
