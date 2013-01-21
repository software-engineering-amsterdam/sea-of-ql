// $ANTLR 3.5 C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g 2013-01-21 14:09:53

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expressions.*;
import org.uva.sea.ql.ast.types.*;
import org.uva.sea.ql.ast.statements.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class QLParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "Bool", "Comments", "Ident", "Int", 
		"String_literal", "WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", 
		"'-'", "'/'", "':'", "'<'", "'<='", "'=='", "'>'", "'>='", "'form'", "'if'", 
		"'{'", "'||'", "'}'"
	};
	public static final int EOF=-1;
	public static final int T__10=10;
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
	public static final int Bool=4;
	public static final int Comments=5;
	public static final int Ident=6;
	public static final int Int=7;
	public static final int String_literal=8;
	public static final int WS=9;

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
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:22:1: form returns [Form result] : 'form' ident '{' ( part )+ '}' ;
	public final Form form() throws RecognitionException {
		Form result = null;


		Statement part1 =null;
		ParserRuleReturnScope ident2 =null;

		 List<Statement> formpart = new ArrayList<Statement>();
		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:24:2: ( 'form' ident '{' ( part )+ '}' )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:24:5: 'form' ident '{' ( part )+ '}'
			{
			match(input,25,FOLLOW_25_in_form55); 
			pushFollow(FOLLOW_ident_in_form57);
			ident2=ident();
			state._fsp--;

			match(input,27,FOLLOW_27_in_form59); 
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:24:22: ( part )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==Ident||LA1_0==26) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:24:23: part
					{
					pushFollow(FOLLOW_part_in_form62);
					part1=part();
					state._fsp--;

					formpart.add(part1);
					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			match(input,29,FOLLOW_29_in_form68); 
			result = new Form (new Ident((ident2!=null?input.toString(ident2.start,ident2.stop):null)), formpart);
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



	// $ANTLR start "part"
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:29:1: part returns [Statement result] : ( ifthen | questions );
	public final Statement part() throws RecognitionException {
		Statement result = null;


		Statement ifthen3 =null;
		Question questions4 =null;

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:30:3: ( ifthen | questions )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==26) ) {
				alt2=1;
			}
			else if ( (LA2_0==Ident) ) {
				alt2=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:30:5: ifthen
					{
					pushFollow(FOLLOW_ifthen_in_part89);
					ifthen3=ifthen();
					state._fsp--;

					 result = ifthen3; 
					}
					break;
				case 2 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:31:5: questions
					{
					pushFollow(FOLLOW_questions_in_part98);
					questions4=questions();
					state._fsp--;

					 result = questions4; 
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
	// $ANTLR end "part"



	// $ANTLR start "ifthen"
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:37:1: ifthen returns [Statement result] : 'if' expression '{' ( part )+ '}' ;
	public final Statement ifthen() throws RecognitionException {
		Statement result = null;


		Statement part5 =null;
		Expr expression6 =null;

		 List<Statement> block = new ArrayList<Statement>();
		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:39:3: ( 'if' expression '{' ( part )+ '}' )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:39:5: 'if' expression '{' ( part )+ '}'
			{
			match(input,26,FOLLOW_26_in_ifthen130); 
			pushFollow(FOLLOW_expression_in_ifthen132);
			expression6=expression();
			state._fsp--;

			match(input,27,FOLLOW_27_in_ifthen134); 
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:39:25: ( part )+
			int cnt3=0;
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==Ident||LA3_0==26) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:39:26: part
					{
					pushFollow(FOLLOW_part_in_ifthen137);
					part5=part();
					state._fsp--;

					block.add(part5);
					}
					break;

				default :
					if ( cnt3 >= 1 ) break loop3;
					EarlyExitException eee = new EarlyExitException(3, input);
					throw eee;
				}
				cnt3++;
			}

			match(input,29,FOLLOW_29_in_ifthen143); 
			result = new Ifthen(expression6 , block);
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



	// $ANTLR start "questions"
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:55:2: questions returns [Question result] : ( ident ':' string bool | ident ':' string type expression );
	public final Question questions() throws RecognitionException {
		Question result = null;


		ParserRuleReturnScope ident7 =null;
		ParserRuleReturnScope string8 =null;
		ParserRuleReturnScope bool9 =null;
		ParserRuleReturnScope ident10 =null;
		ParserRuleReturnScope string11 =null;
		Type type12 =null;
		Expr expression13 =null;

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:56:3: ( ident ':' string bool | ident ':' string type expression )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==Ident) ) {
				int LA4_1 = input.LA(2);
				if ( (LA4_1==19) ) {
					int LA4_2 = input.LA(3);
					if ( (LA4_2==String_literal) ) {
						int LA4_3 = input.LA(4);
						if ( (LA4_3==Bool) ) {
							switch ( input.LA(5) ) {
							case 26:
							case 29:
								{
								alt4=1;
								}
								break;
							case Ident:
								{
								int LA4_7 = input.LA(6);
								if ( (LA4_7==19) ) {
									alt4=1;
								}
								else if ( (LA4_7==Ident||LA4_7==26||LA4_7==29) ) {
									alt4=2;
								}

								else {
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 4, 7, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

								}
								break;
							case Bool:
							case Int:
							case String_literal:
							case 13:
								{
								alt4=2;
								}
								break;
							default:
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 4, 4, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}
						}
						else if ( ((LA4_3 >= Ident && LA4_3 <= String_literal)) ) {
							alt4=2;
						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 4, 3, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 4, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 4, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:56:5: ident ':' string bool
					{
					pushFollow(FOLLOW_ident_in_questions253);
					ident7=ident();
					state._fsp--;

					match(input,19,FOLLOW_19_in_questions255); 
					pushFollow(FOLLOW_string_in_questions257);
					string8=string();
					state._fsp--;

					pushFollow(FOLLOW_bool_in_questions259);
					bool9=bool();
					state._fsp--;

					result = new Questions(new Ident((ident7!=null?input.toString(ident7.start,ident7.stop):null)) , new String_lit((string8!=null?input.toString(string8.start,string8.stop):null)) , new Bool(Boolean.parseBoolean((bool9!=null?input.toString(bool9.start,bool9.stop):null))));
					}
					break;
				case 2 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:57:5: ident ':' string type expression
					{
					pushFollow(FOLLOW_ident_in_questions267);
					ident10=ident();
					state._fsp--;

					match(input,19,FOLLOW_19_in_questions269); 
					pushFollow(FOLLOW_string_in_questions271);
					string11=string();
					state._fsp--;

					pushFollow(FOLLOW_type_in_questions273);
					type12=type();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_questions275);
					expression13=expression();
					state._fsp--;

					result = new ComQuestions(new Ident((ident10!=null?input.toString(ident10.start,ident10.stop):null)) , new String_lit((string11!=null?input.toString(string11.start,string11.stop):null)) , type12 , expression13);
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
	// $ANTLR end "questions"



	// $ANTLR start "expression"
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:68:1: expression returns [Expr result] : ( type | '(' x= orExpr ')' );
	public final Expr expression() throws RecognitionException {
		Expr result = null;


		Expr x =null;

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:69:3: ( type | '(' x= orExpr ')' )
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==Bool||(LA5_0 >= Ident && LA5_0 <= String_literal)) ) {
				alt5=1;
			}
			else if ( (LA5_0==13) ) {
				alt5=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}

			switch (alt5) {
				case 1 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:69:5: type
					{
					pushFollow(FOLLOW_type_in_expression345);
					type();
					state._fsp--;

					}
					break;
				case 2 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:70:5: '(' x= orExpr ')'
					{
					match(input,13,FOLLOW_13_in_expression352); 
					pushFollow(FOLLOW_orExpr_in_expression356);
					x=orExpr();
					state._fsp--;

					match(input,14,FOLLOW_14_in_expression358); 
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
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:75:1: unExpr returns [Expr result] : ( '+' pos= unExpr | '-' neg= unExpr | '!' not= unExpr |x= expression );
	public final Expr unExpr() throws RecognitionException {
		Expr result = null;


		Expr pos =null;
		Expr neg =null;
		Expr not =null;
		Expr x =null;

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:76:5: ( '+' pos= unExpr | '-' neg= unExpr | '!' not= unExpr |x= expression )
			int alt6=4;
			switch ( input.LA(1) ) {
			case 16:
				{
				alt6=1;
				}
				break;
			case 17:
				{
				alt6=2;
				}
				break;
			case 10:
				{
				alt6=3;
				}
				break;
			case Bool:
			case Ident:
			case Int:
			case String_literal:
			case 13:
				{
				alt6=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}
			switch (alt6) {
				case 1 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:76:8: '+' pos= unExpr
					{
					match(input,16,FOLLOW_16_in_unExpr384); 
					pushFollow(FOLLOW_unExpr_in_unExpr388);
					pos=unExpr();
					state._fsp--;

					 result = new Pos(pos); 
					}
					break;
				case 2 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:77:8: '-' neg= unExpr
					{
					match(input,17,FOLLOW_17_in_unExpr399); 
					pushFollow(FOLLOW_unExpr_in_unExpr403);
					neg=unExpr();
					state._fsp--;

					 result = new Neg(neg); 
					}
					break;
				case 3 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:78:8: '!' not= unExpr
					{
					match(input,10,FOLLOW_10_in_unExpr414); 
					pushFollow(FOLLOW_unExpr_in_unExpr418);
					not=unExpr();
					state._fsp--;

					 result = new Not(not); 
					}
					break;
				case 4 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:79:8: x= expression
					{
					pushFollow(FOLLOW_expression_in_unExpr431);
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
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:83:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
	public final Expr mulExpr() throws RecognitionException {
		Expr result = null;


		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:84:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:84:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
			{
			pushFollow(FOLLOW_unExpr_in_mulExpr471);
			lhs=unExpr();
			state._fsp--;

			 result =lhs; 
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:84:45: (op= ( '*' | '/' ) rhs= unExpr )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==15||LA7_0==18) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:84:47: op= ( '*' | '/' ) rhs= unExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==15||input.LA(1)==18 ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_unExpr_in_mulExpr491);
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
	// $ANTLR end "mulExpr"



	// $ANTLR start "addExpr"
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:95:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
	public final Expr addExpr() throws RecognitionException {
		Expr result = null;


		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:96:4: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:96:8: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
			{
			pushFollow(FOLLOW_mulExpr_in_addExpr526);
			lhs=mulExpr();
			state._fsp--;

			 result =lhs; 
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:96:45: (op= ( '+' | '-' ) rhs= mulExpr )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( ((LA8_0 >= 16 && LA8_0 <= 17)) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:96:47: op= ( '+' | '-' ) rhs= mulExpr
					{
					op=input.LT(1);
					if ( (input.LA(1) >= 16 && input.LA(1) <= 17) ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_mulExpr_in_addExpr544);
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
	// $ANTLR end "addExpr"



	// $ANTLR start "relExpr"
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:107:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
	public final Expr relExpr() throws RecognitionException {
		Expr result = null;


		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:108:3: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:108:7: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			{
			pushFollow(FOLLOW_addExpr_in_relExpr583);
			lhs=addExpr();
			state._fsp--;

			 result =lhs; 
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:108:44: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==11||(LA9_0 >= 20 && LA9_0 <= 24)) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:108:46: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==11||(input.LA(1) >= 20 && input.LA(1) <= 24) ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_addExpr_in_relExpr607);
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
	// $ANTLR end "relExpr"



	// $ANTLR start "andExpr"
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:131:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
	public final Expr andExpr() throws RecognitionException {
		Expr result = null;


		Expr lhs =null;
		Expr rhs =null;

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:132:3: (lhs= relExpr ( '&&' rhs= relExpr )* )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:132:5: lhs= relExpr ( '&&' rhs= relExpr )*
			{
			pushFollow(FOLLOW_relExpr_in_andExpr640);
			lhs=relExpr();
			state._fsp--;

			result = lhs;
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:132:42: ( '&&' rhs= relExpr )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==12) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:132:44: '&&' rhs= relExpr
					{
					match(input,12,FOLLOW_12_in_andExpr646); 
					pushFollow(FOLLOW_relExpr_in_andExpr650);
					rhs=relExpr();
					state._fsp--;

					result = new And (result, rhs); 
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
		}
		return result;
	}
	// $ANTLR end "andExpr"



	// $ANTLR start "orExpr"
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:135:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
	public final Expr orExpr() throws RecognitionException {
		Expr result = null;


		Expr lhs =null;
		Expr rhs =null;

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:136:3: (lhs= andExpr ( '||' rhs= andExpr )* )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:136:5: lhs= andExpr ( '||' rhs= andExpr )*
			{
			pushFollow(FOLLOW_andExpr_in_orExpr675);
			lhs=andExpr();
			state._fsp--;

			result = lhs;
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:136:43: ( '||' rhs= andExpr )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==28) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:136:45: '||' rhs= andExpr
					{
					match(input,28,FOLLOW_28_in_orExpr682); 
					pushFollow(FOLLOW_andExpr_in_orExpr686);
					rhs=andExpr();
					state._fsp--;

					result = new Or(result,rhs); 
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
		}
		return result;
	}
	// $ANTLR end "orExpr"



	// $ANTLR start "type"
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:141:1: type returns [Type result] : ( integer | ident | bool | string );
	public final Type type() throws RecognitionException {
		Type result = null;


		ParserRuleReturnScope integer14 =null;
		ParserRuleReturnScope ident15 =null;
		ParserRuleReturnScope bool16 =null;
		ParserRuleReturnScope string17 =null;

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:142:3: ( integer | ident | bool | string )
			int alt12=4;
			switch ( input.LA(1) ) {
			case Int:
				{
				alt12=1;
				}
				break;
			case Ident:
				{
				alt12=2;
				}
				break;
			case Bool:
				{
				alt12=3;
				}
				break;
			case String_literal:
				{
				alt12=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}
			switch (alt12) {
				case 1 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:142:5: integer
					{
					pushFollow(FOLLOW_integer_in_type709);
					integer14=integer();
					state._fsp--;

					result = new Int(Integer.parseInt((integer14!=null?input.toString(integer14.start,integer14.stop):null)));
					}
					break;
				case 2 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:143:5: ident
					{
					pushFollow(FOLLOW_ident_in_type717);
					ident15=ident();
					state._fsp--;

					result = new Ident((ident15!=null?input.toString(ident15.start,ident15.stop):null));
					}
					break;
				case 3 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:144:5: bool
					{
					pushFollow(FOLLOW_bool_in_type725);
					bool16=bool();
					state._fsp--;

					 result = new Bool(Boolean.parseBoolean((bool16!=null?input.toString(bool16.start,bool16.stop):null)));
					}
					break;
				case 4 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:145:5: string
					{
					pushFollow(FOLLOW_string_in_type733);
					string17=string();
					state._fsp--;

					 result = new String_lit((string17!=null?input.toString(string17.start,string17.stop):null));
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
	// $ANTLR end "type"


	public static class integer_return extends ParserRuleReturnScope {
	};


	// $ANTLR start "integer"
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:148:1: integer : Int ;
	public final QLParser.integer_return integer() throws RecognitionException {
		QLParser.integer_return retval = new QLParser.integer_return();
		retval.start = input.LT(1);

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:148:9: ( Int )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:148:11: Int
			{
			match(input,Int,FOLLOW_Int_in_integer748); 
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
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:149:1: string : String_literal ;
	public final QLParser.string_return string() throws RecognitionException {
		QLParser.string_return retval = new QLParser.string_return();
		retval.start = input.LT(1);

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:149:8: ( String_literal )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:149:10: String_literal
			{
			match(input,String_literal,FOLLOW_String_literal_in_string757); 
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
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:150:1: bool : Bool ;
	public final QLParser.bool_return bool() throws RecognitionException {
		QLParser.bool_return retval = new QLParser.bool_return();
		retval.start = input.LT(1);

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:150:6: ( Bool )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:150:8: Bool
			{
			match(input,Bool,FOLLOW_Bool_in_bool766); 
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
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:151:1: ident : Ident ;
	public final QLParser.ident_return ident() throws RecognitionException {
		QLParser.ident_return retval = new QLParser.ident_return();
		retval.start = input.LT(1);

		try {
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:151:7: ( Ident )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:151:9: Ident
			{
			match(input,Ident,FOLLOW_Ident_in_ident774); 
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

	// Delegated rules



	public static final BitSet FOLLOW_25_in_form55 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ident_in_form57 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_27_in_form59 = new BitSet(new long[]{0x0000000004000040L});
	public static final BitSet FOLLOW_part_in_form62 = new BitSet(new long[]{0x0000000024000040L});
	public static final BitSet FOLLOW_29_in_form68 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifthen_in_part89 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_questions_in_part98 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_26_in_ifthen130 = new BitSet(new long[]{0x00000000000021D0L});
	public static final BitSet FOLLOW_expression_in_ifthen132 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_27_in_ifthen134 = new BitSet(new long[]{0x0000000004000040L});
	public static final BitSet FOLLOW_part_in_ifthen137 = new BitSet(new long[]{0x0000000024000040L});
	public static final BitSet FOLLOW_29_in_ifthen143 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ident_in_questions253 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_questions255 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_string_in_questions257 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_bool_in_questions259 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ident_in_questions267 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_questions269 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_string_in_questions271 = new BitSet(new long[]{0x00000000000001D0L});
	public static final BitSet FOLLOW_type_in_questions273 = new BitSet(new long[]{0x00000000000021D0L});
	public static final BitSet FOLLOW_expression_in_questions275 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_in_expression345 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_13_in_expression352 = new BitSet(new long[]{0x00000000000325D0L});
	public static final BitSet FOLLOW_orExpr_in_expression356 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_expression358 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_16_in_unExpr384 = new BitSet(new long[]{0x00000000000325D0L});
	public static final BitSet FOLLOW_unExpr_in_unExpr388 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_17_in_unExpr399 = new BitSet(new long[]{0x00000000000325D0L});
	public static final BitSet FOLLOW_unExpr_in_unExpr403 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_unExpr414 = new BitSet(new long[]{0x00000000000325D0L});
	public static final BitSet FOLLOW_unExpr_in_unExpr418 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_unExpr431 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr471 = new BitSet(new long[]{0x0000000000048002L});
	public static final BitSet FOLLOW_set_in_mulExpr479 = new BitSet(new long[]{0x00000000000325D0L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr491 = new BitSet(new long[]{0x0000000000048002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr526 = new BitSet(new long[]{0x0000000000030002L});
	public static final BitSet FOLLOW_set_in_addExpr534 = new BitSet(new long[]{0x00000000000325D0L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr544 = new BitSet(new long[]{0x0000000000030002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr583 = new BitSet(new long[]{0x0000000001F00802L});
	public static final BitSet FOLLOW_set_in_relExpr591 = new BitSet(new long[]{0x00000000000325D0L});
	public static final BitSet FOLLOW_addExpr_in_relExpr607 = new BitSet(new long[]{0x0000000001F00802L});
	public static final BitSet FOLLOW_relExpr_in_andExpr640 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_12_in_andExpr646 = new BitSet(new long[]{0x00000000000325D0L});
	public static final BitSet FOLLOW_relExpr_in_andExpr650 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr675 = new BitSet(new long[]{0x0000000010000002L});
	public static final BitSet FOLLOW_28_in_orExpr682 = new BitSet(new long[]{0x00000000000325D0L});
	public static final BitSet FOLLOW_andExpr_in_orExpr686 = new BitSet(new long[]{0x0000000010000002L});
	public static final BitSet FOLLOW_integer_in_type709 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ident_in_type717 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_bool_in_type725 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_string_in_type733 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Int_in_integer748 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_String_literal_in_string757 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Bool_in_bool766 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_ident774 = new BitSet(new long[]{0x0000000000000002L});
}
