// $ANTLR 3.5 /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g 2013-02-18 13:39:57

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.parser.errors.*;
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
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "Bool", "COMMENT", "EscapedCharacterSequence", 
		"Ident", "Int", "Money", "String", "Type", "WS", "'!'", "'!='", "'&&'", 
		"'('", "')'", "'*'", "'+'", "'-'", "'/'", "':'", "'<'", "'<='", "'=='", 
		"'>'", "'>='", "'else'", "'form'", "'if'", "'{'", "'||'", "'}'"
	};
	public static final int EOF=-1;
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
	public static final int Bool=4;
	public static final int COMMENT=5;
	public static final int EscapedCharacterSequence=6;
	public static final int Ident=7;
	public static final int Int=8;
	public static final int Money=9;
	public static final int String=10;
	public static final int Type=11;
	public static final int WS=12;

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
		this.state.ruleMemo = new HashMap[38+1];


	}

	@Override public String[] getTokenNames() { return QLParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g"; }


	  // Syntax error reporter to use instead of the default (see: http://www.antlr.org/wiki/display/ANTLR3/Error+reporting+and+recovery)
	  private ISyntaxErrorReporter syntaxErrorReporter;
	  
	  public void setErrorReporter(final ISyntaxErrorReporter syntaxErrorReporter) {
	    this.syntaxErrorReporter = syntaxErrorReporter;
	  }
	  
	  private SyntaxPosition getSyntaxPosition(final Token token) {
	    return new SyntaxPosition(token.getLine(), token.getCharPositionInLine());
		}
		
		private String getUnquotedString(final String text) {
		  return text.substring(1, text.length() - 1);
		}

		@Override
	  public void reportError(RecognitionException e) {
	    if (syntaxErrorReporter == null) {
	      super.reportError(e);
	      return;
	    }
	    
	    final String message = getErrorMessage(e, this.getTokenNames());
	    syntaxErrorReporter.reportError(new SyntaxErrorMessage(new SyntaxPosition(e.line, e.charPositionInLine), message));
	  }



	// $ANTLR start "form"
	// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:74:1: form returns [Form result] : formStatement= 'form' Ident '{' formStatements= statements '}' ;
	public final Form form() throws RecognitionException {
		Form result = null;

		int form_StartIndex = input.index();

		Token formStatement=null;
		Token Ident1=null;
		List<Statement> formStatements =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:75:3: (formStatement= 'form' Ident '{' formStatements= statements '}' )
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:75:5: formStatement= 'form' Ident '{' formStatements= statements '}'
			{
			formStatement=(Token)match(input,29,FOLLOW_29_in_form66); if (state.failed) return result;
			Ident1=(Token)match(input,Ident,FOLLOW_Ident_in_form68); if (state.failed) return result;
			match(input,31,FOLLOW_31_in_form70); if (state.failed) return result;
			pushFollow(FOLLOW_statements_in_form74);
			formStatements=statements();
			state._fsp--;
			if (state.failed) return result;
			match(input,33,FOLLOW_33_in_form76); if (state.failed) return result;
			if ( state.backtracking==0 ) {    
			    result = new Form((Ident1!=null?Ident1.getText():null), formStatements, getSyntaxPosition(formStatement));
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



	// $ANTLR start "statements"
	// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:79:1: statements returns [List<Statement> results] : ( statement )* ;
	public final List<Statement> statements() throws RecognitionException {
		List<Statement> results = null;

		int statements_StartIndex = input.index();

		Statement statement2 =null;

		 results = new ArrayList<Statement>(); 
		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return results; }

			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:81:3: ( ( statement )* )
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:81:5: ( statement )*
			{
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:81:5: ( statement )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==Ident||LA1_0==30) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:81:6: statement
					{
					pushFollow(FOLLOW_statement_in_statements100);
					statement2=statement();
					state._fsp--;
					if (state.failed) return results;
					if ( state.backtracking==0 ) { results.add(statement2); }
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
			if ( state.backtracking>0 ) { memoize(input, 2, statements_StartIndex); }

		}
		return results;
	}
	// $ANTLR end "statements"



	// $ANTLR start "statement"
	// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:83:1: statement returns [Statement result] : ( question | computation | ifStatement );
	public final Statement statement() throws RecognitionException {
		Statement result = null;

		int statement_StartIndex = input.index();

		Question question3 =null;
		Computation computation4 =null;
		IfStatement ifStatement5 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:84:5: ( question | computation | ifStatement )
			int alt2=3;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==Ident) ) {
				int LA2_1 = input.LA(2);
				if ( (LA2_1==22) ) {
					int LA2_3 = input.LA(3);
					if ( (LA2_3==String) ) {
						int LA2_4 = input.LA(4);
						if ( (LA2_4==Type) ) {
							int LA2_5 = input.LA(5);
							if ( (LA2_5==EOF||LA2_5==Ident||LA2_5==30||LA2_5==33) ) {
								alt2=1;
							}
							else if ( (LA2_5==16) ) {
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
			else if ( (LA2_0==30) ) {
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
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:84:7: question
					{
					pushFollow(FOLLOW_question_in_statement120);
					question3=question();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = question3; }
					}
					break;
				case 2 :
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:85:7: computation
					{
					pushFollow(FOLLOW_computation_in_statement130);
					computation4=computation();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = computation4; }
					}
					break;
				case 3 :
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:86:7: ifStatement
					{
					pushFollow(FOLLOW_ifStatement_in_statement140);
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
			if ( state.backtracking>0 ) { memoize(input, 3, statement_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "statement"



	// $ANTLR start "ifStatement"
	// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:88:1: ifStatement returns [IfStatement result] : (line= ( 'if' '(' condition= orExpression ')' '{' successStatements= statements '}' 'else' '{' elseStatements= statements '}' ) |line= ( 'if' '(' condition= orExpression ')' '{' successStatements= statements '}' ) );
	public final IfStatement ifStatement() throws RecognitionException {
		IfStatement result = null;

		int ifStatement_StartIndex = input.index();

		Token line=null;
		Expression condition =null;
		List<Statement> successStatements =null;
		List<Statement> elseStatements =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:89:5: (line= ( 'if' '(' condition= orExpression ')' '{' successStatements= statements '}' 'else' '{' elseStatements= statements '}' ) |line= ( 'if' '(' condition= orExpression ')' '{' successStatements= statements '}' ) )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==30) ) {
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
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:89:7: line= ( 'if' '(' condition= orExpression ')' '{' successStatements= statements '}' 'else' '{' elseStatements= statements '}' )
					{
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:89:12: ( 'if' '(' condition= orExpression ')' '{' successStatements= statements '}' 'else' '{' elseStatements= statements '}' )
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:89:13: 'if' '(' condition= orExpression ')' '{' successStatements= statements '}' 'else' '{' elseStatements= statements '}'
					{
					line=(Token)match(input,30,FOLLOW_30_in_ifStatement161); if (state.failed) return result;
					line=(Token)match(input,16,FOLLOW_16_in_ifStatement163); if (state.failed) return result;
					pushFollow(FOLLOW_orExpression_in_ifStatement167);
					condition=orExpression();
					state._fsp--;
					if (state.failed) return result;
					line=(Token)match(input,17,FOLLOW_17_in_ifStatement169); if (state.failed) return result;
					line=(Token)match(input,31,FOLLOW_31_in_ifStatement171); if (state.failed) return result;
					pushFollow(FOLLOW_statements_in_ifStatement175);
					successStatements=statements();
					state._fsp--;
					if (state.failed) return result;
					line=(Token)match(input,33,FOLLOW_33_in_ifStatement177); if (state.failed) return result;
					line=(Token)match(input,28,FOLLOW_28_in_ifStatement179); if (state.failed) return result;
					line=(Token)match(input,31,FOLLOW_31_in_ifStatement181); if (state.failed) return result;
					pushFollow(FOLLOW_statements_in_ifStatement185);
					elseStatements=statements();
					state._fsp--;
					if (state.failed) return result;
					line=(Token)match(input,33,FOLLOW_33_in_ifStatement187); if (state.failed) return result;
					}

					if ( state.backtracking==0 ) {
					      result = new IfThenElse(condition, successStatements, elseStatements, getSyntaxPosition(line));
					    }
					}
					break;
				case 2 :
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:93:7: line= ( 'if' '(' condition= orExpression ')' '{' successStatements= statements '}' )
					{
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:93:12: ( 'if' '(' condition= orExpression ')' '{' successStatements= statements '}' )
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:93:13: 'if' '(' condition= orExpression ')' '{' successStatements= statements '}'
					{
					line=(Token)match(input,30,FOLLOW_30_in_ifStatement205); if (state.failed) return result;
					line=(Token)match(input,16,FOLLOW_16_in_ifStatement207); if (state.failed) return result;
					pushFollow(FOLLOW_orExpression_in_ifStatement211);
					condition=orExpression();
					state._fsp--;
					if (state.failed) return result;
					line=(Token)match(input,17,FOLLOW_17_in_ifStatement213); if (state.failed) return result;
					line=(Token)match(input,31,FOLLOW_31_in_ifStatement215); if (state.failed) return result;
					pushFollow(FOLLOW_statements_in_ifStatement219);
					successStatements=statements();
					state._fsp--;
					if (state.failed) return result;
					line=(Token)match(input,33,FOLLOW_33_in_ifStatement221); if (state.failed) return result;
					}

					if ( state.backtracking==0 ) {
					      result = new IfThen(condition, successStatements, getSyntaxPosition(line));
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



	// $ANTLR start "computation"
	// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:98:1: computation returns [Computation result] : id= Ident ':' String parameter= dataType '(' operation= orExpression ')' ;
	public final Computation computation() throws RecognitionException {
		Computation result = null;

		int computation_StartIndex = input.index();

		Token id=null;
		Token String6=null;
		DataType parameter =null;
		Expression operation =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:99:3: (id= Ident ':' String parameter= dataType '(' operation= orExpression ')' )
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:99:5: id= Ident ':' String parameter= dataType '(' operation= orExpression ')'
			{
			id=(Token)match(input,Ident,FOLLOW_Ident_in_computation244); if (state.failed) return result;
			match(input,22,FOLLOW_22_in_computation246); if (state.failed) return result;
			String6=(Token)match(input,String,FOLLOW_String_in_computation248); if (state.failed) return result;
			pushFollow(FOLLOW_dataType_in_computation252);
			parameter=dataType();
			state._fsp--;
			if (state.failed) return result;
			match(input,16,FOLLOW_16_in_computation254); if (state.failed) return result;
			pushFollow(FOLLOW_orExpression_in_computation258);
			operation=orExpression();
			state._fsp--;
			if (state.failed) return result;
			match(input,17,FOLLOW_17_in_computation260); if (state.failed) return result;
			if ( state.backtracking==0 ) {
			    final Ident ident = new Ident((id!=null?id.getText():null), getSyntaxPosition(id));
			    result = new Computation(ident, getUnquotedString((String6!=null?String6.getText():null)), parameter, operation, getSyntaxPosition(id));
			  }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 5, computation_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "computation"



	// $ANTLR start "question"
	// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:104:1: question returns [Question result] : id= Ident ':' String parameter= dataType ;
	public final Question question() throws RecognitionException {
		Question result = null;

		int question_StartIndex = input.index();

		Token id=null;
		Token String7=null;
		DataType parameter =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:105:3: (id= Ident ':' String parameter= dataType )
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:105:5: id= Ident ':' String parameter= dataType
			{
			id=(Token)match(input,Ident,FOLLOW_Ident_in_question278); if (state.failed) return result;
			match(input,22,FOLLOW_22_in_question280); if (state.failed) return result;
			String7=(Token)match(input,String,FOLLOW_String_in_question282); if (state.failed) return result;
			pushFollow(FOLLOW_dataType_in_question286);
			parameter=dataType();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) {
			    final Ident ident = new Ident((id!=null?id.getText():null), getSyntaxPosition(id)); 
			    result = new Question(ident, getUnquotedString((String7!=null?String7.getText():null)), parameter, getSyntaxPosition(id));
			  }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 6, question_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "question"



	// $ANTLR start "dataType"
	// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:110:1: dataType returns [DataType result] : Type ;
	public final DataType dataType() throws RecognitionException {
		DataType result = null;

		int dataType_StartIndex = input.index();

		Token Type8=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:111:2: ( Type )
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:111:4: Type
			{
			Type8=(Token)match(input,Type,FOLLOW_Type_in_dataType303); if (state.failed) return result;
			if ( state.backtracking==0 ) {
			    if ((Type8!=null?Type8.getText():null).equals("string")) result = new StringType();
			    else if ((Type8!=null?Type8.getText():null).equals("integer")) result = new IntType();
			    else if ((Type8!=null?Type8.getText():null).equals("money")) result = new MoneyType();
			    else if ((Type8!=null?Type8.getText():null).equals("boolean")) result = new BoolType();
			 }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 7, dataType_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "dataType"



	// $ANTLR start "primary"
	// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:118:1: primary returns [Expression result] : ( Int | Money | Bool | Ident | String | '(' orExpression ')' );
	public final Expression primary() throws RecognitionException {
		Expression result = null;

		int primary_StartIndex = input.index();

		Token Int9=null;
		Token Money10=null;
		Token Bool11=null;
		Token Ident12=null;
		Token String13=null;
		Expression orExpression14 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:119:3: ( Int | Money | Bool | Ident | String | '(' orExpression ')' )
			int alt4=6;
			switch ( input.LA(1) ) {
			case Int:
				{
				alt4=1;
				}
				break;
			case Money:
				{
				alt4=2;
				}
				break;
			case Bool:
				{
				alt4=3;
				}
				break;
			case Ident:
				{
				alt4=4;
				}
				break;
			case String:
				{
				alt4=5;
				}
				break;
			case 16:
				{
				alt4=6;
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
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:119:5: Int
					{
					Int9=(Token)match(input,Int,FOLLOW_Int_in_primary320); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new IntLiteral(Integer.parseInt((Int9!=null?Int9.getText():null)), getSyntaxPosition(Int9)); }
					}
					break;
				case 2 :
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:120:5: Money
					{
					Money10=(Token)match(input,Money,FOLLOW_Money_in_primary330); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new MoneyLiteral((Money10!=null?Money10.getText():null), getSyntaxPosition(Money10)); }
					}
					break;
				case 3 :
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:121:5: Bool
					{
					Bool11=(Token)match(input,Bool,FOLLOW_Bool_in_primary338); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new BoolLiteral(Boolean.parseBoolean((Bool11!=null?Bool11.getText():null)), getSyntaxPosition(Bool11)); }
					}
					break;
				case 4 :
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:122:5: Ident
					{
					Ident12=(Token)match(input,Ident,FOLLOW_Ident_in_primary346); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Ident((Ident12!=null?Ident12.getText():null), getSyntaxPosition(Ident12)); }
					}
					break;
				case 5 :
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:123:5: String
					{
					String13=(Token)match(input,String,FOLLOW_String_in_primary354); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new StringLiteral(getUnquotedString((String13!=null?String13.getText():null)), getSyntaxPosition(String13)); }
					}
					break;
				case 6 :
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:124:5: '(' orExpression ')'
					{
					match(input,16,FOLLOW_16_in_primary362); if (state.failed) return result;
					pushFollow(FOLLOW_orExpression_in_primary364);
					orExpression14=orExpression();
					state._fsp--;
					if (state.failed) return result;
					match(input,17,FOLLOW_17_in_primary366); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = orExpression14; }
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



	// $ANTLR start "unExpression"
	// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:126:1: unExpression returns [Expression result] : (op= '+' x= unExpression |op= '-' x= unExpression |op= '!' x= unExpression |x= primary );
	public final Expression unExpression() throws RecognitionException {
		Expression result = null;

		int unExpression_StartIndex = input.index();

		Token op=null;
		Expression x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:127:5: (op= '+' x= unExpression |op= '-' x= unExpression |op= '!' x= unExpression |x= primary )
			int alt5=4;
			switch ( input.LA(1) ) {
			case 19:
				{
				alt5=1;
				}
				break;
			case 20:
				{
				alt5=2;
				}
				break;
			case 13:
				{
				alt5=3;
				}
				break;
			case Bool:
			case Ident:
			case Int:
			case Money:
			case String:
			case 16:
				{
				alt5=4;
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
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:127:8: op= '+' x= unExpression
					{
					op=(Token)match(input,19,FOLLOW_19_in_unExpression387); if (state.failed) return result;
					pushFollow(FOLLOW_unExpression_in_unExpression391);
					x=unExpression();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Pos(x, getSyntaxPosition(op)); }
					}
					break;
				case 2 :
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:128:8: op= '-' x= unExpression
					{
					op=(Token)match(input,20,FOLLOW_20_in_unExpression404); if (state.failed) return result;
					pushFollow(FOLLOW_unExpression_in_unExpression408);
					x=unExpression();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Neg(x, getSyntaxPosition(op)); }
					}
					break;
				case 3 :
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:129:8: op= '!' x= unExpression
					{
					op=(Token)match(input,13,FOLLOW_13_in_unExpression421); if (state.failed) return result;
					pushFollow(FOLLOW_unExpression_in_unExpression425);
					x=unExpression();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Not(x, getSyntaxPosition(op)); }
					}
					break;
				case 4 :
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:130:8: x= primary
					{
					pushFollow(FOLLOW_primary_in_unExpression438);
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
			if ( state.backtracking>0 ) { memoize(input, 9, unExpression_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "unExpression"



	// $ANTLR start "mulExpression"
	// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:132:1: mulExpression returns [Expression result] : lhs= unExpression (op= ( '*' | '/' ) rhs= unExpression )* ;
	public final Expression mulExpression() throws RecognitionException {
		Expression result = null;

		int mulExpression_StartIndex = input.index();

		Token op=null;
		Expression lhs =null;
		Expression rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:133:5: (lhs= unExpression (op= ( '*' | '/' ) rhs= unExpression )* )
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:133:9: lhs= unExpression (op= ( '*' | '/' ) rhs= unExpression )*
			{
			pushFollow(FOLLOW_unExpression_in_mulExpression471);
			lhs=unExpression();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:133:51: (op= ( '*' | '/' ) rhs= unExpression )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==18||LA6_0==21) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:133:53: op= ( '*' | '/' ) rhs= unExpression
					{
					op=input.LT(1);
					if ( input.LA(1)==18||input.LA(1)==21 ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_unExpression_in_mulExpression491);
					rhs=unExpression();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { 
					      final SyntaxPosition syntaxPosition = getSyntaxPosition(op);

					      if ((op!=null?op.getText():null).equals("*")) {
					        result = new Mul(result, rhs, syntaxPosition);
					      }
					      if ((op!=null?op.getText():null).equals("/")) {
					        result = new Div(result, rhs, syntaxPosition); 
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
			if ( state.backtracking>0 ) { memoize(input, 10, mulExpression_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "mulExpression"



	// $ANTLR start "addExpression"
	// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:145:1: addExpression returns [Expression result] : lhs= mulExpression (op= ( '+' | '-' ) rhs= mulExpression )* ;
	public final Expression addExpression() throws RecognitionException {
		Expression result = null;

		int addExpression_StartIndex = input.index();

		Token op=null;
		Expression lhs =null;
		Expression rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:146:5: (lhs= mulExpression (op= ( '+' | '-' ) rhs= mulExpression )* )
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:146:9: lhs= mulExpression (op= ( '+' | '-' ) rhs= mulExpression )*
			{
			pushFollow(FOLLOW_mulExpression_in_addExpression520);
			lhs=mulExpression();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:146:52: (op= ( '+' | '-' ) rhs= mulExpression )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( ((LA7_0 >= 19 && LA7_0 <= 20)) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:146:54: op= ( '+' | '-' ) rhs= mulExpression
					{
					op=input.LT(1);
					if ( (input.LA(1) >= 19 && input.LA(1) <= 20) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_mulExpression_in_addExpression538);
					rhs=mulExpression();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { 
					      final SyntaxPosition syntaxPosition = getSyntaxPosition(op);
					    
					      if ((op!=null?op.getText():null).equals("+")) {
					        result = new Add(result, rhs, syntaxPosition);
					      }
					      if ((op!=null?op.getText():null).equals("-")) {
					        result = new Sub(result, rhs, syntaxPosition);
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
			if ( state.backtracking>0 ) { memoize(input, 11, addExpression_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "addExpression"



	// $ANTLR start "relExpression"
	// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:158:1: relExpression returns [Expression result] : lhs= addExpression (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpression )* ;
	public final Expression relExpression() throws RecognitionException {
		Expression result = null;

		int relExpression_StartIndex = input.index();

		Token op=null;
		Expression lhs =null;
		Expression rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }

			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:159:5: (lhs= addExpression (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpression )* )
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:159:9: lhs= addExpression (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpression )*
			{
			pushFollow(FOLLOW_addExpression_in_relExpression568);
			lhs=addExpression();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:159:52: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpression )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==14||(LA8_0 >= 23 && LA8_0 <= 27)) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:159:54: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpression
					{
					op=input.LT(1);
					if ( input.LA(1)==14||(input.LA(1) >= 23 && input.LA(1) <= 27) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_addExpression_in_relExpression592);
					rhs=addExpression();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {
					      final SyntaxPosition syntaxPosition = getSyntaxPosition(op);
					    
					      if ((op!=null?op.getText():null).equals("<")) {
					        result = new LT(result, rhs, syntaxPosition);
					      }
					      if ((op!=null?op.getText():null).equals("<=")) {
					        result = new LEq(result, rhs, syntaxPosition);      
					      }
					      if ((op!=null?op.getText():null).equals(">")) {
					        result = new GT(result, rhs, syntaxPosition);
					      }
					      if ((op!=null?op.getText():null).equals(">=")) {
					        result = new GEq(result, rhs, syntaxPosition);      
					      }
					      if ((op!=null?op.getText():null).equals("==")) {
					        result = new Eq(result, rhs, syntaxPosition);
					      }
					      if ((op!=null?op.getText():null).equals("!=")) {
					        result = new NEq(result, rhs, syntaxPosition);
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
			if ( state.backtracking>0 ) { memoize(input, 12, relExpression_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "relExpression"



	// $ANTLR start "andExpression"
	// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:183:1: andExpression returns [Expression result] : lhs= relExpression (op= '&&' rhs= relExpression )* ;
	public final Expression andExpression() throws RecognitionException {
		Expression result = null;

		int andExpression_StartIndex = input.index();

		Token op=null;
		Expression lhs =null;
		Expression rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return result; }

			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:184:5: (lhs= relExpression (op= '&&' rhs= relExpression )* )
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:184:9: lhs= relExpression (op= '&&' rhs= relExpression )*
			{
			pushFollow(FOLLOW_relExpression_in_andExpression625);
			lhs=relExpression();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:184:52: (op= '&&' rhs= relExpression )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==15) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:184:54: op= '&&' rhs= relExpression
					{
					op=(Token)match(input,15,FOLLOW_15_in_andExpression633); if (state.failed) return result;
					pushFollow(FOLLOW_relExpression_in_andExpression637);
					rhs=relExpression();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new And(result, rhs, getSyntaxPosition(op)); }
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
			if ( state.backtracking>0 ) { memoize(input, 13, andExpression_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "andExpression"



	// $ANTLR start "orExpression"
	// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:187:1: orExpression returns [Expression result] : lhs= andExpression (op= '||' rhs= andExpression )* ;
	public final Expression orExpression() throws RecognitionException {
		Expression result = null;

		int orExpression_StartIndex = input.index();

		Token op=null;
		Expression lhs =null;
		Expression rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return result; }

			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:188:5: (lhs= andExpression (op= '||' rhs= andExpression )* )
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:188:9: lhs= andExpression (op= '||' rhs= andExpression )*
			{
			pushFollow(FOLLOW_andExpression_in_orExpression667);
			lhs=andExpression();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = lhs; }
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:188:54: (op= '||' rhs= andExpression )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==32) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:188:56: op= '||' rhs= andExpression
					{
					op=(Token)match(input,32,FOLLOW_32_in_orExpression675); if (state.failed) return result;
					pushFollow(FOLLOW_andExpression_in_orExpression679);
					rhs=andExpression();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Or(result, rhs, getSyntaxPosition(op)); }
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
			if ( state.backtracking>0 ) { memoize(input, 14, orExpression_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "orExpression"

	// $ANTLR start synpred4_QL
	public final void synpred4_QL_fragment() throws RecognitionException {
		Token line=null;
		Expression condition =null;
		List<Statement> successStatements =null;
		List<Statement> elseStatements =null;

		// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:89:7: (line= ( 'if' '(' condition= orExpression ')' '{' successStatements= statements '}' 'else' '{' elseStatements= statements '}' ) )
		// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:89:7: line= ( 'if' '(' condition= orExpression ')' '{' successStatements= statements '}' 'else' '{' elseStatements= statements '}' )
		{
		// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:89:12: ( 'if' '(' condition= orExpression ')' '{' successStatements= statements '}' 'else' '{' elseStatements= statements '}' )
		// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:89:13: 'if' '(' condition= orExpression ')' '{' successStatements= statements '}' 'else' '{' elseStatements= statements '}'
		{
		line=(Token)match(input,30,FOLLOW_30_in_synpred4_QL161); if (state.failed) return;
		line=(Token)match(input,16,FOLLOW_16_in_synpred4_QL163); if (state.failed) return;
		pushFollow(FOLLOW_orExpression_in_synpred4_QL167);
		condition=orExpression();
		state._fsp--;
		if (state.failed) return;
		line=(Token)match(input,17,FOLLOW_17_in_synpred4_QL169); if (state.failed) return;
		line=(Token)match(input,31,FOLLOW_31_in_synpred4_QL171); if (state.failed) return;
		pushFollow(FOLLOW_statements_in_synpred4_QL175);
		successStatements=statements();
		state._fsp--;
		if (state.failed) return;
		line=(Token)match(input,33,FOLLOW_33_in_synpred4_QL177); if (state.failed) return;
		line=(Token)match(input,28,FOLLOW_28_in_synpred4_QL179); if (state.failed) return;
		line=(Token)match(input,31,FOLLOW_31_in_synpred4_QL181); if (state.failed) return;
		pushFollow(FOLLOW_statements_in_synpred4_QL185);
		elseStatements=statements();
		state._fsp--;
		if (state.failed) return;
		line=(Token)match(input,33,FOLLOW_33_in_synpred4_QL187); if (state.failed) return;
		}

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



	public static final BitSet FOLLOW_29_in_form66 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Ident_in_form68 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_form70 = new BitSet(new long[]{0x0000000240000080L});
	public static final BitSet FOLLOW_statements_in_form74 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_33_in_form76 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_statement_in_statements100 = new BitSet(new long[]{0x0000000040000082L});
	public static final BitSet FOLLOW_question_in_statement120 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_computation_in_statement130 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifStatement_in_statement140 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_30_in_ifStatement161 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_ifStatement163 = new BitSet(new long[]{0x0000000000192790L});
	public static final BitSet FOLLOW_orExpression_in_ifStatement167 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_ifStatement169 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_ifStatement171 = new BitSet(new long[]{0x0000000240000080L});
	public static final BitSet FOLLOW_statements_in_ifStatement175 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_33_in_ifStatement177 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_28_in_ifStatement179 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_ifStatement181 = new BitSet(new long[]{0x0000000240000080L});
	public static final BitSet FOLLOW_statements_in_ifStatement185 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_33_in_ifStatement187 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_30_in_ifStatement205 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_ifStatement207 = new BitSet(new long[]{0x0000000000192790L});
	public static final BitSet FOLLOW_orExpression_in_ifStatement211 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_ifStatement213 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_ifStatement215 = new BitSet(new long[]{0x0000000240000080L});
	public static final BitSet FOLLOW_statements_in_ifStatement219 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_33_in_ifStatement221 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_computation244 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_computation246 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_String_in_computation248 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_dataType_in_computation252 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_computation254 = new BitSet(new long[]{0x0000000000192790L});
	public static final BitSet FOLLOW_orExpression_in_computation258 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_computation260 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_question278 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_question280 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_String_in_question282 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_dataType_in_question286 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Type_in_dataType303 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Int_in_primary320 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Money_in_primary330 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Bool_in_primary338 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_primary346 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_String_in_primary354 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_16_in_primary362 = new BitSet(new long[]{0x0000000000192790L});
	public static final BitSet FOLLOW_orExpression_in_primary364 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_primary366 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_19_in_unExpression387 = new BitSet(new long[]{0x0000000000192790L});
	public static final BitSet FOLLOW_unExpression_in_unExpression391 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_20_in_unExpression404 = new BitSet(new long[]{0x0000000000192790L});
	public static final BitSet FOLLOW_unExpression_in_unExpression408 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_13_in_unExpression421 = new BitSet(new long[]{0x0000000000192790L});
	public static final BitSet FOLLOW_unExpression_in_unExpression425 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpression438 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpression_in_mulExpression471 = new BitSet(new long[]{0x0000000000240002L});
	public static final BitSet FOLLOW_set_in_mulExpression479 = new BitSet(new long[]{0x0000000000192790L});
	public static final BitSet FOLLOW_unExpression_in_mulExpression491 = new BitSet(new long[]{0x0000000000240002L});
	public static final BitSet FOLLOW_mulExpression_in_addExpression520 = new BitSet(new long[]{0x0000000000180002L});
	public static final BitSet FOLLOW_set_in_addExpression528 = new BitSet(new long[]{0x0000000000192790L});
	public static final BitSet FOLLOW_mulExpression_in_addExpression538 = new BitSet(new long[]{0x0000000000180002L});
	public static final BitSet FOLLOW_addExpression_in_relExpression568 = new BitSet(new long[]{0x000000000F804002L});
	public static final BitSet FOLLOW_set_in_relExpression576 = new BitSet(new long[]{0x0000000000192790L});
	public static final BitSet FOLLOW_addExpression_in_relExpression592 = new BitSet(new long[]{0x000000000F804002L});
	public static final BitSet FOLLOW_relExpression_in_andExpression625 = new BitSet(new long[]{0x0000000000008002L});
	public static final BitSet FOLLOW_15_in_andExpression633 = new BitSet(new long[]{0x0000000000192790L});
	public static final BitSet FOLLOW_relExpression_in_andExpression637 = new BitSet(new long[]{0x0000000000008002L});
	public static final BitSet FOLLOW_andExpression_in_orExpression667 = new BitSet(new long[]{0x0000000100000002L});
	public static final BitSet FOLLOW_32_in_orExpression675 = new BitSet(new long[]{0x0000000000192790L});
	public static final BitSet FOLLOW_andExpression_in_orExpression679 = new BitSet(new long[]{0x0000000100000002L});
	public static final BitSet FOLLOW_30_in_synpred4_QL161 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_synpred4_QL163 = new BitSet(new long[]{0x0000000000192790L});
	public static final BitSet FOLLOW_orExpression_in_synpred4_QL167 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_synpred4_QL169 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_synpred4_QL171 = new BitSet(new long[]{0x0000000240000080L});
	public static final BitSet FOLLOW_statements_in_synpred4_QL175 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_33_in_synpred4_QL177 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_28_in_synpred4_QL179 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_synpred4_QL181 = new BitSet(new long[]{0x0000000240000080L});
	public static final BitSet FOLLOW_statements_in_synpred4_QL185 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_33_in_synpred4_QL187 = new BitSet(new long[]{0x0000000000000002L});
}
