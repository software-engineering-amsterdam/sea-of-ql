// $ANTLR 3.5 /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g 2013-01-13 14:09:55

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.parser.antlr.types.*;
import org.uva.sea.ql.parser.antlr.operators.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings("all")
public class QLParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "BLOCK_END", "BLOCK_START", "Bool", 
		"COMMENT", "ELSE", "EscapedCharacterSequence", "FORM", "IF", "IF_STATEMENT_PREFIX", 
		"IF_STATEMENT_SUFFIX", "Ident", "Int", "Money", "String", "Type", "WS", 
		"'!'", "'!='", "'&&'", "'*'", "'+'", "'-'", "'/'", "':'", "'<'", "'<='", 
		"'=='", "'>'", "'>='", "'||'"
	};
	public static final int EOF=-1;
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
	public static final int BLOCK_END=4;
	public static final int BLOCK_START=5;
	public static final int Bool=6;
	public static final int COMMENT=7;
	public static final int ELSE=8;
	public static final int EscapedCharacterSequence=9;
	public static final int FORM=10;
	public static final int IF=11;
	public static final int IF_STATEMENT_PREFIX=12;
	public static final int IF_STATEMENT_SUFFIX=13;
	public static final int Ident=14;
	public static final int Int=15;
	public static final int Money=16;
	public static final int String=17;
	public static final int Type=18;
	public static final int WS=19;

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
		this.state.ruleMemo = new HashMap[35+1];


	}

	@Override public String[] getTokenNames() { return QLParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g"; }


	//  @Override
	//  public void reportError(RecognitionException e) {
	//   throw new RuntimeException(e.getMessage()); 
	//  }



	// $ANTLR start "formExpression"
	// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:34:1: formExpression returns [Form result] : FORM Ident BLOCK_START expressions= questionArray BLOCK_END ;
	public final Form formExpression() throws RecognitionException {
		Form result = null;

		int formExpression_StartIndex = input.index();

		List<FormQuestion> expressions =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:35:2: ( FORM Ident BLOCK_START expressions= questionArray BLOCK_END )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:35:4: FORM Ident BLOCK_START expressions= questionArray BLOCK_END
			{
			match(input,FORM,FOLLOW_FORM_in_formExpression66); if (state.failed) return result;
			match(input,Ident,FOLLOW_Ident_in_formExpression68); if (state.failed) return result;
			match(input,BLOCK_START,FOLLOW_BLOCK_START_in_formExpression70); if (state.failed) return result;
			pushFollow(FOLLOW_questionArray_in_formExpression74);
			expressions=questionArray();
			state._fsp--;
			if (state.failed) return result;
			match(input,BLOCK_END,FOLLOW_BLOCK_END_in_formExpression76); if (state.failed) return result;
			if ( state.backtracking==0 ) {

			    
			    result = new Form(expressions);
			  }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 1, formExpression_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "formExpression"



	// $ANTLR start "questionArray"
	// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:41:1: questionArray returns [List<FormQuestion> expressions] : (e= questionExpression )+ ;
	public final List<FormQuestion> questionArray() throws RecognitionException {
		List<FormQuestion> expressions = null;

		int questionArray_StartIndex = input.index();

		FormQuestion e =null;

		 expressions = new ArrayList<FormQuestion>(); 
		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return expressions; }

			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:43:5: ( (e= questionExpression )+ )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:43:7: (e= questionExpression )+
			{
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:43:7: (e= questionExpression )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==Ident) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:43:8: e= questionExpression
					{
					pushFollow(FOLLOW_questionExpression_in_questionArray106);
					e=questionExpression();
					state._fsp--;
					if (state.failed) return expressions;
					if ( state.backtracking==0 ) { expressions.add(e); }
					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					if (state.backtracking>0) {state.failed=true; return expressions;}
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 2, questionArray_StartIndex); }

		}
		return expressions;
	}
	// $ANTLR end "questionArray"



	// $ANTLR start "questionExpression"
	// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:45:1: questionExpression returns [FormQuestion result] : label= Ident ':' question= String parameter= dataTypeExpression ;
	public final FormQuestion questionExpression() throws RecognitionException {
		FormQuestion result = null;

		int questionExpression_StartIndex = input.index();

		Token label=null;
		Token question=null;
		DataType parameter =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:46:3: (label= Ident ':' question= String parameter= dataTypeExpression )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:46:5: label= Ident ':' question= String parameter= dataTypeExpression
			{
			label=(Token)match(input,Ident,FOLLOW_Ident_in_questionExpression126); if (state.failed) return result;
			match(input,27,FOLLOW_27_in_questionExpression128); if (state.failed) return result;
			question=(Token)match(input,String,FOLLOW_String_in_questionExpression132); if (state.failed) return result;
			pushFollow(FOLLOW_dataTypeExpression_in_questionExpression136);
			parameter=dataTypeExpression();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) {
			    result = new FormQuestion((label!=null?label.getText():null), (question!=null?question.getText():null), parameter);
			  }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 3, questionExpression_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "questionExpression"



	// $ANTLR start "dataTypeExpression"
	// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:50:1: dataTypeExpression returns [DataType result] : Type ;
	public final DataType dataTypeExpression() throws RecognitionException {
		DataType result = null;

		int dataTypeExpression_StartIndex = input.index();

		Token Type1=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:51:2: ( Type )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:51:4: Type
			{
			Type1=(Token)match(input,Type,FOLLOW_Type_in_dataTypeExpression153); if (state.failed) return result;
			if ( state.backtracking==0 ) {
			    if ((Type1!=null?Type1.getText():null).equals("string")) result = new StringLiteral();
			    else if ((Type1!=null?Type1.getText():null).equals("integer")) result = new Int();
			    else if ((Type1!=null?Type1.getText():null).equals("money")) result = new Money();
			    else if ((Type1!=null?Type1.getText():null).equals("boolean")) result = new Bool();
			 }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 4, dataTypeExpression_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "dataTypeExpression"



	// $ANTLR start "primary"
	// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:58:1: primary returns [Expression result] : ( Int | Money | Bool | Ident | String | '(' x= orExpression ')' | ifExpression );
	public final Expression primary() throws RecognitionException {
		Expression result = null;

		int primary_StartIndex = input.index();

		Token Int2=null;
		Token Money3=null;
		Token Bool4=null;
		Token Ident5=null;
		Token String6=null;
		Expression x =null;
		IfExpression ifExpression7 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:59:3: ( Int | Money | Bool | Ident | String | '(' x= orExpression ')' | ifExpression )
			int alt2=7;
			switch ( input.LA(1) ) {
			case Int:
				{
				alt2=1;
				}
				break;
			case Money:
				{
				alt2=2;
				}
				break;
			case Bool:
				{
				alt2=3;
				}
				break;
			case Ident:
				{
				alt2=4;
				}
				break;
			case String:
				{
				alt2=5;
				}
				break;
			case IF_STATEMENT_PREFIX:
				{
				alt2=6;
				}
				break;
			case IF:
				{
				alt2=7;
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
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:59:5: Int
					{
					Int2=(Token)match(input,Int,FOLLOW_Int_in_primary170); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Int(Integer.parseInt((Int2!=null?Int2.getText():null))); }
					}
					break;
				case 2 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:60:5: Money
					{
					Money3=(Token)match(input,Money,FOLLOW_Money_in_primary180); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Money((Money3!=null?Money3.getText():null)); }
					}
					break;
				case 3 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:61:5: Bool
					{
					Bool4=(Token)match(input,Bool,FOLLOW_Bool_in_primary188); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Bool(Boolean.parseBoolean((Bool4!=null?Bool4.getText():null))); }
					}
					break;
				case 4 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:62:5: Ident
					{
					Ident5=(Token)match(input,Ident,FOLLOW_Ident_in_primary196); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Ident((Ident5!=null?Ident5.getText():null)); }
					}
					break;
				case 5 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:63:5: String
					{
					String6=(Token)match(input,String,FOLLOW_String_in_primary204); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new StringLiteral((String6!=null?String6.getText():null).substring(1, (String6!=null?String6.getText():null).length() - 1)); }
					}
					break;
				case 6 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:64:5: '(' x= orExpression ')'
					{
					match(input,IF_STATEMENT_PREFIX,FOLLOW_IF_STATEMENT_PREFIX_in_primary212); if (state.failed) return result;
					pushFollow(FOLLOW_orExpression_in_primary216);
					x=orExpression();
					state._fsp--;
					if (state.failed) return result;
					match(input,IF_STATEMENT_SUFFIX,FOLLOW_IF_STATEMENT_SUFFIX_in_primary218); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = x; }
					}
					break;
				case 7 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:65:5: ifExpression
					{
					pushFollow(FOLLOW_ifExpression_in_primary225);
					ifExpression7=ifExpression();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = ifExpression7; }
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



	// $ANTLR start "ifExpression"
	// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:68:1: ifExpression returns [IfExpression result] : ( IF IF_STATEMENT_PREFIX statement= orExpression IF_STATEMENT_SUFFIX BLOCK_START successStatements= orExpression BLOCK_END ELSE BLOCK_START elseStatements= orExpression BLOCK_END | IF IF_STATEMENT_PREFIX statement= orExpression IF_STATEMENT_SUFFIX BLOCK_START successStatements= orExpression BLOCK_END );
	public final IfExpression ifExpression() throws RecognitionException {
		IfExpression result = null;

		int ifExpression_StartIndex = input.index();

		Expression statement =null;
		Expression successStatements =null;
		Expression elseStatements =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:69:5: ( IF IF_STATEMENT_PREFIX statement= orExpression IF_STATEMENT_SUFFIX BLOCK_START successStatements= orExpression BLOCK_END ELSE BLOCK_START elseStatements= orExpression BLOCK_END | IF IF_STATEMENT_PREFIX statement= orExpression IF_STATEMENT_SUFFIX BLOCK_START successStatements= orExpression BLOCK_END )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==IF) ) {
				int LA3_1 = input.LA(2);
				if ( (synpred8_QL()) ) {
					alt3=1;
				}
				else if ( (true) ) {
					alt3=2;
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:69:7: IF IF_STATEMENT_PREFIX statement= orExpression IF_STATEMENT_SUFFIX BLOCK_START successStatements= orExpression BLOCK_END ELSE BLOCK_START elseStatements= orExpression BLOCK_END
					{
					match(input,IF,FOLLOW_IF_in_ifExpression246); if (state.failed) return result;
					match(input,IF_STATEMENT_PREFIX,FOLLOW_IF_STATEMENT_PREFIX_in_ifExpression248); if (state.failed) return result;
					pushFollow(FOLLOW_orExpression_in_ifExpression252);
					statement=orExpression();
					state._fsp--;
					if (state.failed) return result;
					match(input,IF_STATEMENT_SUFFIX,FOLLOW_IF_STATEMENT_SUFFIX_in_ifExpression254); if (state.failed) return result;
					match(input,BLOCK_START,FOLLOW_BLOCK_START_in_ifExpression256); if (state.failed) return result;
					pushFollow(FOLLOW_orExpression_in_ifExpression260);
					successStatements=orExpression();
					state._fsp--;
					if (state.failed) return result;
					match(input,BLOCK_END,FOLLOW_BLOCK_END_in_ifExpression262); if (state.failed) return result;
					match(input,ELSE,FOLLOW_ELSE_in_ifExpression264); if (state.failed) return result;
					match(input,BLOCK_START,FOLLOW_BLOCK_START_in_ifExpression266); if (state.failed) return result;
					pushFollow(FOLLOW_orExpression_in_ifExpression270);
					elseStatements=orExpression();
					state._fsp--;
					if (state.failed) return result;
					match(input,BLOCK_END,FOLLOW_BLOCK_END_in_ifExpression272); if (state.failed) return result;
					if ( state.backtracking==0 ) {
					      result = new IfElse(statement, successStatements, elseStatements);
					    }
					}
					break;
				case 2 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:73:7: IF IF_STATEMENT_PREFIX statement= orExpression IF_STATEMENT_SUFFIX BLOCK_START successStatements= orExpression BLOCK_END
					{
					match(input,IF,FOLLOW_IF_in_ifExpression286); if (state.failed) return result;
					match(input,IF_STATEMENT_PREFIX,FOLLOW_IF_STATEMENT_PREFIX_in_ifExpression288); if (state.failed) return result;
					pushFollow(FOLLOW_orExpression_in_ifExpression292);
					statement=orExpression();
					state._fsp--;
					if (state.failed) return result;
					match(input,IF_STATEMENT_SUFFIX,FOLLOW_IF_STATEMENT_SUFFIX_in_ifExpression294); if (state.failed) return result;
					match(input,BLOCK_START,FOLLOW_BLOCK_START_in_ifExpression296); if (state.failed) return result;
					pushFollow(FOLLOW_orExpression_in_ifExpression300);
					successStatements=orExpression();
					state._fsp--;
					if (state.failed) return result;
					match(input,BLOCK_END,FOLLOW_BLOCK_END_in_ifExpression302); if (state.failed) return result;
					if ( state.backtracking==0 ) {
					      result = new If(statement, successStatements);
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
			if ( state.backtracking>0 ) { memoize(input, 6, ifExpression_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "ifExpression"



	// $ANTLR start "unExpression"
	// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:79:1: unExpression returns [Expression result] : ( '+' x= unExpression | '-' x= unExpression | '!' x= unExpression |x= primary );
	public final Expression unExpression() throws RecognitionException {
		Expression result = null;

		int unExpression_StartIndex = input.index();

		Expression x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:80:5: ( '+' x= unExpression | '-' x= unExpression | '!' x= unExpression |x= primary )
			int alt4=4;
			switch ( input.LA(1) ) {
			case 24:
				{
				alt4=1;
				}
				break;
			case 25:
				{
				alt4=2;
				}
				break;
			case 20:
				{
				alt4=3;
				}
				break;
			case Bool:
			case IF:
			case IF_STATEMENT_PREFIX:
			case Ident:
			case Int:
			case Money:
			case String:
				{
				alt4=4;
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
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:80:8: '+' x= unExpression
					{
					match(input,24,FOLLOW_24_in_unExpression336); if (state.failed) return result;
					pushFollow(FOLLOW_unExpression_in_unExpression340);
					x=unExpression();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Pos(x); }
					}
					break;
				case 2 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:81:8: '-' x= unExpression
					{
					match(input,25,FOLLOW_25_in_unExpression351); if (state.failed) return result;
					pushFollow(FOLLOW_unExpression_in_unExpression355);
					x=unExpression();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Neg(x); }
					}
					break;
				case 3 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:82:8: '!' x= unExpression
					{
					match(input,20,FOLLOW_20_in_unExpression366); if (state.failed) return result;
					pushFollow(FOLLOW_unExpression_in_unExpression370);
					x=unExpression();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Not(x); }
					}
					break;
				case 4 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:83:8: x= primary
					{
					pushFollow(FOLLOW_primary_in_unExpression383);
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
			if ( state.backtracking>0 ) { memoize(input, 7, unExpression_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "unExpression"



	// $ANTLR start "mulExpression"
	// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:86:1: mulExpression returns [Expression result] : lhs= unExpression (op= ( '*' | '/' ) rhs= unExpression )* ;
	public final Expression mulExpression() throws RecognitionException {
		Expression result = null;

		int mulExpression_StartIndex = input.index();

		Token op=null;
		Expression lhs =null;
		Expression rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:87:5: (lhs= unExpression (op= ( '*' | '/' ) rhs= unExpression )* )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:87:9: lhs= unExpression (op= ( '*' | '/' ) rhs= unExpression )*
			{
			pushFollow(FOLLOW_unExpression_in_mulExpression421);
			lhs=unExpression();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:87:51: (op= ( '*' | '/' ) rhs= unExpression )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==23||LA5_0==26) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:87:53: op= ( '*' | '/' ) rhs= unExpression
					{
					op=input.LT(1);
					if ( input.LA(1)==23||input.LA(1)==26 ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_unExpression_in_mulExpression441);
					rhs=unExpression();
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
			if ( state.backtracking>0 ) { memoize(input, 8, mulExpression_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "mulExpression"



	// $ANTLR start "addExpression"
	// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:101:1: addExpression returns [Expression result] : lhs= mulExpression (op= ( '+' | '-' ) rhs= mulExpression )* ;
	public final Expression addExpression() throws RecognitionException {
		Expression result = null;

		int addExpression_StartIndex = input.index();

		Token op=null;
		Expression lhs =null;
		Expression rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:102:5: (lhs= mulExpression (op= ( '+' | '-' ) rhs= mulExpression )* )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:102:9: lhs= mulExpression (op= ( '+' | '-' ) rhs= mulExpression )*
			{
			pushFollow(FOLLOW_mulExpression_in_addExpression484);
			lhs=mulExpression();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:102:52: (op= ( '+' | '-' ) rhs= mulExpression )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( ((LA6_0 >= 24 && LA6_0 <= 25)) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:102:54: op= ( '+' | '-' ) rhs= mulExpression
					{
					op=input.LT(1);
					if ( (input.LA(1) >= 24 && input.LA(1) <= 25) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_mulExpression_in_addExpression502);
					rhs=mulExpression();
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
			if ( state.backtracking>0 ) { memoize(input, 9, addExpression_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "addExpression"



	// $ANTLR start "relExpression"
	// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:113:1: relExpression returns [Expression result] : lhs= addExpression (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpression )* ;
	public final Expression relExpression() throws RecognitionException {
		Expression result = null;

		int relExpression_StartIndex = input.index();

		Token op=null;
		Expression lhs =null;
		Expression rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:114:5: (lhs= addExpression (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpression )* )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:114:9: lhs= addExpression (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpression )*
			{
			pushFollow(FOLLOW_addExpression_in_relExpression537);
			lhs=addExpression();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:114:52: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpression )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==21||(LA7_0 >= 28 && LA7_0 <= 32)) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:114:54: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpression
					{
					op=input.LT(1);
					if ( input.LA(1)==21||(input.LA(1) >= 28 && input.LA(1) <= 32) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_addExpression_in_relExpression561);
					rhs=addExpression();
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
			if ( state.backtracking>0 ) { memoize(input, 10, relExpression_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "relExpression"



	// $ANTLR start "andExpression"
	// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:137:1: andExpression returns [Expression result] : lhs= relExpression ( '&&' rhs= relExpression )* ;
	public final Expression andExpression() throws RecognitionException {
		Expression result = null;

		int andExpression_StartIndex = input.index();

		Expression lhs =null;
		Expression rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:138:5: (lhs= relExpression ( '&&' rhs= relExpression )* )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:138:9: lhs= relExpression ( '&&' rhs= relExpression )*
			{
			pushFollow(FOLLOW_relExpression_in_andExpression599);
			lhs=relExpression();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:138:52: ( '&&' rhs= relExpression )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==22) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:138:54: '&&' rhs= relExpression
					{
					match(input,22,FOLLOW_22_in_andExpression605); if (state.failed) return result;
					pushFollow(FOLLOW_relExpression_in_andExpression609);
					rhs=relExpression();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new And(result, rhs); }
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
			if ( state.backtracking>0 ) { memoize(input, 11, andExpression_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "andExpression"



	// $ANTLR start "orExpression"
	// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:142:1: orExpression returns [Expression result] : lhs= andExpression ( '||' rhs= andExpression )* ;
	public final Expression orExpression() throws RecognitionException {
		Expression result = null;

		int orExpression_StartIndex = input.index();

		Expression lhs =null;
		Expression rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }

			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:143:5: (lhs= andExpression ( '||' rhs= andExpression )* )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:143:9: lhs= andExpression ( '||' rhs= andExpression )*
			{
			pushFollow(FOLLOW_andExpression_in_orExpression644);
			lhs=andExpression();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = lhs; }
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:143:54: ( '||' rhs= andExpression )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==33) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:143:56: '||' rhs= andExpression
					{
					match(input,33,FOLLOW_33_in_orExpression650); if (state.failed) return result;
					pushFollow(FOLLOW_andExpression_in_orExpression654);
					rhs=andExpression();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Or(result, rhs); }
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
			if ( state.backtracking>0 ) { memoize(input, 12, orExpression_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "orExpression"

	// $ANTLR start synpred8_QL
	public final void synpred8_QL_fragment() throws RecognitionException {
		Expression statement =null;
		Expression successStatements =null;
		Expression elseStatements =null;

		// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:69:7: ( IF IF_STATEMENT_PREFIX statement= orExpression IF_STATEMENT_SUFFIX BLOCK_START successStatements= orExpression BLOCK_END ELSE BLOCK_START elseStatements= orExpression BLOCK_END )
		// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:69:7: IF IF_STATEMENT_PREFIX statement= orExpression IF_STATEMENT_SUFFIX BLOCK_START successStatements= orExpression BLOCK_END ELSE BLOCK_START elseStatements= orExpression BLOCK_END
		{
		match(input,IF,FOLLOW_IF_in_synpred8_QL246); if (state.failed) return;
		match(input,IF_STATEMENT_PREFIX,FOLLOW_IF_STATEMENT_PREFIX_in_synpred8_QL248); if (state.failed) return;
		pushFollow(FOLLOW_orExpression_in_synpred8_QL252);
		statement=orExpression();
		state._fsp--;
		if (state.failed) return;
		match(input,IF_STATEMENT_SUFFIX,FOLLOW_IF_STATEMENT_SUFFIX_in_synpred8_QL254); if (state.failed) return;
		match(input,BLOCK_START,FOLLOW_BLOCK_START_in_synpred8_QL256); if (state.failed) return;
		pushFollow(FOLLOW_orExpression_in_synpred8_QL260);
		successStatements=orExpression();
		state._fsp--;
		if (state.failed) return;
		match(input,BLOCK_END,FOLLOW_BLOCK_END_in_synpred8_QL262); if (state.failed) return;
		match(input,ELSE,FOLLOW_ELSE_in_synpred8_QL264); if (state.failed) return;
		match(input,BLOCK_START,FOLLOW_BLOCK_START_in_synpred8_QL266); if (state.failed) return;
		pushFollow(FOLLOW_orExpression_in_synpred8_QL270);
		elseStatements=orExpression();
		state._fsp--;
		if (state.failed) return;
		match(input,BLOCK_END,FOLLOW_BLOCK_END_in_synpred8_QL272); if (state.failed) return;
		}

	}
	// $ANTLR end synpred8_QL

	// Delegated rules

	public final boolean synpred8_QL() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred8_QL_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}



	public static final BitSet FOLLOW_FORM_in_formExpression66 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_Ident_in_formExpression68 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_BLOCK_START_in_formExpression70 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_questionArray_in_formExpression74 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_BLOCK_END_in_formExpression76 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_questionExpression_in_questionArray106 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_Ident_in_questionExpression126 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_27_in_questionExpression128 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_String_in_questionExpression132 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_dataTypeExpression_in_questionExpression136 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Type_in_dataTypeExpression153 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Int_in_primary170 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Money_in_primary180 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Bool_in_primary188 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_primary196 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_String_in_primary204 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_STATEMENT_PREFIX_in_primary212 = new BitSet(new long[]{0x000000000313D840L});
	public static final BitSet FOLLOW_orExpression_in_primary216 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_IF_STATEMENT_SUFFIX_in_primary218 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifExpression_in_primary225 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_ifExpression246 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_IF_STATEMENT_PREFIX_in_ifExpression248 = new BitSet(new long[]{0x000000000313D840L});
	public static final BitSet FOLLOW_orExpression_in_ifExpression252 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_IF_STATEMENT_SUFFIX_in_ifExpression254 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_BLOCK_START_in_ifExpression256 = new BitSet(new long[]{0x000000000313D840L});
	public static final BitSet FOLLOW_orExpression_in_ifExpression260 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_BLOCK_END_in_ifExpression262 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_ELSE_in_ifExpression264 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_BLOCK_START_in_ifExpression266 = new BitSet(new long[]{0x000000000313D840L});
	public static final BitSet FOLLOW_orExpression_in_ifExpression270 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_BLOCK_END_in_ifExpression272 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_ifExpression286 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_IF_STATEMENT_PREFIX_in_ifExpression288 = new BitSet(new long[]{0x000000000313D840L});
	public static final BitSet FOLLOW_orExpression_in_ifExpression292 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_IF_STATEMENT_SUFFIX_in_ifExpression294 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_BLOCK_START_in_ifExpression296 = new BitSet(new long[]{0x000000000313D840L});
	public static final BitSet FOLLOW_orExpression_in_ifExpression300 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_BLOCK_END_in_ifExpression302 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_24_in_unExpression336 = new BitSet(new long[]{0x000000000313D840L});
	public static final BitSet FOLLOW_unExpression_in_unExpression340 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_25_in_unExpression351 = new BitSet(new long[]{0x000000000313D840L});
	public static final BitSet FOLLOW_unExpression_in_unExpression355 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_20_in_unExpression366 = new BitSet(new long[]{0x000000000313D840L});
	public static final BitSet FOLLOW_unExpression_in_unExpression370 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpression383 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpression_in_mulExpression421 = new BitSet(new long[]{0x0000000004800002L});
	public static final BitSet FOLLOW_set_in_mulExpression429 = new BitSet(new long[]{0x000000000313D840L});
	public static final BitSet FOLLOW_unExpression_in_mulExpression441 = new BitSet(new long[]{0x0000000004800002L});
	public static final BitSet FOLLOW_mulExpression_in_addExpression484 = new BitSet(new long[]{0x0000000003000002L});
	public static final BitSet FOLLOW_set_in_addExpression492 = new BitSet(new long[]{0x000000000313D840L});
	public static final BitSet FOLLOW_mulExpression_in_addExpression502 = new BitSet(new long[]{0x0000000003000002L});
	public static final BitSet FOLLOW_addExpression_in_relExpression537 = new BitSet(new long[]{0x00000001F0200002L});
	public static final BitSet FOLLOW_set_in_relExpression545 = new BitSet(new long[]{0x000000000313D840L});
	public static final BitSet FOLLOW_addExpression_in_relExpression561 = new BitSet(new long[]{0x00000001F0200002L});
	public static final BitSet FOLLOW_relExpression_in_andExpression599 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_22_in_andExpression605 = new BitSet(new long[]{0x000000000313D840L});
	public static final BitSet FOLLOW_relExpression_in_andExpression609 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_andExpression_in_orExpression644 = new BitSet(new long[]{0x0000000200000002L});
	public static final BitSet FOLLOW_33_in_orExpression650 = new BitSet(new long[]{0x000000000313D840L});
	public static final BitSet FOLLOW_andExpression_in_orExpression654 = new BitSet(new long[]{0x0000000200000002L});
	public static final BitSet FOLLOW_IF_in_synpred8_QL246 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_IF_STATEMENT_PREFIX_in_synpred8_QL248 = new BitSet(new long[]{0x000000000313D840L});
	public static final BitSet FOLLOW_orExpression_in_synpred8_QL252 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_IF_STATEMENT_SUFFIX_in_synpred8_QL254 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_BLOCK_START_in_synpred8_QL256 = new BitSet(new long[]{0x000000000313D840L});
	public static final BitSet FOLLOW_orExpression_in_synpred8_QL260 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_BLOCK_END_in_synpred8_QL262 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_ELSE_in_synpred8_QL264 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_BLOCK_START_in_synpred8_QL266 = new BitSet(new long[]{0x000000000313D840L});
	public static final BitSet FOLLOW_orExpression_in_synpred8_QL270 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_BLOCK_END_in_synpred8_QL272 = new BitSet(new long[]{0x0000000000000002L});
}
