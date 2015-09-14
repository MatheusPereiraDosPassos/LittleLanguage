import littleLanguage.Calculo;
import littleLanguage.Parser;

public class LittleLanguage {

	public static void main(String[] args) {
		// Lexer lex = new Lexer(System.in);
		String texto = "";
                System.out.println("Digite os Valores Ex:( 1+1= ) : ");
		try {
			
			Parser parser = new Parser(System.in);
			Calculo exp = parser.parse();
			System.out.println(exp.resolver());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
