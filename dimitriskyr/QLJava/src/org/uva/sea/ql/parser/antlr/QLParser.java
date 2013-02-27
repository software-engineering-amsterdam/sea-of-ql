// $ANTLR 3.5 C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g 2013-02-25 14:10:15

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
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:28:1: block returns [Block result] : ( body )* ;
	public final Block block() throws RecognitionException {
		Block result = null;


		Statement body3 =null;

		 Block block = new Block(); 
		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:30:3: ( ( body )* )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:30:5: ( body )*
			{
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:30:5: ( body )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==Ident||LA1_0==29) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:30:6: body
					{
					pushFollow(FOLLOW_body_in_block84);
					body3=body();
					state._fsp--;

					block.addBody(body3);
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
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:34:1: body returns [Statement result] : ( ifthen | simplequestion | comquestion );
	public final Statement body() throws RecognitionException {
		Statement result = null;


		Statement ifthen4 =null;
		Statement simplequestion5 =null;
		Statement comquestion6 =null;

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:35:3: ( ifthen | simplequestion | comquestion )
			int alt2=3;
			alt2 = dfa2.predict(input);
			switch (alt2) {
				case 1 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:35:5: ifthen
					{
					pushFollow(FOLLOW_ifthen_in_body110);
					ifthen4=ifthen();
					state._fsp--;

					 result = ifthen4; 
					}
					break;
				case 2 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:36:5: simplequestion
					{
					pushFollow(FOLLOW_simplequestion_in_body119);
					simplequestion5=simplequestion();
					state._fsp--;

					 result = simplequestion5; 
					}
					break;
				case 3 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:37:5: comquestion
					{
					pushFollow(FOLLOW_comquestion_in_body127);
					comquestion6=comquestion();
					state._fsp--;

					result = comquestion6; 
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
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:42:1: ifthen returns [Statement result] : 'if' expression '{' b= block '}' ;
	public final Statement ifthen() throws RecognitionException {
		Statement result = null;


		Block b =null;
		Expr expression7 =null;

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:43:3: ( 'if' expression '{' b= block '}' )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:43:5: 'if' expression '{' b= block '}'
			{
			match(input,29,FOLLOW_29_in_ifthen153); 
			pushFollow(FOLLOW_expression_in_ifthen155);
			expression7=expression();
			state._fsp--;

			match(input,33,FOLLOW_33_in_ifthen157); 
			pushFollow(FOLLOW_block_in_ifthen161);
			b=block();
			state._fsp--;

			match(input,35,FOLLOW_35_in_ifthen163); 
			result = new IfThen(expression7 , b);
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
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:47:1: ifthenelse returns [Statement result] : 'if' expression '{' b1= block '}' 'else' '{' b2= block '}' ;
	public final Statement ifthenelse() throws RecognitionException {
		Statement result = null;


		Block b1 =null;
		Block b2 =null;
		Expr expression8 =null;

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:48:3: ( 'if' expression '{' b1= block '}' 'else' '{' b2= block '}' )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:48:5: 'if' expression '{' b1= block '}' 'else' '{' b2= block '}'
			{
			match(input,29,FOLLOW_29_in_ifthenelse218); 
			pushFollow(FOLLOW_expression_in_ifthenelse220);
			expression8=expression();
			state._fsp--;

			match(input,33,FOLLOW_33_in_ifthenelse222); 
			pushFollow(FOLLOW_block_in_ifthenelse226);
			b1=block();
			state._fsp--;

			match(input,35,FOLLOW_35_in_ifthenelse228); 
			match(input,27,FOLLOW_27_in_ifthenelse230); 
			match(input,33,FOLLOW_33_in_ifthenelse232); 
			pushFollow(FOLLOW_block_in_ifthenelse236);
			b2=block();
			state._fsp--;

			match(input,35,FOLLOW_35_in_ifthenelse238); 
			result = new IfThenElse(expression8 , b1, b2);
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
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:51:1: simplequestion returns [Statement result] : ident ':' string type ;
	public final Statement simplequestion() throws RecognitionException {
		Statement result = null;


		ParserRuleReturnScope ident9 =null;
		ParserRuleReturnScope string10 =null;
		Type type11 =null;

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:52:3: ( ident ':' string type )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:52:5: ident ':' string type
			{
			pushFollow(FOLLOW_ident_in_simplequestion256);
			ident9=ident();
			state._fsp--;

			match(input,20,FOLLOW_20_in_simplequestion258); 
			pushFollow(FOLLOW_string_in_simplequestion260);
			string10=string();
			state._fsp--;

			pushFollow(FOLLOW_type_in_simplequestion262);
			type11=type();
			state._fsp--;

			result = new SimpleQuestion(new Ident((ident9!=null?input.toString(ident9.start,ident9.stop):null)) , new String_lit((string10!=null?input.toString(string10.start,string10.stop):null)) , type11);
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
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:55:1: comquestion returns [Statement result] : ident ':' string type expression ;
	public final Statement comquestion() throws RecognitionException {
		Statement result = null;


		ParserRuleReturnScope ident12 =null;
		ParserRuleReturnScope string13 =null;
		Type type14 =null;
		Expr expression15 =null;

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:56:3: ( ident ':' string type expression )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:56:5: ident ':' string type expression
			{
			pushFollow(FOLLOW_ident_in_comquestion282);
			ident12=ident();
			state._fsp--;

			match(input,20,FOLLOW_20_in_comquestion284); 
			pushFollow(FOLLOW_string_in_comquestion286);
			string13=string();
			state._fsp--;

			pushFollow(FOLLOW_type_in_comquestion288);
			type14=type();
			state._fsp--;

			pushFollow(FOLLOW_expression_in_comquestion290);
			expression15=expression();
			state._fsp--;

			result = new ComQuestion(new Ident((ident12!=null?input.toString(ident12.start,ident12.stop):null)) , new String_lit((string13!=null?input.toString(string13.start,string13.stop):null)) , type14 , expression15);
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
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:60:1: expression returns [Expr result] : ( integer | bool | string | money | ident | '(' x= orExpr ')' );
	public final Expr expression() throws RecognitionException {
		Expr result = null;


		Expr x =null;
		ParserRuleReturnScope integer16 =null;
		ParserRuleReturnScope bool17 =null;
		ParserRuleReturnScope string18 =null;
		ParserRuleReturnScope money19 =null;
		ParserRuleReturnScope ident20 =null;

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:61:3: ( integer | bool | string | money | ident | '(' x= orExpr ')' )
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
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:61:5: integer
					{
					pushFollow(FOLLOW_integer_in_expression397);
					integer16=integer();
					state._fsp--;

					result = new Int(Integer.parseInt((integer16!=null?input.toString(integer16.start,integer16.stop):null)));
					}
					break;
				case 2 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:62:5: bool
					{
					pushFollow(FOLLOW_bool_in_expression405);
					bool17=bool();
					state._fsp--;

					 result = new Bool(Boolean.parseBoolean((bool17!=null?input.toString(bool17.start,bool17.stop):null)));
					}
					break;
				case 3 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:63:5: string
					{
					pushFollow(FOLLOW_string_in_expression413);
					string18=string();
					state._fsp--;

					 result = new String_lit((string18!=null?input.toString(string18.start,string18.stop):null));
					}
					break;
				case 4 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:64:5: money
					{
					pushFollow(FOLLOW_money_in_expression421);
					money19=money();
					state._fsp--;

					result = new Money(Float.parseFloat((money19!=null?input.toString(money19.start,money19.stop):null)));
					}
					break;
				case 5 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:65:5: ident
					{
					pushFollow(FOLLOW_ident_in_expression429);
					ident20=ident();
					state._fsp--;

					result = new Ident((ident20!=null?input.toString(ident20.start,ident20.stop):null));
					}
					break;
				case 6 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:66:5: '(' x= orExpr ')'
					{
					match(input,14,FOLLOW_14_in_expression437); 
					pushFollow(FOLLOW_orExpr_in_expression441);
					x=orExpr();
					state._fsp--;

					match(input,15,FOLLOW_15_in_expression443); 
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
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:71:1: unExpr returns [Expr result] : ( '+' pos= unExpr | '-' neg= unExpr | '!' not= unExpr |x= expression );
	public final Expr unExpr() throws RecognitionException {
		Expr result = null;


		Expr pos =null;
		Expr neg =null;
		Expr not =null;
		Expr x =null;

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:72:5: ( '+' pos= unExpr | '-' neg= unExpr | '!' not= unExpr |x= expression )
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
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:72:8: '+' pos= unExpr
					{
					match(input,17,FOLLOW_17_in_unExpr469); 
					pushFollow(FOLLOW_unExpr_in_unExpr473);
					pos=unExpr();
					state._fsp--;

					 result = new Pos(pos); 
					}
					break;
				case 2 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:73:8: '-' neg= unExpr
					{
					match(input,18,FOLLOW_18_in_unExpr484); 
					pushFollow(FOLLOW_unExpr_in_unExpr488);
					neg=unExpr();
					state._fsp--;

					 result = new Neg(neg); 
					}
					break;
				case 3 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:74:8: '!' not= unExpr
					{
					match(input,11,FOLLOW_11_in_unExpr499); 
					pushFollow(FOLLOW_unExpr_in_unExpr503);
					not=unExpr();
					state._fsp--;

					 result = new Not(not); 
					}
					break;
				case 4 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:75:8: x= expression
					{
					pushFollow(FOLLOW_expression_in_unExpr516);
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
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:79:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
	public final Expr mulExpr() throws RecognitionException {
		Expr result = null;


		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:80:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:80:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
			{
			pushFollow(FOLLOW_unExpr_in_mulExpr556);
			lhs=unExpr();
			state._fsp--;

			 result =lhs; 
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:80:45: (op= ( '*' | '/' ) rhs= unExpr )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==16||LA5_0==19) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:80:47: op= ( '*' | '/' ) rhs= unExpr
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
					pushFollow(FOLLOW_unExpr_in_mulExpr576);
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
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:91:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
	public final Expr addExpr() throws RecognitionException {
		Expr result = null;


		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:92:4: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:92:8: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
			{
			pushFollow(FOLLOW_mulExpr_in_addExpr611);
			lhs=mulExpr();
			state._fsp--;

			 result =lhs; 
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:92:45: (op= ( '+' | '-' ) rhs= mulExpr )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( ((LA6_0 >= 17 && LA6_0 <= 18)) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:92:47: op= ( '+' | '-' ) rhs= mulExpr
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
					pushFollow(FOLLOW_mulExpr_in_addExpr629);
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
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:103:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
	public final Expr relExpr() throws RecognitionException {
		Expr result = null;


		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:104:3: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:104:7: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			{
			pushFollow(FOLLOW_addExpr_in_relExpr668);
			lhs=addExpr();
			state._fsp--;

			 result =lhs; 
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:104:44: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==12||(LA7_0 >= 21 && LA7_0 <= 25)) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:104:46: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
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
					pushFollow(FOLLOW_addExpr_in_relExpr692);
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
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:127:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
	public final Expr andExpr() throws RecognitionException {
		Expr result = null;


		Expr lhs =null;
		Expr rhs =null;

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:128:3: (lhs= relExpr ( '&&' rhs= relExpr )* )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:128:5: lhs= relExpr ( '&&' rhs= relExpr )*
			{
			pushFollow(FOLLOW_relExpr_in_andExpr726);
			lhs=relExpr();
			state._fsp--;

			result = lhs;
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:128:42: ( '&&' rhs= relExpr )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==13) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:128:44: '&&' rhs= relExpr
					{
					match(input,13,FOLLOW_13_in_andExpr732); 
					pushFollow(FOLLOW_relExpr_in_andExpr736);
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
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:131:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
	public final Expr orExpr() throws RecognitionException {
		Expr result = null;


		Expr lhs =null;
		Expr rhs =null;

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:132:3: (lhs= andExpr ( '||' rhs= andExpr )* )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:132:5: lhs= andExpr ( '||' rhs= andExpr )*
			{
			pushFollow(FOLLOW_andExpr_in_orExpr761);
			lhs=andExpr();
			state._fsp--;

			result = lhs;
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:132:43: ( '||' rhs= andExpr )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==34) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:132:45: '||' rhs= andExpr
					{
					match(input,34,FOLLOW_34_in_orExpr768); 
					pushFollow(FOLLOW_andExpr_in_orExpr772);
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
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:135:1: type returns [Type result] : (whattype= ( 'integer' | 'boolean' | 'string' | 'money' ) )+ ;
	public final Type type() throws RecognitionException {
		Type result = null;


		Token whattype=null;

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:136:2: ( (whattype= ( 'integer' | 'boolean' | 'string' | 'money' ) )+ )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:136:5: (whattype= ( 'integer' | 'boolean' | 'string' | 'money' ) )+
			{
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:136:5: (whattype= ( 'integer' | 'boolean' | 'string' | 'money' ) )+
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
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:136:7: whattype= ( 'integer' | 'boolean' | 'string' | 'money' )
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
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:153:1: integer : Int ;
	public final QLParser.integer_return integer() throws RecognitionException {
		QLParser.integer_return retval = new QLParser.integer_return();
		retval.start = input.LT(1);

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:153:9: ( Int )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:153:11: Int
			{
			match(input,Int,FOLLOW_Int_in_integer829); 
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
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:154:1: string : String_literal ;
	public final QLParser.string_return string() throws RecognitionException {
		QLParser.string_return retval = new QLParser.string_return();
		retval.start = input.LT(1);

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:154:8: ( String_literal )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:154:10: String_literal
			{
			match(input,String_literal,FOLLOW_String_literal_in_string838); 
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
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:155:1: bool : Bool ;
	public final QLParser.bool_return bool() throws RecognitionException {
		QLParser.bool_return retval = new QLParser.bool_return();
		retval.start = input.LT(1);

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:155:6: ( Bool )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:155:8: Bool
			{
			match(input,Bool,FOLLOW_Bool_in_bool847); 
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
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:156:1: ident : Ident ;
	public final QLParser.ident_return ident() throws RecognitionException {
		QLParser.ident_return retval = new QLParser.ident_return();
		retval.start = input.LT(1);

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:156:7: ( Ident )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:156:9: Ident
			{
			match(input,Ident,FOLLOW_Ident_in_ident855); 
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
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:157:1: money : Money ;
	public final QLParser.money_return money() throws RecognitionException {
		QLParser.money_return retval = new QLParser.money_return();
		retval.start = input.LT(1);

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:157:7: ( Money )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:157:9: Money
			{
			match(input,Money,FOLLOW_Money_in_money863); 
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
			return "34:1: body returns [Statement result] : ( ifthen | simplequestion | comquestion );";
		}
	}

	public static final BitSet FOLLOW_28_in_form50 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ident_in_form52 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_33_in_form54 = new BitSet(new long[]{0x0000000820000040L});
	public static final BitSet FOLLOW_block_in_form56 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_35_in_form58 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_body_in_block84 = new BitSet(new long[]{0x0000000020000042L});
	public static final BitSet FOLLOW_ifthen_in_body110 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_simplequestion_in_body119 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_comquestion_in_body127 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_29_in_ifthen153 = new BitSet(new long[]{0x00000000000043D0L});
	public static final BitSet FOLLOW_expression_in_ifthen155 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_33_in_ifthen157 = new BitSet(new long[]{0x0000000820000040L});
	public static final BitSet FOLLOW_block_in_ifthen161 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_35_in_ifthen163 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_29_in_ifthenelse218 = new BitSet(new long[]{0x00000000000043D0L});
	public static final BitSet FOLLOW_expression_in_ifthenelse220 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_33_in_ifthenelse222 = new BitSet(new long[]{0x0000000820000040L});
	public static final BitSet FOLLOW_block_in_ifthenelse226 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_35_in_ifthenelse228 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_27_in_ifthenelse230 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_33_in_ifthenelse232 = new BitSet(new long[]{0x0000000820000040L});
	public static final BitSet FOLLOW_block_in_ifthenelse236 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_35_in_ifthenelse238 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ident_in_simplequestion256 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_simplequestion258 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_string_in_simplequestion260 = new BitSet(new long[]{0x00000001C4000000L});
	public static final BitSet FOLLOW_type_in_simplequestion262 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ident_in_comquestion282 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_comquestion284 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_string_in_comquestion286 = new BitSet(new long[]{0x00000001C4000000L});
	public static final BitSet FOLLOW_type_in_comquestion288 = new BitSet(new long[]{0x00000000000043D0L});
	public static final BitSet FOLLOW_expression_in_comquestion290 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_integer_in_expression397 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_bool_in_expression405 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_string_in_expression413 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_money_in_expression421 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ident_in_expression429 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_14_in_expression437 = new BitSet(new long[]{0x0000000000064BD0L});
	public static final BitSet FOLLOW_orExpr_in_expression441 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_expression443 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_17_in_unExpr469 = new BitSet(new long[]{0x0000000000064BD0L});
	public static final BitSet FOLLOW_unExpr_in_unExpr473 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_18_in_unExpr484 = new BitSet(new long[]{0x0000000000064BD0L});
	public static final BitSet FOLLOW_unExpr_in_unExpr488 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_11_in_unExpr499 = new BitSet(new long[]{0x0000000000064BD0L});
	public static final BitSet FOLLOW_unExpr_in_unExpr503 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_unExpr516 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr556 = new BitSet(new long[]{0x0000000000090002L});
	public static final BitSet FOLLOW_set_in_mulExpr564 = new BitSet(new long[]{0x0000000000064BD0L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr576 = new BitSet(new long[]{0x0000000000090002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr611 = new BitSet(new long[]{0x0000000000060002L});
	public static final BitSet FOLLOW_set_in_addExpr619 = new BitSet(new long[]{0x0000000000064BD0L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr629 = new BitSet(new long[]{0x0000000000060002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr668 = new BitSet(new long[]{0x0000000003E01002L});
	public static final BitSet FOLLOW_set_in_relExpr676 = new BitSet(new long[]{0x0000000000064BD0L});
	public static final BitSet FOLLOW_addExpr_in_relExpr692 = new BitSet(new long[]{0x0000000003E01002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr726 = new BitSet(new long[]{0x0000000000002002L});
	public static final BitSet FOLLOW_13_in_andExpr732 = new BitSet(new long[]{0x0000000000064BD0L});
	public static final BitSet FOLLOW_relExpr_in_andExpr736 = new BitSet(new long[]{0x0000000000002002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr761 = new BitSet(new long[]{0x0000000400000002L});
	public static final BitSet FOLLOW_34_in_orExpr768 = new BitSet(new long[]{0x0000000000064BD0L});
	public static final BitSet FOLLOW_andExpr_in_orExpr772 = new BitSet(new long[]{0x0000000400000002L});
	public static final BitSet FOLLOW_set_in_type798 = new BitSet(new long[]{0x00000001C4000002L});
	public static final BitSet FOLLOW_Int_in_integer829 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_String_literal_in_string838 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Bool_in_bool847 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_ident855 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Money_in_money863 = new BitSet(new long[]{0x0000000000000002L});
}
