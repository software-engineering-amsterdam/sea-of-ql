// $ANTLR 3.5 /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g 2013-02-04 13:34:29

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.base.*;
import org.uva.sea.ql.ast.form.*;
import org.uva.sea.ql.ast.types.*;
import org.uva.sea.ql.ast.types.literals.*;
import org.uva.sea.ql.ast.types.datatypes.*;
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
		"COMMENT", "ELSE", "ENDOFFILE", "EscapedCharacterSequence", "FORM", "IF", 
		"Ident", "Int", "Money", "PARENTHESES_CLOSE", "PARENTHESES_OPEN", "String", 
		"Type", "WS", "'!'", "'!='", "'&&'", "'*'", "'+'", "'-'", "'/'", "':'", 
		"'<'", "'<='", "'=='", "'>'", "'>='", "'||'"
	};
	public static final int EOF=-1;
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
	public static final int BLOCK_END=4;
	public static final int BLOCK_START=5;
	public static final int Bool=6;
	public static final int COMMENT=7;
	public static final int ELSE=8;
	public static final int ENDOFFILE=9;
	public static final int EscapedCharacterSequence=10;
	public static final int FORM=11;
	public static final int IF=12;
	public static final int Ident=13;
	public static final int Int=14;
	public static final int Money=15;
	public static final int PARENTHESES_CLOSE=16;
	public static final int PARENTHESES_OPEN=17;
	public static final int String=18;
	public static final int Type=19;
	public static final int WS=20;

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
	@Override public String getGrammarFileName() { return "/Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g"; }





	// $ANTLR start "form"
	// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:30:1: form returns [Form result] : FORM Ident BLOCK_START e= elements BLOCK_END ;
	public final Form form() throws RecognitionException {
		Form result = null;

		int form_StartIndex = input.index();

		Token Ident1=null;
		List<Element> e =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:31:3: ( FORM Ident BLOCK_START e= elements BLOCK_END )
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:31:5: FORM Ident BLOCK_START e= elements BLOCK_END
			{
			match(input,FORM,FOLLOW_FORM_in_form64); if (state.failed) return result;
			Ident1=(Token)match(input,Ident,FOLLOW_Ident_in_form66); if (state.failed) return result;
			match(input,BLOCK_START,FOLLOW_BLOCK_START_in_form68); if (state.failed) return result;
			pushFollow(FOLLOW_elements_in_form72);
			e=elements();
			state._fsp--;
			if (state.failed) return result;
			match(input,BLOCK_END,FOLLOW_BLOCK_END_in_form74); if (state.failed) return result;
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
	// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:35:1: elements returns [List<Element> results] : ( element )* ;
	public final List<Element> elements() throws RecognitionException {
		List<Element> results = null;

		int elements_StartIndex = input.index();

		Element element2 =null;

		 results = new ArrayList<Element>(); 
		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return results; }

			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:37:3: ( ( element )* )
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:37:5: ( element )*
			{
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:37:5: ( element )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= IF && LA1_0 <= Ident)) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:37:6: element
					{
					pushFollow(FOLLOW_element_in_elements98);
					element2=element();
					state._fsp--;
					if (state.failed) return results;
					if ( state.backtracking==0 ) { results.add(element2); }
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
			if ( state.backtracking>0 ) { memoize(input, 2, elements_StartIndex); }

		}
		return results;
	}
	// $ANTLR end "elements"



	// $ANTLR start "element"
	// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:39:1: element returns [Element result] : ( question | computation | ifStatement );
	public final Element element() throws RecognitionException {
		Element result = null;

		int element_StartIndex = input.index();

		Question question3 =null;
		Computation computation4 =null;
		IfStatement ifStatement5 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:40:5: ( question | computation | ifStatement )
			int alt2=3;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==Ident) ) {
				int LA2_1 = input.LA(2);
				if ( (LA2_1==28) ) {
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
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:40:7: question
					{
					pushFollow(FOLLOW_question_in_element118);
					question3=question();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = question3; }
					}
					break;
				case 2 :
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:41:7: computation
					{
					pushFollow(FOLLOW_computation_in_element128);
					computation4=computation();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = computation4; }
					}
					break;
				case 3 :
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:42:7: ifStatement
					{
					pushFollow(FOLLOW_ifStatement_in_element138);
					ifStatement5=ifStatement();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = ifStatement5; }
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



	// $ANTLR start "ifStatement"
	// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:44:1: ifStatement returns [IfStatement result] : ( IF PARENTHESES_OPEN condition= orExpression PARENTHESES_CLOSE BLOCK_START successStatements= elements BLOCK_END ELSE BLOCK_START elseStatements= elements BLOCK_END | IF PARENTHESES_OPEN condition= orExpression PARENTHESES_CLOSE BLOCK_START successStatements= elements BLOCK_END );
	public final IfStatement ifStatement() throws RecognitionException {
		IfStatement result = null;

		int ifStatement_StartIndex = input.index();

		Expression condition =null;
		List<Element> successStatements =null;
		List<Element> elseStatements =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:45:5: ( IF PARENTHESES_OPEN condition= orExpression PARENTHESES_CLOSE BLOCK_START successStatements= elements BLOCK_END ELSE BLOCK_START elseStatements= elements BLOCK_END | IF PARENTHESES_OPEN condition= orExpression PARENTHESES_CLOSE BLOCK_START successStatements= elements BLOCK_END )
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
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:45:7: IF PARENTHESES_OPEN condition= orExpression PARENTHESES_CLOSE BLOCK_START successStatements= elements BLOCK_END ELSE BLOCK_START elseStatements= elements BLOCK_END
					{
					match(input,IF,FOLLOW_IF_in_ifStatement156); if (state.failed) return result;
					match(input,PARENTHESES_OPEN,FOLLOW_PARENTHESES_OPEN_in_ifStatement158); if (state.failed) return result;
					pushFollow(FOLLOW_orExpression_in_ifStatement162);
					condition=orExpression();
					state._fsp--;
					if (state.failed) return result;
					match(input,PARENTHESES_CLOSE,FOLLOW_PARENTHESES_CLOSE_in_ifStatement164); if (state.failed) return result;
					match(input,BLOCK_START,FOLLOW_BLOCK_START_in_ifStatement166); if (state.failed) return result;
					pushFollow(FOLLOW_elements_in_ifStatement170);
					successStatements=elements();
					state._fsp--;
					if (state.failed) return result;
					match(input,BLOCK_END,FOLLOW_BLOCK_END_in_ifStatement172); if (state.failed) return result;
					match(input,ELSE,FOLLOW_ELSE_in_ifStatement174); if (state.failed) return result;
					match(input,BLOCK_START,FOLLOW_BLOCK_START_in_ifStatement176); if (state.failed) return result;
					pushFollow(FOLLOW_elements_in_ifStatement180);
					elseStatements=elements();
					state._fsp--;
					if (state.failed) return result;
					match(input,BLOCK_END,FOLLOW_BLOCK_END_in_ifStatement182); if (state.failed) return result;
					if ( state.backtracking==0 ) {
					      result = new IfThenElse(condition, successStatements, elseStatements);
					    }
					}
					break;
				case 2 :
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:49:7: IF PARENTHESES_OPEN condition= orExpression PARENTHESES_CLOSE BLOCK_START successStatements= elements BLOCK_END
					{
					match(input,IF,FOLLOW_IF_in_ifStatement196); if (state.failed) return result;
					match(input,PARENTHESES_OPEN,FOLLOW_PARENTHESES_OPEN_in_ifStatement198); if (state.failed) return result;
					pushFollow(FOLLOW_orExpression_in_ifStatement202);
					condition=orExpression();
					state._fsp--;
					if (state.failed) return result;
					match(input,PARENTHESES_CLOSE,FOLLOW_PARENTHESES_CLOSE_in_ifStatement204); if (state.failed) return result;
					match(input,BLOCK_START,FOLLOW_BLOCK_START_in_ifStatement206); if (state.failed) return result;
					pushFollow(FOLLOW_elements_in_ifStatement210);
					successStatements=elements();
					state._fsp--;
					if (state.failed) return result;
					match(input,BLOCK_END,FOLLOW_BLOCK_END_in_ifStatement212); if (state.failed) return result;
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
			if ( state.backtracking>0 ) { memoize(input, 4, ifStatement_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "ifStatement"



	// $ANTLR start "questions"
	// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:54:1: questions returns [List<Question> results] : ( question )+ ;
	public final List<Question> questions() throws RecognitionException {
		List<Question> results = null;

		int questions_StartIndex = input.index();

		Question question6 =null;

		 results = new ArrayList<Question>(); 
		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return results; }

			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:56:5: ( ( question )+ )
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:56:7: ( question )+
			{
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:56:7: ( question )+
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
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:56:8: question
					{
					pushFollow(FOLLOW_question_in_questions246);
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
	// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:58:1: computation returns [Computation result] : label= Ident ':' String parameter= dataType PARENTHESES_OPEN operation= orExpression PARENTHESES_CLOSE ;
	public final Computation computation() throws RecognitionException {
		Computation result = null;

		int computation_StartIndex = input.index();

		Token label=null;
		Token String7=null;
		DataType parameter =null;
		Expression operation =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:59:3: (label= Ident ':' String parameter= dataType PARENTHESES_OPEN operation= orExpression PARENTHESES_CLOSE )
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:59:5: label= Ident ':' String parameter= dataType PARENTHESES_OPEN operation= orExpression PARENTHESES_CLOSE
			{
			label=(Token)match(input,Ident,FOLLOW_Ident_in_computation266); if (state.failed) return result;
			match(input,28,FOLLOW_28_in_computation268); if (state.failed) return result;
			String7=(Token)match(input,String,FOLLOW_String_in_computation270); if (state.failed) return result;
			pushFollow(FOLLOW_dataType_in_computation274);
			parameter=dataType();
			state._fsp--;
			if (state.failed) return result;
			match(input,PARENTHESES_OPEN,FOLLOW_PARENTHESES_OPEN_in_computation276); if (state.failed) return result;
			pushFollow(FOLLOW_orExpression_in_computation280);
			operation=orExpression();
			state._fsp--;
			if (state.failed) return result;
			match(input,PARENTHESES_CLOSE,FOLLOW_PARENTHESES_CLOSE_in_computation282); if (state.failed) return result;
			if ( state.backtracking==0 ) {
			    result = new Computation(new Ident((label!=null?label.getText():null)), (String7!=null?String7.getText():null).substring(1, (String7!=null?String7.getText():null).length() - 1), parameter, operation);
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
	// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:63:1: question returns [Question result] : label= Ident ':' String parameter= dataType ;
	public final Question question() throws RecognitionException {
		Question result = null;

		int question_StartIndex = input.index();

		Token label=null;
		Token String8=null;
		DataType parameter =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:64:3: (label= Ident ':' String parameter= dataType )
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:64:5: label= Ident ':' String parameter= dataType
			{
			label=(Token)match(input,Ident,FOLLOW_Ident_in_question300); if (state.failed) return result;
			match(input,28,FOLLOW_28_in_question302); if (state.failed) return result;
			String8=(Token)match(input,String,FOLLOW_String_in_question304); if (state.failed) return result;
			pushFollow(FOLLOW_dataType_in_question308);
			parameter=dataType();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) {
			    result = new Question(new Ident((label!=null?label.getText():null)), (String8!=null?String8.getText():null).substring(1, (String8!=null?String8.getText():null).length() - 1), parameter);
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
	// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:68:1: dataType returns [DataType result] : Type ;
	public final DataType dataType() throws RecognitionException {
		DataType result = null;

		int dataType_StartIndex = input.index();

		Token Type9=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:69:2: ( Type )
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:69:4: Type
			{
			Type9=(Token)match(input,Type,FOLLOW_Type_in_dataType325); if (state.failed) return result;
			if ( state.backtracking==0 ) {
			    // TODO: instances
			    if ((Type9!=null?Type9.getText():null).equals("string")) result = new StringType();
			    else if ((Type9!=null?Type9.getText():null).equals("integer")) result = new IntType();
			    else if ((Type9!=null?Type9.getText():null).equals("money")) result = new MoneyType();
			    else if ((Type9!=null?Type9.getText():null).equals("boolean")) result = new BoolType();
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
	// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:77:1: primary returns [Expression result] : ( Int | Money | Bool | Ident | String | PARENTHESES_OPEN orExpression PARENTHESES_CLOSE );
	public final Expression primary() throws RecognitionException {
		Expression result = null;

		int primary_StartIndex = input.index();

		Token Int10=null;
		Token Money11=null;
		Token Bool12=null;
		Token Ident13=null;
		Token String14=null;
		Expression orExpression15 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:78:3: ( Int | Money | Bool | Ident | String | PARENTHESES_OPEN orExpression PARENTHESES_CLOSE )
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
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:78:5: Int
					{
					Int10=(Token)match(input,Int,FOLLOW_Int_in_primary342); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new IntLiteral(Integer.parseInt((Int10!=null?Int10.getText():null))); }
					}
					break;
				case 2 :
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:79:5: Money
					{
					Money11=(Token)match(input,Money,FOLLOW_Money_in_primary352); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new MoneyLiteral((Money11!=null?Money11.getText():null)); }
					}
					break;
				case 3 :
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:80:5: Bool
					{
					Bool12=(Token)match(input,Bool,FOLLOW_Bool_in_primary360); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new BoolLiteral(Boolean.parseBoolean((Bool12!=null?Bool12.getText():null))); }
					}
					break;
				case 4 :
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:81:5: Ident
					{
					Ident13=(Token)match(input,Ident,FOLLOW_Ident_in_primary368); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Ident((Ident13!=null?Ident13.getText():null)); }
					}
					break;
				case 5 :
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:82:5: String
					{
					String14=(Token)match(input,String,FOLLOW_String_in_primary376); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new StringLiteral((String14!=null?String14.getText():null).substring(1, (String14!=null?String14.getText():null).length() - 1)); }
					}
					break;
				case 6 :
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:83:5: PARENTHESES_OPEN orExpression PARENTHESES_CLOSE
					{
					match(input,PARENTHESES_OPEN,FOLLOW_PARENTHESES_OPEN_in_primary384); if (state.failed) return result;
					pushFollow(FOLLOW_orExpression_in_primary386);
					orExpression15=orExpression();
					state._fsp--;
					if (state.failed) return result;
					match(input,PARENTHESES_CLOSE,FOLLOW_PARENTHESES_CLOSE_in_primary388); if (state.failed) return result;
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
	// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:85:1: unExpression returns [Expression result] : ( '+' x= unExpression | '-' x= unExpression | '!' x= unExpression |x= primary );
	public final Expression unExpression() throws RecognitionException {
		Expression result = null;

		int unExpression_StartIndex = input.index();

		Expression x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:86:5: ( '+' x= unExpression | '-' x= unExpression | '!' x= unExpression |x= primary )
			int alt6=4;
			switch ( input.LA(1) ) {
			case 25:
				{
				alt6=1;
				}
				break;
			case 26:
				{
				alt6=2;
				}
				break;
			case 21:
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
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:86:8: '+' x= unExpression
					{
					match(input,25,FOLLOW_25_in_unExpression407); if (state.failed) return result;
					pushFollow(FOLLOW_unExpression_in_unExpression411);
					x=unExpression();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Pos(x); }
					}
					break;
				case 2 :
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:87:8: '-' x= unExpression
					{
					match(input,26,FOLLOW_26_in_unExpression422); if (state.failed) return result;
					pushFollow(FOLLOW_unExpression_in_unExpression426);
					x=unExpression();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Neg(x); }
					}
					break;
				case 3 :
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:88:8: '!' x= unExpression
					{
					match(input,21,FOLLOW_21_in_unExpression437); if (state.failed) return result;
					pushFollow(FOLLOW_unExpression_in_unExpression441);
					x=unExpression();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Not(x); }
					}
					break;
				case 4 :
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:89:8: x= primary
					{
					pushFollow(FOLLOW_primary_in_unExpression454);
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
	// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:91:1: mulExpression returns [Expression result] : lhs= unExpression (op= ( '*' | '/' ) rhs= unExpression )* ;
	public final Expression mulExpression() throws RecognitionException {
		Expression result = null;

		int mulExpression_StartIndex = input.index();

		Token op=null;
		Expression lhs =null;
		Expression rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:92:5: (lhs= unExpression (op= ( '*' | '/' ) rhs= unExpression )* )
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:92:9: lhs= unExpression (op= ( '*' | '/' ) rhs= unExpression )*
			{
			pushFollow(FOLLOW_unExpression_in_mulExpression487);
			lhs=unExpression();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:92:51: (op= ( '*' | '/' ) rhs= unExpression )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==24||LA7_0==27) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:92:53: op= ( '*' | '/' ) rhs= unExpression
					{
					op=input.LT(1);
					if ( input.LA(1)==24||input.LA(1)==27 ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_unExpression_in_mulExpression507);
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
	// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:102:1: addExpression returns [Expression result] : lhs= mulExpression (op= ( '+' | '-' ) rhs= mulExpression )* ;
	public final Expression addExpression() throws RecognitionException {
		Expression result = null;

		int addExpression_StartIndex = input.index();

		Token op=null;
		Expression lhs =null;
		Expression rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }

			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:103:5: (lhs= mulExpression (op= ( '+' | '-' ) rhs= mulExpression )* )
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:103:9: lhs= mulExpression (op= ( '+' | '-' ) rhs= mulExpression )*
			{
			pushFollow(FOLLOW_mulExpression_in_addExpression536);
			lhs=mulExpression();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:103:52: (op= ( '+' | '-' ) rhs= mulExpression )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( ((LA8_0 >= 25 && LA8_0 <= 26)) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:103:54: op= ( '+' | '-' ) rhs= mulExpression
					{
					op=input.LT(1);
					if ( (input.LA(1) >= 25 && input.LA(1) <= 26) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_mulExpression_in_addExpression554);
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
	// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:113:1: relExpression returns [Expression result] : lhs= addExpression (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpression )* ;
	public final Expression relExpression() throws RecognitionException {
		Expression result = null;

		int relExpression_StartIndex = input.index();

		Token op=null;
		Expression lhs =null;
		Expression rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return result; }

			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:114:5: (lhs= addExpression (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpression )* )
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:114:9: lhs= addExpression (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpression )*
			{
			pushFollow(FOLLOW_addExpression_in_relExpression584);
			lhs=addExpression();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:114:52: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpression )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==22||(LA9_0 >= 29 && LA9_0 <= 33)) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:114:54: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpression
					{
					op=input.LT(1);
					if ( input.LA(1)==22||(input.LA(1) >= 29 && input.LA(1) <= 33) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_addExpression_in_relExpression608);
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
	// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:136:1: andExpression returns [Expression result] : lhs= relExpression ( '&&' rhs= relExpression )* ;
	public final Expression andExpression() throws RecognitionException {
		Expression result = null;

		int andExpression_StartIndex = input.index();

		Expression lhs =null;
		Expression rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return result; }

			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:137:5: (lhs= relExpression ( '&&' rhs= relExpression )* )
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:137:9: lhs= relExpression ( '&&' rhs= relExpression )*
			{
			pushFollow(FOLLOW_relExpression_in_andExpression641);
			lhs=relExpression();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:137:52: ( '&&' rhs= relExpression )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==23) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:137:54: '&&' rhs= relExpression
					{
					match(input,23,FOLLOW_23_in_andExpression647); if (state.failed) return result;
					pushFollow(FOLLOW_relExpression_in_andExpression651);
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
	// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:140:1: orExpression returns [Expression result] : lhs= andExpression ( '||' rhs= andExpression )* ;
	public final Expression orExpression() throws RecognitionException {
		Expression result = null;

		int orExpression_StartIndex = input.index();

		Expression lhs =null;
		Expression rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return result; }

			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:141:5: (lhs= andExpression ( '||' rhs= andExpression )* )
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:141:9: lhs= andExpression ( '||' rhs= andExpression )*
			{
			pushFollow(FOLLOW_andExpression_in_orExpression681);
			lhs=andExpression();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = lhs; }
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:141:54: ( '||' rhs= andExpression )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==34) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:141:56: '||' rhs= andExpression
					{
					match(input,34,FOLLOW_34_in_orExpression687); if (state.failed) return result;
					pushFollow(FOLLOW_andExpression_in_orExpression691);
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
		Expression condition =null;
		List<Element> successStatements =null;
		List<Element> elseStatements =null;

		// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:45:7: ( IF PARENTHESES_OPEN condition= orExpression PARENTHESES_CLOSE BLOCK_START successStatements= elements BLOCK_END ELSE BLOCK_START elseStatements= elements BLOCK_END )
		// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:45:7: IF PARENTHESES_OPEN condition= orExpression PARENTHESES_CLOSE BLOCK_START successStatements= elements BLOCK_END ELSE BLOCK_START elseStatements= elements BLOCK_END
		{
		match(input,IF,FOLLOW_IF_in_synpred4_QL156); if (state.failed) return;
		match(input,PARENTHESES_OPEN,FOLLOW_PARENTHESES_OPEN_in_synpred4_QL158); if (state.failed) return;
		pushFollow(FOLLOW_orExpression_in_synpred4_QL162);
		condition=orExpression();
		state._fsp--;
		if (state.failed) return;
		match(input,PARENTHESES_CLOSE,FOLLOW_PARENTHESES_CLOSE_in_synpred4_QL164); if (state.failed) return;
		match(input,BLOCK_START,FOLLOW_BLOCK_START_in_synpred4_QL166); if (state.failed) return;
		pushFollow(FOLLOW_elements_in_synpred4_QL170);
		successStatements=elements();
		state._fsp--;
		if (state.failed) return;
		match(input,BLOCK_END,FOLLOW_BLOCK_END_in_synpred4_QL172); if (state.failed) return;
		match(input,ELSE,FOLLOW_ELSE_in_synpred4_QL174); if (state.failed) return;
		match(input,BLOCK_START,FOLLOW_BLOCK_START_in_synpred4_QL176); if (state.failed) return;
		pushFollow(FOLLOW_elements_in_synpred4_QL180);
		elseStatements=elements();
		state._fsp--;
		if (state.failed) return;
		match(input,BLOCK_END,FOLLOW_BLOCK_END_in_synpred4_QL182); if (state.failed) return;
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



	public static final BitSet FOLLOW_FORM_in_form64 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_Ident_in_form66 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_BLOCK_START_in_form68 = new BitSet(new long[]{0x0000000000003010L});
	public static final BitSet FOLLOW_elements_in_form72 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_BLOCK_END_in_form74 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_element_in_elements98 = new BitSet(new long[]{0x0000000000003002L});
	public static final BitSet FOLLOW_question_in_element118 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_computation_in_element128 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifStatement_in_element138 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_ifStatement156 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_PARENTHESES_OPEN_in_ifStatement158 = new BitSet(new long[]{0x000000000626E040L});
	public static final BitSet FOLLOW_orExpression_in_ifStatement162 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_PARENTHESES_CLOSE_in_ifStatement164 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_BLOCK_START_in_ifStatement166 = new BitSet(new long[]{0x0000000000003010L});
	public static final BitSet FOLLOW_elements_in_ifStatement170 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_BLOCK_END_in_ifStatement172 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_ELSE_in_ifStatement174 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_BLOCK_START_in_ifStatement176 = new BitSet(new long[]{0x0000000000003010L});
	public static final BitSet FOLLOW_elements_in_ifStatement180 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_BLOCK_END_in_ifStatement182 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_ifStatement196 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_PARENTHESES_OPEN_in_ifStatement198 = new BitSet(new long[]{0x000000000626E040L});
	public static final BitSet FOLLOW_orExpression_in_ifStatement202 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_PARENTHESES_CLOSE_in_ifStatement204 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_BLOCK_START_in_ifStatement206 = new BitSet(new long[]{0x0000000000003010L});
	public static final BitSet FOLLOW_elements_in_ifStatement210 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_BLOCK_END_in_ifStatement212 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_question_in_questions246 = new BitSet(new long[]{0x0000000000002002L});
	public static final BitSet FOLLOW_Ident_in_computation266 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_28_in_computation268 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_String_in_computation270 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_dataType_in_computation274 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_PARENTHESES_OPEN_in_computation276 = new BitSet(new long[]{0x000000000626E040L});
	public static final BitSet FOLLOW_orExpression_in_computation280 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_PARENTHESES_CLOSE_in_computation282 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_question300 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_28_in_question302 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_String_in_question304 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_dataType_in_question308 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Type_in_dataType325 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Int_in_primary342 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Money_in_primary352 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Bool_in_primary360 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_primary368 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_String_in_primary376 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PARENTHESES_OPEN_in_primary384 = new BitSet(new long[]{0x000000000626E040L});
	public static final BitSet FOLLOW_orExpression_in_primary386 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_PARENTHESES_CLOSE_in_primary388 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_25_in_unExpression407 = new BitSet(new long[]{0x000000000626E040L});
	public static final BitSet FOLLOW_unExpression_in_unExpression411 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_26_in_unExpression422 = new BitSet(new long[]{0x000000000626E040L});
	public static final BitSet FOLLOW_unExpression_in_unExpression426 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_21_in_unExpression437 = new BitSet(new long[]{0x000000000626E040L});
	public static final BitSet FOLLOW_unExpression_in_unExpression441 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpression454 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpression_in_mulExpression487 = new BitSet(new long[]{0x0000000009000002L});
	public static final BitSet FOLLOW_set_in_mulExpression495 = new BitSet(new long[]{0x000000000626E040L});
	public static final BitSet FOLLOW_unExpression_in_mulExpression507 = new BitSet(new long[]{0x0000000009000002L});
	public static final BitSet FOLLOW_mulExpression_in_addExpression536 = new BitSet(new long[]{0x0000000006000002L});
	public static final BitSet FOLLOW_set_in_addExpression544 = new BitSet(new long[]{0x000000000626E040L});
	public static final BitSet FOLLOW_mulExpression_in_addExpression554 = new BitSet(new long[]{0x0000000006000002L});
	public static final BitSet FOLLOW_addExpression_in_relExpression584 = new BitSet(new long[]{0x00000003E0400002L});
	public static final BitSet FOLLOW_set_in_relExpression592 = new BitSet(new long[]{0x000000000626E040L});
	public static final BitSet FOLLOW_addExpression_in_relExpression608 = new BitSet(new long[]{0x00000003E0400002L});
	public static final BitSet FOLLOW_relExpression_in_andExpression641 = new BitSet(new long[]{0x0000000000800002L});
	public static final BitSet FOLLOW_23_in_andExpression647 = new BitSet(new long[]{0x000000000626E040L});
	public static final BitSet FOLLOW_relExpression_in_andExpression651 = new BitSet(new long[]{0x0000000000800002L});
	public static final BitSet FOLLOW_andExpression_in_orExpression681 = new BitSet(new long[]{0x0000000400000002L});
	public static final BitSet FOLLOW_34_in_orExpression687 = new BitSet(new long[]{0x000000000626E040L});
	public static final BitSet FOLLOW_andExpression_in_orExpression691 = new BitSet(new long[]{0x0000000400000002L});
	public static final BitSet FOLLOW_IF_in_synpred4_QL156 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_PARENTHESES_OPEN_in_synpred4_QL158 = new BitSet(new long[]{0x000000000626E040L});
	public static final BitSet FOLLOW_orExpression_in_synpred4_QL162 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_PARENTHESES_CLOSE_in_synpred4_QL164 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_BLOCK_START_in_synpred4_QL166 = new BitSet(new long[]{0x0000000000003010L});
	public static final BitSet FOLLOW_elements_in_synpred4_QL170 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_BLOCK_END_in_synpred4_QL172 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_ELSE_in_synpred4_QL174 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_BLOCK_START_in_synpred4_QL176 = new BitSet(new long[]{0x0000000000003010L});
	public static final BitSet FOLLOW_elements_in_synpred4_QL180 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_BLOCK_END_in_synpred4_QL182 = new BitSet(new long[]{0x0000000000000002L});
}