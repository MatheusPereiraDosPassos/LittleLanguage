package littleLanguage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StreamTokenizer;

public class Lexer {

    public static final int INVALID = -1;
    public static final int NO_TOKENS = 0;
    public static final int NUMBER = 1;
    public static final int EXPRESSION = 3;
    public static final int PLUS = 4;
    public static final int EOL = 6;
    public static final int EOF = 7;
    public static final int EQUALS = 9;
    public static String tokenAtual = "";

    public int token = 0;

    private StreamTokenizer input;

    public Lexer(InputStream in) {
        BufferedReader r = new BufferedReader(new InputStreamReader(in));
        input = new StreamTokenizer(r);
        input.resetSyntax();
        input.eolIsSignificant(true);
        input.wordChars('0', '9');
        input.whitespaceChars('\u0000', '\u0020');
        input.ordinaryChar('+');
        input.ordinaryChar('=');

    }

    public int nextToken() throws Exception {
        int token = 0;
        try {
            switch (input.nextToken()) {
                case StreamTokenizer.TT_EOF:
                    token = EOF;
                    tokenAtual = "fim de arquivo";
                    break;
                case StreamTokenizer.TT_EOL:
                    tokenAtual = "fim de linha";
                    token = EOL;
                    break;
                case StreamTokenizer.TT_WORD:
                    Integer.parseInt(input.sval);
                    tokenAtual = input.sval;

                    token = NUMBER;

                    break;
                case '+':
                    tokenAtual = "+";
                    token = PLUS;
                    break;
                case '=':
                    tokenAtual = "=";
                    token = EQUALS;
                    break;

                case StreamTokenizer.TT_NUMBER:
                    System.err.println("entrou no TT_NUMBER");
                    break;
                default:
                    token = INVALID;
                    throw new Exception("ERRO LEXICO: Token Invalido!");
            }
        } catch (IOException e) {
            token = EOF;
        }
        return token;
    }

    public static String getTokenAtual() {
        return tokenAtual;
    }

}
