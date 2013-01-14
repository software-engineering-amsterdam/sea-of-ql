// $ANTLR 3.5 QL.g 2013-01-14 16:42:31

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings("all")
public class QLParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "BooleanLiteral", "COLON", "COMMENT", 
		"Ident", "IntLiteral", "LBRACE", "RBRACE", "StringLiteral", "WS", "'!'", 
		"'!='", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", "'/'", "'<'", "'<='", 
		"'=='", "'>'", "'>='", "'boolean'", "'else'", "'form'", "'if'", "'money'", 
		"'string'", "'||'"
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
	public static final int T__33=33;
	public static final int BooleanLiteral=4;
	public static final int COLON=5;
	public static final int COMMENT=6;
	public static final int Ident=7;
	public static final int IntLiteral=8;
	public static final int LBRACE=9;
	public static final int RBRACE=10;
	public static final int StringLiteral=11;
	public static final int WS=12;

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
	@Override public String getGrammarFileName() { return "QL.g"; }



	// $ANTLR start "qlprogram"
	// QL.g:15:1: qlprogram returns [QLProgram result] : 'form' Ident cb= compoundStatement ;
	public final QLProgram qlprogram() throws RecognitionException {
		QLProgram result = null;

		int qlprogram_StartIndex = input.index();

		Token Ident1=null;
		Statement cb =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

			// QL.g:16:5: ( 'form' Ident cb= compoundStatement )
			// QL.g:16:7: 'form' Ident cb= compoundStatement
			{
			match(input,29,FOLLOW_29_in_qlprogram48); if (state.failed) return result;
			Ident1=(Token)match(input,Ident,FOLLOW_Ident_in_qlprogram50); if (state.failed) return result;
			pushFollow(FOLLOW_compoundStatement_in_qlprogram55);
			cb=compoundStatement();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = new QLProgram(Ident1, cb) ; }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 1, qlprogram_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "qlprogram"



	// $ANTLR start "compoundStatement"
	// QL.g:19:1: compoundStatement returns [Statement result] : LBRACE (st= statement )* RBRACE ;
	public final Statement compoundStatement() throws RecognitionException {
		Statement result = null;

		int compoundStatement_StartIndex = input.index();

		ParserRuleReturnScope st =null;

		 CompoundStatement compoundStatement = new CompoundStatement() ; 
		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

			// QL.g:21:5: ( LBRACE (st= statement )* RBRACE )
			// QL.g:21:7: LBRACE (st= statement )* RBRACE
			{
			match(input,LBRACE,FOLLOW_LBRACE_in_compoundStatement86); if (state.failed) return result;
			// QL.g:22:7: (st= statement )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==Ident||LA1_0==LBRACE||LA1_0==30) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// QL.g:22:8: st= statement
					{
					pushFollow(FOLLOW_statement_in_compoundStatement98);
					st=statement();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { compoundStatement.addStatement((st!=null?((QLParser.statement_return)st).result:null)) ; }
					}
					break;

				default :
					break loop1;
				}
			}

			match(input,RBRACE,FOLLOW_RBRACE_in_compoundStatement113); if (state.failed) return result;
			if ( state.backtracking==0 ) { result = compoundStatement ; }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 2, compoundStatement_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "compoundStatement"


	public static class statement_return extends ParserRuleReturnScope {
		public Statement result;
	};


	// $ANTLR start "statement"
	// QL.g:27:1: statement returns [Statement result] : ( Ident COLON st= StringLiteral ty= type | 'if' '(' ex= orExpr ')' ctrue= compoundStatement ( 'else' cfalse= compoundStatement )? |c= compoundStatement );
	public final QLParser.statement_return statement() throws RecognitionException {
		QLParser.statement_return retval = new QLParser.statement_return();
		retval.start = input.LT(1);
		int statement_StartIndex = input.index();

		Token st=null;
		Token Ident2=null;
		TypeDescription ty =null;
		Expr ex =null;
		Statement ctrue =null;
		Statement cfalse =null;
		Statement c =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return retval; }

			// QL.g:28:5: ( Ident COLON st= StringLiteral ty= type | 'if' '(' ex= orExpr ')' ctrue= compoundStatement ( 'else' cfalse= compoundStatement )? |c= compoundStatement )
			int alt3=3;
			switch ( input.LA(1) ) {
			case Ident:
				{
				alt3=1;
				}
				break;
			case 30:
				{
				alt3=2;
				}
				break;
			case LBRACE:
				{
				alt3=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}
			switch (alt3) {
				case 1 :
					// QL.g:28:7: Ident COLON st= StringLiteral ty= type
					{
					Ident2=(Token)match(input,Ident,FOLLOW_Ident_in_statement149); if (state.failed) return retval;
					match(input,COLON,FOLLOW_COLON_in_statement151); if (state.failed) return retval;
					st=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_statement155); if (state.failed) return retval;
					pushFollow(FOLLOW_type_in_statement159);
					ty=type();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) { retval.result = new LineStatement(new String((Ident2!=null?Ident2.getText():null)),st,ty); }
					}
					break;
				case 2 :
					// QL.g:29:7: 'if' '(' ex= orExpr ')' ctrue= compoundStatement ( 'else' cfalse= compoundStatement )?
					{
					match(input,30,FOLLOW_30_in_statement169); if (state.failed) return retval;
					match(input,16,FOLLOW_16_in_statement171); if (state.failed) return retval;
					pushFollow(FOLLOW_orExpr_in_statement175);
					ex=orExpr();
					state._fsp--;
					if (state.failed) return retval;
					match(input,17,FOLLOW_17_in_statement177); if (state.failed) return retval;
					pushFollow(FOLLOW_compoundStatement_in_statement181);
					ctrue=compoundStatement();
					state._fsp--;
					if (state.failed) return retval;
					// QL.g:29:54: ( 'else' cfalse= compoundStatement )?
					int alt2=2;
					int LA2_0 = input.LA(1);
					if ( (LA2_0==28) ) {
						alt2=1;
					}
					switch (alt2) {
						case 1 :
							// QL.g:29:55: 'else' cfalse= compoundStatement
							{
							match(input,28,FOLLOW_28_in_statement184); if (state.failed) return retval;
							pushFollow(FOLLOW_compoundStatement_in_statement188);
							cfalse=compoundStatement();
							state._fsp--;
							if (state.failed) return retval;
							}
							break;

					}

					if ( state.backtracking==0 ) { retval.result = new ConditionalStatement(ex,ctrue,cfalse) ; }
					}
					break;
				case 3 :
					// QL.g:30:7: c= compoundStatement
					{
					pushFollow(FOLLOW_compoundStatement_in_statement202);
					c=compoundStatement();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) { retval.result = c ;}
					}
					break;

			}
			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 3, statement_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "statement"



	// $ANTLR start "type"
	// QL.g:35:1: type returns [TypeDescription result] : ( 'boolean' | 'string' | 'money' ( '(' x= orExpr ')' )? );
	public final TypeDescription type() throws RecognitionException {
		TypeDescription result = null;

		int type_StartIndex = input.index();

		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

			// QL.g:36:5: ( 'boolean' | 'string' | 'money' ( '(' x= orExpr ')' )? )
			int alt5=3;
			switch ( input.LA(1) ) {
			case 27:
				{
				alt5=1;
				}
				break;
			case 32:
				{
				alt5=2;
				}
				break;
			case 31:
				{
				alt5=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}
			switch (alt5) {
				case 1 :
					// QL.g:36:7: 'boolean'
					{
					match(input,27,FOLLOW_27_in_type229); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new BooleanType() ;}
					}
					break;
				case 2 :
					// QL.g:37:7: 'string'
					{
					match(input,32,FOLLOW_32_in_type239); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new StringType() ;}
					}
					break;
				case 3 :
					// QL.g:38:7: 'money' ( '(' x= orExpr ')' )?
					{
					match(input,31,FOLLOW_31_in_type250); if (state.failed) return result;
					// QL.g:38:15: ( '(' x= orExpr ')' )?
					int alt4=2;
					int LA4_0 = input.LA(1);
					if ( (LA4_0==16) ) {
						alt4=1;
					}
					switch (alt4) {
						case 1 :
							// QL.g:38:16: '(' x= orExpr ')'
							{
							match(input,16,FOLLOW_16_in_type253); if (state.failed) return result;
							pushFollow(FOLLOW_orExpr_in_type257);
							x=orExpr();
							state._fsp--;
							if (state.failed) return result;
							match(input,17,FOLLOW_17_in_type259); if (state.failed) return result;
							}
							break;

					}

					if ( state.backtracking==0 ) { result = new MoneyType(x) ;}
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
			if ( state.backtracking>0 ) { memoize(input, 4, type_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "type"



	// $ANTLR start "primary"
	// QL.g:41:1: primary returns [Expr result] : ( IntLiteral | Ident | BooleanLiteral | StringLiteral | '(' x= orExpr ')' );
	public final Expr primary() throws RecognitionException {
		Expr result = null;

		int primary_StartIndex = input.index();

		Token IntLiteral3=null;
		Token Ident4=null;
		Token BooleanLiteral5=null;
		Token StringLiteral6=null;
		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

			// QL.g:42:3: ( IntLiteral | Ident | BooleanLiteral | StringLiteral | '(' x= orExpr ')' )
			int alt6=5;
			switch ( input.LA(1) ) {
			case IntLiteral:
				{
				alt6=1;
				}
				break;
			case Ident:
				{
				alt6=2;
				}
				break;
			case BooleanLiteral:
				{
				alt6=3;
				}
				break;
			case StringLiteral:
				{
				alt6=4;
				}
				break;
			case 16:
				{
				alt6=5;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}
			switch (alt6) {
				case 1 :
					// QL.g:42:5: IntLiteral
					{
					IntLiteral3=(Token)match(input,IntLiteral,FOLLOW_IntLiteral_in_primary282); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new IntLiteral(Integer.parseInt((IntLiteral3!=null?IntLiteral3.getText():null))); }
					}
					break;
				case 2 :
					// QL.g:43:5: Ident
					{
					Ident4=(Token)match(input,Ident,FOLLOW_Ident_in_primary295); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Ident((Ident4!=null?Ident4.getText():null)); }
					}
					break;
				case 3 :
					// QL.g:44:5: BooleanLiteral
					{
					BooleanLiteral5=(Token)match(input,BooleanLiteral,FOLLOW_BooleanLiteral_in_primary313); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new BooleanLiteral((BooleanLiteral5!=null?BooleanLiteral5.getText():null)) ;}
					}
					break;
				case 4 :
					// QL.g:45:5: StringLiteral
					{
					StringLiteral6=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_primary322); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new StringLiteral((StringLiteral6!=null?StringLiteral6.getText():null)) ;}
					}
					break;
				case 5 :
					// QL.g:46:5: '(' x= orExpr ')'
					{
					match(input,16,FOLLOW_16_in_primary332); if (state.failed) return result;
					pushFollow(FOLLOW_orExpr_in_primary336);
					x=orExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,17,FOLLOW_17_in_primary338); if (state.failed) return result;
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
			if ( state.backtracking>0 ) { memoize(input, 5, primary_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "primary"



	// $ANTLR start "unExpr"
	// QL.g:49:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
	public final Expr unExpr() throws RecognitionException {
		Expr result = null;

		int unExpr_StartIndex = input.index();

		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

			// QL.g:50:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
			int alt7=4;
			switch ( input.LA(1) ) {
			case 19:
				{
				alt7=1;
				}
				break;
			case 20:
				{
				alt7=2;
				}
				break;
			case 13:
				{
				alt7=3;
				}
				break;
			case BooleanLiteral:
			case Ident:
			case IntLiteral:
			case StringLiteral:
			case 16:
				{
				alt7=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}
			switch (alt7) {
				case 1 :
					// QL.g:50:8: '+' x= unExpr
					{
					match(input,19,FOLLOW_19_in_unExpr363); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr367);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Pos(x); }
					}
					break;
				case 2 :
					// QL.g:51:8: '-' x= unExpr
					{
					match(input,20,FOLLOW_20_in_unExpr378); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr382);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Neg(x); }
					}
					break;
				case 3 :
					// QL.g:52:8: '!' x= unExpr
					{
					match(input,13,FOLLOW_13_in_unExpr393); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr397);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Not(x); }
					}
					break;
				case 4 :
					// QL.g:53:8: x= primary
					{
					pushFollow(FOLLOW_primary_in_unExpr410);
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
			if ( state.backtracking>0 ) { memoize(input, 6, unExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "unExpr"



	// $ANTLR start "mulExpr"
	// QL.g:56:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
	public final Expr mulExpr() throws RecognitionException {
		Expr result = null;

		int mulExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

			// QL.g:57:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
			// QL.g:57:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
			{
			pushFollow(FOLLOW_unExpr_in_mulExpr448);
			lhs=unExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// QL.g:57:45: (op= ( '*' | '/' ) rhs= unExpr )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==18||LA8_0==21) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// QL.g:57:47: op= ( '*' | '/' ) rhs= unExpr
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
					pushFollow(FOLLOW_unExpr_in_mulExpr468);
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
			if ( state.backtracking>0 ) { memoize(input, 7, mulExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "mulExpr"



	// $ANTLR start "addExpr"
	// QL.g:68:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
	public final Expr addExpr() throws RecognitionException {
		Expr result = null;

		int addExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

			// QL.g:69:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
			// QL.g:69:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
			{
			pushFollow(FOLLOW_mulExpr_in_addExpr506);
			lhs=mulExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// QL.g:69:46: (op= ( '+' | '-' ) rhs= mulExpr )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( ((LA9_0 >= 19 && LA9_0 <= 20)) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// QL.g:69:48: op= ( '+' | '-' ) rhs= mulExpr
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
					pushFollow(FOLLOW_mulExpr_in_addExpr524);
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
			if ( state.backtracking>0 ) { memoize(input, 8, addExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "addExpr"



	// $ANTLR start "relExpr"
	// QL.g:80:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
	public final Expr relExpr() throws RecognitionException {
		Expr result = null;

		int relExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

			// QL.g:81:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
			// QL.g:81:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			{
			pushFollow(FOLLOW_addExpr_in_relExpr559);
			lhs=addExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// QL.g:81:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==14||(LA10_0 >= 22 && LA10_0 <= 26)) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// QL.g:81:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==14||(input.LA(1) >= 22 && input.LA(1) <= 26) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_addExpr_in_relExpr583);
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
			if ( state.backtracking>0 ) { memoize(input, 9, relExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "relExpr"



	// $ANTLR start "andExpr"
	// QL.g:104:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
	public final Expr andExpr() throws RecognitionException {
		Expr result = null;

		int andExpr_StartIndex = input.index();

		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

			// QL.g:105:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
			// QL.g:105:9: lhs= relExpr ( '&&' rhs= relExpr )*
			{
			pushFollow(FOLLOW_relExpr_in_andExpr621);
			lhs=relExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// QL.g:105:46: ( '&&' rhs= relExpr )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==15) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// QL.g:105:48: '&&' rhs= relExpr
					{
					match(input,15,FOLLOW_15_in_andExpr627); if (state.failed) return result;
					pushFollow(FOLLOW_relExpr_in_andExpr631);
					rhs=relExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new And(result, rhs); }
					}
					break;

				default :
					break loop11;
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
			if ( state.backtracking>0 ) { memoize(input, 10, andExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "andExpr"



	// $ANTLR start "orExpr"
	// QL.g:108:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
	public final Expr orExpr() throws RecognitionException {
		Expr result = null;

		int orExpr_StartIndex = input.index();

		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

			// QL.g:109:5: (lhs= andExpr ( '||' rhs= andExpr )* )
			// QL.g:109:9: lhs= andExpr ( '||' rhs= andExpr )*
			{
			pushFollow(FOLLOW_andExpr_in_orExpr665);
			lhs=andExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = lhs; }
			// QL.g:109:48: ( '||' rhs= andExpr )*
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( (LA12_0==33) ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// QL.g:109:50: '||' rhs= andExpr
					{
					match(input,33,FOLLOW_33_in_orExpr671); if (state.failed) return result;
					pushFollow(FOLLOW_andExpr_in_orExpr675);
					rhs=andExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Or(result, rhs); }
					}
					break;

				default :
					break loop12;
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
			if ( state.backtracking>0 ) { memoize(input, 11, orExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "orExpr"

	// Delegated rules



	public static final BitSet FOLLOW_29_in_qlprogram48 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Ident_in_qlprogram50 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_compoundStatement_in_qlprogram55 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LBRACE_in_compoundStatement86 = new BitSet(new long[]{0x0000000040000680L});
	public static final BitSet FOLLOW_statement_in_compoundStatement98 = new BitSet(new long[]{0x0000000040000680L});
	public static final BitSet FOLLOW_RBRACE_in_compoundStatement113 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_statement149 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_COLON_in_statement151 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_StringLiteral_in_statement155 = new BitSet(new long[]{0x0000000188000000L});
	public static final BitSet FOLLOW_type_in_statement159 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_30_in_statement169 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_statement171 = new BitSet(new long[]{0x0000000000192990L});
	public static final BitSet FOLLOW_orExpr_in_statement175 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_statement177 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_compoundStatement_in_statement181 = new BitSet(new long[]{0x0000000010000002L});
	public static final BitSet FOLLOW_28_in_statement184 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_compoundStatement_in_statement188 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_compoundStatement_in_statement202 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_27_in_type229 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_32_in_type239 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_31_in_type250 = new BitSet(new long[]{0x0000000000010002L});
	public static final BitSet FOLLOW_16_in_type253 = new BitSet(new long[]{0x0000000000192990L});
	public static final BitSet FOLLOW_orExpr_in_type257 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_type259 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IntLiteral_in_primary282 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_primary295 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BooleanLiteral_in_primary313 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_StringLiteral_in_primary322 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_16_in_primary332 = new BitSet(new long[]{0x0000000000192990L});
	public static final BitSet FOLLOW_orExpr_in_primary336 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_primary338 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_19_in_unExpr363 = new BitSet(new long[]{0x0000000000192990L});
	public static final BitSet FOLLOW_unExpr_in_unExpr367 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_20_in_unExpr378 = new BitSet(new long[]{0x0000000000192990L});
	public static final BitSet FOLLOW_unExpr_in_unExpr382 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_13_in_unExpr393 = new BitSet(new long[]{0x0000000000192990L});
	public static final BitSet FOLLOW_unExpr_in_unExpr397 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpr410 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr448 = new BitSet(new long[]{0x0000000000240002L});
	public static final BitSet FOLLOW_set_in_mulExpr456 = new BitSet(new long[]{0x0000000000192990L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr468 = new BitSet(new long[]{0x0000000000240002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr506 = new BitSet(new long[]{0x0000000000180002L});
	public static final BitSet FOLLOW_set_in_addExpr514 = new BitSet(new long[]{0x0000000000192990L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr524 = new BitSet(new long[]{0x0000000000180002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr559 = new BitSet(new long[]{0x0000000007C04002L});
	public static final BitSet FOLLOW_set_in_relExpr567 = new BitSet(new long[]{0x0000000000192990L});
	public static final BitSet FOLLOW_addExpr_in_relExpr583 = new BitSet(new long[]{0x0000000007C04002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr621 = new BitSet(new long[]{0x0000000000008002L});
	public static final BitSet FOLLOW_15_in_andExpr627 = new BitSet(new long[]{0x0000000000192990L});
	public static final BitSet FOLLOW_relExpr_in_andExpr631 = new BitSet(new long[]{0x0000000000008002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr665 = new BitSet(new long[]{0x0000000200000002L});
	public static final BitSet FOLLOW_33_in_orExpr671 = new BitSet(new long[]{0x0000000000192990L});
	public static final BitSet FOLLOW_andExpr_in_orExpr675 = new BitSet(new long[]{0x0000000200000002L});
}