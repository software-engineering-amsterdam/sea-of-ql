// $ANTLR 3.4 /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g 2013-02-05 22:27:16

package org.uva.sea.ql.parser.antlr;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class QLLexer extends Lexer {
    public static final int EOF=-1;
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
    public static final int BOOLEAN=4;
    public static final int BoolLit=5;
    public static final int COMMENT=6;
    public static final int Decimal=7;
    public static final int INTEGER=8;
    public static final int Ident=9;
    public static final int Int=10;
    public static final int MONEY=11;
    public static final int STRING=12;
    public static final int StringLit=13;
    public static final int WS=14;

    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public QLLexer() {} 
    public QLLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public QLLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "/home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g"; }

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:7:7: ( '!' )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:7:9: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:8:7: ( '!=' )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:8:9: '!='
            {
            match("!="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:9:7: ( '&&' )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:9:9: '&&'
            {
            match("&&"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:10:7: ( '(' )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:10:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:11:7: ( ')' )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:11:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:12:7: ( '*' )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:12:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:13:7: ( '+' )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:13:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:14:7: ( '-' )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:14:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:15:7: ( '/' )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:15:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:16:7: ( ':' )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:16:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:17:7: ( '<' )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:17:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:18:7: ( '<=' )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:18:9: '<='
            {
            match("<="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:19:7: ( '==' )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:19:9: '=='
            {
            match("=="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:20:7: ( '>' )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:20:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:21:7: ( '>=' )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:21:9: '>='
            {
            match(">="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:22:7: ( 'else' )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:22:9: 'else'
            {
            match("else"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:23:7: ( 'form' )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:23:9: 'form'
            {
            match("form"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:24:7: ( 'if' )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:24:9: 'if'
            {
            match("if"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:25:7: ( '{' )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:25:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:26:7: ( '||' )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:26:9: '||'
            {
            match("||"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:27:7: ( '}' )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:27:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "INTEGER"
    public final void mINTEGER() throws RecognitionException {
        try {
            int _type = INTEGER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:154:8: ( 'int' )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:154:9: 'int'
            {
            match("int"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INTEGER"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:155:7: ( 'string' )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:155:8: 'string'
            {
            match("string"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "BOOLEAN"
    public final void mBOOLEAN() throws RecognitionException {
        try {
            int _type = BOOLEAN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:156:8: ( 'boolean' )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:156:9: 'boolean'
            {
            match("boolean"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BOOLEAN"

    // $ANTLR start "MONEY"
    public final void mMONEY() throws RecognitionException {
        try {
            int _type = MONEY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:157:6: ( 'money' )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:157:7: 'money'
            {
            match("money"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MONEY"

    // $ANTLR start "BoolLit"
    public final void mBoolLit() throws RecognitionException {
        try {
            int _type = BoolLit;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:160:9: ( ( 'true' | 'false' ) )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:160:11: ( 'true' | 'false' )
            {
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:160:11: ( 'true' | 'false' )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='t') ) {
                alt1=1;
            }
            else if ( (LA1_0=='f') ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;

            }
            switch (alt1) {
                case 1 :
                    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:160:12: 'true'
                    {
                    match("true"); 



                    }
                    break;
                case 2 :
                    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:160:21: 'false'
                    {
                    match("false"); 



                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BoolLit"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:164:5: ( ( ' ' | '\\t' | '\\n' | '\\r' ) )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:164:7: ( ' ' | '\\t' | '\\n' | '\\r' )
            {
            if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


             _channel=HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:168:6: ( '/*' ( . )* '*/' | '//' ( . )* ( '\\n' | '\\r' ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='/') ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1=='*') ) {
                    alt4=1;
                }
                else if ( (LA4_1=='/') ) {
                    alt4=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }
            switch (alt4) {
                case 1 :
                    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:168:8: '/*' ( . )* '*/'
                    {
                    match("/*"); 



                    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:168:13: ( . )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0=='*') ) {
                            int LA2_1 = input.LA(2);

                            if ( (LA2_1=='/') ) {
                                alt2=2;
                            }
                            else if ( ((LA2_1 >= '\u0000' && LA2_1 <= '.')||(LA2_1 >= '0' && LA2_1 <= '\uFFFF')) ) {
                                alt2=1;
                            }


                        }
                        else if ( ((LA2_0 >= '\u0000' && LA2_0 <= ')')||(LA2_0 >= '+' && LA2_0 <= '\uFFFF')) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:168:13: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);


                    match("*/"); 



                    _channel=HIDDEN;

                    }
                    break;
                case 2 :
                    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:169:8: '//' ( . )* ( '\\n' | '\\r' )
                    {
                    match("//"); 



                    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:169:13: ( . )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0=='\n'||LA3_0=='\r') ) {
                            alt3=2;
                        }
                        else if ( ((LA3_0 >= '\u0000' && LA3_0 <= '\t')||(LA3_0 >= '\u000B' && LA3_0 <= '\f')||(LA3_0 >= '\u000E' && LA3_0 <= '\uFFFF')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:169:13: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    if ( input.LA(1)=='\n'||input.LA(1)=='\r' ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    _channel=HIDDEN;

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "StringLit"
    public final void mStringLit() throws RecognitionException {
        try {
            int _type = StringLit;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:174:11: ( '\"' ( . )* '\"' )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:174:13: '\"' ( . )* '\"'
            {
            match('\"'); 

            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:174:17: ( . )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='\"') ) {
                    alt5=2;
                }
                else if ( ((LA5_0 >= '\u0000' && LA5_0 <= '!')||(LA5_0 >= '#' && LA5_0 <= '\uFFFF')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:174:17: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "StringLit"

    // $ANTLR start "Ident"
    public final void mIdent() throws RecognitionException {
        try {
            int _type = Ident;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:177:6: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:177:10: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:177:29: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0 >= '0' && LA6_0 <= '9')||(LA6_0 >= 'A' && LA6_0 <= 'Z')||LA6_0=='_'||(LA6_0 >= 'a' && LA6_0 <= 'z')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Ident"

    // $ANTLR start "Decimal"
    public final void mDecimal() throws RecognitionException {
        try {
            int _type = Decimal;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:179:9: ( Int '.' Int )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:179:11: Int '.' Int
            {
            mInt(); 


            match('.'); 

            mInt(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Decimal"

    // $ANTLR start "Int"
    public final void mInt() throws RecognitionException {
        try {
            int _type = Int;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:180:4: ( ( '0' .. '9' )+ )
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:180:6: ( '0' .. '9' )+
            {
            // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:180:6: ( '0' .. '9' )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0 >= '0' && LA7_0 <= '9')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Int"

    public void mTokens() throws RecognitionException {
        // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:8: ( T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | INTEGER | STRING | BOOLEAN | MONEY | BoolLit | WS | COMMENT | StringLit | Ident | Decimal | Int )
        int alt8=32;
        alt8 = dfa8.predict(input);
        switch (alt8) {
            case 1 :
                // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:10: T__15
                {
                mT__15(); 


                }
                break;
            case 2 :
                // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:16: T__16
                {
                mT__16(); 


                }
                break;
            case 3 :
                // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:22: T__17
                {
                mT__17(); 


                }
                break;
            case 4 :
                // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:28: T__18
                {
                mT__18(); 


                }
                break;
            case 5 :
                // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:34: T__19
                {
                mT__19(); 


                }
                break;
            case 6 :
                // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:40: T__20
                {
                mT__20(); 


                }
                break;
            case 7 :
                // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:46: T__21
                {
                mT__21(); 


                }
                break;
            case 8 :
                // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:52: T__22
                {
                mT__22(); 


                }
                break;
            case 9 :
                // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:58: T__23
                {
                mT__23(); 


                }
                break;
            case 10 :
                // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:64: T__24
                {
                mT__24(); 


                }
                break;
            case 11 :
                // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:70: T__25
                {
                mT__25(); 


                }
                break;
            case 12 :
                // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:76: T__26
                {
                mT__26(); 


                }
                break;
            case 13 :
                // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:82: T__27
                {
                mT__27(); 


                }
                break;
            case 14 :
                // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:88: T__28
                {
                mT__28(); 


                }
                break;
            case 15 :
                // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:94: T__29
                {
                mT__29(); 


                }
                break;
            case 16 :
                // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:100: T__30
                {
                mT__30(); 


                }
                break;
            case 17 :
                // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:106: T__31
                {
                mT__31(); 


                }
                break;
            case 18 :
                // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:112: T__32
                {
                mT__32(); 


                }
                break;
            case 19 :
                // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:118: T__33
                {
                mT__33(); 


                }
                break;
            case 20 :
                // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:124: T__34
                {
                mT__34(); 


                }
                break;
            case 21 :
                // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:130: T__35
                {
                mT__35(); 


                }
                break;
            case 22 :
                // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:136: INTEGER
                {
                mINTEGER(); 


                }
                break;
            case 23 :
                // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:144: STRING
                {
                mSTRING(); 


                }
                break;
            case 24 :
                // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:151: BOOLEAN
                {
                mBOOLEAN(); 


                }
                break;
            case 25 :
                // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:159: MONEY
                {
                mMONEY(); 


                }
                break;
            case 26 :
                // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:165: BoolLit
                {
                mBoolLit(); 


                }
                break;
            case 27 :
                // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:173: WS
                {
                mWS(); 


                }
                break;
            case 28 :
                // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:176: COMMENT
                {
                mCOMMENT(); 


                }
                break;
            case 29 :
                // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:184: StringLit
                {
                mStringLit(); 


                }
                break;
            case 30 :
                // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:194: Ident
                {
                mIdent(); 


                }
                break;
            case 31 :
                // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:200: Decimal
                {
                mDecimal(); 


                }
                break;
            case 32 :
                // /home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:208: Int
                {
                mInt(); 


                }
                break;

        }

    }


    protected DFA8 dfa8 = new DFA8(this);
    static final String DFA8_eotS =
        "\1\uffff\1\34\6\uffff\1\36\1\uffff\1\40\1\uffff\1\42\3\31\3\uffff"+
        "\4\31\3\uffff\1\54\10\uffff\3\31\1\61\5\31\2\uffff\3\31\1\uffff"+
        "\1\72\4\31\1\77\1\100\1\31\1\uffff\3\31\1\105\2\uffff\1\105\2\31"+
        "\1\110\1\uffff\1\111\1\31\2\uffff\1\113\1\uffff";
    static final String DFA8_eofS =
        "\114\uffff";
    static final String DFA8_minS =
        "\1\11\1\75\6\uffff\1\52\1\uffff\1\75\1\uffff\1\75\1\154\1\141\1"+
        "\146\3\uffff\1\164\2\157\1\162\3\uffff\1\56\10\uffff\1\163\1\162"+
        "\1\154\1\60\1\164\1\162\1\157\1\156\1\165\2\uffff\1\145\1\155\1"+
        "\163\1\uffff\1\60\1\151\1\154\2\145\2\60\1\145\1\uffff\1\156\1\145"+
        "\1\171\1\60\2\uffff\1\60\1\147\1\141\1\60\1\uffff\1\60\1\156\2\uffff"+
        "\1\60\1\uffff";
    static final String DFA8_maxS =
        "\1\175\1\75\6\uffff\1\57\1\uffff\1\75\1\uffff\1\75\1\154\1\157\1"+
        "\156\3\uffff\1\164\2\157\1\162\3\uffff\1\71\10\uffff\1\163\1\162"+
        "\1\154\1\172\1\164\1\162\1\157\1\156\1\165\2\uffff\1\145\1\155\1"+
        "\163\1\uffff\1\172\1\151\1\154\2\145\2\172\1\145\1\uffff\1\156\1"+
        "\145\1\171\1\172\2\uffff\1\172\1\147\1\141\1\172\1\uffff\1\172\1"+
        "\156\2\uffff\1\172\1\uffff";
    static final String DFA8_acceptS =
        "\2\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\uffff\1\12\1\uffff\1\15\4\uffff"+
        "\1\23\1\24\1\25\4\uffff\1\33\1\35\1\36\1\uffff\1\2\1\1\1\34\1\11"+
        "\1\14\1\13\1\17\1\16\11\uffff\1\40\1\37\3\uffff\1\22\10\uffff\1"+
        "\26\4\uffff\1\20\1\21\4\uffff\1\32\2\uffff\1\31\1\27\1\uffff\1\30";
    static final String DFA8_specialS =
        "\114\uffff}>";
    static final String[] DFA8_transitionS = {
            "\2\27\2\uffff\1\27\22\uffff\1\27\1\1\1\30\3\uffff\1\2\1\uffff"+
            "\1\3\1\4\1\5\1\6\1\uffff\1\7\1\uffff\1\10\12\32\1\11\1\uffff"+
            "\1\12\1\13\1\14\2\uffff\32\31\6\uffff\1\31\1\24\2\31\1\15\1"+
            "\16\2\31\1\17\3\31\1\25\5\31\1\23\1\26\6\31\1\20\1\21\1\22",
            "\1\33",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\35\4\uffff\1\35",
            "",
            "\1\37",
            "",
            "\1\41",
            "\1\43",
            "\1\45\15\uffff\1\44",
            "\1\46\7\uffff\1\47",
            "",
            "",
            "",
            "\1\50",
            "\1\51",
            "\1\52",
            "\1\53",
            "",
            "",
            "",
            "\1\55\1\uffff\12\32",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\56",
            "\1\57",
            "\1\60",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\1\62",
            "\1\63",
            "\1\64",
            "\1\65",
            "\1\66",
            "",
            "",
            "\1\67",
            "\1\70",
            "\1\71",
            "",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\1\73",
            "\1\74",
            "\1\75",
            "\1\76",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\1\101",
            "",
            "\1\102",
            "\1\103",
            "\1\104",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "",
            "",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\1\106",
            "\1\107",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\1\112",
            "",
            "",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            ""
    };

    static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
    static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
    static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
    static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
    static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
    static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
    static final short[][] DFA8_transition;

    static {
        int numStates = DFA8_transitionS.length;
        DFA8_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
        }
    }

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = DFA8_eot;
            this.eof = DFA8_eof;
            this.min = DFA8_min;
            this.max = DFA8_max;
            this.accept = DFA8_accept;
            this.special = DFA8_special;
            this.transition = DFA8_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | INTEGER | STRING | BOOLEAN | MONEY | BoolLit | WS | COMMENT | StringLit | Ident | Decimal | Int );";
        }
    }
 

}