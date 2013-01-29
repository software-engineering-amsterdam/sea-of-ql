// $ANTLR 3.5 C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g 2013-01-29 14:21:24

  package org.uva.sea.ql.parser;
  import org.uva.sea.ql.ast.*;
  import org.uva.sea.ql.ast.expr.*;
  import org.uva.sea.ql.ast.expr.binary.*;
  import org.uva.sea.ql.ast.expr.primary.*;
  import org.uva.sea.ql.ast.expr.unary.*;
  import org.uva.sea.ql.ast.type.*;
  import org.uva.sea.ql.ast.stmt.*;
  import org.uva.sea.ql.ast.stmt.question.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings("all")
public class QLParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "Bool", "Digit", "Else", "Ident", 
		"If", "Int", "Letter", "MComment", "SComment", "String", "WS", "'!'", 
		"'!='", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", "'/'", "':'", "';'", 
		"'<'", "'<='", "'=='", "'>'", "'>='", "'boolean'", "'form'", "'integer'", 
		"'string'", "'{'", "'||'", "'}'"
	};
	public static final int EOF=-1;
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
	public static final int T__36=36;
	public static final int T__37=37;
	public static final int Bool=4;
	public static final int Digit=5;
	public static final int Else=6;
	public static final int Ident=7;
	public static final int If=8;
	public static final int Int=9;
	public static final int Letter=10;
	public static final int MComment=11;
	public static final int SComment=12;
	public static final int String=13;
	public static final int WS=14;

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
		this.state.ruleMemo = new HashMap[42+1];


	}

	@Override public String[] getTokenNames() { return QLParser.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g"; }



	// $ANTLR start "form"
	// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:27:1: form returns [Form result] : ( 'form' Ident statements= block )+ EOF ;
	public final Form form() throws RecognitionException {
		Form result = null;

		int form_StartIndex = input.index();

		Token Ident1=null;
		List<Statement> statements =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:28:3: ( ( 'form' Ident statements= block )+ EOF )
			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:28:5: ( 'form' Ident statements= block )+ EOF
			{
			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:28:5: ( 'form' Ident statements= block )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==32) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:28:6: 'form' Ident statements= block
					{
					match(input,32,FOLLOW_32_in_form57); if (state.failed) return result;
					Ident1=(Token)match(input,Ident,FOLLOW_Ident_in_form59); if (state.failed) return result;
					pushFollow(FOLLOW_block_in_form63);
					statements=block();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { 
						    result = new Form(new Ident((Ident1!=null?Ident1.getText():null)), statements); 
						  }
					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					if (state.backtracking>0) {state.failed=true; return result;}
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			match(input,EOF,FOLLOW_EOF_in_form72); if (state.failed) return result;
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



	// $ANTLR start "block"
	// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:34:1: block returns [List<Statement> result] : '{' (stmt= statement )* '}' ;
	public final List<Statement> block() throws RecognitionException {
		List<Statement> result = null;

		int block_StartIndex = input.index();

		Statement stmt =null;


		      result = new ArrayList<Statement>();
		    
		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:39:3: ( '{' (stmt= statement )* '}' )
			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:39:5: '{' (stmt= statement )* '}'
			{
			match(input,35,FOLLOW_35_in_block100); if (state.failed) return result;
			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:39:9: (stmt= statement )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= Ident && LA2_0 <= If)) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:39:11: stmt= statement
					{
					pushFollow(FOLLOW_statement_in_block106);
					stmt=statement();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result.add(stmt); }
					}
					break;

				default :
					break loop2;
				}
			}

			match(input,37,FOLLOW_37_in_block113); if (state.failed) return result;
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 2, block_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "block"



	// $ANTLR start "statement"
	// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:42:1: statement returns [Statement result] : (q= question |i= ifStatement );
	public final Statement statement() throws RecognitionException {
		Statement result = null;

		int statement_StartIndex = input.index();

		Statement q =null;
		Statement i =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:43:3: (q= question |i= ifStatement )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==Ident) ) {
				alt3=1;
			}
			else if ( (LA3_0==If) ) {
				alt3=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:43:5: q= question
					{
					pushFollow(FOLLOW_question_in_statement134);
					q=question();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = q; }
					}
					break;
				case 2 :
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:44:5: i= ifStatement
					{
					pushFollow(FOLLOW_ifStatement_in_statement147);
					i=ifStatement();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = i; }
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



	// $ANTLR start "ifStatement"
	// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:47:1: ifStatement returns [Statement result] : If '(' condition= orExpr ')' ifBlock= block ( ( Else )=> Else elseBlock= block | () ) ;
	public final Statement ifStatement() throws RecognitionException {
		Statement result = null;

		int ifStatement_StartIndex = input.index();

		Expr condition =null;
		List<Statement> ifBlock =null;
		List<Statement> elseBlock =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:48:3: ( If '(' condition= orExpr ')' ifBlock= block ( ( Else )=> Else elseBlock= block | () ) )
			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:48:5: If '(' condition= orExpr ')' ifBlock= block ( ( Else )=> Else elseBlock= block | () )
			{
			match(input,If,FOLLOW_If_in_ifStatement168); if (state.failed) return result;
			match(input,18,FOLLOW_18_in_ifStatement170); if (state.failed) return result;
			pushFollow(FOLLOW_orExpr_in_ifStatement174);
			condition=orExpr();
			state._fsp--;
			if (state.failed) return result;
			match(input,19,FOLLOW_19_in_ifStatement176); if (state.failed) return result;
			pushFollow(FOLLOW_block_in_ifStatement180);
			ifBlock=block();
			state._fsp--;
			if (state.failed) return result;
			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:49:5: ( ( Else )=> Else elseBlock= block | () )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==Else) && (synpred4_QL())) {
				alt4=1;
			}
			else if ( (LA4_0==EOF||(LA4_0 >= Ident && LA4_0 <= If)||LA4_0==37) ) {
				alt4=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:49:7: ( Else )=> Else elseBlock= block
					{
					match(input,Else,FOLLOW_Else_in_ifStatement193); if (state.failed) return result;
					pushFollow(FOLLOW_block_in_ifStatement197);
					elseBlock=block();
					state._fsp--;
					if (state.failed) return result;
					}
					break;
				case 2 :
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:50:7: ()
					{
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:50:7: ()
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:50:9: 
					{
					}

					}
					break;

			}

			if ( state.backtracking==0 ) {
			      if (elseBlock != null) {
			        result = new IfThenElse(condition, ifBlock, elseBlock);
			      } else {
			        result = new IfThenElse(condition, ifBlock);
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
			if ( state.backtracking>0 ) { memoize(input, 4, ifStatement_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "ifStatement"



	// $ANTLR start "question"
	// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:61:1: question returns [Statement result] : ( Ident ':' String tp= type ( ';' )? | Ident ':' String tp= type cp= computation ( ';' )? );
	public final Statement question() throws RecognitionException {
		Statement result = null;

		int question_StartIndex = input.index();

		Token Ident2=null;
		Token String3=null;
		Token Ident4=null;
		Token String5=null;
		Type tp =null;
		Expr cp =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:62:3: ( Ident ':' String tp= type ( ';' )? | Ident ':' String tp= type cp= computation ( ';' )? )
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==Ident) ) {
				int LA7_1 = input.LA(2);
				if ( (LA7_1==24) ) {
					int LA7_2 = input.LA(3);
					if ( (LA7_2==String) ) {
						switch ( input.LA(4) ) {
						case 34:
							{
							int LA7_4 = input.LA(5);
							if ( (LA7_4==EOF||(LA7_4 >= Ident && LA7_4 <= If)||LA7_4==25||LA7_4==37) ) {
								alt7=1;
							}
							else if ( (LA7_4==18) ) {
								alt7=2;
							}

							else {
								if (state.backtracking>0) {state.failed=true; return result;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 7, 4, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

							}
							break;
						case 31:
							{
							int LA7_5 = input.LA(5);
							if ( (LA7_5==EOF||(LA7_5 >= Ident && LA7_5 <= If)||LA7_5==25||LA7_5==37) ) {
								alt7=1;
							}
							else if ( (LA7_5==18) ) {
								alt7=2;
							}

							else {
								if (state.backtracking>0) {state.failed=true; return result;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 7, 5, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

							}
							break;
						case 33:
							{
							int LA7_6 = input.LA(5);
							if ( (LA7_6==EOF||(LA7_6 >= Ident && LA7_6 <= If)||LA7_6==25||LA7_6==37) ) {
								alt7=1;
							}
							else if ( (LA7_6==18) ) {
								alt7=2;
							}

							else {
								if (state.backtracking>0) {state.failed=true; return result;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 7, 6, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

							}
							break;
						default:
							if (state.backtracking>0) {state.failed=true; return result;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 7, 3, input);
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
								new NoViableAltException("", 7, 2, input);
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
							new NoViableAltException("", 7, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}

			switch (alt7) {
				case 1 :
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:62:5: Ident ':' String tp= type ( ';' )?
					{
					Ident2=(Token)match(input,Ident,FOLLOW_Ident_in_question239); if (state.failed) return result;
					match(input,24,FOLLOW_24_in_question241); if (state.failed) return result;
					String3=(Token)match(input,String,FOLLOW_String_in_question243); if (state.failed) return result;
					pushFollow(FOLLOW_type_in_question247);
					tp=type();
					state._fsp--;
					if (state.failed) return result;
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:62:30: ( ';' )?
					int alt5=2;
					int LA5_0 = input.LA(1);
					if ( (LA5_0==25) ) {
						alt5=1;
					}
					switch (alt5) {
						case 1 :
							// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:62:31: ';'
							{
							match(input,25,FOLLOW_25_in_question250); if (state.failed) return result;
							}
							break;

					}

					if ( state.backtracking==0 ) { 
					    result = new NormalQuestion(new Ident((Ident2!=null?Ident2.getText():null)), (String3!=null?String3.getText():null), tp); 
					  }
					}
					break;
				case 2 :
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:66:5: Ident ':' String tp= type cp= computation ( ';' )?
					{
					Ident4=(Token)match(input,Ident,FOLLOW_Ident_in_question262); if (state.failed) return result;
					match(input,24,FOLLOW_24_in_question264); if (state.failed) return result;
					String5=(Token)match(input,String,FOLLOW_String_in_question266); if (state.failed) return result;
					pushFollow(FOLLOW_type_in_question270);
					tp=type();
					state._fsp--;
					if (state.failed) return result;
					pushFollow(FOLLOW_computation_in_question274);
					cp=computation();
					state._fsp--;
					if (state.failed) return result;
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:66:45: ( ';' )?
					int alt6=2;
					int LA6_0 = input.LA(1);
					if ( (LA6_0==25) ) {
						alt6=1;
					}
					switch (alt6) {
						case 1 :
							// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:66:46: ';'
							{
							match(input,25,FOLLOW_25_in_question277); if (state.failed) return result;
							}
							break;

					}

					if ( state.backtracking==0 ) { 
					    result = new ComputedQuestion(new Ident((Ident4!=null?Ident4.getText():null)), (String5!=null?String5.getText():null), tp, cp); 
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
			if ( state.backtracking>0 ) { memoize(input, 5, question_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "question"



	// $ANTLR start "type"
	// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:72:1: type returns [Type result] : ( 'string' | 'boolean' | 'integer' );
	public final Type type() throws RecognitionException {
		Type result = null;

		int type_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:73:3: ( 'string' | 'boolean' | 'integer' )
			int alt8=3;
			switch ( input.LA(1) ) {
			case 34:
				{
				alt8=1;
				}
				break;
			case 31:
				{
				alt8=2;
				}
				break;
			case 33:
				{
				alt8=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}
			switch (alt8) {
				case 1 :
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:73:5: 'string'
					{
					match(input,34,FOLLOW_34_in_type300); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new StringType(); }
					}
					break;
				case 2 :
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:74:5: 'boolean'
					{
					match(input,31,FOLLOW_31_in_type310); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new BooleanType(); }
					}
					break;
				case 3 :
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:75:5: 'integer'
					{
					match(input,33,FOLLOW_33_in_type318); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new IntegerType(); }
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
			if ( state.backtracking>0 ) { memoize(input, 6, type_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "type"



	// $ANTLR start "computation"
	// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:78:1: computation returns [Expr result] : '(' expr= orExpr ')' ;
	public final Expr computation() throws RecognitionException {
		Expr result = null;

		int computation_StartIndex = input.index();

		Expr expr =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:79:3: ( '(' expr= orExpr ')' )
			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:79:5: '(' expr= orExpr ')'
			{
			match(input,18,FOLLOW_18_in_computation339); if (state.failed) return result;
			pushFollow(FOLLOW_orExpr_in_computation343);
			expr=orExpr();
			state._fsp--;
			if (state.failed) return result;
			match(input,19,FOLLOW_19_in_computation345); if (state.failed) return result;
			if ( state.backtracking==0 ) { result = expr; }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 7, computation_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "computation"



	// $ANTLR start "primary"
	// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:82:1: primary returns [Expr result] : ( Int | Ident | Bool | String | '(' x= orExpr ')' );
	public final Expr primary() throws RecognitionException {
		Expr result = null;

		int primary_StartIndex = input.index();

		Token Int6=null;
		Token Ident7=null;
		Token Bool8=null;
		Token String9=null;
		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:83:3: ( Int | Ident | Bool | String | '(' x= orExpr ')' )
			int alt9=5;
			switch ( input.LA(1) ) {
			case Int:
				{
				alt9=1;
				}
				break;
			case Ident:
				{
				alt9=2;
				}
				break;
			case Bool:
				{
				alt9=3;
				}
				break;
			case String:
				{
				alt9=4;
				}
				break;
			case 18:
				{
				alt9=5;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}
			switch (alt9) {
				case 1 :
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:83:5: Int
					{
					Int6=(Token)match(input,Int,FOLLOW_Int_in_primary364); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Int(Integer.parseInt((Int6!=null?Int6.getText():null))); }
					}
					break;
				case 2 :
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:84:5: Ident
					{
					Ident7=(Token)match(input,Ident,FOLLOW_Ident_in_primary376); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Ident((Ident7!=null?Ident7.getText():null)); }
					}
					break;
				case 3 :
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:85:5: Bool
					{
					Bool8=(Token)match(input,Bool,FOLLOW_Bool_in_primary386); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Bool(Boolean.parseBoolean((Bool8!=null?Bool8.getText():null))); }
					}
					break;
				case 4 :
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:86:5: String
					{
					String9=(Token)match(input,String,FOLLOW_String_in_primary397); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new StringLiteral((String9!=null?String9.getText():null)); }
					}
					break;
				case 5 :
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:87:5: '(' x= orExpr ')'
					{
					match(input,18,FOLLOW_18_in_primary406); if (state.failed) return result;
					pushFollow(FOLLOW_orExpr_in_primary410);
					x=orExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,19,FOLLOW_19_in_primary412); if (state.failed) return result;
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
			if ( state.backtracking>0 ) { memoize(input, 8, primary_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "primary"



	// $ANTLR start "unExpr"
	// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:90:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
	public final Expr unExpr() throws RecognitionException {
		Expr result = null;

		int unExpr_StartIndex = input.index();

		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:91:3: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
			int alt10=4;
			switch ( input.LA(1) ) {
			case 21:
				{
				alt10=1;
				}
				break;
			case 22:
				{
				alt10=2;
				}
				break;
			case 15:
				{
				alt10=3;
				}
				break;
			case Bool:
			case Ident:
			case Int:
			case String:
			case 18:
				{
				alt10=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}
			switch (alt10) {
				case 1 :
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:91:6: '+' x= unExpr
					{
					match(input,21,FOLLOW_21_in_unExpr436); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr440);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Pos(x); }
					}
					break;
				case 2 :
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:92:6: '-' x= unExpr
					{
					match(input,22,FOLLOW_22_in_unExpr449); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr453);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Neg(x); }
					}
					break;
				case 3 :
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:93:6: '!' x= unExpr
					{
					match(input,15,FOLLOW_15_in_unExpr462); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr466);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Not(x); }
					}
					break;
				case 4 :
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:94:6: x= primary
					{
					pushFollow(FOLLOW_primary_in_unExpr477);
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
			if ( state.backtracking>0 ) { memoize(input, 9, unExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "unExpr"



	// $ANTLR start "mulExpr"
	// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:97:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
	public final Expr mulExpr() throws RecognitionException {
		Expr result = null;

		int mulExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:98:3: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:98:7: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
			{
			pushFollow(FOLLOW_unExpr_in_mulExpr511);
			lhs=unExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:98:43: (op= ( '*' | '/' ) rhs= unExpr )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==20||LA11_0==23) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:98:45: op= ( '*' | '/' ) rhs= unExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==20||input.LA(1)==23 ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_unExpr_in_mulExpr531);
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
			if ( state.backtracking>0 ) { memoize(input, 10, mulExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "mulExpr"



	// $ANTLR start "addExpr"
	// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:110:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
	public final Expr addExpr() throws RecognitionException {
		Expr result = null;

		int addExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:111:3: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:111:7: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
			{
			pushFollow(FOLLOW_mulExpr_in_addExpr566);
			lhs=mulExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:111:44: (op= ( '+' | '-' ) rhs= mulExpr )*
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( ((LA12_0 >= 21 && LA12_0 <= 22)) ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:111:46: op= ( '+' | '-' ) rhs= mulExpr
					{
					op=input.LT(1);
					if ( (input.LA(1) >= 21 && input.LA(1) <= 22) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_mulExpr_in_addExpr584);
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
			if ( state.backtracking>0 ) { memoize(input, 11, addExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "addExpr"



	// $ANTLR start "relExpr"
	// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:122:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
	public final Expr relExpr() throws RecognitionException {
		Expr result = null;

		int relExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }

			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:123:3: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:123:7: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			{
			pushFollow(FOLLOW_addExpr_in_relExpr614);
			lhs=addExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:123:44: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0==16||(LA13_0 >= 26 && LA13_0 <= 30)) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:123:46: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==16||(input.LA(1) >= 26 && input.LA(1) <= 30) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_addExpr_in_relExpr638);
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
					break loop13;
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
			if ( state.backtracking>0 ) { memoize(input, 12, relExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "relExpr"



	// $ANTLR start "andExpr"
	// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:146:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
	public final Expr andExpr() throws RecognitionException {
		Expr result = null;

		int andExpr_StartIndex = input.index();

		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return result; }

			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:147:3: (lhs= relExpr ( '&&' rhs= relExpr )* )
			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:147:7: lhs= relExpr ( '&&' rhs= relExpr )*
			{
			pushFollow(FOLLOW_relExpr_in_andExpr670);
			lhs=relExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:147:44: ( '&&' rhs= relExpr )*
			loop14:
			while (true) {
				int alt14=2;
				int LA14_0 = input.LA(1);
				if ( (LA14_0==17) ) {
					alt14=1;
				}

				switch (alt14) {
				case 1 :
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:147:46: '&&' rhs= relExpr
					{
					match(input,17,FOLLOW_17_in_andExpr676); if (state.failed) return result;
					pushFollow(FOLLOW_relExpr_in_andExpr680);
					rhs=relExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new And(result, rhs); }
					}
					break;

				default :
					break loop14;
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
			if ( state.backtracking>0 ) { memoize(input, 13, andExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "andExpr"



	// $ANTLR start "orExpr"
	// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:151:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
	public final Expr orExpr() throws RecognitionException {
		Expr result = null;

		int orExpr_StartIndex = input.index();

		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return result; }

			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:152:3: (lhs= andExpr ( '||' rhs= andExpr )* )
			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:152:7: lhs= andExpr ( '||' rhs= andExpr )*
			{
			pushFollow(FOLLOW_andExpr_in_orExpr711);
			lhs=andExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = lhs; }
			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:152:46: ( '||' rhs= andExpr )*
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( (LA15_0==36) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:152:48: '||' rhs= andExpr
					{
					match(input,36,FOLLOW_36_in_orExpr717); if (state.failed) return result;
					pushFollow(FOLLOW_andExpr_in_orExpr721);
					rhs=andExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Or(result, rhs); }
					}
					break;

				default :
					break loop15;
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
			if ( state.backtracking>0 ) { memoize(input, 14, orExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "orExpr"

	// $ANTLR start synpred4_QL
	public final void synpred4_QL_fragment() throws RecognitionException {
		// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:49:7: ( Else )
		// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:49:8: Else
		{
		match(input,Else,FOLLOW_Else_in_synpred4_QL189); if (state.failed) return;
		}

	}
	// $ANTLR end synpred4_QL

	// Delegated rules

	public final boolean synpred4_QL() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred4_QL_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}



	public static final BitSet FOLLOW_32_in_form57 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Ident_in_form59 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_block_in_form63 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_EOF_in_form72 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_35_in_block100 = new BitSet(new long[]{0x0000002000000180L});
	public static final BitSet FOLLOW_statement_in_block106 = new BitSet(new long[]{0x0000002000000180L});
	public static final BitSet FOLLOW_37_in_block113 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_question_in_statement134 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifStatement_in_statement147 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_If_in_ifStatement168 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_18_in_ifStatement170 = new BitSet(new long[]{0x000000000064A290L});
	public static final BitSet FOLLOW_orExpr_in_ifStatement174 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_ifStatement176 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_block_in_ifStatement180 = new BitSet(new long[]{0x0000000000000042L});
	public static final BitSet FOLLOW_Else_in_ifStatement193 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_block_in_ifStatement197 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_question239 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_24_in_question241 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_String_in_question243 = new BitSet(new long[]{0x0000000680000000L});
	public static final BitSet FOLLOW_type_in_question247 = new BitSet(new long[]{0x0000000002000002L});
	public static final BitSet FOLLOW_25_in_question250 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_question262 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_24_in_question264 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_String_in_question266 = new BitSet(new long[]{0x0000000680000000L});
	public static final BitSet FOLLOW_type_in_question270 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_computation_in_question274 = new BitSet(new long[]{0x0000000002000002L});
	public static final BitSet FOLLOW_25_in_question277 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_34_in_type300 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_31_in_type310 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_33_in_type318 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_18_in_computation339 = new BitSet(new long[]{0x000000000064A290L});
	public static final BitSet FOLLOW_orExpr_in_computation343 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_computation345 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Int_in_primary364 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_primary376 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Bool_in_primary386 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_String_in_primary397 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_18_in_primary406 = new BitSet(new long[]{0x000000000064A290L});
	public static final BitSet FOLLOW_orExpr_in_primary410 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_primary412 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_21_in_unExpr436 = new BitSet(new long[]{0x000000000064A290L});
	public static final BitSet FOLLOW_unExpr_in_unExpr440 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_22_in_unExpr449 = new BitSet(new long[]{0x000000000064A290L});
	public static final BitSet FOLLOW_unExpr_in_unExpr453 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_15_in_unExpr462 = new BitSet(new long[]{0x000000000064A290L});
	public static final BitSet FOLLOW_unExpr_in_unExpr466 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpr477 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr511 = new BitSet(new long[]{0x0000000000900002L});
	public static final BitSet FOLLOW_set_in_mulExpr519 = new BitSet(new long[]{0x000000000064A290L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr531 = new BitSet(new long[]{0x0000000000900002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr566 = new BitSet(new long[]{0x0000000000600002L});
	public static final BitSet FOLLOW_set_in_addExpr574 = new BitSet(new long[]{0x000000000064A290L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr584 = new BitSet(new long[]{0x0000000000600002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr614 = new BitSet(new long[]{0x000000007C010002L});
	public static final BitSet FOLLOW_set_in_relExpr622 = new BitSet(new long[]{0x000000000064A290L});
	public static final BitSet FOLLOW_addExpr_in_relExpr638 = new BitSet(new long[]{0x000000007C010002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr670 = new BitSet(new long[]{0x0000000000020002L});
	public static final BitSet FOLLOW_17_in_andExpr676 = new BitSet(new long[]{0x000000000064A290L});
	public static final BitSet FOLLOW_relExpr_in_andExpr680 = new BitSet(new long[]{0x0000000000020002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr711 = new BitSet(new long[]{0x0000001000000002L});
	public static final BitSet FOLLOW_36_in_orExpr717 = new BitSet(new long[]{0x000000000064A290L});
	public static final BitSet FOLLOW_andExpr_in_orExpr721 = new BitSet(new long[]{0x0000001000000002L});
	public static final BitSet FOLLOW_Else_in_synpred4_QL189 = new BitSet(new long[]{0x0000000000000002L});
}
