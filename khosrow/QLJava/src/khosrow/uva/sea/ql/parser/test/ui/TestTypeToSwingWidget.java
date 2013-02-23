package khosrow.uva.sea.ql.parser.test.ui;

import static org.junit.Assert.assertEquals;
import khosrow.uva.sea.ql.ast.type.*;
import khosrow.uva.sea.ql.ui.TypeToSwingWidget;
import khosrow.uva.sea.ql.ui.controls.*;

import org.junit.Test;

public class TestTypeToSwingWidget {
	
	@Test
	public void intControl() {
		assertEquals(TypeToSwingWidget.convert(new Int()).getClass(), IntControl.class);
	}
	
	@Test
	public void moneyControl() {
		assertEquals(TypeToSwingWidget.convert(new Money()).getClass(), MoneyControl.class);
	}
	
	@Test
	public void boolControl() {
		assertEquals(TypeToSwingWidget.convert(new Bool()).getClass(), BoolControl.class);
	}
	
	@Test
	public void stringControl() {
		assertEquals(TypeToSwingWidget.convert(new Str()).getClass(), StringControl.class);
	}
}
