package org.uva.sea.ql.parser.test;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.uva.sea.ql.ast.form.*;
import org.uva.sea.ql.ast.conditionals.*;
import org.uva.sea.ql.ast.operators.binary.*;
import org.uva.sea.ql.ast.operators.unary.*;
import org.uva.sea.ql.ast.traversal.base.IVisitable;
import org.uva.sea.ql.ast.traversal.base.IVisitor;
import org.uva.sea.ql.ast.types.*;

public class TestVisitorPattern extends TestBase {
	private final IVisitor visitor = mock(IVisitor.class);
	
	@Test
	public void testConditionals() {
		mockAndVerifyVisit(IfThen.class);
		mockAndVerifyVisit(IfThenElse.class);
	}
	
	@Test
	public void testFormPackageVisits() {
		// Nodes that are not in the if then else scope
		final Question question = mock(Question.class);
		final Computation computation = mock(Computation.class);
		
		// then statements
		final Label ifQuestionLabel = mock(Label.class);
		final Question ifQuestion = new Question(ifQuestionLabel, "does not matter", Bool.class);
		
		// else statements
		final Int leftAdditionInt = mock(Int.class);
		final Int rightAdditionInt = mock(Int.class);
		final Add addition = new Add(leftAdditionInt, rightAdditionInt);

		final Label computationLabel = mock(Label.class);
		final Computation elseComputation = new Computation(computationLabel, "does not matter", Int.class, addition);

		// Use an Eq of stringliteral and money as a condition (this will not be semantically checked anyway) 
		final StringLiteral leftEqStringLiteral = mock(StringLiteral.class);
		final Money rightEqMoney = mock(Money.class);
		final Eq condition = new Eq(leftEqStringLiteral, rightEqMoney);
		final IfThenElse ifThenElse = new IfThenElse(condition, elementToArray(ifQuestion), elementToArray(elseComputation));
		
		// Create the form
		final List<Element> formElements = new ArrayList<Element>();
		formElements.add(question);
		formElements.add(computation);
		formElements.add(ifThenElse);
		final Form form = new Form("name", formElements);
		
		// Accept should traverse all visits in the tree of mocked objects
		form.accept(visitor);
	
		// Verify the correct implementation of the pattern
		verify(computation).accept(visitor);
		verify(leftAdditionInt).accept(visitor);
		verify(rightAdditionInt).accept(visitor);
		verify(computationLabel).accept(visitor);
		verify(ifQuestionLabel).accept(visitor);
		verify(leftEqStringLiteral).accept(visitor);
		verify(rightEqMoney).accept(visitor);
	}
	
	@Test
	public void testBinaryOperatorVisits() {
		mockAndVerifyVisit(Add.class);
		mockAndVerifyVisit(And.class);
		mockAndVerifyVisit(Div.class);
		mockAndVerifyVisit(Eq.class);
		mockAndVerifyVisit(GEq.class);
		mockAndVerifyVisit(GT.class);
		mockAndVerifyVisit(LEq.class);
		mockAndVerifyVisit(LT.class);
		mockAndVerifyVisit(Mul.class);
		mockAndVerifyVisit(NEq.class);
		mockAndVerifyVisit(Or.class);
		mockAndVerifyVisit(Sub.class);
	}
	
	@Test
	public void testUnaryOperatorVisits() {
		mockAndVerifyVisit(Neg.class);
		mockAndVerifyVisit(Pos.class);
		mockAndVerifyVisit(Not.class);
	}
	
	@Test
	public void testDataTypeVisits() {
		mockAndVerifyVisit(Bool.class);
		mockAndVerifyVisit(Ident.class);
		mockAndVerifyVisit(Int.class);
		mockAndVerifyVisit(Money.class);
		mockAndVerifyVisit(StringLiteral.class);
	}

	@Test
	public void testVisitorInterface() {
		final Add addMock = mock(Add.class);
		final And andMock = mock(And.class);
		final Div divMock = mock(Div.class);
		final Eq eqMock = mock(Eq.class);
		final GEq geqMock = mock(GEq.class);
		final GT gtMock = mock(GT.class);
		final LEq leqMock = mock(LEq.class);
		final LT ltMock = mock(LT.class);
		final Mul mulMock = mock(Mul.class);
		final NEq neqMock = mock(NEq.class);
		final Or orMock = mock(Or.class);
		final Sub subMock = mock(Sub.class);
		final Neg negMock = mock(Neg.class);
		final Pos posMock = mock(Pos.class);
		final Not notMock = mock(Not.class);
		final Computation computationMock = mock(Computation.class);
		final Form formMock = mock(Form.class);
		final Question questionMock = mock(Question.class);
		final Label labelMock = mock(Label.class);
		final IfThenElse ifThenElseMock = mock(IfThenElse.class);
		final IfThen ifThenMock = mock(IfThen.class);
		final Bool boolMock = mock(Bool.class);
		final Int intMock = mock(Int.class);
		final StringLiteral stringMock = mock(StringLiteral.class);
		final Ident identMock = mock(Ident.class);
		final Money moneyMock = mock(Money.class);
		
		visitor.visit(addMock);
		visitor.visit(andMock);
		visitor.visit(divMock);
		visitor.visit(eqMock);
		visitor.visit(geqMock);
		visitor.visit(gtMock);
		visitor.visit(leqMock);
		visitor.visit(ltMock);
		visitor.visit(mulMock);
		visitor.visit(neqMock);
		visitor.visit(orMock);
		visitor.visit(subMock);
		visitor.visit(negMock);
		visitor.visit(posMock);
		visitor.visit(notMock);
		visitor.visit(computationMock);
		visitor.visit(formMock);
		visitor.visit(questionMock);
		visitor.visit(labelMock);
		visitor.visit(ifThenElseMock);
		visitor.visit(ifThenMock);
		visitor.visit(boolMock);
		visitor.visit(intMock);
		visitor.visit(stringMock);
		visitor.visit(identMock);
		visitor.visit(moneyMock);
		
		verify(visitor).visit(andMock);
		verify(visitor).visit(divMock);
		verify(visitor).visit(eqMock);
		verify(visitor).visit(geqMock);
		verify(visitor).visit(gtMock);
		verify(visitor).visit(leqMock);
		verify(visitor).visit(ltMock);
		verify(visitor).visit(mulMock);
		verify(visitor).visit(neqMock);
		verify(visitor).visit(orMock);
		verify(visitor).visit(subMock);
		verify(visitor).visit(negMock);
		verify(visitor).visit(posMock);
		verify(visitor).visit(notMock);
		verify(visitor).visit(computationMock);
		verify(visitor).visit(formMock);
		verify(visitor).visit(questionMock);
		verify(visitor).visit(labelMock);
		verify(visitor).visit(ifThenElseMock);
		verify(visitor).visit(ifThenMock);
		verify(visitor).visit(boolMock);
		verify(visitor).visit(intMock);
		verify(visitor).visit(stringMock);
		verify(visitor).visit(identMock);
		verify(visitor).visit(moneyMock);
	}
	
	private void mockAndVerifyVisit(final Class<? extends IVisitable> visitable) {
		final IVisitable mockedVisitable = mock(visitable);
		mockedVisitable.accept(visitor);
		verify(mockedVisitable).accept(visitor);
	}
	
	private List<Element> elementToArray(final Element element) {
		final List<Element> elements = new ArrayList<Element>();
		elements.add(element);
		return elements;
	}
}
