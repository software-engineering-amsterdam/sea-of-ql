// $ANTLR 3.5 C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g 2013-01-17 04:29:59

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.types.*;
import org.uva.sea.ql.ast.expr.*;
import org.uva.sea.ql.ast.expr.value.*;


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
		this.state.ruleMemo = new HashMap[36+1];


	}

	@Override public String[] getTokenNames() { return QLParser.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g"; }



	// $ANTLR start "primary"
	// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:20:1: primary returns [Expr result] : ( IntLiteral | MoneyLiteral | BoolLiteral | StringLiteral | Ident | '(' x= orExpr ')' );
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

			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:21:3: ( IntLiteral | MoneyLiteral | BoolLiteral | StringLiteral | Ident | '(' x= orExpr ')' )
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
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:21:5: IntLiteral
					{
					IntLiteral1=(Token)match(input,IntLiteral,FOLLOW_IntLiteral_in_primary50); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new IntLiteral(Integer.parseInt((IntLiteral1!=null?IntLiteral1.getText():null))); }
					}
					break;
				case 2 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:22:5: MoneyLiteral
					{
					MoneyLiteral2=(Token)match(input,MoneyLiteral,FOLLOW_MoneyLiteral_in_primary68); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new MoneyLiteral(Double.parseDouble((MoneyLiteral2!=null?MoneyLiteral2.getText():null))) ;}
					}
					break;
				case 3 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:23:5: BoolLiteral
					{
					BoolLiteral3=(Token)match(input,BoolLiteral,FOLLOW_BoolLiteral_in_primary84); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new BoolLiteral(Boolean.parseBoolean((BoolLiteral3!=null?BoolLiteral3.getText():null))) ;}
					}
					break;
				case 4 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:24:5: StringLiteral
					{
					StringLiteral4=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_primary101); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new StringLiteral((StringLiteral4!=null?StringLiteral4.getText():null));}
					}
					break;
				case 5 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:25:5: Ident
					{
					Ident5=(Token)match(input,Ident,FOLLOW_Ident_in_primary116); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Ident((Ident5!=null?Ident5.getText():null)); }
					}
					break;
				case 6 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:26:5: '(' x= orExpr ')'
					{
					match(input,16,FOLLOW_16_in_primary139); if (state.failed) return result;
					pushFollow(FOLLOW_orExpr_in_primary143);
					x=orExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,17,FOLLOW_17_in_primary145); if (state.failed) return result;
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
	// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:29:1: type returns [Type result] : Type ;
	public final Type type() throws RecognitionException {
		Type result = null;

		int type_StartIndex = input.index();

		Token Type6=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:30:2: ( Type )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:30:4: Type
			{
			Type6=(Token)match(input,Type,FOLLOW_Type_in_type169); if (state.failed) return result;
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
	// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:38:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
	public final Expr unExpr() throws RecognitionException {
		Expr result = null;

		int unExpr_StartIndex = input.index();

		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:39:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
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
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:39:8: '+' x= unExpr
					{
					match(input,19,FOLLOW_19_in_unExpr195); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr199);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Pos(x); }
					}
					break;
				case 2 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:40:8: '-' x= unExpr
					{
					match(input,20,FOLLOW_20_in_unExpr210); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr214);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Neg(x); }
					}
					break;
				case 3 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:41:8: '!' x= unExpr
					{
					match(input,13,FOLLOW_13_in_unExpr225); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr229);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Not(x); }
					}
					break;
				case 4 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:42:8: x= primary
					{
					pushFollow(FOLLOW_primary_in_unExpr242);
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
	// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:45:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
	public final Expr mulExpr() throws RecognitionException {
		Expr result = null;

		int mulExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:46:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:46:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
			{
			pushFollow(FOLLOW_unExpr_in_mulExpr280);
			lhs=unExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:46:45: (op= ( '*' | '/' ) rhs= unExpr )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==18||LA3_0==21) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:46:47: op= ( '*' | '/' ) rhs= unExpr
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
					pushFollow(FOLLOW_unExpr_in_mulExpr300);
					rhs=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { 
					      if ((op!=null?op.getText():null).equals("*")) {
					        result = new Mul(result, rhs);
					      }
					      if ((op!=null?op.getText():null).equals("<=")) {
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
			pushFollow(FOLLOW_mulExpr_in_addExpr341);
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
					pushFollow(FOLLOW_mulExpr_in_addExpr359);
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
			pushFollow(FOLLOW_addExpr_in_relExpr394);
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
					pushFollow(FOLLOW_addExpr_in_relExpr418);
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
			pushFollow(FOLLOW_relExpr_in_andExpr456);
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
					match(input,15,FOLLOW_15_in_andExpr462); if (state.failed) return result;
					pushFollow(FOLLOW_relExpr_in_andExpr466);
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
			pushFollow(FOLLOW_andExpr_in_orExpr500);
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
					match(input,31,FOLLOW_31_in_orExpr506); if (state.failed) return result;
					pushFollow(FOLLOW_andExpr_in_orExpr510);
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



	// $ANTLR start "question"
	// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:102:1: question returns [Question result] : ( Ident ':' StringLiteral type '(' orExpr ')' | Ident ':' StringLiteral type );
	public final Question question() throws RecognitionException {
		Question result = null;

		int question_StartIndex = input.index();

		Token Ident7=null;
		Token StringLiteral8=null;
		Token Ident11=null;
		Token StringLiteral12=null;
		Type type9 =null;
		Expr orExpr10 =null;
		Type type13 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:103:5: ( Ident ':' StringLiteral type '(' orExpr ')' | Ident ':' StringLiteral type )
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==Ident) ) {
				int LA8_1 = input.LA(2);
				if ( (LA8_1==22) ) {
					int LA8_2 = input.LA(3);
					if ( (LA8_2==StringLiteral) ) {
						int LA8_3 = input.LA(4);
						if ( (LA8_3==Type) ) {
							int LA8_4 = input.LA(5);
							if ( (LA8_4==16) ) {
								alt8=1;
							}
							else if ( (LA8_4==EOF||LA8_4==Ident||LA8_4==29||LA8_4==32) ) {
								alt8=2;
							}

							else {
								if (state.backtracking>0) {state.failed=true; return result;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
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
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
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
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
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
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 8, 1, input);
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
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:103:9: Ident ':' StringLiteral type '(' orExpr ')'
					{
					Ident7=(Token)match(input,Ident,FOLLOW_Ident_in_question538); if (state.failed) return result;
					match(input,22,FOLLOW_22_in_question540); if (state.failed) return result;
					StringLiteral8=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_question542); if (state.failed) return result;
					pushFollow(FOLLOW_type_in_question544);
					type9=type();
					state._fsp--;
					if (state.failed) return result;
					match(input,16,FOLLOW_16_in_question546); if (state.failed) return result;
					pushFollow(FOLLOW_orExpr_in_question548);
					orExpr10=orExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,17,FOLLOW_17_in_question550); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Question(new Ident((Ident7!=null?Ident7.getText():null)) ,new StringLiteral((StringLiteral8!=null?StringLiteral8.getText():null)), type9, orExpr10); }
					}
					break;
				case 2 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:104:9: Ident ':' StringLiteral type
					{
					Ident11=(Token)match(input,Ident,FOLLOW_Ident_in_question562); if (state.failed) return result;
					match(input,22,FOLLOW_22_in_question564); if (state.failed) return result;
					StringLiteral12=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_question566); if (state.failed) return result;
					pushFollow(FOLLOW_type_in_question568);
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
			if ( state.backtracking>0 ) { memoize(input, 9, question_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "question"



	// $ANTLR start "ifbody"
	// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:107:1: ifbody returns [IfBody result] : 'if' '(' x= orExpr ')' '{' body= formblock '}' ;
	public final IfBody ifbody() throws RecognitionException {
		IfBody result = null;

		int ifbody_StartIndex = input.index();

		Expr x =null;
		List<FormElement> body =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:108:5: ( 'if' '(' x= orExpr ')' '{' body= formblock '}' )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:108:9: 'if' '(' x= orExpr ')' '{' body= formblock '}'
			{
			match(input,29,FOLLOW_29_in_ifbody593); if (state.failed) return result;
			match(input,16,FOLLOW_16_in_ifbody595); if (state.failed) return result;
			pushFollow(FOLLOW_orExpr_in_ifbody601);
			x=orExpr();
			state._fsp--;
			if (state.failed) return result;
			match(input,17,FOLLOW_17_in_ifbody603); if (state.failed) return result;
			match(input,30,FOLLOW_30_in_ifbody605); if (state.failed) return result;
			pushFollow(FOLLOW_formblock_in_ifbody609);
			body=formblock();
			state._fsp--;
			if (state.failed) return result;
			match(input,32,FOLLOW_32_in_ifbody611); if (state.failed) return result;
			if ( state.backtracking==0 ) { result = new IfBody(x, body); }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 10, ifbody_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "ifbody"



	// $ANTLR start "formElement"
	// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:111:1: formElement returns [FormElement result] : ( ifbody | question );
	public final FormElement formElement() throws RecognitionException {
		FormElement result = null;

		int formElement_StartIndex = input.index();

		IfBody ifbody14 =null;
		Question question15 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:112:5: ( ifbody | question )
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==29) ) {
				alt9=1;
			}
			else if ( (LA9_0==Ident) ) {
				alt9=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}

			switch (alt9) {
				case 1 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:112:7: ifbody
					{
					pushFollow(FOLLOW_ifbody_in_formElement634);
					ifbody14=ifbody();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = ifbody14; }
					}
					break;
				case 2 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:113:7: question
					{
					pushFollow(FOLLOW_question_in_formElement648);
					question15=question();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = question15; }
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
			if ( state.backtracking>0 ) { memoize(input, 11, formElement_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "formElement"



	// $ANTLR start "formblock"
	// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:116:1: formblock returns [List<FormElement> result] : (ele= formElement )* ;
	public final List<FormElement> formblock() throws RecognitionException {
		List<FormElement> result = null;

		int formblock_StartIndex = input.index();

		FormElement ele =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }

			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:117:5: ( (ele= formElement )* )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:117:8: (ele= formElement )*
			{
			if ( state.backtracking==0 ) {result = new ArrayList<FormElement>(); }
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:117:51: (ele= formElement )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==Ident||LA10_0==29) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:117:52: ele= formElement
					{
					pushFollow(FOLLOW_formElement_in_formblock683);
					ele=formElement();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result.add(ele); }
					}
					break;

				default :
					break loop10;
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
			if ( state.backtracking>0 ) { memoize(input, 12, formblock_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "formblock"



	// $ANTLR start "form"
	// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:120:1: form returns [Form result] : 'form' Ident '{' formblock '}' ;
	public final Form form() throws RecognitionException {
		Form result = null;

		int form_StartIndex = input.index();

		Token Ident16=null;
		List<FormElement> formblock17 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return result; }

			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:121:5: ( 'form' Ident '{' formblock '}' )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:121:7: 'form' Ident '{' formblock '}'
			{
			match(input,28,FOLLOW_28_in_form710); if (state.failed) return result;
			Ident16=(Token)match(input,Ident,FOLLOW_Ident_in_form712); if (state.failed) return result;
			match(input,30,FOLLOW_30_in_form714); if (state.failed) return result;
			pushFollow(FOLLOW_formblock_in_form716);
			formblock17=formblock();
			state._fsp--;
			if (state.failed) return result;
			match(input,32,FOLLOW_32_in_form718); if (state.failed) return result;
			if ( state.backtracking==0 ) { result = new Form(new Ident((Ident16!=null?Ident16.getText():null)), formblock17); }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 13, form_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "form"

	// Delegated rules



	public static final BitSet FOLLOW_IntLiteral_in_primary50 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MoneyLiteral_in_primary68 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BoolLiteral_in_primary84 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_StringLiteral_in_primary101 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_primary116 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_16_in_primary139 = new BitSet(new long[]{0x00000000001926D0L});
	public static final BitSet FOLLOW_orExpr_in_primary143 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_primary145 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Type_in_type169 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_19_in_unExpr195 = new BitSet(new long[]{0x00000000001926D0L});
	public static final BitSet FOLLOW_unExpr_in_unExpr199 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_20_in_unExpr210 = new BitSet(new long[]{0x00000000001926D0L});
	public static final BitSet FOLLOW_unExpr_in_unExpr214 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_13_in_unExpr225 = new BitSet(new long[]{0x00000000001926D0L});
	public static final BitSet FOLLOW_unExpr_in_unExpr229 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpr242 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr280 = new BitSet(new long[]{0x0000000000240002L});
	public static final BitSet FOLLOW_set_in_mulExpr288 = new BitSet(new long[]{0x00000000001926D0L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr300 = new BitSet(new long[]{0x0000000000240002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr341 = new BitSet(new long[]{0x0000000000180002L});
	public static final BitSet FOLLOW_set_in_addExpr349 = new BitSet(new long[]{0x00000000001926D0L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr359 = new BitSet(new long[]{0x0000000000180002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr394 = new BitSet(new long[]{0x000000000F804002L});
	public static final BitSet FOLLOW_set_in_relExpr402 = new BitSet(new long[]{0x00000000001926D0L});
	public static final BitSet FOLLOW_addExpr_in_relExpr418 = new BitSet(new long[]{0x000000000F804002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr456 = new BitSet(new long[]{0x0000000000008002L});
	public static final BitSet FOLLOW_15_in_andExpr462 = new BitSet(new long[]{0x00000000001926D0L});
	public static final BitSet FOLLOW_relExpr_in_andExpr466 = new BitSet(new long[]{0x0000000000008002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr500 = new BitSet(new long[]{0x0000000080000002L});
	public static final BitSet FOLLOW_31_in_orExpr506 = new BitSet(new long[]{0x00000000001926D0L});
	public static final BitSet FOLLOW_andExpr_in_orExpr510 = new BitSet(new long[]{0x0000000080000002L});
	public static final BitSet FOLLOW_Ident_in_question538 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_question540 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_StringLiteral_in_question542 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_type_in_question544 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_question546 = new BitSet(new long[]{0x00000000001926D0L});
	public static final BitSet FOLLOW_orExpr_in_question548 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_question550 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_question562 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_question564 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_StringLiteral_in_question566 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_type_in_question568 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_29_in_ifbody593 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_ifbody595 = new BitSet(new long[]{0x00000000001926D0L});
	public static final BitSet FOLLOW_orExpr_in_ifbody601 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_ifbody603 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_30_in_ifbody605 = new BitSet(new long[]{0x0000000120000040L});
	public static final BitSet FOLLOW_formblock_in_ifbody609 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_32_in_ifbody611 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifbody_in_formElement634 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_question_in_formElement648 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_formElement_in_formblock683 = new BitSet(new long[]{0x0000000020000042L});
	public static final BitSet FOLLOW_28_in_form710 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Ident_in_form712 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_30_in_form714 = new BitSet(new long[]{0x0000000120000040L});
	public static final BitSet FOLLOW_formblock_in_form716 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_32_in_form718 = new BitSet(new long[]{0x0000000000000002L});
}
