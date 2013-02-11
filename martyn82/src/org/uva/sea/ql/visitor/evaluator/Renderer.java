package org.uva.sea.ql.visitor.evaluator;

import java.util.LinkedList;
import java.util.Observer;

import org.uva.sea.ql.ast.expression.BinaryExpression;
import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.UnaryExpression;
import org.uva.sea.ql.ast.statement.Assignment;
import org.uva.sea.ql.ast.statement.FormDeclaration;
import org.uva.sea.ql.ast.statement.IfThen;
import org.uva.sea.ql.ast.statement.IfThenElse;
import org.uva.sea.ql.ast.statement.QuestionComputed;
import org.uva.sea.ql.ast.statement.QuestionDeclaration;
import org.uva.sea.ql.ast.statement.QuestionVariable;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.ast.statement.Statements;
import org.uva.sea.ql.ast.statement.VarDeclaration;
import org.uva.sea.ql.ast.type.BooleanType;
import org.uva.sea.ql.ast.type.IntegerType;
import org.uva.sea.ql.ast.type.MoneyType;
import org.uva.sea.ql.ast.type.NumberType;
import org.uva.sea.ql.ast.type.StringType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ui.ControlEvent;
import org.uva.sea.ql.ui.ControlEventListener;
import org.uva.sea.ql.ui.ControlFactory;
import org.uva.sea.ql.ui.control.Control;
import org.uva.sea.ql.ui.control.PanelControl;
import org.uva.sea.ql.visitor.StatementVisitor;
import org.uva.sea.ql.visitor.TypeVisitor;
import org.uva.sea.ql.visitor.evaluator.value.BooleanValue;
import org.uva.sea.ql.visitor.evaluator.value.IntegerValue;
import org.uva.sea.ql.visitor.evaluator.value.MoneyValue;
import org.uva.sea.ql.visitor.evaluator.value.StringValue;
import org.uva.sea.ql.visitor.evaluator.value.UndefinedValue;
import org.uva.sea.ql.visitor.evaluator.value.Value;

public class Renderer implements StatementVisitor<Void>, TypeVisitor<Control> {
	private final Environment environment;
	private final TypeInitializer typeInitializer;
	private final PanelControl panel;
	private final ControlFactory factory;

	public static PanelControl render( Statement statement, Environment environment, ControlFactory factory ) {
		Renderer renderer = new Renderer( environment, factory );
		statement.accept( renderer );
		return renderer.getPanel();
	}

	private Renderer( Environment environment, ControlFactory factory ) {
		this.factory = factory;
		this.environment = environment;
		this.typeInitializer = new TypeInitializer();
		this.panel = this.factory.createPanel();
	}

	private PanelControl getPanel() {
		return this.panel;
	}

	private void addComponent( Control component ) {
		this.panel.add( component );
	}

	private void addLabel( String label ) {
		this.addComponent( this.factory.createLabel( label ) );
	}

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

				// TODO get this out
				Value value = UndefinedValue.UNDEFINED;

				if ( type instanceof BooleanType ) {
					value = new BooleanValue( (Boolean) source.getValue() );
				}

				if ( type instanceof StringType ) {
					value = new StringValue( (String) source.getValue() );
				}

				if ( type instanceof IntegerType ) {
					value = new IntegerValue( Integer.parseInt( source.getValue().toString() ) );
				}

				if ( type instanceof MoneyType ) {
					value = new MoneyValue( Double.parseDouble( source.getValue().toString() ) );
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
	public Void visit( IfThen node ) {
		boolean condition = ( (BooleanValue) Evaluator.evaluate( node.getCondition(), this.environment ) ).getValue();

		PanelControl tru = render( node.getBody(), this.environment, this.factory );
		PanelControl fls = this.factory.createPanel();

		tru.setVisible( condition );
		fls.setVisible( !condition );

		this.addComponent( tru );
		this.addComponent( fls );

		this.registerCondition( node.getCondition(), tru, fls );

		return null;
	}

	@Override
	public Void visit( IfThenElse node ) {
		boolean condition = ( (BooleanValue) Evaluator.evaluate( node.getCondition(), this.environment ) ).getValue();

		PanelControl tru = render( node.getBody(), this.environment, this.factory );
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
		Value value = Evaluator.evaluate( node.getExpression(), this.environment );

		if ( !this.environment.isDeclared( node.getIdent() ) ) {
			this.environment.declare( node.getIdent(), value.getType() );
		}

		this.environment.assign( node.getIdent(), value );

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
	public Void visit( QuestionVariable node ) {
		node.getVarDeclaration().accept( this );

		Type type = node.getType();
		Value value = type.accept( this.typeInitializer );

		String label = node.getLabel().getValue();
		Control component = this.createControlFromType( type, value, true );

		this.addLabel( label );
		this.addComponent( component );

		this.registerHandler( node, component );

		return null;
	}

	@Override
	public Void visit( QuestionComputed node ) {
		node.getAssignment().accept( this );

		Value value = this.environment.lookup( node.getIdent() );
		Type type = value.getType();

		String label = node.getLabel().getValue();
		Control component = this.createControlFromType( type, value, false );

		this.addLabel( label );
		this.addComponent( component );

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
	public Control visit( BooleanType node ) {
		return this.factory.createCheckBox();
	}

	@Override
	public Control visit( IntegerType node ) {
		return this.factory.createTextBox();
	}

	@Override
	public Control visit( StringType node ) {
		return this.factory.createTextBox();
	}

	@Override
	public Control visit( MoneyType node ) {
		return this.factory.createTextBox();
	}

	@Override
	public Control visit( NumberType node ) {
		return this.factory.createTextBox();
	}
}
