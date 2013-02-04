package org.uva.sea.ql.evaluator;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.LinkedList;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
import org.uva.sea.ql.evaluator.typechecker.ExpressionTypeResolver;
import org.uva.sea.ql.evaluator.value.Boolean;
import org.uva.sea.ql.evaluator.value.Value;
import org.uva.sea.ql.visitor.IStatementVisitor;
import org.uva.sea.ql.visitor.ITypeVisitor;

/**
 * Evaluator for statement nodes.
 */
public class Renderer implements IStatementVisitor<Void>, ITypeVisitor<JComponent> {
	/**
	 * Holds the environment.
	 */
	private final Environment environment;

	/**
	 * Holds the expression evaluator.
	 */
	private final Evaluator expressionEvaluator;

	/**
	 * Holds the type resolver.
	 */
	private final ExpressionTypeResolver typeResolver;

	/**
	 * Holds the type evaluator.
	 */
	private final TypeEvaluator typeEvaluator;

	/**
	 * Holds the working panel.
	 */
	private final JPanel panel;

	/**
	 * Renders the given statement.
	 *
	 * @param statement
	 * @param environment
	 *
	 * @return Panel resulting from statement.
	 */
	public static JPanel render( Statement statement, Environment environment ) {
		Renderer evaluator = new Renderer( environment );
		statement.accept( evaluator );
		return evaluator.getPanel();
	}

	/**
	 * Hidden constructor for renderer.
	 *
	 * @param environment
	 */
	private Renderer( Environment environment ) {
		this.environment = environment;
		this.expressionEvaluator = new Evaluator( environment );
		this.typeEvaluator = new TypeEvaluator();
		this.typeResolver = new ExpressionTypeResolver( environment );

		this.panel = new JPanel();
	}

	/**
	 * Retrieves the rendered panel.
	 *
	 * @return The result.
	 */
	private JPanel getPanel() {
		return this.panel;
	}

	/**
	 * Adds a component to the panel.
	 *
	 * @param component
	 */
	private void addComponent( JComponent component ) {
		this.panel.add( component );
	}

	/**
	 * Adds a label to the panel.
	 *
	 * @param label
	 */
	private void addLabel( String label ) {
		this.addComponent( new JLabel( label ) );
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
	private JComponent createControlFromType( Type type, Value value, boolean editable ) {
		JComponent component = type.accept( this );
		component.setEnabled( editable );

		if ( component instanceof JCheckBox ) {
			( (JCheckBox) component ).setSelected( ( (Boolean) value ).getValue() );
		}
		else if ( component instanceof JTextField ) {
			( (JTextField) component ).setText( ( (org.uva.sea.ql.evaluator.value.String) value ).getValue() );
		}

		return component;
	}

	private void registerHandler( final QuestionDeclaration question, final JComponent component ) {
		if ( component instanceof JCheckBox ) {
			( (JCheckBox) component ).addItemListener( new ItemListener() {
				@Override
				public void itemStateChanged( ItemEvent event ) {
					System.out.println( "Notify for " + question.getIdent().getName() );
					JCheckBox source = (JCheckBox) event.getSource();
					environment.declareVariable( question.getIdent(), new Boolean( source.isSelected() ) );
					environment.notifyObservers( question.getIdent() );
				}
			} );
		}
	}

	private void registerCondition( Expression expression, JPanel ifTrue, JPanel ifFalse ) {
		Observer observer = new ConditionObserver( expression, this.environment, ifTrue, ifFalse );
		LinkedList<Ident> list = new LinkedList<Ident>();
		this.getIdents( list, expression );

		for ( Ident ident : list ) {
			this.environment.registerObserver( ident, observer );
		}
	}

	private void getIdents( LinkedList<Ident> list, Expression expression ) {
		if ( expression instanceof BinaryExpression ) {
			this.getIdents( list, ( (BinaryExpression) expression ).getLhs() );
			this.getIdents( list, ( (BinaryExpression) expression ).getRhs() );
		}
		else if ( expression instanceof UnaryExpression ) {
			this.getIdents( list, ( (UnaryExpression) expression ).getExpression() );
		}
		else if ( expression instanceof Ident ) {
			list.add( (Ident) expression );
		}
	}

	@Override
	public Void visit( ElseIf node ) {
		Boolean value = (Boolean) node.getCondition().accept( this.expressionEvaluator );
		JPanel tru = render( node.getBody(), this.environment );

		tru.setVisible( value.getValue() );
		this.addComponent( tru );

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
		JPanel panel = render( node.getBody(), this.environment );
		this.addComponent( panel );

		return null;
	}

	@Override
	public Void visit( IfThenElse node ) {
		Boolean value = (Boolean) node.getCondition().accept( this.expressionEvaluator );

		JPanel tru = render( node.getIfBody(), this.environment );
		JPanel sif = render( node.getElseIfs(), this.environment );
		JPanel fls = render( node.getElse(), this.environment );

		tru.setVisible( value.getValue() );
		sif.setVisible( !value.getValue() );
		fls.setVisible( !value.getValue() );

		this.addComponent( tru );
		this.addComponent( sif );
		this.addComponent( fls );

		this.registerCondition( node.getCondition(), tru, fls );

		return null;
	}

	@Override
	public Void visit( VarDeclaration node ) {
		Value value = node.getType().accept( this.typeEvaluator );

// FIXME ident type is declared, but ident var may not
//		if ( !this.environment.isDeclared( node.getIdent() ) ) {
			this.environment.declareVariable( node.getIdent(), value );
//		}

		return null;
	}

	@Override
	public Void visit( Assignment node ) {
		Value value = node.getExpression().accept( this.expressionEvaluator );
		this.environment.declareVariable( node.getIdent(), value );

		return null;
	}

	@Override
	public Void visit( FormDeclaration node ) {
		JPanel formPanel = render( node.getStatements(), this.environment );
		this.addComponent( formPanel );

		this.panel.setName( node.getIdent().getName() );

		return null;
	}

	@Override
	public Void visit( QuestionVar node ) {
		node.getVarDeclaration().accept( this );

		Type type = node.getType();
		Value value = type.accept( this.typeEvaluator );
		String label = node.getLabel().getValue();

		JComponent component = this.createControlFromType( type, value, true );

		this.addLabel( label );
		this.addComponent( component );

		this.environment.setObservable( node.getIdent(), new Observable() );
		this.registerHandler( node, component );

System.out.println( "Registered questionVar for " + node.getIdent().getName() );

		return null;
	}

	@Override
	public Void visit( QuestionComputed node ) {
		node.getAssignment().accept( this );

		Value value = this.environment.lookup( node.getIdent() );
		Type type = node.getExpression().accept( this.typeResolver );
		String label = node.getLabel().getValue();

		JComponent component = this.createControlFromType( type, value, false );

		this.addLabel( label );
		this.addComponent( component );

		this.environment.setObservable( node.getIdent(), new Observable() );

		LinkedList<Ident> list = new LinkedList<Ident>();
		this.getIdents( list, node.getExpression() );

		for ( Ident ident : list ) {
			this.environment.registerObserver( ident, new ComputedObserver( component, this.environment, node ) );
		}

		this.registerHandler( node, component );

		System.out.println( "Registered questionComputed for " + node.getIdent().getName() );
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
	public JComponent visit( Bool node ) {
		return new JCheckBox();
	}

	@Override
	public JComponent visit( Int node ) {
		return new JTextField();
	}

	@Override
	public JComponent visit( Str node ) {
		return new JTextField();
	}

	@Override
	public JComponent visit( Money node ) {
		return new JTextField();
	}

	@Override
	public JComponent visit( Number node ) {
		return new JTextField();
	}
}
