// $ANTLR 3.5 C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g 2013-01-21 16:34:53

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.bool.*;
import org.uva.sea.ql.ast.types.*;
import org.uva.sea.ql.ast.math.*;
import org.uva.sea.ql.ast.literal.*;
import org.uva.sea.ql.ast.elements.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings("all")
public class QLParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "Assign", "COMMENT", "Form", "FormIdent", 
		"Ident", "Int", "LEFTBR", "LEFTCBR", "RIGHTBR", "RIGHTCBR", "String", 
		"WS", "'!'", "'!='", "'&&'", "'*'", "'+'", "'-'", "'/'", "'<'", "'<='", 
		"'=='", "'>'", "'>='", "'boolean'", "'if'", "'integer'", "'money'", "'string'", 
		"'||'"
	};
	public static final int EOF=-1;
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
	public static final int Assign=4;
	public static final int COMMENT=5;
	public static final int Form=6;
	public static final int FormIdent=7;
	public static final int Ident=8;
	public static final int Int=9;
	public static final int LEFTBR=10;
	public static final int LEFTCBR=11;
	public static final int RIGHTBR=12;
	public static final int RIGHTCBR=13;
	public static final int String=14;
	public static final int WS=15;

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
		this.state.ruleMemo = new HashMap[45+1];


	}

	@Override public String[] getTokenNames() { return QLParser.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g"; }



	// $ANTLR start "parse"
	// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:20:1: parse returns [Expr result] : formDefinition EOF ;
	public final Expr parse() throws RecognitionException {
		Expr result = null;

		int parse_StartIndex = input.index();

		Expr formDefinition1 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

			// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:21:4: ( formDefinition EOF )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:21:4: formDefinition EOF
			{
			pushFollow(FOLLOW_formDefinition_in_parse45);
			formDefinition1=formDefinition();
			state._fsp--;
			if (state.failed) return result;
			match(input,EOF,FOLLOW_EOF_in_parse47); if (state.failed) return result;
			if ( state.backtracking==0 ) {result = formDefinition1;}
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
		return result;
	}
	// $ANTLR end "parse"



	// $ANTLR start "formDefinition"
	// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:23:1: formDefinition returns [Expr result] : Form formDeclaration ;
	public final Expr formDefinition() throws RecognitionException {
		Expr result = null;

		int formDefinition_StartIndex = input.index();

		Expr formDeclaration2 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

			// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:24:2: ( Form formDeclaration )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:24:5: Form formDeclaration
			{
			match(input,Form,FOLLOW_Form_in_formDefinition63); if (state.failed) return result;
			pushFollow(FOLLOW_formDeclaration_in_formDefinition65);
			formDeclaration2=formDeclaration();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) {result = formDeclaration2;}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 2, formDefinition_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "formDefinition"



	// $ANTLR start "formDeclaration"
	// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:26:1: formDeclaration returns [Expr result] : FormIdent LEFTCBR blockContent RIGHTCBR ;
	public final Expr formDeclaration() throws RecognitionException {
		Expr result = null;

		int formDeclaration_StartIndex = input.index();

		Token FormIdent3=null;
		Block blockContent4 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

			// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:27:4: ( FormIdent LEFTCBR blockContent RIGHTCBR )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:27:4: FormIdent LEFTCBR blockContent RIGHTCBR
			{
			FormIdent3=(Token)match(input,FormIdent,FOLLOW_FormIdent_in_formDeclaration81); if (state.failed) return result;
			match(input,LEFTCBR,FOLLOW_LEFTCBR_in_formDeclaration83); if (state.failed) return result;
			pushFollow(FOLLOW_blockContent_in_formDeclaration85);
			blockContent4=blockContent();
			state._fsp--;
			if (state.failed) return result;
			match(input,RIGHTCBR,FOLLOW_RIGHTCBR_in_formDeclaration87); if (state.failed) return result;
			if ( state.backtracking==0 ) {result = new Form((FormIdent3!=null?FormIdent3.getText():null), blockContent4);}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 3, formDeclaration_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "formDeclaration"



	// $ANTLR start "blockContent"
	// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:29:1: blockContent returns [Block result] : ( blockLine )* ;
	public final Block blockContent() throws RecognitionException {
		Block result = null;

		int blockContent_StartIndex = input.index();

		Expr blockLine5 =null;


			List l = new ArrayList();
			result = new Block(l);	

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

			// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:35:3: ( ( blockLine )* )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:35:3: ( blockLine )*
			{
			// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:35:3: ( blockLine )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==Ident||LA1_0==29) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:35:4: blockLine
					{
					pushFollow(FOLLOW_blockLine_in_blockContent108);
					blockLine5=blockLine();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {if(blockLine5 != null) {result.addLine(blockLine5);}}
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
			if ( state.backtracking>0 ) { memoize(input, 4, blockContent_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "blockContent"



	// $ANTLR start "blockLine"
	// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:38:1: blockLine returns [Expr result] : ( question | ifStatement );
	public final Expr blockLine() throws RecognitionException {
		Expr result = null;

		int blockLine_StartIndex = input.index();

		Expr question6 =null;
		Expr ifStatement7 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

			// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:39:4: ( question | ifStatement )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==Ident) ) {
				alt2=1;
			}
			else if ( (LA2_0==29) ) {
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
					// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:39:4: question
					{
					pushFollow(FOLLOW_question_in_blockLine129);
					question6=question();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {result = question6;}
					}
					break;
				case 2 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:40:3: ifStatement
					{
					pushFollow(FOLLOW_ifStatement_in_blockLine135);
					ifStatement7=ifStatement();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {result = ifStatement7;}
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
			if ( state.backtracking>0 ) { memoize(input, 5, blockLine_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "blockLine"



	// $ANTLR start "question"
	// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:43:1: question returns [Expr result] : Ident Assign String type ;
	public final Expr question() throws RecognitionException {
		Expr result = null;

		int question_StartIndex = input.index();

		Token Ident8=null;
		Token String9=null;
		Type type10 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

			// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:44:3: ( Ident Assign String type )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:44:3: Ident Assign String type
			{
			Ident8=(Token)match(input,Ident,FOLLOW_Ident_in_question150); if (state.failed) return result;
			match(input,Assign,FOLLOW_Assign_in_question152); if (state.failed) return result;
			String9=(Token)match(input,String,FOLLOW_String_in_question154); if (state.failed) return result;
			pushFollow(FOLLOW_type_in_question156);
			type10=type();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) {result = new Question(new Ident((Ident8!=null?Ident8.getText():null)), new StringLiteral((String9!=null?String9.getText():null)), type10);}
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



	// $ANTLR start "ifStatement"
	// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:47:1: ifStatement returns [Expr result] : 'if' LEFTBR orExpr RIGHTBR LEFTCBR blockContent RIGHTCBR ;
	public final Expr ifStatement() throws RecognitionException {
		Expr result = null;

		int ifStatement_StartIndex = input.index();

		Expr orExpr11 =null;
		Block blockContent12 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

			// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:48:3: ( 'if' LEFTBR orExpr RIGHTBR LEFTCBR blockContent RIGHTCBR )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:48:3: 'if' LEFTBR orExpr RIGHTBR LEFTCBR blockContent RIGHTCBR
			{
			match(input,29,FOLLOW_29_in_ifStatement171); if (state.failed) return result;
			match(input,LEFTBR,FOLLOW_LEFTBR_in_ifStatement173); if (state.failed) return result;
			pushFollow(FOLLOW_orExpr_in_ifStatement175);
			orExpr11=orExpr();
			state._fsp--;
			if (state.failed) return result;
			match(input,RIGHTBR,FOLLOW_RIGHTBR_in_ifStatement177); if (state.failed) return result;
			match(input,LEFTCBR,FOLLOW_LEFTCBR_in_ifStatement179); if (state.failed) return result;
			pushFollow(FOLLOW_blockContent_in_ifStatement181);
			blockContent12=blockContent();
			state._fsp--;
			if (state.failed) return result;
			match(input,RIGHTCBR,FOLLOW_RIGHTCBR_in_ifStatement183); if (state.failed) return result;
			if ( state.backtracking==0 ) {result = new IfStatement(orExpr11, blockContent12);}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 7, ifStatement_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "ifStatement"



	// $ANTLR start "type"
	// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:51:1: type returns [Type result] : ( boolType | money | intType | strType );
	public final Type type() throws RecognitionException {
		Type result = null;

		int type_StartIndex = input.index();

		Money money13 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

			// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:52:2: ( boolType | money | intType | strType )
			int alt3=4;
			switch ( input.LA(1) ) {
			case 28:
				{
				alt3=1;
				}
				break;
			case 31:
				{
				alt3=2;
				}
				break;
			case 30:
				{
				alt3=3;
				}
				break;
			case 32:
				{
				alt3=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}
			switch (alt3) {
				case 1 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:52:5: boolType
					{
					pushFollow(FOLLOW_boolType_in_type200);
					boolType();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new BooleanType();}
					}
					break;
				case 2 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:53:5: money
					{
					pushFollow(FOLLOW_money_in_type208);
					money13=money();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = money13;}
					}
					break;
				case 3 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:54:5: intType
					{
					pushFollow(FOLLOW_intType_in_type219);
					intType();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new IntType();}
					}
					break;
				case 4 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:55:5: strType
					{
					pushFollow(FOLLOW_strType_in_type227);
					strType();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new StrType();}
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
			if ( state.backtracking>0 ) { memoize(input, 8, type_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "type"



	// $ANTLR start "money"
	// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:60:1: money returns [Money result] : ( 'money' | moneyCalc );
	public final Money money() throws RecognitionException {
		Money result = null;

		int money_StartIndex = input.index();

		Money moneyCalc14 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

			// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:61:2: ( 'money' | moneyCalc )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==31) ) {
				int LA4_1 = input.LA(2);
				if ( (LA4_1==LEFTBR) ) {
					alt4=2;
				}
				else if ( (LA4_1==EOF||LA4_1==Ident||(LA4_1 >= RIGHTBR && LA4_1 <= RIGHTCBR)||(LA4_1 >= 17 && LA4_1 <= 27)||LA4_1==29||LA4_1==33) ) {
					alt4=1;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return result;}
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
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:61:5: 'money'
					{
					match(input,31,FOLLOW_31_in_money247); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Money(); }
					}
					break;
				case 2 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:62:5: moneyCalc
					{
					pushFollow(FOLLOW_moneyCalc_in_money255);
					moneyCalc14=moneyCalc();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = moneyCalc14; }
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
			if ( state.backtracking>0 ) { memoize(input, 9, money_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "money"



	// $ANTLR start "moneyCalc"
	// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:65:1: moneyCalc returns [Money result] : 'money' LEFTBR addExpr RIGHTBR ;
	public final Money moneyCalc() throws RecognitionException {
		Money result = null;

		int moneyCalc_StartIndex = input.index();

		Expr addExpr15 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

			// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:66:4: ( 'money' LEFTBR addExpr RIGHTBR )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:66:4: 'money' LEFTBR addExpr RIGHTBR
			{
			match(input,31,FOLLOW_31_in_moneyCalc271); if (state.failed) return result;
			match(input,LEFTBR,FOLLOW_LEFTBR_in_moneyCalc273); if (state.failed) return result;
			pushFollow(FOLLOW_addExpr_in_moneyCalc275);
			addExpr15=addExpr();
			state._fsp--;
			if (state.failed) return result;
			match(input,RIGHTBR,FOLLOW_RIGHTBR_in_moneyCalc277); if (state.failed) return result;
			if ( state.backtracking==0 ) {result = new Money( addExpr15);}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 10, moneyCalc_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "moneyCalc"



	// $ANTLR start "primary"
	// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:71:1: primary returns [Expr result] : ( Int | Ident | String | type | '(' x= orExpr ')' );
	public final Expr primary() throws RecognitionException {
		Expr result = null;

		int primary_StartIndex = input.index();

		Token Int16=null;
		Token Ident17=null;
		Token String18=null;
		Expr x =null;
		Type type19 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

			// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:72:3: ( Int | Ident | String | type | '(' x= orExpr ')' )
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
			case String:
				{
				alt5=3;
				}
				break;
			case 28:
			case 30:
			case 31:
			case 32:
				{
				alt5=4;
				}
				break;
			case LEFTBR:
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
					// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:72:5: Int
					{
					Int16=(Token)match(input,Int,FOLLOW_Int_in_primary297); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new IntLiteral(Integer.parseInt((Int16!=null?Int16.getText():null))); }
					}
					break;
				case 2 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:73:5: Ident
					{
					Ident17=(Token)match(input,Ident,FOLLOW_Ident_in_primary307); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Ident((Ident17!=null?Ident17.getText():null)); }
					}
					break;
				case 3 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:74:5: String
					{
					String18=(Token)match(input,String,FOLLOW_String_in_primary315); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new StringLiteral((String18!=null?String18.getText():null)); }
					}
					break;
				case 4 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:75:5: type
					{
					pushFollow(FOLLOW_type_in_primary323);
					type19=type();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {result = type19; }
					}
					break;
				case 5 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:76:5: '(' x= orExpr ')'
					{
					match(input,LEFTBR,FOLLOW_LEFTBR_in_primary331); if (state.failed) return result;
					pushFollow(FOLLOW_orExpr_in_primary335);
					x=orExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,RIGHTBR,FOLLOW_RIGHTBR_in_primary337); if (state.failed) return result;
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
	// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:79:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
	public final Expr unExpr() throws RecognitionException {
		Expr result = null;

		int unExpr_StartIndex = input.index();

		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }

			// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:80:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
			int alt6=4;
			switch ( input.LA(1) ) {
			case 20:
				{
				alt6=1;
				}
				break;
			case 21:
				{
				alt6=2;
				}
				break;
			case 16:
				{
				alt6=3;
				}
				break;
			case Ident:
			case Int:
			case LEFTBR:
			case String:
			case 28:
			case 30:
			case 31:
			case 32:
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
					// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:80:8: '+' x= unExpr
					{
					match(input,20,FOLLOW_20_in_unExpr362); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr366);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Pos(x); }
					}
					break;
				case 2 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:81:8: '-' x= unExpr
					{
					match(input,21,FOLLOW_21_in_unExpr377); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr381);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Neg(x); }
					}
					break;
				case 3 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:82:8: '!' x= unExpr
					{
					match(input,16,FOLLOW_16_in_unExpr392); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr396);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Not(x); }
					}
					break;
				case 4 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:83:8: x= primary
					{
					pushFollow(FOLLOW_primary_in_unExpr409);
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
	// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:86:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
	public final Expr mulExpr() throws RecognitionException {
		Expr result = null;

		int mulExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return result; }

			// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:87:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:87:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
			{
			pushFollow(FOLLOW_unExpr_in_mulExpr447);
			lhs=unExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:87:45: (op= ( '*' | '/' ) rhs= unExpr )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==19||LA7_0==22) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:87:47: op= ( '*' | '/' ) rhs= unExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==19||input.LA(1)==22 ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_unExpr_in_mulExpr467);
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
	// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:99:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
	public final Expr addExpr() throws RecognitionException {
		Expr result = null;

		int addExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return result; }

			// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:100:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:100:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
			{
			pushFollow(FOLLOW_mulExpr_in_addExpr508);
			lhs=mulExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:100:46: (op= ( '+' | '-' ) rhs= mulExpr )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( ((LA8_0 >= 20 && LA8_0 <= 21)) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:100:48: op= ( '+' | '-' ) rhs= mulExpr
					{
					op=input.LT(1);
					if ( (input.LA(1) >= 20 && input.LA(1) <= 21) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_mulExpr_in_addExpr526);
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
	// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:111:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
	public final Expr relExpr() throws RecognitionException {
		Expr result = null;

		int relExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return result; }

			// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:112:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:112:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			{
			pushFollow(FOLLOW_addExpr_in_relExpr561);
			lhs=addExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:112:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==17||(LA9_0 >= 23 && LA9_0 <= 27)) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:112:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==17||(input.LA(1) >= 23 && input.LA(1) <= 27) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_addExpr_in_relExpr585);
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
	// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:135:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
	public final Expr andExpr() throws RecognitionException {
		Expr result = null;

		int andExpr_StartIndex = input.index();

		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return result; }

			// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:136:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:136:9: lhs= relExpr ( '&&' rhs= relExpr )*
			{
			pushFollow(FOLLOW_relExpr_in_andExpr623);
			lhs=relExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:136:46: ( '&&' rhs= relExpr )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==18) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:136:48: '&&' rhs= relExpr
					{
					match(input,18,FOLLOW_18_in_andExpr629); if (state.failed) return result;
					pushFollow(FOLLOW_relExpr_in_andExpr633);
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
	// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:140:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
	public final Expr orExpr() throws RecognitionException {
		Expr result = null;

		int orExpr_StartIndex = input.index();

		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return result; }

			// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:141:5: (lhs= andExpr ( '||' rhs= andExpr )* )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:141:9: lhs= andExpr ( '||' rhs= andExpr )*
			{
			pushFollow(FOLLOW_andExpr_in_orExpr668);
			lhs=andExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = lhs; }
			// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:141:48: ( '||' rhs= andExpr )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==33) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:141:50: '||' rhs= andExpr
					{
					match(input,33,FOLLOW_33_in_orExpr674); if (state.failed) return result;
					pushFollow(FOLLOW_andExpr_in_orExpr678);
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



	// $ANTLR start "boolType"
	// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:144:1: boolType : 'boolean' ;
	public final void boolType() throws RecognitionException {
		int boolType_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return; }

			// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:144:9: ( 'boolean' )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:144:11: 'boolean'
			{
			match(input,28,FOLLOW_28_in_boolType699); if (state.failed) return;
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 18, boolType_StartIndex); }

		}
	}
	// $ANTLR end "boolType"



	// $ANTLR start "strType"
	// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:145:1: strType : 'string' ;
	public final void strType() throws RecognitionException {
		int strType_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return; }

			// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:145:9: ( 'string' )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:145:11: 'string'
			{
			match(input,32,FOLLOW_32_in_strType706); if (state.failed) return;
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 19, strType_StartIndex); }

		}
	}
	// $ANTLR end "strType"



	// $ANTLR start "intType"
	// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:146:1: intType : 'integer' ;
	public final void intType() throws RecognitionException {
		int intType_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return; }

			// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:146:9: ( 'integer' )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:146:11: 'integer'
			{
			match(input,30,FOLLOW_30_in_intType713); if (state.failed) return;
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 20, intType_StartIndex); }

		}
	}
	// $ANTLR end "intType"

	// Delegated rules



	public static final BitSet FOLLOW_formDefinition_in_parse45 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_parse47 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Form_in_formDefinition63 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_formDeclaration_in_formDefinition65 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FormIdent_in_formDeclaration81 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_LEFTCBR_in_formDeclaration83 = new BitSet(new long[]{0x0000000020002100L});
	public static final BitSet FOLLOW_blockContent_in_formDeclaration85 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_RIGHTCBR_in_formDeclaration87 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_blockLine_in_blockContent108 = new BitSet(new long[]{0x0000000020000102L});
	public static final BitSet FOLLOW_question_in_blockLine129 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifStatement_in_blockLine135 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_question150 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_Assign_in_question152 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_String_in_question154 = new BitSet(new long[]{0x00000001D0000000L});
	public static final BitSet FOLLOW_type_in_question156 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_29_in_ifStatement171 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_LEFTBR_in_ifStatement173 = new BitSet(new long[]{0x00000001D0314700L});
	public static final BitSet FOLLOW_orExpr_in_ifStatement175 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_RIGHTBR_in_ifStatement177 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_LEFTCBR_in_ifStatement179 = new BitSet(new long[]{0x0000000020002100L});
	public static final BitSet FOLLOW_blockContent_in_ifStatement181 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_RIGHTCBR_in_ifStatement183 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_boolType_in_type200 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_money_in_type208 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_intType_in_type219 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_strType_in_type227 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_31_in_money247 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_moneyCalc_in_money255 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_31_in_moneyCalc271 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_LEFTBR_in_moneyCalc273 = new BitSet(new long[]{0x00000001D0314700L});
	public static final BitSet FOLLOW_addExpr_in_moneyCalc275 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_RIGHTBR_in_moneyCalc277 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Int_in_primary297 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_primary307 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_String_in_primary315 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_in_primary323 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LEFTBR_in_primary331 = new BitSet(new long[]{0x00000001D0314700L});
	public static final BitSet FOLLOW_orExpr_in_primary335 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_RIGHTBR_in_primary337 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_20_in_unExpr362 = new BitSet(new long[]{0x00000001D0314700L});
	public static final BitSet FOLLOW_unExpr_in_unExpr366 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_21_in_unExpr377 = new BitSet(new long[]{0x00000001D0314700L});
	public static final BitSet FOLLOW_unExpr_in_unExpr381 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_16_in_unExpr392 = new BitSet(new long[]{0x00000001D0314700L});
	public static final BitSet FOLLOW_unExpr_in_unExpr396 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpr409 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr447 = new BitSet(new long[]{0x0000000000480002L});
	public static final BitSet FOLLOW_set_in_mulExpr455 = new BitSet(new long[]{0x00000001D0314700L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr467 = new BitSet(new long[]{0x0000000000480002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr508 = new BitSet(new long[]{0x0000000000300002L});
	public static final BitSet FOLLOW_set_in_addExpr516 = new BitSet(new long[]{0x00000001D0314700L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr526 = new BitSet(new long[]{0x0000000000300002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr561 = new BitSet(new long[]{0x000000000F820002L});
	public static final BitSet FOLLOW_set_in_relExpr569 = new BitSet(new long[]{0x00000001D0314700L});
	public static final BitSet FOLLOW_addExpr_in_relExpr585 = new BitSet(new long[]{0x000000000F820002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr623 = new BitSet(new long[]{0x0000000000040002L});
	public static final BitSet FOLLOW_18_in_andExpr629 = new BitSet(new long[]{0x00000001D0314700L});
	public static final BitSet FOLLOW_relExpr_in_andExpr633 = new BitSet(new long[]{0x0000000000040002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr668 = new BitSet(new long[]{0x0000000200000002L});
	public static final BitSet FOLLOW_33_in_orExpr674 = new BitSet(new long[]{0x00000001D0314700L});
	public static final BitSet FOLLOW_andExpr_in_orExpr678 = new BitSet(new long[]{0x0000000200000002L});
	public static final BitSet FOLLOW_28_in_boolType699 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_32_in_strType706 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_30_in_intType713 = new BitSet(new long[]{0x0000000000000002L});
}
