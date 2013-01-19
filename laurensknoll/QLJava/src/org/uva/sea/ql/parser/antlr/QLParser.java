// $ANTLR 3.5 C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g 2013-01-16 21:02:29

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expr.Add;
import org.uva.sea.ql.ast.expr.And;
import org.uva.sea.ql.ast.expr.Div;
import org.uva.sea.ql.ast.expr.Eq;
import org.uva.sea.ql.ast.expr.AbstractExpr;
import org.uva.sea.ql.ast.expr.GEq;
import org.uva.sea.ql.ast.expr.GT;
import org.uva.sea.ql.ast.expr.LEq;
import org.uva.sea.ql.ast.expr.LT;
import org.uva.sea.ql.ast.expr.Mul;
import org.uva.sea.ql.ast.expr.NEq;
import org.uva.sea.ql.ast.expr.Neg;
import org.uva.sea.ql.ast.expr.Not;
import org.uva.sea.ql.ast.expr.Or;
import org.uva.sea.ql.ast.expr.Pos;
import org.uva.sea.ql.ast.expr.Sub;
import org.uva.sea.ql.ast.statement.AbstractStatement;
import org.uva.sea.ql.ast.statement.Block;
import org.uva.sea.ql.ast.statement.IfStatement;
import org.uva.sea.ql.ast.statement.Question;
import org.uva.sea.ql.ast.statement.QuestionForm;
import org.uva.sea.ql.ast.statement.Summary;
import org.uva.sea.ql.ast.type.Bool;
import org.uva.sea.ql.ast.type.Money;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings("all")
public class QLParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "Boolean", "COMMENT", "Ident", 
		"Int", "Money", "String", "WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", 
		"'+'", "'-'", "'/'", "':'", "'<'", "'<='", "'=='", "'>'", "'>='", "'if'", 
		"'{'", "'||'", "'}'"
	};
	public static final int EOF=-1;
	public static final int T__11=11;
	public static final int T__12=12;
	public static final int T__13=13;
	public static final int T__14=14;
	public static final int T__15=15;
	public static final int T__16=16;
	public static final int T__17=17;
	public static final int T__18=18;
	public static final int T__19=19;
	public static final int T__20=20;
	public static final int T__21=21;
	public static final int T__22=22;
	public static final int T__23=23;
	public static final int T__24=24;
	public static final int T__25=25;
	public static final int T__26=26;
	public static final int T__27=27;
	public static final int T__28=28;
	public static final int T__29=29;
	public static final int Boolean=4;
	public static final int COMMENT=5;
	public static final int Ident=6;
	public static final int Int=7;
	public static final int Money=8;
	public static final int String=9;
	public static final int WS=10;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public QLParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public QLParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
		this.state.ruleMemo = new HashMap[37+1];


	}

	@Override public String[] getTokenNames() { return QLParser.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g"; }



	// $ANTLR start "primary"
	// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:15:1: primary returns [Expr result] : ( Int | Ident | String |x= expression );
	public final AbstractExpr primary() throws RecognitionException {
		AbstractExpr result = null;

		int primary_StartIndex = input.index();

		Token Int1=null;
		Token Ident2=null;
		Token String3=null;
		AbstractExpr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:16:2: ( Int | Ident | String |x= expression )
			int alt1=4;
			switch ( input.LA(1) ) {
			case Int:
				{
				alt1=1;
				}
				break;
			case Ident:
				{
				alt1=2;
				}
				break;
			case String:
				{
				alt1=3;
				}
				break;
			case 14:
				{
				alt1=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}
			switch (alt1) {
				case 1 :
					// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:16:4: Int
					{
					Int1=(Token)match(input,Int,FOLLOW_Int_in_primary45); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Int(Integer.parseInt((Int1!=null?Int1.getText():null))); }
					}
					break;
				case 2 :
					// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:17:4: Ident
					{
					Ident2=(Token)match(input,Ident,FOLLOW_Ident_in_primary53); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Ident((Ident2!=null?Ident2.getText():null)); }
					}
					break;
				case 3 :
					// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:18:4: String
					{
					String3=(Token)match(input,String,FOLLOW_String_in_primary61); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Literal((String3!=null?String3.getText():null)); }
					}
					break;
				case 4 :
					// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:19:4: x= expression
					{
					pushFollow(FOLLOW_expression_in_primary71);
					x=expression();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = x; }
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 1, primary_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "primary"



	// $ANTLR start "expression"
	// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:23:1: expression returns [Expr result] : '(' x= orExpr ')' ;
	public final AbstractExpr expression() throws RecognitionException {
		AbstractExpr result = null;

		int expression_StartIndex = input.index();

		AbstractExpr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:24:2: ( '(' x= orExpr ')' )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:24:4: '(' x= orExpr ')'
			{
			match(input,14,FOLLOW_14_in_expression89); if (state.failed) return result;
			pushFollow(FOLLOW_orExpr_in_expression93);
			x=orExpr();
			state._fsp--;
			if (state.failed) return result;
			match(input,15,FOLLOW_15_in_expression95); if (state.failed) return result;
			if ( state.backtracking==0 ) { result = x; }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 2, expression_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "expression"



	// $ANTLR start "unExpr"
	// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:27:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
	public final AbstractExpr unExpr() throws RecognitionException {
		AbstractExpr result = null;

		int unExpr_StartIndex = input.index();

		AbstractExpr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:28:2: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
			int alt2=4;
			switch ( input.LA(1) ) {
			case 17:
				{
				alt2=1;
				}
				break;
			case 18:
				{
				alt2=2;
				}
				break;
			case 11:
				{
				alt2=3;
				}
				break;
			case Ident:
			case Int:
			case String:
			case 14:
				{
				alt2=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}
			switch (alt2) {
				case 1 :
					// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:28:4: '+' x= unExpr
					{
					match(input,17,FOLLOW_17_in_unExpr112); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr116);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Pos(x); }
					}
					break;
				case 2 :
					// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:29:4: '-' x= unExpr
					{
					match(input,18,FOLLOW_18_in_unExpr123); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr127);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Neg(x); }
					}
					break;
				case 3 :
					// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:30:4: '!' x= unExpr
					{
					match(input,11,FOLLOW_11_in_unExpr134); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr138);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Not(x); }
					}
					break;
				case 4 :
					// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:31:4: x= primary
					{
					pushFollow(FOLLOW_primary_in_unExpr147);
					x=primary();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = x; }
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 3, unExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "unExpr"



	// $ANTLR start "mulExpr"
	// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:34:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
	public final AbstractExpr mulExpr() throws RecognitionException {
		AbstractExpr result = null;

		int mulExpr_StartIndex = input.index();

		Token op=null;
		AbstractExpr lhs =null;
		AbstractExpr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:35:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:35:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
			{
			pushFollow(FOLLOW_unExpr_in_mulExpr179);
			lhs=unExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:35:45: (op= ( '*' | '/' ) rhs= unExpr )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==16||LA3_0==19) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:35:47: op= ( '*' | '/' ) rhs= unExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==16||input.LA(1)==19 ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_unExpr_in_mulExpr199);
					rhs=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { 
					      if ((op!=null?op.getText():null).equals("*")) {
					        result = new Mul(result, rhs);
					      }
					      if ((op!=null?op.getText():null).equals("/")) { // Bug TvD <= -> /
					        result = new Div(result, rhs);      
					      }
					    }
					}
					break;

				default :
					break loop3;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 4, mulExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "mulExpr"



	// $ANTLR start "addExpr"
	// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:47:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
	public final AbstractExpr addExpr() throws RecognitionException {
		AbstractExpr result = null;

		int addExpr_StartIndex = input.index();

		Token op=null;
		AbstractExpr lhs =null;
		AbstractExpr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:48:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:48:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
			{
			pushFollow(FOLLOW_mulExpr_in_addExpr240);
			lhs=mulExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:48:46: (op= ( '+' | '-' ) rhs= mulExpr )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( ((LA4_0 >= 17 && LA4_0 <= 18)) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:48:48: op= ( '+' | '-' ) rhs= mulExpr
					{
					op=input.LT(1);
					if ( (input.LA(1) >= 17 && input.LA(1) <= 18) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_mulExpr_in_addExpr258);
					rhs=mulExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { 
					      if ((op!=null?op.getText():null).equals("+")) {
					        result = new Add(result, rhs);
					      }
					      if ((op!=null?op.getText():null).equals("-")) {
					        result = new Sub(result, rhs);      
					      }
					    }
					}
					break;

				default :
					break loop4;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 5, addExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "addExpr"



	// $ANTLR start "relExpr"
	// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:59:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
	public final AbstractExpr relExpr() throws RecognitionException {
		AbstractExpr result = null;

		int relExpr_StartIndex = input.index();

		Token op=null;
		AbstractExpr lhs =null;
		AbstractExpr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:60:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:60:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			{
			pushFollow(FOLLOW_addExpr_in_relExpr293);
			lhs=addExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:60:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==12||(LA5_0 >= 21 && LA5_0 <= 25)) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:60:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==12||(input.LA(1) >= 21 && input.LA(1) <= 25) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_addExpr_in_relExpr317);
					rhs=addExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { 
					      if ((op!=null?op.getText():null).equals("<")) {
					        result = new LT(result, rhs);
					      }
					      if ((op!=null?op.getText():null).equals("<=")) {
					        result = new LEq(result, rhs);      
					      }
					      if ((op!=null?op.getText():null).equals(">")) {
					        result = new GT(result, rhs);
					      }
					      if ((op!=null?op.getText():null).equals(">=")) {
					        result = new GEq(result, rhs);      
					      }
					      if ((op!=null?op.getText():null).equals("==")) {
					        result = new Eq(result, rhs);
					      }
					      if ((op!=null?op.getText():null).equals("!=")) {
					        result = new NEq(result, rhs);
					      }
					    }
					}
					break;

				default :
					break loop5;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 6, relExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "relExpr"



	// $ANTLR start "andExpr"
	// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:83:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
	public final AbstractExpr andExpr() throws RecognitionException {
		AbstractExpr result = null;

		int andExpr_StartIndex = input.index();

		AbstractExpr lhs =null;
		AbstractExpr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:84:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:84:9: lhs= relExpr ( '&&' rhs= relExpr )*
			{
			pushFollow(FOLLOW_relExpr_in_andExpr355);
			lhs=relExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:84:46: ( '&&' rhs= relExpr )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==13) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:84:48: '&&' rhs= relExpr
					{
					match(input,13,FOLLOW_13_in_andExpr361); if (state.failed) return result;
					pushFollow(FOLLOW_relExpr_in_andExpr365);
					rhs=relExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new And(result, rhs); }
					}
					break;

				default :
					break loop6;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 7, andExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "andExpr"



	// $ANTLR start "orExpr"
	// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:88:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
	public final AbstractExpr orExpr() throws RecognitionException {
		AbstractExpr result = null;

		int orExpr_StartIndex = input.index();

		AbstractExpr lhs =null;
		AbstractExpr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:89:5: (lhs= andExpr ( '||' rhs= andExpr )* )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:89:9: lhs= andExpr ( '||' rhs= andExpr )*
			{
			pushFollow(FOLLOW_andExpr_in_orExpr400);
			lhs=andExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = lhs; }
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:89:48: ( '||' rhs= andExpr )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==28) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:89:50: '||' rhs= andExpr
					{
					match(input,28,FOLLOW_28_in_orExpr406); if (state.failed) return result;
					pushFollow(FOLLOW_andExpr_in_orExpr410);
					rhs=andExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Or(result, rhs); }
					}
					break;

				default :
					break loop7;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 8, orExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "orExpr"



	// $ANTLR start "form"
	// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:93:1: form returns [QuestionForm result] : x= statement ;
	public final QuestionForm form() throws RecognitionException {
		QuestionForm result = null;

		int form_StartIndex = input.index();

		AbstractStatement x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:94:2: (x= statement )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:94:4: x= statement
			{
			pushFollow(FOLLOW_statement_in_form436);
			x=statement();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = new QuestionForm(x); }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 9, form_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "form"



	// $ANTLR start "statement"
	// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:97:1: statement returns [Statement result] : (x= blockStatement |x= ifStatement |x= declStatement );
	public final AbstractStatement statement() throws RecognitionException {
		AbstractStatement result = null;

		int statement_StartIndex = input.index();

		AbstractStatement x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:98:6: (x= blockStatement |x= ifStatement |x= declStatement )
			int alt8=3;
			switch ( input.LA(1) ) {
			case 27:
				{
				alt8=1;
				}
				break;
			case 26:
				{
				alt8=2;
				}
				break;
			case Ident:
				{
				alt8=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}
			switch (alt8) {
				case 1 :
					// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:98:8: x= blockStatement
					{
					pushFollow(FOLLOW_blockStatement_in_statement459);
					x=blockStatement();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = x; }
					}
					break;
				case 2 :
					// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:99:8: x= ifStatement
					{
					pushFollow(FOLLOW_ifStatement_in_statement472);
					x=ifStatement();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = x; }
					}
					break;
				case 3 :
					// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:100:8: x= declStatement
					{
					pushFollow(FOLLOW_declStatement_in_statement485);
					x=declStatement();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = x; }
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 10, statement_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "statement"



	// $ANTLR start "blockStatement"
	// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:103:1: blockStatement returns [Statement result] : '{' (s= statement )* '}' ;
	public final AbstractStatement blockStatement() throws RecognitionException {
		AbstractStatement result = null;

		int blockStatement_StartIndex = input.index();

		AbstractStatement s =null;


				List<AbstractStatement> list = new ArrayList<AbstractStatement>();
			
		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:112:2: ( '{' (s= statement )* '}' )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:112:4: '{' (s= statement )* '}'
			{
			match(input,27,FOLLOW_27_in_blockStatement520); if (state.failed) return result;
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:112:8: (s= statement )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==Ident||(LA9_0 >= 26 && LA9_0 <= 27)) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:112:9: s= statement
					{
					pushFollow(FOLLOW_statement_in_blockStatement525);
					s=statement();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { list.add(s); }
					}
					break;

				default :
					break loop9;
				}
			}

			match(input,29,FOLLOW_29_in_blockStatement531); if (state.failed) return result;
			}

			if ( state.backtracking==0 ) {
					result = new Block(list);
				}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 11, blockStatement_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "blockStatement"



	// $ANTLR start "ifStatement"
	// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:115:1: ifStatement returns [Statement result] : 'if' condition= expression truePath= statement ;
	public final AbstractStatement ifStatement() throws RecognitionException {
		AbstractStatement result = null;

		int ifStatement_StartIndex = input.index();

		AbstractExpr condition =null;
		AbstractStatement truePath =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }

			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:116:6: ( 'if' condition= expression truePath= statement )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:116:8: 'if' condition= expression truePath= statement
			{
			match(input,26,FOLLOW_26_in_ifStatement550); if (state.failed) return result;
			pushFollow(FOLLOW_expression_in_ifStatement554);
			condition=expression();
			state._fsp--;
			if (state.failed) return result;
			pushFollow(FOLLOW_statement_in_ifStatement558);
			truePath=statement();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = new IfStatement(condition, truePath); }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 12, ifStatement_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "ifStatement"



	// $ANTLR start "declStatement"
	// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:120:1: declStatement returns [Statement result] : (ident= Ident ':' description= String type= Boolean (expr= expression )? |ident= Ident ':' description= String type= Money (expr= expression )? );
	public final AbstractStatement declStatement() throws RecognitionException {
		AbstractStatement result = null;

		int declStatement_StartIndex = input.index();

		Token ident=null;
		Token description=null;
		Token type=null;
		AbstractExpr expr =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return result; }

			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:121:2: (ident= Ident ':' description= String type= Boolean (expr= expression )? |ident= Ident ':' description= String type= Money (expr= expression )? )
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0==Ident) ) {
				int LA12_1 = input.LA(2);
				if ( (LA12_1==20) ) {
					int LA12_2 = input.LA(3);
					if ( (LA12_2==String) ) {
						int LA12_3 = input.LA(4);
						if ( (LA12_3==Boolean) ) {
							alt12=1;
						}
						else if ( (LA12_3==Money) ) {
							alt12=2;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return result;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 12, 3, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 12, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					if (state.backtracking>0) {state.failed=true; return result;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 12, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}

			switch (alt12) {
				case 1 :
					// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:121:4: ident= Ident ':' description= String type= Boolean (expr= expression )?
					{
					ident=(Token)match(input,Ident,FOLLOW_Ident_in_declStatement583); if (state.failed) return result;
					match(input,20,FOLLOW_20_in_declStatement585); if (state.failed) return result;
					description=(Token)match(input,String,FOLLOW_String_in_declStatement589); if (state.failed) return result;
					type=(Token)match(input,Boolean,FOLLOW_Boolean_in_declStatement593); if (state.failed) return result;
					if ( state.backtracking==0 ) {
								result = new Question((ident!=null?ident.getText():null), (description!=null?description.getText():null), new Bool());
							}
					// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:125:3: (expr= expression )?
					int alt10=2;
					int LA10_0 = input.LA(1);
					if ( (LA10_0==14) ) {
						alt10=1;
					}
					switch (alt10) {
						case 1 :
							// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:125:4: expr= expression
							{
							pushFollow(FOLLOW_expression_in_declStatement604);
							expr=expression();
							state._fsp--;
							if (state.failed) return result;
							}
							break;

					}

					if ( state.backtracking==0 ) {
								result = new Summary(result, expr);
							}
					}
					break;
				case 2 :
					// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:129:4: ident= Ident ':' description= String type= Money (expr= expression )?
					{
					ident=(Token)match(input,Ident,FOLLOW_Ident_in_declStatement617); if (state.failed) return result;
					match(input,20,FOLLOW_20_in_declStatement619); if (state.failed) return result;
					description=(Token)match(input,String,FOLLOW_String_in_declStatement623); if (state.failed) return result;
					type=(Token)match(input,Money,FOLLOW_Money_in_declStatement627); if (state.failed) return result;
					if ( state.backtracking==0 ) {
								result = new Question((ident!=null?ident.getText():null), (description!=null?description.getText():null), new Money());
							}
					// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:133:3: (expr= expression )?
					int alt11=2;
					int LA11_0 = input.LA(1);
					if ( (LA11_0==14) ) {
						alt11=1;
					}
					switch (alt11) {
						case 1 :
							// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:133:4: expr= expression
							{
							pushFollow(FOLLOW_expression_in_declStatement638);
							expr=expression();
							state._fsp--;
							if (state.failed) return result;
							}
							break;

					}

					if ( state.backtracking==0 ) {
								result = new Summary(result, expr);
							}
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 13, declStatement_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "declStatement"

	// Delegated rules



	public static final BitSet FOLLOW_Int_in_primary45 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_primary53 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_String_in_primary61 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_primary71 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_14_in_expression89 = new BitSet(new long[]{0x0000000000064AC0L});
	public static final BitSet FOLLOW_orExpr_in_expression93 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_expression95 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_17_in_unExpr112 = new BitSet(new long[]{0x0000000000064AC0L});
	public static final BitSet FOLLOW_unExpr_in_unExpr116 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_18_in_unExpr123 = new BitSet(new long[]{0x0000000000064AC0L});
	public static final BitSet FOLLOW_unExpr_in_unExpr127 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_11_in_unExpr134 = new BitSet(new long[]{0x0000000000064AC0L});
	public static final BitSet FOLLOW_unExpr_in_unExpr138 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpr147 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr179 = new BitSet(new long[]{0x0000000000090002L});
	public static final BitSet FOLLOW_set_in_mulExpr187 = new BitSet(new long[]{0x0000000000064AC0L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr199 = new BitSet(new long[]{0x0000000000090002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr240 = new BitSet(new long[]{0x0000000000060002L});
	public static final BitSet FOLLOW_set_in_addExpr248 = new BitSet(new long[]{0x0000000000064AC0L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr258 = new BitSet(new long[]{0x0000000000060002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr293 = new BitSet(new long[]{0x0000000003E01002L});
	public static final BitSet FOLLOW_set_in_relExpr301 = new BitSet(new long[]{0x0000000000064AC0L});
	public static final BitSet FOLLOW_addExpr_in_relExpr317 = new BitSet(new long[]{0x0000000003E01002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr355 = new BitSet(new long[]{0x0000000000002002L});
	public static final BitSet FOLLOW_13_in_andExpr361 = new BitSet(new long[]{0x0000000000064AC0L});
	public static final BitSet FOLLOW_relExpr_in_andExpr365 = new BitSet(new long[]{0x0000000000002002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr400 = new BitSet(new long[]{0x0000000010000002L});
	public static final BitSet FOLLOW_28_in_orExpr406 = new BitSet(new long[]{0x0000000000064AC0L});
	public static final BitSet FOLLOW_andExpr_in_orExpr410 = new BitSet(new long[]{0x0000000010000002L});
	public static final BitSet FOLLOW_statement_in_form436 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_blockStatement_in_statement459 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifStatement_in_statement472 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_declStatement_in_statement485 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_27_in_blockStatement520 = new BitSet(new long[]{0x000000002C000040L});
	public static final BitSet FOLLOW_statement_in_blockStatement525 = new BitSet(new long[]{0x000000002C000040L});
	public static final BitSet FOLLOW_29_in_blockStatement531 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_26_in_ifStatement550 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_expression_in_ifStatement554 = new BitSet(new long[]{0x000000000C000040L});
	public static final BitSet FOLLOW_statement_in_ifStatement558 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_declStatement583 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_declStatement585 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_String_in_declStatement589 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_Boolean_in_declStatement593 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_expression_in_declStatement604 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_declStatement617 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_declStatement619 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_String_in_declStatement623 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_Money_in_declStatement627 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_expression_in_declStatement638 = new BitSet(new long[]{0x0000000000000002L});
}
