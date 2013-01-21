// $ANTLR 3.4 /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g 2013-01-21 04:34:40

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expr.*;
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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "BoolLit", "COMMENT", "Decimal", "Ident", "Int", "LB", "StringLit", "Type", "WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", "'/'", "':'", "'<'", "'<='", "'=='", "'>'", "'>='", "'form'", "'if'", "'{'", "'||'", "'}'"
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
    public static final int BoolLit=4;
    public static final int COMMENT=5;
    public static final int Decimal=6;
    public static final int Ident=7;
    public static final int Int=8;
    public static final int LB=9;
    public static final int StringLit=10;
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
        this.state.ruleMemo = new HashMap[37+1];
         

    }

    public String[] getTokenNames() { return QLParser.tokenNames; }
    public String getGrammarFileName() { return "/home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g"; }



    // $ANTLR start "type"
    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:23:1: type returns [Type result] : ( Type ) ;
    public final Type type() throws RecognitionException {
        Type result = null;

        int type_StartIndex = input.index();

        Token Type1=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:24:2: ( ( Type ) )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:24:4: ( Type )
            {
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:24:4: ( Type )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:24:5: Type
            {
            Type1=(Token)match(input,Type,FOLLOW_Type_in_type48); if (state.failed) return result;

            if ( state.backtracking==0 ) {
            		 if ((Type1!=null?Type1.getText():null).equals("int"))result = new IntType((Type1!=null?Type1.getText():null)); 
            		 else if ((Type1!=null?Type1.getText():null).equals("boolean"))result = new BoolType((Type1!=null?Type1.getText():null)); 
            		 else if ((Type1!=null?Type1.getText():null).equals("string"))result = new StringType((Type1!=null?Type1.getText():null));
            		 else if ((Type1!=null?Type1.getText():null).equals("money"))result = new MoneyType((Type1!=null?Type1.getText():null));
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
    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:34:1: form returns [Form result] : 'form' Ident '{' body '}' ;
    public final Form form() throws RecognitionException {
        Form result = null;

        int form_StartIndex = input.index();

        Token Ident2=null;
        List<Element> body3 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:35:2: ( 'form' Ident '{' body '}' )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:35:4: 'form' Ident '{' body '}'
            {
            match(input,28,FOLLOW_28_in_form71); if (state.failed) return result;

            Ident2=(Token)match(input,Ident,FOLLOW_Ident_in_form73); if (state.failed) return result;

            match(input,30,FOLLOW_30_in_form76); if (state.failed) return result;

            pushFollow(FOLLOW_body_in_form78);
            body3=body();

            state._fsp--;
            if (state.failed) return result;

            match(input,32,FOLLOW_32_in_form80); if (state.failed) return result;

            if ( state.backtracking==0 ) {result = new Form(new Ident((Ident2!=null?Ident2.getText():null)),body3);}

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



    // $ANTLR start "body"
    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:42:2: body returns [List<Element> result] : ( element )* ;
    public final List<Element> body() throws RecognitionException {
        List<Element> result = null;

        int body_StartIndex = input.index();

        Element element4 =null;


         List<Element> list = new ArrayList<Element>() ; 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:43:60: ( ( element )* )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:43:61: ( element )*
            {
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:43:61: ( element )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==Ident||LA1_0==29) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:43:62: element
            	    {
            	    pushFollow(FOLLOW_element_in_body113);
            	    element4=element();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { list.add(element4) ; }

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            if ( state.backtracking==0 ) {result =list;}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 3, body_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "body"



    // $ANTLR start "element"
    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:47:1: element returns [Element result] : ( computedQuestion | question | ifBlock );
    public final Element element() throws RecognitionException {
        Element result = null;

        int element_StartIndex = input.index();

        ComputedQuestion computedQuestion5 =null;

        Question question6 =null;

        IfBlock ifBlock7 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:48:3: ( computedQuestion | question | ifBlock )
            int alt2=3;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==Ident) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==22) ) {
                    int LA2_3 = input.LA(3);

                    if ( (LA2_3==StringLit) ) {
                        int LA2_4 = input.LA(4);

                        if ( (LA2_4==Type) ) {
                            int LA2_5 = input.LA(5);

                            if ( (LA2_5==16) ) {
                                alt2=1;
                            }
                            else if ( (LA2_5==EOF||LA2_5==Ident||LA2_5==29||LA2_5==32) ) {
                                alt2=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return result;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 2, 5, input);

                                throw nvae;

                            }
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return result;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 2, 4, input);

                            throw nvae;

                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return result;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 2, 3, input);

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
            else if ( (LA2_0==29) ) {
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
                    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:48:4: computedQuestion
                    {
                    pushFollow(FOLLOW_computedQuestion_in_element140);
                    computedQuestion5=computedQuestion();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) {result =computedQuestion5;}

                    }
                    break;
                case 2 :
                    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:49:4: question
                    {
                    pushFollow(FOLLOW_question_in_element147);
                    question6=question();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) {result =question6;}

                    }
                    break;
                case 3 :
                    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:50:4: ifBlock
                    {
                    pushFollow(FOLLOW_ifBlock_in_element154);
                    ifBlock7=ifBlock();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) {result =ifBlock7;}

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
            if ( state.backtracking>0 ) { memoize(input, 4, element_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "element"



    // $ANTLR start "question"
    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:54:1: question returns [Question result] : Ident ':' StringLit type ;
    public final Question question() throws RecognitionException {
        Question result = null;

        int question_StartIndex = input.index();

        Token Ident8=null;
        Token StringLit9=null;
        Type type10 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:55:3: ( Ident ':' StringLit type )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:55:5: Ident ':' StringLit type
            {
            Ident8=(Token)match(input,Ident,FOLLOW_Ident_in_question175); if (state.failed) return result;

            match(input,22,FOLLOW_22_in_question177); if (state.failed) return result;

            StringLit9=(Token)match(input,StringLit,FOLLOW_StringLit_in_question179); if (state.failed) return result;

            pushFollow(FOLLOW_type_in_question181);
            type10=type();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) {result =new Question(new Ident((Ident8!=null?Ident8.getText():null)),(StringLit9!=null?StringLit9.getText():null),type10);}

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



    // $ANTLR start "computedQuestion"
    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:57:1: computedQuestion returns [ComputedQuestion result] : Ident ':' StringLit type '(' expr= orExpr ')' ;
    public final ComputedQuestion computedQuestion() throws RecognitionException {
        ComputedQuestion result = null;

        int computedQuestion_StartIndex = input.index();

        Token Ident11=null;
        Token StringLit12=null;
        Expr expr =null;

        Type type13 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:58:3: ( Ident ':' StringLit type '(' expr= orExpr ')' )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:58:5: Ident ':' StringLit type '(' expr= orExpr ')'
            {
            Ident11=(Token)match(input,Ident,FOLLOW_Ident_in_computedQuestion199); if (state.failed) return result;

            match(input,22,FOLLOW_22_in_computedQuestion201); if (state.failed) return result;

            StringLit12=(Token)match(input,StringLit,FOLLOW_StringLit_in_computedQuestion203); if (state.failed) return result;

            pushFollow(FOLLOW_type_in_computedQuestion205);
            type13=type();

            state._fsp--;
            if (state.failed) return result;

            match(input,16,FOLLOW_16_in_computedQuestion207); if (state.failed) return result;

            pushFollow(FOLLOW_orExpr_in_computedQuestion211);
            expr=orExpr();

            state._fsp--;
            if (state.failed) return result;

            match(input,17,FOLLOW_17_in_computedQuestion213); if (state.failed) return result;

            if ( state.backtracking==0 ) {result =new ComputedQuestion(new Ident((Ident11!=null?Ident11.getText():null)),(StringLit12!=null?StringLit12.getText():null),type13,expr);}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 6, computedQuestion_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "computedQuestion"



    // $ANTLR start "ifBlock"
    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:61:1: ifBlock returns [IfBlock result] : 'if' '(' expr= orExpr ')' '{' body '}' ;
    public final IfBlock ifBlock() throws RecognitionException {
        IfBlock result = null;

        int ifBlock_StartIndex = input.index();

        Expr expr =null;

        List<Element> body14 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:62:2: ( 'if' '(' expr= orExpr ')' '{' body '}' )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:62:4: 'if' '(' expr= orExpr ')' '{' body '}'
            {
            match(input,29,FOLLOW_29_in_ifBlock233); if (state.failed) return result;

            match(input,16,FOLLOW_16_in_ifBlock235); if (state.failed) return result;

            pushFollow(FOLLOW_orExpr_in_ifBlock239);
            expr=orExpr();

            state._fsp--;
            if (state.failed) return result;

            match(input,17,FOLLOW_17_in_ifBlock241); if (state.failed) return result;

            match(input,30,FOLLOW_30_in_ifBlock243); if (state.failed) return result;

            pushFollow(FOLLOW_body_in_ifBlock246);
            body14=body();

            state._fsp--;
            if (state.failed) return result;

            match(input,32,FOLLOW_32_in_ifBlock247); if (state.failed) return result;

            if ( state.backtracking==0 ) {result =new IfBlock(expr,body14);}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 7, ifBlock_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "ifBlock"



    // $ANTLR start "primary"
    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:67:1: primary returns [Expr result] : ( Decimal | Int | StringLit | BoolLit | Ident | '(' x= orExpr ')' );
    public final Expr primary() throws RecognitionException {
        Expr result = null;

        int primary_StartIndex = input.index();

        Token Decimal15=null;
        Token Int16=null;
        Token StringLit17=null;
        Token BoolLit18=null;
        Token Ident19=null;
        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:68:3: ( Decimal | Int | StringLit | BoolLit | Ident | '(' x= orExpr ')' )
            int alt3=6;
            switch ( input.LA(1) ) {
            case Decimal:
                {
                alt3=1;
                }
                break;
            case Int:
                {
                alt3=2;
                }
                break;
            case StringLit:
                {
                alt3=3;
                }
                break;
            case BoolLit:
                {
                alt3=4;
                }
                break;
            case Ident:
                {
                alt3=5;
                }
                break;
            case 16:
                {
                alt3=6;
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
                    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:68:5: Decimal
                    {
                    Decimal15=(Token)match(input,Decimal,FOLLOW_Decimal_in_primary268); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Decimal(Float.parseFloat((Decimal15!=null?Decimal15.getText():null))); }

                    }
                    break;
                case 2 :
                    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:69:5: Int
                    {
                    Int16=(Token)match(input,Int,FOLLOW_Int_in_primary276); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Int(Integer.parseInt((Int16!=null?Int16.getText():null))); }

                    }
                    break;
                case 3 :
                    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:70:5: StringLit
                    {
                    StringLit17=(Token)match(input,StringLit,FOLLOW_StringLit_in_primary284); if (state.failed) return result;

                    if ( state.backtracking==0 ) {result = new StringLit((StringLit17!=null?StringLit17.getText():null));}

                    }
                    break;
                case 4 :
                    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:71:5: BoolLit
                    {
                    BoolLit18=(Token)match(input,BoolLit,FOLLOW_BoolLit_in_primary292); if (state.failed) return result;

                    if ( state.backtracking==0 ) {result = new BoolLit((BoolLit18!=null?BoolLit18.getText():null));}

                    }
                    break;
                case 5 :
                    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:72:5: Ident
                    {
                    Ident19=(Token)match(input,Ident,FOLLOW_Ident_in_primary301); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Ident((Ident19!=null?Ident19.getText():null)); }

                    }
                    break;
                case 6 :
                    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:73:5: '(' x= orExpr ')'
                    {
                    match(input,16,FOLLOW_16_in_primary309); if (state.failed) return result;

                    pushFollow(FOLLOW_orExpr_in_primary313);
                    x=orExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,17,FOLLOW_17_in_primary315); if (state.failed) return result;

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
    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:79:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
    public final Expr unExpr() throws RecognitionException {
        Expr result = null;

        int unExpr_StartIndex = input.index();

        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:80:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
            int alt4=4;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt4=1;
                }
                break;
            case 20:
                {
                alt4=2;
                }
                break;
            case 13:
                {
                alt4=3;
                }
                break;
            case BoolLit:
            case Decimal:
            case Ident:
            case Int:
            case StringLit:
            case 16:
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
                    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:80:8: '+' x= unExpr
                    {
                    match(input,19,FOLLOW_19_in_unExpr343); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr347);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Pos(x); }

                    }
                    break;
                case 2 :
                    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:81:8: '-' x= unExpr
                    {
                    match(input,20,FOLLOW_20_in_unExpr358); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr362);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Neg(x); }

                    }
                    break;
                case 3 :
                    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:82:8: '!' x= unExpr
                    {
                    match(input,13,FOLLOW_13_in_unExpr373); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr377);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Not(x); }

                    }
                    break;
                case 4 :
                    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:83:8: x= primary
                    {
                    pushFollow(FOLLOW_primary_in_unExpr390);
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
    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:86:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
    public final Expr mulExpr() throws RecognitionException {
        Expr result = null;

        int mulExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:87:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:87:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
            {
            pushFollow(FOLLOW_unExpr_in_mulExpr428);
            lhs=unExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:87:45: (op= ( '*' | '/' ) rhs= unExpr )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==18||LA5_0==21) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:87:47: op= ( '*' | '/' ) rhs= unExpr
            	    {
            	    op=(Token)input.LT(1);

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


            	    pushFollow(FOLLOW_unExpr_in_mulExpr448);
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
    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:99:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
    public final Expr addExpr() throws RecognitionException {
        Expr result = null;

        int addExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:100:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:100:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
            {
            pushFollow(FOLLOW_mulExpr_in_addExpr489);
            lhs=mulExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:100:46: (op= ( '+' | '-' ) rhs= mulExpr )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0 >= 19 && LA6_0 <= 20)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:100:48: op= ( '+' | '-' ) rhs= mulExpr
            	    {
            	    op=(Token)input.LT(1);

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


            	    pushFollow(FOLLOW_mulExpr_in_addExpr507);
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
    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:111:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
    public final Expr relExpr() throws RecognitionException {
        Expr result = null;

        int relExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }

            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:112:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:112:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            {
            pushFollow(FOLLOW_addExpr_in_relExpr542);
            lhs=addExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:112:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==14||(LA7_0 >= 23 && LA7_0 <= 27)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:112:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
            	    {
            	    op=(Token)input.LT(1);

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


            	    pushFollow(FOLLOW_addExpr_in_relExpr566);
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
    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:135:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
    public final Expr andExpr() throws RecognitionException {
        Expr result = null;

        int andExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return result; }

            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:136:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:136:9: lhs= relExpr ( '&&' rhs= relExpr )*
            {
            pushFollow(FOLLOW_relExpr_in_andExpr604);
            lhs=relExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:136:46: ( '&&' rhs= relExpr )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==15) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:136:48: '&&' rhs= relExpr
            	    {
            	    match(input,15,FOLLOW_15_in_andExpr610); if (state.failed) return result;

            	    pushFollow(FOLLOW_relExpr_in_andExpr614);
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
    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:140:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
    public final Expr orExpr() throws RecognitionException {
        Expr result = null;

        int orExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return result; }

            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:141:5: (lhs= andExpr ( '||' rhs= andExpr )* )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:141:9: lhs= andExpr ( '||' rhs= andExpr )*
            {
            pushFollow(FOLLOW_andExpr_in_orExpr649);
            lhs=andExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = lhs; }

            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:141:48: ( '||' rhs= andExpr )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==31) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:141:50: '||' rhs= andExpr
            	    {
            	    match(input,31,FOLLOW_31_in_orExpr655); if (state.failed) return result;

            	    pushFollow(FOLLOW_andExpr_in_orExpr659);
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

    // Delegated rules


 

    public static final BitSet FOLLOW_Type_in_type48 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_form71 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_Ident_in_form73 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_form76 = new BitSet(new long[]{0x0000000120000080L});
    public static final BitSet FOLLOW_body_in_form78 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_form80 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_element_in_body113 = new BitSet(new long[]{0x0000000020000082L});
    public static final BitSet FOLLOW_computedQuestion_in_element140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_question_in_element147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifBlock_in_element154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_question175 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_question177 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_StringLit_in_question179 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_type_in_question181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_computedQuestion199 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_computedQuestion201 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_StringLit_in_computedQuestion203 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_type_in_computedQuestion205 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_computedQuestion207 = new BitSet(new long[]{0x00000000001925D0L});
    public static final BitSet FOLLOW_orExpr_in_computedQuestion211 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_computedQuestion213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ifBlock233 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ifBlock235 = new BitSet(new long[]{0x00000000001925D0L});
    public static final BitSet FOLLOW_orExpr_in_ifBlock239 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ifBlock241 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ifBlock243 = new BitSet(new long[]{0x0000000120000080L});
    public static final BitSet FOLLOW_body_in_ifBlock246 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ifBlock247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Decimal_in_primary268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Int_in_primary276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLit_in_primary284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BoolLit_in_primary292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_primary301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_primary309 = new BitSet(new long[]{0x00000000001925D0L});
    public static final BitSet FOLLOW_orExpr_in_primary313 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_primary315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_unExpr343 = new BitSet(new long[]{0x00000000001925D0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_unExpr358 = new BitSet(new long[]{0x00000000001925D0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_unExpr373 = new BitSet(new long[]{0x00000000001925D0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_unExpr390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr428 = new BitSet(new long[]{0x0000000000240002L});
    public static final BitSet FOLLOW_set_in_mulExpr436 = new BitSet(new long[]{0x00000000001925D0L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr448 = new BitSet(new long[]{0x0000000000240002L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr489 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_set_in_addExpr497 = new BitSet(new long[]{0x00000000001925D0L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr507 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_addExpr_in_relExpr542 = new BitSet(new long[]{0x000000000F804002L});
    public static final BitSet FOLLOW_set_in_relExpr550 = new BitSet(new long[]{0x00000000001925D0L});
    public static final BitSet FOLLOW_addExpr_in_relExpr566 = new BitSet(new long[]{0x000000000F804002L});
    public static final BitSet FOLLOW_relExpr_in_andExpr604 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_andExpr610 = new BitSet(new long[]{0x00000000001925D0L});
    public static final BitSet FOLLOW_relExpr_in_andExpr614 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_andExpr_in_orExpr649 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_orExpr655 = new BitSet(new long[]{0x00000000001925D0L});
    public static final BitSet FOLLOW_andExpr_in_orExpr659 = new BitSet(new long[]{0x0000000080000002L});

}