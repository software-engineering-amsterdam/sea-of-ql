// $ANTLR 3.5 C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g 2013-02-16 12:46:21

package org.uva.sea.ql.parsers.antlr;
import org.uva.sea.ql.core.dom.*; 
import org.uva.sea.ql.core.dom.operators.*;
import org.uva.sea.ql.core.dom.operators.arithmetic.*;
import org.uva.sea.ql.core.dom.operators.conditional.*;
import org.uva.sea.ql.core.dom.operators.relational.*;
import org.uva.sea.ql.core.dom.operators.unary.*;
import org.uva.sea.ql.core.dom.statements.*;
import org.uva.sea.ql.core.dom.types.declarations.*;
import org.uva.sea.ql.core.dom.types.primitive.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings("all")
public class QLParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "BOOL", "COLON", "COMMENT", "FORM", 
		"IDENT", "INT", "STRING", "WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", 
		"'+'", "'-'", "'/'", "'<'", "'<='", "'=='", "'>'", "'>='", "'boolean'", 
		"'integer'", "'string'", "'{'", "'||'", "'}'"
	};
	public static final int EOF=-1;
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
	public static final int T__30=30;
	public static final int T__31=31;
	public static final int BOOL=4;
	public static final int COLON=5;
	public static final int COMMENT=6;
	public static final int FORM=7;
	public static final int IDENT=8;
	public static final int INT=9;
	public static final int STRING=10;
	public static final int WS=11;

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
		this.state.ruleMemo = new HashMap[33+1];


	}

	@Override public String[] getTokenNames() { return QLParser.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g"; }



	// $ANTLR start "form"
	// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:25:1: form returns [Form result] : FORM IDENT '{' elements= formElementList '}' ;
	public final Form form() throws RecognitionException {
		Form result = null;

		int form_StartIndex = input.index();

		List<FormElement> elements =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:26:3: ( FORM IDENT '{' elements= formElementList '}' )
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:26:5: FORM IDENT '{' elements= formElementList '}'
			{
			match(input,FORM,FOLLOW_FORM_in_form49); if (state.failed) return result;
			match(input,IDENT,FOLLOW_IDENT_in_form51); if (state.failed) return result;
			match(input,29,FOLLOW_29_in_form53); if (state.failed) return result;
			pushFollow(FOLLOW_formElementList_in_form57);
			elements=formElementList();
			state._fsp--;
			if (state.failed) return result;
			match(input,31,FOLLOW_31_in_form59); if (state.failed) return result;
			if ( state.backtracking==0 ) { result = new Form(elements); }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 1, form_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "form"



	// $ANTLR start "formElementList"
	// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:29:1: formElementList returns [List<FormElement> result] : (element= formElement )* ;
	public final List<FormElement> formElementList() throws RecognitionException {
		List<FormElement> result = null;

		int formElementList_StartIndex = input.index();

		FormElement element =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:30:3: ( (element= formElement )* )
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:30:5: (element= formElement )*
			{
			if ( state.backtracking==0 ) {result = new ArrayList<FormElement>();}
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:30:47: (element= formElement )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==IDENT) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:30:48: element= formElement
					{
					pushFollow(FOLLOW_formElement_in_formElementList83);
					element=formElement();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {result.add(element);}
					}
					break;

				default :
					break loop1;
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
			if ( state.backtracking>0 ) { memoize(input, 2, formElementList_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "formElementList"



	// $ANTLR start "formElement"
	// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:33:1: formElement returns [FormElement result] : IDENT COLON STRING type ;
	public final FormElement formElement() throws RecognitionException {
		FormElement result = null;

		int formElement_StartIndex = input.index();

		Token IDENT1=null;
		Token STRING2=null;
		TypeDeclaration type3 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:34:3: ( IDENT COLON STRING type )
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:34:5: IDENT COLON STRING type
			{
			IDENT1=(Token)match(input,IDENT,FOLLOW_IDENT_in_formElement106); if (state.failed) return result;
			match(input,COLON,FOLLOW_COLON_in_formElement108); if (state.failed) return result;
			STRING2=(Token)match(input,STRING,FOLLOW_STRING_in_formElement110); if (state.failed) return result;
			pushFollow(FOLLOW_type_in_formElement112);
			type3=type();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = new FormElement(new Identifier((IDENT1!=null?IDENT1.getText():null)), new StringLiteral((STRING2!=null?STRING2.getText():null)), type3);}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 3, formElement_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "formElement"



	// $ANTLR start "type"
	// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:37:1: type returns [TypeDefinition result] : (x= 'boolean' |x= 'integer' |x= 'string' );
	public final TypeDeclaration type() throws RecognitionException {
		TypeDeclaration result = null;

		int type_StartIndex = input.index();

		Token x=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:38:3: (x= 'boolean' |x= 'integer' |x= 'string' )
			int alt2=3;
			switch ( input.LA(1) ) {
			case 26:
				{
				alt2=1;
				}
				break;
			case 27:
				{
				alt2=2;
				}
				break;
			case 28:
				{
				alt2=3;
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
					// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:38:5: x= 'boolean'
					{
					x=(Token)match(input,26,FOLLOW_26_in_type135); if (state.failed) return result;
					if ( state.backtracking==0 ) {result = new BooleanDeclaration(); }
					}
					break;
				case 2 :
					// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:39:5: x= 'integer'
					{
					x=(Token)match(input,27,FOLLOW_27_in_type145); if (state.failed) return result;
					if ( state.backtracking==0 ) {result =new IntDeclaration();}
					}
					break;
				case 3 :
					// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:40:5: x= 'string'
					{
					x=(Token)match(input,28,FOLLOW_28_in_type155); if (state.failed) return result;
					if ( state.backtracking==0 ) {result =new StringDeclaration();}
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
	// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:43:1: primary returns [Expression result] : ( INT | BOOL | STRING | IDENT | '(' x= orExpr ')' );
	public final Expression primary() throws RecognitionException {
		Expression result = null;

		int primary_StartIndex = input.index();

		Token INT4=null;
		Token BOOL5=null;
		Token STRING6=null;
		Token IDENT7=null;
		Expression x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:44:3: ( INT | BOOL | STRING | IDENT | '(' x= orExpr ')' )
			int alt3=5;
			switch ( input.LA(1) ) {
			case INT:
				{
				alt3=1;
				}
				break;
			case BOOL:
				{
				alt3=2;
				}
				break;
			case STRING:
				{
				alt3=3;
				}
				break;
			case IDENT:
				{
				alt3=4;
				}
				break;
			case 15:
				{
				alt3=5;
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
					// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:44:5: INT
					{
					INT4=(Token)match(input,INT,FOLLOW_INT_in_primary176); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new IntLiteral((INT4!=null?INT4.getText():null)); }
					}
					break;
				case 2 :
					// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:45:5: BOOL
					{
					BOOL5=(Token)match(input,BOOL,FOLLOW_BOOL_in_primary186); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new BooleanLiteral((BOOL5!=null?BOOL5.getText():null)); }
					}
					break;
				case 3 :
					// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:46:5: STRING
					{
					STRING6=(Token)match(input,STRING,FOLLOW_STRING_in_primary196); if (state.failed) return result;
					if ( state.backtracking==0 ) {result = new StringLiteral((STRING6!=null?STRING6.getText():null));}
					}
					break;
				case 4 :
					// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:47:5: IDENT
					{
					IDENT7=(Token)match(input,IDENT,FOLLOW_IDENT_in_primary204); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Identifier((IDENT7!=null?IDENT7.getText():null)); }
					}
					break;
				case 5 :
					// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:48:5: '(' x= orExpr ')'
					{
					match(input,15,FOLLOW_15_in_primary212); if (state.failed) return result;
					pushFollow(FOLLOW_orExpr_in_primary216);
					x=orExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,16,FOLLOW_16_in_primary218); if (state.failed) return result;
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
	// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:51:1: unExpr returns [Expression result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
	public final Expression unExpr() throws RecognitionException {
		Expression result = null;

		int unExpr_StartIndex = input.index();

		Expression x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:52:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
			int alt4=4;
			switch ( input.LA(1) ) {
			case 18:
				{
				alt4=1;
				}
				break;
			case 19:
				{
				alt4=2;
				}
				break;
			case 12:
				{
				alt4=3;
				}
				break;
			case BOOL:
			case IDENT:
			case INT:
			case STRING:
			case 15:
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
					// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:52:8: '+' x= unExpr
					{
					match(input,18,FOLLOW_18_in_unExpr243); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr247);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Pos(x); }
					}
					break;
				case 2 :
					// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:53:8: '-' x= unExpr
					{
					match(input,19,FOLLOW_19_in_unExpr258); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr262);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Neg(x); }
					}
					break;
				case 3 :
					// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:54:8: '!' x= unExpr
					{
					match(input,12,FOLLOW_12_in_unExpr273); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr277);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Not(x); }
					}
					break;
				case 4 :
					// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:55:8: x= primary
					{
					pushFollow(FOLLOW_primary_in_unExpr291);
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
	// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:58:1: mulExpr returns [Expression result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
	public final Expression mulExpr() throws RecognitionException {
		Expression result = null;

		int mulExpr_StartIndex = input.index();

		Token op=null;
		Expression lhs =null;
		Expression rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:59:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:59:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
			{
			pushFollow(FOLLOW_unExpr_in_mulExpr329);
			lhs=unExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:59:45: (op= ( '*' | '/' ) rhs= unExpr )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==17||LA5_0==20) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:59:47: op= ( '*' | '/' ) rhs= unExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==17||input.LA(1)==20 ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_unExpr_in_mulExpr349);
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
			if ( state.backtracking>0 ) { memoize(input, 7, mulExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "mulExpr"



	// $ANTLR start "addExpr"
	// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:71:1: addExpr returns [Expression result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
	public final Expression addExpr() throws RecognitionException {
		Expression result = null;

		int addExpr_StartIndex = input.index();

		Token op=null;
		Expression lhs =null;
		Expression rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:72:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:72:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
			{
			pushFollow(FOLLOW_mulExpr_in_addExpr391);
			lhs=mulExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:72:46: (op= ( '+' | '-' ) rhs= mulExpr )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( ((LA6_0 >= 18 && LA6_0 <= 19)) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:72:48: op= ( '+' | '-' ) rhs= mulExpr
					{
					op=input.LT(1);
					if ( (input.LA(1) >= 18 && input.LA(1) <= 19) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_mulExpr_in_addExpr409);
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
			if ( state.backtracking>0 ) { memoize(input, 8, addExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "addExpr"



	// $ANTLR start "relExpr"
	// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:83:1: relExpr returns [Expression result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
	public final Expression relExpr() throws RecognitionException {
		Expression result = null;

		int relExpr_StartIndex = input.index();

		Token op=null;
		Expression lhs =null;
		Expression rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:84:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:84:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			{
			pushFollow(FOLLOW_addExpr_in_relExpr444);
			lhs=addExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:84:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==13||(LA7_0 >= 21 && LA7_0 <= 25)) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:84:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==13||(input.LA(1) >= 21 && input.LA(1) <= 25) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_addExpr_in_relExpr468);
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
			if ( state.backtracking>0 ) { memoize(input, 9, relExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "relExpr"



	// $ANTLR start "andExpr"
	// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:107:1: andExpr returns [Expression result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
	public final Expression andExpr() throws RecognitionException {
		Expression result = null;

		int andExpr_StartIndex = input.index();

		Expression lhs =null;
		Expression rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:108:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:108:9: lhs= relExpr ( '&&' rhs= relExpr )*
			{
			pushFollow(FOLLOW_relExpr_in_andExpr506);
			lhs=relExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:108:46: ( '&&' rhs= relExpr )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==14) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:108:48: '&&' rhs= relExpr
					{
					match(input,14,FOLLOW_14_in_andExpr512); if (state.failed) return result;
					pushFollow(FOLLOW_relExpr_in_andExpr516);
					rhs=relExpr();
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
			if ( state.backtracking>0 ) { memoize(input, 10, andExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "andExpr"



	// $ANTLR start "orExpr"
	// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:112:1: orExpr returns [Expression result] : lhs= andExpr ( '||' rhs= andExpr )* ;
	public final Expression orExpr() throws RecognitionException {
		Expression result = null;

		int orExpr_StartIndex = input.index();

		Expression lhs =null;
		Expression rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:113:5: (lhs= andExpr ( '||' rhs= andExpr )* )
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:113:9: lhs= andExpr ( '||' rhs= andExpr )*
			{
			pushFollow(FOLLOW_andExpr_in_orExpr551);
			lhs=andExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = lhs; }
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:113:48: ( '||' rhs= andExpr )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==30) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:113:50: '||' rhs= andExpr
					{
					match(input,30,FOLLOW_30_in_orExpr557); if (state.failed) return result;
					pushFollow(FOLLOW_andExpr_in_orExpr561);
					rhs=andExpr();
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
			if ( state.backtracking>0 ) { memoize(input, 11, orExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "orExpr"

	// Delegated rules



	public static final BitSet FOLLOW_FORM_in_form49 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_IDENT_in_form51 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_29_in_form53 = new BitSet(new long[]{0x0000000080000100L});
	public static final BitSet FOLLOW_formElementList_in_form57 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_form59 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_formElement_in_formElementList83 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_IDENT_in_formElement106 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_COLON_in_formElement108 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_STRING_in_formElement110 = new BitSet(new long[]{0x000000001C000000L});
	public static final BitSet FOLLOW_type_in_formElement112 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_26_in_type135 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_27_in_type145 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_28_in_type155 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_primary176 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BOOL_in_primary186 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_in_primary196 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_primary204 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_15_in_primary212 = new BitSet(new long[]{0x00000000000C9710L});
	public static final BitSet FOLLOW_orExpr_in_primary216 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_primary218 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_18_in_unExpr243 = new BitSet(new long[]{0x00000000000C9710L});
	public static final BitSet FOLLOW_unExpr_in_unExpr247 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_19_in_unExpr258 = new BitSet(new long[]{0x00000000000C9710L});
	public static final BitSet FOLLOW_unExpr_in_unExpr262 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_unExpr273 = new BitSet(new long[]{0x00000000000C9710L});
	public static final BitSet FOLLOW_unExpr_in_unExpr277 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpr291 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr329 = new BitSet(new long[]{0x0000000000120002L});
	public static final BitSet FOLLOW_set_in_mulExpr337 = new BitSet(new long[]{0x00000000000C9710L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr349 = new BitSet(new long[]{0x0000000000120002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr391 = new BitSet(new long[]{0x00000000000C0002L});
	public static final BitSet FOLLOW_set_in_addExpr399 = new BitSet(new long[]{0x00000000000C9710L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr409 = new BitSet(new long[]{0x00000000000C0002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr444 = new BitSet(new long[]{0x0000000003E02002L});
	public static final BitSet FOLLOW_set_in_relExpr452 = new BitSet(new long[]{0x00000000000C9710L});
	public static final BitSet FOLLOW_addExpr_in_relExpr468 = new BitSet(new long[]{0x0000000003E02002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr506 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_14_in_andExpr512 = new BitSet(new long[]{0x00000000000C9710L});
	public static final BitSet FOLLOW_relExpr_in_andExpr516 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr551 = new BitSet(new long[]{0x0000000040000002L});
	public static final BitSet FOLLOW_30_in_orExpr557 = new BitSet(new long[]{0x00000000000C9710L});
	public static final BitSet FOLLOW_andExpr_in_orExpr561 = new BitSet(new long[]{0x0000000040000002L});
}
