// $ANTLR 3.4 C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g 2013-02-22 16:58:55

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.expressions.binary.arithmetic.*;
import org.uva.sea.ql.ast.expressions.binary.logical.*;
import org.uva.sea.ql.ast.expressions.binary.relational.*;
import org.uva.sea.ql.ast.expressions.literal.*;
import org.uva.sea.ql.ast.expressions.unary.*;
import org.uva.sea.ql.ast.forms.Form;
import org.uva.sea.ql.ast.statements.conditions.*;
import org.uva.sea.ql.ast.statements.questions.*;
import org.uva.sea.ql.ast.statements.*;
import org.uva.sea.ql.ast.types.*;

import java.util.ArrayList;
import java.util.List;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class QLParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Bool", "COMMENT", "Ident", "Int", "Money", "String", "WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", "'/'", "':'", "'<'", "'<='", "'='", "'=='", "'>'", "'>='", "'boolean'", "'else'", "'form'", "'if'", "'integer'", "'money'", "'string'", "'{'", "'||'", "'}'"
    };

    public static final int EOF=-1;
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
    public static final int T__36=36;
    public static final int Bool=4;
    public static final int COMMENT=5;
    public static final int Ident=6;
    public static final int Int=7;
    public static final int Money=8;
    public static final int String=9;
    public static final int WS=10;

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

    public String[] getTokenNames() { return QLParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g"; }



    // $ANTLR start "form"
    // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:26:1: form returns [Form result] : 'form' Ident '{' body= conditionBody '}' ;
    public final Form form() throws RecognitionException {
        Form result = null;

        int form_StartIndex = input.index();

        Token Ident1=null;
        ArrayList<FormStatement> body =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

            // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:27:5: ( 'form' Ident '{' body= conditionBody '}' )
            // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:27:9: 'form' Ident '{' body= conditionBody '}'
            {
            match(input,29,FOLLOW_29_in_form50); if (state.failed) return result;

            Ident1=(Token)match(input,Ident,FOLLOW_Ident_in_form52); if (state.failed) return result;

            match(input,34,FOLLOW_34_in_form54); if (state.failed) return result;

            pushFollow(FOLLOW_conditionBody_in_form58);
            body=conditionBody();

            state._fsp--;
            if (state.failed) return result;

            match(input,36,FOLLOW_36_in_form60); if (state.failed) return result;

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
    // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:30:1: formStatement returns [FormStatement result] : ( question | conditionBlock );
    public final FormStatement formStatement() throws RecognitionException {
        FormStatement result = null;

        int formStatement_StartIndex = input.index();

        Question question2 =null;

        ConditionBlock conditionBlock3 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

            // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:31:5: ( question | conditionBlock )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==String) ) {
                alt1=1;
            }
            else if ( (LA1_0==30) ) {
                alt1=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;

            }
            switch (alt1) {
                case 1 :
                    // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:31:9: question
                    {
                    pushFollow(FOLLOW_question_in_formStatement85);
                    question2=question();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = question2; }

                    }
                    break;
                case 2 :
                    // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:32:9: conditionBlock
                    {
                    pushFollow(FOLLOW_conditionBlock_in_formStatement103);
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
    // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:35:1: question returns [Question result] : ( String Ident ':' t= type | String Ident '=' e= orExpr );
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

            // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:36:5: ( String Ident ':' t= type | String Ident '=' e= orExpr )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==String) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==Ident) ) {
                    int LA2_2 = input.LA(3);

                    if ( (LA2_2==20) ) {
                        alt2=1;
                    }
                    else if ( (LA2_2==23) ) {
                        alt2=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return result;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 2, 2, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return result;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;

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
                    // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:36:9: String Ident ':' t= type
                    {
                    String4=(Token)match(input,String,FOLLOW_String_in_question128); if (state.failed) return result;

                    Ident5=(Token)match(input,Ident,FOLLOW_Ident_in_question130); if (state.failed) return result;

                    match(input,20,FOLLOW_20_in_question132); if (state.failed) return result;

                    pushFollow(FOLLOW_type_in_question136);
                    t=type();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new AnswerableQuestion(new org.uva.sea.ql.ast.expressions.literal.Str((String4!=null?String4.getText():null)), new Ident((Ident5!=null?Ident5.getText():null)), t); }

                    }
                    break;
                case 2 :
                    // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:37:9: String Ident '=' e= orExpr
                    {
                    String6=(Token)match(input,String,FOLLOW_String_in_question148); if (state.failed) return result;

                    Ident7=(Token)match(input,Ident,FOLLOW_Ident_in_question150); if (state.failed) return result;

                    match(input,23,FOLLOW_23_in_question152); if (state.failed) return result;

                    pushFollow(FOLLOW_orExpr_in_question156);
                    e=orExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new ComputedQuestion(new org.uva.sea.ql.ast.expressions.literal.Str((String6!=null?String6.getText():null)), new Ident((Ident7!=null?Ident7.getText():null)), e); }

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
    // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:40:1: conditionBlock returns [ConditionBlock result] : ( 'if' '(' condition= orExpr ')' ifBody= conditionBody 'else' elseBody= conditionBody | 'if' '(' condition= orExpr ')' ifBody= conditionBody );
    public final ConditionBlock conditionBlock() throws RecognitionException {
        ConditionBlock result = null;

        int conditionBlock_StartIndex = input.index();

        Expr condition =null;

        ArrayList<FormStatement> ifBody =null;

        ArrayList<FormStatement> elseBody =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

            // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:41:5: ( 'if' '(' condition= orExpr ')' ifBody= conditionBody 'else' elseBody= conditionBody | 'if' '(' condition= orExpr ')' ifBody= conditionBody )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==30) ) {
                int LA3_1 = input.LA(2);

                if ( (synpred3_QL()) ) {
                    alt3=1;
                }
                else if ( (true) ) {
                    alt3=2;
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
                    // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:41:9: 'if' '(' condition= orExpr ')' ifBody= conditionBody 'else' elseBody= conditionBody
                    {
                    match(input,30,FOLLOW_30_in_conditionBlock181); if (state.failed) return result;

                    match(input,14,FOLLOW_14_in_conditionBlock183); if (state.failed) return result;

                    pushFollow(FOLLOW_orExpr_in_conditionBlock187);
                    condition=orExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,15,FOLLOW_15_in_conditionBlock189); if (state.failed) return result;

                    pushFollow(FOLLOW_conditionBody_in_conditionBlock193);
                    ifBody=conditionBody();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,28,FOLLOW_28_in_conditionBlock195); if (state.failed) return result;

                    pushFollow(FOLLOW_conditionBody_in_conditionBlock199);
                    elseBody=conditionBody();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new IfThenElse(condition, ifBody, elseBody); }

                    }
                    break;
                case 2 :
                    // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:43:9: 'if' '(' condition= orExpr ')' ifBody= conditionBody
                    {
                    match(input,30,FOLLOW_30_in_conditionBlock219); if (state.failed) return result;

                    match(input,14,FOLLOW_14_in_conditionBlock221); if (state.failed) return result;

                    pushFollow(FOLLOW_orExpr_in_conditionBlock225);
                    condition=orExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,15,FOLLOW_15_in_conditionBlock227); if (state.failed) return result;

                    pushFollow(FOLLOW_conditionBody_in_conditionBlock231);
                    ifBody=conditionBody();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new IfThen(condition, ifBody); }

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
    // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:47:1: conditionBody returns [ArrayList<FormStatement> result] : ( '{' (body= formStatement )+ '}' | (body= formStatement )+ );
    public final ArrayList<FormStatement> conditionBody() throws RecognitionException {
        ArrayList<FormStatement> result = null;

        int conditionBody_StartIndex = input.index();

        FormStatement body =null;


         ArrayList<FormStatement> statements = new ArrayList<FormStatement>(); 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

            // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:50:5: ( '{' (body= formStatement )+ '}' | (body= formStatement )+ )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==34) ) {
                alt6=1;
            }
            else if ( (LA6_0==String||LA6_0==30) ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;

            }
            switch (alt6) {
                case 1 :
                    // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:50:9: '{' (body= formStatement )+ '}'
                    {
                    match(input,34,FOLLOW_34_in_conditionBody280); if (state.failed) return result;

                    // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:50:13: (body= formStatement )+
                    int cnt4=0;
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==String||LA4_0==30) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:50:14: body= formStatement
                    	    {
                    	    pushFollow(FOLLOW_formStatement_in_conditionBody285);
                    	    body=formStatement();

                    	    state._fsp--;
                    	    if (state.failed) return result;

                    	    if ( state.backtracking==0 ) { statements.add(body); }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt4 >= 1 ) break loop4;
                    	    if (state.backtracking>0) {state.failed=true; return result;}
                                EarlyExitException eee =
                                    new EarlyExitException(4, input);
                                throw eee;
                        }
                        cnt4++;
                    } while (true);


                    match(input,36,FOLLOW_36_in_conditionBody291); if (state.failed) return result;

                    }
                    break;
                case 2 :
                    // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:51:9: (body= formStatement )+
                    {
                    // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:51:9: (body= formStatement )+
                    int cnt5=0;
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==String) ) {
                            int LA5_2 = input.LA(2);

                            if ( (synpred6_QL()) ) {
                                alt5=1;
                            }


                        }
                        else if ( (LA5_0==30) ) {
                            int LA5_3 = input.LA(2);

                            if ( (synpred6_QL()) ) {
                                alt5=1;
                            }


                        }


                        switch (alt5) {
                    	case 1 :
                    	    // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:51:10: body= formStatement
                    	    {
                    	    pushFollow(FOLLOW_formStatement_in_conditionBody304);
                    	    body=formStatement();

                    	    state._fsp--;
                    	    if (state.failed) return result;

                    	    if ( state.backtracking==0 ) { statements.add(body); }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt5 >= 1 ) break loop5;
                    	    if (state.backtracking>0) {state.failed=true; return result;}
                                EarlyExitException eee =
                                    new EarlyExitException(5, input);
                                throw eee;
                        }
                        cnt5++;
                    } while (true);


                    }
                    break;

            }
            if ( state.backtracking==0 ) { result = statements; }
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
    // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:54:1: primary returns [Expr result] : ( Int | Bool | Money | String | Ident | '(' x= orExpr ')' );
    public final Expr primary() throws RecognitionException {
        Expr result = null;

        int primary_StartIndex = input.index();

        Token Int8=null;
        Token Bool9=null;
        Token Money10=null;
        Token String11=null;
        Token Ident12=null;
        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

            // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:55:5: ( Int | Bool | Money | String | Ident | '(' x= orExpr ')' )
            int alt7=6;
            switch ( input.LA(1) ) {
            case Int:
                {
                alt7=1;
                }
                break;
            case Bool:
                {
                alt7=2;
                }
                break;
            case Money:
                {
                alt7=3;
                }
                break;
            case String:
                {
                alt7=4;
                }
                break;
            case Ident:
                {
                alt7=5;
                }
                break;
            case 14:
                {
                alt7=6;
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
                    // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:55:9: Int
                    {
                    Int8=(Token)match(input,Int,FOLLOW_Int_in_primary331); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.expressions.literal.Int(Integer.parseInt((Int8!=null?Int8.getText():null))); }

                    }
                    break;
                case 2 :
                    // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:56:9: Bool
                    {
                    Bool9=(Token)match(input,Bool,FOLLOW_Bool_in_primary346); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.expressions.literal.Bool(Boolean.parseBoolean((Bool9!=null?Bool9.getText():null))); }

                    }
                    break;
                case 3 :
                    // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:57:9: Money
                    {
                    Money10=(Token)match(input,Money,FOLLOW_Money_in_primary360); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.expressions.literal.Money(Double.parseDouble((Money10!=null?Money10.getText():null).replace(',', '.'))); }

                    }
                    break;
                case 4 :
                    // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:58:9: String
                    {
                    String11=(Token)match(input,String,FOLLOW_String_in_primary373); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.expressions.literal.Str((String11!=null?String11.getText():null)); }

                    }
                    break;
                case 5 :
                    // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:59:9: Ident
                    {
                    Ident12=(Token)match(input,Ident,FOLLOW_Ident_in_primary385); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Ident((Ident12!=null?Ident12.getText():null)); }

                    }
                    break;
                case 6 :
                    // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:60:9: '(' x= orExpr ')'
                    {
                    match(input,14,FOLLOW_14_in_primary398); if (state.failed) return result;

                    pushFollow(FOLLOW_orExpr_in_primary402);
                    x=orExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,15,FOLLOW_15_in_primary404); if (state.failed) return result;

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
    // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:63:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
    public final Expr unExpr() throws RecognitionException {
        Expr result = null;

        int unExpr_StartIndex = input.index();

        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

            // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:64:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
            int alt8=4;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt8=1;
                }
                break;
            case 18:
                {
                alt8=2;
                }
                break;
            case 11:
                {
                alt8=3;
                }
                break;
            case Bool:
            case Ident:
            case Int:
            case Money:
            case String:
            case 14:
                {
                alt8=4;
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
                    // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:64:9: '+' x= unExpr
                    {
                    match(input,17,FOLLOW_17_in_unExpr432); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr436);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Pos(x); }

                    }
                    break;
                case 2 :
                    // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:65:9: '-' x= unExpr
                    {
                    match(input,18,FOLLOW_18_in_unExpr448); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr452);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Neg(x); }

                    }
                    break;
                case 3 :
                    // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:66:9: '!' x= unExpr
                    {
                    match(input,11,FOLLOW_11_in_unExpr464); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr468);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Not(x); }

                    }
                    break;
                case 4 :
                    // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:67:9: x= primary
                    {
                    pushFollow(FOLLOW_primary_in_unExpr482);
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
    // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:70:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
    public final Expr mulExpr() throws RecognitionException {
        Expr result = null;

        int mulExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

            // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:71:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
            // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:71:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
            {
            pushFollow(FOLLOW_unExpr_in_mulExpr520);
            lhs=unExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:71:45: (op= ( '*' | '/' ) rhs= unExpr )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==16||LA9_0==19) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:71:47: op= ( '*' | '/' ) rhs= unExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( input.LA(1)==16||input.LA(1)==19 ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_unExpr_in_mulExpr540);
            	    rhs=unExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { 
            	            if ((op!=null?op.getText():null).equals("*")) { result = new Mul(result, rhs); }
            	            if ((op!=null?op.getText():null).equals("/")) { result = new Div(result, rhs); }
            	        }

            	    }
            	    break;

            	default :
            	    break loop9;
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
    // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:78:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
    public final Expr addExpr() throws RecognitionException {
        Expr result = null;

        int addExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

            // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:79:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
            // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:79:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
            {
            pushFollow(FOLLOW_mulExpr_in_addExpr578);
            lhs=mulExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:79:46: (op= ( '+' | '-' ) rhs= mulExpr )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0 >= 17 && LA10_0 <= 18)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:79:48: op= ( '+' | '-' ) rhs= mulExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( (input.LA(1) >= 17 && input.LA(1) <= 18) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_mulExpr_in_addExpr596);
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
            if ( state.backtracking>0 ) { memoize(input, 9, addExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "addExpr"



    // $ANTLR start "relExpr"
    // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:86:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
    public final Expr relExpr() throws RecognitionException {
        Expr result = null;

        int relExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

            // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:87:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
            // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:87:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            {
            pushFollow(FOLLOW_addExpr_in_relExpr631);
            lhs=addExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:87:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==12||(LA11_0 >= 21 && LA11_0 <= 22)||(LA11_0 >= 24 && LA11_0 <= 26)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:87:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( input.LA(1)==12||(input.LA(1) >= 21 && input.LA(1) <= 22)||(input.LA(1) >= 24 && input.LA(1) <= 26) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_addExpr_in_relExpr655);
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
            if ( state.backtracking>0 ) { memoize(input, 10, relExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "relExpr"



    // $ANTLR start "andExpr"
    // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:98:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
    public final Expr andExpr() throws RecognitionException {
        Expr result = null;

        int andExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

            // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:99:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
            // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:99:9: lhs= relExpr ( '&&' rhs= relExpr )*
            {
            pushFollow(FOLLOW_relExpr_in_andExpr693);
            lhs=relExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:99:46: ( '&&' rhs= relExpr )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==13) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:99:48: '&&' rhs= relExpr
            	    {
            	    match(input,13,FOLLOW_13_in_andExpr699); if (state.failed) return result;

            	    pushFollow(FOLLOW_relExpr_in_andExpr703);
            	    rhs=relExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { result = new And(result, rhs); }

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
            if ( state.backtracking>0 ) { memoize(input, 11, andExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "andExpr"



    // $ANTLR start "orExpr"
    // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:103:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
    public final Expr orExpr() throws RecognitionException {
        Expr result = null;

        int orExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }

            // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:104:5: (lhs= andExpr ( '||' rhs= andExpr )* )
            // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:104:9: lhs= andExpr ( '||' rhs= andExpr )*
            {
            pushFollow(FOLLOW_andExpr_in_orExpr738);
            lhs=andExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = lhs; }

            // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:104:48: ( '||' rhs= andExpr )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==35) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:104:50: '||' rhs= andExpr
            	    {
            	    match(input,35,FOLLOW_35_in_orExpr744); if (state.failed) return result;

            	    pushFollow(FOLLOW_andExpr_in_orExpr748);
            	    rhs=andExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { result = new Or(result, rhs); }

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
            if ( state.backtracking>0 ) { memoize(input, 12, orExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "orExpr"



    // $ANTLR start "type"
    // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:107:1: type returns [Type result] : ( 'integer' | 'string' | 'boolean' | 'money' );
    public final Type type() throws RecognitionException {
        Type result = null;

        int type_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return result; }

            // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:108:5: ( 'integer' | 'string' | 'boolean' | 'money' )
            int alt14=4;
            switch ( input.LA(1) ) {
            case 31:
                {
                alt14=1;
                }
                break;
            case 33:
                {
                alt14=2;
                }
                break;
            case 27:
                {
                alt14=3;
                }
                break;
            case 32:
                {
                alt14=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;

            }

            switch (alt14) {
                case 1 :
                    // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:108:9: 'integer'
                    {
                    match(input,31,FOLLOW_31_in_type776); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.types.Int();   }

                    }
                    break;
                case 2 :
                    // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:109:9: 'string'
                    {
                    match(input,33,FOLLOW_33_in_type788); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.types.Str();   }

                    }
                    break;
                case 3 :
                    // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:110:9: 'boolean'
                    {
                    match(input,27,FOLLOW_27_in_type801); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.types.Bool();  }

                    }
                    break;
                case 4 :
                    // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:111:9: 'money'
                    {
                    match(input,32,FOLLOW_32_in_type813); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.types.Money(); }

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

    // $ANTLR start synpred3_QL
    public final void synpred3_QL_fragment() throws RecognitionException {
        Expr condition =null;

        ArrayList<FormStatement> ifBody =null;

        ArrayList<FormStatement> elseBody =null;


        // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:41:9: ( 'if' '(' condition= orExpr ')' ifBody= conditionBody 'else' elseBody= conditionBody )
        // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:41:9: 'if' '(' condition= orExpr ')' ifBody= conditionBody 'else' elseBody= conditionBody
        {
        match(input,30,FOLLOW_30_in_synpred3_QL181); if (state.failed) return ;

        match(input,14,FOLLOW_14_in_synpred3_QL183); if (state.failed) return ;

        pushFollow(FOLLOW_orExpr_in_synpred3_QL187);
        condition=orExpr();

        state._fsp--;
        if (state.failed) return ;

        match(input,15,FOLLOW_15_in_synpred3_QL189); if (state.failed) return ;

        pushFollow(FOLLOW_conditionBody_in_synpred3_QL193);
        ifBody=conditionBody();

        state._fsp--;
        if (state.failed) return ;

        match(input,28,FOLLOW_28_in_synpred3_QL195); if (state.failed) return ;

        pushFollow(FOLLOW_conditionBody_in_synpred3_QL199);
        elseBody=conditionBody();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred3_QL

    // $ANTLR start synpred6_QL
    public final void synpred6_QL_fragment() throws RecognitionException {
        FormStatement body =null;


        // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:51:10: (body= formStatement )
        // C:\\Documents and Settings\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:51:10: body= formStatement
        {
        pushFollow(FOLLOW_formStatement_in_synpred6_QL304);
        body=formStatement();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred6_QL

    // Delegated rules

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


 

    public static final BitSet FOLLOW_29_in_form50 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_Ident_in_form52 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_form54 = new BitSet(new long[]{0x0000000440000200L});
    public static final BitSet FOLLOW_conditionBody_in_form58 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_form60 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_question_in_formStatement85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditionBlock_in_formStatement103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_String_in_question128 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_Ident_in_question130 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_question132 = new BitSet(new long[]{0x0000000388000000L});
    public static final BitSet FOLLOW_type_in_question136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_String_in_question148 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_Ident_in_question150 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_question152 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_orExpr_in_question156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_conditionBlock181 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_conditionBlock183 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_orExpr_in_conditionBlock187 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_conditionBlock189 = new BitSet(new long[]{0x0000000440000200L});
    public static final BitSet FOLLOW_conditionBody_in_conditionBlock193 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_conditionBlock195 = new BitSet(new long[]{0x0000000440000200L});
    public static final BitSet FOLLOW_conditionBody_in_conditionBlock199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_conditionBlock219 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_conditionBlock221 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_orExpr_in_conditionBlock225 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_conditionBlock227 = new BitSet(new long[]{0x0000000440000200L});
    public static final BitSet FOLLOW_conditionBody_in_conditionBlock231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_conditionBody280 = new BitSet(new long[]{0x0000000040000200L});
    public static final BitSet FOLLOW_formStatement_in_conditionBody285 = new BitSet(new long[]{0x0000001040000200L});
    public static final BitSet FOLLOW_36_in_conditionBody291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_formStatement_in_conditionBody304 = new BitSet(new long[]{0x0000000040000202L});
    public static final BitSet FOLLOW_Int_in_primary331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Bool_in_primary346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Money_in_primary360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_String_in_primary373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_primary385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_primary398 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_orExpr_in_primary402 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_primary404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_unExpr432 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_unExpr448 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_unExpr464 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_unExpr482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr520 = new BitSet(new long[]{0x0000000000090002L});
    public static final BitSet FOLLOW_set_in_mulExpr528 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr540 = new BitSet(new long[]{0x0000000000090002L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr578 = new BitSet(new long[]{0x0000000000060002L});
    public static final BitSet FOLLOW_set_in_addExpr586 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr596 = new BitSet(new long[]{0x0000000000060002L});
    public static final BitSet FOLLOW_addExpr_in_relExpr631 = new BitSet(new long[]{0x0000000007601002L});
    public static final BitSet FOLLOW_set_in_relExpr639 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_addExpr_in_relExpr655 = new BitSet(new long[]{0x0000000007601002L});
    public static final BitSet FOLLOW_relExpr_in_andExpr693 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_andExpr699 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_relExpr_in_andExpr703 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_andExpr_in_orExpr738 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_orExpr744 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_andExpr_in_orExpr748 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_31_in_type776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_type788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_type801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_type813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_synpred3_QL181 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_synpred3_QL183 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_orExpr_in_synpred3_QL187 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_synpred3_QL189 = new BitSet(new long[]{0x0000000440000200L});
    public static final BitSet FOLLOW_conditionBody_in_synpred3_QL193 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_synpred3_QL195 = new BitSet(new long[]{0x0000000440000200L});
    public static final BitSet FOLLOW_conditionBody_in_synpred3_QL199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_formStatement_in_synpred6_QL304 = new BitSet(new long[]{0x0000000000000002L});

}