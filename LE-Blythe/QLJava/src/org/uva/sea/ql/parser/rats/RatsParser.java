package org.uva.sea.ql.parser.rats;

import java.io.IOException;
import java.io.StringReader;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.errors.ParseError;
import org.uva.sea.ql.interfaces.IParse;

import xtc.parser.Result;

public class RatsParser implements IParse {
	public RatsParser() {
		
	}

	@Override
	public ASTNode parse(String src) throws ParseError {
		QLParser parser = new QLParser(new StringReader(src), "-");
		
		try {
			Result result = parser.pRunParse(0);
			if (result.hasValue()) {
				return result.semanticValue();
			}
			throw new ParseError(result.parseError().msg);
		} catch (IOException e) {
			return null;
		}
	}

}