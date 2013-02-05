// $ANTLR 3.5 C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g 2013-02-04 22:47:25

  package org.uva.sea.ql.parser;
  import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expr.*;
import org.uva.sea.ql.ast.expr.binary.*;
import org.uva.sea.ql.ast.expr.primary.*;
import org.uva.sea.ql.ast.expr.unary.*;
import org.uva.sea.ql.ast.stmt.*;
import org.uva.sea.ql.ast.stmt.question.*;
import org.uva.sea.ql.type.*;


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
		this.state.ruleMemo = new HashMap[41+1];


	}

	@Override public String[] getTokenNames() { return QLParser.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g"; }



	// $ANTLR start "form"
	// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:27:1: form returns [Form result] : 'form' Ident statements= block EOF ;
	public final Form form() throws RecognitionException {
		Form result = null;

		int form_StartIndex = input.index();

		Token Ident1=null;
		List<Statement> statements =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:28:3: ( 'form' Ident statements= block EOF )
			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:28:5: 'form' Ident statements= block EOF
			{
			match(input,32,FOLLOW_32_in_form56); if (state.failed) return result;
			Ident1=(Token)match(input,Ident,FOLLOW_Ident_in_form58); if (state.failed) return result;
			pushFollow(FOLLOW_block_in_form62);
			statements=block();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { 
				    result = new Form(new Ident((Ident1!=null?Ident1.getText():null)), statements); 
				  }
			match(input,EOF,FOLLOW_EOF_in_form69); if (state.failed) return result;
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
			match(input,35,FOLLOW_35_in_block97); if (state.failed) return result;
			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:39:9: (stmt= statement )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= Ident && LA1_0 <= If)) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:39:11: stmt= statement
					{
					pushFollow(FOLLOW_statement_in_block103);
					stmt=statement();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result.add(stmt); }
					}
					break;

				default :
					break loop1;
				}
			}

			match(input,37,FOLLOW_37_in_block110); if (state.failed) return result;
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
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==Ident) ) {
				alt2=1;
			}
			else if ( (LA2_0==If) ) {
				alt2=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:43:5: q= question
					{
					pushFollow(FOLLOW_question_in_statement131);
					q=question();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = q; }
					}
					break;
				case 2 :
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:44:5: i= ifStatement
					{
					pushFollow(FOLLOW_ifStatement_in_statement144);
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
			match(input,If,FOLLOW_If_in_ifStatement165); if (state.failed) return result;
			match(input,18,FOLLOW_18_in_ifStatement167); if (state.failed) return result;
			pushFollow(FOLLOW_orExpr_in_ifStatement171);
			condition=orExpr();
			state._fsp--;
			if (state.failed) return result;
			match(input,19,FOLLOW_19_in_ifStatement173); if (state.failed) return result;
			pushFollow(FOLLOW_block_in_ifStatement177);
			ifBlock=block();
			state._fsp--;
			if (state.failed) return result;
			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:49:5: ( ( Else )=> Else elseBlock= block | () )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==Else) && (synpred3_QL())) {
				alt3=1;
			}
			else if ( (LA3_0==EOF||(LA3_0 >= Ident && LA3_0 <= If)||LA3_0==37) ) {
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
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:49:7: ( Else )=> Else elseBlock= block
					{
					match(input,Else,FOLLOW_Else_in_ifStatement190); if (state.failed) return result;
					pushFollow(FOLLOW_block_in_ifStatement194);
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
			        result = new IfThen(condition, ifBlock);
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
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==Ident) ) {
				int LA6_1 = input.LA(2);
				if ( (LA6_1==24) ) {
					int LA6_2 = input.LA(3);
					if ( (LA6_2==String) ) {
						switch ( input.LA(4) ) {
						case 34:
							{
							int LA6_4 = input.LA(5);
							if ( (LA6_4==EOF||(LA6_4 >= Ident && LA6_4 <= If)||LA6_4==25||LA6_4==37) ) {
								alt6=1;
							}
							else if ( (LA6_4==18) ) {
								alt6=2;
							}

							else {
								if (state.backtracking>0) {state.failed=true; return result;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 6, 4, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

							}
							break;
						case 31:
							{
							int LA6_5 = input.LA(5);
							if ( (LA6_5==EOF||(LA6_5 >= Ident && LA6_5 <= If)||LA6_5==25||LA6_5==37) ) {
								alt6=1;
							}
							else if ( (LA6_5==18) ) {
								alt6=2;
							}

							else {
								if (state.backtracking>0) {state.failed=true; return result;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 6, 5, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

							}
							break;
						case 33:
							{
							int LA6_6 = input.LA(5);
							if ( (LA6_6==EOF||(LA6_6 >= Ident && LA6_6 <= If)||LA6_6==25||LA6_6==37) ) {
								alt6=1;
							}
							else if ( (LA6_6==18) ) {
								alt6=2;
							}

							else {
								if (state.backtracking>0) {state.failed=true; return result;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 6, 6, input);
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
									new NoViableAltException("", 6, 3, input);
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
								new NoViableAltException("", 6, 2, input);
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
							new NoViableAltException("", 6, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}

			switch (alt6) {
				case 1 :
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:62:5: Ident ':' String tp= type ( ';' )?
					{
					Ident2=(Token)match(input,Ident,FOLLOW_Ident_in_question236); if (state.failed) return result;
					match(input,24,FOLLOW_24_in_question238); if (state.failed) return result;
					String3=(Token)match(input,String,FOLLOW_String_in_question240); if (state.failed) return result;
					pushFollow(FOLLOW_type_in_question244);
					tp=type();
					state._fsp--;
					if (state.failed) return result;
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:62:30: ( ';' )?
					int alt4=2;
					int LA4_0 = input.LA(1);
					if ( (LA4_0==25) ) {
						alt4=1;
					}
					switch (alt4) {
						case 1 :
							// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:62:31: ';'
							{
							match(input,25,FOLLOW_25_in_question247); if (state.failed) return result;
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
					Ident4=(Token)match(input,Ident,FOLLOW_Ident_in_question259); if (state.failed) return result;
					match(input,24,FOLLOW_24_in_question261); if (state.failed) return result;
					String5=(Token)match(input,String,FOLLOW_String_in_question263); if (state.failed) return result;
					pushFollow(FOLLOW_type_in_question267);
					tp=type();
					state._fsp--;
					if (state.failed) return result;
					pushFollow(FOLLOW_computation_in_question271);
					cp=computation();
					state._fsp--;
					if (state.failed) return result;
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:66:45: ( ';' )?
					int alt5=2;
					int LA5_0 = input.LA(1);
					if ( (LA5_0==25) ) {
						alt5=1;
					}
					switch (alt5) {
						case 1 :
							// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:66:46: ';'
							{
							match(input,25,FOLLOW_25_in_question274); if (state.failed) return result;
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
			int alt7=3;
			switch ( input.LA(1) ) {
			case 34:
				{
				alt7=1;
				}
				break;
			case 31:
				{
				alt7=2;
				}
				break;
			case 33:
				{
				alt7=3;
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
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:73:5: 'string'
					{
					match(input,34,FOLLOW_34_in_type297); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new StringType(); }
					}
					break;
				case 2 :
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:74:5: 'boolean'
					{
					match(input,31,FOLLOW_31_in_type307); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new BooleanType(); }
					}
					break;
				case 3 :
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:75:5: 'integer'
					{
					match(input,33,FOLLOW_33_in_type315); if (state.failed) return result;
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
			match(input,18,FOLLOW_18_in_computation336); if (state.failed) return result;
			pushFollow(FOLLOW_orExpr_in_computation340);
			expr=orExpr();
			state._fsp--;
			if (state.failed) return result;
			match(input,19,FOLLOW_19_in_computation342); if (state.failed) return result;
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
			int alt8=5;
			switch ( input.LA(1) ) {
			case Int:
				{
				alt8=1;
				}
				break;
			case Ident:
				{
				alt8=2;
				}
				break;
			case Bool:
				{
				alt8=3;
				}
				break;
			case String:
				{
				alt8=4;
				}
				break;
			case 18:
				{
				alt8=5;
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
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:83:5: Int
					{
					Int6=(Token)match(input,Int,FOLLOW_Int_in_primary361); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Int(Integer.parseInt((Int6!=null?Int6.getText():null))); }
					}
					break;
				case 2 :
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:84:5: Ident
					{
					Ident7=(Token)match(input,Ident,FOLLOW_Ident_in_primary373); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Ident((Ident7!=null?Ident7.getText():null)); }
					}
					break;
				case 3 :
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:85:5: Bool
					{
					Bool8=(Token)match(input,Bool,FOLLOW_Bool_in_primary383); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Bool(Boolean.parseBoolean((Bool8!=null?Bool8.getText():null))); }
					}
					break;
				case 4 :
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:86:5: String
					{
					String9=(Token)match(input,String,FOLLOW_String_in_primary394); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new StringLiteral((String9!=null?String9.getText():null)); }
					}
					break;
				case 5 :
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:87:5: '(' x= orExpr ')'
					{
					match(input,18,FOLLOW_18_in_primary403); if (state.failed) return result;
					pushFollow(FOLLOW_orExpr_in_primary407);
					x=orExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,19,FOLLOW_19_in_primary409); if (state.failed) return result;
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
			int alt9=4;
			switch ( input.LA(1) ) {
			case 21:
				{
				alt9=1;
				}
				break;
			case 22:
				{
				alt9=2;
				}
				break;
			case 15:
				{
				alt9=3;
				}
				break;
			case Bool:
			case Ident:
			case Int:
			case String:
			case 18:
				{
				alt9=4;
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
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:91:6: '+' x= unExpr
					{
					match(input,21,FOLLOW_21_in_unExpr433); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr437);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Pos(x); }
					}
					break;
				case 2 :
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:92:6: '-' x= unExpr
					{
					match(input,22,FOLLOW_22_in_unExpr446); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr450);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Neg(x); }
					}
					break;
				case 3 :
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:93:6: '!' x= unExpr
					{
					match(input,15,FOLLOW_15_in_unExpr459); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr463);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Not(x); }
					}
					break;
				case 4 :
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:94:6: x= primary
					{
					pushFollow(FOLLOW_primary_in_unExpr474);
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
			pushFollow(FOLLOW_unExpr_in_mulExpr508);
			lhs=unExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:98:43: (op= ( '*' | '/' ) rhs= unExpr )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==20||LA10_0==23) ) {
					alt10=1;
				}

				switch (alt10) {
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
					pushFollow(FOLLOW_unExpr_in_mulExpr528);
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
			pushFollow(FOLLOW_mulExpr_in_addExpr563);
			lhs=mulExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:111:44: (op= ( '+' | '-' ) rhs= mulExpr )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( ((LA11_0 >= 21 && LA11_0 <= 22)) ) {
					alt11=1;
				}

				switch (alt11) {
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
					pushFollow(FOLLOW_mulExpr_in_addExpr581);
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
			pushFollow(FOLLOW_addExpr_in_relExpr611);
			lhs=addExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:123:44: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( (LA12_0==16||(LA12_0 >= 26 && LA12_0 <= 30)) ) {
					alt12=1;
				}

				switch (alt12) {
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
					pushFollow(FOLLOW_addExpr_in_relExpr635);
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
			pushFollow(FOLLOW_relExpr_in_andExpr667);
			lhs=relExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:147:44: ( '&&' rhs= relExpr )*
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0==17) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:147:46: '&&' rhs= relExpr
					{
					match(input,17,FOLLOW_17_in_andExpr673); if (state.failed) return result;
					pushFollow(FOLLOW_relExpr_in_andExpr677);
					rhs=relExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new And(result, rhs); }
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
			pushFollow(FOLLOW_andExpr_in_orExpr708);
			lhs=andExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = lhs; }
			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:152:46: ( '||' rhs= andExpr )*
			loop14:
			while (true) {
				int alt14=2;
				int LA14_0 = input.LA(1);
				if ( (LA14_0==36) ) {
					alt14=1;
				}

				switch (alt14) {
				case 1 :
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:152:48: '||' rhs= andExpr
					{
					match(input,36,FOLLOW_36_in_orExpr714); if (state.failed) return result;
					pushFollow(FOLLOW_andExpr_in_orExpr718);
					rhs=andExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Or(result, rhs); }
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
			if ( state.backtracking>0 ) { memoize(input, 14, orExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "orExpr"

	// $ANTLR start synpred3_QL
	public final void synpred3_QL_fragment() throws RecognitionException {
		// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:49:7: ( Else )
		// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:49:8: Else
		{
		match(input,Else,FOLLOW_Else_in_synpred3_QL186); if (state.failed) return;
		}

	}
	// $ANTLR end synpred3_QL

	// Delegated rules

	public final boolean synpred3_QL() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred3_QL_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}



	public static final BitSet FOLLOW_32_in_form56 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Ident_in_form58 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_block_in_form62 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_form69 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_35_in_block97 = new BitSet(new long[]{0x0000002000000180L});
	public static final BitSet FOLLOW_statement_in_block103 = new BitSet(new long[]{0x0000002000000180L});
	public static final BitSet FOLLOW_37_in_block110 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_question_in_statement131 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifStatement_in_statement144 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_If_in_ifStatement165 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_18_in_ifStatement167 = new BitSet(new long[]{0x000000000064A290L});
	public static final BitSet FOLLOW_orExpr_in_ifStatement171 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_ifStatement173 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_block_in_ifStatement177 = new BitSet(new long[]{0x0000000000000042L});
	public static final BitSet FOLLOW_Else_in_ifStatement190 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_block_in_ifStatement194 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_question236 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_24_in_question238 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_String_in_question240 = new BitSet(new long[]{0x0000000680000000L});
	public static final BitSet FOLLOW_type_in_question244 = new BitSet(new long[]{0x0000000002000002L});
	public static final BitSet FOLLOW_25_in_question247 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_question259 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_24_in_question261 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_String_in_question263 = new BitSet(new long[]{0x0000000680000000L});
	public static final BitSet FOLLOW_type_in_question267 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_computation_in_question271 = new BitSet(new long[]{0x0000000002000002L});
	public static final BitSet FOLLOW_25_in_question274 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_34_in_type297 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_31_in_type307 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_33_in_type315 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_18_in_computation336 = new BitSet(new long[]{0x000000000064A290L});
	public static final BitSet FOLLOW_orExpr_in_computation340 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_computation342 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Int_in_primary361 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_primary373 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Bool_in_primary383 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_String_in_primary394 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_18_in_primary403 = new BitSet(new long[]{0x000000000064A290L});
	public static final BitSet FOLLOW_orExpr_in_primary407 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_primary409 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_21_in_unExpr433 = new BitSet(new long[]{0x000000000064A290L});
	public static final BitSet FOLLOW_unExpr_in_unExpr437 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_22_in_unExpr446 = new BitSet(new long[]{0x000000000064A290L});
	public static final BitSet FOLLOW_unExpr_in_unExpr450 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_15_in_unExpr459 = new BitSet(new long[]{0x000000000064A290L});
	public static final BitSet FOLLOW_unExpr_in_unExpr463 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpr474 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr508 = new BitSet(new long[]{0x0000000000900002L});
	public static final BitSet FOLLOW_set_in_mulExpr516 = new BitSet(new long[]{0x000000000064A290L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr528 = new BitSet(new long[]{0x0000000000900002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr563 = new BitSet(new long[]{0x0000000000600002L});
	public static final BitSet FOLLOW_set_in_addExpr571 = new BitSet(new long[]{0x000000000064A290L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr581 = new BitSet(new long[]{0x0000000000600002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr611 = new BitSet(new long[]{0x000000007C010002L});
	public static final BitSet FOLLOW_set_in_relExpr619 = new BitSet(new long[]{0x000000000064A290L});
	public static final BitSet FOLLOW_addExpr_in_relExpr635 = new BitSet(new long[]{0x000000007C010002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr667 = new BitSet(new long[]{0x0000000000020002L});
	public static final BitSet FOLLOW_17_in_andExpr673 = new BitSet(new long[]{0x000000000064A290L});
	public static final BitSet FOLLOW_relExpr_in_andExpr677 = new BitSet(new long[]{0x0000000000020002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr708 = new BitSet(new long[]{0x0000001000000002L});
	public static final BitSet FOLLOW_36_in_orExpr714 = new BitSet(new long[]{0x000000000064A290L});
	public static final BitSet FOLLOW_andExpr_in_orExpr718 = new BitSet(new long[]{0x0000001000000002L});
	public static final BitSet FOLLOW_Else_in_synpred3_QL186 = new BitSet(new long[]{0x0000000000000002L});
}
