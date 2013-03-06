// $ANTLR 3.2 Sep 23, 2009 12:02:23 C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g 2013-03-04 14:41:59

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.alg.*;
import org.uva.sea.ql.ast.form.*;
import org.uva.sea.ql.ast.types.*;
import java.util.Map;
import java.util.HashMap;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class QLParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Ident", "STRING", "Int", "Bool", "WS", "COMMENT", "Money", "'form'", "'{'", "'}'", "':'", "'integer'", "'boolean'", "'string'", "'money'", "'if'", "'('", "')'", "'else'", "'='", "'+'", "'-'", "'!'", "'*'", "'/'", "'<'", "'<='", "'>'", "'>='", "'=='", "'!='", "'&&'", "'||'"
    };
    public static final int Bool=7;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int EOF=-1;
    public static final int Int=6;
    public static final int T__30=30;
    public static final int T__19=19;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int Money=10;
    public static final int WS=8;
    public static final int T__33=33;
    public static final int T__16=16;
    public static final int T__34=34;
    public static final int T__15=15;
    public static final int T__35=35;
    public static final int T__18=18;
    public static final int Ident=4;
    public static final int T__36=36;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int COMMENT=9;
    public static final int STRING=5;

    // delegates
    // delegators


        public QLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public QLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return QLParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g"; }


        private final Map<String, Ident> variables = new HashMap<String, Ident>();



    // $ANTLR start "form"
    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:28:1: form returns [Form f] : 'form' Ident '{' (q= question | ce= ifconditionalexpr )* '}' ;
    public final Form form() throws RecognitionException {
        Form f = null;
        int form_StartIndex = input.index();
        Token Ident1=null;
        Question q = null;

        IfConditionalExpr ce = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return f; }
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:29:5: ( 'form' Ident '{' (q= question | ce= ifconditionalexpr )* '}' )
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:30:7: 'form' Ident '{' (q= question | ce= ifconditionalexpr )* '}'
            {
            match(input,11,FOLLOW_11_in_form69); 
            Ident1=(Token)match(input,Ident,FOLLOW_Ident_in_form71); 
            f = new Form((Ident1!=null?Ident1.getText():null)); 
            match(input,12,FOLLOW_12_in_form75); 
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:30:55: (q= question | ce= ifconditionalexpr )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==STRING) ) {
                    alt1=1;
                }
                else if ( (LA1_0==19) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:30:57: q= question
            	    {
            	    pushFollow(FOLLOW_question_in_form83);
            	    q=question();

            	    state._fsp--;

            	     f.addQuestion(q); 

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:30:96: ce= ifconditionalexpr
            	    {
            	    pushFollow(FOLLOW_ifconditionalexpr_in_form94);
            	    ce=ifconditionalexpr();

            	    state._fsp--;

            	     f.addIfConditionalExpr(ce); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            match(input,13,FOLLOW_13_in_form100); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return f;
    }
    // $ANTLR end "form"


    // $ANTLR start "question"
    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:34:1: question returns [Question q] : ( STRING ) (d= declaration | c= calculation ) ;
    public final Question question() throws RecognitionException {
        Question q = null;
        int question_StartIndex = input.index();
        Token STRING2=null;
        Declaration d = null;

        Calculation c = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return q; }
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:35:5: ( ( STRING ) (d= declaration | c= calculation ) )
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:36:7: ( STRING ) (d= declaration | c= calculation )
            {
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:36:7: ( STRING )
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:36:8: STRING
            {
            STRING2=(Token)match(input,STRING,FOLLOW_STRING_in_question135); 
            q = new Question((STRING2!=null?STRING2.getText():null)); 

            }

            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:36:52: (d= declaration | c= calculation )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==Ident) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==14) ) {
                    alt2=1;
                }
                else if ( (LA2_1==23) ) {
                    alt2=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:36:54: d= declaration
                    {
                    pushFollow(FOLLOW_declaration_in_question146);
                    d=declaration();

                    state._fsp--;

                    q.addDeclaration(d); 

                    }
                    break;
                case 2 :
                    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:36:98: c= calculation
                    {
                    pushFollow(FOLLOW_calculation_in_question157);
                    c=calculation();

                    state._fsp--;

                     q.addCalculation(c); 

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
        }
        return q;
    }
    // $ANTLR end "question"


    // $ANTLR start "declaration"
    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:39:1: declaration returns [Declaration d] : d1= Ident ':' d2= type ;
    public final Declaration declaration() throws RecognitionException {
        Declaration d = null;
        int declaration_StartIndex = input.index();
        Token d1=null;
        Type d2 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return d; }
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:40:5: (d1= Ident ':' d2= type )
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:41:7: d1= Ident ':' d2= type
            {
            d1=(Token)match(input,Ident,FOLLOW_Ident_in_declaration196); 
            match(input,14,FOLLOW_14_in_declaration198); 
            pushFollow(FOLLOW_type_in_declaration204);
            d2=type();

            state._fsp--;

             
                     Ident ident = new Ident((d1!=null?d1.getText():null));      
                     d = new Declaration(ident, d2); 
                     this.variables.put((d1!=null?d1.getText():null), ident);
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return d;
    }
    // $ANTLR end "declaration"


    // $ANTLR start "type"
    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:50:1: type returns [Type type] : ( 'integer' | 'boolean' | 'string' | 'money' );
    public final Type type() throws RecognitionException {
        Type type = null;
        int type_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return type; }
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:51:1: ( 'integer' | 'boolean' | 'string' | 'money' )
            int alt3=4;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt3=1;
                }
                break;
            case 16:
                {
                alt3=2;
                }
                break;
            case 17:
                {
                alt3=3;
                }
                break;
            case 18:
                {
                alt3=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:51:3: 'integer'
                    {
                    match(input,15,FOLLOW_15_in_type231); 
                    type = new IntType();

                    }
                    break;
                case 2 :
                    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:52:3: 'boolean'
                    {
                    match(input,16,FOLLOW_16_in_type237); 
                    type = new BoolType();

                    }
                    break;
                case 3 :
                    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:53:3: 'string'
                    {
                    match(input,17,FOLLOW_17_in_type243); 
                    type = new StrType();

                    }
                    break;
                case 4 :
                    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:54:3: 'money'
                    {
                    match(input,18,FOLLOW_18_in_type250); 
                    type = new MoneyType();

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return type;
    }
    // $ANTLR end "type"


    // $ANTLR start "ifconditionalexpr"
    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:58:1: ifconditionalexpr returns [IfConditionalExpr ifce] : 'if' '(' ce1= orExpr ')' '{' (ce2= question )* '}' ( 'else' '{' (ce3= question )* '}' )? ;
    public final IfConditionalExpr ifconditionalexpr() throws RecognitionException {
        IfConditionalExpr ifce = null;
        int ifconditionalexpr_StartIndex = input.index();
        Expr ce1 = null;

        Question ce2 = null;

        Question ce3 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return ifce; }
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:59:5: ( 'if' '(' ce1= orExpr ')' '{' (ce2= question )* '}' ( 'else' '{' (ce3= question )* '}' )? )
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:60:7: 'if' '(' ce1= orExpr ')' '{' (ce2= question )* '}' ( 'else' '{' (ce3= question )* '}' )?
            {
            match(input,19,FOLLOW_19_in_ifconditionalexpr278); 
            match(input,20,FOLLOW_20_in_ifconditionalexpr280); 
            pushFollow(FOLLOW_orExpr_in_ifconditionalexpr286);
            ce1=orExpr();

            state._fsp--;

            ifce = new IfConditionalExpr(ce1); 
            match(input,21,FOLLOW_21_in_ifconditionalexpr290); 
            match(input,12,FOLLOW_12_in_ifconditionalexpr292); 
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:60:76: (ce2= question )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==STRING) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:60:77: ce2= question
            	    {
            	    pushFollow(FOLLOW_question_in_ifconditionalexpr299);
            	    ce2=question();

            	    state._fsp--;

            	    ifce.addThen(ce2); 

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            match(input,13,FOLLOW_13_in_ifconditionalexpr306); 
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:60:122: ( 'else' '{' (ce3= question )* '}' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==22) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:60:123: 'else' '{' (ce3= question )* '}'
                    {
                    match(input,22,FOLLOW_22_in_ifconditionalexpr309); 
                    match(input,12,FOLLOW_12_in_ifconditionalexpr311); 
                    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:60:134: (ce3= question )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==STRING) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:60:135: ce3= question
                    	    {
                    	    pushFollow(FOLLOW_question_in_ifconditionalexpr318);
                    	    ce3=question();

                    	    state._fsp--;

                    	    ifce.addElse(ce3); 

                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    match(input,13,FOLLOW_13_in_ifconditionalexpr325); 

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
        }
        return ifce;
    }
    // $ANTLR end "ifconditionalexpr"


    // $ANTLR start "calculation"
    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:63:1: calculation returns [Calculation c] : d1= Ident '=' or1= orExpr ;
    public final Calculation calculation() throws RecognitionException {
        Calculation c = null;
        int calculation_StartIndex = input.index();
        Token d1=null;
        Expr or1 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return c; }
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:64:5: (d1= Ident '=' or1= orExpr )
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:65:7: d1= Ident '=' or1= orExpr
            {
            d1=(Token)match(input,Ident,FOLLOW_Ident_in_calculation359); 
            match(input,23,FOLLOW_23_in_calculation362); 
            pushFollow(FOLLOW_orExpr_in_calculation369);
            or1=orExpr();

            state._fsp--;

            c = new Calculation((d1!=null?d1.getText():null), or1); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return c;
    }
    // $ANTLR end "calculation"


    // $ANTLR start "primary"
    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:69:1: primary returns [Expr result] : ( Int | Ident | Bool | '(' x= orExpr ')' );
    public final Expr primary() throws RecognitionException {
        Expr result = null;
        int primary_StartIndex = input.index();
        Token Int3=null;
        Token Ident4=null;
        Token Bool5=null;
        Expr x = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:70:3: ( Int | Ident | Bool | '(' x= orExpr ')' )
            int alt7=4;
            switch ( input.LA(1) ) {
            case Int:
                {
                alt7=1;
                }
                break;
            case Ident:
                {
                alt7=2;
                }
                break;
            case Bool:
                {
                alt7=3;
                }
                break;
            case 20:
                {
                alt7=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:70:5: Int
                    {
                    Int3=(Token)match(input,Int,FOLLOW_Int_in_primary395); 
                     result = new Int(Integer.parseInt((Int3!=null?Int3.getText():null))); 

                    }
                    break;
                case 2 :
                    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:71:5: Ident
                    {
                    Ident4=(Token)match(input,Ident,FOLLOW_Ident_in_primary405); 
                     result = this.variables.get((Ident4!=null?Ident4.getText():null)); 

                    }
                    break;
                case 3 :
                    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:72:5: Bool
                    {
                    Bool5=(Token)match(input,Bool,FOLLOW_Bool_in_primary413); 
                     result = new Bool((Bool5!=null?Bool5.getText():null)); 

                    }
                    break;
                case 4 :
                    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:73:5: '(' x= orExpr ')'
                    {
                    match(input,20,FOLLOW_20_in_primary421); 
                    pushFollow(FOLLOW_orExpr_in_primary425);
                    x=orExpr();

                    state._fsp--;

                    match(input,21,FOLLOW_21_in_primary427); 
                     result = x; 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "primary"


    // $ANTLR start "unExpr"
    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:78:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr | x= primary );
    public final Expr unExpr() throws RecognitionException {
        Expr result = null;
        int unExpr_StartIndex = input.index();
        Expr x = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:79:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr | x= primary )
            int alt8=4;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt8=1;
                }
                break;
            case 25:
                {
                alt8=2;
                }
                break;
            case 26:
                {
                alt8=3;
                }
                break;
            case Ident:
            case Int:
            case Bool:
            case 20:
                {
                alt8=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:79:8: '+' x= unExpr
                    {
                    match(input,24,FOLLOW_24_in_unExpr460); 
                    pushFollow(FOLLOW_unExpr_in_unExpr464);
                    x=unExpr();

                    state._fsp--;

                     result = new Pos(x); 

                    }
                    break;
                case 2 :
                    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:80:8: '-' x= unExpr
                    {
                    match(input,25,FOLLOW_25_in_unExpr475); 
                    pushFollow(FOLLOW_unExpr_in_unExpr479);
                    x=unExpr();

                    state._fsp--;

                     result = new Neg(x); 

                    }
                    break;
                case 3 :
                    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:81:8: '!' x= unExpr
                    {
                    match(input,26,FOLLOW_26_in_unExpr490); 
                    pushFollow(FOLLOW_unExpr_in_unExpr494);
                    x=unExpr();

                    state._fsp--;

                     result = new Not(x); 

                    }
                    break;
                case 4 :
                    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:82:8: x= primary
                    {
                    pushFollow(FOLLOW_primary_in_unExpr507);
                    x=primary();

                    state._fsp--;

                     result = x; 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "unExpr"


    // $ANTLR start "mulExpr"
    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:85:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
    public final Expr mulExpr() throws RecognitionException {
        Expr result = null;
        int mulExpr_StartIndex = input.index();
        Token op=null;
        Expr lhs = null;

        Expr rhs = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:86:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:86:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
            {
            pushFollow(FOLLOW_unExpr_in_mulExpr545);
            lhs=unExpr();

            state._fsp--;

             result =lhs; 
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:86:45: (op= ( '*' | '/' ) rhs= unExpr )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=27 && LA9_0<=28)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:86:47: op= ( '*' | '/' ) rhs= unExpr
            	    {
            	    op=(Token)input.LT(1);
            	    if ( (input.LA(1)>=27 && input.LA(1)<=28) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_unExpr_in_mulExpr565);
            	    rhs=unExpr();

            	    state._fsp--;

            	     
            	          if ((op!=null?op.getText():null).equals("*")) {
            	            result = new Mul(result, rhs);
            	          }
            	          if ((op!=null?op.getText():null).equals("/")) {
            	            result = new Div(result, rhs);      
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
        }
        return result;
    }
    // $ANTLR end "mulExpr"


    // $ANTLR start "addExpr"
    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:98:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
    public final Expr addExpr() throws RecognitionException {
        Expr result = null;
        int addExpr_StartIndex = input.index();
        Token op=null;
        Expr lhs = null;

        Expr rhs = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:99:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:99:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
            {
            pushFollow(FOLLOW_mulExpr_in_addExpr606);
            lhs=mulExpr();

            state._fsp--;

             result =lhs; 
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:99:46: (op= ( '+' | '-' ) rhs= mulExpr )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>=24 && LA10_0<=25)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:99:48: op= ( '+' | '-' ) rhs= mulExpr
            	    {
            	    op=(Token)input.LT(1);
            	    if ( (input.LA(1)>=24 && input.LA(1)<=25) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_mulExpr_in_addExpr624);
            	    rhs=mulExpr();

            	    state._fsp--;

            	     
            	          if ((op!=null?op.getText():null).equals("+")) {
            	            result = new Add(result, rhs);
            	          }
            	          if ((op!=null?op.getText():null).equals("-")) {
            	            result = new Sub(result, rhs);      
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
        }
        return result;
    }
    // $ANTLR end "addExpr"


    // $ANTLR start "relExpr"
    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:111:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
    public final Expr relExpr() throws RecognitionException {
        Expr result = null;
        int relExpr_StartIndex = input.index();
        Token op=null;
        Expr lhs = null;

        Expr rhs = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:112:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:112:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            {
            pushFollow(FOLLOW_addExpr_in_relExpr662);
            lhs=addExpr();

            state._fsp--;

             result =lhs; 
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:112:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>=29 && LA11_0<=34)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:112:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
            	    {
            	    op=(Token)input.LT(1);
            	    if ( (input.LA(1)>=29 && input.LA(1)<=34) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_addExpr_in_relExpr686);
            	    rhs=addExpr();

            	    state._fsp--;

            	     
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
        }
        return result;
    }
    // $ANTLR end "relExpr"


    // $ANTLR start "andExpr"
    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:136:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
    public final Expr andExpr() throws RecognitionException {
        Expr result = null;
        int andExpr_StartIndex = input.index();
        Expr lhs = null;

        Expr rhs = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:137:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:137:9: lhs= relExpr ( '&&' rhs= relExpr )*
            {
            pushFollow(FOLLOW_relExpr_in_andExpr729);
            lhs=relExpr();

            state._fsp--;

             result =lhs; 
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:137:46: ( '&&' rhs= relExpr )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==35) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:137:48: '&&' rhs= relExpr
            	    {
            	    match(input,35,FOLLOW_35_in_andExpr735); 
            	    pushFollow(FOLLOW_relExpr_in_andExpr739);
            	    rhs=relExpr();

            	    state._fsp--;

            	     result = new And(result, rhs); 

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
        }
        return result;
    }
    // $ANTLR end "andExpr"


    // $ANTLR start "orExpr"
    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:141:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
    public final Expr orExpr() throws RecognitionException {
        Expr result = null;
        int orExpr_StartIndex = input.index();
        Expr lhs = null;

        Expr rhs = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return result; }
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:142:5: (lhs= andExpr ( '||' rhs= andExpr )* )
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:142:9: lhs= andExpr ( '||' rhs= andExpr )*
            {
            pushFollow(FOLLOW_andExpr_in_orExpr774);
            lhs=andExpr();

            state._fsp--;

             result = lhs; 
            // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:142:48: ( '||' rhs= andExpr )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==36) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // C:\\Users\\prajan\\Desktop\\Unive\\UVA\\Software Construction\\eclipseIndigo\\gitrepository2\\Prajan\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:142:50: '||' rhs= andExpr
            	    {
            	    match(input,36,FOLLOW_36_in_orExpr780); 
            	    pushFollow(FOLLOW_andExpr_in_orExpr784);
            	    rhs=andExpr();

            	    state._fsp--;

            	     result = new Or(result, rhs); 

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
        }
        return result;
    }
    // $ANTLR end "orExpr"

    // Delegated rules


 

    public static final BitSet FOLLOW_11_in_form69 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Ident_in_form71 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_form75 = new BitSet(new long[]{0x0000000000082020L});
    public static final BitSet FOLLOW_question_in_form83 = new BitSet(new long[]{0x0000000000082020L});
    public static final BitSet FOLLOW_ifconditionalexpr_in_form94 = new BitSet(new long[]{0x0000000000082020L});
    public static final BitSet FOLLOW_13_in_form100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_question135 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_declaration_in_question146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_calculation_in_question157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_declaration196 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_declaration198 = new BitSet(new long[]{0x0000000000078000L});
    public static final BitSet FOLLOW_type_in_declaration204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_type231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_type237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_type243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_type250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ifconditionalexpr278 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ifconditionalexpr280 = new BitSet(new long[]{0x00000000071000D0L});
    public static final BitSet FOLLOW_orExpr_in_ifconditionalexpr286 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ifconditionalexpr290 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ifconditionalexpr292 = new BitSet(new long[]{0x0000000000002020L});
    public static final BitSet FOLLOW_question_in_ifconditionalexpr299 = new BitSet(new long[]{0x0000000000002020L});
    public static final BitSet FOLLOW_13_in_ifconditionalexpr306 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_ifconditionalexpr309 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ifconditionalexpr311 = new BitSet(new long[]{0x0000000000002020L});
    public static final BitSet FOLLOW_question_in_ifconditionalexpr318 = new BitSet(new long[]{0x0000000000002020L});
    public static final BitSet FOLLOW_13_in_ifconditionalexpr325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_calculation359 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_calculation362 = new BitSet(new long[]{0x00000000071000D0L});
    public static final BitSet FOLLOW_orExpr_in_calculation369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Int_in_primary395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_primary405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Bool_in_primary413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_primary421 = new BitSet(new long[]{0x00000000071000D0L});
    public static final BitSet FOLLOW_orExpr_in_primary425 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_primary427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_unExpr460 = new BitSet(new long[]{0x00000000071000D0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_unExpr475 = new BitSet(new long[]{0x00000000071000D0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_unExpr490 = new BitSet(new long[]{0x00000000071000D0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_unExpr507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr545 = new BitSet(new long[]{0x0000000018000002L});
    public static final BitSet FOLLOW_set_in_mulExpr553 = new BitSet(new long[]{0x00000000071000D0L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr565 = new BitSet(new long[]{0x0000000018000002L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr606 = new BitSet(new long[]{0x0000000003000002L});
    public static final BitSet FOLLOW_set_in_addExpr614 = new BitSet(new long[]{0x00000000071000D0L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr624 = new BitSet(new long[]{0x0000000003000002L});
    public static final BitSet FOLLOW_addExpr_in_relExpr662 = new BitSet(new long[]{0x00000007E0000002L});
    public static final BitSet FOLLOW_set_in_relExpr670 = new BitSet(new long[]{0x00000000071000D0L});
    public static final BitSet FOLLOW_addExpr_in_relExpr686 = new BitSet(new long[]{0x00000007E0000002L});
    public static final BitSet FOLLOW_relExpr_in_andExpr729 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_andExpr735 = new BitSet(new long[]{0x00000000071000D0L});
    public static final BitSet FOLLOW_relExpr_in_andExpr739 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_andExpr_in_orExpr774 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_36_in_orExpr780 = new BitSet(new long[]{0x00000000071000D0L});
    public static final BitSet FOLLOW_andExpr_in_orExpr784 = new BitSet(new long[]{0x0000001000000002L});

}