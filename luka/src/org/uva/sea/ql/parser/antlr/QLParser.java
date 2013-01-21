// $ANTLR 3.5 /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g 2013-01-19 21:14:47

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings("all")
public class QLParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "Boolean", "COMMENT", "FormId", 
		"FormStart", "IF", "Ident", "Int", "Lbr", "Money", "Question", "QuestionId", 
		"Rbr", "WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", 
		"'/'", "':'", "'<'", "'<='", "'=='", "'>'", "'>='", "'||'"
	};
	public static final int EOF=-1;
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
	public static final int Boolean=4;
	public static final int COMMENT=5;
	public static final int FormId=6;
	public static final int FormStart=7;
	public static final int IF=8;
	public static final int Ident=9;
	public static final int Int=10;
	public static final int Lbr=11;
	public static final int Money=12;
	public static final int Question=13;
	public static final int QuestionId=14;
	public static final int Rbr=15;
	public static final int WS=16;

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
	@Override public String getGrammarFileName() { return "/Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g"; }



	// $ANTLR start "parse"
	// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:35:1: parse returns [QuestionnaireForm root] : questionnaireExpr EOF ;
	public final QuestionnaireForm parse() throws RecognitionException {
		QuestionnaireForm root = null;

		int parse_StartIndex = input.index();

		QuestionnaireForm questionnaireExpr1 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return root; }

			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:36:2: ( questionnaireExpr EOF )
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:36:4: questionnaireExpr EOF
			{
			pushFollow(FOLLOW_questionnaireExpr_in_parse71);
			questionnaireExpr1=questionnaireExpr();
			state._fsp--;
			if (state.failed) return root;
			if ( state.backtracking==0 ) {root = questionnaireExpr1;}
			match(input,EOF,FOLLOW_EOF_in_parse75); if (state.failed) return root;
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 1, parse_StartIndex); }

		}
		return root;
	}
	// $ANTLR end "parse"



	// $ANTLR start "questionnaireExpr"
	// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:38:1: questionnaireExpr returns [QuestionnaireForm root] : FormStart qStartExp ;
	public final QuestionnaireForm questionnaireExpr() throws RecognitionException {
		QuestionnaireForm root = null;

		int questionnaireExpr_StartIndex = input.index();

		QuestionnaireForm qStartExp2 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return root; }

			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:39:2: ( FormStart qStartExp )
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:39:4: FormStart qStartExp
			{
			match(input,FormStart,FOLLOW_FormStart_in_questionnaireExpr90); if (state.failed) return root;
			pushFollow(FOLLOW_qStartExp_in_questionnaireExpr92);
			qStartExp2=qStartExp();
			state._fsp--;
			if (state.failed) return root;
			if ( state.backtracking==0 ) {root = qStartExp2;}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 2, questionnaireExpr_StartIndex); }

		}
		return root;
	}
	// $ANTLR end "questionnaireExpr"



	// $ANTLR start "qStartExp"
	// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:42:1: qStartExp returns [QuestionnaireForm root] : FormId Lbr qStartQExpr Rbr ;
	public final QuestionnaireForm qStartExp() throws RecognitionException {
		QuestionnaireForm root = null;

		int qStartExp_StartIndex = input.index();

		Token FormId3=null;
		List<QuestionnaireItemInterface> qStartQExpr4 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return root; }

			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:44:2: ( FormId Lbr qStartQExpr Rbr )
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:44:4: FormId Lbr qStartQExpr Rbr
			{
			FormId3=(Token)match(input,FormId,FOLLOW_FormId_in_qStartExp111); if (state.failed) return root;
			match(input,Lbr,FOLLOW_Lbr_in_qStartExp113); if (state.failed) return root;
			pushFollow(FOLLOW_qStartQExpr_in_qStartExp115);
			qStartQExpr4=qStartQExpr();
			state._fsp--;
			if (state.failed) return root;
			if ( state.backtracking==0 ) { root = new QuestionnaireForm((FormId3!=null?FormId3.getText():null), new QuestionnaireContent(qStartQExpr4));}
			match(input,Rbr,FOLLOW_Rbr_in_qStartExp119); if (state.failed) return root;
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 3, qStartExp_StartIndex); }

		}
		return root;
	}
	// $ANTLR end "qStartExp"



	// $ANTLR start "qStartQExpr"
	// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:47:1: qStartQExpr returns [List<QuestionnaireItemInterface> result] : ( qDeclaration | ifStatementExpr )* ;
	public final List<QuestionnaireItemInterface> qStartQExpr() throws RecognitionException {
		List<QuestionnaireItemInterface> result = null;

		int qStartQExpr_StartIndex = input.index();

		Question qDeclaration5 =null;
		IfBlock ifStatementExpr6 =null;


			result = new ArrayList<QuestionnaireItemInterface>();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:51:2: ( ( qDeclaration | ifStatementExpr )* )
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:51:4: ( qDeclaration | ifStatementExpr )*
			{
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:51:4: ( qDeclaration | ifStatementExpr )*
			loop1:
			while (true) {
				int alt1=3;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==QuestionId) ) {
					alt1=1;
				}
				else if ( (LA1_0==IF) ) {
					alt1=2;
				}

				switch (alt1) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:51:5: qDeclaration
					{
					pushFollow(FOLLOW_qDeclaration_in_qStartQExpr138);
					qDeclaration5=qDeclaration();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {result.add(qDeclaration5);}
					}
					break;
				case 2 :
					// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:51:57: ifStatementExpr
					{
					pushFollow(FOLLOW_ifStatementExpr_in_qStartQExpr144);
					ifStatementExpr6=ifStatementExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {result.add(ifStatementExpr6);}
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
			if ( state.backtracking>0 ) { memoize(input, 4, qStartQExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "qStartQExpr"



	// $ANTLR start "qDeclaration"
	// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:53:1: qDeclaration returns [Question result] : i= qIdentifier ':' l= qLabel (t= qType |t= qType e= qValueCalcExpr ) ;
	public final Question qDeclaration() throws RecognitionException {
		Question result = null;

		int qDeclaration_StartIndex = input.index();

		ParserRuleReturnScope i =null;
		ParserRuleReturnScope l =null;
		QuestionType t =null;
		Expr e =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:54:2: (i= qIdentifier ':' l= qLabel (t= qType |t= qType e= qValueCalcExpr ) )
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:54:4: i= qIdentifier ':' l= qLabel (t= qType |t= qType e= qValueCalcExpr )
			{
			pushFollow(FOLLOW_qIdentifier_in_qDeclaration164);
			i=qIdentifier();
			state._fsp--;
			if (state.failed) return result;
			match(input,26,FOLLOW_26_in_qDeclaration166); if (state.failed) return result;
			pushFollow(FOLLOW_qLabel_in_qDeclaration171);
			l=qLabel();
			state._fsp--;
			if (state.failed) return result;
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:54:32: (t= qType |t= qType e= qValueCalcExpr )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==Boolean) ) {
				int LA2_1 = input.LA(2);
				if ( (LA2_1==EOF||LA2_1==IF||(LA2_1 >= QuestionId && LA2_1 <= Rbr)) ) {
					alt2=1;
				}
				else if ( (LA2_1==20) ) {
					alt2=2;
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
			else if ( (LA2_0==Money) ) {
				int LA2_2 = input.LA(2);
				if ( (LA2_2==EOF||LA2_2==IF||(LA2_2 >= QuestionId && LA2_2 <= Rbr)) ) {
					alt2=1;
				}
				else if ( (LA2_2==20) ) {
					alt2=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return result;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 2, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:54:33: t= qType
					{
					pushFollow(FOLLOW_qType_in_qDeclaration177);
					t=qType();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {result = new Question((i!=null?input.toString(i.start,i.stop):null),(l!=null?input.toString(l.start,l.stop):null),t);}
					}
					break;
				case 2 :
					// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:54:96: t= qType e= qValueCalcExpr
					{
					pushFollow(FOLLOW_qType_in_qDeclaration185);
					t=qType();
					state._fsp--;
					if (state.failed) return result;
					pushFollow(FOLLOW_qValueCalcExpr_in_qDeclaration190);
					e=qValueCalcExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {result = new Question((i!=null?input.toString(i.start,i.stop):null),(l!=null?input.toString(l.start,l.stop):null),t,e);}
					}
					break;

			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 5, qDeclaration_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "qDeclaration"



	// $ANTLR start "ifStatementExpr"
	// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:57:1: ifStatementExpr returns [IfBlock result] : IF '(' qId= qIdentifier ')' Lbr (qDecl= qDeclaration |ifStatem= ifStatementExpr )+ Rbr ;
	public final IfBlock ifStatementExpr() throws RecognitionException {
		IfBlock result = null;

		int ifStatementExpr_StartIndex = input.index();

		ParserRuleReturnScope qId =null;
		Question qDecl =null;
		IfBlock ifStatem =null;


			List<QuestionnaireItemInterface> blockContent = new ArrayList<QuestionnaireItemInterface>();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:61:2: ( IF '(' qId= qIdentifier ')' Lbr (qDecl= qDeclaration |ifStatem= ifStatementExpr )+ Rbr )
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:61:5: IF '(' qId= qIdentifier ')' Lbr (qDecl= qDeclaration |ifStatem= ifStatementExpr )+ Rbr
			{
			match(input,IF,FOLLOW_IF_in_ifStatementExpr212); if (state.failed) return result;
			match(input,20,FOLLOW_20_in_ifStatementExpr214); if (state.failed) return result;
			pushFollow(FOLLOW_qIdentifier_in_ifStatementExpr218);
			qId=qIdentifier();
			state._fsp--;
			if (state.failed) return result;
			match(input,21,FOLLOW_21_in_ifStatementExpr220); if (state.failed) return result;
			match(input,Lbr,FOLLOW_Lbr_in_ifStatementExpr222); if (state.failed) return result;
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:61:36: (qDecl= qDeclaration |ifStatem= ifStatementExpr )+
			int cnt3=0;
			loop3:
			while (true) {
				int alt3=3;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==QuestionId) ) {
					alt3=1;
				}
				else if ( (LA3_0==IF) ) {
					alt3=2;
				}

				switch (alt3) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:61:38: qDecl= qDeclaration
					{
					pushFollow(FOLLOW_qDeclaration_in_ifStatementExpr229);
					qDecl=qDeclaration();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {blockContent.add(qDecl);}
					}
					break;
				case 2 :
					// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:61:95: ifStatem= ifStatementExpr
					{
					pushFollow(FOLLOW_ifStatementExpr_in_ifStatementExpr239);
					ifStatem=ifStatementExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {blockContent.add(ifStatem);}
					}
					break;

				default :
					if ( cnt3 >= 1 ) break loop3;
					if (state.backtracking>0) {state.failed=true; return result;}
					EarlyExitException eee = new EarlyExitException(3, input);
					throw eee;
				}
				cnt3++;
			}

			if ( state.backtracking==0 ) {result = new IfBlock((qId!=null?input.toString(qId.start,qId.stop):null),blockContent);}
			match(input,Rbr,FOLLOW_Rbr_in_ifStatementExpr247); if (state.failed) return result;
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 6, ifStatementExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "ifStatementExpr"



	// $ANTLR start "qValueCalcExpr"
	// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:64:1: qValueCalcExpr returns [Expr result] : '(' orExpr ')' ;
	public final Expr qValueCalcExpr() throws RecognitionException {
		Expr result = null;

		int qValueCalcExpr_StartIndex = input.index();

		Expr orExpr7 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:65:2: ( '(' orExpr ')' )
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:65:5: '(' orExpr ')'
			{
			match(input,20,FOLLOW_20_in_qValueCalcExpr264); if (state.failed) return result;
			pushFollow(FOLLOW_orExpr_in_qValueCalcExpr266);
			orExpr7=orExpr();
			state._fsp--;
			if (state.failed) return result;
			match(input,21,FOLLOW_21_in_qValueCalcExpr268); if (state.failed) return result;
			if ( state.backtracking==0 ) {result = new ValueExpr(orExpr7);}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 7, qValueCalcExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "qValueCalcExpr"


	public static class qIdentifier_return extends ParserRuleReturnScope {
	};


	// $ANTLR start "qIdentifier"
	// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:68:1: qIdentifier : QuestionId ;
	public final QLParser.qIdentifier_return qIdentifier() throws RecognitionException {
		QLParser.qIdentifier_return retval = new QLParser.qIdentifier_return();
		retval.start = input.LT(1);
		int qIdentifier_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:68:13: ( QuestionId )
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:68:15: QuestionId
			{
			match(input,QuestionId,FOLLOW_QuestionId_in_qIdentifier281); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 8, qIdentifier_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "qIdentifier"


	public static class qLabel_return extends ParserRuleReturnScope {
	};


	// $ANTLR start "qLabel"
	// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:70:1: qLabel : Question ;
	public final QLParser.qLabel_return qLabel() throws RecognitionException {
		QLParser.qLabel_return retval = new QLParser.qLabel_return();
		retval.start = input.LT(1);
		int qLabel_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:70:8: ( Question )
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:70:10: Question
			{
			match(input,Question,FOLLOW_Question_in_qLabel291); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 9, qLabel_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "qLabel"



	// $ANTLR start "qType"
	// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:72:1: qType returns [QuestionType result] : ( Boolean | Money );
	public final QuestionType qType() throws RecognitionException {
		QuestionType result = null;

		int qType_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:73:2: ( Boolean | Money )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==Boolean) ) {
				alt4=1;
			}
			else if ( (LA4_0==Money) ) {
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
					// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:73:4: Boolean
					{
					match(input,Boolean,FOLLOW_Boolean_in_qType304); if (state.failed) return result;
					if ( state.backtracking==0 ) {result = QuestionType.BOOL;}
					}
					break;
				case 2 :
					// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:73:45: Money
					{
					match(input,Money,FOLLOW_Money_in_qType310); if (state.failed) return result;
					if ( state.backtracking==0 ) {result = QuestionType.MONEY;}
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
			if ( state.backtracking>0 ) { memoize(input, 10, qType_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "qType"



	// $ANTLR start "primary"
	// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:76:1: primary returns [Expr result] : ( Int | Ident | Boolean | QuestionId | '(' x= orExpr ')' );
	public final Expr primary() throws RecognitionException {
		Expr result = null;

		int primary_StartIndex = input.index();

		Token Int8=null;
		Token Ident9=null;
		Token Boolean10=null;
		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:77:3: ( Int | Ident | Boolean | QuestionId | '(' x= orExpr ')' )
			int alt5=5;
			switch ( input.LA(1) ) {
			case Int:
				{
				alt5=1;
				}
				break;
			case Ident:
				{
				alt5=2;
				}
				break;
			case Boolean:
				{
				alt5=3;
				}
				break;
			case QuestionId:
				{
				alt5=4;
				}
				break;
			case 20:
				{
				alt5=5;
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
					// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:77:5: Int
					{
					Int8=(Token)match(input,Int,FOLLOW_Int_in_primary328); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Int(Integer.parseInt((Int8!=null?Int8.getText():null))); }
					}
					break;
				case 2 :
					// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:78:5: Ident
					{
					Ident9=(Token)match(input,Ident,FOLLOW_Ident_in_primary338); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Ident((Ident9!=null?Ident9.getText():null)); }
					}
					break;
				case 3 :
					// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:80:5: Boolean
					{
					Boolean10=(Token)match(input,Boolean,FOLLOW_Boolean_in_primary347); if (state.failed) return result;
					if ( state.backtracking==0 ) {result = new Bool((Boolean10!=null?Boolean10.getText():null));}
					}
					break;
				case 4 :
					// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:81:5: QuestionId
					{
					match(input,QuestionId,FOLLOW_QuestionId_in_primary355); if (state.failed) return result;
					if ( state.backtracking==0 ) {result = null;}
					}
					break;
				case 5 :
					// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:84:5: '(' x= orExpr ')'
					{
					match(input,20,FOLLOW_20_in_primary369); if (state.failed) return result;
					pushFollow(FOLLOW_orExpr_in_primary373);
					x=orExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,21,FOLLOW_21_in_primary375); if (state.failed) return result;
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
			if ( state.backtracking>0 ) { memoize(input, 11, primary_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "primary"



	// $ANTLR start "unExpr"
	// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:88:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
	public final Expr unExpr() throws RecognitionException {
		Expr result = null;

		int unExpr_StartIndex = input.index();

		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }

			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:89:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
			int alt6=4;
			switch ( input.LA(1) ) {
			case 23:
				{
				alt6=1;
				}
				break;
			case 24:
				{
				alt6=2;
				}
				break;
			case 17:
				{
				alt6=3;
				}
				break;
			case Boolean:
			case Ident:
			case Int:
			case QuestionId:
			case 20:
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
					// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:89:8: '+' x= unExpr
					{
					match(input,23,FOLLOW_23_in_unExpr401); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr405);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Pos(x); }
					}
					break;
				case 2 :
					// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:90:8: '-' x= unExpr
					{
					match(input,24,FOLLOW_24_in_unExpr416); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr420);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Neg(x); }
					}
					break;
				case 3 :
					// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:91:8: '!' x= unExpr
					{
					match(input,17,FOLLOW_17_in_unExpr431); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr435);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Not(x); }
					}
					break;
				case 4 :
					// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:92:8: x= primary
					{
					pushFollow(FOLLOW_primary_in_unExpr448);
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
			if ( state.backtracking>0 ) { memoize(input, 12, unExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "unExpr"



	// $ANTLR start "mulExpr"
	// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:95:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
	public final Expr mulExpr() throws RecognitionException {
		Expr result = null;

		int mulExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return result; }

			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:96:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:96:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
			{
			pushFollow(FOLLOW_unExpr_in_mulExpr486);
			lhs=unExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:96:45: (op= ( '*' | '/' ) rhs= unExpr )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==22||LA7_0==25) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:96:47: op= ( '*' | '/' ) rhs= unExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==22||input.LA(1)==25 ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_unExpr_in_mulExpr506);
					rhs=unExpr();
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
			if ( state.backtracking>0 ) { memoize(input, 13, mulExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "mulExpr"



	// $ANTLR start "addExpr"
	// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:108:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
	public final Expr addExpr() throws RecognitionException {
		Expr result = null;

		int addExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return result; }

			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:109:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:109:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
			{
			pushFollow(FOLLOW_mulExpr_in_addExpr547);
			lhs=mulExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:109:46: (op= ( '+' | '-' ) rhs= mulExpr )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( ((LA8_0 >= 23 && LA8_0 <= 24)) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:109:48: op= ( '+' | '-' ) rhs= mulExpr
					{
					op=input.LT(1);
					if ( (input.LA(1) >= 23 && input.LA(1) <= 24) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_mulExpr_in_addExpr565);
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
			if ( state.backtracking>0 ) { memoize(input, 14, addExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "addExpr"



	// $ANTLR start "relExpr"
	// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:120:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
	public final Expr relExpr() throws RecognitionException {
		Expr result = null;

		int relExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return result; }

			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:121:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:121:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			{
			pushFollow(FOLLOW_addExpr_in_relExpr600);
			lhs=addExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:121:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==18||(LA9_0 >= 27 && LA9_0 <= 31)) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:121:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==18||(input.LA(1) >= 27 && input.LA(1) <= 31) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_addExpr_in_relExpr624);
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
			if ( state.backtracking>0 ) { memoize(input, 15, relExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "relExpr"



	// $ANTLR start "andExpr"
	// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:144:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
	public final Expr andExpr() throws RecognitionException {
		Expr result = null;

		int andExpr_StartIndex = input.index();

		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return result; }

			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:145:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:145:9: lhs= relExpr ( '&&' rhs= relExpr )*
			{
			pushFollow(FOLLOW_relExpr_in_andExpr662);
			lhs=relExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:145:46: ( '&&' rhs= relExpr )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==19) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:145:48: '&&' rhs= relExpr
					{
					match(input,19,FOLLOW_19_in_andExpr668); if (state.failed) return result;
					pushFollow(FOLLOW_relExpr_in_andExpr672);
					rhs=relExpr();
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
			if ( state.backtracking>0 ) { memoize(input, 16, andExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "andExpr"



	// $ANTLR start "orExpr"
	// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:149:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
	public final Expr orExpr() throws RecognitionException {
		Expr result = null;

		int orExpr_StartIndex = input.index();

		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return result; }

			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:150:5: (lhs= andExpr ( '||' rhs= andExpr )* )
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:150:9: lhs= andExpr ( '||' rhs= andExpr )*
			{
			pushFollow(FOLLOW_andExpr_in_orExpr707);
			lhs=andExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = lhs; }
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:150:48: ( '||' rhs= andExpr )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==32) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:150:50: '||' rhs= andExpr
					{
					match(input,32,FOLLOW_32_in_orExpr713); if (state.failed) return result;
					pushFollow(FOLLOW_andExpr_in_orExpr717);
					rhs=andExpr();
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
			if ( state.backtracking>0 ) { memoize(input, 17, orExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "orExpr"

	// Delegated rules



	public static final BitSet FOLLOW_questionnaireExpr_in_parse71 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_parse75 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FormStart_in_questionnaireExpr90 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_qStartExp_in_questionnaireExpr92 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FormId_in_qStartExp111 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_Lbr_in_qStartExp113 = new BitSet(new long[]{0x000000000000C100L});
	public static final BitSet FOLLOW_qStartQExpr_in_qStartExp115 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_Rbr_in_qStartExp119 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_qDeclaration_in_qStartQExpr138 = new BitSet(new long[]{0x0000000000004102L});
	public static final BitSet FOLLOW_ifStatementExpr_in_qStartQExpr144 = new BitSet(new long[]{0x0000000000004102L});
	public static final BitSet FOLLOW_qIdentifier_in_qDeclaration164 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_26_in_qDeclaration166 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_qLabel_in_qDeclaration171 = new BitSet(new long[]{0x0000000000001010L});
	public static final BitSet FOLLOW_qType_in_qDeclaration177 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_qType_in_qDeclaration185 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_qValueCalcExpr_in_qDeclaration190 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_ifStatementExpr212 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_ifStatementExpr214 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_qIdentifier_in_ifStatementExpr218 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_21_in_ifStatementExpr220 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_Lbr_in_ifStatementExpr222 = new BitSet(new long[]{0x0000000000004100L});
	public static final BitSet FOLLOW_qDeclaration_in_ifStatementExpr229 = new BitSet(new long[]{0x000000000000C100L});
	public static final BitSet FOLLOW_ifStatementExpr_in_ifStatementExpr239 = new BitSet(new long[]{0x000000000000C100L});
	public static final BitSet FOLLOW_Rbr_in_ifStatementExpr247 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_20_in_qValueCalcExpr264 = new BitSet(new long[]{0x0000000001924610L});
	public static final BitSet FOLLOW_orExpr_in_qValueCalcExpr266 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_21_in_qValueCalcExpr268 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_QuestionId_in_qIdentifier281 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Question_in_qLabel291 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Boolean_in_qType304 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Money_in_qType310 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Int_in_primary328 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_primary338 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Boolean_in_primary347 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_QuestionId_in_primary355 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_20_in_primary369 = new BitSet(new long[]{0x0000000001924610L});
	public static final BitSet FOLLOW_orExpr_in_primary373 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_21_in_primary375 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_23_in_unExpr401 = new BitSet(new long[]{0x0000000001924610L});
	public static final BitSet FOLLOW_unExpr_in_unExpr405 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_24_in_unExpr416 = new BitSet(new long[]{0x0000000001924610L});
	public static final BitSet FOLLOW_unExpr_in_unExpr420 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_17_in_unExpr431 = new BitSet(new long[]{0x0000000001924610L});
	public static final BitSet FOLLOW_unExpr_in_unExpr435 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpr448 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr486 = new BitSet(new long[]{0x0000000002400002L});
	public static final BitSet FOLLOW_set_in_mulExpr494 = new BitSet(new long[]{0x0000000001924610L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr506 = new BitSet(new long[]{0x0000000002400002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr547 = new BitSet(new long[]{0x0000000001800002L});
	public static final BitSet FOLLOW_set_in_addExpr555 = new BitSet(new long[]{0x0000000001924610L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr565 = new BitSet(new long[]{0x0000000001800002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr600 = new BitSet(new long[]{0x00000000F8040002L});
	public static final BitSet FOLLOW_set_in_relExpr608 = new BitSet(new long[]{0x0000000001924610L});
	public static final BitSet FOLLOW_addExpr_in_relExpr624 = new BitSet(new long[]{0x00000000F8040002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr662 = new BitSet(new long[]{0x0000000000080002L});
	public static final BitSet FOLLOW_19_in_andExpr668 = new BitSet(new long[]{0x0000000001924610L});
	public static final BitSet FOLLOW_relExpr_in_andExpr672 = new BitSet(new long[]{0x0000000000080002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr707 = new BitSet(new long[]{0x0000000100000002L});
	public static final BitSet FOLLOW_32_in_orExpr713 = new BitSet(new long[]{0x0000000001924610L});
	public static final BitSet FOLLOW_andExpr_in_orExpr717 = new BitSet(new long[]{0x0000000100000002L});
}
