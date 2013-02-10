// $ANTLR 3.5 /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g 2013-02-04 17:05:47

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.types.*;
import org.uva.sea.ql.ast.literals.BooleanLiteral;
import org.uva.sea.ql.ast.literals.IntegerLiteral;
import org.uva.sea.ql.ast.literals.MoneyLiteral;
import org.uva.sea.ql.ast.literals.StringLiteral;
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
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "BigLiteral", "BooleanLiteral", 
		"COLON", "COMMENT", "Ident", "IntLiteral", "LBRACE", "RBRACE", "StringLiteral", 
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
	public static final int BigLiteral=4;
	public static final int BooleanLiteral=5;
	public static final int COLON=6;
	public static final int COMMENT=7;
	public static final int Ident=8;
	public static final int IntLiteral=9;
	public static final int LBRACE=10;
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
	// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:35:1: qlprogram returns [QLProgram result] : 'form' Ident cb= compoundStatement ;
	public final QLProgram qlprogram() throws RecognitionException {
		QLProgram result = null;

		int qlprogram_StartIndex = input.index();

		Token Ident1=null;
		Statement cb =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

			// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:36:5: ( 'form' Ident cb= compoundStatement )
			// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:36:7: 'form' Ident cb= compoundStatement
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
	// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:39:1: compoundStatement returns [Statement result] : LBRACE (st= statement )* RBRACE ;
	public final Statement compoundStatement() throws RecognitionException {
		Statement result = null;

		int compoundStatement_StartIndex = input.index();

		Statement st =null;

		 CompoundStatement compoundStatement = new CompoundStatement() ; 
		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

			// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:41:5: ( LBRACE (st= statement )* RBRACE )
			// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:41:7: LBRACE (st= statement )* RBRACE
			{
			match(input,LBRACE,FOLLOW_LBRACE_in_compoundStatement93); if (state.failed) return result;
			// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:42:7: (st= statement )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==Ident||LA1_0==LBRACE||LA1_0==31) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:42:8: st= statement
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
	// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:46:1: statement returns [Statement result] : ( Ident COLON StringLiteral type ( '(' x= orExpr ')' )? | 'if' '(' ex= orExpr ')' ctrue= compoundStatement ( 'else' cfalse= compoundStatement )? |cst= compoundStatement );
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

			// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:47:5: ( Ident COLON StringLiteral type ( '(' x= orExpr ')' )? | 'if' '(' ex= orExpr ')' ctrue= compoundStatement ( 'else' cfalse= compoundStatement )? |cst= compoundStatement )
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
					// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:47:7: Ident COLON StringLiteral type ( '(' x= orExpr ')' )?
					{
					Ident2=(Token)match(input,Ident,FOLLOW_Ident_in_statement155); if (state.failed) return result;
					match(input,COLON,FOLLOW_COLON_in_statement157); if (state.failed) return result;
					StringLiteral3=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_statement159); if (state.failed) return result;
					pushFollow(FOLLOW_type_in_statement161);
					type4=type();
					state._fsp--;
					if (state.failed) return result;
					// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:47:38: ( '(' x= orExpr ')' )?
					int alt2=2;
					int LA2_0 = input.LA(1);
					if ( (LA2_0==17) ) {
						alt2=1;
					}
					switch (alt2) {
						case 1 :
							// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:47:39: '(' x= orExpr ')'
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
					// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:48:7: 'if' '(' ex= orExpr ')' ctrue= compoundStatement ( 'else' cfalse= compoundStatement )?
					{
					match(input,31,FOLLOW_31_in_statement182); if (state.failed) return result;
					match(input,17,FOLLOW_17_in_statement184); if (state.failed) return result;
					pushFollow(FOLLOW_orExpr_in_statement188);
					ex=orExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,18,FOLLOW_18_in_statement190); if (state.failed) return result;
					pushFollow(FOLLOW_compoundStatement_in_statement194);
					ctrue=compoundStatement();
					state._fsp--;
					if (state.failed) return result;
					// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:48:54: ( 'else' cfalse= compoundStatement )?
					int alt3=2;
					int LA3_0 = input.LA(1);
					if ( (LA3_0==29) ) {
						alt3=1;
					}
					switch (alt3) {
						case 1 :
							// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:48:55: 'else' cfalse= compoundStatement
							{
							match(input,29,FOLLOW_29_in_statement197); if (state.failed) return result;
							pushFollow(FOLLOW_compoundStatement_in_statement201);
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
					// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:49:8: cst= compoundStatement
					{
					pushFollow(FOLLOW_compoundStatement_in_statement216);
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
	// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:52:1: type returns [TypeDescription result] : ( 'boolean' | 'string' | 'money' | 'integer' );
	public final Type type() throws RecognitionException {
		Type result = null;

		int type_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

			// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:53:5: ( 'boolean' | 'string' | 'money' | 'integer' )
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
					// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:53:7: 'boolean'
					{
					match(input,28,FOLLOW_28_in_type241); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new BooleanType() ;}
					}
					break;
				case 2 :
					// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:54:7: 'string'
					{
					match(input,34,FOLLOW_34_in_type251); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new StringType() ;}
					}
					break;
				case 3 :
					// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:55:7: 'money'
					{
					match(input,33,FOLLOW_33_in_type262); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new MoneyType() ;}
					}
					break;
				case 4 :
					// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:56:7: 'integer'
					{
					match(input,32,FOLLOW_32_in_type274); if (state.failed) return result;
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
	// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:59:1: primary returns [Expr result] : ( IntLiteral | BigLiteral | Ident | BooleanLiteral | StringLiteral | '(' x= orExpr ')' );
	public final Expr primary() throws RecognitionException {
		Expr result = null;

		int primary_StartIndex = input.index();

		Token IntLiteral5=null;
		Token BigLiteral6=null;
		Token Ident7=null;
		Token BooleanLiteral8=null;
		Token StringLiteral9=null;
		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

			// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:60:3: ( IntLiteral | BigLiteral | Ident | BooleanLiteral | StringLiteral | '(' x= orExpr ')' )
			int alt6=6;
			switch ( input.LA(1) ) {
			case IntLiteral:
				{
				alt6=1;
				}
				break;
			case BigLiteral:
				{
				alt6=2;
				}
				break;
			case Ident:
				{
				alt6=3;
				}
				break;
			case BooleanLiteral:
				{
				alt6=4;
				}
				break;
			case StringLiteral:
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
					// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:60:5: IntLiteral
					{
					IntLiteral5=(Token)match(input,IntLiteral,FOLLOW_IntLiteral_in_primary296); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new IntegerLiteral((IntLiteral5!=null?IntLiteral5.getText():null)); }
					}
					break;
				case 2 :
					// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:61:5: BigLiteral
					{
					BigLiteral6=(Token)match(input,BigLiteral,FOLLOW_BigLiteral_in_primary309); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new MoneyLiteral((BigLiteral6!=null?BigLiteral6.getText():null)); }
					}
					break;
				case 3 :
					// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:62:5: Ident
					{
					Ident7=(Token)match(input,Ident,FOLLOW_Ident_in_primary322); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Ident(Ident7); }
					}
					break;
				case 4 :
					// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:63:5: BooleanLiteral
					{
					BooleanLiteral8=(Token)match(input,BooleanLiteral,FOLLOW_BooleanLiteral_in_primary340); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new BooleanLiteral((BooleanLiteral8!=null?BooleanLiteral8.getText():null)) ;}
					}
					break;
				case 5 :
					// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:64:5: StringLiteral
					{
					StringLiteral9=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_primary349); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new StringLiteral((StringLiteral9!=null?StringLiteral9.getText():null)) ;}
					}
					break;
				case 6 :
					// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:65:5: '(' x= orExpr ')'
					{
					match(input,17,FOLLOW_17_in_primary359); if (state.failed) return result;
					pushFollow(FOLLOW_orExpr_in_primary363);
					x=orExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,18,FOLLOW_18_in_primary365); if (state.failed) return result;
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
	// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:68:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
	public final Expr unExpr() throws RecognitionException {
		Expr result = null;

		int unExpr_StartIndex = input.index();

		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

			// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:69:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
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
			case BigLiteral:
			case BooleanLiteral:
			case Ident:
			case IntLiteral:
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
					// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:69:8: '+' x= unExpr
					{
					match(input,20,FOLLOW_20_in_unExpr390); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr394);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Pos(x); }
					}
					break;
				case 2 :
					// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:70:8: '-' x= unExpr
					{
					match(input,21,FOLLOW_21_in_unExpr405); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr409);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Neg(x); }
					}
					break;
				case 3 :
					// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:71:8: '!' x= unExpr
					{
					match(input,14,FOLLOW_14_in_unExpr420); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr424);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Not(x); }
					}
					break;
				case 4 :
					// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:72:8: x= primary
					{
					pushFollow(FOLLOW_primary_in_unExpr437);
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
	// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:75:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
	public final Expr mulExpr() throws RecognitionException {
		Expr result = null;

		int mulExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

			// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:76:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
			// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:76:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
			{
			pushFollow(FOLLOW_unExpr_in_mulExpr475);
			lhs=unExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:76:45: (op= ( '*' | '/' ) rhs= unExpr )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==19||LA8_0==22) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:76:47: op= ( '*' | '/' ) rhs= unExpr
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
					pushFollow(FOLLOW_unExpr_in_mulExpr495);
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
	// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:87:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
	public final Expr addExpr() throws RecognitionException {
		Expr result = null;

		int addExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

			// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:88:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
			// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:88:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
			{
			pushFollow(FOLLOW_mulExpr_in_addExpr533);
			lhs=mulExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:88:46: (op= ( '+' | '-' ) rhs= mulExpr )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( ((LA9_0 >= 20 && LA9_0 <= 21)) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:88:48: op= ( '+' | '-' ) rhs= mulExpr
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
					pushFollow(FOLLOW_mulExpr_in_addExpr551);
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
	// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:99:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
	public final Expr relExpr() throws RecognitionException {
		Expr result = null;

		int relExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

			// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:100:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
			// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:100:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			{
			pushFollow(FOLLOW_addExpr_in_relExpr586);
			lhs=addExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:100:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==15||(LA10_0 >= 23 && LA10_0 <= 27)) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:100:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
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
					pushFollow(FOLLOW_addExpr_in_relExpr610);
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
	// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:123:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
	public final Expr andExpr() throws RecognitionException {
		Expr result = null;

		int andExpr_StartIndex = input.index();

		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

			// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:124:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
			// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:124:9: lhs= relExpr ( '&&' rhs= relExpr )*
			{
			pushFollow(FOLLOW_relExpr_in_andExpr648);
			lhs=relExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:124:46: ( '&&' rhs= relExpr )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==16) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:124:48: '&&' rhs= relExpr
					{
					match(input,16,FOLLOW_16_in_andExpr654); if (state.failed) return result;
					pushFollow(FOLLOW_relExpr_in_andExpr658);
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
	// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:127:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
	public final Expr orExpr() throws RecognitionException {
		Expr result = null;

		int orExpr_StartIndex = input.index();

		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

			// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:128:5: (lhs= andExpr ( '||' rhs= andExpr )* )
			// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:128:9: lhs= andExpr ( '||' rhs= andExpr )*
			{
			pushFollow(FOLLOW_andExpr_in_orExpr692);
			lhs=andExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = lhs; }
			// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:128:48: ( '||' rhs= andExpr )*
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( (LA12_0==35) ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// /Users/Ferry/sea-of-ql/FerryRiet/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:128:50: '||' rhs= andExpr
					{
					match(input,35,FOLLOW_35_in_orExpr698); if (state.failed) return result;
					pushFollow(FOLLOW_andExpr_in_orExpr702);
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



	public static final BitSet FOLLOW_30_in_qlprogram55 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_Ident_in_qlprogram57 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_compoundStatement_in_qlprogram62 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LBRACE_in_compoundStatement93 = new BitSet(new long[]{0x0000000080000D00L});
	public static final BitSet FOLLOW_statement_in_compoundStatement105 = new BitSet(new long[]{0x0000000080000D00L});
	public static final BitSet FOLLOW_RBRACE_in_compoundStatement120 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_statement155 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_COLON_in_statement157 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_StringLiteral_in_statement159 = new BitSet(new long[]{0x0000000710000000L});
	public static final BitSet FOLLOW_type_in_statement161 = new BitSet(new long[]{0x0000000000020002L});
	public static final BitSet FOLLOW_17_in_statement164 = new BitSet(new long[]{0x0000000000325330L});
	public static final BitSet FOLLOW_orExpr_in_statement168 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_18_in_statement170 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_31_in_statement182 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_statement184 = new BitSet(new long[]{0x0000000000325330L});
	public static final BitSet FOLLOW_orExpr_in_statement188 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_18_in_statement190 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_compoundStatement_in_statement194 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_29_in_statement197 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_compoundStatement_in_statement201 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_compoundStatement_in_statement216 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_28_in_type241 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_34_in_type251 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_33_in_type262 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_32_in_type274 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IntLiteral_in_primary296 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BigLiteral_in_primary309 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_primary322 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BooleanLiteral_in_primary340 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_StringLiteral_in_primary349 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_17_in_primary359 = new BitSet(new long[]{0x0000000000325330L});
	public static final BitSet FOLLOW_orExpr_in_primary363 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_18_in_primary365 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_20_in_unExpr390 = new BitSet(new long[]{0x0000000000325330L});
	public static final BitSet FOLLOW_unExpr_in_unExpr394 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_21_in_unExpr405 = new BitSet(new long[]{0x0000000000325330L});
	public static final BitSet FOLLOW_unExpr_in_unExpr409 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_14_in_unExpr420 = new BitSet(new long[]{0x0000000000325330L});
	public static final BitSet FOLLOW_unExpr_in_unExpr424 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpr437 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr475 = new BitSet(new long[]{0x0000000000480002L});
	public static final BitSet FOLLOW_set_in_mulExpr483 = new BitSet(new long[]{0x0000000000325330L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr495 = new BitSet(new long[]{0x0000000000480002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr533 = new BitSet(new long[]{0x0000000000300002L});
	public static final BitSet FOLLOW_set_in_addExpr541 = new BitSet(new long[]{0x0000000000325330L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr551 = new BitSet(new long[]{0x0000000000300002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr586 = new BitSet(new long[]{0x000000000F808002L});
	public static final BitSet FOLLOW_set_in_relExpr594 = new BitSet(new long[]{0x0000000000325330L});
	public static final BitSet FOLLOW_addExpr_in_relExpr610 = new BitSet(new long[]{0x000000000F808002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr648 = new BitSet(new long[]{0x0000000000010002L});
	public static final BitSet FOLLOW_16_in_andExpr654 = new BitSet(new long[]{0x0000000000325330L});
	public static final BitSet FOLLOW_relExpr_in_andExpr658 = new BitSet(new long[]{0x0000000000010002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr692 = new BitSet(new long[]{0x0000000800000002L});
	public static final BitSet FOLLOW_35_in_orExpr698 = new BitSet(new long[]{0x0000000000325330L});
	public static final BitSet FOLLOW_andExpr_in_orExpr702 = new BitSet(new long[]{0x0000000800000002L});
}
