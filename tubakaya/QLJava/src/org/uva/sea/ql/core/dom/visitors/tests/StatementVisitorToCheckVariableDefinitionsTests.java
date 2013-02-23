package org.uva.sea.ql.core.dom.visitors.tests;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.core.dom.*;
import org.uva.sea.ql.core.dom.statements.*;
import org.uva.sea.ql.core.dom.types.declarations.*;
import org.uva.sea.ql.core.dom.types.primitive.IntLiteral;
import org.uva.sea.ql.core.dom.types.primitive.StringLiteral;
import org.uva.sea.ql.core.dom.visitors.StatementVisitorToCheckVariableDefinitions;
import org.uva.sea.ql.core.dom.visitors.tests.Stubs.FakeExpressionVisitor;
import org.uva.sea.ql.parsers.exceptions.ParseException;

public class StatementVisitorToCheckVariableDefinitionsTests {
	
	private ExpressionVisitor expressionVisitor;
	private StatementVisitorToCheckVariableDefinitions target;
	
	@Before
    public void setUp() {
		this.expressionVisitor = new FakeExpressionVisitor();
		this.target = new StatementVisitorToCheckVariableDefinitions(expressionVisitor);
    }
	
	@Test
	public void does_addOneErrorInTheList_when_aVariableWithSameNameAndTypeFoundTwiceFromQuestion() throws ParseException {
		String identifierName="identifier";
		TypeDeclaration type=new BooleanDeclaration();
		
		Variable variable = new Variable (new Identifier(identifierName),type);
		Question question = new Question(variable,new StringLiteral("question"));
		target.visit(question);
		assertEquals(0,target.getErrors().size());	
		
		Variable variable2 = new Variable (new Identifier(identifierName),type);
		Question question2 = new Question(variable2,new StringLiteral("question2"));
		target.visit(question2);
		assertEquals(1,target.getErrors().size());	
	}
	
	@Test
	public void does_addOneErrorInTheList_when_aVariableWithSameNameAndTypeFoundTwiceFromComputedValue() throws ParseException {
		String identifierName="identifier";
		TypeDeclaration type=new BooleanDeclaration();
		
		Variable variable = new Variable (new Identifier(identifierName),type);
		ComputedValue computedValue = new ComputedValue(variable,new StringLiteral("computedValue"), new IntLiteral("1"));
		target.visit(computedValue);
		assertEquals(0,target.getErrors().size());	
		
		Variable variable2 = new Variable (new Identifier(identifierName),type);
		ComputedValue computedValue2 = new ComputedValue(variable2,new StringLiteral("computedValue2"), new IntLiteral("1"));
		target.visit(computedValue2);
		assertEquals(1,target.getErrors().size());	
	}
}
