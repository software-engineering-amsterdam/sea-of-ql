// $ANTLR 3.5 /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g 2013-01-17 15:27:06

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.base.*;
import org.uva.sea.ql.ast.form.*;
import org.uva.sea.ql.ast.types.*;
import org.uva.sea.ql.ast.operators.base.*;
import org.uva.sea.ql.ast.operators.unary.*;
import org.uva.sea.ql.ast.operators.binary.*;
import org.uva.sea.ql.ast.conditionals.*;


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





	// $ANTLR start "form"
	// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:29:1: form returns [Form result] : FORM Ident BLOCK_START e= elements BLOCK_END ;
	public final Form form() throws RecognitionException {
		Form result = null;

		int form_StartIndex = input.index();

		Token Ident1=null;
		List<Element> e =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:30:3: ( FORM Ident BLOCK_START e= elements BLOCK_END )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:30:5: FORM Ident BLOCK_START e= elements BLOCK_END
			{
			match(input,FORM,FOLLOW_FORM_in_form65); if (state.failed) return result;
			Ident1=(Token)match(input,Ident,FOLLOW_Ident_in_form67); if (state.failed) return result;
			match(input,BLOCK_START,FOLLOW_BLOCK_START_in_form69); if (state.failed) return result;
			pushFollow(FOLLOW_elements_in_form73);
			e=elements();
			state._fsp--;
			if (state.failed) return result;
			match(input,BLOCK_END,FOLLOW_BLOCK_END_in_form75); if (state.failed) return result;
			if ( state.backtracking==0 ) {    
			    result = new Form((Ident1!=null?Ident1.getText():null), e);
			  }
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



	// $ANTLR start "elements"
	// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:34:1: elements returns [List<Element> results] : ( element )+ ;
	public final List<Element> elements() throws RecognitionException {
		List<Element> results = null;

		int elements_StartIndex = input.index();

		Element element2 =null;

		 results = new ArrayList<Element>(); 
		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return results; }

			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:36:3: ( ( element )+ )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:36:5: ( element )+
			{
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:36:5: ( element )+
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
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:36:6: element
					{
					pushFollow(FOLLOW_element_in_elements99);
					element2=element();
					state._fsp--;
					if (state.failed) return results;
					if ( state.backtracking==0 ) { results.add(element2); }
					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					if (state.backtracking>0) {state.failed=true; return results;}
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
			if ( state.backtracking>0 ) { memoize(input, 2, elements_StartIndex); }

		}
		return results;
	}
	// $ANTLR end "elements"



	// $ANTLR start "element"
	// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:38:1: element returns [Element result] : ( question | computation | ifExpression );
	public final Element element() throws RecognitionException {
		Element result = null;

		int element_StartIndex = input.index();

		Question question3 =null;
		Computation computation4 =null;
		IfStatement ifExpression5 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:39:5: ( question | computation | ifExpression )
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
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:39:7: question
					{
					pushFollow(FOLLOW_question_in_element119);
					question3=question();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = question3; }
					}
					break;
				case 2 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:40:7: computation
					{
					pushFollow(FOLLOW_computation_in_element129);
					computation4=computation();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = computation4; }
					}
					break;
				case 3 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:41:7: ifExpression
					{
					pushFollow(FOLLOW_ifExpression_in_element139);
					ifExpression5=ifExpression();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = ifExpression5; }
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
			if ( state.backtracking>0 ) { memoize(input, 3, element_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "element"



	// $ANTLR start "ifExpression"
	// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:43:1: ifExpression returns [IfStatement result] : ( IF PARENTHESES_OPEN condition= orExpression PARENTHESES_CLOSE BLOCK_START successStatements= elements BLOCK_END ELSE BLOCK_START elseStatements= elements BLOCK_END | IF PARENTHESES_OPEN condition= orExpression PARENTHESES_CLOSE BLOCK_START successStatements= elements BLOCK_END );
	public final IfStatement ifExpression() throws RecognitionException {
		IfStatement result = null;

		int ifExpression_StartIndex = input.index();

		Node condition =null;
		List<Element> successStatements =null;
		List<Element> elseStatements =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:44:5: ( IF PARENTHESES_OPEN condition= orExpression PARENTHESES_CLOSE BLOCK_START successStatements= elements BLOCK_END ELSE BLOCK_START elseStatements= elements BLOCK_END | IF PARENTHESES_OPEN condition= orExpression PARENTHESES_CLOSE BLOCK_START successStatements= elements BLOCK_END )
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
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:44:7: IF PARENTHESES_OPEN condition= orExpression PARENTHESES_CLOSE BLOCK_START successStatements= elements BLOCK_END ELSE BLOCK_START elseStatements= elements BLOCK_END
					{
					match(input,IF,FOLLOW_IF_in_ifExpression157); if (state.failed) return result;
					match(input,PARENTHESES_OPEN,FOLLOW_PARENTHESES_OPEN_in_ifExpression159); if (state.failed) return result;
					pushFollow(FOLLOW_orExpression_in_ifExpression163);
					condition=orExpression();
					state._fsp--;
					if (state.failed) return result;
					match(input,PARENTHESES_CLOSE,FOLLOW_PARENTHESES_CLOSE_in_ifExpression165); if (state.failed) return result;
					match(input,BLOCK_START,FOLLOW_BLOCK_START_in_ifExpression167); if (state.failed) return result;
					pushFollow(FOLLOW_elements_in_ifExpression171);
					successStatements=elements();
					state._fsp--;
					if (state.failed) return result;
					match(input,BLOCK_END,FOLLOW_BLOCK_END_in_ifExpression173); if (state.failed) return result;
					match(input,ELSE,FOLLOW_ELSE_in_ifExpression175); if (state.failed) return result;
					match(input,BLOCK_START,FOLLOW_BLOCK_START_in_ifExpression177); if (state.failed) return result;
					pushFollow(FOLLOW_elements_in_ifExpression181);
					elseStatements=elements();
					state._fsp--;
					if (state.failed) return result;
					match(input,BLOCK_END,FOLLOW_BLOCK_END_in_ifExpression183); if (state.failed) return result;
					if ( state.backtracking==0 ) {
					      result = new IfThenElse(condition, successStatements, elseStatements);
					    }
					}
					break;
				case 2 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:48:7: IF PARENTHESES_OPEN condition= orExpression PARENTHESES_CLOSE BLOCK_START successStatements= elements BLOCK_END
					{
					match(input,IF,FOLLOW_IF_in_ifExpression197); if (state.failed) return result;
					match(input,PARENTHESES_OPEN,FOLLOW_PARENTHESES_OPEN_in_ifExpression199); if (state.failed) return result;
					pushFollow(FOLLOW_orExpression_in_ifExpression203);
					condition=orExpression();
					state._fsp--;
					if (state.failed) return result;
					match(input,PARENTHESES_CLOSE,FOLLOW_PARENTHESES_CLOSE_in_ifExpression205); if (state.failed) return result;
					match(input,BLOCK_START,FOLLOW_BLOCK_START_in_ifExpression207); if (state.failed) return result;
					pushFollow(FOLLOW_elements_in_ifExpression211);
					successStatements=elements();
					state._fsp--;
					if (state.failed) return result;
					match(input,BLOCK_END,FOLLOW_BLOCK_END_in_ifExpression213); if (state.failed) return result;
					if ( state.backtracking==0 ) {
					      result = new IfThen(condition, successStatements);
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
			if ( state.backtracking>0 ) { memoize(input, 4, ifExpression_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "ifExpression"



	// $ANTLR start "questions"
	// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:53:1: questions returns [List<Question> results] : ( question )+ ;
	public final List<Question> questions() throws RecognitionException {
		List<Question> results = null;

		int questions_StartIndex = input.index();

		Question question6 =null;

		 results = new ArrayList<Question>(); 
		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return results; }

			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:55:5: ( ( question )+ )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:55:7: ( question )+
			{
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:55:7: ( question )+
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
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:55:8: question
					{
					pushFollow(FOLLOW_question_in_questions247);
					question6=question();
					state._fsp--;
					if (state.failed) return results;
					if ( state.backtracking==0 ) { results.add(question6); }
					}
					break;

				default :
					if ( cnt4 >= 1 ) break loop4;
					if (state.backtracking>0) {state.failed=true; return results;}
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
			if ( state.backtracking>0 ) { memoize(input, 5, questions_StartIndex); }

		}
		return results;
	}
	// $ANTLR end "questions"



	// $ANTLR start "computation"
	// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:57:1: computation returns [Computation result] : label= Ident ':' String parameter= dataType PARENTHESES_OPEN operation= orExpression PARENTHESES_CLOSE ;
	public final Computation computation() throws RecognitionException {
		Computation result = null;

		int computation_StartIndex = input.index();

		Token label=null;
		Token String7=null;
		Class<? extends DataType> parameter =null;
		Node operation =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:58:3: (label= Ident ':' String parameter= dataType PARENTHESES_OPEN operation= orExpression PARENTHESES_CLOSE )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:58:5: label= Ident ':' String parameter= dataType PARENTHESES_OPEN operation= orExpression PARENTHESES_CLOSE
			{
			label=(Token)match(input,Ident,FOLLOW_Ident_in_computation267); if (state.failed) return result;
			match(input,27,FOLLOW_27_in_computation269); if (state.failed) return result;
			String7=(Token)match(input,String,FOLLOW_String_in_computation271); if (state.failed) return result;
			pushFollow(FOLLOW_dataType_in_computation275);
			parameter=dataType();
			state._fsp--;
			if (state.failed) return result;
			match(input,PARENTHESES_OPEN,FOLLOW_PARENTHESES_OPEN_in_computation277); if (state.failed) return result;
			pushFollow(FOLLOW_orExpression_in_computation281);
			operation=orExpression();
			state._fsp--;
			if (state.failed) return result;
			match(input,PARENTHESES_CLOSE,FOLLOW_PARENTHESES_CLOSE_in_computation283); if (state.failed) return result;
			if ( state.backtracking==0 ) {
			    result = new Computation(new Label((label!=null?label.getText():null)), (String7!=null?String7.getText():null), parameter, operation);
			  }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 6, computation_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "computation"



	// $ANTLR start "question"
	// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:62:1: question returns [Question result] : label= Ident ':' String parameter= dataType ;
	public final Question question() throws RecognitionException {
		Question result = null;

		int question_StartIndex = input.index();

		Token label=null;
		Token String8=null;
		Class<? extends DataType> parameter =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:63:3: (label= Ident ':' String parameter= dataType )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:63:5: label= Ident ':' String parameter= dataType
			{
			label=(Token)match(input,Ident,FOLLOW_Ident_in_question301); if (state.failed) return result;
			match(input,27,FOLLOW_27_in_question303); if (state.failed) return result;
			String8=(Token)match(input,String,FOLLOW_String_in_question305); if (state.failed) return result;
			pushFollow(FOLLOW_dataType_in_question309);
			parameter=dataType();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) {
			    result = new Question(new Label((label!=null?label.getText():null)), (String8!=null?String8.getText():null), parameter);
			  }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 7, question_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "question"



	// $ANTLR start "dataType"
	// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:67:1: dataType returns [Class<? extends DataType> result] : Type ;
	public final Class<? extends DataType> dataType() throws RecognitionException {
		Class<? extends DataType> result = null;

		int dataType_StartIndex = input.index();

		Token Type9=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:68:2: ( Type )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:68:4: Type
			{
			Type9=(Token)match(input,Type,FOLLOW_Type_in_dataType326); if (state.failed) return result;
			if ( state.backtracking==0 ) {
			    if ((Type9!=null?Type9.getText():null).equals("string")) result = StringLiteral.class;
			    else if ((Type9!=null?Type9.getText():null).equals("integer")) result = Int.class;
			    else if ((Type9!=null?Type9.getText():null).equals("money")) result = Money.class;
			    else if ((Type9!=null?Type9.getText():null).equals("boolean")) result = Bool.class;
			 }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 8, dataType_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "dataType"



	// $ANTLR start "primary"
	// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:75:1: primary returns [Node result] : ( Int | Money | Bool | Ident | String | PARENTHESES_OPEN orExpression PARENTHESES_CLOSE );
	public final Node primary() throws RecognitionException {
		Node result = null;

		int primary_StartIndex = input.index();

		Token Int10=null;
		Token Money11=null;
		Token Bool12=null;
		Token Ident13=null;
		Token String14=null;
		Node orExpression15 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:76:3: ( Int | Money | Bool | Ident | String | PARENTHESES_OPEN orExpression PARENTHESES_CLOSE )
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
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:76:5: Int
					{
					Int10=(Token)match(input,Int,FOLLOW_Int_in_primary343); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Int(Integer.parseInt((Int10!=null?Int10.getText():null))); }
					}
					break;
				case 2 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:77:5: Money
					{
					Money11=(Token)match(input,Money,FOLLOW_Money_in_primary353); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Money((Money11!=null?Money11.getText():null)); }
					}
					break;
				case 3 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:78:5: Bool
					{
					Bool12=(Token)match(input,Bool,FOLLOW_Bool_in_primary361); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Bool(Boolean.parseBoolean((Bool12!=null?Bool12.getText():null))); }
					}
					break;
				case 4 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:79:5: Ident
					{
					Ident13=(Token)match(input,Ident,FOLLOW_Ident_in_primary369); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Ident((Ident13!=null?Ident13.getText():null)); }
					}
					break;
				case 5 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:80:5: String
					{
					String14=(Token)match(input,String,FOLLOW_String_in_primary377); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new StringLiteral((String14!=null?String14.getText():null).substring(1, (String14!=null?String14.getText():null).length() - 1)); }
					}
					break;
				case 6 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:81:5: PARENTHESES_OPEN orExpression PARENTHESES_CLOSE
					{
					match(input,PARENTHESES_OPEN,FOLLOW_PARENTHESES_OPEN_in_primary385); if (state.failed) return result;
					pushFollow(FOLLOW_orExpression_in_primary387);
					orExpression15=orExpression();
					state._fsp--;
					if (state.failed) return result;
					match(input,PARENTHESES_CLOSE,FOLLOW_PARENTHESES_CLOSE_in_primary389); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = orExpression15; }
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
	// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:83:1: unExpression returns [Node result] : ( '+' x= unExpression | '-' x= unExpression | '!' x= unExpression |x= primary );
	public final Node unExpression() throws RecognitionException {
		Node result = null;

		int unExpression_StartIndex = input.index();

		Node x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:84:5: ( '+' x= unExpression | '-' x= unExpression | '!' x= unExpression |x= primary )
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
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:84:8: '+' x= unExpression
					{
					match(input,24,FOLLOW_24_in_unExpression408); if (state.failed) return result;
					pushFollow(FOLLOW_unExpression_in_unExpression412);
					x=unExpression();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Pos(x); }
					}
					break;
				case 2 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:85:8: '-' x= unExpression
					{
					match(input,25,FOLLOW_25_in_unExpression423); if (state.failed) return result;
					pushFollow(FOLLOW_unExpression_in_unExpression427);
					x=unExpression();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Neg(x); }
					}
					break;
				case 3 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:86:8: '!' x= unExpression
					{
					match(input,20,FOLLOW_20_in_unExpression438); if (state.failed) return result;
					pushFollow(FOLLOW_unExpression_in_unExpression442);
					x=unExpression();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Not(x); }
					}
					break;
				case 4 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:87:8: x= primary
					{
					pushFollow(FOLLOW_primary_in_unExpression455);
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
	// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:89:1: mulExpression returns [Node result] : lhs= unExpression (op= ( '*' | '/' ) rhs= unExpression )* ;
	public final Node mulExpression() throws RecognitionException {
		Node result = null;

		int mulExpression_StartIndex = input.index();

		Token op=null;
		Node lhs =null;
		Node rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:90:5: (lhs= unExpression (op= ( '*' | '/' ) rhs= unExpression )* )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:90:9: lhs= unExpression (op= ( '*' | '/' ) rhs= unExpression )*
			{
			pushFollow(FOLLOW_unExpression_in_mulExpression488);
			lhs=unExpression();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:90:51: (op= ( '*' | '/' ) rhs= unExpression )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==23||LA7_0==26) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:90:53: op= ( '*' | '/' ) rhs= unExpression
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
					pushFollow(FOLLOW_unExpression_in_mulExpression508);
					rhs=unExpression();
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
	// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:100:1: addExpression returns [Node result] : lhs= mulExpression (op= ( '+' | '-' ) rhs= mulExpression )* ;
	public final Node addExpression() throws RecognitionException {
		Node result = null;

		int addExpression_StartIndex = input.index();

		Token op=null;
		Node lhs =null;
		Node rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }

			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:101:5: (lhs= mulExpression (op= ( '+' | '-' ) rhs= mulExpression )* )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:101:9: lhs= mulExpression (op= ( '+' | '-' ) rhs= mulExpression )*
			{
			pushFollow(FOLLOW_mulExpression_in_addExpression537);
			lhs=mulExpression();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:101:52: (op= ( '+' | '-' ) rhs= mulExpression )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( ((LA8_0 >= 24 && LA8_0 <= 25)) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:101:54: op= ( '+' | '-' ) rhs= mulExpression
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
					pushFollow(FOLLOW_mulExpression_in_addExpression555);
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
	// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:111:1: relExpression returns [Node result] : lhs= addExpression (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpression )* ;
	public final Node relExpression() throws RecognitionException {
		Node result = null;

		int relExpression_StartIndex = input.index();

		Token op=null;
		Node lhs =null;
		Node rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return result; }

			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:112:5: (lhs= addExpression (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpression )* )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:112:9: lhs= addExpression (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpression )*
			{
			pushFollow(FOLLOW_addExpression_in_relExpression585);
			lhs=addExpression();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:112:52: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpression )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==21||(LA9_0 >= 28 && LA9_0 <= 32)) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:112:54: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpression
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
					pushFollow(FOLLOW_addExpression_in_relExpression609);
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
	// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:134:1: andExpression returns [Node result] : lhs= relExpression ( '&&' rhs= relExpression )* ;
	public final Node andExpression() throws RecognitionException {
		Node result = null;

		int andExpression_StartIndex = input.index();

		Node lhs =null;
		Node rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return result; }

			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:135:5: (lhs= relExpression ( '&&' rhs= relExpression )* )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:135:9: lhs= relExpression ( '&&' rhs= relExpression )*
			{
			pushFollow(FOLLOW_relExpression_in_andExpression642);
			lhs=relExpression();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:135:52: ( '&&' rhs= relExpression )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==22) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:135:54: '&&' rhs= relExpression
					{
					match(input,22,FOLLOW_22_in_andExpression648); if (state.failed) return result;
					pushFollow(FOLLOW_relExpression_in_andExpression652);
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
	// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:138:1: orExpression returns [Node result] : lhs= andExpression ( '||' rhs= andExpression )* ;
	public final Node orExpression() throws RecognitionException {
		Node result = null;

		int orExpression_StartIndex = input.index();

		Node lhs =null;
		Node rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return result; }

			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:139:5: (lhs= andExpression ( '||' rhs= andExpression )* )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:139:9: lhs= andExpression ( '||' rhs= andExpression )*
			{
			pushFollow(FOLLOW_andExpression_in_orExpression682);
			lhs=andExpression();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = lhs; }
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:139:54: ( '||' rhs= andExpression )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==33) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:139:56: '||' rhs= andExpression
					{
					match(input,33,FOLLOW_33_in_orExpression688); if (state.failed) return result;
					pushFollow(FOLLOW_andExpression_in_orExpression692);
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
		Node condition =null;
		List<Element> successStatements =null;
		List<Element> elseStatements =null;

		// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:44:7: ( IF PARENTHESES_OPEN condition= orExpression PARENTHESES_CLOSE BLOCK_START successStatements= elements BLOCK_END ELSE BLOCK_START elseStatements= elements BLOCK_END )
		// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:44:7: IF PARENTHESES_OPEN condition= orExpression PARENTHESES_CLOSE BLOCK_START successStatements= elements BLOCK_END ELSE BLOCK_START elseStatements= elements BLOCK_END
		{
		match(input,IF,FOLLOW_IF_in_synpred4_QL157); if (state.failed) return;
		match(input,PARENTHESES_OPEN,FOLLOW_PARENTHESES_OPEN_in_synpred4_QL159); if (state.failed) return;
		pushFollow(FOLLOW_orExpression_in_synpred4_QL163);
		condition=orExpression();
		state._fsp--;
		if (state.failed) return;
		match(input,PARENTHESES_CLOSE,FOLLOW_PARENTHESES_CLOSE_in_synpred4_QL165); if (state.failed) return;
		match(input,BLOCK_START,FOLLOW_BLOCK_START_in_synpred4_QL167); if (state.failed) return;
		pushFollow(FOLLOW_elements_in_synpred4_QL171);
		successStatements=elements();
		state._fsp--;
		if (state.failed) return;
		match(input,BLOCK_END,FOLLOW_BLOCK_END_in_synpred4_QL173); if (state.failed) return;
		match(input,ELSE,FOLLOW_ELSE_in_synpred4_QL175); if (state.failed) return;
		match(input,BLOCK_START,FOLLOW_BLOCK_START_in_synpred4_QL177); if (state.failed) return;
		pushFollow(FOLLOW_elements_in_synpred4_QL181);
		elseStatements=elements();
		state._fsp--;
		if (state.failed) return;
		match(input,BLOCK_END,FOLLOW_BLOCK_END_in_synpred4_QL183); if (state.failed) return;
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



	public static final BitSet FOLLOW_FORM_in_form65 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_Ident_in_form67 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_BLOCK_START_in_form69 = new BitSet(new long[]{0x0000000000001800L});
	public static final BitSet FOLLOW_elements_in_form73 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_BLOCK_END_in_form75 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_element_in_elements99 = new BitSet(new long[]{0x0000000000001802L});
	public static final BitSet FOLLOW_question_in_element119 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_computation_in_element129 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifExpression_in_element139 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_ifExpression157 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_PARENTHESES_OPEN_in_ifExpression159 = new BitSet(new long[]{0x0000000003137040L});
	public static final BitSet FOLLOW_orExpression_in_ifExpression163 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_PARENTHESES_CLOSE_in_ifExpression165 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_BLOCK_START_in_ifExpression167 = new BitSet(new long[]{0x0000000000001800L});
	public static final BitSet FOLLOW_elements_in_ifExpression171 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_BLOCK_END_in_ifExpression173 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_ELSE_in_ifExpression175 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_BLOCK_START_in_ifExpression177 = new BitSet(new long[]{0x0000000000001800L});
	public static final BitSet FOLLOW_elements_in_ifExpression181 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_BLOCK_END_in_ifExpression183 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_ifExpression197 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_PARENTHESES_OPEN_in_ifExpression199 = new BitSet(new long[]{0x0000000003137040L});
	public static final BitSet FOLLOW_orExpression_in_ifExpression203 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_PARENTHESES_CLOSE_in_ifExpression205 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_BLOCK_START_in_ifExpression207 = new BitSet(new long[]{0x0000000000001800L});
	public static final BitSet FOLLOW_elements_in_ifExpression211 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_BLOCK_END_in_ifExpression213 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_question_in_questions247 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_Ident_in_computation267 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_27_in_computation269 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_String_in_computation271 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_dataType_in_computation275 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_PARENTHESES_OPEN_in_computation277 = new BitSet(new long[]{0x0000000003137040L});
	public static final BitSet FOLLOW_orExpression_in_computation281 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_PARENTHESES_CLOSE_in_computation283 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_question301 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_27_in_question303 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_String_in_question305 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_dataType_in_question309 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Type_in_dataType326 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Int_in_primary343 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Money_in_primary353 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Bool_in_primary361 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_primary369 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_String_in_primary377 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PARENTHESES_OPEN_in_primary385 = new BitSet(new long[]{0x0000000003137040L});
	public static final BitSet FOLLOW_orExpression_in_primary387 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_PARENTHESES_CLOSE_in_primary389 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_24_in_unExpression408 = new BitSet(new long[]{0x0000000003137040L});
	public static final BitSet FOLLOW_unExpression_in_unExpression412 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_25_in_unExpression423 = new BitSet(new long[]{0x0000000003137040L});
	public static final BitSet FOLLOW_unExpression_in_unExpression427 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_20_in_unExpression438 = new BitSet(new long[]{0x0000000003137040L});
	public static final BitSet FOLLOW_unExpression_in_unExpression442 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpression455 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpression_in_mulExpression488 = new BitSet(new long[]{0x0000000004800002L});
	public static final BitSet FOLLOW_set_in_mulExpression496 = new BitSet(new long[]{0x0000000003137040L});
	public static final BitSet FOLLOW_unExpression_in_mulExpression508 = new BitSet(new long[]{0x0000000004800002L});
	public static final BitSet FOLLOW_mulExpression_in_addExpression537 = new BitSet(new long[]{0x0000000003000002L});
	public static final BitSet FOLLOW_set_in_addExpression545 = new BitSet(new long[]{0x0000000003137040L});
	public static final BitSet FOLLOW_mulExpression_in_addExpression555 = new BitSet(new long[]{0x0000000003000002L});
	public static final BitSet FOLLOW_addExpression_in_relExpression585 = new BitSet(new long[]{0x00000001F0200002L});
	public static final BitSet FOLLOW_set_in_relExpression593 = new BitSet(new long[]{0x0000000003137040L});
	public static final BitSet FOLLOW_addExpression_in_relExpression609 = new BitSet(new long[]{0x00000001F0200002L});
	public static final BitSet FOLLOW_relExpression_in_andExpression642 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_22_in_andExpression648 = new BitSet(new long[]{0x0000000003137040L});
	public static final BitSet FOLLOW_relExpression_in_andExpression652 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_andExpression_in_orExpression682 = new BitSet(new long[]{0x0000000200000002L});
	public static final BitSet FOLLOW_33_in_orExpression688 = new BitSet(new long[]{0x0000000003137040L});
	public static final BitSet FOLLOW_andExpression_in_orExpression692 = new BitSet(new long[]{0x0000000200000002L});
	public static final BitSet FOLLOW_IF_in_synpred4_QL157 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_PARENTHESES_OPEN_in_synpred4_QL159 = new BitSet(new long[]{0x0000000003137040L});
	public static final BitSet FOLLOW_orExpression_in_synpred4_QL163 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_PARENTHESES_CLOSE_in_synpred4_QL165 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_BLOCK_START_in_synpred4_QL167 = new BitSet(new long[]{0x0000000000001800L});
	public static final BitSet FOLLOW_elements_in_synpred4_QL171 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_BLOCK_END_in_synpred4_QL173 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_ELSE_in_synpred4_QL175 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_BLOCK_START_in_synpred4_QL177 = new BitSet(new long[]{0x0000000000001800L});
	public static final BitSet FOLLOW_elements_in_synpred4_QL181 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_BLOCK_END_in_synpred4_QL183 = new BitSet(new long[]{0x0000000000000002L});
}
