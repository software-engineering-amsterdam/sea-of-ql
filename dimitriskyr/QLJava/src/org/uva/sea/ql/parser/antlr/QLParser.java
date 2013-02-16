// $ANTLR 3.5 C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g 2013-02-15 20:59:28

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expressions.*;
import org.uva.sea.ql.ast.types.*;
import org.uva.sea.ql.ast.statements.*;
import org.uva.sea.ql.ast.values.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class QLParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "Bool", "Comments", "Ident", "Int", 
		"Money", "String_literal", "WS", "'!'", "'!='", "'&&'", "'('", "')'", 
		"'*'", "'+'", "'-'", "'/'", "':'", "'<'", "'<='", "'=='", "'>'", "'>='", 
		"'boolean'", "'else'", "'form'", "'if'", "'integer'", "'money'", "'string'", 
		"'{'", "'||'", "'}'"
	};
	public static final int EOF=-1;
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
	public static final int T__30=30;
	public static final int T__31=31;
	public static final int T__32=32;
	public static final int T__33=33;
	public static final int T__34=34;
	public static final int T__35=35;
	public static final int Bool=4;
	public static final int Comments=5;
	public static final int Ident=6;
	public static final int Int=7;
	public static final int Money=8;
	public static final int String_literal=9;
	public static final int WS=10;

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



	// $ANTLR start "form"
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:23:1: form returns [Form result] : 'form' ident '{' block '}' ;
	public final Form form() throws RecognitionException {
		Form result = null;


		ParserRuleReturnScope ident1 =null;
		Block block2 =null;

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:24:3: ( 'form' ident '{' block '}' )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:24:6: 'form' ident '{' block '}'
			{
			match(input,28,FOLLOW_28_in_form50); 
			pushFollow(FOLLOW_ident_in_form52);
			ident1=ident();
			state._fsp--;

			match(input,33,FOLLOW_33_in_form54); 
			pushFollow(FOLLOW_block_in_form56);
			block2=block();
			state._fsp--;

			match(input,35,FOLLOW_35_in_form58); 
			result = new Form (new Ident((ident1!=null?input.toString(ident1.start,ident1.stop):null)), block2);
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



	// $ANTLR start "block"
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:30:1: block returns [Block result] : ( body )* ;
	public final Block block() throws RecognitionException {
		Block result = null;


		 Block block = new Block(); 
		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:32:3: ( ( body )* )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:32:5: ( body )*
			{
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:32:5: ( body )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==Ident||LA1_0==29) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:32:6: body
					{
					pushFollow(FOLLOW_body_in_block86);
					body();
					state._fsp--;

					block.addBody(result);
					}
					break;

				default :
					break loop1;
				}
			}

			result =block;
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
	// $ANTLR end "block"



	// $ANTLR start "body"
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:36:1: body returns [Statement result] : ( ifthen | simplequestion | comquestion );
	public final Statement body() throws RecognitionException {
		Statement result = null;


		Statement ifthen3 =null;
		Statement simplequestion4 =null;
		Statement comquestion5 =null;

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:37:3: ( ifthen | simplequestion | comquestion )
			int alt2=3;
			alt2 = dfa2.predict(input);
			switch (alt2) {
				case 1 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:37:5: ifthen
					{
					pushFollow(FOLLOW_ifthen_in_body112);
					ifthen3=ifthen();
					state._fsp--;

					 result = ifthen3; 
					}
					break;
				case 2 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:38:5: simplequestion
					{
					pushFollow(FOLLOW_simplequestion_in_body121);
					simplequestion4=simplequestion();
					state._fsp--;

					 result = simplequestion4; 
					}
					break;
				case 3 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:39:5: comquestion
					{
					pushFollow(FOLLOW_comquestion_in_body129);
					comquestion5=comquestion();
					state._fsp--;

					result = comquestion5; 
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
	// $ANTLR end "body"



	// $ANTLR start "ifthen"
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:46:1: ifthen returns [Statement result] : 'if' expression '{' b= block '}' ;
	public final Statement ifthen() throws RecognitionException {
		Statement result = null;


		Block b =null;
		Expr expression6 =null;

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:47:3: ( 'if' expression '{' b= block '}' )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:47:5: 'if' expression '{' b= block '}'
			{
			match(input,29,FOLLOW_29_in_ifthen157); 
			pushFollow(FOLLOW_expression_in_ifthen159);
			expression6=expression();
			state._fsp--;

			match(input,33,FOLLOW_33_in_ifthen161); 
			pushFollow(FOLLOW_block_in_ifthen165);
			b=block();
			state._fsp--;

			match(input,35,FOLLOW_35_in_ifthen167); 
			result = new IfThen(expression6 , b);
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



	// $ANTLR start "ifthenelse"
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:54:1: ifthenelse returns [Statement result] : 'if' expression '{' b1= block '}' 'else' '{' b2= block '}' ;
	public final Statement ifthenelse() throws RecognitionException {
		Statement result = null;


		Block b1 =null;
		Block b2 =null;
		Expr expression7 =null;

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:55:3: ( 'if' expression '{' b1= block '}' 'else' '{' b2= block '}' )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:55:5: 'if' expression '{' b1= block '}' 'else' '{' b2= block '}'
			{
			match(input,29,FOLLOW_29_in_ifthenelse267); 
			pushFollow(FOLLOW_expression_in_ifthenelse269);
			expression7=expression();
			state._fsp--;

			match(input,33,FOLLOW_33_in_ifthenelse271); 
			pushFollow(FOLLOW_block_in_ifthenelse275);
			b1=block();
			state._fsp--;

			match(input,35,FOLLOW_35_in_ifthenelse277); 
			match(input,27,FOLLOW_27_in_ifthenelse279); 
			match(input,33,FOLLOW_33_in_ifthenelse281); 
			pushFollow(FOLLOW_block_in_ifthenelse285);
			b2=block();
			state._fsp--;

			match(input,35,FOLLOW_35_in_ifthenelse287); 
			result = new IfThenElse(expression7 , b1, b2);
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
	// $ANTLR end "ifthenelse"



	// $ANTLR start "simplequestion"
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:62:1: simplequestion returns [Statement result] : ident ':' string type ;
	public final Statement simplequestion() throws RecognitionException {
		Statement result = null;


		ParserRuleReturnScope ident8 =null;
		ParserRuleReturnScope string9 =null;
		Type type10 =null;

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:63:3: ( ident ':' string type )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:63:5: ident ':' string type
			{
			pushFollow(FOLLOW_ident_in_simplequestion309);
			ident8=ident();
			state._fsp--;

			match(input,20,FOLLOW_20_in_simplequestion311); 
			pushFollow(FOLLOW_string_in_simplequestion313);
			string9=string();
			state._fsp--;

			pushFollow(FOLLOW_type_in_simplequestion315);
			type10=type();
			state._fsp--;

			result = new SimpleQuestion(new Ident((ident8!=null?input.toString(ident8.start,ident8.stop):null)) , new String_lit((string9!=null?input.toString(string9.start,string9.stop):null)) , type10);
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
	// $ANTLR end "simplequestion"



	// $ANTLR start "comquestion"
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:66:1: comquestion returns [Statement result] : ident ':' string type expression ;
	public final Statement comquestion() throws RecognitionException {
		Statement result = null;


		ParserRuleReturnScope ident11 =null;
		ParserRuleReturnScope string12 =null;
		Type type13 =null;
		Expr expression14 =null;

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:67:3: ( ident ':' string type expression )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:67:5: ident ':' string type expression
			{
			pushFollow(FOLLOW_ident_in_comquestion335);
			ident11=ident();
			state._fsp--;

			match(input,20,FOLLOW_20_in_comquestion337); 
			pushFollow(FOLLOW_string_in_comquestion339);
			string12=string();
			state._fsp--;

			pushFollow(FOLLOW_type_in_comquestion341);
			type13=type();
			state._fsp--;

			pushFollow(FOLLOW_expression_in_comquestion343);
			expression14=expression();
			state._fsp--;

			result = new ComQuestion(new Ident((ident11!=null?input.toString(ident11.start,ident11.stop):null)) , new String_lit((string12!=null?input.toString(string12.start,string12.stop):null)) , type13 , expression14);
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
	// $ANTLR end "comquestion"



	// $ANTLR start "expression"
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:72:1: expression returns [Expr result] : ( integer | bool | string | money | ident | '(' x= orExpr ')' );
	public final Expr expression() throws RecognitionException {
		Expr result = null;


		Expr x =null;
		ParserRuleReturnScope integer15 =null;
		ParserRuleReturnScope bool16 =null;
		ParserRuleReturnScope string17 =null;
		ParserRuleReturnScope money18 =null;
		ParserRuleReturnScope ident19 =null;

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:73:3: ( integer | bool | string | money | ident | '(' x= orExpr ')' )
			int alt3=6;
			switch ( input.LA(1) ) {
			case Int:
				{
				alt3=1;
				}
				break;
			case Bool:
				{
				alt3=2;
				}
				break;
			case String_literal:
				{
				alt3=3;
				}
				break;
			case Money:
				{
				alt3=4;
				}
				break;
			case Ident:
				{
				alt3=5;
				}
				break;
			case 14:
				{
				alt3=6;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}
			switch (alt3) {
				case 1 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:73:5: integer
					{
					pushFollow(FOLLOW_integer_in_expression450);
					integer15=integer();
					state._fsp--;

					result = new Int(Integer.parseInt((integer15!=null?input.toString(integer15.start,integer15.stop):null)));
					}
					break;
				case 2 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:74:5: bool
					{
					pushFollow(FOLLOW_bool_in_expression458);
					bool16=bool();
					state._fsp--;

					 result = new Bool(Boolean.parseBoolean((bool16!=null?input.toString(bool16.start,bool16.stop):null)));
					}
					break;
				case 3 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:75:5: string
					{
					pushFollow(FOLLOW_string_in_expression466);
					string17=string();
					state._fsp--;

					 result = new String_lit((string17!=null?input.toString(string17.start,string17.stop):null));
					}
					break;
				case 4 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:76:5: money
					{
					pushFollow(FOLLOW_money_in_expression474);
					money18=money();
					state._fsp--;

					result = new Money(Float.parseFloat((money18!=null?input.toString(money18.start,money18.stop):null)));
					}
					break;
				case 5 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:77:5: ident
					{
					pushFollow(FOLLOW_ident_in_expression482);
					ident19=ident();
					state._fsp--;

					result = new Ident((ident19!=null?input.toString(ident19.start,ident19.stop):null));
					}
					break;
				case 6 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:78:5: '(' x= orExpr ')'
					{
					match(input,14,FOLLOW_14_in_expression490); 
					pushFollow(FOLLOW_orExpr_in_expression494);
					x=orExpr();
					state._fsp--;

					match(input,15,FOLLOW_15_in_expression496); 
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
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:83:1: unExpr returns [Expr result] : ( '+' pos= unExpr | '-' neg= unExpr | '!' not= unExpr |x= expression );
	public final Expr unExpr() throws RecognitionException {
		Expr result = null;


		Expr pos =null;
		Expr neg =null;
		Expr not =null;
		Expr x =null;

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:84:5: ( '+' pos= unExpr | '-' neg= unExpr | '!' not= unExpr |x= expression )
			int alt4=4;
			switch ( input.LA(1) ) {
			case 17:
				{
				alt4=1;
				}
				break;
			case 18:
				{
				alt4=2;
				}
				break;
			case 11:
				{
				alt4=3;
				}
				break;
			case Bool:
			case Ident:
			case Int:
			case Money:
			case String_literal:
			case 14:
				{
				alt4=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}
			switch (alt4) {
				case 1 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:84:8: '+' pos= unExpr
					{
					match(input,17,FOLLOW_17_in_unExpr522); 
					pushFollow(FOLLOW_unExpr_in_unExpr526);
					pos=unExpr();
					state._fsp--;

					 result = new Pos(pos); 
					}
					break;
				case 2 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:85:8: '-' neg= unExpr
					{
					match(input,18,FOLLOW_18_in_unExpr537); 
					pushFollow(FOLLOW_unExpr_in_unExpr541);
					neg=unExpr();
					state._fsp--;

					 result = new Neg(neg); 
					}
					break;
				case 3 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:86:8: '!' not= unExpr
					{
					match(input,11,FOLLOW_11_in_unExpr552); 
					pushFollow(FOLLOW_unExpr_in_unExpr556);
					not=unExpr();
					state._fsp--;

					 result = new Not(not); 
					}
					break;
				case 4 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:87:8: x= expression
					{
					pushFollow(FOLLOW_expression_in_unExpr569);
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
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:91:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
	public final Expr mulExpr() throws RecognitionException {
		Expr result = null;


		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:92:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:92:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
			{
			pushFollow(FOLLOW_unExpr_in_mulExpr609);
			lhs=unExpr();
			state._fsp--;

			 result =lhs; 
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:92:45: (op= ( '*' | '/' ) rhs= unExpr )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==16||LA5_0==19) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:92:47: op= ( '*' | '/' ) rhs= unExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==16||input.LA(1)==19 ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_unExpr_in_mulExpr629);
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
	// $ANTLR end "mulExpr"



	// $ANTLR start "addExpr"
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:103:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
	public final Expr addExpr() throws RecognitionException {
		Expr result = null;


		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:104:4: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:104:8: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
			{
			pushFollow(FOLLOW_mulExpr_in_addExpr664);
			lhs=mulExpr();
			state._fsp--;

			 result =lhs; 
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:104:45: (op= ( '+' | '-' ) rhs= mulExpr )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( ((LA6_0 >= 17 && LA6_0 <= 18)) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:104:47: op= ( '+' | '-' ) rhs= mulExpr
					{
					op=input.LT(1);
					if ( (input.LA(1) >= 17 && input.LA(1) <= 18) ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_mulExpr_in_addExpr682);
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
	// $ANTLR end "addExpr"



	// $ANTLR start "relExpr"
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:115:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
	public final Expr relExpr() throws RecognitionException {
		Expr result = null;


		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:116:3: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:116:7: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			{
			pushFollow(FOLLOW_addExpr_in_relExpr721);
			lhs=addExpr();
			state._fsp--;

			 result =lhs; 
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:116:44: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==12||(LA7_0 >= 21 && LA7_0 <= 25)) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:116:46: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==12||(input.LA(1) >= 21 && input.LA(1) <= 25) ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_addExpr_in_relExpr745);
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
	// $ANTLR end "relExpr"



	// $ANTLR start "andExpr"
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:139:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
	public final Expr andExpr() throws RecognitionException {
		Expr result = null;


		Expr lhs =null;
		Expr rhs =null;

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:140:3: (lhs= relExpr ( '&&' rhs= relExpr )* )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:140:5: lhs= relExpr ( '&&' rhs= relExpr )*
			{
			pushFollow(FOLLOW_relExpr_in_andExpr779);
			lhs=relExpr();
			state._fsp--;

			result = lhs;
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:140:42: ( '&&' rhs= relExpr )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==13) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:140:44: '&&' rhs= relExpr
					{
					match(input,13,FOLLOW_13_in_andExpr785); 
					pushFollow(FOLLOW_relExpr_in_andExpr789);
					rhs=relExpr();
					state._fsp--;

					result = new And (result, rhs); 
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
		}
		return result;
	}
	// $ANTLR end "andExpr"



	// $ANTLR start "orExpr"
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:143:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
	public final Expr orExpr() throws RecognitionException {
		Expr result = null;


		Expr lhs =null;
		Expr rhs =null;

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:144:3: (lhs= andExpr ( '||' rhs= andExpr )* )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:144:5: lhs= andExpr ( '||' rhs= andExpr )*
			{
			pushFollow(FOLLOW_andExpr_in_orExpr814);
			lhs=andExpr();
			state._fsp--;

			result = lhs;
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:144:43: ( '||' rhs= andExpr )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==34) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:144:45: '||' rhs= andExpr
					{
					match(input,34,FOLLOW_34_in_orExpr821); 
					pushFollow(FOLLOW_andExpr_in_orExpr825);
					rhs=andExpr();
					state._fsp--;

					result = new Or(result,rhs); 
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
		}
		return result;
	}
	// $ANTLR end "orExpr"



	// $ANTLR start "type"
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:150:1: type returns [Type result] : (whattype= ( 'integer' | 'boolean' | 'string' | 'money' ) )+ ;
	public final Type type() throws RecognitionException {
		Type result = null;


		Token whattype=null;

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:151:2: ( (whattype= ( 'integer' | 'boolean' | 'string' | 'money' ) )+ )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:151:5: (whattype= ( 'integer' | 'boolean' | 'string' | 'money' ) )+
			{
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:151:5: (whattype= ( 'integer' | 'boolean' | 'string' | 'money' ) )+
			int cnt10=0;
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==26||(LA10_0 >= 30 && LA10_0 <= 32)) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:151:7: whattype= ( 'integer' | 'boolean' | 'string' | 'money' )
					{
					whattype=input.LT(1);
					if ( input.LA(1)==26||(input.LA(1) >= 30 && input.LA(1) <= 32) ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					 
					      if ((whattype!=null?whattype.getText():null).equals("integer")) {
					        result = new IntegerType();
					      }
					      if ((whattype!=null?whattype.getText():null).equals("boolean")) {
					        result = new BooleanType();      
					      }
					      if ((whattype!=null?whattype.getText():null).equals("string")) {
					        result = new StringType();
					     }
					     if ((whattype!=null?whattype.getText():null).equals("money")) {
					        result = new MoneyType();
					     }
					    
					}
					break;

				default :
					if ( cnt10 >= 1 ) break loop10;
					EarlyExitException eee = new EarlyExitException(10, input);
					throw eee;
				}
				cnt10++;
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
	// $ANTLR end "type"


	public static class integer_return extends ParserRuleReturnScope {
	};


	// $ANTLR start "integer"
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:168:1: integer : Int ;
	public final QLParser.integer_return integer() throws RecognitionException {
		QLParser.integer_return retval = new QLParser.integer_return();
		retval.start = input.LT(1);

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:168:9: ( Int )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:168:11: Int
			{
			match(input,Int,FOLLOW_Int_in_integer886); 
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
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:169:1: string : String_literal ;
	public final QLParser.string_return string() throws RecognitionException {
		QLParser.string_return retval = new QLParser.string_return();
		retval.start = input.LT(1);

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:169:8: ( String_literal )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:169:10: String_literal
			{
			match(input,String_literal,FOLLOW_String_literal_in_string895); 
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
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:170:1: bool : Bool ;
	public final QLParser.bool_return bool() throws RecognitionException {
		QLParser.bool_return retval = new QLParser.bool_return();
		retval.start = input.LT(1);

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:170:6: ( Bool )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:170:8: Bool
			{
			match(input,Bool,FOLLOW_Bool_in_bool904); 
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
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:171:1: ident : Ident ;
	public final QLParser.ident_return ident() throws RecognitionException {
		QLParser.ident_return retval = new QLParser.ident_return();
		retval.start = input.LT(1);

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:171:7: ( Ident )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:171:9: Ident
			{
			match(input,Ident,FOLLOW_Ident_in_ident912); 
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


	public static class money_return extends ParserRuleReturnScope {
	};


	// $ANTLR start "money"
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:172:1: money : Money ;
	public final QLParser.money_return money() throws RecognitionException {
		QLParser.money_return retval = new QLParser.money_return();
		retval.start = input.LT(1);

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:172:7: ( Money )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:172:9: Money
			{
			match(input,Money,FOLLOW_Money_in_money920); 
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
	// $ANTLR end "money"

	// Delegated rules


	protected DFA2 dfa2 = new DFA2(this);
	static final String DFA2_eotS =
		"\11\uffff";
	static final String DFA2_eofS =
		"\11\uffff";
	static final String DFA2_minS =
		"\1\6\1\uffff\1\24\1\11\1\32\1\4\1\uffff\1\6\1\uffff";
	static final String DFA2_maxS =
		"\1\35\1\uffff\1\24\1\11\1\40\1\43\1\uffff\1\43\1\uffff";
	static final String DFA2_acceptS =
		"\1\uffff\1\1\4\uffff\1\2\1\uffff\1\3";
	static final String DFA2_specialS =
		"\11\uffff}>";
	static final String[] DFA2_transitionS = {
			"\1\2\26\uffff\1\1",
			"",
			"\1\3",
			"\1\4",
			"\1\5\3\uffff\3\5",
			"\1\10\1\uffff\1\7\3\10\4\uffff\1\10\13\uffff\1\5\2\uffff\1\6\3\5\2\uffff"+
			"\1\6",
			"",
			"\1\10\15\uffff\1\6\10\uffff\1\10\5\uffff\1\10",
			""
	};

	static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
	static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
	static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
	static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
	static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
	static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
	static final short[][] DFA2_transition;

	static {
		int numStates = DFA2_transitionS.length;
		DFA2_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
		}
	}

	protected class DFA2 extends DFA {

		public DFA2(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 2;
			this.eot = DFA2_eot;
			this.eof = DFA2_eof;
			this.min = DFA2_min;
			this.max = DFA2_max;
			this.accept = DFA2_accept;
			this.special = DFA2_special;
			this.transition = DFA2_transition;
		}
		@Override
		public String getDescription() {
			return "36:1: body returns [Statement result] : ( ifthen | simplequestion | comquestion );";
		}
	}

	public static final BitSet FOLLOW_28_in_form50 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ident_in_form52 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_33_in_form54 = new BitSet(new long[]{0x0000000820000040L});
	public static final BitSet FOLLOW_block_in_form56 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_35_in_form58 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_body_in_block86 = new BitSet(new long[]{0x0000000020000042L});
	public static final BitSet FOLLOW_ifthen_in_body112 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_simplequestion_in_body121 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_comquestion_in_body129 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_29_in_ifthen157 = new BitSet(new long[]{0x00000000000043D0L});
	public static final BitSet FOLLOW_expression_in_ifthen159 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_33_in_ifthen161 = new BitSet(new long[]{0x0000000820000040L});
	public static final BitSet FOLLOW_block_in_ifthen165 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_35_in_ifthen167 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_29_in_ifthenelse267 = new BitSet(new long[]{0x00000000000043D0L});
	public static final BitSet FOLLOW_expression_in_ifthenelse269 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_33_in_ifthenelse271 = new BitSet(new long[]{0x0000000820000040L});
	public static final BitSet FOLLOW_block_in_ifthenelse275 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_35_in_ifthenelse277 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_27_in_ifthenelse279 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_33_in_ifthenelse281 = new BitSet(new long[]{0x0000000820000040L});
	public static final BitSet FOLLOW_block_in_ifthenelse285 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_35_in_ifthenelse287 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ident_in_simplequestion309 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_simplequestion311 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_string_in_simplequestion313 = new BitSet(new long[]{0x00000001C4000000L});
	public static final BitSet FOLLOW_type_in_simplequestion315 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ident_in_comquestion335 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_comquestion337 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_string_in_comquestion339 = new BitSet(new long[]{0x00000001C4000000L});
	public static final BitSet FOLLOW_type_in_comquestion341 = new BitSet(new long[]{0x00000000000043D0L});
	public static final BitSet FOLLOW_expression_in_comquestion343 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_integer_in_expression450 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_bool_in_expression458 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_string_in_expression466 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_money_in_expression474 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ident_in_expression482 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_14_in_expression490 = new BitSet(new long[]{0x0000000000064BD0L});
	public static final BitSet FOLLOW_orExpr_in_expression494 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_expression496 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_17_in_unExpr522 = new BitSet(new long[]{0x0000000000064BD0L});
	public static final BitSet FOLLOW_unExpr_in_unExpr526 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_18_in_unExpr537 = new BitSet(new long[]{0x0000000000064BD0L});
	public static final BitSet FOLLOW_unExpr_in_unExpr541 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_11_in_unExpr552 = new BitSet(new long[]{0x0000000000064BD0L});
	public static final BitSet FOLLOW_unExpr_in_unExpr556 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_unExpr569 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr609 = new BitSet(new long[]{0x0000000000090002L});
	public static final BitSet FOLLOW_set_in_mulExpr617 = new BitSet(new long[]{0x0000000000064BD0L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr629 = new BitSet(new long[]{0x0000000000090002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr664 = new BitSet(new long[]{0x0000000000060002L});
	public static final BitSet FOLLOW_set_in_addExpr672 = new BitSet(new long[]{0x0000000000064BD0L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr682 = new BitSet(new long[]{0x0000000000060002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr721 = new BitSet(new long[]{0x0000000003E01002L});
	public static final BitSet FOLLOW_set_in_relExpr729 = new BitSet(new long[]{0x0000000000064BD0L});
	public static final BitSet FOLLOW_addExpr_in_relExpr745 = new BitSet(new long[]{0x0000000003E01002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr779 = new BitSet(new long[]{0x0000000000002002L});
	public static final BitSet FOLLOW_13_in_andExpr785 = new BitSet(new long[]{0x0000000000064BD0L});
	public static final BitSet FOLLOW_relExpr_in_andExpr789 = new BitSet(new long[]{0x0000000000002002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr814 = new BitSet(new long[]{0x0000000400000002L});
	public static final BitSet FOLLOW_34_in_orExpr821 = new BitSet(new long[]{0x0000000000064BD0L});
	public static final BitSet FOLLOW_andExpr_in_orExpr825 = new BitSet(new long[]{0x0000000400000002L});
	public static final BitSet FOLLOW_set_in_type855 = new BitSet(new long[]{0x00000001C4000002L});
	public static final BitSet FOLLOW_Int_in_integer886 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_String_literal_in_string895 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Bool_in_bool904 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_ident912 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Money_in_money920 = new BitSet(new long[]{0x0000000000000002L});
}
