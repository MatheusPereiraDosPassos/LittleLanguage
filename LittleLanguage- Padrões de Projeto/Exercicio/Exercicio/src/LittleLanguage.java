import littleLanguage.Calculo;
import littleLanguage.Parser;

public class LittleLanguage {

	public static void main(String[] args) {
		
                System.out.println("Digite o calculo");
		try {
			
			Parser parser = new Parser(System.in);
			Calculo exp = parser.parse();
			System.out.println(exp.resolver());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
