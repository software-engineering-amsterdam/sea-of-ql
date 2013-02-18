// $ANTLR 3.5 C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g 2013-02-17 21:39:22

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
	// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:22:1: primary returns [Expr result] : ( IntLiteral | MoneyLiteral | BoolLiteral | StringLiteral | Ident | '(' x= orExpr ')' );
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

			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:23:4: ( IntLiteral | MoneyLiteral | BoolLiteral | StringLiteral | Ident | '(' x= orExpr ')' )
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
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:23:6: IntLiteral
					{
					IntLiteral1=(Token)match(input,IntLiteral,FOLLOW_IntLiteral_in_primary49); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new IntLiteral(Integer.parseInt((IntLiteral1!=null?IntLiteral1.getText():null))); }
					}
					break;
				case 2 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:24:6: MoneyLiteral
					{
					MoneyLiteral2=(Token)match(input,MoneyLiteral,FOLLOW_MoneyLiteral_in_primary68); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new MoneyLiteral(Double.parseDouble((MoneyLiteral2!=null?MoneyLiteral2.getText():null))) ;}
					}
					break;
				case 3 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:25:6: BoolLiteral
					{
					BoolLiteral3=(Token)match(input,BoolLiteral,FOLLOW_BoolLiteral_in_primary85); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new BoolLiteral(Boolean.parseBoolean((BoolLiteral3!=null?BoolLiteral3.getText():null))) ;}
					}
					break;
				case 4 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:26:6: StringLiteral
					{
					StringLiteral4=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_primary103); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new StringLiteral((StringLiteral4!=null?StringLiteral4.getText():null));}
					}
					break;
				case 5 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:27:6: Ident
					{
					Ident5=(Token)match(input,Ident,FOLLOW_Ident_in_primary119); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Ident((Ident5!=null?Ident5.getText():null)); }
					}
					break;
				case 6 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:28:6: '(' x= orExpr ')'
					{
					match(input,19,FOLLOW_19_in_primary143); if (state.failed) return result;
					pushFollow(FOLLOW_orExpr_in_primary147);
					x=orExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,20,FOLLOW_20_in_primary149); if (state.failed) return result;
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
	// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:31:1: type returns [Type result] : ( INTEGER | BOOLEAN | STRING | MONEY );
	public final Type type() throws RecognitionException {
		Type result = null;

		int type_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:32:4: ( INTEGER | BOOLEAN | STRING | MONEY )
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
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:32:5: INTEGER
					{
					match(input,INTEGER,FOLLOW_INTEGER_in_type175); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new IntType();}
					}
					break;
				case 2 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:33:5: BOOLEAN
					{
					match(input,BOOLEAN,FOLLOW_BOOLEAN_in_type184); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new BoolType();}
					}
					break;
				case 3 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:34:5: STRING
					{
					match(input,STRING,FOLLOW_STRING_in_type193); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new StringType();}
					}
					break;
				case 4 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:35:5: MONEY
					{
					match(input,MONEY,FOLLOW_MONEY_in_type202); if (state.failed) return result;
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
	// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:38:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
	public final Expr unExpr() throws RecognitionException {
		Expr result = null;

		int unExpr_StartIndex = input.index();

		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:39:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
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
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:39:8: '+' x= unExpr
					{
					match(input,22,FOLLOW_22_in_unExpr231); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr235);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Pos(x); }
					}
					break;
				case 2 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:40:8: '-' x= unExpr
					{
					match(input,23,FOLLOW_23_in_unExpr246); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr250);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Neg(x); }
					}
					break;
				case 3 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:41:8: '!' x= unExpr
					{
					match(input,16,FOLLOW_16_in_unExpr261); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr265);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Not(x); }
					}
					break;
				case 4 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:42:8: x= primary
					{
					pushFollow(FOLLOW_primary_in_unExpr278);
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
	// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:45:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
	public final Expr mulExpr() throws RecognitionException {
		Expr result = null;

		int mulExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:46:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:46:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
			{
			pushFollow(FOLLOW_unExpr_in_mulExpr316);
			lhs=unExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:46:45: (op= ( '*' | '/' ) rhs= unExpr )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==21||LA4_0==24) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:46:47: op= ( '*' | '/' ) rhs= unExpr
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
					pushFollow(FOLLOW_unExpr_in_mulExpr336);
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
	// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:57:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
	public final Expr addExpr() throws RecognitionException {
		Expr result = null;

		int addExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:58:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:58:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
			{
			pushFollow(FOLLOW_mulExpr_in_addExpr374);
			lhs=mulExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:58:46: (op= ( '+' | '-' ) rhs= mulExpr )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( ((LA5_0 >= 22 && LA5_0 <= 23)) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:58:48: op= ( '+' | '-' ) rhs= mulExpr
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
					pushFollow(FOLLOW_mulExpr_in_addExpr392);
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
	// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:69:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
	public final Expr relExpr() throws RecognitionException {
		Expr result = null;

		int relExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:70:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:70:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			{
			pushFollow(FOLLOW_addExpr_in_relExpr427);
			lhs=addExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:70:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==17||(LA6_0 >= 26 && LA6_0 <= 30)) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:70:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
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
					pushFollow(FOLLOW_addExpr_in_relExpr451);
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
	// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:93:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
	public final Expr andExpr() throws RecognitionException {
		Expr result = null;

		int andExpr_StartIndex = input.index();

		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:94:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:94:9: lhs= relExpr ( '&&' rhs= relExpr )*
			{
			pushFollow(FOLLOW_relExpr_in_andExpr489);
			lhs=relExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:94:46: ( '&&' rhs= relExpr )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==18) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:94:48: '&&' rhs= relExpr
					{
					match(input,18,FOLLOW_18_in_andExpr495); if (state.failed) return result;
					pushFollow(FOLLOW_relExpr_in_andExpr499);
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
	// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:97:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
	public final Expr orExpr() throws RecognitionException {
		Expr result = null;

		int orExpr_StartIndex = input.index();

		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:98:5: (lhs= andExpr ( '||' rhs= andExpr )* )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:98:9: lhs= andExpr ( '||' rhs= andExpr )*
			{
			pushFollow(FOLLOW_andExpr_in_orExpr533);
			lhs=andExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = lhs; }
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:98:48: ( '||' rhs= andExpr )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==35) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:98:50: '||' rhs= andExpr
					{
					match(input,35,FOLLOW_35_in_orExpr539); if (state.failed) return result;
					pushFollow(FOLLOW_andExpr_in_orExpr543);
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
	// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:101:1: formElement returns [FormElement result] : ( 'if' '(' x= orExpr ')' '{' thenbody= formblock '}' 'else' '{' elsebody= formblock '}' | 'if' '(' x= orExpr ')' '{' thenbody= formblock '}' | Ident ':' StringLiteral type '(' orExpr ')' | Ident ':' StringLiteral type );
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

			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:102:5: ( 'if' '(' x= orExpr ')' '{' thenbody= formblock '}' 'else' '{' elsebody= formblock '}' | 'if' '(' x= orExpr ')' '{' thenbody= formblock '}' | Ident ':' StringLiteral type '(' orExpr ')' | Ident ':' StringLiteral type )
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
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:102:7: 'if' '(' x= orExpr ')' '{' thenbody= formblock '}' 'else' '{' elsebody= formblock '}'
					{
					match(input,33,FOLLOW_33_in_formElement569); if (state.failed) return result;
					match(input,19,FOLLOW_19_in_formElement571); if (state.failed) return result;
					pushFollow(FOLLOW_orExpr_in_formElement577);
					x=orExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,20,FOLLOW_20_in_formElement579); if (state.failed) return result;
					match(input,34,FOLLOW_34_in_formElement582); if (state.failed) return result;
					pushFollow(FOLLOW_formblock_in_formElement586);
					thenbody=formblock();
					state._fsp--;
					if (state.failed) return result;
					match(input,36,FOLLOW_36_in_formElement588); if (state.failed) return result;
					match(input,31,FOLLOW_31_in_formElement590); if (state.failed) return result;
					match(input,34,FOLLOW_34_in_formElement592); if (state.failed) return result;
					pushFollow(FOLLOW_formblock_in_formElement598);
					elsebody=formblock();
					state._fsp--;
					if (state.failed) return result;
					match(input,36,FOLLOW_36_in_formElement600); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new IfThenElse(x, thenbody, elsebody); }
					}
					break;
				case 2 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:103:7: 'if' '(' x= orExpr ')' '{' thenbody= formblock '}'
					{
					match(input,33,FOLLOW_33_in_formElement610); if (state.failed) return result;
					match(input,19,FOLLOW_19_in_formElement612); if (state.failed) return result;
					pushFollow(FOLLOW_orExpr_in_formElement618);
					x=orExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,20,FOLLOW_20_in_formElement620); if (state.failed) return result;
					match(input,34,FOLLOW_34_in_formElement623); if (state.failed) return result;
					pushFollow(FOLLOW_formblock_in_formElement627);
					thenbody=formblock();
					state._fsp--;
					if (state.failed) return result;
					match(input,36,FOLLOW_36_in_formElement629); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new IfThen(x, thenbody); }
					}
					break;
				case 3 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:104:7: Ident ':' StringLiteral type '(' orExpr ')'
					{
					Ident6=(Token)match(input,Ident,FOLLOW_Ident_in_formElement640); if (state.failed) return result;
					match(input,25,FOLLOW_25_in_formElement642); if (state.failed) return result;
					StringLiteral7=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_formElement644); if (state.failed) return result;
					pushFollow(FOLLOW_type_in_formElement646);
					type8=type();
					state._fsp--;
					if (state.failed) return result;
					match(input,19,FOLLOW_19_in_formElement648); if (state.failed) return result;
					pushFollow(FOLLOW_orExpr_in_formElement650);
					orExpr9=orExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,20,FOLLOW_20_in_formElement652); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new CompQuestion(new Ident((Ident6!=null?Ident6.getText():null)) ,new StringLiteral((StringLiteral7!=null?StringLiteral7.getText():null)), type8, orExpr9); }
					}
					break;
				case 4 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:105:7: Ident ':' StringLiteral type
					{
					Ident10=(Token)match(input,Ident,FOLLOW_Ident_in_formElement662); if (state.failed) return result;
					match(input,25,FOLLOW_25_in_formElement664); if (state.failed) return result;
					StringLiteral11=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_formElement666); if (state.failed) return result;
					pushFollow(FOLLOW_type_in_formElement668);
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
	// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:108:2: formblock returns [Block result] : ( formElement )* ;
	public final Block formblock() throws RecognitionException {
		Block result = null;

		int formblock_StartIndex = input.index();

		FormElement formElement13 =null;


		          Block formblock = new Block();
		    
		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:112:5: ( ( formElement )* )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:112:7: ( formElement )*
			{
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:112:7: ( formElement )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==Ident||LA10_0==33) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:112:8: formElement
					{
					pushFollow(FOLLOW_formElement_in_formblock699);
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
	// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:116:1: form returns [Form result] : 'form' Ident '{' fb= formblock '}' EOF ;
	public final Form form() throws RecognitionException {
		Form result = null;

		int form_StartIndex = input.index();

		Token Ident14=null;
		Block fb =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:117:5: ( 'form' Ident '{' fb= formblock '}' EOF )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:117:7: 'form' Ident '{' fb= formblock '}' EOF
			{
			match(input,32,FOLLOW_32_in_form731); if (state.failed) return result;
			Ident14=(Token)match(input,Ident,FOLLOW_Ident_in_form733); if (state.failed) return result;
			match(input,34,FOLLOW_34_in_form735); if (state.failed) return result;
			pushFollow(FOLLOW_formblock_in_form741);
			fb=formblock();
			state._fsp--;
			if (state.failed) return result;
			match(input,36,FOLLOW_36_in_form743); if (state.failed) return result;
			match(input,EOF,FOLLOW_EOF_in_form745); if (state.failed) return result;
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

		// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:102:7: ( 'if' '(' x= orExpr ')' '{' thenbody= formblock '}' 'else' '{' elsebody= formblock '}' )
		// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:102:7: 'if' '(' x= orExpr ')' '{' thenbody= formblock '}' 'else' '{' elsebody= formblock '}'
		{
		match(input,33,FOLLOW_33_in_synpred24_QL569); if (state.failed) return;
		match(input,19,FOLLOW_19_in_synpred24_QL571); if (state.failed) return;
		pushFollow(FOLLOW_orExpr_in_synpred24_QL577);
		x=orExpr();
		state._fsp--;
		if (state.failed) return;
		match(input,20,FOLLOW_20_in_synpred24_QL579); if (state.failed) return;
		match(input,34,FOLLOW_34_in_synpred24_QL582); if (state.failed) return;
		pushFollow(FOLLOW_formblock_in_synpred24_QL586);
		thenbody=formblock();
		state._fsp--;
		if (state.failed) return;
		match(input,36,FOLLOW_36_in_synpred24_QL588); if (state.failed) return;
		match(input,31,FOLLOW_31_in_synpred24_QL590); if (state.failed) return;
		match(input,34,FOLLOW_34_in_synpred24_QL592); if (state.failed) return;
		pushFollow(FOLLOW_formblock_in_synpred24_QL598);
		elsebody=formblock();
		state._fsp--;
		if (state.failed) return;
		match(input,36,FOLLOW_36_in_synpred24_QL600); if (state.failed) return;
		}

	}
	// $ANTLR end synpred24_QL

	// $ANTLR start synpred25_QL
	public final void synpred25_QL_fragment() throws RecognitionException {
		Expr x =null;
		Block thenbody =null;

		// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:103:7: ( 'if' '(' x= orExpr ')' '{' thenbody= formblock '}' )
		// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:103:7: 'if' '(' x= orExpr ')' '{' thenbody= formblock '}'
		{
		match(input,33,FOLLOW_33_in_synpred25_QL610); if (state.failed) return;
		match(input,19,FOLLOW_19_in_synpred25_QL612); if (state.failed) return;
		pushFollow(FOLLOW_orExpr_in_synpred25_QL618);
		x=orExpr();
		state._fsp--;
		if (state.failed) return;
		match(input,20,FOLLOW_20_in_synpred25_QL620); if (state.failed) return;
		match(input,34,FOLLOW_34_in_synpred25_QL623); if (state.failed) return;
		pushFollow(FOLLOW_formblock_in_synpred25_QL627);
		thenbody=formblock();
		state._fsp--;
		if (state.failed) return;
		match(input,36,FOLLOW_36_in_synpred25_QL629); if (state.failed) return;
		}

	}
	// $ANTLR end synpred25_QL

	// $ANTLR start synpred26_QL
	public final void synpred26_QL_fragment() throws RecognitionException {
		// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:104:7: ( Ident ':' StringLiteral type '(' orExpr ')' )
		// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:104:7: Ident ':' StringLiteral type '(' orExpr ')'
		{
		match(input,Ident,FOLLOW_Ident_in_synpred26_QL640); if (state.failed) return;
		match(input,25,FOLLOW_25_in_synpred26_QL642); if (state.failed) return;
		match(input,StringLiteral,FOLLOW_StringLiteral_in_synpred26_QL644); if (state.failed) return;
		pushFollow(FOLLOW_type_in_synpred26_QL646);
		type();
		state._fsp--;
		if (state.failed) return;
		match(input,19,FOLLOW_19_in_synpred26_QL648); if (state.failed) return;
		pushFollow(FOLLOW_orExpr_in_synpred26_QL650);
		orExpr();
		state._fsp--;
		if (state.failed) return;
		match(input,20,FOLLOW_20_in_synpred26_QL652); if (state.failed) return;
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



	public static final BitSet FOLLOW_IntLiteral_in_primary49 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MoneyLiteral_in_primary68 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BoolLiteral_in_primary85 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_StringLiteral_in_primary103 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_primary119 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_19_in_primary143 = new BitSet(new long[]{0x0000000000C95320L});
	public static final BitSet FOLLOW_orExpr_in_primary147 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_primary149 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTEGER_in_type175 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BOOLEAN_in_type184 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_in_type193 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MONEY_in_type202 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_22_in_unExpr231 = new BitSet(new long[]{0x0000000000C95320L});
	public static final BitSet FOLLOW_unExpr_in_unExpr235 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_23_in_unExpr246 = new BitSet(new long[]{0x0000000000C95320L});
	public static final BitSet FOLLOW_unExpr_in_unExpr250 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_16_in_unExpr261 = new BitSet(new long[]{0x0000000000C95320L});
	public static final BitSet FOLLOW_unExpr_in_unExpr265 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpr278 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr316 = new BitSet(new long[]{0x0000000001200002L});
	public static final BitSet FOLLOW_set_in_mulExpr324 = new BitSet(new long[]{0x0000000000C95320L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr336 = new BitSet(new long[]{0x0000000001200002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr374 = new BitSet(new long[]{0x0000000000C00002L});
	public static final BitSet FOLLOW_set_in_addExpr382 = new BitSet(new long[]{0x0000000000C95320L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr392 = new BitSet(new long[]{0x0000000000C00002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr427 = new BitSet(new long[]{0x000000007C020002L});
	public static final BitSet FOLLOW_set_in_relExpr435 = new BitSet(new long[]{0x0000000000C95320L});
	public static final BitSet FOLLOW_addExpr_in_relExpr451 = new BitSet(new long[]{0x000000007C020002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr489 = new BitSet(new long[]{0x0000000000040002L});
	public static final BitSet FOLLOW_18_in_andExpr495 = new BitSet(new long[]{0x0000000000C95320L});
	public static final BitSet FOLLOW_relExpr_in_andExpr499 = new BitSet(new long[]{0x0000000000040002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr533 = new BitSet(new long[]{0x0000000800000002L});
	public static final BitSet FOLLOW_35_in_orExpr539 = new BitSet(new long[]{0x0000000000C95320L});
	public static final BitSet FOLLOW_andExpr_in_orExpr543 = new BitSet(new long[]{0x0000000800000002L});
	public static final BitSet FOLLOW_33_in_formElement569 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_formElement571 = new BitSet(new long[]{0x0000000000C95320L});
	public static final BitSet FOLLOW_orExpr_in_formElement577 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_formElement579 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_34_in_formElement582 = new BitSet(new long[]{0x0000001200000100L});
	public static final BitSet FOLLOW_formblock_in_formElement586 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_36_in_formElement588 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_formElement590 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_34_in_formElement592 = new BitSet(new long[]{0x0000001200000100L});
	public static final BitSet FOLLOW_formblock_in_formElement598 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_36_in_formElement600 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_33_in_formElement610 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_formElement612 = new BitSet(new long[]{0x0000000000C95320L});
	public static final BitSet FOLLOW_orExpr_in_formElement618 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_formElement620 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_34_in_formElement623 = new BitSet(new long[]{0x0000001200000100L});
	public static final BitSet FOLLOW_formblock_in_formElement627 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_36_in_formElement629 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_formElement640 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_25_in_formElement642 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_StringLiteral_in_formElement644 = new BitSet(new long[]{0x0000000000002890L});
	public static final BitSet FOLLOW_type_in_formElement646 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_formElement648 = new BitSet(new long[]{0x0000000000C95320L});
	public static final BitSet FOLLOW_orExpr_in_formElement650 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_formElement652 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_formElement662 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_25_in_formElement664 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_StringLiteral_in_formElement666 = new BitSet(new long[]{0x0000000000002890L});
	public static final BitSet FOLLOW_type_in_formElement668 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_formElement_in_formblock699 = new BitSet(new long[]{0x0000000200000102L});
	public static final BitSet FOLLOW_32_in_form731 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_Ident_in_form733 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_34_in_form735 = new BitSet(new long[]{0x0000001200000100L});
	public static final BitSet FOLLOW_formblock_in_form741 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_36_in_form743 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_form745 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_33_in_synpred24_QL569 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_synpred24_QL571 = new BitSet(new long[]{0x0000000000C95320L});
	public static final BitSet FOLLOW_orExpr_in_synpred24_QL577 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_synpred24_QL579 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_34_in_synpred24_QL582 = new BitSet(new long[]{0x0000001200000100L});
	public static final BitSet FOLLOW_formblock_in_synpred24_QL586 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_36_in_synpred24_QL588 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_synpred24_QL590 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_34_in_synpred24_QL592 = new BitSet(new long[]{0x0000001200000100L});
	public static final BitSet FOLLOW_formblock_in_synpred24_QL598 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_36_in_synpred24_QL600 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_33_in_synpred25_QL610 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_synpred25_QL612 = new BitSet(new long[]{0x0000000000C95320L});
	public static final BitSet FOLLOW_orExpr_in_synpred25_QL618 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_synpred25_QL620 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_34_in_synpred25_QL623 = new BitSet(new long[]{0x0000001200000100L});
	public static final BitSet FOLLOW_formblock_in_synpred25_QL627 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_36_in_synpred25_QL629 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_synpred26_QL640 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_25_in_synpred26_QL642 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_StringLiteral_in_synpred26_QL644 = new BitSet(new long[]{0x0000000000002890L});
	public static final BitSet FOLLOW_type_in_synpred26_QL646 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_synpred26_QL648 = new BitSet(new long[]{0x0000000000C95320L});
	public static final BitSet FOLLOW_orExpr_in_synpred26_QL650 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_synpred26_QL652 = new BitSet(new long[]{0x0000000000000002L});
}
