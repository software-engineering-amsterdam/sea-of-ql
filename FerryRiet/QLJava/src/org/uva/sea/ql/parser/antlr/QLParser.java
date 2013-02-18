// $ANTLR 3.5 /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g 2013-02-18 11:08:41

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.literals.*;
import org.uva.sea.ql.ast.types.*;
import org.uva.sea.ql.ast.statements.*;
import org.uva.sea.ql.ast.operators.*;
import java.util.LinkedList;


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
		"Ident", "IntegerLiteral", "LBRACE", "MoneyLiteral", "RBRACE", "StringLiteral", 
		"WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", "'/'", 
		"'<'", "'<='", "'=='", "'>'", "'>='", "'boolean'", "'else'", "'form'", 
		"'if'", "'integer'", "'money'", "'string'", "'||'"
	};
	public static final int EOF=-1;
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
	public static final int T__34=34;
	public static final int T__35=35;
	public static final int BooleanLiteral=4;
	public static final int COLON=5;
	public static final int COMMENT=6;
	public static final int Ident=7;
	public static final int IntegerLiteral=8;
	public static final int LBRACE=9;
	public static final int MoneyLiteral=10;
	public static final int RBRACE=11;
	public static final int StringLiteral=12;
	public static final int WS=13;

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
		this.state.ruleMemo = new HashMap[39+1];


	}

	@Override public String[] getTokenNames() { return QLParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g"; }


	    private List<String> errors = new LinkedList<String>();
	    public void displayRecognitionError(String[] tokenNames,
	                                        RecognitionException e) {
	        String hdr = getErrorHeader(e);
	        String msg = getErrorMessage(e, tokenNames);
	        errors.add(hdr + " " + msg);
	    }
	    public List<String> getErrors() {
	        return errors;
	    }
	    public int getErrorCount() {
	        return errors.size() ;
	    }



	// $ANTLR start "qlprogram"
	// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:36:1: qlprogram returns [QLProgram result] : 'form' Ident cb= compoundStatement ;
	public final QLProgram qlprogram() throws RecognitionException {
		QLProgram result = null;

		int qlprogram_StartIndex = input.index();

		Token Ident1=null;
		Statement cb =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

			// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:37:5: ( 'form' Ident cb= compoundStatement )
			// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:37:7: 'form' Ident cb= compoundStatement
			{
			match(input,30,FOLLOW_30_in_qlprogram55); if (state.failed) return result;
			Ident1=(Token)match(input,Ident,FOLLOW_Ident_in_qlprogram57); if (state.failed) return result;
			pushFollow(FOLLOW_compoundStatement_in_qlprogram62);
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
	// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:40:1: compoundStatement returns [Statement result] : LBRACE (st= statement )* RBRACE ;
	public final Statement compoundStatement() throws RecognitionException {
		Statement result = null;

		int compoundStatement_StartIndex = input.index();

		Statement st =null;

		 CompoundStatement compoundStatement = new CompoundStatement() ; 
		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

			// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:42:5: ( LBRACE (st= statement )* RBRACE )
			// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:42:7: LBRACE (st= statement )* RBRACE
			{
			match(input,LBRACE,FOLLOW_LBRACE_in_compoundStatement93); if (state.failed) return result;
			// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:43:7: (st= statement )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==Ident||LA1_0==LBRACE||LA1_0==31) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:43:8: st= statement
					{
					pushFollow(FOLLOW_statement_in_compoundStatement105);
					st=statement();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { compoundStatement.addStatement(st) ; }
					}
					break;

				default :
					break loop1;
				}
			}

			match(input,RBRACE,FOLLOW_RBRACE_in_compoundStatement120); if (state.failed) return result;
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



	// $ANTLR start "statement"
	// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:47:1: statement returns [Statement result] : ( Ident COLON StringLiteral type ( '(' x= orExpr ')' )? | 'if' '(' ex= orExpr ')' ctrue= compoundStatement ( 'else' cfalse= compoundStatement )? |cst= compoundStatement );
	public final Statement statement() throws RecognitionException {
		Statement result = null;

		int statement_StartIndex = input.index();

		Token Ident2=null;
		Token StringLiteral3=null;
		Expr x =null;
		Expr ex =null;
		Statement ctrue =null;
		Statement cfalse =null;
		Statement cst =null;
		Type type4 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

			// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:48:5: ( Ident COLON StringLiteral type ( '(' x= orExpr ')' )? | 'if' '(' ex= orExpr ')' ctrue= compoundStatement ( 'else' cfalse= compoundStatement )? |cst= compoundStatement )
			int alt4=3;
			switch ( input.LA(1) ) {
			case Ident:
				{
				alt4=1;
				}
				break;
			case 31:
				{
				alt4=2;
				}
				break;
			case LBRACE:
				{
				alt4=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}
			switch (alt4) {
				case 1 :
					// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:48:7: Ident COLON StringLiteral type ( '(' x= orExpr ')' )?
					{
					Ident2=(Token)match(input,Ident,FOLLOW_Ident_in_statement155); if (state.failed) return result;
					match(input,COLON,FOLLOW_COLON_in_statement157); if (state.failed) return result;
					StringLiteral3=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_statement159); if (state.failed) return result;
					pushFollow(FOLLOW_type_in_statement161);
					type4=type();
					state._fsp--;
					if (state.failed) return result;
					// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:48:38: ( '(' x= orExpr ')' )?
					int alt2=2;
					int LA2_0 = input.LA(1);
					if ( (LA2_0==17) ) {
						alt2=1;
					}
					switch (alt2) {
						case 1 :
							// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:48:39: '(' x= orExpr ')'
							{
							match(input,17,FOLLOW_17_in_statement164); if (state.failed) return result;
							pushFollow(FOLLOW_orExpr_in_statement168);
							x=orExpr();
							state._fsp--;
							if (state.failed) return result;
							match(input,18,FOLLOW_18_in_statement170); if (state.failed) return result;
							}
							break;

					}

					if ( state.backtracking==0 ) { result = new LineStatement(new Ident(Ident2),StringLiteral3,type4,x); }
					}
					break;
				case 2 :
					// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:50:7: 'if' '(' ex= orExpr ')' ctrue= compoundStatement ( 'else' cfalse= compoundStatement )?
					{
					match(input,31,FOLLOW_31_in_statement193); if (state.failed) return result;
					match(input,17,FOLLOW_17_in_statement195); if (state.failed) return result;
					pushFollow(FOLLOW_orExpr_in_statement199);
					ex=orExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,18,FOLLOW_18_in_statement201); if (state.failed) return result;
					pushFollow(FOLLOW_compoundStatement_in_statement205);
					ctrue=compoundStatement();
					state._fsp--;
					if (state.failed) return result;
					// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:50:54: ( 'else' cfalse= compoundStatement )?
					int alt3=2;
					int LA3_0 = input.LA(1);
					if ( (LA3_0==29) ) {
						alt3=1;
					}
					switch (alt3) {
						case 1 :
							// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:50:55: 'else' cfalse= compoundStatement
							{
							match(input,29,FOLLOW_29_in_statement208); if (state.failed) return result;
							pushFollow(FOLLOW_compoundStatement_in_statement212);
							cfalse=compoundStatement();
							state._fsp--;
							if (state.failed) return result;
							}
							break;

					}

					if ( state.backtracking==0 ) { result = new ConditionalStatement(ex,ctrue,cfalse) ; }
					}
					break;
				case 3 :
					// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:52:8: cst= compoundStatement
					{
					pushFollow(FOLLOW_compoundStatement_in_statement238);
					cst=compoundStatement();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = cst ;}
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
			if ( state.backtracking>0 ) { memoize(input, 3, statement_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "statement"



	// $ANTLR start "type"
	// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:55:1: type returns [Type result] : ( 'boolean' | 'string' | 'money' | 'integer' );
	public final Type type() throws RecognitionException {
		Type result = null;

		int type_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

			// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:56:5: ( 'boolean' | 'string' | 'money' | 'integer' )
			int alt5=4;
			switch ( input.LA(1) ) {
			case 28:
				{
				alt5=1;
				}
				break;
			case 34:
				{
				alt5=2;
				}
				break;
			case 33:
				{
				alt5=3;
				}
				break;
			case 32:
				{
				alt5=4;
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
					// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:56:7: 'boolean'
					{
					match(input,28,FOLLOW_28_in_type263); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new BooleanType() ;}
					}
					break;
				case 2 :
					// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:57:7: 'string'
					{
					match(input,34,FOLLOW_34_in_type273); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new StringType() ;}
					}
					break;
				case 3 :
					// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:58:7: 'money'
					{
					match(input,33,FOLLOW_33_in_type284); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new MoneyType() ;}
					}
					break;
				case 4 :
					// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:59:7: 'integer'
					{
					match(input,32,FOLLOW_32_in_type296); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new IntegerType() ;}
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
	// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:62:1: primary returns [Expr result] : ( IntegerLiteral | MoneyLiteral | BooleanLiteral | StringLiteral | Ident | '(' x= orExpr ')' );
	public final Expr primary() throws RecognitionException {
		Expr result = null;

		int primary_StartIndex = input.index();

		Token IntegerLiteral5=null;
		Token MoneyLiteral6=null;
		Token BooleanLiteral7=null;
		Token StringLiteral8=null;
		Token Ident9=null;
		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

			// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:63:3: ( IntegerLiteral | MoneyLiteral | BooleanLiteral | StringLiteral | Ident | '(' x= orExpr ')' )
			int alt6=6;
			switch ( input.LA(1) ) {
			case IntegerLiteral:
				{
				alt6=1;
				}
				break;
			case MoneyLiteral:
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
			case Ident:
				{
				alt6=5;
				}
				break;
			case 17:
				{
				alt6=6;
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
					// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:63:5: IntegerLiteral
					{
					IntegerLiteral5=(Token)match(input,IntegerLiteral,FOLLOW_IntegerLiteral_in_primary319); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new IntegerLiteral((IntegerLiteral5!=null?IntegerLiteral5.getText():null)); }
					}
					break;
				case 2 :
					// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:64:5: MoneyLiteral
					{
					MoneyLiteral6=(Token)match(input,MoneyLiteral,FOLLOW_MoneyLiteral_in_primary332); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new MoneyLiteral((MoneyLiteral6!=null?MoneyLiteral6.getText():null)); }
					}
					break;
				case 3 :
					// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:65:5: BooleanLiteral
					{
					BooleanLiteral7=(Token)match(input,BooleanLiteral,FOLLOW_BooleanLiteral_in_primary347); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new BooleanLiteral((BooleanLiteral7!=null?BooleanLiteral7.getText():null)) ;}
					}
					break;
				case 4 :
					// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:66:5: StringLiteral
					{
					StringLiteral8=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_primary360); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new StringLiteral((StringLiteral8!=null?StringLiteral8.getText():null)) ;}
					}
					break;
				case 5 :
					// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:67:5: Ident
					{
					Ident9=(Token)match(input,Ident,FOLLOW_Ident_in_primary374); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Ident(Ident9); }
					}
					break;
				case 6 :
					// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:68:5: '(' x= orExpr ')'
					{
					match(input,17,FOLLOW_17_in_primary396); if (state.failed) return result;
					pushFollow(FOLLOW_orExpr_in_primary400);
					x=orExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,18,FOLLOW_18_in_primary402); if (state.failed) return result;
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
	// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:71:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
	public final Expr unExpr() throws RecognitionException {
		Expr result = null;

		int unExpr_StartIndex = input.index();

		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

			// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:72:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
			int alt7=4;
			switch ( input.LA(1) ) {
			case 20:
				{
				alt7=1;
				}
				break;
			case 21:
				{
				alt7=2;
				}
				break;
			case 14:
				{
				alt7=3;
				}
				break;
			case BooleanLiteral:
			case Ident:
			case IntegerLiteral:
			case MoneyLiteral:
			case StringLiteral:
			case 17:
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
					// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:72:8: '+' x= unExpr
					{
					match(input,20,FOLLOW_20_in_unExpr431); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr435);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Pos(x); }
					}
					break;
				case 2 :
					// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:73:8: '-' x= unExpr
					{
					match(input,21,FOLLOW_21_in_unExpr446); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr450);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Neg(x); }
					}
					break;
				case 3 :
					// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:74:8: '!' x= unExpr
					{
					match(input,14,FOLLOW_14_in_unExpr461); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr465);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Not(x); }
					}
					break;
				case 4 :
					// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:75:8: x= primary
					{
					pushFollow(FOLLOW_primary_in_unExpr478);
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
	// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:78:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
	public final Expr mulExpr() throws RecognitionException {
		Expr result = null;

		int mulExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

			// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:79:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
			// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:79:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
			{
			pushFollow(FOLLOW_unExpr_in_mulExpr516);
			lhs=unExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:79:45: (op= ( '*' | '/' ) rhs= unExpr )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==19||LA8_0==22) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:79:47: op= ( '*' | '/' ) rhs= unExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==19||input.LA(1)==22 ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_unExpr_in_mulExpr536);
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
	// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:90:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
	public final Expr addExpr() throws RecognitionException {
		Expr result = null;

		int addExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

			// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:91:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
			// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:91:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
			{
			pushFollow(FOLLOW_mulExpr_in_addExpr574);
			lhs=mulExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:91:46: (op= ( '+' | '-' ) rhs= mulExpr )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( ((LA9_0 >= 20 && LA9_0 <= 21)) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:91:48: op= ( '+' | '-' ) rhs= mulExpr
					{
					op=input.LT(1);
					if ( (input.LA(1) >= 20 && input.LA(1) <= 21) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_mulExpr_in_addExpr592);
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
	// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:102:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
	public final Expr relExpr() throws RecognitionException {
		Expr result = null;

		int relExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

			// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:103:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
			// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:103:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			{
			pushFollow(FOLLOW_addExpr_in_relExpr627);
			lhs=addExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:103:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==15||(LA10_0 >= 23 && LA10_0 <= 27)) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:103:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==15||(input.LA(1) >= 23 && input.LA(1) <= 27) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_addExpr_in_relExpr651);
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
	// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:126:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
	public final Expr andExpr() throws RecognitionException {
		Expr result = null;

		int andExpr_StartIndex = input.index();

		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

			// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:127:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
			// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:127:9: lhs= relExpr ( '&&' rhs= relExpr )*
			{
			pushFollow(FOLLOW_relExpr_in_andExpr689);
			lhs=relExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:127:46: ( '&&' rhs= relExpr )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==16) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:127:48: '&&' rhs= relExpr
					{
					match(input,16,FOLLOW_16_in_andExpr695); if (state.failed) return result;
					pushFollow(FOLLOW_relExpr_in_andExpr699);
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
	// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:130:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
	public final Expr orExpr() throws RecognitionException {
		Expr result = null;

		int orExpr_StartIndex = input.index();

		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

			// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:131:5: (lhs= andExpr ( '||' rhs= andExpr )* )
			// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:131:9: lhs= andExpr ( '||' rhs= andExpr )*
			{
			pushFollow(FOLLOW_andExpr_in_orExpr733);
			lhs=andExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = lhs; }
			// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:131:48: ( '||' rhs= andExpr )*
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( (LA12_0==35) ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:131:50: '||' rhs= andExpr
					{
					match(input,35,FOLLOW_35_in_orExpr739); if (state.failed) return result;
					pushFollow(FOLLOW_andExpr_in_orExpr743);
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



	public static final BitSet FOLLOW_30_in_qlprogram55 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Ident_in_qlprogram57 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_compoundStatement_in_qlprogram62 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LBRACE_in_compoundStatement93 = new BitSet(new long[]{0x0000000080000A80L});
	public static final BitSet FOLLOW_statement_in_compoundStatement105 = new BitSet(new long[]{0x0000000080000A80L});
	public static final BitSet FOLLOW_RBRACE_in_compoundStatement120 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_statement155 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_COLON_in_statement157 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_StringLiteral_in_statement159 = new BitSet(new long[]{0x0000000710000000L});
	public static final BitSet FOLLOW_type_in_statement161 = new BitSet(new long[]{0x0000000000020002L});
	public static final BitSet FOLLOW_17_in_statement164 = new BitSet(new long[]{0x0000000000325590L});
	public static final BitSet FOLLOW_orExpr_in_statement168 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_18_in_statement170 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_31_in_statement193 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_statement195 = new BitSet(new long[]{0x0000000000325590L});
	public static final BitSet FOLLOW_orExpr_in_statement199 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_18_in_statement201 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_compoundStatement_in_statement205 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_29_in_statement208 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_compoundStatement_in_statement212 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_compoundStatement_in_statement238 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_28_in_type263 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_34_in_type273 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_33_in_type284 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_32_in_type296 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IntegerLiteral_in_primary319 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MoneyLiteral_in_primary332 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BooleanLiteral_in_primary347 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_StringLiteral_in_primary360 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_primary374 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_17_in_primary396 = new BitSet(new long[]{0x0000000000325590L});
	public static final BitSet FOLLOW_orExpr_in_primary400 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_18_in_primary402 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_20_in_unExpr431 = new BitSet(new long[]{0x0000000000325590L});
	public static final BitSet FOLLOW_unExpr_in_unExpr435 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_21_in_unExpr446 = new BitSet(new long[]{0x0000000000325590L});
	public static final BitSet FOLLOW_unExpr_in_unExpr450 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_14_in_unExpr461 = new BitSet(new long[]{0x0000000000325590L});
	public static final BitSet FOLLOW_unExpr_in_unExpr465 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpr478 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr516 = new BitSet(new long[]{0x0000000000480002L});
	public static final BitSet FOLLOW_set_in_mulExpr524 = new BitSet(new long[]{0x0000000000325590L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr536 = new BitSet(new long[]{0x0000000000480002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr574 = new BitSet(new long[]{0x0000000000300002L});
	public static final BitSet FOLLOW_set_in_addExpr582 = new BitSet(new long[]{0x0000000000325590L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr592 = new BitSet(new long[]{0x0000000000300002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr627 = new BitSet(new long[]{0x000000000F808002L});
	public static final BitSet FOLLOW_set_in_relExpr635 = new BitSet(new long[]{0x0000000000325590L});
	public static final BitSet FOLLOW_addExpr_in_relExpr651 = new BitSet(new long[]{0x000000000F808002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr689 = new BitSet(new long[]{0x0000000000010002L});
	public static final BitSet FOLLOW_16_in_andExpr695 = new BitSet(new long[]{0x0000000000325590L});
	public static final BitSet FOLLOW_relExpr_in_andExpr699 = new BitSet(new long[]{0x0000000000010002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr733 = new BitSet(new long[]{0x0000000800000002L});
	public static final BitSet FOLLOW_35_in_orExpr739 = new BitSet(new long[]{0x0000000000325590L});
	public static final BitSet FOLLOW_andExpr_in_orExpr743 = new BitSet(new long[]{0x0000000800000002L});
}
