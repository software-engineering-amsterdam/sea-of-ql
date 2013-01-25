<<<<<<< HEAD
package org.uva.sea.ql.parser.test;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Form;

public interface IParse {
	Expr parse(String src) throws ParseError;
	Form parseForm(String src) throws ParseError; 
}
=======
package org.uva.sea.ql.parser.test;

import org.uva.sea.ql.ast.Form;

import org.uva.sea.ql.ast.expr.Expr;

public interface IParse {
	Expr parse(String src) throws ParseError;
	Form parseForm(String src) throws ParseError; 
}
>>>>>>> 483057f28359ecac2b999d94a928c0aaf01d2a6e
