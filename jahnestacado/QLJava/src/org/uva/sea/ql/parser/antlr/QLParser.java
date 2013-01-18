// $ANTLR 3.4 /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g 2013-01-18 19:09:36

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.form.*;
import org.uva.sea.ql.ast.types.*;
import org.uva.sea.ql.ast.values.*;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class QLParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "BoolLit", "COMMENT", "Ident", "Int", "LB", "StringLit", "Type", "WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", "'/'", "':'", "'<'", "'<='", "'=='", "'>'", "'>='", "'form'", "'if'", "'{'", "'||'", "'}'"
    };

    public static final int EOF=-1;
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
    public static final int BoolLit=4;
    public static final int COMMENT=5;
    public static final int Ident=6;
    public static final int Int=7;
    public static final int LB=8;
    public static final int StringLit=9;
    public static final int Type=10;
    public static final int WS=11;

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
        this.state.ruleMemo = new HashMap[35+1];
         

    }

    public String[] getTokenNames() { return QLParser.tokenNames; }
    public String getGrammarFileName() { return "/home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g"; }



    // $ANTLR start "type"
    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:22:1: type returns [Type result] : ( Type ) ;
    public final Type type() throws RecognitionException {
        Type result = null;

        int type_StartIndex = input.index();

        Token Type1=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:23:2: ( ( Type ) )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:23:4: ( Type )
            {
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:23:4: ( Type )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:23:5: Type
            {
            Type1=(Token)match(input,Type,FOLLOW_Type_in_type48); if (state.failed) return result;

            if ( state.backtracking==0 ) {
            	 if ((Type1!=null?Type1.getText():null).equals("int"))result = new IntType((Type1!=null?Type1.getText():null)); 
            	 else if ((Type1!=null?Type1.getText():null).equals("boolean"))result = new BoolType((Type1!=null?Type1.getText():null)); 
            	  else if ((Type1!=null?Type1.getText():null).equals("string"))result = new StringType((Type1!=null?Type1.getText():null));
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
            if ( state.backtracking>0 ) { memoize(input, 1, type_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "type"



    // $ANTLR start "form"
    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:32:1: form returns [Form result] : 'form' Ident '{' bodyElements '}' ;
    public final Form form() throws RecognitionException {
        Form result = null;

        int form_StartIndex = input.index();

        Token Ident2=null;
        List<BodyElements> bodyElements3 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:33:2: ( 'form' Ident '{' bodyElements '}' )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:33:4: 'form' Ident '{' bodyElements '}'
            {
            match(input,27,FOLLOW_27_in_form71); if (state.failed) return result;

            Ident2=(Token)match(input,Ident,FOLLOW_Ident_in_form73); if (state.failed) return result;

            match(input,29,FOLLOW_29_in_form76); if (state.failed) return result;

            pushFollow(FOLLOW_bodyElements_in_form78);
            bodyElements3=bodyElements();

            state._fsp--;
            if (state.failed) return result;

            match(input,31,FOLLOW_31_in_form80); if (state.failed) return result;

            if ( state.backtracking==0 ) {result = new Form(new Ident((Ident2!=null?Ident2.getText():null)),bodyElements3);}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 2, form_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "form"



    // $ANTLR start "bodyElements"
    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:38:1: bodyElements returns [List<BodyElements> result] : ( question | computedQuestion | ifBlock )+ ;
    public final List<BodyElements> bodyElements() throws RecognitionException {
        List<BodyElements> result = null;

        int bodyElements_StartIndex = input.index();

        Question question4 =null;

        ComputedQuestion computedQuestion5 =null;

        IfBlock ifBlock6 =null;


         List<BodyElements> bodyElements = new ArrayList(); 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:40:2: ( ( question | computedQuestion | ifBlock )+ )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:40:3: ( question | computedQuestion | ifBlock )+
            {
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:40:3: ( question | computedQuestion | ifBlock )+
            int cnt1=0;
            loop1:
            do {
                int alt1=4;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==Ident) ) {
                    int LA1_2 = input.LA(2);

                    if ( (LA1_2==21) ) {
                        int LA1_4 = input.LA(3);

                        if ( (LA1_4==StringLit) ) {
                            int LA1_5 = input.LA(4);

                            if ( (LA1_5==Type) ) {
                                int LA1_6 = input.LA(5);

                                if ( (LA1_6==Ident||LA1_6==28||LA1_6==31) ) {
                                    alt1=1;
                                }
                                else if ( (LA1_6==15) ) {
                                    alt1=2;
                                }


                            }


                        }


                    }


                }
                else if ( (LA1_0==28) ) {
                    alt1=3;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:40:5: question
            	    {
            	    pushFollow(FOLLOW_question_in_bodyElements109);
            	    question4=question();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) {bodyElements.add(question4);}

            	    }
            	    break;
            	case 2 :
            	    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:41:3: computedQuestion
            	    {
            	    pushFollow(FOLLOW_computedQuestion_in_bodyElements115);
            	    computedQuestion5=computedQuestion();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) {bodyElements.add(computedQuestion5);}

            	    }
            	    break;
            	case 3 :
            	    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:42:3: ifBlock
            	    {
            	    pushFollow(FOLLOW_ifBlock_in_bodyElements121);
            	    ifBlock6=ifBlock();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) {bodyElements.add(ifBlock6);}

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


            if ( state.backtracking==0 ) {result =result;}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 3, bodyElements_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "bodyElements"



    // $ANTLR start "question"
    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:47:1: question returns [Question result] : Ident ':' StringLit type ;
    public final Question question() throws RecognitionException {
        Question result = null;

        int question_StartIndex = input.index();

        Token Ident7=null;
        Token StringLit8=null;
        Type type9 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:48:3: ( Ident ':' StringLit type )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:48:5: Ident ':' StringLit type
            {
            Ident7=(Token)match(input,Ident,FOLLOW_Ident_in_question148); if (state.failed) return result;

            match(input,21,FOLLOW_21_in_question150); if (state.failed) return result;

            StringLit8=(Token)match(input,StringLit,FOLLOW_StringLit_in_question152); if (state.failed) return result;

            pushFollow(FOLLOW_type_in_question154);
            type9=type();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) {result =new Question((Ident7!=null?Ident7.getText():null),(StringLit8!=null?StringLit8.getText():null),type9);}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 4, question_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "question"



    // $ANTLR start "computedQuestion"
    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:50:1: computedQuestion returns [ComputedQuestion result] : Ident ':' StringLit type '(' expr= orExpr ')' ;
    public final ComputedQuestion computedQuestion() throws RecognitionException {
        ComputedQuestion result = null;

        int computedQuestion_StartIndex = input.index();

        Token Ident10=null;
        Token StringLit11=null;
        Expr expr =null;

        Type type12 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:51:3: ( Ident ':' StringLit type '(' expr= orExpr ')' )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:51:5: Ident ':' StringLit type '(' expr= orExpr ')'
            {
            Ident10=(Token)match(input,Ident,FOLLOW_Ident_in_computedQuestion172); if (state.failed) return result;

            match(input,21,FOLLOW_21_in_computedQuestion174); if (state.failed) return result;

            StringLit11=(Token)match(input,StringLit,FOLLOW_StringLit_in_computedQuestion176); if (state.failed) return result;

            pushFollow(FOLLOW_type_in_computedQuestion178);
            type12=type();

            state._fsp--;
            if (state.failed) return result;

            match(input,15,FOLLOW_15_in_computedQuestion180); if (state.failed) return result;

            pushFollow(FOLLOW_orExpr_in_computedQuestion184);
            expr=orExpr();

            state._fsp--;
            if (state.failed) return result;

            match(input,16,FOLLOW_16_in_computedQuestion186); if (state.failed) return result;

            if ( state.backtracking==0 ) {result =new ComputedQuestion(new Ident((Ident10!=null?Ident10.getText():null)),(StringLit11!=null?StringLit11.getText():null),type12,expr);}

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



    // $ANTLR start "ifBlock"
    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:54:3: ifBlock returns [IfBlock result] : 'if' '(' expr= orExpr ')' '{' bodyElements '}' ;
    public final IfBlock ifBlock() throws RecognitionException {
        IfBlock result = null;

        int ifBlock_StartIndex = input.index();

        Expr expr =null;

        List<BodyElements> bodyElements13 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:55:3: ( 'if' '(' expr= orExpr ')' '{' bodyElements '}' )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:55:5: 'if' '(' expr= orExpr ')' '{' bodyElements '}'
            {
            match(input,28,FOLLOW_28_in_ifBlock209); if (state.failed) return result;

            match(input,15,FOLLOW_15_in_ifBlock211); if (state.failed) return result;

            pushFollow(FOLLOW_orExpr_in_ifBlock215);
            expr=orExpr();

            state._fsp--;
            if (state.failed) return result;

            match(input,16,FOLLOW_16_in_ifBlock217); if (state.failed) return result;

            match(input,29,FOLLOW_29_in_ifBlock219); if (state.failed) return result;

            pushFollow(FOLLOW_bodyElements_in_ifBlock221);
            bodyElements13=bodyElements();

            state._fsp--;
            if (state.failed) return result;

            match(input,31,FOLLOW_31_in_ifBlock222); if (state.failed) return result;

            if ( state.backtracking==0 ) {result =new IfBlock(expr,bodyElements13);}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 6, ifBlock_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "ifBlock"



    // $ANTLR start "primary"
    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:60:1: primary returns [Expr result] : ( Int | StringLit | BoolLit | Ident | '(' x= orExpr ')' );
    public final Expr primary() throws RecognitionException {
        Expr result = null;

        int primary_StartIndex = input.index();

        Token Int14=null;
        Token StringLit15=null;
        Token BoolLit16=null;
        Token Ident17=null;
        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:61:3: ( Int | StringLit | BoolLit | Ident | '(' x= orExpr ')' )
            int alt2=5;
            switch ( input.LA(1) ) {
            case Int:
                {
                alt2=1;
                }
                break;
            case StringLit:
                {
                alt2=2;
                }
                break;
            case BoolLit:
                {
                alt2=3;
                }
                break;
            case Ident:
                {
                alt2=4;
                }
                break;
            case 15:
                {
                alt2=5;
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
                    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:61:5: Int
                    {
                    Int14=(Token)match(input,Int,FOLLOW_Int_in_primary243); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Int(Integer.parseInt((Int14!=null?Int14.getText():null))); }

                    }
                    break;
                case 2 :
                    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:62:5: StringLit
                    {
                    StringLit15=(Token)match(input,StringLit,FOLLOW_StringLit_in_primary253); if (state.failed) return result;

                    if ( state.backtracking==0 ) {result = new StringLit((StringLit15!=null?StringLit15.getText():null));}

                    }
                    break;
                case 3 :
                    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:63:5: BoolLit
                    {
                    BoolLit16=(Token)match(input,BoolLit,FOLLOW_BoolLit_in_primary261); if (state.failed) return result;

                    if ( state.backtracking==0 ) {result = new BoolLit((BoolLit16!=null?BoolLit16.getText():null));}

                    }
                    break;
                case 4 :
                    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:64:5: Ident
                    {
                    Ident17=(Token)match(input,Ident,FOLLOW_Ident_in_primary270); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Ident((Ident17!=null?Ident17.getText():null)); }

                    }
                    break;
                case 5 :
                    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:65:5: '(' x= orExpr ')'
                    {
                    match(input,15,FOLLOW_15_in_primary278); if (state.failed) return result;

                    pushFollow(FOLLOW_orExpr_in_primary282);
                    x=orExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,16,FOLLOW_16_in_primary284); if (state.failed) return result;

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
            if ( state.backtracking>0 ) { memoize(input, 7, primary_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "primary"



    // $ANTLR start "unExpr"
    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:71:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
    public final Expr unExpr() throws RecognitionException {
        Expr result = null;

        int unExpr_StartIndex = input.index();

        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:72:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
            int alt3=4;
            switch ( input.LA(1) ) {
            case 18:
                {
                alt3=1;
                }
                break;
            case 19:
                {
                alt3=2;
                }
                break;
            case 12:
                {
                alt3=3;
                }
                break;
            case BoolLit:
            case Ident:
            case Int:
            case StringLit:
            case 15:
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
                    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:72:8: '+' x= unExpr
                    {
                    match(input,18,FOLLOW_18_in_unExpr312); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr316);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Pos(x); }

                    }
                    break;
                case 2 :
                    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:73:8: '-' x= unExpr
                    {
                    match(input,19,FOLLOW_19_in_unExpr327); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr331);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Neg(x); }

                    }
                    break;
                case 3 :
                    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:74:8: '!' x= unExpr
                    {
                    match(input,12,FOLLOW_12_in_unExpr342); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr346);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Not(x); }

                    }
                    break;
                case 4 :
                    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:75:8: x= primary
                    {
                    pushFollow(FOLLOW_primary_in_unExpr359);
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
            if ( state.backtracking>0 ) { memoize(input, 8, unExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "unExpr"



    // $ANTLR start "mulExpr"
    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:78:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
    public final Expr mulExpr() throws RecognitionException {
        Expr result = null;

        int mulExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:79:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:79:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
            {
            pushFollow(FOLLOW_unExpr_in_mulExpr397);
            lhs=unExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:79:45: (op= ( '*' | '/' ) rhs= unExpr )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==17||LA4_0==20) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:79:47: op= ( '*' | '/' ) rhs= unExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( input.LA(1)==17||input.LA(1)==20 ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_unExpr_in_mulExpr417);
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
            	    break loop4;
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
            if ( state.backtracking>0 ) { memoize(input, 9, mulExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "mulExpr"



    // $ANTLR start "addExpr"
    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:91:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
    public final Expr addExpr() throws RecognitionException {
        Expr result = null;

        int addExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:92:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:92:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
            {
            pushFollow(FOLLOW_mulExpr_in_addExpr458);
            lhs=mulExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:92:46: (op= ( '+' | '-' ) rhs= mulExpr )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0 >= 18 && LA5_0 <= 19)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:92:48: op= ( '+' | '-' ) rhs= mulExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( (input.LA(1) >= 18 && input.LA(1) <= 19) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_mulExpr_in_addExpr476);
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
            if ( state.backtracking>0 ) { memoize(input, 10, addExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "addExpr"



    // $ANTLR start "relExpr"
    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:103:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
    public final Expr relExpr() throws RecognitionException {
        Expr result = null;

        int relExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:104:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:104:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            {
            pushFollow(FOLLOW_addExpr_in_relExpr511);
            lhs=addExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:104:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==13||(LA6_0 >= 22 && LA6_0 <= 26)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:104:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( input.LA(1)==13||(input.LA(1) >= 22 && input.LA(1) <= 26) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_addExpr_in_relExpr535);
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
            if ( state.backtracking>0 ) { memoize(input, 11, relExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "relExpr"



    // $ANTLR start "andExpr"
    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:127:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
    public final Expr andExpr() throws RecognitionException {
        Expr result = null;

        int andExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }

            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:128:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:128:9: lhs= relExpr ( '&&' rhs= relExpr )*
            {
            pushFollow(FOLLOW_relExpr_in_andExpr573);
            lhs=relExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:128:46: ( '&&' rhs= relExpr )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==14) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:128:48: '&&' rhs= relExpr
            	    {
            	    match(input,14,FOLLOW_14_in_andExpr579); if (state.failed) return result;

            	    pushFollow(FOLLOW_relExpr_in_andExpr583);
            	    rhs=relExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { result = new And(result, rhs); }

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
            if ( state.backtracking>0 ) { memoize(input, 12, andExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "andExpr"



    // $ANTLR start "orExpr"
    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:132:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
    public final Expr orExpr() throws RecognitionException {
        Expr result = null;

        int orExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return result; }

            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:133:5: (lhs= andExpr ( '||' rhs= andExpr )* )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:133:9: lhs= andExpr ( '||' rhs= andExpr )*
            {
            pushFollow(FOLLOW_andExpr_in_orExpr618);
            lhs=andExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = lhs; }

            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:133:48: ( '||' rhs= andExpr )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==30) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:133:50: '||' rhs= andExpr
            	    {
            	    match(input,30,FOLLOW_30_in_orExpr624); if (state.failed) return result;

            	    pushFollow(FOLLOW_andExpr_in_orExpr628);
            	    rhs=andExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { result = new Or(result, rhs); }

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
            if ( state.backtracking>0 ) { memoize(input, 13, orExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "orExpr"

    // Delegated rules


 

    public static final BitSet FOLLOW_Type_in_type48 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_form71 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_Ident_in_form73 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_form76 = new BitSet(new long[]{0x0000000010000040L});
    public static final BitSet FOLLOW_bodyElements_in_form78 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_form80 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_question_in_bodyElements109 = new BitSet(new long[]{0x0000000010000042L});
    public static final BitSet FOLLOW_computedQuestion_in_bodyElements115 = new BitSet(new long[]{0x0000000010000042L});
    public static final BitSet FOLLOW_ifBlock_in_bodyElements121 = new BitSet(new long[]{0x0000000010000042L});
    public static final BitSet FOLLOW_Ident_in_question148 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_question150 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_StringLit_in_question152 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_type_in_question154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_computedQuestion172 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_computedQuestion174 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_StringLit_in_computedQuestion176 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_type_in_computedQuestion178 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_computedQuestion180 = new BitSet(new long[]{0x00000000000C92D0L});
    public static final BitSet FOLLOW_orExpr_in_computedQuestion184 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_computedQuestion186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ifBlock209 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ifBlock211 = new BitSet(new long[]{0x00000000000C92D0L});
    public static final BitSet FOLLOW_orExpr_in_ifBlock215 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ifBlock217 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ifBlock219 = new BitSet(new long[]{0x0000000010000040L});
    public static final BitSet FOLLOW_bodyElements_in_ifBlock221 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ifBlock222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Int_in_primary243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLit_in_primary253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BoolLit_in_primary261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_primary270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_primary278 = new BitSet(new long[]{0x00000000000C92D0L});
    public static final BitSet FOLLOW_orExpr_in_primary282 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_primary284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_unExpr312 = new BitSet(new long[]{0x00000000000C92D0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_unExpr327 = new BitSet(new long[]{0x00000000000C92D0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_unExpr342 = new BitSet(new long[]{0x00000000000C92D0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_unExpr359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr397 = new BitSet(new long[]{0x0000000000120002L});
    public static final BitSet FOLLOW_set_in_mulExpr405 = new BitSet(new long[]{0x00000000000C92D0L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr417 = new BitSet(new long[]{0x0000000000120002L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr458 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_set_in_addExpr466 = new BitSet(new long[]{0x00000000000C92D0L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr476 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_addExpr_in_relExpr511 = new BitSet(new long[]{0x0000000007C02002L});
    public static final BitSet FOLLOW_set_in_relExpr519 = new BitSet(new long[]{0x00000000000C92D0L});
    public static final BitSet FOLLOW_addExpr_in_relExpr535 = new BitSet(new long[]{0x0000000007C02002L});
    public static final BitSet FOLLOW_relExpr_in_andExpr573 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_andExpr579 = new BitSet(new long[]{0x00000000000C92D0L});
    public static final BitSet FOLLOW_relExpr_in_andExpr583 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_andExpr_in_orExpr618 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_30_in_orExpr624 = new BitSet(new long[]{0x00000000000C92D0L});
    public static final BitSet FOLLOW_andExpr_in_orExpr628 = new BitSet(new long[]{0x0000000040000002L});

}