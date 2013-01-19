// $ANTLR 3.5 C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g 2013-01-19 04:39:22

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expressions.*;
import org.uva.sea.ql.ast.types.*;
import org.uva.sea.ql.ast.statements.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class QLParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "Bool", "Comments", "Ident", "Int", 
		"String_literal", "WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", 
		"'-'", "'/'", "':'", "'<'", "'<='", "'=='", "'>'", "'>='", "'form'", "'if'", 
		"'{'", "'||'", "'}'"
	};
	public static final int EOF=-1;
	public static final int T__10=10;
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
	public static final int Bool=4;
	public static final int Comments=5;
	public static final int Ident=6;
	public static final int Int=7;
	public static final int String_literal=8;
	public static final int WS=9;

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
	}

	@Override public String[] getTokenNames() { return QLParser.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g"; }



	// $ANTLR start "expression"
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:19:1: expression returns [Expr result] : ( type | '(' x= orExpr ')' );
	public final Expr expression() throws RecognitionException {
		Expr result = null;


		Expr x =null;

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:20:3: ( type | '(' x= orExpr ')' )
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==Bool||(LA1_0 >= Ident && LA1_0 <= String_literal)) ) {
				alt1=1;
			}
			else if ( (LA1_0==13) ) {
				alt1=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}

			switch (alt1) {
				case 1 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:20:5: type
					{
					pushFollow(FOLLOW_type_in_expression47);
					type();
					state._fsp--;

					}
					break;
				case 2 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:21:5: '(' x= orExpr ')'
					{
					match(input,13,FOLLOW_13_in_expression53); 
					pushFollow(FOLLOW_orExpr_in_expression57);
					x=orExpr();
					state._fsp--;

					match(input,14,FOLLOW_14_in_expression59); 
					result = x;
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
		}
		return result;
	}
	// $ANTLR end "expression"



	// $ANTLR start "unExpr"
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:26:1: unExpr returns [Expr result] : ( '+' pos= unExpr | '-' neg= unExpr | '!' not= unExpr |x= expression );
	public final Expr unExpr() throws RecognitionException {
		Expr result = null;


		Expr pos =null;
		Expr neg =null;
		Expr not =null;
		Expr x =null;

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:27:5: ( '+' pos= unExpr | '-' neg= unExpr | '!' not= unExpr |x= expression )
			int alt2=4;
			switch ( input.LA(1) ) {
			case 16:
				{
				alt2=1;
				}
				break;
			case 17:
				{
				alt2=2;
				}
				break;
			case 10:
				{
				alt2=3;
				}
				break;
			case Bool:
			case Ident:
			case Int:
			case String_literal:
			case 13:
				{
				alt2=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}
			switch (alt2) {
				case 1 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:27:8: '+' pos= unExpr
					{
					match(input,16,FOLLOW_16_in_unExpr85); 
					pushFollow(FOLLOW_unExpr_in_unExpr89);
					pos=unExpr();
					state._fsp--;

					 result = new Pos(pos); 
					}
					break;
				case 2 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:28:8: '-' neg= unExpr
					{
					match(input,17,FOLLOW_17_in_unExpr100); 
					pushFollow(FOLLOW_unExpr_in_unExpr104);
					neg=unExpr();
					state._fsp--;

					 result = new Neg(neg); 
					}
					break;
				case 3 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:29:8: '!' not= unExpr
					{
					match(input,10,FOLLOW_10_in_unExpr115); 
					pushFollow(FOLLOW_unExpr_in_unExpr119);
					not=unExpr();
					state._fsp--;

					 result = new Not(not); 
					}
					break;
				case 4 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:30:8: x= expression
					{
					pushFollow(FOLLOW_expression_in_unExpr132);
					x=expression();
					state._fsp--;

					 result = x; 
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
		}
		return result;
	}
	// $ANTLR end "unExpr"



	// $ANTLR start "mulExpr"
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:34:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
	public final Expr mulExpr() throws RecognitionException {
		Expr result = null;


		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:35:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:35:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
			{
			pushFollow(FOLLOW_unExpr_in_mulExpr172);
			lhs=unExpr();
			state._fsp--;

			 result =lhs; 
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:35:45: (op= ( '*' | '/' ) rhs= unExpr )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==15||LA3_0==18) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:35:47: op= ( '*' | '/' ) rhs= unExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==15||input.LA(1)==18 ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_unExpr_in_mulExpr192);
					rhs=unExpr();
					state._fsp--;

					 
					      if ((op!=null?op.getText():null).equals("*")) {
					        result = new Mul(result, rhs);
					      }
					      if ((op!=null?op.getText():null).equals("/")) {
					        result = new Div(result, rhs);      
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
		}
		return result;
	}
	// $ANTLR end "mulExpr"



	// $ANTLR start "addExpr"
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:46:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
	public final Expr addExpr() throws RecognitionException {
		Expr result = null;


		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:47:4: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:47:8: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
			{
			pushFollow(FOLLOW_mulExpr_in_addExpr227);
			lhs=mulExpr();
			state._fsp--;

			 result =lhs; 
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:47:45: (op= ( '+' | '-' ) rhs= mulExpr )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( ((LA4_0 >= 16 && LA4_0 <= 17)) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:47:47: op= ( '+' | '-' ) rhs= mulExpr
					{
					op=input.LT(1);
					if ( (input.LA(1) >= 16 && input.LA(1) <= 17) ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_mulExpr_in_addExpr245);
					rhs=mulExpr();
					state._fsp--;

					 
					      if ((op!=null?op.getText():null).equals("+")) {
					        result = new Add(result, rhs);
					      }
					      if ((op!=null?op.getText():null).equals("-")) {
					        result = new Sub(result, rhs);      
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
		}
		return result;
	}
	// $ANTLR end "addExpr"



	// $ANTLR start "relExpr"
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:58:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
	public final Expr relExpr() throws RecognitionException {
		Expr result = null;


		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:59:3: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:59:7: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			{
			pushFollow(FOLLOW_addExpr_in_relExpr284);
			lhs=addExpr();
			state._fsp--;

			 result =lhs; 
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:59:44: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==11||(LA5_0 >= 20 && LA5_0 <= 24)) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:59:46: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==11||(input.LA(1) >= 20 && input.LA(1) <= 24) ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_addExpr_in_relExpr308);
					rhs=addExpr();
					state._fsp--;

					 
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
		}
		return result;
	}
	// $ANTLR end "relExpr"



	// $ANTLR start "andExpr"
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:82:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
	public final Expr andExpr() throws RecognitionException {
		Expr result = null;


		Expr lhs =null;
		Expr rhs =null;

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:83:3: (lhs= relExpr ( '&&' rhs= relExpr )* )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:83:5: lhs= relExpr ( '&&' rhs= relExpr )*
			{
			pushFollow(FOLLOW_relExpr_in_andExpr341);
			lhs=relExpr();
			state._fsp--;

			result = lhs;
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:83:42: ( '&&' rhs= relExpr )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==12) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:83:44: '&&' rhs= relExpr
					{
					match(input,12,FOLLOW_12_in_andExpr347); 
					pushFollow(FOLLOW_relExpr_in_andExpr351);
					rhs=relExpr();
					state._fsp--;

					result = new And (result, rhs); 
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
		}
		return result;
	}
	// $ANTLR end "andExpr"



	// $ANTLR start "orExpr"
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:86:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
	public final Expr orExpr() throws RecognitionException {
		Expr result = null;


		Expr lhs =null;
		Expr rhs =null;

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:87:3: (lhs= andExpr ( '||' rhs= andExpr )* )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:87:5: lhs= andExpr ( '||' rhs= andExpr )*
			{
			pushFollow(FOLLOW_andExpr_in_orExpr376);
			lhs=andExpr();
			state._fsp--;

			result = lhs;
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:87:43: ( '||' rhs= andExpr )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==28) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:87:45: '||' rhs= andExpr
					{
					match(input,28,FOLLOW_28_in_orExpr383); 
					pushFollow(FOLLOW_andExpr_in_orExpr387);
					rhs=andExpr();
					state._fsp--;

					result = new Or(result,rhs); 
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
		}
		return result;
	}
	// $ANTLR end "orExpr"



	// $ANTLR start "type"
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:92:1: type returns [Type result] : ( integer | ident | bool | string );
	public final Type type() throws RecognitionException {
		Type result = null;


		ParserRuleReturnScope integer1 =null;
		ParserRuleReturnScope ident2 =null;
		ParserRuleReturnScope bool3 =null;
		ParserRuleReturnScope string4 =null;

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:93:3: ( integer | ident | bool | string )
			int alt8=4;
			switch ( input.LA(1) ) {
			case Int:
				{
				alt8=1;
				}
				break;
			case Ident:
				{
				alt8=2;
				}
				break;
			case Bool:
				{
				alt8=3;
				}
				break;
			case String_literal:
				{
				alt8=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}
			switch (alt8) {
				case 1 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:93:5: integer
					{
					pushFollow(FOLLOW_integer_in_type410);
					integer1=integer();
					state._fsp--;

					result = new Int(Integer.parseInt((integer1!=null?input.toString(integer1.start,integer1.stop):null)));
					}
					break;
				case 2 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:94:5: ident
					{
					pushFollow(FOLLOW_ident_in_type418);
					ident2=ident();
					state._fsp--;

					result = new Ident((ident2!=null?input.toString(ident2.start,ident2.stop):null));
					}
					break;
				case 3 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:95:5: bool
					{
					pushFollow(FOLLOW_bool_in_type426);
					bool3=bool();
					state._fsp--;

					 result = new Bool(Boolean.parseBoolean((bool3!=null?input.toString(bool3.start,bool3.stop):null)));
					}
					break;
				case 4 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:96:5: string
					{
					pushFollow(FOLLOW_string_in_type434);
					string4=string();
					state._fsp--;

					 result = new String_lit((string4!=null?input.toString(string4.start,string4.stop):null));
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
		}
		return result;
	}
	// $ANTLR end "type"


	public static class integer_return extends ParserRuleReturnScope {
	};


	// $ANTLR start "integer"
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:99:1: integer : Int ;
	public final QLParser.integer_return integer() throws RecognitionException {
		QLParser.integer_return retval = new QLParser.integer_return();
		retval.start = input.LT(1);

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:99:9: ( Int )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:99:11: Int
			{
			match(input,Int,FOLLOW_Int_in_integer449); 
			}

			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "integer"


	public static class string_return extends ParserRuleReturnScope {
	};


	// $ANTLR start "string"
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:100:1: string : String_literal ;
	public final QLParser.string_return string() throws RecognitionException {
		QLParser.string_return retval = new QLParser.string_return();
		retval.start = input.LT(1);

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:100:8: ( String_literal )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:100:10: String_literal
			{
			match(input,String_literal,FOLLOW_String_literal_in_string458); 
			}

			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "string"


	public static class bool_return extends ParserRuleReturnScope {
	};


	// $ANTLR start "bool"
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:101:1: bool : Bool ;
	public final QLParser.bool_return bool() throws RecognitionException {
		QLParser.bool_return retval = new QLParser.bool_return();
		retval.start = input.LT(1);

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:101:6: ( Bool )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:101:8: Bool
			{
			match(input,Bool,FOLLOW_Bool_in_bool467); 
			}

			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "bool"


	public static class ident_return extends ParserRuleReturnScope {
	};


	// $ANTLR start "ident"
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:102:1: ident : Ident ;
	public final QLParser.ident_return ident() throws RecognitionException {
		QLParser.ident_return retval = new QLParser.ident_return();
		retval.start = input.LT(1);

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:102:7: ( Ident )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:102:9: Ident
			{
			match(input,Ident,FOLLOW_Ident_in_ident475); 
			}

			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "ident"



	// $ANTLR start "ifthen"
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:107:1: ifthen returns [Statement result] : 'if' expression '{' ( part )+ '}' ;
	public final Statement ifthen() throws RecognitionException {
		Statement result = null;


		Statement part5 =null;
		Expr expression6 =null;

		 List<Statement> block = new ArrayList<Statement>();
		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:109:3: ( 'if' expression '{' ( part )+ '}' )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:109:5: 'if' expression '{' ( part )+ '}'
			{
			match(input,26,FOLLOW_26_in_ifthen504); 
			pushFollow(FOLLOW_expression_in_ifthen506);
			expression6=expression();
			state._fsp--;

			match(input,27,FOLLOW_27_in_ifthen508); 
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:109:25: ( part )+
			int cnt9=0;
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==Ident||LA9_0==26) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:109:26: part
					{
					pushFollow(FOLLOW_part_in_ifthen511);
					part5=part();
					state._fsp--;

					block.add(part5);
					}
					break;

				default :
					if ( cnt9 >= 1 ) break loop9;
					EarlyExitException eee = new EarlyExitException(9, input);
					throw eee;
				}
				cnt9++;
			}

			match(input,29,FOLLOW_29_in_ifthen517); 
			result = new Ifthen(expression6 , block);
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return result;
	}
	// $ANTLR end "ifthen"



	// $ANTLR start "questions"
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:115:2: questions returns [Question result] : ( ident ':' string bool | ident ':' string type expression );
	public final Question questions() throws RecognitionException {
		Question result = null;


		ParserRuleReturnScope ident7 =null;
		ParserRuleReturnScope string8 =null;
		ParserRuleReturnScope bool9 =null;
		ParserRuleReturnScope ident10 =null;
		ParserRuleReturnScope string11 =null;
		Type type12 =null;
		Expr expression13 =null;

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:116:3: ( ident ':' string bool | ident ':' string type expression )
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==Ident) ) {
				int LA10_1 = input.LA(2);
				if ( (LA10_1==19) ) {
					int LA10_2 = input.LA(3);
					if ( (LA10_2==String_literal) ) {
						int LA10_3 = input.LA(4);
						if ( (LA10_3==Bool) ) {
							switch ( input.LA(5) ) {
							case 26:
							case 29:
								{
								alt10=1;
								}
								break;
							case Ident:
								{
								int LA10_7 = input.LA(6);
								if ( (LA10_7==19) ) {
									alt10=1;
								}
								else if ( (LA10_7==Ident||LA10_7==26||LA10_7==29) ) {
									alt10=2;
								}

								else {
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 10, 7, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

								}
								break;
							case Bool:
							case Int:
							case String_literal:
							case 13:
								{
								alt10=2;
								}
								break;
							default:
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 10, 4, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}
						}
						else if ( ((LA10_3 >= Ident && LA10_3 <= String_literal)) ) {
							alt10=2;
						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 10, 3, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 10, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 10, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}

			switch (alt10) {
				case 1 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:116:5: ident ':' string bool
					{
					pushFollow(FOLLOW_ident_in_questions540);
					ident7=ident();
					state._fsp--;

					match(input,19,FOLLOW_19_in_questions542); 
					pushFollow(FOLLOW_string_in_questions544);
					string8=string();
					state._fsp--;

					pushFollow(FOLLOW_bool_in_questions546);
					bool9=bool();
					state._fsp--;

					result = new Questions(new Ident((ident7!=null?input.toString(ident7.start,ident7.stop):null)) , new String_lit((string8!=null?input.toString(string8.start,string8.stop):null)) , new Bool(Boolean.parseBoolean((bool9!=null?input.toString(bool9.start,bool9.stop):null))));
					}
					break;
				case 2 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:117:5: ident ':' string type expression
					{
					pushFollow(FOLLOW_ident_in_questions554);
					ident10=ident();
					state._fsp--;

					match(input,19,FOLLOW_19_in_questions556); 
					pushFollow(FOLLOW_string_in_questions558);
					string11=string();
					state._fsp--;

					pushFollow(FOLLOW_type_in_questions560);
					type12=type();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_questions562);
					expression13=expression();
					state._fsp--;

					result = new ComQuestions(new Ident((ident10!=null?input.toString(ident10.start,ident10.stop):null)) , new String_lit((string11!=null?input.toString(string11.start,string11.stop):null)) , type12 , expression13);
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
		}
		return result;
	}
	// $ANTLR end "questions"



	// $ANTLR start "part"
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:128:1: part returns [Statement result] : ( ifthen | questions );
	public final Statement part() throws RecognitionException {
		Statement result = null;


		Statement ifthen14 =null;
		Question questions15 =null;

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:129:3: ( ifthen | questions )
			int alt11=2;
			int LA11_0 = input.LA(1);
			if ( (LA11_0==26) ) {
				alt11=1;
			}
			else if ( (LA11_0==Ident) ) {
				alt11=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}

			switch (alt11) {
				case 1 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:129:5: ifthen
					{
					pushFollow(FOLLOW_ifthen_in_part590);
					ifthen14=ifthen();
					state._fsp--;

					 result = ifthen14; 
					}
					break;
				case 2 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:130:5: questions
					{
					pushFollow(FOLLOW_questions_in_part598);
					questions15=questions();
					state._fsp--;

					 result = questions15; 
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
		}
		return result;
	}
	// $ANTLR end "part"



	// $ANTLR start "form"
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:134:1: form returns [Form result] : 'form' ident '{' ( part )+ '}' ;
	public final Form form() throws RecognitionException {
		Form result = null;


		Statement part16 =null;
		ParserRuleReturnScope ident17 =null;

		 List<Statement> formpart = new ArrayList<Statement>();
		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:136:2: ( 'form' ident '{' ( part )+ '}' )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:136:5: 'form' ident '{' ( part )+ '}'
			{
			match(input,25,FOLLOW_25_in_form627); 
			pushFollow(FOLLOW_ident_in_form629);
			ident17=ident();
			state._fsp--;

			match(input,27,FOLLOW_27_in_form631); 
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:136:22: ( part )+
			int cnt12=0;
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( (LA12_0==Ident||LA12_0==26) ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:136:23: part
					{
					pushFollow(FOLLOW_part_in_form634);
					part16=part();
					state._fsp--;

					formpart.add(part16);
					}
					break;

				default :
					if ( cnt12 >= 1 ) break loop12;
					EarlyExitException eee = new EarlyExitException(12, input);
					throw eee;
				}
				cnt12++;
			}

			match(input,29,FOLLOW_29_in_form640); 
			result = new Form (new Ident((ident17!=null?input.toString(ident17.start,ident17.stop):null)), formpart);
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return result;
	}
	// $ANTLR end "form"

	// Delegated rules



	public static final BitSet FOLLOW_type_in_expression47 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_13_in_expression53 = new BitSet(new long[]{0x00000000000325D0L});
	public static final BitSet FOLLOW_orExpr_in_expression57 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_expression59 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_16_in_unExpr85 = new BitSet(new long[]{0x00000000000325D0L});
	public static final BitSet FOLLOW_unExpr_in_unExpr89 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_17_in_unExpr100 = new BitSet(new long[]{0x00000000000325D0L});
	public static final BitSet FOLLOW_unExpr_in_unExpr104 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_unExpr115 = new BitSet(new long[]{0x00000000000325D0L});
	public static final BitSet FOLLOW_unExpr_in_unExpr119 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_unExpr132 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr172 = new BitSet(new long[]{0x0000000000048002L});
	public static final BitSet FOLLOW_set_in_mulExpr180 = new BitSet(new long[]{0x00000000000325D0L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr192 = new BitSet(new long[]{0x0000000000048002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr227 = new BitSet(new long[]{0x0000000000030002L});
	public static final BitSet FOLLOW_set_in_addExpr235 = new BitSet(new long[]{0x00000000000325D0L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr245 = new BitSet(new long[]{0x0000000000030002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr284 = new BitSet(new long[]{0x0000000001F00802L});
	public static final BitSet FOLLOW_set_in_relExpr292 = new BitSet(new long[]{0x00000000000325D0L});
	public static final BitSet FOLLOW_addExpr_in_relExpr308 = new BitSet(new long[]{0x0000000001F00802L});
	public static final BitSet FOLLOW_relExpr_in_andExpr341 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_12_in_andExpr347 = new BitSet(new long[]{0x00000000000325D0L});
	public static final BitSet FOLLOW_relExpr_in_andExpr351 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr376 = new BitSet(new long[]{0x0000000010000002L});
	public static final BitSet FOLLOW_28_in_orExpr383 = new BitSet(new long[]{0x00000000000325D0L});
	public static final BitSet FOLLOW_andExpr_in_orExpr387 = new BitSet(new long[]{0x0000000010000002L});
	public static final BitSet FOLLOW_integer_in_type410 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ident_in_type418 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_bool_in_type426 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_string_in_type434 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Int_in_integer449 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_String_literal_in_string458 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Bool_in_bool467 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_ident475 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_26_in_ifthen504 = new BitSet(new long[]{0x00000000000021D0L});
	public static final BitSet FOLLOW_expression_in_ifthen506 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_27_in_ifthen508 = new BitSet(new long[]{0x0000000004000040L});
	public static final BitSet FOLLOW_part_in_ifthen511 = new BitSet(new long[]{0x0000000024000040L});
	public static final BitSet FOLLOW_29_in_ifthen517 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ident_in_questions540 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_questions542 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_string_in_questions544 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_bool_in_questions546 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ident_in_questions554 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_questions556 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_string_in_questions558 = new BitSet(new long[]{0x00000000000001D0L});
	public static final BitSet FOLLOW_type_in_questions560 = new BitSet(new long[]{0x00000000000021D0L});
	public static final BitSet FOLLOW_expression_in_questions562 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifthen_in_part590 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_questions_in_part598 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_25_in_form627 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ident_in_form629 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_27_in_form631 = new BitSet(new long[]{0x0000000004000040L});
	public static final BitSet FOLLOW_part_in_form634 = new BitSet(new long[]{0x0000000024000040L});
	public static final BitSet FOLLOW_29_in_form640 = new BitSet(new long[]{0x0000000000000002L});
}
