// $ANTLR 3.4 C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g 2013-01-28 14:06:50

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expressions.*;
import org.uva.sea.ql.ast.questions.*;
import org.uva.sea.ql.ast.values.*;
import org.uva.sea.ql.ast.types.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class QLParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Bool", "COMMENT", "Ident", "Int", "String", "WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", "'/'", "':'", "'<'", "'<='", "'='", "'=='", "'>'", "'>='", "'boolean'", "'else'", "'form'", "'if'", "'integer'", "'money'", "'string'", "'{'", "'||'", "'}'"
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
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int Bool=4;
    public static final int COMMENT=5;
    public static final int Ident=6;
    public static final int Int=7;
    public static final int String=8;
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
        this.state.ruleMemo = new HashMap[44+1];
         

    }

    public String[] getTokenNames() { return QLParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g"; }



    // $ANTLR start "form"
    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:19:1: form returns [Form result] : 'form' Ident '{' (body= formStatement )* '}' ;
    public final Form form() throws RecognitionException {
        Form result = null;

        int form_StartIndex = input.index();

        Token Ident1=null;
        FormStatement body =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

            // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:20:5: ( 'form' Ident '{' (body= formStatement )* '}' )
            // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:20:9: 'form' Ident '{' (body= formStatement )* '}'
            {
            match(input,28,FOLLOW_28_in_form50); if (state.failed) return result;

            Ident1=(Token)match(input,Ident,FOLLOW_Ident_in_form52); if (state.failed) return result;

            match(input,33,FOLLOW_33_in_form54); if (state.failed) return result;

            // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:20:30: (body= formStatement )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==String||LA1_0==29) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:20:30: body= formStatement
            	    {
            	    pushFollow(FOLLOW_formStatement_in_form58);
            	    body=formStatement();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            match(input,35,FOLLOW_35_in_form61); if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new Form(new Ident((Ident1!=null?Ident1.getText():null)), body); }

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



    // $ANTLR start "formStatement"
    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:23:1: formStatement returns [FormStatement result] : ( question | conditionBlock );
    public final FormStatement formStatement() throws RecognitionException {
        FormStatement result = null;

        int formStatement_StartIndex = input.index();

        Question question2 =null;

        ConditionBlock conditionBlock3 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

            // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:24:5: ( question | conditionBlock )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==String) ) {
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
                    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:24:9: question
                    {
                    pushFollow(FOLLOW_question_in_formStatement86);
                    question2=question();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = question2; }

                    }
                    break;
                case 2 :
                    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:25:9: conditionBlock
                    {
                    pushFollow(FOLLOW_conditionBlock_in_formStatement106);
                    conditionBlock3=conditionBlock();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = conditionBlock3; }

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
            if ( state.backtracking>0 ) { memoize(input, 2, formStatement_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "formStatement"



    // $ANTLR start "question"
    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:28:1: question returns [Question result] : ( String Ident ':' t= type | String Ident '=' e= orExpr );
    public final Question question() throws RecognitionException {
        Question result = null;

        int question_StartIndex = input.index();

        Token String4=null;
        Token Ident5=null;
        Token String6=null;
        Token Ident7=null;
        Type t =null;

        Expr e =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

            // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:29:5: ( String Ident ':' t= type | String Ident '=' e= orExpr )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==String) ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==Ident) ) {
                    int LA3_2 = input.LA(3);

                    if ( (LA3_2==19) ) {
                        alt3=1;
                    }
                    else if ( (LA3_2==22) ) {
                        alt3=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return result;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 2, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return result;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 1, input);

                    throw nvae;

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
                    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:29:9: String Ident ':' t= type
                    {
                    String4=(Token)match(input,String,FOLLOW_String_in_question133); if (state.failed) return result;

                    Ident5=(Token)match(input,Ident,FOLLOW_Ident_in_question135); if (state.failed) return result;

                    match(input,19,FOLLOW_19_in_question137); if (state.failed) return result;

                    pushFollow(FOLLOW_type_in_question141);
                    t=type();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new AnswerableQuestion(new org.uva.sea.ql.ast.values.Str((String4!=null?String4.getText():null)), new Ident((Ident5!=null?Ident5.getText():null)), t); }

                    }
                    break;
                case 2 :
                    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:30:9: String Ident '=' e= orExpr
                    {
                    String6=(Token)match(input,String,FOLLOW_String_in_question153); if (state.failed) return result;

                    Ident7=(Token)match(input,Ident,FOLLOW_Ident_in_question155); if (state.failed) return result;

                    match(input,22,FOLLOW_22_in_question157); if (state.failed) return result;

                    pushFollow(FOLLOW_orExpr_in_question161);
                    e=orExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new ComputedQuestion(new org.uva.sea.ql.ast.values.Str((String6!=null?String6.getText():null)), new Ident((Ident7!=null?Ident7.getText():null)), e); }

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
            if ( state.backtracking>0 ) { memoize(input, 3, question_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "question"



    // $ANTLR start "conditionBlock"
    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:33:1: conditionBlock returns [ConditionBlock result] : ( 'if' '(' condition= orExpr ')' ifBody= conditionBody 'else' elseBody= conditionBody | 'if' '(' condition= orExpr ')' ifBody= conditionBody );
    public final ConditionBlock conditionBlock() throws RecognitionException {
        ConditionBlock result = null;

        int conditionBlock_StartIndex = input.index();

        Expr condition =null;

        FormStatement ifBody =null;

        FormStatement elseBody =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

            // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:34:5: ( 'if' '(' condition= orExpr ')' ifBody= conditionBody 'else' elseBody= conditionBody | 'if' '(' condition= orExpr ')' ifBody= conditionBody )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==29) ) {
                int LA4_1 = input.LA(2);

                if ( (synpred4_QL()) ) {
                    alt4=1;
                }
                else if ( (true) ) {
                    alt4=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return result;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 1, input);

                    throw nvae;

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
                    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:34:9: 'if' '(' condition= orExpr ')' ifBody= conditionBody 'else' elseBody= conditionBody
                    {
                    match(input,29,FOLLOW_29_in_conditionBlock186); if (state.failed) return result;

                    match(input,13,FOLLOW_13_in_conditionBlock188); if (state.failed) return result;

                    pushFollow(FOLLOW_orExpr_in_conditionBlock192);
                    condition=orExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,14,FOLLOW_14_in_conditionBlock194); if (state.failed) return result;

                    pushFollow(FOLLOW_conditionBody_in_conditionBlock198);
                    ifBody=conditionBody();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,27,FOLLOW_27_in_conditionBlock200); if (state.failed) return result;

                    pushFollow(FOLLOW_conditionBody_in_conditionBlock204);
                    elseBody=conditionBody();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new ConditionBlock(condition, ifBody, elseBody); }

                    }
                    break;
                case 2 :
                    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:36:9: 'if' '(' condition= orExpr ')' ifBody= conditionBody
                    {
                    match(input,29,FOLLOW_29_in_conditionBlock224); if (state.failed) return result;

                    match(input,13,FOLLOW_13_in_conditionBlock226); if (state.failed) return result;

                    pushFollow(FOLLOW_orExpr_in_conditionBlock230);
                    condition=orExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,14,FOLLOW_14_in_conditionBlock232); if (state.failed) return result;

                    pushFollow(FOLLOW_conditionBody_in_conditionBlock236);
                    ifBody=conditionBody();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new ConditionBlock(condition, ifBody); }

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
            if ( state.backtracking>0 ) { memoize(input, 4, conditionBlock_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "conditionBlock"



    // $ANTLR start "conditionBody"
    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:40:1: conditionBody returns [FormStatement result] : ( '{' body= formStatement '}' |body= formStatement | '{' (body= formStatement )* '}' | (body= formStatement )* );
    public final FormStatement conditionBody() throws RecognitionException {
        FormStatement result = null;

        int conditionBody_StartIndex = input.index();

        FormStatement body =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

            // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:41:5: ( '{' body= formStatement '}' |body= formStatement | '{' (body= formStatement )* '}' | (body= formStatement )* )
            int alt7=4;
            switch ( input.LA(1) ) {
            case 33:
                {
                int LA7_1 = input.LA(2);

                if ( (synpred5_QL()) ) {
                    alt7=1;
                }
                else if ( (synpred8_QL()) ) {
                    alt7=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return result;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;

                }
                }
                break;
            case String:
                {
                int LA7_2 = input.LA(2);

                if ( (synpred6_QL()) ) {
                    alt7=2;
                }
                else if ( (true) ) {
                    alt7=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return result;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 2, input);

                    throw nvae;

                }
                }
                break;
            case 29:
                {
                int LA7_3 = input.LA(2);

                if ( (synpred6_QL()) ) {
                    alt7=2;
                }
                else if ( (true) ) {
                    alt7=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return result;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 3, input);

                    throw nvae;

                }
                }
                break;
            case EOF:
            case 27:
            case 35:
                {
                alt7=4;
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
                    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:41:9: '{' body= formStatement '}'
                    {
                    match(input,33,FOLLOW_33_in_conditionBody269); if (state.failed) return result;

                    pushFollow(FOLLOW_formStatement_in_conditionBody273);
                    body=formStatement();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,35,FOLLOW_35_in_conditionBody275); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = body; }

                    }
                    break;
                case 2 :
                    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:42:9: body= formStatement
                    {
                    pushFollow(FOLLOW_formStatement_in_conditionBody290);
                    body=formStatement();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = body; }

                    }
                    break;
                case 3 :
                    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:43:9: '{' (body= formStatement )* '}'
                    {
                    match(input,33,FOLLOW_33_in_conditionBody311); if (state.failed) return result;

                    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:43:17: (body= formStatement )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==String||LA5_0==29) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:43:17: body= formStatement
                    	    {
                    	    pushFollow(FOLLOW_formStatement_in_conditionBody315);
                    	    body=formStatement();

                    	    state._fsp--;
                    	    if (state.failed) return result;

                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);


                    match(input,35,FOLLOW_35_in_conditionBody318); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = body; }

                    }
                    break;
                case 4 :
                    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:44:9: (body= formStatement )*
                    {
                    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:44:13: (body= formStatement )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==String) ) {
                            int LA6_2 = input.LA(2);

                            if ( (synpred9_QL()) ) {
                                alt6=1;
                            }


                        }
                        else if ( (LA6_0==29) ) {
                            int LA6_3 = input.LA(2);

                            if ( (synpred9_QL()) ) {
                                alt6=1;
                            }


                        }


                        switch (alt6) {
                    	case 1 :
                    	    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:44:13: body= formStatement
                    	    {
                    	    pushFollow(FOLLOW_formStatement_in_conditionBody332);
                    	    body=formStatement();

                    	    state._fsp--;
                    	    if (state.failed) return result;

                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);


                    if ( state.backtracking==0 ) { result = body; }

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
            if ( state.backtracking>0 ) { memoize(input, 5, conditionBody_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "conditionBody"



    // $ANTLR start "primary"
    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:47:1: primary returns [Expr result] : ( Int | Bool | String | Ident | '(' x= orExpr ')' );
    public final Expr primary() throws RecognitionException {
        Expr result = null;

        int primary_StartIndex = input.index();

        Token Int8=null;
        Token Bool9=null;
        Token String10=null;
        Token Ident11=null;
        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

            // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:48:5: ( Int | Bool | String | Ident | '(' x= orExpr ')' )
            int alt8=5;
            switch ( input.LA(1) ) {
            case Int:
                {
                alt8=1;
                }
                break;
            case Bool:
                {
                alt8=2;
                }
                break;
            case String:
                {
                alt8=3;
                }
                break;
            case Ident:
                {
                alt8=4;
                }
                break;
            case 13:
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
                    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:48:9: Int
                    {
                    Int8=(Token)match(input,Int,FOLLOW_Int_in_primary366); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.values.Int(Integer.parseInt((Int8!=null?Int8.getText():null))); }

                    }
                    break;
                case 2 :
                    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:49:9: Bool
                    {
                    Bool9=(Token)match(input,Bool,FOLLOW_Bool_in_primary381); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.values.Bool(Boolean.parseBoolean((Bool9!=null?Bool9.getText():null))); }

                    }
                    break;
                case 3 :
                    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:50:9: String
                    {
                    String10=(Token)match(input,String,FOLLOW_String_in_primary395); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.values.Str((String10!=null?String10.getText():null)); }

                    }
                    break;
                case 4 :
                    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:51:9: Ident
                    {
                    Ident11=(Token)match(input,Ident,FOLLOW_Ident_in_primary407); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Ident((Ident11!=null?Ident11.getText():null)); }

                    }
                    break;
                case 5 :
                    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:52:9: '(' x= orExpr ')'
                    {
                    match(input,13,FOLLOW_13_in_primary420); if (state.failed) return result;

                    pushFollow(FOLLOW_orExpr_in_primary424);
                    x=orExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,14,FOLLOW_14_in_primary426); if (state.failed) return result;

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
            if ( state.backtracking>0 ) { memoize(input, 6, primary_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "primary"



    // $ANTLR start "unExpr"
    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:55:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
    public final Expr unExpr() throws RecognitionException {
        Expr result = null;

        int unExpr_StartIndex = input.index();

        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

            // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:56:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
            int alt9=4;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt9=1;
                }
                break;
            case 17:
                {
                alt9=2;
                }
                break;
            case 10:
                {
                alt9=3;
                }
                break;
            case Bool:
            case Ident:
            case Int:
            case String:
            case 13:
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
                    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:56:9: '+' x= unExpr
                    {
                    match(input,16,FOLLOW_16_in_unExpr454); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr458);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Pos(x); }

                    }
                    break;
                case 2 :
                    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:57:9: '-' x= unExpr
                    {
                    match(input,17,FOLLOW_17_in_unExpr470); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr474);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Neg(x); }

                    }
                    break;
                case 3 :
                    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:58:9: '!' x= unExpr
                    {
                    match(input,10,FOLLOW_10_in_unExpr486); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr490);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Not(x); }

                    }
                    break;
                case 4 :
                    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:59:9: x= primary
                    {
                    pushFollow(FOLLOW_primary_in_unExpr504);
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
            if ( state.backtracking>0 ) { memoize(input, 7, unExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "unExpr"



    // $ANTLR start "mulExpr"
    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:62:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
    public final Expr mulExpr() throws RecognitionException {
        Expr result = null;

        int mulExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

            // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:63:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
            // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:63:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
            {
            pushFollow(FOLLOW_unExpr_in_mulExpr542);
            lhs=unExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:63:45: (op= ( '*' | '/' ) rhs= unExpr )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==15||LA10_0==18) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:63:47: op= ( '*' | '/' ) rhs= unExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( input.LA(1)==15||input.LA(1)==18 ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_unExpr_in_mulExpr562);
            	    rhs=unExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { 
            	            if ((op!=null?op.getText():null).equals("*"))  { result = new Mul(result, rhs); }
            	            if ((op!=null?op.getText():null).equals("<=")) { result = new Div(result, rhs); }
            	        }

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 8, mulExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "mulExpr"



    // $ANTLR start "addExpr"
    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:70:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
    public final Expr addExpr() throws RecognitionException {
        Expr result = null;

        int addExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

            // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:71:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
            // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:71:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
            {
            pushFollow(FOLLOW_mulExpr_in_addExpr600);
            lhs=mulExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:71:46: (op= ( '+' | '-' ) rhs= mulExpr )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0 >= 16 && LA11_0 <= 17)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:71:48: op= ( '+' | '-' ) rhs= mulExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( (input.LA(1) >= 16 && input.LA(1) <= 17) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_mulExpr_in_addExpr618);
            	    rhs=mulExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { 
            	            if ((op!=null?op.getText():null).equals("+")) { result = new Add(result, rhs); }
            	            if ((op!=null?op.getText():null).equals("-")) { result = new Sub(result, rhs); }
            	        }

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 9, addExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "addExpr"



    // $ANTLR start "relExpr"
    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:78:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
    public final Expr relExpr() throws RecognitionException {
        Expr result = null;

        int relExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

            // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:79:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
            // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:79:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            {
            pushFollow(FOLLOW_addExpr_in_relExpr653);
            lhs=addExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:79:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==11||(LA12_0 >= 20 && LA12_0 <= 21)||(LA12_0 >= 23 && LA12_0 <= 25)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:79:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( input.LA(1)==11||(input.LA(1) >= 20 && input.LA(1) <= 21)||(input.LA(1) >= 23 && input.LA(1) <= 25) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_addExpr_in_relExpr677);
            	    rhs=addExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { 
            	            if ((op!=null?op.getText():null).equals("<"))  { result = new LT(result, rhs);  }
            	            if ((op!=null?op.getText():null).equals("<=")) { result = new LEq(result, rhs); }
            	            if ((op!=null?op.getText():null).equals(">"))  { result = new GT(result, rhs);  }
            	            if ((op!=null?op.getText():null).equals(">=")) { result = new GEq(result, rhs); }
            	            if ((op!=null?op.getText():null).equals("==")) { result = new Eq(result, rhs);  }
            	            if ((op!=null?op.getText():null).equals("!=")) { result = new NEq(result, rhs); }
            	        }

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 10, relExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "relExpr"



    // $ANTLR start "andExpr"
    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:90:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
    public final Expr andExpr() throws RecognitionException {
        Expr result = null;

        int andExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

            // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:91:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
            // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:91:9: lhs= relExpr ( '&&' rhs= relExpr )*
            {
            pushFollow(FOLLOW_relExpr_in_andExpr715);
            lhs=relExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:91:46: ( '&&' rhs= relExpr )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==12) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:91:48: '&&' rhs= relExpr
            	    {
            	    match(input,12,FOLLOW_12_in_andExpr721); if (state.failed) return result;

            	    pushFollow(FOLLOW_relExpr_in_andExpr725);
            	    rhs=relExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { result = new And(result, rhs); }

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 11, andExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "andExpr"



    // $ANTLR start "orExpr"
    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:95:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
    public final Expr orExpr() throws RecognitionException {
        Expr result = null;

        int orExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }

            // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:96:5: (lhs= andExpr ( '||' rhs= andExpr )* )
            // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:96:9: lhs= andExpr ( '||' rhs= andExpr )*
            {
            pushFollow(FOLLOW_andExpr_in_orExpr760);
            lhs=andExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = lhs; }

            // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:96:48: ( '||' rhs= andExpr )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==34) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:96:50: '||' rhs= andExpr
            	    {
            	    match(input,34,FOLLOW_34_in_orExpr766); if (state.failed) return result;

            	    pushFollow(FOLLOW_andExpr_in_orExpr770);
            	    rhs=andExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { result = new Or(result, rhs); }

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 12, orExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "orExpr"



    // $ANTLR start "type"
    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:99:1: type returns [Type result] : ( 'integer' | 'string' | 'boolean' | 'money' );
    public final Type type() throws RecognitionException {
        Type result = null;

        int type_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return result; }

            // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:100:5: ( 'integer' | 'string' | 'boolean' | 'money' )
            int alt15=4;
            switch ( input.LA(1) ) {
            case 30:
                {
                alt15=1;
                }
                break;
            case 32:
                {
                alt15=2;
                }
                break;
            case 26:
                {
                alt15=3;
                }
                break;
            case 31:
                {
                alt15=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;

            }

            switch (alt15) {
                case 1 :
                    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:100:9: 'integer'
                    {
                    match(input,30,FOLLOW_30_in_type798); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.types.Int();  }

                    }
                    break;
                case 2 :
                    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:101:9: 'string'
                    {
                    match(input,32,FOLLOW_32_in_type810); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.types.Str();  }

                    }
                    break;
                case 3 :
                    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:102:9: 'boolean'
                    {
                    match(input,26,FOLLOW_26_in_type823); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.types.Bool(); }

                    }
                    break;
                case 4 :
                    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:103:9: 'money'
                    {
                    match(input,31,FOLLOW_31_in_type835); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.types.Int();  }

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
            if ( state.backtracking>0 ) { memoize(input, 13, type_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "type"

    // $ANTLR start synpred4_QL
    public final void synpred4_QL_fragment() throws RecognitionException {
        Expr condition =null;

        FormStatement ifBody =null;

        FormStatement elseBody =null;


        // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:34:9: ( 'if' '(' condition= orExpr ')' ifBody= conditionBody 'else' elseBody= conditionBody )
        // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:34:9: 'if' '(' condition= orExpr ')' ifBody= conditionBody 'else' elseBody= conditionBody
        {
        match(input,29,FOLLOW_29_in_synpred4_QL186); if (state.failed) return ;

        match(input,13,FOLLOW_13_in_synpred4_QL188); if (state.failed) return ;

        pushFollow(FOLLOW_orExpr_in_synpred4_QL192);
        condition=orExpr();

        state._fsp--;
        if (state.failed) return ;

        match(input,14,FOLLOW_14_in_synpred4_QL194); if (state.failed) return ;

        pushFollow(FOLLOW_conditionBody_in_synpred4_QL198);
        ifBody=conditionBody();

        state._fsp--;
        if (state.failed) return ;

        match(input,27,FOLLOW_27_in_synpred4_QL200); if (state.failed) return ;

        pushFollow(FOLLOW_conditionBody_in_synpred4_QL204);
        elseBody=conditionBody();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred4_QL

    // $ANTLR start synpred5_QL
    public final void synpred5_QL_fragment() throws RecognitionException {
        FormStatement body =null;


        // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:41:9: ( '{' body= formStatement '}' )
        // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:41:9: '{' body= formStatement '}'
        {
        match(input,33,FOLLOW_33_in_synpred5_QL269); if (state.failed) return ;

        pushFollow(FOLLOW_formStatement_in_synpred5_QL273);
        body=formStatement();

        state._fsp--;
        if (state.failed) return ;

        match(input,35,FOLLOW_35_in_synpred5_QL275); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred5_QL

    // $ANTLR start synpred6_QL
    public final void synpred6_QL_fragment() throws RecognitionException {
        FormStatement body =null;


        // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:42:9: (body= formStatement )
        // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:42:9: body= formStatement
        {
        pushFollow(FOLLOW_formStatement_in_synpred6_QL290);
        body=formStatement();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred6_QL

    // $ANTLR start synpred8_QL
    public final void synpred8_QL_fragment() throws RecognitionException {
        FormStatement body =null;


        // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:43:9: ( '{' (body= formStatement )* '}' )
        // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:43:9: '{' (body= formStatement )* '}'
        {
        match(input,33,FOLLOW_33_in_synpred8_QL311); if (state.failed) return ;

        // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:43:17: (body= formStatement )*
        loop16:
        do {
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==String||LA16_0==29) ) {
                alt16=1;
            }


            switch (alt16) {
        	case 1 :
        	    // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:43:17: body= formStatement
        	    {
        	    pushFollow(FOLLOW_formStatement_in_synpred8_QL315);
        	    body=formStatement();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop16;
            }
        } while (true);


        match(input,35,FOLLOW_35_in_synpred8_QL318); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred8_QL

    // $ANTLR start synpred9_QL
    public final void synpred9_QL_fragment() throws RecognitionException {
        FormStatement body =null;


        // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:44:13: (body= formStatement )
        // C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:44:13: body= formStatement
        {
        pushFollow(FOLLOW_formStatement_in_synpred9_QL332);
        body=formStatement();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred9_QL

    // Delegated rules

    public final boolean synpred5_QL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_QL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_QL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_QL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
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
    public final boolean synpred9_QL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_QL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_QL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_QL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_28_in_form50 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_Ident_in_form52 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_form54 = new BitSet(new long[]{0x0000000820000100L});
    public static final BitSet FOLLOW_formStatement_in_form58 = new BitSet(new long[]{0x0000000820000100L});
    public static final BitSet FOLLOW_35_in_form61 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_question_in_formStatement86 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditionBlock_in_formStatement106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_String_in_question133 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_Ident_in_question135 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_question137 = new BitSet(new long[]{0x00000001C4000000L});
    public static final BitSet FOLLOW_type_in_question141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_String_in_question153 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_Ident_in_question155 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_question157 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_orExpr_in_question161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_conditionBlock186 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_conditionBlock188 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_orExpr_in_conditionBlock192 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_conditionBlock194 = new BitSet(new long[]{0x0000000228000100L});
    public static final BitSet FOLLOW_conditionBody_in_conditionBlock198 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_conditionBlock200 = new BitSet(new long[]{0x0000000220000100L});
    public static final BitSet FOLLOW_conditionBody_in_conditionBlock204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_conditionBlock224 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_conditionBlock226 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_orExpr_in_conditionBlock230 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_conditionBlock232 = new BitSet(new long[]{0x0000000220000100L});
    public static final BitSet FOLLOW_conditionBody_in_conditionBlock236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_conditionBody269 = new BitSet(new long[]{0x0000000020000100L});
    public static final BitSet FOLLOW_formStatement_in_conditionBody273 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_conditionBody275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_formStatement_in_conditionBody290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_conditionBody311 = new BitSet(new long[]{0x0000000820000100L});
    public static final BitSet FOLLOW_formStatement_in_conditionBody315 = new BitSet(new long[]{0x0000000820000100L});
    public static final BitSet FOLLOW_35_in_conditionBody318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_formStatement_in_conditionBody332 = new BitSet(new long[]{0x0000000020000102L});
    public static final BitSet FOLLOW_Int_in_primary366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Bool_in_primary381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_String_in_primary395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_primary407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_primary420 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_orExpr_in_primary424 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_primary426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_unExpr454 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_unExpr470 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_unExpr486 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_unExpr504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr542 = new BitSet(new long[]{0x0000000000048002L});
    public static final BitSet FOLLOW_set_in_mulExpr550 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr562 = new BitSet(new long[]{0x0000000000048002L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr600 = new BitSet(new long[]{0x0000000000030002L});
    public static final BitSet FOLLOW_set_in_addExpr608 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr618 = new BitSet(new long[]{0x0000000000030002L});
    public static final BitSet FOLLOW_addExpr_in_relExpr653 = new BitSet(new long[]{0x0000000003B00802L});
    public static final BitSet FOLLOW_set_in_relExpr661 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_addExpr_in_relExpr677 = new BitSet(new long[]{0x0000000003B00802L});
    public static final BitSet FOLLOW_relExpr_in_andExpr715 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_12_in_andExpr721 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_relExpr_in_andExpr725 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_andExpr_in_orExpr760 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_34_in_orExpr766 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_andExpr_in_orExpr770 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_30_in_type798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_type810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_type823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_type835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_synpred4_QL186 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_synpred4_QL188 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_orExpr_in_synpred4_QL192 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_synpred4_QL194 = new BitSet(new long[]{0x0000000228000100L});
    public static final BitSet FOLLOW_conditionBody_in_synpred4_QL198 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_synpred4_QL200 = new BitSet(new long[]{0x0000000220000100L});
    public static final BitSet FOLLOW_conditionBody_in_synpred4_QL204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_synpred5_QL269 = new BitSet(new long[]{0x0000000020000100L});
    public static final BitSet FOLLOW_formStatement_in_synpred5_QL273 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_synpred5_QL275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_formStatement_in_synpred6_QL290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_synpred8_QL311 = new BitSet(new long[]{0x0000000820000100L});
    public static final BitSet FOLLOW_formStatement_in_synpred8_QL315 = new BitSet(new long[]{0x0000000820000100L});
    public static final BitSet FOLLOW_35_in_synpred8_QL318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_formStatement_in_synpred9_QL332 = new BitSet(new long[]{0x0000000000000002L});

}