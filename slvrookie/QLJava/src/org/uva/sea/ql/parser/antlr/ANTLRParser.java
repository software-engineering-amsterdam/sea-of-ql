package org.uva.sea.ql.parser.antlr;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.parser.test.IParse;
import org.uva.sea.ql.parser.test.ParseError;

public class ANTLRParser implements IParse {

 public static void main(String[] args)  {
  ANTLRStringStream stream = new ANTLRStringStream("\n3*3");
  CommonTokenStream tokens = new CommonTokenStream();
  tokens.setTokenSource(new QLLexer(stream));
  QLParser parser = new QLParser(tokens);
  try {
   System.out.println(parser.orExpr());
  } catch (RecognitionException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
  /* try {
   return parser.orExpr();
  } catch (RecognitionException e) {
   throw new ParseError(e.getMessage());
  }
  */
 }

 @Override
 public Expr parse(String src) throws ParseError {
  // TODO Auto-generated method stub
  return null;
 }

}
