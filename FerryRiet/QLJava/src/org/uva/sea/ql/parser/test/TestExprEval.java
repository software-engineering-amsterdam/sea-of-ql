package org.uva.sea.ql.parser.test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.junit.Test;
import org.uva.sea.ql.ast.operatorresults.BooleanResult;
import org.uva.sea.ql.ast.operatorresults.IntegerResult;
import org.uva.sea.ql.ast.operatorresults.MoneyResult;
import org.uva.sea.ql.ast.operatorresults.Result;

public class TestExprEval extends TestCase {

	static final private IParse parser = new ANTLRParser();

	@Test
	public void testExprEval() throws Exception {

		Map<String, Result> symbols = new HashMap<String, Result>();

		symbols.put("bool", new BooleanResult(false));
		symbols.put("money1", new MoneyResult(10));
		symbols.put("money2", new MoneyResult(100));
		symbols.put("int1", new IntegerResult(100));
		symbols.put("bool", new BooleanResult(false));

		assertEquals(parser.expr("9 < 10").eval(symbols).getBooleanValue(), true);
		assertEquals(parser.expr("9 < 10.0").eval(symbols).getBooleanValue(), true);
		assertEquals(parser.expr("9.0 < 10").eval(symbols).getBooleanValue(), true);
		assertEquals(parser.expr("9.0 < 10.0").eval(symbols).getBooleanValue(), true);

		assertEquals(parser.expr("9 <= 10").eval(symbols).getBooleanValue(), true);
		assertEquals(parser.expr("9 <= 10.0").eval(symbols).getBooleanValue(), true);
		assertEquals(parser.expr("9.0 <= 10").eval(symbols).getBooleanValue(), true);
		assertEquals(parser.expr("9.0 <= 10.0").eval(symbols).getBooleanValue(), true);

		assertEquals(parser.expr("9 > 10").eval(symbols).getBooleanValue(), false);
		assertEquals(parser.expr("9 > 10.0").eval(symbols).getBooleanValue(), false);
		assertEquals(parser.expr("9.0 > 10").eval(symbols).getBooleanValue(), false);
		assertEquals(parser.expr("9.0 > 10.0").eval(symbols).getBooleanValue(), false);

		assertEquals(parser.expr("9 >= 10").eval(symbols).getBooleanValue(), false);
		assertEquals(parser.expr("9 >= 10.0").eval(symbols).getBooleanValue(), false);
		assertEquals(parser.expr("9.0 >= 10").eval(symbols).getBooleanValue(), false);
		assertEquals(parser.expr("9.0 >= 10.0").eval(symbols).getBooleanValue(), false);

		assertEquals(parser.expr("9 == 10").eval(symbols).getBooleanValue(), false);
		assertEquals(parser.expr("9 == 10.0").eval(symbols).getBooleanValue(), false);
		assertEquals(parser.expr("9.0 == 10").eval(symbols).getBooleanValue(), false);
		assertEquals(parser.expr("9.0 == 10.0").eval(symbols).getBooleanValue(), false);

		assertEquals(parser.expr("9   == 9").eval(symbols).getBooleanValue(), true);
		assertEquals(parser.expr("9.0 == 9.0").eval(symbols).getBooleanValue(), true);
		assertEquals(parser.expr("9.0 == 9").eval(symbols).getBooleanValue(), true);
		assertEquals(parser.expr("9   == 9.0").eval(symbols).getBooleanValue(), true);

		assertEquals(parser.expr("10.0 < 10.0 == true").eval(symbols).getBooleanValue(), false);
		assertEquals(parser.expr("10 < 11 && 10 > 9").eval(null).getBooleanValue(), true);

		assertEquals(parser.expr("10 < 11 || 10 < 9").eval(null).getBooleanValue(), true);
		assertEquals(parser.expr("10 > 11 || 10 > 9").eval(null).getBooleanValue(), true);

		assertEquals(parser.expr("10.0 > 11.0 || 10.0 < 9.0").eval(null).getBooleanValue(), false);
		assertEquals(parser.expr("10.0 > 11.0 || 10.0 < 9.0").eval(null).getBooleanValue(), false);

		assertEquals(parser.expr("10 < 11 || 10 < 9").eval(null).getBooleanValue(), true);

		assertEquals(parser.expr("10 > 11").eval(null).getBooleanValue(), false);
		assertEquals(parser.expr("10 > 9").eval(null).getBooleanValue(), true);
		assertEquals(parser.expr("10 > 11 || 10 > 9").eval(null).getBooleanValue(), true);

		assertEquals(parser.expr("money1 + money2").eval(symbols).getMoneyValue(), new BigDecimal(
				110));
		assertEquals(parser.expr("int1 + money1").eval(symbols).getMoneyValue(),
				new BigDecimal(110));
		assertEquals(parser.expr("money1 + int1").eval(symbols).getMoneyValue(),
				new BigDecimal(110));
		assertEquals(parser.expr("money1 - int1").eval(symbols).getMoneyValue(),
				new BigDecimal(-90));
		assertEquals(parser.expr("int1 - money1").eval(symbols).getMoneyValue(), new BigDecimal(90));
		assertEquals(parser.expr("int1 + int1").eval(symbols).getIntegerValue(), 200);
		assertEquals(parser.expr("10 + 100").eval(symbols).getIntegerValue(), 10 + 100);
		assertEquals(parser.expr("10 + 100").eval(symbols).getIntegerValue(), 10 + 100);
		assertEquals(parser.expr("10 + 100 * 100 + 10 / 10  ").eval(null).getIntegerValue(), 10011);
		assertEquals(parser.expr("money1 < money2").eval(symbols).getBooleanValue(), true);
		assertEquals(parser.expr("money2 < money1").eval(symbols).getBooleanValue(), false);
		assertEquals(parser.expr("money1 < 100").eval(symbols).getBooleanValue(), true);
		assertEquals(parser.expr("money1 < 1").eval(symbols).getBooleanValue(), false);
		assertEquals(parser.expr("1 < money1").eval(symbols).getBooleanValue(), true);
		assertEquals(parser.expr("100 < money1").eval(symbols).getBooleanValue(), false);
	}
}
