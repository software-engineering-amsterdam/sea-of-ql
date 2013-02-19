// $ANTLR 3.5 C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g 2013-02-19 02:23:09

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.types.*;
import org.uva.sea.ql.ast.expr.*;
import org.uva.sea.ql.ast.expr.value.*;
import org.uva.sea.ql.ast.expr.binary.*;
import org.uva.sea.ql.ast.expr.unary.*;
import org.uva.sea.ql.ast.formelements.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings("all")
public class QLParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "BOOLEAN", "BoolLiteral", "Comment", 
		"INTEGER", "Ident", "IntLiteral", "LineComment", "MONEY", "MoneyLiteral", 
		"STRING", "StringLiteral", "Ws", "'!'", "'!='", "'&&'", "'('", "')'", 
		"'*'", "'+'", "'-'", "'/'", "':'", "'<'", "'<='", "'=='", "'>'", "'>='", 
		"'else'", "'form'", "'if'", "'{'", "'||'", "'}'"
	};
	public static final int EOF=-1;
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
	public static final int T__30=30;
	public static final int T__31=31;
	public static final int T__32=32;
	public static final int T__33=33;
	public static final int T__34=34;
	public static final int T__35=35;
	public static final int T__36=36;
	public static final int BOOLEAN=4;
	public static final int BoolLiteral=5;
	public static final int Comment=6;
	public static final int INTEGER=7;
	public static final int Ident=8;
	public static final int IntLiteral=9;
	public static final int LineComment=10;
	public static final int MONEY=11;
	public static final int MoneyLiteral=12;
	public static final int STRING=13;
	public static final int StringLiteral=14;
	public static final int Ws=15;

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
		this.state.ruleMemo = new HashMap[38+1];


	}

	@Override public String[] getTokenNames() { return QLParser.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g"; }



	// $ANTLR start "primary"
	// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:23:1: primary returns [Expr result] : ( IntLiteral | MoneyLiteral | BoolLiteral | StringLiteral | Ident | '(' x= orExpr ')' );
	public final Expr primary() throws RecognitionException {
		Expr result = null;

		int primary_StartIndex = input.index();

		Token IntLiteral1=null;
		Token MoneyLiteral2=null;
		Token BoolLiteral3=null;
		Token StringLiteral4=null;
		Token Ident5=null;
		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:24:4: ( IntLiteral | MoneyLiteral | BoolLiteral | StringLiteral | Ident | '(' x= orExpr ')' )
			int alt1=6;
			switch ( input.LA(1) ) {
			case IntLiteral:
				{
				alt1=1;
				}
				break;
			case MoneyLiteral:
				{
				alt1=2;
				}
				break;
			case BoolLiteral:
				{
				alt1=3;
				}
				break;
			case StringLiteral:
				{
				alt1=4;
				}
				break;
			case Ident:
				{
				alt1=5;
				}
				break;
			case 19:
				{
				alt1=6;
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
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:24:6: IntLiteral
					{
					IntLiteral1=(Token)match(input,IntLiteral,FOLLOW_IntLiteral_in_primary50); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new IntLiteral(Integer.parseInt((IntLiteral1!=null?IntLiteral1.getText():null))); }
					}
					break;
				case 2 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:25:6: MoneyLiteral
					{
					MoneyLiteral2=(Token)match(input,MoneyLiteral,FOLLOW_MoneyLiteral_in_primary69); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new MoneyLiteral(Double.parseDouble((MoneyLiteral2!=null?MoneyLiteral2.getText():null))) ;}
					}
					break;
				case 3 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:26:6: BoolLiteral
					{
					BoolLiteral3=(Token)match(input,BoolLiteral,FOLLOW_BoolLiteral_in_primary86); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new BoolLiteral(Boolean.parseBoolean((BoolLiteral3!=null?BoolLiteral3.getText():null))) ;}
					}
					break;
				case 4 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:27:6: StringLiteral
					{
					StringLiteral4=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_primary104); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new StringLiteral((StringLiteral4!=null?StringLiteral4.getText():null));}
					}
					break;
				case 5 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:28:6: Ident
					{
					Ident5=(Token)match(input,Ident,FOLLOW_Ident_in_primary120); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Ident((Ident5!=null?Ident5.getText():null)); }
					}
					break;
				case 6 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:29:6: '(' x= orExpr ')'
					{
					match(input,19,FOLLOW_19_in_primary144); if (state.failed) return result;
					pushFollow(FOLLOW_orExpr_in_primary148);
					x=orExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,20,FOLLOW_20_in_primary150); if (state.failed) return result;
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



	// $ANTLR start "type"
	// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:32:1: type returns [Type result] : ( INTEGER | BOOLEAN | STRING | MONEY );
	public final Type type() throws RecognitionException {
		Type result = null;

		int type_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:33:4: ( INTEGER | BOOLEAN | STRING | MONEY )
			int alt2=4;
			switch ( input.LA(1) ) {
			case INTEGER:
				{
				alt2=1;
				}
				break;
			case BOOLEAN:
				{
				alt2=2;
				}
				break;
			case STRING:
				{
				alt2=3;
				}
				break;
			case MONEY:
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
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:33:5: INTEGER
					{
					match(input,INTEGER,FOLLOW_INTEGER_in_type176); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new IntType();}
					}
					break;
				case 2 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:34:5: BOOLEAN
					{
					match(input,BOOLEAN,FOLLOW_BOOLEAN_in_type185); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new BoolType();}
					}
					break;
				case 3 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:35:5: STRING
					{
					match(input,STRING,FOLLOW_STRING_in_type194); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new StringType();}
					}
					break;
				case 4 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:36:5: MONEY
					{
					match(input,MONEY,FOLLOW_MONEY_in_type203); if (state.failed) return result;
					if ( state.backtracking==0 ) {result = new MoneyType();}
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
			if ( state.backtracking>0 ) { memoize(input, 2, type_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "type"



	// $ANTLR start "unExpr"
	// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:39:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
	public final Expr unExpr() throws RecognitionException {
		Expr result = null;

		int unExpr_StartIndex = input.index();

		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:40:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
			int alt3=4;
			switch ( input.LA(1) ) {
			case 22:
				{
				alt3=1;
				}
				break;
			case 23:
				{
				alt3=2;
				}
				break;
			case 16:
				{
				alt3=3;
				}
				break;
			case BoolLiteral:
			case Ident:
			case IntLiteral:
			case MoneyLiteral:
			case StringLiteral:
			case 19:
				{
				alt3=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}
			switch (alt3) {
				case 1 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:40:8: '+' x= unExpr
					{
					match(input,22,FOLLOW_22_in_unExpr232); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr236);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Pos(x); }
					}
					break;
				case 2 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:41:8: '-' x= unExpr
					{
					match(input,23,FOLLOW_23_in_unExpr247); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr251);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Neg(x); }
					}
					break;
				case 3 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:42:8: '!' x= unExpr
					{
					match(input,16,FOLLOW_16_in_unExpr262); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr266);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Not(x); }
					}
					break;
				case 4 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:43:8: x= primary
					{
					pushFollow(FOLLOW_primary_in_unExpr279);
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
	// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:46:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
	public final Expr mulExpr() throws RecognitionException {
		Expr result = null;

		int mulExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:47:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:47:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
			{
			pushFollow(FOLLOW_unExpr_in_mulExpr317);
			lhs=unExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:47:45: (op= ( '*' | '/' ) rhs= unExpr )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==21||LA4_0==24) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:47:47: op= ( '*' | '/' ) rhs= unExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==21||input.LA(1)==24 ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_unExpr_in_mulExpr337);
					rhs=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { 
					      if ((op!=null?op.getText():null).equals("*")) {
					        result = new Mul(result, rhs);
					      }
					      if ((op!=null?op.getText():null).equals("/")) {
					        result = new Div(result, rhs);      
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
			if ( state.backtracking>0 ) { memoize(input, 4, mulExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "mulExpr"



	// $ANTLR start "addExpr"
	// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:58:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
	public final Expr addExpr() throws RecognitionException {
		Expr result = null;

		int addExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:59:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:59:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
			{
			pushFollow(FOLLOW_mulExpr_in_addExpr375);
			lhs=mulExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:59:46: (op= ( '+' | '-' ) rhs= mulExpr )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( ((LA5_0 >= 22 && LA5_0 <= 23)) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:59:48: op= ( '+' | '-' ) rhs= mulExpr
					{
					op=input.LT(1);
					if ( (input.LA(1) >= 22 && input.LA(1) <= 23) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_mulExpr_in_addExpr393);
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
			if ( state.backtracking>0 ) { memoize(input, 5, addExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "addExpr"



	// $ANTLR start "relExpr"
	// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:70:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
	public final Expr relExpr() throws RecognitionException {
		Expr result = null;

		int relExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:71:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:71:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			{
			pushFollow(FOLLOW_addExpr_in_relExpr428);
			lhs=addExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:71:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==17||(LA6_0 >= 26 && LA6_0 <= 30)) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:71:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==17||(input.LA(1) >= 26 && input.LA(1) <= 30) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_addExpr_in_relExpr452);
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
			if ( state.backtracking>0 ) { memoize(input, 6, relExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "relExpr"



	// $ANTLR start "andExpr"
	// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:94:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
	public final Expr andExpr() throws RecognitionException {
		Expr result = null;

		int andExpr_StartIndex = input.index();

		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:95:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:95:9: lhs= relExpr ( '&&' rhs= relExpr )*
			{
			pushFollow(FOLLOW_relExpr_in_andExpr490);
			lhs=relExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:95:46: ( '&&' rhs= relExpr )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==18) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:95:48: '&&' rhs= relExpr
					{
					match(input,18,FOLLOW_18_in_andExpr496); if (state.failed) return result;
					pushFollow(FOLLOW_relExpr_in_andExpr500);
					rhs=relExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new And(result, rhs); }
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
			if ( state.backtracking>0 ) { memoize(input, 7, andExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "andExpr"



	// $ANTLR start "orExpr"
	// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:98:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
	public final Expr orExpr() throws RecognitionException {
		Expr result = null;

		int orExpr_StartIndex = input.index();

		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:99:5: (lhs= andExpr ( '||' rhs= andExpr )* )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:99:9: lhs= andExpr ( '||' rhs= andExpr )*
			{
			pushFollow(FOLLOW_andExpr_in_orExpr534);
			lhs=andExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = lhs; }
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:99:48: ( '||' rhs= andExpr )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==35) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:99:50: '||' rhs= andExpr
					{
					match(input,35,FOLLOW_35_in_orExpr540); if (state.failed) return result;
					pushFollow(FOLLOW_andExpr_in_orExpr544);
					rhs=andExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Or(result, rhs); }
					}
					break;

				default :
					break loop8;
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



	// $ANTLR start "formElement"
	// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:102:1: formElement returns [FormElement result] : ( 'if' '(' x= orExpr ')' '{' thenbody= formblock '}' 'else' '{' elsebody= formblock '}' | 'if' '(' x= orExpr ')' '{' thenbody= formblock '}' | Ident ':' StringLiteral type '(' orExpr ')' | Ident ':' StringLiteral type );
	public final FormElement formElement() throws RecognitionException {
		FormElement result = null;

		int formElement_StartIndex = input.index();

		Token Ident6=null;
		Token StringLiteral7=null;
		Token Ident10=null;
		Token StringLiteral11=null;
		Expr x =null;
		Block thenbody =null;
		Block elsebody =null;
		Type type8 =null;
		Expr orExpr9 =null;
		Type type12 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:103:5: ( 'if' '(' x= orExpr ')' '{' thenbody= formblock '}' 'else' '{' elsebody= formblock '}' | 'if' '(' x= orExpr ')' '{' thenbody= formblock '}' | Ident ':' StringLiteral type '(' orExpr ')' | Ident ':' StringLiteral type )
			int alt9=4;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==33) ) {
				int LA9_1 = input.LA(2);
				if ( (synpred24_QL()) ) {
					alt9=1;
				}
				else if ( (synpred25_QL()) ) {
					alt9=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return result;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 9, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA9_0==Ident) ) {
				int LA9_2 = input.LA(2);
				if ( (synpred26_QL()) ) {
					alt9=3;
				}
				else if ( (true) ) {
					alt9=4;
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}

			switch (alt9) {
				case 1 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:103:7: 'if' '(' x= orExpr ')' '{' thenbody= formblock '}' 'else' '{' elsebody= formblock '}'
					{
					match(input,33,FOLLOW_33_in_formElement570); if (state.failed) return result;
					match(input,19,FOLLOW_19_in_formElement572); if (state.failed) return result;
					pushFollow(FOLLOW_orExpr_in_formElement578);
					x=orExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,20,FOLLOW_20_in_formElement580); if (state.failed) return result;
					match(input,34,FOLLOW_34_in_formElement583); if (state.failed) return result;
					pushFollow(FOLLOW_formblock_in_formElement587);
					thenbody=formblock();
					state._fsp--;
					if (state.failed) return result;
					match(input,36,FOLLOW_36_in_formElement589); if (state.failed) return result;
					match(input,31,FOLLOW_31_in_formElement591); if (state.failed) return result;
					match(input,34,FOLLOW_34_in_formElement593); if (state.failed) return result;
					pushFollow(FOLLOW_formblock_in_formElement599);
					elsebody=formblock();
					state._fsp--;
					if (state.failed) return result;
					match(input,36,FOLLOW_36_in_formElement601); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new IfThenElse(x, thenbody, elsebody); }
					}
					break;
				case 2 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:104:7: 'if' '(' x= orExpr ')' '{' thenbody= formblock '}'
					{
					match(input,33,FOLLOW_33_in_formElement611); if (state.failed) return result;
					match(input,19,FOLLOW_19_in_formElement613); if (state.failed) return result;
					pushFollow(FOLLOW_orExpr_in_formElement619);
					x=orExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,20,FOLLOW_20_in_formElement621); if (state.failed) return result;
					match(input,34,FOLLOW_34_in_formElement624); if (state.failed) return result;
					pushFollow(FOLLOW_formblock_in_formElement628);
					thenbody=formblock();
					state._fsp--;
					if (state.failed) return result;
					match(input,36,FOLLOW_36_in_formElement630); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new IfThen(x, thenbody); }
					}
					break;
				case 3 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:105:7: Ident ':' StringLiteral type '(' orExpr ')'
					{
					Ident6=(Token)match(input,Ident,FOLLOW_Ident_in_formElement641); if (state.failed) return result;
					match(input,25,FOLLOW_25_in_formElement643); if (state.failed) return result;
					StringLiteral7=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_formElement645); if (state.failed) return result;
					pushFollow(FOLLOW_type_in_formElement647);
					type8=type();
					state._fsp--;
					if (state.failed) return result;
					match(input,19,FOLLOW_19_in_formElement649); if (state.failed) return result;
					pushFollow(FOLLOW_orExpr_in_formElement651);
					orExpr9=orExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,20,FOLLOW_20_in_formElement653); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new CompQuestion(new Ident((Ident6!=null?Ident6.getText():null)) ,new StringLiteral((StringLiteral7!=null?StringLiteral7.getText():null)), type8, orExpr9); }
					}
					break;
				case 4 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:106:7: Ident ':' StringLiteral type
					{
					Ident10=(Token)match(input,Ident,FOLLOW_Ident_in_formElement663); if (state.failed) return result;
					match(input,25,FOLLOW_25_in_formElement665); if (state.failed) return result;
					StringLiteral11=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_formElement667); if (state.failed) return result;
					pushFollow(FOLLOW_type_in_formElement669);
					type12=type();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Question(new Ident((Ident10!=null?Ident10.getText():null)) ,new StringLiteral((StringLiteral11!=null?StringLiteral11.getText():null)), type12); }
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
			if ( state.backtracking>0 ) { memoize(input, 9, formElement_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "formElement"



	// $ANTLR start "formblock"
	// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:109:2: formblock returns [Block result] : ( formElement )* ;
	public final Block formblock() throws RecognitionException {
		Block result = null;

		int formblock_StartIndex = input.index();

		FormElement formElement13 =null;


		          Block formblock = new Block();
		    
		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:113:5: ( ( formElement )* )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:113:7: ( formElement )*
			{
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:113:7: ( formElement )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==Ident||LA10_0==33) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:113:8: formElement
					{
					pushFollow(FOLLOW_formElement_in_formblock700);
					formElement13=formElement();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {formblock.addElement(formElement13);}
					}
					break;

				default :
					break loop10;
				}
			}

			if ( state.backtracking==0 ) {result =formblock;}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 10, formblock_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "formblock"



	// $ANTLR start "form"
	// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:117:1: form returns [Form result] : 'form' Ident '{' fb= formblock '}' EOF ;
	public final Form form() throws RecognitionException {
		Form result = null;

		int form_StartIndex = input.index();

		Token Ident14=null;
		Block fb =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:118:5: ( 'form' Ident '{' fb= formblock '}' EOF )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:118:7: 'form' Ident '{' fb= formblock '}' EOF
			{
			match(input,32,FOLLOW_32_in_form732); if (state.failed) return result;
			Ident14=(Token)match(input,Ident,FOLLOW_Ident_in_form734); if (state.failed) return result;
			match(input,34,FOLLOW_34_in_form736); if (state.failed) return result;
			pushFollow(FOLLOW_formblock_in_form742);
			fb=formblock();
			state._fsp--;
			if (state.failed) return result;
			match(input,36,FOLLOW_36_in_form744); if (state.failed) return result;
			match(input,EOF,FOLLOW_EOF_in_form746); if (state.failed) return result;
			if ( state.backtracking==0 ) { result = new Form(new Ident((Ident14!=null?Ident14.getText():null)), fb); }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 11, form_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "form"

	// $ANTLR start synpred24_QL
	public final void synpred24_QL_fragment() throws RecognitionException {
		Expr x =null;
		Block thenbody =null;
		Block elsebody =null;

		// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:103:7: ( 'if' '(' x= orExpr ')' '{' thenbody= formblock '}' 'else' '{' elsebody= formblock '}' )
		// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:103:7: 'if' '(' x= orExpr ')' '{' thenbody= formblock '}' 'else' '{' elsebody= formblock '}'
		{
		match(input,33,FOLLOW_33_in_synpred24_QL570); if (state.failed) return;
		match(input,19,FOLLOW_19_in_synpred24_QL572); if (state.failed) return;
		pushFollow(FOLLOW_orExpr_in_synpred24_QL578);
		x=orExpr();
		state._fsp--;
		if (state.failed) return;
		match(input,20,FOLLOW_20_in_synpred24_QL580); if (state.failed) return;
		match(input,34,FOLLOW_34_in_synpred24_QL583); if (state.failed) return;
		pushFollow(FOLLOW_formblock_in_synpred24_QL587);
		thenbody=formblock();
		state._fsp--;
		if (state.failed) return;
		match(input,36,FOLLOW_36_in_synpred24_QL589); if (state.failed) return;
		match(input,31,FOLLOW_31_in_synpred24_QL591); if (state.failed) return;
		match(input,34,FOLLOW_34_in_synpred24_QL593); if (state.failed) return;
		pushFollow(FOLLOW_formblock_in_synpred24_QL599);
		elsebody=formblock();
		state._fsp--;
		if (state.failed) return;
		match(input,36,FOLLOW_36_in_synpred24_QL601); if (state.failed) return;
		}

	}
	// $ANTLR end synpred24_QL

	// $ANTLR start synpred25_QL
	public final void synpred25_QL_fragment() throws RecognitionException {
		Expr x =null;
		Block thenbody =null;

		// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:104:7: ( 'if' '(' x= orExpr ')' '{' thenbody= formblock '}' )
		// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:104:7: 'if' '(' x= orExpr ')' '{' thenbody= formblock '}'
		{
		match(input,33,FOLLOW_33_in_synpred25_QL611); if (state.failed) return;
		match(input,19,FOLLOW_19_in_synpred25_QL613); if (state.failed) return;
		pushFollow(FOLLOW_orExpr_in_synpred25_QL619);
		x=orExpr();
		state._fsp--;
		if (state.failed) return;
		match(input,20,FOLLOW_20_in_synpred25_QL621); if (state.failed) return;
		match(input,34,FOLLOW_34_in_synpred25_QL624); if (state.failed) return;
		pushFollow(FOLLOW_formblock_in_synpred25_QL628);
		thenbody=formblock();
		state._fsp--;
		if (state.failed) return;
		match(input,36,FOLLOW_36_in_synpred25_QL630); if (state.failed) return;
		}

	}
	// $ANTLR end synpred25_QL

	// $ANTLR start synpred26_QL
	public final void synpred26_QL_fragment() throws RecognitionException {
		// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:105:7: ( Ident ':' StringLiteral type '(' orExpr ')' )
		// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:105:7: Ident ':' StringLiteral type '(' orExpr ')'
		{
		match(input,Ident,FOLLOW_Ident_in_synpred26_QL641); if (state.failed) return;
		match(input,25,FOLLOW_25_in_synpred26_QL643); if (state.failed) return;
		match(input,StringLiteral,FOLLOW_StringLiteral_in_synpred26_QL645); if (state.failed) return;
		pushFollow(FOLLOW_type_in_synpred26_QL647);
		type();
		state._fsp--;
		if (state.failed) return;
		match(input,19,FOLLOW_19_in_synpred26_QL649); if (state.failed) return;
		pushFollow(FOLLOW_orExpr_in_synpred26_QL651);
		orExpr();
		state._fsp--;
		if (state.failed) return;
		match(input,20,FOLLOW_20_in_synpred26_QL653); if (state.failed) return;
		}

	}
	// $ANTLR end synpred26_QL

	// Delegated rules

	public final boolean synpred26_QL() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred26_QL_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred25_QL() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred25_QL_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred24_QL() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred24_QL_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}



	public static final BitSet FOLLOW_IntLiteral_in_primary50 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MoneyLiteral_in_primary69 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BoolLiteral_in_primary86 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_StringLiteral_in_primary104 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_primary120 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_19_in_primary144 = new BitSet(new long[]{0x0000000000C95320L});
	public static final BitSet FOLLOW_orExpr_in_primary148 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_primary150 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTEGER_in_type176 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BOOLEAN_in_type185 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_in_type194 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MONEY_in_type203 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_22_in_unExpr232 = new BitSet(new long[]{0x0000000000C95320L});
	public static final BitSet FOLLOW_unExpr_in_unExpr236 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_23_in_unExpr247 = new BitSet(new long[]{0x0000000000C95320L});
	public static final BitSet FOLLOW_unExpr_in_unExpr251 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_16_in_unExpr262 = new BitSet(new long[]{0x0000000000C95320L});
	public static final BitSet FOLLOW_unExpr_in_unExpr266 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpr279 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr317 = new BitSet(new long[]{0x0000000001200002L});
	public static final BitSet FOLLOW_set_in_mulExpr325 = new BitSet(new long[]{0x0000000000C95320L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr337 = new BitSet(new long[]{0x0000000001200002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr375 = new BitSet(new long[]{0x0000000000C00002L});
	public static final BitSet FOLLOW_set_in_addExpr383 = new BitSet(new long[]{0x0000000000C95320L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr393 = new BitSet(new long[]{0x0000000000C00002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr428 = new BitSet(new long[]{0x000000007C020002L});
	public static final BitSet FOLLOW_set_in_relExpr436 = new BitSet(new long[]{0x0000000000C95320L});
	public static final BitSet FOLLOW_addExpr_in_relExpr452 = new BitSet(new long[]{0x000000007C020002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr490 = new BitSet(new long[]{0x0000000000040002L});
	public static final BitSet FOLLOW_18_in_andExpr496 = new BitSet(new long[]{0x0000000000C95320L});
	public static final BitSet FOLLOW_relExpr_in_andExpr500 = new BitSet(new long[]{0x0000000000040002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr534 = new BitSet(new long[]{0x0000000800000002L});
	public static final BitSet FOLLOW_35_in_orExpr540 = new BitSet(new long[]{0x0000000000C95320L});
	public static final BitSet FOLLOW_andExpr_in_orExpr544 = new BitSet(new long[]{0x0000000800000002L});
	public static final BitSet FOLLOW_33_in_formElement570 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_formElement572 = new BitSet(new long[]{0x0000000000C95320L});
	public static final BitSet FOLLOW_orExpr_in_formElement578 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_formElement580 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_34_in_formElement583 = new BitSet(new long[]{0x0000001200000100L});
	public static final BitSet FOLLOW_formblock_in_formElement587 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_36_in_formElement589 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_formElement591 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_34_in_formElement593 = new BitSet(new long[]{0x0000001200000100L});
	public static final BitSet FOLLOW_formblock_in_formElement599 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_36_in_formElement601 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_33_in_formElement611 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_formElement613 = new BitSet(new long[]{0x0000000000C95320L});
	public static final BitSet FOLLOW_orExpr_in_formElement619 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_formElement621 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_34_in_formElement624 = new BitSet(new long[]{0x0000001200000100L});
	public static final BitSet FOLLOW_formblock_in_formElement628 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_36_in_formElement630 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_formElement641 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_25_in_formElement643 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_StringLiteral_in_formElement645 = new BitSet(new long[]{0x0000000000002890L});
	public static final BitSet FOLLOW_type_in_formElement647 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_formElement649 = new BitSet(new long[]{0x0000000000C95320L});
	public static final BitSet FOLLOW_orExpr_in_formElement651 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_formElement653 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_formElement663 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_25_in_formElement665 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_StringLiteral_in_formElement667 = new BitSet(new long[]{0x0000000000002890L});
	public static final BitSet FOLLOW_type_in_formElement669 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_formElement_in_formblock700 = new BitSet(new long[]{0x0000000200000102L});
	public static final BitSet FOLLOW_32_in_form732 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_Ident_in_form734 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_34_in_form736 = new BitSet(new long[]{0x0000001200000100L});
	public static final BitSet FOLLOW_formblock_in_form742 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_36_in_form744 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_form746 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_33_in_synpred24_QL570 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_synpred24_QL572 = new BitSet(new long[]{0x0000000000C95320L});
	public static final BitSet FOLLOW_orExpr_in_synpred24_QL578 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_synpred24_QL580 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_34_in_synpred24_QL583 = new BitSet(new long[]{0x0000001200000100L});
	public static final BitSet FOLLOW_formblock_in_synpred24_QL587 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_36_in_synpred24_QL589 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_synpred24_QL591 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_34_in_synpred24_QL593 = new BitSet(new long[]{0x0000001200000100L});
	public static final BitSet FOLLOW_formblock_in_synpred24_QL599 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_36_in_synpred24_QL601 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_33_in_synpred25_QL611 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_synpred25_QL613 = new BitSet(new long[]{0x0000000000C95320L});
	public static final BitSet FOLLOW_orExpr_in_synpred25_QL619 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_synpred25_QL621 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_34_in_synpred25_QL624 = new BitSet(new long[]{0x0000001200000100L});
	public static final BitSet FOLLOW_formblock_in_synpred25_QL628 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_36_in_synpred25_QL630 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_synpred26_QL641 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_25_in_synpred26_QL643 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_StringLiteral_in_synpred26_QL645 = new BitSet(new long[]{0x0000000000002890L});
	public static final BitSet FOLLOW_type_in_synpred26_QL647 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_synpred26_QL649 = new BitSet(new long[]{0x0000000000C95320L});
	public static final BitSet FOLLOW_orExpr_in_synpred26_QL651 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_synpred26_QL653 = new BitSet(new long[]{0x0000000000000002L});
}
