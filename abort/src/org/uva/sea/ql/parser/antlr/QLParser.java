// $ANTLR 3.5 /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g 2013-01-13 16:22:04

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
		"COMMENT", "ELSE", "EscapedCharacterSequence", "FORM", "IF", "Ident", 
		"Int", "Money", "PARENTHESES_CLOSE", "PARENTHESES_OPEN", "String", "Type", 
		"WS", "'!'", "'!='", "'&&'", "'*'", "'+'", "'-'", "'/'", "':'", "'<'", 
		"'<='", "'=='", "'>'", "'>='", "'||'"
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
	public static final int Ident=12;
	public static final int Int=13;
	public static final int Money=14;
	public static final int PARENTHESES_CLOSE=15;
	public static final int PARENTHESES_OPEN=16;
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
		this.state.ruleMemo = new HashMap[40+1];


	}

	@Override public String[] getTokenNames() { return QLParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g"; }


	//  @Override
	//  public void reportError(RecognitionException e) {
	//   throw new RuntimeException(e.getMessage()); 
	//  }



	// $ANTLR start "formExpression"
	// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:34:1: formExpression returns [Form result] : FORM Ident BLOCK_START elements= formElementArray BLOCK_END ;
	public final Form formExpression() throws RecognitionException {
		Form result = null;

		int formExpression_StartIndex = input.index();

		List<FormExpression> elements =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:35:2: ( FORM Ident BLOCK_START elements= formElementArray BLOCK_END )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:35:4: FORM Ident BLOCK_START elements= formElementArray BLOCK_END
			{
			match(input,FORM,FOLLOW_FORM_in_formExpression66); if (state.failed) return result;
			match(input,Ident,FOLLOW_Ident_in_formExpression68); if (state.failed) return result;
			match(input,BLOCK_START,FOLLOW_BLOCK_START_in_formExpression70); if (state.failed) return result;
			pushFollow(FOLLOW_formElementArray_in_formExpression74);
			elements=formElementArray();
			state._fsp--;
			if (state.failed) return result;
			match(input,BLOCK_END,FOLLOW_BLOCK_END_in_formExpression76); if (state.failed) return result;
			if ( state.backtracking==0 ) {
			 
			    
			    result = new Form(elements);
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



	// $ANTLR start "formElementArray"
	// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:41:1: formElementArray returns [List<FormExpression> formExpressions] : (e= formElementExpression )+ ;
	public final List<FormExpression> formElementArray() throws RecognitionException {
		List<FormExpression> formExpressions = null;

		int formElementArray_StartIndex = input.index();

		FormExpression e =null;

		 formExpressions = new ArrayList<FormExpression>(); 
		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return formExpressions; }

			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:43:3: ( (e= formElementExpression )+ )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:43:5: (e= formElementExpression )+
			{
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:43:5: (e= formElementExpression )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= IF && LA1_0 <= Ident)) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:43:6: e= formElementExpression
					{
					pushFollow(FOLLOW_formElementExpression_in_formElementArray102);
					e=formElementExpression();
					state._fsp--;
					if (state.failed) return formExpressions;
					if ( state.backtracking==0 ) { formExpressions.add(e); }
					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					if (state.backtracking>0) {state.failed=true; return formExpressions;}
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
			if ( state.backtracking>0 ) { memoize(input, 2, formElementArray_StartIndex); }

		}
		return formExpressions;
	}
	// $ANTLR end "formElementArray"



	// $ANTLR start "formElementExpression"
	// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:45:1: formElementExpression returns [FormExpression result] : ( questionExpression | computedExpression | formIfExpression );
	public final FormExpression formElementExpression() throws RecognitionException {
		FormExpression result = null;

		int formElementExpression_StartIndex = input.index();

		FormQuestion questionExpression1 =null;
		FormComputed computedExpression2 =null;
		IfExpression formIfExpression3 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:46:5: ( questionExpression | computedExpression | formIfExpression )
			int alt2=3;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==Ident) ) {
				int LA2_1 = input.LA(2);
				if ( (LA2_1==27) ) {
					int LA2_3 = input.LA(3);
					if ( (LA2_3==String) ) {
						int LA2_4 = input.LA(4);
						if ( (LA2_4==Type) ) {
							int LA2_5 = input.LA(5);
							if ( (LA2_5==EOF||LA2_5==BLOCK_END||(LA2_5 >= IF && LA2_5 <= Ident)) ) {
								alt2=1;
							}
							else if ( (LA2_5==PARENTHESES_OPEN) ) {
								alt2=2;
							}

							else {
								if (state.backtracking>0) {state.failed=true; return result;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 2, 5, input);
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
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 2, 4, input);
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
								new NoViableAltException("", 2, 3, input);
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
							new NoViableAltException("", 2, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA2_0==IF) ) {
				alt2=3;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:46:7: questionExpression
					{
					pushFollow(FOLLOW_questionExpression_in_formElementExpression122);
					questionExpression1=questionExpression();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = questionExpression1; }
					}
					break;
				case 2 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:47:7: computedExpression
					{
					pushFollow(FOLLOW_computedExpression_in_formElementExpression132);
					computedExpression2=computedExpression();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = computedExpression2; }
					}
					break;
				case 3 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:48:7: formIfExpression
					{
					pushFollow(FOLLOW_formIfExpression_in_formElementExpression142);
					formIfExpression3=formIfExpression();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = formIfExpression3; }
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
			if ( state.backtracking>0 ) { memoize(input, 3, formElementExpression_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "formElementExpression"



	// $ANTLR start "formIfExpression"
	// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:51:1: formIfExpression returns [IfExpression result] : ( IF PARENTHESES_OPEN statement= orExpression PARENTHESES_CLOSE BLOCK_START successStatements= formElementArray BLOCK_END ELSE BLOCK_START elseStatements= formElementArray BLOCK_END | IF PARENTHESES_OPEN statement= orExpression PARENTHESES_CLOSE BLOCK_START successStatements= formElementArray BLOCK_END );
	public final IfExpression formIfExpression() throws RecognitionException {
		IfExpression result = null;

		int formIfExpression_StartIndex = input.index();

		Expression statement =null;
		List<FormExpression> successStatements =null;
		List<FormExpression> elseStatements =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:52:5: ( IF PARENTHESES_OPEN statement= orExpression PARENTHESES_CLOSE BLOCK_START successStatements= formElementArray BLOCK_END ELSE BLOCK_START elseStatements= formElementArray BLOCK_END | IF PARENTHESES_OPEN statement= orExpression PARENTHESES_CLOSE BLOCK_START successStatements= formElementArray BLOCK_END )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==IF) ) {
				int LA3_1 = input.LA(2);
				if ( (synpred4_QL()) ) {
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
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:52:7: IF PARENTHESES_OPEN statement= orExpression PARENTHESES_CLOSE BLOCK_START successStatements= formElementArray BLOCK_END ELSE BLOCK_START elseStatements= formElementArray BLOCK_END
					{
					match(input,IF,FOLLOW_IF_in_formIfExpression165); if (state.failed) return result;
					match(input,PARENTHESES_OPEN,FOLLOW_PARENTHESES_OPEN_in_formIfExpression167); if (state.failed) return result;
					pushFollow(FOLLOW_orExpression_in_formIfExpression171);
					statement=orExpression();
					state._fsp--;
					if (state.failed) return result;
					match(input,PARENTHESES_CLOSE,FOLLOW_PARENTHESES_CLOSE_in_formIfExpression173); if (state.failed) return result;
					match(input,BLOCK_START,FOLLOW_BLOCK_START_in_formIfExpression175); if (state.failed) return result;
					pushFollow(FOLLOW_formElementArray_in_formIfExpression179);
					successStatements=formElementArray();
					state._fsp--;
					if (state.failed) return result;
					match(input,BLOCK_END,FOLLOW_BLOCK_END_in_formIfExpression181); if (state.failed) return result;
					match(input,ELSE,FOLLOW_ELSE_in_formIfExpression183); if (state.failed) return result;
					match(input,BLOCK_START,FOLLOW_BLOCK_START_in_formIfExpression185); if (state.failed) return result;
					pushFollow(FOLLOW_formElementArray_in_formIfExpression189);
					elseStatements=formElementArray();
					state._fsp--;
					if (state.failed) return result;
					match(input,BLOCK_END,FOLLOW_BLOCK_END_in_formIfExpression191); if (state.failed) return result;
					if ( state.backtracking==0 ) {
					      result = new IfElse(statement, successStatements, elseStatements);
					    }
					}
					break;
				case 2 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:56:7: IF PARENTHESES_OPEN statement= orExpression PARENTHESES_CLOSE BLOCK_START successStatements= formElementArray BLOCK_END
					{
					match(input,IF,FOLLOW_IF_in_formIfExpression205); if (state.failed) return result;
					match(input,PARENTHESES_OPEN,FOLLOW_PARENTHESES_OPEN_in_formIfExpression207); if (state.failed) return result;
					pushFollow(FOLLOW_orExpression_in_formIfExpression211);
					statement=orExpression();
					state._fsp--;
					if (state.failed) return result;
					match(input,PARENTHESES_CLOSE,FOLLOW_PARENTHESES_CLOSE_in_formIfExpression213); if (state.failed) return result;
					match(input,BLOCK_START,FOLLOW_BLOCK_START_in_formIfExpression215); if (state.failed) return result;
					pushFollow(FOLLOW_formElementArray_in_formIfExpression219);
					successStatements=formElementArray();
					state._fsp--;
					if (state.failed) return result;
					match(input,BLOCK_END,FOLLOW_BLOCK_END_in_formIfExpression221); if (state.failed) return result;
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
			if ( state.backtracking>0 ) { memoize(input, 4, formIfExpression_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "formIfExpression"



	// $ANTLR start "questionArray"
	// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:61:1: questionArray returns [List<FormQuestion> expressions] : (e= questionExpression )+ ;
	public final List<FormQuestion> questionArray() throws RecognitionException {
		List<FormQuestion> expressions = null;

		int questionArray_StartIndex = input.index();

		FormQuestion e =null;

		 expressions = new ArrayList<FormQuestion>(); 
		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return expressions; }

			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:63:5: ( (e= questionExpression )+ )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:63:7: (e= questionExpression )+
			{
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:63:7: (e= questionExpression )+
			int cnt4=0;
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==Ident) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:63:8: e= questionExpression
					{
					pushFollow(FOLLOW_questionExpression_in_questionArray257);
					e=questionExpression();
					state._fsp--;
					if (state.failed) return expressions;
					if ( state.backtracking==0 ) { expressions.add(e); }
					}
					break;

				default :
					if ( cnt4 >= 1 ) break loop4;
					if (state.backtracking>0) {state.failed=true; return expressions;}
					EarlyExitException eee = new EarlyExitException(4, input);
					throw eee;
				}
				cnt4++;
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 5, questionArray_StartIndex); }

		}
		return expressions;
	}
	// $ANTLR end "questionArray"



	// $ANTLR start "computedExpression"
	// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:65:1: computedExpression returns [FormComputed result] : label= Ident ':' question= String parameter= dataTypeExpression PARENTHESES_OPEN operation= orExpression PARENTHESES_CLOSE ;
	public final FormComputed computedExpression() throws RecognitionException {
		FormComputed result = null;

		int computedExpression_StartIndex = input.index();

		Token label=null;
		Token question=null;
		DataType parameter =null;
		Expression operation =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:66:3: (label= Ident ':' question= String parameter= dataTypeExpression PARENTHESES_OPEN operation= orExpression PARENTHESES_CLOSE )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:66:5: label= Ident ':' question= String parameter= dataTypeExpression PARENTHESES_OPEN operation= orExpression PARENTHESES_CLOSE
			{
			label=(Token)match(input,Ident,FOLLOW_Ident_in_computedExpression277); if (state.failed) return result;
			match(input,27,FOLLOW_27_in_computedExpression279); if (state.failed) return result;
			question=(Token)match(input,String,FOLLOW_String_in_computedExpression283); if (state.failed) return result;
			pushFollow(FOLLOW_dataTypeExpression_in_computedExpression287);
			parameter=dataTypeExpression();
			state._fsp--;
			if (state.failed) return result;
			match(input,PARENTHESES_OPEN,FOLLOW_PARENTHESES_OPEN_in_computedExpression289); if (state.failed) return result;
			pushFollow(FOLLOW_orExpression_in_computedExpression293);
			operation=orExpression();
			state._fsp--;
			if (state.failed) return result;
			match(input,PARENTHESES_CLOSE,FOLLOW_PARENTHESES_CLOSE_in_computedExpression295); if (state.failed) return result;
			if ( state.backtracking==0 ) {
			    result = new FormComputed((label!=null?label.getText():null), (question!=null?question.getText():null), parameter, operation);
			  }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 6, computedExpression_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "computedExpression"



	// $ANTLR start "questionExpression"
	// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:70:1: questionExpression returns [FormQuestion result] : label= Ident ':' question= String parameter= dataTypeExpression ;
	public final FormQuestion questionExpression() throws RecognitionException {
		FormQuestion result = null;

		int questionExpression_StartIndex = input.index();

		Token label=null;
		Token question=null;
		DataType parameter =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:71:3: (label= Ident ':' question= String parameter= dataTypeExpression )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:71:5: label= Ident ':' question= String parameter= dataTypeExpression
			{
			label=(Token)match(input,Ident,FOLLOW_Ident_in_questionExpression313); if (state.failed) return result;
			match(input,27,FOLLOW_27_in_questionExpression315); if (state.failed) return result;
			question=(Token)match(input,String,FOLLOW_String_in_questionExpression319); if (state.failed) return result;
			pushFollow(FOLLOW_dataTypeExpression_in_questionExpression323);
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
			if ( state.backtracking>0 ) { memoize(input, 7, questionExpression_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "questionExpression"



	// $ANTLR start "dataTypeExpression"
	// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:75:1: dataTypeExpression returns [DataType result] : Type ;
	public final DataType dataTypeExpression() throws RecognitionException {
		DataType result = null;

		int dataTypeExpression_StartIndex = input.index();

		Token Type4=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:76:2: ( Type )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:76:4: Type
			{
			Type4=(Token)match(input,Type,FOLLOW_Type_in_dataTypeExpression340); if (state.failed) return result;
			if ( state.backtracking==0 ) {
			    if ((Type4!=null?Type4.getText():null).equals("string")) result = new StringLiteral();
			    else if ((Type4!=null?Type4.getText():null).equals("integer")) result = new Int();
			    else if ((Type4!=null?Type4.getText():null).equals("money")) result = new Money();
			    else if ((Type4!=null?Type4.getText():null).equals("boolean")) result = new Bool();
			 }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 8, dataTypeExpression_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "dataTypeExpression"



	// $ANTLR start "primary"
	// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:83:1: primary returns [Expression result] : ( Int | Money | Bool | Ident | String | '(' x= orExpression ')' );
	public final Expression primary() throws RecognitionException {
		Expression result = null;

		int primary_StartIndex = input.index();

		Token Int5=null;
		Token Money6=null;
		Token Bool7=null;
		Token Ident8=null;
		Token String9=null;
		Expression x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:84:3: ( Int | Money | Bool | Ident | String | '(' x= orExpression ')' )
			int alt5=6;
			switch ( input.LA(1) ) {
			case Int:
				{
				alt5=1;
				}
				break;
			case Money:
				{
				alt5=2;
				}
				break;
			case Bool:
				{
				alt5=3;
				}
				break;
			case Ident:
				{
				alt5=4;
				}
				break;
			case String:
				{
				alt5=5;
				}
				break;
			case PARENTHESES_OPEN:
				{
				alt5=6;
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
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:84:5: Int
					{
					Int5=(Token)match(input,Int,FOLLOW_Int_in_primary357); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Int(Integer.parseInt((Int5!=null?Int5.getText():null))); }
					}
					break;
				case 2 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:85:5: Money
					{
					Money6=(Token)match(input,Money,FOLLOW_Money_in_primary367); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Money((Money6!=null?Money6.getText():null)); }
					}
					break;
				case 3 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:86:5: Bool
					{
					Bool7=(Token)match(input,Bool,FOLLOW_Bool_in_primary375); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Bool(Boolean.parseBoolean((Bool7!=null?Bool7.getText():null))); }
					}
					break;
				case 4 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:87:5: Ident
					{
					Ident8=(Token)match(input,Ident,FOLLOW_Ident_in_primary383); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Ident((Ident8!=null?Ident8.getText():null)); }
					}
					break;
				case 5 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:88:5: String
					{
					String9=(Token)match(input,String,FOLLOW_String_in_primary391); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new StringLiteral((String9!=null?String9.getText():null).substring(1, (String9!=null?String9.getText():null).length() - 1)); }
					}
					break;
				case 6 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:89:5: '(' x= orExpression ')'
					{
					match(input,PARENTHESES_OPEN,FOLLOW_PARENTHESES_OPEN_in_primary399); if (state.failed) return result;
					pushFollow(FOLLOW_orExpression_in_primary403);
					x=orExpression();
					state._fsp--;
					if (state.failed) return result;
					match(input,PARENTHESES_CLOSE,FOLLOW_PARENTHESES_CLOSE_in_primary405); if (state.failed) return result;
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
			if ( state.backtracking>0 ) { memoize(input, 9, primary_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "primary"



	// $ANTLR start "unExpression"
	// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:103:1: unExpression returns [Expression result] : ( '+' x= unExpression | '-' x= unExpression | '!' x= unExpression |x= primary );
	public final Expression unExpression() throws RecognitionException {
		Expression result = null;

		int unExpression_StartIndex = input.index();

		Expression x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:104:5: ( '+' x= unExpression | '-' x= unExpression | '!' x= unExpression |x= primary )
			int alt6=4;
			switch ( input.LA(1) ) {
			case 24:
				{
				alt6=1;
				}
				break;
			case 25:
				{
				alt6=2;
				}
				break;
			case 20:
				{
				alt6=3;
				}
				break;
			case Bool:
			case Ident:
			case Int:
			case Money:
			case PARENTHESES_OPEN:
			case String:
				{
				alt6=4;
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
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:104:8: '+' x= unExpression
					{
					match(input,24,FOLLOW_24_in_unExpression441); if (state.failed) return result;
					pushFollow(FOLLOW_unExpression_in_unExpression445);
					x=unExpression();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Pos(x); }
					}
					break;
				case 2 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:105:8: '-' x= unExpression
					{
					match(input,25,FOLLOW_25_in_unExpression456); if (state.failed) return result;
					pushFollow(FOLLOW_unExpression_in_unExpression460);
					x=unExpression();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Neg(x); }
					}
					break;
				case 3 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:106:8: '!' x= unExpression
					{
					match(input,20,FOLLOW_20_in_unExpression471); if (state.failed) return result;
					pushFollow(FOLLOW_unExpression_in_unExpression475);
					x=unExpression();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Not(x); }
					}
					break;
				case 4 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:107:8: x= primary
					{
					pushFollow(FOLLOW_primary_in_unExpression488);
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
			if ( state.backtracking>0 ) { memoize(input, 10, unExpression_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "unExpression"



	// $ANTLR start "mulExpression"
	// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:110:1: mulExpression returns [Expression result] : lhs= unExpression (op= ( '*' | '/' ) rhs= unExpression )* ;
	public final Expression mulExpression() throws RecognitionException {
		Expression result = null;

		int mulExpression_StartIndex = input.index();

		Token op=null;
		Expression lhs =null;
		Expression rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:111:5: (lhs= unExpression (op= ( '*' | '/' ) rhs= unExpression )* )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:111:9: lhs= unExpression (op= ( '*' | '/' ) rhs= unExpression )*
			{
			pushFollow(FOLLOW_unExpression_in_mulExpression526);
			lhs=unExpression();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:111:51: (op= ( '*' | '/' ) rhs= unExpression )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==23||LA7_0==26) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:111:53: op= ( '*' | '/' ) rhs= unExpression
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
					pushFollow(FOLLOW_unExpression_in_mulExpression546);
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
			if ( state.backtracking>0 ) { memoize(input, 11, mulExpression_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "mulExpression"



	// $ANTLR start "addExpression"
	// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:125:1: addExpression returns [Expression result] : lhs= mulExpression (op= ( '+' | '-' ) rhs= mulExpression )* ;
	public final Expression addExpression() throws RecognitionException {
		Expression result = null;

		int addExpression_StartIndex = input.index();

		Token op=null;
		Expression lhs =null;
		Expression rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }

			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:126:5: (lhs= mulExpression (op= ( '+' | '-' ) rhs= mulExpression )* )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:126:9: lhs= mulExpression (op= ( '+' | '-' ) rhs= mulExpression )*
			{
			pushFollow(FOLLOW_mulExpression_in_addExpression589);
			lhs=mulExpression();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:126:52: (op= ( '+' | '-' ) rhs= mulExpression )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( ((LA8_0 >= 24 && LA8_0 <= 25)) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:126:54: op= ( '+' | '-' ) rhs= mulExpression
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
					pushFollow(FOLLOW_mulExpression_in_addExpression607);
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
			if ( state.backtracking>0 ) { memoize(input, 12, addExpression_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "addExpression"



	// $ANTLR start "relExpression"
	// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:137:1: relExpression returns [Expression result] : lhs= addExpression (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpression )* ;
	public final Expression relExpression() throws RecognitionException {
		Expression result = null;

		int relExpression_StartIndex = input.index();

		Token op=null;
		Expression lhs =null;
		Expression rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return result; }

			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:138:5: (lhs= addExpression (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpression )* )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:138:9: lhs= addExpression (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpression )*
			{
			pushFollow(FOLLOW_addExpression_in_relExpression642);
			lhs=addExpression();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:138:52: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpression )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==21||(LA9_0 >= 28 && LA9_0 <= 32)) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:138:54: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpression
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
					pushFollow(FOLLOW_addExpression_in_relExpression666);
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
			if ( state.backtracking>0 ) { memoize(input, 13, relExpression_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "relExpression"



	// $ANTLR start "andExpression"
	// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:161:1: andExpression returns [Expression result] : lhs= relExpression ( '&&' rhs= relExpression )* ;
	public final Expression andExpression() throws RecognitionException {
		Expression result = null;

		int andExpression_StartIndex = input.index();

		Expression lhs =null;
		Expression rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return result; }

			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:162:5: (lhs= relExpression ( '&&' rhs= relExpression )* )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:162:9: lhs= relExpression ( '&&' rhs= relExpression )*
			{
			pushFollow(FOLLOW_relExpression_in_andExpression704);
			lhs=relExpression();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:162:52: ( '&&' rhs= relExpression )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==22) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:162:54: '&&' rhs= relExpression
					{
					match(input,22,FOLLOW_22_in_andExpression710); if (state.failed) return result;
					pushFollow(FOLLOW_relExpression_in_andExpression714);
					rhs=relExpression();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new And(result, rhs); }
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
			if ( state.backtracking>0 ) { memoize(input, 14, andExpression_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "andExpression"



	// $ANTLR start "orExpression"
	// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:166:1: orExpression returns [Expression result] : lhs= andExpression ( '||' rhs= andExpression )* ;
	public final Expression orExpression() throws RecognitionException {
		Expression result = null;

		int orExpression_StartIndex = input.index();

		Expression lhs =null;
		Expression rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return result; }

			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:167:5: (lhs= andExpression ( '||' rhs= andExpression )* )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:167:9: lhs= andExpression ( '||' rhs= andExpression )*
			{
			pushFollow(FOLLOW_andExpression_in_orExpression749);
			lhs=andExpression();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = lhs; }
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:167:54: ( '||' rhs= andExpression )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==33) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:167:56: '||' rhs= andExpression
					{
					match(input,33,FOLLOW_33_in_orExpression755); if (state.failed) return result;
					pushFollow(FOLLOW_andExpression_in_orExpression759);
					rhs=andExpression();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Or(result, rhs); }
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
			if ( state.backtracking>0 ) { memoize(input, 15, orExpression_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "orExpression"

	// $ANTLR start synpred4_QL
	public final void synpred4_QL_fragment() throws RecognitionException {
		Expression statement =null;
		List<FormExpression> successStatements =null;
		List<FormExpression> elseStatements =null;

		// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:52:7: ( IF PARENTHESES_OPEN statement= orExpression PARENTHESES_CLOSE BLOCK_START successStatements= formElementArray BLOCK_END ELSE BLOCK_START elseStatements= formElementArray BLOCK_END )
		// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:52:7: IF PARENTHESES_OPEN statement= orExpression PARENTHESES_CLOSE BLOCK_START successStatements= formElementArray BLOCK_END ELSE BLOCK_START elseStatements= formElementArray BLOCK_END
		{
		match(input,IF,FOLLOW_IF_in_synpred4_QL165); if (state.failed) return;
		match(input,PARENTHESES_OPEN,FOLLOW_PARENTHESES_OPEN_in_synpred4_QL167); if (state.failed) return;
		pushFollow(FOLLOW_orExpression_in_synpred4_QL171);
		statement=orExpression();
		state._fsp--;
		if (state.failed) return;
		match(input,PARENTHESES_CLOSE,FOLLOW_PARENTHESES_CLOSE_in_synpred4_QL173); if (state.failed) return;
		match(input,BLOCK_START,FOLLOW_BLOCK_START_in_synpred4_QL175); if (state.failed) return;
		pushFollow(FOLLOW_formElementArray_in_synpred4_QL179);
		successStatements=formElementArray();
		state._fsp--;
		if (state.failed) return;
		match(input,BLOCK_END,FOLLOW_BLOCK_END_in_synpred4_QL181); if (state.failed) return;
		match(input,ELSE,FOLLOW_ELSE_in_synpred4_QL183); if (state.failed) return;
		match(input,BLOCK_START,FOLLOW_BLOCK_START_in_synpred4_QL185); if (state.failed) return;
		pushFollow(FOLLOW_formElementArray_in_synpred4_QL189);
		elseStatements=formElementArray();
		state._fsp--;
		if (state.failed) return;
		match(input,BLOCK_END,FOLLOW_BLOCK_END_in_synpred4_QL191); if (state.failed) return;
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



	public static final BitSet FOLLOW_FORM_in_formExpression66 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_Ident_in_formExpression68 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_BLOCK_START_in_formExpression70 = new BitSet(new long[]{0x0000000000001800L});
	public static final BitSet FOLLOW_formElementArray_in_formExpression74 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_BLOCK_END_in_formExpression76 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_formElementExpression_in_formElementArray102 = new BitSet(new long[]{0x0000000000001802L});
	public static final BitSet FOLLOW_questionExpression_in_formElementExpression122 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_computedExpression_in_formElementExpression132 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_formIfExpression_in_formElementExpression142 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_formIfExpression165 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_PARENTHESES_OPEN_in_formIfExpression167 = new BitSet(new long[]{0x0000000003137040L});
	public static final BitSet FOLLOW_orExpression_in_formIfExpression171 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_PARENTHESES_CLOSE_in_formIfExpression173 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_BLOCK_START_in_formIfExpression175 = new BitSet(new long[]{0x0000000000001800L});
	public static final BitSet FOLLOW_formElementArray_in_formIfExpression179 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_BLOCK_END_in_formIfExpression181 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_ELSE_in_formIfExpression183 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_BLOCK_START_in_formIfExpression185 = new BitSet(new long[]{0x0000000000001800L});
	public static final BitSet FOLLOW_formElementArray_in_formIfExpression189 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_BLOCK_END_in_formIfExpression191 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_formIfExpression205 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_PARENTHESES_OPEN_in_formIfExpression207 = new BitSet(new long[]{0x0000000003137040L});
	public static final BitSet FOLLOW_orExpression_in_formIfExpression211 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_PARENTHESES_CLOSE_in_formIfExpression213 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_BLOCK_START_in_formIfExpression215 = new BitSet(new long[]{0x0000000000001800L});
	public static final BitSet FOLLOW_formElementArray_in_formIfExpression219 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_BLOCK_END_in_formIfExpression221 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_questionExpression_in_questionArray257 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_Ident_in_computedExpression277 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_27_in_computedExpression279 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_String_in_computedExpression283 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_dataTypeExpression_in_computedExpression287 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_PARENTHESES_OPEN_in_computedExpression289 = new BitSet(new long[]{0x0000000003137040L});
	public static final BitSet FOLLOW_orExpression_in_computedExpression293 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_PARENTHESES_CLOSE_in_computedExpression295 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_questionExpression313 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_27_in_questionExpression315 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_String_in_questionExpression319 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_dataTypeExpression_in_questionExpression323 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Type_in_dataTypeExpression340 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Int_in_primary357 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Money_in_primary367 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Bool_in_primary375 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_primary383 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_String_in_primary391 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PARENTHESES_OPEN_in_primary399 = new BitSet(new long[]{0x0000000003137040L});
	public static final BitSet FOLLOW_orExpression_in_primary403 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_PARENTHESES_CLOSE_in_primary405 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_24_in_unExpression441 = new BitSet(new long[]{0x0000000003137040L});
	public static final BitSet FOLLOW_unExpression_in_unExpression445 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_25_in_unExpression456 = new BitSet(new long[]{0x0000000003137040L});
	public static final BitSet FOLLOW_unExpression_in_unExpression460 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_20_in_unExpression471 = new BitSet(new long[]{0x0000000003137040L});
	public static final BitSet FOLLOW_unExpression_in_unExpression475 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpression488 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpression_in_mulExpression526 = new BitSet(new long[]{0x0000000004800002L});
	public static final BitSet FOLLOW_set_in_mulExpression534 = new BitSet(new long[]{0x0000000003137040L});
	public static final BitSet FOLLOW_unExpression_in_mulExpression546 = new BitSet(new long[]{0x0000000004800002L});
	public static final BitSet FOLLOW_mulExpression_in_addExpression589 = new BitSet(new long[]{0x0000000003000002L});
	public static final BitSet FOLLOW_set_in_addExpression597 = new BitSet(new long[]{0x0000000003137040L});
	public static final BitSet FOLLOW_mulExpression_in_addExpression607 = new BitSet(new long[]{0x0000000003000002L});
	public static final BitSet FOLLOW_addExpression_in_relExpression642 = new BitSet(new long[]{0x00000001F0200002L});
	public static final BitSet FOLLOW_set_in_relExpression650 = new BitSet(new long[]{0x0000000003137040L});
	public static final BitSet FOLLOW_addExpression_in_relExpression666 = new BitSet(new long[]{0x00000001F0200002L});
	public static final BitSet FOLLOW_relExpression_in_andExpression704 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_22_in_andExpression710 = new BitSet(new long[]{0x0000000003137040L});
	public static final BitSet FOLLOW_relExpression_in_andExpression714 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_andExpression_in_orExpression749 = new BitSet(new long[]{0x0000000200000002L});
	public static final BitSet FOLLOW_33_in_orExpression755 = new BitSet(new long[]{0x0000000003137040L});
	public static final BitSet FOLLOW_andExpression_in_orExpression759 = new BitSet(new long[]{0x0000000200000002L});
	public static final BitSet FOLLOW_IF_in_synpred4_QL165 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_PARENTHESES_OPEN_in_synpred4_QL167 = new BitSet(new long[]{0x0000000003137040L});
	public static final BitSet FOLLOW_orExpression_in_synpred4_QL171 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_PARENTHESES_CLOSE_in_synpred4_QL173 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_BLOCK_START_in_synpred4_QL175 = new BitSet(new long[]{0x0000000000001800L});
	public static final BitSet FOLLOW_formElementArray_in_synpred4_QL179 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_BLOCK_END_in_synpred4_QL181 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_ELSE_in_synpred4_QL183 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_BLOCK_START_in_synpred4_QL185 = new BitSet(new long[]{0x0000000000001800L});
	public static final BitSet FOLLOW_formElementArray_in_synpred4_QL189 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_BLOCK_END_in_synpred4_QL191 = new BitSet(new long[]{0x0000000000000002L});
}
