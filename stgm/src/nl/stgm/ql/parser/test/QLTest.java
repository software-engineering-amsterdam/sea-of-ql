package nl.stgm.ql.parser.test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import nl.stgm.ql.parser.*;
import nl.stgm.ql.parser.rats.RatsParser;

public class QLTest
{
	protected IParse parser;

	public QLTest()
	{
		this.parser = new RatsParser();
	}

	protected void assertClass(Class c, Object o)
	{
		assertEquals(c, o.getClass());
	}
}
