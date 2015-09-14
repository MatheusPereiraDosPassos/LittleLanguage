package Test;
import org.junit.Test;
import static org.junit.Assert.*;

public class JunitTest {
	public JunitTest(){
		
	}
@Test //@Teste: Esta anota��o indica que o c�digo a seguir � um teste.

public void SomaTest(){ //M�todo criado para teste, foi dado o nome test (indicando que � um teste) e Soma (indicando qual o m�todo est� sendo testado)
	 int n1=1;
	 int n2=2;
	int ExpResult = (n1+n2);
	int Result = Calculo.Soma(n1,n2);//Faz uma chamada ao m�todo soma do objeto calculo, passando como par�metro as vari�veis a e b. 
	assertEquals(ExpResult, Result);//O assertEquals compara duas vari�veis, neste caso o expResult(Resultado esperado) com a vari�vel result que traz o resultado obtido pelo m�todo soma do objeto calculo.
}

@Test

public void SubtraiTest(){
	 int n1=1;
	 int n2=2;
	int ExpResult = (n1-n2);
	int Result = Calculo.Subtracao(n1,n2);
	assertEquals(ExpResult, Result);
}

@Test

public void DividiTest(){
	 int n1=1;
	 int n2=2;
	int ExpResult = (n1/n2);
	int Result = Calculo.Divisao(n1,n2);
	assertEquals(ExpResult, Result);
}

@Test

public void MultiplicaTest(){
	 int n1=1;
	 int n2=2;
	int ExpResult = (n1*n2);
	int Result = Calculo.Multiplicacao(n1,n2);
	assertEquals(ExpResult, Result);
}

}