// $ANTLR 3.4 /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g 2013-02-05 16:26:25

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.expressions.*;
import org.uva.sea.ql.ast.expressions.unary.*;
import org.uva.sea.ql.ast.expressions.binary.*;
import org.uva.sea.ql.ast.types.*;
import org.uva.sea.ql.form.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class QLParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Bool", "COMMENT", "Ident", "Int", "String", "WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", "'/'", "':'", "'<'", "'<='", "'=='", "'>'", "'>='", "'boolean'", "'else'", "'form'", "'if'", "'int'", "'string'", "'{'", "'||'", "'}'"
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
        this.state.ruleMemo = new HashMap[39+1];
         

    }

    public String[] getTokenNames() { return QLParser.tokenNames; }
    public String getGrammarFileName() { return "/Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g"; }


      @Override
      public void reportError(RecognitionException e) {
      throw new RuntimeException(e);
      }



    // $ANTLR start "form"
    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:35:1: form returns [Form result] : 'form' Ident '{' formItems '}' ;
    public final Form form() throws RecognitionException {
        Form result = null;

        int form_StartIndex = input.index();

        Token Ident1=null;
        List<FormItem> formItems2 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:36:3: ( 'form' Ident '{' formItems '}' )
            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:36:5: 'form' Ident '{' formItems '}'
            {
            match(input,27,FOLLOW_27_in_form64); if (state.failed) return result;

            Ident1=(Token)match(input,Ident,FOLLOW_Ident_in_form66); if (state.failed) return result;

            match(input,31,FOLLOW_31_in_form68); if (state.failed) return result;

            pushFollow(FOLLOW_formItems_in_form74);
            formItems2=formItems();

            state._fsp--;
            if (state.failed) return result;

            match(input,33,FOLLOW_33_in_form80); if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new Form(new Ident((Ident1!=null?Ident1.getText():null)), formItems2); }

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



    // $ANTLR start "formItems"
    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:41:1: formItems returns [List<FormItem> result] : (ie= ifElseStatement |i= ifStatement |cq= computedQuestion |q= question )+ ;
    public final List<FormItem> formItems() throws RecognitionException {
        List<FormItem> result = null;

        int formItems_StartIndex = input.index();

        IfElseStatement ie =null;

        IfStatement i =null;

        ComputedQuestion cq =null;

        Question q =null;


         List<FormItem> formItems = new ArrayList(); 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:43:3: ( (ie= ifElseStatement |i= ifStatement |cq= computedQuestion |q= question )+ )
            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:43:5: (ie= ifElseStatement |i= ifStatement |cq= computedQuestion |q= question )+
            {
            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:43:5: (ie= ifElseStatement |i= ifStatement |cq= computedQuestion |q= question )+
            int cnt1=0;
            loop1:
            do {
                int alt1=5;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==28) ) {
                    int LA1_2 = input.LA(2);

                    if ( (synpred1_QL()) ) {
                        alt1=1;
                    }
                    else if ( (synpred2_QL()) ) {
                        alt1=2;
                    }


                }
                else if ( (LA1_0==Ident) ) {
                    int LA1_3 = input.LA(2);

                    if ( (synpred3_QL()) ) {
                        alt1=3;
                    }
                    else if ( (synpred4_QL()) ) {
                        alt1=4;
                    }


                }


                switch (alt1) {
            	case 1 :
            	    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:43:7: ie= ifElseStatement
            	    {
            	    pushFollow(FOLLOW_ifElseStatement_in_formItems108);
            	    ie=ifElseStatement();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { formItems.add(ie); }

            	    }
            	    break;
            	case 2 :
            	    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:44:7: i= ifStatement
            	    {
            	    pushFollow(FOLLOW_ifStatement_in_formItems120);
            	    i=ifStatement();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { formItems.add(i); }

            	    }
            	    break;
            	case 3 :
            	    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:45:7: cq= computedQuestion
            	    {
            	    pushFollow(FOLLOW_computedQuestion_in_formItems133);
            	    cq=computedQuestion();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { formItems.add(cq); }

            	    }
            	    break;
            	case 4 :
            	    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:46:7: q= question
            	    {
            	    pushFollow(FOLLOW_question_in_formItems146);
            	    q=question();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { formItems.add(q); }

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
            	    if (state.backtracking>0) {state.failed=true; return result;}
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            if ( state.backtracking==0 ) { result = formItems; }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 2, formItems_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "formItems"



    // $ANTLR start "ifElseStatement"
    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:50:1: ifElseStatement returns [IfElseStatement result] : 'if' '(' orExpr ')' '{' ifBody= formItems '}' 'else' '{' elseBody= formItems '}' ;
    public final IfElseStatement ifElseStatement() throws RecognitionException {
        IfElseStatement result = null;

        int ifElseStatement_StartIndex = input.index();

        List<FormItem> ifBody =null;

        List<FormItem> elseBody =null;

        Expr orExpr3 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:51:3: ( 'if' '(' orExpr ')' '{' ifBody= formItems '}' 'else' '{' elseBody= formItems '}' )
            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:51:5: 'if' '(' orExpr ')' '{' ifBody= formItems '}' 'else' '{' elseBody= formItems '}'
            {
            match(input,28,FOLLOW_28_in_ifElseStatement177); if (state.failed) return result;

            match(input,13,FOLLOW_13_in_ifElseStatement179); if (state.failed) return result;

            pushFollow(FOLLOW_orExpr_in_ifElseStatement181);
            orExpr3=orExpr();

            state._fsp--;
            if (state.failed) return result;

            match(input,14,FOLLOW_14_in_ifElseStatement183); if (state.failed) return result;

            match(input,31,FOLLOW_31_in_ifElseStatement185); if (state.failed) return result;

            pushFollow(FOLLOW_formItems_in_ifElseStatement189);
            ifBody=formItems();

            state._fsp--;
            if (state.failed) return result;

            match(input,33,FOLLOW_33_in_ifElseStatement191); if (state.failed) return result;

            match(input,26,FOLLOW_26_in_ifElseStatement197); if (state.failed) return result;

            match(input,31,FOLLOW_31_in_ifElseStatement199); if (state.failed) return result;

            pushFollow(FOLLOW_formItems_in_ifElseStatement203);
            elseBody=formItems();

            state._fsp--;
            if (state.failed) return result;

            match(input,33,FOLLOW_33_in_ifElseStatement205); if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new IfElseStatement(orExpr3, ifBody, elseBody); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 3, ifElseStatement_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "ifElseStatement"



    // $ANTLR start "ifStatement"
    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:56:1: ifStatement returns [IfStatement result] : 'if' '(' orExpr ')' '{' ifBody= formItems '}' ;
    public final IfStatement ifStatement() throws RecognitionException {
        IfStatement result = null;

        int ifStatement_StartIndex = input.index();

        List<FormItem> ifBody =null;

        Expr orExpr4 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:57:3: ( 'if' '(' orExpr ')' '{' ifBody= formItems '}' )
            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:57:5: 'if' '(' orExpr ')' '{' ifBody= formItems '}'
            {
            match(input,28,FOLLOW_28_in_ifStatement231); if (state.failed) return result;

            match(input,13,FOLLOW_13_in_ifStatement233); if (state.failed) return result;

            pushFollow(FOLLOW_orExpr_in_ifStatement235);
            orExpr4=orExpr();

            state._fsp--;
            if (state.failed) return result;

            match(input,14,FOLLOW_14_in_ifStatement237); if (state.failed) return result;

            match(input,31,FOLLOW_31_in_ifStatement239); if (state.failed) return result;

            pushFollow(FOLLOW_formItems_in_ifStatement243);
            ifBody=formItems();

            state._fsp--;
            if (state.failed) return result;

            match(input,33,FOLLOW_33_in_ifStatement245); if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new IfStatement(orExpr4, ifBody); }

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



    // $ANTLR start "computedQuestion"
    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:61:1: computedQuestion returns [ComputedQuestion result] : Ident ':' String questionType '(' orExpr ')' ;
    public final ComputedQuestion computedQuestion() throws RecognitionException {
        ComputedQuestion result = null;

        int computedQuestion_StartIndex = input.index();

        Token Ident5=null;
        Token String6=null;
        Type questionType7 =null;

        Expr orExpr8 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:62:3: ( Ident ':' String questionType '(' orExpr ')' )
            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:62:5: Ident ':' String questionType '(' orExpr ')'
            {
            Ident5=(Token)match(input,Ident,FOLLOW_Ident_in_computedQuestion270); if (state.failed) return result;

            match(input,19,FOLLOW_19_in_computedQuestion272); if (state.failed) return result;

            String6=(Token)match(input,String,FOLLOW_String_in_computedQuestion274); if (state.failed) return result;

            pushFollow(FOLLOW_questionType_in_computedQuestion276);
            questionType7=questionType();

            state._fsp--;
            if (state.failed) return result;

            match(input,13,FOLLOW_13_in_computedQuestion278); if (state.failed) return result;

            pushFollow(FOLLOW_orExpr_in_computedQuestion280);
            orExpr8=orExpr();

            state._fsp--;
            if (state.failed) return result;

            match(input,14,FOLLOW_14_in_computedQuestion282); if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new ComputedQuestion(new Ident((Ident5!=null?Ident5.getText():null)), (String6!=null?String6.getText():null), questionType7, orExpr8); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 5, computedQuestion_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "computedQuestion"



    // $ANTLR start "question"
    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:66:1: question returns [Question result] : Ident ':' String questionType ;
    public final Question question() throws RecognitionException {
        Question result = null;

        int question_StartIndex = input.index();

        Token Ident9=null;
        Token String10=null;
        Type questionType11 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:67:3: ( Ident ':' String questionType )
            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:67:5: Ident ':' String questionType
            {
            Ident9=(Token)match(input,Ident,FOLLOW_Ident_in_question308); if (state.failed) return result;

            match(input,19,FOLLOW_19_in_question310); if (state.failed) return result;

            String10=(Token)match(input,String,FOLLOW_String_in_question312); if (state.failed) return result;

            pushFollow(FOLLOW_questionType_in_question314);
            questionType11=questionType();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new Question(new Ident((Ident9!=null?Ident9.getText():null)), (String10!=null?String10.getText():null), questionType11); }

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



    // $ANTLR start "questionType"
    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:70:1: questionType returns [Type result] : ( 'boolean' | 'int' | 'string' );
    public final Type questionType() throws RecognitionException {
        Type result = null;

        int questionType_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:71:3: ( 'boolean' | 'int' | 'string' )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 25:
                {
                alt2=1;
                }
                break;
            case 29:
                {
                alt2=2;
                }
                break;
            case 30:
                {
                alt2=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }

            switch (alt2) {
                case 1 :
                    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:71:5: 'boolean'
                    {
                    match(input,25,FOLLOW_25_in_questionType333); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new BoolType(); }

                    }
                    break;
                case 2 :
                    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:72:5: 'int'
                    {
                    match(input,29,FOLLOW_29_in_questionType341); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new IntType(); }

                    }
                    break;
                case 3 :
                    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:73:5: 'string'
                    {
                    match(input,30,FOLLOW_30_in_questionType349); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new StringType(); }

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
            if ( state.backtracking>0 ) { memoize(input, 7, questionType_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "questionType"



    // $ANTLR start "primary"
    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:76:1: primary returns [Expr result] : ( Int | Bool | String | Ident | '(' x= orExpr ')' );
    public final Expr primary() throws RecognitionException {
        Expr result = null;

        int primary_StartIndex = input.index();

        Token Int12=null;
        Token Bool13=null;
        Token String14=null;
        Token Ident15=null;
        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:77:3: ( Int | Bool | String | Ident | '(' x= orExpr ')' )
            int alt3=5;
            switch ( input.LA(1) ) {
            case Int:
                {
                alt3=1;
                }
                break;
            case Bool:
                {
                alt3=2;
                }
                break;
            case String:
                {
                alt3=3;
                }
                break;
            case Ident:
                {
                alt3=4;
                }
                break;
            case 13:
                {
                alt3=5;
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
                    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:77:5: Int
                    {
                    Int12=(Token)match(input,Int,FOLLOW_Int_in_primary368); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Int(Integer.parseInt((Int12!=null?Int12.getText():null))); }

                    }
                    break;
                case 2 :
                    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:78:5: Bool
                    {
                    Bool13=(Token)match(input,Bool,FOLLOW_Bool_in_primary378); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Bool(Boolean.parseBoolean((Bool13!=null?Bool13.getText():null))); }

                    }
                    break;
                case 3 :
                    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:79:5: String
                    {
                    String14=(Token)match(input,String,FOLLOW_String_in_primary386); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Str((String14!=null?String14.getText():null)); }

                    }
                    break;
                case 4 :
                    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:80:5: Ident
                    {
                    Ident15=(Token)match(input,Ident,FOLLOW_Ident_in_primary394); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Ident((Ident15!=null?Ident15.getText():null)); }

                    }
                    break;
                case 5 :
                    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:81:5: '(' x= orExpr ')'
                    {
                    match(input,13,FOLLOW_13_in_primary402); if (state.failed) return result;

                    pushFollow(FOLLOW_orExpr_in_primary406);
                    x=orExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,14,FOLLOW_14_in_primary408); if (state.failed) return result;

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
    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:84:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
    public final Expr unExpr() throws RecognitionException {
        Expr result = null;

        int unExpr_StartIndex = input.index();

        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:85:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
            int alt4=4;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt4=1;
                }
                break;
            case 17:
                {
                alt4=2;
                }
                break;
            case 10:
                {
                alt4=3;
                }
                break;
            case Bool:
            case Ident:
            case Int:
            case String:
            case 13:
                {
                alt4=4;
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
                    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:85:8: '+' x= unExpr
                    {
                    match(input,16,FOLLOW_16_in_unExpr433); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr437);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Pos(x); }

                    }
                    break;
                case 2 :
                    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:86:8: '-' x= unExpr
                    {
                    match(input,17,FOLLOW_17_in_unExpr448); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr452);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Neg(x); }

                    }
                    break;
                case 3 :
                    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:87:8: '!' x= unExpr
                    {
                    match(input,10,FOLLOW_10_in_unExpr463); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr467);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Not(x); }

                    }
                    break;
                case 4 :
                    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:88:8: x= primary
                    {
                    pushFollow(FOLLOW_primary_in_unExpr480);
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
    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:91:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
    public final Expr mulExpr() throws RecognitionException {
        Expr result = null;

        int mulExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:92:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:92:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
            {
            pushFollow(FOLLOW_unExpr_in_mulExpr518);
            lhs=unExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:92:45: (op= ( '*' | '/' ) rhs= unExpr )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==15||LA5_0==18) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:92:47: op= ( '*' | '/' ) rhs= unExpr
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


            	    pushFollow(FOLLOW_unExpr_in_mulExpr538);
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
            	    break loop5;
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
            if ( state.backtracking>0 ) { memoize(input, 10, mulExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "mulExpr"



    // $ANTLR start "addExpr"
    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:104:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
    public final Expr addExpr() throws RecognitionException {
        Expr result = null;

        int addExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:105:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:105:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
            {
            pushFollow(FOLLOW_mulExpr_in_addExpr579);
            lhs=mulExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:105:46: (op= ( '+' | '-' ) rhs= mulExpr )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0 >= 16 && LA6_0 <= 17)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:105:48: op= ( '+' | '-' ) rhs= mulExpr
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


            	    pushFollow(FOLLOW_mulExpr_in_addExpr597);
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
            	    break loop6;
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
            if ( state.backtracking>0 ) { memoize(input, 11, addExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "addExpr"



    // $ANTLR start "relExpr"
    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:116:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
    public final Expr relExpr() throws RecognitionException {
        Expr result = null;

        int relExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }

            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:117:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:117:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            {
            pushFollow(FOLLOW_addExpr_in_relExpr632);
            lhs=addExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:117:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==11||(LA7_0 >= 20 && LA7_0 <= 24)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:117:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( input.LA(1)==11||(input.LA(1) >= 20 && input.LA(1) <= 24) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_addExpr_in_relExpr656);
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
            	    break loop7;
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
            if ( state.backtracking>0 ) { memoize(input, 12, relExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "relExpr"



    // $ANTLR start "andExpr"
    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:140:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
    public final Expr andExpr() throws RecognitionException {
        Expr result = null;

        int andExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return result; }

            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:141:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:141:9: lhs= relExpr ( '&&' rhs= relExpr )*
            {
            pushFollow(FOLLOW_relExpr_in_andExpr694);
            lhs=relExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:141:46: ( '&&' rhs= relExpr )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==12) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:141:48: '&&' rhs= relExpr
            	    {
            	    match(input,12,FOLLOW_12_in_andExpr700); if (state.failed) return result;

            	    pushFollow(FOLLOW_relExpr_in_andExpr704);
            	    rhs=relExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { result = new And(result, rhs); }

            	    }
            	    break;

            	default :
            	    break loop8;
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
            if ( state.backtracking>0 ) { memoize(input, 13, andExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "andExpr"



    // $ANTLR start "orExpr"
    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:145:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
    public final Expr orExpr() throws RecognitionException {
        Expr result = null;

        int orExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return result; }

            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:146:5: (lhs= andExpr ( '||' rhs= andExpr )* )
            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:146:9: lhs= andExpr ( '||' rhs= andExpr )*
            {
            pushFollow(FOLLOW_andExpr_in_orExpr739);
            lhs=andExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = lhs; }

            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:146:48: ( '||' rhs= andExpr )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==32) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:146:50: '||' rhs= andExpr
            	    {
            	    match(input,32,FOLLOW_32_in_orExpr745); if (state.failed) return result;

            	    pushFollow(FOLLOW_andExpr_in_orExpr749);
            	    rhs=andExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { result = new Or(result, rhs); }

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
            if ( state.backtracking>0 ) { memoize(input, 14, orExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "orExpr"

    // $ANTLR start synpred1_QL
    public final void synpred1_QL_fragment() throws RecognitionException {
        IfElseStatement ie =null;


        // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:43:7: (ie= ifElseStatement )
        // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:43:7: ie= ifElseStatement
        {
        pushFollow(FOLLOW_ifElseStatement_in_synpred1_QL108);
        ie=ifElseStatement();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred1_QL

    // $ANTLR start synpred2_QL
    public final void synpred2_QL_fragment() throws RecognitionException {
        IfStatement i =null;


        // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:44:7: (i= ifStatement )
        // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:44:7: i= ifStatement
        {
        pushFollow(FOLLOW_ifStatement_in_synpred2_QL120);
        i=ifStatement();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred2_QL

    // $ANTLR start synpred3_QL
    public final void synpred3_QL_fragment() throws RecognitionException {
        ComputedQuestion cq =null;


        // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:45:7: (cq= computedQuestion )
        // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:45:7: cq= computedQuestion
        {
        pushFollow(FOLLOW_computedQuestion_in_synpred3_QL133);
        cq=computedQuestion();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred3_QL

    // $ANTLR start synpred4_QL
    public final void synpred4_QL_fragment() throws RecognitionException {
        Question q =null;


        // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:46:7: (q= question )
        // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/QL.g:46:7: q= question
        {
        pushFollow(FOLLOW_question_in_synpred4_QL146);
        q=question();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred4_QL

    // Delegated rules

    public final boolean synpred2_QL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_QL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_QL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_QL_fragment(); // can never throw exception
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


 

    public static final BitSet FOLLOW_27_in_form64 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_Ident_in_form66 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_form68 = new BitSet(new long[]{0x0000000010000040L});
    public static final BitSet FOLLOW_formItems_in_form74 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_form80 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifElseStatement_in_formItems108 = new BitSet(new long[]{0x0000000010000042L});
    public static final BitSet FOLLOW_ifStatement_in_formItems120 = new BitSet(new long[]{0x0000000010000042L});
    public static final BitSet FOLLOW_computedQuestion_in_formItems133 = new BitSet(new long[]{0x0000000010000042L});
    public static final BitSet FOLLOW_question_in_formItems146 = new BitSet(new long[]{0x0000000010000042L});
    public static final BitSet FOLLOW_28_in_ifElseStatement177 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ifElseStatement179 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_orExpr_in_ifElseStatement181 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ifElseStatement183 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ifElseStatement185 = new BitSet(new long[]{0x0000000010000040L});
    public static final BitSet FOLLOW_formItems_in_ifElseStatement189 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ifElseStatement191 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ifElseStatement197 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ifElseStatement199 = new BitSet(new long[]{0x0000000010000040L});
    public static final BitSet FOLLOW_formItems_in_ifElseStatement203 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ifElseStatement205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ifStatement231 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ifStatement233 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_orExpr_in_ifStatement235 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ifStatement237 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ifStatement239 = new BitSet(new long[]{0x0000000010000040L});
    public static final BitSet FOLLOW_formItems_in_ifStatement243 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ifStatement245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_computedQuestion270 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_computedQuestion272 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_String_in_computedQuestion274 = new BitSet(new long[]{0x0000000062000000L});
    public static final BitSet FOLLOW_questionType_in_computedQuestion276 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_computedQuestion278 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_orExpr_in_computedQuestion280 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_computedQuestion282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_question308 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_question310 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_String_in_question312 = new BitSet(new long[]{0x0000000062000000L});
    public static final BitSet FOLLOW_questionType_in_question314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_questionType333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_questionType341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_questionType349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Int_in_primary368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Bool_in_primary378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_String_in_primary386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_primary394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_primary402 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_orExpr_in_primary406 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_primary408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_unExpr433 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_unExpr448 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_unExpr463 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_unExpr480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr518 = new BitSet(new long[]{0x0000000000048002L});
    public static final BitSet FOLLOW_set_in_mulExpr526 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr538 = new BitSet(new long[]{0x0000000000048002L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr579 = new BitSet(new long[]{0x0000000000030002L});
    public static final BitSet FOLLOW_set_in_addExpr587 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr597 = new BitSet(new long[]{0x0000000000030002L});
    public static final BitSet FOLLOW_addExpr_in_relExpr632 = new BitSet(new long[]{0x0000000001F00802L});
    public static final BitSet FOLLOW_set_in_relExpr640 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_addExpr_in_relExpr656 = new BitSet(new long[]{0x0000000001F00802L});
    public static final BitSet FOLLOW_relExpr_in_andExpr694 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_12_in_andExpr700 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_relExpr_in_andExpr704 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_andExpr_in_orExpr739 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_orExpr745 = new BitSet(new long[]{0x00000000000325D0L});
    public static final BitSet FOLLOW_andExpr_in_orExpr749 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_ifElseStatement_in_synpred1_QL108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStatement_in_synpred2_QL120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_computedQuestion_in_synpred3_QL133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_question_in_synpred4_QL146 = new BitSet(new long[]{0x0000000000000002L});

}