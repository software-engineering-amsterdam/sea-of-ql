package org.uva.sea.ql.tests;

import static org.mockito.Mockito.*;

import org.junit.Test;
import org.uva.sea.ql.ast.conditionals.*;
import org.uva.sea.ql.ast.form.*;
import org.uva.sea.ql.ast.operators.binary.*;
import org.uva.sea.ql.ast.operators.unary.*;
import org.uva.sea.ql.ast.traversal.base.*;
import org.uva.sea.ql.ast.types.Ident;
import org.uva.sea.ql.ast.types.literals.*;

// Test whether the visitor pattern has been implemented as it should be.
public class TestVisitorPattern extends TestBase {
	@SuppressWarnings("unchecked")
	private final IVisitor<Void> visitor = mock(IVisitor.class);

	@Test
	public void testConditionals() {
		mockAndVerifyVisit(IfThen.class);
		mockAndVerifyVisit(IfThenElse.class);
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
		mockAndVerifyVisit(BoolLiteral.class);
		mockAndVerifyVisit(Ident.class);
		mockAndVerifyVisit(IntLiteral.class);
		mockAndVerifyVisit(MoneyLiteral.class);
		mockAndVerifyVisit(StringLiteral.class);
	}

	@Test
	public void testVisitorInterface() {
		// Tests whether mocked objects really get visited by a visitor
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
		final Ident identMock1 = mock(Ident.class);
		final IfThenElse ifThenElseMock = mock(IfThenElse.class);
		final IfThen ifThenMock = mock(IfThen.class);
		final BoolLiteral boolMock = mock(BoolLiteral.class);
		final IntLiteral intMock = mock(IntLiteral.class);
		final StringLiteral stringMock = mock(StringLiteral.class);
		final Ident identMock2 = mock(Ident.class);
		final MoneyLiteral moneyMock = mock(MoneyLiteral.class);

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
		visitor.visit(identMock1);
		visitor.visit(ifThenElseMock);
		visitor.visit(ifThenMock);
		visitor.visit(boolMock);
		visitor.visit(intMock);
		visitor.visit(stringMock);
		visitor.visit(identMock2);
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
		verify(visitor).visit(identMock1);
		verify(visitor).visit(ifThenElseMock);
		verify(visitor).visit(ifThenMock);
		verify(visitor).visit(boolMock);
		verify(visitor).visit(intMock);
		verify(visitor).visit(stringMock);
		verify(visitor).visit(identMock2);
		verify(visitor).visit(moneyMock);
	}

	private void mockAndVerifyVisit(final Class<? extends IVisitable> visitable) {
		// Verifies visits by the visitor
		final IVisitable mockedVisitable = mock(visitable);
		mockedVisitable.accept(visitor);
		verify(mockedVisitable).accept(visitor);

	}
}
