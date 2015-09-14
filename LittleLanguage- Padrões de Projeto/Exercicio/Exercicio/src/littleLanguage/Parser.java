package littleLanguage;

import java.io.InputStream;

public class Parser {

    private Lexer lexer = null;
    private String tokenString = "";
    private int token;
    private String temp = "";
    private int aux;
 

    public Parser(InputStream in) {
        this.lexer = new Lexer(in);
    }

    public Calculo parse() throws Exception {
        nextToken();
        Calculo exp = expressao();
        return exp;
    }

    private Calculo expressao() throws Exception {
        Calculo exp = null;
        if (token == Lexer.NUMBER) {
            temp = this.tokenString;
            aux = this.token;
            nextToken();
            if (token == Lexer.PLUS) {
                exp = soma(Integer.parseInt(temp));
            }

        }
        return exp;
    }

    private Calculo soma(int n1) throws Exception {

        nextToken();

        int n2 = Integer.parseInt(tokenString);
        Calculo exp = new Soma(n1, n2);
        nextToken();
        //System.out.println("Primeiro Numero ->" + n1);
        //System.out.println("Segundo Numero ->" + n2);
        return exp;

    }

    private void nextToken() throws Exception {
        this.token = lexer.nextToken();
        this.tokenString = Lexer.tokenAtual;
        System.out.println("Token atual -> " + this.tokenName(this.token));
    }

    private String tokenName(int token2) {
        String token = "";
        switch (token2) {
            case Lexer.EOF:
                token = "FIM DE ARQUIVO";
                break;
            case Lexer.EOL:
                token = "FIM DE LINHA";
                break;
            case Lexer.EXPRESSION:
                token = this.tokenString;
                break;
            case Lexer.NUMBER:
                token = this.tokenString;
                break;
            case Lexer.PLUS:
                token = "MAIS";
                break;
            case Lexer.EQUALS:
                token = "IGUAL";
                break;
            default:
                token = "Erro ";
                break;
        }
        return token;
    }

}
