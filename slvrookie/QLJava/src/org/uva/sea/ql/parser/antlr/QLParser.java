// $ANTLR 3.5 C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g 2013-01-21 01:54:42

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.types.*;
import org.uva.sea.ql.ast.expr.*;
import org.uva.sea.ql.ast.expr.value.*;
import org.uva.sea.ql.ast.expr.binary.*;
import org.uva.sea.ql.ast.expr.unary.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings("all")
public class QLParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "BoolLiteral", "Comment", "Ident", 
		"IntLiteral", "LineComment", "MoneyLiteral", "StringLiteral", "Type", 
		"Ws", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", "'/'", 
		"':'", "'<'", "'<='", "'=='", "'>'", "'>='", "'form'", "'if'", "'{'", 
		"'||'", "'}'"
	};
	public static final int EOF=-1;
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
	public static final int T__30=30;
	public static final int T__31=31;
	public static final int T__32=32;
	public static final int BoolLiteral=4;
	public static final int Comment=5;
	public static final int Ident=6;
	public static final int IntLiteral=7;
	public static final int LineComment=8;
	public static final int MoneyLiteral=9;
	public static final int StringLiteral=10;
	public static final int Type=11;
	public static final int Ws=12;

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
		this.state.ruleMemo = new HashMap[34+1];


	}

	@Override public String[] getTokenNames() { return QLParser.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g"; }



	// $ANTLR start "primary"
	// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:21:1: primary returns [Expr result] : ( IntLiteral | MoneyLiteral | BoolLiteral | StringLiteral | Ident | '(' x= orExpr ')' );
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

			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:22:4: ( IntLiteral | MoneyLiteral | BoolLiteral | StringLiteral | Ident | '(' x= orExpr ')' )
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
			case 16:
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
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:22:6: IntLiteral
					{
					IntLiteral1=(Token)match(input,IntLiteral,FOLLOW_IntLiteral_in_primary49); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new IntLiteral(Integer.parseInt((IntLiteral1!=null?IntLiteral1.getText():null))); }
					}
					break;
				case 2 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:23:6: MoneyLiteral
					{
					MoneyLiteral2=(Token)match(input,MoneyLiteral,FOLLOW_MoneyLiteral_in_primary68); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new MoneyLiteral(Double.parseDouble((MoneyLiteral2!=null?MoneyLiteral2.getText():null))) ;}
					}
					break;
				case 3 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:24:6: BoolLiteral
					{
					BoolLiteral3=(Token)match(input,BoolLiteral,FOLLOW_BoolLiteral_in_primary85); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new BoolLiteral(Boolean.parseBoolean((BoolLiteral3!=null?BoolLiteral3.getText():null))) ;}
					}
					break;
				case 4 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:25:6: StringLiteral
					{
					StringLiteral4=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_primary103); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new StringLiteral((StringLiteral4!=null?StringLiteral4.getText():null));}
					}
					break;
				case 5 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:26:6: Ident
					{
					Ident5=(Token)match(input,Ident,FOLLOW_Ident_in_primary119); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Ident((Ident5!=null?Ident5.getText():null)); }
					}
					break;
				case 6 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:27:6: '(' x= orExpr ')'
					{
					match(input,16,FOLLOW_16_in_primary143); if (state.failed) return result;
					pushFollow(FOLLOW_orExpr_in_primary147);
					x=orExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,17,FOLLOW_17_in_primary149); if (state.failed) return result;
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
	// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:30:1: type returns [Type result] : Type ;
	public final Type type() throws RecognitionException {
		Type result = null;

		int type_StartIndex = input.index();

		Token Type6=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:31:4: ( Type )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:31:6: Type
			{
			Type6=(Token)match(input,Type,FOLLOW_Type_in_type176); if (state.failed) return result;
			if ( state.backtracking==0 ) {
			     if ((Type6!=null?Type6.getText():null).equals("string")) result = new StringType();
			     else if ((Type6!=null?Type6.getText():null).equals("int")) result = new IntType();
			     else if ((Type6!=null?Type6.getText():null).equals("money")) result = new MoneyType();
			     else if ((Type6!=null?Type6.getText():null).equals("boolean")) result = new BoolType();
			   }
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
	// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:39:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
	public final Expr unExpr() throws RecognitionException {
		Expr result = null;

		int unExpr_StartIndex = input.index();

		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:40:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
			int alt2=4;
			switch ( input.LA(1) ) {
			case 19:
				{
				alt2=1;
				}
				break;
			case 20:
				{
				alt2=2;
				}
				break;
			case 13:
				{
				alt2=3;
				}
				break;
			case BoolLiteral:
			case Ident:
			case IntLiteral:
			case MoneyLiteral:
			case StringLiteral:
			case 16:
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
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:40:8: '+' x= unExpr
					{
					match(input,19,FOLLOW_19_in_unExpr203); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr207);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Pos(x); }
					}
					break;
				case 2 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:41:8: '-' x= unExpr
					{
					match(input,20,FOLLOW_20_in_unExpr218); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr222);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Neg(x); }
					}
					break;
				case 3 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:42:8: '!' x= unExpr
					{
					match(input,13,FOLLOW_13_in_unExpr233); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr237);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Not(x); }
					}
					break;
				case 4 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:43:8: x= primary
					{
					pushFollow(FOLLOW_primary_in_unExpr250);
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
	// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:46:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
	public final Expr mulExpr() throws RecognitionException {
		Expr result = null;

		int mulExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:47:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:47:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
			{
			pushFollow(FOLLOW_unExpr_in_mulExpr288);
			lhs=unExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:47:45: (op= ( '*' | '/' ) rhs= unExpr )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==18||LA3_0==21) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:47:47: op= ( '*' | '/' ) rhs= unExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==18||input.LA(1)==21 ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_unExpr_in_mulExpr308);
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
	// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:58:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
	public final Expr addExpr() throws RecognitionException {
		Expr result = null;

		int addExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:59:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:59:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
			{
			pushFollow(FOLLOW_mulExpr_in_addExpr346);
			lhs=mulExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:59:46: (op= ( '+' | '-' ) rhs= mulExpr )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( ((LA4_0 >= 19 && LA4_0 <= 20)) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:59:48: op= ( '+' | '-' ) rhs= mulExpr
					{
					op=input.LT(1);
					if ( (input.LA(1) >= 19 && input.LA(1) <= 20) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_mulExpr_in_addExpr364);
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
	// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:70:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
	public final Expr relExpr() throws RecognitionException {
		Expr result = null;

		int relExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:71:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:71:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			{
			pushFollow(FOLLOW_addExpr_in_relExpr399);
			lhs=addExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:71:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==14||(LA5_0 >= 23 && LA5_0 <= 27)) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:71:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==14||(input.LA(1) >= 23 && input.LA(1) <= 27) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_addExpr_in_relExpr423);
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
	// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:94:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
	public final Expr andExpr() throws RecognitionException {
		Expr result = null;

		int andExpr_StartIndex = input.index();

		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:95:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:95:9: lhs= relExpr ( '&&' rhs= relExpr )*
			{
			pushFollow(FOLLOW_relExpr_in_andExpr461);
			lhs=relExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:95:46: ( '&&' rhs= relExpr )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==15) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:95:48: '&&' rhs= relExpr
					{
					match(input,15,FOLLOW_15_in_andExpr467); if (state.failed) return result;
					pushFollow(FOLLOW_relExpr_in_andExpr471);
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
	// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:98:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
	public final Expr orExpr() throws RecognitionException {
		Expr result = null;

		int orExpr_StartIndex = input.index();

		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:99:5: (lhs= andExpr ( '||' rhs= andExpr )* )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:99:9: lhs= andExpr ( '||' rhs= andExpr )*
			{
			pushFollow(FOLLOW_andExpr_in_orExpr505);
			lhs=andExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = lhs; }
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:99:48: ( '||' rhs= andExpr )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==31) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:99:50: '||' rhs= andExpr
					{
					match(input,31,FOLLOW_31_in_orExpr511); if (state.failed) return result;
					pushFollow(FOLLOW_andExpr_in_orExpr515);
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



	// $ANTLR start "formElement"
	// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:102:1: formElement returns [FormElement result] : ( 'if' '(' x= orExpr ')' '{' body= formblock '}' | Ident ':' StringLiteral type '(' orExpr ')' | Ident ':' StringLiteral type );
	public final FormElement formElement() throws RecognitionException {
		FormElement result = null;

		int formElement_StartIndex = input.index();

		Token Ident7=null;
		Token StringLiteral8=null;
		Token Ident11=null;
		Token StringLiteral12=null;
		Expr x =null;
		List<FormElement> body =null;
		Type type9 =null;
		Expr orExpr10 =null;
		Type type13 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:103:5: ( 'if' '(' x= orExpr ')' '{' body= formblock '}' | Ident ':' StringLiteral type '(' orExpr ')' | Ident ':' StringLiteral type )
			int alt8=3;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==29) ) {
				alt8=1;
			}
			else if ( (LA8_0==Ident) ) {
				int LA8_2 = input.LA(2);
				if ( (LA8_2==22) ) {
					int LA8_3 = input.LA(3);
					if ( (LA8_3==StringLiteral) ) {
						int LA8_4 = input.LA(4);
						if ( (LA8_4==Type) ) {
							int LA8_5 = input.LA(5);
							if ( (LA8_5==16) ) {
								alt8=2;
							}
							else if ( (LA8_5==EOF||LA8_5==Ident||LA8_5==29||LA8_5==32) ) {
								alt8=3;
							}

							else {
								if (state.backtracking>0) {state.failed=true; return result;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 8, 5, input);
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
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 8, 4, input);
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
								new NoViableAltException("", 8, 3, input);
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
							new NoViableAltException("", 8, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}

			switch (alt8) {
				case 1 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:103:7: 'if' '(' x= orExpr ')' '{' body= formblock '}'
					{
					match(input,29,FOLLOW_29_in_formElement541); if (state.failed) return result;
					match(input,16,FOLLOW_16_in_formElement543); if (state.failed) return result;
					pushFollow(FOLLOW_orExpr_in_formElement549);
					x=orExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,17,FOLLOW_17_in_formElement551); if (state.failed) return result;
					match(input,30,FOLLOW_30_in_formElement553); if (state.failed) return result;
					pushFollow(FOLLOW_formblock_in_formElement557);
					body=formblock();
					state._fsp--;
					if (state.failed) return result;
					match(input,32,FOLLOW_32_in_formElement559); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new IfBody(x, body); }
					}
					break;
				case 2 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:104:7: Ident ':' StringLiteral type '(' orExpr ')'
					{
					Ident7=(Token)match(input,Ident,FOLLOW_Ident_in_formElement569); if (state.failed) return result;
					match(input,22,FOLLOW_22_in_formElement571); if (state.failed) return result;
					StringLiteral8=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_formElement573); if (state.failed) return result;
					pushFollow(FOLLOW_type_in_formElement575);
					type9=type();
					state._fsp--;
					if (state.failed) return result;
					match(input,16,FOLLOW_16_in_formElement577); if (state.failed) return result;
					pushFollow(FOLLOW_orExpr_in_formElement579);
					orExpr10=orExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,17,FOLLOW_17_in_formElement581); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new CompQuestion(new Ident((Ident7!=null?Ident7.getText():null)) ,new StringLiteral((StringLiteral8!=null?StringLiteral8.getText():null)), type9, orExpr10); }
					}
					break;
				case 3 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:105:7: Ident ':' StringLiteral type
					{
					Ident11=(Token)match(input,Ident,FOLLOW_Ident_in_formElement591); if (state.failed) return result;
					match(input,22,FOLLOW_22_in_formElement593); if (state.failed) return result;
					StringLiteral12=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_formElement595); if (state.failed) return result;
					pushFollow(FOLLOW_type_in_formElement597);
					type13=type();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Question(new Ident((Ident11!=null?Ident11.getText():null)) ,new StringLiteral((StringLiteral12!=null?StringLiteral12.getText():null)), type13); }
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
	// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:108:1: formblock returns [List<FormElement> result] : (forme= formElement )* ;
	public final List<FormElement> formblock() throws RecognitionException {
		List<FormElement> result = null;

		int formblock_StartIndex = input.index();

		FormElement forme =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:109:5: ( (forme= formElement )* )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:109:8: (forme= formElement )*
			{
			if ( state.backtracking==0 ) { result = new ArrayList<FormElement>() ; }
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:109:52: (forme= formElement )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==Ident||LA9_0==29) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:109:53: forme= formElement
					{
					pushFollow(FOLLOW_formElement_in_formblock629);
					forme=formElement();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result.add(forme) ; }
					}
					break;

				default :
					break loop9;
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
			if ( state.backtracking>0 ) { memoize(input, 10, formblock_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "formblock"



	// $ANTLR start "form"
	// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:112:1: form returns [Form result] : 'form' Ident '{' fb= formblock '}' ;
	public final Form form() throws RecognitionException {
		Form result = null;

		int form_StartIndex = input.index();

		Token Ident14=null;
		List<FormElement> fb =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:113:5: ( 'form' Ident '{' fb= formblock '}' )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:113:7: 'form' Ident '{' fb= formblock '}'
			{
			match(input,28,FOLLOW_28_in_form662); if (state.failed) return result;
			Ident14=(Token)match(input,Ident,FOLLOW_Ident_in_form664); if (state.failed) return result;
			match(input,30,FOLLOW_30_in_form666); if (state.failed) return result;
			pushFollow(FOLLOW_formblock_in_form672);
			fb=formblock();
			state._fsp--;
			if (state.failed) return result;
			match(input,32,FOLLOW_32_in_form674); if (state.failed) return result;
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

	// Delegated rules



	public static final BitSet FOLLOW_IntLiteral_in_primary49 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MoneyLiteral_in_primary68 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BoolLiteral_in_primary85 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_StringLiteral_in_primary103 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_primary119 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_16_in_primary143 = new BitSet(new long[]{0x00000000001926D0L});
	public static final BitSet FOLLOW_orExpr_in_primary147 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_primary149 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Type_in_type176 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_19_in_unExpr203 = new BitSet(new long[]{0x00000000001926D0L});
	public static final BitSet FOLLOW_unExpr_in_unExpr207 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_20_in_unExpr218 = new BitSet(new long[]{0x00000000001926D0L});
	public static final BitSet FOLLOW_unExpr_in_unExpr222 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_13_in_unExpr233 = new BitSet(new long[]{0x00000000001926D0L});
	public static final BitSet FOLLOW_unExpr_in_unExpr237 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpr250 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr288 = new BitSet(new long[]{0x0000000000240002L});
	public static final BitSet FOLLOW_set_in_mulExpr296 = new BitSet(new long[]{0x00000000001926D0L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr308 = new BitSet(new long[]{0x0000000000240002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr346 = new BitSet(new long[]{0x0000000000180002L});
	public static final BitSet FOLLOW_set_in_addExpr354 = new BitSet(new long[]{0x00000000001926D0L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr364 = new BitSet(new long[]{0x0000000000180002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr399 = new BitSet(new long[]{0x000000000F804002L});
	public static final BitSet FOLLOW_set_in_relExpr407 = new BitSet(new long[]{0x00000000001926D0L});
	public static final BitSet FOLLOW_addExpr_in_relExpr423 = new BitSet(new long[]{0x000000000F804002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr461 = new BitSet(new long[]{0x0000000000008002L});
	public static final BitSet FOLLOW_15_in_andExpr467 = new BitSet(new long[]{0x00000000001926D0L});
	public static final BitSet FOLLOW_relExpr_in_andExpr471 = new BitSet(new long[]{0x0000000000008002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr505 = new BitSet(new long[]{0x0000000080000002L});
	public static final BitSet FOLLOW_31_in_orExpr511 = new BitSet(new long[]{0x00000000001926D0L});
	public static final BitSet FOLLOW_andExpr_in_orExpr515 = new BitSet(new long[]{0x0000000080000002L});
	public static final BitSet FOLLOW_29_in_formElement541 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_formElement543 = new BitSet(new long[]{0x00000000001926D0L});
	public static final BitSet FOLLOW_orExpr_in_formElement549 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_formElement551 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_30_in_formElement553 = new BitSet(new long[]{0x0000000120000040L});
	public static final BitSet FOLLOW_formblock_in_formElement557 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_32_in_formElement559 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_formElement569 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_formElement571 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_StringLiteral_in_formElement573 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_type_in_formElement575 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_formElement577 = new BitSet(new long[]{0x00000000001926D0L});
	public static final BitSet FOLLOW_orExpr_in_formElement579 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_formElement581 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_formElement591 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_formElement593 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_StringLiteral_in_formElement595 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_type_in_formElement597 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_formElement_in_formblock629 = new BitSet(new long[]{0x0000000020000042L});
	public static final BitSet FOLLOW_28_in_form662 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Ident_in_form664 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_30_in_form666 = new BitSet(new long[]{0x0000000120000040L});
	public static final BitSet FOLLOW_formblock_in_form672 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_32_in_form674 = new BitSet(new long[]{0x0000000000000002L});
}
