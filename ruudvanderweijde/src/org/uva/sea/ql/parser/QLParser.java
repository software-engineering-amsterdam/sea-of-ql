// $ANTLR 3.5 C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g 2013-01-21 20:04:59

  package org.uva.sea.ql.parser;
  import org.uva.sea.ql.ast.*;
  import org.uva.sea.ql.ast.expr.*;
  import org.uva.sea.ql.ast.expr.binary.*;
  import org.uva.sea.ql.ast.expr.primary.*;
  import org.uva.sea.ql.ast.expr.unary.*;
  import org.uva.sea.ql.ast.type.*;
  import org.uva.sea.ql.ast.stmt.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings("all")
public class QLParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "Bool", "CBrace", "CParen", "Colon", 
		"Digit", "Else", "Ident", "If", "Int", "Letter", "MComment", "OBrace", 
		"OParen", "SComment", "String", "WS", "'!'", "'!='", "'&&'", "'*'", "'+'", 
		"'-'", "'/'", "'<'", "'<='", "'=='", "'>'", "'>='", "'boolean'", "'form'", 
		"'integer'", "'string'", "'||'"
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
	public static final int T__34=34;
	public static final int T__35=35;
	public static final int T__36=36;
	public static final int Bool=4;
	public static final int CBrace=5;
	public static final int CParen=6;
	public static final int Colon=7;
	public static final int Digit=8;
	public static final int Else=9;
	public static final int Ident=10;
	public static final int If=11;
	public static final int Int=12;
	public static final int Letter=13;
	public static final int MComment=14;
	public static final int OBrace=15;
	public static final int OParen=16;
	public static final int SComment=17;
	public static final int String=18;
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
		this.state.ruleMemo = new HashMap[42+1];


	}

	@Override public String[] getTokenNames() { return QLParser.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g"; }



	// $ANTLR start "form"
	// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:26:1: form returns [Form result] : ( 'form' Ident statements= block )+ ;
	public final Form form() throws RecognitionException {
		Form result = null;

		int form_StartIndex = input.index();

		Token Ident1=null;
		List<Statement> statements =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:27:3: ( ( 'form' Ident statements= block )+ )
			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:27:5: ( 'form' Ident statements= block )+
			{
			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:27:5: ( 'form' Ident statements= block )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==33) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:27:6: 'form' Ident statements= block
					{
					match(input,33,FOLLOW_33_in_form57); if (state.failed) return result;
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
	// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:33:1: block returns [List<Statement> result] : OBrace (stmt= statement )* CBrace ;
	public final List<Statement> block() throws RecognitionException {
		List<Statement> result = null;

		int block_StartIndex = input.index();

		Statement stmt =null;


		      result = new ArrayList<Statement>();
		    
		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:38:3: ( OBrace (stmt= statement )* CBrace )
			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:38:5: OBrace (stmt= statement )* CBrace
			{
			match(input,OBrace,FOLLOW_OBrace_in_block98); if (state.failed) return result;
			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:38:12: (stmt= statement )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= Ident && LA2_0 <= If)) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:38:14: stmt= statement
					{
					pushFollow(FOLLOW_statement_in_block104);
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

			match(input,CBrace,FOLLOW_CBrace_in_block111); if (state.failed) return result;
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
	// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:41:1: statement returns [Statement result] : (q= question |i= ifStatement );
	public final Statement statement() throws RecognitionException {
		Statement result = null;

		int statement_StartIndex = input.index();

		Statement q =null;
		Statement i =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:42:3: (q= question |i= ifStatement )
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
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:42:5: q= question
					{
					pushFollow(FOLLOW_question_in_statement132);
					q=question();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = q; }
					}
					break;
				case 2 :
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:43:5: i= ifStatement
					{
					pushFollow(FOLLOW_ifStatement_in_statement145);
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
	// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:46:1: ifStatement returns [Statement result] : If OParen condition= orExpr CParen ifBlock= block ( ( Else )=> Else elseBlock= block | () ) ;
	public final Statement ifStatement() throws RecognitionException {
		Statement result = null;

		int ifStatement_StartIndex = input.index();

		Expr condition =null;
		List<Statement> ifBlock =null;
		List<Statement> elseBlock =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:47:3: ( If OParen condition= orExpr CParen ifBlock= block ( ( Else )=> Else elseBlock= block | () ) )
			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:47:5: If OParen condition= orExpr CParen ifBlock= block ( ( Else )=> Else elseBlock= block | () )
			{
			match(input,If,FOLLOW_If_in_ifStatement166); if (state.failed) return result;
			match(input,OParen,FOLLOW_OParen_in_ifStatement168); if (state.failed) return result;
			pushFollow(FOLLOW_orExpr_in_ifStatement172);
			condition=orExpr();
			state._fsp--;
			if (state.failed) return result;
			match(input,CParen,FOLLOW_CParen_in_ifStatement174); if (state.failed) return result;
			pushFollow(FOLLOW_block_in_ifStatement178);
			ifBlock=block();
			state._fsp--;
			if (state.failed) return result;
			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:48:5: ( ( Else )=> Else elseBlock= block | () )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==Else) && (synpred4_QL())) {
				alt4=1;
			}
			else if ( (LA4_0==EOF||LA4_0==CBrace||(LA4_0 >= Ident && LA4_0 <= If)) ) {
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
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:48:7: ( Else )=> Else elseBlock= block
					{
					match(input,Else,FOLLOW_Else_in_ifStatement191); if (state.failed) return result;
					pushFollow(FOLLOW_block_in_ifStatement195);
					elseBlock=block();
					state._fsp--;
					if (state.failed) return result;
					}
					break;
				case 2 :
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:49:7: ()
					{
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:49:7: ()
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:49:9: 
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
	// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:60:1: question returns [Statement result] : Ident Colon String tp= type ;
	public final Statement question() throws RecognitionException {
		Statement result = null;

		int question_StartIndex = input.index();

		Token Ident2=null;
		Token String3=null;
		Type tp =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:61:3: ( Ident Colon String tp= type )
			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:61:5: Ident Colon String tp= type
			{
			Ident2=(Token)match(input,Ident,FOLLOW_Ident_in_question237); if (state.failed) return result;
			match(input,Colon,FOLLOW_Colon_in_question239); if (state.failed) return result;
			String3=(Token)match(input,String,FOLLOW_String_in_question241); if (state.failed) return result;
			pushFollow(FOLLOW_type_in_question245);
			tp=type();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = new Question(new Ident((Ident2!=null?Ident2.getText():null)), (String3!=null?String3.getText():null), tp); }
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
	// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:64:1: type returns [Type result] : ( 'string' (cp= computation )? | 'boolean' (cp= computation )? | 'integer' (cp= computation )? );
	public final Type type() throws RecognitionException {
		Type result = null;

		int type_StartIndex = input.index();

		Expr cp =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:65:3: ( 'string' (cp= computation )? | 'boolean' (cp= computation )? | 'integer' (cp= computation )? )
			int alt8=3;
			switch ( input.LA(1) ) {
			case 35:
				{
				alt8=1;
				}
				break;
			case 32:
				{
				alt8=2;
				}
				break;
			case 34:
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
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:65:5: 'string' (cp= computation )?
					{
					match(input,35,FOLLOW_35_in_type264); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new StringType(); }
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:65:48: (cp= computation )?
					int alt5=2;
					int LA5_0 = input.LA(1);
					if ( (LA5_0==OParen) ) {
						alt5=1;
					}
					switch (alt5) {
						case 1 :
							// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:65:50: cp= computation
							{
							pushFollow(FOLLOW_computation_in_type274);
							cp=computation();
							state._fsp--;
							if (state.failed) return result;
							if ( state.backtracking==0 ) { result.add(cp); }
							}
							break;

					}

					}
					break;
				case 2 :
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:66:5: 'boolean' (cp= computation )?
					{
					match(input,32,FOLLOW_32_in_type286); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new BooleanType(); }
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:66:48: (cp= computation )?
					int alt6=2;
					int LA6_0 = input.LA(1);
					if ( (LA6_0==OParen) ) {
						alt6=1;
					}
					switch (alt6) {
						case 1 :
							// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:66:50: cp= computation
							{
							pushFollow(FOLLOW_computation_in_type294);
							cp=computation();
							state._fsp--;
							if (state.failed) return result;
							if ( state.backtracking==0 ) { result.add(cp); }
							}
							break;

					}

					}
					break;
				case 3 :
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:67:5: 'integer' (cp= computation )?
					{
					match(input,34,FOLLOW_34_in_type306); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new IntegerType(); }
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:67:48: (cp= computation )?
					int alt7=2;
					int LA7_0 = input.LA(1);
					if ( (LA7_0==OParen) ) {
						alt7=1;
					}
					switch (alt7) {
						case 1 :
							// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:67:50: cp= computation
							{
							pushFollow(FOLLOW_computation_in_type314);
							cp=computation();
							state._fsp--;
							if (state.failed) return result;
							if ( state.backtracking==0 ) { result.add(cp); }
							}
							break;

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
			if ( state.backtracking>0 ) { memoize(input, 6, type_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "type"



	// $ANTLR start "computation"
	// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:70:1: computation returns [Expr result] : '(' expr= orExpr ')' ;
	public final Expr computation() throws RecognitionException {
		Expr result = null;

		int computation_StartIndex = input.index();

		Expr expr =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:71:3: ( '(' expr= orExpr ')' )
			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:71:5: '(' expr= orExpr ')'
			{
			match(input,OParen,FOLLOW_OParen_in_computation339); if (state.failed) return result;
			pushFollow(FOLLOW_orExpr_in_computation343);
			expr=orExpr();
			state._fsp--;
			if (state.failed) return result;
			match(input,CParen,FOLLOW_CParen_in_computation345); if (state.failed) return result;
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
	// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:74:1: primary returns [Expr result] : ( Int | Ident | Bool | String | '(' x= orExpr ')' );
	public final Expr primary() throws RecognitionException {
		Expr result = null;

		int primary_StartIndex = input.index();

		Token Int4=null;
		Token Ident5=null;
		Token Bool6=null;
		Token String7=null;
		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:75:3: ( Int | Ident | Bool | String | '(' x= orExpr ')' )
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
			case OParen:
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
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:75:5: Int
					{
					Int4=(Token)match(input,Int,FOLLOW_Int_in_primary364); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Int(Integer.parseInt((Int4!=null?Int4.getText():null))); }
					}
					break;
				case 2 :
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:76:5: Ident
					{
					Ident5=(Token)match(input,Ident,FOLLOW_Ident_in_primary376); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Ident((Ident5!=null?Ident5.getText():null)); }
					}
					break;
				case 3 :
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:77:5: Bool
					{
					Bool6=(Token)match(input,Bool,FOLLOW_Bool_in_primary386); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Bool(Boolean.parseBoolean((Bool6!=null?Bool6.getText():null))); }
					}
					break;
				case 4 :
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:78:5: String
					{
					String7=(Token)match(input,String,FOLLOW_String_in_primary397); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new StringLiteral((String7!=null?String7.getText():null)); }
					}
					break;
				case 5 :
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:79:5: '(' x= orExpr ')'
					{
					match(input,OParen,FOLLOW_OParen_in_primary406); if (state.failed) return result;
					pushFollow(FOLLOW_orExpr_in_primary410);
					x=orExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,CParen,FOLLOW_CParen_in_primary412); if (state.failed) return result;
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
	// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:82:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
	public final Expr unExpr() throws RecognitionException {
		Expr result = null;

		int unExpr_StartIndex = input.index();

		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:83:3: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
			int alt10=4;
			switch ( input.LA(1) ) {
			case 24:
				{
				alt10=1;
				}
				break;
			case 25:
				{
				alt10=2;
				}
				break;
			case 20:
				{
				alt10=3;
				}
				break;
			case Bool:
			case Ident:
			case Int:
			case OParen:
			case String:
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
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:83:6: '+' x= unExpr
					{
					match(input,24,FOLLOW_24_in_unExpr436); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr440);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Pos(x); }
					}
					break;
				case 2 :
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:84:6: '-' x= unExpr
					{
					match(input,25,FOLLOW_25_in_unExpr449); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr453);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Neg(x); }
					}
					break;
				case 3 :
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:85:6: '!' x= unExpr
					{
					match(input,20,FOLLOW_20_in_unExpr462); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr466);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Not(x); }
					}
					break;
				case 4 :
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:86:6: x= primary
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
	// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:89:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
	public final Expr mulExpr() throws RecognitionException {
		Expr result = null;

		int mulExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:90:3: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:90:7: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
			{
			pushFollow(FOLLOW_unExpr_in_mulExpr511);
			lhs=unExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:90:43: (op= ( '*' | '/' ) rhs= unExpr )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==23||LA11_0==26) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:90:45: op= ( '*' | '/' ) rhs= unExpr
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
	// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:102:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
	public final Expr addExpr() throws RecognitionException {
		Expr result = null;

		int addExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:103:3: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:103:7: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
			{
			pushFollow(FOLLOW_mulExpr_in_addExpr566);
			lhs=mulExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:103:44: (op= ( '+' | '-' ) rhs= mulExpr )*
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( ((LA12_0 >= 24 && LA12_0 <= 25)) ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:103:46: op= ( '+' | '-' ) rhs= mulExpr
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
	// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:114:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
	public final Expr relExpr() throws RecognitionException {
		Expr result = null;

		int relExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }

			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:115:3: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:115:7: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			{
			pushFollow(FOLLOW_addExpr_in_relExpr614);
			lhs=addExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:115:44: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0==21||(LA13_0 >= 27 && LA13_0 <= 31)) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:115:46: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==21||(input.LA(1) >= 27 && input.LA(1) <= 31) ) {
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
	// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:138:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
	public final Expr andExpr() throws RecognitionException {
		Expr result = null;

		int andExpr_StartIndex = input.index();

		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return result; }

			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:139:3: (lhs= relExpr ( '&&' rhs= relExpr )* )
			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:139:7: lhs= relExpr ( '&&' rhs= relExpr )*
			{
			pushFollow(FOLLOW_relExpr_in_andExpr670);
			lhs=relExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:139:44: ( '&&' rhs= relExpr )*
			loop14:
			while (true) {
				int alt14=2;
				int LA14_0 = input.LA(1);
				if ( (LA14_0==22) ) {
					alt14=1;
				}

				switch (alt14) {
				case 1 :
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:139:46: '&&' rhs= relExpr
					{
					match(input,22,FOLLOW_22_in_andExpr676); if (state.failed) return result;
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
	// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:143:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
	public final Expr orExpr() throws RecognitionException {
		Expr result = null;

		int orExpr_StartIndex = input.index();

		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return result; }

			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:144:3: (lhs= andExpr ( '||' rhs= andExpr )* )
			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:144:7: lhs= andExpr ( '||' rhs= andExpr )*
			{
			pushFollow(FOLLOW_andExpr_in_orExpr711);
			lhs=andExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = lhs; }
			// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:144:46: ( '||' rhs= andExpr )*
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( (LA15_0==36) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:144:48: '||' rhs= andExpr
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
		// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:48:7: ( Else )
		// C:\\GIT\\sea-of-ql\\ruudvanderweijde\\sea-of-ql\\ruudvanderweijde\\src\\org\\uva\\sea\\ql\\parser\\QL.g:48:8: Else
		{
		match(input,Else,FOLLOW_Else_in_synpred4_QL187); if (state.failed) return;
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



	public static final BitSet FOLLOW_33_in_form57 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_Ident_in_form59 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_block_in_form63 = new BitSet(new long[]{0x0000000200000002L});
	public static final BitSet FOLLOW_OBrace_in_block98 = new BitSet(new long[]{0x0000000000000C20L});
	public static final BitSet FOLLOW_statement_in_block104 = new BitSet(new long[]{0x0000000000000C20L});
	public static final BitSet FOLLOW_CBrace_in_block111 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_question_in_statement132 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifStatement_in_statement145 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_If_in_ifStatement166 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_OParen_in_ifStatement168 = new BitSet(new long[]{0x0000000003151410L});
	public static final BitSet FOLLOW_orExpr_in_ifStatement172 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_CParen_in_ifStatement174 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_block_in_ifStatement178 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_Else_in_ifStatement191 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_block_in_ifStatement195 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_question237 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Colon_in_question239 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_String_in_question241 = new BitSet(new long[]{0x0000000D00000000L});
	public static final BitSet FOLLOW_type_in_question245 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_35_in_type264 = new BitSet(new long[]{0x0000000000010002L});
	public static final BitSet FOLLOW_computation_in_type274 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_32_in_type286 = new BitSet(new long[]{0x0000000000010002L});
	public static final BitSet FOLLOW_computation_in_type294 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_34_in_type306 = new BitSet(new long[]{0x0000000000010002L});
	public static final BitSet FOLLOW_computation_in_type314 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OParen_in_computation339 = new BitSet(new long[]{0x0000000003151410L});
	public static final BitSet FOLLOW_orExpr_in_computation343 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_CParen_in_computation345 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Int_in_primary364 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_primary376 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Bool_in_primary386 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_String_in_primary397 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OParen_in_primary406 = new BitSet(new long[]{0x0000000003151410L});
	public static final BitSet FOLLOW_orExpr_in_primary410 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_CParen_in_primary412 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_24_in_unExpr436 = new BitSet(new long[]{0x0000000003151410L});
	public static final BitSet FOLLOW_unExpr_in_unExpr440 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_25_in_unExpr449 = new BitSet(new long[]{0x0000000003151410L});
	public static final BitSet FOLLOW_unExpr_in_unExpr453 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_20_in_unExpr462 = new BitSet(new long[]{0x0000000003151410L});
	public static final BitSet FOLLOW_unExpr_in_unExpr466 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpr477 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr511 = new BitSet(new long[]{0x0000000004800002L});
	public static final BitSet FOLLOW_set_in_mulExpr519 = new BitSet(new long[]{0x0000000003151410L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr531 = new BitSet(new long[]{0x0000000004800002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr566 = new BitSet(new long[]{0x0000000003000002L});
	public static final BitSet FOLLOW_set_in_addExpr574 = new BitSet(new long[]{0x0000000003151410L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr584 = new BitSet(new long[]{0x0000000003000002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr614 = new BitSet(new long[]{0x00000000F8200002L});
	public static final BitSet FOLLOW_set_in_relExpr622 = new BitSet(new long[]{0x0000000003151410L});
	public static final BitSet FOLLOW_addExpr_in_relExpr638 = new BitSet(new long[]{0x00000000F8200002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr670 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_22_in_andExpr676 = new BitSet(new long[]{0x0000000003151410L});
	public static final BitSet FOLLOW_relExpr_in_andExpr680 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr711 = new BitSet(new long[]{0x0000001000000002L});
	public static final BitSet FOLLOW_36_in_orExpr717 = new BitSet(new long[]{0x0000000003151410L});
	public static final BitSet FOLLOW_andExpr_in_orExpr721 = new BitSet(new long[]{0x0000001000000002L});
	public static final BitSet FOLLOW_Else_in_synpred4_QL187 = new BitSet(new long[]{0x0000000000000002L});
}
