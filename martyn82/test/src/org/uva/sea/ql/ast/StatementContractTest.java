package org.uva.sea.ql.ast;

import org.junit.Test;
import org.uva.sea.ql.ast.expression.IdentifierExpression;
import org.uva.sea.ql.ast.expression.literal.BooleanLiteral;
import org.uva.sea.ql.ast.expression.literal.IntegerLiteral;
import org.uva.sea.ql.ast.expression.literal.StringLiteral;
import org.uva.sea.ql.ast.statement.Assignment;
import org.uva.sea.ql.ast.statement.ComputedQuestion;
import org.uva.sea.ql.ast.statement.FormDeclaration;
import org.uva.sea.ql.ast.statement.IfThen;
import org.uva.sea.ql.ast.statement.IfThenElse;
import org.uva.sea.ql.ast.statement.Statements;
import org.uva.sea.ql.ast.statement.VariableDeclaration;
import org.uva.sea.ql.ast.statement.VariableQuestion;
import org.uva.sea.ql.ast.type.StringType;

public class StatementContractTest {
	@Test( expected = AssertionError.class )
	public void testAssignment_NoRhs() {
		new Assignment( new IdentifierExpression( "var" ), null );
	}

	@Test( expected = AssertionError.class )
	public void testAssignment_NoLhs() {
		new Assignment( null, new IntegerLiteral( 0 ) );
	}

	@Test( expected = AssertionError.class )
	public void testComputedQuestion_NoRhs() {
		new ComputedQuestion( new StringLiteral( "" ), null );
	}

	@Test( expected = AssertionError.class )
	public void testComputedQuestion_NoLhs() {
		new ComputedQuestion( null, new Assignment( new IdentifierExpression( "var" ), new IntegerLiteral( 0 ) ) );
	}

	@Test( expected = AssertionError.class )
	public void testFormDeclaration_NoBody() {
		new FormDeclaration( "form", null );
	}

	@Test( expected = AssertionError.class )
	public void testFormDeclaration_EmptyLabel() {
		new FormDeclaration( "", new Statements() );
	}

	@Test( expected = AssertionError.class )
	public void testFormDeclaration_NullLabel() {
		new FormDeclaration( null, new Statements() );
	}

	@Test( expected = AssertionError.class )
	public void testIfThen_NoCondition() {
		new IfThen( null, new Statements() );
	}

	@Test( expected = AssertionError.class )
	public void testIfThen_NoBody() {
		new IfThen( new BooleanLiteral( true ), null );
	}

	@Test( expected = AssertionError.class )
	public void testIfThenElse_NoCondition() {
		new IfThenElse( null, new Statements(), new Statements() );
	}

	@Test( expected = AssertionError.class )
	public void testIfThenElse_NoIfBody() {
		new IfThenElse( new BooleanLiteral( true ), null, new Statements() );
	}

	@Test( expected = AssertionError.class )
	public void testIfThenElse_NoElseBody() {
		new IfThenElse( new BooleanLiteral( true ), new Statements(), null );
	}

	@Test( expected = AssertionError.class )
	public void testVariableDeclaration_NoIdent() {
		new VariableDeclaration( null, StringType.STRING );
	}

	@Test( expected = AssertionError.class )
	public void testVariableDeclaration_NoType() {
		new VariableDeclaration( new IdentifierExpression( "var" ), null );
	}

	@Test( expected = AssertionError.class )
	public void testVariableQuestion_NoLabel() {
		new VariableQuestion( null, new VariableDeclaration( new IdentifierExpression( "var" ), StringType.STRING ) );
	}

	@Test( expected = AssertionError.class )
	public void testVariableQuestion_NoDeclaration() {
		new VariableQuestion( new StringLiteral( "label" ), null );
	}
}
