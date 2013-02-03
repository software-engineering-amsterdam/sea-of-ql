package khosrow.uva.sea.ql.parser.test;

import khosrow.uva.sea.ql.ast.expr.Ident;
import khosrow.uva.sea.ql.ast.type.Bool;
import khosrow.uva.sea.ql.ast.type.Int;
import khosrow.uva.sea.ql.ast.type.Money;
import khosrow.uva.sea.ql.ast.type.Str;
import khosrow.uva.sea.ql.env.Env;

public class TheTestEnv {
	private static Env typeEnv;
	private static TheTestEnv testEnv;
	
	private TheTestEnv(){}
	
	public static Env getTypeEnv() {
		if(testEnv == null) {
			testEnv = new TheTestEnv();
			typeEnv = new Env();
			typeEnv.declareType(new Ident("iA"), new Int());
			typeEnv.declareType(new Ident("iB"), new Int());
			typeEnv.declareType(new Ident("iC"), new Int());
			typeEnv.declareType(new Ident("iD"), new Int());		
			typeEnv.declareType(new Ident("bA"), new Bool());
			typeEnv.declareType(new Ident("bB"), new Bool());
			typeEnv.declareType(new Ident("bC"), new Bool());
			typeEnv.declareType(new Ident("bD"), new Bool());
			typeEnv.declareType(new Ident("sA"), new Str());
			typeEnv.declareType(new Ident("sB"), new Str());
			typeEnv.declareType(new Ident("sC"), new Str());
			typeEnv.declareType(new Ident("sD"), new Str());
			typeEnv.declareType(new Ident("mA"), new Money());
			typeEnv.declareType(new Ident("mB"), new Money());
			typeEnv.declareType(new Ident("mC"), new Money());
			typeEnv.declareType(new Ident("mD"), new Money());
		}
		return typeEnv;
	}
}
