package nl.stgm.ql.parser.rats;

import java.io.IOException;
import java.io.StringReader;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.ast.form.Document;
import nl.stgm.ql.ast.form.Form;

import nl.stgm.ql.parser.IParse;
import nl.stgm.ql.parser.ParseError;

import xtc.parser.Result;

public class RatsParser implements IParse
{
	public RatsParser()
	{
	}

	public Document parse(String src) throws ParseError
	{
		QLParser parser = new QLParser(new StringReader(src), "-");

		try
		{
			Result result = parser.pParse(0);
			if (result.hasValue())
			{
				return result.semanticValue();
			}
			throw new ParseError(result.parseError().msg);
		}
		catch (IOException e)
		{
			return null;
		}
	}

	public Form parseForm(String src) throws ParseError
	{
		QLParser parser = new QLParser(new StringReader(src), "-");

		try
		{
			Result result = parser.pParseForm(0);
			if (result.hasValue())
			{
				return result.semanticValue();
			}
			throw new ParseError(result.parseError().msg);
		}
		catch (IOException e)
		{
			return null;
		}
	}

	public ASTExpressionNode parseExpr(String src) throws ParseError
	{
		QLParser parser = new QLParser(new StringReader(src), "-");

		try
		{
			Result result = parser.pParseExpr(0);
			if (result.hasValue())
			{
				return result.semanticValue();
			}
			throw new ParseError(result.parseError().msg);
		}
		catch (IOException e)
		{
			return null;
		}
	}
}
